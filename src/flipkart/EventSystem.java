package flipkart;

import flipkart.api.UserEventAPI;
import flipkart.domain.Event;
import flipkart.domain.User;
import flipkart.domain.UserEvent;
import flipkart.impl.UserEventImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by sharanya.p on 2/17/2018.
 */
public class EventSystem {

    public static void main(String[] args) {

        UserEventAPI eventAPI = new UserEventImpl();

        //Create users
        User user1 = eventAPI.addUser(new User("user1", "user1@test.com"));
        User user2 = eventAPI.addUser(new User("user2", "user2@test.com"));
        User user3 = eventAPI.addUser(new User("user3", "user3@test.com"));

        List<User> users = new ArrayList() {{
            add(user1);
            add(user2);
            add(user3);
        }};

        Date startTime = new Date();
        long HOUR = 3600 * 1000; // in milli-seconds.
        Date endTime = new Date(startTime.getTime() + 1 * HOUR);
        Event event1 = eventAPI.createEvent(new Event(startTime, endTime, "room1", user1, users, "test meeting1"));

        Event event2 = eventAPI.createEvent(new Event(new Date(endTime.getTime() + 1 * HOUR), new Date(endTime.getTime() + 2 * HOUR), "room1", user2, users, "test meeting2"));

        Event event3 = eventAPI.createEvent(new Event(new Date(startTime.getTime() - 1 * HOUR), new Date(startTime.getTime()), "room1", user3, users, "test meeting3"));

        Event event4 = eventAPI.createEvent(new Event(new Date(startTime.getTime() - 2 * HOUR), new Date(startTime.getTime() - 1 * HOUR), "room1", user3, users, "test meeting4"));

        //Get All Events/Calendar for User
        Set<Event> eventsForUser = user3.getEvents();
        System.out.println("Events for User " + user3.getName() + " :: " + eventsForUser);

        //Delete Event
        event1 = eventAPI.deleteEvent(event2.getEventId());
        System.out.println("Deleted Event :: " + event2.toString());

        // All Events
        /*System.out.println("Get All Active Events:: ");
        List<Event> events = eventAPI.getEvents();
        for (Event event : events) {
            System.out.println("Event " + event.getTitle() + " start time " + event.getStart() + " end time " + event.getEnd());
        }*/

        // Free Time
        //System.out.println("Get Free time for Users :: " + eventAPI.freeTimeForUsers(users));

        //Get All Events/Calendar for User
        eventsForUser = user3.getEvents();
        System.out.println("Events for User " + user3.getName() + " :: " + eventsForUser);


        /*for (UserEvent userEvent: eventAPI.getUsersEvents()){
            System.out.println("User :: "+ userEvent.getUser().toString() + " Event :: "+ userEvent.getEvent().toString()+ " Status :: "+ userEvent.getStatus());
        }*/





        /*System.out.println("Created Event :: " + event1.toString());

        event1.setTitle("change title");
        users = new ArrayList() {{
            add(user1);
            add(user2);
        }};

        //Update Event
        event1 = eventAPI.updateEvent(event1, users);
        System.out.println("Updated Event :: " + event1.toString());


        //Delete Event
        event1 = eventAPI.deleteEvent(event1.getEventId());
        System.out.println("Deleted Event :: " + event1.toString());

        //Get All Events/Calendar for User
        Set<Event> eventsForUser = user1.getEvents();
        System.out.println("Events for User " + user1.getName() + " :: " + eventsForUser);


        event1 = eventAPI.createEvent(new Event(startTime, endTime, "room1", user1, users, "test meeting"));
        System.out.println("Created Event 1 :: " + event1.toString());

        users = new ArrayList() {{
            add(user2);
            add(user3);
        }};
        Event event2 = eventAPI.createEvent(new Event(endTime, new Date(endTime.getTime() + 1 * HOUR), "room2", user2, users, "test meeting2"));
        System.out.println("Created Event 2 :: " + event2.toString());

        //Event2 Data
        System.out.println("Event2 details :: " + event2.toString());

        // All Events
        System.out.println("Get All Active Events:: ");
        List<Event> events = eventAPI.getEvents();
        for (Event event : events) {
            System.out.println("Event " + event.getTitle() + " start time " + event.getStart() + " end time " + event.getEnd());
        }

        // Free Time
        System.out.println("Get Free time for Users :: " + eventAPI.freeTimeForUsers(users));
*/


    }
}
