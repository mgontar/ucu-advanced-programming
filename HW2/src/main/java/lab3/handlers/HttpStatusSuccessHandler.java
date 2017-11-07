package lab3.handlers;

import lab3.Constants;
import lab3.HttpCode;
import lab3.HttpStatus;
import lab3.HttpStatusHandler;

@HttpCode(fromCode = Constants.HTTP_STATUS_SUCCESS_CODE_MIN, toCode = Constants.HTTP_STATUS_SUCCESS_CODE_MAX)
public class HttpStatusSuccessHandler implements HttpStatusHandler {

    @Override
    public void handle(HttpStatus status) {
        System.out.println("Hurray: http status is "+status.toString());
    }
}
