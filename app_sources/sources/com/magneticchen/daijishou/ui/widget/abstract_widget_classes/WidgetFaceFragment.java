package com.magneticchen.daijishou.ui.widget.abstract_widget_classes;

import android.content.Context;
import android.os.Bundle;
import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.data.db.repositories.DaijishouLibraryRepository;
import com.magneticchen.daijishou.data.db.repositories.DaijishouWidgetRepository;
import com.magneticchen.daijishou.ui.fragments.p000abstract.DaijishouFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WidgetFaceFragment.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0004J\b\u0010\u001e\u001a\u00020\u001cH\u0016J\u0012\u0010\u001f\u001a\u00020\u001c2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010\"\u001a\u00020\u001cH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006#"}, d2 = {"Lcom/magneticchen/daijishou/ui/widget/abstract_widget_classes/WidgetFaceFragment;", "Lcom/magneticchen/daijishou/ui/fragments/abstract/DaijishouFragment;", "()V", "application", "Lcom/magneticchen/daijishou/DaijishouApplication;", "getApplication", "()Lcom/magneticchen/daijishou/DaijishouApplication;", "setApplication", "(Lcom/magneticchen/daijishou/DaijishouApplication;)V", "daijishouLibraryRepository", "Lcom/magneticchen/daijishou/data/db/repositories/DaijishouLibraryRepository;", "getDaijishouLibraryRepository", "()Lcom/magneticchen/daijishou/data/db/repositories/DaijishouLibraryRepository;", "setDaijishouLibraryRepository", "(Lcom/magneticchen/daijishou/data/db/repositories/DaijishouLibraryRepository;)V", "daijishouWidgetRepository", "Lcom/magneticchen/daijishou/data/db/repositories/DaijishouWidgetRepository;", "getDaijishouWidgetRepository", "()Lcom/magneticchen/daijishou/data/db/repositories/DaijishouWidgetRepository;", "setDaijishouWidgetRepository", "(Lcom/magneticchen/daijishou/data/db/repositories/DaijishouWidgetRepository;)V", "widgetInstance", "Lcom/magneticchen/daijishou/ui/widget/abstract_widget_classes/WidgetInstance;", "getWidgetInstance", "()Lcom/magneticchen/daijishou/ui/widget/abstract_widget_classes/WidgetInstance;", "setWidgetInstance", "(Lcom/magneticchen/daijishou/ui/widget/abstract_widget_classes/WidgetInstance;)V", "initWidgetFaceDaijishouApplicationObjects", "", "daijishouApplication", "onClick", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPreload", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class WidgetFaceFragment extends DaijishouFragment {
    protected DaijishouApplication application;
    protected DaijishouLibraryRepository daijishouLibraryRepository;
    protected DaijishouWidgetRepository daijishouWidgetRepository;
    public WidgetInstance widgetInstance;

    public void onClick() {
    }

    public void onPreload() {
    }

    public final WidgetInstance getWidgetInstance() {
        WidgetInstance widgetInstance = this.widgetInstance;
        if (widgetInstance != null) {
            return widgetInstance;
        }
        Intrinsics.throwUninitializedPropertyAccessException("widgetInstance");
        return null;
    }

    public final void setWidgetInstance(WidgetInstance widgetInstance) {
        Intrinsics.checkNotNullParameter(widgetInstance, "<set-?>");
        this.widgetInstance = widgetInstance;
    }

    protected final DaijishouWidgetRepository getDaijishouWidgetRepository() {
        DaijishouWidgetRepository daijishouWidgetRepository = this.daijishouWidgetRepository;
        if (daijishouWidgetRepository != null) {
            return daijishouWidgetRepository;
        }
        Intrinsics.throwUninitializedPropertyAccessException("daijishouWidgetRepository");
        return null;
    }

    protected final void setDaijishouWidgetRepository(DaijishouWidgetRepository daijishouWidgetRepository) {
        Intrinsics.checkNotNullParameter(daijishouWidgetRepository, "<set-?>");
        this.daijishouWidgetRepository = daijishouWidgetRepository;
    }

    protected final DaijishouLibraryRepository getDaijishouLibraryRepository() {
        DaijishouLibraryRepository daijishouLibraryRepository = this.daijishouLibraryRepository;
        if (daijishouLibraryRepository != null) {
            return daijishouLibraryRepository;
        }
        Intrinsics.throwUninitializedPropertyAccessException("daijishouLibraryRepository");
        return null;
    }

    protected final void setDaijishouLibraryRepository(DaijishouLibraryRepository daijishouLibraryRepository) {
        Intrinsics.checkNotNullParameter(daijishouLibraryRepository, "<set-?>");
        this.daijishouLibraryRepository = daijishouLibraryRepository;
    }

    protected final DaijishouApplication getApplication() {
        DaijishouApplication daijishouApplication = this.application;
        if (daijishouApplication != null) {
            return daijishouApplication;
        }
        Intrinsics.throwUninitializedPropertyAccessException("application");
        return null;
    }

    protected final void setApplication(DaijishouApplication daijishouApplication) {
        Intrinsics.checkNotNullParameter(daijishouApplication, "<set-?>");
        this.application = daijishouApplication;
    }

    public final void initWidgetFaceDaijishouApplicationObjects(DaijishouApplication daijishouApplication) {
        Intrinsics.checkNotNullParameter(daijishouApplication, "daijishouApplication");
        initDaijishouApplicationObjects(daijishouApplication);
        setApplication(daijishouApplication);
        setDaijishouWidgetRepository(daijishouApplication.getDaijishouWidgetRepository());
        setDaijishouLibraryRepository(daijishouApplication.getDaijishouLibraryRepository());
    }

    @Override // com.magneticchen.daijishou.ui.fragments.p000abstract.DaijishouFragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Context applicationContext = requireContext().getApplicationContext();
        Intrinsics.checkNotNull(applicationContext, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication");
        initWidgetFaceDaijishouApplicationObjects((DaijishouApplication) applicationContext);
    }
}
