package com.prof18.rssparser.internal.atom;

import com.prof18.rssparser.internal.AtomKeyword;
import com.prof18.rssparser.internal.ChannelFactory;
import com.prof18.rssparser.internal.XmlPullParser_Kt;
import com.prof18.rssparser.model.RssChannel;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: compiled from: AtomParser.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000¨\u0006\u0005"}, d2 = {"extractAtomContent", "Lcom/prof18/rssparser/model/RssChannel;", "Lkotlinx/coroutines/CoroutineScope;", "xmlPullParser", "Lorg/xmlpull/v1/XmlPullParser;", "rssparser_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class AtomParserKt {
    public static final RssChannel extractAtomContent(CoroutineScope coroutineScope, XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        String strNextTrimmedText;
        Intrinsics.checkNotNullParameter(coroutineScope, "<this>");
        Intrinsics.checkNotNullParameter(xmlPullParser, "xmlPullParser");
        ChannelFactory channelFactory = new ChannelFactory();
        int eventType = xmlPullParser.getEventType();
        boolean z = false;
        boolean z2 = false;
        while (eventType != 1 && CoroutineScopeKt.isActive(coroutineScope)) {
            if (eventType == 2) {
                if (XmlPullParser_Kt.contains(xmlPullParser, AtomKeyword.Atom.INSTANCE)) {
                    z = true;
                } else if (XmlPullParser_Kt.contains(xmlPullParser, AtomKeyword.Entry.Item.INSTANCE)) {
                    z2 = true;
                } else if (XmlPullParser_Kt.contains(xmlPullParser, AtomKeyword.Icon.INSTANCE)) {
                    if (z) {
                        channelFactory.getChannelImageBuilder().url(XmlPullParser_Kt.nextTrimmedText(xmlPullParser));
                    }
                } else if (XmlPullParser_Kt.contains(xmlPullParser, AtomKeyword.Entry.Author.INSTANCE)) {
                    if (z2) {
                        channelFactory.getArticleBuilder().author(XmlPullParser_Kt.nextTrimmedText(xmlPullParser));
                    }
                } else if (XmlPullParser_Kt.contains(xmlPullParser, AtomKeyword.Entry.Category.INSTANCE)) {
                    if (z2) {
                        String strNextTrimmedText2 = XmlPullParser_Kt.nextTrimmedText(xmlPullParser);
                        String strAttributeValue = XmlPullParser_Kt.attributeValue(xmlPullParser, AtomKeyword.Entry.Term.INSTANCE);
                        if (strNextTrimmedText2 != null && strNextTrimmedText2.length() == 0) {
                            strNextTrimmedText2 = strAttributeValue;
                        }
                        channelFactory.getArticleBuilder().addCategory(strNextTrimmedText2);
                    }
                } else if (XmlPullParser_Kt.contains(xmlPullParser, AtomKeyword.Entry.Guid.INSTANCE)) {
                    if (z2) {
                        channelFactory.getArticleBuilder().guid(XmlPullParser_Kt.nextTrimmedText(xmlPullParser));
                    }
                } else if (XmlPullParser_Kt.contains(xmlPullParser, AtomKeyword.Entry.Content.INSTANCE)) {
                    if (z2) {
                        try {
                            strNextTrimmedText = XmlPullParser_Kt.nextTrimmedText(xmlPullParser);
                        } catch (XmlPullParserException unused) {
                            strNextTrimmedText = null;
                        }
                        channelFactory.getArticleBuilder().content(strNextTrimmedText);
                        channelFactory.setImageFromContent(strNextTrimmedText);
                    }
                } else if (XmlPullParser_Kt.contains(xmlPullParser, AtomKeyword.Updated.INSTANCE)) {
                    if (z2) {
                        channelFactory.getArticleBuilder().pubDateIfNull(XmlPullParser_Kt.nextTrimmedText(xmlPullParser));
                    } else if (z) {
                        channelFactory.getChannelBuilder().lastBuildDate(XmlPullParser_Kt.nextTrimmedText(xmlPullParser));
                    }
                } else if (XmlPullParser_Kt.contains(xmlPullParser, AtomKeyword.Entry.Published.INSTANCE)) {
                    if (z2) {
                        channelFactory.getArticleBuilder().pubDateIfNull(XmlPullParser_Kt.nextTrimmedText(xmlPullParser));
                    }
                } else if (XmlPullParser_Kt.contains(xmlPullParser, AtomKeyword.Subtitle.INSTANCE)) {
                    if (z) {
                        channelFactory.getChannelBuilder().description(XmlPullParser_Kt.nextTrimmedText(xmlPullParser));
                    }
                } else if (XmlPullParser_Kt.contains(xmlPullParser, AtomKeyword.Entry.Description.INSTANCE)) {
                    if (z2) {
                        String strNextTrimmedText3 = XmlPullParser_Kt.nextTrimmedText(xmlPullParser);
                        channelFactory.getArticleBuilder().description(strNextTrimmedText3);
                        channelFactory.setImageFromContent(strNextTrimmedText3);
                    }
                } else if (XmlPullParser_Kt.contains(xmlPullParser, AtomKeyword.Title.INSTANCE)) {
                    if (z2) {
                        channelFactory.getArticleBuilder().title(XmlPullParser_Kt.nextTrimmedText(xmlPullParser));
                    } else if (z) {
                        channelFactory.getChannelBuilder().title(XmlPullParser_Kt.nextTrimmedText(xmlPullParser));
                    }
                } else if (XmlPullParser_Kt.contains(xmlPullParser, AtomKeyword.Link.INSTANCE) && z) {
                    String strAttributeValue2 = XmlPullParser_Kt.attributeValue(xmlPullParser, AtomKeyword.Link.Href.INSTANCE);
                    String strAttributeValue3 = XmlPullParser_Kt.attributeValue(xmlPullParser, AtomKeyword.Link.Rel.INSTANCE);
                    if (!Intrinsics.areEqual(strAttributeValue3, AtomKeyword.Link.Edit.INSTANCE.getValue()) && !Intrinsics.areEqual(strAttributeValue3, AtomKeyword.Link.Self.INSTANCE.getValue())) {
                        if (z2) {
                            channelFactory.getArticleBuilder().link(strAttributeValue2);
                        } else {
                            channelFactory.getChannelBuilder().link(strAttributeValue2);
                        }
                    }
                }
            } else if (eventType == 3 && XmlPullParser_Kt.contains(xmlPullParser, AtomKeyword.Entry.Item.INSTANCE)) {
                channelFactory.buildArticle();
                z2 = false;
            } else if (eventType == 3 && XmlPullParser_Kt.contains(xmlPullParser, AtomKeyword.Atom.INSTANCE)) {
                z = false;
            }
            eventType = xmlPullParser.next();
        }
        return channelFactory.build();
    }
}
