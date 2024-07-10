package gdsc.essential.controller;

import gdsc.essential.domain.ApiResponse;
import gdsc.essential.domain.SubmitRequest;
import gdsc.essential.service.EssentialService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 * Controller: Presentation Layer
 * get HTTP request, call necessary business logics, return results.
 */
@RestController
@RequestMapping("/api/v1")
public class EssentialController {
    private final EssentialService essentialService;

    public EssentialController(EssentialService essentialService) {
        this.essentialService = essentialService;
    }

    // 1단계: api/v1/date API - 날짜 리스트를 트로 보내기
    @GetMapping("/date")
    public List<String> getDates() {
        return essentialService.getDates();
    }

    // 2단계: api/v1/submit API - 입력 받은 날짜, 주제, 본문을 백엔드에 저장
    @PostMapping("/submit")
    public void submitData(@RequestBody SubmitRequest request) {
        essentialService.saveResponse(request);
    }

    // 3단계: api/v1/submit/info API - 현재까지 입력 받은 사항들 보여주기
    @GetMapping("/submit/info")
    public List<ApiResponse> getAllResponses() {
        return essentialService.getAllResponses();
    }
}
