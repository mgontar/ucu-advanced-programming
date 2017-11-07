package lab4;

import lombok.SneakyThrows;
import org.reflections.Reflections;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class ObjectFactory {
    private static ObjectFactory ourInstance = new ObjectFactory();
    private Config config = new JavaConfig();
    private Random random = new Random();
    private Map<Class<? extends Annotation>, ObjectConfigurator> map = new HashMap<>();
    public static ObjectFactory getInstance() {
        return ourInstance;
    }

    @SneakyThrows
    private ObjectFactory() {
        Reflections scanner = new Reflections("lab4");
        Set<Class<? extends ObjectConfigurator>> classes = scanner.getSubTypesOf(ObjectConfigurator.class);
        for (Class<? extends ObjectConfigurator> ocClass : classes) {
            if (!Modifier.isAbstract(ocClass.getModifiers())) {
                ConfiguratorType annotation = ocClass.getAnnotation(ConfiguratorType.class);
                if (annotation != null) {
                    Class<? extends Annotation>  annotationType = annotation.annotation();
                    ObjectConfigurator mgObj = ocClass.newInstance();
                    map.put(annotationType, mgObj);
                }
            }
        }
    }

    @SneakyThrows
    public <T> T createObject(Class<T> type) {
        if (type.isInterface()) {
           type =  config.getImpl(type);
        }
        T o = type.newInstance();

        Field[] fields = type.getDeclaredFields();
        for (Field field : fields) {
            Annotation[] annotations = field.getAnnotations();
            for (Annotation annotation : annotations)
            {
                ObjectConfigurator objectConfigurator = map.get(annotation.annotationType());
                o = objectConfigurator.configure(o, field, random);
            }
        }
        return o;
    }
}
