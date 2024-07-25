package gdsc.essential.seminar.controller;

import gdsc.essential.seminar.model.SeminarRequest;
import gdsc.essential.seminar.service.SeminarService;
import gdsc.essential.seminar.model.Seminar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

import java.util.Optional;

@RestController
public class SeminarControllerImpl implements SeminarController {
    private final SeminarService seminarService;

    @Autowired
    public SeminarControllerImpl(SeminarService seminarService) {
        this.seminarService = seminarService;
    }

    @Override
    public ResponseEntity<String> postSeminar(@RequestBody SeminarRequest seminarRequest) {
        try {
            LocalDate date = LocalDate.parse(seminarRequest.getSeminarDate());
            Seminar seminar = new Seminar(date, seminarRequest.getSubject(), seminarRequest.getContent());
            seminarService.postSeminar(seminar);
            return ResponseEntity.ok("세미나 발표 신청이 완료되었습니다.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @Override
    public ResponseEntity<Seminar> getLastSeminar() {
        Seminar lastSeminar = seminarService.getLastSeminar();
        return Optional.ofNullable(lastSeminar)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }
}
