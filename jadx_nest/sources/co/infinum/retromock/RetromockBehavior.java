package co.infinum.retromock;

import co.infinum.retromock.meta.MockBehavior;

/* JADX INFO: loaded from: classes3.dex */
final class RetromockBehavior extends DefaultBehavior {
    RetromockBehavior(MockBehavior mockBehavior) {
        super(mockBehavior.durationMillis(), mockBehavior.durationDeviation());
    }
}
