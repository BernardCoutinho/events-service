package microsservice.eventsservice.repositories;

import microsservice.eventsservice.models.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {

    @Query("SELECT COUNT(s) FROM subscription s WHERE s.event.id = :eventId")
    Long getSubscriptionsQuantityByEvent(@Param("eventId") String eventId);
}
