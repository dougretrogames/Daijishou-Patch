package okhttp3;

import java.util.Comparator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* INFO: compiled from: CipherSuite.kt */
/* INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¨\u0006\b"}, d2 = {"okhttp3/CipherSuite$Companion$ORDER_BY_NAME$1", "Ljava/util/Comparator;", "", "Lkotlin/Comparator;", "compare", "", "a", "b", "okhttp"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CipherSuite$Companion$ORDER_BY_NAME$1 implements Comparator<String> {
    CipherSuite$Companion$ORDER_BY_NAME$1() {
    }

    @Override // java.util.Comparator
    public int compare(String a, String b) {
        Intrinsics.checkNotNullParameter(a, "a");
        Intrinsics.checkNotNullParameter(b, "b");
        int iMin = Math.min(a.length(), b.length());
        for (int i = 4; i < iMin; i++) {
            char cCharAt = a.charAt(i);
            char cCharAt2 = b.charAt(i);
            if (cCharAt != cCharAt2) {
                return Intrinsics.compare((int) cCharAt, (int) cCharAt2) < 0 ? -1 : 1;
            }
        }
        int length = a.length();
        int length2 = b.length();
        if (length != length2) {
            return length < length2 ? -1 : 1;
        }
        return 0;
    }
}
