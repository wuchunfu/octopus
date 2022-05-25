package org.metahut.octopus.server.service;

import org.metahut.octopus.api.dto.AlerterSourceConditionsRequestDTO;
import org.metahut.octopus.api.dto.AlerterSourceCreateOrUpdateRequestDTO;
import org.metahut.octopus.api.dto.AlerterSourceResponseDTO;
import org.metahut.octopus.dao.entity.AlerterSource;

import org.springframework.data.domain.Page;

import java.util.Collection;
import java.util.List;

public interface AlerterSourceService {

    Collection<String> queryAllPluginTypes();

    Page<AlerterSource> queryListPage(AlerterSourceConditionsRequestDTO requestDTO);

    List<AlerterSource> queryList(AlerterSourceConditionsRequestDTO requestDTO);

    AlerterSourceResponseDTO createOrUpdate(AlerterSourceCreateOrUpdateRequestDTO requestDTO);

    void deleteById(Integer id);
}
