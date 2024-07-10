package gdsc.essential.controller;

import gdsc.essential.dto.request.SubmitRequest;
import gdsc.essential.dto.response.SeminarDateResponse;
import gdsc.essential.dto.response.SubmitResponse;
import gdsc.essential.service.EssentialService;
import gdsc.essential.service.SubmitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/submit")
public class EssentialController implements EssentialOperation {

    @Autowired
    private SubmitService submitService;

    @Override
    public ResponseEntity<String> submit( SubmitRequest submitRequest) {
        return submitService.submit(submitRequest);
    }



    @Override
    public ResponseEntity<List<SubmitResponse>> getSubmitInfo() {
        return submitService.getSubmitInfo();
    }
}