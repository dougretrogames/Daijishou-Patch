package com.prof18.rssparser.internal;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: XmlFetcher.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005H¦@¢\u0006\u0002\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/prof18/rssparser/internal/XmlFetcher;", "", "fetchXml", "Lcom/prof18/rssparser/internal/ParserInput;", "url", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fetchXmlAsString", "rssparser_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface XmlFetcher {
    Object fetchXml(String str, Continuation<? super ParserInput> continuation);

    Object fetchXmlAsString(String str, Continuation<? super String> continuation);
}
