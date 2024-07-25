package gdsc.essential.controller;

import gdsc.essential.Speaker;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/api/v1")
@RequiredArgsConstructor
@RestController
public class EssentialController {

    private Speaker targetSpeaker;

    @PostMapping("/submit")
    public ResponseEntity<String> enrollSpeaker(@RequestBody Speaker sp) {
        targetSpeaker = new Speaker(
                sp.getDate(),
                sp.getTopic(),
                sp.getContent()
        );
        return ResponseEntity.ok("등록 완료");
    }

    @GetMapping("/submit/date")
    public ResponseEntity<String> submitDate(@RequestParam String id) {

        if (targetSpeaker != null) {
            String date = targetSpeaker.getDate();
            if (date != null && date.isEmpty()) {
                return ResponseEntity.ok("발표 날짜는 " + date + " 입니다.");
            }
        }
        return ResponseEntity.badRequest().body("해당 발표자는 없습니다.");
    }

    @GetMapping("/submit/info")
    public ResponseEntity<?> getSpeaker() {

        if (targetSpeaker == null) {
            return ResponseEntity.badRequest().body("발표자가 없습니다.");
        }

        return ResponseEntity.ok(targetSpeaker);
    }
}
