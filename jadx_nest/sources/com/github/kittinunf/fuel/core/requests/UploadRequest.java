package com.github.kittinunf.fuel.core.requests;

import androidx.exifinterface.media.ExifInterface;
import com.github.kittinunf.fuel.core.Blob;
import com.github.kittinunf.fuel.core.Body;
import com.github.kittinunf.fuel.core.DataPart;
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
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.Pair;
import kotlin.ReplaceWith;
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
import kotlin.reflect.KClass;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.eclipse.jgit.lib.Constants;
import org.jsoup.helper.HttpConnection;

/* INFO: compiled from: UploadRequest.kt */
/* INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¾\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u0093\u00012\u00020\u0001:\u0002\u0093\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\u000e\u00107\u001a\u00020\u00002\u0006\u00108\u001a\u00020\u000eJ-\u00107\u001a\u00020\u00002%\u00108\u001a!\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\nj\u0002`\u000fJ\u001f\u00107\u001a\u00020\u00002\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000e09\"\u00020\u000e¢\u0006\u0002\u0010:J]\u00107\u001a\u00020\u00002P\u0010\b\u001a)\u0012%\b\u0001\u0012!\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\nj\u0002`\u000f09\"!\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\nj\u0002`\u000f¢\u0006\u0002\u0010;J\u0011\u0010<\u001a\u00020\u00012\u0006\u0010<\u001a\u00020=H\u0096\u0001J:\u0010>\u001a\u00020\u00012*\u0010?\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020)0(09\"\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020)0(H\u0096\u0001¢\u0006\u0002\u0010@J\u0019\u0010>\u001a\u00020\u00012\u0006\u0010A\u001a\u00020\u00142\u0006\u0010B\u001a\u00020)H\u0096\u0001J*\u0010>\u001a\u00020\u00012\u0006\u0010A\u001a\u00020\u00142\u0012\u0010C\u001a\n\u0012\u0006\b\u0001\u0012\u00020)09\"\u00020)H\u0096\u0001¢\u0006\u0002\u0010DJ\"\u0010E\u001a\u00020\u00002\u0018\u0010F\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020H0GH\u0007J(\u0010I\u001a\u00020\u00002\u001e\u0010J\u001a\u001a\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u000202\u0012\n\u0012\b\u0012\u0004\u0012\u00020H0K0GH\u0007J\u0011\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\u0096\u0001JG\u0010\u0004\u001a\u00020\u00012\u0010\u0010L\u001a\f\u0012\u0004\u0012\u00020N0Mj\u0002`O2\u0016\b\u0002\u0010P\u001a\u0010\u0012\u0004\u0012\u00020Q\u0018\u00010Mj\u0004\u0018\u0001`R2\b\b\u0002\u0010S\u001a\u00020T2\b\b\u0002\u0010U\u001a\u00020=H\u0096\u0001J\u001b\u0010\u0004\u001a\u00020\u00012\u0006\u0010V\u001a\u00020W2\b\b\u0002\u0010S\u001a\u00020TH\u0096\u0001J=\u0010\u0004\u001a\u00020\u00012\u0006\u0010X\u001a\u00020N2\u0016\b\u0002\u0010P\u001a\u0010\u0012\u0004\u0012\u00020Q\u0018\u00010Mj\u0004\u0018\u0001`R2\b\b\u0002\u0010S\u001a\u00020T2\b\b\u0002\u0010U\u001a\u00020=H\u0096\u0001J\u001b\u0010\u0004\u001a\u00020\u00012\u0006\u0010Y\u001a\u00020Z2\b\b\u0002\u0010S\u001a\u00020TH\u0096\u0001J\u001b\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00142\b\b\u0002\u0010S\u001a\u00020TH\u0096\u0001J(\u0010\b\u001a\u00020\u00002\u001e\u0010[\u001a\u001a\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u000202\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0K0GH\u0007J\b\u0010\\\u001a\u00020]H\u0002J\u001b\u0010^\u001a\f\u0012\u0004\u0012\u00020\u00140_j\u0002``2\u0006\u0010A\u001a\u00020\u0014H\u0096\u0003J(\u0010a\u001a\u0004\u0018\u0001Hb\"\b\b\u0000\u0010b*\u00020)2\f\u0010c\u001a\b\u0012\u0004\u0012\u0002Hb0dH\u0096\u0001¢\u0006\u0002\u0010eJ:\u0010A\u001a\u00020\u00012*\u0010?\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020)0(09\"\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020)0(H\u0096\u0001¢\u0006\u0002\u0010@J\u001b\u0010A\u001a\f\u0012\u0004\u0012\u00020\u00140_j\u0002``2\u0006\u0010A\u001a\u00020\u0014H\u0096\u0001J\u0019\u0010A\u001a\u00020\u00012\u0006\u0010A\u001a\u00020\u00142\u0006\u0010B\u001a\u00020)H\u0096\u0001J*\u0010A\u001a\u00020\u00012\u0006\u0010A\u001a\u00020\u00142\u0012\u0010C\u001a\n\u0012\u0006\b\u0001\u0012\u00020)09\"\u00020)H\u0096\u0001¢\u0006\u0002\u0010DJ\u001d\u0010A\u001a\u00020\u00012\u0006\u0010A\u001a\u00020\u00142\n\u0010C\u001a\u0006\u0012\u0002\b\u00030_H\u0096\u0001J\u001d\u0010A\u001a\u00020\u00012\u0012\u0010f\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020)0gH\u0096\u0001J!\u0010h\u001a\u00020\u00012\u0016\u0010h\u001a\u0012\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020]0\nj\u0002`iH\u0096\u0001J\u0016\u0010\f\u001a\u00020\u00002\f\u0010j\u001a\b\u0012\u0004\u0012\u00020\u00140MH\u0007J\u0010\u0010\f\u001a\u00020\u00002\u0006\u0010k\u001a\u00020\u0014H\u0007J\u0011\u0010l\u001a\u00020\u00002\u0006\u00108\u001a\u00020\u000eH\u0086\u0002J0\u0010l\u001a\u00020\u00002%\u00108\u001a!\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\nj\u0002`\u000fH\u0086\u0002J\u0017\u0010l\u001a\u00020\u00002\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u000e0KH\u0086\u0002JB\u0010m\u001a\u00020\u00012:\u0010m\u001a6\u0012\u0013\u0012\u00110Q¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(n\u0012\u0013\u0012\u00110Q¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(o\u0012\u0004\u0012\u00020]0Gj\u0002`pJE\u0010q\u001a\u00020\u00012:\u0010r\u001a6\u0012\u0013\u0012\u00110Q¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(n\u0012\u0013\u0012\u00110Q¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(o\u0012\u0004\u0012\u00020]0Gj\u0002`pH\u0096\u0001J1\u0010s\u001a*\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020u\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020Z\u0012\u0004\u0012\u00020w0v0tj\b\u0012\u0004\u0012\u00020Z`xH\u0096\u0001J\u0017\u0010s\u001a\u00020y2\f\u0010r\u001a\b\u0012\u0004\u0012\u00020Z0zH\u0096\u0001J\u0017\u0010s\u001a\u00020y2\f\u0010r\u001a\b\u0012\u0004\u0012\u00020Z0{H\u0096\u0001J?\u0010s\u001a\u00020y24\u0010r\u001a0\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020u\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020Z\u0012\u0004\u0012\u00020w0v\u0012\u0004\u0012\u00020]0|j\b\u0012\u0004\u0012\u00020Z`}H\u0096\u0001J3\u0010s\u001a\u00020y2(\u0010r\u001a$\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020Z\u0012\u0004\u0012\u00020w0v\u0012\u0004\u0012\u00020]0\nj\b\u0012\u0004\u0012\u00020Z`~H\u0096\u0001JK\u0010\u007f\u001a*\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020u\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002Hb\u0012\u0004\u0012\u00020w0v0tj\b\u0012\u0004\u0012\u0002Hb`x\"\b\b\u0000\u0010b*\u00020)2\u000e\u0010\u0080\u0001\u001a\t\u0012\u0004\u0012\u0002Hb0\u0081\u0001H\u0096\u0001J1\u0010\u007f\u001a\u00020y\"\b\b\u0000\u0010b*\u00020)2\u000e\u0010\u0080\u0001\u001a\t\u0012\u0004\u0012\u0002Hb0\u0081\u00012\f\u0010r\u001a\b\u0012\u0004\u0012\u0002Hb0zH\u0096\u0001J1\u0010\u007f\u001a\u00020y\"\b\b\u0000\u0010b*\u00020)2\u000e\u0010\u0080\u0001\u001a\t\u0012\u0004\u0012\u0002Hb0\u0081\u00012\f\u0010r\u001a\b\u0012\u0004\u0012\u0002Hb0{H\u0096\u0001JY\u0010\u007f\u001a\u00020y\"\b\b\u0000\u0010b*\u00020)2\u000e\u0010\u0080\u0001\u001a\t\u0012\u0004\u0012\u0002Hb0\u0081\u000124\u0010r\u001a0\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020u\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002Hb\u0012\u0004\u0012\u00020w0v\u0012\u0004\u0012\u00020]0|j\b\u0012\u0004\u0012\u0002Hb`}H\u0096\u0001JM\u0010\u007f\u001a\u00020y\"\b\b\u0000\u0010b*\u00020)2\u000e\u0010\u0080\u0001\u001a\t\u0012\u0004\u0012\u0002Hb0\u0081\u00012(\u0010r\u001a$\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002Hb\u0012\u0004\u0012\u00020w0v\u0012\u0004\u0012\u00020]0\nj\b\u0012\u0004\u0012\u0002Hb`~H\u0096\u0001JF\u0010\u0082\u0001\u001a\u00020\u00012:\u0010r\u001a6\u0012\u0013\u0012\u00110Q¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(n\u0012\u0013\u0012\u00110Q¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(o\u0012\u0004\u0012\u00020]0Gj\u0002`pH\u0096\u0001J2\u0010\u0083\u0001\u001a*\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020u\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020w0v0tj\b\u0012\u0004\u0012\u00020\u0014`xH\u0096\u0001J\u0018\u0010\u0083\u0001\u001a\u00020y2\f\u0010r\u001a\b\u0012\u0004\u0012\u00020\u00140zH\u0096\u0001J\u0018\u0010\u0083\u0001\u001a\u00020y2\f\u0010r\u001a\b\u0012\u0004\u0012\u00020\u00140{H\u0096\u0001J@\u0010\u0083\u0001\u001a\u00020y24\u0010r\u001a0\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020u\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020w0v\u0012\u0004\u0012\u00020]0|j\b\u0012\u0004\u0012\u00020\u0014`}H\u0096\u0001J4\u0010\u0083\u0001\u001a\u00020y2(\u0010r\u001a$\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020w0v\u0012\u0004\u0012\u00020]0\nj\b\u0012\u0004\u0012\u00020\u0014`~H\u0096\u0001J<\u0010\u0083\u0001\u001a*\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020u\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020w0v0tj\b\u0012\u0004\u0012\u00020\u0014`x2\b\b\u0002\u0010S\u001a\u00020TH\u0096\u0001J\"\u0010\u0083\u0001\u001a\u00020y2\b\b\u0002\u0010S\u001a\u00020T2\f\u0010r\u001a\b\u0012\u0004\u0012\u00020\u00140zH\u0096\u0001J\"\u0010\u0083\u0001\u001a\u00020y2\b\b\u0002\u0010S\u001a\u00020T2\f\u0010r\u001a\b\u0012\u0004\u0012\u00020\u00140{H\u0096\u0001JJ\u0010\u0083\u0001\u001a\u00020y2\b\b\u0002\u0010S\u001a\u00020T24\u0010r\u001a0\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020u\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020w0v\u0012\u0004\u0012\u00020]0|j\b\u0012\u0004\u0012\u00020\u0014`}H\u0096\u0001J>\u0010\u0083\u0001\u001a\u00020y2\b\b\u0002\u0010S\u001a\u00020T2(\u0010r\u001a$\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020w0v\u0012\u0004\u0012\u00020]0\nj\b\u0012\u0004\u0012\u00020\u0014`~H\u0096\u0001J\u001a\u0010\u0084\u0001\u001a\u00020\u00012\u0006\u0010A\u001a\u00020\u00142\u0006\u0010B\u001a\u00020)H\u0096\u0003J\u001e\u0010\u0084\u0001\u001a\u00020\u00012\u0006\u0010A\u001a\u00020\u00142\n\u0010C\u001a\u0006\u0012\u0002\b\u00030_H\u0096\u0003J$\u0010\u0085\u0001\u001a\u00020\u00002\u0019\u0010\u0086\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020W0GH\u0007J*\u0010\u0087\u0001\u001a\u00020\u00002\u001f\u0010\u0088\u0001\u001a\u001a\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u000202\u0012\n\u0012\b\u0012\u0004\u0012\u00020W0K0GH\u0007J\u0013\u0010\u0089\u0001\u001a\u00020\u00012\u0007\u0010\u008a\u0001\u001a\u00020)H\u0096\u0001J\u0014\u0010\u008b\u0001\u001a\u00020\u00012\b\u0010\u008b\u0001\u001a\u00030\u008c\u0001H\u0096\u0001J\u0014\u0010\u008d\u0001\u001a\u00020\u00012\b\u0010\u008b\u0001\u001a\u00030\u008c\u0001H\u0096\u0001J\t\u0010\u008e\u0001\u001a\u00020\u0014H\u0016J\u0013\u0010\u008f\u0001\u001a\u00020\u00012\u0007\u0010\u008f\u0001\u001a\u00020=H\u0096\u0001J$\u0010\u0090\u0001\u001a\u00020\u00012\u0018\u0010\u0091\u0001\u001a\u0013\u0012\u0004\u0012\u00020u\u0012\u0004\u0012\u00020=0\nj\u0003`\u0092\u0001H\u0096\u0001R\u0012\u0010\u0004\u001a\u00020\u0005X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R6\u0010\b\u001a'\u0012#\u0012!\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\nj\u0002`\u000f0\t¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00010\u0013j\u0002`\u0015X\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0018\u001a\u00020\u0019X\u0096\u000f¢\u0006\f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0012\u0010\u001e\u001a\u00020\u001fX\u0096\u0005¢\u0006\u0006\u001a\u0004\b \u0010!R\u0012\u0010\"\u001a\u00020#X\u0096\u0005¢\u0006\u0006\u001a\u0004\b$\u0010%R0\u0010&\u001a\u001a\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0006\u0012\u0004\u0018\u00010)0(0'j\u0002`*X\u0096\u000f¢\u0006\f\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u0014\u0010\r\u001a\u00020\u0000X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0018\u00101\u001a\u000202X\u0096\u000f¢\u0006\f\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0094\u0001"}, d2 = {"Lcom/github/kittinunf/fuel/core/requests/UploadRequest;", "Lcom/github/kittinunf/fuel/core/Request;", "wrapped", "(Lcom/github/kittinunf/fuel/core/Request;)V", "body", "Lcom/github/kittinunf/fuel/core/Body;", "getBody", "()Lcom/github/kittinunf/fuel/core/Body;", "dataParts", "", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "request", "Lcom/github/kittinunf/fuel/core/DataPart;", "Lcom/github/kittinunf/fuel/core/LazyDataPart;", "getDataParts", "()Ljava/util/Collection;", "enabledFeatures", "", "", "Lcom/github/kittinunf/fuel/core/RequestFeatures;", "getEnabledFeatures", "()Ljava/util/Map;", "executionOptions", "Lcom/github/kittinunf/fuel/core/RequestExecutionOptions;", "getExecutionOptions", "()Lcom/github/kittinunf/fuel/core/RequestExecutionOptions;", "setExecutionOptions", "(Lcom/github/kittinunf/fuel/core/RequestExecutionOptions;)V", "headers", "Lcom/github/kittinunf/fuel/core/Headers;", "getHeaders", "()Lcom/github/kittinunf/fuel/core/Headers;", "method", "Lcom/github/kittinunf/fuel/core/Method;", "getMethod", "()Lcom/github/kittinunf/fuel/core/Method;", "parameters", "", "Lkotlin/Pair;", "", "Lcom/github/kittinunf/fuel/core/Parameters;", "getParameters", "()Ljava/util/List;", "setParameters", "(Ljava/util/List;)V", "getRequest", "()Lcom/github/kittinunf/fuel/core/requests/UploadRequest;", "url", "Ljava/net/URL;", "getUrl", "()Ljava/net/URL;", "setUrl", "(Ljava/net/URL;)V", "add", "dataPart", "", "([Lcom/github/kittinunf/fuel/core/DataPart;)Lcom/github/kittinunf/fuel/core/requests/UploadRequest;", "([Lkotlin/jvm/functions/Function1;)Lcom/github/kittinunf/fuel/core/requests/UploadRequest;", "allowRedirects", "", "appendHeader", "pairs", "([Lkotlin/Pair;)Lcom/github/kittinunf/fuel/core/Request;", "header", "value", "values", "(Ljava/lang/String;[Ljava/lang/Object;)Lcom/github/kittinunf/fuel/core/Request;", Constants.TYPE_BLOB, "blobCallback", "Lkotlin/Function2;", "Lcom/github/kittinunf/fuel/core/Blob;", "blobs", "blobsCallback", "", "openStream", "Lkotlin/Function0;", "Ljava/io/InputStream;", "Lcom/github/kittinunf/fuel/core/BodySource;", "calculateLength", "", "Lcom/github/kittinunf/fuel/core/BodyLength;", "charset", "Ljava/nio/charset/Charset;", "repeatable", "file", "Ljava/io/File;", "stream", "bytes", "", "dataPartsCallback", "ensureBoundary", "", "get", "", "Lcom/github/kittinunf/fuel/core/HeaderValues;", "getTag", ExifInterface.GPS_DIRECTION_TRUE, "clazz", "Lkotlin/reflect/KClass;", "(Lkotlin/reflect/KClass;)Ljava/lang/Object;", "map", "", "interrupt", "Lcom/github/kittinunf/fuel/core/InterruptCallback;", "nameCallback", "newName", "plus", "progress", "readBytes", "totalBytes", "Lcom/github/kittinunf/fuel/core/ProgressCallback;", "requestProgress", "handler", "response", "Lkotlin/Triple;", "Lcom/github/kittinunf/fuel/core/Response;", "Lcom/github/kittinunf/result/Result;", "Lcom/github/kittinunf/fuel/core/FuelError;", "Lcom/github/kittinunf/fuel/core/ResponseResultOf;", "Lcom/github/kittinunf/fuel/core/requests/CancellableRequest;", "Lcom/github/kittinunf/fuel/core/Handler;", "Lcom/github/kittinunf/fuel/core/ResponseHandler;", "Lkotlin/Function3;", "Lcom/github/kittinunf/fuel/core/ResponseResultHandler;", "Lcom/github/kittinunf/fuel/core/ResultHandler;", "responseObject", "deserializer", "Lcom/github/kittinunf/fuel/core/ResponseDeserializable;", "responseProgress", "responseString", "set", "source", "sourceCallback", "sources", "sourcesCallback", "tag", "t", "timeout", "", "timeoutRead", "toString", "useHttpCache", "validate", "validator", "Lcom/github/kittinunf/fuel/core/ResponseValidator;", "Companion", "fuel"}, k = 1, mv = {1, 4, 0})
public final class UploadRequest implements Request {

    /* INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String FEATURE;
    private final Collection<Function1<Request, DataPart>> dataParts;
    private final UploadRequest request;
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

    private UploadRequest(Request request) {
        this.wrapped = request;
        this.request = this;
        this.dataParts = new ArrayList();
    }

    public /* synthetic */ UploadRequest(Request request, DefaultConstructorMarker defaultConstructorMarker) {
        this(request);
    }

    @Override // com.github.kittinunf.fuel.core.RequestFactory.RequestConvertible
    public UploadRequest getRequest() {
        return this.request;
    }

    public final Collection<Function1<Request, DataPart>> getDataParts() {
        return this.dataParts;
    }

    /* INFO: Access modifiers changed from: private */
    public final void ensureBoundary() {
        String str = (String) CollectionsKt.lastOrNull(get("Content-Type"));
        String str2 = str;
        if (str2 == null || StringsKt.isBlank(str2) || !StringsKt.startsWith$default(str, HttpConnection.MULTIPART_FORM_DATA, false, 2, (Object) null) || !new Regex("boundary=[^\\s]+").containsMatchIn(str2)) {
            set("Content-Type", "multipart/form-data; boundary=\"" + UUID.randomUUID() + '\"');
        }
    }

    @Override // com.github.kittinunf.fuel.core.Request
    public String toString() {
        return "Upload[\n\r\t" + this.wrapped + "\n\r]";
    }

    public final UploadRequest add(DataPart... dataParts) {
        Intrinsics.checkNotNullParameter(dataParts, "dataParts");
        return plus(ArraysKt.toList(dataParts));
    }

    public final UploadRequest add(Function1<? super Request, ? extends DataPart> dataPart) {
        Intrinsics.checkNotNullParameter(dataPart, "dataPart");
        return plus(dataPart);
    }

    public final UploadRequest add(DataPart dataPart) {
        Intrinsics.checkNotNullParameter(dataPart, "dataPart");
        return plus(dataPart);
    }

    public final UploadRequest plus(Function1<? super Request, ? extends DataPart> dataPart) {
        Intrinsics.checkNotNullParameter(dataPart, "dataPart");
        this.dataParts.add(dataPart);
        return this;
    }

    /* INFO: renamed from: com.github.kittinunf.fuel.core.requests.UploadRequest$plus$2, reason: invalid class name */
    /* INFO: compiled from: UploadRequest.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/github/kittinunf/fuel/core/DataPart;", "it", "Lcom/github/kittinunf/fuel/core/Request;", "invoke"}, k = 3, mv = {1, 4, 0})
    static final class AnonymousClass2 extends Lambda implements Function1<Request, DataPart> {
        final /* synthetic */ DataPart $dataPart;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(DataPart dataPart) {
            super(1);
            this.$dataPart = dataPart;
        }

        @Override // kotlin.jvm.functions.Function1
        public final DataPart invoke(Request it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return this.$dataPart;
        }
    }

    public final UploadRequest plus(DataPart dataPart) {
        Intrinsics.checkNotNullParameter(dataPart, "dataPart");
        return plus(new AnonymousClass2(dataPart));
    }

    public final Request progress(Function2<? super Long, ? super Long, Unit> progress) {
        Intrinsics.checkNotNullParameter(progress, "progress");
        return requestProgress(progress);
    }

    /* INFO: compiled from: UploadRequest.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/github/kittinunf/fuel/core/requests/UploadRequest$Companion;", "", "()V", "FEATURE", "", "getFEATURE", "()Ljava/lang/String;", "enableFor", "Lcom/github/kittinunf/fuel/core/requests/UploadRequest;", "request", "Lcom/github/kittinunf/fuel/core/Request;", "fuel"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String getFEATURE() {
            return UploadRequest.FEATURE;
        }

        public final UploadRequest enableFor(Request request) {
            Intrinsics.checkNotNullParameter(request, "request");
            Map<String, Request> enabledFeatures = request.getEnabledFeatures();
            String feature = getFEATURE();
            UploadRequest uploadRequest = enabledFeatures.get(feature);
            if (uploadRequest == null) {
                UploadRequest uploadRequest2 = new UploadRequest(request, null);
                uploadRequest2.body(UploadBody.INSTANCE.from(uploadRequest2));
                uploadRequest2.ensureBoundary();
                uploadRequest = uploadRequest2;
                enabledFeatures.put(feature, uploadRequest);
            }
            return (UploadRequest) uploadRequest;
        }
    }

    static {
        String canonicalName = UploadRequest.class.getCanonicalName();
        Intrinsics.checkNotNullExpressionValue(canonicalName, "UploadRequest::class.java.canonicalName");
        FEATURE = canonicalName;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use request.add({ BlobDataPart(...) }, { ... }, ...) instead", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public final UploadRequest blobs(Function2<? super Request, ? super URL, ? extends Iterable<Blob>> blobsCallback) {
        Intrinsics.checkNotNullParameter(blobsCallback, "blobsCallback");
        throw new NotImplementedError("request.blobs has been removed. Use request.add({ BlobDataPart(...) }, { ... }, ...) instead.");
    }

    @Deprecated(message = "Use request.add { BlobDataPart(...) } instead", replaceWith = @ReplaceWith(expression = "add(blobsCallback)", imports = {}))
    public final UploadRequest blob(Function2<? super Request, ? super URL, Blob> blobCallback) {
        Intrinsics.checkNotNullParameter(blobCallback, "blobCallback");
        throw new NotImplementedError("request.blob has been removed. Use request.add { BlobDataPart(...) } instead.");
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use request.add({ ... }, { ... }, ...) instead", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public final UploadRequest dataParts(Function2<? super Request, ? super URL, ? extends Iterable<? extends DataPart>> dataPartsCallback) {
        Intrinsics.checkNotNullParameter(dataPartsCallback, "dataPartsCallback");
        throw new NotImplementedError("request.dataParts has been removed. Use request.add { XXXDataPart(...) } instead.");
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use request.add({ FileDataPart(...) }, { ... }, ...) instead", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public final UploadRequest sources(Function2<? super Request, ? super URL, ? extends Iterable<? extends File>> sourcesCallback) {
        Intrinsics.checkNotNullParameter(sourcesCallback, "sourcesCallback");
        throw new NotImplementedError("request.sources has been removed. Use request.add({ BlobDataPart(...) }, { ... }, ...) instead.");
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use request.add { FileDataPart(...)} instead", replaceWith = @ReplaceWith(expression = "add(sourceCallback)", imports = {}))
    public final UploadRequest source(Function2<? super Request, ? super URL, ? extends File> sourceCallback) {
        Intrinsics.checkNotNullParameter(sourceCallback, "sourceCallback");
        throw new NotImplementedError("request.source has been removed. Use request.add { FileDataPart(...) } instead.");
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Set the name via DataPart (FileDataPart, InlineDataPart, BlobDataPart) instead", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public final UploadRequest name(Function0<String> nameCallback) {
        Intrinsics.checkNotNullParameter(nameCallback, "nameCallback");
        throw new NotImplementedError("request.name has been removed. Set the name via DataPart (FileDataPart, InlineDataPart, BlobDataPart) instead");
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Set the name via DataPart (FileDataPart, InlineDataPart, BlobDataPart) instead", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public final UploadRequest name(String newName) {
        Intrinsics.checkNotNullParameter(newName, "newName");
        throw new NotImplementedError("request.name has been removed. Set the name via DataPart (FileDataPart, InlineDataPart, BlobDataPart) instead");
    }

    public final UploadRequest add(Function1<? super Request, ? extends DataPart>... dataParts) {
        Intrinsics.checkNotNullParameter(dataParts, "dataParts");
        UploadRequest uploadRequestPlus = this;
        for (Function1<? super Request, ? extends DataPart> function1 : dataParts) {
            uploadRequestPlus = uploadRequestPlus.plus(function1);
        }
        return uploadRequestPlus;
    }

    public final UploadRequest plus(Iterable<? extends DataPart> dataParts) {
        Intrinsics.checkNotNullParameter(dataParts, "dataParts");
        Iterator<? extends DataPart> it = dataParts.iterator();
        UploadRequest uploadRequestPlus = this;
        while (it.hasNext()) {
            uploadRequestPlus = uploadRequestPlus.plus(it.next());
        }
        return uploadRequestPlus;
    }
}
