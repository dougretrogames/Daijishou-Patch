package com.magneticchen.daijishou.data.live;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: TripleLiveData.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u00032 \u0012\u001c\u0012\u001a\u0012\u0006\u0012\u0004\u0018\u0001H\u0001\u0012\u0006\u0012\u0004\u0018\u0001H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u00030\u00050\u0004B/\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00020\u0007¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/magneticchen/daijishou/data/live/TripleLiveData;", "A", "B", "C", "Landroidx/lifecycle/MediatorLiveData;", "Lkotlin/Triple;", "first", "Landroidx/lifecycle/LiveData;", "second", "third", "(Landroidx/lifecycle/LiveData;Landroidx/lifecycle/LiveData;Landroidx/lifecycle/LiveData;)V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class TripleLiveData<A, B, C> extends MediatorLiveData<Triple<? extends A, ? extends B, ? extends C>> {
    public TripleLiveData(final LiveData<A> first, final LiveData<B> second, final LiveData<C> third) {
        Intrinsics.checkNotNullParameter(first, "first");
        Intrinsics.checkNotNullParameter(second, "second");
        Intrinsics.checkNotNullParameter(third, "third");
        addSource(first, new TripleLiveData$sam$androidx_lifecycle_Observer$0(new Function1<A, Unit>(this) { // from class: com.magneticchen.daijishou.data.live.TripleLiveData.1
            final /* synthetic */ TripleLiveData<A, B, C> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                invoke2(obj);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(A a) {
                this.this$0.setValue(new Triple(a, second.getValue(), third.getValue()));
            }
        }));
        addSource(second, new TripleLiveData$sam$androidx_lifecycle_Observer$0(new Function1<B, Unit>(this) { // from class: com.magneticchen.daijishou.data.live.TripleLiveData.2
            final /* synthetic */ TripleLiveData<A, B, C> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                invoke2(obj);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(B b) {
                this.this$0.setValue(new Triple(first.getValue(), b, third.getValue()));
            }
        }));
        addSource(third, new TripleLiveData$sam$androidx_lifecycle_Observer$0(new Function1<C, Unit>(this) { // from class: com.magneticchen.daijishou.data.live.TripleLiveData.3
            final /* synthetic */ TripleLiveData<A, B, C> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                invoke2(obj);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(C c) {
                this.this$0.setValue(new Triple(first.getValue(), second.getValue(), c));
            }
        }));
    }
}
