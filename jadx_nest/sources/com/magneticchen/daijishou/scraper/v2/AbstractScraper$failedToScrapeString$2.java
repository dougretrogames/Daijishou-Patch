package com.magneticchen.daijishou.scraper.v2;

import com.magneticchen.daijishou.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: AbstractScraper.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class AbstractScraper$failedToScrapeString$2 extends Lambda<String> implements Function0<String> {
    final /* synthetic */ AbstractScraper this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AbstractScraper$failedToScrapeString$2(AbstractScraper abstractScraper) {
        super(0);
        this.this$0 = abstractScraper;
    }

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() {
        return this.this$0.getApplication().getString(R.string.scraper_failed_to_scrape_message);
    }
}
