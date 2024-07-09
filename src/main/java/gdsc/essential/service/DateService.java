package gdsc.essential.service;

import gdsc.essential.Entity.SeminarDate;
import gdsc.essential.dto.response.SeminarDatesResponseDTO;
import gdsc.essential.repository.DateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class DateService {
    private final DateRepository dateRepository;
    @Autowired
    public DateService(DateRepository dateRepository) {
        this.dateRepository = dateRepository;
    }

    public String getSeminarDate(Long month) {
        Optional<SeminarDate> seminarDate = dateRepository.findById(month);

        if (seminarDate.isPresent()){
            return seminarDate.get().getSeminarDate();
        }
        else return "추후 날짜 확정시";
    }
}
