package com.github.kittinunf.fuel.core.interceptors;

import com.github.kittinunf.fuel.core.Method;
import com.github.kittinunf.fuel.core.Request;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import okhttp3.HttpUrl;
import org.jsoup.helper.HttpConnection;

/* JADX INFO: compiled from: ParameterEncoder.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u000022\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001j\u0002`\u0003\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001j\u0002`\u00030\u0001j\u0002`\u0004B\u0007\b\u0002¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0002J(\u0010\n\u001a\u00020\u000b2\u001e\u0010\f\u001a\u001a\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000e0\rj\u0002`\u0010H\u0002J1\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001j\u0002`\u00032\u0016\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001j\u0002`\u0003H\u0096\u0002J,\u0010\u0013\u001a\u00020\u0014*\u00020\u00142\u001e\u0010\f\u001a\u001a\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000e0\rj\u0002`\u0010H\u0002¨\u0006\u0015"}, d2 = {"Lcom/github/kittinunf/fuel/core/interceptors/ParameterEncoder;", "Lkotlin/Function1;", "Lcom/github/kittinunf/fuel/core/Request;", "Lcom/github/kittinunf/fuel/core/RequestTransformer;", "Lcom/github/kittinunf/fuel/core/FoldableRequestInterceptor;", "()V", "allowParametersInBody", "", "method", "Lcom/github/kittinunf/fuel/core/Method;", "encode", "", "parameters", "", "Lkotlin/Pair;", "", "Lcom/github/kittinunf/fuel/core/Parameters;", "invoke", "next", "withParameters", "Ljava/net/URL;", "fuel"}, k = 1, mv = {1, 4, 0})
public final class ParameterEncoder implements Function1<Function1<? super Request, ? extends Request>, Function1<? super Request, ? extends Request>> {
    public static final ParameterEncoder INSTANCE = new ParameterEncoder();

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 0})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Method.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[Method.POST.ordinal()] = 1;
            iArr[Method.PATCH.ordinal()] = 2;
            iArr[Method.PUT.ordinal()] = 3;
        }
    }

    /* JADX INFO: renamed from: com.github.kittinunf.fuel.core.interceptors.ParameterEncoder$encode$3, reason: invalid class name */
    /* JADX INFO: compiled from: ParameterEncoder.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u00040\u00040\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "<name for destructuring parameter 0>", "Lkotlin/Pair;", "", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 4, 0})
    static final class AnonymousClass3 extends Lambda implements Function1<Pair<? extends String, ? extends String>, CharSequence> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ CharSequence invoke(Pair<? extends String, ? extends String> pair) {
            return invoke2((Pair<String, String>) pair);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final CharSequence invoke2(Pair<String, String> pair) {
            Intrinsics.checkNotNullParameter(pair, "<name for destructuring parameter 0>");
            String strComponent1 = pair.component1();
            String value = pair.component2();
            Intrinsics.checkNotNullExpressionValue(value, "value");
            return StringsKt.isBlank(value) ? strComponent1 : strComponent1 + '=' + value;
        }
    }

    private ParameterEncoder() {
    }

    /* JADX INFO: renamed from: com.github.kittinunf.fuel.core.interceptors.ParameterEncoder$invoke$1, reason: invalid class name */
    /* JADX INFO: compiled from: ParameterEncoder.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/github/kittinunf/fuel/core/Request;", "request", "invoke"}, k = 3, mv = {1, 4, 0})
    static final class AnonymousClass1 extends Lambda implements Function1<Request, Request> {
        final /* synthetic */ Function1 $next;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Function1 function1) {
            super(1);
            this.$next = function1;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Request invoke(Request request) {
            String str;
            Intrinsics.checkNotNullParameter(request, "request");
            String str2 = (String) CollectionsKt.lastOrNull(request.get("Content-Type"));
            if (str2 != null && StringsKt.startsWith$default(str2, HttpConnection.MULTIPART_FORM_DATA, false, 2, (Object) null)) {
                return (Request) this.$next.invoke(request);
            }
            if (request.getBody().isEmpty() && ParameterEncoder.INSTANCE.allowParametersInBody(request.getMethod()) && ((str = str2) == null || StringsKt.isBlank(str) || StringsKt.startsWith$default(str2, "application/x-www-form-urlencoded", false, 2, (Object) null))) {
                Function1 function1 = this.$next;
                Request requestBody$default = Request.DefaultImpls.body$default(request.header("Content-Type", "application/x-www-form-urlencoded"), ParameterEncoder.INSTANCE.encode(request.getParameters()), (Charset) null, 2, (Object) null);
                requestBody$default.setParameters(CollectionsKt.emptyList());
                Unit unit = Unit.INSTANCE;
                return (Request) function1.invoke(requestBody$default);
            }
            Function1 function2 = this.$next;
            request.setUrl(ParameterEncoder.INSTANCE.withParameters(request.getUrl(), request.getParameters()));
            Unit unit2 = Unit.INSTANCE;
            request.setParameters(CollectionsKt.emptyList());
            Unit unit3 = Unit.INSTANCE;
            return (Request) function2.invoke(request);
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public Function1<Request, Request> invoke(Function1<? super Request, ? extends Request> next) {
        Intrinsics.checkNotNullParameter(next, "next");
        return new AnonymousClass1(next);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String encode(List<? extends Pair<String, ? extends Object>> parameters) {
        ArrayList arrayListListOf;
        List list;
        ArrayList<Pair> arrayList = new ArrayList();
        for (Object obj : parameters) {
            if (((Pair) obj).component2() != null) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Pair pair : arrayList) {
            String str = (String) pair.component1();
            Object objComponent2 = pair.component2();
            List list2 = null;
            Iterable iterable = (Iterable) (!(objComponent2 instanceof Iterable) ? null : objComponent2);
            if (iterable == null || (list = CollectionsKt.toList(iterable)) == null) {
                Object[] objArr = (Object[]) (!(objComponent2 instanceof Object[]) ? null : objComponent2);
                if (objArr != null) {
                    list2 = ArraysKt.toList(objArr);
                }
            } else {
                list2 = list;
            }
            if (list2 != null) {
                String str2 = URLEncoder.encode(str, "UTF-8") + HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
                List list3 = list2;
                ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list3, 10));
                Iterator it = list3.iterator();
                while (it.hasNext()) {
                    arrayList3.add(TuplesKt.to(str2, URLEncoder.encode(String.valueOf(it.next()), "UTF-8")));
                }
                arrayListListOf = arrayList3;
            } else {
                arrayListListOf = CollectionsKt.listOf(TuplesKt.to(URLEncoder.encode(str, "UTF-8"), URLEncoder.encode(String.valueOf(objComponent2), "UTF-8")));
            }
            CollectionsKt.addAll(arrayList2, arrayListListOf);
        }
        return CollectionsKt.joinToString$default(arrayList2, "&", null, null, 0, null, AnonymousClass3.INSTANCE, 30, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean allowParametersInBody(Method method) {
        int i = WhenMappings.$EnumSwitchMapping$0[method.ordinal()];
        return i == 1 || i == 2 || i == 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final URL withParameters(URL url, List<? extends Pair<String, ? extends Object>> list) {
        String str;
        String strEncode = INSTANCE.encode(list);
        if (strEncode.length() == 0) {
            return url;
        }
        String externalForm = url.toExternalForm();
        Intrinsics.checkNotNullExpressionValue(externalForm, "toExternalForm()");
        if (StringsKt.contains$default((CharSequence) externalForm, '?', false, 2, (Object) null)) {
            String query = url.getQuery();
            Intrinsics.checkNotNullExpressionValue(query, "query");
            str = query.length() > 0 ? "&" : "";
        } else {
            str = "?";
        }
        return new URL(url.toExternalForm() + str + strEncode);
    }
}
