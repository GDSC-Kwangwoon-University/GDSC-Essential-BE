package gdsc.essential.seminar.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import java.time.LocalDate;
import lombok.Getter;

@Getter
public class SubmitRequestDto {
    @JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate seminarDate;
    private String subject;
    private String content;
}
