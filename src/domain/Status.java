package domain;

public enum Status {
    ONLINE ("Online"),
    OFFLINE ("Offline"),
    AWAY ("Away");

    private String status;

    private Status (String status) {
       this.status = status;
    }

    public String getStatus() {
        return this.status;
    }
}
