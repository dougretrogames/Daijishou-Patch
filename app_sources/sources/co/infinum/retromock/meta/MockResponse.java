package co.infinum.retromock.meta;

import co.infinum.retromock.BodyFactory;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* INFO: loaded from: classes3.dex */
@Target({ElementType.METHOD})
@Documented
@Repeatable(MockResponses.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface MockResponse {
    String body() default "";

    Class<? extends BodyFactory> bodyFactory() default BodyFactory.class;

    int code() default 200;

    MockHeader[] headers() default {};

    String message() default "OK";
}
