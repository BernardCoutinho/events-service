package microsservice.eventsservice.exceptions;

public class EventFullException extends RuntimeException{
    public EventFullException(){
        super("Event is full");
    }

    public EventFullException(String message){
        super(message);
    }
}
