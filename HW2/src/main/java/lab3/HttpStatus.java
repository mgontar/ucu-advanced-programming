package lab3;

import org.apache.commons.lang3.Range;

public enum HttpStatus {
    INFO(Constants.HTTP_STATUS_INFO_CODE_MIN,Constants.HTTP_STATUS_INFO_CODE_MAX, "Informational"),
    SUCCESS(Constants.HTTP_STATUS_SUCCESS_CODE_MIN,Constants.HTTP_STATUS_SUCCESS_CODE_MAX, "Success"),
    REDIRECT(Constants.HTTP_STATUS_REDIRECT_CODE_MIN,Constants.HTTP_STATUS_REDIRECT_CODE_MAX, "3xx Redirection"),
    CLIENT_ERROR(Constants.HTTP_STATUS_CLIENT_ERROR_CODE_MIN,Constants.HTTP_STATUS_CLIENT_ERROR_CODE_MAX, "4xx Client Error"),
    SERVER_ERROR(Constants.HTTP_STATUS_SERVER_ERROR_CODE_MIN,Constants.HTTP_STATUS_SERVER_ERROR_CODE_MAX,"5xx Server Error");

    public final Range<Integer> codeRange;
    private final String description;
    HttpStatus(int fromCode, int toCode, String description) {
        codeRange = Range.between(fromCode, toCode);
        this.description = description;
    }

    public static HttpStatus findByHttpCode(int code) {
        HttpStatus[] statuses = values();
        for (HttpStatus status : statuses) {
            if (status.codeRange.contains(code)) {
                return status;
            }
        }
        throw new RuntimeException("http status code" + code + " not supported");
    }

    @Override
    public String toString() {
        return description;
    }
}
