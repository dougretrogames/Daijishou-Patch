package com.prof18.rssparser;

import com.prof18.rssparser.internal.ParserInput;
import com.prof18.rssparser.internal.XmlFetcher;
import com.prof18.rssparser.internal.XmlParser;
import com.prof18.rssparser.model.RssChannel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: compiled from: RssParser.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0010B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0086@¢\u0006\u0002\u0010\rJ\u0016\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\fH\u0086@¢\u0006\u0002\u0010\rR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/prof18/rssparser/RssParser;", "", "xmlFetcher", "Lcom/prof18/rssparser/internal/XmlFetcher;", "xmlParser", "Lcom/prof18/rssparser/internal/XmlParser;", "(Lcom/prof18/rssparser/internal/XmlFetcher;Lcom/prof18/rssparser/internal/XmlParser;)V", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getRssChannel", "Lcom/prof18/rssparser/model/RssChannel;", "url", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "parse", "rawRssFeed", "Builder", "rssparser_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class RssParser {
    private final CoroutineContext coroutineContext;
    private final XmlFetcher xmlFetcher;
    private final XmlParser xmlParser;

    /* JADX INFO: compiled from: RssParser.kt */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/prof18/rssparser/RssParser$Builder;", "", "build", "Lcom/prof18/rssparser/RssParser;", "rssparser_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface Builder {
        RssParser build();
    }

    public RssParser(XmlFetcher xmlFetcher, XmlParser xmlParser) {
        Intrinsics.checkNotNullParameter(xmlFetcher, "xmlFetcher");
        Intrinsics.checkNotNullParameter(xmlParser, "xmlParser");
        this.xmlFetcher = xmlFetcher;
        this.xmlParser = xmlParser;
        this.coroutineContext = SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getDefault());
    }

    /* JADX INFO: renamed from: com.prof18.rssparser.RssParser$getRssChannel$2, reason: invalid class name */
    /* JADX INFO: compiled from: RssParser.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/prof18/rssparser/model/RssChannel;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.prof18.rssparser.RssParser$getRssChannel$2", f = "RssParser.kt", i = {}, l = {34, 36, 38, 40}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super RssChannel>, Object> {
        final /* synthetic */ String $url;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(String str, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$url = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return RssParser.this.new AnonymousClass2(this.$url, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super RssChannel> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code restructure failed: missing block: B:28:0x008a, code lost:
        
            if (r8 == r0) goto L29;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) throws java.lang.Throwable {
            /*
                r7 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r7.label
                r2 = 4
                r3 = 3
                r4 = 2
                r5 = 1
                if (r1 == 0) goto L2d
                if (r1 == r5) goto L29
                if (r1 == r4) goto L25
                if (r1 == r3) goto L21
                if (r1 != r2) goto L19
                kotlin.ResultKt.throwOnFailure(r8)
                goto L8d
            L19:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L21:
                kotlin.ResultKt.throwOnFailure(r8)
                goto L6f
            L25:
                kotlin.ResultKt.throwOnFailure(r8)     // Catch: com.prof18.rssparser.exception.RssParsingException -> L5b
                goto L58
            L29:
                kotlin.ResultKt.throwOnFailure(r8)
                goto L44
            L2d:
                kotlin.ResultKt.throwOnFailure(r8)
                com.prof18.rssparser.RssParser r8 = com.prof18.rssparser.RssParser.this
                com.prof18.rssparser.internal.XmlFetcher r8 = com.prof18.rssparser.RssParser.access$getXmlFetcher$p(r8)
                java.lang.String r1 = r7.$url
                r6 = r7
                kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
                r7.label = r5
                java.lang.Object r8 = r8.fetchXml(r1, r6)
                if (r8 != r0) goto L44
                goto L8c
            L44:
                com.prof18.rssparser.internal.ParserInput r8 = (com.prof18.rssparser.internal.ParserInput) r8
                com.prof18.rssparser.RssParser r1 = com.prof18.rssparser.RssParser.this     // Catch: com.prof18.rssparser.exception.RssParsingException -> L5b
                com.prof18.rssparser.internal.XmlParser r1 = com.prof18.rssparser.RssParser.access$getXmlParser$p(r1)     // Catch: com.prof18.rssparser.exception.RssParsingException -> L5b
                r5 = r7
                kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5     // Catch: com.prof18.rssparser.exception.RssParsingException -> L5b
                r7.label = r4     // Catch: com.prof18.rssparser.exception.RssParsingException -> L5b
                java.lang.Object r8 = r1.parseXML(r8, r5)     // Catch: com.prof18.rssparser.exception.RssParsingException -> L5b
                if (r8 != r0) goto L58
                goto L8c
            L58:
                com.prof18.rssparser.model.RssChannel r8 = (com.prof18.rssparser.model.RssChannel) r8     // Catch: com.prof18.rssparser.exception.RssParsingException -> L5b
                return r8
            L5b:
                com.prof18.rssparser.RssParser r8 = com.prof18.rssparser.RssParser.this
                com.prof18.rssparser.internal.XmlFetcher r8 = com.prof18.rssparser.RssParser.access$getXmlFetcher$p(r8)
                java.lang.String r1 = r7.$url
                r4 = r7
                kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
                r7.label = r3
                java.lang.Object r8 = r8.fetchXmlAsString(r1, r4)
                if (r8 != r0) goto L6f
                goto L8c
            L6f:
                java.lang.String r8 = (java.lang.String) r8
                com.prof18.rssparser.RssParser r1 = com.prof18.rssparser.RssParser.this
                com.prof18.rssparser.internal.XmlParser r1 = com.prof18.rssparser.RssParser.access$getXmlParser$p(r1)
                com.prof18.rssparser.internal.ParserInput r8 = r1.generateParserInputFromString(r8)
                com.prof18.rssparser.RssParser r1 = com.prof18.rssparser.RssParser.this
                com.prof18.rssparser.internal.XmlParser r1 = com.prof18.rssparser.RssParser.access$getXmlParser$p(r1)
                r3 = r7
                kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
                r7.label = r2
                java.lang.Object r8 = r1.parseXML(r8, r3)
                if (r8 != r0) goto L8d
            L8c:
                return r0
            L8d:
                com.prof18.rssparser.model.RssChannel r8 = (com.prof18.rssparser.model.RssChannel) r8
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.prof18.rssparser.RssParser.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public final Object getRssChannel(String str, Continuation<? super RssChannel> continuation) {
        return BuildersKt.withContext(this.coroutineContext, new AnonymousClass2(str, null), continuation);
    }

    /* JADX INFO: renamed from: com.prof18.rssparser.RssParser$parse$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: RssParser.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/prof18/rssparser/model/RssChannel;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.prof18.rssparser.RssParser$parse$2", f = "RssParser.kt", i = {}, l = {49}, m = "invokeSuspend", n = {}, s = {})
    static final class C02952 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super RssChannel>, Object> {
        final /* synthetic */ String $rawRssFeed;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C02952(String str, Continuation<? super C02952> continuation) {
            super(2, continuation);
            this.$rawRssFeed = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return RssParser.this.new C02952(this.$rawRssFeed, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super RssChannel> continuation) {
            return ((C02952) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            ParserInput parserInputGenerateParserInputFromString = RssParser.this.xmlParser.generateParserInputFromString(this.$rawRssFeed);
            this.label = 1;
            Object xml = RssParser.this.xmlParser.parseXML(parserInputGenerateParserInputFromString, this);
            return xml == coroutine_suspended ? coroutine_suspended : xml;
        }
    }

    public final Object parse(String str, Continuation<? super RssChannel> continuation) {
        return BuildersKt.withContext(this.coroutineContext, new C02952(str, null), continuation);
    }
}
