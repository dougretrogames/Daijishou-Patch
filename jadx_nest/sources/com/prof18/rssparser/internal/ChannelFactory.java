package com.prof18.rssparser.internal;

import com.googlecode.javaewah32.RunningLengthWord32;
import com.prof18.rssparser.model.ItunesChannelData;
import com.prof18.rssparser.model.ItunesItemData;
import com.prof18.rssparser.model.ItunesOwner;
import com.prof18.rssparser.model.RssChannel;
import com.prof18.rssparser.model.RssImage;
import com.prof18.rssparser.model.RssItem;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.apache.commons.collections4.CollectionUtils;

/* INFO: compiled from: ChannelFactory.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0007\b\u0000\u0018\u0000 /2\u00020\u0001:\u0001/B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010#\u001a\u00020$J\u0006\u0010%\u001a\u00020&J\u0006\u0010'\u001a\u00020&J\u0018\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00120)2\b\u0010*\u001a\u0004\u0018\u00010\u0012H\u0002J\u0010\u0010+\u001a\u00020&2\b\u0010*\u001a\u0004\u0018\u00010\u0012J\u0010\u0010,\u001a\u00020&2\b\u0010*\u001a\u0004\u0018\u00010\u0012J\u0010\u0010-\u001a\u00020&2\b\u0010.\u001a\u0004\u0018\u00010\u0012R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\u001a¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u00060"}, d2 = {"Lcom/prof18/rssparser/internal/ChannelFactory;", "", "()V", "articleBuilder", "Lcom/prof18/rssparser/model/RssItem$Builder;", "getArticleBuilder", "()Lcom/prof18/rssparser/model/RssItem$Builder;", "setArticleBuilder", "(Lcom/prof18/rssparser/model/RssItem$Builder;)V", "channelBuilder", "Lcom/prof18/rssparser/model/RssChannel$Builder;", "getChannelBuilder", "()Lcom/prof18/rssparser/model/RssChannel$Builder;", "channelImageBuilder", "Lcom/prof18/rssparser/model/RssImage$Builder;", "getChannelImageBuilder", "()Lcom/prof18/rssparser/model/RssImage$Builder;", "imageUrlFromContent", "", "itunesArticleBuilder", "Lcom/prof18/rssparser/model/ItunesItemData$Builder;", "getItunesArticleBuilder", "()Lcom/prof18/rssparser/model/ItunesItemData$Builder;", "setItunesArticleBuilder", "(Lcom/prof18/rssparser/model/ItunesItemData$Builder;)V", "itunesChannelBuilder", "Lcom/prof18/rssparser/model/ItunesChannelData$Builder;", "getItunesChannelBuilder", "()Lcom/prof18/rssparser/model/ItunesChannelData$Builder;", "itunesOwnerBuilder", "Lcom/prof18/rssparser/model/ItunesOwner$Builder;", "getItunesOwnerBuilder", "()Lcom/prof18/rssparser/model/ItunesOwner$Builder;", "setItunesOwnerBuilder", "(Lcom/prof18/rssparser/model/ItunesOwner$Builder;)V", "build", "Lcom/prof18/rssparser/model/RssChannel;", "buildArticle", "", "buildItunesOwner", "extractItunesKeywords", "", "keywords", "setArticleItunesKeywords", "setChannelItunesKeywords", "setImageFromContent", "content", "Companion", "rssparser_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ChannelFactory {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final String EMOJI_WEBSITE = "https://s.w.org/images/core/emoji";
    private String imageUrlFromContent;
    private final RssChannel.Builder channelBuilder = new RssChannel.Builder(null, null, null, null, null, null, null, null, 255, null);
    private final RssImage.Builder channelImageBuilder = new RssImage.Builder(null, null, null, null, 15, null);
    private RssItem.Builder articleBuilder = new RssItem.Builder(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, RunningLengthWord32.LARGEST_LITERAL_COUNT, null);
    private final ItunesChannelData.Builder itunesChannelBuilder = new ItunesChannelData.Builder(null, null, null, null, null, null, null, null, null, null, null, 2047, null);
    private ItunesItemData.Builder itunesArticleBuilder = new ItunesItemData.Builder(null, null, null, null, null, null, null, null, null, null, 1023, null);
    private ItunesOwner.Builder itunesOwnerBuilder = new ItunesOwner.Builder(null, null, 3, null);

    public final RssChannel.Builder getChannelBuilder() {
        return this.channelBuilder;
    }

    public final RssImage.Builder getChannelImageBuilder() {
        return this.channelImageBuilder;
    }

    public final RssItem.Builder getArticleBuilder() {
        return this.articleBuilder;
    }

    public final void setArticleBuilder(RssItem.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "<set-?>");
        this.articleBuilder = builder;
    }

    public final ItunesChannelData.Builder getItunesChannelBuilder() {
        return this.itunesChannelBuilder;
    }

    public final ItunesItemData.Builder getItunesArticleBuilder() {
        return this.itunesArticleBuilder;
    }

    public final void setItunesArticleBuilder(ItunesItemData.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "<set-?>");
        this.itunesArticleBuilder = builder;
    }

    public final ItunesOwner.Builder getItunesOwnerBuilder() {
        return this.itunesOwnerBuilder;
    }

    public final void setItunesOwnerBuilder(ItunesOwner.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "<set-?>");
        this.itunesOwnerBuilder = builder;
    }

    public final void buildArticle() {
        this.articleBuilder.image(this.imageUrlFromContent);
        this.articleBuilder.itunesArticleData(this.itunesArticleBuilder.build());
        this.channelBuilder.addItem(this.articleBuilder.build());
        this.imageUrlFromContent = null;
        this.articleBuilder = new RssItem.Builder(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, RunningLengthWord32.LARGEST_LITERAL_COUNT, null);
        this.itunesArticleBuilder = new ItunesItemData.Builder(null, null, null, null, null, null, null, null, null, null, 1023, null);
    }

    public final void buildItunesOwner() {
        this.itunesChannelBuilder.owner(this.itunesOwnerBuilder.build());
        this.itunesOwnerBuilder = new ItunesOwner.Builder(null, null, 3, null);
    }

    public final void setImageFromContent(String content) {
        MatchResult matchResultFind$default;
        try {
            Regex regex = new Regex("https?:\\/\\/[^\\s<>\"]+\\.(?:jpg|jpeg|png|gif|bmp|webp)");
            if (content == null || (matchResultFind$default = Regex.find$default(regex, content, 0, 2, null)) == null) {
                return;
            }
            String string = StringsKt.trim((CharSequence) matchResultFind$default.getValue()).toString();
            if (StringsKt.contains$default((CharSequence) string, (CharSequence) EMOJI_WEBSITE, false, 2, (Object) null)) {
                return;
            }
            this.imageUrlFromContent = string;
        } catch (Throwable unused) {
        }
    }

    public final void setChannelItunesKeywords(String keywords) {
        List<String> listExtractItunesKeywords = extractItunesKeywords(keywords);
        if (listExtractItunesKeywords.isEmpty()) {
            return;
        }
        this.itunesChannelBuilder.keywords(listExtractItunesKeywords);
    }

    public final void setArticleItunesKeywords(String keywords) {
        List<String> listExtractItunesKeywords = extractItunesKeywords(keywords);
        if (listExtractItunesKeywords.isEmpty()) {
            return;
        }
        this.itunesArticleBuilder.keywords(listExtractItunesKeywords);
    }

    private final List<String> extractItunesKeywords(String keywords) {
        List<String> listSplit$default;
        if (keywords == null || (listSplit$default = StringsKt.split$default((CharSequence) keywords, new String[]{CollectionUtils.COMMA}, false, 0, 6, (Object) null)) == null) {
            return CollectionsKt.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (String str : listSplit$default) {
            if (str.length() == 0) {
                str = null;
            }
            String str2 = str;
            if (str2 != null) {
                arrayList.add(str2);
            }
        }
        return arrayList;
    }

    public final RssChannel build() {
        RssImage rssImageBuild = this.channelImageBuilder.build();
        if (rssImageBuild.isNotEmpty()) {
            this.channelBuilder.image(rssImageBuild);
        }
        this.channelBuilder.itunesChannelData(this.itunesChannelBuilder.build());
        return this.channelBuilder.build();
    }

    /* INFO: compiled from: ChannelFactory.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/prof18/rssparser/internal/ChannelFactory$Companion;", "", "()V", "EMOJI_WEBSITE", "", "rssparser_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
