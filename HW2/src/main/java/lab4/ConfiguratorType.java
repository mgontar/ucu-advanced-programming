package lab4;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
public @interface ConfiguratorType {
    Class<? extends Annotation> annotation();
}
