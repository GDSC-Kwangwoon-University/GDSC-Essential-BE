package gdsc.essential.controller;

import gdsc.essential.dto.request.DateRequestDTO;
import gdsc.essential.dto.request.SubmitInfoRequestDTO;
import gdsc.essential.dto.response.RecentSubmitInfoResponseDTO;
import gdsc.essential.dto.response.SeminarDatesResponseDTO;
import gdsc.essential.service.EssentialService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class EssentialController {
    private final EssentialService essentialService;
    @GetMapping("/submit/info")
    public ResponseEntity<RecentSubmitInfoResponseDTO> getRecentSubmitInfos() {
        RecentSubmitInfoResponseDTO recentSubmitInfoResponseDTO = essentialService.getRecentSubmitInfos();
        return ResponseEntity.ok(recentSubmitInfoResponseDTO);
    }
    @PostMapping("/submit")
    public ResponseEntity<String> saveSubmitInfo(@RequestBody SubmitInfoRequestDTO requestDTO) {
        essentialService.saveSubmitInfo(requestDTO);
        return ResponseEntity.ok("성공적으로 저장되었습니다");
    }
    @PostMapping("/seminarDate")
    public ResponseEntity<String> addSeminarDate(@RequestBody DateRequestDTO dateRequestDTO){
        essentialService.addSeminarDate(dateRequestDTO);
        return ResponseEntity.ok("성공적으로 추가되었습니다.");
    }
    @GetMapping("/seminarDate")
    public ResponseEntity<SeminarDatesResponseDTO> getSeminarDates() {
        SeminarDatesResponseDTO seminarDatesResponseDTO = essentialService.getSeminarDates();
        return ResponseEntity.ok(seminarDatesResponseDTO);
    }
}