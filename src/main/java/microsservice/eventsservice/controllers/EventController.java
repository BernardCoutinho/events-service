package microsservice.eventsservice.controllers;

import microsservice.eventsservice.dtos.EventRequestDTO;
import microsservice.eventsservice.dtos.SubscriptionRequestDTO;
import microsservice.eventsservice.models.Event;
import microsservice.eventsservice.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/event")
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    @GetMapping("/upcoming")
    public List<Event> getUpcomingEvents() {
        return eventService.getUpcomingEvents();
    }

}
