package com.google.android.material.badge;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R;
import com.google.android.material.internal.ParcelableSparseArray;
import com.google.android.material.internal.ToolbarUtils;

/* JADX INFO: loaded from: classes3.dex */
public class BadgeUtils {
    private static final String LOG_TAG = "BadgeUtils";
    public static final boolean USE_COMPAT_PARENT = false;

    private BadgeUtils() {
    }

    public static void updateBadgeBounds(Rect rect, float f, float f2, float f3, float f4) {
        rect.set((int) (f - f3), (int) (f2 - f4), (int) (f + f3), (int) (f2 + f4));
    }

    public static void attachBadgeDrawable(BadgeDrawable badgeDrawable, View view) {
        attachBadgeDrawable(badgeDrawable, view, (FrameLayout) null);
    }

    public static void attachBadgeDrawable(BadgeDrawable badgeDrawable, View view, FrameLayout frameLayout) {
        setBadgeDrawableBounds(badgeDrawable, view, frameLayout);
        if (badgeDrawable.getCustomBadgeParent() != null) {
            badgeDrawable.getCustomBadgeParent().setForeground(badgeDrawable);
        } else {
            if (USE_COMPAT_PARENT) {
                throw new IllegalArgumentException("Trying to reference null customBadgeParent");
            }
            view.getOverlay().add(badgeDrawable);
        }
    }

    public static void attachBadgeDrawable(BadgeDrawable badgeDrawable, Toolbar toolbar, int i) {
        attachBadgeDrawable(badgeDrawable, toolbar, i, null);
    }

    /* JADX INFO: renamed from: com.google.android.material.badge.BadgeUtils$1, reason: invalid class name */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ BadgeDrawable val$badgeDrawable;
        final /* synthetic */ FrameLayout val$customBadgeParent;
        final /* synthetic */ int val$menuItemId;
        final /* synthetic */ Toolbar val$toolbar;

        AnonymousClass1(Toolbar toolbar, int i, BadgeDrawable badgeDrawable, FrameLayout frameLayout) {
            this.val$toolbar = toolbar;
            this.val$menuItemId = i;
            this.val$badgeDrawable = badgeDrawable;
            this.val$customBadgeParent = frameLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            ActionMenuItemView actionMenuItemView = ToolbarUtils.getActionMenuItemView(this.val$toolbar, this.val$menuItemId);
            if (actionMenuItemView != null) {
                BadgeUtils.setToolbarOffset(this.val$badgeDrawable, this.val$toolbar.getResources());
                BadgeUtils.attachBadgeDrawable(this.val$badgeDrawable, actionMenuItemView, this.val$customBadgeParent);
                BadgeUtils.attachBadgeContentDescription(this.val$badgeDrawable, actionMenuItemView);
            }
        }
    }

    public static void attachBadgeDrawable(BadgeDrawable badgeDrawable, Toolbar toolbar, int i, FrameLayout frameLayout) {
        toolbar.post(new AnonymousClass1(toolbar, i, badgeDrawable, frameLayout));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void attachBadgeContentDescription(BadgeDrawable badgeDrawable, View view) {
        if (Build.VERSION.SDK_INT >= 29 && ViewCompat.hasAccessibilityDelegate(view)) {
            ViewCompat.setAccessibilityDelegate(view, new AnonymousClass2(view.getAccessibilityDelegate(), badgeDrawable));
        } else {
            ViewCompat.setAccessibilityDelegate(view, new AnonymousClass3(badgeDrawable));
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.badge.BadgeUtils$2, reason: invalid class name */
    class AnonymousClass2 extends AccessibilityDelegateCompat {
        final /* synthetic */ BadgeDrawable val$badgeDrawable;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(View.AccessibilityDelegate accessibilityDelegate, BadgeDrawable badgeDrawable) {
            super(accessibilityDelegate);
            this.val$badgeDrawable = badgeDrawable;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setContentDescription(this.val$badgeDrawable.getContentDescription());
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.badge.BadgeUtils$3, reason: invalid class name */
    class AnonymousClass3 extends AccessibilityDelegateCompat {
        final /* synthetic */ BadgeDrawable val$badgeDrawable;

        AnonymousClass3(BadgeDrawable badgeDrawable) {
            this.val$badgeDrawable = badgeDrawable;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setContentDescription(this.val$badgeDrawable.getContentDescription());
        }
    }

    public static void detachBadgeDrawable(BadgeDrawable badgeDrawable, View view) {
        if (badgeDrawable == null) {
            return;
        }
        if (USE_COMPAT_PARENT || badgeDrawable.getCustomBadgeParent() != null) {
            badgeDrawable.getCustomBadgeParent().setForeground(null);
        } else {
            view.getOverlay().remove(badgeDrawable);
        }
    }

    public static void detachBadgeDrawable(BadgeDrawable badgeDrawable, Toolbar toolbar, int i) {
        if (badgeDrawable == null) {
            return;
        }
        ActionMenuItemView actionMenuItemView = ToolbarUtils.getActionMenuItemView(toolbar, i);
        if (actionMenuItemView != null) {
            removeToolbarOffset(badgeDrawable);
            detachBadgeDrawable(badgeDrawable, actionMenuItemView);
            detachBadgeContentDescription(actionMenuItemView);
            return;
        }
        Log.w(LOG_TAG, "Trying to remove badge from a null menuItemView: " + i);
    }

    private static void detachBadgeContentDescription(View view) {
        if (Build.VERSION.SDK_INT >= 29 && ViewCompat.hasAccessibilityDelegate(view)) {
            ViewCompat.setAccessibilityDelegate(view, new AnonymousClass4(view.getAccessibilityDelegate()));
        } else {
            ViewCompat.setAccessibilityDelegate(view, null);
        }
    }

    /* JADX INFO: renamed from: com.google.android.material.badge.BadgeUtils$4, reason: invalid class name */
    class AnonymousClass4 extends AccessibilityDelegateCompat {
        AnonymousClass4(View.AccessibilityDelegate accessibilityDelegate) {
            super(accessibilityDelegate);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setContentDescription(null);
        }
    }

    static void setToolbarOffset(BadgeDrawable badgeDrawable, Resources resources) {
        badgeDrawable.setAdditionalHorizontalOffset(resources.getDimensionPixelOffset(R.dimen.mtrl_badge_toolbar_action_menu_item_horizontal_offset));
        badgeDrawable.setAdditionalVerticalOffset(resources.getDimensionPixelOffset(R.dimen.mtrl_badge_toolbar_action_menu_item_vertical_offset));
    }

    static void removeToolbarOffset(BadgeDrawable badgeDrawable) {
        badgeDrawable.setAdditionalHorizontalOffset(0);
        badgeDrawable.setAdditionalVerticalOffset(0);
    }

    public static void setBadgeDrawableBounds(BadgeDrawable badgeDrawable, View view, FrameLayout frameLayout) {
        Rect rect = new Rect();
        view.getDrawingRect(rect);
        badgeDrawable.setBounds(rect);
        badgeDrawable.updateBadgeCoordinates(view, frameLayout);
    }

    public static ParcelableSparseArray createParcelableBadgeStates(SparseArray<BadgeDrawable> sparseArray) {
        ParcelableSparseArray parcelableSparseArray = new ParcelableSparseArray();
        for (int i = 0; i < sparseArray.size(); i++) {
            int iKeyAt = sparseArray.keyAt(i);
            BadgeDrawable badgeDrawableValueAt = sparseArray.valueAt(i);
            parcelableSparseArray.put(iKeyAt, badgeDrawableValueAt != null ? badgeDrawableValueAt.getSavedState() : null);
        }
        return parcelableSparseArray;
    }

    public static SparseArray<BadgeDrawable> createBadgeDrawablesFromSavedStates(Context context, ParcelableSparseArray parcelableSparseArray) {
        SparseArray<BadgeDrawable> sparseArray = new SparseArray<>(parcelableSparseArray.size());
        for (int i = 0; i < parcelableSparseArray.size(); i++) {
            int iKeyAt = parcelableSparseArray.keyAt(i);
            BadgeState.State state = (BadgeState.State) parcelableSparseArray.valueAt(i);
            sparseArray.put(iKeyAt, state != null ? BadgeDrawable.createFromSavedState(context, state) : null);
        }
        return sparseArray;
    }
}
