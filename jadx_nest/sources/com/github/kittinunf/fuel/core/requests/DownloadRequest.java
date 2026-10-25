package com.github.kittinunf.fuel.core.requests;

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
import com.github.kittinunf.result.Result;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KClass;

/* JADX INFO: compiled from: DownloadRequest.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000´\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u0084\u00012\u00020\u0001:\u0002\u0084\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\u0011\u00106\u001a\u00020\u00012\u0006\u00106\u001a\u000207H\u0096\u0001J:\u00108\u001a\u00020\u00012*\u00109\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020'0\u000b0:\"\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020'0\u000bH\u0096\u0001¢\u0006\u0002\u0010;J\u0019\u00108\u001a\u00020\u00012\u0006\u0010<\u001a\u00020\u00132\u0006\u0010=\u001a\u00020'H\u0096\u0001J*\u00108\u001a\u00020\u00012\u0006\u0010<\u001a\u00020\u00132\u0012\u0010>\u001a\n\u0012\u0006\b\u0001\u0012\u00020'0:\"\u00020'H\u0096\u0001¢\u0006\u0002\u0010?J\u0011\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\u0096\u0001JG\u0010\u0004\u001a\u00020\u00012\u0010\u0010@\u001a\f\u0012\u0004\u0012\u00020\u000e0\rj\u0002`A2\u0016\b\u0002\u0010B\u001a\u0010\u0012\u0004\u0012\u00020C\u0018\u00010\rj\u0004\u0018\u0001`D2\b\b\u0002\u0010E\u001a\u00020F2\b\b\u0002\u0010G\u001a\u000207H\u0096\u0001J\u001b\u0010\u0004\u001a\u00020\u00012\u0006\u0010H\u001a\u00020I2\b\b\u0002\u0010E\u001a\u00020FH\u0096\u0001J=\u0010\u0004\u001a\u00020\u00012\u0006\u0010J\u001a\u00020\u000e2\u0016\b\u0002\u0010B\u001a\u0010\u0012\u0004\u0012\u00020C\u0018\u00010\rj\u0004\u0018\u0001`D2\b\b\u0002\u0010E\u001a\u00020F2\b\b\u0002\u0010G\u001a\u000207H\u0096\u0001J\u001b\u0010\u0004\u001a\u00020\u00012\u0006\u0010K\u001a\u00020L2\b\b\u0002\u0010E\u001a\u00020FH\u0096\u0001J\u001b\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00132\b\b\u0002\u0010E\u001a\u00020FH\u0096\u0001J&\u0010M\u001a\u00020\u00002\u001c\u0010M\u001a\u0018\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020I0\tj\u0002`NH\u0007J$\u0010O\u001a\u00020\u00002\u001c\u0010M\u001a\u0018\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020I0\tj\u0002`PJ\u001b\u0010Q\u001a\f\u0012\u0004\u0012\u00020\u00130Rj\u0002`S2\u0006\u0010<\u001a\u00020\u0013H\u0096\u0003J(\u0010T\u001a\u0004\u0018\u0001HU\"\b\b\u0000\u0010U*\u00020'2\f\u0010V\u001a\b\u0012\u0004\u0012\u0002HU0WH\u0096\u0001¢\u0006\u0002\u0010XJ:\u0010<\u001a\u00020\u00012*\u00109\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020'0\u000b0:\"\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020'0\u000bH\u0096\u0001¢\u0006\u0002\u0010;J\u001b\u0010<\u001a\f\u0012\u0004\u0012\u00020\u00130Rj\u0002`S2\u0006\u0010<\u001a\u00020\u0013H\u0096\u0001J\u0019\u0010<\u001a\u00020\u00012\u0006\u0010<\u001a\u00020\u00132\u0006\u0010=\u001a\u00020'H\u0096\u0001J*\u0010<\u001a\u00020\u00012\u0006\u0010<\u001a\u00020\u00132\u0012\u0010>\u001a\n\u0012\u0006\b\u0001\u0012\u00020'0:\"\u00020'H\u0096\u0001¢\u0006\u0002\u0010?J\u001d\u0010<\u001a\u00020\u00012\u0006\u0010<\u001a\u00020\u00132\n\u0010>\u001a\u0006\u0012\u0002\b\u00030RH\u0096\u0001J\u001d\u0010<\u001a\u00020\u00012\u0012\u0010Y\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020'0ZH\u0096\u0001J!\u0010[\u001a\u00020\u00012\u0016\u0010[\u001a\u0012\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020]0\\j\u0002`^H\u0096\u0001JB\u0010_\u001a\u00020\u00012:\u0010_\u001a6\u0012\u0013\u0012\u00110C¢\u0006\f\b`\u0012\b\ba\u0012\u0004\b\b(b\u0012\u0013\u0012\u00110C¢\u0006\f\b`\u0012\b\ba\u0012\u0004\b\b(c\u0012\u0004\u0012\u00020]0\tj\u0002`dJE\u0010e\u001a\u00020\u00012:\u0010f\u001a6\u0012\u0013\u0012\u00110C¢\u0006\f\b`\u0012\b\ba\u0012\u0004\b\b(b\u0012\u0013\u0012\u00110C¢\u0006\f\b`\u0012\b\ba\u0012\u0004\b\b(c\u0012\u0004\u0012\u00020]0\tj\u0002`dH\u0096\u0001J1\u0010g\u001a*\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\n\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020L\u0012\u0004\u0012\u00020j0i0hj\b\u0012\u0004\u0012\u00020L`kH\u0096\u0001J\u0017\u0010g\u001a\u00020l2\f\u0010f\u001a\b\u0012\u0004\u0012\u00020L0mH\u0096\u0001J\u0017\u0010g\u001a\u00020l2\f\u0010f\u001a\b\u0012\u0004\u0012\u00020L0nH\u0096\u0001J?\u0010g\u001a\u00020l24\u0010f\u001a0\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\n\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020L\u0012\u0004\u0012\u00020j0i\u0012\u0004\u0012\u00020]0oj\b\u0012\u0004\u0012\u00020L`pH\u0096\u0001J3\u0010g\u001a\u00020l2(\u0010f\u001a$\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020L\u0012\u0004\u0012\u00020j0i\u0012\u0004\u0012\u00020]0\\j\b\u0012\u0004\u0012\u00020L`qH\u0096\u0001JI\u0010r\u001a*\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\n\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002HU\u0012\u0004\u0012\u00020j0i0hj\b\u0012\u0004\u0012\u0002HU`k\"\b\b\u0000\u0010U*\u00020'2\f\u0010s\u001a\b\u0012\u0004\u0012\u0002HU0tH\u0096\u0001J/\u0010r\u001a\u00020l\"\b\b\u0000\u0010U*\u00020'2\f\u0010s\u001a\b\u0012\u0004\u0012\u0002HU0t2\f\u0010f\u001a\b\u0012\u0004\u0012\u0002HU0mH\u0096\u0001J/\u0010r\u001a\u00020l\"\b\b\u0000\u0010U*\u00020'2\f\u0010s\u001a\b\u0012\u0004\u0012\u0002HU0t2\f\u0010f\u001a\b\u0012\u0004\u0012\u0002HU0nH\u0096\u0001JW\u0010r\u001a\u00020l\"\b\b\u0000\u0010U*\u00020'2\f\u0010s\u001a\b\u0012\u0004\u0012\u0002HU0t24\u0010f\u001a0\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\n\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002HU\u0012\u0004\u0012\u00020j0i\u0012\u0004\u0012\u00020]0oj\b\u0012\u0004\u0012\u0002HU`pH\u0096\u0001JK\u0010r\u001a\u00020l\"\b\b\u0000\u0010U*\u00020'2\f\u0010s\u001a\b\u0012\u0004\u0012\u0002HU0t2(\u0010f\u001a$\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002HU\u0012\u0004\u0012\u00020j0i\u0012\u0004\u0012\u00020]0\\j\b\u0012\u0004\u0012\u0002HU`qH\u0096\u0001JE\u0010u\u001a\u00020\u00012:\u0010f\u001a6\u0012\u0013\u0012\u00110C¢\u0006\f\b`\u0012\b\ba\u0012\u0004\b\b(b\u0012\u0013\u0012\u00110C¢\u0006\f\b`\u0012\b\ba\u0012\u0004\b\b(c\u0012\u0004\u0012\u00020]0\tj\u0002`dH\u0096\u0001J1\u0010v\u001a*\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\n\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020j0i0hj\b\u0012\u0004\u0012\u00020\u0013`kH\u0096\u0001J\u0017\u0010v\u001a\u00020l2\f\u0010f\u001a\b\u0012\u0004\u0012\u00020\u00130mH\u0096\u0001J\u0017\u0010v\u001a\u00020l2\f\u0010f\u001a\b\u0012\u0004\u0012\u00020\u00130nH\u0096\u0001J?\u0010v\u001a\u00020l24\u0010f\u001a0\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\n\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020j0i\u0012\u0004\u0012\u00020]0oj\b\u0012\u0004\u0012\u00020\u0013`pH\u0096\u0001J3\u0010v\u001a\u00020l2(\u0010f\u001a$\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020j0i\u0012\u0004\u0012\u00020]0\\j\b\u0012\u0004\u0012\u00020\u0013`qH\u0096\u0001J;\u0010v\u001a*\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\n\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020j0i0hj\b\u0012\u0004\u0012\u00020\u0013`k2\b\b\u0002\u0010E\u001a\u00020FH\u0096\u0001J!\u0010v\u001a\u00020l2\b\b\u0002\u0010E\u001a\u00020F2\f\u0010f\u001a\b\u0012\u0004\u0012\u00020\u00130mH\u0096\u0001J!\u0010v\u001a\u00020l2\b\b\u0002\u0010E\u001a\u00020F2\f\u0010f\u001a\b\u0012\u0004\u0012\u00020\u00130nH\u0096\u0001JI\u0010v\u001a\u00020l2\b\b\u0002\u0010E\u001a\u00020F24\u0010f\u001a0\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\n\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020j0i\u0012\u0004\u0012\u00020]0oj\b\u0012\u0004\u0012\u00020\u0013`pH\u0096\u0001J=\u0010v\u001a\u00020l2\b\b\u0002\u0010E\u001a\u00020F2(\u0010f\u001a$\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020j0i\u0012\u0004\u0012\u00020]0\\j\b\u0012\u0004\u0012\u00020\u0013`qH\u0096\u0001J\u0019\u0010w\u001a\u00020\u00012\u0006\u0010<\u001a\u00020\u00132\u0006\u0010=\u001a\u00020'H\u0096\u0003J\u001d\u0010w\u001a\u00020\u00012\u0006\u0010<\u001a\u00020\u00132\n\u0010>\u001a\u0006\u0012\u0002\b\u00030RH\u0096\u0003J:\u0010x\u001a\u00020\u000022\u0010M\u001a.\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\f\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u000e0\rj\u0002`\u000f0\u000b0\tj\u0002`\u0010J\u0011\u0010y\u001a\u00020\u00012\u0006\u0010z\u001a\u00020'H\u0096\u0001J\u0011\u0010{\u001a\u00020\u00012\u0006\u0010{\u001a\u00020|H\u0096\u0001J\u0011\u0010}\u001a\u00020\u00012\u0006\u0010{\u001a\u00020|H\u0096\u0001J\b\u0010~\u001a\u00020\u0013H\u0016J\u0018\u0010\u007f\u001a\u00020\n2\u0006\u0010-\u001a\u00020\u00012\u0006\u0010g\u001a\u00020\nH\u0002J\u0013\u0010\u0080\u0001\u001a\u00020\u00012\u0007\u0010\u0080\u0001\u001a\u000207H\u0096\u0001J$\u0010\u0081\u0001\u001a\u00020\u00012\u0018\u0010\u0082\u0001\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u0002070\\j\u0003`\u0083\u0001H\u0096\u0001R\u0012\u0010\u0004\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R:\u0010\b\u001a.\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0001\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\f\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u000e0\rj\u0002`\u000f0\u000b0\tj\u0002`\u0010X\u0082.¢\u0006\u0002\n\u0000R\"\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00010\u0012j\u0002`\u0014X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0017\u001a\u00020\u0018X\u0096\u000f¢\u0006\f\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0012\u0010\u001d\u001a\u00020\u001eX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0012\u0010!\u001a\u00020\"X\u0096\u0005¢\u0006\u0006\u001a\u0004\b#\u0010$R0\u0010%\u001a\u001a\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0006\u0012\u0004\u0018\u00010'0\u000b0&j\u0002`(X\u0096\u000f¢\u0006\f\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0014\u0010-\u001a\u00020\u0000X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0018\u00100\u001a\u000201X\u0096\u000f¢\u0006\f\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0085\u0001"}, d2 = {"Lcom/github/kittinunf/fuel/core/requests/DownloadRequest;", "Lcom/github/kittinunf/fuel/core/Request;", "wrapped", "(Lcom/github/kittinunf/fuel/core/Request;)V", "body", "Lcom/github/kittinunf/fuel/core/Body;", "getBody", "()Lcom/github/kittinunf/fuel/core/Body;", "destinationCallback", "Lkotlin/Function2;", "Lcom/github/kittinunf/fuel/core/Response;", "Lkotlin/Pair;", "Ljava/io/OutputStream;", "Lkotlin/Function0;", "Ljava/io/InputStream;", "Lcom/github/kittinunf/fuel/core/requests/DestinationAsStreamCallback;", "Lcom/github/kittinunf/fuel/core/requests/StreamDestinationCallback;", "enabledFeatures", "", "", "Lcom/github/kittinunf/fuel/core/RequestFeatures;", "getEnabledFeatures", "()Ljava/util/Map;", "executionOptions", "Lcom/github/kittinunf/fuel/core/RequestExecutionOptions;", "getExecutionOptions", "()Lcom/github/kittinunf/fuel/core/RequestExecutionOptions;", "setExecutionOptions", "(Lcom/github/kittinunf/fuel/core/RequestExecutionOptions;)V", "headers", "Lcom/github/kittinunf/fuel/core/Headers;", "getHeaders", "()Lcom/github/kittinunf/fuel/core/Headers;", "method", "Lcom/github/kittinunf/fuel/core/Method;", "getMethod", "()Lcom/github/kittinunf/fuel/core/Method;", "parameters", "", "", "Lcom/github/kittinunf/fuel/core/Parameters;", "getParameters", "()Ljava/util/List;", "setParameters", "(Ljava/util/List;)V", "request", "getRequest", "()Lcom/github/kittinunf/fuel/core/requests/DownloadRequest;", "url", "Ljava/net/URL;", "getUrl", "()Ljava/net/URL;", "setUrl", "(Ljava/net/URL;)V", "allowRedirects", "", "appendHeader", "pairs", "", "([Lkotlin/Pair;)Lcom/github/kittinunf/fuel/core/Request;", "header", "value", "values", "(Ljava/lang/String;[Ljava/lang/Object;)Lcom/github/kittinunf/fuel/core/Request;", "openStream", "Lcom/github/kittinunf/fuel/core/BodySource;", "calculateLength", "", "Lcom/github/kittinunf/fuel/core/BodyLength;", "charset", "Ljava/nio/charset/Charset;", "repeatable", "file", "Ljava/io/File;", "stream", "bytes", "", "destination", "Lcom/github/kittinunf/fuel/core/requests/LegacyDestinationCallback;", "fileDestination", "Lcom/github/kittinunf/fuel/core/requests/FileDestinationCallback;", "get", "", "Lcom/github/kittinunf/fuel/core/HeaderValues;", "getTag", ExifInterface.GPS_DIRECTION_TRUE, "clazz", "Lkotlin/reflect/KClass;", "(Lkotlin/reflect/KClass;)Ljava/lang/Object;", "map", "", "interrupt", "Lkotlin/Function1;", "", "Lcom/github/kittinunf/fuel/core/InterruptCallback;", "progress", "Lkotlin/ParameterName;", "name", "readBytes", "totalBytes", "Lcom/github/kittinunf/fuel/core/ProgressCallback;", "requestProgress", "handler", "response", "Lkotlin/Triple;", "Lcom/github/kittinunf/result/Result;", "Lcom/github/kittinunf/fuel/core/FuelError;", "Lcom/github/kittinunf/fuel/core/ResponseResultOf;", "Lcom/github/kittinunf/fuel/core/requests/CancellableRequest;", "Lcom/github/kittinunf/fuel/core/Handler;", "Lcom/github/kittinunf/fuel/core/ResponseHandler;", "Lkotlin/Function3;", "Lcom/github/kittinunf/fuel/core/ResponseResultHandler;", "Lcom/github/kittinunf/fuel/core/ResultHandler;", "responseObject", "deserializer", "Lcom/github/kittinunf/fuel/core/ResponseDeserializable;", "responseProgress", "responseString", "set", "streamDestination", "tag", "t", "timeout", "", "timeoutRead", "toString", "transformResponse", "useHttpCache", "validate", "validator", "Lcom/github/kittinunf/fuel/core/ResponseValidator;", "Companion", "fuel"}, k = 1, mv = {1, 4, 0})
public final class DownloadRequest implements Request {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String FEATURE;
    private Function2<? super Response, ? super Request, ? extends Pair<? extends OutputStream, ? extends Function0<? extends InputStream>>> destinationCallback;
    private final DownloadRequest request;
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
    public Request useHttpCache(boolean useHttpCache) {
        return this.wrapped.useHttpCache(useHttpCache);
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public Request validate(Function1<? super Response, Boolean> validator) {
        Intrinsics.checkNotNullParameter(validator, "validator");
        return this.wrapped.validate(validator);
    }

    private DownloadRequest(Request request) {
        this.wrapped = request;
        this.request = this;
        getExecutionOptions().plusAssign(new AnonymousClass1(this));
    }

    public /* synthetic */ DownloadRequest(Request request, DefaultConstructorMarker defaultConstructorMarker) {
        this(request);
    }

    @Override // com.github.kittinunf.fuel.core.RequestFactory.RequestConvertible
    public DownloadRequest getRequest() {
        return this.request;
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public String toString() {
        return "Download[\n\r\t" + this.wrapped + "\n\r]";
    }

    /* JADX INFO: renamed from: com.github.kittinunf.fuel.core.requests.DownloadRequest$1, reason: invalid class name */
    /* JADX INFO: compiled from: DownloadRequest.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lcom/github/kittinunf/fuel/core/Response;", "p1", "Lcom/github/kittinunf/fuel/core/Request;", "p2", "invoke"}, k = 3, mv = {1, 4, 0})
    static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function2<Request, Response, Response> {
        AnonymousClass1(DownloadRequest downloadRequest) {
            super(2, downloadRequest, DownloadRequest.class, "transformResponse", "transformResponse(Lcom/github/kittinunf/fuel/core/Request;Lcom/github/kittinunf/fuel/core/Response;)Lcom/github/kittinunf/fuel/core/Response;", 0);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Response invoke(Request p1, Response p2) {
            Intrinsics.checkNotNullParameter(p1, "p1");
            Intrinsics.checkNotNullParameter(p2, "p2");
            return ((DownloadRequest) this.receiver).transformResponse(p1, p2);
        }
    }

    /* JADX INFO: renamed from: com.github.kittinunf.fuel.core.requests.DownloadRequest$destination$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DownloadRequest.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "Ljava/io/File;", "response", "Lcom/github/kittinunf/fuel/core/Response;", "request", "Lcom/github/kittinunf/fuel/core/Request;", "invoke"}, k = 3, mv = {1, 4, 0})
    static final class C01941 extends Lambda implements Function2<Response, Request, File> {
        final /* synthetic */ Function2 $destination;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C01941(Function2 function2) {
            super(2);
            this.$destination = function2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final File invoke(Response response, Request request) {
            Intrinsics.checkNotNullParameter(response, "response");
            Intrinsics.checkNotNullParameter(request, "request");
            return (File) this.$destination.invoke(response, request.getUrl());
        }
    }

    @Deprecated(message = "Use fileDestination with (Request, Response) -> File")
    public final DownloadRequest destination(Function2<? super Response, ? super URL, ? extends File> destination) {
        Intrinsics.checkNotNullParameter(destination, "destination");
        return fileDestination(new C01941(destination));
    }

    /* JADX INFO: renamed from: com.github.kittinunf.fuel.core.requests.DownloadRequest$fileDestination$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DownloadRequest.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00040\u0003j\u0002`\u00050\u00012\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\n¢\u0006\u0002\b\n"}, d2 = {"<anonymous>", "Lkotlin/Pair;", "Ljava/io/OutputStream;", "Lkotlin/Function0;", "Ljava/io/InputStream;", "Lcom/github/kittinunf/fuel/core/requests/DestinationAsStreamCallback;", "response", "Lcom/github/kittinunf/fuel/core/Response;", "request", "Lcom/github/kittinunf/fuel/core/Request;", "invoke"}, k = 3, mv = {1, 4, 0})
    static final class C01951 extends Lambda implements Function2<Response, Request, Pair<? extends OutputStream, ? extends Function0<? extends InputStream>>> {
        final /* synthetic */ Function2 $destination;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C01951(Function2 function2) {
            super(2);
            this.$destination = function2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Pair<OutputStream, Function0<InputStream>> invoke(Response response, Request request) {
            Intrinsics.checkNotNullParameter(response, "response");
            Intrinsics.checkNotNullParameter(request, "request");
            File file = (File) this.$destination.invoke(response, request);
            return new Pair<>(new FileOutputStream(file), new DownloadRequest$fileDestination$1$1$1(file));
        }
    }

    public final DownloadRequest fileDestination(Function2<? super Response, ? super Request, ? extends File> destination) {
        Intrinsics.checkNotNullParameter(destination, "destination");
        return streamDestination(new C01951(destination));
    }

    public final DownloadRequest streamDestination(Function2<? super Response, ? super Request, ? extends Pair<? extends OutputStream, ? extends Function0<? extends InputStream>>> destination) {
        Intrinsics.checkNotNullParameter(destination, "destination");
        this.destinationCallback = destination;
        return getRequest();
    }

    public final Request progress(Function2<? super Long, ? super Long, Unit> progress) {
        Intrinsics.checkNotNullParameter(progress, "progress");
        return responseProgress(progress);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Response transformResponse(Request request, Response response) {
        Function2<? super Response, ? super Request, ? extends Pair<? extends OutputStream, ? extends Function0<? extends InputStream>>> function2 = this.destinationCallback;
        if (function2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("destinationCallback");
        }
        Pair<? extends OutputStream, ? extends Function0<? extends InputStream>> pairInvoke = function2.invoke(response, request);
        OutputStream outputStreamComponent1 = pairInvoke.component1();
        Function0<? extends InputStream> function0Component2 = pairInvoke.component2();
        OutputStream outputStream = outputStreamComponent1;
        try {
            OutputStream outputStream2 = outputStream;
            InputStream stream = response.getBody$fuel().toStream();
            try {
                ByteStreamsKt.copyTo$default(stream, outputStream2, 0, 2, null);
                CloseableKt.closeFinally(stream, null);
                CloseableKt.closeFinally(outputStream, null);
                return Response.copy$default(response, null, 0, null, null, 0L, DefaultBody.Companion.from$default(DefaultBody.INSTANCE, function0Component2, null, null, 4, null), 31, null);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(stream, th);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            try {
                throw th3;
            } catch (Throwable th4) {
                CloseableKt.closeFinally(outputStream, th3);
                throw th4;
            }
        }
    }

    /* JADX INFO: compiled from: DownloadRequest.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/github/kittinunf/fuel/core/requests/DownloadRequest$Companion;", "", "()V", "FEATURE", "", "getFEATURE", "()Ljava/lang/String;", "enableFor", "Lcom/github/kittinunf/fuel/core/requests/DownloadRequest;", "request", "Lcom/github/kittinunf/fuel/core/Request;", "fuel"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String getFEATURE() {
            return DownloadRequest.FEATURE;
        }

        public final DownloadRequest enableFor(Request request) {
            Intrinsics.checkNotNullParameter(request, "request");
            Map<String, Request> enabledFeatures = request.getEnabledFeatures();
            String feature = getFEATURE();
            DownloadRequest downloadRequest = enabledFeatures.get(feature);
            if (downloadRequest == null) {
                downloadRequest = new DownloadRequest(request, null);
                enabledFeatures.put(feature, downloadRequest);
            }
            return (DownloadRequest) downloadRequest;
        }
    }

    static {
        String canonicalName = DownloadRequest.class.getCanonicalName();
        Intrinsics.checkNotNullExpressionValue(canonicalName, "DownloadRequest::class.java.canonicalName");
        FEATURE = canonicalName;
    }
}
