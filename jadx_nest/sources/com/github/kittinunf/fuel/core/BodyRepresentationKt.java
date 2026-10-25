package com.github.kittinunf.fuel.core;

import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: BodyRepresentation.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0014\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"TEXT_CONTENT_TYPE", "Lkotlin/text/Regex;", "representationOfBytes", "", "Lcom/github/kittinunf/fuel/core/Body;", "contentType", "fuel"}, k = 2, mv = {1, 4, 0})
public final class BodyRepresentationKt {
    private static final Regex TEXT_CONTENT_TYPE = new Regex("^(?:text/.*|application/(?:csv|javascript|json|typescript|xml|x-yaml|x-www-form-urlencoded|vnd\\.coffeescript)|.*\\+(?:xml|json))");

    public static final String representationOfBytes(Body representationOfBytes, String str) {
        String str2;
        Charset charsetForName;
        Object next;
        String strSubstringAfter$default;
        Intrinsics.checkNotNullParameter(representationOfBytes, "$this$representationOfBytes");
        String str3 = str;
        if (str3 == null || str3.length() == 0) {
            str = "(unknown)";
        }
        if (TEXT_CONTENT_TYPE.containsMatchIn(str)) {
            Regex regex = new Regex("^CHARSET=.*");
            if (str != null) {
                String upperCase = str.toUpperCase();
                Intrinsics.checkNotNullExpressionValue(upperCase, "(this as java.lang.String).toUpperCase()");
                List<String> listSplit$default = StringsKt.split$default((CharSequence) upperCase, new char[]{';'}, false, 0, 6, (Object) null);
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listSplit$default, 10));
                for (String str4 : listSplit$default) {
                    if (str4 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
                    }
                    arrayList.add(StringsKt.trim((CharSequence) str4).toString());
                }
                try {
                    Iterator it = arrayList.iterator();
                    do {
                        if (!it.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it.next();
                    } while (!regex.matches((String) next));
                    String str5 = (String) next;
                    if (str5 == null || (strSubstringAfter$default = StringsKt.substringAfter$default(str5, "CHARSET=", (String) null, 2, (Object) null)) == null) {
                        strSubstringAfter$default = "";
                    }
                    charsetForName = Charset.forName(strSubstringAfter$default);
                    Intrinsics.checkNotNullExpressionValue(charsetForName, "Charset.forName(paramete…gAfter(\"CHARSET=\") ?: \"\")");
                } catch (IllegalCharsetNameException unused) {
                    charsetForName = Charsets.US_ASCII;
                }
                return new String(representationOfBytes.toByteArray(), charsetForName);
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        Long length = representationOfBytes.getLength();
        long jLongValue = length != null ? length.longValue() : -1L;
        if (jLongValue == 0) {
            return "(empty)";
        }
        if (jLongValue < 0) {
            str2 = "unknown number of bytes";
        } else {
            str2 = jLongValue + " bytes";
        }
        return "(" + str2 + " of " + str + ')';
    }
}
