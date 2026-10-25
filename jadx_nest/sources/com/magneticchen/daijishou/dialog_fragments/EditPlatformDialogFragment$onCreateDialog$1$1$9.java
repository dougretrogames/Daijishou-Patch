package com.magneticchen.daijishou.dialog_fragments;

import android.widget.ArrayAdapter;
import com.magneticchen.daijishou.daijishou_library_db.PlayerEntity;
import com.magneticchen.daijishou.utils.AutoCompleteAdapter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: EditPlatformDialogFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "it", "", "Lcom/magneticchen/daijishou/daijishou_library_db/PlayerEntity;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class EditPlatformDialogFragment$onCreateDialog$1$1$9 extends Lambda<Unit> implements Function1<List<? extends PlayerEntity>, Unit> {
    final /* synthetic */ AutoCompleteAdapter $playerArraySearchAdapter;
    final /* synthetic */ List<Long> $playerEntityIdList;
    final /* synthetic */ List<PlayerEntity> $playerEntityList;
    final /* synthetic */ List<String> $playerEntityNameList;
    final /* synthetic */ List<String> $playerEntityNameListWithIndex;
    final /* synthetic */ List<Long> $selectedPlayerIdList;
    final /* synthetic */ EditPlatformDialogFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    EditPlatformDialogFragment$onCreateDialog$1$1$9(List<PlayerEntity> list, List<String> list2, List<String> list3, List<Long> list4, EditPlatformDialogFragment editPlatformDialogFragment, AutoCompleteAdapter autoCompleteAdapter, List<Long> list5) {
        super(1);
        this.$playerEntityList = list;
        this.$playerEntityNameListWithIndex = list2;
        this.$playerEntityNameList = list3;
        this.$playerEntityIdList = list4;
        this.this$0 = editPlatformDialogFragment;
        this.$playerArraySearchAdapter = autoCompleteAdapter;
        this.$selectedPlayerIdList = list5;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends PlayerEntity> list) {
        invoke2((List<PlayerEntity>) list);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<PlayerEntity> list) {
        this.$playerEntityList.clear();
        List<PlayerEntity> list2 = this.$playerEntityList;
        Intrinsics.checkNotNull(list);
        list2.addAll(list);
        this.$playerEntityNameListWithIndex.clear();
        List<String> list3 = this.$playerEntityNameListWithIndex;
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(i2 + " - " + list.get(i2).getName());
        }
        list3.addAll(arrayList);
        this.$playerEntityNameList.clear();
        List<String> list4 = this.$playerEntityNameList;
        int size2 = list.size();
        ArrayList arrayList2 = new ArrayList(size2);
        for (int i3 = 0; i3 < size2; i3++) {
            arrayList2.add(list.get(i3).getName());
        }
        list4.addAll(arrayList2);
        this.$playerEntityIdList.clear();
        List<Long> list5 = this.$playerEntityIdList;
        int size3 = list.size();
        ArrayList arrayList3 = new ArrayList(size3);
        for (int i4 = 0; i4 < size3; i4++) {
            arrayList3.add(Long.valueOf(list.get(i4).getId()));
        }
        list5.addAll(arrayList3);
        ArrayAdapter arrayAdapter = this.this$0.playerArrayAdapter;
        Intrinsics.checkNotNull(arrayAdapter);
        arrayAdapter.clear();
        ArrayAdapter arrayAdapter2 = this.this$0.playerArrayAdapter;
        Intrinsics.checkNotNull(arrayAdapter2);
        List<PlayerEntity> list6 = this.$playerEntityList;
        List<Long> list7 = this.$selectedPlayerIdList;
        ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list6, 10));
        for (Object obj : list6) {
            int i5 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            if (!list7.contains(Long.valueOf(((PlayerEntity) obj).getId()))) {
                i = -1;
            }
            arrayList4.add(Integer.valueOf(i));
            i = i5;
        }
        ArrayList arrayList5 = new ArrayList();
        for (Object obj2 : arrayList4) {
            if (((Number) obj2).intValue() >= 0) {
                arrayList5.add(obj2);
            }
        }
        ArrayList arrayList6 = arrayList5;
        List<String> list8 = this.$playerEntityNameListWithIndex;
        ArrayList arrayList7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList6, 10));
        Iterator it = arrayList6.iterator();
        while (it.hasNext()) {
            arrayList7.add(list8.get(((Number) it.next()).intValue()));
        }
        arrayAdapter2.addAll(arrayList7);
        this.$playerArraySearchAdapter.notifyDataSetChanged();
    }
}
