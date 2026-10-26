package com.magneticchen.daijishou.dialog_fragments;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.serialization.json.JsonBuilder;

/* INFO: compiled from: EditPlayableItemDialogFragment.kt */
/* INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lkotlinx/serialization/json/JsonBuilder;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
final class EditPlayableItemDialogFragment$checkPreviewMediaDirectory$jsonFormat$1 extends Lambda<Unit> implements Function1<JsonBuilder, Unit> {
    public static final EditPlayableItemDialogFragment$checkPreviewMediaDirectory$jsonFormat$1 INSTANCE = new EditPlayableItemDialogFragment$checkPreviewMediaDirectory$jsonFormat$1();

    EditPlayableItemDialogFragment$checkPreviewMediaDirectory$jsonFormat$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(JsonBuilder jsonBuilder) {
        invoke2(jsonBuilder);
        return Unit.INSTANCE;
    }

    /* INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(JsonBuilder Json) {
        Intrinsics.checkNotNullParameter(Json, "$this$Json");
        Json.setPrettyPrint(true);
        Json.setEncodeDefaults(true);
    }
}
