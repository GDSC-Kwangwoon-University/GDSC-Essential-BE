package gdsc.essential.essential.controller;

import gdsc.essential.seminar.dto.DateRequestDto;
import gdsc.essential.seminar.dto.SubmitRequestDto;
import gdsc.essential.seminar.RecentSubmitSeminarInfo;
import gdsc.essential.seminar.dto.SeminarDateResponseDto;
import gdsc.essential.essential.service.EssentialService;
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
        essentialService.addPresentor(submitRequestDto);
        return ResponseEntity.ok("success");
    }


    @GetMapping("/seminarDate")
    public ResponseEntity<SeminarDateResponseDto> getSeminarDate() {
        return ResponseEntity.ok(SeminarDateResponseDto.of(essentialService.exractSeminarDates()));
    }

    @PostMapping("/addSeminarDate")
    public ResponseEntity<String> addSeminarDate(@RequestBody DateRequestDto localDate) {
        System.out.println(localDate.getSeminarDate());
        essentialService.addSeminarDate(localDate.getSeminarDate());
        return ResponseEntity.ok("add Date success");
    }


    @GetMapping("/submit/info")
    public ResponseEntity<RecentSubmitSeminarInfo> getRecentSeminar() {
        return ResponseEntity.ok(essentialService.recentSeminarRequest());
    }
}
