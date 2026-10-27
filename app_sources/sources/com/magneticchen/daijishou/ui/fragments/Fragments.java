package com.magneticchen.daijishou.ui.fragments;

import com.magneticchen.daijishou.ui.fragments.pager.AppsViewPagerFragment;
import com.magneticchen.daijishou.ui.fragments.pager.LibraryViewPagerFragment;
import com.magneticchen.daijishou.ui.fragments.pager.SettingsViewPagerFragment;
import com.magneticchen.daijishou.ui.fragments.pager.WidgetsViewPagerFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Fragments.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\tHÆ\u0003J1\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001f"}, d2 = {"Lcom/magneticchen/daijishou/ui/fragments/Fragments;", "", "platformsFragmentInstance", "Lcom/magneticchen/daijishou/ui/fragments/pager/LibraryViewPagerFragment;", "widgetsFragmentInstance", "Lcom/magneticchen/daijishou/ui/fragments/pager/WidgetsViewPagerFragment;", "appsFragmentInstance", "Lcom/magneticchen/daijishou/ui/fragments/pager/AppsViewPagerFragment;", "settingsFragmentInstance", "Lcom/magneticchen/daijishou/ui/fragments/pager/SettingsViewPagerFragment;", "(Lcom/magneticchen/daijishou/ui/fragments/pager/LibraryViewPagerFragment;Lcom/magneticchen/daijishou/ui/fragments/pager/WidgetsViewPagerFragment;Lcom/magneticchen/daijishou/ui/fragments/pager/AppsViewPagerFragment;Lcom/magneticchen/daijishou/ui/fragments/pager/SettingsViewPagerFragment;)V", "getAppsFragmentInstance", "()Lcom/magneticchen/daijishou/ui/fragments/pager/AppsViewPagerFragment;", "getPlatformsFragmentInstance", "()Lcom/magneticchen/daijishou/ui/fragments/pager/LibraryViewPagerFragment;", "getSettingsFragmentInstance", "()Lcom/magneticchen/daijishou/ui/fragments/pager/SettingsViewPagerFragment;", "getWidgetsFragmentInstance", "()Lcom/magneticchen/daijishou/ui/fragments/pager/WidgetsViewPagerFragment;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class Fragments {
    private final AppsViewPagerFragment appsFragmentInstance;
    private final LibraryViewPagerFragment platformsFragmentInstance;
    private final SettingsViewPagerFragment settingsFragmentInstance;
    private final WidgetsViewPagerFragment widgetsFragmentInstance;

    public Fragments() {
        this(null, null, null, null, 15, null);
    }

    public static /* synthetic */ Fragments copy$default(Fragments fragments, LibraryViewPagerFragment libraryViewPagerFragment, WidgetsViewPagerFragment widgetsViewPagerFragment, AppsViewPagerFragment appsViewPagerFragment, SettingsViewPagerFragment settingsViewPagerFragment, int i, Object obj) {
        if ((i & 1) != 0) {
            libraryViewPagerFragment = fragments.platformsFragmentInstance;
        }
        if ((i & 2) != 0) {
            widgetsViewPagerFragment = fragments.widgetsFragmentInstance;
        }
        if ((i & 4) != 0) {
            appsViewPagerFragment = fragments.appsFragmentInstance;
        }
        if ((i & 8) != 0) {
            settingsViewPagerFragment = fragments.settingsFragmentInstance;
        }
        return fragments.copy(libraryViewPagerFragment, widgetsViewPagerFragment, appsViewPagerFragment, settingsViewPagerFragment);
    }

    public final LibraryViewPagerFragment component1() {
        return this.platformsFragmentInstance;
    }

    public final WidgetsViewPagerFragment component2() {
        return this.widgetsFragmentInstance;
    }

    public final AppsViewPagerFragment component3() {
        return this.appsFragmentInstance;
    }

    public final SettingsViewPagerFragment component4() {
        return this.settingsFragmentInstance;
    }

    public final Fragments copy(LibraryViewPagerFragment platformsFragmentInstance, WidgetsViewPagerFragment widgetsFragmentInstance, AppsViewPagerFragment appsFragmentInstance, SettingsViewPagerFragment settingsFragmentInstance) {
        Intrinsics.checkNotNullParameter(platformsFragmentInstance, "platformsFragmentInstance");
        Intrinsics.checkNotNullParameter(widgetsFragmentInstance, "widgetsFragmentInstance");
        Intrinsics.checkNotNullParameter(appsFragmentInstance, "appsFragmentInstance");
        Intrinsics.checkNotNullParameter(settingsFragmentInstance, "settingsFragmentInstance");
        return new Fragments(platformsFragmentInstance, widgetsFragmentInstance, appsFragmentInstance, settingsFragmentInstance);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Fragments)) {
            return false;
        }
        Fragments fragments = (Fragments) obj;
        return Intrinsics.areEqual(this.platformsFragmentInstance, fragments.platformsFragmentInstance) && Intrinsics.areEqual(this.widgetsFragmentInstance, fragments.widgetsFragmentInstance) && Intrinsics.areEqual(this.appsFragmentInstance, fragments.appsFragmentInstance) && Intrinsics.areEqual(this.settingsFragmentInstance, fragments.settingsFragmentInstance);
    }

    public int hashCode() {
        return (((((this.platformsFragmentInstance.hashCode() * 31) + this.widgetsFragmentInstance.hashCode()) * 31) + this.appsFragmentInstance.hashCode()) * 31) + this.settingsFragmentInstance.hashCode();
    }

    public String toString() {
        return "Fragments(platformsFragmentInstance=" + this.platformsFragmentInstance + ", widgetsFragmentInstance=" + this.widgetsFragmentInstance + ", appsFragmentInstance=" + this.appsFragmentInstance + ", settingsFragmentInstance=" + this.settingsFragmentInstance + ")";
    }

    public Fragments(LibraryViewPagerFragment platformsFragmentInstance, WidgetsViewPagerFragment widgetsFragmentInstance, AppsViewPagerFragment appsFragmentInstance, SettingsViewPagerFragment settingsFragmentInstance) {
        Intrinsics.checkNotNullParameter(platformsFragmentInstance, "platformsFragmentInstance");
        Intrinsics.checkNotNullParameter(widgetsFragmentInstance, "widgetsFragmentInstance");
        Intrinsics.checkNotNullParameter(appsFragmentInstance, "appsFragmentInstance");
        Intrinsics.checkNotNullParameter(settingsFragmentInstance, "settingsFragmentInstance");
        this.platformsFragmentInstance = platformsFragmentInstance;
        this.widgetsFragmentInstance = widgetsFragmentInstance;
        this.appsFragmentInstance = appsFragmentInstance;
        this.settingsFragmentInstance = settingsFragmentInstance;
    }

    public /* synthetic */ Fragments(LibraryViewPagerFragment libraryViewPagerFragment, WidgetsViewPagerFragment widgetsViewPagerFragment, AppsViewPagerFragment appsViewPagerFragment, SettingsViewPagerFragment settingsViewPagerFragment, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? LibraryViewPagerFragment.Companion.newInstance() : libraryViewPagerFragment, (i & 2) != 0 ? WidgetsViewPagerFragment.Companion.newInstance() : widgetsViewPagerFragment, (i & 4) != 0 ? AppsViewPagerFragment.Companion.newInstance() : appsViewPagerFragment, (i & 8) != 0 ? SettingsViewPagerFragment.Companion.newInstance() : settingsViewPagerFragment);
    }

    public final LibraryViewPagerFragment getPlatformsFragmentInstance() {
        return this.platformsFragmentInstance;
    }

    public final WidgetsViewPagerFragment getWidgetsFragmentInstance() {
        return this.widgetsFragmentInstance;
    }

    public final AppsViewPagerFragment getAppsFragmentInstance() {
        return this.appsFragmentInstance;
    }

    public final SettingsViewPagerFragment getSettingsFragmentInstance() {
        return this.settingsFragmentInstance;
    }
}
