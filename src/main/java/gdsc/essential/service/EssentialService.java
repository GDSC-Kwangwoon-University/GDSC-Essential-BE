package gdsc.essential.service;

import gdsc.essential.domain.ApiResponse;
import gdsc.essential.domain.Authority;
import org.springframework.stereotype.Service;

@Service
public class EssentialService {
    public ApiResponse madeMemberResponse(String username) {

        return new ApiResponse(username, 21, Authority.MEMBER);
    }
}