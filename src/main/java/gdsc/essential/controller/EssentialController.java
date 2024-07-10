package gdsc.essential.controller;

import gdsc.essential.domain.ApiResponse;
import gdsc.essential.service.EssentialService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class EssentialController {
    private final EssentialService essentialService;

    public EssentialController(EssentialService essentialService) {

        this.essentialService = essentialService;
    }

    @GetMapping("/user")
    public ApiResponse callResponse(@RequestParam String username){

        return essentialService.madeMemberResponse(username);
    }

}
