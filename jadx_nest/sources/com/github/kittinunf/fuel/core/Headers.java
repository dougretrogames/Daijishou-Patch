package com.github.kittinunf.fuel.core;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableMap;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: Headers.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0010'\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u001f\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 12\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00020\u0003j\u0002`\u00040\u0001:\u00011B\u0005¢\u0006\u0002\u0010\u0005J\u0016\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001cJ\u001a\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u00022\n\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\u0003J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0002H\u0016J\u001a\u0010\"\u001a\u00020 2\u0010\u0010\u001b\u001a\f\u0012\u0004\u0012\u00020\u00020\u0003j\u0002`\u0004H\u0016J\u001b\u0010#\u001a\f\u0012\u0004\u0012\u00020\u00020\u0003j\u0002`\u00042\u0006\u0010!\u001a\u00020\u0002H\u0096\u0002J\b\u0010$\u001a\u00020 H\u0016J0\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0003j\u0004\u0018\u0001`\u00042\u0006\u0010!\u001a\u00020\u00022\u0010\u0010\u001b\u001a\f\u0012\u0004\u0012\u00020\u00020\u0003j\u0002`\u0004H\u0016J(\u0010&\u001a\u00020\u001e2\u001e\u0010'\u001a\u001a\u0012\u0006\b\u0001\u0012\u00020\u0002\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00020\u0003j\u0002`\u00040(H\u0016J\u001e\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0003j\u0004\u0018\u0001`\u00042\u0006\u0010!\u001a\u00020\u0002H\u0016J#\u0010*\u001a\u00020\u00002\u0006\u0010!\u001a\u00020\u00022\u0010\u0010\u0015\u001a\f\u0012\u0004\u0012\u00020\u00020\u0003j\u0002`\u0004H\u0086\u0002J\u0019\u0010*\u001a\u00020\u00002\u0006\u0010!\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0002H\u0086\u0002J\b\u0010+\u001a\u00020\u0002H\u0016J|\u0010,\u001a\u00020\u001e28\u0010*\u001a4\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(!\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(\u001b\u0012\u0006\u0012\u0004\u0018\u00010\u001c0-2:\b\u0002\u00100\u001a4\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(!\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b.\u0012\b\b/\u0012\u0004\b\b(\u001b\u0012\u0006\u0012\u0004\u0018\u00010\u001c0-R:\u0010\u0006\u001a.\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00030\u0007j\u0018\u0012\u0004\u0012\u00020\b\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00020\u0003j\u0002`\u0004`\tX\u0082\u000e¢\u0006\u0002\n\u0000R0\u0010\n\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0004\u0012\u00020\u0002\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00020\u0003j\u0002`\u00040\f0\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\u00128VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R$\u0010\u0015\u001a\u0012\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\u00020\u0003j\u0002`\u00040\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u00062"}, d2 = {"Lcom/github/kittinunf/fuel/core/Headers;", "", "", "", "Lcom/github/kittinunf/fuel/core/HeaderValues;", "()V", "contents", "Ljava/util/HashMap;", "Lcom/github/kittinunf/fuel/core/HeaderName;", "Lkotlin/collections/HashMap;", "entries", "", "", "getEntries", "()Ljava/util/Set;", "keys", "getKeys", "size", "", "getSize", "()I", "values", "", "getValues", "()Ljava/util/Collection;", "append", "header", "value", "", "clear", "", "containsKey", "", "key", "containsValue", "get", "isEmpty", "put", "putAll", TypedValues.TransitionType.S_FROM, "", "remove", "set", "toString", "transformIterate", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "add", "Companion", "fuel"}, k = 1, mv = {1, 4, 0})
public final class Headers implements Map<String, Collection<? extends String>>, KMutableMap {
    public static final String ACCEPT = "Accept";
    public static final String ACCEPT_ENCODING = "Accept-Encoding";
    public static final String ACCEPT_LANGUAGE = "Accept-Language";
    public static final String ACCEPT_TRANSFER_ENCODING = "TE";
    public static final String AGE = "Age";
    public static final String AUTHORIZATION = "Authorization";
    public static final String CACHE_CONTROL = "Cache-Control";
    public static final String CONTENT_DISPOSITION = "Content-Disposition";
    public static final String CONTENT_ENCODING = "Content-Encoding";
    public static final String CONTENT_LENGTH = "Content-Length";
    public static final String CONTENT_LOCATION = "Content-Location";
    public static final String CONTENT_TYPE = "Content-Type";
    public static final String COOKIE = "Cookie";
    public static final String EXPECT = "Expect";
    public static final String EXPIRES = "Expires";
    public static final String LOCATION = "Location";
    public static final String SET_COOKIE = "Set-Cookie";
    public static final String TRANSFER_ENCODING = "Transfer-Encoding";
    public static final String USER_AGENT = "User-Agent";
    private HashMap<HeaderName, Collection<String>> contents = new HashMap<>();

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Map<HeaderName, Boolean> COLLAPSIBLE_HEADERS = MapsKt.mapOf(TuplesKt.to(new HeaderName("Set-Cookie"), false));
    private static final Map<HeaderName, Boolean> SINGLE_VALUE_HEADERS = MapsKt.mapOf(TuplesKt.to(new HeaderName("Age"), true), TuplesKt.to(new HeaderName("Content-Encoding"), true), TuplesKt.to(new HeaderName("Content-Length"), true), TuplesKt.to(new HeaderName("Content-Location"), true), TuplesKt.to(new HeaderName("Content-Type"), true), TuplesKt.to(new HeaderName("Expect"), true), TuplesKt.to(new HeaderName("Expires"), true), TuplesKt.to(new HeaderName("Location"), true), TuplesKt.to(new HeaderName("User-Agent"), true));
    private static final Map<HeaderName, String> COLLAPSE_SEPARATOR = MapsKt.mapOf(TuplesKt.to(new HeaderName("Cookie"), "; "));

    @Override // java.util.Map
    public final /* bridge */ boolean containsKey(Object obj) {
        if (obj instanceof String) {
            return containsKey((String) obj);
        }
        return false;
    }

    @Override // java.util.Map
    public final /* bridge */ boolean containsValue(Object obj) {
        if (obj instanceof Collection) {
            return containsValue((Collection<String>) obj);
        }
        return false;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map.Entry<String, Collection<? extends String>>> entrySet() {
        return getEntries();
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<? extends String> get(Object obj) {
        if (obj instanceof String) {
            return get((String) obj);
        }
        return null;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<String> keySet() {
        return getKeys();
    }

    @Override // java.util.Map
    public /* bridge */ /* synthetic */ Collection<? extends String> put(String str, Collection<? extends String> collection) {
        return put2(str, (Collection<String>) collection);
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<? extends String> remove(Object obj) {
        if (obj instanceof String) {
            return remove((String) obj);
        }
        return null;
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<Collection<? extends String>> values() {
        return getValues();
    }

    public Set<Map.Entry<String, Collection<String>>> getEntries() {
        HashMap<HeaderName, Collection<String>> map = this.contents;
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(map.size()));
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(((HeaderName) entry.getKey()).getName(), entry.getValue());
        }
        return MapsKt.toMutableMap(linkedHashMap).entrySet();
    }

    public Set<String> getKeys() {
        Set<HeaderName> setKeySet = this.contents.keySet();
        Intrinsics.checkNotNullExpressionValue(setKeySet, "contents.keys");
        Set<HeaderName> set = setKeySet;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(set, 10));
        Iterator<T> it = set.iterator();
        while (it.hasNext()) {
            arrayList.add(((HeaderName) it.next()).getName());
        }
        return CollectionsKt.toMutableSet(new HashSet(arrayList));
    }

    public Collection<Collection<String>> getValues() {
        Collection<Collection<String>> collectionValues = this.contents.values();
        Intrinsics.checkNotNullExpressionValue(collectionValues, "contents.values");
        return collectionValues;
    }

    @Override // java.util.Map
    public void clear() {
        this.contents.clear();
    }

    /* JADX INFO: renamed from: put, reason: avoid collision after fix types in other method */
    public Collection<String> put2(String key, Collection<String> value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        return this.contents.put(new HeaderName(key), value);
    }

    public final Headers append(String header, Collection<?> values) {
        Intrinsics.checkNotNullParameter(header, "header");
        Intrinsics.checkNotNullParameter(values, "values");
        Collection<? extends String> collection = get((Object) header);
        Collection<?> collection2 = values;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(collection2, 10));
        Iterator<T> it = collection2.iterator();
        while (it.hasNext()) {
            arrayList.add(String.valueOf(it.next()));
        }
        put2(header, (Collection<String>) CollectionsKt.plus((Collection) collection, (Iterable) arrayList));
        return this;
    }

    public final Headers append(String header, Object value) {
        Intrinsics.checkNotNullParameter(header, "header");
        Intrinsics.checkNotNullParameter(value, "value");
        boolean zIsSingleValue = INSTANCE.isSingleValue(header);
        if (zIsSingleValue) {
            return set(header, value.toString());
        }
        if (zIsSingleValue) {
            throw new NoWhenBranchMatchedException();
        }
        return set(header, CollectionsKt.plus(get((Object) header), value.toString()));
    }

    @Override // java.util.Map
    public void putAll(Map<? extends String, ? extends Collection<? extends String>> from) {
        Intrinsics.checkNotNullParameter(from, "from");
        for (Map.Entry<String, Collection<? extends String>> entry : INSTANCE.from(from).entrySet()) {
            put2(entry.getKey(), (Collection<String>) entry.getValue());
        }
    }

    public Collection<String> remove(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.contents.remove(new HeaderName(key));
    }

    public int getSize() {
        return this.contents.size();
    }

    public boolean containsKey(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.contents.containsKey(new HeaderName(key));
    }

    public boolean containsValue(Collection<String> value) {
        Intrinsics.checkNotNullParameter(value, "value");
        return this.contents.containsValue(value);
    }

    public Collection<String> get(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        HeaderName headerName = new HeaderName(key);
        List listEmptyList = this.contents.get(headerName);
        if (listEmptyList == null) {
            listEmptyList = CollectionsKt.emptyList();
        }
        boolean zIsSingleValue = INSTANCE.isSingleValue(headerName);
        if (zIsSingleValue) {
            return CollectionsKt.listOfNotNull(CollectionsKt.lastOrNull(listEmptyList));
        }
        if (zIsSingleValue) {
            throw new NoWhenBranchMatchedException();
        }
        return listEmptyList;
    }

    public final Headers set(String key, String value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        put2(key, (Collection<String>) CollectionsKt.listOf(value));
        return this;
    }

    public final Headers set(String key, Collection<String> values) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(values, "values");
        put2(key, values);
        return this;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.contents.isEmpty();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void transformIterate$default(Headers headers, Function2 function2, Function2 function3, int i, Object obj) {
        if ((i & 2) != 0) {
            function3 = function2;
        }
        headers.transformIterate(function2, function3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void transformIterate(Function2<? super String, ? super String, ? extends Object> set, Function2<? super String, ? super String, ? extends Object> add) {
        Intrinsics.checkNotNullParameter(set, "set");
        Intrinsics.checkNotNullParameter(add, "add");
        for (Map.Entry<String, Collection<? extends String>> entry : entrySet()) {
            String key = entry.getKey();
            Collection<? extends String> value = entry.getValue();
            HeaderName headerName = new HeaderName(key);
            Companion companion = INSTANCE;
            boolean zIsCollapsible = companion.isCollapsible(headerName);
            if (zIsCollapsible) {
                set.invoke(key, companion.collapse(headerName, (Collection<String>) value));
            } else if (!zIsCollapsible) {
                boolean zIsSingleValue = companion.isSingleValue(headerName);
                if (zIsSingleValue) {
                    String str = (String) CollectionsKt.lastOrNull(value);
                    if (str != null) {
                        set.invoke(key, str);
                    }
                } else if (!zIsSingleValue) {
                    Iterator<T> it = value.iterator();
                    while (it.hasNext()) {
                        add.invoke(key, (String) it.next());
                    }
                }
            }
        }
    }

    public String toString() {
        String string = this.contents.toString();
        Intrinsics.checkNotNullExpressionValue(string, "contents.toString()");
        return string;
    }

    /* JADX INFO: compiled from: Headers.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\r2\u0010\u0010\u001f\u001a\f\u0012\u0004\u0012\u00020\u00040 j\u0002`!J \u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u00042\u0010\u0010\u001f\u001a\f\u0012\u0004\u0012\u00020\u00040 j\u0002`!J7\u0010\"\u001a\u00020#2*\u0010$\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010&0%\"\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010&¢\u0006\u0002\u0010'J \u0010\"\u001a\u00020#2\u0018\u0010$\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010&0 J\u001c\u0010\"\u001a\u00020#2\u0014\u0010(\u001a\u0010\u0012\u0006\b\u0001\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\fJ\u000e\u0010)\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\rJ\u000e\u0010)\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u0004J\u000e\u0010*\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\rJ\u000e\u0010*\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00040\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000f0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000f0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/github/kittinunf/fuel/core/Headers$Companion;", "", "()V", "ACCEPT", "", "ACCEPT_ENCODING", "ACCEPT_LANGUAGE", "ACCEPT_TRANSFER_ENCODING", "AGE", "AUTHORIZATION", "CACHE_CONTROL", "COLLAPSE_SEPARATOR", "", "Lcom/github/kittinunf/fuel/core/HeaderName;", "COLLAPSIBLE_HEADERS", "", "CONTENT_DISPOSITION", "CONTENT_ENCODING", "CONTENT_LENGTH", "CONTENT_LOCATION", "CONTENT_TYPE", "COOKIE", "EXPECT", "EXPIRES", "LOCATION", "SET_COOKIE", "SINGLE_VALUE_HEADERS", "TRANSFER_ENCODING", "USER_AGENT", "collapse", "header", "values", "", "Lcom/github/kittinunf/fuel/core/HeaderValues;", TypedValues.TransitionType.S_FROM, "Lcom/github/kittinunf/fuel/core/Headers;", "pairs", "", "Lkotlin/Pair;", "([Lkotlin/Pair;)Lcom/github/kittinunf/fuel/core/Headers;", "source", "isCollapsible", "isSingleValue", "fuel"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean isCollapsible(HeaderName header) {
            Intrinsics.checkNotNullParameter(header, "header");
            Object objValueOf = Headers.COLLAPSIBLE_HEADERS.get(header);
            if (objValueOf == null) {
                objValueOf = Boolean.valueOf(!Headers.INSTANCE.isSingleValue(header));
            }
            return ((Boolean) objValueOf).booleanValue();
        }

        public final boolean isSingleValue(HeaderName header) {
            Intrinsics.checkNotNullParameter(header, "header");
            Boolean bool = (Boolean) Headers.SINGLE_VALUE_HEADERS.get(header);
            if (bool != null) {
                return bool.booleanValue();
            }
            return false;
        }

        public final String collapse(HeaderName header, Collection<String> values) {
            Intrinsics.checkNotNullParameter(header, "header");
            Intrinsics.checkNotNullParameter(values, "values");
            Collection<String> collection = values;
            String str = (String) Headers.COLLAPSE_SEPARATOR.get(header);
            if (str == null) {
                str = ", ";
            }
            return CollectionsKt.joinToString$default(collection, str, null, null, 0, null, null, 62, null);
        }

        public final boolean isCollapsible(String header) {
            Intrinsics.checkNotNullParameter(header, "header");
            return isCollapsible(new HeaderName(header));
        }

        public final boolean isSingleValue(String header) {
            Intrinsics.checkNotNullParameter(header, "header");
            return isSingleValue(new HeaderName(header));
        }

        public final String collapse(String header, Collection<String> values) {
            Intrinsics.checkNotNullParameter(header, "header");
            Intrinsics.checkNotNullParameter(values, "values");
            return collapse(new HeaderName(header), values);
        }

        public final Headers from(Collection<? extends Pair<String, ? extends Object>> pairs) {
            Intrinsics.checkNotNullParameter(pairs, "pairs");
            Headers headers = new Headers();
            Iterator<T> it = pairs.iterator();
            while (it.hasNext()) {
                Pair pair = (Pair) it.next();
                String str = (String) pair.getFirst();
                if (str == null) {
                    str = "";
                }
                String str2 = str;
                if (StringsKt.isBlank(str2)) {
                    str2 = null;
                }
                String str3 = str2;
                if (str3 != null) {
                    Object second = pair.getSecond();
                    if (second instanceof Collection) {
                        Collection collection = (Collection) second;
                        Collection collection2 = collection.isEmpty() ? null : collection;
                        if (collection2 != null) {
                            Collection collection3 = collection2;
                            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(collection3, 10));
                            Iterator it2 = collection3.iterator();
                            while (it2.hasNext()) {
                                arrayList.add(String.valueOf(it2.next()));
                            }
                            headers = headers.append(str3, (Collection<?>) arrayList);
                        }
                    } else {
                        headers = headers.append(str3, second.toString());
                    }
                }
            }
            return headers;
        }

        public final Headers from(Map<? extends String, ? extends Object> source) {
            Intrinsics.checkNotNullParameter(source, "source");
            Set<Map.Entry<? extends String, ? extends Object>> setEntrySet = source.entrySet();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(setEntrySet, 10));
            Iterator<T> it = setEntrySet.iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                arrayList.add(new Pair(entry.getKey(), entry.getValue()));
            }
            return from(arrayList);
        }

        public final Headers from(Pair<String, ? extends Object>... pairs) {
            Intrinsics.checkNotNullParameter(pairs, "pairs");
            return from(ArraysKt.toList(pairs));
        }
    }
}
