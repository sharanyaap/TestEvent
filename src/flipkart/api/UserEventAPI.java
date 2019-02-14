package flipkart.api;

import flipkart.domain.Event;
import flipkart.domain.User;
import flipkart.domain.UserEvent;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;

/**
 * Created by sharanya.p on 2/17/2018.
 */
public interface UserEventAPI {

    Event createEvent(Event event);

    Event updateEvent(Event event, List<User> users);

    Event deleteEvent(UUID eventId);

    Event getEvent(UUID eventId);

    User addUser(User user);

    Date freeTimeForUsers(List<User> users);

    List<Event> getEvents();

    //List<User> getUsers();

    List<UserEvent> getUsersEvents();
}
