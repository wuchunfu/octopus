package org.metahut.octopus.server.service;

import org.metahut.octopus.api.dto.SelectItemRequestDTO;
import org.metahut.octopus.api.dto.SelectItemResponseDTO;

import java.util.List;
import java.util.Map;

public interface SelectItemService {

    Map<String, List<SelectItemResponseDTO>> queryList(SelectItemRequestDTO selectItemRequestDTO);
}
