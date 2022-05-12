package org.metahut.octopus.server.controller;

import org.metahut.octopus.api.controller.SelectItemController;
import org.metahut.octopus.api.dto.ResultEntity;
import org.metahut.octopus.api.dto.SelectItemRequestDTO;
import org.metahut.octopus.api.dto.SelectItemResponseDTO;
import org.metahut.octopus.server.service.SelectItemService;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class SelectItemControllerImpl implements SelectItemController {

    private final SelectItemService selectItemService;

    public SelectItemControllerImpl(SelectItemService selectItemService) {
        this.selectItemService = selectItemService;
    }

    @Override
    public ResultEntity<Map<String, List<SelectItemResponseDTO>>> queryList(SelectItemRequestDTO selectItemRequestDTO) {
        return ResultEntity.success(selectItemService.queryList(selectItemRequestDTO));
    }
}
