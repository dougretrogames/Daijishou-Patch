package com.github.kittinunf.fuel.core.requests;

import androidx.exifinterface.media.ExifInterface;
import com.github.kittinunf.fuel.core.Body;
import com.github.kittinunf.fuel.core.DeserializableKt;
import com.github.kittinunf.fuel.core.FuelError;
import com.github.kittinunf.fuel.core.Handler;
import com.github.kittinunf.fuel.core.Headers;
import com.github.kittinunf.fuel.core.Method;
import com.github.kittinunf.fuel.core.Request;
import com.github.kittinunf.fuel.core.RequestExecutionOptions;
import com.github.kittinunf.fuel.core.Response;
import com.github.kittinunf.fuel.core.ResponseDeserializable;
import com.github.kittinunf.fuel.core.ResponseHandler;
import com.github.kittinunf.fuel.core.deserializers.ByteArrayDeserializer;
import com.github.kittinunf.fuel.core.deserializers.StringDeserializer;
import com.github.kittinunf.result.Result;
import com.magneticchen.daijishou.daijishou_player.DaijishouPlayerTemplate;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.apache.http.message.TokenParser;
import org.apache.http.protocol.HTTP;
import org.eclipse.jgit.lib.ConfigConstants;

/* INFO: compiled from: DefaultRequest.kt */
/* INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u008e\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\f\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0083\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012 \b\u0002\u0010\b\u001a\u001a\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\n0\tj\u0002`\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\u0018\b\u0002\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\u0011j\u0002`\u0012\u0012\u001c\b\u0002\u0010\u0013\u001a\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0014\u0012\u0004\u0012\u00020\f0\u0011j\u0002`\u0015¢\u0006\u0002\u0010\u0016J\u0010\u00104\u001a\u00020\u00012\u0006\u00104\u001a\u000205H\u0016J9\u00106\u001a\u00020\u00012*\u00107\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n08\"\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nH\u0016¢\u0006\u0002\u00109J\u0018\u00106\u001a\u00020\u00012\u0006\u0010:\u001a\u00020\u000b2\u0006\u0010;\u001a\u00020\fH\u0016J)\u00106\u001a\u00020\u00012\u0006\u0010:\u001a\u00020\u000b2\u0012\u0010<\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f08\"\u00020\fH\u0016¢\u0006\u0002\u0010=J\u0010\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u000fH\u0016J@\u0010\u001b\u001a\u00020\u00012\u0010\u0010>\u001a\f\u0012\u0004\u0012\u00020@0?j\u0002`A2\u0014\u0010B\u001a\u0010\u0012\u0004\u0012\u00020C\u0018\u00010?j\u0004\u0018\u0001`D2\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u000205H\u0016J\u0018\u0010\u001b\u001a\u00020\u00012\u0006\u0010H\u001a\u00020I2\u0006\u0010E\u001a\u00020FH\u0016J6\u0010\u001b\u001a\u00020\u00012\u0006\u0010J\u001a\u00020@2\u0014\u0010B\u001a\u0010\u0012\u0004\u0012\u00020C\u0018\u00010?j\u0004\u0018\u0001`D2\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u000205H\u0016J\u0018\u0010\u001b\u001a\u00020\u00012\u0006\u0010K\u001a\u00020L2\u0006\u0010E\u001a\u00020FH\u0016J\u0018\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u000b2\u0006\u0010E\u001a\u00020FH\u0016J\t\u0010M\u001a\u00020\u0003HÆ\u0003J\t\u0010N\u001a\u00020\u0005HÆ\u0003J\t\u0010O\u001a\u00020\u0007HÆ\u0003J!\u0010P\u001a\u001a\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\n0\tj\u0002`\rHÆ\u0003J\u000e\u0010Q\u001a\u00020\u000fHÀ\u0003¢\u0006\u0002\bRJ\u0019\u0010S\u001a\u0012\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\u0011j\u0002`\u0012HÆ\u0003J\u001d\u0010T\u001a\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0014\u0012\u0004\u0012\u00020\f0\u0011j\u0002`\u0015HÂ\u0003J\u008b\u0001\u0010U\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072 \b\u0002\u0010\b\u001a\u001a\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\n0\tj\u0002`\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u0018\b\u0002\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\u0011j\u0002`\u00122\u001c\b\u0002\u0010\u0013\u001a\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0014\u0012\u0004\u0012\u00020\f0\u0011j\u0002`\u0015HÆ\u0001J\u0013\u0010V\u001a\u0002052\b\u0010W\u001a\u0004\u0018\u00010\fHÖ\u0003J\u001b\u0010X\u001a\f\u0012\u0004\u0012\u00020\u000b0Yj\u0002`Z2\u0006\u0010:\u001a\u00020\u000bH\u0096\u0002J'\u0010[\u001a\u0004\u0018\u0001H\\\"\b\b\u0000\u0010\\*\u00020\f2\f\u0010]\u001a\b\u0012\u0004\u0012\u0002H\\0\u0014H\u0016¢\u0006\u0002\u0010^J\t\u0010_\u001a\u00020`HÖ\u0001J9\u0010:\u001a\u00020\u00012*\u00107\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n08\"\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nH\u0016¢\u0006\u0002\u00109J\u001a\u0010:\u001a\f\u0012\u0004\u0012\u00020\u000b0Yj\u0002`Z2\u0006\u0010:\u001a\u00020\u000bH\u0016J\u0018\u0010:\u001a\u00020\u00012\u0006\u0010:\u001a\u00020\u000b2\u0006\u0010;\u001a\u00020\fH\u0016J)\u0010:\u001a\u00020\u00012\u0006\u0010:\u001a\u00020\u000b2\u0012\u0010<\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f08\"\u00020\fH\u0016¢\u0006\u0002\u0010=J\u001c\u0010:\u001a\u00020\u00012\u0006\u0010:\u001a\u00020\u000b2\n\u0010<\u001a\u0006\u0012\u0002\b\u00030YH\u0016J\u001c\u0010:\u001a\u00020\u00012\u0012\u0010a\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0bH\u0016J \u0010c\u001a\u00020\u00012\u0016\u0010c\u001a\u0012\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020e0dj\u0002`fH\u0016JD\u0010g\u001a\u00020\u00012:\u0010h\u001a6\u0012\u0013\u0012\u00110C¢\u0006\f\bj\u0012\b\bk\u0012\u0004\b\b(l\u0012\u0013\u0012\u00110C¢\u0006\f\bj\u0012\b\bk\u0012\u0004\b\b(m\u0012\u0004\u0012\u00020e0ij\u0002`nH\u0016J0\u0010o\u001a*\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020q\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020L\u0012\u0004\u0012\u00020s0r0pj\b\u0012\u0004\u0012\u00020L`tH\u0016J\u0016\u0010o\u001a\u00020u2\f\u0010h\u001a\b\u0012\u0004\u0012\u00020L0vH\u0016J\u0016\u0010o\u001a\u00020u2\f\u0010h\u001a\b\u0012\u0004\u0012\u00020L0wH\u0016J>\u0010o\u001a\u00020u24\u0010h\u001a0\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020q\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020L\u0012\u0004\u0012\u00020s0r\u0012\u0004\u0012\u00020e0xj\b\u0012\u0004\u0012\u00020L`yH\u0016J2\u0010o\u001a\u00020u2(\u0010h\u001a$\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020L\u0012\u0004\u0012\u00020s0r\u0012\u0004\u0012\u00020e0dj\b\u0012\u0004\u0012\u00020L`zH\u0016JH\u0010{\u001a*\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020q\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\\\u0012\u0004\u0012\u00020s0r0pj\b\u0012\u0004\u0012\u0002H\\`t\"\b\b\u0000\u0010\\*\u00020\f2\f\u0010|\u001a\b\u0012\u0004\u0012\u0002H\\0}H\u0016J.\u0010{\u001a\u00020u\"\b\b\u0000\u0010\\*\u00020\f2\f\u0010|\u001a\b\u0012\u0004\u0012\u0002H\\0}2\f\u0010h\u001a\b\u0012\u0004\u0012\u0002H\\0vH\u0016J.\u0010{\u001a\u00020u\"\b\b\u0000\u0010\\*\u00020\f2\f\u0010|\u001a\b\u0012\u0004\u0012\u0002H\\0}2\f\u0010h\u001a\b\u0012\u0004\u0012\u0002H\\0wH\u0016JV\u0010{\u001a\u00020u\"\b\b\u0000\u0010\\*\u00020\f2\f\u0010|\u001a\b\u0012\u0004\u0012\u0002H\\0}24\u0010h\u001a0\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020q\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\\\u0012\u0004\u0012\u00020s0r\u0012\u0004\u0012\u00020e0xj\b\u0012\u0004\u0012\u0002H\\`yH\u0016JJ\u0010{\u001a\u00020u\"\b\b\u0000\u0010\\*\u00020\f2\f\u0010|\u001a\b\u0012\u0004\u0012\u0002H\\0}2(\u0010h\u001a$\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\\\u0012\u0004\u0012\u00020s0r\u0012\u0004\u0012\u00020e0dj\b\u0012\u0004\u0012\u0002H\\`zH\u0016JD\u0010~\u001a\u00020\u00012:\u0010h\u001a6\u0012\u0013\u0012\u00110C¢\u0006\f\bj\u0012\b\bk\u0012\u0004\b\b(l\u0012\u0013\u0012\u00110C¢\u0006\f\bj\u0012\b\bk\u0012\u0004\b\b(m\u0012\u0004\u0012\u00020e0ij\u0002`nH\u0016J0\u0010\u007f\u001a*\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020q\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020s0r0pj\b\u0012\u0004\u0012\u00020\u000b`tH\u0016J\u0016\u0010\u007f\u001a\u00020u2\f\u0010h\u001a\b\u0012\u0004\u0012\u00020\u000b0vH\u0016J\u0016\u0010\u007f\u001a\u00020u2\f\u0010h\u001a\b\u0012\u0004\u0012\u00020\u000b0wH\u0016J>\u0010\u007f\u001a\u00020u24\u0010h\u001a0\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020q\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020s0r\u0012\u0004\u0012\u00020e0xj\b\u0012\u0004\u0012\u00020\u000b`yH\u0016J2\u0010\u007f\u001a\u00020u2(\u0010h\u001a$\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020s0r\u0012\u0004\u0012\u00020e0dj\b\u0012\u0004\u0012\u00020\u000b`zH\u0016J8\u0010\u007f\u001a*\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020q\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020s0r0pj\b\u0012\u0004\u0012\u00020\u000b`t2\u0006\u0010E\u001a\u00020FH\u0016J\u001e\u0010\u007f\u001a\u00020u2\u0006\u0010E\u001a\u00020F2\f\u0010h\u001a\b\u0012\u0004\u0012\u00020\u000b0vH\u0016J\u001e\u0010\u007f\u001a\u00020u2\u0006\u0010E\u001a\u00020F2\f\u0010h\u001a\b\u0012\u0004\u0012\u00020\u000b0wH\u0016JF\u0010\u007f\u001a\u00020u2\u0006\u0010E\u001a\u00020F24\u0010h\u001a0\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020q\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020s0r\u0012\u0004\u0012\u00020e0xj\b\u0012\u0004\u0012\u00020\u000b`yH\u0016J:\u0010\u007f\u001a\u00020u2\u0006\u0010E\u001a\u00020F2(\u0010h\u001a$\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020s0r\u0012\u0004\u0012\u00020e0dj\b\u0012\u0004\u0012\u00020\u000b`zH\u0016J\u001a\u0010\u0080\u0001\u001a\u00020\u00012\u0006\u0010:\u001a\u00020\u000b2\u0006\u0010;\u001a\u00020\fH\u0096\u0002J\u001e\u0010\u0080\u0001\u001a\u00020\u00012\u0006\u0010:\u001a\u00020\u000b2\n\u0010<\u001a\u0006\u0012\u0002\b\u00030YH\u0096\u0002J\u0012\u0010\u0081\u0001\u001a\u00020\u00012\u0007\u0010\u0082\u0001\u001a\u00020\fH\u0016J\u0012\u0010\u0083\u0001\u001a\u00020\u00012\u0007\u0010\u0083\u0001\u001a\u00020`H\u0016J\u0012\u0010\u0084\u0001\u001a\u00020\u00012\u0007\u0010\u0083\u0001\u001a\u00020`H\u0016J\t\u0010\u0085\u0001\u001a\u00020\u000bH\u0016J\u0012\u0010\u0086\u0001\u001a\u00020\u00012\u0007\u0010\u0086\u0001\u001a\u000205H\u0016J#\u0010\u0087\u0001\u001a\u00020\u00012\u0018\u0010\u0088\u0001\u001a\u0013\u0012\u0004\u0012\u00020q\u0012\u0004\u0012\u0002050dj\u0003`\u0089\u0001H\u0016R\u001a\u0010\u000e\u001a\u00020\u000fX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0018R$\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00010\u0011j\u0002`\u0012X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020 X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R2\u0010\b\u001a\u001a\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\f0\n0\tj\u0002`\rX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u0014\u0010-\u001a\u00020\u00018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/R\"\u0010\u0013\u001a\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0014\u0012\u0004\u0012\u00020\f0\u0011j\u0002`\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103¨\u0006\u008a\u0001"}, d2 = {"Lcom/github/kittinunf/fuel/core/requests/DefaultRequest;", "Lcom/github/kittinunf/fuel/core/Request;", "method", "Lcom/github/kittinunf/fuel/core/Method;", "url", "Ljava/net/URL;", "headers", "Lcom/github/kittinunf/fuel/core/Headers;", "parameters", "", "Lkotlin/Pair;", "", "", "Lcom/github/kittinunf/fuel/core/Parameters;", "_body", "Lcom/github/kittinunf/fuel/core/Body;", "enabledFeatures", "", "Lcom/github/kittinunf/fuel/core/RequestFeatures;", DaijishouPlayerTemplate.templateTagPrefix, "Lkotlin/reflect/KClass;", "Lcom/github/kittinunf/fuel/core/Tags;", "(Lcom/github/kittinunf/fuel/core/Method;Ljava/net/URL;Lcom/github/kittinunf/fuel/core/Headers;Ljava/util/List;Lcom/github/kittinunf/fuel/core/Body;Ljava/util/Map;Ljava/util/Map;)V", "get_body$fuel", "()Lcom/github/kittinunf/fuel/core/Body;", "set_body$fuel", "(Lcom/github/kittinunf/fuel/core/Body;)V", "body", "getBody", "getEnabledFeatures", "()Ljava/util/Map;", "executionOptions", "Lcom/github/kittinunf/fuel/core/RequestExecutionOptions;", "getExecutionOptions", "()Lcom/github/kittinunf/fuel/core/RequestExecutionOptions;", "setExecutionOptions", "(Lcom/github/kittinunf/fuel/core/RequestExecutionOptions;)V", "getHeaders", "()Lcom/github/kittinunf/fuel/core/Headers;", "getMethod", "()Lcom/github/kittinunf/fuel/core/Method;", "getParameters", "()Ljava/util/List;", "setParameters", "(Ljava/util/List;)V", "request", "getRequest", "()Lcom/github/kittinunf/fuel/core/Request;", "getUrl", "()Ljava/net/URL;", "setUrl", "(Ljava/net/URL;)V", "allowRedirects", "", "appendHeader", "pairs", "", "([Lkotlin/Pair;)Lcom/github/kittinunf/fuel/core/Request;", "header", "value", "values", "(Ljava/lang/String;[Ljava/lang/Object;)Lcom/github/kittinunf/fuel/core/Request;", "openStream", "Lkotlin/Function0;", "Ljava/io/InputStream;", "Lcom/github/kittinunf/fuel/core/BodySource;", "calculateLength", "", "Lcom/github/kittinunf/fuel/core/BodyLength;", "charset", "Ljava/nio/charset/Charset;", "repeatable", "file", "Ljava/io/File;", "stream", "bytes", "", "component1", "component2", "component3", "component4", "component5", "component5$fuel", "component6", "component7", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "other", "get", "", "Lcom/github/kittinunf/fuel/core/HeaderValues;", "getTag", ExifInterface.GPS_DIRECTION_TRUE, "clazz", "(Lkotlin/reflect/KClass;)Ljava/lang/Object;", "hashCode", "", "map", "", "interrupt", "Lkotlin/Function1;", "", "Lcom/github/kittinunf/fuel/core/InterruptCallback;", "requestProgress", "handler", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "readBytes", "totalBytes", "Lcom/github/kittinunf/fuel/core/ProgressCallback;", "response", "Lkotlin/Triple;", "Lcom/github/kittinunf/fuel/core/Response;", "Lcom/github/kittinunf/result/Result;", "Lcom/github/kittinunf/fuel/core/FuelError;", "Lcom/github/kittinunf/fuel/core/ResponseResultOf;", "Lcom/github/kittinunf/fuel/core/requests/CancellableRequest;", "Lcom/github/kittinunf/fuel/core/Handler;", "Lcom/github/kittinunf/fuel/core/ResponseHandler;", "Lkotlin/Function3;", "Lcom/github/kittinunf/fuel/core/ResponseResultHandler;", "Lcom/github/kittinunf/fuel/core/ResultHandler;", "responseObject", "deserializer", "Lcom/github/kittinunf/fuel/core/ResponseDeserializable;", "responseProgress", "responseString", "set", "tag", "t", "timeout", "timeoutRead", "toString", "useHttpCache", "validate", "validator", "Lcom/github/kittinunf/fuel/core/ResponseValidator;", "fuel"}, k = 1, mv = {1, 4, 0})
public final /* data */ class DefaultRequest implements Request {
    private Body _body;
    private final Map<String, Request> enabledFeatures;
    public RequestExecutionOptions executionOptions;
    private final Headers headers;
    private final Method method;
    private List<? extends Pair<String, ? extends Object>> parameters;
    private final Map<KClass<?>, Object> tags;
    private URL url;

    private final Map<KClass<?>, Object> component7() {
        return this.tags;
    }

    /* WARN: Multi-variable type inference failed */
    public static /* synthetic */ DefaultRequest copy$default(DefaultRequest defaultRequest, Method method, URL url, Headers headers, List list, Body body, Map map, Map map2, int i, Object obj) {
        if ((i & 1) != 0) {
            method = defaultRequest.getMethod();
        }
        if ((i & 2) != 0) {
            url = defaultRequest.getUrl();
        }
        if ((i & 4) != 0) {
            headers = defaultRequest.getHeaders();
        }
        if ((i & 8) != 0) {
            list = defaultRequest.getParameters();
        }
        if ((i & 16) != 0) {
            body = defaultRequest._body;
        }
        if ((i & 32) != 0) {
            map = defaultRequest.getEnabledFeatures();
        }
        if ((i & 64) != 0) {
            map2 = defaultRequest.tags;
        }
        Map map3 = map;
        Map map4 = map2;
        Body body2 = body;
        Headers headers2 = headers;
        return defaultRequest.copy(method, url, headers2, list, body2, map3, map4);
    }

    public final Method component1() {
        return getMethod();
    }

    public final URL component2() {
        return getUrl();
    }

    public final Headers component3() {
        return getHeaders();
    }

    public final List<Pair<String, Object>> component4() {
        return getParameters();
    }

    /* INFO: renamed from: component5$fuel, reason: from getter */
    public final Body get_body() {
        return this._body;
    }

    public final Map<String, Request> component6() {
        return getEnabledFeatures();
    }

    public final DefaultRequest copy(Method method, URL url, Headers headers, List<? extends Pair<String, ? extends Object>> parameters, Body _body, Map<String, Request> enabledFeatures, Map<KClass<?>, Object> tags) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        Intrinsics.checkNotNullParameter(_body, "_body");
        Intrinsics.checkNotNullParameter(enabledFeatures, "enabledFeatures");
        Intrinsics.checkNotNullParameter(tags, "tags");
        return new DefaultRequest(method, url, headers, parameters, _body, enabledFeatures, tags);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DefaultRequest)) {
            return false;
        }
        DefaultRequest defaultRequest = (DefaultRequest) other;
        return Intrinsics.areEqual(getMethod(), defaultRequest.getMethod()) && Intrinsics.areEqual(getUrl(), defaultRequest.getUrl()) && Intrinsics.areEqual(getHeaders(), defaultRequest.getHeaders()) && Intrinsics.areEqual(getParameters(), defaultRequest.getParameters()) && Intrinsics.areEqual(this._body, defaultRequest._body) && Intrinsics.areEqual(getEnabledFeatures(), defaultRequest.getEnabledFeatures()) && Intrinsics.areEqual(this.tags, defaultRequest.tags);
    }

    public int hashCode() {
        Method method = getMethod();
        int iHashCode = (method != null ? method.hashCode() : 0) * 31;
        URL url = getUrl();
        int iHashCode2 = (iHashCode + (url != null ? url.hashCode() : 0)) * 31;
        Headers headers = getHeaders();
        int iHashCode3 = (iHashCode2 + (headers != null ? headers.hashCode() : 0)) * 31;
        List<Pair<String, Object>> parameters = getParameters();
        int iHashCode4 = (iHashCode3 + (parameters != null ? parameters.hashCode() : 0)) * 31;
        Body body = this._body;
        int iHashCode5 = (iHashCode4 + (body != null ? body.hashCode() : 0)) * 31;
        Map<String, Request> enabledFeatures = getEnabledFeatures();
        int iHashCode6 = (iHashCode5 + (enabledFeatures != null ? enabledFeatures.hashCode() : 0)) * 31;
        Map<KClass<?>, Object> map = this.tags;
        return iHashCode6 + (map != null ? map.hashCode() : 0);
    }

    /* INFO: renamed from: com.github.kittinunf.fuel.core.requests.DefaultRequest$body$3, reason: invalid class name */
    /* INFO: compiled from: DefaultRequest.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 0})
    static final class AnonymousClass3 extends Lambda implements Function0<Long> {
        final /* synthetic */ byte[] $bytes;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(byte[] bArr) {
            super(0);
            this.$bytes = bArr;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Long invoke() {
            return Long.valueOf(invoke2());
        }

        /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final long invoke2() {
            return this.$bytes.length;
        }
    }

    /* INFO: renamed from: com.github.kittinunf.fuel.core.requests.DefaultRequest$body$6, reason: invalid class name */
    /* INFO: compiled from: DefaultRequest.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\t\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 0})
    static final class AnonymousClass6 extends Lambda implements Function0<Long> {
        final /* synthetic */ File $file;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass6(File file) {
            super(0);
            this.$file = file;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Long invoke() {
            return Long.valueOf(invoke2());
        }

        /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final long invoke2() {
            return this.$file.length();
        }
    }

    public DefaultRequest(Method method, URL url, Headers headers, List<? extends Pair<String, ? extends Object>> parameters, Body _body, Map<String, Request> enabledFeatures, Map<KClass<?>, Object> tags) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        Intrinsics.checkNotNullParameter(_body, "_body");
        Intrinsics.checkNotNullParameter(enabledFeatures, "enabledFeatures");
        Intrinsics.checkNotNullParameter(tags, "tags");
        this.method = method;
        this.url = url;
        this.headers = headers;
        this.parameters = parameters;
        this._body = _body;
        this.enabledFeatures = enabledFeatures;
        this.tags = tags;
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public Method getMethod() {
        return this.method;
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public URL getUrl() {
        return this.url;
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public void setUrl(URL url) {
        Intrinsics.checkNotNullParameter(url, "<set-?>");
        this.url = url;
    }

    public /* synthetic */ DefaultRequest(Method method, URL url, Headers headers, List list, Body body, Map map, Map map2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(method, url, (i & 4) != 0 ? new Headers() : headers, (i & 8) != 0 ? CollectionsKt.emptyList() : list, (i & 16) != 0 ? new DefaultBody(null, null, null, 7, null) : body, (i & 32) != 0 ? new LinkedHashMap() : map, (i & 64) != 0 ? new LinkedHashMap() : map2);
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public Headers getHeaders() {
        return this.headers;
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public List<Pair<String, Object>> getParameters() {
        return this.parameters;
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public void setParameters(List<? extends Pair<String, ? extends Object>> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.parameters = list;
    }

    public final Body get_body$fuel() {
        return this._body;
    }

    public final void set_body$fuel(Body body) {
        Intrinsics.checkNotNullParameter(body, "<set-?>");
        this._body = body;
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public Map<String, Request> getEnabledFeatures() {
        return this.enabledFeatures;
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public RequestExecutionOptions getExecutionOptions() {
        RequestExecutionOptions requestExecutionOptions = this.executionOptions;
        if (requestExecutionOptions == null) {
            Intrinsics.throwUninitializedPropertyAccessException("executionOptions");
        }
        return requestExecutionOptions;
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public void setExecutionOptions(RequestExecutionOptions requestExecutionOptions) {
        Intrinsics.checkNotNullParameter(requestExecutionOptions, "<set-?>");
        this.executionOptions = requestExecutionOptions;
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public Body getBody() {
        return this._body;
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public Collection<String> get(String header) {
        Intrinsics.checkNotNullParameter(header, "header");
        return (Collection) getHeaders().get((Object) header);
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public Request set(String header, Collection<?> values) {
        Intrinsics.checkNotNullParameter(header, "header");
        Intrinsics.checkNotNullParameter(values, "values");
        Headers headers = getHeaders();
        Collection<?> collection = values;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(collection, 10));
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(String.valueOf(it.next()));
        }
        headers.set(header, arrayList);
        return getRequest();
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public Request set(String header, Object value) {
        Intrinsics.checkNotNullParameter(header, "header");
        Intrinsics.checkNotNullParameter(value, "value");
        if (value instanceof Collection) {
            set(header, (Collection<?>) value);
        } else {
            getHeaders().set(header, value.toString());
        }
        return getRequest();
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public Collection<String> header(String header) {
        Intrinsics.checkNotNullParameter(header, "header");
        return get(header);
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public Request header(Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "map");
        getHeaders().putAll(Headers.INSTANCE.from(map));
        return getRequest();
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public Request header(Pair<String, ? extends Object>... pairs) {
        Intrinsics.checkNotNullParameter(pairs, "pairs");
        getHeaders().putAll(Headers.INSTANCE.from((Pair<String, ? extends Object>[]) Arrays.copyOf(pairs, pairs.length)));
        return getRequest();
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public Request header(String header, Collection<?> values) {
        Intrinsics.checkNotNullParameter(header, "header");
        Intrinsics.checkNotNullParameter(values, "values");
        return set(header, values);
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public Request header(String header, Object value) {
        Intrinsics.checkNotNullParameter(header, "header");
        Intrinsics.checkNotNullParameter(value, "value");
        return set(header, value);
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public Request header(String header, Object... values) {
        Intrinsics.checkNotNullParameter(header, "header");
        Intrinsics.checkNotNullParameter(values, "values");
        return set(header, (Collection<?>) ArraysKt.toList(values));
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public Request appendHeader(String header, Object value) {
        Intrinsics.checkNotNullParameter(header, "header");
        Intrinsics.checkNotNullParameter(value, "value");
        getHeaders().append(header, value);
        return getRequest();
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public Request appendHeader(String header, Object... values) {
        Intrinsics.checkNotNullParameter(header, "header");
        Intrinsics.checkNotNullParameter(values, "values");
        getHeaders().append(header, (Collection<?>) ArraysKt.toList(values));
        return getRequest();
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public Request body(Function0<? extends InputStream> openStream, Function0<Long> calculateLength, Charset charset, boolean repeatable) {
        Intrinsics.checkNotNullParameter(openStream, "openStream");
        Intrinsics.checkNotNullParameter(charset, "charset");
        Body bodyFrom = DefaultBody.INSTANCE.from(openStream, calculateLength, charset);
        if (repeatable) {
            bodyFrom = bodyFrom.asRepeatable();
        }
        this._body = bodyFrom;
        return getRequest();
    }

    /* INFO: renamed from: com.github.kittinunf.fuel.core.requests.DefaultRequest$body$2, reason: invalid class name */
    /* INFO: compiled from: DefaultRequest.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Ljava/io/InputStream;", "invoke"}, k = 3, mv = {1, 4, 0})
    static final class AnonymousClass2 extends Lambda implements Function0<InputStream> {
        final /* synthetic */ InputStream $stream;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(InputStream inputStream) {
            super(0);
            this.$stream = inputStream;
        }

        /* WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final InputStream invoke() {
            return this.$stream;
        }
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public Request body(InputStream stream, Function0<Long> calculateLength, Charset charset, boolean repeatable) {
        Intrinsics.checkNotNullParameter(stream, "stream");
        Intrinsics.checkNotNullParameter(charset, "charset");
        return body(new AnonymousClass2(stream), calculateLength, charset, repeatable);
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public Request body(byte[] bytes, Charset charset) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        Intrinsics.checkNotNullParameter(charset, "charset");
        return body((InputStream) new ByteArrayInputStream(bytes), (Function0<Long>) new AnonymousClass3(bytes), charset, true);
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public Request body(String body, Charset charset) {
        Intrinsics.checkNotNullParameter(body, "body");
        Intrinsics.checkNotNullParameter(charset, "charset");
        byte[] bytes = body.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
        Request requestBody = body(bytes, charset);
        CharSequence charSequence = (CharSequence) CollectionsKt.lastOrNull(header("Content-Type"));
        return (charSequence == null || StringsKt.isBlank(charSequence)) ? header("Content-Type", "text/plain; charset=" + charset.name()) : requestBody;
    }

    /* INFO: renamed from: com.github.kittinunf.fuel.core.requests.DefaultRequest$body$5, reason: invalid class name */
    /* INFO: compiled from: DefaultRequest.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Ljava/io/InputStream;", "invoke"}, k = 3, mv = {1, 4, 0})
    static final class AnonymousClass5 extends Lambda implements Function0<InputStream> {
        final /* synthetic */ File $file;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass5(File file) {
            super(0);
            this.$file = file;
        }

        /* WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final InputStream invoke() {
            return new FileInputStream(this.$file);
        }
    }

    /* INFO: renamed from: com.github.kittinunf.fuel.core.requests.DefaultRequest$body$7, reason: invalid class name */
    /* INFO: compiled from: DefaultRequest.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Ljava/io/InputStream;", "invoke"}, k = 3, mv = {1, 4, 0})
    static final class AnonymousClass7 extends Lambda implements Function0<InputStream> {
        final /* synthetic */ File $file;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass7(File file) {
            super(0);
            this.$file = file;
        }

        /* WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final InputStream invoke() {
            return new FileInputStream(this.$file);
        }
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public Request body(File file, Charset charset) {
        Charset charset2;
        Request requestBody$default;
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(charset, "charset");
        if (Intrinsics.areEqual(charset, Charsets.UTF_8)) {
            requestBody$default = Request.DefaultImpls.body$default((Request) this, (Function0) new AnonymousClass5(file), (Function0) new AnonymousClass6(file), charset, false, 8, (Object) null);
            charset2 = charset;
        } else {
            charset2 = charset;
            requestBody$default = Request.DefaultImpls.body$default((Request) this, (Function0) new AnonymousClass7(file), (Function0) null, charset2, false, 8, (Object) null);
        }
        CharSequence charSequence = (CharSequence) CollectionsKt.lastOrNull(header("Content-Type"));
        if (charSequence != null && !StringsKt.isBlank(charSequence)) {
            return requestBody$default;
        }
        return header("Content-Type", URLConnection.guessContentTypeFromName(file.getName()) + HTTP.CHARSET_PARAM + charset2.name());
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public Request body(Body body) {
        Intrinsics.checkNotNullParameter(body, "body");
        this._body = body;
        return getRequest();
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public Request requestProgress(Function2<? super Long, ? super Long, Unit> handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        getExecutionOptions().getRequestProgress().plusAssign(handler);
        return getRequest();
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public Request responseProgress(Function2<? super Long, ? super Long, Unit> handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        getExecutionOptions().getResponseProgress().plusAssign(handler);
        return getRequest();
    }

    /* WARN: Multi-variable type inference failed */
    @Override // com.github.kittinunf.fuel.core.Request
    public Request interrupt(Function1<? super Request, Unit> interrupt) {
        Intrinsics.checkNotNullParameter(interrupt, "interrupt");
        Request request = getRequest();
        request.getExecutionOptions().getInterruptCallbacks().add(interrupt);
        return request;
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public Request timeout(int timeout) {
        Request request = getRequest();
        request.getExecutionOptions().setTimeoutInMillisecond(timeout);
        return request;
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public Request timeoutRead(int timeout) {
        Request request = getRequest();
        request.getExecutionOptions().setTimeoutReadInMillisecond(timeout);
        return request;
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public Request allowRedirects(boolean allowRedirects) {
        Request request = getRequest();
        request.getExecutionOptions().setAllowRedirects(Boolean.valueOf(allowRedirects));
        return request;
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public Request useHttpCache(boolean useHttpCache) {
        Request request = getRequest();
        request.getExecutionOptions().setUseHttpCache(Boolean.valueOf(useHttpCache));
        return request;
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public Request validate(Function1<? super Response, Boolean> validator) {
        Intrinsics.checkNotNullParameter(validator, "validator");
        Request request = getRequest();
        request.getExecutionOptions().setResponseValidator(validator);
        return request;
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public Request tag(Object t) {
        Intrinsics.checkNotNullParameter(t, "t");
        Request request = getRequest();
        this.tags.put(Reflection.getOrCreateKotlinClass(t.getClass()), t);
        return request;
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public <T> T getTag(KClass<T> clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        T t = (T) this.tags.get(clazz);
        if (t instanceof Object) {
            return t;
        }
        return null;
    }

    @Override // com.github.kittinunf.fuel.core.RequestFactory.RequestConvertible
    public Request getRequest() {
        return this;
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public String toString() {
        StringBuilder sb = new StringBuilder();
        StringBuilder sbAppend = sb.append("--> " + getMethod() + TokenParser.SP + getUrl());
        Intrinsics.checkNotNullExpressionValue(sbAppend, "append(value)");
        StringsKt.appendln(sbAppend);
        StringBuilder sbAppend2 = sb.append("Body : " + getBody().asString((String) CollectionsKt.lastOrNull(header("Content-Type"))));
        Intrinsics.checkNotNullExpressionValue(sbAppend2, "append(value)");
        StringsKt.appendln(sbAppend2);
        StringBuilder sbAppend3 = sb.append("Headers : (" + getHeaders().size() + ')');
        Intrinsics.checkNotNullExpressionValue(sbAppend3, "append(value)");
        StringsKt.appendln(sbAppend3);
        Headers.transformIterate$default(getHeaders(), new DefaultRequest$toString$1$appendHeaderWithValue$1(sb), null, 2, null);
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public CancellableRequest response(Function3<? super Request, ? super Response, ? super Result<byte[], ? extends FuelError>, Unit> handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        return DeserializableKt.response(this, new ByteArrayDeserializer(), handler);
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public CancellableRequest response(Function1<? super Result<byte[], ? extends FuelError>, Unit> handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        return DeserializableKt.response(this, new ByteArrayDeserializer(), handler);
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public CancellableRequest response(ResponseHandler<? super byte[]> handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        return DeserializableKt.response(this, new ByteArrayDeserializer(), handler);
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public CancellableRequest response(Handler<? super byte[]> handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        return DeserializableKt.response(this, new ByteArrayDeserializer(), handler);
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public Triple<Request, Response, Result<byte[], FuelError>> response() {
        return DeserializableKt.response(this, new ByteArrayDeserializer());
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public CancellableRequest responseString(Charset charset, Function3<? super Request, ? super Response, ? super Result<String, ? extends FuelError>, Unit> handler) {
        Intrinsics.checkNotNullParameter(charset, "charset");
        Intrinsics.checkNotNullParameter(handler, "handler");
        return DeserializableKt.response(this, new StringDeserializer(charset), handler);
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public CancellableRequest responseString(Function3<? super Request, ? super Response, ? super Result<String, ? extends FuelError>, Unit> handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        return responseString(Charsets.UTF_8, handler);
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public CancellableRequest responseString(Charset charset, Function1<? super Result<String, ? extends FuelError>, Unit> handler) {
        Intrinsics.checkNotNullParameter(charset, "charset");
        Intrinsics.checkNotNullParameter(handler, "handler");
        return DeserializableKt.response(this, new StringDeserializer(charset), handler);
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public CancellableRequest responseString(Function1<? super Result<String, ? extends FuelError>, Unit> handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        return responseString(Charsets.UTF_8, handler);
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public CancellableRequest responseString(Charset charset, ResponseHandler<? super String> handler) {
        Intrinsics.checkNotNullParameter(charset, "charset");
        Intrinsics.checkNotNullParameter(handler, "handler");
        return DeserializableKt.response(this, new StringDeserializer(charset), handler);
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public CancellableRequest responseString(ResponseHandler<? super String> handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        return DeserializableKt.response(this, new StringDeserializer(null, 1, null), handler);
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public CancellableRequest responseString(Charset charset, Handler<? super String> handler) {
        Intrinsics.checkNotNullParameter(charset, "charset");
        Intrinsics.checkNotNullParameter(handler, "handler");
        return DeserializableKt.response(this, new StringDeserializer(charset), handler);
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public CancellableRequest responseString(Handler<? super String> handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        return DeserializableKt.response(this, new StringDeserializer(null, 1, null), handler);
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public Triple<Request, Response, Result<String, FuelError>> responseString(Charset charset) {
        Intrinsics.checkNotNullParameter(charset, "charset");
        return DeserializableKt.response(this, new StringDeserializer(charset));
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public Triple<Request, Response, Result<String, FuelError>> responseString() {
        return DeserializableKt.response(this, new StringDeserializer(Charsets.UTF_8));
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public <T> CancellableRequest responseObject(ResponseDeserializable<? extends T> deserializer, Function3<? super Request, ? super Response, ? super Result<? extends T, ? extends FuelError>, Unit> handler) {
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
        Intrinsics.checkNotNullParameter(handler, "handler");
        return DeserializableKt.response(this, deserializer, handler);
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public <T> CancellableRequest responseObject(ResponseDeserializable<? extends T> deserializer, Function1<? super Result<? extends T, ? extends FuelError>, Unit> handler) {
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
        Intrinsics.checkNotNullParameter(handler, "handler");
        return DeserializableKt.response(this, deserializer, handler);
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public <T> CancellableRequest responseObject(ResponseDeserializable<? extends T> deserializer, ResponseHandler<? super T> handler) {
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
        Intrinsics.checkNotNullParameter(handler, "handler");
        return DeserializableKt.response(this, deserializer, handler);
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public <T> CancellableRequest responseObject(ResponseDeserializable<? extends T> deserializer, Handler<? super T> handler) {
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
        Intrinsics.checkNotNullParameter(handler, "handler");
        return DeserializableKt.response(this, deserializer, handler);
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public <T> Triple<Request, Response, Result<T, FuelError>> responseObject(ResponseDeserializable<? extends T> deserializer) {
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
        return DeserializableKt.response(this, deserializer);
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public Request appendHeader(Pair<String, ? extends Object>... pairs) {
        Intrinsics.checkNotNullParameter(pairs, "pairs");
        for (Pair<String, ? extends Object> pair : pairs) {
            appendHeader(pair.getFirst(), pair.getSecond());
        }
        return getRequest();
    }
}
