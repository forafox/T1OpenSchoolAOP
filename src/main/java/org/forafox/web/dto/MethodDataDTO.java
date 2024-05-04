package org.forafox.web.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

@Data
@Schema(description = "DTO for Methods data entity")
public class MethodDataDTO {
    @Schema(description = "Execution date of the method", example = "")
    private Date executeDate;
    @Schema(description = "Name of the method", example = "")
    private String methodName;
    @Schema(description = "Execution time of the method", example = "")
    private Long executeTime;
}
