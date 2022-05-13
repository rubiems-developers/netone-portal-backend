package zw.co.rubiem.netone.portal.domain.commons;

import lombok.Data;

/**
 * @author Nyabinde Nyasha
 * @created 12/18/2020
 * @project boilerplate
 */

@Data
public class ResponseMessage {

    private String message;

    public ResponseMessage(String message) {
        this.message = message;
    }

}
