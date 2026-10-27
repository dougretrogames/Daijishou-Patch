package com.magneticchen.daijishou.player;

import android.content.Context;
import android.net.Uri;
import androidx.documentfile.provider.DocumentFile;
import com.magneticchen.daijishou.utils.BoundedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.io.ConstantsKt;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.Charsets;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: compiled from: DaijishouPlayerTemplate.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J \u0010\u0011\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u00120\b2\u0006\u0010\u0013\u001a\u00020\u0014J\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0014R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \f*\u0004\u0018\u00010\u000b0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/magneticchen/daijishou/player/DaijishouPlayerTemplate;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "daijishouPlayerTemplateFirstLineList", "", "", "logger", "Lorg/slf4j/Logger;", "kotlin.jvm.PlatformType", "normalizingReplace", "Lkotlin/text/Regex;", "templateTagAndValue", "templateTagPrefix", "getTemplateTagsAndValuesFromUri", "Lkotlin/Pair;", "uri", "Landroid/net/Uri;", "isUriDaijishouPlayerTemplate", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DaijishouPlayerTemplate {
    private final Context context;
    private final List<String> daijishouPlayerTemplateFirstLineList;
    private final Logger logger;
    private final Regex normalizingReplace;
    private final Regex templateTagAndValue;
    private final String templateTagPrefix;

    public DaijishouPlayerTemplate(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        this.templateTagAndValue = new Regex("^\\s*\\[([^]]+)]\\s+(.*)$");
        this.normalizingReplace = new Regex("[^0-9a-zA-Z\\s]+");
        this.daijishouPlayerTemplateFirstLineList = CollectionsKt.listOf((Object[]) new String[]{"# DPT", "# Daijishou Player Template"});
        this.templateTagPrefix = "tags";
        this.logger = LoggerFactory.getLogger(getClass());
    }

    public final Context getContext() {
        return this.context;
    }

    public final boolean isUriDaijishouPlayerTemplate(Context context, Uri uri) {
        DocumentFile documentFileFromSingleUri;
        InputStream inputStreamOpenInputStream;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, "uri");
        if (Intrinsics.areEqual(uri, Uri.EMPTY) || (documentFileFromSingleUri = DocumentFile.fromSingleUri(context, uri)) == null || !documentFileFromSingleUri.exists() || documentFileFromSingleUri.length() == 0 || (inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri)) == null) {
            return false;
        }
        BoundedInputStream boundedInputStream = new BoundedInputStream(inputStreamOpenInputStream, 262144L);
        String line = new BufferedReader(new InputStreamReader(boundedInputStream)).readLine();
        Intrinsics.checkNotNullExpressionValue(line, "readLine(...)");
        String str = (String) CollectionsKt.getOrNull(StringsKt.split$default((CharSequence) line, new String[]{"#"}, false, 2, 2, (Object) null), 1);
        if (str == null) {
            boundedInputStream.close();
            return false;
        }
        String lowerCase = this.normalizingReplace.replace(str, "").toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        Iterator<String> it = this.daijishouPlayerTemplateFirstLineList.iterator();
        while (it.hasNext()) {
            String lowerCase2 = this.normalizingReplace.replace(it.next(), "").toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
            if (Intrinsics.areEqual(lowerCase, lowerCase2)) {
                boundedInputStream.close();
                return true;
            }
        }
        boundedInputStream.close();
        return false;
    }

    public final List<Pair<String, String>> getTemplateTagsAndValuesFromUri(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        if (Intrinsics.areEqual(uri, Uri.EMPTY)) {
            return CollectionsKt.emptyList();
        }
        DocumentFile documentFileFromSingleUri = DocumentFile.fromSingleUri(this.context, uri);
        if (documentFileFromSingleUri == null || !documentFileFromSingleUri.exists() || documentFileFromSingleUri.length() == 0) {
            return CollectionsKt.emptyList();
        }
        try {
            InputStream inputStreamOpenInputStream = this.context.getContentResolver().openInputStream(uri);
            if (inputStreamOpenInputStream != null) {
                Reader inputStreamReader = new InputStreamReader(inputStreamOpenInputStream, Charsets.UTF_8);
                BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, ConstantsKt.DEFAULT_BUFFER_SIZE);
                BufferedReader bufferedReader2 = bufferedReader instanceof BufferedReader ? bufferedReader : new BufferedReader(bufferedReader, ConstantsKt.DEFAULT_BUFFER_SIZE);
                try {
                    List<Pair<String, String>> list = SequencesKt.toList(SequencesKt.mapNotNull(TextStreamsKt.lineSequence(bufferedReader2), new Function1<String, Pair<? extends String, ? extends String>>() { // from class: com.magneticchen.daijishou.player.DaijishouPlayerTemplate$getTemplateTagsAndValuesFromUri$1$1
                        

                        @Override // kotlin.jvm.functions.Function1
                        public final Pair<String, String> invoke(String line) {
                            Intrinsics.checkNotNullParameter(line, "line");
                            MatchResult matchResultFind$default = Regex.find$default(this.this$0.templateTagAndValue, line, 0, 2, null);
                            if (matchResultFind$default == null) {
                                return null;
                            }
                            MatchResult.Destructured destructured = matchResultFind$default.getDestructured();
                            return TuplesKt.to("{" + this.this$0.templateTagPrefix + "." + destructured.getMatch().getGroupValues().get(1) + "}", destructured.getMatch().getGroupValues().get(2));
                        }
                    }));
                    CloseableKt.closeFinally(bufferedReader2, null);
                    if (list != null) {
                        return list;
                    }
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(bufferedReader2, th);
                        throw th2;
                    }
                }
            }
            return CollectionsKt.emptyList();
        } catch (Exception e) {
            this.logger.warn("There was an issue executing getTemplateTagsAndValuesFromUri", e);
            return CollectionsKt.emptyList();
        }
    }
}
