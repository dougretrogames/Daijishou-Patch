package com.magneticchen.daijishou.ui.fragments.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.fragment.app.FragmentActivity;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.ui.fragments.p000abstract.DaijishouDialogFragment;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ListSelectDialogFragment.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u000eH\u0016J\u0014\u0010\u001a\u001a\u00020\u00002\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010J)\u0010\u001b\u001a\u00020\u00002!\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\tJ)\u0010\u001c\u001a\u00020\u00002!\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\tR\u0016\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010\b\u001a\u001f\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010\u0011\u001a\u001f\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/magneticchen/daijishou/ui/fragments/dialog/ListSelectDialogFragment;", "Lcom/magneticchen/daijishou/ui/fragments/abstract/DaijishouDialogFragment;", "()V", "adapter", "Landroid/widget/ArrayAdapter;", "", "listView", "Landroid/widget/ListView;", "longSelectedListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "pos", "", "onCancelListener", "Lkotlin/Function0;", "selectedListener", "onCancel", "dialog", "Landroid/content/DialogInterface;", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "setOnCancelListener", "setOnLongSelectListener", "setOnSelectListener", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class ListSelectDialogFragment extends DaijishouDialogFragment {
    public static final Companion Companion = new Companion(null);
    private ArrayAdapter<String> adapter;
    private ListView listView;
    private Function1<? super Integer, Unit> longSelectedListener;
    private Function0<Unit> onCancelListener;
    private Function1<? super Integer, Unit> selectedListener;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$6$lambda$5(DialogInterface dialogInterface) {
    }

    /* JADX INFO: compiled from: ListSelectDialogFragment.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JT\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00060\bj\b\u0012\u0004\u0012\u00020\u0006`\t2 \b\u0002\u0010\n\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\bj\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u0001`\t2\b\b\u0002\u0010\u000b\u001a\u00020\f¨\u0006\r"}, d2 = {"Lcom/magneticchen/daijishou/ui/fragments/dialog/ListSelectDialogFragment$Companion;", "", "()V", "newInstance", "Lcom/magneticchen/daijishou/ui/fragments/dialog/ListSelectDialogFragment;", "title", "", "titleList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "descriptionList", "dismiss", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ListSelectDialogFragment newInstance$default(Companion companion, String str, ArrayList arrayList, ArrayList arrayList2, boolean z, int i, Object obj) {
            if ((i & 4) != 0) {
                arrayList2 = null;
            }
            if ((i & 8) != 0) {
                z = true;
            }
            return companion.newInstance(str, arrayList, arrayList2, z);
        }

        public final ListSelectDialogFragment newInstance(String str, ArrayList<String> titleList, ArrayList<String> arrayList, boolean z) {
            Intrinsics.checkNotNullParameter(titleList, "titleList");
            ListSelectDialogFragment listSelectDialogFragment = new ListSelectDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putString("title", str);
            bundle.putStringArrayList("titleList", titleList);
            bundle.putStringArrayList("descriptionList", arrayList);
            bundle.putBoolean("dismiss", z);
            listSelectDialogFragment.setArguments(bundle);
            return listSelectDialogFragment;
        }
    }

    public final ListSelectDialogFragment setOnSelectListener(Function1<? super Integer, Unit> selectedListener) {
        Intrinsics.checkNotNullParameter(selectedListener, "selectedListener");
        this.selectedListener = selectedListener;
        return this;
    }

    public final ListSelectDialogFragment setOnLongSelectListener(Function1<? super Integer, Unit> longSelectedListener) {
        Intrinsics.checkNotNullParameter(longSelectedListener, "longSelectedListener");
        this.longSelectedListener = longSelectedListener;
        return this;
    }

    public final ListSelectDialogFragment setOnCancelListener(Function0<Unit> onCancelListener) {
        Intrinsics.checkNotNullParameter(onCancelListener, "onCancelListener");
        this.onCancelListener = onCancelListener;
        return this;
    }

    public void onStart() {
        super.onStart();
        Window window = requireDialog().getWindow();
        if (window != null) {
            window.setBackgroundDrawable(AppCompatResources.getDrawable(requireContext(), R.drawable.dialog_background));
        }
    }

    public void onCancel(DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onCancel(dialog);
        Function0<Unit> function0 = this.onCancelListener;
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Override // com.magneticchen.daijishou.ui.fragments.p000abstract.DaijishouDialogFragment
    public Dialog onCreateDialog(Bundle bundle) {
        Bundle arguments = getArguments();
        final AlertDialog alertDialogCreate = null;
        String string = arguments != null ? arguments.getString("title") : null;
        Bundle arguments2 = getArguments();
        final ArrayList<String> stringArrayList = arguments2 != null ? arguments2.getStringArrayList("titleList") : null;
        Intrinsics.checkNotNull(stringArrayList);
        Bundle arguments3 = getArguments();
        final ArrayList<String> stringArrayList2 = arguments3 != null ? arguments3.getStringArrayList("descriptionList") : null;
        Bundle arguments4 = getArguments();
        Boolean boolValueOf = arguments4 != null ? Boolean.valueOf(arguments4.getBoolean("dismiss")) : null;
        Intrinsics.checkNotNull(boolValueOf);
        final boolean zBooleanValue = boolValueOf.booleanValue();
        FragmentActivity activity = getActivity();
        if (activity != null) {
            View viewInflate = activity.getLayoutInflater().inflate(R.layout.fragment_select_list_dialog, (ViewGroup) null);
            ListView listView = (ListView) viewInflate.findViewById(R.id.fragment_select_list_dialog_list_view);
            if (stringArrayList2 == null || stringArrayList2.size() == 0) {
                this.adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_list_item_1, android.R.id.text1, stringArrayList.toArray(new String[0]));
            } else {
                final Context contextRequireContext = requireContext();
                this.adapter = new ArrayAdapter<String>(stringArrayList2, stringArrayList, contextRequireContext) { // from class: com.magneticchen.daijishou.ui.fragments.dialog.ListSelectDialogFragment$onCreateDialog$1$1
                    final /* synthetic */ ArrayList<String> $descriptionList;
                    final /* synthetic */ ArrayList<String> $titleList;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(contextRequireContext, android.R.layout.simple_list_item_2, android.R.id.text1, stringArrayList2);
                        this.$descriptionList = stringArrayList2;
                        this.$titleList = stringArrayList;
                        Intrinsics.checkNotNull(stringArrayList2, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
                    }

                    @Override // android.widget.ArrayAdapter, android.widget.Adapter
                    public View getView(int i, View view, ViewGroup parent) {
                        Intrinsics.checkNotNullParameter(parent, "parent");
                        View view2 = super.getView(i, view, parent);
                        Intrinsics.checkNotNullExpressionValue(view2, "getView(...)");
                        View viewFindViewById = view2.findViewById(android.R.id.text1);
                        Intrinsics.checkNotNull(viewFindViewById, "null cannot be cast to non-null type android.widget.TextView");
                        View viewFindViewById2 = view2.findViewById(android.R.id.text2);
                        Intrinsics.checkNotNull(viewFindViewById2, "null cannot be cast to non-null type android.widget.TextView");
                        TextView textView = (TextView) viewFindViewById2;
                        ((TextView) viewFindViewById).setText(this.$titleList.get(i));
                        textView.setText(this.$descriptionList.get(i));
                        textView.setAlpha(0.75f);
                        return view2;
                    }
                };
            }
            listView.setAdapter((ListAdapter) this.adapter);
            this.listView = listView;
            alertDialogCreate = new AlertDialog.Builder(getContext()).setView(viewInflate).setTitle(string).setNegativeButton(getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.ListSelectDialogFragment$$ExternalSyntheticLambda0
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.cancel();
                }
            }).create();
            Intrinsics.checkNotNull(alertDialogCreate);
            setupDaijishouDialog(alertDialogCreate);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.ListSelectDialogFragment$$ExternalSyntheticLambda1
                @Override // android.widget.AdapterView.OnItemClickListener
                public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                    ListSelectDialogFragment.onCreateDialog$lambda$6$lambda$2(this.f$0, zBooleanValue, alertDialogCreate, adapterView, view, i, j);
                }
            });
            listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.ListSelectDialogFragment$$ExternalSyntheticLambda2
                @Override // android.widget.AdapterView.OnItemLongClickListener
                public final boolean onItemLongClick(AdapterView adapterView, View view, int i, long j) {
                    return ListSelectDialogFragment.onCreateDialog$lambda$6$lambda$4(this.f$0, zBooleanValue, alertDialogCreate, adapterView, view, i, j);
                }
            });
            alertDialogCreate.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.magneticchen.daijishou.ui.fragments.dialog.ListSelectDialogFragment$$ExternalSyntheticLambda3
                @Override // android.content.DialogInterface.OnShowListener
                public final void onShow(DialogInterface dialogInterface) {
                    ListSelectDialogFragment.onCreateDialog$lambda$6$lambda$5(dialogInterface);
                }
            });
        }
        if (alertDialogCreate != null) {
            return alertDialogCreate;
        }
        throw new IllegalStateException("Activity cannot be null");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateDialog$lambda$6$lambda$2(ListSelectDialogFragment this$0, boolean z, AlertDialog alertDialog, AdapterView adapterView, View view, int i, long j) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Function1<? super Integer, Unit> function1 = this$0.selectedListener;
        if (function1 != null) {
            function1.invoke(Integer.valueOf(i));
        }
        if (z) {
            alertDialog.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onCreateDialog$lambda$6$lambda$4(ListSelectDialogFragment this$0, boolean z, AlertDialog alertDialog, AdapterView adapterView, View view, int i, long j) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Function1<? super Integer, Unit> function1 = this$0.longSelectedListener;
        if (function1 != null) {
            function1.invoke(Integer.valueOf(i));
        }
        if (!z || this$0.longSelectedListener == null) {
            return true;
        }
        alertDialog.dismiss();
        return true;
    }
}
