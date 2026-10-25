package com.prof18.rssparser.internal;

import com.prof18.rssparser.model.RssChannel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: XmlParser.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H¦@¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lcom/prof18/rssparser/internal/XmlParser;", "", "generateParserInputFromString", "Lcom/prof18/rssparser/internal/ParserInput;", "rawRssFeed", "", "parseXML", "Lcom/prof18/rssparser/model/RssChannel;", "input", "(Lcom/prof18/rssparser/internal/ParserInput;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "rssparser_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface XmlParser {
    ParserInput generateParserInputFromString(String rawRssFeed);

    Object parseXML(ParserInput parserInput, Continuation<? super RssChannel> continuation);
}
