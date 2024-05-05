package org.forafox.web.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.forafox.domain.enums.AnnotationType;

@Data
@Schema(description = "DTO for method data statistics")
public class MethodDataStatDTO {
    @Schema(description = "Name of the method", example = "")
    private String methodName;
    @Schema(description = "Minimum method execution time (ms)", example = "1")
    private Long minExecuteTime;
    @Schema(description = "Maximum method execution time (ms)", example = "42")
    private Long maxExecuteTime;
    @Schema(description = "Average method execution time (ms)", example = "2")
    private Long avgExecuteTime;
    @Schema(description = "Annotation type of the method (ms)", example = "49")
    private AnnotationType annotationType;
}
