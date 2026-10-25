package com.prof18.rssparser.internal;

import com.prof18.rssparser.exception.RssParsingException;
import com.prof18.rssparser.internal.atom.AtomParserKt;
import com.prof18.rssparser.internal.rss.RssParserKt;
import com.prof18.rssparser.model.RssChannel;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* JADX INFO: compiled from: AndroidXmlParser.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\u000eR\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/prof18/rssparser/internal/AndroidXmlParser;", "Lcom/prof18/rssparser/internal/XmlParser;", "charset", "Ljava/nio/charset/Charset;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "(Ljava/nio/charset/Charset;Lkotlinx/coroutines/CoroutineDispatcher;)V", "generateParserInputFromString", "Lcom/prof18/rssparser/internal/ParserInput;", "rawRssFeed", "", "parseXML", "Lcom/prof18/rssparser/model/RssChannel;", "input", "(Lcom/prof18/rssparser/internal/ParserInput;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "rssparser_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class AndroidXmlParser implements XmlParser {
    private final Charset charset;
    private final CoroutineDispatcher dispatcher;

    public AndroidXmlParser(Charset charset, CoroutineDispatcher dispatcher) {
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        this.charset = charset;
        this.dispatcher = dispatcher;
    }

    public /* synthetic */ AndroidXmlParser(Charset charset, CoroutineDispatcher coroutineDispatcher, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : charset, coroutineDispatcher);
    }

    /* JADX INFO: renamed from: com.prof18.rssparser.internal.AndroidXmlParser$parseXML$2, reason: invalid class name */
    /* JADX INFO: compiled from: AndroidXmlParser.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/prof18/rssparser/model/RssChannel;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.prof18.rssparser.internal.AndroidXmlParser$parseXML$2", f = "AndroidXmlParser.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super RssChannel>, Object> {
        final /* synthetic */ ParserInput $input;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ AndroidXmlParser this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(ParserInput parserInput, AndroidXmlParser androidXmlParser, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$input = parserInput;
            this.this$0 = androidXmlParser;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$input, this.this$0, continuation);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super RssChannel> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            RssChannel rssChannelExtractAtomContent;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            try {
                try {
                    XmlPullParserFactory xmlPullParserFactoryNewInstance = XmlPullParserFactory.newInstance();
                    xmlPullParserFactoryNewInstance.setNamespaceAware(false);
                    XmlPullParser xmlPullParserNewPullParser = xmlPullParserFactoryNewInstance.newPullParser();
                    InputStream inputStream = this.$input.getInputStream();
                    Charset charset = this.this$0.charset;
                    RssChannel rssChannel = null;
                    xmlPullParserNewPullParser.setInput(inputStream, charset != null ? charset.toString() : null);
                    for (int eventType = xmlPullParserNewPullParser.getEventType(); eventType != 1; eventType = xmlPullParserNewPullParser.next()) {
                        if (eventType == 2) {
                            Intrinsics.checkNotNull(xmlPullParserNewPullParser);
                            if (XmlPullParser_Kt.contains(xmlPullParserNewPullParser, RssKeyword.Rss.INSTANCE)) {
                                rssChannelExtractAtomContent = RssParserKt.extractRSSContent(coroutineScope, xmlPullParserNewPullParser);
                            } else if (XmlPullParser_Kt.contains(xmlPullParserNewPullParser, AtomKeyword.Atom.INSTANCE)) {
                                rssChannelExtractAtomContent = AtomParserKt.extractAtomContent(coroutineScope, xmlPullParserNewPullParser);
                            }
                            rssChannel = rssChannelExtractAtomContent;
                        }
                    }
                    if (rssChannel == null) {
                        throw new IllegalArgumentException("The provided XML is not supported. Only RSS and Atom feeds are supported");
                    }
                    InputStreamUtilsKt.closeQuietly(this.$input.getInputStream());
                    return rssChannel;
                } catch (XmlPullParserException e) {
                    throw new RssParsingException("Something went wrong during the parsing of the feed. Please check if the XML is valid", e);
                }
            } catch (Throwable th) {
                InputStreamUtilsKt.closeQuietly(this.$input.getInputStream());
                throw th;
            }
            InputStreamUtilsKt.closeQuietly(this.$input.getInputStream());
            throw th;
        }
    }

    @Override // com.prof18.rssparser.internal.XmlParser
    public Object parseXML(ParserInput parserInput, Continuation<? super RssChannel> continuation) {
        return BuildersKt.withContext(this.dispatcher, new AnonymousClass2(parserInput, this, null), continuation);
    }

    @Override // com.prof18.rssparser.internal.XmlParser
    public ParserInput generateParserInputFromString(String rawRssFeed) {
        Intrinsics.checkNotNullParameter(rawRssFeed, "rawRssFeed");
        String string = StringsKt.trim((CharSequence) rawRssFeed).toString();
        Charset charset = this.charset;
        if (charset == null) {
            charset = Charsets.UTF_8;
        }
        byte[] bytes = string.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        return new ParserInput(new ByteArrayInputStream(bytes));
    }
}
