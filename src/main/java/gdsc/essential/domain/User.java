package gdsc.essential.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class User {
    private Long user_id;
    private UserPart part;
    private UserRole role;
    @Builder
    public User(Long user_id, UserPart part, UserRole role) {
        this.user_id = user_id;
        this.part = part;
        this.role = role;
    }
}
