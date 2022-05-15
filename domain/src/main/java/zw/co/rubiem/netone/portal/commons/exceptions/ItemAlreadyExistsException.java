package zw.co.rubiem.netone.portal.commons.exceptions;

public class ItemAlreadyExistsException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ItemAlreadyExistsException(String message) {
        super(message + " already exists!!!");
    }
}
