package com.magneticchen.daijishou.ui.fragments.dialog;

import android.os.Bundle;
import com.magneticchen.daijishou.data.db.entity.PlayableItemEntity;
import com.magneticchen.daijishou.ui.fragments.p000abstract.PlayableItemCollectionDialogFragment;
import com.magneticchen.daijishou.ui.model.DaijishouLibraryModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: StaticPlayableItemCollectionDialogFragment.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0006"}, d2 = {"Lcom/magneticchen/daijishou/ui/fragments/dialog/StaticPlayableItemCollectionDialogFragment;", "Lcom/magneticchen/daijishou/ui/fragments/abstract/PlayableItemCollectionDialogFragment;", "()V", "onStart", "", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class StaticPlayableItemCollectionDialogFragment extends PlayableItemCollectionDialogFragment {
    public static final Companion Companion = new Companion(null);

    /* JADX INFO: compiled from: StaticPlayableItemCollectionDialogFragment.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000b¨\u0006\f"}, d2 = {"Lcom/magneticchen/daijishou/ui/fragments/dialog/StaticPlayableItemCollectionDialogFragment$Companion;", "", "()V", "newInstance", "Lcom/magneticchen/daijishou/ui/fragments/dialog/StaticPlayableItemCollectionDialogFragment;", "playableItemEntityList", "", "Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;", "title", "", "doNotMerge", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ StaticPlayableItemCollectionDialogFragment newInstance$default(Companion companion, List list, String str, boolean z, int i, Object obj) {
            if ((i & 2) != 0) {
                str = null;
            }
            if ((i & 4) != 0) {
                z = false;
            }
            return companion.newInstance(list, str, z);
        }

        public final StaticPlayableItemCollectionDialogFragment newInstance(List<PlayableItemEntity> playableItemEntityList, String str, boolean z) {
            Intrinsics.checkNotNullParameter(playableItemEntityList, "playableItemEntityList");
            StaticPlayableItemCollectionDialogFragment staticPlayableItemCollectionDialogFragment = new StaticPlayableItemCollectionDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("playableItemEntityList", (ArrayList) playableItemEntityList);
            bundle.putString("title", str);
            bundle.putBoolean("doNotMerge", z);
            staticPlayableItemCollectionDialogFragment.setArguments(bundle);
            return staticPlayableItemCollectionDialogFragment;
        }
    }

    @Override // com.magneticchen.daijishou.ui.fragments.p000abstract.PlayableItemCollectionDialogFragment
    public void onStart() {
        super.onStart();
        String string = requireArguments().getString("title");
        DaijishouLibraryModel daijishouLibrary = getDaijishouLibrary();
        ArrayList parcelableArrayList = requireArguments().getParcelableArrayList("playableItemEntityList");
        Intrinsics.checkNotNull(parcelableArrayList);
        PlayableItemEntity[] playableItemEntityArr = (PlayableItemEntity[]) parcelableArrayList.toArray(new PlayableItemEntity[0]);
        List<PlayableItemEntity> mergedPlayableItemsWithPreferences = daijishouLibrary.getMergedPlayableItemsWithPreferences((PlayableItemEntity[]) Arrays.copyOf(playableItemEntityArr, playableItemEntityArr.length));
        if (string != null) {
            setTitle(string);
        }
        setPlayableItemCollection(CollectionsKt.toList(mergedPlayableItemsWithPreferences));
    }
}
