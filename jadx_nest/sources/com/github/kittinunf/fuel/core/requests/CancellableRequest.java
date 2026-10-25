package com.github.kittinunf.fuel.core.requests;

import androidx.exifinterface.media.ExifInterface;
import com.github.kittinunf.fuel.Fuel;
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
import com.github.kittinunf.result.Result;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* JADX INFO: compiled from: CancellableRequest.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¢\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u008a\u00012\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0002\u008a\u0001B\u001d\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0001\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0002\u0010\u0006J\u0011\u0010<\u001a\u00020\u00012\u0006\u0010<\u001a\u00020=H\u0096\u0001J:\u0010>\u001a\u00020\u00012*\u0010?\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020-0,0@\"\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020-0,H\u0096\u0001¢\u0006\u0002\u0010AJ\u0019\u0010>\u001a\u00020\u00012\u0006\u0010B\u001a\u00020\r2\u0006\u0010C\u001a\u00020-H\u0096\u0001J*\u0010>\u001a\u00020\u00012\u0006\u0010B\u001a\u00020\r2\u0012\u0010D\u001a\n\u0012\u0006\b\u0001\u0012\u00020-0@\"\u00020-H\u0096\u0001¢\u0006\u0002\u0010EJ\u0011\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\bH\u0096\u0001JG\u0010\u0007\u001a\u00020\u00012\u0010\u0010F\u001a\f\u0012\u0004\u0012\u00020H0Gj\u0002`I2\u0016\b\u0002\u0010J\u001a\u0010\u0012\u0004\u0012\u00020K\u0018\u00010Gj\u0004\u0018\u0001`L2\b\b\u0002\u0010M\u001a\u00020N2\b\b\u0002\u0010O\u001a\u00020=H\u0096\u0001J\u001b\u0010\u0007\u001a\u00020\u00012\u0006\u0010P\u001a\u00020Q2\b\b\u0002\u0010M\u001a\u00020NH\u0096\u0001J=\u0010\u0007\u001a\u00020\u00012\u0006\u0010R\u001a\u00020H2\u0016\b\u0002\u0010J\u001a\u0010\u0012\u0004\u0012\u00020K\u0018\u00010Gj\u0004\u0018\u0001`L2\b\b\u0002\u0010M\u001a\u00020N2\b\b\u0002\u0010O\u001a\u00020=H\u0096\u0001J\u001b\u0010\u0007\u001a\u00020\u00012\u0006\u0010S\u001a\u00020T2\b\b\u0002\u0010M\u001a\u00020NH\u0096\u0001J\u001b\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\r2\b\b\u0002\u0010M\u001a\u00020NH\u0096\u0001J\u0006\u0010U\u001a\u00020=J\u0011\u0010U\u001a\u00020=2\u0006\u0010V\u001a\u00020=H\u0096\u0001J\u0011\u0010W\u001a\n X*\u0004\u0018\u00010\u00030\u0003H\u0096\u0001J)\u0010W\u001a\n X*\u0004\u0018\u00010\u00030\u00032\u0006\u0010V\u001a\u00020K2\u000e\u0010Y\u001a\n X*\u0004\u0018\u00010Z0ZH\u0096\u0003J\u001b\u0010W\u001a\f\u0012\u0004\u0012\u00020\r0[j\u0002`\\2\u0006\u0010B\u001a\u00020\rH\u0096\u0003J(\u0010]\u001a\u0004\u0018\u0001H^\"\b\b\u0000\u0010^*\u00020-2\f\u0010_\u001a\b\u0012\u0004\u0012\u0002H^0`H\u0096\u0001¢\u0006\u0002\u0010aJ:\u0010B\u001a\u00020\u00012*\u0010?\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020-0,0@\"\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020-0,H\u0096\u0001¢\u0006\u0002\u0010AJ\u001b\u0010B\u001a\f\u0012\u0004\u0012\u00020\r0[j\u0002`\\2\u0006\u0010B\u001a\u00020\rH\u0096\u0001J\u0019\u0010B\u001a\u00020\u00012\u0006\u0010B\u001a\u00020\r2\u0006\u0010C\u001a\u00020-H\u0096\u0001J*\u0010B\u001a\u00020\u00012\u0006\u0010B\u001a\u00020\r2\u0012\u0010D\u001a\n\u0012\u0006\b\u0001\u0012\u00020-0@\"\u00020-H\u0096\u0001¢\u0006\u0002\u0010EJ\u001d\u0010B\u001a\u00020\u00012\u0006\u0010B\u001a\u00020\r2\n\u0010D\u001a\u0006\u0012\u0002\b\u00030[H\u0096\u0001J\u001d\u0010B\u001a\u00020\u00012\u0012\u0010b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020-0cH\u0096\u0001J!\u0010d\u001a\u00020\u00012\u0016\u0010d\u001a\u0012\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020!0 j\u0002`\"H\u0096\u0001J\t\u0010e\u001a\u00020=H\u0096\u0001J\t\u0010f\u001a\u00020=H\u0096\u0001J\u0006\u0010g\u001a\u00020\u0003JE\u0010h\u001a\u00020\u00012:\u0010i\u001a6\u0012\u0013\u0012\u00110K¢\u0006\f\bk\u0012\b\bl\u0012\u0004\b\b(m\u0012\u0013\u0012\u00110K¢\u0006\f\bk\u0012\b\bl\u0012\u0004\b\b(n\u0012\u0004\u0012\u00020!0jj\u0002`oH\u0096\u0001J1\u0010p\u001a*\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020T\u0012\u0004\u0012\u00020s0r0qj\b\u0012\u0004\u0012\u00020T`tH\u0096\u0001J\u0017\u0010p\u001a\u00020\u00002\f\u0010i\u001a\b\u0012\u0004\u0012\u00020T0uH\u0096\u0001J\u0017\u0010p\u001a\u00020\u00002\f\u0010i\u001a\b\u0012\u0004\u0012\u00020T0vH\u0096\u0001J?\u0010p\u001a\u00020\u000024\u0010i\u001a0\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020T\u0012\u0004\u0012\u00020s0r\u0012\u0004\u0012\u00020!0wj\b\u0012\u0004\u0012\u00020T`xH\u0096\u0001J3\u0010p\u001a\u00020\u00002(\u0010i\u001a$\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020T\u0012\u0004\u0012\u00020s0r\u0012\u0004\u0012\u00020!0 j\b\u0012\u0004\u0012\u00020T`yH\u0096\u0001JI\u0010z\u001a*\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H^\u0012\u0004\u0012\u00020s0r0qj\b\u0012\u0004\u0012\u0002H^`t\"\b\b\u0000\u0010^*\u00020-2\f\u0010{\u001a\b\u0012\u0004\u0012\u0002H^0|H\u0096\u0001J/\u0010z\u001a\u00020\u0000\"\b\b\u0000\u0010^*\u00020-2\f\u0010{\u001a\b\u0012\u0004\u0012\u0002H^0|2\f\u0010i\u001a\b\u0012\u0004\u0012\u0002H^0uH\u0096\u0001J/\u0010z\u001a\u00020\u0000\"\b\b\u0000\u0010^*\u00020-2\f\u0010{\u001a\b\u0012\u0004\u0012\u0002H^0|2\f\u0010i\u001a\b\u0012\u0004\u0012\u0002H^0vH\u0096\u0001JW\u0010z\u001a\u00020\u0000\"\b\b\u0000\u0010^*\u00020-2\f\u0010{\u001a\b\u0012\u0004\u0012\u0002H^0|24\u0010i\u001a0\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H^\u0012\u0004\u0012\u00020s0r\u0012\u0004\u0012\u00020!0wj\b\u0012\u0004\u0012\u0002H^`xH\u0096\u0001JK\u0010z\u001a\u00020\u0000\"\b\b\u0000\u0010^*\u00020-2\f\u0010{\u001a\b\u0012\u0004\u0012\u0002H^0|2(\u0010i\u001a$\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H^\u0012\u0004\u0012\u00020s0r\u0012\u0004\u0012\u00020!0 j\b\u0012\u0004\u0012\u0002H^`yH\u0096\u0001JE\u0010}\u001a\u00020\u00012:\u0010i\u001a6\u0012\u0013\u0012\u00110K¢\u0006\f\bk\u0012\b\bl\u0012\u0004\b\b(m\u0012\u0013\u0012\u00110K¢\u0006\f\bk\u0012\b\bl\u0012\u0004\b\b(n\u0012\u0004\u0012\u00020!0jj\u0002`oH\u0096\u0001J1\u0010~\u001a*\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020s0r0qj\b\u0012\u0004\u0012\u00020\r`tH\u0096\u0001J\u0017\u0010~\u001a\u00020\u00002\f\u0010i\u001a\b\u0012\u0004\u0012\u00020\r0uH\u0096\u0001J\u0017\u0010~\u001a\u00020\u00002\f\u0010i\u001a\b\u0012\u0004\u0012\u00020\r0vH\u0096\u0001J?\u0010~\u001a\u00020\u000024\u0010i\u001a0\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020s0r\u0012\u0004\u0012\u00020!0wj\b\u0012\u0004\u0012\u00020\r`xH\u0096\u0001J3\u0010~\u001a\u00020\u00002(\u0010i\u001a$\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020s0r\u0012\u0004\u0012\u00020!0 j\b\u0012\u0004\u0012\u00020\r`yH\u0096\u0001J;\u0010~\u001a*\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020s0r0qj\b\u0012\u0004\u0012\u00020\r`t2\b\b\u0002\u0010M\u001a\u00020NH\u0096\u0001J!\u0010~\u001a\u00020\u00002\b\b\u0002\u0010M\u001a\u00020N2\f\u0010i\u001a\b\u0012\u0004\u0012\u00020\r0uH\u0096\u0001J!\u0010~\u001a\u00020\u00002\b\b\u0002\u0010M\u001a\u00020N2\f\u0010i\u001a\b\u0012\u0004\u0012\u00020\r0vH\u0096\u0001JI\u0010~\u001a\u00020\u00002\b\b\u0002\u0010M\u001a\u00020N24\u0010i\u001a0\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020s0r\u0012\u0004\u0012\u00020!0wj\b\u0012\u0004\u0012\u00020\r`xH\u0096\u0001J=\u0010~\u001a\u00020\u00002\b\b\u0002\u0010M\u001a\u00020N2(\u0010i\u001a$\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020s0r\u0012\u0004\u0012\u00020!0 j\b\u0012\u0004\u0012\u00020\r`yH\u0096\u0001J\u0019\u0010\u007f\u001a\u00020\u00012\u0006\u0010B\u001a\u00020\r2\u0006\u0010C\u001a\u00020-H\u0096\u0003J\u001d\u0010\u007f\u001a\u00020\u00012\u0006\u0010B\u001a\u00020\r2\n\u0010D\u001a\u0006\u0012\u0002\b\u00030[H\u0096\u0003J\u0013\u0010\u0080\u0001\u001a\u00020\u00012\u0007\u0010\u0081\u0001\u001a\u00020-H\u0096\u0001J\u0014\u0010\u0082\u0001\u001a\u00020\u00012\b\u0010\u0082\u0001\u001a\u00030\u0083\u0001H\u0096\u0001J\u0014\u0010\u0084\u0001\u001a\u00020\u00012\b\u0010\u0082\u0001\u001a\u00030\u0083\u0001H\u0096\u0001J\t\u0010\u0085\u0001\u001a\u00020\rH\u0016J\u0013\u0010\u0086\u0001\u001a\u00020\u00012\u0007\u0010\u0086\u0001\u001a\u00020=H\u0096\u0001J$\u0010\u0087\u0001\u001a\u00020\u00012\u0018\u0010\u0088\u0001\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020=0 j\u0003`\u0089\u0001H\u0096\u0001R\u0012\u0010\u0007\u001a\u00020\bX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\"\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00010\fj\u0002`\u000eX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0011\u001a\u00020\u0012X\u0096\u000f¢\u0006\f\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0017\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0018\u0010\u0014R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u001b\u001a\u00020\u001cX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR+\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020!0 j\u0002`\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\u001a\u001a\u0004\b#\u0010$R\u0012\u0010&\u001a\u00020'X\u0096\u0005¢\u0006\u0006\u001a\u0004\b(\u0010)R0\u0010*\u001a\u001a\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\r\u0012\u0006\u0012\u0004\u0018\u00010-0,0+j\u0002`.X\u0096\u000f¢\u0006\f\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u0014\u00103\u001a\u00020\u0000X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0018\u00106\u001a\u000207X\u0096\u000f¢\u0006\f\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u000e\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u008b\u0001"}, d2 = {"Lcom/github/kittinunf/fuel/core/requests/CancellableRequest;", "Lcom/github/kittinunf/fuel/core/Request;", "Ljava/util/concurrent/Future;", "Lcom/github/kittinunf/fuel/core/Response;", "wrapped", "future", "(Lcom/github/kittinunf/fuel/core/Request;Ljava/util/concurrent/Future;)V", "body", "Lcom/github/kittinunf/fuel/core/Body;", "getBody", "()Lcom/github/kittinunf/fuel/core/Body;", "enabledFeatures", "", "", "Lcom/github/kittinunf/fuel/core/RequestFeatures;", "getEnabledFeatures", "()Ljava/util/Map;", "executionOptions", "Lcom/github/kittinunf/fuel/core/RequestExecutionOptions;", "getExecutionOptions", "()Lcom/github/kittinunf/fuel/core/RequestExecutionOptions;", "setExecutionOptions", "(Lcom/github/kittinunf/fuel/core/RequestExecutionOptions;)V", "executor", "getExecutor", "executor$delegate", "Lkotlin/Lazy;", "headers", "Lcom/github/kittinunf/fuel/core/Headers;", "getHeaders", "()Lcom/github/kittinunf/fuel/core/Headers;", "interruptCallback", "Lkotlin/Function1;", "", "Lcom/github/kittinunf/fuel/core/InterruptCallback;", "getInterruptCallback", "()Lkotlin/jvm/functions/Function1;", "interruptCallback$delegate", "method", "Lcom/github/kittinunf/fuel/core/Method;", "getMethod", "()Lcom/github/kittinunf/fuel/core/Method;", "parameters", "", "Lkotlin/Pair;", "", "Lcom/github/kittinunf/fuel/core/Parameters;", "getParameters", "()Ljava/util/List;", "setParameters", "(Ljava/util/List;)V", "request", "getRequest", "()Lcom/github/kittinunf/fuel/core/requests/CancellableRequest;", "url", "Ljava/net/URL;", "getUrl", "()Ljava/net/URL;", "setUrl", "(Ljava/net/URL;)V", "allowRedirects", "", "appendHeader", "pairs", "", "([Lkotlin/Pair;)Lcom/github/kittinunf/fuel/core/Request;", "header", "value", "values", "(Ljava/lang/String;[Ljava/lang/Object;)Lcom/github/kittinunf/fuel/core/Request;", "openStream", "Lkotlin/Function0;", "Ljava/io/InputStream;", "Lcom/github/kittinunf/fuel/core/BodySource;", "calculateLength", "", "Lcom/github/kittinunf/fuel/core/BodyLength;", "charset", "Ljava/nio/charset/Charset;", "repeatable", "file", "Ljava/io/File;", "stream", "bytes", "", "cancel", "p0", "get", "kotlin.jvm.PlatformType", "p1", "Ljava/util/concurrent/TimeUnit;", "", "Lcom/github/kittinunf/fuel/core/HeaderValues;", "getTag", ExifInterface.GPS_DIRECTION_TRUE, "clazz", "Lkotlin/reflect/KClass;", "(Lkotlin/reflect/KClass;)Ljava/lang/Object;", "map", "", "interrupt", "isCancelled", "isDone", "join", "requestProgress", "handler", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "readBytes", "totalBytes", "Lcom/github/kittinunf/fuel/core/ProgressCallback;", "response", "Lkotlin/Triple;", "Lcom/github/kittinunf/result/Result;", "Lcom/github/kittinunf/fuel/core/FuelError;", "Lcom/github/kittinunf/fuel/core/ResponseResultOf;", "Lcom/github/kittinunf/fuel/core/Handler;", "Lcom/github/kittinunf/fuel/core/ResponseHandler;", "Lkotlin/Function3;", "Lcom/github/kittinunf/fuel/core/ResponseResultHandler;", "Lcom/github/kittinunf/fuel/core/ResultHandler;", "responseObject", "deserializer", "Lcom/github/kittinunf/fuel/core/ResponseDeserializable;", "responseProgress", "responseString", "set", "tag", "t", "timeout", "", "timeoutRead", "toString", "useHttpCache", "validate", "validator", "Lcom/github/kittinunf/fuel/core/ResponseValidator;", "Companion", "fuel"}, k = 1, mv = {1, 4, 0})
public final class CancellableRequest implements Request, Future<Response> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String FEATURE;

    /* JADX INFO: renamed from: executor$delegate, reason: from kotlin metadata */
    private final Lazy executor;
    private final Future<Response> future;

    /* JADX INFO: renamed from: interruptCallback$delegate, reason: from kotlin metadata */
    private final Lazy interruptCallback;
    private final CancellableRequest request;
    private final Request wrapped;

    /* JADX INFO: Access modifiers changed from: private */
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

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean p0) {
        return this.future.cancel(p0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Future
    public Response get() {
        return this.future.get();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.concurrent.Future
    public Response get(long p0, TimeUnit p1) {
        return this.future.get(p0, p1);
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

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.future.isCancelled();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return this.future.isDone();
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
    public Request useHttpCache(boolean useHttpCache) {
        return this.wrapped.useHttpCache(useHttpCache);
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public Request validate(Function1<? super Response, Boolean> validator) {
        Intrinsics.checkNotNullParameter(validator, "validator");
        return this.wrapped.validate(validator);
    }

    private CancellableRequest(Request request, Future<Response> future) {
        this.wrapped = request;
        this.future = future;
        this.interruptCallback = LazyKt.lazy(new CancellableRequest$interruptCallback$2(this));
        this.executor = LazyKt.lazy(new CancellableRequest$executor$2(this));
        this.request = this;
    }

    public /* synthetic */ CancellableRequest(Request request, Future future, DefaultConstructorMarker defaultConstructorMarker) {
        this(request, future);
    }

    @Override // com.github.kittinunf.fuel.core.RequestFactory.RequestConvertible
    public CancellableRequest getRequest() {
        return this.request;
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public String toString() {
        return "Cancellable[\n\r\t" + this.wrapped + "\n\r] done=" + isDone() + " cancelled=" + isCancelled();
    }

    public final boolean cancel() {
        return this.future.cancel(true);
    }

    public final Response join() {
        Object objM3752constructorimpl;
        try {
            kotlin.Result.Companion companion = kotlin.Result.INSTANCE;
            CancellableRequest cancellableRequest = this;
            objM3752constructorimpl = kotlin.Result.m3752constructorimpl(this.future.get());
        } catch (Throwable th) {
            kotlin.Result.Companion companion2 = kotlin.Result.INSTANCE;
            objM3752constructorimpl = kotlin.Result.m3752constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM3755exceptionOrNullimpl = kotlin.Result.m3755exceptionOrNullimpl(objM3752constructorimpl);
        if (thM3755exceptionOrNullimpl == null) {
            Response response = (Response) objM3752constructorimpl;
            Fuel.INSTANCE.trace(new CancellableRequest$join$2$1$1(response));
            Intrinsics.checkNotNullExpressionValue(response, "it.also { Fuel.trace { \"…quest] joined to $it\" } }");
            return response;
        }
        Response responseError = Response.INSTANCE.error(getUrl());
        Fuel.INSTANCE.trace(new CancellableRequest$join$$inlined$fold$lambda$1(thM3755exceptionOrNullimpl, this));
        if (!FuelError.Companion.wrap$default(FuelError.INSTANCE, thM3755exceptionOrNullimpl, null, 2, null).getCausedByInterruption()) {
            return responseError;
        }
        getInterruptCallback().invoke(this.wrapped);
        return responseError;
    }

    /* JADX INFO: compiled from: CancellableRequest.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/github/kittinunf/fuel/core/requests/CancellableRequest$Companion;", "", "()V", "FEATURE", "", "getFEATURE", "()Ljava/lang/String;", "enableFor", "Lcom/github/kittinunf/fuel/core/requests/CancellableRequest;", "request", "Lcom/github/kittinunf/fuel/core/Request;", "future", "Ljava/util/concurrent/Future;", "Lcom/github/kittinunf/fuel/core/Response;", "getFor", "fuel"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String getFEATURE() {
            return CancellableRequest.FEATURE;
        }

        public final CancellableRequest enableFor(Request request, Future<Response> future) {
            Intrinsics.checkNotNullParameter(request, "request");
            Intrinsics.checkNotNullParameter(future, "future");
            CancellableRequest cancellableRequest = getFor(request);
            if (cancellableRequest == null) {
                cancellableRequest = new CancellableRequest(request, future, null);
            }
            if (request != cancellableRequest) {
                request.getEnabledFeatures().put(getFEATURE(), cancellableRequest);
            }
            return cancellableRequest;
        }

        public final CancellableRequest getFor(Request request) {
            Intrinsics.checkNotNullParameter(request, "request");
            Request request2 = request.getEnabledFeatures().get(getFEATURE());
            if (!(request2 instanceof CancellableRequest)) {
                request2 = null;
            }
            return (CancellableRequest) request2;
        }
    }

    static {
        String canonicalName = CancellableRequest.class.getCanonicalName();
        Intrinsics.checkNotNullExpressionValue(canonicalName, "CancellableRequest::class.java.canonicalName");
        FEATURE = canonicalName;
    }
}
