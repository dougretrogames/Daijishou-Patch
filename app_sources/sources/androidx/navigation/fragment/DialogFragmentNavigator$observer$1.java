package androidx.navigation.fragment;

import android.util.Log;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.navigation.NavBackStackEntry;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* INFO: compiled from: DialogFragmentNavigator.kt */
/* INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"androidx/navigation/fragment/DialogFragmentNavigator$observer$1", "Landroidx/lifecycle/LifecycleEventObserver;", "onStateChanged", "", "source", "Landroidx/lifecycle/LifecycleOwner;", NotificationCompat.CATEGORY_EVENT, "Landroidx/lifecycle/Lifecycle$Event;", "navigation-fragment_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class DialogFragmentNavigator$observer$1 implements LifecycleEventObserver {
    final /* synthetic */ DialogFragmentNavigator this$0;

    /* INFO: compiled from: DialogFragmentNavigator.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            try {
                iArr[Lifecycle.Event.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Lifecycle.Event.ON_RESUME.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Lifecycle.Event.ON_STOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Lifecycle.Event.ON_DESTROY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    DialogFragmentNavigator$observer$1(DialogFragmentNavigator dialogFragmentNavigator) {
        this.this$0 = dialogFragmentNavigator;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(LifecycleOwner source, Lifecycle.Event event) {
        int iNextIndex;
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(event, "event");
        int i = WhenMappings.$EnumSwitchMapping$0[event.ordinal()];
        if (i == 1) {
            DialogFragment dialogFragment = (DialogFragment) source;
            List<NavBackStackEntry> value = this.this$0.getState().getBackStack().getValue();
            if (!(value instanceof Collection) || !value.isEmpty()) {
                Iterator<T> it = value.iterator();
                while (it.hasNext()) {
                    if (Intrinsics.areEqual(((NavBackStackEntry) it.next()).getId(), dialogFragment.getTag())) {
                        return;
                    }
                }
            }
            dialogFragment.dismiss();
            return;
        }
        Object obj = null;
        if (i == 2) {
            DialogFragment dialogFragment2 = (DialogFragment) source;
            for (Object obj2 : this.this$0.getState().getTransitionsInProgress().getValue()) {
                if (Intrinsics.areEqual(((NavBackStackEntry) obj2).getId(), dialogFragment2.getTag())) {
                    obj = obj2;
                }
            }
            NavBackStackEntry navBackStackEntry = (NavBackStackEntry) obj;
            if (navBackStackEntry != null) {
                this.this$0.getState().markTransitionComplete(navBackStackEntry);
                return;
            }
            return;
        }
        if (i != 3) {
            if (i != 4) {
                return;
            }
            DialogFragment dialogFragment3 = (DialogFragment) source;
            for (Object obj3 : this.this$0.getState().getTransitionsInProgress().getValue()) {
                if (Intrinsics.areEqual(((NavBackStackEntry) obj3).getId(), dialogFragment3.getTag())) {
                    obj = obj3;
                }
            }
            NavBackStackEntry navBackStackEntry2 = (NavBackStackEntry) obj;
            if (navBackStackEntry2 != null) {
                this.this$0.getState().markTransitionComplete(navBackStackEntry2);
            }
            dialogFragment3.getLifecycle().removeObserver(this);
            return;
        }
        DialogFragment dialogFragment4 = (DialogFragment) source;
        if (dialogFragment4.requireDialog().isShowing()) {
            return;
        }
        List<NavBackStackEntry> value2 = this.this$0.getState().getBackStack().getValue();
        ListIterator<NavBackStackEntry> listIterator = value2.listIterator(value2.size());
        while (true) {
            if (listIterator.hasPrevious()) {
                if (Intrinsics.areEqual(listIterator.previous().getId(), dialogFragment4.getTag())) {
                    iNextIndex = listIterator.nextIndex();
                    break;
                }
            } else {
                iNextIndex = -1;
                break;
            }
        }
        NavBackStackEntry navBackStackEntry3 = (NavBackStackEntry) CollectionsKt.getOrNull(value2, iNextIndex);
        if (!Intrinsics.areEqual(CollectionsKt.lastOrNull((List) value2), navBackStackEntry3)) {
            Log.i("DialogFragmentNavigator", "Dialog " + dialogFragment4 + " was dismissed while it was not the top of the back stack, popping all dialogs above this dismissed dialog");
        }
        if (navBackStackEntry3 != null) {
            this.this$0.popWithTransition(iNextIndex, navBackStackEntry3, false);
        }
    }
}
