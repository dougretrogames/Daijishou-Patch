package androidx.activity.result;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.contract.ActivityResultContract;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: Add missing generic type declarations: [I, O] */
/* JADX INFO: compiled from: ActivityResultCaller.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\t\n\u0000\n\u0002\b\u0005*\u0001\u0001\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "androidx/activity/result/ActivityResultCallerLauncher$resultContract$2$1", "I", "O", "invoke", "()Landroidx/activity/result/ActivityResultCallerLauncher$resultContract$2$1;"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class ActivityResultCallerLauncher$resultContract$2<I, O> extends Lambda implements Function0<AnonymousClass1<I, O>> {
    final /* synthetic */ ActivityResultCallerLauncher<I, O> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ActivityResultCallerLauncher$resultContract$2(ActivityResultCallerLauncher<I, O> activityResultCallerLauncher) {
        super(0);
        this.this$0 = activityResultCallerLauncher;
    }

    /* JADX INFO: renamed from: androidx.activity.result.ActivityResultCallerLauncher$resultContract$2$1, reason: invalid class name */
    /* JADX INFO: compiled from: ActivityResultCaller.kt */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00028\u00000\u0001J\u001d\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0002\u0010\bJ\u001f\u0010\t\u001a\u00028\u00002\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"androidx/activity/result/ActivityResultCallerLauncher$resultContract$2$1", "Landroidx/activity/result/contract/ActivityResultContract;", "", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "input", "(Landroid/content/Context;Lkotlin/Unit;)Landroid/content/Intent;", "parseResult", "resultCode", "", "intent", "(ILandroid/content/Intent;)Ljava/lang/Object;", "activity-ktx_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class AnonymousClass1 extends ActivityResultContract<Unit, O> {
        final /* synthetic */ ActivityResultCallerLauncher<I, O> this$0;

        AnonymousClass1(ActivityResultCallerLauncher<I, O> activityResultCallerLauncher) {
            this.this$0 = activityResultCallerLauncher;
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public Intent createIntent(Context context, Unit input) {
            return this.this$0.getCallerContract().createIntent(context, this.this$0.getCallerInput());
        }

        @Override // androidx.activity.result.contract.ActivityResultContract
        public O parseResult(int resultCode, Intent intent) {
            return this.this$0.getCallerContract().parseResult(resultCode, intent);
        }
    }

    @Override // kotlin.jvm.functions.Function0
    public final AnonymousClass1<I, O> invoke() {
        return new AnonymousClass1(this.this$0);
    }
}
