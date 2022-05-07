package org.metahut.octopus.server.service;

import org.metahut.octopus.api.dto.AlerterInstanceConditionsRequestDTO;
import org.metahut.octopus.api.dto.AlerterInstanceCreateRequestDTO;
import org.metahut.octopus.api.dto.AlerterInstanceResponseDTO;
import org.metahut.octopus.api.dto.PageRequestDTO;
import org.metahut.octopus.dao.entity.AlerterInstance;

import org.springframework.data.domain.Page;

import java.util.Collection;
import java.util.List;

public interface AlerterInstanceService {

    Collection<String> queryAllPluginTypes();

    Page<AlerterInstance> queryListPage(PageRequestDTO<AlerterInstanceConditionsRequestDTO> pageRequestDTO);

    List<AlerterInstance> queryList(AlerterInstanceConditionsRequestDTO alerterInstanceConditionsRequestDTO);

    AlerterInstanceResponseDTO create(AlerterInstanceCreateRequestDTO alerterInstanceCreateRequestDTO);

    void deleteById(Integer id);
}
