package lab3;

import org.apache.commons.lang3.Range;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
public @interface HttpCode {
    int fromCode();
    int toCode();
}