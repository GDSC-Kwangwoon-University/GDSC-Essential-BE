package gdsc.essential.date.controller;

import gdsc.essential.date.model.SeminarDateRequest;
import gdsc.essential.date.model.SeminarDateResponse;
import gdsc.essential.date.service.SeminarDateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SeminarDateControllerImpl implements SeminarDateController {
    private final SeminarDateService seminarDateService;

    @Autowired
    public SeminarDateControllerImpl(SeminarDateService seminarDateService) {
        this.seminarDateService = seminarDateService;
    }

    @Override
    public ResponseEntity<String> postSeminarDates(@RequestBody SeminarDateRequest seminarDateRequest) {
        seminarDateService.postSeminarDates(seminarDateRequest.getDates());
        return ResponseEntity.ok("세미나 날짜들이 추가되었습니다.");
    }

    @Override
    public ResponseEntity<SeminarDateResponse> getSeminarDates() {
        List<String> seminarDates = seminarDateService.getSeminarDates();
        if (seminarDates.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(new SeminarDateResponse(seminarDates));
    }
}
