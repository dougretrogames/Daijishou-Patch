package androidx.webkit;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.chromium.support_lib_boundary.WebViewBuilderBoundaryInterface;

/* INFO: loaded from: classes3.dex */
public final class Policy {
    private final List<ConfigRunnable> mBehaviors;

    private interface ConfigRunnable {
        void configure(WebViewBuilderBoundaryInterface.Config config) throws WebViewBuilderException;
    }

    /* synthetic */ Policy(List list, AnonymousClass1 anonymousClass1) {
        this(list);
    }

    private Policy(List<ConfigRunnable> list) {
        this.mBehaviors = list;
    }

    void configure(WebViewBuilderBoundaryInterface.Config config) throws WebViewBuilderException {
        Iterator<ConfigRunnable> it = this.mBehaviors.iterator();
        while (it.hasNext()) {
            it.next().configure(config);
        }
    }

    public static final class Builder {
        final List<ConfigRunnable> mBehaviors = new ArrayList();

        public Policy build() {
            return new Policy(this.mBehaviors, null);
        }
    }
}
