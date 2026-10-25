package com.magneticchen.daijishou.daijishou_widget.abstract_widget_classes;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.repositories.DaijishouWidgetRepository;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WidgetViewModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0005X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/magneticchen/daijishou/daijishou_widget/abstract_widget_classes/WidgetViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "Lcom/magneticchen/daijishou/DaijishouApplication;", "getApplication", "()Lcom/magneticchen/daijishou/DaijishouApplication;", "daijishouWidgetRepository", "Lcom/magneticchen/daijishou/repositories/DaijishouWidgetRepository;", "getDaijishouWidgetRepository", "()Lcom/magneticchen/daijishou/repositories/DaijishouWidgetRepository;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class WidgetViewModel extends AndroidViewModel {
    private final DaijishouApplication application;
    private final DaijishouWidgetRepository daijishouWidgetRepository;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetViewModel(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        DaijishouApplication daijishouApplication = (DaijishouApplication) application;
        this.application = daijishouApplication;
        this.daijishouWidgetRepository = daijishouApplication.getDaijishouWidgetRepository();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.AndroidViewModel
    public final DaijishouApplication getApplication() {
        return this.application;
    }

    protected final DaijishouWidgetRepository getDaijishouWidgetRepository() {
        return this.daijishouWidgetRepository;
    }
}
