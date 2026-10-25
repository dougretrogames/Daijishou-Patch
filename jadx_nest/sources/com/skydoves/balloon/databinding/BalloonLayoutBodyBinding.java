package com.skydoves.balloon.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.skydoves.balloon.R;
import com.skydoves.balloon.radius.RadiusLayout;
import com.skydoves.balloon.vectortext.VectorTextView;

/* JADX INFO: loaded from: classes4.dex */
public final class BalloonLayoutBodyBinding implements ViewBinding {
    public final FrameLayout balloon;
    public final ImageView balloonArrow;
    public final RadiusLayout balloonCard;
    public final FrameLayout balloonContent;
    public final VectorTextView balloonText;
    public final FrameLayout balloonWrapper;
    private final FrameLayout rootView;

    private BalloonLayoutBodyBinding(FrameLayout frameLayout, FrameLayout frameLayout2, ImageView imageView, RadiusLayout radiusLayout, FrameLayout frameLayout3, VectorTextView vectorTextView, FrameLayout frameLayout4) {
        this.rootView = frameLayout;
        this.balloon = frameLayout2;
        this.balloonArrow = imageView;
        this.balloonCard = radiusLayout;
        this.balloonContent = frameLayout3;
        this.balloonText = vectorTextView;
        this.balloonWrapper = frameLayout4;
    }

    @Override // androidx.viewbinding.ViewBinding
    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static BalloonLayoutBodyBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static BalloonLayoutBodyBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.balloon_layout_body, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BalloonLayoutBodyBinding bind(View view) {
        FrameLayout frameLayout = (FrameLayout) view;
        int i = R.id.balloon_arrow;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, i);
        if (imageView != null) {
            i = R.id.balloon_card;
            RadiusLayout radiusLayout = (RadiusLayout) ViewBindings.findChildViewById(view, i);
            if (radiusLayout != null) {
                i = R.id.balloon_content;
                FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, i);
                if (frameLayout2 != null) {
                    i = R.id.balloon_text;
                    VectorTextView vectorTextView = (VectorTextView) ViewBindings.findChildViewById(view, i);
                    if (vectorTextView != null) {
                        i = R.id.balloon_wrapper;
                        FrameLayout frameLayout3 = (FrameLayout) ViewBindings.findChildViewById(view, i);
                        if (frameLayout3 != null) {
                            return new BalloonLayoutBodyBinding(frameLayout, frameLayout, imageView, radiusLayout, frameLayout2, vectorTextView, frameLayout3);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
