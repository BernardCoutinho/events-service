package microsservice.eventsservice.services;

import microsservice.eventsservice.dtos.EventRequestDTO;
import microsservice.eventsservice.exceptions.EventNotFoundException;
import microsservice.eventsservice.models.Event;
import microsservice.eventsservice.repositories.EventsRepository;
import microsservice.eventsservice.repositories.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventsRepository eventRepository;

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    public List<Event> getAllEvents(){
        return eventRepository.findAll();
    }

    public List<Event> getUpcomingEvents(){
        return eventRepository.findUpcomingEvents(LocalDateTime.now());
    }

    public Event createEvent(EventRequestDTO eventRequestDTO){
        Event event = new Event(eventRequestDTO);
        return eventRepository.save(event);
    }
}
