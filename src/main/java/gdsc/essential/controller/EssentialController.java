package gdsc.essential.controller;

import gdsc.essential.dto.request.SubmitInfoRequestDTO;
import gdsc.essential.dto.response.RecentSubmitInfoResponseDTO;
import gdsc.essential.service.EssentialService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/v1/submit")
public class EssentialController {
    private final EssentialService essentialService;
    @GetMapping("/info")
    public ResponseEntity<RecentSubmitInfoResponseDTO> getRecentSubmitInfos() {
        RecentSubmitInfoResponseDTO recentSubmitInfoResponseDTO = essentialService.getRecentSubmitInfos();
        return ResponseEntity.ok(recentSubmitInfoResponseDTO);
    }
    @PostMapping("/")
    public ResponseEntity<String> saveSubmitInfo(@RequestBody SubmitInfoRequestDTO requestDTO) {
        essentialService.saveSubmitInfo(requestDTO);
        return ResponseEntity.ok("성공적으로 저장되었습니다");
    }
}