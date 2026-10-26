package com.magneticchen.daijishou.daijishou_widget.widgets.activity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import androidx.core.graphics.ColorUtils;
import com.magneticchen.daijishou.daijishou_library_db.EventEntity;
import com.magneticchen.daijishou.repositories.DaijishouLibraryRepository;
import com.magneticchen.daijishou.utils.Utils;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* INFO: compiled from: ActivityWidgetGridFaceFragment.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.magneticchen.daijishou.daijishou_widget.widgets.activity.ActivityWidgetGridFaceFragment$renewAndUpdateTable$2$1", f = "ActivityWidgetGridFaceFragment.kt", i = {}, l = {201}, m = "invokeSuspendImpl", n = {}, s = {})
final class ActivityWidgetGridFaceFragment$renewAndUpdateTable$2$1 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
    final /* synthetic */ boolean $updateTable;
    final /* synthetic */ long $widgetInstanceId;
    int label;
    final /* synthetic */ ActivityWidgetGridFaceFragment this$0;

    /* WARN: 'super' call moved to the top of the method (can break code semantics) */
    ActivityWidgetGridFaceFragment$renewAndUpdateTable$2$1(long j, ActivityWidgetGridFaceFragment activityWidgetGridFaceFragment, boolean z, Continuation<?> continuation) {
        super(2, continuation);
        this.$widgetInstanceId = j;
        this.this$0 = activityWidgetGridFaceFragment;
        this.$updateTable = z;
    }


    public final Continuation create(Object obj, Continuation<?> continuation) {
        return new ActivityWidgetGridFaceFragment$renewAndUpdateTable$2$1(this.$widgetInstanceId, this.this$0, this.$updateTable, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
        try {
            return ((ActivityWidgetGridFaceFragment$renewAndUpdateTable$2$1) create(coroutineScope, continuation)).invokeSuspendImpl(Unit.INSTANCE);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }

    public final Object invokeSuspendImpl(Object obj) throws Throwable {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            int i2 = ((int) this.$widgetInstanceId) - 1;
            Date dateAtStartOfDay = Utils.INSTANCE.atStartOfDay(new Date());
            Intrinsics.checkNotNull(dateAtStartOfDay);
            Calendar cal = Calendar.getInstance();
            cal.setTime(dateAtStartOfDay);
            cal.add(Calendar.DAY_OF_YEAR, -25);
            Date dateLocalDateTimeToDate = cal.getTime();
            Intrinsics.checkNotNull(dateLocalDateTimeToDate);
            ActivityWidgetGridFaceFragment activityWidgetGridFaceFragment = this.this$0;
            activityWidgetGridFaceFragment.recentEvents = DaijishouLibraryRepository.getRecentEventsByEventStatically$default(activityWidgetGridFaceFragment.getDaijishouLibraryRepository(), i2, dateLocalDateTimeToDate, 0, 4, null);
            this.this$0.recentEventsList.clear();
            this.this$0.recentEventsTintList.clear();
            this.this$0.recentEventsBitmapList.clear();
            int i3 = 0;
            for (int i4 = 0; i4 < 25; i4++) {
                Calendar cal2 = Calendar.getInstance();
                cal2.setTime(dateAtStartOfDay);
                cal2.add(Calendar.DAY_OF_YEAR, -i4);
                Date dateLocalDateTimeToDate2 = cal2.getTime();
                ArrayList arrayList = new ArrayList();
                while (true) {
                    List list = this.this$0.recentEvents;
                    if (list == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("recentEvents");
                        list = null;
                    }
                    if (i3 >= list.size()) {
                        break;
                    }
                    List list2 = this.this$0.recentEvents;
                    if (list2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("recentEvents");
                        list2 = null;
                    }
                    if (((EventEntity) list2.get(i3)).getTimestamp().compareTo(dateLocalDateTimeToDate2) < 0) {
                        break;
                    }
                    List list3 = this.this$0.recentEvents;
                    if (list3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("recentEvents");
                        list3 = null;
                    }
                    arrayList.add(list3.get(i3));
                    this.this$0.eventsCount++;
                    i3++;
                }
                if (arrayList.size() > this.this$0.maxEventsPerDayCount) {
                    this.this$0.maxEventsPerDayCount = arrayList.size();
                }
                this.this$0.recentEventsList.add(arrayList);
            }
            for (int i5 = 0; i5 < 25; i5++) {
                List list4 = (List) this.this$0.recentEventsList.get(i5);
                Bitmap bitmapCreateBitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
                Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
                new Canvas(bitmapCreateBitmap).drawColor(ColorUtils.setAlphaComponent(this.this$0.activityColor, (int) (ActivityWidgetGridFaceFragment.BASE_ALPHA * (list4.size() / this.this$0.maxEventsPerDayCount))));
                this.this$0.recentEventsBitmapList.add(bitmapCreateBitmap);
            }
            if (this.$updateTable) {
                this.label = 1;
                if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass1(this.this$0, null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    /* INFO: renamed from: com.magneticchen.daijishou.daijishou_widget.widgets.activity.ActivityWidgetGridFaceFragment$renewAndUpdateTable$2$1$1, reason: invalid class name */
    /* INFO: compiled from: ActivityWidgetGridFaceFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.daijishou_widget.widgets.activity.ActivityWidgetGridFaceFragment$renewAndUpdateTable$2$1$1", f = "ActivityWidgetGridFaceFragment.kt", i = {}, l = {202}, m = "invokeSuspendImpl", n = {}, s = {})
    static final class AnonymousClass1 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
        int label;
        final /* synthetic */ ActivityWidgetGridFaceFragment this$0;

        /* WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(ActivityWidgetGridFaceFragment activityWidgetGridFaceFragment, Continuation<?> continuation) {
            super(2, continuation);
            this.this$0 = activityWidgetGridFaceFragment;
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
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (this.this$0.updateTableBitmap(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }
}
