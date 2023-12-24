package microsservice.eventsservice.repositories;

import microsservice.eventsservice.models.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
}
