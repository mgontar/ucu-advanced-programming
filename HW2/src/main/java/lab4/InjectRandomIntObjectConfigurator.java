package lab4;

import lombok.SneakyThrows;

import java.lang.reflect.Field;
import java.util.Random;

@ConfiguratorType(annotation = InjectRandomInt.class)
public class InjectRandomIntObjectConfigurator implements ObjectConfigurator {

    @SneakyThrows
    @Override
    public <T> T configure(T object, Field field, Random rnd) {
        InjectRandomInt annotation = field.getAnnotation(InjectRandomInt.class);
        if (annotation != null) {
            int min = annotation.min();
            int max = annotation.max();
            int randomIntValue = rnd.nextInt(max - min) + min;
            field.setAccessible(true);
            field.set(object,randomIntValue);
        }
        return object;
    }
}
