package org.metahut.octopus.server.service.impl;

import org.metahut.octopus.api.dto.UserResponseDTO;
import org.metahut.octopus.dao.entity.User;
import org.metahut.octopus.dao.repository.UserRepository;
import org.metahut.octopus.server.service.UserService;

import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Service;

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
    public List<UserResponseDTO> findList() {
        return (List<UserResponseDTO>) conversionService.convert(userRepository.findAll(),
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(User.class)),
                TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(UserResponseDTO.class)));
    }
}
