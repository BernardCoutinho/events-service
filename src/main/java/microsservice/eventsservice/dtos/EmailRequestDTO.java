package microsservice.eventsservice.dtos;

public record EmailRequestDTO(String to, String Subject, String body) {
}
