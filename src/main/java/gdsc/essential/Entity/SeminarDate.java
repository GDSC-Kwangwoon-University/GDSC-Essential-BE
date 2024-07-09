package gdsc.essential.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Entity
@Table
@Data
@Getter
public class SeminarDate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long month_id;

    private String seminarDate;
}
