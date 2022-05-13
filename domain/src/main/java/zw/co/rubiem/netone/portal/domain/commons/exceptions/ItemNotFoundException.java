package zw.co.rubiem.netone.portal.domain.commons.exceptions;

public class ItemNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ItemNotFoundException(String message) {
        super(message + " not found!!!");
    }

}
