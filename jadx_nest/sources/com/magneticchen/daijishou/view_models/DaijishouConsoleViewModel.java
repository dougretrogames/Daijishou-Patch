package com.magneticchen.daijishou.view_models;

import android.app.Application;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.application_data.BooleanPreference;
import com.magneticchen.daijishou.application_data.Constants;
import com.magneticchen.daijishou.daijishou_player.DaijishouPlayerTemplate;
import com.magneticchen.daijishou.dialog_fragments.DebugAndExperimentalDialogFragment;
import com.magneticchen.daijishou.view_models.abstract_view_models.DaijishouAndroidViewModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;
import org.eclipse.jgit.lib.ConfigConstants;

/* JADX INFO: compiled from: DaijishouConsoleViewModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 \u001e2\u00020\u0001:\u0003\u001e\u001f B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0086@¢\u0006\u0002\u0010\u0014J\"\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00132\b\b\u0002\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0018\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0013H\u0002J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u001d\u001a\u00020\u0013H\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00060\u000bR\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00060\rR\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/magneticchen/daijishou/view_models/DaijishouConsoleViewModel;", "Lcom/magneticchen/daijishou/view_models/abstract_view_models/DaijishouAndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "commands", "", "Lcom/magneticchen/daijishou/view_models/DaijishouConsoleViewModel$Companion$Command;", "daijishouPlayerTemplate", "Lcom/magneticchen/daijishou/daijishou_player/DaijishouPlayerTemplate;", "debugCommand", "Lcom/magneticchen/daijishou/view_models/DaijishouConsoleViewModel$DebugCommand;", "helpCommand", "Lcom/magneticchen/daijishou/view_models/DaijishouConsoleViewModel$HelpCommand;", "execute", "Lcom/magneticchen/daijishou/view_models/DaijishouConsoleViewModel$Companion$CommandResult;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "command", "", "(Landroidx/appcompat/app/AppCompatActivity;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "logCommand", "", "log", "prettyPrint", "", "logUnsupportedCommand", "logWarningCommand", "toGenericNameDSESS", TypedValues.Custom.S_STRING, "Companion", "DebugCommand", "HelpCommand", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DaijishouConsoleViewModel extends DaijishouAndroidViewModel {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String consoleTitle = "💻 Daijishou Console";
    private static final Regex hasTemplateTagsRegex = new Regex("^[^{]*(\\{[^{]*\\}).*$");
    private static final Companion.CommandResult unsupportedCommandResult = new Companion.CommandResult("Unsupported command.", Companion.CommandResult.INSTANCE.getUNSUPPORTED_COMMAND_STATUS_CODE(), null, false, 12, null);
    private final List<Companion.Command> commands;
    public final DaijishouPlayerTemplate daijishouPlayerTemplate;
    private final DebugCommand debugCommand;
    private final HelpCommand helpCommand;

    /* JADX INFO: renamed from: com.magneticchen.daijishou.view_models.DaijishouConsoleViewModel$execute$1, reason: invalid class name */
    /* JADX INFO: compiled from: DaijishouConsoleViewModel.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.magneticchen.daijishou.view_models.DaijishouConsoleViewModel", f = "DaijishouConsoleViewModel.kt", i = {1, 1, 1}, l = {695, TypedValues.TransitionType.TYPE_STAGGERED}, m = "execute", n = {"this", "trimmedCommand", "$this$execute_u24lambda_u241"}, s = {"L$0", "L$1", "L$2"})
    final class AnonymousClass1 extends com.magneticchen.daijishou.support.DaijishouContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<?> continuation) {
            super(continuation);
        }

        public final Object invokeSuspendImpl(Object obj)throws Throwable {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DaijishouConsoleViewModel.this.execute(null, null, this);
        }
    }

    /* JADX INFO: compiled from: DaijishouConsoleViewModel.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0002\u0012\u0013B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00102\u0006\u0010\u0011\u001a\u00020\u0004H\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0014"}, d2 = {"Lcom/magneticchen/daijishou/view_models/DaijishouConsoleViewModel$Companion;", "", "()V", "consoleTitle", "", "getConsoleTitle", "()Ljava/lang/String;", "hasTemplateTagsRegex", "Lkotlin/text/Regex;", "getHasTemplateTagsRegex", "()Lkotlin/text/Regex;", "unsupportedCommandResult", "Lcom/magneticchen/daijishou/view_models/DaijishouConsoleViewModel$Companion$CommandResult;", "getUnsupportedCommandResult", "()Lcom/magneticchen/daijishou/view_models/DaijishouConsoleViewModel$Companion$CommandResult;", "splitCommandBySpaces", "", "command", "Command", "CommandResult", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {

        /* JADX INFO: compiled from: DaijishouConsoleViewModel.kt */
        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004H¦@¢\u0006\u0002\u0010\u0010R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/magneticchen/daijishou/view_models/DaijishouConsoleViewModel$Companion$Command;", "", "()V", "description", "", "getDescription", "()Ljava/lang/String;", "startWith", "getStartWith", "execute", "Lcom/magneticchen/daijishou/view_models/DaijishouConsoleViewModel$Companion$CommandResult;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "application", "Lcom/magneticchen/daijishou/DaijishouApplication;", "command", "(Landroidx/appcompat/app/AppCompatActivity;Lcom/magneticchen/daijishou/DaijishouApplication;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static abstract class Command {
            public abstract Object execute(AppCompatActivity appCompatActivity, DaijishouApplication daijishouApplication, String str, Continuation<?> continuation);

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
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0016\b\u0086\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB/\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010\u0018\u001a\u00020\tHÆ\u0003J5\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001f"}, d2 = {"Lcom/magneticchen/daijishou/view_models/DaijishouConsoleViewModel$Companion$CommandResult;", "", "message", "", "statusCode", "", "exception", "Ljava/lang/Exception;", "prettyPrint", "", "(Ljava/lang/String;ILjava/lang/Exception;Z)V", "getException", "()Ljava/lang/Exception;", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "getPrettyPrint", "()Z", "getStatusCode", "()I", "component1", "component2", "component3", "component4", ConfigConstants.CONFIG_RENAMELIMIT_COPY, "equals", "other", "hashCode", "toString", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final /* data */ class CommandResult {
            private static final int SUCCEED_STATUS_CODE = 0;
            private final Exception exception;
            private String message;
            private final boolean prettyPrint;
            private final int statusCode;

            /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
            public static final CommandResultCompanion INSTANCE = new CommandResultCompanion(null);
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

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getMessage() {
                return this.message;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final int getStatusCode() {
                return this.statusCode;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final Exception getException() {
                return this.exception;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final boolean getPrettyPrint() {
                return this.prettyPrint;
            }

            public final CommandResult copy(String message, int statusCode, Exception exception, boolean prettyPrint) {
                return new CommandResult(message, statusCode, exception, prettyPrint);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof CommandResult)) {
                    return false;
                }
                CommandResult commandResult = (CommandResult) other;
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


            public final void setMessage(String str) {
                this.message = str;
            }

            public /* synthetic */ CommandResult(String str, int i, Exception exc, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, (i2 & 2) != 0 ? SUCCEED_STATUS_CODE : i, (i2 & 4) != 0 ? null : exc, (i2 & 8) != 0 ? true : z);
            }




            /* JADX INFO: compiled from: DaijishouConsoleViewModel.kt */
            @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u00020\u0004X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/magneticchen/daijishou/view_models/DaijishouConsoleViewModel$Companion$CommandResult$Companion;", "", "()V", "FAILED_STATUS_CODE", "", "getFAILED_STATUS_CODE", "()I", "SUCCEED_STATUS_CODE", "getSUCCEED_STATUS_CODE", "UNSUPPORTED_COMMAND_STATUS_CODE", "getUNSUPPORTED_COMMAND_STATUS_CODE", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
            public static final class CommandResultCompanion {
                public /* synthetic */ CommandResultCompanion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                }

                private CommandResultCompanion() {
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
        public final List<String> splitCommandBySpaces(String command) {
            List listSplit$default = StringsKt.split$default((CharSequence) command, new String[]{" "}, false, 0, 6, (Object) null);
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
        this.commands = CollectionsKt.listOf(new Companion.Command[]{helpCommand, debugCommand, new DaijishouConsoleViewModel$commands$1(), new DaijishouConsoleViewModel$commands$2(), new DaijishouConsoleViewModel$commands$3(), new DaijishouConsoleViewModel$commands$4(this), new DaijishouConsoleViewModel$commands$5(this), new DaijishouConsoleViewModel$commands$6(this), new DaijishouConsoleViewModel$commands$7(this), new DaijishouConsoleViewModel$commands$8(), new DaijishouConsoleViewModel$commands$9(), new DaijishouConsoleViewModel$commands$10(), new DaijishouConsoleViewModel$commands$11()});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String toGenericNameDSESS(String string) {
        List<String> groupValues;
        String str;
        MatchResult matchResultFind$default = Regex.find$default(Constants.INSTANCE.getToGenericNameRegex(), string, 0, 2, null);
        if (matchResultFind$default != null && (groupValues = matchResultFind$default.getGroupValues()) != null && (str = groupValues.get(1)) != null) {
            Locale locale = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
            String lowerCase = str.toLowerCase(locale);
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

    private final void logCommand(String command, String log, boolean prettyPrint) {
        if (prettyPrint) {
            getApplication().getLogger().info(consoleTitle, command + "\n> " + StringsKt.replace$default(log, "\n", "\n> ", false, 4, (Object) null));
            return;
        }
        getApplication().getLogger().info(consoleTitle, command + "\n" + log);
    }

    private final void logWarningCommand(String command, String log) {
        getApplication().getLogger().warn(consoleTitle, command + "\n> " + StringsKt.replace$default(log, "\n", "\n> ", false, 4, (Object) null));
    }

    private final void logUnsupportedCommand(String command) {
        getApplication().getLogger().warn(consoleTitle, command + "\n> Unsupported command.");
    }

    /* JADX INFO: compiled from: DaijishouConsoleViewModel.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004H\u0096@¢\u0006\u0002\u0010\u0010R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/magneticchen/daijishou/view_models/DaijishouConsoleViewModel$HelpCommand;", "Lcom/magneticchen/daijishou/view_models/DaijishouConsoleViewModel$Companion$Command;", "(Lcom/magneticchen/daijishou/view_models/DaijishouConsoleViewModel;)V", "description", "", "getDescription", "()Ljava/lang/String;", "startWith", "getStartWith", "execute", "Lcom/magneticchen/daijishou/view_models/DaijishouConsoleViewModel$Companion$CommandResult;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "application", "Lcom/magneticchen/daijishou/DaijishouApplication;", "command", "(Landroidx/appcompat/app/AppCompatActivity;Lcom/magneticchen/daijishou/DaijishouApplication;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class HelpCommand extends Companion.Command {
        private final String startWith = "\\help";
        private final String description = "Help command. Type to see commands usages.\n> \\help\n> \\help \"keyword\"";

        public HelpCommand() {
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
            String str2 = (String) CollectionsKt.getOrNull(DaijishouConsoleViewModel.INSTANCE.splitCommandBySpaces(str), 1);
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
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004H\u0096@¢\u0006\u0002\u0010\u0010R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/magneticchen/daijishou/view_models/DaijishouConsoleViewModel$DebugCommand;", "Lcom/magneticchen/daijishou/view_models/DaijishouConsoleViewModel$Companion$Command;", "(Lcom/magneticchen/daijishou/view_models/DaijishouConsoleViewModel;)V", "description", "", "getDescription", "()Ljava/lang/String;", "startWith", "getStartWith", "execute", "Lcom/magneticchen/daijishou/view_models/DaijishouConsoleViewModel$Companion$CommandResult;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "application", "Lcom/magneticchen/daijishou/DaijishouApplication;", "command", "(Landroidx/appcompat/app/AppCompatActivity;Lcom/magneticchen/daijishou/DaijishouApplication;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class DebugCommand extends Companion.Command {
        private final String startWith = "\\debug";
        private final String description = "Debug command to toggle debug mode. Usage:\n> \\debug on/off\n> \\debug show menu";

        public DebugCommand() {
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
            List listSplitCommandBySpaces = DaijishouConsoleViewModel.INSTANCE.splitCommandBySpaces(str);
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
                DebugAndExperimentalDialogFragment.INSTANCE.newInstance().show(appCompatActivity.getSupportFragmentManager(), DebugAndExperimentalDialogFragment.class.getName());
                return new Companion.CommandResult("Menu is shown in app.", 0, null, false, 14, null);
            }
            return DaijishouConsoleViewModel.INSTANCE.getUnsupportedCommandResult();
        }
    }

    public final Object execute(AppCompatActivity appCompatActivity, String str, Continuation<?> continuation) throws Throwable {
        AnonymousClass1 anonymousClass1;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i != 0) {
            if (i == 1) {
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            if (i == 2) {
                DaijishouConsoleViewModel daijishouConsoleViewModel = (DaijishouConsoleViewModel) anonymousClass1.L$2;
                String str2 = (String) anonymousClass1.L$1;
                DaijishouConsoleViewModel daijishouConsoleViewModel2 = (DaijishouConsoleViewModel) anonymousClass1.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                    Companion.CommandResult commandResult = (Companion.CommandResult) obj;
                    if (commandResult.getStatusCode() == Companion.CommandResult.INSTANCE.getSUCCEED_STATUS_CODE()) {
                        String message = commandResult.getMessage();
                        if (message == null) {
                            message = "Succeed. With null value.";
                        }
                        commandResult.setMessage(message);
                        String message2 = commandResult.getMessage();
                        Intrinsics.checkNotNull(message2);
                        daijishouConsoleViewModel.logCommand(str2, message2, commandResult.getPrettyPrint());
                        return commandResult;
                    }
                    if (commandResult.getStatusCode() == Companion.CommandResult.INSTANCE.getFAILED_STATUS_CODE()) {
                        String message3 = commandResult.getMessage();
                        if (message3 == null) {
                            message3 = "Failed. With null value.";
                        }
                        commandResult.setMessage(message3);
                        String message4 = commandResult.getMessage();
                        Intrinsics.checkNotNull(message4);
                        daijishouConsoleViewModel.logWarningCommand(str2, message4);
                        return commandResult;
                    }
                    if (commandResult.getStatusCode() == Companion.CommandResult.INSTANCE.getUNSUPPORTED_COMMAND_STATUS_CODE()) {
                        daijishouConsoleViewModel.logUnsupportedCommand(str2);
                    }
                    return commandResult;
                } catch (Exception e) {
                    daijishouConsoleViewModel.getApplication().getLogger().warn(daijishouConsoleViewModel2, ExceptionsKt.stackTraceToString(e));
                    String message5 = e.getMessage();
                    if (message5 == null) {
                        message5 = ExceptionsKt.stackTraceToString(e);
                    }
                    return new Companion.CommandResult(message5, Companion.CommandResult.INSTANCE.getFAILED_STATUS_CODE(), null, false, 12, null);
                }
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        String string = StringsKt.trimStart((CharSequence) str).toString();
        if (!getApplication().getDefaultSharedPreferences().getBoolean(BooleanPreference.USE_DEBUG_MODE.getKey(), false)) {
            if (StringsKt.startsWith$default(string, this.debugCommand.getStartWith(), false, 2, (Object) null)) {
                anonymousClass1.label = 1;
                Object execute = this.debugCommand.execute(appCompatActivity, getApplication(), string, anonymousClass1);
                return execute == coroutine_suspended ? coroutine_suspended : execute;
            }
            String str3 = "This action only allowed in debug mode.\n> " + string;
            getApplication().getLogger().warn(this, str3);
            return new Companion.CommandResult(str3, Companion.CommandResult.INSTANCE.getFAILED_STATUS_CODE(), null, false, 12, null);
        }
        for (Companion.Command command : this.commands) {
            if (StringsKt.startsWith$default(string, command.getStartWith(), false, 2, (Object) null)) {
                try {
                    DaijishouApplication application = getApplication();
                    anonymousClass1.L$0 = this;
                    anonymousClass1.L$1 = string;
                    anonymousClass1.L$2 = this;
                    anonymousClass1.label = 2;
                    Object execute2 = command.execute(appCompatActivity, application, string, anonymousClass1);
                    if (execute2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    Companion.CommandResult commandResult2 = (Companion.CommandResult) execute2;
                    if (commandResult2.getStatusCode() == Companion.CommandResult.INSTANCE.getSUCCEED_STATUS_CODE()) {
                        String message6 = commandResult2.getMessage();
                        if (message6 == null) {
                            message6 = "Succeed. With null value.";
                        }
                        commandResult2.setMessage(message6);
                        String message7 = commandResult2.getMessage();
                        Intrinsics.checkNotNull(message7);
                        logCommand(string, message7, commandResult2.getPrettyPrint());
                        return commandResult2;
                    }
                    if (commandResult2.getStatusCode() == Companion.CommandResult.INSTANCE.getFAILED_STATUS_CODE()) {
                        String message8 = commandResult2.getMessage();
                        if (message8 == null) {
                            message8 = "Failed. With null value.";
                        }
                        commandResult2.setMessage(message8);
                        String message9 = commandResult2.getMessage();
                        Intrinsics.checkNotNull(message9);
                        logWarningCommand(string, message9);
                        return commandResult2;
                    }
                    if (commandResult2.getStatusCode() == Companion.CommandResult.INSTANCE.getUNSUPPORTED_COMMAND_STATUS_CODE()) {
                        logUnsupportedCommand(string);
                    }
                    return commandResult2;
                } catch (Exception e2) {
                    getApplication().getLogger().warn(this, ExceptionsKt.stackTraceToString(e2));
                    String message10 = e2.getMessage();
                    if (message10 == null) {
                        message10 = ExceptionsKt.stackTraceToString(e2);
                    }
                    return new Companion.CommandResult(message10, Companion.CommandResult.INSTANCE.getFAILED_STATUS_CODE(), null, false, 12, null);
                }
            }
        }
        logUnsupportedCommand(string);
        return unsupportedCommandResult;
    }
}
