package com.magneticchen.daijishou.ui.widget.abstract_widget_classes;

import androidx.appcompat.app.AppCompatActivity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetBuilder.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001JA\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00012#\u0010\u0007\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00030\bH&¨\u0006\r"}, d2 = {"Lcom/magneticchen/daijishou/ui/widget/abstract_widget_classes/DataRemovalWidget;", "", "requestWidgetInstanceRemoval", "", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "data", "callback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "widgetInstanceId", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public interface DataRemovalWidget {
    void requestWidgetInstanceRemoval(AppCompatActivity appCompatActivity, Object obj, Function1<? super Long, Unit> function1);
}
