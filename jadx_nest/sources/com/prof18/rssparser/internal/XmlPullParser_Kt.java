package com.prof18.rssparser.internal;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: XmlPullParser+.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u0016\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\u0016\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0005H\u0000\u001a\u0014\u0010\u0006\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\u0014\u0010\u0006\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0005H\u0000\u001a\u000e\u0010\b\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0000¨\u0006\t"}, d2 = {"attributeValue", "", "Lorg/xmlpull/v1/XmlPullParser;", "key", "Lcom/prof18/rssparser/internal/AtomKeyword;", "Lcom/prof18/rssparser/internal/RssKeyword;", "contains", "", "nextTrimmedText", "rssparser_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class XmlPullParser_Kt {
    public static final String nextTrimmedText(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        Intrinsics.checkNotNullParameter(xmlPullParser, "<this>");
        String strNextText = xmlPullParser.nextText();
        if (strNextText != null) {
            return StringsKt.trim((CharSequence) strNextText).toString();
        }
        return null;
    }

    public static final boolean contains(XmlPullParser xmlPullParser, RssKeyword key) {
        Intrinsics.checkNotNullParameter(xmlPullParser, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        return StringsKt.equals(xmlPullParser.getName(), key.getValue(), true);
    }

    public static final String attributeValue(XmlPullParser xmlPullParser, RssKeyword key) {
        Intrinsics.checkNotNullParameter(xmlPullParser, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        String attributeValue = xmlPullParser.getAttributeValue(null, key.getValue());
        if (attributeValue != null) {
            return StringsKt.trim((CharSequence) attributeValue).toString();
        }
        return null;
    }

    public static final boolean contains(XmlPullParser xmlPullParser, AtomKeyword key) {
        Intrinsics.checkNotNullParameter(xmlPullParser, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        return StringsKt.equals(xmlPullParser.getName(), key.getValue(), true);
    }

    public static final String attributeValue(XmlPullParser xmlPullParser, AtomKeyword key) {
        Intrinsics.checkNotNullParameter(xmlPullParser, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        String attributeValue = xmlPullParser.getAttributeValue(null, key.getValue());
        if (attributeValue != null) {
            return StringsKt.trim((CharSequence) attributeValue).toString();
        }
        return null;
    }
}
