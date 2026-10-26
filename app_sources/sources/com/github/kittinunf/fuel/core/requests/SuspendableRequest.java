package com.github.kittinunf.fuel.core.requests;

import androidx.exifinterface.media.ExifInterface;
import com.github.kittinunf.fuel.Fuel;
import com.github.kittinunf.fuel.core.Body;
import com.github.kittinunf.fuel.core.Client;
import com.github.kittinunf.fuel.core.FuelError;
import com.github.kittinunf.fuel.core.Handler;
import com.github.kittinunf.fuel.core.Headers;
import com.github.kittinunf.fuel.core.HttpException;
import com.github.kittinunf.fuel.core.Method;
import com.github.kittinunf.fuel.core.Request;
import com.github.kittinunf.fuel.core.RequestExecutionOptions;
import com.github.kittinunf.fuel.core.Response;
import com.github.kittinunf.fuel.core.ResponseDeserializable;
import com.github.kittinunf.fuel.core.ResponseHandler;
import com.github.kittinunf.result.Result;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* INFO: compiled from: SuspendableRequest.kt */
/* INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¬\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u008e\u00012\u00020\u0001:\u0002\u008e\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\u0011\u0010>\u001a\u00020\u00012\u0006\u0010>\u001a\u00020?H\u0096\u0001J:\u0010@\u001a\u00020\u00012*\u0010A\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020/0.0B\"\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020/0.H\u0096\u0001¢\u0006\u0002\u0010CJ\u0019\u0010@\u001a\u00020\u00012\u0006\u0010D\u001a\u00020\u00102\u0006\u0010E\u001a\u00020/H\u0096\u0001J*\u0010@\u001a\u00020\u00012\u0006\u0010D\u001a\u00020\u00102\u0012\u0010F\u001a\n\u0012\u0006\b\u0001\u0012\u00020/0B\"\u00020/H\u0096\u0001¢\u0006\u0002\u0010GJ\u0011\u0010H\u001a\u00020IH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010JJ\u001d\u0010K\u001a\u000e\u0012\u0004\u0012\u00020I\u0012\u0004\u0012\u00020M0LH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010JJ\u0011\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\u0096\u0001JG\u0010\u0004\u001a\u00020\u00012\u0010\u0010N\u001a\f\u0012\u0004\u0012\u00020P0Oj\u0002`Q2\u0016\b\u0002\u0010R\u001a\u0010\u0012\u0004\u0012\u00020S\u0018\u00010Oj\u0004\u0018\u0001`T2\b\b\u0002\u0010U\u001a\u00020V2\b\b\u0002\u0010W\u001a\u00020?H\u0096\u0001J\u001b\u0010\u0004\u001a\u00020\u00012\u0006\u0010X\u001a\u00020Y2\b\b\u0002\u0010U\u001a\u00020VH\u0096\u0001J=\u0010\u0004\u001a\u00020\u00012\u0006\u0010Z\u001a\u00020P2\u0016\b\u0002\u0010R\u001a\u0010\u0012\u0004\u0012\u00020S\u0018\u00010Oj\u0004\u0018\u0001`T2\b\b\u0002\u0010U\u001a\u00020V2\b\b\u0002\u0010W\u001a\u00020?H\u0096\u0001J\u001b\u0010\u0004\u001a\u00020\u00012\u0006\u0010[\u001a\u00020\\2\b\b\u0002\u0010U\u001a\u00020VH\u0096\u0001J\u001b\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00102\b\b\u0002\u0010U\u001a\u00020VH\u0096\u0001J%\u0010]\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020I0.2\u0006\u00105\u001a\u00020\u0001H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010^J\u001b\u0010_\u001a\f\u0012\u0004\u0012\u00020\u00100`j\u0002`a2\u0006\u0010D\u001a\u00020\u0010H\u0096\u0003J(\u0010b\u001a\u0004\u0018\u0001Hc\"\b\b\u0000\u0010c*\u00020/2\f\u0010d\u001a\b\u0012\u0004\u0012\u0002Hc0eH\u0096\u0001¢\u0006\u0002\u0010fJ:\u0010D\u001a\u00020\u00012*\u0010A\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020/0.0B\"\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020/0.H\u0096\u0001¢\u0006\u0002\u0010CJ\u001b\u0010D\u001a\f\u0012\u0004\u0012\u00020\u00100`j\u0002`a2\u0006\u0010D\u001a\u00020\u0010H\u0096\u0001J\u0019\u0010D\u001a\u00020\u00012\u0006\u0010D\u001a\u00020\u00102\u0006\u0010E\u001a\u00020/H\u0096\u0001J*\u0010D\u001a\u00020\u00012\u0006\u0010D\u001a\u00020\u00102\u0012\u0010F\u001a\n\u0012\u0006\b\u0001\u0012\u00020/0B\"\u00020/H\u0096\u0001¢\u0006\u0002\u0010GJ\u001d\u0010D\u001a\u00020\u00012\u0006\u0010D\u001a\u00020\u00102\n\u0010F\u001a\u0006\u0012\u0002\b\u00030`H\u0096\u0001J\u001d\u0010D\u001a\u00020\u00012\u0012\u0010g\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020/0hH\u0096\u0001J!\u0010i\u001a\u00020\u00012\u0016\u0010i\u001a\u0012\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020#0\"j\u0002`$H\u0096\u0001J\u0010\u0010j\u001a\u00020\u00012\u0006\u00105\u001a\u00020\u0001H\u0002J\u001c\u0010k\u001a\u00020I2\u0012\u0010l\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020I0.H\u0002JE\u0010m\u001a\u00020\u00012:\u0010n\u001a6\u0012\u0013\u0012\u00110S¢\u0006\f\bp\u0012\b\bq\u0012\u0004\b\b(r\u0012\u0013\u0012\u00110S¢\u0006\f\bp\u0012\b\bq\u0012\u0004\b\b(s\u0012\u0004\u0012\u00020#0oj\u0002`tH\u0096\u0001J1\u0010u\u001a*\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020I\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\\\u0012\u0004\u0012\u00020M0L0vj\b\u0012\u0004\u0012\u00020\\`wH\u0096\u0001J\u0017\u0010u\u001a\u00020x2\f\u0010n\u001a\b\u0012\u0004\u0012\u00020\\0yH\u0096\u0001J\u0017\u0010u\u001a\u00020x2\f\u0010n\u001a\b\u0012\u0004\u0012\u00020\\0zH\u0096\u0001J?\u0010u\u001a\u00020x24\u0010n\u001a0\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020I\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\\\u0012\u0004\u0012\u00020M0L\u0012\u0004\u0012\u00020#0{j\b\u0012\u0004\u0012\u00020\\`|H\u0096\u0001J3\u0010u\u001a\u00020x2(\u0010n\u001a$\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\\\u0012\u0004\u0012\u00020M0L\u0012\u0004\u0012\u00020#0\"j\b\u0012\u0004\u0012\u00020\\`}H\u0096\u0001JJ\u0010~\u001a*\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020I\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002Hc\u0012\u0004\u0012\u00020M0L0vj\b\u0012\u0004\u0012\u0002Hc`w\"\b\b\u0000\u0010c*\u00020/2\r\u0010\u007f\u001a\t\u0012\u0004\u0012\u0002Hc0\u0080\u0001H\u0096\u0001J0\u0010~\u001a\u00020x\"\b\b\u0000\u0010c*\u00020/2\r\u0010\u007f\u001a\t\u0012\u0004\u0012\u0002Hc0\u0080\u00012\f\u0010n\u001a\b\u0012\u0004\u0012\u0002Hc0yH\u0096\u0001J0\u0010~\u001a\u00020x\"\b\b\u0000\u0010c*\u00020/2\r\u0010\u007f\u001a\t\u0012\u0004\u0012\u0002Hc0\u0080\u00012\f\u0010n\u001a\b\u0012\u0004\u0012\u0002Hc0zH\u0096\u0001JX\u0010~\u001a\u00020x\"\b\b\u0000\u0010c*\u00020/2\r\u0010\u007f\u001a\t\u0012\u0004\u0012\u0002Hc0\u0080\u000124\u0010n\u001a0\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020I\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002Hc\u0012\u0004\u0012\u00020M0L\u0012\u0004\u0012\u00020#0{j\b\u0012\u0004\u0012\u0002Hc`|H\u0096\u0001JL\u0010~\u001a\u00020x\"\b\b\u0000\u0010c*\u00020/2\r\u0010\u007f\u001a\t\u0012\u0004\u0012\u0002Hc0\u0080\u00012(\u0010n\u001a$\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002Hc\u0012\u0004\u0012\u00020M0L\u0012\u0004\u0012\u00020#0\"j\b\u0012\u0004\u0012\u0002Hc`}H\u0096\u0001JF\u0010\u0081\u0001\u001a\u00020\u00012:\u0010n\u001a6\u0012\u0013\u0012\u00110S¢\u0006\f\bp\u0012\b\bq\u0012\u0004\b\b(r\u0012\u0013\u0012\u00110S¢\u0006\f\bp\u0012\b\bq\u0012\u0004\b\b(s\u0012\u0004\u0012\u00020#0oj\u0002`tH\u0096\u0001J2\u0010\u0082\u0001\u001a*\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020I\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020M0L0vj\b\u0012\u0004\u0012\u00020\u0010`wH\u0096\u0001J\u0018\u0010\u0082\u0001\u001a\u00020x2\f\u0010n\u001a\b\u0012\u0004\u0012\u00020\u00100yH\u0096\u0001J\u0018\u0010\u0082\u0001\u001a\u00020x2\f\u0010n\u001a\b\u0012\u0004\u0012\u00020\u00100zH\u0096\u0001J@\u0010\u0082\u0001\u001a\u00020x24\u0010n\u001a0\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020I\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020M0L\u0012\u0004\u0012\u00020#0{j\b\u0012\u0004\u0012\u00020\u0010`|H\u0096\u0001J4\u0010\u0082\u0001\u001a\u00020x2(\u0010n\u001a$\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020M0L\u0012\u0004\u0012\u00020#0\"j\b\u0012\u0004\u0012\u00020\u0010`}H\u0096\u0001J<\u0010\u0082\u0001\u001a*\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020I\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020M0L0vj\b\u0012\u0004\u0012\u00020\u0010`w2\b\b\u0002\u0010U\u001a\u00020VH\u0096\u0001J\"\u0010\u0082\u0001\u001a\u00020x2\b\b\u0002\u0010U\u001a\u00020V2\f\u0010n\u001a\b\u0012\u0004\u0012\u00020\u00100yH\u0096\u0001J\"\u0010\u0082\u0001\u001a\u00020x2\b\b\u0002\u0010U\u001a\u00020V2\f\u0010n\u001a\b\u0012\u0004\u0012\u00020\u00100zH\u0096\u0001JJ\u0010\u0082\u0001\u001a\u00020x2\b\b\u0002\u0010U\u001a\u00020V24\u0010n\u001a0\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020I\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020M0L\u0012\u0004\u0012\u00020#0{j\b\u0012\u0004\u0012\u00020\u0010`|H\u0096\u0001J>\u0010\u0082\u0001\u001a\u00020x2\b\b\u0002\u0010U\u001a\u00020V2(\u0010n\u001a$\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020M0L\u0012\u0004\u0012\u00020#0\"j\b\u0012\u0004\u0012\u00020\u0010`}H\u0096\u0001J\u001a\u0010\u0083\u0001\u001a\u00020\u00012\u0006\u0010D\u001a\u00020\u00102\u0006\u0010E\u001a\u00020/H\u0096\u0003J\u001e\u0010\u0083\u0001\u001a\u00020\u00012\u0006\u0010D\u001a\u00020\u00102\n\u0010F\u001a\u0006\u0012\u0002\b\u00030`H\u0096\u0003J\u0013\u0010\u0084\u0001\u001a\u00020\u00012\u0007\u0010\u0085\u0001\u001a\u00020/H\u0096\u0001J\u0014\u0010\u0086\u0001\u001a\u00020\u00012\b\u0010\u0086\u0001\u001a\u00030\u0087\u0001H\u0096\u0001J\u0014\u0010\u0088\u0001\u001a\u00020\u00012\b\u0010\u0086\u0001\u001a\u00030\u0087\u0001H\u0096\u0001J\n\u0010\u0089\u0001\u001a\u00020\u0010H\u0096\u0001J\u0013\u0010\u008a\u0001\u001a\u00020\u00012\u0007\u0010\u008a\u0001\u001a\u00020?H\u0096\u0001J$\u0010\u008b\u0001\u001a\u00020\u00012\u0018\u0010\u008c\u0001\u001a\u0013\u0012\u0004\u0012\u00020I\u0012\u0004\u0012\u00020?0\"j\u0003`\u008d\u0001H\u0096\u0001R\u0012\u0010\u0004\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\"\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010\u000fj\u0002`\u0011X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0014\u001a\u00020\u0015X\u0096\u000f¢\u0006\f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001a\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\r\u001a\u0004\b\u001b\u0010\u0017R\u0012\u0010\u001d\u001a\u00020\u001eX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R+\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020#0\"j\u0002`$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\r\u001a\u0004\b%\u0010&R\u0012\u0010(\u001a\u00020)X\u0096\u0005¢\u0006\u0006\u001a\u0004\b*\u0010+R0\u0010,\u001a\u001a\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010/0.0-j\u0002`0X\u0096\u000f¢\u0006\f\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u0012\u00105\u001a\u00020\u0001X\u0096\u0005¢\u0006\u0006\u001a\u0004\b6\u00107R\u0018\u00108\u001a\u000209X\u0096\u000f¢\u0006\f\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u008f\u0001"}, d2 = {"Lcom/github/kittinunf/fuel/core/requests/SuspendableRequest;", "Lcom/github/kittinunf/fuel/core/Request;", "wrapped", "(Lcom/github/kittinunf/fuel/core/Request;)V", "body", "Lcom/github/kittinunf/fuel/core/Body;", "getBody", "()Lcom/github/kittinunf/fuel/core/Body;", "client", "Lcom/github/kittinunf/fuel/core/Client;", "getClient", "()Lcom/github/kittinunf/fuel/core/Client;", "client$delegate", "Lkotlin/Lazy;", "enabledFeatures", "", "", "Lcom/github/kittinunf/fuel/core/RequestFeatures;", "getEnabledFeatures", "()Ljava/util/Map;", "executionOptions", "Lcom/github/kittinunf/fuel/core/RequestExecutionOptions;", "getExecutionOptions", "()Lcom/github/kittinunf/fuel/core/RequestExecutionOptions;", "setExecutionOptions", "(Lcom/github/kittinunf/fuel/core/RequestExecutionOptions;)V", "executor", "getExecutor", "executor$delegate", "headers", "Lcom/github/kittinunf/fuel/core/Headers;", "getHeaders", "()Lcom/github/kittinunf/fuel/core/Headers;", "interruptCallback", "Lkotlin/Function1;", "", "Lcom/github/kittinunf/fuel/core/InterruptCallback;", "getInterruptCallback", "()Lkotlin/jvm/functions/Function1;", "interruptCallback$delegate", "method", "Lcom/github/kittinunf/fuel/core/Method;", "getMethod", "()Lcom/github/kittinunf/fuel/core/Method;", "parameters", "", "Lkotlin/Pair;", "", "Lcom/github/kittinunf/fuel/core/Parameters;", "getParameters", "()Ljava/util/List;", "setParameters", "(Ljava/util/List;)V", "request", "getRequest", "()Lcom/github/kittinunf/fuel/core/Request;", "url", "Ljava/net/URL;", "getUrl", "()Ljava/net/URL;", "setUrl", "(Ljava/net/URL;)V", "allowRedirects", "", "appendHeader", "pairs", "", "([Lkotlin/Pair;)Lcom/github/kittinunf/fuel/core/Request;", "header", "value", "values", "(Ljava/lang/String;[Ljava/lang/Object;)Lcom/github/kittinunf/fuel/core/Request;", "await", "Lcom/github/kittinunf/fuel/core/Response;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitResult", "Lcom/github/kittinunf/result/Result;", "Lcom/github/kittinunf/fuel/core/FuelError;", "openStream", "Lkotlin/Function0;", "Ljava/io/InputStream;", "Lcom/github/kittinunf/fuel/core/BodySource;", "calculateLength", "", "Lcom/github/kittinunf/fuel/core/BodyLength;", "charset", "Ljava/nio/charset/Charset;", "repeatable", "file", "Ljava/io/File;", "stream", "bytes", "", "executeRequest", "(Lcom/github/kittinunf/fuel/core/Request;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "get", "", "Lcom/github/kittinunf/fuel/core/HeaderValues;", "getTag", ExifInterface.GPS_DIRECTION_TRUE, "clazz", "Lkotlin/reflect/KClass;", "(Lkotlin/reflect/KClass;)Ljava/lang/Object;", "map", "", "interrupt", "prepareRequest", "prepareResponse", "result", "requestProgress", "handler", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "readBytes", "totalBytes", "Lcom/github/kittinunf/fuel/core/ProgressCallback;", "response", "Lkotlin/Triple;", "Lcom/github/kittinunf/fuel/core/ResponseResultOf;", "Lcom/github/kittinunf/fuel/core/requests/CancellableRequest;", "Lcom/github/kittinunf/fuel/core/Handler;", "Lcom/github/kittinunf/fuel/core/ResponseHandler;", "Lkotlin/Function3;", "Lcom/github/kittinunf/fuel/core/ResponseResultHandler;", "Lcom/github/kittinunf/fuel/core/ResultHandler;", "responseObject", "deserializer", "Lcom/github/kittinunf/fuel/core/ResponseDeserializable;", "responseProgress", "responseString", "set", "tag", "t", "timeout", "", "timeoutRead", "toString", "useHttpCache", "validate", "validator", "Lcom/github/kittinunf/fuel/core/ResponseValidator;", "Companion", "fuel"}, k = 1, mv = {1, 4, 0})
public final class SuspendableRequest implements Request {

    /* INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String FEATURE = SuspendableRequest.class.getCanonicalName();

    /* INFO: renamed from: client$delegate, reason: from kotlin metadata */
    private final Lazy client;

    /* INFO: renamed from: executor$delegate, reason: from kotlin metadata */
    private final Lazy executor;

    /* INFO: renamed from: interruptCallback$delegate, reason: from kotlin metadata */
    private final Lazy interruptCallback;
    private final Request wrapped;

    /* INFO: renamed from: com.github.kittinunf.fuel.core.requests.SuspendableRequest$await$1, reason: invalid class name */
    /* INFO: compiled from: SuspendableRequest.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0086@"}, d2 = {"await", "", "continuation", "Lkotlin/coroutines/Continuation;", "Lcom/github/kittinunf/fuel/core/Response;"}, k = 3, mv = {1, 4, 0})
    @DebugMetadata(c = "com.github.kittinunf.fuel.core.requests.SuspendableRequest", f = "SuspendableRequest.kt", i = {0}, l = {64}, m = "await", n = {"this"}, s = {"L$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SuspendableRequest.this.await(this);
        }
    }

    /* INFO: renamed from: com.github.kittinunf.fuel.core.requests.SuspendableRequest$awaitResult$1, reason: invalid class name and case insensitive filesystem */
    /* INFO: compiled from: SuspendableRequest.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0018\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00040\u0003H\u0086@"}, d2 = {"awaitResult", "", "continuation", "Lkotlin/coroutines/Continuation;", "Lcom/github/kittinunf/result/Result;", "Lcom/github/kittinunf/fuel/core/Response;", "Lcom/github/kittinunf/fuel/core/FuelError;"}, k = 3, mv = {1, 4, 0})
    @DebugMetadata(c = "com.github.kittinunf.fuel.core.requests.SuspendableRequest", f = "SuspendableRequest.kt", i = {0, 0}, l = {40}, m = "awaitResult", n = {"this", "it"}, s = {"L$0", "L$1"})
    static final class C01961 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C01961(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SuspendableRequest.this.awaitResult(this);
        }
    }

    /* INFO: renamed from: com.github.kittinunf.fuel.core.requests.SuspendableRequest$executeRequest$1, reason: invalid class name and case insensitive filesystem */
    /* INFO: compiled from: SuspendableRequest.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0018\u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u00060\u0005H\u0082@"}, d2 = {"executeRequest", "", "request", "Lcom/github/kittinunf/fuel/core/Request;", "continuation", "Lkotlin/coroutines/Continuation;", "Lkotlin/Pair;", "Lcom/github/kittinunf/fuel/core/Response;"}, k = 3, mv = {1, 4, 0})
    @DebugMetadata(c = "com.github.kittinunf.fuel.core.requests.SuspendableRequest", f = "SuspendableRequest.kt", i = {0, 0, 0}, l = {21}, m = "executeRequest", n = {"this", "request", "$this$runCatching"}, s = {"L$0", "L$1", "L$2"})
    static final class C01971 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C01971(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SuspendableRequest.this.executeRequest(null, this);
        }
    }

    private final Client getClient() {
        return (Client) this.client.getValue();
    }

    /* INFO: Access modifiers changed from: private */
    public final RequestExecutionOptions getExecutor() {
        return (RequestExecutionOptions) this.executor.getValue();
    }

    private final Function1<Request, Unit> getInterruptCallback() {
        return (Function1) this.interruptCallback.getValue();
    }

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

    @Override // com.github.kittinunf.fuel.core.RequestFactory.RequestConvertible
    public Request getRequest() {
        return this.wrapped.getRequest();
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

    private SuspendableRequest(Request request) {
        this.wrapped = request;
        this.interruptCallback = LazyKt.lazy(new SuspendableRequest$interruptCallback$2(this));
        this.executor = LazyKt.lazy(new SuspendableRequest$executor$2(this));
        this.client = LazyKt.lazy(new SuspendableRequest$client$2(this));
    }

    public /* synthetic */ SuspendableRequest(Request request, DefaultConstructorMarker defaultConstructorMarker) {
        this(request);
    }

    private final Request prepareRequest(Request request) {
        return getExecutor().getRequestTransformer().invoke(request);
    }

    /* WARN: Code duplicated, block: B:7:0x0014  */
    final /* synthetic */ Object executeRequest(Request request, Continuation<? super Pair<? extends Request, Response>> continuation) throws Throwable {
        C01971 c01971;
        Throwable th;
        SuspendableRequest suspendableRequest;
        Object objM3752constructorimpl;
        if (continuation instanceof C01971) {
            c01971 = (C01971) continuation;
            if ((c01971.label & Integer.MIN_VALUE) != 0) {
                c01971.label -= Integer.MIN_VALUE;
            } else {
                c01971 = new C01971(continuation);
            }
        } else {
            c01971 = new C01971(continuation);
        }
        Object objAwaitRequest = c01971.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c01971.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objAwaitRequest);
            try {
                kotlin.Result.Companion companion = kotlin.Result.INSTANCE;
                SuspendableRequest suspendableRequest2 = this;
                Client client = getClient();
                c01971.L$0 = this;
                c01971.L$1 = request;
                c01971.L$2 = this;
                c01971.L$3 = request;
                c01971.label = 1;
                objAwaitRequest = client.awaitRequest(request, c01971);
                if (objAwaitRequest == coroutine_suspended) {
                    return coroutine_suspended;
                }
                suspendableRequest = this;
            } catch (Throwable th2) {
                th = th2;
                suspendableRequest = this;
                kotlin.Result.Companion companion2 = kotlin.Result.INSTANCE;
                objM3752constructorimpl = kotlin.Result.m3752constructorimpl(ResultKt.createFailure(th));
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            request = (Request) c01971.L$3;
            suspendableRequest = (SuspendableRequest) c01971.L$0;
            try {
                ResultKt.throwOnFailure(objAwaitRequest);
            } catch (Throwable th3) {
                th = th3;
                kotlin.Result.Companion companion3 = kotlin.Result.INSTANCE;
                objM3752constructorimpl = kotlin.Result.m3752constructorimpl(ResultKt.createFailure(th));
            }
        }
        objM3752constructorimpl = kotlin.Result.m3752constructorimpl(new Pair(request, objAwaitRequest));
        Throwable thM3755exceptionOrNullimpl = kotlin.Result.m3755exceptionOrNullimpl(objM3752constructorimpl);
        if (thM3755exceptionOrNullimpl != null) {
            kotlin.Result.Companion companion4 = kotlin.Result.INSTANCE;
            throw FuelError.INSTANCE.wrap(thM3755exceptionOrNullimpl, new Response(suspendableRequest.getUrl(), 0, null, null, 0L, null, 62, null));
        }
        ResultKt.throwOnFailure(objM3752constructorimpl);
        return objM3752constructorimpl;
    }

    private final Response prepareResponse(Pair<? extends Request, Response> result) throws Throwable {
        Object objM3752constructorimpl;
        Object objM3752constructorimpl2;
        Request requestComponent1 = result.component1();
        Response responseComponent2 = result.component2();
        try {
            kotlin.Result.Companion companion = kotlin.Result.INSTANCE;
            SuspendableRequest suspendableRequest = this;
            objM3752constructorimpl = kotlin.Result.m3752constructorimpl(getExecutor().getResponseTransformer().invoke(requestComponent1, responseComponent2));
        } catch (Throwable th) {
            kotlin.Result.Companion companion2 = kotlin.Result.INSTANCE;
            objM3752constructorimpl = kotlin.Result.m3752constructorimpl(ResultKt.createFailure(th));
        }
        if (kotlin.Result.m3759isSuccessimpl(objM3752constructorimpl)) {
            try {
                kotlin.Result.Companion companion3 = kotlin.Result.INSTANCE;
                Response response = (Response) objM3752constructorimpl;
                if (getExecutor().getResponseValidator().invoke(response).booleanValue()) {
                    objM3752constructorimpl2 = kotlin.Result.m3752constructorimpl(response);
                } else {
                    throw FuelError.INSTANCE.wrap(new HttpException(response.getStatusCode(), response.getResponseMessage()), response);
                }
            } catch (Throwable th2) {
                kotlin.Result.Companion companion4 = kotlin.Result.INSTANCE;
                objM3752constructorimpl = ResultKt.createFailure(th2);
                objM3752constructorimpl2 = kotlin.Result.m3752constructorimpl(objM3752constructorimpl);
            }
        } else {
            objM3752constructorimpl2 = kotlin.Result.m3752constructorimpl(objM3752constructorimpl);
        }
        Throwable thM3755exceptionOrNullimpl = kotlin.Result.m3755exceptionOrNullimpl(objM3752constructorimpl2);
        if (thM3755exceptionOrNullimpl != null) {
            kotlin.Result.Companion companion5 = kotlin.Result.INSTANCE;
            throw FuelError.INSTANCE.wrap(thM3755exceptionOrNullimpl, responseComponent2);
        }
        ResultKt.throwOnFailure(objM3752constructorimpl2);
        return (Response) objM3752constructorimpl2;
    }

    /* WARN: Code duplicated, block: B:44:0x00b6 A[Catch: all -> 0x00dd, TryCatch #4 {all -> 0x00dd, blocks: (B:37:0x0093, B:42:0x00b0, B:44:0x00b6, B:45:0x00c0, B:46:0x00dc, B:41:0x00a6, B:38:0x0097), top: B:75:0x0093, inners: #2 }] */
    /* WARN: Code duplicated, block: B:45:0x00c0 A[Catch: all -> 0x00dd, TryCatch #4 {all -> 0x00dd, blocks: (B:37:0x0093, B:42:0x00b0, B:44:0x00b6, B:45:0x00c0, B:46:0x00dc, B:41:0x00a6, B:38:0x0097), top: B:75:0x0093, inners: #2 }] */
    /* WARN: Code duplicated, block: B:49:0x00e4 A[PHI: r5
  0x00e4: PHI (r5v39 java.lang.Object) = (r5v20 java.lang.Object), (r5v22 java.lang.Object) binds: [B:36:0x0091, B:48:0x00de] A[DONT_GENERATE, DONT_INLINE]] */
    /* WARN: Code duplicated, block: B:52:0x00ee  */
    /* WARN: Code duplicated, block: B:59:0x0124  */
    /* WARN: Code duplicated, block: B:60:0x0132  */
    /* WARN: Code duplicated, block: B:64:0x013d  */
    /* WARN: Code duplicated, block: B:75:0x0093 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* WARN: Code duplicated, block: B:7:0x0014  */
    public final Object awaitResult(Continuation<? super Result<Response, ? extends FuelError>> continuation) throws Throwable {
        C01961 c01961;
        Object objM3752constructorimpl;
        SuspendableRequest suspendableRequest;
        Object objM3752constructorimpl2;
        Pair<? extends Request, Response> pair;
        Object objM3752constructorimpl3;
        Throwable thM3755exceptionOrNullimpl;
        Object objM3752constructorimpl4;
        Throwable thM3755exceptionOrNullimpl2;
        Object objM3752constructorimpl5;
        Throwable thM3755exceptionOrNullimpl3;
        if (continuation instanceof C01961) {
            c01961 = (C01961) continuation;
            if ((c01961.label & Integer.MIN_VALUE) != 0) {
                c01961.label -= Integer.MIN_VALUE;
            } else {
                c01961 = new C01961(continuation);
            }
        } else {
            c01961 = new C01961(continuation);
        }
        Object objExecuteRequest = c01961.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c01961.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objExecuteRequest);
            try {
                kotlin.Result.Companion companion = kotlin.Result.INSTANCE;
                SuspendableRequest suspendableRequest2 = this;
                objM3752constructorimpl = kotlin.Result.m3752constructorimpl(prepareRequest(getRequest()));
            } catch (Throwable th) {
                kotlin.Result.Companion companion2 = kotlin.Result.INSTANCE;
                objM3752constructorimpl = kotlin.Result.m3752constructorimpl(ResultKt.createFailure(th));
            }
            if (kotlin.Result.m3759isSuccessimpl(objM3752constructorimpl)) {
                try {
                    kotlin.Result.Companion companion3 = kotlin.Result.INSTANCE;
                    Request request = (Request) objM3752constructorimpl;
                    c01961.L$0 = this;
                    c01961.L$1 = request;
                    c01961.label = 1;
                    objExecuteRequest = executeRequest(request, c01961);
                    if (objExecuteRequest == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    suspendableRequest = this;
                } catch (Throwable th2) {
                    th = th2;
                    suspendableRequest = this;
                    kotlin.Result.Companion companion4 = kotlin.Result.INSTANCE;
                    objM3752constructorimpl2 = kotlin.Result.m3752constructorimpl(ResultKt.createFailure(th));
                }
            } else {
                objM3752constructorimpl2 = kotlin.Result.m3752constructorimpl(objM3752constructorimpl);
                suspendableRequest = this;
            }
            if (kotlin.Result.m3759isSuccessimpl(objM3752constructorimpl2)) {
                try {
                    kotlin.Result.Companion companion5 = kotlin.Result.INSTANCE;
                    pair = (Pair) objM3752constructorimpl2;
                    try {
                        kotlin.Result.Companion companion6 = kotlin.Result.INSTANCE;
                        objM3752constructorimpl3 = kotlin.Result.m3752constructorimpl(suspendableRequest.prepareResponse(pair));
                    } catch (Throwable th3) {
                        kotlin.Result.Companion companion7 = kotlin.Result.INSTANCE;
                        objM3752constructorimpl3 = kotlin.Result.m3752constructorimpl(ResultKt.createFailure(th3));
                    }
                    thM3755exceptionOrNullimpl = kotlin.Result.m3755exceptionOrNullimpl(objM3752constructorimpl3);
                    if (thM3755exceptionOrNullimpl == null) {
                        kotlin.Result.Companion companion8 = kotlin.Result.INSTANCE;
                        Fuel.INSTANCE.trace(new SuspendableRequest$$special$$inlined$also$lambda$1(thM3755exceptionOrNullimpl));
                        throw FuelError.INSTANCE.wrap(thM3755exceptionOrNullimpl, pair.getSecond());
                    }
                    ResultKt.throwOnFailure(objM3752constructorimpl3);
                    objM3752constructorimpl4 = kotlin.Result.m3752constructorimpl((Response) objM3752constructorimpl3);
                } catch (Throwable th4) {
                    kotlin.Result.Companion companion9 = kotlin.Result.INSTANCE;
                    objM3752constructorimpl2 = ResultKt.createFailure(th4);
                    objM3752constructorimpl4 = kotlin.Result.m3752constructorimpl(objM3752constructorimpl2);
                }
            } else {
                objM3752constructorimpl4 = kotlin.Result.m3752constructorimpl(objM3752constructorimpl2);
            }
            thM3755exceptionOrNullimpl2 = kotlin.Result.m3755exceptionOrNullimpl(objM3752constructorimpl4);
            if (thM3755exceptionOrNullimpl2 != null) {
                Fuel.INSTANCE.trace(new SuspendableRequest$awaitResult$5$1(thM3755exceptionOrNullimpl2));
                if ((thM3755exceptionOrNullimpl2 instanceof FuelError) && ((FuelError) thM3755exceptionOrNullimpl2).getCausedByInterruption()) {
                    Fuel.INSTANCE.trace(new SuspendableRequest$awaitResult$5$2(thM3755exceptionOrNullimpl2));
                    suspendableRequest.getInterruptCallback().invoke(suspendableRequest.getRequest());
                }
            }
            if (kotlin.Result.m3759isSuccessimpl(objM3752constructorimpl4)) {
                kotlin.Result.Companion companion10 = kotlin.Result.INSTANCE;
                objM3752constructorimpl5 = kotlin.Result.m3752constructorimpl(new Result.Success((Response) objM3752constructorimpl4));
            } else {
                objM3752constructorimpl5 = kotlin.Result.m3752constructorimpl(objM3752constructorimpl4);
            }
            thM3755exceptionOrNullimpl3 = kotlin.Result.m3755exceptionOrNullimpl(objM3752constructorimpl5);
            if (thM3755exceptionOrNullimpl3 != null) {
                kotlin.Result.Companion companion11 = kotlin.Result.INSTANCE;
                objM3752constructorimpl5 = kotlin.Result.m3752constructorimpl(new Result.Failure((FuelError) thM3755exceptionOrNullimpl3));
            }
            ResultKt.throwOnFailure(objM3752constructorimpl5);
            return objM3752constructorimpl5;
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        suspendableRequest = (SuspendableRequest) c01961.L$0;
        try {
            ResultKt.throwOnFailure(objExecuteRequest);
        } catch (Throwable th5) {
            th = th5;
            kotlin.Result.Companion companion12 = kotlin.Result.INSTANCE;
            objM3752constructorimpl2 = kotlin.Result.m3752constructorimpl(ResultKt.createFailure(th));
        }
        objM3752constructorimpl2 = kotlin.Result.m3752constructorimpl((Pair) objExecuteRequest);
        if (kotlin.Result.m3759isSuccessimpl(objM3752constructorimpl2)) {
            kotlin.Result.Companion companion13 = kotlin.Result.INSTANCE;
            pair = (Pair) objM3752constructorimpl2;
            kotlin.Result.Companion companion14 = kotlin.Result.INSTANCE;
            objM3752constructorimpl3 = kotlin.Result.m3752constructorimpl(suspendableRequest.prepareResponse(pair));
            thM3755exceptionOrNullimpl = kotlin.Result.m3755exceptionOrNullimpl(objM3752constructorimpl3);
            if (thM3755exceptionOrNullimpl == null) {
                kotlin.Result.Companion companion15 = kotlin.Result.INSTANCE;
                Fuel.INSTANCE.trace(new SuspendableRequest$$special$$inlined$also$lambda$1(thM3755exceptionOrNullimpl));
                throw FuelError.INSTANCE.wrap(thM3755exceptionOrNullimpl, pair.getSecond());
            }
            ResultKt.throwOnFailure(objM3752constructorimpl3);
            objM3752constructorimpl4 = kotlin.Result.m3752constructorimpl((Response) objM3752constructorimpl3);
        } else {
            objM3752constructorimpl4 = kotlin.Result.m3752constructorimpl(objM3752constructorimpl2);
        }
        thM3755exceptionOrNullimpl2 = kotlin.Result.m3755exceptionOrNullimpl(objM3752constructorimpl4);
        if (thM3755exceptionOrNullimpl2 != null) {
            Fuel.INSTANCE.trace(new SuspendableRequest$awaitResult$5$1(thM3755exceptionOrNullimpl2));
            if (thM3755exceptionOrNullimpl2 instanceof FuelError) {
                Fuel.INSTANCE.trace(new SuspendableRequest$awaitResult$5$2(thM3755exceptionOrNullimpl2));
                suspendableRequest.getInterruptCallback().invoke(suspendableRequest.getRequest());
            }
        }
        if (kotlin.Result.m3759isSuccessimpl(objM3752constructorimpl4)) {
            kotlin.Result.Companion companion16 = kotlin.Result.INSTANCE;
            objM3752constructorimpl5 = kotlin.Result.m3752constructorimpl(new Result.Success((Response) objM3752constructorimpl4));
        } else {
            objM3752constructorimpl5 = kotlin.Result.m3752constructorimpl(objM3752constructorimpl4);
        }
        thM3755exceptionOrNullimpl3 = kotlin.Result.m3755exceptionOrNullimpl(objM3752constructorimpl5);
        if (thM3755exceptionOrNullimpl3 != null) {
            kotlin.Result.Companion companion17 = kotlin.Result.INSTANCE;
            objM3752constructorimpl5 = kotlin.Result.m3752constructorimpl(new Result.Failure((FuelError) thM3755exceptionOrNullimpl3));
        }
        ResultKt.throwOnFailure(objM3752constructorimpl5);
        return objM3752constructorimpl5;
    }

    /* WARN: Code duplicated, block: B:7:0x0014  */
    public final Object await(Continuation<? super Response> continuation) throws Throwable {
        AnonymousClass1 anonymousClass1;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object objAwaitResult = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objAwaitResult);
            anonymousClass1.L$0 = this;
            anonymousClass1.label = 1;
            objAwaitResult = awaitResult(anonymousClass1);
            if (objAwaitResult == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objAwaitResult);
        }
        return ((Result) objAwaitResult).get();
    }

    /* INFO: compiled from: SuspendableRequest.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/github/kittinunf/fuel/core/requests/SuspendableRequest$Companion;", "", "()V", "FEATURE", "", "kotlin.jvm.PlatformType", "enableFor", "Lcom/github/kittinunf/fuel/core/requests/SuspendableRequest;", "request", "Lcom/github/kittinunf/fuel/core/Request;", "fuel"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SuspendableRequest enableFor(Request request) {
            Intrinsics.checkNotNullParameter(request, "request");
            SuspendableRequest suspendableRequest = request.getEnabledFeatures().get(SuspendableRequest.FEATURE);
            if (suspendableRequest == null) {
                suspendableRequest = new SuspendableRequest(request, null);
            }
            if (request != suspendableRequest) {
                Map<String, Request> enabledFeatures = request.getEnabledFeatures();
                String FEATURE = SuspendableRequest.FEATURE;
                Intrinsics.checkNotNullExpressionValue(FEATURE, "FEATURE");
                enabledFeatures.put(FEATURE, suspendableRequest);
            }
            if (suspendableRequest != null) {
                return (SuspendableRequest) suspendableRequest;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.github.kittinunf.fuel.core.requests.SuspendableRequest");
        }
    }
}
