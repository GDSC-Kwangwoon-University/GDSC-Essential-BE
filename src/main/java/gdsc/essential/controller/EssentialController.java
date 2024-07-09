package gdsc.essential.controller;

import gdsc.essential.dto.request.SubmitInfoRequestDTO;
import gdsc.essential.dto.response.SubmitInfoResponseDTO;
import gdsc.essential.service.EssentialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/v1/submit")
public class EssentialController {
    private final EssentialService essentialService;
    @Autowired
    public EssentialController(EssentialService essentialService) {
        this.essentialService = essentialService;
    }

    @GetMapping("/info")
    public ResponseEntity<List<SubmitInfoResponseDTO>> getAllSubmitInfos() {
        List<SubmitInfoResponseDTO> submitInfoResponseDTOList = essentialService.getAllSubmitInfos();

        return new ResponseEntity<>(submitInfoResponseDTOList, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<String> saveSubmitInfo(@RequestBody SubmitInfoRequestDTO requestDTO) {
        essentialService.saveSubmitInfo(requestDTO);

        return ResponseEntity.ok("성공적으로 저장되었습니다");
    }
}