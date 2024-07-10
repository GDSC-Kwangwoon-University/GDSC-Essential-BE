package gdsc.essential.service;

import gdsc.essential.domain.SeminarDate;
import gdsc.essential.domain.Submit;
import gdsc.essential.dto.request.SubmitRequest;
import gdsc.essential.dto.response.SubmitResponse;
import gdsc.essential.repository.SubmitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubmitService {

    @Autowired
    private SubmitRepository submitRepository;

    @Autowired
    private SeminarDateService seminarDateService;

    public ResponseEntity<String> submit(SubmitRequest requestDTO) {
        SeminarDate seminarDate = seminarDateService.getSeminarDateByDate(requestDTO.getDate());
        if (seminarDate == null) {
            return ResponseEntity.badRequest().body("Invalid seminar date");
        }

        Submit submit = new Submit();
        submit.setTitle(requestDTO.getTitle());
        submit.setContent(requestDTO.getContent());
        submit.setSeminarDate(seminarDate);
        submitRepository.save(submit);
        return ResponseEntity.ok("Submit successful");
    }

    public ResponseEntity<List<SubmitResponse>> getSubmitInfo() {
        List<Submit> submitList = submitRepository.findAll();
        List<SubmitResponse> submitResponses = submitList.stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList());
        return ResponseEntity.ok(submitResponses);
    }

    private SubmitResponse convertToResponse(Submit submit) {
        SubmitResponse response = new SubmitResponse();
        response.setId(submit.getId());
        response.setTitle(submit.getTitle());
        response.setContent(submit.getContent());
        return response;
    }
}
