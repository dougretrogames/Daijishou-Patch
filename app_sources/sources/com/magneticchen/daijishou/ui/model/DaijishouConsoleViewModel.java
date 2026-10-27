package com.magneticchen.daijishou.ui.model;

import android.app.ActivityManager;
import android.app.Application;
import android.text.format.Formatter;
import androidx.appcompat.app.AppCompatActivity;
import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.data.BooleanPreference;
import com.magneticchen.daijishou.data.Constants;
import com.magneticchen.daijishou.player.DaijishouPlayerTemplate;
import com.magneticchen.daijishou.ui.fragments.dialog.DebugAndExperimentalDialogFragment;
import com.magneticchen.daijishou.ui.model.abstract_view_models.DaijishouAndroidViewModel;
import com.skydoves.balloon.internals.DefinitionKt;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: DaijishouConsoleViewModel.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 \u001e2\u00020\u0001:\u0003\u001e\u001f B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0086@¢\u0006\u0002\u0010\u0014J\"\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00132\b\b\u0002\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0018\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0013H\u0002J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u001d\u001a\u00020\u0013H\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00060\u000bR\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00060\rR\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/magneticchen/daijishou/ui/model/DaijishouConsoleViewModel;", "Lcom/magneticchen/daijishou/ui/model/abstract_view_models/DaijishouAndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "commands", "", "Lcom/magneticchen/daijishou/ui/model/DaijishouConsoleViewModel$Companion$Command;", "daijishouPlayerTemplate", "Lcom/magneticchen/daijishou/player/DaijishouPlayerTemplate;", "debugCommand", "Lcom/magneticchen/daijishou/ui/model/DaijishouConsoleViewModel$DebugCommand;", "helpCommand", "Lcom/magneticchen/daijishou/ui/model/DaijishouConsoleViewModel$HelpCommand;", "execute", "Lcom/magneticchen/daijishou/ui/model/DaijishouConsoleViewModel$Companion$CommandResult;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "command", "", "(Landroidx/appcompat/app/AppCompatActivity;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "logCommand", "", "log", "prettyPrint", "", "logUnsupportedCommand", "logWarningCommand", "toGenericNameDSESS", "string", "Companion", "DebugCommand", "HelpCommand", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DaijishouConsoleViewModel extends DaijishouAndroidViewModel {
    public static final Companion Companion = new Companion(null);
    private static final String consoleTitle = "💻 Daijishou Console";
    private static final Regex hasTemplateTagsRegex = new Regex("^[^{]*(\\{[^{]*\\}).*$");
    private static final Companion.CommandResult unsupportedCommandResult = new Companion.CommandResult("Unsupported command.", Companion.CommandResult.Companion.getUNSUPPORTED_COMMAND_STATUS_CODE(), null, false, 12, null);
    private final List<Companion.Command> commands;
    private final DaijishouPlayerTemplate daijishouPlayerTemplate;
    private final DebugCommand debugCommand;
    private final HelpCommand helpCommand;

    /* JADX INFO: renamed from: com.magneticchen.daijishou.ui.model.DaijishouConsoleViewModel$execute$1, reason: invalid class name */
    /* JADX INFO: compiled from: DaijishouConsoleViewModel.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.ui.model.DaijishouConsoleViewModel", f = "DaijishouConsoleViewModel.kt", i = {1, 1, 1}, l = {687, 698}, m = "execute", n = {"this", "trimmedCommand", "$this$execute_u24lambda_u241"}, s = {"L$0", "L$1", "L$2"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DaijishouConsoleViewModel.this.execute(null, null, this);
        }
    }

    /* JADX INFO: compiled from: DaijishouConsoleViewModel.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0002\u0012\u0013B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00102\u0006\u0010\u0011\u001a\u00020\u0004H\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0014"}, d2 = {"Lcom/magneticchen/daijishou/ui/model/DaijishouConsoleViewModel$Companion;", "", "()V", "consoleTitle", "", "getConsoleTitle", "()Ljava/lang/String;", "hasTemplateTagsRegex", "Lkotlin/text/Regex;", "getHasTemplateTagsRegex", "()Lkotlin/text/Regex;", "unsupportedCommandResult", "Lcom/magneticchen/daijishou/ui/model/DaijishouConsoleViewModel$Companion$CommandResult;", "getUnsupportedCommandResult", "()Lcom/magneticchen/daijishou/ui/model/DaijishouConsoleViewModel$Companion$CommandResult;", "splitCommandBySpaces", "", "command", "Command", "CommandResult", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {

        /* JADX INFO: compiled from: DaijishouConsoleViewModel.kt */
        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004H¦@¢\u0006\u0002\u0010\u0010R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/magneticchen/daijishou/ui/model/DaijishouConsoleViewModel$Companion$Command;", "", "()V", "description", "", "getDescription", "()Ljava/lang/String;", "startWith", "getStartWith", "execute", "Lcom/magneticchen/daijishou/ui/model/DaijishouConsoleViewModel$Companion$CommandResult;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "application", "Lcom/magneticchen/daijishou/DaijishouApplication;", "command", "(Landroidx/appcompat/app/AppCompatActivity;Lcom/magneticchen/daijishou/DaijishouApplication;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static abstract class Command {
            public abstract Object execute(AppCompatActivity appCompatActivity, DaijishouApplication daijishouApplication, String str, Continuation<? super CommandResult> continuation);

            public abstract String getDescription();

            public abstract String getStartWith();
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getConsoleTitle() {
            return DaijishouConsoleViewModel.consoleTitle;
        }

        /* JADX INFO: compiled from: DaijishouConsoleViewModel.kt */
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0016\b\u0086\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB/\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010\u0018\u001a\u00020\tHÆ\u0003J5\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001f"}, d2 = {"Lcom/magneticchen/daijishou/ui/model/DaijishouConsoleViewModel$Companion$CommandResult;", "", "message", "", "statusCode", "", "exception", "Ljava/lang/Exception;", "prettyPrint", "", "(Ljava/lang/String;ILjava/lang/Exception;Z)V", "getException", "()Ljava/lang/Exception;", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "getPrettyPrint", "()Z", "getStatusCode", "()I", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class CommandResult {
            private static final int SUCCEED_STATUS_CODE = 0;
            private final Exception exception;
            private String message;
            private final boolean prettyPrint;
            private final int statusCode;
            public static final C0026Companion Companion = new C0026Companion(null);
            private static final int UNSUPPORTED_COMMAND_STATUS_CODE = -1;
            private static final int FAILED_STATUS_CODE = -2;

            public static /* synthetic */ CommandResult copy$default(CommandResult commandResult, String str, int i, Exception exc, boolean z, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    str = commandResult.message;
                }
                if ((i2 & 2) != 0) {
                    i = commandResult.statusCode;
                }
                if ((i2 & 4) != 0) {
                    exc = commandResult.exception;
                }
                if ((i2 & 8) != 0) {
                    z = commandResult.prettyPrint;
                }
                return commandResult.copy(str, i, exc, z);
            }

            public final String component1() {
                return this.message;
            }

            public final int component2() {
                return this.statusCode;
            }

            public final Exception component3() {
                return this.exception;
            }

            public final boolean component4() {
                return this.prettyPrint;
            }

            public final CommandResult copy(String str, int i, Exception exc, boolean z) {
                return new CommandResult(str, i, exc, z);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof CommandResult)) {
                    return false;
                }
                CommandResult commandResult = (CommandResult) obj;
                return Intrinsics.areEqual(this.message, commandResult.message) && this.statusCode == commandResult.statusCode && Intrinsics.areEqual(this.exception, commandResult.exception) && this.prettyPrint == commandResult.prettyPrint;
            }

            public int hashCode() {
                String str = this.message;
                int iHashCode = (((str == null ? 0 : str.hashCode()) * 31) + Integer.hashCode(this.statusCode)) * 31;
                Exception exc = this.exception;
                return ((iHashCode + (exc != null ? exc.hashCode() : 0)) * 31) + Boolean.hashCode(this.prettyPrint);
            }

            public String toString() {
                return "CommandResult(message=" + this.message + ", statusCode=" + this.statusCode + ", exception=" + this.exception + ", prettyPrint=" + this.prettyPrint + ")";
            }

            public CommandResult(String str, int i, Exception exc, boolean z) {
                this.message = str;
                this.statusCode = i;
                this.exception = exc;
                this.prettyPrint = z;
            }

            public final String getMessage() {
                return this.message;
            }

            public final void setMessage(String str) {
                this.message = str;
            }

            public /* synthetic */ CommandResult(String str, int i, Exception exc, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, (i2 & 2) != 0 ? SUCCEED_STATUS_CODE : i, (i2 & 4) != 0 ? null : exc, (i2 & 8) != 0 ? true : z);
            }

            public final int getStatusCode() {
                return this.statusCode;
            }

            public final Exception getException() {
                return this.exception;
            }

            public final boolean getPrettyPrint() {
                return this.prettyPrint;
            }

            /* JADX INFO: renamed from: com.magneticchen.daijishou.ui.model.DaijishouConsoleViewModel$Companion$CommandResult$Companion, reason: collision with other inner class name */
            /* JADX INFO: compiled from: DaijishouConsoleViewModel.kt */
            @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/magneticchen/daijishou/ui/model/DaijishouConsoleViewModel$Companion$CommandResult$Companion;", "", "()V", "FAILED_STATUS_CODE", "", "getFAILED_STATUS_CODE", "()I", "SUCCEED_STATUS_CODE", "getSUCCEED_STATUS_CODE", "UNSUPPORTED_COMMAND_STATUS_CODE", "getUNSUPPORTED_COMMAND_STATUS_CODE", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
            public static final class C0026Companion {
                public /* synthetic */ C0026Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private C0026Companion() {
                }

                public final int getSUCCEED_STATUS_CODE() {
                    return CommandResult.SUCCEED_STATUS_CODE;
                }

                public final int getUNSUPPORTED_COMMAND_STATUS_CODE() {
                    return CommandResult.UNSUPPORTED_COMMAND_STATUS_CODE;
                }

                public final int getFAILED_STATUS_CODE() {
                    return CommandResult.FAILED_STATUS_CODE;
                }
            }
        }

        public final Regex getHasTemplateTagsRegex() {
            return DaijishouConsoleViewModel.hasTemplateTagsRegex;
        }

        public final CommandResult getUnsupportedCommandResult() {
            return DaijishouConsoleViewModel.unsupportedCommandResult;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final List<String> splitCommandBySpaces(String str) {
            List listSplit$default = StringsKt.split$default((CharSequence) str, new String[]{" "}, false, 0, 6, (Object) null);
            ArrayList arrayList = new ArrayList();
            for (Object obj : listSplit$default) {
                if (((String) obj).length() > 0) {
                    arrayList.add(obj);
                }
            }
            return arrayList;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DaijishouConsoleViewModel(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        this.daijishouPlayerTemplate = new DaijishouPlayerTemplate(application);
        HelpCommand helpCommand = new HelpCommand();
        this.helpCommand = helpCommand;
        DebugCommand debugCommand = new DebugCommand();
        this.debugCommand = debugCommand;
        this.commands = CollectionsKt.listOf((Object[]) new Companion.Command[]{helpCommand, debugCommand, new Companion.Command() { // from class: com.magneticchen.daijishou.ui.model.DaijishouConsoleViewModel$commands$1
            private final String startWith = "\\echo ";
            private final String description = "Echo command. Type \"\\echo message\". To show \"message\".";

            @Override // com.magneticchen.daijishou.ui.model.DaijishouConsoleViewModel.Companion.Command
            public String getStartWith() {
                return this.startWith;
            }

            @Override // com.magneticchen.daijishou.ui.model.DaijishouConsoleViewModel.Companion.Command
            public String getDescription() {
                return this.description;
            }

            @Override // com.magneticchen.daijishou.ui.model.DaijishouConsoleViewModel.Companion.Command
            public Object execute(AppCompatActivity appCompatActivity, DaijishouApplication daijishouApplication, String str, Continuation<? super DaijishouConsoleViewModel.Companion.CommandResult> continuation) {
                String str2 = str;
                daijishouApplication.getLogger().info(DaijishouConsoleViewModel.Companion.getConsoleTitle(), (String) StringsKt.split$default((CharSequence) str2, new String[]{"\\echo "}, false, 0, 6, (Object) null).get(1));
                return new DaijishouConsoleViewModel.Companion.CommandResult((String) StringsKt.split$default((CharSequence) str2, new String[]{"\\echo "}, false, 0, 6, (Object) null).get(1), 0, null, false, 14, null);
            }
        }, new DaijishouConsoleViewModel$commands$2(), new DaijishouConsoleViewModel$commands$3(), new Companion.Command() { // from class: com.magneticchen.daijishou.ui.model.DaijishouConsoleViewModel$commands$4
            private final String startWith = "\\prefs ";
            private final String description = "Preferences command. View and modify android preferences. Usage:\n> \\prefs list all/bool/int/string/float/long\n> \\prefs show \"your key\"\n> \\prefs set bool/int/string/float/long \"your key\" value";

            @Override // com.magneticchen.daijishou.ui.model.DaijishouConsoleViewModel.Companion.Command
            public String getStartWith() {
                return this.startWith;
            }

            @Override // com.magneticchen.daijishou.ui.model.DaijishouConsoleViewModel.Companion.Command
            public String getDescription() {
                return this.description;
            }

            @Override // com.magneticchen.daijishou.ui.model.DaijishouConsoleViewModel.Companion.Command
            public Object execute(AppCompatActivity appCompatActivity, DaijishouApplication daijishouApplication, String str, Continuation<? super DaijishouConsoleViewModel.Companion.CommandResult> continuation) {
                String str2 = str;
                List listSplitCommandBySpaces = DaijishouConsoleViewModel.Companion.splitCommandBySpaces(str2);
                HashMap mapHashMapOf = MapsKt.hashMapOf(TuplesKt.to("bool", Boxing.boxBoolean(false)), TuplesKt.to("boolean", Boxing.boxBoolean(false)), TuplesKt.to("int", Boxing.boxInt(0)), TuplesKt.to("integer", Boxing.boxInt(0)), TuplesKt.to("string", ""), TuplesKt.to("float", Boxing.boxFloat(DefinitionKt.NO_Float_VALUE)), TuplesKt.to("long", Boxing.boxLong(0L)));
                if (listSplitCommandBySpaces.size() == 3 && Intrinsics.areEqual(listSplitCommandBySpaces.get(1), "list")) {
                    Object obj = mapHashMapOf.get(listSplitCommandBySpaces.get(2));
                    ArrayList arrayList = new ArrayList();
                    if (!Intrinsics.areEqual(listSplitCommandBySpaces.get(2), "all") && obj == null) {
                        return DaijishouConsoleViewModel.Companion.getUnsupportedCommandResult();
                    }
                    Map<String, ?> all = daijishouApplication.getDefaultSharedPreferences().getAll();
                    Intrinsics.checkNotNullExpressionValue(all, "getAll(...)");
                    for (Map.Entry<String, ?> entry : all.entrySet()) {
                        String key = entry.getKey();
                        Object value = entry.getValue();
                        if (obj == null) {
                            arrayList.add(key + " -> " + value);
                        } else if (value != null && value.getClass() == obj.getClass()) {
                            arrayList.add(key + " -> " + value);
                        }
                    }
                    int size = ((arrayList.size() - 1) / 8) + 1;
                    if (1 <= size) {
                        int i = 1;
                        while (true) {
                            DaijishouConsoleViewModel.logCommand$default(this.this$0, str2, "Page " + i + " of " + size + ":\n" + CollectionsKt.joinToString$default(arrayList.subList((i - 1) * 8, Math.min(8 * i, arrayList.size())), "\n", null, null, 0, null, null, 62, null), false, 4, null);
                            if (i == size) {
                                break;
                            }
                            i++;
                            str2 = str;
                        }
                    }
                    return new DaijishouConsoleViewModel.Companion.CommandResult("Results printed in the logger.", 0, null, false, 14, null);
                }
                if (listSplitCommandBySpaces.size() >= 3 && Intrinsics.areEqual(listSplitCommandBySpaces.get(1), "show")) {
                    String str3 = (String) StringsKt.split$default((CharSequence) str, new String[]{"show "}, false, 2, 2, (Object) null).get(1);
                    return this.this$0.getDefaultSharedPreferences().contains(str3) ? new DaijishouConsoleViewModel.Companion.CommandResult(String.valueOf(this.this$0.getDefaultSharedPreferences().getAll().get(str3)), 0, null, false, 14, null) : new DaijishouConsoleViewModel.Companion.CommandResult("key \"" + str3 + "\" does not exist.", DaijishouConsoleViewModel.Companion.CommandResult.Companion.getFAILED_STATUS_CODE(), null, false, 12, null);
                }
                if (listSplitCommandBySpaces.size() >= 4 && Intrinsics.areEqual(listSplitCommandBySpaces.get(1), "set")) {
                    Object obj2 = mapHashMapOf.get(listSplitCommandBySpaces.get(2));
                    String str4 = (String) listSplitCommandBySpaces.get(3);
                    String str5 = (String) CollectionsKt.getOrNull(StringsKt.split$default((CharSequence) str, new String[]{str4 + " "}, false, 2, 2, (Object) null), 1);
                    try {
                        if (obj2 == null || str5 == null) {
                            return DaijishouConsoleViewModel.Companion.getUnsupportedCommandResult();
                        }
                        if (obj2.getClass() == Boolean.class) {
                            boolean z = Boolean.parseBoolean(StringsKt.replace$default(str5, " ", "", false, 4, (Object) null));
                            this.this$0.getDefaultSharedPreferences().edit().putBoolean(str4, z).apply();
                            return new DaijishouConsoleViewModel.Companion.CommandResult("Succeed. Set key \"" + str4 + "\" to \"" + z + "\".", 0, null, false, 14, null);
                        }
                        if (obj2.getClass() == Integer.class) {
                            int i2 = Integer.parseInt(str5);
                            this.this$0.getDefaultSharedPreferences().edit().putInt(str4, i2).apply();
                            return new DaijishouConsoleViewModel.Companion.CommandResult("Succeed. Set key \"" + str4 + "\" to \"" + i2 + "\".", 0, null, false, 14, null);
                        }
                        if (obj2.getClass() == "".getClass()) {
                            this.this$0.getDefaultSharedPreferences().edit().putString(str4, str5).apply();
                            return new DaijishouConsoleViewModel.Companion.CommandResult("Succeed. Set key \"" + str4 + "\" to \"" + str5 + "\".", 0, null, false, 14, null);
                        }
                        if (obj2.getClass() == Float.class) {
                            float f = Float.parseFloat(str5);
                            this.this$0.getDefaultSharedPreferences().edit().putFloat(str4, f).apply();
                            return new DaijishouConsoleViewModel.Companion.CommandResult("Succeed. Set key \"" + str4 + "\" to \"" + f + "\".", 0, null, false, 14, null);
                        }
                        if (obj2.getClass() == Long.class) {
                            long j = Long.parseLong(str5);
                            this.this$0.getDefaultSharedPreferences().edit().putLong(str4, j).apply();
                            return new DaijishouConsoleViewModel.Companion.CommandResult("Succeed. Set key \"" + str4 + "\" to \"" + j + "\".", 0, null, false, 14, null);
                        }
                        return DaijishouConsoleViewModel.Companion.getUnsupportedCommandResult();
                    } catch (Exception e) {
                        String message = e.getMessage();
                        if (message == null) {
                            message = ExceptionsKt.stackTraceToString(e);
                        }
                        return new DaijishouConsoleViewModel.Companion.CommandResult(message, DaijishouConsoleViewModel.Companion.CommandResult.Companion.getFAILED_STATUS_CODE(), e, false, 8, null);
                    }
                }
                return DaijishouConsoleViewModel.Companion.getUnsupportedCommandResult();
            }
        }, new DaijishouConsoleViewModel$commands$5(this), new DaijishouConsoleViewModel$commands$6(this), new DaijishouConsoleViewModel$commands$7(this), new DaijishouConsoleViewModel$commands$8(), new Companion.Command() { // from class: com.magneticchen.daijishou.ui.model.DaijishouConsoleViewModel$commands$9
            private final String startWith = "\\cache ";
            private final String description = "Cache command. Usage:\n> \\cache clear all ";

            @Override // com.magneticchen.daijishou.ui.model.DaijishouConsoleViewModel.Companion.Command
            public String getStartWith() {
                return this.startWith;
            }

            @Override // com.magneticchen.daijishou.ui.model.DaijishouConsoleViewModel.Companion.Command
            public String getDescription() {
                return this.description;
            }

            @Override // com.magneticchen.daijishou.ui.model.DaijishouConsoleViewModel.Companion.Command
            public Object execute(AppCompatActivity appCompatActivity, DaijishouApplication daijishouApplication, String str, Continuation<? super DaijishouConsoleViewModel.Companion.CommandResult> continuation) {
                List listSplitCommandBySpaces = DaijishouConsoleViewModel.Companion.splitCommandBySpaces(str);
                if (listSplitCommandBySpaces.size() == 3 && Intrinsics.areEqual(listSplitCommandBySpaces.get(1), "clear") && Intrinsics.areEqual(listSplitCommandBySpaces.get(2), "all")) {
                    File cacheDir = daijishouApplication.getCacheDir();
                    Intrinsics.checkNotNullExpressionValue(cacheDir, "getCacheDir(...)");
                    FilesKt.deleteRecursively(cacheDir);
                    return new DaijishouConsoleViewModel.Companion.CommandResult("Executed.", 0, null, false, 14, null);
                }
                return DaijishouConsoleViewModel.Companion.getUnsupportedCommandResult();
            }
        }, new Companion.Command() { // from class: com.magneticchen.daijishou.ui.model.DaijishouConsoleViewModel$commands$10
            private final String startWith = "\\db ";
            private final String description = "Database command. Usage:\n> \\db delete \"You Database code to be deleted\"";

            @Override // com.magneticchen.daijishou.ui.model.DaijishouConsoleViewModel.Companion.Command
            public String getStartWith() {
                return this.startWith;
            }

            @Override // com.magneticchen.daijishou.ui.model.DaijishouConsoleViewModel.Companion.Command
            public String getDescription() {
                return this.description;
            }

            @Override // com.magneticchen.daijishou.ui.model.DaijishouConsoleViewModel.Companion.Command
            public Object execute(AppCompatActivity appCompatActivity, DaijishouApplication daijishouApplication, String str, Continuation<? super DaijishouConsoleViewModel.Companion.CommandResult> continuation) {
                String string;
                if (Intrinsics.areEqual(DaijishouConsoleViewModel.Companion.splitCommandBySpaces(str).get(1), "delete")) {
                    String str2 = (String) CollectionsKt.getOrNull(StringsKt.split$default((CharSequence) str, new String[]{"delete"}, false, 2, 2, (Object) null), 1);
                    if (str2 == null || (string = StringsKt.trimStart((CharSequence) str2).toString()) == null) {
                        return DaijishouConsoleViewModel.Companion.getUnsupportedCommandResult();
                    }
                    daijishouApplication.deleteDatabase(string);
                    File databasePath = daijishouApplication.getDatabasePath(string);
                    File file = new File(databasePath.getPath() + "-shm");
                    File file2 = new File(databasePath.getPath() + "-wal");
                    File file3 = new File(databasePath.getPath() + "-bkp");
                    if (databasePath.exists()) {
                        databasePath.delete();
                    }
                    if (file.exists()) {
                        file.delete();
                    }
                    if (file2.exists()) {
                        file2.delete();
                    }
                    if (file3.exists()) {
                        file3.delete();
                    }
                    return new DaijishouConsoleViewModel.Companion.CommandResult("Database \"" + string + "\" deletion executed. All connections have to be closed to be succeed.", 0, null, false, 14, null);
                }
                return DaijishouConsoleViewModel.Companion.getUnsupportedCommandResult();
            }
        }, new Companion.Command() { // from class: com.magneticchen.daijishou.ui.model.DaijishouConsoleViewModel$commands$11
            private final String startWith = "\\app ";
            private final String description = "Daijishou Application related command. Usage:\n> \\app mem stats\n> \\app mem gc\n> \\app clear logs\n> \\app finish\n> \\app terminate\n> \\app show version";

            @Override // com.magneticchen.daijishou.ui.model.DaijishouConsoleViewModel.Companion.Command
            public String getStartWith() {
                return this.startWith;
            }

            @Override // com.magneticchen.daijishou.ui.model.DaijishouConsoleViewModel.Companion.Command
            public String getDescription() {
                return this.description;
            }

            @Override // com.magneticchen.daijishou.ui.model.DaijishouConsoleViewModel.Companion.Command
            public Object execute(AppCompatActivity appCompatActivity, DaijishouApplication daijishouApplication, String str, Continuation<? super DaijishouConsoleViewModel.Companion.CommandResult> continuation) {
                List listSplitCommandBySpaces = DaijishouConsoleViewModel.Companion.splitCommandBySpaces(str);
                if (listSplitCommandBySpaces.size() == 3 && ((Intrinsics.areEqual(listSplitCommandBySpaces.get(1), "mem") || Intrinsics.areEqual(listSplitCommandBySpaces.get(1), "memory")) && Intrinsics.areEqual(listSplitCommandBySpaces.get(2), "stats"))) {
                    Runtime runtime = Runtime.getRuntime();
                    long jMaxMemory = runtime.maxMemory();
                    long j = runtime.totalMemory();
                    long jFreeMemory = runtime.freeMemory();
                    ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                    Object systemService = daijishouApplication.getSystemService("activity");
                    Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
                    ((ActivityManager) systemService).getMemoryInfo(memoryInfo);
                    long j2 = memoryInfo.totalMem;
                    long j3 = memoryInfo.availMem;
                    DaijishouApplication daijishouApplication2 = daijishouApplication;
                    String fileSize = Formatter.formatFileSize(daijishouApplication2, jMaxMemory);
                    String str2 = String.format("%,d", Arrays.copyOf(new Object[]{Boxing.boxLong(jMaxMemory)}, 1));
                    Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                    String fileSize2 = Formatter.formatFileSize(daijishouApplication2, j);
                    String str3 = String.format("%,d", Arrays.copyOf(new Object[]{Boxing.boxLong(j)}, 1));
                    Intrinsics.checkNotNullExpressionValue(str3, "format(...)");
                    String fileSize3 = Formatter.formatFileSize(daijishouApplication2, jFreeMemory);
                    String str4 = String.format("%,d", Arrays.copyOf(new Object[]{Boxing.boxLong(jFreeMemory)}, 1));
                    Intrinsics.checkNotNullExpressionValue(str4, "format(...)");
                    long j4 = jMaxMemory - jFreeMemory;
                    String fileSize4 = Formatter.formatFileSize(daijishouApplication2, j4);
                    String str5 = String.format("%,d", Arrays.copyOf(new Object[]{Boxing.boxLong(j4)}, 1));
                    Intrinsics.checkNotNullExpressionValue(str5, "format(...)");
                    String fileSize5 = Formatter.formatFileSize(daijishouApplication2, j2);
                    String str6 = String.format("%,d", Arrays.copyOf(new Object[]{Boxing.boxLong(j2)}, 1));
                    Intrinsics.checkNotNullExpressionValue(str6, "format(...)");
                    String fileSize6 = Formatter.formatFileSize(daijishouApplication2, j3);
                    String str7 = String.format("%,d", Arrays.copyOf(new Object[]{Boxing.boxLong(j3)}, 1));
                    Intrinsics.checkNotNullExpressionValue(str7, "format(...)");
                    long j5 = j2 - j3;
                    String fileSize7 = Formatter.formatFileSize(daijishouApplication2, j5);
                    String str8 = String.format("%,d", Arrays.copyOf(new Object[]{Boxing.boxLong(j5)}, 1));
                    Intrinsics.checkNotNullExpressionValue(str8, "format(...)");
                    return new DaijishouConsoleViewModel.Companion.CommandResult("Runtime max: " + fileSize + " (" + str2 + ").\nRuntime total: " + fileSize2 + " (" + str3 + ").\nRuntime free: " + fileSize3 + " (" + str4 + ").\nRuntime used: " + fileSize4 + " (" + str5 + ").\nNative heap: " + fileSize5 + " (" + str6 + ").\nNative heap free: " + fileSize6 + " (" + str7 + ").\nNative heap used: " + fileSize7 + " (" + str8 + ").", 0, null, false, 14, null);
                }
                if (listSplitCommandBySpaces.size() == 3 && ((Intrinsics.areEqual(listSplitCommandBySpaces.get(1), "mem") || Intrinsics.areEqual(listSplitCommandBySpaces.get(1), "memory")) && Intrinsics.areEqual(listSplitCommandBySpaces.get(2), "gc"))) {
                    Runtime.getRuntime().gc();
                    return new DaijishouConsoleViewModel.Companion.CommandResult("Executed.", 0, null, false, 14, null);
                }
                if (listSplitCommandBySpaces.size() == 3 && Intrinsics.areEqual(listSplitCommandBySpaces.get(1), "clear") && Intrinsics.areEqual(listSplitCommandBySpaces.get(2), "logs")) {
                    daijishouApplication.getLogger().clear();
                    return new DaijishouConsoleViewModel.Companion.CommandResult("Logs cleared.", 0, null, false, 14, null);
                }
                if (listSplitCommandBySpaces.size() == 2 && Intrinsics.areEqual(listSplitCommandBySpaces.get(1), "finish")) {
                    appCompatActivity.finish();
                    return new DaijishouConsoleViewModel.Companion.CommandResult("Activity finished.", 0, null, false, 14, null);
                }
                if (listSplitCommandBySpaces.size() == 2 && Intrinsics.areEqual(listSplitCommandBySpaces.get(1), "terminate")) {
                    appCompatActivity.finishAffinity();
                    daijishouApplication.stopAllServices();
                    System.exit(0);
                    throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
                }
                if (listSplitCommandBySpaces.size() == 3 && Intrinsics.areEqual(listSplitCommandBySpaces.get(1), "show") && Intrinsics.areEqual(listSplitCommandBySpaces.get(2), "version")) {
                    return new DaijishouConsoleViewModel.Companion.CommandResult("1.8.1 (426)", 0, null, false, 14, null);
                }
                return DaijishouConsoleViewModel.Companion.getUnsupportedCommandResult();
            }
        }});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String toGenericNameDSESS(String str) {
        List<String> groupValues;
        String str2;
        MatchResult matchResultFind$default = Regex.find$default(Constants.INSTANCE.getToGenericNameRegex(), str, 0, 2, null);
        if (matchResultFind$default != null && (groupValues = matchResultFind$default.getGroupValues()) != null && (str2 = groupValues.get(1)) != null) {
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
            String lowerCase = str2.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            if (lowerCase != null) {
                String strReplace = new Regex("\\s*-\\s+Disc\\s+\\d+\\s*", RegexOption.IGNORE_CASE).replace(lowerCase, "");
                if (strReplace != null) {
                    return new Regex("(\\s+|_+)").replace(strReplace, " ");
                }
            }
        }
        return null;
    }

    static /* synthetic */ void logCommand$default(DaijishouConsoleViewModel daijishouConsoleViewModel, String str, String str2, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        daijishouConsoleViewModel.logCommand(str, str2, z);
    }

    private final void logCommand(String str, String str2, boolean z) {
        if (z) {
            getApplication().getLogger().info(consoleTitle, str + "\n> " + StringsKt.replace$default(str2, "\n", "\n> ", false, 4, (Object) null));
            return;
        }
        getApplication().getLogger().info(consoleTitle, str + "\n" + str2);
    }

    private final void logWarningCommand(String str, String str2) {
        getApplication().getLogger().warn(consoleTitle, str + "\n> " + StringsKt.replace$default(str2, "\n", "\n> ", false, 4, (Object) null));
    }

    private final void logUnsupportedCommand(String str) {
        getApplication().getLogger().warn(consoleTitle, str + "\n> Unsupported command.");
    }

    /* JADX INFO: compiled from: DaijishouConsoleViewModel.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004H\u0096@¢\u0006\u0002\u0010\u0010R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/magneticchen/daijishou/ui/model/DaijishouConsoleViewModel$HelpCommand;", "Lcom/magneticchen/daijishou/ui/model/DaijishouConsoleViewModel$Companion$Command;", "(Lcom/magneticchen/daijishou/ui/model/DaijishouConsoleViewModel;)V", "description", "", "getDescription", "()Ljava/lang/String;", "startWith", "getStartWith", "execute", "Lcom/magneticchen/daijishou/ui/model/DaijishouConsoleViewModel$Companion$CommandResult;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "application", "Lcom/magneticchen/daijishou/DaijishouApplication;", "command", "(Landroidx/appcompat/app/AppCompatActivity;Lcom/magneticchen/daijishou/DaijishouApplication;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class HelpCommand extends Companion.Command {
        private final String startWith = "\\help";
        private final String description = "Help command. Type to see commands usages.\n> \\help\n> \\help \"keyword\"";

        public HelpCommand() {
        }

        @Override // com.magneticchen.daijishou.ui.model.DaijishouConsoleViewModel.Companion.Command
        public String getStartWith() {
            return this.startWith;
        }

        @Override // com.magneticchen.daijishou.ui.model.DaijishouConsoleViewModel.Companion.Command
        public String getDescription() {
            return this.description;
        }

        @Override // com.magneticchen.daijishou.ui.model.DaijishouConsoleViewModel.Companion.Command
        public Object execute(AppCompatActivity appCompatActivity, DaijishouApplication daijishouApplication, String str, Continuation<? super Companion.CommandResult> continuation) {
            String str2 = (String) CollectionsKt.getOrNull(DaijishouConsoleViewModel.Companion.splitCommandBySpaces(str), 1);
            String str3 = "";
            int i = 0;
            for (Object obj : DaijishouConsoleViewModel.this.commands) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Companion.Command command = (Companion.Command) obj;
                if (str2 == null || StringsKt.contains$default((CharSequence) command.getStartWith(), (CharSequence) str2, false, 2, (Object) null)) {
                    str3 = ((Object) (((Object) str3) + "Start with: " + command.getStartWith() + "\n  " + StringsKt.replace$default(command.getDescription(), "\n", "\n  ", false, 4, (Object) null))) + "\n\n";
                }
                i = i2;
            }
            return new Companion.CommandResult(((Object) str3) + "If you are using Daijishou SDK, there will be additional commands.\nPlease check: https://github.com/Daijishou/Daijishou-SDK", 0, null, false, 6, null);
        }
    }

    /* JADX INFO: compiled from: DaijishouConsoleViewModel.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004H\u0096@¢\u0006\u0002\u0010\u0010R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/magneticchen/daijishou/ui/model/DaijishouConsoleViewModel$DebugCommand;", "Lcom/magneticchen/daijishou/ui/model/DaijishouConsoleViewModel$Companion$Command;", "(Lcom/magneticchen/daijishou/ui/model/DaijishouConsoleViewModel;)V", "description", "", "getDescription", "()Ljava/lang/String;", "startWith", "getStartWith", "execute", "Lcom/magneticchen/daijishou/ui/model/DaijishouConsoleViewModel$Companion$CommandResult;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "application", "Lcom/magneticchen/daijishou/DaijishouApplication;", "command", "(Landroidx/appcompat/app/AppCompatActivity;Lcom/magneticchen/daijishou/DaijishouApplication;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class DebugCommand extends Companion.Command {
        private final String startWith = "\\debug";
        private final String description = "Debug command to toggle debug mode. Usage:\n> \\debug on/off\n> \\debug show menu";

        public DebugCommand() {
        }

        @Override // com.magneticchen.daijishou.ui.model.DaijishouConsoleViewModel.Companion.Command
        public String getStartWith() {
            return this.startWith;
        }

        @Override // com.magneticchen.daijishou.ui.model.DaijishouConsoleViewModel.Companion.Command
        public String getDescription() {
            return this.description;
        }

        @Override // com.magneticchen.daijishou.ui.model.DaijishouConsoleViewModel.Companion.Command
        public Object execute(AppCompatActivity appCompatActivity, DaijishouApplication daijishouApplication, String str, Continuation<? super Companion.CommandResult> continuation) {
            List listSplitCommandBySpaces = DaijishouConsoleViewModel.Companion.splitCommandBySpaces(str);
            String str2 = str;
            if (StringsKt.contains$default((CharSequence) StringsKt.split$default((CharSequence) str2, new String[]{"\\debug"}, false, 0, 6, (Object) null).get(1), (CharSequence) " on", false, 2, (Object) null)) {
                DaijishouConsoleViewModel.this.getDefaultSharedPreferences().edit().putBoolean(BooleanPreference.USE_DEBUG_MODE.getKey(), true).apply();
                return new Companion.CommandResult("Debug mode set to \"true\".", 0, null, false, 14, null);
            }
            if (StringsKt.contains$default((CharSequence) StringsKt.split$default((CharSequence) str2, new String[]{"\\debug"}, false, 0, 6, (Object) null).get(1), (CharSequence) " off", false, 2, (Object) null)) {
                DaijishouConsoleViewModel.this.getDefaultSharedPreferences().edit().putBoolean(BooleanPreference.USE_DEBUG_MODE.getKey(), false).apply();
                return new Companion.CommandResult("Debug mode set to \"false\".", 0, null, false, 14, null);
            }
            if (listSplitCommandBySpaces.size() == 3 && Intrinsics.areEqual(listSplitCommandBySpaces.get(1), "show") && Intrinsics.areEqual(listSplitCommandBySpaces.get(2), "menu")) {
                DebugAndExperimentalDialogFragment.Companion.newInstance().show(appCompatActivity.getSupportFragmentManager(), DebugAndExperimentalDialogFragment.class.getName());
                return new Companion.CommandResult("Menu is shown in app.", 0, null, false, 14, null);
            }
            return DaijishouConsoleViewModel.Companion.getUnsupportedCommandResult();
        }
    }

    /* JADX WARN: Code duplicated, block: B:43:0x00fa A[Catch: Exception -> 0x003b, TryCatch #0 {Exception -> 0x003b, blocks: (B:13:0x0036, B:41:0x00ec, B:43:0x00fa, B:46:0x0102, B:48:0x0114, B:50:0x0120, B:53:0x0128, B:55:0x0136, B:57:0x0142), top: B:68:0x0036 }] */
    /* JADX WARN: Code duplicated, block: B:45:0x0100  */
    /* JADX WARN: Code duplicated, block: B:48:0x0114 A[Catch: Exception -> 0x003b, TryCatch #0 {Exception -> 0x003b, blocks: (B:13:0x0036, B:41:0x00ec, B:43:0x00fa, B:46:0x0102, B:48:0x0114, B:50:0x0120, B:53:0x0128, B:55:0x0136, B:57:0x0142), top: B:68:0x0036 }] */
    /* JADX WARN: Code duplicated, block: B:50:0x0120 A[Catch: Exception -> 0x003b, TryCatch #0 {Exception -> 0x003b, blocks: (B:13:0x0036, B:41:0x00ec, B:43:0x00fa, B:46:0x0102, B:48:0x0114, B:50:0x0120, B:53:0x0128, B:55:0x0136, B:57:0x0142), top: B:68:0x0036 }] */
    /* JADX WARN: Code duplicated, block: B:52:0x0126  */
    /* JADX WARN: Code duplicated, block: B:55:0x0136 A[Catch: Exception -> 0x003b, TryCatch #0 {Exception -> 0x003b, blocks: (B:13:0x0036, B:41:0x00ec, B:43:0x00fa, B:46:0x0102, B:48:0x0114, B:50:0x0120, B:53:0x0128, B:55:0x0136, B:57:0x0142), top: B:68:0x0036 }] */
    /* JADX WARN: Code duplicated, block: B:57:0x0142 A[Catch: Exception -> 0x003b, TRY_LEAVE, TryCatch #0 {Exception -> 0x003b, blocks: (B:13:0x0036, B:41:0x00ec, B:43:0x00fa, B:46:0x0102, B:48:0x0114, B:50:0x0120, B:53:0x0128, B:55:0x0136, B:57:0x0142), top: B:68:0x0036 }] */
    /* JADX WARN: Code duplicated, block: B:63:0x0166  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0146, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0147, code lost:
    
        r9 = r0;
        r8 = r7;
        r1 = r8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object execute(androidx.appcompat.app.AppCompatActivity r8, java.lang.String r9, kotlin.coroutines.Continuation<? super com.magneticchen.daijishou.ui.model.DaijishouConsoleViewModel.Companion.CommandResult> r10) {
        /*
            Method dump skipped, instruction units count: 383
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.magneticchen.daijishou.ui.model.DaijishouConsoleViewModel.execute(androidx.appcompat.app.AppCompatActivity, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
