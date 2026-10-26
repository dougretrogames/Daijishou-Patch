package com.skydoves.balloon.extensions;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.text.Spanned;
import android.text.method.MovementMethod;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.widget.TextViewCompat;
import com.skydoves.balloon.IconForm;
import com.skydoves.balloon.IconGravity;
import com.skydoves.balloon.TextForm;
import com.skydoves.balloon.vectortext.VectorTextView;
import com.skydoves.balloon.vectortext.VectorTextViewParams;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* INFO: compiled from: TextViewExtension.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002\u001a\u0014\u0010\t\u001a\u00020\u0001*\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0000\u001a\u0014\u0010\r\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000fH\u0000\"\u0019\u0010\u0010\u001a\u00020\u0011*\u00020\u00028À\u0002X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"applyTextForm", "", "Landroid/widget/TextView;", "textForm", "Lcom/skydoves/balloon/TextForm;", "fromHtml", "Landroid/text/Spanned;", "text", "", "applyIconForm", "Lcom/skydoves/balloon/vectortext/VectorTextView;", "iconForm", "Lcom/skydoves/balloon/IconForm;", "applyDrawable", "vectorTextViewParams", "Lcom/skydoves/balloon/vectortext/VectorTextViewParams;", "sumOfCompoundPadding", "", "getSumOfCompoundPadding", "(Landroid/widget/TextView;)I", "balloon_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class TextViewExtensionKt {

    /* INFO: compiled from: TextViewExtension.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[IconGravity.values().length];
            try {
                iArr[IconGravity.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[IconGravity.TOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[IconGravity.BOTTOM.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[IconGravity.END.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final /* synthetic */ void applyTextForm(TextView textView, TextForm textForm) {
        Spanned text;
        Intrinsics.checkNotNullParameter(textView, "<this>");
        Intrinsics.checkNotNullParameter(textForm, "textForm");
        boolean textIsHtml = textForm.getTextIsHtml();
        if (textIsHtml) {
            text = fromHtml(textForm.getText().toString());
        } else {
            if (textIsHtml) {
                throw new NoWhenBranchMatchedException();
            }
            text = textForm.getText();
        }
        textView.setText(text);
        textView.setTextSize(textForm.getTextSize());
        textView.setGravity(textForm.getTextGravity());
        textView.setTextColor(textForm.getTextColor());
        textView.setIncludeFontPadding(textForm.getIncludeFontPadding());
        Float textLineSpacing = textForm.getTextLineSpacing();
        if (textLineSpacing != null) {
            textView.setLineSpacing(textLineSpacing.floatValue(), 1.0f);
        }
        Float textLetterSpacing = textForm.getTextLetterSpacing();
        if (textLetterSpacing != null) {
            textView.setLetterSpacing(textLetterSpacing.floatValue());
        }
        Typeface textTypeface = textForm.getTextTypeface();
        if (textTypeface != null) {
            textView.setTypeface(textTypeface);
        } else {
            textView.setTypeface(textView.getTypeface(), textForm.getTextStyle());
        }
        MovementMethod movementMethod = textForm.getMovementMethod();
        if (movementMethod != null) {
            textView.setMovementMethod(movementMethod);
        }
        if (textForm.getEnableAutoSized()) {
            TextViewCompat.setAutoSizeTextTypeUniformWithConfiguration(textView, (int) textForm.getMinAutoSizeTextSize(), (int) textForm.getMaxAutoSizeTextSize(), 1, 1);
        }
    }

    private static final Spanned fromHtml(String str) {
        return Html.fromHtml(str, 0);
    }

    public static final /* synthetic */ void applyIconForm(VectorTextView vectorTextView, IconForm iconForm) {
        Intrinsics.checkNotNullParameter(vectorTextView, "<this>");
        Intrinsics.checkNotNullParameter(iconForm, "iconForm");
        if (iconForm.getDrawable() != null) {
            int iconWidth = iconForm.getIconWidth();
            int iconHeight = iconForm.getIconHeight();
            int iconSpace = iconForm.getIconSpace();
            CharSequence iconContentDescription = iconForm.getIconContentDescription();
            Integer numValueOf = Integer.valueOf(iconForm.getIconColor());
            if (!Boolean.valueOf(numValueOf.intValue() != Integer.MIN_VALUE).booleanValue()) {
                numValueOf = null;
            }
            VectorTextViewParams vectorTextViewParams = new VectorTextViewParams(null, null, null, null, null, null, null, null, false, iconContentDescription, Integer.valueOf(iconSpace), Integer.valueOf(iconWidth), Integer.valueOf(iconHeight), null, numValueOf, null, null, null, 238079, null);
            int i = WhenMappings.$EnumSwitchMapping$0[iconForm.getIconGravity().ordinal()];
            if (i == 1) {
                vectorTextViewParams.setDrawableStart(iconForm.getDrawable());
                vectorTextViewParams.setDrawableStartRes(iconForm.getDrawableRes());
            } else if (i == 2) {
                vectorTextViewParams.setDrawableTop(iconForm.getDrawable());
                vectorTextViewParams.setDrawableTopRes(iconForm.getDrawableRes());
            } else if (i == 3) {
                vectorTextViewParams.setDrawableBottom(iconForm.getDrawable());
                vectorTextViewParams.setDrawableBottomRes(iconForm.getDrawableRes());
            } else {
                if (i != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                vectorTextViewParams.setDrawableEnd(iconForm.getDrawable());
                vectorTextViewParams.setDrawableEndRes(iconForm.getDrawableRes());
            }
            vectorTextView.setDrawableTextViewParams(vectorTextViewParams);
        }
    }

    /* WARN: Code duplicated, block: B:35:0x00c9  */
    /* WARN: Code duplicated, block: B:46:0x00fe  */
    /* WARN: Code duplicated, block: B:57:0x0133  */
    public static final /* synthetic */ void applyDrawable(TextView textView, VectorTextViewParams vectorTextViewParams) {
        Drawable drawableTint;
        Drawable drawableTint2;
        Drawable drawableTint3;
        Intrinsics.checkNotNullParameter(textView, "<this>");
        Intrinsics.checkNotNullParameter(vectorTextViewParams, "vectorTextViewParams");
        Integer iconHeight = vectorTextViewParams.getIconHeight();
        Drawable drawableTint4 = null;
        if (iconHeight == null) {
            Integer heightRes = vectorTextViewParams.getHeightRes();
            if (heightRes != null) {
                iconHeight = Integer.valueOf(textView.getContext().getResources().getDimensionPixelSize(heightRes.intValue()));
            } else {
                iconHeight = null;
            }
            if (iconHeight == null) {
                Integer squareSizeRes = vectorTextViewParams.getSquareSizeRes();
                if (squareSizeRes != null) {
                    iconHeight = Integer.valueOf(textView.getContext().getResources().getDimensionPixelSize(squareSizeRes.intValue()));
                } else {
                    iconHeight = null;
                }
            }
        }
        Integer iconWidth = vectorTextViewParams.getIconWidth();
        if (iconWidth == null) {
            Integer widthRes = vectorTextViewParams.getWidthRes();
            if (widthRes != null) {
                iconWidth = Integer.valueOf(textView.getContext().getResources().getDimensionPixelSize(widthRes.intValue()));
            } else {
                iconWidth = null;
            }
            if (iconWidth == null) {
                Integer squareSizeRes2 = vectorTextViewParams.getSquareSizeRes();
                if (squareSizeRes2 != null) {
                    iconWidth = Integer.valueOf(textView.getContext().getResources().getDimensionPixelSize(squareSizeRes2.intValue()));
                } else {
                    iconWidth = null;
                }
            }
        }
        Drawable drawableStart = vectorTextViewParams.getDrawableStart();
        if (drawableStart == null) {
            Integer drawableStartRes = vectorTextViewParams.getDrawableStartRes();
            if (drawableStartRes != null) {
                drawableStart = AppCompatResources.getDrawable(textView.getContext(), drawableStartRes.intValue());
            } else {
                drawableStart = null;
            }
        }
        if (drawableStart != null) {
            Context context = textView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            Drawable drawableResize = DrawableExtensionKt.resize(drawableStart, context, iconWidth, iconHeight);
            if (drawableResize != null) {
                drawableTint = DrawableExtensionKt.tint(drawableResize, vectorTextViewParams.getTintColor());
            } else {
                drawableTint = null;
            }
        } else {
            drawableTint = null;
        }
        Drawable drawableEnd = vectorTextViewParams.getDrawableEnd();
        if (drawableEnd == null) {
            Integer drawableEndRes = vectorTextViewParams.getDrawableEndRes();
            if (drawableEndRes != null) {
                drawableEnd = AppCompatResources.getDrawable(textView.getContext(), drawableEndRes.intValue());
            } else {
                drawableEnd = null;
            }
        }
        if (drawableEnd != null) {
            Context context2 = textView.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "getContext(...)");
            Drawable drawableResize2 = DrawableExtensionKt.resize(drawableEnd, context2, iconWidth, iconHeight);
            if (drawableResize2 != null) {
                drawableTint2 = DrawableExtensionKt.tint(drawableResize2, vectorTextViewParams.getTintColor());
            } else {
                drawableTint2 = null;
            }
        } else {
            drawableTint2 = null;
        }
        Drawable drawableBottom = vectorTextViewParams.getDrawableBottom();
        if (drawableBottom == null) {
            Integer drawableBottomRes = vectorTextViewParams.getDrawableBottomRes();
            if (drawableBottomRes != null) {
                drawableBottom = AppCompatResources.getDrawable(textView.getContext(), drawableBottomRes.intValue());
            } else {
                drawableBottom = null;
            }
        }
        if (drawableBottom != null) {
            Context context3 = textView.getContext();
            Intrinsics.checkNotNullExpressionValue(context3, "getContext(...)");
            Drawable drawableResize3 = DrawableExtensionKt.resize(drawableBottom, context3, iconWidth, iconHeight);
            if (drawableResize3 != null) {
                drawableTint3 = DrawableExtensionKt.tint(drawableResize3, vectorTextViewParams.getTintColor());
            } else {
                drawableTint3 = null;
            }
        } else {
            drawableTint3 = null;
        }
        Drawable drawableTop = vectorTextViewParams.getDrawableTop();
        if (drawableTop == null) {
            Integer drawableTopRes = vectorTextViewParams.getDrawableTopRes();
            if (drawableTopRes != null) {
                drawableTop = AppCompatResources.getDrawable(textView.getContext(), drawableTopRes.intValue());
            } else {
                drawableTop = null;
            }
        }
        if (drawableTop != null) {
            Context context4 = textView.getContext();
            Intrinsics.checkNotNullExpressionValue(context4, "getContext(...)");
            Drawable drawableResize4 = DrawableExtensionKt.resize(drawableTop, context4, iconWidth, iconHeight);
            if (drawableResize4 != null) {
                drawableTint4 = DrawableExtensionKt.tint(drawableResize4, vectorTextViewParams.getTintColor());
            }
        }
        if (vectorTextViewParams.isRtlLayout()) {
            textView.setCompoundDrawablesWithIntrinsicBounds(drawableTint2, drawableTint4, drawableTint, drawableTint3);
        } else {
            textView.setCompoundDrawablesWithIntrinsicBounds(drawableTint, drawableTint4, drawableTint2, drawableTint3);
        }
        Integer compoundDrawablePadding = vectorTextViewParams.getCompoundDrawablePadding();
        if (compoundDrawablePadding != null) {
            textView.setCompoundDrawablePadding(compoundDrawablePadding.intValue());
        } else {
            Integer compoundDrawablePaddingRes = vectorTextViewParams.getCompoundDrawablePaddingRes();
            if (compoundDrawablePaddingRes != null) {
                textView.setCompoundDrawablePadding(textView.getContext().getResources().getDimensionPixelSize(compoundDrawablePaddingRes.intValue()));
            }
        }
        textView.setContentDescription(vectorTextViewParams.getContentDescription());
    }

    public static final /* synthetic */ int getSumOfCompoundPadding(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        return textView.getCompoundPaddingStart() + textView.getCompoundPaddingEnd();
    }
}
