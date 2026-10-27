package com.magneticchen.daijishou.ui.fragments.settings;

import android.widget.Toast;
import androidx.lifecycle.LifecycleOwnerKt;
import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.ui.fragments.dialog.AcknowledgementDialogFragment;
import com.magneticchen.daijishou.ui.fragments.dialog.ListSelectDialogFragment;
import com.magneticchen.daijishou.ui.fragments.dialog.ProgressDialogFragment;
import com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: BackupAndRestoreSettingsNavFragment.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.magneticchen.daijishou.ui.fragments.settings.BackupAndRestoreSettingsNavFragment$onCreateView$2$1", f = "BackupAndRestoreSettingsNavFragment.kt", i = {0, 1}, l = {122, 130}, m = "invokeSuspend", n = {"$this$launch", "$this$launch"}, s = {"L$0", "L$0"})
final class BackupAndRestoreSettingsNavFragment$onCreateView$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DaijishouApplication.WrappedLogger $logger;
    final /* synthetic */ ProgressDialogFragment $progressDialogFragment;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ BackupAndRestoreSettingsNavFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BackupAndRestoreSettingsNavFragment$onCreateView$2$1(BackupAndRestoreSettingsNavFragment backupAndRestoreSettingsNavFragment, DaijishouApplication.WrappedLogger wrappedLogger, ProgressDialogFragment progressDialogFragment, Continuation<? super BackupAndRestoreSettingsNavFragment$onCreateView$2$1> continuation) {
        super(2, continuation);
        this.this$0 = backupAndRestoreSettingsNavFragment;
        this.$logger = wrappedLogger;
        this.$progressDialogFragment = progressDialogFragment;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        BackupAndRestoreSettingsNavFragment$onCreateView$2$1 backupAndRestoreSettingsNavFragment$onCreateView$2$1 = new BackupAndRestoreSettingsNavFragment$onCreateView$2$1(this.this$0, this.$logger, this.$progressDialogFragment, continuation);
        backupAndRestoreSettingsNavFragment$onCreateView$2$1.L$0 = obj;
        return backupAndRestoreSettingsNavFragment$onCreateView$2$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((BackupAndRestoreSettingsNavFragment$onCreateView$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x012f, code lost:
    
        if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.magneticchen.daijishou.ui.fragments.settings.BackupAndRestoreSettingsNavFragment$onCreateView$2$1.AnonymousClass2(r18.$progressDialogFragment, r18.this$0, r9, r10, r11, null), r18) == r0) goto L29;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [int, java.lang.Object] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r19) {
        /*
            Method dump skipped, instruction units count: 321
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.magneticchen.daijishou.ui.fragments.settings.BackupAndRestoreSettingsNavFragment$onCreateView$2$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.ui.fragments.settings.BackupAndRestoreSettingsNavFragment$onCreateView$2$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: BackupAndRestoreSettingsNavFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.ui.fragments.settings.BackupAndRestoreSettingsNavFragment$onCreateView$2$1$2", f = "BackupAndRestoreSettingsNavFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<String> $descriptionList;
        final /* synthetic */ List<DaijishouSynchronizationModel.Companion.IndexOfListOfBackupData> $indices;
        final /* synthetic */ ProgressDialogFragment $progressDialogFragment;
        final /* synthetic */ List<String> $titleList;
        int label;
        final /* synthetic */ BackupAndRestoreSettingsNavFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(ProgressDialogFragment progressDialogFragment, BackupAndRestoreSettingsNavFragment backupAndRestoreSettingsNavFragment, List<String> list, List<String> list2, List<DaijishouSynchronizationModel.Companion.IndexOfListOfBackupData> list3, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$progressDialogFragment = progressDialogFragment;
            this.this$0 = backupAndRestoreSettingsNavFragment;
            this.$titleList = list;
            this.$descriptionList = list2;
            this.$indices = list3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$progressDialogFragment, this.this$0, this.$titleList, this.$descriptionList, this.$indices, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.$progressDialogFragment.dismiss();
            ListSelectDialogFragment listSelectDialogFragmentNewInstance$default = ListSelectDialogFragment.Companion.newInstance$default(ListSelectDialogFragment.Companion, this.this$0.getString(R.string.select_a_backup_hint), new ArrayList(this.$titleList), new ArrayList(this.$descriptionList), false, 8, null);
            final BackupAndRestoreSettingsNavFragment backupAndRestoreSettingsNavFragment = this.this$0;
            final List<DaijishouSynchronizationModel.Companion.IndexOfListOfBackupData> list = this.$indices;
            ListSelectDialogFragment onSelectListener = listSelectDialogFragmentNewInstance$default.setOnSelectListener(new Function1<Integer, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.settings.BackupAndRestoreSettingsNavFragment.onCreateView.2.1.2.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                    invoke(num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(final int i) {
                    String string = backupAndRestoreSettingsNavFragment.getString(R.string.supported_backup_and_restore_module_format);
                    Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                    List<Integer> backupAndRestoreModulesNameStringIdsByPolicy = backupAndRestoreSettingsNavFragment.getDaijishouSynchronizationModel().getBackupAndRestoreModulesNameStringIdsByPolicy(0);
                    List<Integer> backupAndRestoreModulesNameStringIdsByPolicy2 = backupAndRestoreSettingsNavFragment.getDaijishouSynchronizationModel().getBackupAndRestoreModulesNameStringIdsByPolicy(1);
                    List<Integer> backupAndRestoreModulesNameStringIdsByPolicy3 = backupAndRestoreSettingsNavFragment.getDaijishouSynchronizationModel().getBackupAndRestoreModulesNameStringIdsByPolicy(2);
                    int size = backupAndRestoreModulesNameStringIdsByPolicy.size();
                    BackupAndRestoreSettingsNavFragment backupAndRestoreSettingsNavFragment2 = backupAndRestoreSettingsNavFragment;
                    ArrayList arrayList = new ArrayList(size);
                    for (int i2 = 0; i2 < size; i2++) {
                        arrayList.add(backupAndRestoreSettingsNavFragment2.getString(backupAndRestoreModulesNameStringIdsByPolicy.get(i2).intValue()));
                    }
                    ArrayList arrayList2 = arrayList;
                    int size2 = backupAndRestoreModulesNameStringIdsByPolicy2.size();
                    BackupAndRestoreSettingsNavFragment backupAndRestoreSettingsNavFragment3 = backupAndRestoreSettingsNavFragment;
                    ArrayList arrayList3 = new ArrayList(size2);
                    for (int i3 = 0; i3 < size2; i3++) {
                        arrayList3.add(backupAndRestoreSettingsNavFragment3.getString(backupAndRestoreModulesNameStringIdsByPolicy.get(i3).intValue()));
                    }
                    ArrayList arrayList4 = arrayList3;
                    int size3 = backupAndRestoreModulesNameStringIdsByPolicy3.size();
                    BackupAndRestoreSettingsNavFragment backupAndRestoreSettingsNavFragment4 = backupAndRestoreSettingsNavFragment;
                    ArrayList arrayList5 = new ArrayList(size3);
                    for (int i4 = 0; i4 < size3; i4++) {
                        arrayList5.add(backupAndRestoreSettingsNavFragment4.getString(backupAndRestoreModulesNameStringIdsByPolicy.get(i4).intValue()));
                    }
                    ListSelectDialogFragment.Companion companion = ListSelectDialogFragment.Companion;
                    String string2 = backupAndRestoreSettingsNavFragment.getString(R.string.restore_policy);
                    String string3 = backupAndRestoreSettingsNavFragment.getString(R.string.reset_restore_policy_description);
                    Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                    String string4 = backupAndRestoreSettingsNavFragment.getString(R.string.override_restore_policy_description);
                    Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
                    String string5 = backupAndRestoreSettingsNavFragment.getString(R.string.preserve_restore_policy_description);
                    Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
                    ArrayList arrayListArrayListOf = CollectionsKt.arrayListOf(string3, string4, string5);
                    String str = String.format(string, Arrays.copyOf(new Object[]{CollectionsKt.joinToString$default(arrayList2, ", ", null, null, 0, null, null, 62, null)}, 1));
                    Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                    String str2 = String.format(string, Arrays.copyOf(new Object[]{CollectionsKt.joinToString$default(arrayList4, ", ", null, null, 0, null, null, 62, null)}, 1));
                    Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                    String str3 = String.format(string, Arrays.copyOf(new Object[]{CollectionsKt.joinToString$default(arrayList5, ", ", null, null, 0, null, null, 62, null)}, 1));
                    Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                    ListSelectDialogFragment listSelectDialogFragmentNewInstance$default2 = ListSelectDialogFragment.Companion.newInstance$default(companion, string2, arrayListArrayListOf, CollectionsKt.arrayListOf(str, str2, str3), false, 8, null);
                    final BackupAndRestoreSettingsNavFragment backupAndRestoreSettingsNavFragment5 = backupAndRestoreSettingsNavFragment;
                    final List<DaijishouSynchronizationModel.Companion.IndexOfListOfBackupData> list2 = list;
                    listSelectDialogFragmentNewInstance$default2.setOnSelectListener(new Function1<Integer, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.settings.BackupAndRestoreSettingsNavFragment.onCreateView.2.1.2.1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                            invoke(num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(int i5) {
                            List listListOf = CollectionsKt.listOf((Object[]) new Integer[]{0, 1, 2});
                            Toast.makeText(backupAndRestoreSettingsNavFragment5.requireContext(), backupAndRestoreSettingsNavFragment5.getString(R.string.applying_changes), 0).show();
                            try {
                                backupAndRestoreSettingsNavFragment5.getDaijishouSynchronizationModel().restoreFromIndexOfListOfBackupDataFromGoogleDrive(list2.get(i), ((Number) listListOf.get(i5)).intValue());
                            } catch (Exception e) {
                                Toast.makeText(backupAndRestoreSettingsNavFragment5.requireContext(), e.getMessage(), 0).show();
                            }
                        }
                    }).show(backupAndRestoreSettingsNavFragment.getParentFragmentManager(), ListSelectDialogFragment.class.getName());
                }
            });
            final BackupAndRestoreSettingsNavFragment backupAndRestoreSettingsNavFragment2 = this.this$0;
            final ProgressDialogFragment progressDialogFragment = this.$progressDialogFragment;
            final List<DaijishouSynchronizationModel.Companion.IndexOfListOfBackupData> list2 = this.$indices;
            onSelectListener.setOnLongSelectListener(new Function1<Integer, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.settings.BackupAndRestoreSettingsNavFragment.onCreateView.2.1.2.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                    invoke(num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(final int i) {
                    AcknowledgementDialogFragment acknowledgementDialogFragmentNewInstance$default = AcknowledgementDialogFragment.Companion.newInstance$default(AcknowledgementDialogFragment.Companion, backupAndRestoreSettingsNavFragment2.getString(R.string.are_you_sure), backupAndRestoreSettingsNavFragment2.getString(R.string.delete_this_backup_hint), null, null, null, 28, null);
                    final ProgressDialogFragment progressDialogFragment2 = progressDialogFragment;
                    final BackupAndRestoreSettingsNavFragment backupAndRestoreSettingsNavFragment3 = backupAndRestoreSettingsNavFragment2;
                    final List<DaijishouSynchronizationModel.Companion.IndexOfListOfBackupData> list3 = list2;
                    acknowledgementDialogFragmentNewInstance$default.setOnAcknowledgedListener(new Function0<Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.settings.BackupAndRestoreSettingsNavFragment.onCreateView.2.1.2.2.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: com.magneticchen.daijishou.ui.fragments.settings.BackupAndRestoreSettingsNavFragment$onCreateView$2$1$2$2$1$1, reason: invalid class name and collision with other inner class name */
                        /* JADX INFO: compiled from: BackupAndRestoreSettingsNavFragment.kt */
                        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
                        @DebugMetadata(c = "com.magneticchen.daijishou.ui.fragments.settings.BackupAndRestoreSettingsNavFragment$onCreateView$2$1$2$2$1$1", f = "BackupAndRestoreSettingsNavFragment.kt", i = {}, l = {192, 193}, m = "invokeSuspend", n = {}, s = {})
                        static final class C00201 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                            final /* synthetic */ List<DaijishouSynchronizationModel.Companion.IndexOfListOfBackupData> $indices;
                            final /* synthetic */ int $it;
                            final /* synthetic */ ProgressDialogFragment $progressDialogFragment;
                            private /* synthetic */ Object L$0;
                            int label;
                            final /* synthetic */ BackupAndRestoreSettingsNavFragment this$0;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            C00201(BackupAndRestoreSettingsNavFragment backupAndRestoreSettingsNavFragment, List<DaijishouSynchronizationModel.Companion.IndexOfListOfBackupData> list, int i, ProgressDialogFragment progressDialogFragment, Continuation<? super C00201> continuation) {
                                super(2, continuation);
                                this.this$0 = backupAndRestoreSettingsNavFragment;
                                this.$indices = list;
                                this.$it = i;
                                this.$progressDialogFragment = progressDialogFragment;
                            }

                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                C00201 c00201 = new C00201(this.this$0, this.$indices, this.$it, this.$progressDialogFragment, continuation);
                                c00201.L$0 = obj;
                                return c00201;
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                return ((C00201) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                            }

                            /* JADX WARN: Code restructure failed: missing block: B:14:0x0080, code lost:
                            
                                if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.magneticchen.daijishou.ui.fragments.settings.BackupAndRestoreSettingsNavFragment$onCreateView$2$1.AnonymousClass2.C00192.AnonymousClass1.C00201.C00211(r6.$progressDialogFragment, null), r6) == r0) goto L15;
                             */
                            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                            /*
                                Code decompiled incorrectly, please refer to instructions dump.
                                To view partially-correct add '--show-bad-code' argument
                            */
                            public final java.lang.Object invokeSuspend(java.lang.Object r7) {
                                /*
                                    r6 = this;
                                    java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                                    int r1 = r6.label
                                    r2 = 2
                                    r3 = 1
                                    if (r1 == 0) goto L1e
                                    if (r1 == r3) goto L1a
                                    if (r1 != r2) goto L12
                                    kotlin.ResultKt.throwOnFailure(r7)
                                    goto L83
                                L12:
                                    java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                                    r7.<init>(r0)
                                    throw r7
                                L1a:
                                    kotlin.ResultKt.throwOnFailure(r7)
                                    goto L67
                                L1e:
                                    kotlin.ResultKt.throwOnFailure(r7)
                                    java.lang.Object r7 = r6.L$0
                                    kotlinx.coroutines.CoroutineScope r7 = (kotlinx.coroutines.CoroutineScope) r7
                                    com.magneticchen.daijishou.ui.fragments.settings.BackupAndRestoreSettingsNavFragment r1 = r6.this$0
                                    androidx.fragment.app.FragmentActivity r1 = r1.requireActivity()
                                    android.app.Application r1 = r1.getApplication()
                                    java.lang.String r4 = "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication"
                                    kotlin.jvm.internal.Intrinsics.checkNotNull(r1, r4)
                                    com.magneticchen.daijishou.DaijishouApplication r1 = (com.magneticchen.daijishou.DaijishouApplication) r1
                                    com.magneticchen.daijishou.DaijishouApplication$WrappedLogger r1 = r1.getLogger()
                                    java.util.List<com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel$Companion$IndexOfListOfBackupData> r4 = r6.$indices
                                    int r5 = r6.$it
                                    java.lang.Object r4 = r4.get(r5)
                                    com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel$Companion$IndexOfListOfBackupData r4 = (com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel.Companion.IndexOfListOfBackupData) r4
                                    java.lang.String r4 = r4.toString()
                                    r1.debug(r7, r4)
                                    com.magneticchen.daijishou.ui.fragments.settings.BackupAndRestoreSettingsNavFragment r7 = r6.this$0
                                    com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel r7 = com.magneticchen.daijishou.ui.fragments.settings.BackupAndRestoreSettingsNavFragment.access$getDaijishouSynchronizationModel(r7)
                                    java.util.List<com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel$Companion$IndexOfListOfBackupData> r1 = r6.$indices
                                    int r4 = r6.$it
                                    java.lang.Object r1 = r1.get(r4)
                                    com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel$Companion$IndexOfListOfBackupData r1 = (com.magneticchen.daijishou.ui.model.DaijishouSynchronizationModel.Companion.IndexOfListOfBackupData) r1
                                    r4 = r6
                                    kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
                                    r6.label = r3
                                    java.lang.Object r7 = r7.deleteListOfBackupDataByIndexFromGoogleDrive(r1, r4)
                                    if (r7 != r0) goto L67
                                    goto L82
                                L67:
                                    kotlinx.coroutines.MainCoroutineDispatcher r7 = kotlinx.coroutines.Dispatchers.getMain()
                                    kotlin.coroutines.CoroutineContext r7 = (kotlin.coroutines.CoroutineContext) r7
                                    com.magneticchen.daijishou.ui.fragments.settings.BackupAndRestoreSettingsNavFragment$onCreateView$2$1$2$2$1$1$1 r1 = new com.magneticchen.daijishou.ui.fragments.settings.BackupAndRestoreSettingsNavFragment$onCreateView$2$1$2$2$1$1$1
                                    com.magneticchen.daijishou.ui.fragments.dialog.ProgressDialogFragment r3 = r6.$progressDialogFragment
                                    r4 = 0
                                    r1.<init>(r3, r4)
                                    kotlin.jvm.functions.Function2 r1 = (kotlin.jvm.functions.Function2) r1
                                    r3 = r6
                                    kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
                                    r6.label = r2
                                    java.lang.Object r7 = kotlinx.coroutines.BuildersKt.withContext(r7, r1, r3)
                                    if (r7 != r0) goto L83
                                L82:
                                    return r0
                                L83:
                                    kotlin.Unit r7 = kotlin.Unit.INSTANCE
                                    return r7
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.magneticchen.daijishou.ui.fragments.settings.BackupAndRestoreSettingsNavFragment$onCreateView$2$1.AnonymousClass2.C00192.AnonymousClass1.C00201.invokeSuspend(java.lang.Object):java.lang.Object");
                            }

                            /* JADX INFO: renamed from: com.magneticchen.daijishou.ui.fragments.settings.BackupAndRestoreSettingsNavFragment$onCreateView$2$1$2$2$1$1$1, reason: invalid class name and collision with other inner class name */
                            /* JADX INFO: compiled from: BackupAndRestoreSettingsNavFragment.kt */
                            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
                            @DebugMetadata(c = "com.magneticchen.daijishou.ui.fragments.settings.BackupAndRestoreSettingsNavFragment$onCreateView$2$1$2$2$1$1$1", f = "BackupAndRestoreSettingsNavFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
                            static final class C00211 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                final /* synthetic */ ProgressDialogFragment $progressDialogFragment;
                                int label;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                C00211(ProgressDialogFragment progressDialogFragment, Continuation<? super C00211> continuation) {
                                    super(2, continuation);
                                    this.$progressDialogFragment = progressDialogFragment;
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                    return new C00211(this.$progressDialogFragment, continuation);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                    return ((C00211) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Object invokeSuspend(Object obj) {
                                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                    if (this.label != 0) {
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                    ResultKt.throwOnFailure(obj);
                                    this.$progressDialogFragment.dismiss();
                                    return Unit.INSTANCE;
                                }
                            }
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            progressDialogFragment2.show(backupAndRestoreSettingsNavFragment3.getParentFragmentManager(), ProgressDialogFragment.class.getName());
                            BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(backupAndRestoreSettingsNavFragment3), Dispatchers.getIO(), (CoroutineStart) null, new C00201(backupAndRestoreSettingsNavFragment3, list3, i, progressDialogFragment2, null), 2, (Object) null);
                        }
                    }).setOnCanceledListener(new Function0<Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.settings.BackupAndRestoreSettingsNavFragment.onCreateView.2.1.2.2.2
                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }
                    }).show(backupAndRestoreSettingsNavFragment2.getParentFragmentManager(), AcknowledgementDialogFragment.class.getName());
                }
            }).show(this.this$0.getParentFragmentManager(), ListSelectDialogFragment.class.getName());
            return Unit.INSTANCE;
        }
    }
}
