package com.magneticchen.daijishou.ui.widget.widgets.activity;

import android.widget.TextView;
import com.magneticchen.daijishou.R;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: ActivityWidgetTodayFaceFragment.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.magneticchen.daijishou.ui.widget.widgets.activity.ActivityWidgetTodayFaceFragment$renewAndUpdateFace$1$1", f = "ActivityWidgetTodayFaceFragment.kt", i = {}, l = {158, 161}, m = "invokeSuspend", n = {}, s = {})
final class ActivityWidgetTodayFaceFragment$renewAndUpdateFace$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $widgetInstanceId;
    int label;
    final /* synthetic */ ActivityWidgetTodayFaceFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ActivityWidgetTodayFaceFragment$renewAndUpdateFace$1$1(ActivityWidgetTodayFaceFragment activityWidgetTodayFaceFragment, long j, Continuation<? super ActivityWidgetTodayFaceFragment$renewAndUpdateFace$1$1> continuation) {
        super(2, continuation);
        this.this$0 = activityWidgetTodayFaceFragment;
        this.$widgetInstanceId = j;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ActivityWidgetTodayFaceFragment$renewAndUpdateFace$1$1(this.this$0, this.$widgetInstanceId, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ActivityWidgetTodayFaceFragment$renewAndUpdateFace$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x006a, code lost:
    
        if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.magneticchen.daijishou.ui.widget.widgets.activity.ActivityWidgetTodayFaceFragment$renewAndUpdateFace$1$1.AnonymousClass1(r7.this$0, r7.$widgetInstanceId, null), r7) == r0) goto L17;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1e
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.ResultKt.throwOnFailure(r8)
            goto L6d
        L12:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L1a:
            kotlin.ResultKt.throwOnFailure(r8)
            goto L4f
        L1e:
            kotlin.ResultKt.throwOnFailure(r8)
            com.magneticchen.daijishou.ui.widget.widgets.activity.ActivityWidgetTodayFaceFragment r8 = r7.this$0
            java.util.List r8 = com.magneticchen.daijishou.ui.widget.widgets.activity.ActivityWidgetTodayFaceFragment.access$getRecentEvents$p(r8)
            java.util.Collection r8 = (java.util.Collection) r8
            boolean r8 = r8.isEmpty()
            if (r8 != 0) goto L4f
            kotlin.jvm.internal.Ref$IntRef r8 = new kotlin.jvm.internal.Ref$IntRef
            r8.<init>()
            r1 = -1
            r8.element = r1
            kotlin.jvm.internal.Ref$IntRef r1 = new kotlin.jvm.internal.Ref$IntRef
            r1.<init>()
            kotlin.jvm.internal.Ref$ObjectRef r4 = new kotlin.jvm.internal.Ref$ObjectRef
            r4.<init>()
            com.magneticchen.daijishou.ui.widget.widgets.activity.ActivityWidgetTodayFaceFragment r5 = r7.this$0
            r6 = r7
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
            r7.label = r3
            java.lang.Object r8 = invokeSuspend$tryNext(r8, r5, r1, r4, r6)
            if (r8 != r0) goto L4f
            goto L6c
        L4f:
            kotlinx.coroutines.MainCoroutineDispatcher r8 = kotlinx.coroutines.Dispatchers.getMain()
            kotlin.coroutines.CoroutineContext r8 = (kotlin.coroutines.CoroutineContext) r8
            com.magneticchen.daijishou.ui.widget.widgets.activity.ActivityWidgetTodayFaceFragment$renewAndUpdateFace$1$1$1 r1 = new com.magneticchen.daijishou.ui.widget.widgets.activity.ActivityWidgetTodayFaceFragment$renewAndUpdateFace$1$1$1
            com.magneticchen.daijishou.ui.widget.widgets.activity.ActivityWidgetTodayFaceFragment r3 = r7.this$0
            long r4 = r7.$widgetInstanceId
            r6 = 0
            r1.<init>(r3, r4, r6)
            kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
            r3 = r7
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            r7.label = r2
            java.lang.Object r8 = kotlinx.coroutines.BuildersKt.withContext(r8, r1, r3)
            if (r8 != r0) goto L6d
        L6c:
            return r0
        L6d:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.magneticchen.daijishou.ui.widget.widgets.activity.ActivityWidgetTodayFaceFragment$renewAndUpdateFace$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:31:0x00b6 A[PHI: r9 r10 r11 r12
  0x00b6: PHI (r9v5 kotlin.jvm.internal.Ref$IntRef) = (r9v0 kotlin.jvm.internal.Ref$IntRef), (r9v0 kotlin.jvm.internal.Ref$IntRef), (r9v12 kotlin.jvm.internal.Ref$IntRef) binds: [B:27:0x008c, B:29:0x00b3, B:19:0x0047] A[DONT_GENERATE, DONT_INLINE]
  0x00b6: PHI (r10v1 com.magneticchen.daijishou.ui.widget.widgets.activity.ActivityWidgetTodayFaceFragment) = 
  (r10v0 com.magneticchen.daijishou.ui.widget.widgets.activity.ActivityWidgetTodayFaceFragment)
  (r10v0 com.magneticchen.daijishou.ui.widget.widgets.activity.ActivityWidgetTodayFaceFragment)
  (r10v4 com.magneticchen.daijishou.ui.widget.widgets.activity.ActivityWidgetTodayFaceFragment)
 binds: [B:27:0x008c, B:29:0x00b3, B:19:0x0047] A[DONT_GENERATE, DONT_INLINE]
  0x00b6: PHI (r11v3 kotlin.jvm.internal.Ref$IntRef) = (r11v0 kotlin.jvm.internal.Ref$IntRef), (r11v0 kotlin.jvm.internal.Ref$IntRef), (r11v6 kotlin.jvm.internal.Ref$IntRef) binds: [B:27:0x008c, B:29:0x00b3, B:19:0x0047] A[DONT_GENERATE, DONT_INLINE]
  0x00b6: PHI (r12v5 kotlin.jvm.internal.Ref$ObjectRef<com.magneticchen.daijishou.data.db.entity.EventEntity>) = 
  (r12v0 kotlin.jvm.internal.Ref$ObjectRef<com.magneticchen.daijishou.data.db.entity.EventEntity>)
  (r12v0 kotlin.jvm.internal.Ref$ObjectRef<com.magneticchen.daijishou.data.db.entity.EventEntity>)
  (r12v8 kotlin.jvm.internal.Ref$ObjectRef<com.magneticchen.daijishou.data.db.entity.EventEntity>)
 binds: [B:27:0x008c, B:29:0x00b3, B:19:0x0047] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00c4, code lost:
    
        if (invokeSuspend$tryNext(r9, r10, r11, r12, r0) == r1) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00e9, code lost:
    
        if (invokeSuspend$tryNext(r9, r10, r11, r12, r0) == r1) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0110, code lost:
    
        if (kotlinx.coroutines.BuildersKt.withContext(r11, r12, r0) == r1) goto L49;
     */
    /* JADX WARN: Type inference failed for: r13v7, types: [T, com.magneticchen.daijishou.data.db.entity.EventEntity] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object invokeSuspend$tryNext(kotlin.jvm.internal.Ref.IntRef r9, com.magneticchen.daijishou.ui.widget.widgets.activity.ActivityWidgetTodayFaceFragment r10, kotlin.jvm.internal.Ref.IntRef r11, kotlin.jvm.internal.Ref.ObjectRef<com.magneticchen.daijishou.data.db.entity.EventEntity> r12, kotlin.coroutines.Continuation<? super kotlin.Unit> r13) {
        /*
            Method dump skipped, instruction units count: 278
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.magneticchen.daijishou.ui.widget.widgets.activity.ActivityWidgetTodayFaceFragment$renewAndUpdateFace$1$1.invokeSuspend$tryNext(kotlin.jvm.internal.Ref$IntRef, com.magneticchen.daijishou.ui.widget.widgets.activity.ActivityWidgetTodayFaceFragment, kotlin.jvm.internal.Ref$IntRef, kotlin.jvm.internal.Ref$ObjectRef, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.ui.widget.widgets.activity.ActivityWidgetTodayFaceFragment$renewAndUpdateFace$1$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: ActivityWidgetTodayFaceFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.ui.widget.widgets.activity.ActivityWidgetTodayFaceFragment$renewAndUpdateFace$1$1$1", f = "ActivityWidgetTodayFaceFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ long $widgetInstanceId;
        int label;
        final /* synthetic */ ActivityWidgetTodayFaceFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ActivityWidgetTodayFaceFragment activityWidgetTodayFaceFragment, long j, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = activityWidgetTodayFaceFragment;
            this.$widgetInstanceId = j;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, this.$widgetInstanceId, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
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
                Integer num = ActivityWidgetTodayFaceFragment.Companion.getWidgetInstanceIdToTitle().get(Boxing.boxLong(this.$widgetInstanceId));
                Intrinsics.checkNotNull(num);
                textView.setText(activityWidgetTodayFaceFragment.getString(num.intValue()));
                TextView textView3 = this.this$0.description;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("description");
                    textView3 = null;
                }
                ActivityWidgetTodayFaceFragment activityWidgetTodayFaceFragment2 = this.this$0;
                Integer num2 = ActivityWidgetTodayFaceFragment.Companion.getWidgetInstanceIdToDescription().get(Boxing.boxLong(this.$widgetInstanceId));
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
