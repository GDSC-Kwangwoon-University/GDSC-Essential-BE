package gdsc.essential.domain;

// 2단계: 요청을 위한 SubmitRequest 클래스
public record SubmitRequest(String date, String subject, String content) {
}