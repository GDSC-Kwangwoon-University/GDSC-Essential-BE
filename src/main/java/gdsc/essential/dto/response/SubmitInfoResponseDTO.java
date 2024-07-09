package gdsc.essential.dto.response;

import lombok.Data;
import lombok.Setter;

import java.time.LocalDate;

@Data
@Setter
public class SubmitInfoResponseDTO {
    private Long id;
    private Long speaker_id;
    private String date;
    private String topic;
    private String content;
}
