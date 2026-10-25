package com.magneticchen.daijishou.view_models;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.magneticchen.daijishou.DaijishouApplication;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: DaijishouConsoleViewModel.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J&\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0003H\u0096@¢\u0006\u0002\u0010\u000fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0003X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0005¨\u0006\u0010"}, d2 = {"com/magneticchen/daijishou/view_models/DaijishouConsoleViewModel$commands$4", "Lcom/magneticchen/daijishou/view_models/DaijishouConsoleViewModel$Companion$Command;", "description", "", "getDescription", "()Ljava/lang/String;", "startWith", "getStartWith", "execute", "Lcom/magneticchen/daijishou/view_models/DaijishouConsoleViewModel$Companion$CommandResult;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "application", "Lcom/magneticchen/daijishou/DaijishouApplication;", "command", "(Landroidx/appcompat/app/AppCompatActivity;Lcom/magneticchen/daijishou/DaijishouApplication;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class DaijishouConsoleViewModel$commands$4 extends DaijishouConsoleViewModel.Companion.Command {
    final /* synthetic */ DaijishouConsoleViewModel this$0;
    private final String startWith = "\\prefs ";
    private final String description = "Preferences command. View and modify android preferences. Usage:\n> \\prefs list all/bool/int/string/float/long\n> \\prefs show \"your key\"\n> \\prefs set bool/int/string/float/long \"your key\" value";

    DaijishouConsoleViewModel$commands$4(DaijishouConsoleViewModel daijishouConsoleViewModel) {
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
        String str2 = str;
        List listSplitCommandBySpaces = DaijishouConsoleViewModel.INSTANCE.splitCommandBySpaces(str2);
        HashMap mapHashMapOf = MapsKt.hashMapOf(TuplesKt.to("bool", Boxing.boxBoolean(false)), TuplesKt.to(TypedValues.Custom.S_BOOLEAN, Boxing.boxBoolean(false)), TuplesKt.to("int", Boxing.boxInt(0)), TuplesKt.to(TypedValues.Custom.S_INT, Boxing.boxInt(0)), TuplesKt.to(TypedValues.Custom.S_STRING, ""), TuplesKt.to(TypedValues.Custom.S_FLOAT, Boxing.boxFloat(0.0f)), TuplesKt.to("long", Boxing.boxLong(0L)));
        if (listSplitCommandBySpaces.size() == 3 && Intrinsics.areEqual(listSplitCommandBySpaces.get(1), "list")) {
            Object obj = mapHashMapOf.get(listSplitCommandBySpaces.get(2));
            ArrayList arrayList = new ArrayList();
            if (!Intrinsics.areEqual(listSplitCommandBySpaces.get(2), "all") && obj == null) {
                return DaijishouConsoleViewModel.INSTANCE.getUnsupportedCommandResult();
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
            return this.this$0.getDefaultSharedPreferences().contains(str3) ? new DaijishouConsoleViewModel.Companion.CommandResult(String.valueOf(this.this$0.getDefaultSharedPreferences().getAll().get(str3)), 0, null, false, 14, null) : new DaijishouConsoleViewModel.Companion.CommandResult("key \"" + str3 + "\" does not exist.", DaijishouConsoleViewModel.Companion.CommandResult.INSTANCE.getFAILED_STATUS_CODE(), null, false, 12, null);
        }
        if (listSplitCommandBySpaces.size() >= 4 && Intrinsics.areEqual(listSplitCommandBySpaces.get(1), "set")) {
            Object obj2 = mapHashMapOf.get(listSplitCommandBySpaces.get(2));
            String str4 = (String) listSplitCommandBySpaces.get(3);
            String str5 = (String) CollectionsKt.getOrNull(StringsKt.split$default((CharSequence) str, new String[]{str4 + " "}, false, 2, 2, (Object) null), 1);
            try {
                if (obj2 == null || str5 == null) {
                    return DaijishouConsoleViewModel.INSTANCE.getUnsupportedCommandResult();
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
                return DaijishouConsoleViewModel.INSTANCE.getUnsupportedCommandResult();
            } catch (Exception e) {
                String message = e.getMessage();
                if (message == null) {
                    message = ExceptionsKt.stackTraceToString(e);
                }
                return new DaijishouConsoleViewModel.Companion.CommandResult(message, DaijishouConsoleViewModel.Companion.CommandResult.INSTANCE.getFAILED_STATUS_CODE(), e, false, 8, null);
            }
        }
        return DaijishouConsoleViewModel.INSTANCE.getUnsupportedCommandResult();
    }
}
