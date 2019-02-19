package exceptions;

public class BadFormatException extends Exception {
    public BadFormatException() {
    }

    public BadFormatException(String msg) {
        super(msg);
    }
}
