package gdsc.essential.controller;

import gdsc.essential.dto.request.SeminarDateRequest;
import gdsc.essential.dto.response.SeminarDateResponse;
import gdsc.essential.service.EssentialService;
import gdsc.essential.service.SeminarDateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/submit/date")
public class SeminarDateController implements SeminarDateOperation {

    @Autowired
    private SeminarDateService seminarDateService;

    @Override
    public ResponseEntity<String> addSeminarDate( SeminarDateRequest seminarDateRequest) {//세미나 날짜 추가
        return seminarDateService.addSeminarDate(seminarDateRequest);
    }

    @Override
    public ResponseEntity<List<SeminarDateResponse>> getAllSeminarDates() {
//모든 세미나 날짜 가져오기
        return seminarDateService.getAllSeminarDates();
    }
}
