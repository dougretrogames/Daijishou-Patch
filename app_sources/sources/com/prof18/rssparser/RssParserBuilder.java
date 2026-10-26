package com.prof18.rssparser;

import com.prof18.rssparser.internal.AndroidXmlParser;
import com.prof18.rssparser.internal.JvmXmlFetcher;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Dispatchers;
import okhttp3.Call;
import okhttp3.OkHttpClient;

/* INFO: compiled from: RssParserBuilder.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/prof18/rssparser/RssParserBuilder;", "Lcom/prof18/rssparser/RssParser$Builder;", "callFactory", "Lokhttp3/Call$Factory;", "charset", "Ljava/nio/charset/Charset;", "(Lokhttp3/Call$Factory;Ljava/nio/charset/Charset;)V", "build", "Lcom/prof18/rssparser/RssParser;", "rssparser_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class RssParserBuilder implements RssParser.Builder {
    private final Call.Factory callFactory;
    private final Charset charset;

    public RssParserBuilder() {
        this(null, null, 3, null);
    }

    public RssParserBuilder(Call.Factory callFactory, Charset charset) {
        Intrinsics.checkNotNullParameter(callFactory, "callFactory");
        this.callFactory = callFactory;
        this.charset = charset;
    }

    public /* synthetic */ RssParserBuilder(OkHttpClient okHttpClient, Charset charset, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new OkHttpClient() : okHttpClient, (i & 2) != 0 ? null : charset);
    }

    @Override // com.prof18.rssparser.RssParser.Builder
    public RssParser build() {
        return new RssParser(new JvmXmlFetcher(this.callFactory), new AndroidXmlParser(this.charset, Dispatchers.getIO()));
    }
}
