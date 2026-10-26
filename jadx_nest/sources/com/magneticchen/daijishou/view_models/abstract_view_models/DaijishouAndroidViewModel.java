package com.magneticchen.daijishou.view_models.abstract_view_models;

import android.app.Application;
import android.content.SharedPreferences;
import androidx.lifecycle.AndroidViewModel;
import com.magneticchen.daijishou.DaijishouApplication;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.Json;

/* INFO: compiled from: DaijishouAndroidViewModel.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/magneticchen/daijishou/view_models/abstract_view_models/DaijishouAndroidViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "Lcom/magneticchen/daijishou/DaijishouApplication;", "getApplication", "()Lcom/magneticchen/daijishou/DaijishouApplication;", "defaultSharedPreferences", "Landroid/content/SharedPreferences;", "getDefaultSharedPreferences", "()Landroid/content/SharedPreferences;", "weakJson", "Lkotlinx/serialization/json/Json;", "getWeakJson", "()Lkotlinx/serialization/json/Json;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class DaijishouAndroidViewModel extends AndroidViewModel {
    private final DaijishouApplication application;
    private final SharedPreferences defaultSharedPreferences;
    private final Json weakJson;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DaijishouAndroidViewModel(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        DaijishouApplication daijishouApplication = (DaijishouApplication) application;
        this.application = daijishouApplication;
        this.defaultSharedPreferences = daijishouApplication.getDefaultSharedPreferences();
        this.weakJson = daijishouApplication.getWeakJson();
    }

    @Override // androidx.lifecycle.AndroidViewModel
    public final DaijishouApplication getApplication() {
        return this.application;
    }

    public final SharedPreferences getDefaultSharedPreferences() {
        return this.defaultSharedPreferences;
    }

    public final Json getWeakJson() {
        return this.weakJson;
    }
}
