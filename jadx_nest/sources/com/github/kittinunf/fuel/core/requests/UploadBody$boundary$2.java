package com.github.kittinunf.fuel.core.requests;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* INFO: compiled from: UploadBody.kt */
/* INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 0})
final class UploadBody$boundary$2 extends Lambda implements Function0<String> {
    final /* synthetic */ UploadBody this$0;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    UploadBody$boundary$2(UploadBody uploadBody) {
        super(0);
        this.this$0 = uploadBody;
    }

    @Override // kotlin.jvm.functions.Function0
    public final String invoke() throws BoundaryMissing {
        List<String> groupValues;
        String str;
        String str2 = (String) CollectionsKt.lastOrNull(this.this$0.getRequest().get("Content-Type"));
        if (str2 != null) {
            String strTrim = null;
            MatchResult matchResultFind$default = Regex.find$default(new Regex("boundary=([^\\s]+)"), str2, 0, 2, null);
            if (matchResultFind$default != null && (groupValues = matchResultFind$default.getGroupValues()) != null && (str = (String) CollectionsKt.getOrNull(groupValues, 1)) != null) {
                strTrim = StringsKt.trim(str, '\"');
            }
            if (strTrim != null) {
                return strTrim;
            }
        }
        throw new BoundaryMissing(this.this$0.getRequest());
    }
}
