package gdsc.essential.service;

import gdsc.essential.domain.SubmitInfo;
import gdsc.essential.dto.request.SubmitInfoRequestDTO;
import gdsc.essential.dto.response.RecentSubmitInfoResponseDTO;
import gdsc.essential.repository.EssentialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EssentialService {
    private RecentSubmitInfoResponseDTO recentSubmitInfoResponseDTO;
    public void saveSubmitInfo(SubmitInfoRequestDTO submitInfoRequestDTO) {
        SubmitInfo submitInfo = new SubmitInfo(submitInfoRequestDTO);
        recentSubmitInfoResponseDTO = RecentSubmitInfoResponseDTO.of(submitInfoRequestDTO);
    }
    public RecentSubmitInfoResponseDTO getRecentSubmitInfos() {
        return recentSubmitInfoResponseDTO;
    }


}
