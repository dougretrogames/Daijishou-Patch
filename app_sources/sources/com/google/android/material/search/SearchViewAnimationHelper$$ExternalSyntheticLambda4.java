package com.google.android.material.search;

/* INFO: compiled from: D8$$SyntheticClass */
/* INFO: loaded from: classes3.dex */
public final /* synthetic */ class SearchViewAnimationHelper$$ExternalSyntheticLambda4 implements Runnable {
    public final /* synthetic */ SearchView f$0;

    public /* synthetic */ SearchViewAnimationHelper$$ExternalSyntheticLambda4(SearchView searchView) {
        this.f$0 = searchView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f$0.requestFocusAndShowKeyboardIfNeeded();
    }
}
