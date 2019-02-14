package flipkart.impl;

import flipkart.api.UserEventAPI;
import flipkart.domain.Event;
import flipkart.domain.User;
import flipkart.domain.UserEvent;

import java.util.*;

/**
 * Created by sharanya.p on 2/17/2018.
 */
public class UserEventImpl implements UserEventAPI {

    List<Event> events = new ArrayList<>();

    List<User> users = new ArrayList<>();

    List<UserEvent> userEvents = new ArrayList<>();

    @Override
    public Event createEvent(Event event) {
        events.add(event);
        updateUserListForEvent(event);
        return event;
    }

    /**
     * Helper class to populate userEvents
     *
     * @param user
     * @param event
     */
    private void populateUserEvent(User user, Event event) {
        if (!userEvents.isEmpty()) {
            for (UserEvent userEvent : userEvents) {
                if (userEvent.getEvent().equals(event) && userEvent.getUser().equals(user)) {
                    return;
                }
            }
        }
        userEvents.add(new UserEvent(user, event));
    }

    /**
     * Helper class to update the user list in event
     *
     * @param event
     */
    private void updateUserListForEvent(Event event) {
        for (User user : event.getUserList()) {
            Set<Event> userEvents = new HashSet<>();
            if (user.getEvents() != null) {
                userEvents = user.getEvents();
            }
            userEvents.add(event);
            user.setEvents(userEvents);
            populateUserEvent(user, event);
        }
    }

    @Override
    public Event updateEvent(Event event, List<User> updateUsers) {
        for (User user : event.getUserList()) {
            removeAllUserEventsForUser(user.getUserId());
            for (Event event1 : user.getEvents()) {
                if (event1.equals(event)) {
                    user.getEvents().remove(event1);
                }
            }
        }
        event.setUserList(updateUsers);
        updateUserListForEvent(event);
        return event;
    }

    /**
     * Remove all Events in case of update user list
     *
     * @param userId
     */
    private void removeAllUserEventsForUser(UUID userId) {
        List<UserEvent> removeEvents = new ArrayList<>();
        for (UserEvent userEvent : userEvents) {
            if (userId.equals(userEvent.getUser().getUserId())) {
                removeEvents.add(userEvent);
            }
        }
        userEvents.removeAll(removeEvents);
    }

    @Override
    public Event deleteEvent(UUID eventId) {
        Event removeEvent = null;
        if (!events.isEmpty()) {
            Iterator<Event> eventIterator = events.iterator();
            //Remove in user events list
            while (eventIterator.hasNext()) {
                Event event = eventIterator.next();
                if (eventId.equals(event.getEventId())) {
                    removeEvent = event;
                    for (User user : event.getUserList()) {
                        user.getEvents().remove(removeEvent);
                    }
                    break;
                }
            }
            //remove from events
            if (removeEvent != null) {
                events.remove(removeEvent);
            }
            // Remove from userEvents as well
            if (!userEvents.isEmpty()) {
                List<UserEvent> removeEvents = new ArrayList<>();
                for (UserEvent userEvent : userEvents) {
                    if (eventId.equals(userEvent.getEvent().getEventId())) {
                        removeEvents.add(userEvent);
                    }
                }
                userEvents.removeAll(removeEvents);
            }
        }
        return removeEvent;
    }

    @Override
    public Event getEvent(UUID eventId) {
        if (!events.isEmpty()) {
            for (Event event : events) {
                if (eventId.equals(event.getEventId())) {
                    return event;
                }
            }
        }
        return null;
    }

    @Override
    public User addUser(User user) {
        users.add(user);
        return user;
    }

    @Override
    public Date freeTimeForUsers(List<User> users) {
        Date res = null;
        Set<Event> occEvents = new HashSet<>();
        for (User user : users) {
            if (!user.getEvents().isEmpty())
                occEvents.addAll(user.getEvents());
        }
        for (Event event : occEvents) {
            if (res == null) {
                res = event.getEnd();
            } else if (event.getStart().compareTo(res) == 0) {
                res = event.getEnd();
            }
        }
        return res;
    }

    @Override
    public List<Event> getEvents() {
        return events;
    }


    @Override
    public List<UserEvent> getUsersEvents() {
        return userEvents;
    }

}
