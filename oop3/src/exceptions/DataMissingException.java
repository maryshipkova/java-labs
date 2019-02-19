package exceptions;

public class DataMissingException extends Exception{
    public DataMissingException() {
    }

    public DataMissingException(String msg) {
        super(msg);
    }
}

