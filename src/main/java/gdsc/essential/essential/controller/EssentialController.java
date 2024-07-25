package gdsc.essential.essential.controller;

import gdsc.essential.seminar.BaseSeminarManagerImpl;
import gdsc.essential.seminar.dto.DateRequestDto;
import gdsc.essential.seminar.dto.SubmitRequestDto;
import gdsc.essential.seminar.RecentSubmitSeminarInfo;
import gdsc.essential.seminar.dto.SeminarDateResponseDto;
import gdsc.essential.essential.service.EssentialServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class EssentialController {

    private final EssentialService essentialService;

    //세미나, 발표자

    @PostMapping("/submit")
    public ResponseEntity<String> saveSumitData(@RequestBody SubmitRequestDto submitRequestDto) {
        try {
            essentialService.addPresentor(submitRequestDto);
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok("success");
    }


    @GetMapping("/seminarDate")
    public ResponseEntity<SeminarDateResponseDto> getSeminarDate() {
        try{
            return ResponseEntity.ok(SeminarDateResponseDto.of(essentialService.exractSeminarDates()));
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(SeminarDateResponseDto.of(null));
        }
    }

    @PostMapping("/addSeminarDate")
    public ResponseEntity<String> addSeminarDate(@RequestBody DateRequestDto localDate) {
        try {
            essentialService.addSeminarDate(localDate.getSeminarDate());
            return ResponseEntity.ok("add Date success");
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    @GetMapping("/submit/info")
    public ResponseEntity<RecentSubmitSeminarInfo> getRecentSeminar() {
        try {
            return ResponseEntity.ok(essentialService.recentSeminarRequest());
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(null);
        }
    }
}
