package com.magneticchen.daijishou.dialog_fragments;

import com.google.android.material.textfield.TextInputLayout;
import com.magneticchen.daijishou.application_data.BooleanPreference;
import com.magneticchen.daijishou.application_data.Constants;
import com.magneticchen.daijishou.daijishou_recycler_view.DaijishouRecyclerView;
import com.magneticchen.daijishou.logger.Logger;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: LoggerDialogFragment.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.magneticchen.daijishou.dialog_fragments.LoggerDialogFragment$onCreateView$7$onTextChanged$1", f = "LoggerDialogFragment.kt", i = {}, l = {332}, m = "invokeSuspendImpl", n = {}, s = {})
final class LoggerDialogFragment$onCreateView$7$onTextChanged$1 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
    final /* synthetic */ LoggerDialogFragment.SearchRecyclerViewAdapter $recyclerViewAdapter;
    final /* synthetic */ CharSequence $s;
    final /* synthetic */ List<Logger.LogRecord> $searchLogRecordList;
    int label;
    final /* synthetic */ LoggerDialogFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LoggerDialogFragment$onCreateView$7$onTextChanged$1(CharSequence charSequence, LoggerDialogFragment loggerDialogFragment, List<Logger.LogRecord> list, LoggerDialogFragment.SearchRecyclerViewAdapter searchRecyclerViewAdapter, Continuation<?> continuation) {
        super(2, continuation);
        this.$s = charSequence;
        this.this$0 = loggerDialogFragment;
        this.$searchLogRecordList = list;
        this.$recyclerViewAdapter = searchRecyclerViewAdapter;
    }


    public final Continuation create(Object obj, Continuation<?> continuation) {
        return new LoggerDialogFragment$onCreateView$7$onTextChanged$1(this.$s, this.this$0, this.$searchLogRecordList, this.$recyclerViewAdapter, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
        try {
            return ((LoggerDialogFragment$onCreateView$7$onTextChanged$1) create(coroutineScope, continuation)).invokeSuspendImpl(Unit.INSTANCE);
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }

    public final Object invokeSuspendImpl(Object obj) throws Throwable {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            String strValueOf = String.valueOf(this.$s);
            TextInputLayout textInputLayout = null;
            if (StringsKt.startsWith$default(strValueOf, "\\", false, 2, (Object) null)) {
                return Unit.INSTANCE;
            }
            List<Logger.LogRecord> listRequireFilteredLogs = this.this$0.requireFilteredLogs();
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : listRequireFilteredLogs) {
                Logger.LogRecord logRecord = (Logger.LogRecord) obj2;
                String str = strValueOf;
                if (StringsKt.contains((CharSequence) logRecord.getFromComponent(), (CharSequence) str, true) || StringsKt.contains((CharSequence) logRecord.getMessage(), (CharSequence) str, true)) {
                    arrayList.add(obj2);
                }
            }
            ArrayList arrayList2 = arrayList;
            TextInputLayout textInputLayout2 = this.this$0.searchEditTextInputLayout;
            if (textInputLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("searchEditTextInputLayout");
            } else {
                textInputLayout = textInputLayout2;
            }
            textInputLayout.setHint(this.this$0.getSearchHint());
            this.label = 1;
            if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass1(strValueOf, this.this$0, this.$searchLogRecordList, arrayList2, this.$recyclerViewAdapter, null), this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: com.magneticchen.daijishou.dialog_fragments.LoggerDialogFragment$onCreateView$7$onTextChanged$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: LoggerDialogFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.dialog_fragments.LoggerDialogFragment$onCreateView$7$onTextChanged$1$1", f = "LoggerDialogFragment.kt", i = {}, l = {}, m = "invokeSuspendImpl", n = {}, s = {})
    static final class AnonymousClass1 extends com.magneticchen.daijishou.support.DaijishouSuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
        final /* synthetic */ String $keyword;
        final /* synthetic */ LoggerDialogFragment.SearchRecyclerViewAdapter $recyclerViewAdapter;
        final /* synthetic */ List<Logger.LogRecord> $searchList;
        final /* synthetic */ List<Logger.LogRecord> $searchLogRecordList;
        int label;
        final /* synthetic */ LoggerDialogFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, LoggerDialogFragment loggerDialogFragment, List<Logger.LogRecord> list, List<Logger.LogRecord> list2, LoggerDialogFragment.SearchRecyclerViewAdapter searchRecyclerViewAdapter, Continuation<?> continuation) {
            super(2, continuation);
            this.$keyword = str;
            this.this$0 = loggerDialogFragment;
            this.$searchLogRecordList = list;
            this.$searchList = list2;
            this.$recyclerViewAdapter = searchRecyclerViewAdapter;
        }


        public final Continuation create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$keyword, this.this$0, this.$searchLogRecordList, this.$searchList, this.$recyclerViewAdapter, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
            try {
                try {
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspendImpl(Unit.INSTANCE);
                } catch (Throwable th) {
                    throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
                }
            } catch (Throwable th) {
                throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
            }
        }

        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
        public final Object invokeSuspendImpl(Object obj) throws Exception {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            String str = this.$keyword;
            switch (str.hashCode()) {
                case -2003638802:
                    if (str.equals(Constants.debugOnSecretKeyword)) {
                        this.this$0.getDefaultSharedPreferences().edit().putBoolean(BooleanPreference.USE_DEBUG_MODE.getKey(), true).apply();
                        return Unit.INSTANCE;
                    }
                    break;
                case -1983267134:
                    if (str.equals(Constants.debugOffSecretKeyword)) {
                        this.this$0.getDefaultSharedPreferences().edit().putBoolean(BooleanPreference.USE_DEBUG_MODE.getKey(), BooleanPreference.USE_DEBUG_MODE.getDefaultValue()).apply();
                        return Unit.INSTANCE;
                    }
                    break;
                case -1393530574:
                    if (str.equals(Constants.secretKeyword)) {
                        DebugAndExperimentalDialogFragment.INSTANCE.newInstance().show(this.this$0.getParentFragmentManager(), DebugAndExperimentalDialogFragment.class.getName());
                        return Unit.INSTANCE;
                    }
                    break;
                case -1284326656:
                    if (str.equals(Constants.crashSecretKeyword)) {
                        throw new Exception(Constants.crashSecretKeyword);
                    }
                    break;
            }
            this.$searchLogRecordList.clear();
            this.$searchLogRecordList.addAll(this.$searchList);
            this.$recyclerViewAdapter.notifyDataSetChanged();
            DaijishouRecyclerView daijishouRecyclerView = this.this$0.recyclerView;
            if (daijishouRecyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                daijishouRecyclerView = null;
            }
            daijishouRecyclerView.scrollTo(0, 0);
            return Unit.INSTANCE;
        }
    }
}
