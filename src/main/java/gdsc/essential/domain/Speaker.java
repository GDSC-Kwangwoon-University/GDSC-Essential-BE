package gdsc.essential.domain;

import gdsc.essential.dto.request.SubmitInfoRequestDTO;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Speaker {
    private User user;
    private String topic;
    private String content;

    @Builder
    public Speaker(User user, String topic, String content) {
        this.user = user;
        this.topic = topic;
        this.content = content;
    }

    public static Speaker of(User user, SubmitInfoRequestDTO submitInfoRequestDTO){
        return Speaker.builder()
                .user(user)
                .topic(submitInfoRequestDTO.getTopic())
                .content(submitInfoRequestDTO.getContent())
                .build();
    }
}
