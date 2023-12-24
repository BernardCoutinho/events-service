package microsservice.eventsservice.repositories;

import microsservice.eventsservice.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventsRepository extends JpaRepository<Event, String> {
}
