package com.google.auth.oauth2;

import com.google.api.client.util.Clock;
import com.google.auth.Credentials;
import com.google.auth.RequestMetadataCallback;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;
import com.google.common.util.concurrent.AbstractFuture;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableFutureTask;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.net.URI;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.ServiceLoader;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes3.dex */
public class OAuth2Credentials extends Credentials {
    static final Duration DEFAULT_EXPIRATION_MARGIN = Duration.ofMinutes(3);
    static final Duration DEFAULT_REFRESH_MARGIN = Duration.ofMinutes(3).plusSeconds(45);
    private static final ImmutableMap<String, List<String>> EMPTY_EXTRA_HEADERS = ImmutableMap.of();
    private static final long serialVersionUID = 4556936364828217687L;
    private transient List<CredentialsChangedListener> changeListeners;
    transient Clock clock;
    private final Duration expirationMargin;
    final Object lock;
    private final Duration refreshMargin;
    transient RefreshTask refreshTask;
    private volatile OAuthValue value;

    enum CacheState {
        FRESH,
        STALE,
        EXPIRED
    }

    public interface CredentialsChangedListener {
        void onChanged(OAuth2Credentials oAuth2Credentials) throws IOException;
    }

    @Override // com.google.auth.Credentials
    public boolean hasRequestMetadata() {
        return true;
    }

    @Override // com.google.auth.Credentials
    public boolean hasRequestMetadataOnly() {
        return true;
    }

    public static OAuth2Credentials create(AccessToken accessToken) {
        return newBuilder().setAccessToken(accessToken).build();
    }

    protected OAuth2Credentials() {
        this(null);
    }

    protected OAuth2Credentials(AccessToken accessToken) {
        this(accessToken, DEFAULT_REFRESH_MARGIN, DEFAULT_EXPIRATION_MARGIN);
    }

    protected OAuth2Credentials(AccessToken accessToken, Duration duration, Duration duration2) {
        this.lock = new byte[0];
        this.value = null;
        this.clock = Clock.SYSTEM;
        if (accessToken != null) {
            this.value = OAuthValue.create(accessToken, EMPTY_EXTRA_HEADERS);
        }
        this.refreshMargin = (Duration) Preconditions.checkNotNull(duration, "refreshMargin");
        Preconditions.checkArgument(!duration.isNegative(), "refreshMargin can't be negative");
        this.expirationMargin = (Duration) Preconditions.checkNotNull(duration2, "expirationMargin");
        Preconditions.checkArgument(!duration2.isNegative(), "expirationMargin can't be negative");
    }

    @Override // com.google.auth.Credentials
    public String getAuthenticationType() {
        return "OAuth2";
    }

    public final AccessToken getAccessToken() {
        OAuthValue oAuthValue = this.value;
        if (oAuthValue != null) {
            return oAuthValue.temporaryAccess;
        }
        return null;
    }

    Duration getRefreshMargin() {
        return this.refreshMargin;
    }

    Duration getExpirationMargin() {
        return this.expirationMargin;
    }

    @Override // com.google.auth.Credentials
    public void getRequestMetadata(URI uri, Executor executor, RequestMetadataCallback requestMetadataCallback) {
        Futures.addCallback(asyncFetch(executor), new FutureCallbackToMetadataCallbackAdapter(requestMetadataCallback), MoreExecutors.directExecutor());
    }

    @Override // com.google.auth.Credentials
    public Map<String, List<String>> getRequestMetadata(URI uri) throws IOException {
        return ((OAuthValue) unwrapDirectFuture(asyncFetch(MoreExecutors.directExecutor()))).requestMetadata;
    }

    @Override // com.google.auth.Credentials
    public void refresh() throws IOException {
        AsyncRefreshResult orCreateRefreshTask = getOrCreateRefreshTask();
        orCreateRefreshTask.executeIfNew(MoreExecutors.directExecutor());
        unwrapDirectFuture(orCreateRefreshTask.task);
    }

    public void refreshIfExpired() throws IOException {
        unwrapDirectFuture(asyncFetch(MoreExecutors.directExecutor()));
    }

    private ListenableFuture<OAuthValue> asyncFetch(Executor executor) {
        AsyncRefreshResult orCreateRefreshTask;
        if (getState() == CacheState.FRESH) {
            return Futures.immediateFuture(this.value);
        }
        synchronized (this.lock) {
            orCreateRefreshTask = getState() != CacheState.FRESH ? getOrCreateRefreshTask() : null;
        }
        if (orCreateRefreshTask != null) {
            orCreateRefreshTask.executeIfNew(executor);
        }
        synchronized (this.lock) {
            if (getState() != CacheState.EXPIRED) {
                return Futures.immediateFuture(this.value);
            }
            if (orCreateRefreshTask == null) {
                return Futures.immediateFailedFuture(new IllegalStateException("Credentials expired, but there is no task to refresh"));
            }
            return orCreateRefreshTask.task;
        }
    }

    private AsyncRefreshResult getOrCreateRefreshTask() {
        synchronized (this.lock) {
            if (this.refreshTask != null) {
                return new AsyncRefreshResult(this.refreshTask, false);
            }
            ListenableFutureTask listenableFutureTaskCreate = ListenableFutureTask.create(new AnonymousClass1());
            this.refreshTask = new RefreshTask(listenableFutureTaskCreate, new RefreshTaskListener(listenableFutureTaskCreate));
            return new AsyncRefreshResult(this.refreshTask, true);
        }
    }

    /* JADX INFO: renamed from: com.google.auth.oauth2.OAuth2Credentials$1, reason: invalid class name */
    class AnonymousClass1 implements Callable<OAuthValue> {
        AnonymousClass1() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public OAuthValue call() throws Exception {
            return OAuthValue.create(OAuth2Credentials.this.refreshAccessToken(), OAuth2Credentials.this.getAdditionalHeaders());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishRefreshAsync(ListenableFuture<OAuthValue> listenableFuture) {
        synchronized (this.lock) {
            try {
                this.value = (OAuthValue) Futures.getDone(listenableFuture);
                Iterator<CredentialsChangedListener> it = this.changeListeners.iterator();
                while (it.hasNext()) {
                    it.next().onChanged(this);
                }
                RefreshTask refreshTask = this.refreshTask;
                if (refreshTask != null && refreshTask.getTask() == listenableFuture) {
                    this.refreshTask = null;
                }
            } catch (Exception unused) {
                RefreshTask refreshTask2 = this.refreshTask;
                if (refreshTask2 != null && refreshTask2.getTask() == listenableFuture) {
                }
            } catch (Throwable th) {
                RefreshTask refreshTask3 = this.refreshTask;
                if (refreshTask3 != null && refreshTask3.getTask() == listenableFuture) {
                    this.refreshTask = null;
                }
                throw th;
            }
        }
    }

    private static <T> T unwrapDirectFuture(ListenableFuture<T> listenableFuture) throws IOException {
        try {
            return listenableFuture.get();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new IOException("Interrupted while asynchronously refreshing the access token", e);
        } catch (ExecutionException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof IOException) {
                throw ((IOException) cause);
            }
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            throw new IOException("Unexpected error refreshing access token", cause);
        }
    }

    private CacheState getState() {
        OAuthValue oAuthValue = this.value;
        if (oAuthValue == null) {
            return CacheState.EXPIRED;
        }
        Date expirationTime = oAuthValue.temporaryAccess.getExpirationTime();
        if (expirationTime == null) {
            return CacheState.FRESH;
        }
        Duration durationOfMillis = Duration.ofMillis(expirationTime.getTime() - this.clock.currentTimeMillis());
        if (durationOfMillis.compareTo(this.expirationMargin) <= 0) {
            return CacheState.EXPIRED;
        }
        if (durationOfMillis.compareTo(this.refreshMargin) <= 0) {
            return CacheState.STALE;
        }
        return CacheState.FRESH;
    }

    public AccessToken refreshAccessToken() throws IOException {
        throw new IllegalStateException("OAuth2Credentials instance does not support refreshing the access token. An instance with a new access token should be used, or a derived type that supports refreshing.");
    }

    protected Map<String, List<String>> getAdditionalHeaders() {
        return EMPTY_EXTRA_HEADERS;
    }

    public final void addChangeListener(CredentialsChangedListener credentialsChangedListener) {
        synchronized (this.lock) {
            if (this.changeListeners == null) {
                this.changeListeners = new ArrayList();
            }
            this.changeListeners.add(credentialsChangedListener);
        }
    }

    public final void removeChangeListener(CredentialsChangedListener credentialsChangedListener) {
        synchronized (this.lock) {
            List<CredentialsChangedListener> list = this.changeListeners;
            if (list != null) {
                list.remove(credentialsChangedListener);
            }
        }
    }

    public int hashCode() {
        return Objects.hashCode(this.value);
    }

    @Nullable
    protected Map<String, List<String>> getRequestMetadataInternal() {
        OAuthValue oAuthValue = this.value;
        if (oAuthValue != null) {
            return oAuthValue.requestMetadata;
        }
        return null;
    }

    public String toString() {
        Map map;
        AccessToken accessToken;
        OAuthValue oAuthValue = this.value;
        if (oAuthValue != null) {
            map = oAuthValue.requestMetadata;
            accessToken = oAuthValue.temporaryAccess;
        } else {
            map = null;
            accessToken = null;
        }
        return MoreObjects.toStringHelper(this).add("requestMetadata", map).add("temporaryAccess", accessToken).toString();
    }

    public boolean equals(Object obj) {
        if (obj instanceof OAuth2Credentials) {
            return Objects.equals(this.value, ((OAuth2Credentials) obj).value);
        }
        return false;
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.clock = Clock.SYSTEM;
        this.refreshTask = null;
    }

    protected static <T> T newInstance(String str) throws IOException, ClassNotFoundException {
        try {
            return (T) Class.forName(str).newInstance();
        } catch (IllegalAccessException | InstantiationException e) {
            throw new IOException(e);
        }
    }

    protected static <T> T getFromServiceLoader(Class<? extends T> cls, T t) {
        return (T) Iterables.getFirst(ServiceLoader.load(cls), t);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public Builder toBuilder() {
        return new Builder(this);
    }

    static class OAuthValue implements Serializable {
        private final Map<String, List<String>> requestMetadata;
        private final AccessToken temporaryAccess;

        static OAuthValue create(AccessToken accessToken, Map<String, List<String>> map) {
            return new OAuthValue(accessToken, ImmutableMap.builder().put("Authorization", ImmutableList.of("Bearer " + accessToken.getTokenValue())).putAll(map).build());
        }

        private OAuthValue(AccessToken accessToken, Map<String, List<String>> map) {
            this.temporaryAccess = accessToken;
            this.requestMetadata = map;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof OAuthValue)) {
                return false;
            }
            OAuthValue oAuthValue = (OAuthValue) obj;
            return Objects.equals(this.requestMetadata, oAuthValue.requestMetadata) && Objects.equals(this.temporaryAccess, oAuthValue.temporaryAccess);
        }

        public int hashCode() {
            return Objects.hash(this.temporaryAccess, this.requestMetadata);
        }
    }

    static class FutureCallbackToMetadataCallbackAdapter implements FutureCallback<OAuthValue> {
        private final RequestMetadataCallback callback;

        public FutureCallbackToMetadataCallbackAdapter(RequestMetadataCallback requestMetadataCallback) {
            this.callback = requestMetadataCallback;
        }

        @Override // com.google.common.util.concurrent.FutureCallback
        public void onSuccess(@Nullable OAuthValue oAuthValue) {
            this.callback.onSuccess(oAuthValue.requestMetadata);
        }

        @Override // com.google.common.util.concurrent.FutureCallback
        public void onFailure(Throwable th) {
            if (th instanceof ExecutionException) {
                th = th.getCause();
            }
            this.callback.onFailure(th);
        }
    }

    static class AsyncRefreshResult {
        private final boolean isNew;
        private final RefreshTask task;

        AsyncRefreshResult(RefreshTask refreshTask, boolean z) {
            this.task = refreshTask;
            this.isNew = z;
        }

        void executeIfNew(Executor executor) {
            if (this.isNew) {
                executor.execute(this.task);
            }
        }
    }

    class RefreshTaskListener implements Runnable {
        private ListenableFutureTask<OAuthValue> task;

        RefreshTaskListener(ListenableFutureTask<OAuthValue> listenableFutureTask) {
            this.task = listenableFutureTask;
        }

        @Override // java.lang.Runnable
        public void run() {
            OAuth2Credentials.this.finishRefreshAsync(this.task);
        }
    }

    class RefreshTask extends AbstractFuture<OAuthValue> implements Runnable {
        private final RefreshTaskListener listener;
        private final ListenableFutureTask<OAuthValue> task;

        RefreshTask(ListenableFutureTask<OAuthValue> listenableFutureTask, RefreshTaskListener refreshTaskListener) {
            this.task = listenableFutureTask;
            this.listener = refreshTaskListener;
            listenableFutureTask.addListener(refreshTaskListener, MoreExecutors.directExecutor());
            Futures.addCallback(listenableFutureTask, new AnonymousClass1(OAuth2Credentials.this), MoreExecutors.directExecutor());
        }

        /* JADX INFO: renamed from: com.google.auth.oauth2.OAuth2Credentials$RefreshTask$1, reason: invalid class name */
        class AnonymousClass1 implements FutureCallback<OAuthValue> {
            final /* synthetic */ OAuth2Credentials val$this$0;

            AnonymousClass1(OAuth2Credentials oAuth2Credentials) {
                this.val$this$0 = oAuth2Credentials;
            }

            @Override // com.google.common.util.concurrent.FutureCallback
            public void onSuccess(OAuthValue oAuthValue) {
                RefreshTask.this.set(oAuthValue);
            }

            @Override // com.google.common.util.concurrent.FutureCallback
            public void onFailure(Throwable th) {
                RefreshTask.this.setException(th);
            }
        }

        public ListenableFutureTask<OAuthValue> getTask() {
            return this.task;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.task.run();
        }
    }

    public static class Builder {
        private AccessToken accessToken;
        private Duration expirationMargin;
        private Duration refreshMargin;

        protected Builder() {
            this.refreshMargin = OAuth2Credentials.DEFAULT_REFRESH_MARGIN;
            this.expirationMargin = OAuth2Credentials.DEFAULT_EXPIRATION_MARGIN;
        }

        protected Builder(OAuth2Credentials oAuth2Credentials) {
            this.refreshMargin = OAuth2Credentials.DEFAULT_REFRESH_MARGIN;
            this.expirationMargin = OAuth2Credentials.DEFAULT_EXPIRATION_MARGIN;
            this.accessToken = oAuth2Credentials.getAccessToken();
            this.refreshMargin = oAuth2Credentials.refreshMargin;
            this.expirationMargin = oAuth2Credentials.expirationMargin;
        }

        public Builder setAccessToken(AccessToken accessToken) {
            this.accessToken = accessToken;
            return this;
        }

        public Builder setRefreshMargin(Duration duration) {
            this.refreshMargin = duration;
            return this;
        }

        public Duration getRefreshMargin() {
            return this.refreshMargin;
        }

        public Builder setExpirationMargin(Duration duration) {
            this.expirationMargin = duration;
            return this;
        }

        public Duration getExpirationMargin() {
            return this.expirationMargin;
        }

        public AccessToken getAccessToken() {
            return this.accessToken;
        }

        public OAuth2Credentials build() {
            return new OAuth2Credentials(this.accessToken, this.refreshMargin, this.expirationMargin);
        }
    }
}
