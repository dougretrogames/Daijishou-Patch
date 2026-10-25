package com.skydoves.balloon;

import android.content.Context;
import android.graphics.Typeface;
import android.text.method.MovementMethod;
import com.skydoves.balloon.extensions.ContextExtensionKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: compiled from: TextForm.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001:\u00010B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0011\u0010\u0014\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\rR\u0016\u0010\u0016\u001a\u00020\u00178\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001a\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0011R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u001d¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010 \u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0019R\u0013\u0010\"\u001a\u0004\u0018\u00010#¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0015\u0010&\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010)\u001a\u0004\b'\u0010(R\u0011\u0010*\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0011R\u0015\u0010,\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010)\u001a\u0004\b-\u0010(R\u0011\u0010.\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u0019¨\u00061"}, d2 = {"Lcom/skydoves/balloon/TextForm;", "", "builder", "Lcom/skydoves/balloon/TextForm$Builder;", "<init>", "(Lcom/skydoves/balloon/TextForm$Builder;)V", "text", "", "getText", "()Ljava/lang/CharSequence;", "textSize", "", "getTextSize", "()F", "enableAutoSized", "", "getEnableAutoSized", "()Z", "minAutoSizeTextSize", "getMinAutoSizeTextSize", "maxAutoSizeTextSize", "getMaxAutoSizeTextSize", "textColor", "", "getTextColor", "()I", "textIsHtml", "getTextIsHtml", "movementMethod", "Landroid/text/method/MovementMethod;", "getMovementMethod", "()Landroid/text/method/MovementMethod;", "textStyle", "getTextStyle", "textTypeface", "Landroid/graphics/Typeface;", "getTextTypeface", "()Landroid/graphics/Typeface;", "textLineSpacing", "getTextLineSpacing", "()Ljava/lang/Float;", "Ljava/lang/Float;", "includeFontPadding", "getIncludeFontPadding", "textLetterSpacing", "getTextLetterSpacing", "textGravity", "getTextGravity", "Builder", "balloon_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TextForm {
    private final boolean enableAutoSized;
    private final boolean includeFontPadding;
    private final float maxAutoSizeTextSize;
    private final float minAutoSizeTextSize;
    private final MovementMethod movementMethod;
    private final CharSequence text;
    private final int textColor;
    private final int textGravity;
    private final boolean textIsHtml;
    private final Float textLetterSpacing;
    private final Float textLineSpacing;
    private final float textSize;
    private final int textStyle;
    private final Typeface textTypeface;

    public /* synthetic */ TextForm(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    private TextForm(Builder builder) {
        this.text = builder.getText();
        this.textSize = builder.getTextSize();
        this.enableAutoSized = builder.getEnableAutoSized();
        this.minAutoSizeTextSize = builder.getMinAutoSizeTextSize();
        this.maxAutoSizeTextSize = builder.getMaxAutoSizeTextSize();
        this.textColor = builder.getTextColor();
        this.textIsHtml = builder.getTextIsHtml();
        this.movementMethod = builder.getMovementMethod();
        this.textStyle = builder.getTextTypeface();
        this.textTypeface = builder.getTextTypefaceObject();
        this.textLineSpacing = builder.getTextLineSpacing();
        this.includeFontPadding = builder.getIncludeFontPadding();
        this.textLetterSpacing = builder.getTextLetterSpacing();
        this.textGravity = builder.getTextGravity();
    }

    public final CharSequence getText() {
        return this.text;
    }

    public final float getTextSize() {
        return this.textSize;
    }

    public final boolean getEnableAutoSized() {
        return this.enableAutoSized;
    }

    public final float getMinAutoSizeTextSize() {
        return this.minAutoSizeTextSize;
    }

    public final float getMaxAutoSizeTextSize() {
        return this.maxAutoSizeTextSize;
    }

    public final int getTextColor() {
        return this.textColor;
    }

    public final boolean getTextIsHtml() {
        return this.textIsHtml;
    }

    public final MovementMethod getMovementMethod() {
        return this.movementMethod;
    }

    public final int getTextStyle() {
        return this.textStyle;
    }

    public final Typeface getTextTypeface() {
        return this.textTypeface;
    }

    public final Float getTextLineSpacing() {
        return this.textLineSpacing;
    }

    public final boolean getIncludeFontPadding() {
        return this.includeFontPadding;
    }

    public final Float getTextLetterSpacing() {
        return this.textLetterSpacing;
    }

    public final int getTextGravity() {
        return this.textGravity;
    }

    /* JADX INFO: compiled from: TextForm.kt */
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010G\u001a\u00020\tJ\u000e\u0010\u0018\u001a\u00020\u00002\u0006\u0010G\u001a\u00020\u0015J\u0010\u0010\u001c\u001a\u00020\u00002\b\b\u0001\u0010G\u001a\u00020\u000fJ\u0010\u0010\u001f\u001a\u00020\u00002\b\b\u0001\u0010G\u001a\u00020\u000fJ\u0010\u0010H\u001a\u00020\u00002\b\b\u0001\u0010G\u001a\u00020!J\u0010\u0010\u0012\u001a\u00020\u00002\b\b\u0001\u0010G\u001a\u00020\u000fJ\u0010\u0010I\u001a\u00020\u00002\b\b\u0001\u0010G\u001a\u00020!J\u0010\u0010$\u001a\u00020\u00002\b\b\u0001\u0010G\u001a\u00020!J\u000e\u0010(\u001a\u00020\u00002\u0006\u0010G\u001a\u00020\u0015J\u000e\u0010-\u001a\u00020\u00002\u0006\u0010G\u001a\u00020*J\u0010\u0010J\u001a\u00020\u00002\b\b\u0001\u0010G\u001a\u00020!J\u0017\u0010;\u001a\u00020\u00002\n\b\u0001\u0010G\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010KJ\u0017\u0010C\u001a\u00020\u00002\n\b\u0001\u0010G\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010KJ\u000e\u0010@\u001a\u00020\u00002\u0006\u0010G\u001a\u00020\u0015J\u0010\u0010L\u001a\u00020\u00002\b\b\u0001\u0010G\u001a\u00020!J\u0010\u0010M\u001a\u00020\u00002\b\b\u0001\u0010G\u001a\u00020!J\u000e\u00101\u001a\u00020\u00002\u0006\u0010G\u001a\u00020!J\u0010\u00101\u001a\u00020\u00002\b\u0010G\u001a\u0004\u0018\u000103J\u000e\u0010F\u001a\u00020\u00002\u0006\u0010G\u001a\u00020!J\u0006\u0010N\u001a\u00020OR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0011\"\u0004\b\u001c\u0010\u0013R\u001a\u0010\u001d\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0011\"\u0004\b\u001f\u0010\u0013R\u001e\u0010 \u001a\u00020!8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0017\"\u0004\b(\u0010\u0019R\u001c\u0010)\u001a\u0004\u0018\u00010*X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001a\u0010/\u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010#\"\u0004\b1\u0010%R\u001c\u00102\u001a\u0004\u0018\u000103X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001e\u00108\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010=\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001a\u0010>\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u0017\"\u0004\b@\u0010\u0019R\u001e\u0010A\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u0010\n\u0002\u0010=\u001a\u0004\bB\u0010:\"\u0004\bC\u0010<R\u001a\u0010D\u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010#\"\u0004\bF\u0010%¨\u0006P"}, d2 = {"Lcom/skydoves/balloon/TextForm$Builder;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "text", "", "getText", "()Ljava/lang/CharSequence;", "setText", "(Ljava/lang/CharSequence;)V", "textSize", "", "getTextSize", "()F", "setTextSize", "(F)V", "enableAutoSized", "", "getEnableAutoSized", "()Z", "setEnableAutoSized", "(Z)V", "minAutoSizeTextSize", "getMinAutoSizeTextSize", "setMinAutoSizeTextSize", "maxAutoSizeTextSize", "getMaxAutoSizeTextSize", "setMaxAutoSizeTextSize", "textColor", "", "getTextColor", "()I", "setTextColor", "(I)V", "textIsHtml", "getTextIsHtml", "setTextIsHtml", "movementMethod", "Landroid/text/method/MovementMethod;", "getMovementMethod", "()Landroid/text/method/MovementMethod;", "setMovementMethod", "(Landroid/text/method/MovementMethod;)V", "textTypeface", "getTextTypeface", "setTextTypeface", "textTypefaceObject", "Landroid/graphics/Typeface;", "getTextTypefaceObject", "()Landroid/graphics/Typeface;", "setTextTypefaceObject", "(Landroid/graphics/Typeface;)V", "textLineSpacing", "getTextLineSpacing", "()Ljava/lang/Float;", "setTextLineSpacing", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "includeFontPadding", "getIncludeFontPadding", "setIncludeFontPadding", "textLetterSpacing", "getTextLetterSpacing", "setTextLetterSpacing", "textGravity", "getTextGravity", "setTextGravity", "value", "setTextResource", "setTextSizeResource", "setTextColorResource", "(Ljava/lang/Float;)Lcom/skydoves/balloon/TextForm$Builder;", "setTextLineSpacingResource", "setTextLetterSpacingResource", "build", "Lcom/skydoves/balloon/TextForm;", "balloon_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    @TextFormDsl
    public static final class Builder {
        private final Context context;
        private boolean enableAutoSized;
        private boolean includeFontPadding;
        private float maxAutoSizeTextSize;
        private float minAutoSizeTextSize;
        private MovementMethod movementMethod;
        private CharSequence text;
        private int textColor;
        private int textGravity;
        private boolean textIsHtml;
        private Float textLetterSpacing;
        private Float textLineSpacing;
        private float textSize;
        private int textTypeface;
        private Typeface textTypefaceObject;

        public Builder(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            this.context = context;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            this.text = "";
            this.textSize = 12.0f;
            this.enableAutoSized = true;
            this.minAutoSizeTextSize = 12.0f;
            this.maxAutoSizeTextSize = 12.0f + 1;
            this.textColor = -1;
            this.includeFontPadding = true;
            this.textGravity = 17;
        }

        public final Context getContext() {
            return this.context;
        }

        public final CharSequence getText() {
            return this.text;
        }

        /* JADX INFO: renamed from: setText, reason: collision with other method in class */
        public final /* synthetic */ void m3738setText(CharSequence charSequence) {
            Intrinsics.checkNotNullParameter(charSequence, "<set-?>");
            this.text = charSequence;
        }

        public final float getTextSize() {
            return this.textSize;
        }

        /* JADX INFO: renamed from: setTextSize, reason: collision with other method in class */
        public final /* synthetic */ void m3744setTextSize(float f) {
            this.textSize = f;
        }

        public final boolean getEnableAutoSized() {
            return this.enableAutoSized;
        }

        /* JADX INFO: renamed from: setEnableAutoSized, reason: collision with other method in class */
        public final /* synthetic */ void m3733setEnableAutoSized(boolean z) {
            this.enableAutoSized = z;
        }

        public final float getMinAutoSizeTextSize() {
            return this.minAutoSizeTextSize;
        }

        /* JADX INFO: renamed from: setMinAutoSizeTextSize, reason: collision with other method in class */
        public final /* synthetic */ void m3736setMinAutoSizeTextSize(float f) {
            this.minAutoSizeTextSize = f;
        }

        public final float getMaxAutoSizeTextSize() {
            return this.maxAutoSizeTextSize;
        }

        /* JADX INFO: renamed from: setMaxAutoSizeTextSize, reason: collision with other method in class */
        public final /* synthetic */ void m3735setMaxAutoSizeTextSize(float f) {
            this.maxAutoSizeTextSize = f;
        }

        public final int getTextColor() {
            return this.textColor;
        }

        /* JADX INFO: renamed from: setTextColor, reason: collision with other method in class */
        public final /* synthetic */ void m3739setTextColor(int i) {
            this.textColor = i;
        }

        public final boolean getTextIsHtml() {
            return this.textIsHtml;
        }

        /* JADX INFO: renamed from: setTextIsHtml, reason: collision with other method in class */
        public final /* synthetic */ void m3741setTextIsHtml(boolean z) {
            this.textIsHtml = z;
        }

        public final MovementMethod getMovementMethod() {
            return this.movementMethod;
        }

        /* JADX INFO: renamed from: setMovementMethod, reason: collision with other method in class */
        public final /* synthetic */ void m3737setMovementMethod(MovementMethod movementMethod) {
            this.movementMethod = movementMethod;
        }

        public final int getTextTypeface() {
            return this.textTypeface;
        }

        /* JADX INFO: renamed from: setTextTypeface, reason: collision with other method in class */
        public final /* synthetic */ void m3745setTextTypeface(int i) {
            this.textTypeface = i;
        }

        public final Typeface getTextTypefaceObject() {
            return this.textTypefaceObject;
        }

        public final /* synthetic */ void setTextTypefaceObject(Typeface typeface) {
            this.textTypefaceObject = typeface;
        }

        public final Float getTextLineSpacing() {
            return this.textLineSpacing;
        }

        /* JADX INFO: renamed from: setTextLineSpacing, reason: collision with other method in class */
        public final /* synthetic */ void m3743setTextLineSpacing(Float f) {
            this.textLineSpacing = f;
        }

        public final boolean getIncludeFontPadding() {
            return this.includeFontPadding;
        }

        /* JADX INFO: renamed from: setIncludeFontPadding, reason: collision with other method in class */
        public final /* synthetic */ void m3734setIncludeFontPadding(boolean z) {
            this.includeFontPadding = z;
        }

        public final Float getTextLetterSpacing() {
            return this.textLetterSpacing;
        }

        /* JADX INFO: renamed from: setTextLetterSpacing, reason: collision with other method in class */
        public final /* synthetic */ void m3742setTextLetterSpacing(Float f) {
            this.textLetterSpacing = f;
        }

        public final int getTextGravity() {
            return this.textGravity;
        }

        /* JADX INFO: renamed from: setTextGravity, reason: collision with other method in class */
        public final /* synthetic */ void m3740setTextGravity(int i) {
            this.textGravity = i;
        }

        public final Builder setText(CharSequence value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.text = value;
            return this;
        }

        public final Builder setEnableAutoSized(boolean value) {
            this.enableAutoSized = value;
            return this;
        }

        public final Builder setMinAutoSizeTextSize(float value) {
            this.minAutoSizeTextSize = value;
            return this;
        }

        public final Builder setMaxAutoSizeTextSize(float value) {
            this.maxAutoSizeTextSize = value;
            return this;
        }

        public final Builder setTextResource(int value) {
            this.text = this.context.getString(value);
            return this;
        }

        public final Builder setTextSize(float value) {
            this.textSize = value;
            return this;
        }

        public final Builder setTextSizeResource(int value) {
            Context context = this.context;
            this.textSize = ContextExtensionKt.px2Sp(context, ContextExtensionKt.dimen(context, value));
            return this;
        }

        public final Builder setTextColor(int value) {
            this.textColor = value;
            return this;
        }

        public final Builder setTextIsHtml(boolean value) {
            this.textIsHtml = value;
            return this;
        }

        public final Builder setMovementMethod(MovementMethod value) {
            Intrinsics.checkNotNullParameter(value, "value");
            this.movementMethod = value;
            return this;
        }

        public final Builder setTextColorResource(int value) {
            this.textColor = ContextExtensionKt.contextColor(this.context, value);
            return this;
        }

        public final Builder setTextLineSpacing(Float value) {
            this.textLineSpacing = value;
            return this;
        }

        public final Builder setTextLetterSpacing(Float value) {
            this.textLetterSpacing = value;
            return this;
        }

        public final Builder setIncludeFontPadding(boolean value) {
            this.includeFontPadding = value;
            return this;
        }

        public final Builder setTextLineSpacingResource(int value) {
            this.textLineSpacing = Float.valueOf(ContextExtensionKt.dimen(this.context, value));
            return this;
        }

        public final Builder setTextLetterSpacingResource(int value) {
            this.textLetterSpacing = Float.valueOf(ContextExtensionKt.dimen(this.context, value));
            return this;
        }

        public final Builder setTextTypeface(int value) {
            this.textTypeface = value;
            return this;
        }

        public final Builder setTextTypeface(Typeface value) {
            this.textTypefaceObject = value;
            return this;
        }

        public final Builder setTextGravity(int value) {
            this.textGravity = value;
            return this;
        }

        public final TextForm build() {
            return new TextForm(this, null);
        }
    }
}
