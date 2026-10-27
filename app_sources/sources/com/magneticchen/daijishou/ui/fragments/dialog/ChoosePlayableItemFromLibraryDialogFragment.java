package com.magneticchen.daijishou.ui.fragments.dialog;

import android.app.Application;
import android.os.Bundle;
import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.data.BooleanPreference;
import com.magneticchen.daijishou.data.db.entity.PlayableItemEntity;
import com.magneticchen.daijishou.ui.fragments.p000abstract.PlayableItemCollectionDialogFragment;
import com.magneticchen.daijishou.ui.model.DaijishouLibraryModel;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: ChoosePlayableItemFromLibraryDialogFragment.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0006"}, d2 = {"Lcom/magneticchen/daijishou/ui/fragments/dialog/ChoosePlayableItemFromLibraryDialogFragment;", "Lcom/magneticchen/daijishou/ui/fragments/abstract/PlayableItemCollectionDialogFragment;", "()V", "onStart", "", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ChoosePlayableItemFromLibraryDialogFragment extends PlayableItemCollectionDialogFragment {
    public static final Companion Companion = new Companion(null);

    /* JADX INFO: compiled from: ChoosePlayableItemFromLibraryDialogFragment.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JD\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\b¨\u0006\r"}, d2 = {"Lcom/magneticchen/daijishou/ui/fragments/dialog/ChoosePlayableItemFromLibraryDialogFragment$Companion;", "", "()V", "newInstance", "Lcom/magneticchen/daijishou/ui/fragments/dialog/ChoosePlayableItemFromLibraryDialogFragment;", "title", "", "populateList", "", "itemFIOF", "withVisibility", "visibility", "doNotMerge", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ ChoosePlayableItemFromLibraryDialogFragment newInstance$default(Companion companion, String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, int i, Object obj) {
            if ((i & 1) != 0) {
                str = null;
            }
            if ((i & 2) != 0) {
                z = true;
            }
            if ((i & 4) != 0) {
                z2 = false;
            }
            if ((i & 8) != 0) {
                z3 = true;
            }
            if ((i & 16) != 0) {
                z4 = true;
            }
            return companion.newInstance(str, z, z2, z3, z4, (i & 32) != 0 ? false : z5);
        }

        public final ChoosePlayableItemFromLibraryDialogFragment newInstance(String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
            ChoosePlayableItemFromLibraryDialogFragment choosePlayableItemFromLibraryDialogFragment = new ChoosePlayableItemFromLibraryDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putString("title", str);
            bundle.putBoolean("populateList", z);
            bundle.putBoolean("itemFIOF", z2);
            bundle.putBoolean("withVisibility", z3);
            bundle.putBoolean("visibility", z4);
            bundle.putBoolean("doNotMerge", z5);
            choosePlayableItemFromLibraryDialogFragment.setArguments(bundle);
            return choosePlayableItemFromLibraryDialogFragment;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.magneticchen.daijishou.ui.fragments.p000abstract.PlayableItemCollectionDialogFragment
    public void onStart() {
        super.onStart();
        String string = requireArguments().getString("title");
        if (string == null) {
            string = getString(R.string.search_your_library);
        }
        Intrinsics.checkNotNull(string);
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        String string2 = requireArguments().getString("search_text");
        T t = string2;
        if (string2 == null) {
            t = "";
        }
        objectRef.element = t;
        final boolean z = requireArguments().getBoolean("populateList");
        setItemFIOF(requireArguments().getBoolean("itemFIOF"));
        final boolean z2 = requireArguments().getBoolean("withVisibility");
        final boolean z3 = requireArguments().getBoolean("visibility");
        final boolean z4 = requireArguments().getBoolean("doNotMerge");
        setTitle(string);
        setOnTextChangedListener(new Function4<CharSequence, Integer, Integer, Integer, Boolean>() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.ChoosePlayableItemFromLibraryDialogFragment.onStart.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Boolean invoke(CharSequence charSequence, Integer num, Integer num2, Integer num3) {
                return invoke(charSequence, num.intValue(), num2.intValue(), num3.intValue());
            }

            /* JADX WARN: Type inference failed for: r7v1, types: [T, java.lang.String] */
            public final Boolean invoke(CharSequence charSequence, int i, int i2, int i3) {
                objectRef.element = String.valueOf(charSequence);
                ChoosePlayableItemFromLibraryDialogFragment.onStart$refreshItems(objectRef, z, this, z4, z2, z3);
                return false;
            }
        });
        Application application = requireActivity().getApplication();
        Intrinsics.checkNotNull(application, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication");
        ((DaijishouApplication) application).getDaijishouLibraryRepository().countAllPlayableItemsByVisibility(z3).observe(getViewLifecycleOwner(), new ChoosePlayableItemFromLibraryDialogFragment$sam$androidx_lifecycle_Observer$0(new Function1<Integer, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.ChoosePlayableItemFromLibraryDialogFragment.onStart.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Integer num) {
                ChoosePlayableItemFromLibraryDialogFragment.onStart$refreshItems(objectRef, z, this, z4, z2, z3);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onStart$refreshItems(Ref.ObjectRef<String> objectRef, boolean z, ChoosePlayableItemFromLibraryDialogFragment choosePlayableItemFromLibraryDialogFragment, boolean z2, boolean z3, boolean z4) {
        if (Intrinsics.areEqual(objectRef.element, "") && !z) {
            choosePlayableItemFromLibraryDialogFragment.setPlayableItemCollection(CollectionsKt.emptyList());
            return;
        }
        if (choosePlayableItemFromLibraryDialogFragment.getDefaultSharedPreferences().getBoolean(BooleanPreference.MERGE_PLAYABLE_ITEMS.getKey(), BooleanPreference.MERGE_PLAYABLE_ITEMS.getDefaultValue()) && !z2) {
            DaijishouLibraryModel daijishouLibrary = choosePlayableItemFromLibraryDialogFragment.getDaijishouLibrary();
            PlayableItemEntity[] playableItemEntityArr = (PlayableItemEntity[]) DaijishouLibraryModel.searchPlayableItemsByKeyword$default(choosePlayableItemFromLibraryDialogFragment.getDaijishouLibrary(), objectRef.element, 128, false, z3, z4, 4, null).toArray(new PlayableItemEntity[0]);
            choosePlayableItemFromLibraryDialogFragment.setPlayableItemCollection(daijishouLibrary.getMergedPlayableItems((PlayableItemEntity[]) Arrays.copyOf(playableItemEntityArr, playableItemEntityArr.length)));
            return;
        }
        choosePlayableItemFromLibraryDialogFragment.setPlayableItemCollection(DaijishouLibraryModel.searchPlayableItemsByKeyword$default(choosePlayableItemFromLibraryDialogFragment.getDaijishouLibrary(), objectRef.element, 64, false, z3, z4, 4, null));
    }
}
