package com.skydoves.balloon.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.skydoves.balloon.R;
import com.skydoves.balloon.overlay.BalloonAnchorOverlayView;

/* JADX INFO: loaded from: classes4.dex */
public final class BalloonLayoutOverlayBinding implements ViewBinding {
    public final BalloonAnchorOverlayView balloonOverlayView;
    private final BalloonAnchorOverlayView rootView;

    private BalloonLayoutOverlayBinding(BalloonAnchorOverlayView balloonAnchorOverlayView, BalloonAnchorOverlayView balloonAnchorOverlayView2) {
        this.rootView = balloonAnchorOverlayView;
        this.balloonOverlayView = balloonAnchorOverlayView2;
    }

    @Override // androidx.viewbinding.ViewBinding
    public BalloonAnchorOverlayView getRoot() {
        return this.rootView;
    }

    public static BalloonLayoutOverlayBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    public static BalloonLayoutOverlayBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View viewInflate = layoutInflater.inflate(R.layout.balloon_layout_overlay, viewGroup, false);
        if (z) {
            viewGroup.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static BalloonLayoutOverlayBinding bind(View view) {
        if (view == null) {
            throw new NullPointerException("rootView");
        }
        BalloonAnchorOverlayView balloonAnchorOverlayView = (BalloonAnchorOverlayView) view;
        return new BalloonLayoutOverlayBinding(balloonAnchorOverlayView, balloonAnchorOverlayView);
    }
}
