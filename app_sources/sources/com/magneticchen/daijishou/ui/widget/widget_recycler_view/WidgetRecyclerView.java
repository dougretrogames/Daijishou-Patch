package com.magneticchen.daijishou.ui.widget.widget_recycler_view;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.magneticchen.daijishou.DaijishouApplication;
import com.magneticchen.daijishou.ui.views.FadingEdgeRecyclerView;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WidgetRecyclerView.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0002\u001c\u001dB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0016\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00100\u0017H\u0014J\u0010\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u0010H\u0014J\b\u0010\u001a\u001a\u00020\u0010H\u0014J\b\u0010\u001b\u001a\u00020\u0015H\u0002R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/magneticchen/daijishou/ui/widget/widget_recycler_view/WidgetRecyclerView;", "Lcom/magneticchen/daijishou/ui/views/FadingEdgeRecyclerView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "hasPendingState", "", "mCurrentItemDataSetChangeObserver", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "pendingAdapterState", "Landroid/os/Parcelable;", "pendingX", "", "pendingY", "dispatchRestoreInstanceState", "", "container", "Landroid/util/SparseArray;", "onRestoreInstanceState", "state", "onSaveInstanceState", "restorePendingState", "DataSetChangeObserver", "SavedState", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class WidgetRecyclerView extends FadingEdgeRecyclerView {
    private boolean hasPendingState;
    private final RecyclerView.AdapterDataObserver mCurrentItemDataSetChangeObserver;
    private Parcelable pendingAdapterState;
    private float pendingX;
    private float pendingY;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetRecyclerView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mCurrentItemDataSetChangeObserver = new DataSetChangeObserver() { // from class: com.magneticchen.daijishou.ui.widget.widget_recycler_view.WidgetRecyclerView$mCurrentItemDataSetChangeObserver$1
            @Override // com.magneticchen.daijishou.ui.widget.widget_recycler_view.WidgetRecyclerView.DataSetChangeObserver
            public void onChanged() {
            }
        };
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mCurrentItemDataSetChangeObserver = new DataSetChangeObserver() { // from class: com.magneticchen.daijishou.ui.widget.widget_recycler_view.WidgetRecyclerView$mCurrentItemDataSetChangeObserver$1
            @Override // com.magneticchen.daijishou.ui.widget.widget_recycler_view.WidgetRecyclerView.DataSetChangeObserver
            public void onChanged() {
            }
        };
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mCurrentItemDataSetChangeObserver = new DataSetChangeObserver() { // from class: com.magneticchen.daijishou.ui.widget.widget_recycler_view.WidgetRecyclerView$mCurrentItemDataSetChangeObserver$1
            @Override // com.magneticchen.daijishou.ui.widget.widget_recycler_view.WidgetRecyclerView.DataSetChangeObserver
            public void onChanged() {
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: WidgetRecyclerView.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\b\"\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\u0018\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\"\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J \u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0018\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\u0010"}, d2 = {"Lcom/magneticchen/daijishou/ui/widget/widget_recycler_view/WidgetRecyclerView$DataSetChangeObserver;", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "()V", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", "payload", "", "onItemRangeInserted", "onItemRangeMoved", "fromPosition", "toPosition", "onItemRangeRemoved", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    static abstract class DataSetChangeObserver extends RecyclerView.AdapterDataObserver {
        public abstract void onChanged();

        public void onItemRangeChanged(int i, int i2) {
            onChanged();
        }

        public void onItemRangeChanged(int i, int i2, Object obj) {
            onChanged();
        }

        public void onItemRangeInserted(int i, int i2) {
            onChanged();
        }

        public void onItemRangeRemoved(int i, int i2) {
            onChanged();
        }

        public void onItemRangeMoved(int i, int i2, int i3) {
            onChanged();
        }
    }

    /* JADX INFO: compiled from: WidgetRecyclerView.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 &2\u00020\u0001:\u0001&B\u0019\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007B\u0011\b\u0016\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u001a\u0010!\u001a\u00020\"2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J\u0018\u0010#\u001a\u00020\"2\u0006\u0010$\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u0013H\u0016R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\nR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\nR\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001d¨\u0006'"}, d2 = {"Lcom/magneticchen/daijishou/ui/widget/widget_recycler_view/WidgetRecyclerView$SavedState;", "Landroid/view/View$BaseSavedState;", "source", "Landroid/os/Parcel;", "loader", "Ljava/lang/ClassLoader;", "(Landroid/os/Parcel;Ljava/lang/ClassLoader;)V", "(Landroid/os/Parcel;)V", "superState", "Landroid/os/Parcelable;", "(Landroid/os/Parcelable;)V", "adapterState", "getAdapterState", "()Landroid/os/Parcelable;", "setAdapterState", "layoutManagerState", "getLayoutManagerState", "setLayoutManagerState", "recyclerViewId", "", "getRecyclerViewId", "()I", "setRecyclerViewId", "(I)V", "x", "", "getX", "()F", "setX", "(F)V", "y", "getY", "setY", "readValues", "", "writeToParcel", "out", "flags", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class SavedState extends View.BaseSavedState {
        private Parcelable adapterState;
        private Parcelable layoutManagerState;
        private int recyclerViewId;
        private float x;
        private float y;
        public static final Companion Companion = new Companion(null);
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: com.magneticchen.daijishou.ui.widget.widget_recycler_view.WidgetRecyclerView$SavedState$Companion$CREATOR$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public WidgetRecyclerView.SavedState createFromParcel(Parcel source, ClassLoader classLoader) {
                Intrinsics.checkNotNullParameter(source, "source");
                return new WidgetRecyclerView.SavedState(source, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public WidgetRecyclerView.SavedState createFromParcel(Parcel source) {
                Intrinsics.checkNotNullParameter(source, "source");
                return createFromParcel(source, (ClassLoader) null);
            }

            @Override // android.os.Parcelable.Creator
            public WidgetRecyclerView.SavedState[] newArray(int i) {
                return new WidgetRecyclerView.SavedState[i];
            }
        };

        public final int getRecyclerViewId() {
            return this.recyclerViewId;
        }

        public final void setRecyclerViewId(int i) {
            this.recyclerViewId = i;
        }

        public final Parcelable getLayoutManagerState() {
            return this.layoutManagerState;
        }

        public final void setLayoutManagerState(Parcelable parcelable) {
            this.layoutManagerState = parcelable;
        }

        public final float getX() {
            return this.x;
        }

        public final void setX(float f) {
            this.x = f;
        }

        public final float getY() {
            return this.y;
        }

        public final void setY(float f) {
            this.y = f;
        }

        public final Parcelable getAdapterState() {
            return this.adapterState;
        }

        public final void setAdapterState(Parcelable parcelable) {
            this.adapterState = parcelable;
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SavedState(Parcel source, ClassLoader classLoader) {
            super(source, classLoader);
            Intrinsics.checkNotNullParameter(source, "source");
            readValues(source, classLoader);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SavedState(Parcel source) {
            super(source);
            Intrinsics.checkNotNullParameter(source, "source");
            readValues(source, null);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private final void readValues(Parcel parcel, ClassLoader classLoader) {
            this.recyclerViewId = parcel.readInt();
            this.x = parcel.readFloat();
            this.y = parcel.readFloat();
            this.adapterState = parcel.readParcelable(classLoader);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel out, int i) {
            Intrinsics.checkNotNullParameter(out, "out");
            super.writeToParcel(out, i);
            out.writeInt(this.recyclerViewId);
            out.writeFloat(this.x);
            out.writeFloat(this.y);
            out.writeParcelable(this.adapterState, i);
        }

        /* JADX INFO: compiled from: WidgetRecyclerView.kt */
        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/magneticchen/daijishou/ui/widget/widget_recycler_view/WidgetRecyclerView$SavedState$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lcom/magneticchen/daijishou/ui/widget/widget_recycler_view/WidgetRecyclerView$SavedState;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.setRecyclerViewId(getId());
        RecyclerView.LayoutManager layoutManager = getLayoutManager();
        savedState.setLayoutManagerState(layoutManager != null ? layoutManager.onSaveInstanceState() : null);
        savedState.setX(getX());
        savedState.setY(getY());
        Parcelable parcelable = this.pendingAdapterState;
        if (parcelable != null) {
            savedState.setAdapterState(parcelable);
        } else if (getAdapter() instanceof StatefulAdapter) {
            StatefulAdapter adapter = getAdapter();
            Intrinsics.checkNotNull(adapter, "null cannot be cast to non-null type com.magneticchen.daijishou.ui.widget.widget_recycler_view.StatefulAdapter");
            savedState.setAdapterState(adapter.saveState());
        }
        return savedState;
    }

    protected void onRestoreInstanceState(Parcelable state) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (!(state instanceof SavedState)) {
            super.onRestoreInstanceState(state);
            return;
        }
        SavedState savedState = (SavedState) state;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.pendingX = savedState.getX();
        this.pendingY = savedState.getY();
        this.pendingAdapterState = savedState.getAdapterState();
        this.hasPendingState = true;
        restorePendingState();
    }

    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> container) {
        Intrinsics.checkNotNullParameter(container, "container");
        Parcelable parcelable = container.get(getId());
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            int recyclerViewId = savedState.getRecyclerViewId();
            container.put(getId(), container.get(recyclerViewId));
            container.remove(recyclerViewId);
            super.onRestoreInstanceState(savedState.getSuperState());
            this.pendingX = savedState.getX();
            this.pendingY = savedState.getY();
            this.pendingAdapterState = savedState.getAdapterState();
            this.hasPendingState = true;
        }
        super.dispatchRestoreInstanceState(container);
        restorePendingState();
    }

    private final void restorePendingState() {
        StatefulAdapter adapter;
        if (this.hasPendingState && (adapter = getAdapter()) != null) {
            Parcelable parcelable = this.pendingAdapterState;
            if (parcelable != null) {
                if (adapter instanceof StatefulAdapter) {
                    try {
                        Intrinsics.checkNotNull(parcelable);
                        adapter.restoreState(parcelable);
                    } catch (Exception e) {
                        Context applicationContext = getContext().getApplicationContext();
                        Intrinsics.checkNotNull(applicationContext, "null cannot be cast to non-null type com.magneticchen.daijishou.DaijishouApplication");
                        ((DaijishouApplication) applicationContext).getLogger().warn(this, ExceptionsKt.stackTraceToString(e));
                    }
                }
                this.pendingAdapterState = null;
            }
            this.hasPendingState = false;
            scrollTo((int) this.pendingX, (int) this.pendingY);
        }
    }
}
