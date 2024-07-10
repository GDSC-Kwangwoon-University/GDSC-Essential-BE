package gdsc.essential.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class SeminarDate {
    /*
    id : Long
    date : String
    submitList : List<Submit>
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "date")
    private String date;

    @OneToMany(mappedBy = "seminarDate", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    //하나의 날짜에 여러 submit
    private List<Submit> submitList;
}
