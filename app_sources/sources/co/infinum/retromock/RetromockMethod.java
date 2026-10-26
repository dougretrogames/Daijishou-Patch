package co.infinum.retromock;

import co.infinum.retromock.meta.Mock;
import co.infinum.retromock.meta.MockBehavior;
import co.infinum.retromock.meta.MockCircular;
import co.infinum.retromock.meta.MockRandom;
import co.infinum.retromock.meta.MockResponse;
import co.infinum.retromock.meta.MockResponses;
import co.infinum.retromock.meta.MockSequential;
import java.lang.reflect.Method;
import javax.annotation.Nullable;
import okhttp3.Headers;

/* INFO: loaded from: classes3.dex */
final class RetromockMethod {
    private static final ResponseParams DEFAULT_PARAMS = new ResponseParams.Builder().code(200).message("OK").headers(new Headers.Builder().add("Content-Type", "text/plain").build()).build();
    private final Behavior behavior;
    private final ParamsProducer producer;

    static RetromockMethod parse(Method method, Retromock retromock) throws Retromock.DisabledException {
        ParamsProducer noResponseProducer;
        Mock mock = (Mock) method.getAnnotation(Mock.class);
        if (mock == null || !mock.value()) {
            throw new Retromock.DisabledException();
        }
        MockResponse[] mockResponseArrLoadMockResponses = loadMockResponses(method);
        if (mockResponseArrLoadMockResponses != null) {
            noResponseProducer = new ResponseParamsProducer(retromock, loadResponseIterator(method, mockResponseArrLoadMockResponses), DEFAULT_PARAMS);
        } else {
            noResponseProducer = new NoResponseProducer(retromock, DEFAULT_PARAMS);
        }
        Behavior behaviorDefaultBehavior = retromock.defaultBehavior();
        MockBehavior mockBehavior = (MockBehavior) method.getAnnotation(MockBehavior.class);
        if (mockBehavior != null) {
            behaviorDefaultBehavior = new RetromockBehavior(mockBehavior);
        }
        return new RetromockMethod(noResponseProducer, behaviorDefaultBehavior);
    }

    @Nullable
    private static MockResponse[] loadMockResponses(Method method) {
        MockResponses mockResponses = (MockResponses) method.getAnnotation(MockResponses.class);
        if (mockResponses != null) {
            return mockResponses.value();
        }
        MockResponse mockResponse = (MockResponse) method.getAnnotation(MockResponse.class);
        if (mockResponse != null) {
            return new MockResponse[]{mockResponse};
        }
        return null;
    }

    private static ResponseIterator<MockResponse> loadResponseIterator(Method method, MockResponse[] mockResponseArr) {
        MockCircular mockCircular = (MockCircular) method.getAnnotation(MockCircular.class);
        MockSequential mockSequential = (MockSequential) method.getAnnotation(MockSequential.class);
        MockRandom mockRandom = (MockRandom) method.getAnnotation(MockRandom.class);
        if (mockCircular != null) {
            if (mockSequential != null || mockRandom != null) {
                throw new IllegalStateException("Cannot specify more than one response iterator.");
            }
            return new CircularIterator(mockResponseArr);
        }
        if (mockSequential != null) {
            if (mockRandom != null) {
                throw new IllegalStateException("Cannot specify more than one response iterator.");
            }
            return new SequentialIterator(mockResponseArr);
        }
        if (mockRandom != null) {
            return new RandomIterator(mockResponseArr);
        }
        return new SequentialIterator(mockResponseArr);
    }

    private RetromockMethod(ParamsProducer paramsProducer, Behavior behavior) {
        this.producer = paramsProducer;
        this.behavior = behavior;
    }

    ParamsProducer producer() {
        return this.producer;
    }

    Behavior behavior() {
        return this.behavior;
    }
}
