package com.magneticchen.daijishou.ui.fragments.dialog;

import android.content.pm.ResolveInfo;
import android.os.Bundle;
import com.magneticchen.daijishou.ui.fragments.p000abstract.ResolveInfoCollectionDialogFragment;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StaticActivityResolveInfoCollectionDialogFragment.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0006"}, d2 = {"Lcom/magneticchen/daijishou/ui/fragments/dialog/StaticResolveInfoCollectionDialogFragment;", "Lcom/magneticchen/daijishou/ui/fragments/abstract/ResolveInfoCollectionDialogFragment;", "()V", "onStart", "", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class StaticResolveInfoCollectionDialogFragment extends ResolveInfoCollectionDialogFragment {
    public static final Companion Companion = new Companion(null);

    /* JADX INFO: compiled from: StaticActivityResolveInfoCollectionDialogFragment.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¨\u0006\n"}, d2 = {"Lcom/magneticchen/daijishou/ui/fragments/dialog/StaticResolveInfoCollectionDialogFragment$Companion;", "", "()V", "newInstance", "Lcom/magneticchen/daijishou/ui/fragments/dialog/StaticResolveInfoCollectionDialogFragment;", "resolveInfoList", "", "Landroid/content/pm/ResolveInfo;", "title", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ StaticResolveInfoCollectionDialogFragment newInstance$default(Companion companion, List list, String str, int i, Object obj) {
            if ((i & 2) != 0) {
                str = null;
            }
            return companion.newInstance(list, str);
        }

        public final StaticResolveInfoCollectionDialogFragment newInstance(List<? extends ResolveInfo> resolveInfoList, String str) {
            Intrinsics.checkNotNullParameter(resolveInfoList, "resolveInfoList");
            StaticResolveInfoCollectionDialogFragment staticResolveInfoCollectionDialogFragment = new StaticResolveInfoCollectionDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("resolveInfoList", (ArrayList) resolveInfoList);
            bundle.putString("title", str);
            staticResolveInfoCollectionDialogFragment.setArguments(bundle);
            return staticResolveInfoCollectionDialogFragment;
        }
    }

    @Override // com.magneticchen.daijishou.ui.fragments.p000abstract.ResolveInfoCollectionDialogFragment
    public void onStart() {
        super.onStart();
        ArrayList parcelableArrayList = requireArguments().getParcelableArrayList("resolveInfoList");
        Intrinsics.checkNotNull(parcelableArrayList);
        String string = requireArguments().getString("title");
        if (string != null) {
            setTitle(string);
        }
        setResolveInfoCollection(CollectionsKt.toList(parcelableArrayList));
    }
}
