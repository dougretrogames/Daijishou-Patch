package com.magneticchen.daijishou.view_models;

import android.content.Context;
import android.net.Uri;
import androidx.appcompat.app.AppCompatActivity;
import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.daijishou_library_db.PlayableItemEntity;
import com.magneticchen.daijishou.daijishou_player.AmStartCommandToIntentConverter;
import com.magneticchen.daijishou.dialog_fragments.ChoosePlayableItemFromLibraryDialogFragment;
import com.magneticchen.daijishou.utils.FileUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import org.eclipse.jgit.diff.DiffEntry;

/* INFO: compiled from: DaijishouConsoleViewModel.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J&\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0003H\u0096@¢\u0006\u0002\u0010\u000fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0003X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0005¨\u0006\u0010"}, d2 = {"com/magneticchen/daijishou/view_models/DaijishouConsoleViewModel$commands$7", "Lcom/magneticchen/daijishou/view_models/DaijishouConsoleViewModel$Companion$Command;", "description", "", "getDescription", "()Ljava/lang/String;", "startWith", "getStartWith", "execute", "Lcom/magneticchen/daijishou/view_models/DaijishouConsoleViewModel$Companion$CommandResult;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "application", "Lcom/magneticchen/daijishou/DaijishouApplication;", "command", "(Landroidx/appcompat/app/AppCompatActivity;Lcom/magneticchen/daijishou/DaijishouApplication;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DaijishouConsoleViewModel$commands$7 extends DaijishouConsoleViewModel.Companion.Command {
    final /* synthetic */ DaijishouConsoleViewModel this$0;
    private final String startWith = "\\am_start ";
    private final String description = "Am start command. Usage:\n> \\am_start \"your arguments here\"";

    DaijishouConsoleViewModel$commands$7(DaijishouConsoleViewModel daijishouConsoleViewModel) {
        this.this$0 = daijishouConsoleViewModel;
    }

    @Override // com.magneticchen.daijishou.view_models.DaijishouConsoleViewModel.Companion.Command
    public String getStartWith() {
        return this.startWith;
    }

    @Override // com.magneticchen.daijishou.view_models.DaijishouConsoleViewModel.Companion.Command
    public String getDescription() {
        return this.description;
    }

    @Override // com.magneticchen.daijishou.view_models.DaijishouConsoleViewModel.Companion.Command
    public Object execute(AppCompatActivity appCompatActivity, DaijishouApplication daijishouApplication, String str, Continuation<?> continuation) {
        try {
            if (DaijishouConsoleViewModel.INSTANCE.splitCommandBySpaces(str).size() > 1) {
                String str2 = (String) StringsKt.split$default((CharSequence) str, new String[]{"am_start "}, false, 0, 6, (Object) null).get(1);
                List listListOf = CollectionsKt.listOf(new String[]{"\"{file.path}\"", "{file.path}", "\"{file.uri}\"", "{file.uri}", "\"{file.documenturi}\"", "{file.documenturi}", "{android.activity}"});
                ArrayList arrayList = new ArrayList();
                Ref.ObjectRef objectRef = new Ref.ObjectRef();
                DaijishouConsoleViewModel daijishouConsoleViewModel = this.this$0;
                String str3 = str2;
                if (DaijishouConsoleViewModel.INSTANCE.getHasTemplateTagsRegex().matches(str3)) {
                    return execute$lambda$2$pickAnItem(daijishouApplication, appCompatActivity, objectRef, this, arrayList, daijishouConsoleViewModel, str2, continuation);
                }
                Iterator it = listListOf.iterator();
                while (it.hasNext()) {
                    if (StringsKt.contains$default((CharSequence) str3, (CharSequence) it.next(), false, 2, (Object) null)) {
                        return execute$lambda$2$pickAnItem(daijishouApplication, appCompatActivity, objectRef, this, arrayList, daijishouConsoleViewModel, str2, continuation);
                    }
                }
                return execute$executeArgs(objectRef, daijishouApplication, this, arrayList, this.this$0, appCompatActivity, str2);
            }
            return DaijishouConsoleViewModel.INSTANCE.getUnsupportedCommandResult();
    
        } catch (Throwable th) {
            throw com.magneticchen.daijishou.support.DaijishouSupport.sneakyThrow(th);
        }
    }

    /* INFO: Access modifiers changed from: private */
    public static final DaijishouConsoleViewModel.Companion.CommandResult execute$executeArgs(Ref.ObjectRef<PlayableItemEntity> objectRef, DaijishouApplication daijishouApplication, DaijishouConsoleViewModel$commands$7 daijishouConsoleViewModel$commands$7, List<Pair<String, String>> list, DaijishouConsoleViewModel daijishouConsoleViewModel, AppCompatActivity appCompatActivity, String str) {
        String path;
        try {
            if (objectRef.element != null) {
                PlayableItemEntity playableItemEntity = objectRef.element;
                Intrinsics.checkNotNull(playableItemEntity);
                Uri uri = playableItemEntity.getUri();
                try {
                    FileUtils fileUtils = FileUtils.INSTANCE;
                    Context applicationContext = daijishouApplication.getApplicationContext();
                    Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
                    path = fileUtils.getFilePath(applicationContext, uri);
                } catch (Exception e) {
                    daijishouApplication.getLogger().warn(daijishouConsoleViewModel$commands$7, ExceptionsKt.stackTraceToString(e));
                    path = uri.getPath();
                    if (path == null) {
                        path = DiffEntry.DEV_NULL;
                    }
                }
                PlayableItemEntity playableItemEntity2 = objectRef.element;
                Intrinsics.checkNotNull(playableItemEntity2);
                list.addAll((List<Pair<String, String>>) (List) CollectionsKt.listOf(new Pair[]{new Pair("\"{file.path}\"", path), new Pair("{file.path}", path), new Pair("\"{file.uri}\"", uri.toString()), new Pair("{file.uri}", uri.toString()), new Pair("\"{file.documenturi}\"", uri.toString()), new Pair("{file.documenturi}", uri.toString()), new Pair("{android.activity}", String.valueOf(playableItemEntity2.getActivityComponentString()))}));
                if (daijishouConsoleViewModel.daijishouPlayerTemplate.isUriDaijishouPlayerTemplate(appCompatActivity, uri)) {
                    list.addAll(daijishouConsoleViewModel.daijishouPlayerTemplate.getTemplateTagsAndValuesFromUri(uri));
                }
            }
            daijishouApplication.getApplicationContext().startActivity(AmStartCommandToIntentConverter.INSTANCE.createIntentByCommandArgs(str, list));
            return new DaijishouConsoleViewModel.Companion.CommandResult("Executed.", 0, null, false, 14, null);
        } catch (Exception e2) {
            String message = e2.getMessage();
            if (message == null) {
                message = ExceptionsKt.stackTraceToString(e2);
            }
            return new DaijishouConsoleViewModel.Companion.CommandResult(message, DaijishouConsoleViewModel.Companion.CommandResult.INSTANCE.getFAILED_STATUS_CODE(), e2, false, 8, null);
        }
    }

    /* INFO: Access modifiers changed from: private */
    public static final Object execute$lambda$2$pickAnItem(DaijishouApplication daijishouApplication, AppCompatActivity appCompatActivity, Ref.ObjectRef<PlayableItemEntity> objectRef, DaijishouConsoleViewModel$commands$7 daijishouConsoleViewModel$commands$7, List<Pair<String, String>> list, DaijishouConsoleViewModel daijishouConsoleViewModel, String str, Continuation<?> continuation) throws Throwable {
        DaijishouConsoleViewModel$commands$7$execute$2$pickAnItem$1 daijishouConsoleViewModel$commands$7$execute$2$pickAnItem$1;
        if (continuation instanceof DaijishouConsoleViewModel$commands$7$execute$2$pickAnItem$1) {
            daijishouConsoleViewModel$commands$7$execute$2$pickAnItem$1 = (DaijishouConsoleViewModel$commands$7$execute$2$pickAnItem$1) continuation;
            if ((daijishouConsoleViewModel$commands$7$execute$2$pickAnItem$1.label & Integer.MIN_VALUE) != 0) {
                daijishouConsoleViewModel$commands$7$execute$2$pickAnItem$1.label -= Integer.MIN_VALUE;
            } else {
                daijishouConsoleViewModel$commands$7$execute$2$pickAnItem$1 = new DaijishouConsoleViewModel$commands$7$execute$2$pickAnItem$1(continuation);
            }
        } else {
            daijishouConsoleViewModel$commands$7$execute$2$pickAnItem$1 = new DaijishouConsoleViewModel$commands$7$execute$2$pickAnItem$1(continuation);
        }
        Object obj = daijishouConsoleViewModel$commands$7$execute$2$pickAnItem$1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = daijishouConsoleViewModel$commands$7$execute$2$pickAnItem$1.label;
        if (i != 0) {
            if (i == 1) {
                Ref.BooleanRef booleanRef = (Ref.BooleanRef) daijishouConsoleViewModel$commands$7$execute$2$pickAnItem$1.L$8;
                ChoosePlayableItemFromLibraryDialogFragment choosePlayableItemFromLibraryDialogFragment = (ChoosePlayableItemFromLibraryDialogFragment) daijishouConsoleViewModel$commands$7$execute$2$pickAnItem$1.L$7;
                String str2 = (String) daijishouConsoleViewModel$commands$7$execute$2$pickAnItem$1.L$6;
                DaijishouConsoleViewModel daijishouConsoleViewModel2 = (DaijishouConsoleViewModel) daijishouConsoleViewModel$commands$7$execute$2$pickAnItem$1.L$5;
                List<Pair<String, String>> list2 = (List) daijishouConsoleViewModel$commands$7$execute$2$pickAnItem$1.L$4;
                DaijishouConsoleViewModel$commands$7 daijishouConsoleViewModel$commands$72 = (DaijishouConsoleViewModel$commands$7) daijishouConsoleViewModel$commands$7$execute$2$pickAnItem$1.L$3;
                Ref.ObjectRef<PlayableItemEntity> objectRef2 = (Ref.ObjectRef) daijishouConsoleViewModel$commands$7$execute$2$pickAnItem$1.L$2;
                AppCompatActivity appCompatActivity2 = (AppCompatActivity) daijishouConsoleViewModel$commands$7$execute$2$pickAnItem$1.L$1;
                DaijishouApplication daijishouApplication2 = (DaijishouApplication) daijishouConsoleViewModel$commands$7$execute$2$pickAnItem$1.L$0;
                ResultKt.throwOnFailure(obj);
                daijishouConsoleViewModel$commands$7$execute$2$pickAnItem$1.L$0 = daijishouApplication2;
                daijishouConsoleViewModel$commands$7$execute$2$pickAnItem$1.L$1 = appCompatActivity2;
                daijishouConsoleViewModel$commands$7$execute$2$pickAnItem$1.L$2 = objectRef2;
                daijishouConsoleViewModel$commands$7$execute$2$pickAnItem$1.L$3 = daijishouConsoleViewModel$commands$72;
                daijishouConsoleViewModel$commands$7$execute$2$pickAnItem$1.L$4 = list2;
                daijishouConsoleViewModel$commands$7$execute$2$pickAnItem$1.L$5 = daijishouConsoleViewModel2;
                daijishouConsoleViewModel$commands$7$execute$2$pickAnItem$1.L$6 = str2;
                daijishouConsoleViewModel$commands$7$execute$2$pickAnItem$1.L$7 = choosePlayableItemFromLibraryDialogFragment;
                daijishouConsoleViewModel$commands$7$execute$2$pickAnItem$1.L$8 = booleanRef;
                daijishouConsoleViewModel$commands$7$execute$2$pickAnItem$1.label = 2;
                SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(daijishouConsoleViewModel$commands$7$execute$2$pickAnItem$1));
                choosePlayableItemFromLibraryDialogFragment.setOnClickListener(new DaijishouConsoleViewModel$commands$7$execute$2$pickAnItem$result$1$1(objectRef2, booleanRef, choosePlayableItemFromLibraryDialogFragment, safeContinuation, daijishouApplication2, daijishouConsoleViewModel$commands$72, list2, daijishouConsoleViewModel2, appCompatActivity2, str2));
                choosePlayableItemFromLibraryDialogFragment.setOnDialogDismissedListener(new DaijishouConsoleViewModel$commands$7$execute$2$pickAnItem$result$1$2(booleanRef, safeContinuation));
                choosePlayableItemFromLibraryDialogFragment.show(appCompatActivity2.getSupportFragmentManager(), ChoosePlayableItemFromLibraryDialogFragment.class.getName());
                Object orThrow = safeContinuation.getOrThrow();
                if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    DebugProbesKt.probeCoroutineSuspended(daijishouConsoleViewModel$commands$7$execute$2$pickAnItem$1);
                }
                if (orThrow == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return (DaijishouConsoleViewModel.Companion.CommandResult) orThrow;
            }
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return (DaijishouConsoleViewModel.Companion.CommandResult) obj;
        }
        ResultKt.throwOnFailure(obj);
        ChoosePlayableItemFromLibraryDialogFragment newInstance$default = ChoosePlayableItemFromLibraryDialogFragment.Companion.newInstance$default(ChoosePlayableItemFromLibraryDialogFragment.INSTANCE, null, false, false, false, false, false, 63, null);
        Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
        daijishouConsoleViewModel$commands$7$execute$2$pickAnItem$1.L$0 = daijishouApplication;
        daijishouConsoleViewModel$commands$7$execute$2$pickAnItem$1.L$1 = appCompatActivity;
        daijishouConsoleViewModel$commands$7$execute$2$pickAnItem$1.L$2 = objectRef;
        daijishouConsoleViewModel$commands$7$execute$2$pickAnItem$1.L$3 = daijishouConsoleViewModel$commands$7;
        daijishouConsoleViewModel$commands$7$execute$2$pickAnItem$1.L$4 = list;
        daijishouConsoleViewModel$commands$7$execute$2$pickAnItem$1.L$5 = daijishouConsoleViewModel;
        daijishouConsoleViewModel$commands$7$execute$2$pickAnItem$1.L$6 = str;
        daijishouConsoleViewModel$commands$7$execute$2$pickAnItem$1.L$7 = newInstance$default;
        daijishouConsoleViewModel$commands$7$execute$2$pickAnItem$1.L$8 = booleanRef2;
        daijishouConsoleViewModel$commands$7$execute$2$pickAnItem$1.label = 1;
        if (BuildersKt.withContext(Dispatchers.getMain(), new DaijishouConsoleViewModel$commands$7$execute$2$pickAnItem$2(daijishouApplication, null), daijishouConsoleViewModel$commands$7$execute$2$pickAnItem$1) == coroutine_suspended) {
            return coroutine_suspended;
        }
        daijishouConsoleViewModel$commands$7$execute$2$pickAnItem$1.L$0 = daijishouApplication;
        daijishouConsoleViewModel$commands$7$execute$2$pickAnItem$1.L$1 = appCompatActivity;
        daijishouConsoleViewModel$commands$7$execute$2$pickAnItem$1.L$2 = objectRef;
        daijishouConsoleViewModel$commands$7$execute$2$pickAnItem$1.L$3 = daijishouConsoleViewModel$commands$7;
        daijishouConsoleViewModel$commands$7$execute$2$pickAnItem$1.L$4 = list;
        daijishouConsoleViewModel$commands$7$execute$2$pickAnItem$1.L$5 = daijishouConsoleViewModel;
        daijishouConsoleViewModel$commands$7$execute$2$pickAnItem$1.L$6 = str;
        daijishouConsoleViewModel$commands$7$execute$2$pickAnItem$1.L$7 = newInstance$default;
        daijishouConsoleViewModel$commands$7$execute$2$pickAnItem$1.L$8 = booleanRef2;
        daijishouConsoleViewModel$commands$7$execute$2$pickAnItem$1.label = 2;
        SafeContinuation safeContinuation2 = new SafeContinuation(IntrinsicsKt.intercepted(daijishouConsoleViewModel$commands$7$execute$2$pickAnItem$1));
        newInstance$default.setOnClickListener(new DaijishouConsoleViewModel$commands$7$execute$2$pickAnItem$result$1$1(objectRef, booleanRef2, newInstance$default, safeContinuation2, daijishouApplication, daijishouConsoleViewModel$commands$7, list, daijishouConsoleViewModel, appCompatActivity, str));
        newInstance$default.setOnDialogDismissedListener(new DaijishouConsoleViewModel$commands$7$execute$2$pickAnItem$result$1$2(booleanRef2, safeContinuation2));
        newInstance$default.show(appCompatActivity.getSupportFragmentManager(), ChoosePlayableItemFromLibraryDialogFragment.class.getName());
        Object orThrow2 = safeContinuation2.getOrThrow();
        if (orThrow2 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(daijishouConsoleViewModel$commands$7$execute$2$pickAnItem$1);
        }
        if (orThrow2 == coroutine_suspended) {
            return coroutine_suspended;
        }
        return (DaijishouConsoleViewModel.Companion.CommandResult) orThrow2;
    }
}
