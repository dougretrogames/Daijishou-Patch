package com.magneticchen.daijishou.data.live;

import android.content.SharedPreferences;
import androidx.lifecycle.LiveData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SharedPreferenceLiveData.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\b&\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\bJ\u000f\u0010\u0010\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0002\u0010\u0011J!\u0010\u0012\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00018\u0000H&¢\u0006\u0002\u0010\u0013J\b\u0010\u0014\u001a\u00020\u0015H\u0014J\b\u0010\u0016\u001a\u00020\u0015H\u0014R\u0012\u0010\u0007\u001a\u0004\u0018\u00018\u0000X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0017"}, d2 = {"Lcom/magneticchen/daijishou/data/live/SharedPreferenceLiveData;", "T", "Landroidx/lifecycle/LiveData;", "sharedPrefs", "Landroid/content/SharedPreferences;", "key", "", "defValue", "(Landroid/content/SharedPreferences;Ljava/lang/String;Ljava/lang/Object;)V", "Ljava/lang/Object;", "getKey", "()Ljava/lang/String;", "preferenceChangeListener", "Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;", "getSharedPrefs", "()Landroid/content/SharedPreferences;", "getValue", "()Ljava/lang/Object;", "getValueFromPreferences", "(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;", "onActive", "", "onInactive", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class SharedPreferenceLiveData<T> extends LiveData<T> {
    private final T defValue;
    private final String key;
    private final SharedPreferences.OnSharedPreferenceChangeListener preferenceChangeListener;
    private final SharedPreferences sharedPrefs;

    public abstract T getValueFromPreferences(String str, T t);

    public final SharedPreferences getSharedPrefs() {
        return this.sharedPrefs;
    }

    public final String getKey() {
        return this.key;
    }

    public SharedPreferenceLiveData(SharedPreferences sharedPrefs, String key, T t) {
        Intrinsics.checkNotNullParameter(sharedPrefs, "sharedPrefs");
        Intrinsics.checkNotNullParameter(key, "key");
        this.sharedPrefs = sharedPrefs;
        this.key = key;
        this.defValue = t;
        this.preferenceChangeListener = new SharedPreferences.OnSharedPreferenceChangeListener() { // from class: com.magneticchen.daijishou.data.live.SharedPreferenceLiveData$$ExternalSyntheticLambda0
            @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
            public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
                SharedPreferenceLiveData.preferenceChangeListener$lambda$0(SharedPreferenceLiveData.this, sharedPreferences, str);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void preferenceChangeListener$lambda$0(SharedPreferenceLiveData this$0, SharedPreferences sharedPreferences, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (Intrinsics.areEqual(str, this$0.key)) {
            Intrinsics.checkNotNull(str);
            this$0.setValue(this$0.getValueFromPreferences(str, this$0.defValue));
        }
    }

    public T getValue() {
        T t = (T) super.getValue();
        return t == null ? getValueFromPreferences(this.key, this.defValue) : t;
    }

    protected void onActive() {
        super.onActive();
        setValue(getValueFromPreferences(this.key, this.defValue));
        this.sharedPrefs.registerOnSharedPreferenceChangeListener(this.preferenceChangeListener);
    }

    protected void onInactive() {
        this.sharedPrefs.unregisterOnSharedPreferenceChangeListener(this.preferenceChangeListener);
        super.onInactive();
    }
}
