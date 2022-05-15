package zw.co.rubiem.netone.portal.commons.exceptions;

public class InvalidPhoneNumberException extends RuntimeException {
    public InvalidPhoneNumberException() {
        super("Supplied Phone Number is invalid!");
    }

    public InvalidPhoneNumberException(String message) {
        super(message);
    }

    public InvalidPhoneNumberException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidPhoneNumberException(Throwable cause) {
        super(cause);
    }

    public InvalidPhoneNumberException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
