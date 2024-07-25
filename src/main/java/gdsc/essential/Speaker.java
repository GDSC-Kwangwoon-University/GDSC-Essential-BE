package gdsc.essential;

public class Speaker {
    private String date, topic, content;

    public Speaker(String date, String topic, String content) {
        this.date = date;
        this.topic = topic;
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public String getTopic() {
        return topic;
    }

    public String getContent() {
        return content;
    }

}
