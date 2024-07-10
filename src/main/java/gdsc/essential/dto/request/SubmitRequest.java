package gdsc.essential.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SubmitRequest {
    private String date;
    private String title;
    private String content;
}
