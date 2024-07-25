package gdsc.essential.date.controller;

import gdsc.essential.date.model.SeminarDateRequest;
import gdsc.essential.date.model.SeminarDateResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/v1/date")
public interface SeminarDateController {
    //세미나 날짜 추가
    @PostMapping("/addDates")
    ResponseEntity<String> postSeminarDates(@RequestBody SeminarDateRequest seminarDateRequest);

    //세미나 날짜 조회
    @GetMapping("/seminarDates")
    ResponseEntity<SeminarDateResponse> getSeminarDates();
}
