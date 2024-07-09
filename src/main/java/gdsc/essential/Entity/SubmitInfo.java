package gdsc.essential.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;

@Data
@Entity
@Getter
@Table
public class SubmitInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long speaker_id;
    private String date;
    private String topic;
    private String content;
}
