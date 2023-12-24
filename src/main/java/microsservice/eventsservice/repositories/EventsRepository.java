package microsservice.eventsservice.repositories;

import microsservice.eventsservice.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import jakarta.annotation.Nonnull;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface EventsRepository extends JpaRepository<Event, String> {

    @Query(value = "SELECT * FROM events event WHERE PARSE (event.date AS TIMESTAMP > :currentDate)", nativeQuery = true)
    List<Event> findUpcomingEvents(@Param("currentDate") LocalDateTime currentDate);

    @Nonnull
    Optional<Event> findById(@Nonnull String id);
}
