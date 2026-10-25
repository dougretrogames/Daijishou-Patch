package com.magneticchen.daijishou.view_models;

import android.app.Application;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.magneticchen.daijishou.view_models.abstract_view_models.DaijishouAndroidViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SettingsViewModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007R\u0016\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/magneticchen/daijishou/view_models/SettingsViewModel;", "Lcom/magneticchen/daijishou/view_models/abstract_view_models/DaijishouAndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "_titleLiveData", "Landroidx/lifecycle/MutableLiveData;", "", "titleLiveData", "Landroidx/lifecycle/LiveData;", "getTitleLiveData", "()Landroidx/lifecycle/LiveData;", "setTitle", "", "newTitle", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class SettingsViewModel extends DaijishouAndroidViewModel {
    private final MutableLiveData<String> _titleLiveData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsViewModel(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        this._titleLiveData = new MutableLiveData<>();
    }

    public final LiveData<String> getTitleLiveData() {
        return this._titleLiveData;
    }

    public final void setTitle(String newTitle) {
        this._titleLiveData.setValue(newTitle);
    }
}
