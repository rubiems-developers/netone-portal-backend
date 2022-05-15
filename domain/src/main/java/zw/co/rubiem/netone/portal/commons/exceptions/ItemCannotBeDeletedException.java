package zw.co.rubiem.netone.portal.commons.exceptions;

public class ItemCannotBeDeletedException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ItemCannotBeDeletedException(String message) {
        super(message + " cannot be deleted!!!");
    }
}
