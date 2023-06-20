package co.com.vortex.jpa.exception;

public class UseCaseException extends RuntimeException{
    public UseCaseException(String message, Throwable error) {
        super(message, error);
    }
}
