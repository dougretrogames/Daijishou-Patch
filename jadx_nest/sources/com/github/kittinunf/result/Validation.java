package com.github.kittinunf.result;

import androidx.exifinterface.media.ExifInterface;
import java.lang.Exception;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Validation.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000*\u000e\b\u0000\u0010\u0001 \u0001*\u00060\u0002j\u0002`\u00032\u00020\u0004B-\u0012&\u0010\u0005\u001a\u0014\u0012\u0010\b\u0001\u0012\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00000\u00070\u0006\"\f\u0012\u0002\b\u0003\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0002\u0010\bR\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/github/kittinunf/result/Validation;", ExifInterface.LONGITUDE_EAST, "Ljava/lang/Exception;", "Lkotlin/Exception;", "", "resultSequence", "", "Lcom/github/kittinunf/result/Result;", "([Lcom/github/kittinunf/result/Result;)V", "failures", "", "getFailures", "()Ljava/util/List;", "hasFailure", "", "getHasFailure", "()Z", "result"}, k = 1, mv = {1, 4, 0})
public final class Validation<E extends Exception> {
    private final List<E> failures;
    private final boolean hasFailure;

    public Validation(Result<?, ? extends E>... resultSequence) {
        Intrinsics.checkNotNullParameter(resultSequence, "resultSequence");
        ArrayList arrayList = new ArrayList();
        for (Result<?, ? extends E> result : resultSequence) {
            if (result instanceof Result.Failure) {
                arrayList.add(result);
            }
        }
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList3.add(((Result.Failure) it.next()).getException());
        }
        ArrayList arrayList4 = arrayList3;
        this.failures = arrayList4;
        this.hasFailure = !arrayList4.isEmpty();
    }

    public final List<E> getFailures() {
        return this.failures;
    }

    public final boolean getHasFailure() {
        return this.hasFailure;
    }
}
