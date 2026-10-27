package com.magneticchen.daijishou.ui.activities;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;
import com.magneticchen.daijishou.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: MainActivity.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroid/widget/ImageSwitcher;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class MainActivity$imageSwitcher$2 extends Lambda implements Function0<ImageSwitcher> {
    final /* synthetic */ MainActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MainActivity$imageSwitcher$2(MainActivity mainActivity) {
        super(0);
        this.this$0 = mainActivity;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ImageSwitcher invoke() {
        View viewFindViewById = this.this$0.findViewById(R.id.image_switcher);
        final MainActivity mainActivity = this.this$0;
        ImageSwitcher imageSwitcher = (ImageSwitcher) viewFindViewById;
        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() { // from class: com.magneticchen.daijishou.ui.activities.MainActivity$imageSwitcher$2$$ExternalSyntheticLambda0
            @Override // android.widget.ViewSwitcher.ViewFactory
            public final View makeView() {
                return MainActivity$imageSwitcher$2.invoke$lambda$2$lambda$1(mainActivity);
            }
        });
        return imageSwitcher;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final View invoke$lambda$2$lambda$1(MainActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ImageView imageView = new ImageView(this$0.getApplicationContext());
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        return imageView;
    }
}
