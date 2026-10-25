package org.apache.http.cookie;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.http.HttpRequest;
import org.apache.http.config.Lookup;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.Args;

/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public final class CookieSpecRegistry implements Lookup<CookieSpecProvider> {
    private final ConcurrentHashMap<String, CookieSpecFactory> registeredSpecs = new ConcurrentHashMap<>();

    public void register(String str, CookieSpecFactory cookieSpecFactory) {
        Args.notNull(str, "Name");
        Args.notNull(cookieSpecFactory, "Cookie spec factory");
        this.registeredSpecs.put(str.toLowerCase(Locale.ENGLISH), cookieSpecFactory);
    }

    public void unregister(String str) {
        Args.notNull(str, "Id");
        this.registeredSpecs.remove(str.toLowerCase(Locale.ENGLISH));
    }

    public CookieSpec getCookieSpec(String str, HttpParams httpParams) throws IllegalStateException {
        Args.notNull(str, "Name");
        CookieSpecFactory cookieSpecFactory = this.registeredSpecs.get(str.toLowerCase(Locale.ENGLISH));
        if (cookieSpecFactory != null) {
            return cookieSpecFactory.newInstance(httpParams);
        }
        throw new IllegalStateException("Unsupported cookie spec: " + str);
    }

    public CookieSpec getCookieSpec(String str) throws IllegalStateException {
        return getCookieSpec(str, null);
    }

    public List<String> getSpecNames() {
        return new ArrayList(this.registeredSpecs.keySet());
    }

    public void setItems(Map<String, CookieSpecFactory> map) {
        if (map == null) {
            return;
        }
        this.registeredSpecs.clear();
        this.registeredSpecs.putAll(map);
    }

    /* JADX INFO: renamed from: org.apache.http.cookie.CookieSpecRegistry$1, reason: invalid class name */
    class AnonymousClass1 implements CookieSpecProvider {
        final /* synthetic */ String val$name;

        AnonymousClass1(String str) {
            this.val$name = str;
        }

        @Override // org.apache.http.cookie.CookieSpecProvider
        public CookieSpec create(HttpContext httpContext) {
            return CookieSpecRegistry.this.getCookieSpec(this.val$name, ((HttpRequest) httpContext.getAttribute("http.request")).getParams());
        }
    }

    @Override // org.apache.http.config.Lookup
    public CookieSpecProvider lookup(String str) {
        return new AnonymousClass1(str);
    }
}
