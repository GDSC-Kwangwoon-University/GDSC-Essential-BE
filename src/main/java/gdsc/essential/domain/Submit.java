package gdsc.essential.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
public class Submit { //신청
    /*
    id : Long
    seminar_date_id : Long
    title : String
    content : String
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "seminar_date_id")//여러 세미나신청에 하나의 날짜
    private SeminarDate seminarDate;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;
}