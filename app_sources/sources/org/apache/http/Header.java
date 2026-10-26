package org.apache.http;

/* INFO: loaded from: classes5.dex */
public interface Header extends NameValuePair {
    HeaderElement[] getElements() throws ParseException;
}
