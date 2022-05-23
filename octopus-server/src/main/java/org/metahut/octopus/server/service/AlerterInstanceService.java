package org.metahut.octopus.server.service;

import org.metahut.octopus.api.dto.AlerterInstanceConditionsRequestDTO;
import org.metahut.octopus.api.dto.AlerterInstanceCreateOrUpdateRequestDTO;
import org.metahut.octopus.api.dto.AlerterInstanceResponseDTO;
import org.metahut.octopus.dao.entity.AlerterInstance;

import org.springframework.data.domain.Page;

import java.util.Collection;
import java.util.List;

public interface AlerterInstanceService {

    Collection<String> queryAllPluginTypes();

    Page<AlerterInstance> queryListPage(AlerterInstanceConditionsRequestDTO requestDTO);

    List<AlerterInstance> queryList(AlerterInstanceConditionsRequestDTO requestDTO);

    AlerterInstanceResponseDTO createOrUpdate(AlerterInstanceCreateOrUpdateRequestDTO requestDTO);

    void deleteById(Integer id);
}
