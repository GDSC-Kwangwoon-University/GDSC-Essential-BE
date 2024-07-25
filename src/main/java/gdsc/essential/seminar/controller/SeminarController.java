package gdsc.essential.seminar.controller;

import gdsc.essential.seminar.model.SeminarRequest;
import gdsc.essential.seminar.model.Seminar;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/api/v1/seminar")
public interface SeminarController {
    //세미나 신청
    @PostMapping("/submit")
    ResponseEntity<String> postSeminar(@RequestBody SeminarRequest seminarRequest);
    //최근 세미나 신청 조회
    @GetMapping("/submit/info")
    ResponseEntity<Seminar> getLastSeminar();
}
