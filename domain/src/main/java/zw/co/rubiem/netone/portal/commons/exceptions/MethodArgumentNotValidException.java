package zw.co.rubiem.netone.portal.commons.exceptions;

/**
 * @author Nyabinde Nyasha
 * @created 3/23/2021
 * @project boilerplate
 */

public class MethodArgumentNotValidException extends RuntimeException {

    public MethodArgumentNotValidException(String message) {
        super(message);
    }
}
