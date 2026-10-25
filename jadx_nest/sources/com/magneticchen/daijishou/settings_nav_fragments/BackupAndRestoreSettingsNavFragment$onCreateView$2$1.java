package com.magneticchen.daijishou.settings_nav_fragments;

import android.widget.Toast;
import androidx.lifecycle.LifecycleOwnerKt;
import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.dialog_fragments.AcknowledgementDialogFragment;
import com.magneticchen.daijishou.dialog_fragments.ListSelectDialogFragment;
import com.magneticchen.daijishou.dialog_fragments.ProgressDialogFragment;
import com.magneticchen.daijishou.view_models.DaijishouSynchronizationModel;
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
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: BackupAndRestoreSettingsNavFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.magneticchen.daijishou.settings_nav_fragments.BackupAndRestoreSettingsNavFragment$onCreateView$2$1", f = "BackupAndRestoreSettingsNavFragment.kt", i = {0, 1}, l = {128, 136}, m = "invokeSuspendImpl", n = {"$this$launch", "$this$launch"}, s = {"L$0", "L$0"})
final class BackupAndRestoreSettingsNavFragment$onCreateView$2$1 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
    final /* synthetic */ DaijishouApplication.WrappedLogger $logger;
    final /* synthetic */ ProgressDialogFragment $progressDialogFragment;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ BackupAndRestoreSettingsNavFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BackupAndRestoreSettingsNavFragment$onCreateView$2$1(BackupAndRestoreSettingsNavFragment backupAndRestoreSettingsNavFragment, DaijishouApplication.WrappedLogger wrappedLogger, ProgressDialogFragment progressDialogFragment, Continuation<?> continuation) {
        super(2, continuation);
        this.this$0 = backupAndRestoreSettingsNavFragment;
        this.$logger = wrappedLogger;
        this.$progressDialogFragment = progressDialogFragment;
    }


    public final Continuation create(Object obj, Continuation<?> continuation) {
        BackupAndRestoreSettingsNavFragment$onCreateView$2$1 backupAndRestoreSettingsNavFragment$onCreateView$2$1 = new BackupAndRestoreSettingsNavFragment$onCreateView$2$1(this.this$0, this.$logger, this.$progressDialogFragment, continuation);
        backupAndRestoreSettingsNavFragment$onCreateView$2$1.L$0 = obj;
        return backupAndRestoreSettingsNavFragment$onCreateView$2$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
        try {
            return ((BackupAndRestoreSettingsNavFragment$onCreateView$2$1) create(coroutineScope, continuation)).invokeSuspendImpl(Unit.INSTANCE);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x012f, code lost:
    
        if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.magneticchen.daijishou.settings_nav_fragments.BackupAndRestoreSettingsNavFragment$onCreateView$2$1.AnonymousClass2(r18.$progressDialogFragment, r18.this$0, r9, r10, r11, null), r18) == r0) goto L29;
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

    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspendImpl(java.lang.Object r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 321
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.magneticchen.daijishou.settings_nav_fragments.BackupAndRestoreSettingsNavFragment$onCreateView$2$1.invokeSuspendImpl(java.lang.Object):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.settings_nav_fragments.BackupAndRestoreSettingsNavFragment$onCreateView$2$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: BackupAndRestoreSettingsNavFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.settings_nav_fragments.BackupAndRestoreSettingsNavFragment$onCreateView$2$1$2", f = "BackupAndRestoreSettingsNavFragment.kt", i = {}, l = {}, m = "invokeSuspendImpl", n = {}, s = {})
    static final class AnonymousClass2 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
        final /* synthetic */ List<String> $descriptionList;
        final /* synthetic */ List<DaijishouSynchronizationModel.Companion.IndexOfListOfBackupData> $indices;
        final /* synthetic */ ProgressDialogFragment $progressDialogFragment;
        final /* synthetic */ List<String> $titleList;
        int label;
        final /* synthetic */ BackupAndRestoreSettingsNavFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(ProgressDialogFragment progressDialogFragment, BackupAndRestoreSettingsNavFragment backupAndRestoreSettingsNavFragment, List<String> list, List<String> list2, List<DaijishouSynchronizationModel.Companion.IndexOfListOfBackupData> list3, Continuation<?> continuation) {
            super(2, continuation);
            this.$progressDialogFragment = progressDialogFragment;
            this.this$0 = backupAndRestoreSettingsNavFragment;
            this.$titleList = list;
            this.$descriptionList = list2;
            this.$indices = list3;
        }


        public final Continuation create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$progressDialogFragment, this.this$0, this.$titleList, this.$descriptionList, this.$indices, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
            try {
                try {
                    return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspendImpl(Unit.INSTANCE);
                } catch (Throwable th) {
                    throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
                }
            } catch (Throwable th) {
                throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
            }
        }

        public final Object invokeSuspendImpl(Object obj) throws Throwable {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.$progressDialogFragment.dismiss();
            ListSelectDialogFragment.Companion.newInstance$default(ListSelectDialogFragment.INSTANCE, this.this$0.getString(R.string.select_a_backup_hint), new ArrayList(this.$titleList), new ArrayList(this.$descriptionList), false, 8, null).setOnSelectListener(new AnonymousClass1(this.this$0, this.$indices)).setOnLongSelectListener(new C00682(this.this$0, this.$progressDialogFragment, this.$indices)).show(this.this$0.getParentFragmentManager(), ListSelectDialogFragment.class.getName());
            return Unit.INSTANCE;
        }

        /* JADX INFO: renamed from: com.magneticchen.daijishou.settings_nav_fragments.BackupAndRestoreSettingsNavFragment$onCreateView$2$1$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: BackupAndRestoreSettingsNavFragment.kt */
        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
        static final class AnonymousClass1 extends Lambda<Unit> implements Function1<Integer, Unit> {
            final /* synthetic */ List<DaijishouSynchronizationModel.Companion.IndexOfListOfBackupData> $indices;
            final /* synthetic */ BackupAndRestoreSettingsNavFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(BackupAndRestoreSettingsNavFragment backupAndRestoreSettingsNavFragment, List<DaijishouSynchronizationModel.Companion.IndexOfListOfBackupData> list) {
                super(1);
                this.this$0 = backupAndRestoreSettingsNavFragment;
                this.$indices = list;
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

            public final void invoke(int i) {
                String string = this.this$0.getString(R.string.supported_backup_and_restore_module_format);
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                List<Integer> backupAndRestoreModulesNameStringIdsByPolicy = this.this$0.getDaijishouSynchronizationModel().getBackupAndRestoreModulesNameStringIdsByPolicy(0);
                List<Integer> backupAndRestoreModulesNameStringIdsByPolicy2 = this.this$0.getDaijishouSynchronizationModel().getBackupAndRestoreModulesNameStringIdsByPolicy(1);
                List<Integer> backupAndRestoreModulesNameStringIdsByPolicy3 = this.this$0.getDaijishouSynchronizationModel().getBackupAndRestoreModulesNameStringIdsByPolicy(2);
                int size = backupAndRestoreModulesNameStringIdsByPolicy.size();
                BackupAndRestoreSettingsNavFragment backupAndRestoreSettingsNavFragment = this.this$0;
                ArrayList arrayList = new ArrayList(size);
                for (int i2 = 0; i2 < size; i2++) {
                    arrayList.add(backupAndRestoreSettingsNavFragment.getString(backupAndRestoreModulesNameStringIdsByPolicy.get(i2).intValue()));
                }
                ArrayList arrayList2 = arrayList;
                int size2 = backupAndRestoreModulesNameStringIdsByPolicy2.size();
                BackupAndRestoreSettingsNavFragment backupAndRestoreSettingsNavFragment2 = this.this$0;
                ArrayList arrayList3 = new ArrayList(size2);
                for (int i3 = 0; i3 < size2; i3++) {
                    arrayList3.add(backupAndRestoreSettingsNavFragment2.getString(backupAndRestoreModulesNameStringIdsByPolicy.get(i3).intValue()));
                }
                ArrayList arrayList4 = arrayList3;
                int size3 = backupAndRestoreModulesNameStringIdsByPolicy3.size();
                BackupAndRestoreSettingsNavFragment backupAndRestoreSettingsNavFragment3 = this.this$0;
                ArrayList arrayList5 = new ArrayList(size3);
                for (int i4 = 0; i4 < size3; i4++) {
                    arrayList5.add(backupAndRestoreSettingsNavFragment3.getString(backupAndRestoreModulesNameStringIdsByPolicy.get(i4).intValue()));
                }
                ListSelectDialogFragment.Companion companion = ListSelectDialogFragment.INSTANCE;
                String string2 = this.this$0.getString(R.string.restore_policy);
                String string3 = this.this$0.getString(R.string.reset_restore_policy_description);
                Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                String string4 = this.this$0.getString(R.string.override_restore_policy_description);
                Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
                String string5 = this.this$0.getString(R.string.preserve_restore_policy_description);
                Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
                ArrayList arrayListArrayListOf = CollectionsKt.arrayListOf(string3, string4, string5);
                String str = String.format(string, Arrays.copyOf(new Object[]{CollectionsKt.joinToString$default(arrayList2, ", ", null, null, 0, null, null, 62, null)}, 1));
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                String str2 = String.format(string, Arrays.copyOf(new Object[]{CollectionsKt.joinToString$default(arrayList4, ", ", null, null, 0, null, null, 62, null)}, 1));
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                String str3 = String.format(string, Arrays.copyOf(new Object[]{CollectionsKt.joinToString$default(arrayList5, ", ", null, null, 0, null, null, 62, null)}, 1));
                Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                ListSelectDialogFragment.Companion.newInstance$default(companion, string2, arrayListArrayListOf, CollectionsKt.arrayListOf(str, str2, str3), false, 8, null).setOnSelectListener(new C00671(this.this$0, this.$indices, i)).show(this.this$0.getParentFragmentManager(), ListSelectDialogFragment.class.getName());
            }

            /* JADX INFO: renamed from: com.magneticchen.daijishou.settings_nav_fragments.BackupAndRestoreSettingsNavFragment$onCreateView$2$1$2$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: BackupAndRestoreSettingsNavFragment.kt */
            @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "policyIndex", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
            static final class C00671 extends Lambda<Unit> implements Function1<Integer, Unit> {
                final /* synthetic */ List<DaijishouSynchronizationModel.Companion.IndexOfListOfBackupData> $indices;
                final /* synthetic */ int $it;
                final /* synthetic */ BackupAndRestoreSettingsNavFragment this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C00671(BackupAndRestoreSettingsNavFragment backupAndRestoreSettingsNavFragment, List<DaijishouSynchronizationModel.Companion.IndexOfListOfBackupData> list, int i) {
                    super(1);
                    this.this$0 = backupAndRestoreSettingsNavFragment;
                    this.$indices = list;
                    this.$it = i;
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

                public final void invoke(int i) {
                    List listListOf = CollectionsKt.listOf(new Integer[]{0, 1, 2});
                    Toast.makeText(this.this$0.requireContext(), this.this$0.getString(R.string.applying_changes), 0).show();
                    try {
                        this.this$0.getDaijishouSynchronizationModel().restoreFromIndexOfListOfBackupDataFromGoogleDrive(this.$indices.get(this.$it), ((Number) listListOf.get(i)).intValue());
                    } catch (Exception e) {
                        Toast.makeText(this.this$0.requireContext(), e.getMessage(), 0).show();
                    }
                }
            }
        }

        /* JADX INFO: renamed from: com.magneticchen.daijishou.settings_nav_fragments.BackupAndRestoreSettingsNavFragment$onCreateView$2$1$2$2, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: BackupAndRestoreSettingsNavFragment.kt */
        @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
        static final class C00682 extends Lambda<Unit> implements Function1<Integer, Unit> {
            final /* synthetic */ List<DaijishouSynchronizationModel.Companion.IndexOfListOfBackupData> $indices;
            final /* synthetic */ ProgressDialogFragment $progressDialogFragment;
            final /* synthetic */ BackupAndRestoreSettingsNavFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00682(BackupAndRestoreSettingsNavFragment backupAndRestoreSettingsNavFragment, ProgressDialogFragment progressDialogFragment, List<DaijishouSynchronizationModel.Companion.IndexOfListOfBackupData> list) {
                super(1);
                this.this$0 = backupAndRestoreSettingsNavFragment;
                this.$progressDialogFragment = progressDialogFragment;
                this.$indices = list;
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

            /* JADX INFO: renamed from: com.magneticchen.daijishou.settings_nav_fragments.BackupAndRestoreSettingsNavFragment$onCreateView$2$1$2$2$1, reason: invalid class name */
            /* JADX INFO: compiled from: BackupAndRestoreSettingsNavFragment.kt */
            @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
            static final class AnonymousClass1 extends Lambda<Unit> implements Function0<Unit> {
                final /* synthetic */ List<DaijishouSynchronizationModel.Companion.IndexOfListOfBackupData> $indices;
                final /* synthetic */ int $it;
                final /* synthetic */ ProgressDialogFragment $progressDialogFragment;
                final /* synthetic */ BackupAndRestoreSettingsNavFragment this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(ProgressDialogFragment progressDialogFragment, BackupAndRestoreSettingsNavFragment backupAndRestoreSettingsNavFragment, List<DaijishouSynchronizationModel.Companion.IndexOfListOfBackupData> list, int i) {
                    super(0);
                    this.$progressDialogFragment = progressDialogFragment;
                    this.this$0 = backupAndRestoreSettingsNavFragment;
                    this.$indices = list;
                    this.$it = i;
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: com.magneticchen.daijishou.settings_nav_fragments.BackupAndRestoreSettingsNavFragment$onCreateView$2$1$2$2$1$1, reason: invalid class name and collision with other inner class name */
                /* JADX INFO: compiled from: BackupAndRestoreSettingsNavFragment.kt */
                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
                @DebugMetadata(c = "com.magneticchen.daijishou.settings_nav_fragments.BackupAndRestoreSettingsNavFragment$onCreateView$2$1$2$2$1$1", f = "BackupAndRestoreSettingsNavFragment.kt", i = {}, l = {196, 197}, m = "invokeSuspendImpl", n = {}, s = {})
                static final class C00691 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
                    final /* synthetic */ List<DaijishouSynchronizationModel.Companion.IndexOfListOfBackupData> $indices;
                    final /* synthetic */ int $it;
                    final /* synthetic */ ProgressDialogFragment $progressDialogFragment;
                    private /* synthetic */ Object L$0;
                    int label;
                    final /* synthetic */ BackupAndRestoreSettingsNavFragment this$0;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    C00691(BackupAndRestoreSettingsNavFragment backupAndRestoreSettingsNavFragment, List<DaijishouSynchronizationModel.Companion.IndexOfListOfBackupData> list, int i, ProgressDialogFragment progressDialogFragment, Continuation<?> continuation) {
                        super(2, continuation);
                        this.this$0 = backupAndRestoreSettingsNavFragment;
                        this.$indices = list;
                        this.$it = i;
                        this.$progressDialogFragment = progressDialogFragment;
                    }


                    public final Continuation create(Object obj, Continuation<?> continuation) {
                        C00691 c00691 = new C00691(this.this$0, this.$indices, this.$it, this.$progressDialogFragment, continuation);
                        c00691.L$0 = obj;
                        return c00691;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
                        try {
                            try {
                                return ((C00691) create(coroutineScope, continuation)).invokeSuspendImpl(Unit.INSTANCE);
                            } catch (Throwable th) {
                                throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
                            }
                        } catch (Throwable th) {
                            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
                        }
                    }

                    /* JADX WARN: Code restructure failed: missing block: B:14:0x0080, code lost:
                    
                        if (kotlinx.coroutines.BuildersKt.withContext(kotlinx.coroutines.Dispatchers.getMain(), new com.magneticchen.daijishou.settings_nav_fragments.BackupAndRestoreSettingsNavFragment$onCreateView$2$1.AnonymousClass2.C00682.AnonymousClass1.C00691.C00701(r6.$progressDialogFragment, null), r6) == r0) goto L15;
                     */

                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public final java.lang.Object invokeSuspendImpl(java.lang.Object r7) throws java.lang.Throwable {
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
                            com.magneticchen.daijishou.settings_nav_fragments.BackupAndRestoreSettingsNavFragment r1 = r6.this$0
                            androidx.fragment.app.FragmentActivity r1 = r1.requireActivity()
                            android.app.Application r1 = r1.getApplication()
                            java.lang.String r4 = "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication"
                            kotlin.jvm.internal.Intrinsics.checkNotNull(r1, r4)
                            com.magneticchen.daijishou.DaijishouApplication r1 = (com.magneticchen.daijishou.DaijishouApplication) r1
                            com.magneticchen.daijishou.DaijishouApplication$WrappedLogger r1 = r1.getLogger()
                            java.util.List<com.magneticchen.daijishou.view_models.DaijishouSynchronizationModel$Companion$IndexOfListOfBackupData> r4 = r6.$indices
                            int r5 = r6.$it
                            java.lang.Object r4 = r4.get(r5)
                            com.magneticchen.daijishou.view_models.DaijishouSynchronizationModel$Companion$IndexOfListOfBackupData r4 = (com.magneticchen.daijishou.view_models.DaijishouSynchronizationModel.Companion.IndexOfListOfBackupData) r4
                            java.lang.String r4 = r4.toString()
                            r1.debug(r7, r4)
                            com.magneticchen.daijishou.settings_nav_fragments.BackupAndRestoreSettingsNavFragment r7 = r6.this$0
                            com.magneticchen.daijishou.view_models.DaijishouSynchronizationModel r7 = com.magneticchen.daijishou.settings_nav_fragments.BackupAndRestoreSettingsNavFragment.access$getDaijishouSynchronizationModel(r7)
                            java.util.List<com.magneticchen.daijishou.view_models.DaijishouSynchronizationModel$Companion$IndexOfListOfBackupData> r1 = r6.$indices
                            int r4 = r6.$it
                            java.lang.Object r1 = r1.get(r4)
                            com.magneticchen.daijishou.view_models.DaijishouSynchronizationModel$Companion$IndexOfListOfBackupData r1 = (com.magneticchen.daijishou.view_models.DaijishouSynchronizationModel.Companion.IndexOfListOfBackupData) r1
                            r4 = r6
                            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
                            r6.label = r3
                            java.lang.Object r7 = r7.deleteListOfBackupDataByIndexFromGoogleDrive(r1, r4)
                            if (r7 != r0) goto L67
                            goto L82
                        L67:
                            kotlinx.coroutines.MainCoroutineDispatcher r7 = kotlinx.coroutines.Dispatchers.getMain()
                            kotlin.coroutines.CoroutineContext r7 = (kotlin.coroutines.CoroutineContext) r7
                            com.magneticchen.daijishou.settings_nav_fragments.BackupAndRestoreSettingsNavFragment$onCreateView$2$1$2$2$1$1$1 r1 = new com.magneticchen.daijishou.settings_nav_fragments.BackupAndRestoreSettingsNavFragment$onCreateView$2$1$2$2$1$1$1
                            com.magneticchen.daijishou.dialog_fragments.ProgressDialogFragment r3 = r6.$progressDialogFragment
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
                        throw new UnsupportedOperationException("Method not decompiled: com.magneticchen.daijishou.settings_nav_fragments.BackupAndRestoreSettingsNavFragment$onCreateView$2$1.AnonymousClass2.C00682.AnonymousClass1.C00691.invokeSuspendImpl(java.lang.Object):java.lang.Object");
                    }

                    /* JADX INFO: renamed from: com.magneticchen.daijishou.settings_nav_fragments.BackupAndRestoreSettingsNavFragment$onCreateView$2$1$2$2$1$1$1, reason: invalid class name and collision with other inner class name */
                    /* JADX INFO: compiled from: BackupAndRestoreSettingsNavFragment.kt */
                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
                    @DebugMetadata(c = "com.magneticchen.daijishou.settings_nav_fragments.BackupAndRestoreSettingsNavFragment$onCreateView$2$1$2$2$1$1$1", f = "BackupAndRestoreSettingsNavFragment.kt", i = {}, l = {}, m = "invokeSuspendImpl", n = {}, s = {})
                    static final class C00701 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
                        final /* synthetic */ ProgressDialogFragment $progressDialogFragment;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        C00701(ProgressDialogFragment progressDialogFragment, Continuation<?> continuation) {
                            super(2, continuation);
                            this.$progressDialogFragment = progressDialogFragment;
                        }


                        public final Continuation create(Object obj, Continuation<?> continuation) {
                            return new C00701(this.$progressDialogFragment, continuation);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
                            try {
                                try {
                                    return ((C00701) create(coroutineScope, continuation)).invokeSuspendImpl(Unit.INSTANCE);
                                } catch (Throwable th) {
                                    throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
                                }
                            } catch (Throwable th) {
                                throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
                            }
                        }

                        public final Object invokeSuspendImpl(Object obj) throws Throwable {
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
                    this.$progressDialogFragment.show(this.this$0.getParentFragmentManager(), ProgressDialogFragment.class.getName());
                    BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.this$0), Dispatchers.getIO(), null, new C00691(this.this$0, this.$indices, this.$it, this.$progressDialogFragment, null), 2, null);
                }
            }

            public final void invoke(int i) {
                AcknowledgementDialogFragment.Companion.newInstance$default(AcknowledgementDialogFragment.INSTANCE, this.this$0.getString(R.string.are_you_sure), this.this$0.getString(R.string.delete_this_backup_hint), null, null, null, 28, null).setOnAcknowledgedListener(new AnonymousClass1(this.$progressDialogFragment, this.this$0, this.$indices, i)).setOnCanceledListener(C00712.INSTANCE).show(this.this$0.getParentFragmentManager(), AcknowledgementDialogFragment.class.getName());
            }

            /* JADX INFO: renamed from: com.magneticchen.daijishou.settings_nav_fragments.BackupAndRestoreSettingsNavFragment$onCreateView$2$1$2$2$2, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: BackupAndRestoreSettingsNavFragment.kt */
            @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
            static final class C00712 extends Lambda<Unit> implements Function0<Unit> {
                public static final C00712 INSTANCE = new C00712();

                C00712() {
                    super(0);
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            }
        }
    }
}
