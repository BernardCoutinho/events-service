package microsservice.eventsservice.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import microsservice.eventsservice.dtos.EventRequestDTO;

@Entity(name="event")
@Table(name="event")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of="id")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private int maxParticipants;

    private String date;

    private String title;

    private String description;

    public Event(EventRequestDTO eventDTO){
        this.maxParticipants = eventDTO.maxParticipants();
        this.date = eventDTO.date();
        this.title = eventDTO.title();
        this.description = eventDTO.description();
    }
}
