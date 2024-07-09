package gdsc.essential.dto.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class SubmitInfoRequestDTO {
    private Long speaker_id;
    private String date;
    private String topic;
    private String content;
}
