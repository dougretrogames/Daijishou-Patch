package com.magneticchen.daijishou.daijishou_widget.widgets.activity;

import android.graphics.Bitmap;
import android.widget.TextView;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.daijishou_library_db.EventEntity;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: ActivityWidgetTodayFaceFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.magneticchen.daijishou.daijishou_widget.widgets.activity.ActivityWidgetTodayFaceFragment$renewAndUpdateFace$1$1", f = "ActivityWidgetTodayFaceFragment.kt", i = {}, l = {161, 164}, m = "invokeSuspendImpl", n = {}, s = {})
final class ActivityWidgetTodayFaceFragment$renewAndUpdateFace$1$1 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
    final /* synthetic */ long $widgetInstanceId;
    int label;
    final /* synthetic */ ActivityWidgetTodayFaceFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ActivityWidgetTodayFaceFragment$renewAndUpdateFace$1$1(ActivityWidgetTodayFaceFragment activityWidgetTodayFaceFragment, long j, Continuation<?> continuation) {
        super(2, continuation);
        this.this$0 = activityWidgetTodayFaceFragment;
        this.$widgetInstanceId = j;
    }

    public final Continuation create(Object obj, Continuation<?> continuation) {
        return new ActivityWidgetTodayFaceFragment$renewAndUpdateFace$1$1(this.this$0, this.$widgetInstanceId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
        try {
            return ((ActivityWidgetTodayFaceFragment$renewAndUpdateFace$1$1) create(coroutineScope, continuation)).invokeSuspendImpl(Unit.INSTANCE);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }

    public final Object invokeSuspendImpl(Object obj) throws Throwable {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else if (i == 2) {
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            if (!this.this$0.recentEvents.isEmpty()) {
                Ref.IntRef intRef = new Ref.IntRef();
                intRef.element = -1;
                Ref.IntRef intRef2 = new Ref.IntRef();
                Ref.ObjectRef<EventEntity> objectRef = new Ref.ObjectRef<>();
                this.label = 1;
                if (invokeSuspendImpl$tryNext(intRef, this.this$0, intRef2, objectRef, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        }
        CoroutineContext main = (CoroutineContext) Dispatchers.getMain();
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$widgetInstanceId, null);
        this.label = 2;
        if (BuildersKt.withContext(main, anonymousClass1, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    public static final Object access$invokeSuspend$tryNext(Ref.IntRef index, ActivityWidgetTodayFaceFragment fragment, Ref.IntRef backgroundSetCount, Ref.ObjectRef<EventEntity> latestEventWithBackground, Continuation<?> continuation) throws Throwable {
        return invokeSuspendImpl$tryNext(index, fragment, backgroundSetCount, latestEventWithBackground, continuation);
    }

    public static final Object invokeSuspendImpl$tryNext(Ref.IntRef index, ActivityWidgetTodayFaceFragment fragment, Ref.IntRef backgroundSetCount, Ref.ObjectRef<EventEntity> latestEventWithBackground, Continuation<?> continuation) throws Throwable {
        ActivityWidgetTodayFaceFragment$renewAndUpdateFace$1$1$tryNext$1 tryNext1;
        if (continuation instanceof ActivityWidgetTodayFaceFragment$renewAndUpdateFace$1$1$tryNext$1) {
            tryNext1 = (ActivityWidgetTodayFaceFragment$renewAndUpdateFace$1$1$tryNext$1) continuation;
            if ((tryNext1.label & Integer.MIN_VALUE) != 0) {
                tryNext1.label -= Integer.MIN_VALUE;
            } else {
                tryNext1 = new ActivityWidgetTodayFaceFragment$renewAndUpdateFace$1$1$tryNext$1(continuation);
            }
        } else {
            tryNext1 = new ActivityWidgetTodayFaceFragment$renewAndUpdateFace$1$1$tryNext$1(continuation);
        }

        Object obj = tryNext1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int label = tryNext1.label;
        if (label != 0) {
            if (label == 1) {
                latestEventWithBackground = (Ref.ObjectRef) tryNext1.L$3;
                backgroundSetCount = (Ref.IntRef) tryNext1.L$2;
                fragment = (ActivityWidgetTodayFaceFragment) tryNext1.L$1;
                index = (Ref.IntRef) tryNext1.L$0;
                ResultKt.throwOnFailure(obj);
                tryNext1.L$0 = null;
                tryNext1.L$1 = null;
                tryNext1.L$2 = null;
                tryNext1.L$3 = null;
                tryNext1.label = 2;
                if (invokeSuspendImpl$tryNext(index, fragment, backgroundSetCount, latestEventWithBackground, tryNext1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            } else if (label == 2) {
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            } else if (label == 3) {
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            } else if (label == 4) {
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        ResultKt.throwOnFailure(obj);
        index.element++;
        if (index.element >= fragment.recentEvents.size()) {
            return Unit.INSTANCE;
        }

        EventEntity eventEntity = fragment.recentEvents.get(index.element);
        if (backgroundSetCount.element == 0) {
            Bitmap bitmap = fragment.getBitmapFromEvent(eventEntity);
            if (bitmap != null) {
                latestEventWithBackground.element = eventEntity;
                backgroundSetCount.element++;
                fragment.backgroundBitmap = bitmap;
                ActivityWidgetTodayFaceFragment$renewAndUpdateFace$1$1$tryNext$2 tryNext2 = new ActivityWidgetTodayFaceFragment$renewAndUpdateFace$1$1$tryNext$2(fragment, bitmap, null);
                tryNext1.L$0 = index;
                tryNext1.L$1 = fragment;
                tryNext1.L$2 = backgroundSetCount;
                tryNext1.L$3 = latestEventWithBackground;
                tryNext1.label = 1;
                if (BuildersKt.withContext((CoroutineContext) Dispatchers.getMain(), tryNext2, tryNext1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            tryNext1.L$0 = null;
            tryNext1.L$1 = null;
            tryNext1.L$2 = null;
            tryNext1.L$3 = null;
            tryNext1.label = 2;
            if (invokeSuspendImpl$tryNext(index, fragment, backgroundSetCount, latestEventWithBackground, tryNext1) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        } else if (backgroundSetCount.element == 1) {
            EventEntity prevEvent = latestEventWithBackground.element;
            Intrinsics.checkNotNull(prevEvent);
            if (Intrinsics.areEqual(eventEntity.getPlayableItemId(), prevEvent.getPlayableItemId())) {
                tryNext1.label = 3;
                if (invokeSuspendImpl$tryNext(index, fragment, backgroundSetCount, latestEventWithBackground, tryNext1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
            Bitmap bitmap2 = fragment.getBitmapFromEvent(eventEntity);
            if (bitmap2 != null) {
                backgroundSetCount.element++;
                fragment.secondBackgroundBitmap = bitmap2;
                ActivityWidgetTodayFaceFragment$renewAndUpdateFace$1$1$tryNext$3$1 tryNext3 = new ActivityWidgetTodayFaceFragment$renewAndUpdateFace$1$1$tryNext$3$1(fragment, bitmap2, null);
                tryNext1.label = 4;
                if (BuildersKt.withContext((CoroutineContext) Dispatchers.getMain(), tryNext3, tryNext1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.daijishou_widget.widgets.activity.ActivityWidgetTodayFaceFragment$renewAndUpdateFace$1$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: ActivityWidgetTodayFaceFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.daijishou_widget.widgets.activity.ActivityWidgetTodayFaceFragment$renewAndUpdateFace$1$1$1", f = "ActivityWidgetTodayFaceFragment.kt", i = {}, l = {}, m = "invokeSuspendImpl", n = {}, s = {})
    static final class AnonymousClass1 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
        final /* synthetic */ long $widgetInstanceId;
        int label;
        final /* synthetic */ ActivityWidgetTodayFaceFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ActivityWidgetTodayFaceFragment activityWidgetTodayFaceFragment, long j, Continuation<?> continuation) {
            super(2, continuation);
            this.this$0 = activityWidgetTodayFaceFragment;
            this.$widgetInstanceId = j;
        }

        public final Continuation create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$widgetInstanceId, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
            try {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspendImpl(Unit.INSTANCE);
            } catch (Throwable th) {
                throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
            }
        }

        public final Object invokeSuspendImpl(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                TextView textView = this.this$0.title;
                TextView textView2 = null;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("title");
                    textView = null;
                }
                ActivityWidgetTodayFaceFragment activityWidgetTodayFaceFragment = this.this$0;
                Integer num = ActivityWidgetTodayFaceFragment.INSTANCE.getWidgetInstanceIdToTitle().get(Boxing.boxLong(this.$widgetInstanceId));
                Intrinsics.checkNotNull(num);
                textView.setText(activityWidgetTodayFaceFragment.getString(num.intValue()));
                TextView textView3 = this.this$0.description;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("description");
                    textView3 = null;
                }
                ActivityWidgetTodayFaceFragment activityWidgetTodayFaceFragment2 = this.this$0;
                Integer num2 = ActivityWidgetTodayFaceFragment.INSTANCE.getWidgetInstanceIdToDescription().get(Boxing.boxLong(this.$widgetInstanceId));
                Intrinsics.checkNotNull(num2);
                textView3.setText(activityWidgetTodayFaceFragment2.getString(num2.intValue()));
                TextView textView4 = this.this$0.itemCount;
                if (textView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("itemCount");
                } else {
                    textView2 = textView4;
                }
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String string = this.this$0.getString(R.string.widget_face_activity_today_subtitle_format);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                String str = String.format(string, Arrays.copyOf(new Object[]{Boxing.boxInt(this.this$0.recentEvents.size())}, 1));
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                textView2.setText(str);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
