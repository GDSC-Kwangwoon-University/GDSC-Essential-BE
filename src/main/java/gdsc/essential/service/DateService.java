package gdsc.essential.service;

import gdsc.essential.SeminarDate;
import gdsc.essential.repository.DateRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class DateService {
    private List<SeminarDate> seminarDateList;

    @PostConstruct
    public void init(){
        seminarDateList = new ArrayList<>(Arrays.asList(
                SeminarDate.builder()
                        .month_id(4)
                                .seminarDate()
                build()
        ))
    }
    public String getSeminarDate(Long month) {

        if (seminarDate.isPresent()){
            return seminarDate.get().getSeminarDate();
        }
        else return "추후 날짜 확정시";
    }
}
