package gdsc.essential.controller;

import gdsc.essential.Entity.SeminarDate;
import gdsc.essential.dto.response.SeminarDatesResponseDTO;
import gdsc.essential.service.DateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/v1/seminarDate")
public class DateController {
    private final DateService dateService;
    @Autowired
    public DateController(DateService dateService) {
        this.dateService = dateService;
    }

    @GetMapping("/{month}")
    public ResponseEntity<SeminarDatesResponseDTO> getSeminarDate(@PathVariable Long month){
        String seminarDate = dateService.getSeminarDate(month);
        SeminarDatesResponseDTO seminarDatesResponseDTO = new SeminarDatesResponseDTO();
        seminarDatesResponseDTO.setSeminarDate(seminarDate);

        if (seminarDate.equals("추후 날짜 확정시")) return new ResponseEntity<>(seminarDatesResponseDTO, HttpStatus.BAD_REQUEST);
        else  return new ResponseEntity<>(seminarDatesResponseDTO, HttpStatus.OK);
    }
}
