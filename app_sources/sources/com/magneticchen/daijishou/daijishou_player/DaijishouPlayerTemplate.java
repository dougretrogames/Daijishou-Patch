package com.magneticchen.daijishou.daijishou_player;

import android.content.Context;
import android.net.Uri;
import android.support.v4.media.session.PlaybackStateCompat;
import androidx.documentfile.provider.DocumentFile;
import com.magneticchen.daijishou.utils.BoundedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* INFO: compiled from: DaijishouPlayerTemplate.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J \u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\t0\b2\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/magneticchen/daijishou/daijishou_player/DaijishouPlayerTemplate;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "getTemplateTagsAndValuesFromUri", "", "Lkotlin/Pair;", "", "uri", "Landroid/net/Uri;", "isUriDaijishouPlayerTemplate", "", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DaijishouPlayerTemplate {
    public static final String templateTagPrefix = "tags";
    private final Context context;

    /* INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Regex templateTagAndValueRegex = new Regex("^\\s*\\[([^]]+)]\\s+(.*)$");
    private static final Regex normalizingReplaceRegex = new Regex("[^0-9a-zA-Z\\s]+");
    private static final List<String> daijishouPlayerTemplateFirstLineList = CollectionsKt.listOf(new String[]{"# DPT", "# Daijishou Player Template"});

    /* INFO: compiled from: DaijishouPlayerTemplate.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/magneticchen/daijishou/daijishou_player/DaijishouPlayerTemplate$Companion;", "", "()V", "daijishouPlayerTemplateFirstLineList", "", "", "getDaijishouPlayerTemplateFirstLineList", "()Ljava/util/List;", "normalizingReplaceRegex", "Lkotlin/text/Regex;", "getNormalizingReplaceRegex", "()Lkotlin/text/Regex;", "templateTagAndValueRegex", "getTemplateTagAndValueRegex", "templateTagPrefix", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Regex getTemplateTagAndValueRegex() {
            return DaijishouPlayerTemplate.templateTagAndValueRegex;
        }

        public final Regex getNormalizingReplaceRegex() {
            return DaijishouPlayerTemplate.normalizingReplaceRegex;
        }

        public final List<String> getDaijishouPlayerTemplateFirstLineList() {
            return DaijishouPlayerTemplate.daijishouPlayerTemplateFirstLineList;
        }
    }

    public DaijishouPlayerTemplate(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
    }

    public final Context getContext() {
        return this.context;
    }

    public final boolean isUriDaijishouPlayerTemplate(Context context, Uri uri) {
        DocumentFile documentFileFromSingleUri;
        InputStream inputStreamOpenInputStream;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, "uri");
        try {
            if (Intrinsics.areEqual(uri, Uri.EMPTY) || (documentFileFromSingleUri = DocumentFile.fromSingleUri(context, uri)) == null || !documentFileFromSingleUri.exists() || documentFileFromSingleUri.length() == 0 || (inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri)) == null) {
                return false;
            }
            BoundedInputStream boundedInputStream = new BoundedInputStream(inputStreamOpenInputStream, PlaybackStateCompat.ACTION_SET_REPEAT_MODE);
            String line = new BufferedReader(new InputStreamReader(boundedInputStream)).readLine();
            Intrinsics.checkNotNullExpressionValue(line, "readLine(...)");
            String str = (String) CollectionsKt.getOrNull(StringsKt.split$default((CharSequence) line, new String[]{"#"}, false, 2, 2, (Object) null), 1);
            if (str == null) {
                boundedInputStream.close();
                return false;
            }
            String lowerCase = normalizingReplaceRegex.replace(str, "").toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            Iterator it = daijishouPlayerTemplateFirstLineList.iterator();
            while (it.hasNext()) {
                String lowerCase2 = normalizingReplaceRegex.replace((String) it.next(), "").toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                if (Intrinsics.areEqual(lowerCase, lowerCase2)) {
                    boundedInputStream.close();
                    return true;
                }
            }
            boundedInputStream.close();
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public final List<Pair<String, String>> getTemplateTagsAndValuesFromUri(Uri uri) {
        List<String> groupValues;
        Intrinsics.checkNotNullParameter(uri, "uri");
        try {
            if (Intrinsics.areEqual(uri, Uri.EMPTY)) {
                return CollectionsKt.emptyList();
            }
            DocumentFile documentFileFromSingleUri = DocumentFile.fromSingleUri(this.context, uri);
            if (documentFileFromSingleUri != null && documentFileFromSingleUri.exists() && documentFileFromSingleUri.length() != 0) {
                InputStream inputStreamOpenInputStream = this.context.getContentResolver().openInputStream(uri);
                if (inputStreamOpenInputStream == null) {
                    return CollectionsKt.emptyList();
                }
                ArrayList arrayList = new ArrayList();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStreamOpenInputStream));
                while (true) {
                    String line = bufferedReader.readLine();
                    if (line != null) {
                        Regex regex = templateTagAndValueRegex;
                        Intrinsics.checkNotNull(line);
                        MatchResult matchResultFind$default = Regex.find$default(regex, line, 0, 2, null);
                        if (matchResultFind$default != null && (groupValues = matchResultFind$default.getGroupValues()) != null && groupValues.size() >= 3) {
                            arrayList.add(new Pair("{tags." + ((Object) groupValues.get(1)) + "}", groupValues.get(2)));
                        }
                    } else {
                        inputStreamOpenInputStream.close();
                        return arrayList;
                    }
                }
            }
            return CollectionsKt.emptyList();
        } catch (Exception e) {
            e.printStackTrace();
            return CollectionsKt.emptyList();
        }
    }
}
