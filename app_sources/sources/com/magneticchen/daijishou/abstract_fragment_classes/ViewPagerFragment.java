package com.magneticchen.daijishou.abstract_fragment_classes;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.activities.MainActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* INFO: compiled from: ViewPagerFragment.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\b\u0010(\u001a\u00020%H\u0016J\u001a\u0010)\u001a\u00020%2\u0006\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\u000e\u0010.\u001a\u00020%2\u0006\u0010/\u001a\u00020\u0004R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0018\u0010\r\u001a\u00020\u0004X¦\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u0006\"\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\nR\u001a\u0010\u0013\u001a\u00020\bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\n\"\u0004\b\u0015\u0010\fR\u0012\u0010\u0016\u001a\u00020\u0017X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0006R\u001a\u0010\u001c\u001a\u00020\bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\n\"\u0004\b\u001e\u0010\fR\u0014\u0010\u001f\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0006R\u001a\u0010!\u001a\u00020\bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\n\"\u0004\b#\u0010\f¨\u00060"}, d2 = {"Lcom/magneticchen/daijishou/abstract_fragment_classes/ViewPagerFragment;", "Lcom/magneticchen/daijishou/abstract_fragment_classes/DaijishouFragment;", "()V", "backButtonDescriptionStringId", "", "getBackButtonDescriptionStringId", "()I", "clearPreviousWallpaperOnSelect", "", "getClearPreviousWallpaperOnSelect", "()Z", "setClearPreviousWallpaperOnSelect", "(Z)V", "displayNameStringId", "getDisplayNameStringId", "setDisplayNameStringId", "(I)V", "fullscreen", "getFullscreen", "handleWallpaperMyself", "getHandleWallpaperMyself", "setHandleWallpaperMyself", "id", "", "getId", "()Ljava/lang/String;", "nextFocusDown", "getNextFocusDown", "pageSelected", "getPageSelected$app_release", "setPageSelected$app_release", "selectButtonDescriptionStringId", "getSelectButtonDescriptionStringId", "useDefaultWallpaper", "getUseDefaultWallpaper", "setUseDefaultWallpaper", "onPageSelected", "", "pageSelectedParameters", "", "onPageUnSelected", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "updateDisplayNameStringId", "stringId", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class ViewPagerFragment extends DaijishouFragment {
    private boolean fullscreen = false;
    private boolean handleWallpaperMyself;
    private boolean pageSelected;
    private boolean useDefaultWallpaper;
    private final int nextFocusDown = -1;
    private final int selectButtonDescriptionStringId = R.string.select;
    private final int backButtonDescriptionStringId = R.string.back;
    private boolean clearPreviousWallpaperOnSelect = true;

    public abstract int getDisplayNameStringId();

    public abstract String getStringId();

    public abstract void setDisplayNameStringId(int i);

    public int getNextFocusDown() {
        return this.nextFocusDown;
    }

    public int getSelectButtonDescriptionStringId() {
        return this.selectButtonDescriptionStringId;
    }

    public int getBackButtonDescriptionStringId() {
        return this.backButtonDescriptionStringId;
    }

    /* INFO: renamed from: getPageSelected$app_release, reason: from getter */
    public final boolean getPageSelected() {
        return this.pageSelected;
    }

    public final void setPageSelected$app_release(boolean z) {
        this.pageSelected = z;
    }

    public boolean getFullscreen() {
        return this.fullscreen;
    }

    public boolean getUseDefaultWallpaper() {
        return this.useDefaultWallpaper;
    }

    public void setUseDefaultWallpaper(boolean z) {
        this.useDefaultWallpaper = z;
    }

    public boolean getHandleWallpaperMyself() {
        return this.handleWallpaperMyself;
    }

    public void setHandleWallpaperMyself(boolean z) {
        this.handleWallpaperMyself = z;
    }

    public boolean getClearPreviousWallpaperOnSelect() {
        return this.clearPreviousWallpaperOnSelect;
    }

    public void setClearPreviousWallpaperOnSelect(boolean z) {
        this.clearPreviousWallpaperOnSelect = z;
    }

    public void onPageSelected(Object pageSelectedParameters) {
        View view = getView();
        if (view != null) {
            ((ViewGroup) view).setDescendantFocusability(262144);
        }
        this.pageSelected = true;
    }

    public void onPageUnSelected() {
        View view = getView();
        if (view != null) {
            ViewGroup viewGroup = (ViewGroup) view;
            viewGroup.setDescendantFocusability(393216);
            viewGroup.clearFocus();
        }
        this.pageSelected = false;
    }

    public final void updateDisplayNameStringId(int stringId) {
        setDisplayNameStringId(stringId);
        FragmentActivity fragmentActivityRequireActivity = requireActivity();
        Intrinsics.checkNotNull(fragmentActivityRequireActivity, "null cannot be cast to non-null type com.magneticchen.daijishou.activities.MainActivity");
        ((MainActivity) fragmentActivityRequireActivity).changeViewPagerFragmentDisplayNameStringId(getStringId(), stringId);
    }

    @Override // com.magneticchen.daijishou.abstract_fragment_classes.DaijishouFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        if (this.pageSelected) {
            ((ViewGroup) view).setDescendantFocusability(262144);
        } else {
            ((ViewGroup) view).setDescendantFocusability(393216);
        }
    }
}
