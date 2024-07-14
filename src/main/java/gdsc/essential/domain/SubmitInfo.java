package gdsc.essential.domain;

import gdsc.essential.dto.request.SubmitInfoRequestDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;


@Getter
public class SubmitInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long speaker_id;
    private LocalDate seminarDate;
    private String topic;
    private String content;

    public SubmitInfo(SubmitInfoRequestDTO submitInfoRequestDTO) {
        this.speaker_id = submitInfoRequestDTO.getSpeakerId();
        this.seminarDate = submitInfoRequestDTO.getSeminarDate();
        this.topic = submitInfoRequestDTO.getTopic();
        this.content = submitInfoRequestDTO.getContent();
    }
    public SubmitInfo() {

    }
}
