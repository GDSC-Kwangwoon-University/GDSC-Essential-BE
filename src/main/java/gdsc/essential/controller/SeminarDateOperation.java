package gdsc.essential.controller;

import gdsc.essential.dto.request.SeminarDateRequest;
import gdsc.essential.dto.response.SeminarDateResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/default")
public interface SeminarDateOperation {
    @PostMapping("/")
    public ResponseEntity<String> addSeminarDate(@RequestBody SeminarDateRequest seminarDateRequest);
    @GetMapping("/all")
    public ResponseEntity<List<SeminarDateResponse>> getAllSeminarDates();
}
