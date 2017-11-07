package lab3.handlers;

import lab3.Constants;
import lab3.HttpCode;
import lab3.HttpStatus;
import lab3.HttpStatusHandler;

@HttpCode(fromCode = Constants.HTTP_STATUS_SERVER_ERROR_CODE_MIN, toCode = Constants.HTTP_STATUS_SERVER_ERROR_CODE_MAX)
public class HttpStatusServerErrorHandler implements HttpStatusHandler {

    @Override
    public void handle(HttpStatus status) {
        System.out.println("Try to reconnect: http status is "+status.toString());
    }
}
