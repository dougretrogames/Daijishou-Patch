package com.magneticchen.daijishou.daijishou_widget.widgets.retro_achievements;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Transformations;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.BaseRequestOptions;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.imageview.ShapeableImageView;
import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.daijishou_widget.abstract_widget_classes.WidgetFaceFragment;
import com.magneticchen.daijishou.retro_achievements.retro_achievements_db.RetroAchievementsUserProfileEntity;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: RetroAchievementsFaceFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/magneticchen/daijishou/daijishou_widget/widgets/retro_achievements/RetroAchievementsFaceFragment;", "Lcom/magneticchen/daijishou/daijishou_widget/abstract_widget_classes/WidgetFaceFragment;", "()V", "cachedProfileImageUrl", "", "cachedUserProfile", "Lcom/magneticchen/daijishou/retro_achievements/retro_achievements_db/RetroAchievementsUserProfileEntity;", "points", "Landroid/widget/TextView;", "thumbnail", "Lcom/google/android/material/imageview/ShapeableImageView;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class RetroAchievementsFaceFragment extends WidgetFaceFragment {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private String cachedProfileImageUrl;
    private RetroAchievementsUserProfileEntity cachedUserProfile;
    public TextView points;
    private ShapeableImageView thumbnail;

    /* JADX INFO: compiled from: RetroAchievementsFaceFragment.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/magneticchen/daijishou/daijishou_widget/widgets/retro_achievements/RetroAchievementsFaceFragment$Companion;", "", "()V", "newInstance", "Lcom/magneticchen/daijishou/daijishou_widget/widgets/retro_achievements/RetroAchievementsFaceFragment;", "widgetInstanceId", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final RetroAchievementsFaceFragment newInstance(long widgetInstanceId) {
            RetroAchievementsFaceFragment retroAchievementsFaceFragment = new RetroAchievementsFaceFragment();
            Bundle bundle = new Bundle();
            bundle.putLong("widgetInstanceId", widgetInstanceId);
            retroAchievementsFaceFragment.setArguments(bundle);
            return retroAchievementsFaceFragment;
        }
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewInflate = inflater.inflate(R.layout.widget_face_retro_achievements_user_profile, container, false);
        View viewFindViewById = viewInflate.findViewById(R.id.widget_nav_retro_achievements_user_profile_thumbnail);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        this.thumbnail = (ShapeableImageView) viewFindViewById;
        View viewFindViewById2 = viewInflate.findViewById(R.id.widget_face_retro_achievements_user_profile_points);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
        this.points = (TextView) viewFindViewById2;
        Context applicationContext = requireContext().getApplicationContext();
        Intrinsics.checkNotNull(applicationContext, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication");
        setRetroAchievementsManager(((DaijishouApplication) applicationContext).getRetroAchievementsManager());
        RetroAchievementsUserProfileEntity retroAchievementsUserProfileEntity = this.cachedUserProfile;
        if (retroAchievementsUserProfileEntity != null) {
            TextView textView = this.points;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("points");
                textView = null;
            }
            RetroAchievementsUserProfileEntity retroAchievementsUserProfileEntity2 = this.cachedUserProfile;
            Intrinsics.checkNotNull(retroAchievementsUserProfileEntity2);
            int softcorePoints = retroAchievementsUserProfileEntity2.getSoftcorePoints();
            RetroAchievementsUserProfileEntity retroAchievementsUserProfileEntity3 = this.cachedUserProfile;
            Intrinsics.checkNotNull(retroAchievementsUserProfileEntity3);
            textView.setText(getString(R.string.achievement_points_format, Integer.valueOf(softcorePoints + retroAchievementsUserProfileEntity3.getHardcorePoints())));
            RequestBuilder<Drawable> requestBuilderTransition = Glide.with(this).load((Object) retroAchievementsUserProfileEntity.getImageUrl()).apply((BaseRequestOptions<?>) RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.NONE)).transition(DrawableTransitionOptions.withCrossFade());
            ShapeableImageView shapeableImageView = this.thumbnail;
            if (shapeableImageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("thumbnail");
                shapeableImageView = null;
            }
            requestBuilderTransition.into(shapeableImageView);
        }
        Transformations.switchMap(getRetroAchievementsManager().getMyUsernameLiveData(), new RetroAchievementsFaceFragment$onCreateView$userProfileLiveData$1(this)).observe(getViewLifecycleOwner(), new RetroAchievementsFaceFragment$sam$androidx_lifecycle_Observer$0(new AnonymousClass2()));
        getRetroAchievementsManager().getRefreshingUsernamesLiveData().observe(getViewLifecycleOwner(), new RetroAchievementsFaceFragment$sam$androidx_lifecycle_Observer$0(new AnonymousClass3()));
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new AnonymousClass4(null), 2, null);
        return viewInflate;
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.daijishou_widget.widgets.retro_achievements.RetroAchievementsFaceFragment$onCreateView$2, reason: invalid class name */
    /* JADX INFO: compiled from: RetroAchievementsFaceFragment.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "userProfile", "Lcom/magneticchen/daijishou/retro_achievements/retro_achievements_db/RetroAchievementsUserProfileEntity;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class AnonymousClass2 extends Lambda<Unit> implements Function1<RetroAchievementsUserProfileEntity, Unit> {
        AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RetroAchievementsUserProfileEntity retroAchievementsUserProfileEntity) {
            invoke2(retroAchievementsUserProfileEntity);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RetroAchievementsUserProfileEntity retroAchievementsUserProfileEntity) {
            ShapeableImageView shapeableImageView = null;
            if (retroAchievementsUserProfileEntity == null) {
                RequestManager requestManagerWith = Glide.with(RetroAchievementsFaceFragment.this);
                ShapeableImageView shapeableImageView2 = RetroAchievementsFaceFragment.this.thumbnail;
                if (shapeableImageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("thumbnail");
                    shapeableImageView2 = null;
                }
                requestManagerWith.clear(shapeableImageView2);
                TextView textView = RetroAchievementsFaceFragment.this.points;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("points");
                    textView = null;
                }
                textView.setText(RetroAchievementsFaceFragment.this.getString(R.string.login));
            }
            if (retroAchievementsUserProfileEntity != null) {
                RetroAchievementsFaceFragment retroAchievementsFaceFragment = RetroAchievementsFaceFragment.this;
                retroAchievementsFaceFragment.cachedUserProfile = retroAchievementsUserProfileEntity;
                TextView textView2 = retroAchievementsFaceFragment.points;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("points");
                    textView2 = null;
                }
                RetroAchievementsUserProfileEntity retroAchievementsUserProfileEntity2 = retroAchievementsFaceFragment.cachedUserProfile;
                Intrinsics.checkNotNull(retroAchievementsUserProfileEntity2);
                int softcorePoints = retroAchievementsUserProfileEntity2.getSoftcorePoints();
                RetroAchievementsUserProfileEntity retroAchievementsUserProfileEntity3 = retroAchievementsFaceFragment.cachedUserProfile;
                Intrinsics.checkNotNull(retroAchievementsUserProfileEntity3);
                textView2.setText(retroAchievementsFaceFragment.getString(R.string.achievement_points_format, Integer.valueOf(softcorePoints + retroAchievementsUserProfileEntity3.getHardcorePoints())));
                RetroAchievementsUserProfileEntity retroAchievementsUserProfileEntity4 = retroAchievementsFaceFragment.cachedUserProfile;
                Intrinsics.checkNotNull(retroAchievementsUserProfileEntity4);
                if (retroAchievementsUserProfileEntity4.getImageUrl() != null) {
                    RetroAchievementsUserProfileEntity retroAchievementsUserProfileEntity5 = retroAchievementsFaceFragment.cachedUserProfile;
                    Intrinsics.checkNotNull(retroAchievementsUserProfileEntity5);
                    retroAchievementsFaceFragment.cachedProfileImageUrl = retroAchievementsUserProfileEntity5.getImageUrl();
                    RequestManager requestManagerWith2 = Glide.with(retroAchievementsFaceFragment);
                    RetroAchievementsUserProfileEntity retroAchievementsUserProfileEntity6 = retroAchievementsFaceFragment.cachedUserProfile;
                    Intrinsics.checkNotNull(retroAchievementsUserProfileEntity6);
                    RequestBuilder<Drawable> requestBuilderTransition = requestManagerWith2.load((Object) retroAchievementsUserProfileEntity6.getImageUrl()).apply((BaseRequestOptions<?>) RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.NONE)).transition(DrawableTransitionOptions.withCrossFade());
                    ShapeableImageView shapeableImageView3 = retroAchievementsFaceFragment.thumbnail;
                    if (shapeableImageView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("thumbnail");
                    } else {
                        shapeableImageView = shapeableImageView3;
                    }
                    requestBuilderTransition.into(shapeableImageView);
                    return;
                }
                RequestManager requestManagerWith3 = Glide.with(retroAchievementsFaceFragment);
                ShapeableImageView shapeableImageView4 = retroAchievementsFaceFragment.thumbnail;
                if (shapeableImageView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("thumbnail");
                } else {
                    shapeableImageView = shapeableImageView4;
                }
                requestManagerWith3.clear(shapeableImageView);
            }
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.daijishou_widget.widgets.retro_achievements.RetroAchievementsFaceFragment$onCreateView$3, reason: invalid class name */
    /* JADX INFO: compiled from: RetroAchievementsFaceFragment.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "it", "", "", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    final class AnonymousClass3 extends Lambda<Unit> implements Function1<List<? extends String>, Unit> {
        AnonymousClass3() {
            super(1);
        }

        /* JADX INFO: renamed from: com.magneticchen.daijishou.daijishou_widget.widgets.retro_achievements.RetroAchievementsFaceFragment$onCreateView$3$1, reason: invalid class name */
        /* JADX INFO: compiled from: RetroAchievementsFaceFragment.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.magneticchen.daijishou.daijishou_widget.widgets.retro_achievements.RetroAchievementsFaceFragment$onCreateView$3$1", f = "RetroAchievementsFaceFragment.kt", i = {}, l = {125, 127}, m = "invokeSuspendImpl", n = {}, s = {})
        final class AnonymousClass1 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
            final /* synthetic */ List<String> $it;
            int label;
            final /* synthetic */ RetroAchievementsFaceFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(RetroAchievementsFaceFragment retroAchievementsFaceFragment, List<String> list, Continuation<?> continuation) {
                super(2, continuation);
                this.this$0 = retroAchievementsFaceFragment;
                this.$it = list;
            }


            public final Continuation create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, this.$it, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
                try {
                    try {
                        return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspendImpl(Unit.INSTANCE);
                    } catch (Throwable th) {
                        throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
                    }
                } catch (Throwable th) {
                    throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
                }
            }

            /* JADX WARN: Code restructure failed: missing block: B:18:0x0055, code lost:
            
                if (kotlinx.coroutines.BuildersKt.withContext(r6, r1, r5) == r0) goto L19;
             */

            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspendImpl(java.lang.Object r6) throws java.lang.Throwable {
                /*
                    r5 = this;
                    java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r1 = r5.label
                    r2 = 2
                    r3 = 1
                    if (r1 == 0) goto L1e
                    if (r1 == r3) goto L1a
                    if (r1 != r2) goto L12
                    kotlin.ResultKt.throwOnFailure(r6)
                    goto L58
                L12:
                    java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r6.<init>(r0)
                    throw r6
                L1a:
                    kotlin.ResultKt.throwOnFailure(r6)
                    goto L33
                L1e:
                    kotlin.ResultKt.throwOnFailure(r6)
                    com.magneticchen.daijishou.daijishou_widget.widgets.retro_achievements.RetroAchievementsFaceFragment r6 = r5.this$0
                    com.magneticchen.daijishou.retro_achievements.RetroAchievementsManager r6 = com.magneticchen.daijishou.daijishou_widget.widgets.retro_achievements.RetroAchievementsFaceFragment.access$getRetroAchievementsManager(r6)
                    r1 = r5
                    kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
                    r5.label = r3
                    java.lang.Object r6 = r6.getMyRetroAchievementsUsername(r1)
                    if (r6 != r0) goto L33
                    goto L57
                L33:
                    java.lang.String r6 = (java.lang.String) r6
                    if (r6 == 0) goto L58
                    java.util.List<java.lang.String> r1 = r5.$it
                    com.magneticchen.daijishou.daijishou_widget.widgets.retro_achievements.RetroAchievementsFaceFragment r3 = r5.this$0
                    boolean r6 = r1.contains(r6)
                    if (r6 == 0) goto L58
                    kotlinx.coroutines.MainCoroutineDispatcher r6 = kotlinx.coroutines.Dispatchers.getMain()
                    kotlin.coroutines.CoroutineContext r6 = (kotlin.coroutines.CoroutineContext) r6
                    com.magneticchen.daijishou.daijishou_widget.widgets.retro_achievements.RetroAchievementsFaceFragment$onCreateView$3$1$1$1 r1 = new com.magneticchen.daijishou.daijishou_widget.widgets.retro_achievements.RetroAchievementsFaceFragment$onCreateView$3$1$1$1
                    r4 = 0
                    r1.<init>(r3, r4)
                    kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
                    r5.label = r2
                    java.lang.Object r6 = kotlinx.coroutines.BuildersKt.withContext(r6, r1, r5)
                    if (r6 != r0) goto L58
                L57:
                    return r0
                L58:
                    kotlin.Unit r6 = kotlin.Unit.INSTANCE
                    return r6
                */
                throw new UnsupportedOperationException("Method not decompiled: com.magneticchen.daijishou.daijishou_widget.widgets.retro_achievements.RetroAchievementsFaceFragment.AnonymousClass3.AnonymousClass1.invokeSuspendImpl(java.lang.Object):java.lang.Object");
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends String> list) {
            invoke2((List<String>) list);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<String> list) {
            BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(RetroAchievementsFaceFragment.this), Dispatchers.getIO(), null, new AnonymousClass1(RetroAchievementsFaceFragment.this, list, null), 2, null);
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.daijishou_widget.widgets.retro_achievements.RetroAchievementsFaceFragment$onCreateView$4, reason: invalid class name */
    /* JADX INFO: compiled from: RetroAchievementsFaceFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.daijishou_widget.widgets.retro_achievements.RetroAchievementsFaceFragment$onCreateView$4", f = "RetroAchievementsFaceFragment.kt", i = {}, l = {136, 138, 142}, m = "invokeSuspendImpl", n = {}, s = {})
    final class AnonymousClass4 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
        int label;

        AnonymousClass4(Continuation<?> continuation) {
            super(2, continuation);
        }


        public final Continuation create(Object obj, Continuation<?> continuation) {
            return RetroAchievementsFaceFragment.this.new AnonymousClass4(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
            try {
                try {
                    return ((AnonymousClass4) create(coroutineScope, continuation)).invokeSuspendImpl(Unit.INSTANCE);
                } catch (Throwable th) {
                    throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
                }
            } catch (Throwable th) {
                throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:18:0x0054, code lost:
        
            if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.magneticchen.daijishou.daijishou_widget.widgets.retro_achievements.RetroAchievementsFaceFragment.AnonymousClass4.AnonymousClass1(r5.this$0, null), r5) == r0) goto L22;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x0066, code lost:
        
            if (r5.this$0.getRetroAchievementsManager().refreshRetroAchievementsUserProfileDataIfExpired(r6, r5) == r0) goto L22;
         */

        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspendImpl(java.lang.Object r6) throws java.lang.Throwable {
            /*
                r5 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r5.label
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L22
                if (r1 == r4) goto L1e
                if (r1 == r3) goto L1a
                if (r1 != r2) goto L12
                goto L1a
            L12:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L1a:
                kotlin.ResultKt.throwOnFailure(r6)
                goto L69
            L1e:
                kotlin.ResultKt.throwOnFailure(r6)
                goto L37
            L22:
                kotlin.ResultKt.throwOnFailure(r6)
                com.magneticchen.daijishou.daijishou_widget.widgets.retro_achievements.RetroAchievementsFaceFragment r6 = com.magneticchen.daijishou.daijishou_widget.widgets.retro_achievements.RetroAchievementsFaceFragment.this
                com.magneticchen.daijishou.retro_achievements.RetroAchievementsManager r6 = com.magneticchen.daijishou.daijishou_widget.widgets.retro_achievements.RetroAchievementsFaceFragment.access$getRetroAchievementsManager(r6)
                r1 = r5
                kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
                r5.label = r4
                java.lang.Object r6 = r6.getMyRetroAchievementsUsername(r1)
                if (r6 != r0) goto L37
                goto L68
            L37:
                java.lang.String r6 = (java.lang.String) r6
                if (r6 != 0) goto L57
                kotlinx.coroutines.MainCoroutineDispatcher r6 = kotlinx.coroutines.Dispatchers.getMain()
                kotlin.coroutines.CoroutineContext r6 = (kotlin.coroutines.CoroutineContext) r6
                com.magneticchen.daijishou.daijishou_widget.widgets.retro_achievements.RetroAchievementsFaceFragment$onCreateView$4$1 r1 = new com.magneticchen.daijishou.daijishou_widget.widgets.retro_achievements.RetroAchievementsFaceFragment$onCreateView$4$1
                com.magneticchen.daijishou.daijishou_widget.widgets.retro_achievements.RetroAchievementsFaceFragment r2 = com.magneticchen.daijishou.daijishou_widget.widgets.retro_achievements.RetroAchievementsFaceFragment.this
                r4 = 0
                r1.<init>(r2, r4)
                kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
                r2 = r5
                kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
                r5.label = r3
                java.lang.Object r6 = kotlinx.coroutines.BuildersKt.withContext(r6, r1, r2)
                if (r6 != r0) goto L69
                goto L68
            L57:
                com.magneticchen.daijishou.daijishou_widget.widgets.retro_achievements.RetroAchievementsFaceFragment r1 = com.magneticchen.daijishou.daijishou_widget.widgets.retro_achievements.RetroAchievementsFaceFragment.this
                com.magneticchen.daijishou.retro_achievements.RetroAchievementsManager r1 = com.magneticchen.daijishou.daijishou_widget.widgets.retro_achievements.RetroAchievementsFaceFragment.access$getRetroAchievementsManager(r1)
                r3 = r5
                kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
                r5.label = r2
                java.lang.Object r6 = r1.refreshRetroAchievementsUserProfileDataIfExpired(r6, r3)
                if (r6 != r0) goto L69
            L68:
                return r0
            L69:
                kotlin.Unit r6 = kotlin.Unit.INSTANCE
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.magneticchen.daijishou.daijishou_widget.widgets.retro_achievements.RetroAchievementsFaceFragment.AnonymousClass4.invokeSuspendImpl(java.lang.Object):java.lang.Object");
        }

        /* JADX INFO: renamed from: com.magneticchen.daijishou.daijishou_widget.widgets.retro_achievements.RetroAchievementsFaceFragment$onCreateView$4$1, reason: invalid class name */
        /* JADX INFO: compiled from: RetroAchievementsFaceFragment.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.magneticchen.daijishou.daijishou_widget.widgets.retro_achievements.RetroAchievementsFaceFragment$onCreateView$4$1", f = "RetroAchievementsFaceFragment.kt", i = {}, l = {}, m = "invokeSuspendImpl", n = {}, s = {})
        final class AnonymousClass1 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
            int label;
            final /* synthetic */ RetroAchievementsFaceFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(RetroAchievementsFaceFragment retroAchievementsFaceFragment, Continuation<?> continuation) {
                super(2, continuation);
                this.this$0 = retroAchievementsFaceFragment;
            }


            public final Continuation create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
                try {
                    try {
                        return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspendImpl(Unit.INSTANCE);
                    } catch (Throwable th) {
                        throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
                    }
                } catch (Throwable th) {
                    throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
                }
            }

            public final Object invokeSuspendImpl(Object obj) throws Throwable {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label == 0) {
                    ResultKt.throwOnFailure(obj);
                    TextView textView = this.this$0.points;
                    if (textView == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("points");
                        textView = null;
                    }
                    textView.setText(this.this$0.getString(R.string.login));
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
    }
}
