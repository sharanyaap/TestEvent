package flipkart.domain;

import java.util.List;

/**
 * Created by sharanya.p on 2/17/2018.
 */
public class UserEvent {

    private User user;

    private Event event;

    private String status;

    public UserEvent(User user, Event event) {
        this.user = user;
        this.event = event;
        this.status = UserAcceptanceStatus.TENTATIVE.toString();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
