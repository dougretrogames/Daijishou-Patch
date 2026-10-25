package com.skydoves.balloon;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import com.skydoves.balloon.extensions.ContextExtensionKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: IconForm.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\r\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\"B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\"\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0018\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0017R\u0011\u0010\u001e\u001a\u00020\u001f¢\u0006\b\n\u0000\u001a\u0004\b \u0010!¨\u0006#"}, d2 = {"Lcom/skydoves/balloon/IconForm;", "", "builder", "Lcom/skydoves/balloon/IconForm$Builder;", "<init>", "(Lcom/skydoves/balloon/IconForm$Builder;)V", "drawable", "Landroid/graphics/drawable/Drawable;", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "drawableRes", "", "getDrawableRes", "()Ljava/lang/Integer;", "setDrawableRes", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "iconGravity", "Lcom/skydoves/balloon/IconGravity;", "getIconGravity", "()Lcom/skydoves/balloon/IconGravity;", "iconWidth", "getIconWidth", "()I", "iconHeight", "getIconHeight", "iconSpace", "getIconSpace", "iconColor", "getIconColor", "iconContentDescription", "", "getIconContentDescription", "()Ljava/lang/CharSequence;", "Builder", "balloon_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class IconForm {
    private final Drawable drawable;
    private Integer drawableRes;
    private final int iconColor;
    private final CharSequence iconContentDescription;
    private final IconGravity iconGravity;
    private final int iconHeight;
    private final int iconSpace;
    private final int iconWidth;

    public /* synthetic */ IconForm(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private IconForm(Builder builder) {
        this.drawable = builder.getDrawable();
        this.drawableRes = builder.getDrawableRes();
        this.iconGravity = builder.getIconGravity();
        this.iconWidth = builder.getIconWidth();
        this.iconHeight = builder.getIconHeight();
        this.iconSpace = builder.getIconSpace();
        this.iconColor = builder.getIconColor();
        this.iconContentDescription = builder.getIconContentDescription();
    }

    public final Drawable getDrawable() {
        return this.drawable;
    }

    public final Integer getDrawableRes() {
        return this.drawableRes;
    }

    public final void setDrawableRes(Integer num) {
        this.drawableRes = num;
    }

    public final IconGravity getIconGravity() {
        return this.iconGravity;
    }

    public final int getIconWidth() {
        return this.iconWidth;
    }

    public final int getIconHeight() {
        return this.iconHeight;
    }

    public final int getIconSpace() {
        return this.iconSpace;
    }

    public final int getIconColor() {
        return this.iconColor;
    }

    public final CharSequence getIconContentDescription() {
        return this.iconContentDescription;
    }

    /* JADX INFO: compiled from: IconForm.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\r\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\f\u001a\u00020\u00002\b\u0010/\u001a\u0004\u0018\u00010\tJ\u0010\u00100\u001a\u00020\u00002\b\b\u0001\u0010/\u001a\u00020\u000fJ\u000e\u00101\u001a\u00020\u00002\u0006\u0010/\u001a\u00020\u0016J\u0010\u0010\u001e\u001a\u00020\u00002\b\b\u0001\u0010/\u001a\u00020\u000fJ\u0010\u0010\"\u001a\u00020\u00002\b\b\u0001\u0010/\u001a\u00020\u000fJ\u0010\u00102\u001a\u00020\u00002\b\b\u0001\u0010/\u001a\u00020\u000fJ\u000e\u0010-\u001a\u00020\u00002\u0006\u0010/\u001a\u00020*J\u0010\u00103\u001a\u00020\u00002\b\b\u0001\u0010/\u001a\u00020\u000fJ\u0010\u0010%\u001a\u00020\u00002\b\b\u0001\u0010/\u001a\u00020\u000fJ\u0010\u0010(\u001a\u00020\u00002\b\b\u0001\u0010/\u001a\u00020\u000fJ\u0010\u00104\u001a\u00020\u00002\b\b\u0001\u0010/\u001a\u00020\u000fJ\u0006\u00105\u001a\u000206R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001b\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001e\u0010 \u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001fR\u001e\u0010#\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001d\"\u0004\b%\u0010\u001fR\u001e\u0010&\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u001d\"\u0004\b(\u0010\u001fR\u001a\u0010)\u001a\u00020*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.¨\u00067"}, d2 = {"Lcom/skydoves/balloon/IconForm$Builder;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "drawable", "Landroid/graphics/drawable/Drawable;", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "setDrawable", "(Landroid/graphics/drawable/Drawable;)V", "drawableRes", "", "getDrawableRes", "()Ljava/lang/Integer;", "setDrawableRes", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "iconGravity", "Lcom/skydoves/balloon/IconGravity;", "getIconGravity", "()Lcom/skydoves/balloon/IconGravity;", "setIconGravity", "(Lcom/skydoves/balloon/IconGravity;)V", "iconWidth", "getIconWidth", "()I", "setIconWidth", "(I)V", "iconHeight", "getIconHeight", "setIconHeight", "iconSpace", "getIconSpace", "setIconSpace", "iconColor", "getIconColor", "setIconColor", "iconContentDescription", "", "getIconContentDescription", "()Ljava/lang/CharSequence;", "setIconContentDescription", "(Ljava/lang/CharSequence;)V", "value", "setDrawableResource", "setDrawableGravity", "setIconSize", "setIconContentDescriptionResource", "setIconColorResource", "build", "Lcom/skydoves/balloon/IconForm;", "balloon_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @IconFormDsl
    public static final class Builder {
        private final Context context;
        private Drawable drawable;
        private Integer drawableRes;
        private int iconColor;
        private CharSequence iconContentDescription;
        private IconGravity iconGravity;
        private int iconHeight;
        private int iconSpace;
        private int iconWidth;

        public Builder(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            this.context = context;
            this.iconGravity = IconGravity.START;
            float f = 28;
            this.iconWidth = MathKt.roundToInt(TypedValue.applyDimension(1, f, Resources.getSystem().getDisplayMetrics()));
            this.iconHeight = MathKt.roundToInt(TypedValue.applyDimension(1, f, Resources.getSystem().getDisplayMetrics()));
            this.iconSpace = MathKt.roundToInt(TypedValue.applyDimension(1, 8, Resources.getSystem().getDisplayMetrics()));
            this.iconColor = -1;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            this.iconContentDescription = "";
        }

        public final Context getContext() {
            return this.context;
        }

        public final Drawable getDrawable() {
            return this.drawable;
        }

        /* JADX INFO: renamed from: setDrawable, reason: collision with other method in class */
        public final /* synthetic */ void m3727setDrawable(Drawable drawable) {
            this.drawable = drawable;
        }

        public final Integer getDrawableRes() {
            return this.drawableRes;
        }

        public final /* synthetic */ void setDrawableRes(Integer num) {
            this.drawableRes = num;
        }

        public final IconGravity getIconGravity() {
            return this.iconGravity;
        }

        public final /* synthetic */ void setIconGravity(IconGravity iconGravity) {
            Intrinsics.checkNotNullParameter(iconGravity, "<set-?>");
            this.iconGravity = iconGravity;
        }

        public final int getIconWidth() {
            return this.iconWidth;
        }

        /* JADX INFO: renamed from: setIconWidth, reason: collision with other method in class */
        public final /* synthetic */ void m3732setIconWidth(int i) {
            this.iconWidth = i;
        }

        public final int getIconHeight() {
            return this.iconHeight;
        }

        /* JADX INFO: renamed from: setIconHeight, reason: collision with other method in class */
        public final /* synthetic */ void m3730setIconHeight(int i) {
            this.iconHeight = i;
        }

        public final int getIconSpace() {
            return this.iconSpace;
        }

        /* JADX INFO: renamed from: setIconSpace, reason: collision with other method in class */
        public final /* synthetic */ void m3731setIconSpace(int i) {
            this.iconSpace = i;
        }

        public final int getIconColor() {
            return this.iconColor;
        }

        /* JADX INFO: renamed from: setIconColor, reason: collision with other method in class */
        public final /* synthetic */ void m3728setIconColor(int i) {
            this.iconColor = i;
        }

        public final CharSequence getIconContentDescription() {
            return this.iconContentDescription;
        }

        /* JADX INFO: renamed from: setIconContentDescription, reason: collision with other method in class */
        public final /* synthetic */ void m3729setIconContentDescription(CharSequence charSequence) {
            Intrinsics.checkNotNullParameter(charSequence, "<set-?>");
            this.iconContentDescription = charSequence;
        }

        public final Builder setDrawable(Drawable value) {
            this.drawable = value;
            return this;
        }

        public final Builder setDrawableResource(int value) {
            this.drawableRes = Integer.valueOf(value);
            return this;
        }

        public final Builder setDrawableGravity(IconGravity value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.iconGravity = value;
            return this;
        }

        public final Builder setIconWidth(int value) {
            this.iconWidth = value;
            return this;
        }

        public final Builder setIconHeight(int value) {
            this.iconHeight = value;
            return this;
        }

        public final Builder setIconSize(int value) {
            setIconWidth(value);
            setIconHeight(value);
            return this;
        }

        public final Builder setIconContentDescription(CharSequence value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.iconContentDescription = value;
            return this;
        }

        public final Builder setIconContentDescriptionResource(int value) {
            this.iconContentDescription = this.context.getString(value);
            return this;
        }

        public final Builder setIconSpace(int value) {
            this.iconSpace = value;
            return this;
        }

        public final Builder setIconColor(int value) {
            this.iconColor = value;
            return this;
        }

        public final Builder setIconColorResource(int value) {
            this.iconColor = ContextExtensionKt.contextColor(this.context, value);
            return this;
        }

        public final IconForm build() {
            return new IconForm(this, null);
        }
    }
}
