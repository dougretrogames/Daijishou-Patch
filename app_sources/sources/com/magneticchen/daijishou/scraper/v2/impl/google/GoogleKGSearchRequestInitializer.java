package com.magneticchen.daijishou.scraper.v2.impl.google;

import com.google.api.client.http.HttpHeaders;
import com.google.api.services.kgsearch.v1.KgsearchRequest;
import com.google.api.services.kgsearch.v1.KgsearchRequestInitializer;
import com.magneticchen.daijishou.BuildConfig;
import com.magneticchen.daijishou.utils.UtilsKt;
import java.io.IOException;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* INFO: compiled from: GoogleKGSearchRequestInitializer.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u00020\u00042\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006H\u0014¨\u0006\u0007"}, d2 = {"Lcom/magneticchen/daijishou/scraper/v2/impl/google/GoogleKGSearchRequestInitializer;", "Lcom/google/api/services/kgsearch/v1/KgsearchRequestInitializer;", "()V", "initializeKgsearchRequest", "", "request", "Lcom/google/api/services/kgsearch/v1/KgsearchRequest;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class GoogleKGSearchRequestInitializer extends KgsearchRequestInitializer {
    public GoogleKGSearchRequestInitializer() {
        super(BuildConfig.GOOGLE_CLOUD_API_KEY);
    }

    @Override // com.google.api.services.kgsearch.v1.KgsearchRequestInitializer
    public void initializeKgsearchRequest(KgsearchRequest<?> request) throws IOException {
        Intrinsics.checkNotNullParameter(request, "request");
        super.initializeKgsearchRequest(request);
        request.getRequestHeaders().set("X-Android-Package", (Object) BuildConfig.APPLICATION_ID);
        request.getRequestHeaders().set("X-Android-Cert", (Object) BuildConfig.GOOGLE_CLOUD_API_KEY_SHA1);
        HttpHeaders requestHeaders = request.getRequestHeaders();
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
        requestHeaders.set("Accept-Language", (Object) UtilsKt.getLanguageAndCountry(locale));
    }
}
