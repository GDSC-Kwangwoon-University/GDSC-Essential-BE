package gdsc.essential.service;

import gdsc.essential.domain.*;
import gdsc.essential.dto.request.DateRequestDTO;
import gdsc.essential.dto.request.SubmitInfoRequestDTO;
import gdsc.essential.dto.response.RecentSubmitInfoResponseDTO;
import gdsc.essential.dto.response.SeminarDatesResponseDTO;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EssentialService {
    private List<Seminar> seminars;
    private List<User> users;
    @PostConstruct
    public void init() {
        seminars = new ArrayList<>(Arrays.asList(
                Seminar.builder()
                        .seminarDate(LocalDate.of(2022, 5,29))
                        .presenters(new ArrayList<>())
                        .build(),
                Seminar.builder()
                        .seminarDate(LocalDate.of(2022,4,10))
                        .presenters(new ArrayList<>())
                        .build()
            )
        );
        users = new ArrayList<>(Arrays.asList(
                User.builder()
                        .user_id(0L)
                        .part(UserPart.fe)
                        .role(UserRole.LEAD)
                        .build(),
                User.builder()
                        .user_id(1L)
                        .part(UserPart.app)
                        .role(UserRole.MEMBER).build(),
                User.builder()
                        .user_id(2L)
                        .part(UserPart.be)
                        .role(UserRole.CORE).build()
            )
        );
    }

    private RecentSubmitInfoResponseDTO recentSubmitInfoResponseDTO;
    public void saveSubmitInfo(SubmitInfoRequestDTO submitInfoRequestDTO) {
        Optional<Seminar> seminarOptional = seminars.stream().filter(seminar -> seminar.getSeminarDate().equals(submitInfoRequestDTO.getSeminarDate())).findFirst();
        if (seminarOptional.isEmpty()){
            throw new IllegalArgumentException("해당 세미나가 존재하지 않습니다.");
        }
        Seminar seminar = seminarOptional.get();

        Optional<User> userOptional = users.stream().filter(user -> user.getUser_id().equals(submitInfoRequestDTO.getSpeakerId())).findFirst();
        if (userOptional.isEmpty())
        {
            throw new IllegalArgumentException("해당 유저가 존재하지 않습니다.");
        }
        User user = userOptional.get();
        Speaker speaker = Speaker.of(user, submitInfoRequestDTO);

        seminar.addPresenter(speaker);
        recentSubmitInfoResponseDTO = RecentSubmitInfoResponseDTO.of(submitInfoRequestDTO);
    }
    public RecentSubmitInfoResponseDTO getRecentSubmitInfos() {
        return recentSubmitInfoResponseDTO;
    }

    public void addSeminarDate(DateRequestDTO dateRequestDTO) {
        seminars.add(Seminar.builder().seminarDate(dateRequestDTO.getSeminarDate()).presenters(new ArrayList<>()).build());
    }

    public SeminarDatesResponseDTO getSeminarDates() {
        List<LocalDate> localDates = seminars.stream().map(Seminar::getSeminarDate).toList();
        return SeminarDatesResponseDTO.of(localDates);
    }
}
