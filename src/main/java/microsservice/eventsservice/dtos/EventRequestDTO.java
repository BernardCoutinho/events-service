package microsservice.eventsservice.dtos;

public record EventRequestDTO(int maxParticipants, String date, String title, String description) {
}
