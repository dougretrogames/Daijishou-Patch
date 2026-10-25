package com.github.kittinunf.fuel.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.eclipse.jgit.lib.ConfigConstants;

/* JADX INFO: compiled from: Progress.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001f\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u000026\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00070\u0001j\u0002`\bBI\u0012B\b\u0002\u0010\t\u001a<\u00128\u00126\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00070\u0001j\u0002`\b0\n¢\u0006\u0002\u0010\u000bJ\u0087\u0001\u0010\f\u001a\u00020\u00002z\u0010\t\u001a>\u0012:\b\u0001\u00126\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00070\u0001j\u0002`\b0\r\"6\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00070\u0001j\u0002`\b¢\u0006\u0002\u0010\u000eJC\u0010\u000f\u001a<\u00128\u00126\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00070\u0001j\u0002`\b0\nHÂ\u0003JM\u0010\u0010\u001a\u00020\u00002B\b\u0002\u0010\t\u001a<\u00128\u00126\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00070\u0001j\u0002`\b0\nHÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0019\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0096\u0002J\u0006\u0010\u0018\u001a\u00020\u0012JE\u0010\u0019\u001a\u00020\u00072:\u0010\u001a\u001a6\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00070\u0001j\u0002`\bH\u0086\u0002JE\u0010\u001b\u001a\u00020\u00072:\u0010\u001a\u001a6\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00070\u0001j\u0002`\bH\u0086\u0002JB\u0010\u001c\u001a\u00020\u00002:\u0010\u001a\u001a6\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00070\u0001j\u0002`\bJ\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001RH\u0010\t\u001a<\u00128\u00126\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00070\u0001j\u0002`\b0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/github/kittinunf/fuel/core/Progress;", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "readBytes", "totalBytes", "", "Lcom/github/kittinunf/fuel/core/ProgressCallback;", "handlers", "", "(Ljava/util/Collection;)V", "add", "", "([Lkotlin/jvm/functions/Function2;)Lcom/github/kittinunf/fuel/core/Progress;", "component1", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "", "other", "", "hashCode", "", "invoke", "isNotSet", "minusAssign", "handler", "plusAssign", "remove", "toString", "", "fuel"}, k = 1, mv = {1, 4, 0})
public final /* data */ class Progress implements Function2<Long, Long, Unit> {
    private final Collection<Function2<Long, Long, Unit>> handlers;

    public Progress() {
        this(null, 1, null);
    }

    private final Collection<Function2<Long, Long, Unit>> component1() {
        return this.handlers;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Progress copy$default(Progress progress, Collection collection, int i, Object obj) {
        if ((i & 1) != 0) {
            collection = progress.handlers;
        }
        return progress.copy(collection);
    }

    public final Progress copy(Collection<Function2<Long, Long, Unit>> handlers) {
        Intrinsics.checkNotNullParameter(handlers, "handlers");
        return new Progress(handlers);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof Progress) && Intrinsics.areEqual(this.handlers, ((Progress) other).handlers);
        }
        return true;
    }

    public int hashCode() {
        Collection<Function2<Long, Long, Unit>> collection = this.handlers;
        if (collection != null) {
            return collection.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "Progress(handlers=" + this.handlers + ")";
    }

    public Progress(Collection<Function2<Long, Long, Unit>> handlers) {
        Intrinsics.checkNotNullParameter(handlers, "handlers");
        this.handlers = handlers;
    }

    public /* synthetic */ Progress(ArrayList arrayList, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new ArrayList() : arrayList);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Long l, Long l2) {
        invoke(l.longValue(), l2.longValue());
        return Unit.INSTANCE;
    }

    public final Progress remove(Function2<? super Long, ? super Long, Unit> handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        minusAssign(handler);
        return this;
    }

    public final boolean isNotSet() {
        return this.handlers.isEmpty();
    }

    public void invoke(long readBytes, long totalBytes) {
        Iterator<T> it = this.handlers.iterator();
        while (it.hasNext()) {
            ((Function2) it.next()).invoke(Long.valueOf(readBytes), Long.valueOf(totalBytes));
        }
    }

    public final void plusAssign(Function2<? super Long, ? super Long, Unit> handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.handlers.add(handler);
    }

    public final void minusAssign(Function2<? super Long, ? super Long, Unit> handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.handlers.remove(handler);
    }

    public final Progress add(Function2<? super Long, ? super Long, Unit>... handlers) {
        Intrinsics.checkNotNullParameter(handlers, "handlers");
        for (Function2<? super Long, ? super Long, Unit> function2 : handlers) {
            plusAssign(function2);
        }
        return this;
    }
}
