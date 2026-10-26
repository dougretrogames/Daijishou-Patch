package androidx.compose.ui.semantics;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* INFO: compiled from: SemanticsProperties.kt */
/* INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R#\u0010\u0003\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR#\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR#\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\tR\u001d\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\tR#\u0010\u0012\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\tR#\u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\tR#\u0010\u0016\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\tR/\u0010\u0018\u001a \u0012\u001c\u0012\u001a\u0012\u0016\u0012\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u001a\u0012\u0004\u0012\u00020\u00070\u00190\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\tR)\u0010\u001d\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00070\u00190\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\tR#\u0010 \u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\tR#\u0010\"\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\tR#\u0010$\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\tR#\u0010&\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\tR#\u0010(\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\tR#\u0010*\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\tR#\u0010,\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\tR#\u0010.\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\tR#\u00100\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\tRM\u00102\u001a>\u0012:\u00128\u00124\u00122\u0012\u0013\u0012\u001104¢\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b(7\u0012\u0013\u0012\u001104¢\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b(8\u0012\u0004\u0012\u00020\u0007030\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010\tR)\u0010:\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020\u00070\u00190\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010\tR8\u0010=\u001a)\u0012%\u0012#\u0012\u001f\u0012\u001d\u0012\u0013\u0012\u001104¢\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b(>\u0012\u0004\u0012\u00020\u00070\u00190\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u0010\tR5\u0010@\u001a&\u0012\"\u0012 \u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070A0\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\bB\u0010\tR)\u0010C\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00070\u00190\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\bD\u0010\tR)\u0010E\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00070\u00190\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\bF\u0010\tR)\u0010G\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00190\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\bH\u0010\t¨\u0006I"}, d2 = {"Landroidx/compose/ui/semantics/SemanticsActions;", "", "()V", "ClearTextSubstitution", "Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "Landroidx/compose/ui/semantics/AccessibilityAction;", "Lkotlin/Function0;", "", "getClearTextSubstitution", "()Landroidx/compose/ui/semantics/SemanticsPropertyKey;", "Collapse", "getCollapse", "CopyText", "getCopyText", "CustomActions", "", "Landroidx/compose/ui/semantics/CustomAccessibilityAction;", "getCustomActions", "CutText", "getCutText", "Dismiss", "getDismiss", "Expand", "getExpand", "GetTextLayoutResult", "Lkotlin/Function1;", "", "Landroidx/compose/ui/text/TextLayoutResult;", "getGetTextLayoutResult", "InsertTextAtCursor", "Landroidx/compose/ui/text/AnnotatedString;", "getInsertTextAtCursor", "OnClick", "getOnClick", "OnImeAction", "getOnImeAction", "OnLongClick", "getOnLongClick", "PageDown", "getPageDown", "PageLeft", "getPageLeft", "PageRight", "getPageRight", "PageUp", "getPageUp", "PasteText", "getPasteText", "RequestFocus", "getRequestFocus", "ScrollBy", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "x", "y", "getScrollBy", "ScrollToIndex", "", "getScrollToIndex", "SetProgress", "progress", "getSetProgress", "SetSelection", "Lkotlin/Function3;", "getSetSelection", "SetText", "getSetText", "SetTextSubstitution", "getSetTextSubstitution", "ShowTextSubstitution", "getShowTextSubstitution", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SemanticsActions {
    public static final SemanticsActions INSTANCE = new SemanticsActions();
    private static final SemanticsPropertyKey<AccessibilityAction<Function1<List<TextLayoutResult>, Boolean>>> GetTextLayoutResult = SemanticsPropertiesKt.AccessibilityKey("GetTextLayoutResult", SemanticsPropertiesKt.AnonymousClass1.INSTANCE);
    private static final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> OnClick = SemanticsPropertiesKt.AccessibilityKey("OnClick", SemanticsPropertiesKt.AnonymousClass1.INSTANCE);
    private static final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> OnLongClick = SemanticsPropertiesKt.AccessibilityKey("OnLongClick", SemanticsPropertiesKt.AnonymousClass1.INSTANCE);
    private static final SemanticsPropertyKey<AccessibilityAction<Function2<Float, Float, Boolean>>> ScrollBy = SemanticsPropertiesKt.AccessibilityKey("ScrollBy", SemanticsPropertiesKt.AnonymousClass1.INSTANCE);
    private static final SemanticsPropertyKey<AccessibilityAction<Function1<Integer, Boolean>>> ScrollToIndex = SemanticsPropertiesKt.AccessibilityKey("ScrollToIndex", SemanticsPropertiesKt.AnonymousClass1.INSTANCE);
    private static final SemanticsPropertyKey<AccessibilityAction<Function1<Float, Boolean>>> SetProgress = SemanticsPropertiesKt.AccessibilityKey("SetProgress", SemanticsPropertiesKt.AnonymousClass1.INSTANCE);
    private static final SemanticsPropertyKey<AccessibilityAction<Function3<Integer, Integer, Boolean, Boolean>>> SetSelection = SemanticsPropertiesKt.AccessibilityKey("SetSelection", SemanticsPropertiesKt.AnonymousClass1.INSTANCE);
    private static final SemanticsPropertyKey<AccessibilityAction<Function1<AnnotatedString, Boolean>>> SetText = SemanticsPropertiesKt.AccessibilityKey("SetText", SemanticsPropertiesKt.AnonymousClass1.INSTANCE);
    private static final SemanticsPropertyKey<AccessibilityAction<Function1<AnnotatedString, Boolean>>> SetTextSubstitution = SemanticsPropertiesKt.AccessibilityKey("SetTextSubstitution", SemanticsPropertiesKt.AnonymousClass1.INSTANCE);
    private static final SemanticsPropertyKey<AccessibilityAction<Function1<Boolean, Boolean>>> ShowTextSubstitution = SemanticsPropertiesKt.AccessibilityKey("ShowTextSubstitution", SemanticsPropertiesKt.AnonymousClass1.INSTANCE);
    private static final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> ClearTextSubstitution = SemanticsPropertiesKt.AccessibilityKey("ClearTextSubstitution", SemanticsPropertiesKt.AnonymousClass1.INSTANCE);
    private static final SemanticsPropertyKey<AccessibilityAction<Function1<AnnotatedString, Boolean>>> InsertTextAtCursor = SemanticsPropertiesKt.AccessibilityKey("InsertTextAtCursor", SemanticsPropertiesKt.AnonymousClass1.INSTANCE);
    private static final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> OnImeAction = SemanticsPropertiesKt.AccessibilityKey("PerformImeAction", SemanticsPropertiesKt.AnonymousClass1.INSTANCE);
    private static final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> CopyText = SemanticsPropertiesKt.AccessibilityKey("CopyText", SemanticsPropertiesKt.AnonymousClass1.INSTANCE);
    private static final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> CutText = SemanticsPropertiesKt.AccessibilityKey("CutText", SemanticsPropertiesKt.AnonymousClass1.INSTANCE);
    private static final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> PasteText = SemanticsPropertiesKt.AccessibilityKey("PasteText", SemanticsPropertiesKt.AnonymousClass1.INSTANCE);
    private static final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> Expand = SemanticsPropertiesKt.AccessibilityKey("Expand", SemanticsPropertiesKt.AnonymousClass1.INSTANCE);
    private static final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> Collapse = SemanticsPropertiesKt.AccessibilityKey("Collapse", SemanticsPropertiesKt.AnonymousClass1.INSTANCE);
    private static final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> Dismiss = SemanticsPropertiesKt.AccessibilityKey("Dismiss", SemanticsPropertiesKt.AnonymousClass1.INSTANCE);
    private static final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> RequestFocus = SemanticsPropertiesKt.AccessibilityKey("RequestFocus", SemanticsPropertiesKt.AnonymousClass1.INSTANCE);
    private static final SemanticsPropertyKey<List<CustomAccessibilityAction>> CustomActions = SemanticsPropertiesKt.AccessibilityKey("CustomActions");
    private static final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> PageUp = SemanticsPropertiesKt.AccessibilityKey("PageUp", SemanticsPropertiesKt.AnonymousClass1.INSTANCE);
    private static final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> PageLeft = SemanticsPropertiesKt.AccessibilityKey("PageLeft", SemanticsPropertiesKt.AnonymousClass1.INSTANCE);
    private static final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> PageDown = SemanticsPropertiesKt.AccessibilityKey("PageDown", SemanticsPropertiesKt.AnonymousClass1.INSTANCE);
    private static final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> PageRight = SemanticsPropertiesKt.AccessibilityKey("PageRight", SemanticsPropertiesKt.AnonymousClass1.INSTANCE);
    public static final int $stable = 8;

    private SemanticsActions() {
    }

    public final SemanticsPropertyKey<AccessibilityAction<Function1<List<TextLayoutResult>, Boolean>>> getGetTextLayoutResult() {
        return GetTextLayoutResult;
    }

    public final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> getOnClick() {
        return OnClick;
    }

    public final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> getOnLongClick() {
        return OnLongClick;
    }

    public final SemanticsPropertyKey<AccessibilityAction<Function2<Float, Float, Boolean>>> getScrollBy() {
        return ScrollBy;
    }

    public final SemanticsPropertyKey<AccessibilityAction<Function1<Integer, Boolean>>> getScrollToIndex() {
        return ScrollToIndex;
    }

    public final SemanticsPropertyKey<AccessibilityAction<Function1<Float, Boolean>>> getSetProgress() {
        return SetProgress;
    }

    public final SemanticsPropertyKey<AccessibilityAction<Function3<Integer, Integer, Boolean, Boolean>>> getSetSelection() {
        return SetSelection;
    }

    public final SemanticsPropertyKey<AccessibilityAction<Function1<AnnotatedString, Boolean>>> getSetText() {
        return SetText;
    }

    public final SemanticsPropertyKey<AccessibilityAction<Function1<AnnotatedString, Boolean>>> getSetTextSubstitution() {
        return SetTextSubstitution;
    }

    public final SemanticsPropertyKey<AccessibilityAction<Function1<Boolean, Boolean>>> getShowTextSubstitution() {
        return ShowTextSubstitution;
    }

    public final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> getClearTextSubstitution() {
        return ClearTextSubstitution;
    }

    public final SemanticsPropertyKey<AccessibilityAction<Function1<AnnotatedString, Boolean>>> getInsertTextAtCursor() {
        return InsertTextAtCursor;
    }

    public final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> getOnImeAction() {
        return OnImeAction;
    }

    public final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> getCopyText() {
        return CopyText;
    }

    public final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> getCutText() {
        return CutText;
    }

    public final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> getPasteText() {
        return PasteText;
    }

    public final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> getExpand() {
        return Expand;
    }

    public final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> getCollapse() {
        return Collapse;
    }

    public final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> getDismiss() {
        return Dismiss;
    }

    public final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> getRequestFocus() {
        return RequestFocus;
    }

    public final SemanticsPropertyKey<List<CustomAccessibilityAction>> getCustomActions() {
        return CustomActions;
    }

    public final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> getPageUp() {
        return PageUp;
    }

    public final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> getPageLeft() {
        return PageLeft;
    }

    public final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> getPageDown() {
        return PageDown;
    }

    public final SemanticsPropertyKey<AccessibilityAction<Function0<Boolean>>> getPageRight() {
        return PageRight;
    }
}
