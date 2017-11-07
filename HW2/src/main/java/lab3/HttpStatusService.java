package lab3;

import lab1.MailGenerator;
import lab1.MailInfo;
import lombok.SneakyThrows;
import org.apache.commons.lang3.Range;
import org.reflections.Reflections;

import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HttpStatusService {
    private Map<Range<Integer>, HttpStatusHandler> map = new HashMap<>();

    @SneakyThrows
    public HttpStatusService() {
        Reflections scanner = new Reflections("lab3");
        Set<Class<? extends HttpStatusHandler>> classes = scanner.getSubTypesOf(HttpStatusHandler.class);
        for (Class<? extends HttpStatusHandler> mgClass : classes) {
            if (!Modifier.isAbstract(mgClass.getModifiers())) {
                HttpCode annotation = mgClass.getAnnotation(HttpCode.class);
                if (annotation != null) {
                    Range<Integer>  codeRange = Range.between(annotation.fromCode(), annotation.toCode());
                    HttpStatusHandler mgObj = mgClass.newInstance();
                    map.put(codeRange, mgObj);
                }
            }
        }
    }

    public void handleHttpStatus(int httpStatusCode) {

        HttpStatus status = HttpStatus.findByHttpCode(httpStatusCode);
        HttpStatusHandler httpStatusHandler = map.get(status.codeRange);
        if (httpStatusHandler == null) {
            throw new IllegalStateException("http status code" + httpStatusCode + " not supported yet");
        }
        httpStatusHandler.handle(status);
    }
}
