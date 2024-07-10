package gdsc.essential.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class SeminarDateRequest {
    private String date;
}
