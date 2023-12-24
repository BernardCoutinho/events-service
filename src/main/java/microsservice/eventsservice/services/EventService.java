package microsservice.eventsservice.services;

import microsservice.eventsservice.dtos.EmailRequestDTO;
import microsservice.eventsservice.dtos.EventRequestDTO;
import microsservice.eventsservice.exceptions.EventFullException;
import microsservice.eventsservice.exceptions.EventNotFoundException;
import microsservice.eventsservice.models.Event;
import microsservice.eventsservice.models.Subscription;
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

    @Autowired
    private EmailServiceClient emailServiceClient;

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

    public Boolean isEventFull(Event event){
        Long registeredParticipantsQuantity = subscriptionRepository.getSubscriptionsQuantityByEvent(event.getId());
        return event.getMaxParticipants() <= registeredParticipantsQuantity;
    }

    public void registerParticipant(String eventId, String participantEmail){
        Event event = eventRepository.findById(eventId).orElseThrow(EventNotFoundException::new);
        if(isEventFull(event)){
            throw new EventFullException();
        }

        Subscription subscription = new Subscription(event, participantEmail);
        subscriptionRepository.save(subscription);

        EmailRequestDTO emailRequestDTO = new EmailRequestDTO(participantEmail, "Event Registration.",
                "You have been successfully registered for the event!");

        emailServiceClient.sendEmail(emailRequestDTO);
    }
}
