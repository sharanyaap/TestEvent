package flipkart.domain;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by sharanya.p on 2/17/2018.
 */
public class Event {

    private UUID eventId;

    private Date start;

    private Date end;

    private String meetingRoom;

    private User owner;

    private List<User> userList;

    private String title;

    public Event(Date start, Date end, String meetingRoom, User owner, List<User> userList, String title) {
        this.eventId = UUID.randomUUID();
        this.start = start;
        this.end = end;
        this.meetingRoom = meetingRoom;
        this.owner = owner;
        this.userList = userList;
        this.title = title;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public String getMeetingRoom() {
        return meetingRoom;
    }

    public void setMeetingRoom(String meetingRoom) {
        this.meetingRoom = meetingRoom;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public UUID getEventId() {
        return eventId;
    }

    @Override
    public String toString() {
        return "Event{" +
                "eventId=" + eventId +
                ", start=" + start +
                ", end=" + end +
                ", meetingRoom='" + meetingRoom + '\'' +
                ", owner=" + owner +
                ", userList=" + userList +
                ", title='" + title + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Event event = (Event) o;

        if (eventId != null ? !eventId.equals(event.eventId) : event.eventId != null) return false;
        if (start != null ? !start.equals(event.start) : event.start != null) return false;
        if (end != null ? !end.equals(event.end) : event.end != null) return false;
        if (meetingRoom != null ? !meetingRoom.equals(event.meetingRoom) : event.meetingRoom != null) return false;
        if (owner != null ? !owner.equals(event.owner) : event.owner != null) return false;
        if (userList != null ? !userList.equals(event.userList) : event.userList != null) return false;
        return title != null ? title.equals(event.title) : event.title == null;
    }

    @Override
    public int hashCode() {
        int result = eventId != null ? eventId.hashCode() : 0;
        //result = 31 * result + (start != null ? start.hashCode() : 0);
        //result = 31 * result + (end != null ? end.hashCode() : 0);
        //result = 31 * result + (meetingRoom != null ? meetingRoom.hashCode() : 0);
        //result = 31 * result + (owner != null ? owner.hashCode() : 0);
        // result = 31 * result + (userList != null ? userList.hashCode() : 0);
        //result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }
}
