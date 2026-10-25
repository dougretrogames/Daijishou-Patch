package com.bumptech.glide.manager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.util.Log;
import com.bumptech.glide.util.GlideSuppliers;
import com.bumptech.glide.util.Util;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes3.dex */
final class SingletonConnectivityReceiver {
    private static final String TAG = "ConnectivityMonitor";
    private static volatile SingletonConnectivityReceiver instance;
    private final FrameworkConnectivityMonitor frameworkConnectivityMonitor;
    private boolean isRegistered;
    final Set<ConnectivityMonitor.ConnectivityListener> listeners = new HashSet();

    private interface FrameworkConnectivityMonitor {
        boolean register();

        void unregister();
    }

    static SingletonConnectivityReceiver get(Context context) {
        if (instance == null) {
            synchronized (SingletonConnectivityReceiver.class) {
                if (instance == null) {
                    instance = new SingletonConnectivityReceiver(context.getApplicationContext());
                }
            }
        }
        return instance;
    }

    static void reset() {
        instance = null;
    }

    private SingletonConnectivityReceiver(Context context) {
        this.frameworkConnectivityMonitor = new FrameworkConnectivityMonitorPostApi24(GlideSuppliers.memorize(new AnonymousClass1(context)), new AnonymousClass2());
    }

    /* JADX INFO: renamed from: com.bumptech.glide.manager.SingletonConnectivityReceiver$1, reason: invalid class name */
    class AnonymousClass1 implements GlideSuppliers.GlideSupplier<ConnectivityManager> {
        final /* synthetic */ Context val$context;

        AnonymousClass1(Context context) {
            this.val$context = context;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.bumptech.glide.util.GlideSuppliers.GlideSupplier
        public ConnectivityManager get() {
            return (ConnectivityManager) this.val$context.getSystemService("connectivity");
        }
    }

    /* JADX INFO: renamed from: com.bumptech.glide.manager.SingletonConnectivityReceiver$2, reason: invalid class name */
    class AnonymousClass2 implements ConnectivityMonitor.ConnectivityListener {
        AnonymousClass2() {
        }

        @Override // com.bumptech.glide.manager.ConnectivityMonitor.ConnectivityListener
        public void onConnectivityChanged(boolean z) {
            ArrayList arrayList;
            Util.assertMainThread();
            synchronized (SingletonConnectivityReceiver.this) {
                arrayList = new ArrayList(SingletonConnectivityReceiver.this.listeners);
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((ConnectivityMonitor.ConnectivityListener) it.next()).onConnectivityChanged(z);
            }
        }
    }

    synchronized void register(ConnectivityMonitor.ConnectivityListener connectivityListener) {
        this.listeners.add(connectivityListener);
        maybeRegisterReceiver();
    }

    synchronized void unregister(ConnectivityMonitor.ConnectivityListener connectivityListener) {
        this.listeners.remove(connectivityListener);
        maybeUnregisterReceiver();
    }

    private void maybeRegisterReceiver() {
        if (this.isRegistered || this.listeners.isEmpty()) {
            return;
        }
        this.isRegistered = this.frameworkConnectivityMonitor.register();
    }

    private void maybeUnregisterReceiver() {
        if (this.isRegistered && this.listeners.isEmpty()) {
            this.frameworkConnectivityMonitor.unregister();
            this.isRegistered = false;
        }
    }

    private static final class FrameworkConnectivityMonitorPostApi24 implements FrameworkConnectivityMonitor {
        private final GlideSuppliers.GlideSupplier<ConnectivityManager> connectivityManager;
        boolean isConnected;
        final ConnectivityMonitor.ConnectivityListener listener;
        private final ConnectivityManager.NetworkCallback networkCallback = new AnonymousClass1();

        /* JADX INFO: renamed from: com.bumptech.glide.manager.SingletonConnectivityReceiver$FrameworkConnectivityMonitorPostApi24$1, reason: invalid class name */
        class AnonymousClass1 extends ConnectivityManager.NetworkCallback {
            AnonymousClass1() {
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onAvailable(Network network) {
                postOnConnectivityChange(true);
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onLost(Network network) {
                postOnConnectivityChange(false);
            }

            /* JADX INFO: renamed from: com.bumptech.glide.manager.SingletonConnectivityReceiver$FrameworkConnectivityMonitorPostApi24$1$1, reason: invalid class name and collision with other inner class name */
            class RunnableC00281 implements Runnable {
                final /* synthetic */ boolean val$newState;

                RunnableC00281(boolean z) {
                    this.val$newState = z;
                }

                @Override // java.lang.Runnable
                public void run() {
                    AnonymousClass1.this.onConnectivityChange(this.val$newState);
                }
            }

            private void postOnConnectivityChange(boolean z) {
                Util.postOnUiThread(new RunnableC00281(z));
            }

            void onConnectivityChange(boolean z) {
                Util.assertMainThread();
                boolean z2 = FrameworkConnectivityMonitorPostApi24.this.isConnected;
                FrameworkConnectivityMonitorPostApi24.this.isConnected = z;
                if (z2 != z) {
                    FrameworkConnectivityMonitorPostApi24.this.listener.onConnectivityChanged(z);
                }
            }
        }

        FrameworkConnectivityMonitorPostApi24(GlideSuppliers.GlideSupplier<ConnectivityManager> glideSupplier, ConnectivityMonitor.ConnectivityListener connectivityListener) {
            this.connectivityManager = glideSupplier;
            this.listener = connectivityListener;
        }

        @Override // com.bumptech.glide.manager.SingletonConnectivityReceiver.FrameworkConnectivityMonitor
        public boolean register() {
            this.isConnected = this.connectivityManager.get().getActiveNetwork() != null;
            try {
                this.connectivityManager.get().registerDefaultNetworkCallback(this.networkCallback);
                return true;
            } catch (RuntimeException e) {
                if (Log.isLoggable(SingletonConnectivityReceiver.TAG, 5)) {
                    Log.w(SingletonConnectivityReceiver.TAG, "Failed to register callback", e);
                }
                return false;
            }
        }

        @Override // com.bumptech.glide.manager.SingletonConnectivityReceiver.FrameworkConnectivityMonitor
        public void unregister() {
            this.connectivityManager.get().unregisterNetworkCallback(this.networkCallback);
        }
    }

    private static final class FrameworkConnectivityMonitorPreApi24 implements FrameworkConnectivityMonitor {
        static final Executor EXECUTOR = AsyncTask.SERIAL_EXECUTOR;
        private final GlideSuppliers.GlideSupplier<ConnectivityManager> connectivityManager;
        final BroadcastReceiver connectivityReceiver = new AnonymousClass1();
        final Context context;
        volatile boolean isConnected;
        volatile boolean isRegistered;
        final ConnectivityMonitor.ConnectivityListener listener;

        /* JADX INFO: renamed from: com.bumptech.glide.manager.SingletonConnectivityReceiver$FrameworkConnectivityMonitorPreApi24$1, reason: invalid class name */
        class AnonymousClass1 extends BroadcastReceiver {
            AnonymousClass1() {
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                FrameworkConnectivityMonitorPreApi24.this.onConnectivityChange();
            }
        }

        FrameworkConnectivityMonitorPreApi24(Context context, GlideSuppliers.GlideSupplier<ConnectivityManager> glideSupplier, ConnectivityMonitor.ConnectivityListener connectivityListener) {
            this.context = context.getApplicationContext();
            this.connectivityManager = glideSupplier;
            this.listener = connectivityListener;
        }

        /* JADX INFO: renamed from: com.bumptech.glide.manager.SingletonConnectivityReceiver$FrameworkConnectivityMonitorPreApi24$2, reason: invalid class name */
        class AnonymousClass2 implements Runnable {
            AnonymousClass2() {
            }

            @Override // java.lang.Runnable
            public void run() {
                FrameworkConnectivityMonitorPreApi24 frameworkConnectivityMonitorPreApi24 = FrameworkConnectivityMonitorPreApi24.this;
                frameworkConnectivityMonitorPreApi24.isConnected = frameworkConnectivityMonitorPreApi24.isConnected();
                try {
                    FrameworkConnectivityMonitorPreApi24.this.context.registerReceiver(FrameworkConnectivityMonitorPreApi24.this.connectivityReceiver, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                    FrameworkConnectivityMonitorPreApi24.this.isRegistered = true;
                } catch (SecurityException e) {
                    if (Log.isLoggable(SingletonConnectivityReceiver.TAG, 5)) {
                        Log.w(SingletonConnectivityReceiver.TAG, "Failed to register", e);
                    }
                    FrameworkConnectivityMonitorPreApi24.this.isRegistered = false;
                }
            }
        }

        @Override // com.bumptech.glide.manager.SingletonConnectivityReceiver.FrameworkConnectivityMonitor
        public boolean register() {
            EXECUTOR.execute(new AnonymousClass2());
            return true;
        }

        /* JADX INFO: renamed from: com.bumptech.glide.manager.SingletonConnectivityReceiver$FrameworkConnectivityMonitorPreApi24$3, reason: invalid class name */
        class AnonymousClass3 implements Runnable {
            AnonymousClass3() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (FrameworkConnectivityMonitorPreApi24.this.isRegistered) {
                    FrameworkConnectivityMonitorPreApi24.this.isRegistered = false;
                    FrameworkConnectivityMonitorPreApi24.this.context.unregisterReceiver(FrameworkConnectivityMonitorPreApi24.this.connectivityReceiver);
                }
            }
        }

        @Override // com.bumptech.glide.manager.SingletonConnectivityReceiver.FrameworkConnectivityMonitor
        public void unregister() {
            EXECUTOR.execute(new AnonymousClass3());
        }

        /* JADX INFO: renamed from: com.bumptech.glide.manager.SingletonConnectivityReceiver$FrameworkConnectivityMonitorPreApi24$4, reason: invalid class name */
        class AnonymousClass4 implements Runnable {
            AnonymousClass4() {
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean z = FrameworkConnectivityMonitorPreApi24.this.isConnected;
                FrameworkConnectivityMonitorPreApi24 frameworkConnectivityMonitorPreApi24 = FrameworkConnectivityMonitorPreApi24.this;
                frameworkConnectivityMonitorPreApi24.isConnected = frameworkConnectivityMonitorPreApi24.isConnected();
                if (z != FrameworkConnectivityMonitorPreApi24.this.isConnected) {
                    if (Log.isLoggable(SingletonConnectivityReceiver.TAG, 3)) {
                        Log.d(SingletonConnectivityReceiver.TAG, "connectivity changed, isConnected: " + FrameworkConnectivityMonitorPreApi24.this.isConnected);
                    }
                    FrameworkConnectivityMonitorPreApi24 frameworkConnectivityMonitorPreApi25 = FrameworkConnectivityMonitorPreApi24.this;
                    frameworkConnectivityMonitorPreApi25.notifyChangeOnUiThread(frameworkConnectivityMonitorPreApi25.isConnected);
                }
            }
        }

        void onConnectivityChange() {
            EXECUTOR.execute(new AnonymousClass4());
        }

        /* JADX INFO: renamed from: com.bumptech.glide.manager.SingletonConnectivityReceiver$FrameworkConnectivityMonitorPreApi24$5, reason: invalid class name */
        class AnonymousClass5 implements Runnable {
            final /* synthetic */ boolean val$isConnected;

            AnonymousClass5(boolean z) {
                this.val$isConnected = z;
            }

            @Override // java.lang.Runnable
            public void run() {
                FrameworkConnectivityMonitorPreApi24.this.listener.onConnectivityChanged(this.val$isConnected);
            }
        }

        void notifyChangeOnUiThread(boolean z) {
            Util.postOnUiThread(new AnonymousClass5(z));
        }

        boolean isConnected() {
            try {
                NetworkInfo activeNetworkInfo = this.connectivityManager.get().getActiveNetworkInfo();
                return activeNetworkInfo != null && activeNetworkInfo.isConnected();
            } catch (RuntimeException e) {
                if (Log.isLoggable(SingletonConnectivityReceiver.TAG, 5)) {
                    Log.w(SingletonConnectivityReceiver.TAG, "Failed to determine connectivity status when connectivity changed", e);
                }
                return true;
            }
        }
    }
}
