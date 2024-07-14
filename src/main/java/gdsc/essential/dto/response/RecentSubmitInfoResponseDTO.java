package gdsc.essential.dto.response;

import gdsc.essential.dto.request.SubmitInfoRequestDTO;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
public class RecentSubmitInfoResponseDTO {
    private Long speakerId;
    private LocalDate seminarDate;
    private String topic;
    private String content;
    @Builder
    public RecentSubmitInfoResponseDTO(Long speakerId, LocalDate seminarDate, String topic, String content) {
        this.speakerId = speakerId;
        this.seminarDate = seminarDate;
        this.topic = topic;
        this.content = content;
    }

    public static RecentSubmitInfoResponseDTO of(SubmitInfoRequestDTO submitInfoRequestDTO) {
        return RecentSubmitInfoResponseDTO.builder()
                .speakerId(submitInfoRequestDTO.getSpeakerId())
                .seminarDate(submitInfoRequestDTO.getSeminarDate())
                .topic(submitInfoRequestDTO.getTopic())
                .content(submitInfoRequestDTO.getContent())
                .build();
    }
}
