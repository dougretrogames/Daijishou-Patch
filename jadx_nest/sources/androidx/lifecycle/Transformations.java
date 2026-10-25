package androidx.lifecycle;

import androidx.arch.core.util.Function;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: Transformations.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001e\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0007\u001aB\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u001c\u0010\u0005\u001a\u0018\u0012\t\u0012\u0007H\u0002¢\u0006\u0002\b\u0007\u0012\t\u0012\u0007H\u0004¢\u0006\u0002\b\u00070\u0006H\u0007\u001a8\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00040\tH\u0007\u001aJ\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00020\u00012$\u0010\u0005\u001a \u0012\t\u0012\u0007H\u0002¢\u0006\u0002\b\u0007\u0012\u0011\u0012\u000f\u0012\u0004\u0012\u0002H\u0004\u0018\u00010\u0001¢\u0006\u0002\b\u00070\u0006H\u0007\u001a>\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00010\tH\u0007¨\u0006\f"}, d2 = {"distinctUntilChanged", "Landroidx/lifecycle/LiveData;", "X", "map", "Y", "transform", "Lkotlin/Function1;", "Lkotlin/jvm/JvmSuppressWildcards;", "mapFunction", "Landroidx/arch/core/util/Function;", "switchMap", "switchMapFunction", "lifecycle-livedata_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class Transformations {
    public static final <X, Y> LiveData<Y> map(LiveData<X> liveData, Function1<X, Y> transform) {
        MediatorLiveData mediatorLiveData;
        Intrinsics.checkNotNullParameter(liveData, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        if (liveData.isInitialized()) {
            mediatorLiveData = new MediatorLiveData(transform.invoke(liveData.getValue()));
        } else {
            mediatorLiveData = new MediatorLiveData();
        }
        mediatorLiveData.addSource(liveData, new Transformations$sam$androidx_lifecycle_Observer$0(new C01681(mediatorLiveData, transform)));
        return mediatorLiveData;
    }

    /* JADX INFO: Add missing generic type declarations: [X] */
    /* JADX INFO: renamed from: androidx.lifecycle.Transformations$map$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Transformations.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u000e\u0010\u0004\u001a\n \u0005*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "X", "Y", "x", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Object;)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
    static final class C01681<X> extends Lambda implements Function1<X, Unit> {
        final /* synthetic */ MediatorLiveData<Y> $result;
        final /* synthetic */ Function1<X, Y> $transform;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C01681(MediatorLiveData<Y> mediatorLiveData, Function1<X, Y> function1) {
            super(1);
            this.$result = mediatorLiveData;
            this.$transform = function1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
            invoke2(obj);
            return Unit.INSTANCE;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(X x) {
            this.$result.setValue((Y) this.$transform.invoke(x));
        }
    }

    /* JADX INFO: Add missing generic type declarations: [X] */
    /* JADX INFO: renamed from: androidx.lifecycle.Transformations$map$2, reason: invalid class name */
    /* JADX INFO: compiled from: Transformations.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u000e\u0010\u0004\u001a\n \u0005*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "X", "Y", "x", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Object;)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
    static final class AnonymousClass2<X> extends Lambda implements Function1<X, Unit> {
        final /* synthetic */ Function<X, Y> $mapFunction;
        final /* synthetic */ MediatorLiveData<Y> $result;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(MediatorLiveData<Y> mediatorLiveData, Function<X, Y> function) {
            super(1);
            this.$result = mediatorLiveData;
            this.$mapFunction = function;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
            invoke2(obj);
            return Unit.INSTANCE;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(X x) {
            this.$result.setValue((Y) this.$mapFunction.apply(x));
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use kotlin functions, instead of outdated arch core Functions")
    public static final /* synthetic */ LiveData map(LiveData liveData, Function mapFunction) {
        Intrinsics.checkNotNullParameter(liveData, "<this>");
        Intrinsics.checkNotNullParameter(mapFunction, "mapFunction");
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(liveData, new Transformations$sam$androidx_lifecycle_Observer$0(new AnonymousClass2(mediatorLiveData, mapFunction)));
        return mediatorLiveData;
    }

    public static final <X, Y> LiveData<Y> switchMap(LiveData<X> liveData, Function1<X, LiveData<Y>> transform) {
        MediatorLiveData mediatorLiveData;
        LiveData<Y> liveDataInvoke;
        Intrinsics.checkNotNullParameter(liveData, "<this>");
        Intrinsics.checkNotNullParameter(transform, "transform");
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        if (liveData.isInitialized() && (liveDataInvoke = transform.invoke(liveData.getValue())) != null && liveDataInvoke.isInitialized()) {
            mediatorLiveData = new MediatorLiveData(liveDataInvoke.getValue());
        } else {
            mediatorLiveData = new MediatorLiveData();
        }
        mediatorLiveData.addSource(liveData, new Transformations$sam$androidx_lifecycle_Observer$0(new C01691(transform, objectRef, mediatorLiveData)));
        return mediatorLiveData;
    }

    /* JADX INFO: Add missing generic type declarations: [X] */
    /* JADX INFO: renamed from: androidx.lifecycle.Transformations$switchMap$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Transformations.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "X", "Y", "value", "invoke", "(Ljava/lang/Object;)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
    static final class C01691<X> extends Lambda implements Function1<X, Unit> {
        final /* synthetic */ Ref.ObjectRef<LiveData<Y>> $liveData;
        final /* synthetic */ MediatorLiveData<Y> $result;
        final /* synthetic */ Function1<X, LiveData<Y>> $transform;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C01691(Function1<X, LiveData<Y>> function1, Ref.ObjectRef<LiveData<Y>> objectRef, MediatorLiveData<Y> mediatorLiveData) {
            super(1);
            this.$transform = function1;
            this.$liveData = objectRef;
            this.$result = mediatorLiveData;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
            invoke2(obj);
            return Unit.INSTANCE;
        }

        /* JADX WARN: Type inference failed for: r4v2, types: [T, androidx.lifecycle.LiveData] */
        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(X x) {
            ?? r4 = (LiveData) this.$transform.invoke(x);
            if (this.$liveData.element != r4) {
                if (this.$liveData.element != 0) {
                    MediatorLiveData<Y> mediatorLiveData = this.$result;
                    T t = this.$liveData.element;
                    Intrinsics.checkNotNull(t);
                    mediatorLiveData.removeSource((LiveData<S>) ((LiveData) t));
                }
                this.$liveData.element = r4;
                if (this.$liveData.element != 0) {
                    MediatorLiveData<Y> mediatorLiveData2 = this.$result;
                    T t2 = this.$liveData.element;
                    Intrinsics.checkNotNull(t2);
                    mediatorLiveData2.addSource((LiveData<S>) ((LiveData) t2), new Transformations$sam$androidx_lifecycle_Observer$0(new C00191(this.$result)));
                }
            }
        }

        /* JADX INFO: Add missing generic type declarations: [Y] */
        /* JADX INFO: renamed from: androidx.lifecycle.Transformations$switchMap$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: Transformations.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u000e\u0010\u0004\u001a\n \u0005*\u0004\u0018\u0001H\u0003H\u0003H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "X", "Y", "y", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Object;)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
        static final class C00191<Y> extends Lambda implements Function1<Y, Unit> {
            final /* synthetic */ MediatorLiveData<Y> $result;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00191(MediatorLiveData<Y> mediatorLiveData) {
                super(1);
                this.$result = mediatorLiveData;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                invoke2(obj);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Y y) {
                this.$result.setValue(y);
            }
        }
    }

    /* JADX INFO: Add missing generic type declarations: [X] */
    /* JADX INFO: renamed from: androidx.lifecycle.Transformations$switchMap$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: Transformations.kt */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0015\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000bR\"\u0010\u0002\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"androidx/lifecycle/Transformations$switchMap$2", "Landroidx/lifecycle/Observer;", "liveData", "Landroidx/lifecycle/LiveData;", "getLiveData", "()Landroidx/lifecycle/LiveData;", "setLiveData", "(Landroidx/lifecycle/LiveData;)V", "onChanged", "", "value", "(Ljava/lang/Object;)V", "lifecycle-livedata_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class C01702<X> implements Observer<X> {
        final /* synthetic */ MediatorLiveData<Y> $result;
        final /* synthetic */ Function<X, LiveData<Y>> $switchMapFunction;
        private LiveData<Y> liveData;

        C01702(Function<X, LiveData<Y>> function, MediatorLiveData<Y> mediatorLiveData) {
            this.$switchMapFunction = function;
            this.$result = mediatorLiveData;
        }

        public final LiveData<Y> getLiveData() {
            return this.liveData;
        }

        public final void setLiveData(LiveData<Y> liveData) {
            this.liveData = liveData;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        @Override // androidx.lifecycle.Observer
        public void onChanged(X value) {
            LiveData<Y> liveData = (LiveData) this.$switchMapFunction.apply(value);
            Object obj = this.liveData;
            if (obj == liveData) {
                return;
            }
            if (obj != null) {
                MediatorLiveData<Y> mediatorLiveData = this.$result;
                Intrinsics.checkNotNull(obj);
                mediatorLiveData.removeSource(obj);
            }
            this.liveData = liveData;
            if (liveData != 0) {
                MediatorLiveData<Y> mediatorLiveData2 = this.$result;
                Intrinsics.checkNotNull(liveData);
                mediatorLiveData2.addSource(liveData, new Transformations$sam$androidx_lifecycle_Observer$0(new Transformations$switchMap$2$onChanged$1(this.$result)));
            }
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use kotlin functions, instead of outdated arch core Functions")
    public static final /* synthetic */ LiveData switchMap(LiveData liveData, Function switchMapFunction) {
        Intrinsics.checkNotNullParameter(liveData, "<this>");
        Intrinsics.checkNotNullParameter(switchMapFunction, "switchMapFunction");
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        mediatorLiveData.addSource(liveData, new C01702(switchMapFunction, mediatorLiveData));
        return mediatorLiveData;
    }

    public static final <X> LiveData<X> distinctUntilChanged(LiveData<X> liveData) {
        MediatorLiveData mediatorLiveData;
        Intrinsics.checkNotNullParameter(liveData, "<this>");
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = true;
        if (liveData.isInitialized()) {
            booleanRef.element = false;
            mediatorLiveData = new MediatorLiveData(liveData.getValue());
        } else {
            mediatorLiveData = new MediatorLiveData();
        }
        mediatorLiveData.addSource(liveData, new Transformations$sam$androidx_lifecycle_Observer$0(new AnonymousClass1(mediatorLiveData, booleanRef)));
        return mediatorLiveData;
    }

    /* JADX INFO: Add missing generic type declarations: [X] */
    /* JADX INFO: renamed from: androidx.lifecycle.Transformations$distinctUntilChanged$1, reason: invalid class name */
    /* JADX INFO: compiled from: Transformations.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "X", "value", "kotlin.jvm.PlatformType", "invoke", "(Ljava/lang/Object;)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
    static final class AnonymousClass1<X> extends Lambda implements Function1<X, Unit> {
        final /* synthetic */ Ref.BooleanRef $firstTime;
        final /* synthetic */ MediatorLiveData<X> $outputLiveData;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(MediatorLiveData<X> mediatorLiveData, Ref.BooleanRef booleanRef) {
            super(1);
            this.$outputLiveData = mediatorLiveData;
            this.$firstTime = booleanRef;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
            invoke2(obj);
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(X x) {
            X value = this.$outputLiveData.getValue();
            if (this.$firstTime.element || ((value == null && x != null) || !(value == null || Intrinsics.areEqual(value, x)))) {
                this.$firstTime.element = false;
                this.$outputLiveData.setValue(x);
            }
        }
    }
}
