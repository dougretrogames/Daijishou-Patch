package com.magneticchen.daijishou.data.live;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import androidx.lifecycle.LiveData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ConnectionLiveData.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0011B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\f\u001a\u00020\tH\u0002J\b\u0010\r\u001a\u00020\u000eH\u0014J\b\u0010\u000f\u001a\u00020\u000eH\u0014J\b\u0010\u0010\u001a\u00020\u000eH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/magneticchen/daijishou/data/live/ConnectionLiveData;", "Landroidx/lifecycle/LiveData;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "connectivityManager", "Landroid/net/ConnectivityManager;", "connectivityManagerCallback", "Landroid/net/ConnectivityManager$NetworkCallback;", "getContext", "()Landroid/content/Context;", "getConnectivityMarshmallowManagerCallback", "onActive", "", "onInactive", "updateConnection", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ConnectionLiveData extends LiveData<Integer> {
    public static final int CONNECTION_CELLULAR = 3;
    public static final int CONNECTION_ETHERNET = 2;
    public static final int CONNECTION_NONE = -1;
    public static final int CONNECTION_UNKNOWN = 0;
    public static final int CONNECTION_WIFI = 1;
    public static final Companion Companion = new Companion(null);
    private ConnectivityManager connectivityManager;
    private ConnectivityManager.NetworkCallback connectivityManagerCallback;
    private final Context context;

    public ConnectionLiveData(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        Object systemService = context.getSystemService("connectivity");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        this.connectivityManager = (ConnectivityManager) systemService;
    }

    public final Context getContext() {
        return this.context;
    }

    /* JADX INFO: compiled from: ConnectionLiveData.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/magneticchen/daijishou/data/live/ConnectionLiveData$Companion;", "", "()V", "CONNECTION_CELLULAR", "", "CONNECTION_ETHERNET", "CONNECTION_NONE", "CONNECTION_UNKNOWN", "CONNECTION_WIFI", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    protected void onActive() {
        super.onActive();
        updateConnection();
        this.connectivityManager.registerDefaultNetworkCallback(getConnectivityMarshmallowManagerCallback());
    }

    protected void onInactive() {
        super.onInactive();
        ConnectivityManager connectivityManager = this.connectivityManager;
        ConnectivityManager.NetworkCallback networkCallback = this.connectivityManagerCallback;
        if (networkCallback == null) {
            Intrinsics.throwUninitializedPropertyAccessException("connectivityManagerCallback");
            networkCallback = null;
        }
        connectivityManager.unregisterNetworkCallback(networkCallback);
    }

    private final ConnectivityManager.NetworkCallback getConnectivityMarshmallowManagerCallback() {
        ConnectivityManager.NetworkCallback networkCallback = new ConnectivityManager.NetworkCallback() { // from class: com.magneticchen.daijishou.data.live.ConnectionLiveData.getConnectivityMarshmallowManagerCallback.1
            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
                Intrinsics.checkNotNullParameter(network, "network");
                Intrinsics.checkNotNullParameter(networkCapabilities, "networkCapabilities");
                ConnectionLiveData connectionLiveData = ConnectionLiveData.this;
                int i = 1;
                if (!networkCapabilities.hasTransport(1)) {
                    i = 3;
                    if (networkCapabilities.hasTransport(3)) {
                        i = 2;
                    } else if (!networkCapabilities.hasTransport(0)) {
                        i = 0;
                    }
                }
                if (networkCapabilities.hasCapability(12) && networkCapabilities.hasCapability(16)) {
                    connectionLiveData.postValue(Integer.valueOf(i));
                }
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onLost(Network network) {
                Intrinsics.checkNotNullParameter(network, "network");
                ConnectionLiveData.this.postValue(-1);
            }
        };
        this.connectivityManagerCallback = networkCallback;
        return networkCallback;
    }

    private final void updateConnection() {
        Network activeNetwork = this.connectivityManager.getActiveNetwork();
        if (activeNetwork == null) {
            postValue(-1);
            return;
        }
        NetworkCapabilities networkCapabilities = this.connectivityManager.getNetworkCapabilities(activeNetwork);
        if (networkCapabilities == null) {
            postValue(-1);
            return;
        }
        int i = 1;
        if (!networkCapabilities.hasTransport(1)) {
            i = 3;
            if (networkCapabilities.hasTransport(3)) {
                i = 2;
            } else if (!networkCapabilities.hasTransport(0)) {
                i = 0;
            }
        }
        if (networkCapabilities.hasCapability(12) && networkCapabilities.hasCapability(16)) {
            postValue(Integer.valueOf(i));
        }
    }
}
