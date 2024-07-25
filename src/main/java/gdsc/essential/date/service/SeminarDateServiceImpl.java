package gdsc.essential.date.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class SeminarDateServiceImpl implements SeminarDateService {
    private Set<String> seminarDates = new HashSet<>();

    @Override
    public void postSeminarDates(List<String> dates) {
        seminarDates.addAll(dates);
    }

    @Override
    public List<String> getSeminarDates() {
        return new ArrayList<>(seminarDates);
    }

    @Override
    public boolean isDateAvailable(String date) {
        return seminarDates.contains(date);
    }
}
