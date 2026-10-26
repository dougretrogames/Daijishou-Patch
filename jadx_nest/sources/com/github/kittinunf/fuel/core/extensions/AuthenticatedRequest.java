package com.github.kittinunf.fuel.core.extensions;

import androidx.exifinterface.media.ExifInterface;
import com.github.kittinunf.fuel.core.Body;
import com.github.kittinunf.fuel.core.FuelError;
import com.github.kittinunf.fuel.core.Handler;
import com.github.kittinunf.fuel.core.Headers;
import com.github.kittinunf.fuel.core.Method;
import com.github.kittinunf.fuel.core.Request;
import com.github.kittinunf.fuel.core.RequestExecutionOptions;
import com.github.kittinunf.fuel.core.Response;
import com.github.kittinunf.fuel.core.ResponseDeserializable;
import com.github.kittinunf.fuel.core.ResponseHandler;
import com.github.kittinunf.fuel.core.requests.CancellableRequest;
import com.github.kittinunf.fuel.util.Base64Kt;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* INFO: compiled from: Authentication.kt */
/* INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0098\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\u0011\u0010.\u001a\u00020\u00012\u0006\u0010.\u001a\u00020/H\u0096\u0001J:\u00100\u001a\u00020\u00012*\u00101\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u001f0\u001e02\"\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u001f0\u001eH\u0096\u0001¢\u0006\u0002\u00103J\u0019\u00100\u001a\u00020\u00012\u0006\u00104\u001a\u00020\n2\u0006\u00105\u001a\u00020\u001fH\u0096\u0001J*\u00100\u001a\u00020\u00012\u0006\u00104\u001a\u00020\n2\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001f02\"\u00020\u001fH\u0096\u0001¢\u0006\u0002\u00107J\u0016\u00108\u001a\u00020\u00012\u0006\u00109\u001a\u00020\n2\u0006\u0010:\u001a\u00020\nJ\u000e\u0010;\u001a\u00020\u00012\u0006\u0010<\u001a\u00020\nJ\u0011\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\u0096\u0001JG\u0010\u0004\u001a\u00020\u00012\u0010\u0010=\u001a\f\u0012\u0004\u0012\u00020?0>j\u0002`@2\u0016\b\u0002\u0010A\u001a\u0010\u0012\u0004\u0012\u00020B\u0018\u00010>j\u0004\u0018\u0001`C2\b\b\u0002\u0010D\u001a\u00020E2\b\b\u0002\u0010F\u001a\u00020/H\u0096\u0001J\u001b\u0010\u0004\u001a\u00020\u00012\u0006\u0010G\u001a\u00020H2\b\b\u0002\u0010D\u001a\u00020EH\u0096\u0001J=\u0010\u0004\u001a\u00020\u00012\u0006\u0010I\u001a\u00020?2\u0016\b\u0002\u0010A\u001a\u0010\u0012\u0004\u0012\u00020B\u0018\u00010>j\u0004\u0018\u0001`C2\b\b\u0002\u0010D\u001a\u00020E2\b\b\u0002\u0010F\u001a\u00020/H\u0096\u0001J\u001b\u0010\u0004\u001a\u00020\u00012\u0006\u0010J\u001a\u00020K2\b\b\u0002\u0010D\u001a\u00020EH\u0096\u0001J\u001b\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\n2\b\b\u0002\u0010D\u001a\u00020EH\u0096\u0001J\u001b\u0010L\u001a\f\u0012\u0004\u0012\u00020\n0Mj\u0002`N2\u0006\u00104\u001a\u00020\nH\u0096\u0003J(\u0010O\u001a\u0004\u0018\u0001HP\"\b\b\u0000\u0010P*\u00020\u001f2\f\u0010Q\u001a\b\u0012\u0004\u0012\u0002HP0RH\u0096\u0001¢\u0006\u0002\u0010SJ:\u00104\u001a\u00020\u00012*\u00101\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u001f0\u001e02\"\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u001f0\u001eH\u0096\u0001¢\u0006\u0002\u00103J\u001b\u00104\u001a\f\u0012\u0004\u0012\u00020\n0Mj\u0002`N2\u0006\u00104\u001a\u00020\nH\u0096\u0001J\u0019\u00104\u001a\u00020\u00012\u0006\u00104\u001a\u00020\n2\u0006\u00105\u001a\u00020\u001fH\u0096\u0001J*\u00104\u001a\u00020\u00012\u0006\u00104\u001a\u00020\n2\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u001f02\"\u00020\u001fH\u0096\u0001¢\u0006\u0002\u00107J\u001d\u00104\u001a\u00020\u00012\u0006\u00104\u001a\u00020\n2\n\u00106\u001a\u0006\u0012\u0002\b\u00030MH\u0096\u0001J\u001d\u00104\u001a\u00020\u00012\u0012\u0010T\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u001f0UH\u0096\u0001J!\u0010V\u001a\u00020\u00012\u0016\u0010V\u001a\u0012\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020X0Wj\u0002`YH\u0096\u0001JE\u0010Z\u001a\u00020\u00012:\u0010[\u001a6\u0012\u0013\u0012\u00110B¢\u0006\f\b]\u0012\b\b^\u0012\u0004\b\b(_\u0012\u0013\u0012\u00110B¢\u0006\f\b]\u0012\b\b^\u0012\u0004\b\b(`\u0012\u0004\u0012\u00020X0\\j\u0002`aH\u0096\u0001J1\u0010b\u001a*\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020d\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020K\u0012\u0004\u0012\u00020f0e0cj\b\u0012\u0004\u0012\u00020K`gH\u0096\u0001J\u0017\u0010b\u001a\u00020h2\f\u0010[\u001a\b\u0012\u0004\u0012\u00020K0iH\u0096\u0001J\u0017\u0010b\u001a\u00020h2\f\u0010[\u001a\b\u0012\u0004\u0012\u00020K0jH\u0096\u0001J?\u0010b\u001a\u00020h24\u0010[\u001a0\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020d\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020K\u0012\u0004\u0012\u00020f0e\u0012\u0004\u0012\u00020X0kj\b\u0012\u0004\u0012\u00020K`lH\u0096\u0001J3\u0010b\u001a\u00020h2(\u0010[\u001a$\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020K\u0012\u0004\u0012\u00020f0e\u0012\u0004\u0012\u00020X0Wj\b\u0012\u0004\u0012\u00020K`mH\u0096\u0001JI\u0010n\u001a*\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020d\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002HP\u0012\u0004\u0012\u00020f0e0cj\b\u0012\u0004\u0012\u0002HP`g\"\b\b\u0000\u0010P*\u00020\u001f2\f\u0010o\u001a\b\u0012\u0004\u0012\u0002HP0pH\u0096\u0001J/\u0010n\u001a\u00020h\"\b\b\u0000\u0010P*\u00020\u001f2\f\u0010o\u001a\b\u0012\u0004\u0012\u0002HP0p2\f\u0010[\u001a\b\u0012\u0004\u0012\u0002HP0iH\u0096\u0001J/\u0010n\u001a\u00020h\"\b\b\u0000\u0010P*\u00020\u001f2\f\u0010o\u001a\b\u0012\u0004\u0012\u0002HP0p2\f\u0010[\u001a\b\u0012\u0004\u0012\u0002HP0jH\u0096\u0001JW\u0010n\u001a\u00020h\"\b\b\u0000\u0010P*\u00020\u001f2\f\u0010o\u001a\b\u0012\u0004\u0012\u0002HP0p24\u0010[\u001a0\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020d\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002HP\u0012\u0004\u0012\u00020f0e\u0012\u0004\u0012\u00020X0kj\b\u0012\u0004\u0012\u0002HP`lH\u0096\u0001JK\u0010n\u001a\u00020h\"\b\b\u0000\u0010P*\u00020\u001f2\f\u0010o\u001a\b\u0012\u0004\u0012\u0002HP0p2(\u0010[\u001a$\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002HP\u0012\u0004\u0012\u00020f0e\u0012\u0004\u0012\u00020X0Wj\b\u0012\u0004\u0012\u0002HP`mH\u0096\u0001JE\u0010q\u001a\u00020\u00012:\u0010[\u001a6\u0012\u0013\u0012\u00110B¢\u0006\f\b]\u0012\b\b^\u0012\u0004\b\b(_\u0012\u0013\u0012\u00110B¢\u0006\f\b]\u0012\b\b^\u0012\u0004\b\b(`\u0012\u0004\u0012\u00020X0\\j\u0002`aH\u0096\u0001J1\u0010r\u001a*\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020d\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020f0e0cj\b\u0012\u0004\u0012\u00020\n`gH\u0096\u0001J\u0017\u0010r\u001a\u00020h2\f\u0010[\u001a\b\u0012\u0004\u0012\u00020\n0iH\u0096\u0001J\u0017\u0010r\u001a\u00020h2\f\u0010[\u001a\b\u0012\u0004\u0012\u00020\n0jH\u0096\u0001J?\u0010r\u001a\u00020h24\u0010[\u001a0\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020d\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020f0e\u0012\u0004\u0012\u00020X0kj\b\u0012\u0004\u0012\u00020\n`lH\u0096\u0001J3\u0010r\u001a\u00020h2(\u0010[\u001a$\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020f0e\u0012\u0004\u0012\u00020X0Wj\b\u0012\u0004\u0012\u00020\n`mH\u0096\u0001J;\u0010r\u001a*\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020d\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020f0e0cj\b\u0012\u0004\u0012\u00020\n`g2\b\b\u0002\u0010D\u001a\u00020EH\u0096\u0001J!\u0010r\u001a\u00020h2\b\b\u0002\u0010D\u001a\u00020E2\f\u0010[\u001a\b\u0012\u0004\u0012\u00020\n0iH\u0096\u0001J!\u0010r\u001a\u00020h2\b\b\u0002\u0010D\u001a\u00020E2\f\u0010[\u001a\b\u0012\u0004\u0012\u00020\n0jH\u0096\u0001JI\u0010r\u001a\u00020h2\b\b\u0002\u0010D\u001a\u00020E24\u0010[\u001a0\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020d\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020f0e\u0012\u0004\u0012\u00020X0kj\b\u0012\u0004\u0012\u00020\n`lH\u0096\u0001J=\u0010r\u001a\u00020h2\b\b\u0002\u0010D\u001a\u00020E2(\u0010[\u001a$\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020f0e\u0012\u0004\u0012\u00020X0Wj\b\u0012\u0004\u0012\u00020\n`mH\u0096\u0001J\u0019\u0010s\u001a\u00020\u00012\u0006\u00104\u001a\u00020\n2\u0006\u00105\u001a\u00020\u001fH\u0096\u0003J\u001d\u0010s\u001a\u00020\u00012\u0006\u00104\u001a\u00020\n2\n\u00106\u001a\u0006\u0012\u0002\b\u00030MH\u0096\u0003J\u0011\u0010t\u001a\u00020\u00012\u0006\u0010u\u001a\u00020\u001fH\u0096\u0001J\u0011\u0010v\u001a\u00020\u00012\u0006\u0010v\u001a\u00020wH\u0096\u0001J\u0011\u0010x\u001a\u00020\u00012\u0006\u0010v\u001a\u00020wH\u0096\u0001J\t\u0010y\u001a\u00020\nH\u0096\u0001J\u0011\u0010z\u001a\u00020\u00012\u0006\u0010z\u001a\u00020/H\u0096\u0001J!\u0010{\u001a\u00020\u00012\u0016\u0010|\u001a\u0012\u0012\u0004\u0012\u00020d\u0012\u0004\u0012\u00020/0Wj\u0002`}H\u0096\u0001R\u0012\u0010\u0004\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\"\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\tj\u0002`\u000bX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0018\u0010\u000e\u001a\u00020\u000fX\u0096\u000f¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0012\u0010\u0014\u001a\u00020\u0015X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0012\u0010\u0018\u001a\u00020\u0019X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR0\u0010\u001c\u001a\u001a\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\n\u0012\u0006\u0012\u0004\u0018\u00010\u001f0\u001e0\u001dj\u0002` X\u0096\u000f¢\u0006\f\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0014\u0010%\u001a\u00020\u0000X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0018\u0010(\u001a\u00020)X\u0096\u000f¢\u0006\f\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006~"}, d2 = {"Lcom/github/kittinunf/fuel/core/extensions/AuthenticatedRequest;", "Lcom/github/kittinunf/fuel/core/Request;", "wrapped", "(Lcom/github/kittinunf/fuel/core/Request;)V", "body", "Lcom/github/kittinunf/fuel/core/Body;", "getBody", "()Lcom/github/kittinunf/fuel/core/Body;", "enabledFeatures", "", "", "Lcom/github/kittinunf/fuel/core/RequestFeatures;", "getEnabledFeatures", "()Ljava/util/Map;", "executionOptions", "Lcom/github/kittinunf/fuel/core/RequestExecutionOptions;", "getExecutionOptions", "()Lcom/github/kittinunf/fuel/core/RequestExecutionOptions;", "setExecutionOptions", "(Lcom/github/kittinunf/fuel/core/RequestExecutionOptions;)V", "headers", "Lcom/github/kittinunf/fuel/core/Headers;", "getHeaders", "()Lcom/github/kittinunf/fuel/core/Headers;", "method", "Lcom/github/kittinunf/fuel/core/Method;", "getMethod", "()Lcom/github/kittinunf/fuel/core/Method;", "parameters", "", "Lkotlin/Pair;", "", "Lcom/github/kittinunf/fuel/core/Parameters;", "getParameters", "()Ljava/util/List;", "setParameters", "(Ljava/util/List;)V", "request", "getRequest", "()Lcom/github/kittinunf/fuel/core/extensions/AuthenticatedRequest;", "url", "Ljava/net/URL;", "getUrl", "()Ljava/net/URL;", "setUrl", "(Ljava/net/URL;)V", "allowRedirects", "", "appendHeader", "pairs", "", "([Lkotlin/Pair;)Lcom/github/kittinunf/fuel/core/Request;", "header", "value", "values", "(Ljava/lang/String;[Ljava/lang/Object;)Lcom/github/kittinunf/fuel/core/Request;", "basic", "username", "password", "bearer", "token", "openStream", "Lkotlin/Function0;", "Ljava/io/InputStream;", "Lcom/github/kittinunf/fuel/core/BodySource;", "calculateLength", "", "Lcom/github/kittinunf/fuel/core/BodyLength;", "charset", "Ljava/nio/charset/Charset;", "repeatable", "file", "Ljava/io/File;", "stream", "bytes", "", "get", "", "Lcom/github/kittinunf/fuel/core/HeaderValues;", "getTag", ExifInterface.GPS_DIRECTION_TRUE, "clazz", "Lkotlin/reflect/KClass;", "(Lkotlin/reflect/KClass;)Ljava/lang/Object;", "map", "", "interrupt", "Lkotlin/Function1;", "", "Lcom/github/kittinunf/fuel/core/InterruptCallback;", "requestProgress", "handler", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "readBytes", "totalBytes", "Lcom/github/kittinunf/fuel/core/ProgressCallback;", "response", "Lkotlin/Triple;", "Lcom/github/kittinunf/fuel/core/Response;", "Lcom/github/kittinunf/result/Result;", "Lcom/github/kittinunf/fuel/core/FuelError;", "Lcom/github/kittinunf/fuel/core/ResponseResultOf;", "Lcom/github/kittinunf/fuel/core/requests/CancellableRequest;", "Lcom/github/kittinunf/fuel/core/Handler;", "Lcom/github/kittinunf/fuel/core/ResponseHandler;", "Lkotlin/Function3;", "Lcom/github/kittinunf/fuel/core/ResponseResultHandler;", "Lcom/github/kittinunf/fuel/core/ResultHandler;", "responseObject", "deserializer", "Lcom/github/kittinunf/fuel/core/ResponseDeserializable;", "responseProgress", "responseString", "set", "tag", "t", "timeout", "", "timeoutRead", "toString", "useHttpCache", "validate", "validator", "Lcom/github/kittinunf/fuel/core/ResponseValidator;", "fuel"}, k = 1, mv = {1, 4, 0})
public final class AuthenticatedRequest implements Request {
    private final AuthenticatedRequest request;
    private final Request wrapped;

    @Override // com.github.kittinunf.fuel.core.Request
    public Request allowRedirects(boolean allowRedirects) {
        return this.wrapped.allowRedirects(allowRedirects);
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public Request appendHeader(String header, Object value) {
        Intrinsics.checkNotNullParameter(header, "header");
        Intrinsics.checkNotNullParameter(value, "value");
        return this.wrapped.appendHeader(header, value);
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public Request appendHeader(String header, Object... values) {
        Intrinsics.checkNotNullParameter(header, "header");
        Intrinsics.checkNotNullParameter(values, "values");
        return this.wrapped.appendHeader(header, values);
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public Request appendHeader(Pair<String, ? extends Object>... pairs) {
        Intrinsics.checkNotNullParameter(pairs, "pairs");
        return this.wrapped.appendHeader(pairs);
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public Request body(Body body) {
        Intrinsics.checkNotNullParameter(body, "body");
        return this.wrapped.body(body);
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public Request body(File file, Charset charset) {
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(charset, "charset");
        return this.wrapped.body(file, charset);
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public Request body(InputStream stream, Function0<Long> calculateLength, Charset charset, boolean repeatable) {
        Intrinsics.checkNotNullParameter(stream, "stream");
        Intrinsics.checkNotNullParameter(charset, "charset");
        return this.wrapped.body(stream, calculateLength, charset, repeatable);
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public Request body(String body, Charset charset) {
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.checkNotNullParameter(charset, "charset");
        return this.wrapped.body(body, charset);
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public Request body(Function0<? extends InputStream> openStream, Function0<Long> calculateLength, Charset charset, boolean repeatable) {
        Intrinsics.checkNotNullParameter(openStream, "openStream");
        Intrinsics.checkNotNullParameter(charset, "charset");
        return this.wrapped.body(openStream, calculateLength, charset, repeatable);
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public Request body(byte[] bytes, Charset charset) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        Intrinsics.checkNotNullParameter(charset, "charset");
        return this.wrapped.body(bytes, charset);
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public Collection<String> get(String header) {
        Intrinsics.checkNotNullParameter(header, "header");
        return this.wrapped.get(header);
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public Body getBody() {
        return this.wrapped.getBody();
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public Map<String, Request> getEnabledFeatures() {
        return this.wrapped.getEnabledFeatures();
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public RequestExecutionOptions getExecutionOptions() {
        return this.wrapped.getExecutionOptions();
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public Headers getHeaders() {
        return this.wrapped.getHeaders();
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public Method getMethod() {
        return this.wrapped.getMethod();
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public List<Pair<String, Object>> getParameters() {
        return this.wrapped.getParameters();
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public <T> T getTag(KClass<T> clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        return (T) this.wrapped.getTag(clazz);
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public URL getUrl() {
        return this.wrapped.getUrl();
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public Request header(String header, Object value) {
        Intrinsics.checkNotNullParameter(header, "header");
        Intrinsics.checkNotNullParameter(value, "value");
        return this.wrapped.header(header, value);
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public Request header(String header, Collection<?> values) {
        Intrinsics.checkNotNullParameter(header, "header");
        Intrinsics.checkNotNullParameter(values, "values");
        return this.wrapped.header(header, values);
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public Request header(String header, Object... values) {
        Intrinsics.checkNotNullParameter(header, "header");
        Intrinsics.checkNotNullParameter(values, "values");
        return this.wrapped.header(header, values);
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public Request header(Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "map");
        return this.wrapped.header(map);
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public Request header(Pair<String, ? extends Object>... pairs) {
        Intrinsics.checkNotNullParameter(pairs, "pairs");
        return this.wrapped.header(pairs);
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public Collection<String> header(String header) {
        Intrinsics.checkNotNullParameter(header, "header");
        return this.wrapped.header(header);
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public Request interrupt(Function1<? super Request, Unit> interrupt) {
        Intrinsics.checkNotNullParameter(interrupt, "interrupt");
        return this.wrapped.interrupt(interrupt);
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public Request requestProgress(Function2<? super Long, ? super Long, Unit> handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        return this.wrapped.requestProgress(handler);
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public CancellableRequest response(Handler<? super byte[]> handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        return this.wrapped.response(handler);
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public CancellableRequest response(ResponseHandler<? super byte[]> handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        return this.wrapped.response(handler);
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public CancellableRequest response(Function1<? super Result<byte[], ? extends FuelError>, Unit> handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        return this.wrapped.response(handler);
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public CancellableRequest response(Function3<? super Request, ? super Response, ? super Result<byte[], ? extends FuelError>, Unit> handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        return this.wrapped.response(handler);
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public Triple<Request, Response, Result<byte[], FuelError>> response() {
        return this.wrapped.response();
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public <T> CancellableRequest responseObject(ResponseDeserializable<? extends T> deserializer, Handler<? super T> handler) {
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
        Intrinsics.checkNotNullParameter(handler, "handler");
        return this.wrapped.responseObject(deserializer, handler);
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public <T> CancellableRequest responseObject(ResponseDeserializable<? extends T> deserializer, ResponseHandler<? super T> handler) {
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
        Intrinsics.checkNotNullParameter(handler, "handler");
        return this.wrapped.responseObject(deserializer, handler);
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public <T> CancellableRequest responseObject(ResponseDeserializable<? extends T> deserializer, Function1<? super Result<? extends T, ? extends FuelError>, Unit> handler) {
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
        Intrinsics.checkNotNullParameter(handler, "handler");
        return this.wrapped.responseObject(deserializer, handler);
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public <T> CancellableRequest responseObject(ResponseDeserializable<? extends T> deserializer, Function3<? super Request, ? super Response, ? super Result<? extends T, ? extends FuelError>, Unit> handler) {
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
        Intrinsics.checkNotNullParameter(handler, "handler");
        return this.wrapped.responseObject(deserializer, handler);
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public <T> Triple<Request, Response, Result<T, FuelError>> responseObject(ResponseDeserializable<? extends T> deserializer) {
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
        return this.wrapped.responseObject(deserializer);
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public Request responseProgress(Function2<? super Long, ? super Long, Unit> handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        return this.wrapped.responseProgress(handler);
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public CancellableRequest responseString(Handler<? super String> handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        return this.wrapped.responseString(handler);
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public CancellableRequest responseString(ResponseHandler<? super String> handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        return this.wrapped.responseString(handler);
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public CancellableRequest responseString(Charset charset, Handler<? super String> handler) {
        Intrinsics.checkNotNullParameter(charset, "charset");
        Intrinsics.checkNotNullParameter(handler, "handler");
        return this.wrapped.responseString(charset, handler);
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public CancellableRequest responseString(Charset charset, ResponseHandler<? super String> handler) {
        Intrinsics.checkNotNullParameter(charset, "charset");
        Intrinsics.checkNotNullParameter(handler, "handler");
        return this.wrapped.responseString(charset, handler);
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public CancellableRequest responseString(Charset charset, Function1<? super Result<String, ? extends FuelError>, Unit> handler) {
        Intrinsics.checkNotNullParameter(charset, "charset");
        Intrinsics.checkNotNullParameter(handler, "handler");
        return this.wrapped.responseString(charset, handler);
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public CancellableRequest responseString(Charset charset, Function3<? super Request, ? super Response, ? super Result<String, ? extends FuelError>, Unit> handler) {
        Intrinsics.checkNotNullParameter(charset, "charset");
        Intrinsics.checkNotNullParameter(handler, "handler");
        return this.wrapped.responseString(charset, handler);
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public CancellableRequest responseString(Function1<? super Result<String, ? extends FuelError>, Unit> handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        return this.wrapped.responseString(handler);
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public CancellableRequest responseString(Function3<? super Request, ? super Response, ? super Result<String, ? extends FuelError>, Unit> handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        return this.wrapped.responseString(handler);
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public Triple<Request, Response, Result<String, FuelError>> responseString() {
        return this.wrapped.responseString();
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public Triple<Request, Response, Result<String, FuelError>> responseString(Charset charset) {
        Intrinsics.checkNotNullParameter(charset, "charset");
        return this.wrapped.responseString(charset);
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public Request set(String header, Object value) {
        Intrinsics.checkNotNullParameter(header, "header");
        Intrinsics.checkNotNullParameter(value, "value");
        return this.wrapped.set(header, value);
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public Request set(String header, Collection<?> values) {
        Intrinsics.checkNotNullParameter(header, "header");
        Intrinsics.checkNotNullParameter(values, "values");
        return this.wrapped.set(header, values);
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public void setExecutionOptions(RequestExecutionOptions requestExecutionOptions) {
        Intrinsics.checkNotNullParameter(requestExecutionOptions, "<set-?>");
        this.wrapped.setExecutionOptions(requestExecutionOptions);
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public void setParameters(List<? extends Pair<String, ? extends Object>> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.wrapped.setParameters(list);
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public void setUrl(URL url) {
        Intrinsics.checkNotNullParameter(url, "<set-?>");
        this.wrapped.setUrl(url);
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public Request tag(Object t) {
        Intrinsics.checkNotNullParameter(t, "t");
        return this.wrapped.tag(t);
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public Request timeout(int timeout) {
        return this.wrapped.timeout(timeout);
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public Request timeoutRead(int timeout) {
        return this.wrapped.timeoutRead(timeout);
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public String toString() {
        return this.wrapped.toString();
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public Request useHttpCache(boolean useHttpCache) {
        return this.wrapped.useHttpCache(useHttpCache);
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public Request validate(Function1<? super Response, Boolean> validator) {
        Intrinsics.checkNotNullParameter(validator, "validator");
        return this.wrapped.validate(validator);
    }

    public AuthenticatedRequest(Request wrapped) {
        Intrinsics.checkNotNullParameter(wrapped, "wrapped");
        this.wrapped = wrapped;
        this.request = this;
    }

    @Override // com.github.kittinunf.fuel.core.RequestFactory.RequestConvertible
    public AuthenticatedRequest getRequest() {
        return this.request;
    }

    public final Request basic(String username, String password) {
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(password, "password");
        set("Authorization", "Basic " + Base64Kt.encodeBase64ToString(username + AbstractJsonLexerKt.COLON + password));
        return getRequest();
    }

    public final Request bearer(String token) {
        Intrinsics.checkNotNullParameter(token, "token");
        set("Authorization", "Bearer " + token);
        return getRequest();
    }
}
