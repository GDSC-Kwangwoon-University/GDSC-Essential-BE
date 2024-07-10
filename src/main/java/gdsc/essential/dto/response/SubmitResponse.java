package gdsc.essential.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SubmitResponse {
    private Long id;
    private String title;
    private String content;
}
