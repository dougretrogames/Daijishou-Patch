package androidx.core.net;

/* INFO: loaded from: classes.dex */
public class ParseException extends RuntimeException {
    public final String response;

    ParseException(String str) {
        super(str);
        this.response = str;
    }
}
