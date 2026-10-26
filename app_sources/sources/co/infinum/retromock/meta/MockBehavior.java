package co.infinum.retromock.meta;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* INFO: loaded from: classes3.dex */
@Target({ElementType.METHOD})
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface MockBehavior {
    public static final int DEFAULT_DEVIATION_MILLIS = 500;
    public static final int DEFAULT_DURATION_MILLIS = 1000;

    int durationDeviation() default 500;

    int durationMillis() default 1000;
}
