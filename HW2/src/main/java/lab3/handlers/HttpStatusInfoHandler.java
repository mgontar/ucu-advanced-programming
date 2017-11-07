package lab3.handlers;

import lab3.Constants;
import lab3.HttpCode;
import lab3.HttpStatus;
import lab3.HttpStatusHandler;

@HttpCode(fromCode = Constants.HTTP_STATUS_INFO_CODE_MIN, toCode = Constants.HTTP_STATUS_INFO_CODE_MAX)
public class HttpStatusInfoHandler implements HttpStatusHandler {

    @Override
    public void handle(HttpStatus status) {
        System.out.println("Just to inform: http status is "+status.toString());
    }
}
