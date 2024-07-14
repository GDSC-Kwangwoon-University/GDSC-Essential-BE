package gdsc.essential.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;

@Data
public class SubmitInfoRequestDTO {
    private Long speakerId;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate seminarDate;

    private String topic;
    private String content;
}
