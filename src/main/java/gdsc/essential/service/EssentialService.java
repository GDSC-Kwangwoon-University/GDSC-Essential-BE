package gdsc.essential.service;

import gdsc.essential.domain.ApiResponse;
import gdsc.essential.domain.SubmitRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/*
 * Service: Service Layer
 * implement business logics
 */
@Service
public class EssentialService {
    // 현재까지의 입력된 값들(id, 날짜, 주제, 본문)
    private final List<ApiResponse> responses = new ArrayList<>();

    // 1: 날짜 return
    public List<String> getDates() {
        List<String> dates = new ArrayList<>();
        dates.add("24.06.01");
        dates.add("24.06.10");
        return dates;
    }

    // 2: 입력 받은 데이터 저장
    public void saveResponse(SubmitRequest request) {
        int id = responses.size() + 1;
        responses.add(new ApiResponse(id, request.date(), request.subject(), request.content()));
    }

    // 3: 모든 데이터 return
    public List<ApiResponse> getAllResponses() {
        return new ArrayList<>(responses);
    }
}