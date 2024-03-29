package microsservice.eventsservice.models;

import lombok.*;
import jakarta.persistence.*;

@Entity(name="subscription")
@Table(name="subscription")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Event event;

    private String participantEmail;

    public Subscription(Event event, String participantEmail){
        this.event = event;
        this.participantEmail = participantEmail;
    }
}
