package org.forafox.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.forafox.service.MethodDataService;
import org.forafox.web.dto.MethodDataDTO;
import org.forafox.web.mapper.MethodDataMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/methodData")
@Tag(name = "Methods Data API", description = "API for methods data")
public class MethodDataController {
    private final MethodDataService methodDataService;
    private final MethodDataMapper methodDataMapper;

    @GetMapping("")
    @Operation(summary = "Get all methods data", description = "Get a list of all  methods data.", operationId = "getAllMethodsData")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Successful operation"),
    })
    public List<MethodDataDTO> getAllMethodsData() {
        return methodDataMapper.toDtoList(methodDataService.getAll());
    }

    @GetMapping("/methodName/{methodName}")
    @Operation(summary = "Get Method data by method name", description = "Get method data by its name.", operationId = "getAllMethodsDataByMethodName")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Successful operation"),
    })
    public List<MethodDataDTO> getAllMethodsDataByMethodName(
            @Parameter(description = "Name of the method to be obtained", required = true) @PathVariable String methodName
    ) {
        return methodDataMapper.toDtoList(methodDataService.getMethodByMethodName(methodName));
    }
}
