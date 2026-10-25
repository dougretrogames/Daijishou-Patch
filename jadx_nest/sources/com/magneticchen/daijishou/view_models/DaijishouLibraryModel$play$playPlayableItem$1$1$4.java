package com.magneticchen.daijishou.view_models;

import android.content.Context;
import android.content.pm.ResolveInfo;
import androidx.appcompat.app.AppCompatActivity;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.daijishou_library_db.PlatformEntity;
import com.magneticchen.daijishou.daijishou_library_db.PlayableItemEntity;
import com.magneticchen.daijishou.daijishou_library_db.PlayerEntity;
import com.magneticchen.daijishou.dialog_fragments.ListSelectDialogFragment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: DaijishouLibraryModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class DaijishouLibraryModel$play$playPlayableItem$1$1$4 extends Lambda<Unit> implements Function0<Unit> {
    final /* synthetic */ AppCompatActivity $appCompatActivity;
    final /* synthetic */ Function1<? super Boolean, Unit> $callback;
    final /* synthetic */ Context $context;
    final /* synthetic */ boolean $isUriDaijishouPlayerTemplate;
    final /* synthetic */ List<ResolveInfo> $launcherIntentResolveInfoList;
    final /* synthetic */ String $packageNameToBeUsed;
    final /* synthetic */ PlatformEntity $platformEntity;
    final /* synthetic */ PlayableItemEntity $playableItemEntity;
    final /* synthetic */ Ref.ObjectRef<PlayerEntity> $playerEntityToBeUsed;
    final /* synthetic */ DaijishouLibraryModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    DaijishouLibraryModel$play$playPlayableItem$1$1$4(PlatformEntity platformEntity, DaijishouLibraryModel daijishouLibraryModel, AppCompatActivity appCompatActivity, List<ResolveInfo> list, PlayableItemEntity playableItemEntity, Ref.ObjectRef<PlayerEntity> objectRef, String str, Function1<? super Boolean, Unit> function1, Context context, boolean z) {
        super(0);
        this.$platformEntity = platformEntity;
        this.this$0 = daijishouLibraryModel;
        this.$appCompatActivity = appCompatActivity;
        this.$launcherIntentResolveInfoList = list;
        this.$playableItemEntity = playableItemEntity;
        this.$playerEntityToBeUsed = objectRef;
        this.$packageNameToBeUsed = str;
        this.$callback = function1;
        this.$context = context;
        this.$isUriDaijishouPlayerTemplate = z;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        String lowerCase;
        List<Long> playerIdList = this.$platformEntity.getPlayerIdList();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        DaijishouLibraryModel daijishouLibraryModel = this.this$0;
        List<ResolveInfo> list = this.$launcherIntentResolveInfoList;
        Iterator it = playerIdList.iterator();
        while (it.hasNext()) {
            PlayerEntity playerByIdStatically = daijishouLibraryModel.daijishouLibraryRepository.getPlayerByIdStatically(((Number) it.next()).longValue());
            if (playerByIdStatically != null) {
                String strConvertAmStartArgumentsToPackageName = daijishouLibraryModel.convertAmStartArgumentsToPackageName(playerByIdStatically.getAmStartArguments());
                for (ResolveInfo resolveInfo : list) {
                    String lowerCase2 = null;
                    if (strConvertAmStartArgumentsToPackageName != null) {
                        lowerCase = strConvertAmStartArgumentsToPackageName.toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                    } else {
                        lowerCase = null;
                    }
                    String str = resolveInfo.activityInfo.packageName;
                    if (str != null) {
                        Intrinsics.checkNotNull(str);
                        lowerCase2 = str.toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                    }
                    if (Intrinsics.areEqual(lowerCase, lowerCase2)) {
                        arrayList.add(playerByIdStatically);
                        arrayList2.add(playerByIdStatically.getName());
                    }
                }
            }
        }
        ListSelectDialogFragment.Companion.newInstance$default(ListSelectDialogFragment.INSTANCE, this.this$0.getApplication().getString(R.string.available_players), arrayList2, null, false, 12, null).setOnSelectListener(new AnonymousClass2(arrayList, this.$playableItemEntity, this.this$0, this.$platformEntity, this.$playerEntityToBeUsed, this.$appCompatActivity, this.$packageNameToBeUsed, this.$callback, this.$context, this.$isUriDaijishouPlayerTemplate)).setOnCancelListener(new AnonymousClass3(this.$callback)).show(this.$appCompatActivity.getSupportFragmentManager(), ListSelectDialogFragment.class.getName());
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.view_models.DaijishouLibraryModel$play$playPlayableItem$1$1$4$2, reason: invalid class name */
    /* JADX INFO: compiled from: DaijishouLibraryModel.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    static final class AnonymousClass2 extends Lambda<Unit> implements Function1<Integer, Unit> {
        final /* synthetic */ AppCompatActivity $appCompatActivity;
        final /* synthetic */ Function1<? super Boolean, Unit> $callback;
        final /* synthetic */ Context $context;
        final /* synthetic */ boolean $isUriDaijishouPlayerTemplate;
        final /* synthetic */ String $packageNameToBeUsed;
        final /* synthetic */ PlatformEntity $platformEntity;
        final /* synthetic */ PlayableItemEntity $playableItemEntity;
        final /* synthetic */ List<PlayerEntity> $playerEntityList;
        final /* synthetic */ Ref.ObjectRef<PlayerEntity> $playerEntityToBeUsed;
        final /* synthetic */ DaijishouLibraryModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(List<PlayerEntity> list, PlayableItemEntity playableItemEntity, DaijishouLibraryModel daijishouLibraryModel, PlatformEntity platformEntity, Ref.ObjectRef<PlayerEntity> objectRef, AppCompatActivity appCompatActivity, String str, Function1<? super Boolean, Unit> function1, Context context, boolean z) {
            super(1);
            this.$playerEntityList = list;
            this.$playableItemEntity = playableItemEntity;
            this.this$0 = daijishouLibraryModel;
            this.$platformEntity = platformEntity;
            this.$playerEntityToBeUsed = objectRef;
            this.$appCompatActivity = appCompatActivity;
            this.$packageNameToBeUsed = str;
            this.$callback = function1;
            this.$context = context;
            this.$isUriDaijishouPlayerTemplate = z;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
            try {
                invoke(num.intValue());
            } catch (Throwable th) {
                throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
            }
            return Unit.INSTANCE;
        }

        /* JADX WARN: Type inference failed for: r10v2, types: [T, com.magneticchen.daijishou.daijishou_library_db.PlayerEntity] */
        public final void invoke(int i) {
            PlayerEntity playerEntity = this.$playerEntityList.get(i);
            if (this.$playableItemEntity.getUseCustomPlayer()) {
                this.$playableItemEntity.setCustomPlayerId(Long.valueOf(playerEntity.getId()));
                this.this$0.daijishouLibraryRepository.updatePlayableItem(this.$playableItemEntity);
            } else {
                this.$platformEntity.setDefaultPlayerId(playerEntity.getId());
                this.this$0.daijishouLibraryRepository.updatePlatform(this.$platformEntity);
            }
            this.$playerEntityToBeUsed.element = playerEntity;
            DaijishouLibraryModel.play$playPlayableItem$lambda$13$lambda$12$playItWithRules(this.$playerEntityToBeUsed, this.this$0, this.$appCompatActivity, this.$packageNameToBeUsed, this.$playableItemEntity, this.$callback, this.$context, this.$isUriDaijishouPlayerTemplate);
        }
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.view_models.DaijishouLibraryModel$play$playPlayableItem$1$1$4$3, reason: invalid class name */
    /* JADX INFO: compiled from: DaijishouLibraryModel.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    static final class AnonymousClass3 extends Lambda<Unit> implements Function0<Unit> {
        final /* synthetic */ Function1<? super Boolean, Unit> $callback;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass3(Function1<? super Boolean, Unit> function1) {
            super(0);
            this.$callback = function1;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Function1<? super Boolean, Unit> function1 = this.$callback;
            if (function1 != null) {
                function1.invoke(false);
            }
        }
    }
}
