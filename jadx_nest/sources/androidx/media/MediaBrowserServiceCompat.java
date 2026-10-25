package androidx.media;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.service.media.MediaBrowserService;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.IMediaSession;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;
import androidx.collection.ArrayMap;
import androidx.core.app.BundleCompat;
import androidx.core.util.Pair;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class MediaBrowserServiceCompat extends Service {
    private static final float EPSILON = 1.0E-5f;
    public static final String KEY_MEDIA_ITEM = "media_item";
    public static final String KEY_SEARCH_RESULTS = "search_results";
    public static final int RESULT_ERROR = -1;
    static final int RESULT_FLAG_ON_LOAD_ITEM_NOT_IMPLEMENTED = 2;
    static final int RESULT_FLAG_ON_SEARCH_NOT_IMPLEMENTED = 4;
    static final int RESULT_FLAG_OPTION_NOT_HANDLED = 1;
    public static final int RESULT_OK = 0;
    public static final int RESULT_PROGRESS_UPDATE = 1;
    public static final String SERVICE_INTERFACE = "android.media.browse.MediaBrowserService";
    ConnectionRecord mCurConnection;
    private MediaBrowserServiceImpl mImpl;
    MediaSessionCompat.Token mSession;
    static final String TAG = "MBServiceCompat";
    static final boolean DEBUG = Log.isLoggable(TAG, 3);
    final ArrayMap<IBinder, ConnectionRecord> mConnections = new ArrayMap<>();
    final ServiceHandler mHandler = new ServiceHandler();

    interface MediaBrowserServiceImpl {
        Bundle getBrowserRootHints();

        MediaSessionManager.RemoteUserInfo getCurrentBrowserInfo();

        void notifyChildrenChanged(MediaSessionManager.RemoteUserInfo remoteUserInfo, String str, Bundle bundle);

        void notifyChildrenChanged(String str, Bundle bundle);

        IBinder onBind(Intent intent);

        void onCreate();

        void setSessionToken(MediaSessionCompat.Token token);
    }

    private interface ServiceCallbacks {
        IBinder asBinder();

        void onConnect(String str, MediaSessionCompat.Token token, Bundle bundle) throws RemoteException;

        void onConnectFailed() throws RemoteException;

        void onLoadChildren(String str, List<MediaBrowserCompat.MediaItem> list, Bundle bundle, Bundle bundle2) throws RemoteException;
    }

    @Override // android.app.Service
    public void dump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    public abstract BrowserRoot onGetRoot(String str, int i, Bundle bundle);

    public abstract void onLoadChildren(String str, Result<List<MediaBrowserCompat.MediaItem>> result);

    public void onSubscribe(String str, Bundle bundle) {
    }

    public void onUnsubscribe(String str) {
    }

    class MediaBrowserServiceImplBase implements MediaBrowserServiceImpl {
        private Messenger mMessenger;

        MediaBrowserServiceImplBase() {
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void onCreate() {
            this.mMessenger = new Messenger(MediaBrowserServiceCompat.this.mHandler);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public IBinder onBind(Intent intent) {
            if (MediaBrowserServiceCompat.SERVICE_INTERFACE.equals(intent.getAction())) {
                return this.mMessenger.getBinder();
            }
            return null;
        }

        /* JADX INFO: renamed from: androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplBase$1, reason: invalid class name */
        class AnonymousClass1 implements Runnable {
            final /* synthetic */ MediaSessionCompat.Token val$token;

            AnonymousClass1(MediaSessionCompat.Token token) {
                this.val$token = token;
            }

            @Override // java.lang.Runnable
            public void run() {
                Iterator<ConnectionRecord> it = MediaBrowserServiceCompat.this.mConnections.values().iterator();
                while (it.hasNext()) {
                    ConnectionRecord next = it.next();
                    try {
                        next.callbacks.onConnect(next.root.getRootId(), this.val$token, next.root.getExtras());
                    } catch (RemoteException unused) {
                        Log.w(MediaBrowserServiceCompat.TAG, "Connection for " + next.pkg + " is no longer valid.");
                        it.remove();
                    }
                }
            }
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void setSessionToken(MediaSessionCompat.Token token) {
            MediaBrowserServiceCompat.this.mHandler.post(new AnonymousClass1(token));
        }

        /* JADX INFO: renamed from: androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplBase$2, reason: invalid class name */
        class AnonymousClass2 implements Runnable {
            final /* synthetic */ Bundle val$options;
            final /* synthetic */ String val$parentId;

            AnonymousClass2(String str, Bundle bundle) {
                this.val$parentId = str;
                this.val$options = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                Iterator<IBinder> it = MediaBrowserServiceCompat.this.mConnections.keySet().iterator();
                while (it.hasNext()) {
                    MediaBrowserServiceImplBase.this.notifyChildrenChangedOnHandler(MediaBrowserServiceCompat.this.mConnections.get(it.next()), this.val$parentId, this.val$options);
                }
            }
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void notifyChildrenChanged(String str, Bundle bundle) {
            MediaBrowserServiceCompat.this.mHandler.post(new AnonymousClass2(str, bundle));
        }

        /* JADX INFO: renamed from: androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplBase$3, reason: invalid class name */
        class AnonymousClass3 implements Runnable {
            final /* synthetic */ Bundle val$options;
            final /* synthetic */ String val$parentId;
            final /* synthetic */ MediaSessionManager.RemoteUserInfo val$remoteUserInfo;

            AnonymousClass3(MediaSessionManager.RemoteUserInfo remoteUserInfo, String str, Bundle bundle) {
                this.val$remoteUserInfo = remoteUserInfo;
                this.val$parentId = str;
                this.val$options = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                for (int i = 0; i < MediaBrowserServiceCompat.this.mConnections.getSize(); i++) {
                    ConnectionRecord connectionRecordValueAt = MediaBrowserServiceCompat.this.mConnections.valueAt(i);
                    if (connectionRecordValueAt.browserInfo.equals(this.val$remoteUserInfo)) {
                        MediaBrowserServiceImplBase.this.notifyChildrenChangedOnHandler(connectionRecordValueAt, this.val$parentId, this.val$options);
                        return;
                    }
                }
            }
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void notifyChildrenChanged(MediaSessionManager.RemoteUserInfo remoteUserInfo, String str, Bundle bundle) {
            MediaBrowserServiceCompat.this.mHandler.post(new AnonymousClass3(remoteUserInfo, str, bundle));
        }

        void notifyChildrenChangedOnHandler(ConnectionRecord connectionRecord, String str, Bundle bundle) {
            List<Pair<IBinder, Bundle>> list = connectionRecord.subscriptions.get(str);
            if (list != null) {
                for (Pair<IBinder, Bundle> pair : list) {
                    if (MediaBrowserCompatUtils.hasDuplicatedItems(bundle, pair.second)) {
                        MediaBrowserServiceCompat.this.performLoadChildren(str, connectionRecord, pair.second, bundle);
                    }
                }
            }
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public Bundle getBrowserRootHints() {
            if (MediaBrowserServiceCompat.this.mCurConnection == null) {
                throw new IllegalStateException("This should be called inside of onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
            }
            if (MediaBrowserServiceCompat.this.mCurConnection.rootHints == null) {
                return null;
            }
            return new Bundle(MediaBrowserServiceCompat.this.mCurConnection.rootHints);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public MediaSessionManager.RemoteUserInfo getCurrentBrowserInfo() {
            if (MediaBrowserServiceCompat.this.mCurConnection == null) {
                throw new IllegalStateException("This should be called inside of onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
            }
            return MediaBrowserServiceCompat.this.mCurConnection.browserInfo;
        }
    }

    class MediaBrowserServiceImplApi21 implements MediaBrowserServiceImpl, MediaBrowserServiceCompatApi21.ServiceCompatProxy {
        Messenger mMessenger;
        final List<Bundle> mRootExtrasList = new ArrayList();
        Object mServiceObj;

        MediaBrowserServiceImplApi21() {
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void onCreate() {
            Object objCreateService = MediaBrowserServiceCompatApi21.createService(MediaBrowserServiceCompat.this, this);
            this.mServiceObj = objCreateService;
            MediaBrowserServiceCompatApi21.onCreate(objCreateService);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public IBinder onBind(Intent intent) {
            return MediaBrowserServiceCompatApi21.onBind(this.mServiceObj, intent);
        }

        /* JADX INFO: renamed from: androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplApi21$1, reason: invalid class name */
        class AnonymousClass1 implements Runnable {
            final /* synthetic */ MediaSessionCompat.Token val$token;

            AnonymousClass1(MediaSessionCompat.Token token) {
                this.val$token = token;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (!MediaBrowserServiceImplApi21.this.mRootExtrasList.isEmpty()) {
                    IMediaSession extraBinder = this.val$token.getExtraBinder();
                    if (extraBinder != null) {
                        Iterator<Bundle> it = MediaBrowserServiceImplApi21.this.mRootExtrasList.iterator();
                        while (it.hasNext()) {
                            BundleCompat.putBinder(it.next(), MediaBrowserProtocol.EXTRA_SESSION_BINDER, extraBinder.asBinder());
                        }
                    }
                    MediaBrowserServiceImplApi21.this.mRootExtrasList.clear();
                }
                MediaBrowserServiceCompatApi21.setSessionToken(MediaBrowserServiceImplApi21.this.mServiceObj, this.val$token.getToken());
            }
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void setSessionToken(MediaSessionCompat.Token token) {
            MediaBrowserServiceCompat.this.mHandler.postOrRun(new AnonymousClass1(token));
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void notifyChildrenChanged(String str, Bundle bundle) {
            notifyChildrenChangedForFramework(str, bundle);
            notifyChildrenChangedForCompat(str, bundle);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void notifyChildrenChanged(MediaSessionManager.RemoteUserInfo remoteUserInfo, String str, Bundle bundle) {
            notifyChildrenChangedForCompat(remoteUserInfo, str, bundle);
        }

        @Override // androidx.media.MediaBrowserServiceCompatApi21.ServiceCompatProxy
        public MediaBrowserServiceCompatApi21.BrowserRoot onGetRoot(String str, int i, Bundle bundle) {
            Bundle extras;
            if (bundle == null || bundle.getInt(MediaBrowserProtocol.EXTRA_CLIENT_VERSION, 0) == 0) {
                extras = null;
            } else {
                bundle.remove(MediaBrowserProtocol.EXTRA_CLIENT_VERSION);
                this.mMessenger = new Messenger(MediaBrowserServiceCompat.this.mHandler);
                extras = new Bundle();
                extras.putInt(MediaBrowserProtocol.EXTRA_SERVICE_VERSION, 2);
                BundleCompat.putBinder(extras, MediaBrowserProtocol.EXTRA_MESSENGER_BINDER, this.mMessenger.getBinder());
                if (MediaBrowserServiceCompat.this.mSession != null) {
                    IMediaSession extraBinder = MediaBrowserServiceCompat.this.mSession.getExtraBinder();
                    BundleCompat.putBinder(extras, MediaBrowserProtocol.EXTRA_SESSION_BINDER, extraBinder == null ? null : extraBinder.asBinder());
                } else {
                    this.mRootExtrasList.add(extras);
                }
            }
            MediaBrowserServiceCompat.this.mCurConnection = MediaBrowserServiceCompat.this.new ConnectionRecord(str, -1, i, bundle, null);
            BrowserRoot browserRootOnGetRoot = MediaBrowserServiceCompat.this.onGetRoot(str, i, bundle);
            MediaBrowserServiceCompat.this.mCurConnection = null;
            if (browserRootOnGetRoot == null) {
                return null;
            }
            if (extras == null) {
                extras = browserRootOnGetRoot.getExtras();
            } else if (browserRootOnGetRoot.getExtras() != null) {
                extras.putAll(browserRootOnGetRoot.getExtras());
            }
            return new MediaBrowserServiceCompatApi21.BrowserRoot(browserRootOnGetRoot.getRootId(), extras);
        }

        /* JADX INFO: renamed from: androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplApi21$2, reason: invalid class name */
        class AnonymousClass2 extends Result<List<MediaBrowserCompat.MediaItem>> {
            final /* synthetic */ MediaBrowserServiceCompatApi21.ResultWrapper val$resultWrapper;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(Object obj, MediaBrowserServiceCompatApi21.ResultWrapper resultWrapper) {
                super(obj);
                this.val$resultWrapper = resultWrapper;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.media.MediaBrowserServiceCompat.Result
            public void onResultSent(List<MediaBrowserCompat.MediaItem> list) {
                ArrayList arrayList;
                if (list != null) {
                    arrayList = new ArrayList();
                    for (MediaBrowserCompat.MediaItem mediaItem : list) {
                        Parcel parcelObtain = Parcel.obtain();
                        mediaItem.writeToParcel(parcelObtain, 0);
                        arrayList.add(parcelObtain);
                    }
                } else {
                    arrayList = null;
                }
                this.val$resultWrapper.sendResult(arrayList);
            }

            @Override // androidx.media.MediaBrowserServiceCompat.Result
            public void detach() {
                this.val$resultWrapper.detach();
            }
        }

        @Override // androidx.media.MediaBrowserServiceCompatApi21.ServiceCompatProxy
        public void onLoadChildren(String str, MediaBrowserServiceCompatApi21.ResultWrapper<List<Parcel>> resultWrapper) {
            MediaBrowserServiceCompat.this.onLoadChildren(str, new AnonymousClass2(str, resultWrapper));
        }

        void notifyChildrenChangedForFramework(String str, Bundle bundle) {
            MediaBrowserServiceCompatApi21.notifyChildrenChanged(this.mServiceObj, str);
        }

        /* JADX INFO: renamed from: androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplApi21$3, reason: invalid class name */
        class AnonymousClass3 implements Runnable {
            final /* synthetic */ Bundle val$options;
            final /* synthetic */ String val$parentId;

            AnonymousClass3(String str, Bundle bundle) {
                this.val$parentId = str;
                this.val$options = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                Iterator<IBinder> it = MediaBrowserServiceCompat.this.mConnections.keySet().iterator();
                while (it.hasNext()) {
                    MediaBrowserServiceImplApi21.this.notifyChildrenChangedForCompatOnHandler(MediaBrowserServiceCompat.this.mConnections.get(it.next()), this.val$parentId, this.val$options);
                }
            }
        }

        void notifyChildrenChangedForCompat(String str, Bundle bundle) {
            MediaBrowserServiceCompat.this.mHandler.post(new AnonymousClass3(str, bundle));
        }

        /* JADX INFO: renamed from: androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplApi21$4, reason: invalid class name */
        class AnonymousClass4 implements Runnable {
            final /* synthetic */ Bundle val$options;
            final /* synthetic */ String val$parentId;
            final /* synthetic */ MediaSessionManager.RemoteUserInfo val$remoteUserInfo;

            AnonymousClass4(MediaSessionManager.RemoteUserInfo remoteUserInfo, String str, Bundle bundle) {
                this.val$remoteUserInfo = remoteUserInfo;
                this.val$parentId = str;
                this.val$options = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                for (int i = 0; i < MediaBrowserServiceCompat.this.mConnections.getSize(); i++) {
                    ConnectionRecord connectionRecordValueAt = MediaBrowserServiceCompat.this.mConnections.valueAt(i);
                    if (connectionRecordValueAt.browserInfo.equals(this.val$remoteUserInfo)) {
                        MediaBrowserServiceImplApi21.this.notifyChildrenChangedForCompatOnHandler(connectionRecordValueAt, this.val$parentId, this.val$options);
                    }
                }
            }
        }

        void notifyChildrenChangedForCompat(MediaSessionManager.RemoteUserInfo remoteUserInfo, String str, Bundle bundle) {
            MediaBrowserServiceCompat.this.mHandler.post(new AnonymousClass4(remoteUserInfo, str, bundle));
        }

        void notifyChildrenChangedForCompatOnHandler(ConnectionRecord connectionRecord, String str, Bundle bundle) {
            List<Pair<IBinder, Bundle>> list = connectionRecord.subscriptions.get(str);
            if (list != null) {
                for (Pair<IBinder, Bundle> pair : list) {
                    if (MediaBrowserCompatUtils.hasDuplicatedItems(bundle, pair.second)) {
                        MediaBrowserServiceCompat.this.performLoadChildren(str, connectionRecord, pair.second, bundle);
                    }
                }
            }
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public Bundle getBrowserRootHints() {
            if (this.mMessenger == null) {
                return null;
            }
            if (MediaBrowserServiceCompat.this.mCurConnection == null) {
                throw new IllegalStateException("This should be called inside of onGetRoot, onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
            }
            if (MediaBrowserServiceCompat.this.mCurConnection.rootHints == null) {
                return null;
            }
            return new Bundle(MediaBrowserServiceCompat.this.mCurConnection.rootHints);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public MediaSessionManager.RemoteUserInfo getCurrentBrowserInfo() {
            if (MediaBrowserServiceCompat.this.mCurConnection == null) {
                throw new IllegalStateException("This should be called inside of onGetRoot, onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
            }
            return MediaBrowserServiceCompat.this.mCurConnection.browserInfo;
        }
    }

    class MediaBrowserServiceImplApi23 extends MediaBrowserServiceImplApi21 implements MediaBrowserServiceCompatApi23.ServiceCompatProxy {
        MediaBrowserServiceImplApi23() {
            super();
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21, androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void onCreate() {
            this.mServiceObj = MediaBrowserServiceCompatApi23.createService(MediaBrowserServiceCompat.this, this);
            MediaBrowserServiceCompatApi21.onCreate(this.mServiceObj);
        }

        /* JADX INFO: renamed from: androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplApi23$1, reason: invalid class name */
        class AnonymousClass1 extends Result<MediaBrowserCompat.MediaItem> {
            final /* synthetic */ MediaBrowserServiceCompatApi21.ResultWrapper val$resultWrapper;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(Object obj, MediaBrowserServiceCompatApi21.ResultWrapper resultWrapper) {
                super(obj);
                this.val$resultWrapper = resultWrapper;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.media.MediaBrowserServiceCompat.Result
            public void onResultSent(MediaBrowserCompat.MediaItem mediaItem) {
                if (mediaItem == null) {
                    this.val$resultWrapper.sendResult(null);
                    return;
                }
                Parcel parcelObtain = Parcel.obtain();
                mediaItem.writeToParcel(parcelObtain, 0);
                this.val$resultWrapper.sendResult(parcelObtain);
            }

            @Override // androidx.media.MediaBrowserServiceCompat.Result
            public void detach() {
                this.val$resultWrapper.detach();
            }
        }

        @Override // androidx.media.MediaBrowserServiceCompatApi23.ServiceCompatProxy
        public void onLoadItem(String str, MediaBrowserServiceCompatApi21.ResultWrapper<Parcel> resultWrapper) {
            MediaBrowserServiceCompat.this.onLoadItem(str, new AnonymousClass1(str, resultWrapper));
        }
    }

    class MediaBrowserServiceImplApi26 extends MediaBrowserServiceImplApi23 implements MediaBrowserServiceCompatApi26.ServiceCompatProxy {
        MediaBrowserServiceImplApi26() {
            super();
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi23, androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21, androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public void onCreate() {
            this.mServiceObj = MediaBrowserServiceCompatApi26.createService(MediaBrowserServiceCompat.this, this);
            MediaBrowserServiceCompatApi21.onCreate(this.mServiceObj);
        }

        /* JADX INFO: renamed from: androidx.media.MediaBrowserServiceCompat$MediaBrowserServiceImplApi26$1, reason: invalid class name */
        class AnonymousClass1 extends Result<List<MediaBrowserCompat.MediaItem>> {
            final /* synthetic */ MediaBrowserServiceCompatApi26.ResultWrapper val$resultWrapper;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(Object obj, MediaBrowserServiceCompatApi26.ResultWrapper resultWrapper) {
                super(obj);
                this.val$resultWrapper = resultWrapper;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // androidx.media.MediaBrowserServiceCompat.Result
            public void onResultSent(List<MediaBrowserCompat.MediaItem> list) {
                ArrayList arrayList;
                if (list != null) {
                    arrayList = new ArrayList();
                    for (MediaBrowserCompat.MediaItem mediaItem : list) {
                        Parcel parcelObtain = Parcel.obtain();
                        mediaItem.writeToParcel(parcelObtain, 0);
                        arrayList.add(parcelObtain);
                    }
                } else {
                    arrayList = null;
                }
                this.val$resultWrapper.sendResult(arrayList, getFlags());
            }

            @Override // androidx.media.MediaBrowserServiceCompat.Result
            public void detach() {
                this.val$resultWrapper.detach();
            }
        }

        @Override // androidx.media.MediaBrowserServiceCompatApi26.ServiceCompatProxy
        public void onLoadChildren(String str, MediaBrowserServiceCompatApi26.ResultWrapper resultWrapper, Bundle bundle) {
            MediaBrowserServiceCompat.this.onLoadChildren(str, new AnonymousClass1(str, resultWrapper), bundle);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21, androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public Bundle getBrowserRootHints() {
            if (MediaBrowserServiceCompat.this.mCurConnection != null) {
                if (MediaBrowserServiceCompat.this.mCurConnection.rootHints == null) {
                    return null;
                }
                return new Bundle(MediaBrowserServiceCompat.this.mCurConnection.rootHints);
            }
            return MediaBrowserServiceCompatApi26.getBrowserRootHints(this.mServiceObj);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21
        void notifyChildrenChangedForFramework(String str, Bundle bundle) {
            if (bundle != null) {
                MediaBrowserServiceCompatApi26.notifyChildrenChanged(this.mServiceObj, str, bundle);
            } else {
                super.notifyChildrenChangedForFramework(str, bundle);
            }
        }
    }

    class MediaBrowserServiceImplApi28 extends MediaBrowserServiceImplApi26 {
        MediaBrowserServiceImplApi28() {
            super();
        }

        @Override // androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImplApi21, androidx.media.MediaBrowserServiceCompat.MediaBrowserServiceImpl
        public MediaSessionManager.RemoteUserInfo getCurrentBrowserInfo() {
            if (MediaBrowserServiceCompat.this.mCurConnection != null) {
                return MediaBrowserServiceCompat.this.mCurConnection.browserInfo;
            }
            return new MediaSessionManager.RemoteUserInfo(((MediaBrowserService) this.mServiceObj).getCurrentBrowserInfo());
        }
    }

    private final class ServiceHandler extends Handler {
        private final ServiceBinderImpl mServiceBinderImpl;

        ServiceHandler() {
            this.mServiceBinderImpl = MediaBrowserServiceCompat.this.new ServiceBinderImpl();
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Bundle data = message.getData();
            switch (message.what) {
                case 1:
                    Bundle bundle = data.getBundle(MediaBrowserProtocol.DATA_ROOT_HINTS);
                    MediaSessionCompat.ensureClassLoader(bundle);
                    this.mServiceBinderImpl.connect(data.getString(MediaBrowserProtocol.DATA_PACKAGE_NAME), data.getInt(MediaBrowserProtocol.DATA_CALLING_PID), data.getInt(MediaBrowserProtocol.DATA_CALLING_UID), bundle, new ServiceCallbacksCompat(message.replyTo));
                    break;
                case 2:
                    this.mServiceBinderImpl.disconnect(new ServiceCallbacksCompat(message.replyTo));
                    break;
                case 3:
                    Bundle bundle2 = data.getBundle(MediaBrowserProtocol.DATA_OPTIONS);
                    MediaSessionCompat.ensureClassLoader(bundle2);
                    this.mServiceBinderImpl.addSubscription(data.getString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID), BundleCompat.getBinder(data, MediaBrowserProtocol.DATA_CALLBACK_TOKEN), bundle2, new ServiceCallbacksCompat(message.replyTo));
                    break;
                case 4:
                    this.mServiceBinderImpl.removeSubscription(data.getString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID), BundleCompat.getBinder(data, MediaBrowserProtocol.DATA_CALLBACK_TOKEN), new ServiceCallbacksCompat(message.replyTo));
                    break;
                case 5:
                    this.mServiceBinderImpl.getMediaItem(data.getString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID), (ResultReceiver) data.getParcelable(MediaBrowserProtocol.DATA_RESULT_RECEIVER), new ServiceCallbacksCompat(message.replyTo));
                    break;
                case 6:
                    Bundle bundle3 = data.getBundle(MediaBrowserProtocol.DATA_ROOT_HINTS);
                    MediaSessionCompat.ensureClassLoader(bundle3);
                    this.mServiceBinderImpl.registerCallbacks(new ServiceCallbacksCompat(message.replyTo), data.getString(MediaBrowserProtocol.DATA_PACKAGE_NAME), data.getInt(MediaBrowserProtocol.DATA_CALLING_PID), data.getInt(MediaBrowserProtocol.DATA_CALLING_UID), bundle3);
                    break;
                case 7:
                    this.mServiceBinderImpl.unregisterCallbacks(new ServiceCallbacksCompat(message.replyTo));
                    break;
                case 8:
                    Bundle bundle4 = data.getBundle(MediaBrowserProtocol.DATA_SEARCH_EXTRAS);
                    MediaSessionCompat.ensureClassLoader(bundle4);
                    this.mServiceBinderImpl.search(data.getString(MediaBrowserProtocol.DATA_SEARCH_QUERY), bundle4, (ResultReceiver) data.getParcelable(MediaBrowserProtocol.DATA_RESULT_RECEIVER), new ServiceCallbacksCompat(message.replyTo));
                    break;
                case 9:
                    Bundle bundle5 = data.getBundle(MediaBrowserProtocol.DATA_CUSTOM_ACTION_EXTRAS);
                    MediaSessionCompat.ensureClassLoader(bundle5);
                    this.mServiceBinderImpl.sendCustomAction(data.getString(MediaBrowserProtocol.DATA_CUSTOM_ACTION), bundle5, (ResultReceiver) data.getParcelable(MediaBrowserProtocol.DATA_RESULT_RECEIVER), new ServiceCallbacksCompat(message.replyTo));
                    break;
                default:
                    Log.w(MediaBrowserServiceCompat.TAG, "Unhandled message: " + message + "\n  Service version: 2\n  Client version: " + message.arg1);
                    break;
            }
        }

        @Override // android.os.Handler
        public boolean sendMessageAtTime(Message message, long j) {
            Bundle data = message.getData();
            data.setClassLoader(MediaBrowserCompat.class.getClassLoader());
            data.putInt(MediaBrowserProtocol.DATA_CALLING_UID, Binder.getCallingUid());
            data.putInt(MediaBrowserProtocol.DATA_CALLING_PID, Binder.getCallingPid());
            return super.sendMessageAtTime(message, j);
        }

        public void postOrRun(Runnable runnable) {
            if (Thread.currentThread() == getLooper().getThread()) {
                runnable.run();
            } else {
                post(runnable);
            }
        }
    }

    private class ConnectionRecord implements IBinder.DeathRecipient {
        public final MediaSessionManager.RemoteUserInfo browserInfo;
        public final ServiceCallbacks callbacks;
        public final int pid;
        public final String pkg;
        public BrowserRoot root;
        public final Bundle rootHints;
        public final HashMap<String, List<Pair<IBinder, Bundle>>> subscriptions = new HashMap<>();
        public final int uid;

        ConnectionRecord(String str, int i, int i2, Bundle bundle, ServiceCallbacks serviceCallbacks) {
            this.pkg = str;
            this.pid = i;
            this.uid = i2;
            this.browserInfo = new MediaSessionManager.RemoteUserInfo(str, i, i2);
            this.rootHints = bundle;
            this.callbacks = serviceCallbacks;
        }

        /* JADX INFO: renamed from: androidx.media.MediaBrowserServiceCompat$ConnectionRecord$1, reason: invalid class name */
        class AnonymousClass1 implements Runnable {
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                MediaBrowserServiceCompat.this.mConnections.remove(ConnectionRecord.this.callbacks.asBinder());
            }
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            MediaBrowserServiceCompat.this.mHandler.post(new AnonymousClass1());
        }
    }

    public static class Result<T> {
        private final Object mDebug;
        private boolean mDetachCalled;
        private int mFlags;
        private boolean mSendErrorCalled;
        private boolean mSendProgressUpdateCalled;
        private boolean mSendResultCalled;

        void onResultSent(T t) {
        }

        Result(Object obj) {
            this.mDebug = obj;
        }

        public void sendResult(T t) {
            if (this.mSendResultCalled || this.mSendErrorCalled) {
                throw new IllegalStateException("sendResult() called when either sendResult() or sendError() had already been called for: " + this.mDebug);
            }
            this.mSendResultCalled = true;
            onResultSent(t);
        }

        public void sendProgressUpdate(Bundle bundle) {
            if (this.mSendResultCalled || this.mSendErrorCalled) {
                throw new IllegalStateException("sendProgressUpdate() called when either sendResult() or sendError() had already been called for: " + this.mDebug);
            }
            checkExtraFields(bundle);
            this.mSendProgressUpdateCalled = true;
            onProgressUpdateSent(bundle);
        }

        public void sendError(Bundle bundle) {
            if (this.mSendResultCalled || this.mSendErrorCalled) {
                throw new IllegalStateException("sendError() called when either sendResult() or sendError() had already been called for: " + this.mDebug);
            }
            this.mSendErrorCalled = true;
            onErrorSent(bundle);
        }

        public void detach() {
            if (this.mDetachCalled) {
                throw new IllegalStateException("detach() called when detach() had already been called for: " + this.mDebug);
            }
            if (this.mSendResultCalled) {
                throw new IllegalStateException("detach() called when sendResult() had already been called for: " + this.mDebug);
            }
            if (this.mSendErrorCalled) {
                throw new IllegalStateException("detach() called when sendError() had already been called for: " + this.mDebug);
            }
            this.mDetachCalled = true;
        }

        boolean isDone() {
            return this.mDetachCalled || this.mSendResultCalled || this.mSendErrorCalled;
        }

        void setFlags(int i) {
            this.mFlags = i;
        }

        int getFlags() {
            return this.mFlags;
        }

        void onProgressUpdateSent(Bundle bundle) {
            throw new UnsupportedOperationException("It is not supported to send an interim update for " + this.mDebug);
        }

        void onErrorSent(Bundle bundle) {
            throw new UnsupportedOperationException("It is not supported to send an error for " + this.mDebug);
        }

        private void checkExtraFields(Bundle bundle) {
            if (bundle != null && bundle.containsKey(MediaBrowserCompat.EXTRA_DOWNLOAD_PROGRESS)) {
                float f = bundle.getFloat(MediaBrowserCompat.EXTRA_DOWNLOAD_PROGRESS);
                if (f < -1.0E-5f || f > 1.00001f) {
                    throw new IllegalArgumentException("The value of the EXTRA_DOWNLOAD_PROGRESS field must be a float number within [0.0, 1.0].");
                }
            }
        }
    }

    private class ServiceBinderImpl {
        ServiceBinderImpl() {
        }

        public void connect(String str, int i, int i2, Bundle bundle, ServiceCallbacks serviceCallbacks) {
            if (!MediaBrowserServiceCompat.this.isValidPackage(str, i2)) {
                throw new IllegalArgumentException("Package/uid mismatch: uid=" + i2 + " package=" + str);
            }
            MediaBrowserServiceCompat.this.mHandler.postOrRun(new AnonymousClass1(serviceCallbacks, str, i, i2, bundle));
        }

        /* JADX INFO: renamed from: androidx.media.MediaBrowserServiceCompat$ServiceBinderImpl$1, reason: invalid class name */
        class AnonymousClass1 implements Runnable {
            final /* synthetic */ ServiceCallbacks val$callbacks;
            final /* synthetic */ int val$pid;
            final /* synthetic */ String val$pkg;
            final /* synthetic */ Bundle val$rootHints;
            final /* synthetic */ int val$uid;

            AnonymousClass1(ServiceCallbacks serviceCallbacks, String str, int i, int i2, Bundle bundle) {
                this.val$callbacks = serviceCallbacks;
                this.val$pkg = str;
                this.val$pid = i;
                this.val$uid = i2;
                this.val$rootHints = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                IBinder iBinderAsBinder = this.val$callbacks.asBinder();
                MediaBrowserServiceCompat.this.mConnections.remove(iBinderAsBinder);
                ConnectionRecord connectionRecord = MediaBrowserServiceCompat.this.new ConnectionRecord(this.val$pkg, this.val$pid, this.val$uid, this.val$rootHints, this.val$callbacks);
                MediaBrowserServiceCompat.this.mCurConnection = connectionRecord;
                connectionRecord.root = MediaBrowserServiceCompat.this.onGetRoot(this.val$pkg, this.val$uid, this.val$rootHints);
                MediaBrowserServiceCompat.this.mCurConnection = null;
                if (connectionRecord.root == null) {
                    Log.i(MediaBrowserServiceCompat.TAG, "No root for client " + this.val$pkg + " from service " + getClass().getName());
                    try {
                        this.val$callbacks.onConnectFailed();
                        return;
                    } catch (RemoteException unused) {
                        Log.w(MediaBrowserServiceCompat.TAG, "Calling onConnectFailed() failed. Ignoring. pkg=" + this.val$pkg);
                        return;
                    }
                }
                try {
                    MediaBrowserServiceCompat.this.mConnections.put(iBinderAsBinder, connectionRecord);
                    iBinderAsBinder.linkToDeath(connectionRecord, 0);
                    if (MediaBrowserServiceCompat.this.mSession != null) {
                        this.val$callbacks.onConnect(connectionRecord.root.getRootId(), MediaBrowserServiceCompat.this.mSession, connectionRecord.root.getExtras());
                    }
                } catch (RemoteException unused2) {
                    Log.w(MediaBrowserServiceCompat.TAG, "Calling onConnect() failed. Dropping client. pkg=" + this.val$pkg);
                    MediaBrowserServiceCompat.this.mConnections.remove(iBinderAsBinder);
                }
            }
        }

        /* JADX INFO: renamed from: androidx.media.MediaBrowserServiceCompat$ServiceBinderImpl$2, reason: invalid class name */
        class AnonymousClass2 implements Runnable {
            final /* synthetic */ ServiceCallbacks val$callbacks;

            AnonymousClass2(ServiceCallbacks serviceCallbacks) {
                this.val$callbacks = serviceCallbacks;
            }

            @Override // java.lang.Runnable
            public void run() {
                ConnectionRecord connectionRecordRemove = MediaBrowserServiceCompat.this.mConnections.remove(this.val$callbacks.asBinder());
                if (connectionRecordRemove != null) {
                    connectionRecordRemove.callbacks.asBinder().unlinkToDeath(connectionRecordRemove, 0);
                }
            }
        }

        public void disconnect(ServiceCallbacks serviceCallbacks) {
            MediaBrowserServiceCompat.this.mHandler.postOrRun(new AnonymousClass2(serviceCallbacks));
        }

        /* JADX INFO: renamed from: androidx.media.MediaBrowserServiceCompat$ServiceBinderImpl$3, reason: invalid class name */
        class AnonymousClass3 implements Runnable {
            final /* synthetic */ ServiceCallbacks val$callbacks;
            final /* synthetic */ String val$id;
            final /* synthetic */ Bundle val$options;
            final /* synthetic */ IBinder val$token;

            AnonymousClass3(ServiceCallbacks serviceCallbacks, String str, IBinder iBinder, Bundle bundle) {
                this.val$callbacks = serviceCallbacks;
                this.val$id = str;
                this.val$token = iBinder;
                this.val$options = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                ConnectionRecord connectionRecord = MediaBrowserServiceCompat.this.mConnections.get(this.val$callbacks.asBinder());
                if (connectionRecord == null) {
                    Log.w(MediaBrowserServiceCompat.TAG, "addSubscription for callback that isn't registered id=" + this.val$id);
                } else {
                    MediaBrowserServiceCompat.this.addSubscription(this.val$id, connectionRecord, this.val$token, this.val$options);
                }
            }
        }

        public void addSubscription(String str, IBinder iBinder, Bundle bundle, ServiceCallbacks serviceCallbacks) {
            MediaBrowserServiceCompat.this.mHandler.postOrRun(new AnonymousClass3(serviceCallbacks, str, iBinder, bundle));
        }

        /* JADX INFO: renamed from: androidx.media.MediaBrowserServiceCompat$ServiceBinderImpl$4, reason: invalid class name */
        class AnonymousClass4 implements Runnable {
            final /* synthetic */ ServiceCallbacks val$callbacks;
            final /* synthetic */ String val$id;
            final /* synthetic */ IBinder val$token;

            AnonymousClass4(ServiceCallbacks serviceCallbacks, String str, IBinder iBinder) {
                this.val$callbacks = serviceCallbacks;
                this.val$id = str;
                this.val$token = iBinder;
            }

            @Override // java.lang.Runnable
            public void run() {
                ConnectionRecord connectionRecord = MediaBrowserServiceCompat.this.mConnections.get(this.val$callbacks.asBinder());
                if (connectionRecord == null) {
                    Log.w(MediaBrowserServiceCompat.TAG, "removeSubscription for callback that isn't registered id=" + this.val$id);
                } else {
                    if (MediaBrowserServiceCompat.this.removeSubscription(this.val$id, connectionRecord, this.val$token)) {
                        return;
                    }
                    Log.w(MediaBrowserServiceCompat.TAG, "removeSubscription called for " + this.val$id + " which is not subscribed");
                }
            }
        }

        public void removeSubscription(String str, IBinder iBinder, ServiceCallbacks serviceCallbacks) {
            MediaBrowserServiceCompat.this.mHandler.postOrRun(new AnonymousClass4(serviceCallbacks, str, iBinder));
        }

        public void getMediaItem(String str, ResultReceiver resultReceiver, ServiceCallbacks serviceCallbacks) {
            if (TextUtils.isEmpty(str) || resultReceiver == null) {
                return;
            }
            MediaBrowserServiceCompat.this.mHandler.postOrRun(new AnonymousClass5(serviceCallbacks, str, resultReceiver));
        }

        /* JADX INFO: renamed from: androidx.media.MediaBrowserServiceCompat$ServiceBinderImpl$5, reason: invalid class name */
        class AnonymousClass5 implements Runnable {
            final /* synthetic */ ServiceCallbacks val$callbacks;
            final /* synthetic */ String val$mediaId;
            final /* synthetic */ ResultReceiver val$receiver;

            AnonymousClass5(ServiceCallbacks serviceCallbacks, String str, ResultReceiver resultReceiver) {
                this.val$callbacks = serviceCallbacks;
                this.val$mediaId = str;
                this.val$receiver = resultReceiver;
            }

            @Override // java.lang.Runnable
            public void run() {
                ConnectionRecord connectionRecord = MediaBrowserServiceCompat.this.mConnections.get(this.val$callbacks.asBinder());
                if (connectionRecord == null) {
                    Log.w(MediaBrowserServiceCompat.TAG, "getMediaItem for callback that isn't registered id=" + this.val$mediaId);
                } else {
                    MediaBrowserServiceCompat.this.performLoadItem(this.val$mediaId, connectionRecord, this.val$receiver);
                }
            }
        }

        /* JADX INFO: renamed from: androidx.media.MediaBrowserServiceCompat$ServiceBinderImpl$6, reason: invalid class name */
        class AnonymousClass6 implements Runnable {
            final /* synthetic */ ServiceCallbacks val$callbacks;
            final /* synthetic */ int val$pid;
            final /* synthetic */ String val$pkg;
            final /* synthetic */ Bundle val$rootHints;
            final /* synthetic */ int val$uid;

            AnonymousClass6(ServiceCallbacks serviceCallbacks, String str, int i, int i2, Bundle bundle) {
                this.val$callbacks = serviceCallbacks;
                this.val$pkg = str;
                this.val$pid = i;
                this.val$uid = i2;
                this.val$rootHints = bundle;
            }

            @Override // java.lang.Runnable
            public void run() {
                IBinder iBinderAsBinder = this.val$callbacks.asBinder();
                MediaBrowserServiceCompat.this.mConnections.remove(iBinderAsBinder);
                ConnectionRecord connectionRecord = MediaBrowserServiceCompat.this.new ConnectionRecord(this.val$pkg, this.val$pid, this.val$uid, this.val$rootHints, this.val$callbacks);
                MediaBrowserServiceCompat.this.mConnections.put(iBinderAsBinder, connectionRecord);
                try {
                    iBinderAsBinder.linkToDeath(connectionRecord, 0);
                } catch (RemoteException unused) {
                    Log.w(MediaBrowserServiceCompat.TAG, "IBinder is already dead.");
                }
            }
        }

        public void registerCallbacks(ServiceCallbacks serviceCallbacks, String str, int i, int i2, Bundle bundle) {
            MediaBrowserServiceCompat.this.mHandler.postOrRun(new AnonymousClass6(serviceCallbacks, str, i, i2, bundle));
        }

        /* JADX INFO: renamed from: androidx.media.MediaBrowserServiceCompat$ServiceBinderImpl$7, reason: invalid class name */
        class AnonymousClass7 implements Runnable {
            final /* synthetic */ ServiceCallbacks val$callbacks;

            AnonymousClass7(ServiceCallbacks serviceCallbacks) {
                this.val$callbacks = serviceCallbacks;
            }

            @Override // java.lang.Runnable
            public void run() {
                IBinder iBinderAsBinder = this.val$callbacks.asBinder();
                ConnectionRecord connectionRecordRemove = MediaBrowserServiceCompat.this.mConnections.remove(iBinderAsBinder);
                if (connectionRecordRemove != null) {
                    iBinderAsBinder.unlinkToDeath(connectionRecordRemove, 0);
                }
            }
        }

        public void unregisterCallbacks(ServiceCallbacks serviceCallbacks) {
            MediaBrowserServiceCompat.this.mHandler.postOrRun(new AnonymousClass7(serviceCallbacks));
        }

        public void search(String str, Bundle bundle, ResultReceiver resultReceiver, ServiceCallbacks serviceCallbacks) {
            if (TextUtils.isEmpty(str) || resultReceiver == null) {
                return;
            }
            MediaBrowserServiceCompat.this.mHandler.postOrRun(new AnonymousClass8(serviceCallbacks, str, bundle, resultReceiver));
        }

        /* JADX INFO: renamed from: androidx.media.MediaBrowserServiceCompat$ServiceBinderImpl$8, reason: invalid class name */
        class AnonymousClass8 implements Runnable {
            final /* synthetic */ ServiceCallbacks val$callbacks;
            final /* synthetic */ Bundle val$extras;
            final /* synthetic */ String val$query;
            final /* synthetic */ ResultReceiver val$receiver;

            AnonymousClass8(ServiceCallbacks serviceCallbacks, String str, Bundle bundle, ResultReceiver resultReceiver) {
                this.val$callbacks = serviceCallbacks;
                this.val$query = str;
                this.val$extras = bundle;
                this.val$receiver = resultReceiver;
            }

            @Override // java.lang.Runnable
            public void run() {
                ConnectionRecord connectionRecord = MediaBrowserServiceCompat.this.mConnections.get(this.val$callbacks.asBinder());
                if (connectionRecord == null) {
                    Log.w(MediaBrowserServiceCompat.TAG, "search for callback that isn't registered query=" + this.val$query);
                } else {
                    MediaBrowserServiceCompat.this.performSearch(this.val$query, this.val$extras, connectionRecord, this.val$receiver);
                }
            }
        }

        public void sendCustomAction(String str, Bundle bundle, ResultReceiver resultReceiver, ServiceCallbacks serviceCallbacks) {
            if (TextUtils.isEmpty(str) || resultReceiver == null) {
                return;
            }
            MediaBrowserServiceCompat.this.mHandler.postOrRun(new AnonymousClass9(serviceCallbacks, str, bundle, resultReceiver));
        }

        /* JADX INFO: renamed from: androidx.media.MediaBrowserServiceCompat$ServiceBinderImpl$9, reason: invalid class name */
        class AnonymousClass9 implements Runnable {
            final /* synthetic */ String val$action;
            final /* synthetic */ ServiceCallbacks val$callbacks;
            final /* synthetic */ Bundle val$extras;
            final /* synthetic */ ResultReceiver val$receiver;

            AnonymousClass9(ServiceCallbacks serviceCallbacks, String str, Bundle bundle, ResultReceiver resultReceiver) {
                this.val$callbacks = serviceCallbacks;
                this.val$action = str;
                this.val$extras = bundle;
                this.val$receiver = resultReceiver;
            }

            @Override // java.lang.Runnable
            public void run() {
                ConnectionRecord connectionRecord = MediaBrowserServiceCompat.this.mConnections.get(this.val$callbacks.asBinder());
                if (connectionRecord == null) {
                    Log.w(MediaBrowserServiceCompat.TAG, "sendCustomAction for callback that isn't registered action=" + this.val$action + ", extras=" + this.val$extras);
                } else {
                    MediaBrowserServiceCompat.this.performCustomAction(this.val$action, this.val$extras, connectionRecord, this.val$receiver);
                }
            }
        }
    }

    private static class ServiceCallbacksCompat implements ServiceCallbacks {
        final Messenger mCallbacks;

        ServiceCallbacksCompat(Messenger messenger) {
            this.mCallbacks = messenger;
        }

        @Override // androidx.media.MediaBrowserServiceCompat.ServiceCallbacks
        public IBinder asBinder() {
            return this.mCallbacks.getBinder();
        }

        @Override // androidx.media.MediaBrowserServiceCompat.ServiceCallbacks
        public void onConnect(String str, MediaSessionCompat.Token token, Bundle bundle) throws RemoteException {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putInt(MediaBrowserProtocol.EXTRA_SERVICE_VERSION, 2);
            Bundle bundle2 = new Bundle();
            bundle2.putString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID, str);
            bundle2.putParcelable(MediaBrowserProtocol.DATA_MEDIA_SESSION_TOKEN, token);
            bundle2.putBundle(MediaBrowserProtocol.DATA_ROOT_HINTS, bundle);
            sendRequest(1, bundle2);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.ServiceCallbacks
        public void onConnectFailed() throws RemoteException {
            sendRequest(2, null);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.ServiceCallbacks
        public void onLoadChildren(String str, List<MediaBrowserCompat.MediaItem> list, Bundle bundle, Bundle bundle2) throws RemoteException {
            Bundle bundle3 = new Bundle();
            bundle3.putString(MediaBrowserProtocol.DATA_MEDIA_ITEM_ID, str);
            bundle3.putBundle(MediaBrowserProtocol.DATA_OPTIONS, bundle);
            bundle3.putBundle(MediaBrowserProtocol.DATA_NOTIFY_CHILDREN_CHANGED_OPTIONS, bundle2);
            if (list != null) {
                bundle3.putParcelableArrayList(MediaBrowserProtocol.DATA_MEDIA_ITEM_LIST, list instanceof ArrayList ? (ArrayList) list : new ArrayList<>(list));
            }
            sendRequest(3, bundle3);
        }

        private void sendRequest(int i, Bundle bundle) throws RemoteException {
            Message messageObtain = Message.obtain();
            messageObtain.what = i;
            messageObtain.arg1 = 2;
            messageObtain.setData(bundle);
            this.mCallbacks.send(messageObtain);
        }
    }

    public void attachToBaseContext(Context context) {
        attachBaseContext(context);
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= 28) {
            this.mImpl = new MediaBrowserServiceImplApi28();
        } else {
            this.mImpl = new MediaBrowserServiceImplApi26();
        }
        this.mImpl.onCreate();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.mImpl.onBind(intent);
    }

    public void onLoadChildren(String str, Result<List<MediaBrowserCompat.MediaItem>> result, Bundle bundle) {
        result.setFlags(1);
        onLoadChildren(str, result);
    }

    public void onLoadItem(String str, Result<MediaBrowserCompat.MediaItem> result) {
        result.setFlags(2);
        result.sendResult(null);
    }

    public void onSearch(String str, Bundle bundle, Result<List<MediaBrowserCompat.MediaItem>> result) {
        result.setFlags(4);
        result.sendResult(null);
    }

    public void onCustomAction(String str, Bundle bundle, Result<Bundle> result) {
        result.sendError(null);
    }

    public void setSessionToken(MediaSessionCompat.Token token) {
        if (token == null) {
            throw new IllegalArgumentException("Session token may not be null.");
        }
        if (this.mSession != null) {
            throw new IllegalStateException("The session token has already been set.");
        }
        this.mSession = token;
        this.mImpl.setSessionToken(token);
    }

    public MediaSessionCompat.Token getSessionToken() {
        return this.mSession;
    }

    public final Bundle getBrowserRootHints() {
        return this.mImpl.getBrowserRootHints();
    }

    public final MediaSessionManager.RemoteUserInfo getCurrentBrowserInfo() {
        return this.mImpl.getCurrentBrowserInfo();
    }

    public void notifyChildrenChanged(String str) {
        if (str == null) {
            throw new IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
        }
        this.mImpl.notifyChildrenChanged(str, null);
    }

    public void notifyChildrenChanged(String str, Bundle bundle) {
        if (str == null) {
            throw new IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
        }
        if (bundle == null) {
            throw new IllegalArgumentException("options cannot be null in notifyChildrenChanged");
        }
        this.mImpl.notifyChildrenChanged(str, bundle);
    }

    public void notifyChildrenChanged(MediaSessionManager.RemoteUserInfo remoteUserInfo, String str, Bundle bundle) {
        if (remoteUserInfo == null) {
            throw new IllegalArgumentException("remoteUserInfo cannot be null in notifyChildrenChanged");
        }
        if (str == null) {
            throw new IllegalArgumentException("parentId cannot be null in notifyChildrenChanged");
        }
        if (bundle == null) {
            throw new IllegalArgumentException("options cannot be null in notifyChildrenChanged");
        }
        this.mImpl.notifyChildrenChanged(remoteUserInfo, str, bundle);
    }

    boolean isValidPackage(String str, int i) {
        if (str == null) {
            return false;
        }
        for (String str2 : getPackageManager().getPackagesForUid(i)) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    void addSubscription(String str, ConnectionRecord connectionRecord, IBinder iBinder, Bundle bundle) {
        List<Pair<IBinder, Bundle>> arrayList = connectionRecord.subscriptions.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        for (Pair<IBinder, Bundle> pair : arrayList) {
            if (iBinder == pair.first && MediaBrowserCompatUtils.areSameOptions(bundle, pair.second)) {
                return;
            }
        }
        arrayList.add(new Pair<>(iBinder, bundle));
        connectionRecord.subscriptions.put(str, arrayList);
        performLoadChildren(str, connectionRecord, bundle, null);
        this.mCurConnection = connectionRecord;
        onSubscribe(str, bundle);
        this.mCurConnection = null;
    }

    boolean removeSubscription(String str, ConnectionRecord connectionRecord, IBinder iBinder) {
        boolean z = false;
        try {
            if (iBinder == null) {
                boolean z2 = connectionRecord.subscriptions.remove(str) != null;
                this.mCurConnection = connectionRecord;
                onUnsubscribe(str);
                this.mCurConnection = null;
                return z2;
            }
            List<Pair<IBinder, Bundle>> list = connectionRecord.subscriptions.get(str);
            if (list != null) {
                Iterator<Pair<IBinder, Bundle>> it = list.iterator();
                while (it.hasNext()) {
                    if (iBinder == it.next().first) {
                        it.remove();
                        z = true;
                    }
                }
                if (list.size() == 0) {
                    connectionRecord.subscriptions.remove(str);
                }
            }
            this.mCurConnection = connectionRecord;
            onUnsubscribe(str);
            this.mCurConnection = null;
            return z;
        } catch (Throwable th) {
            this.mCurConnection = connectionRecord;
            onUnsubscribe(str);
            this.mCurConnection = null;
            throw th;
        }
    }

    /* JADX INFO: renamed from: androidx.media.MediaBrowserServiceCompat$1, reason: invalid class name */
    class AnonymousClass1 extends Result<List<MediaBrowserCompat.MediaItem>> {
        final /* synthetic */ ConnectionRecord val$connection;
        final /* synthetic */ Bundle val$notifyChildrenChangedOptions;
        final /* synthetic */ String val$parentId;
        final /* synthetic */ Bundle val$subscribeOptions;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Object obj, ConnectionRecord connectionRecord, String str, Bundle bundle, Bundle bundle2) {
            super(obj);
            this.val$connection = connectionRecord;
            this.val$parentId = str;
            this.val$subscribeOptions = bundle;
            this.val$notifyChildrenChangedOptions = bundle2;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.media.MediaBrowserServiceCompat.Result
        public void onResultSent(List<MediaBrowserCompat.MediaItem> list) {
            if (MediaBrowserServiceCompat.this.mConnections.get(this.val$connection.callbacks.asBinder()) != this.val$connection) {
                if (MediaBrowserServiceCompat.DEBUG) {
                    Log.d(MediaBrowserServiceCompat.TAG, "Not sending onLoadChildren result for connection that has been disconnected. pkg=" + this.val$connection.pkg + " id=" + this.val$parentId);
                }
            } else {
                if ((getFlags() & 1) != 0) {
                    list = MediaBrowserServiceCompat.this.applyOptions(list, this.val$subscribeOptions);
                }
                try {
                    this.val$connection.callbacks.onLoadChildren(this.val$parentId, list, this.val$subscribeOptions, this.val$notifyChildrenChangedOptions);
                } catch (RemoteException unused) {
                    Log.w(MediaBrowserServiceCompat.TAG, "Calling onLoadChildren() failed for id=" + this.val$parentId + " package=" + this.val$connection.pkg);
                }
            }
        }
    }

    void performLoadChildren(String str, ConnectionRecord connectionRecord, Bundle bundle, Bundle bundle2) {
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(str, connectionRecord, str, bundle, bundle2);
        this.mCurConnection = connectionRecord;
        if (bundle == null) {
            onLoadChildren(str, anonymousClass1);
        } else {
            onLoadChildren(str, anonymousClass1, bundle);
        }
        this.mCurConnection = null;
        if (!anonymousClass1.isDone()) {
            throw new IllegalStateException("onLoadChildren must call detach() or sendResult() before returning for package=" + connectionRecord.pkg + " id=" + str);
        }
    }

    List<MediaBrowserCompat.MediaItem> applyOptions(List<MediaBrowserCompat.MediaItem> list, Bundle bundle) {
        if (list == null) {
            return null;
        }
        int i = bundle.getInt(MediaBrowserCompat.EXTRA_PAGE, -1);
        int i2 = bundle.getInt(MediaBrowserCompat.EXTRA_PAGE_SIZE, -1);
        if (i == -1 && i2 == -1) {
            return list;
        }
        int i3 = i2 * i;
        int size = i3 + i2;
        if (i < 0 || i2 < 1 || i3 >= list.size()) {
            return Collections.emptyList();
        }
        if (size > list.size()) {
            size = list.size();
        }
        return list.subList(i3, size);
    }

    /* JADX INFO: renamed from: androidx.media.MediaBrowserServiceCompat$2, reason: invalid class name */
    class AnonymousClass2 extends Result<MediaBrowserCompat.MediaItem> {
        final /* synthetic */ ResultReceiver val$receiver;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Object obj, ResultReceiver resultReceiver) {
            super(obj);
            this.val$receiver = resultReceiver;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.media.MediaBrowserServiceCompat.Result
        public void onResultSent(MediaBrowserCompat.MediaItem mediaItem) {
            if ((getFlags() & 2) != 0) {
                this.val$receiver.send(-1, null);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putParcelable(MediaBrowserServiceCompat.KEY_MEDIA_ITEM, mediaItem);
            this.val$receiver.send(0, bundle);
        }
    }

    void performLoadItem(String str, ConnectionRecord connectionRecord, ResultReceiver resultReceiver) {
        AnonymousClass2 anonymousClass2 = new AnonymousClass2(str, resultReceiver);
        this.mCurConnection = connectionRecord;
        onLoadItem(str, anonymousClass2);
        this.mCurConnection = null;
        if (!anonymousClass2.isDone()) {
            throw new IllegalStateException("onLoadItem must call detach() or sendResult() before returning for id=" + str);
        }
    }

    /* JADX INFO: renamed from: androidx.media.MediaBrowserServiceCompat$3, reason: invalid class name */
    class AnonymousClass3 extends Result<List<MediaBrowserCompat.MediaItem>> {
        final /* synthetic */ ResultReceiver val$receiver;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(Object obj, ResultReceiver resultReceiver) {
            super(obj);
            this.val$receiver = resultReceiver;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.media.MediaBrowserServiceCompat.Result
        public void onResultSent(List<MediaBrowserCompat.MediaItem> list) {
            if ((getFlags() & 4) != 0 || list == null) {
                this.val$receiver.send(-1, null);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putParcelableArray(MediaBrowserServiceCompat.KEY_SEARCH_RESULTS, (Parcelable[]) list.toArray(new MediaBrowserCompat.MediaItem[0]));
            this.val$receiver.send(0, bundle);
        }
    }

    void performSearch(String str, Bundle bundle, ConnectionRecord connectionRecord, ResultReceiver resultReceiver) {
        AnonymousClass3 anonymousClass3 = new AnonymousClass3(str, resultReceiver);
        this.mCurConnection = connectionRecord;
        onSearch(str, bundle, anonymousClass3);
        this.mCurConnection = null;
        if (!anonymousClass3.isDone()) {
            throw new IllegalStateException("onSearch must call detach() or sendResult() before returning for query=" + str);
        }
    }

    /* JADX INFO: renamed from: androidx.media.MediaBrowserServiceCompat$4, reason: invalid class name */
    class AnonymousClass4 extends Result<Bundle> {
        final /* synthetic */ ResultReceiver val$receiver;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(Object obj, ResultReceiver resultReceiver) {
            super(obj);
            this.val$receiver = resultReceiver;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // androidx.media.MediaBrowserServiceCompat.Result
        public void onResultSent(Bundle bundle) {
            this.val$receiver.send(0, bundle);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.Result
        void onProgressUpdateSent(Bundle bundle) {
            this.val$receiver.send(1, bundle);
        }

        @Override // androidx.media.MediaBrowserServiceCompat.Result
        void onErrorSent(Bundle bundle) {
            this.val$receiver.send(-1, bundle);
        }
    }

    void performCustomAction(String str, Bundle bundle, ConnectionRecord connectionRecord, ResultReceiver resultReceiver) {
        AnonymousClass4 anonymousClass4 = new AnonymousClass4(str, resultReceiver);
        this.mCurConnection = connectionRecord;
        onCustomAction(str, bundle, anonymousClass4);
        this.mCurConnection = null;
        if (!anonymousClass4.isDone()) {
            throw new IllegalStateException("onCustomAction must call detach() or sendResult() or sendError() before returning for action=" + str + " extras=" + bundle);
        }
    }

    public static final class BrowserRoot {
        public static final String EXTRA_OFFLINE = "android.service.media.extra.OFFLINE";
        public static final String EXTRA_RECENT = "android.service.media.extra.RECENT";
        public static final String EXTRA_SUGGESTED = "android.service.media.extra.SUGGESTED";

        @Deprecated
        public static final String EXTRA_SUGGESTION_KEYWORDS = "android.service.media.extra.SUGGESTION_KEYWORDS";
        private final Bundle mExtras;
        private final String mRootId;

        public BrowserRoot(String str, Bundle bundle) {
            if (str == null) {
                throw new IllegalArgumentException("The root id in BrowserRoot cannot be null. Use null for BrowserRoot instead.");
            }
            this.mRootId = str;
            this.mExtras = bundle;
        }

        public String getRootId() {
            return this.mRootId;
        }

        public Bundle getExtras() {
            return this.mExtras;
        }
    }
}
