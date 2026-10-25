package androidx.core.view.insets;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.R;
import androidx.core.graphics.Insets;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ProtectionLayout extends FrameLayout {
    private static final Object PROTECTION_VIEW = new Object();
    private ProtectionGroup mGroup;
    private final List<Protection> mProtections;

    public ProtectionLayout(Context context) {
        super(context);
        this.mProtections = new ArrayList();
    }

    public ProtectionLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ProtectionLayout(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public ProtectionLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mProtections = new ArrayList();
    }

    public ProtectionLayout(Context context, List<Protection> list) {
        super(context);
        this.mProtections = new ArrayList();
        setProtections(list);
    }

    public void setProtections(List<Protection> list) {
        this.mProtections.clear();
        this.mProtections.addAll(list);
        if (isAttachedToWindow()) {
            removeProtectionViews();
            addProtectionViews();
            requestApplyInsets();
        }
    }

    private SystemBarStateMonitor getOrInstallSystemBarStateMonitor() {
        ViewGroup viewGroup = (ViewGroup) getRootView();
        Object tag = viewGroup.getTag(R.id.tag_system_bar_state_monitor);
        if (tag instanceof SystemBarStateMonitor) {
            return (SystemBarStateMonitor) tag;
        }
        SystemBarStateMonitor systemBarStateMonitor = new SystemBarStateMonitor(viewGroup);
        viewGroup.setTag(R.id.tag_system_bar_state_monitor, systemBarStateMonitor);
        return systemBarStateMonitor;
    }

    private void maybeUninstallSystemBarStateMonitor() {
        ViewGroup viewGroup = (ViewGroup) getRootView();
        Object tag = viewGroup.getTag(R.id.tag_system_bar_state_monitor);
        if (tag instanceof SystemBarStateMonitor) {
            SystemBarStateMonitor systemBarStateMonitor = (SystemBarStateMonitor) tag;
            if (systemBarStateMonitor.hasCallback()) {
                return;
            }
            systemBarStateMonitor.detachFromWindow();
            viewGroup.setTag(R.id.tag_system_bar_state_monitor, null);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mGroup != null) {
            removeProtectionViews();
        }
        addProtectionViews();
        requestApplyInsets();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeProtectionViews();
        maybeUninstallSystemBarStateMonitor();
    }

    private void addProtectionViews() {
        if (this.mProtections.isEmpty()) {
            return;
        }
        this.mGroup = new ProtectionGroup(getOrInstallSystemBarStateMonitor(), this.mProtections);
        int childCount = getChildCount();
        int size = this.mGroup.size();
        for (int i = 0; i < size; i++) {
            addProtectionView(getContext(), i + childCount, this.mGroup.getProtection(i));
        }
    }

    private void removeProtectionViews() {
        if (this.mGroup != null) {
            removeViews(getChildCount() - this.mGroup.size(), this.mGroup.size());
            int size = this.mGroup.size();
            for (int i = 0; i < size; i++) {
                this.mGroup.getProtection(i).getAttributes().setCallback(null);
            }
            this.mGroup.dispose();
            this.mGroup = null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0089  */
    private void addProtectionView(Context context, int i, Protection protection) {
        int width;
        int i2;
        int height;
        Protection.Attributes attributes = protection.getAttributes();
        int side = protection.getSide();
        int i3 = -1;
        if (side == 1) {
            width = attributes.getWidth();
            i2 = 3;
        } else {
            if (side == 2) {
                height = attributes.getHeight();
                i2 = 48;
            } else if (side == 4) {
                width = attributes.getWidth();
                i2 = 5;
            } else if (side == 8) {
                height = attributes.getHeight();
                i2 = 80;
            } else {
                throw new IllegalArgumentException("Unexpected side: " + protection.getSide());
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i3, height, i2);
            Insets margin = attributes.getMargin();
            layoutParams.leftMargin = margin.left;
            layoutParams.topMargin = margin.top;
            layoutParams.rightMargin = margin.right;
            layoutParams.bottomMargin = margin.bottom;
            View view = new View(context);
            view.setTag(PROTECTION_VIEW);
            view.setTranslationX(attributes.getTranslationX());
            view.setTranslationY(attributes.getTranslationY());
            view.setAlpha(attributes.getAlpha());
            view.setVisibility(attributes.isVisible() ? 0 : 4);
            view.setBackground(attributes.getDrawable());
            attributes.setCallback(new AnonymousClass1(layoutParams, view));
            addView(view, i, layoutParams);
        }
        i3 = width;
        height = -1;
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i3, height, i2);
        Insets margin2 = attributes.getMargin();
        layoutParams2.leftMargin = margin2.left;
        layoutParams2.topMargin = margin2.top;
        layoutParams2.rightMargin = margin2.right;
        layoutParams2.bottomMargin = margin2.bottom;
        View view2 = new View(context);
        view2.setTag(PROTECTION_VIEW);
        view2.setTranslationX(attributes.getTranslationX());
        view2.setTranslationY(attributes.getTranslationY());
        view2.setAlpha(attributes.getAlpha());
        view2.setVisibility(attributes.isVisible() ? 0 : 4);
        view2.setBackground(attributes.getDrawable());
        attributes.setCallback(new AnonymousClass1(layoutParams2, view2));
        addView(view2, i, layoutParams2);
    }

    /* JADX INFO: renamed from: androidx.core.view.insets.ProtectionLayout$1, reason: invalid class name */
    class AnonymousClass1 implements Protection.Attributes.Callback {
        final /* synthetic */ FrameLayout.LayoutParams val$params;
        final /* synthetic */ View val$view;

        AnonymousClass1(FrameLayout.LayoutParams layoutParams, View view) {
            this.val$params = layoutParams;
            this.val$view = view;
        }

        @Override // androidx.core.view.insets.Protection.Attributes.Callback
        public void onWidthChanged(int i) {
            this.val$params.width = i;
            this.val$view.setLayoutParams(this.val$params);
        }

        @Override // androidx.core.view.insets.Protection.Attributes.Callback
        public void onHeightChanged(int i) {
            this.val$params.height = i;
            this.val$view.setLayoutParams(this.val$params);
        }

        @Override // androidx.core.view.insets.Protection.Attributes.Callback
        public void onMarginChanged(Insets insets) {
            this.val$params.leftMargin = insets.left;
            this.val$params.topMargin = insets.top;
            this.val$params.rightMargin = insets.right;
            this.val$params.bottomMargin = insets.bottom;
            this.val$view.setLayoutParams(this.val$params);
        }

        @Override // androidx.core.view.insets.Protection.Attributes.Callback
        public void onVisibilityChanged(boolean z) {
            this.val$view.setVisibility(z ? 0 : 4);
        }

        @Override // androidx.core.view.insets.Protection.Attributes.Callback
        public void onDrawableChanged(Drawable drawable) {
            this.val$view.setBackground(drawable);
        }

        @Override // androidx.core.view.insets.Protection.Attributes.Callback
        public void onTranslationXChanged(float f) {
            this.val$view.setTranslationX(f);
        }

        @Override // androidx.core.view.insets.Protection.Attributes.Callback
        public void onTranslationYChanged(float f) {
            this.val$view.setTranslationY(f);
        }

        @Override // androidx.core.view.insets.Protection.Attributes.Callback
        public void onAlphaChanged(float f) {
            this.val$view.setAlpha(f);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (view != null && view.getTag() != PROTECTION_VIEW) {
            ProtectionGroup protectionGroup = this.mGroup;
            int childCount = getChildCount() - (protectionGroup != null ? protectionGroup.size() : 0);
            if (i > childCount || i < 0) {
                i = childCount;
            }
        }
        super.addView(view, i, layoutParams);
    }
}
