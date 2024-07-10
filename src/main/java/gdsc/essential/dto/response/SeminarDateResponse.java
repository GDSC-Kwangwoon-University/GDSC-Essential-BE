package gdsc.essential.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class SeminarDateResponse {
    private Long id;
    private String date;
    private List<SubmitResponse> submitList;
}
