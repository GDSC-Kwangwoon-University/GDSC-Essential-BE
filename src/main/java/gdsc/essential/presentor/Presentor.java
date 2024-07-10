package gdsc.essential.presentor;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Presentor {

    private String content;
    private String subject;


    public static Presentor of(String content, String subject){
        return Presentor.builder()
                .content(content)
                .subject(subject)
                .build();
    }

}
