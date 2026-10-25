package com.prof18.rssparser.internal;

import java.io.InputStream;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuationImpl;
import okhttp3.Call;
import okhttp3.Request;

/* JADX INFO: compiled from: JvmXmlFetcher.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\u000bJ\u0016\u0010\f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\u000bJ\u0012\u0010\r\u001a\u00020\u000e*\u00020\u000fH\u0082@¢\u0006\u0002\u0010\u0010J\u0012\u0010\u0011\u001a\u00020\b*\u00020\u000fH\u0082@¢\u0006\u0002\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/prof18/rssparser/internal/JvmXmlFetcher;", "Lcom/prof18/rssparser/internal/XmlFetcher;", "callFactory", "Lokhttp3/Call$Factory;", "(Lokhttp3/Call$Factory;)V", "createRequest", "Lokhttp3/Request;", "url", "", "fetchXml", "Lcom/prof18/rssparser/internal/ParserInput;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchXmlAsString", "awaitForInputStream", "Ljava/io/InputStream;", "Lokhttp3/Call;", "(Lokhttp3/Call;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitForString", "rssparser_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class JvmXmlFetcher implements XmlFetcher {
    private final Call.Factory callFactory;

    /* JADX INFO: renamed from: com.prof18.rssparser.internal.JvmXmlFetcher$fetchXml$1, reason: invalid class name */
    /* JADX INFO: compiled from: JvmXmlFetcher.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.prof18.rssparser.internal.JvmXmlFetcher", f = "JvmXmlFetcher.kt", i = {}, l = {21}, m = "fetchXml", n = {}, s = {})
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return JvmXmlFetcher.this.fetchXml(null, this);
        }
    }

    public JvmXmlFetcher(Call.Factory callFactory) {
        Intrinsics.checkNotNullParameter(callFactory, "callFactory");
        this.callFactory = callFactory;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.prof18.rssparser.internal.XmlFetcher
    public Object fetchXml(String str, Continuation<? super ParserInput> continuation) throws Throwable {
        AnonymousClass1 anonymousClass1;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object objAwaitForInputStream = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objAwaitForInputStream);
            Call callNewCall = this.callFactory.newCall(createRequest(str));
            anonymousClass1.label = 1;
            objAwaitForInputStream = awaitForInputStream(callNewCall, anonymousClass1);
            if (objAwaitForInputStream == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(objAwaitForInputStream);
        }
        return new ParserInput((InputStream) objAwaitForInputStream);
    }

    @Override // com.prof18.rssparser.internal.XmlFetcher
    public Object fetchXmlAsString(String str, Continuation<? super String> continuation) {
        return awaitForString(this.callFactory.newCall(createRequest(str)), continuation);
    }

    private final Request createRequest(String url) {
        return new Request.Builder().url(url).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object awaitForInputStream(Call call, Continuation<? super InputStream> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        cancellableContinuationImpl2.invokeOnCancellation(new JvmXmlFetcher$awaitForInputStream$2$1(call));
        call.enqueue(new JvmXmlFetcher$awaitForInputStream$2$2(cancellableContinuationImpl2));
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object awaitForString(Call call, Continuation<? super String> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        cancellableContinuationImpl2.invokeOnCancellation(new JvmXmlFetcher$awaitForString$2$1(call));
        call.enqueue(new JvmXmlFetcher$awaitForString$2$2(cancellableContinuationImpl2));
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
