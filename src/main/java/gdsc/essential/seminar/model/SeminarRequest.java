package gdsc.essential.seminar.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SeminarRequest {
    private String seminarDate;
    private String subject;
    private String content;
}
