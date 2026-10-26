package com.github.kittinunf.fuel.core;

import androidx.exifinterface.media.ExifInterface;
import com.github.kittinunf.fuel.core.requests.CancellableRequest;
import com.github.kittinunf.result.Result;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.reflect.KClass;
import kotlin.text.Charsets;

/* INFO: compiled from: Request.kt */
/* INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0096\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010)\u001a\u00020\u00002\u0006\u0010)\u001a\u00020*H&J9\u0010+\u001a\u00020\u00002*\u0010,\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001d0\u001c0-\"\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001d0\u001cH&¢\u0006\u0002\u0010.J\u0018\u0010+\u001a\u00020\u00002\u0006\u0010/\u001a\u00020\b2\u0006\u00100\u001a\u00020\u001dH&J)\u0010+\u001a\u00020\u00002\u0006\u0010/\u001a\u00020\b2\u0012\u00101\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001d0-\"\u00020\u001dH&¢\u0006\u0002\u00102J\u0010\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0003H&JF\u0010\u0002\u001a\u00020\u00002\u0010\u00103\u001a\f\u0012\u0004\u0012\u00020504j\u0002`62\u0016\b\u0002\u00107\u001a\u0010\u0012\u0004\u0012\u000208\u0018\u000104j\u0004\u0018\u0001`92\b\b\u0002\u0010:\u001a\u00020;2\b\b\u0002\u0010<\u001a\u00020*H&J\u001a\u0010\u0002\u001a\u00020\u00002\u0006\u0010=\u001a\u00020>2\b\b\u0002\u0010:\u001a\u00020;H&J<\u0010\u0002\u001a\u00020\u00002\u0006\u0010?\u001a\u0002052\u0016\b\u0002\u00107\u001a\u0010\u0012\u0004\u0012\u000208\u0018\u000104j\u0004\u0018\u0001`92\b\b\u0002\u0010:\u001a\u00020;2\b\b\u0002\u0010<\u001a\u00020*H&J\u001a\u0010\u0002\u001a\u00020\u00002\u0006\u0010@\u001a\u00020A2\b\b\u0002\u0010:\u001a\u00020;H&J\u001a\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\b2\b\b\u0002\u0010:\u001a\u00020;H&J\u001b\u0010B\u001a\f\u0012\u0004\u0012\u00020\b0Cj\u0002`D2\u0006\u0010/\u001a\u00020\bH¦\u0002J'\u0010E\u001a\u0004\u0018\u0001HF\"\b\b\u0000\u0010F*\u00020\u001d2\f\u0010G\u001a\b\u0012\u0004\u0012\u0002HF0HH&¢\u0006\u0002\u0010IJ9\u0010/\u001a\u00020\u00002*\u0010,\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001d0\u001c0-\"\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001d0\u001cH&¢\u0006\u0002\u0010.J\u001a\u0010/\u001a\f\u0012\u0004\u0012\u00020\b0Cj\u0002`D2\u0006\u0010/\u001a\u00020\bH&J\u0018\u0010/\u001a\u00020\u00002\u0006\u0010/\u001a\u00020\b2\u0006\u00100\u001a\u00020\u001dH&J)\u0010/\u001a\u00020\u00002\u0006\u0010/\u001a\u00020\b2\u0012\u00101\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001d0-\"\u00020\u001dH&¢\u0006\u0002\u00102J\u001c\u0010/\u001a\u00020\u00002\u0006\u0010/\u001a\u00020\b2\n\u00101\u001a\u0006\u0012\u0002\b\u00030CH&J\u001c\u0010/\u001a\u00020\u00002\u0012\u0010J\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001d0KH&J \u0010L\u001a\u00020\u00002\u0016\u0010L\u001a\u0012\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020N0Mj\u0002`OH&JD\u0010P\u001a\u00020\u00002:\u0010Q\u001a6\u0012\u0013\u0012\u001108¢\u0006\f\bS\u0012\b\bT\u0012\u0004\b\b(U\u0012\u0013\u0012\u001108¢\u0006\f\bS\u0012\b\bT\u0012\u0004\b\b(V\u0012\u0004\u0012\u00020N0Rj\u0002`WH&J0\u0010X\u001a*\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020Z\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020A\u0012\u0004\u0012\u00020\\0[0Yj\b\u0012\u0004\u0012\u00020A`]H&J\u0016\u0010X\u001a\u00020^2\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020A0_H&J\u0016\u0010X\u001a\u00020^2\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020A0`H&J>\u0010X\u001a\u00020^24\u0010Q\u001a0\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020Z\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020A\u0012\u0004\u0012\u00020\\0[\u0012\u0004\u0012\u00020N0aj\b\u0012\u0004\u0012\u00020A`bH&J2\u0010X\u001a\u00020^2(\u0010Q\u001a$\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020A\u0012\u0004\u0012\u00020\\0[\u0012\u0004\u0012\u00020N0Mj\b\u0012\u0004\u0012\u00020A`cH&JH\u0010d\u001a*\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020Z\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002HF\u0012\u0004\u0012\u00020\\0[0Yj\b\u0012\u0004\u0012\u0002HF`]\"\b\b\u0000\u0010F*\u00020\u001d2\f\u0010e\u001a\b\u0012\u0004\u0012\u0002HF0fH&J.\u0010d\u001a\u00020^\"\b\b\u0000\u0010F*\u00020\u001d2\f\u0010e\u001a\b\u0012\u0004\u0012\u0002HF0f2\f\u0010Q\u001a\b\u0012\u0004\u0012\u0002HF0_H&J.\u0010d\u001a\u00020^\"\b\b\u0000\u0010F*\u00020\u001d2\f\u0010e\u001a\b\u0012\u0004\u0012\u0002HF0f2\f\u0010Q\u001a\b\u0012\u0004\u0012\u0002HF0`H&JV\u0010d\u001a\u00020^\"\b\b\u0000\u0010F*\u00020\u001d2\f\u0010e\u001a\b\u0012\u0004\u0012\u0002HF0f24\u0010Q\u001a0\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020Z\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002HF\u0012\u0004\u0012\u00020\\0[\u0012\u0004\u0012\u00020N0aj\b\u0012\u0004\u0012\u0002HF`bH&JJ\u0010d\u001a\u00020^\"\b\b\u0000\u0010F*\u00020\u001d2\f\u0010e\u001a\b\u0012\u0004\u0012\u0002HF0f2(\u0010Q\u001a$\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002HF\u0012\u0004\u0012\u00020\\0[\u0012\u0004\u0012\u00020N0Mj\b\u0012\u0004\u0012\u0002HF`cH&JD\u0010g\u001a\u00020\u00002:\u0010Q\u001a6\u0012\u0013\u0012\u001108¢\u0006\f\bS\u0012\b\bT\u0012\u0004\b\b(U\u0012\u0013\u0012\u001108¢\u0006\f\bS\u0012\b\bT\u0012\u0004\b\b(V\u0012\u0004\u0012\u00020N0Rj\u0002`WH&J0\u0010h\u001a*\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020Z\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\\0[0Yj\b\u0012\u0004\u0012\u00020\b`]H&J\u0016\u0010h\u001a\u00020^2\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020\b0_H&J\u0016\u0010h\u001a\u00020^2\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020\b0`H&J>\u0010h\u001a\u00020^24\u0010Q\u001a0\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020Z\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\\0[\u0012\u0004\u0012\u00020N0aj\b\u0012\u0004\u0012\u00020\b`bH&J2\u0010h\u001a\u00020^2(\u0010Q\u001a$\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\\0[\u0012\u0004\u0012\u00020N0Mj\b\u0012\u0004\u0012\u00020\b`cH&J:\u0010h\u001a*\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020Z\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\\0[0Yj\b\u0012\u0004\u0012\u00020\b`]2\b\b\u0002\u0010:\u001a\u00020;H&J \u0010h\u001a\u00020^2\b\b\u0002\u0010:\u001a\u00020;2\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020\b0_H&J \u0010h\u001a\u00020^2\b\b\u0002\u0010:\u001a\u00020;2\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020\b0`H&JH\u0010h\u001a\u00020^2\b\b\u0002\u0010:\u001a\u00020;24\u0010Q\u001a0\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020Z\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\\0[\u0012\u0004\u0012\u00020N0aj\b\u0012\u0004\u0012\u00020\b`bH&J<\u0010h\u001a\u00020^2\b\b\u0002\u0010:\u001a\u00020;2(\u0010Q\u001a$\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\\0[\u0012\u0004\u0012\u00020N0Mj\b\u0012\u0004\u0012\u00020\b`cH&J\u0019\u0010i\u001a\u00020\u00002\u0006\u0010/\u001a\u00020\b2\u0006\u00100\u001a\u00020\u001dH¦\u0002J\u001d\u0010i\u001a\u00020\u00002\u0006\u0010/\u001a\u00020\b2\n\u00101\u001a\u0006\u0012\u0002\b\u00030CH¦\u0002J\u0010\u0010j\u001a\u00020\u00002\u0006\u0010k\u001a\u00020\u001dH&J\u0010\u0010l\u001a\u00020\u00002\u0006\u0010l\u001a\u00020mH&J\u0010\u0010n\u001a\u00020\u00002\u0006\u0010l\u001a\u00020mH&J\b\u0010o\u001a\u00020\bH&J\u0010\u0010p\u001a\u00020\u00002\u0006\u0010p\u001a\u00020*H&J \u0010q\u001a\u00020\u00002\u0016\u0010r\u001a\u0012\u0012\u0004\u0012\u00020Z\u0012\u0004\u0012\u00020*0Mj\u0002`sH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\"\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00000\u0007j\u0002`\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\f\u001a\u00020\rX¦\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0012\u001a\u00020\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0012\u0010\u0016\u001a\u00020\u0017X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R0\u0010\u001a\u001a\u001a\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u001c0\u001bj\u0002`\u001eX¦\u000e¢\u0006\f\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0018\u0010#\u001a\u00020$X¦\u000e¢\u0006\f\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u0006t"}, d2 = {"Lcom/github/kittinunf/fuel/core/Request;", "Lcom/github/kittinunf/fuel/core/RequestFactory$RequestConvertible;", "body", "Lcom/github/kittinunf/fuel/core/Body;", "getBody", "()Lcom/github/kittinunf/fuel/core/Body;", "enabledFeatures", "", "", "Lcom/github/kittinunf/fuel/core/RequestFeatures;", "getEnabledFeatures", "()Ljava/util/Map;", "executionOptions", "Lcom/github/kittinunf/fuel/core/RequestExecutionOptions;", "getExecutionOptions", "()Lcom/github/kittinunf/fuel/core/RequestExecutionOptions;", "setExecutionOptions", "(Lcom/github/kittinunf/fuel/core/RequestExecutionOptions;)V", "headers", "Lcom/github/kittinunf/fuel/core/Headers;", "getHeaders", "()Lcom/github/kittinunf/fuel/core/Headers;", "method", "Lcom/github/kittinunf/fuel/core/Method;", "getMethod", "()Lcom/github/kittinunf/fuel/core/Method;", "parameters", "", "Lkotlin/Pair;", "", "Lcom/github/kittinunf/fuel/core/Parameters;", "getParameters", "()Ljava/util/List;", "setParameters", "(Ljava/util/List;)V", "url", "Ljava/net/URL;", "getUrl", "()Ljava/net/URL;", "setUrl", "(Ljava/net/URL;)V", "allowRedirects", "", "appendHeader", "pairs", "", "([Lkotlin/Pair;)Lcom/github/kittinunf/fuel/core/Request;", "header", "value", "values", "(Ljava/lang/String;[Ljava/lang/Object;)Lcom/github/kittinunf/fuel/core/Request;", "openStream", "Lkotlin/Function0;", "Ljava/io/InputStream;", "Lcom/github/kittinunf/fuel/core/BodySource;", "calculateLength", "", "Lcom/github/kittinunf/fuel/core/BodyLength;", "charset", "Ljava/nio/charset/Charset;", "repeatable", "file", "Ljava/io/File;", "stream", "bytes", "", "get", "", "Lcom/github/kittinunf/fuel/core/HeaderValues;", "getTag", ExifInterface.GPS_DIRECTION_TRUE, "clazz", "Lkotlin/reflect/KClass;", "(Lkotlin/reflect/KClass;)Ljava/lang/Object;", "map", "", "interrupt", "Lkotlin/Function1;", "", "Lcom/github/kittinunf/fuel/core/InterruptCallback;", "requestProgress", "handler", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "readBytes", "totalBytes", "Lcom/github/kittinunf/fuel/core/ProgressCallback;", "response", "Lkotlin/Triple;", "Lcom/github/kittinunf/fuel/core/Response;", "Lcom/github/kittinunf/result/Result;", "Lcom/github/kittinunf/fuel/core/FuelError;", "Lcom/github/kittinunf/fuel/core/ResponseResultOf;", "Lcom/github/kittinunf/fuel/core/requests/CancellableRequest;", "Lcom/github/kittinunf/fuel/core/Handler;", "Lcom/github/kittinunf/fuel/core/ResponseHandler;", "Lkotlin/Function3;", "Lcom/github/kittinunf/fuel/core/ResponseResultHandler;", "Lcom/github/kittinunf/fuel/core/ResultHandler;", "responseObject", "deserializer", "Lcom/github/kittinunf/fuel/core/ResponseDeserializable;", "responseProgress", "responseString", "set", "tag", "t", "timeout", "", "timeoutRead", "toString", "useHttpCache", "validate", "validator", "Lcom/github/kittinunf/fuel/core/ResponseValidator;", "fuel"}, k = 1, mv = {1, 4, 0})
public interface Request extends RequestFactory.RequestConvertible {
    Request allowRedirects(boolean allowRedirects);

    Request appendHeader(String header, Object value);

    Request appendHeader(String header, Object... values);

    Request appendHeader(Pair<String, ? extends Object>... pairs);

    Request body(Body body);

    Request body(File file, Charset charset);

    Request body(InputStream stream, Function0<Long> calculateLength, Charset charset, boolean repeatable);

    Request body(String body, Charset charset);

    Request body(Function0<? extends InputStream> openStream, Function0<Long> calculateLength, Charset charset, boolean repeatable);

    Request body(byte[] bytes, Charset charset);

    Collection<String> get(String header);

    Body getBody();

    Map<String, Request> getEnabledFeatures();

    RequestExecutionOptions getExecutionOptions();

    Headers getHeaders();

    Method getMethod();

    List<Pair<String, Object>> getParameters();

    <T> T getTag(KClass<T> clazz);

    URL getUrl();

    Request header(String header, Object value);

    Request header(String header, Collection<?> values);

    Request header(String header, Object... values);

    Request header(Map<String, ? extends Object> map);

    Request header(Pair<String, ? extends Object>... pairs);

    Collection<String> header(String header);

    Request interrupt(Function1<? super Request, Unit> interrupt);

    Request requestProgress(Function2<? super Long, ? super Long, Unit> handler);

    CancellableRequest response(Handler<? super byte[]> handler);

    CancellableRequest response(ResponseHandler<? super byte[]> handler);

    CancellableRequest response(Function1<? super Result<byte[], ? extends FuelError>, Unit> handler);

    CancellableRequest response(Function3<? super Request, ? super Response, ? super Result<byte[], ? extends FuelError>, Unit> handler);

    Triple<Request, Response, Result<byte[], FuelError>> response();

    <T> CancellableRequest responseObject(ResponseDeserializable<? extends T> deserializer, Handler<? super T> handler);

    <T> CancellableRequest responseObject(ResponseDeserializable<? extends T> deserializer, ResponseHandler<? super T> handler);

    <T> CancellableRequest responseObject(ResponseDeserializable<? extends T> deserializer, Function1<? super Result<? extends T, ? extends FuelError>, Unit> handler);

    <T> CancellableRequest responseObject(ResponseDeserializable<? extends T> deserializer, Function3<? super Request, ? super Response, ? super Result<? extends T, ? extends FuelError>, Unit> handler);

    <T> Triple<Request, Response, Result<T, FuelError>> responseObject(ResponseDeserializable<? extends T> deserializer);

    Request responseProgress(Function2<? super Long, ? super Long, Unit> handler);

    CancellableRequest responseString(Handler<? super String> handler);

    CancellableRequest responseString(ResponseHandler<? super String> handler);

    CancellableRequest responseString(Charset charset, Handler<? super String> handler);

    CancellableRequest responseString(Charset charset, ResponseHandler<? super String> handler);

    CancellableRequest responseString(Charset charset, Function1<? super Result<String, ? extends FuelError>, Unit> handler);

    CancellableRequest responseString(Charset charset, Function3<? super Request, ? super Response, ? super Result<String, ? extends FuelError>, Unit> handler);

    CancellableRequest responseString(Function1<? super Result<String, ? extends FuelError>, Unit> handler);

    CancellableRequest responseString(Function3<? super Request, ? super Response, ? super Result<String, ? extends FuelError>, Unit> handler);

    Triple<Request, Response, Result<String, FuelError>> responseString();

    Triple<Request, Response, Result<String, FuelError>> responseString(Charset charset);

    Request set(String header, Object value);

    Request set(String header, Collection<?> values);

    void setExecutionOptions(RequestExecutionOptions requestExecutionOptions);

    void setParameters(List<? extends Pair<String, ? extends Object>> list);

    void setUrl(URL url);

    Request tag(Object t);

    Request timeout(int timeout);

    Request timeoutRead(int timeout);

    String toString();

    Request useHttpCache(boolean useHttpCache);

    Request validate(Function1<? super Response, Boolean> validator);

    /* INFO: compiled from: Request.kt */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    public static final class DefaultImpls {
        public static /* synthetic */ CancellableRequest responseString$default(Request request, Charset charset, Function3 function3, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: responseString");
            }
            if ((i & 1) != 0) {
                charset = Charsets.UTF_8;
            }
            return request.responseString(charset, (Function3<? super Request, ? super Response, ? super Result<String, ? extends FuelError>, Unit>) function3);
        }

        public static /* synthetic */ CancellableRequest responseString$default(Request request, Charset charset, Function1 function1, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: responseString");
            }
            if ((i & 1) != 0) {
                charset = Charsets.UTF_8;
            }
            return request.responseString(charset, (Function1<? super Result<String, ? extends FuelError>, Unit>) function1);
        }

        public static /* synthetic */ CancellableRequest responseString$default(Request request, Charset charset, ResponseHandler responseHandler, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: responseString");
            }
            if ((i & 1) != 0) {
                charset = Charsets.UTF_8;
            }
            return request.responseString(charset, (ResponseHandler<? super String>) responseHandler);
        }

        public static /* synthetic */ CancellableRequest responseString$default(Request request, Charset charset, Handler handler, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: responseString");
            }
            if ((i & 1) != 0) {
                charset = Charsets.UTF_8;
            }
            return request.responseString(charset, (Handler<? super String>) handler);
        }

        public static /* synthetic */ Triple responseString$default(Request request, Charset charset, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: responseString");
            }
            if ((i & 1) != 0) {
                charset = Charsets.UTF_8;
            }
            return request.responseString(charset);
        }

        /* WARN: Multi-variable type inference failed */
        public static /* synthetic */ Request body$default(Request request, Function0 function0, Function0 function1, Charset charset, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: body");
            }
            if ((i & 2) != 0) {
                function1 = null;
            }
            if ((i & 4) != 0) {
                charset = Charsets.UTF_8;
            }
            if ((i & 8) != 0) {
                z = false;
            }
            return request.body((Function0<? extends InputStream>) function0, (Function0<Long>) function1, charset, z);
        }

        /* WARN: Multi-variable type inference failed */
        public static /* synthetic */ Request body$default(Request request, InputStream inputStream, Function0 function0, Charset charset, boolean z, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: body");
            }
            if ((i & 2) != 0) {
                function0 = null;
            }
            if ((i & 4) != 0) {
                charset = Charsets.UTF_8;
            }
            if ((i & 8) != 0) {
                z = false;
            }
            return request.body(inputStream, (Function0<Long>) function0, charset, z);
        }

        public static /* synthetic */ Request body$default(Request request, byte[] bArr, Charset charset, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: body");
            }
            if ((i & 2) != 0) {
                charset = Charsets.UTF_8;
            }
            return request.body(bArr, charset);
        }

        public static /* synthetic */ Request body$default(Request request, String str, Charset charset, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: body");
            }
            if ((i & 2) != 0) {
                charset = Charsets.UTF_8;
            }
            return request.body(str, charset);
        }

        public static /* synthetic */ Request body$default(Request request, File file, Charset charset, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: body");
            }
            if ((i & 2) != 0) {
                charset = Charsets.UTF_8;
            }
            return request.body(file, charset);
        }
    }
}
