package org.metahut.octopus.server.service.impl;

import org.metahut.octopus.api.dto.UserConditionsRequestDTO;
import org.metahut.octopus.api.dto.UserResponseDTO;
import org.metahut.octopus.dao.entity.User;
import org.metahut.octopus.dao.entity.User_;
import org.metahut.octopus.dao.repository.UserRepository;
import org.metahut.octopus.server.service.UserService;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ConversionService conversionService;

    public UserServiceImpl(UserRepository userRepository, ConversionService conversionService) {
        this.userRepository = userRepository;
        this.conversionService = conversionService;
    }

    @Override
    public List<UserResponseDTO> findList(UserConditionsRequestDTO requestDTO) {
        return (List<UserResponseDTO>) conversionService.convert(userRepository.findAll(withConditions(requestDTO)),
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(User.class)),
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(UserResponseDTO.class)));
    }

    @Override
    public List<UserResponseDTO> findListByContactInfo(List<String> contactInfos) {
        Specification specification = (root, query, builder) -> builder.or(
                builder.in(root.get(User_.email).as(String.class).in(contactInfos)),
                builder.in(root.get(User_.phoneNumber).as(String.class).in(contactInfos)));
        return (List<UserResponseDTO>) conversionService.convert(userRepository.findAll(specification),
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(User.class)),
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(UserResponseDTO.class)));
    }

    private Specification<User> withConditions(UserConditionsRequestDTO requestDTO) {
        return (root, query, builder) -> {
            List<Predicate> conditions = new ArrayList<>();
            if (StringUtils.isNotBlank(requestDTO.getEnName())) {
                conditions.add(builder.like(root.get(User_.name), "%" + requestDTO.getEnName() + "%"));
            }

            if (StringUtils.isNotBlank(requestDTO.getCnName())) {
                conditions.add(builder.like(root.get(User_.cnName), "%" + requestDTO.getCnName() + "%"));
            }

            return builder.and(conditions.toArray(new Predicate[conditions.size()]));
        };
    }
}
