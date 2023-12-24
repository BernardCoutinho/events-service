package microsservice.eventsservice.dtos;

public record EmailRequestDTO(String to, String subject, String body) {
}
