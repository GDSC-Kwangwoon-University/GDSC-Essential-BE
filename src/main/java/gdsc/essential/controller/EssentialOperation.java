package gdsc.essential.controller;

import gdsc.essential.dto.request.SubmitRequest;
import gdsc.essential.dto.response.SeminarDateResponse;
import gdsc.essential.dto.response.SubmitResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/default")
public interface EssentialOperation {
    @PostMapping("/")//연사자 신청
    public ResponseEntity<String> submit(@RequestBody SubmitRequest requestDTO);

    @GetMapping("/info")//연사자 목록 조회
    public ResponseEntity<List<SubmitResponse>> getSubmitInfo();
}
