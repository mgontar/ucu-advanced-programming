package lab4;

import java.lang.reflect.Field;
import java.util.Random;

public interface ObjectConfigurator {
    <T> T configure(T object, Field field, Random rnd);
}
