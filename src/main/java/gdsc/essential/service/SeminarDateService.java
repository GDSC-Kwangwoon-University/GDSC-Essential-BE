package gdsc.essential.service;

import gdsc.essential.domain.SeminarDate;
import gdsc.essential.dto.request.SeminarDateRequest;
import gdsc.essential.dto.response.SeminarDateResponse;
import gdsc.essential.dto.response.SubmitResponse;
import gdsc.essential.repository.SeminarDateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SeminarDateService {

    @Autowired
    private SeminarDateRepository seminarDateRepository;

    public ResponseEntity<String> addSeminarDate(SeminarDateRequest requestDTO) {
        SeminarDate seminarDate = new SeminarDate();
        seminarDate.setDate(requestDTO.getDate());
        seminarDateRepository.save(seminarDate);
        return ResponseEntity.ok("Seminar Date added successfully");
    }

    public ResponseEntity<List<SeminarDateResponse>> getAllSeminarDates() {
        List<SeminarDate> seminarDates = seminarDateRepository.findAll();
        List<SeminarDateResponse> seminarDateResponses = seminarDates.stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(seminarDateResponses);
    }

    public SeminarDate getSeminarDateByDate(String date) {
        return seminarDateRepository.findByDate(date).orElse(null);
    }

    private SeminarDateResponse convertToResponse(SeminarDate seminarDate) {
        SeminarDateResponse response = new SeminarDateResponse();
        response.setId(seminarDate.getId());
        response.setDate(seminarDate.getDate());
        response.setSubmitList(seminarDate.getSubmitList().stream()
                .map(submit -> {
                    SubmitResponse submitResponse = new SubmitResponse();
                    submitResponse.setId(submit.getId());
                    submitResponse.setTitle(submit.getTitle());
                    submitResponse.setContent(submit.getContent());
                    return submitResponse;
                })
                .collect(Collectors.toList()));
        return response;
    }
}
