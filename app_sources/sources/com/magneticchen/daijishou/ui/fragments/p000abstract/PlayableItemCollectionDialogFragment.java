package com.magneticchen.daijishou.ui.fragments.p000abstract;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.magneticchen.daijishou.R;
import com.magneticchen.daijishou.cache.CachedBitmapLoader;
import com.magneticchen.daijishou.data.Constants;
import com.magneticchen.daijishou.data.db.entity.PlatformEntity;
import com.magneticchen.daijishou.data.db.entity.PlayableItemEntity;
import com.magneticchen.daijishou.ui.daijishou_recycler_view.DaijishouGridLayoutManager;
import com.magneticchen.daijishou.ui.daijishou_recycler_view.DaijishouRecyclerView;
import com.magneticchen.daijishou.ui.widget.widgets.category.CategoryWidgetViewModel;
import com.magneticchen.daijishou.utils.Utils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: PlayableItemCollectionDialogFragment.kt */
/* JADX INFO: loaded from: C:\Users\dfukuoka\Downloads\Daijishou\Daijishou\build_tmp\dex181_classes4.dex */
@Metadata(d1 = {"\u0000À\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010 \n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001:\u0001UB\u0005¢\u0006\u0002\u0010\u0002J\b\u00102\u001a\u00020\u0010H\u0016J&\u00103\u001a\u0004\u0018\u0001042\u0006\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u0001082\b\u00109\u001a\u0004\u0018\u00010:H\u0016J\u0010\u0010;\u001a\u00020\u00192\u0006\u0010<\u001a\u00020=H\u0016J\u001e\u0010>\u001a\u00020\u00192\u0006\u0010?\u001a\u00020!2\u0006\u0010@\u001a\u00020!2\u0006\u0010A\u001a\u00020BJ\b\u0010C\u001a\u00020\u0019H\u0016J\u001a\u0010D\u001a\u00020\u00192\u0006\u0010E\u001a\u0002042\b\u00109\u001a\u0004\u0018\u00010:H\u0016J\u000e\u0010F\u001a\u00020\u00192\u0006\u0010G\u001a\u00020\bJ\u0006\u0010H\u001a\u00020\u0019J\u001a\u0010I\u001a\u00020\u00002\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u0017J\u0014\u0010J\u001a\u00020\u00002\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u001bJ\u001a\u0010K\u001a\u00020\u00002\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u0017J\u001a\u0010L\u001a\u00020\u00002\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u0017J.\u0010M\u001a\u00020\u00002&\u0010\u001e\u001a\"\u0012\u0006\u0012\u0004\u0018\u00010 \u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00100\u001fJ\u0014\u0010N\u001a\u00020\u00192\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00180OJ\u0016\u0010P\u001a\u00020\u00192\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00180OH\u0002J\u000e\u0010Q\u001a\u00020\u00002\u0006\u0010R\u001a\u00020\bJ\u000e\u0010S\u001a\u00020\u00002\u0006\u0010T\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R0\u0010\u001e\u001a$\u0012\u0006\u0012\u0004\u0018\u00010 \u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\"\u001a\u001e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\b0#j\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\b`%X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00180'X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00180'X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082.¢\u0006\u0002\n\u0000R\u0012\u0010+\u001a\u00060,R\u00020\u0000X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020/X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u0082.¢\u0006\u0002\n\u0000¨\u0006V"}, d2 = {"Lcom/magneticchen/daijishou/ui/fragments/abstract/PlayableItemCollectionDialogFragment;", "Lcom/magneticchen/daijishou/ui/fragments/abstract/DaijishouDialogFragment;", "()V", "backButton", "Landroidx/constraintlayout/widget/ConstraintLayout;", "currentPlatformEntity", "Lcom/magneticchen/daijishou/data/db/entity/PlatformEntity;", "currentPlatformEntityDimensionRatio", "", "currentPlatformEntityLiveData", "Landroidx/lifecycle/LiveData;", "currentPlatformEntityLiveDataObserver", "Landroidx/lifecycle/Observer;", "gridLayoutManager", "Lcom/magneticchen/daijishou/ui/daijishou_recycler_view/DaijishouGridLayoutManager;", "itemFIOF", "", "getItemFIOF", "()Z", "setItemFIOF", "(Z)V", "lastSearchText", "onClickListener", "Lkotlin/Function1;", "Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;", "", "onDialogDismissedListener", "Lkotlin/Function0;", "onLongClickListener", "onSelectListener", "onTextChangedListener", "Lkotlin/Function4;", "", "", "platformIdToShortnameHashMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "playableItemCollection", "", "playableItemCollectionInRecyclerView", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerViewAdapter", "Lcom/magneticchen/daijishou/ui/fragments/abstract/PlayableItemCollectionDialogFragment$GridRecyclerViewAdapter;", "scrollingOnBackPressed", "textInputEditText", "Lcom/google/android/material/textfield/TextInputEditText;", "textInputLayout", "Lcom/google/android/material/textfield/TextInputLayout;", "onBackPressed", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "onHotKeyPressed", "hotkeyCode", "keyCode", "keyEvent", "Landroid/view/KeyEvent;", "onStart", "onViewCreated", "view", "refreshSearchItemsByKeyword", "keyword", "resetPlayableItemCollectionInRecyclerView", "setOnClickListener", "setOnDialogDismissedListener", "setOnLongClickListener", "setOnSelectListener", "setOnTextChangedListener", "setPlayableItemCollection", "", "setPlayableItemCollectionInRecyclerView", "setSearchText", "text", "setTitle", "title", "GridRecyclerViewAdapter", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public abstract class PlayableItemCollectionDialogFragment extends DaijishouDialogFragment {
    private ConstraintLayout backButton;
    private PlatformEntity currentPlatformEntity;
    private LiveData<PlatformEntity> currentPlatformEntityLiveData;
    private Observer<PlatformEntity> currentPlatformEntityLiveDataObserver;
    private DaijishouGridLayoutManager gridLayoutManager;
    private boolean itemFIOF;
    private String lastSearchText;
    private Function1<? super PlayableItemEntity, Unit> onClickListener;
    private Function0<Unit> onDialogDismissedListener;
    private Function1<? super PlayableItemEntity, Unit> onLongClickListener;
    private Function1<? super PlayableItemEntity, Unit> onSelectListener;
    private Function4<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, Boolean> onTextChangedListener;
    private RecyclerView recyclerView;
    private GridRecyclerViewAdapter recyclerViewAdapter;
    private boolean scrollingOnBackPressed;
    private TextInputEditText textInputEditText;
    private TextInputLayout textInputLayout;
    private final List<PlayableItemEntity> playableItemCollection = new ArrayList();
    private final List<PlayableItemEntity> playableItemCollectionInRecyclerView = new ArrayList();
    private final HashMap<Long, String> platformIdToShortnameHashMap = new HashMap<>();
    private String currentPlatformEntityDimensionRatio = Constants.defaultThumbnailDimensionRatio;

    public final boolean getItemFIOF() {
        return this.itemFIOF;
    }

    public final void setItemFIOF(boolean z) {
        this.itemFIOF = z;
    }

    public final PlayableItemCollectionDialogFragment setOnLongClickListener(Function1<? super PlayableItemEntity, Unit> onLongClickListener) {
        Intrinsics.checkNotNullParameter(onLongClickListener, "onLongClickListener");
        this.onLongClickListener = onLongClickListener;
        return this;
    }

    public final PlayableItemCollectionDialogFragment setOnClickListener(Function1<? super PlayableItemEntity, Unit> onClickListener) {
        Intrinsics.checkNotNullParameter(onClickListener, "onClickListener");
        this.onClickListener = onClickListener;
        return this;
    }

    public final PlayableItemCollectionDialogFragment setOnSelectListener(Function1<? super PlayableItemEntity, Unit> onSelectListener) {
        Intrinsics.checkNotNullParameter(onSelectListener, "onSelectListener");
        this.onSelectListener = onSelectListener;
        return this;
    }

    public final PlayableItemCollectionDialogFragment setOnTextChangedListener(Function4<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, Boolean> onTextChangedListener) {
        Intrinsics.checkNotNullParameter(onTextChangedListener, "onTextChangedListener");
        this.onTextChangedListener = onTextChangedListener;
        return this;
    }

    public final PlayableItemCollectionDialogFragment setOnDialogDismissedListener(Function0<Unit> onDialogDismissedListener) {
        Intrinsics.checkNotNullParameter(onDialogDismissedListener, "onDialogDismissedListener");
        this.onDialogDismissedListener = onDialogDismissedListener;
        return this;
    }

    public final void setPlayableItemCollection(List<PlayableItemEntity> playableItemCollection) {
        Intrinsics.checkNotNullParameter(playableItemCollection, "playableItemCollection");
        this.playableItemCollection.clear();
        this.playableItemCollection.addAll(playableItemCollection);
        resetPlayableItemCollectionInRecyclerView();
    }

    private final void setPlayableItemCollectionInRecyclerView(List<PlayableItemEntity> list) {
        GridRecyclerViewAdapter gridRecyclerViewAdapter = null;
        if (!this.itemFIOF) {
            DiffUtil.DiffResult diffResultCalculateDiff = DiffUtil.calculateDiff(new PlayableItemEntityDiffUtilCallback(this.playableItemCollectionInRecyclerView, list));
            Intrinsics.checkNotNullExpressionValue(diffResultCalculateDiff, "calculateDiff(...)");
            this.playableItemCollectionInRecyclerView.clear();
            this.playableItemCollectionInRecyclerView.addAll(list);
            GridRecyclerViewAdapter gridRecyclerViewAdapter2 = this.recyclerViewAdapter;
            if (gridRecyclerViewAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerViewAdapter");
            } else {
                gridRecyclerViewAdapter = gridRecyclerViewAdapter2;
            }
            diffResultCalculateDiff.dispatchUpdatesTo(gridRecyclerViewAdapter);
            return;
        }
        List<PlayableItemEntity> list2 = list;
        for (PlayableItemEntity playableItemEntity : list2) {
            List<PlayableItemEntity> list3 = this.playableItemCollectionInRecyclerView;
            if (!(list3 instanceof Collection) || !list3.isEmpty()) {
                Iterator<T> it = list3.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (((PlayableItemEntity) it.next()).getId() == playableItemEntity.getId()) {
                        }
                    }
                }
            }
            this.playableItemCollectionInRecyclerView.add(playableItemEntity);
            RecyclerView recyclerView = this.recyclerView;
            if (recyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                recyclerView = null;
            }
            RecyclerView.Adapter adapter = recyclerView.getAdapter();
            if (adapter != null) {
                adapter.notifyItemInserted(this.playableItemCollectionInRecyclerView.size());
            }
        }
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (Object obj : this.playableItemCollectionInRecyclerView) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            PlayableItemEntity playableItemEntity2 = (PlayableItemEntity) obj;
            if ((list2 instanceof Collection) && list2.isEmpty()) {
                arrayList.add(Integer.valueOf(i));
                break;
                break;
            } else {
                Iterator<T> it2 = list2.iterator();
                do {
                    if (!it2.hasNext()) {
                        arrayList.add(Integer.valueOf(i));
                        break;
                    }
                } while (((PlayableItemEntity) it2.next()).getId() != playableItemEntity2.getId());
            }
            i = i2;
        }
        CollectionsKt.sortDescending(arrayList);
        Iterator it3 = arrayList.iterator();
        while (it3.hasNext()) {
            int iIntValue = ((Number) it3.next()).intValue();
            this.playableItemCollectionInRecyclerView.remove(iIntValue);
            RecyclerView recyclerView2 = this.recyclerView;
            if (recyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                recyclerView2 = null;
            }
            RecyclerView.Adapter adapter2 = recyclerView2.getAdapter();
            if (adapter2 != null) {
                adapter2.notifyItemRemoved(iIntValue);
            }
        }
    }

    public final void resetPlayableItemCollectionInRecyclerView() {
        setPlayableItemCollectionInRecyclerView(this.playableItemCollection);
    }

    public final PlayableItemCollectionDialogFragment setTitle(String title) {
        Intrinsics.checkNotNullParameter(title, "title");
        requireArguments().putString("title", title);
        return this;
    }

    public final PlayableItemCollectionDialogFragment setSearchText(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        requireArguments().putString("search_text", text);
        return this;
    }

    public final void refreshSearchItemsByKeyword(String keyword) {
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        this.lastSearchText = keyword;
        ArrayList arrayList = new ArrayList();
        for (PlayableItemEntity playableItemEntity : this.playableItemCollection) {
            String name = playableItemEntity.getName();
            Locale ROOT = Locale.ROOT;
            Intrinsics.checkNotNullExpressionValue(ROOT, "ROOT");
            String lowerCase = name.toLowerCase(ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            Locale ROOT2 = Locale.ROOT;
            Intrinsics.checkNotNullExpressionValue(ROOT2, "ROOT");
            String lowerCase2 = keyword.toLowerCase(ROOT2);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
            if (!StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) lowerCase2, false, 2, (Object) null)) {
                if (playableItemEntity.getDescription() != null) {
                    String description = playableItemEntity.getDescription();
                    Intrinsics.checkNotNull(description);
                    if (StringsKt.contains$default((CharSequence) description, (CharSequence) keyword, false, 2, (Object) null)) {
                    }
                }
            }
            arrayList.add(playableItemEntity);
        }
        setPlayableItemCollectionInRecyclerView(arrayList);
    }

    /* JADX WARN: Code duplicated, block: B:11:0x001b  */
    /* JADX WARN: Code duplicated, block: B:20:0x0036  */
    /* JADX WARN: Code duplicated, block: B:22:0x003d  */
    /* JADX WARN: Code duplicated, block: B:25:0x004a  */
    /* JADX WARN: Code duplicated, block: B:28:0x0058  */
    /* JADX WARN: Code duplicated, block: B:30:0x005c  */
    /* JADX WARN: Code duplicated, block: B:33:0x0069  */
    /* JADX WARN: Code duplicated, block: B:34:0x006d  */
    /* JADX WARN: Code duplicated, block: B:36:0x0072  */
    /* JADX WARN: Code duplicated, block: B:38:0x0076  */
    /* JADX WARN: Code duplicated, block: B:39:0x007a  */
    /* JADX WARN: Code duplicated, block: B:9:0x0017  */
    @Override // com.magneticchen.daijishou.ui.fragments.p000abstract.DaijishouDialogFragment
    public boolean onBackPressed() {
        RecyclerView recyclerView;
        ConstraintLayout constraintLayout;
        DaijishouGridLayoutManager daijishouGridLayoutManager;
        RecyclerView recyclerView2;
        RecyclerView recyclerView3;
        RecyclerView recyclerView4;
        RecyclerView recyclerView5 = null;
        if (this.scrollingOnBackPressed) {
            RecyclerView recyclerView6 = this.recyclerView;
            if (recyclerView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                recyclerView6 = null;
            }
            if (recyclerView6.getScrollState() != 2) {
                recyclerView = this.recyclerView;
                if (recyclerView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                    recyclerView = null;
                }
                if (recyclerView.computeVerticalScrollOffset() != 0) {
                    this.scrollingOnBackPressed = true;
                    constraintLayout = this.backButton;
                    if (constraintLayout == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("backButton");
                        constraintLayout = null;
                    }
                    constraintLayout.requestFocus();
                    daijishouGridLayoutManager = this.gridLayoutManager;
                    if (daijishouGridLayoutManager == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("gridLayoutManager");
                        daijishouGridLayoutManager = null;
                    }
                    if (daijishouGridLayoutManager.findFirstVisibleItemPosition() > 256) {
                        recyclerView3 = this.recyclerView;
                        if (recyclerView3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                            recyclerView3 = null;
                        }
                        recyclerView3.scrollToPosition(128);
                        recyclerView4 = this.recyclerView;
                        if (recyclerView4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                        } else {
                            recyclerView5 = recyclerView4;
                        }
                        recyclerView5.smoothScrollToPosition(0);
                    } else {
                        recyclerView2 = this.recyclerView;
                        if (recyclerView2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                        } else {
                            recyclerView5 = recyclerView2;
                        }
                        recyclerView5.smoothScrollToPosition(0);
                    }
                    return false;
                }
            }
        } else {
            recyclerView = this.recyclerView;
            if (recyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                recyclerView = null;
            }
            if (recyclerView.computeVerticalScrollOffset() != 0) {
                this.scrollingOnBackPressed = true;
                constraintLayout = this.backButton;
                if (constraintLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("backButton");
                    constraintLayout = null;
                }
                constraintLayout.requestFocus();
                daijishouGridLayoutManager = this.gridLayoutManager;
                if (daijishouGridLayoutManager == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("gridLayoutManager");
                    daijishouGridLayoutManager = null;
                }
                if (daijishouGridLayoutManager.findFirstVisibleItemPosition() > 256) {
                    recyclerView3 = this.recyclerView;
                    if (recyclerView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                        recyclerView3 = null;
                    }
                    recyclerView3.scrollToPosition(128);
                    recyclerView4 = this.recyclerView;
                    if (recyclerView4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                    } else {
                        recyclerView5 = recyclerView4;
                    }
                    recyclerView5.smoothScrollToPosition(0);
                } else {
                    recyclerView2 = this.recyclerView;
                    if (recyclerView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                    } else {
                        recyclerView5 = recyclerView2;
                    }
                    recyclerView5.smoothScrollToPosition(0);
                }
                return false;
            }
        }
        RecyclerView recyclerView7 = this.recyclerView;
        if (recyclerView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        } else {
            recyclerView5 = recyclerView7;
        }
        recyclerView5.scrollToPosition(0);
        return super.onBackPressed();
    }

    @Override // com.magneticchen.daijishou.ui.fragments.p000abstract.DaijishouDialogFragment
    public final void onHotKeyPressed(int i, int i2, KeyEvent keyEvent) {
        Function1<? super PlayableItemEntity, Unit> function1;
        Function1<? super PlayableItemEntity, Unit> function2;
        Intrinsics.checkNotNullParameter(keyEvent, "keyEvent");
        super.onHotKeyPressed(i, i2, keyEvent);
        GridRecyclerViewAdapter gridRecyclerViewAdapter = null;
        if (i == 3) {
            GridRecyclerViewAdapter gridRecyclerViewAdapter2 = this.recyclerViewAdapter;
            if (gridRecyclerViewAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerViewAdapter");
                gridRecyclerViewAdapter2 = null;
            }
            if (gridRecyclerViewAdapter2.getSelectedPosition() >= 0) {
                GridRecyclerViewAdapter gridRecyclerViewAdapter3 = this.recyclerViewAdapter;
                if (gridRecyclerViewAdapter3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recyclerViewAdapter");
                    gridRecyclerViewAdapter3 = null;
                }
                if (gridRecyclerViewAdapter3.getSelectedPosition() >= this.playableItemCollectionInRecyclerView.size() || (function1 = this.onLongClickListener) == null) {
                    return;
                }
                List<PlayableItemEntity> list = this.playableItemCollectionInRecyclerView;
                GridRecyclerViewAdapter gridRecyclerViewAdapter4 = this.recyclerViewAdapter;
                if (gridRecyclerViewAdapter4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recyclerViewAdapter");
                } else {
                    gridRecyclerViewAdapter = gridRecyclerViewAdapter4;
                }
                function1.invoke(list.get(gridRecyclerViewAdapter.getSelectedPosition()));
                return;
            }
            return;
        }
        if (i != 4) {
            return;
        }
        GridRecyclerViewAdapter gridRecyclerViewAdapter5 = this.recyclerViewAdapter;
        if (gridRecyclerViewAdapter5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerViewAdapter");
            gridRecyclerViewAdapter5 = null;
        }
        if (gridRecyclerViewAdapter5.getSelectedPosition() >= 0) {
            GridRecyclerViewAdapter gridRecyclerViewAdapter6 = this.recyclerViewAdapter;
            if (gridRecyclerViewAdapter6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerViewAdapter");
                gridRecyclerViewAdapter6 = null;
            }
            if (gridRecyclerViewAdapter6.getSelectedPosition() >= this.playableItemCollectionInRecyclerView.size() || (function2 = this.onLongClickListener) == null) {
                return;
            }
            List<PlayableItemEntity> list2 = this.playableItemCollectionInRecyclerView;
            GridRecyclerViewAdapter gridRecyclerViewAdapter7 = this.recyclerViewAdapter;
            if (gridRecyclerViewAdapter7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerViewAdapter");
            } else {
                gridRecyclerViewAdapter = gridRecyclerViewAdapter7;
            }
            function2.invoke(list2.get(gridRecyclerViewAdapter.getSelectedPosition()));
        }
    }

    public void onDismiss(DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        Function0<Unit> function0 = this.onDialogDismissedListener;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public void onStart() {
        super.onStart();
        Window window = requireDialog().getWindow();
        View decorView = window != null ? window.getDecorView() : null;
        Intrinsics.checkNotNull(decorView);
        decorView.setBackground(null);
        Window window2 = requireDialog().getWindow();
        if (window2 != null) {
            window2.setLayout(-1, -1);
        }
        Window window3 = requireDialog().getWindow();
        if (window3 != null) {
            window3.setFlags(CategoryWidgetViewModel.LIMIT, CategoryWidgetViewModel.LIMIT);
        }
    }

    @Override // com.magneticchen.daijishou.ui.fragments.p000abstract.DaijishouDialogFragment
    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        Window window = requireDialog().getWindow();
        if (window != null) {
            window.setWindowAnimations(R.style.FullScreenDialogAnimation);
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        String string = requireArguments().getString("title");
        if (string == null) {
            string = getString(R.string.search_your_library);
        }
        Intrinsics.checkNotNull(string);
        String string2 = requireArguments().getString("search_text");
        View viewInflate = inflater.inflate(R.layout.fragment_playable_item_collection_dialog, viewGroup, false);
        RecyclerView recyclerViewFindViewById = viewInflate.findViewById(R.id.fragment_playable_item_collection_dialog_recycler_view);
        Intrinsics.checkNotNullExpressionValue(recyclerViewFindViewById, "findViewById(...)");
        this.recyclerView = recyclerViewFindViewById;
        GridRecyclerViewAdapter gridRecyclerViewAdapter = new GridRecyclerViewAdapter(this, this.playableItemCollectionInRecyclerView);
        this.recyclerViewAdapter = gridRecyclerViewAdapter;
        gridRecyclerViewAdapter.setOnItemClickListener(new Function4<View, Integer, Long, PlayableItemEntity, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.abstract.PlayableItemCollectionDialogFragment.onCreateView.1
            

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(View view, Integer num, Long l, PlayableItemEntity playableItemEntity) {
                invoke(view, num.intValue(), l.longValue(), playableItemEntity);
                return Unit.INSTANCE;
            }

            public final void invoke(View view, int i, long j, PlayableItemEntity playableItemEntity) {
                Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
                Intrinsics.checkNotNullParameter(playableItemEntity, "playableItemEntity");
                Function1 function1 = PlayableItemCollectionDialogFragment.this.onClickListener;
                if (function1 != null) {
                    function1.invoke(playableItemEntity);
                }
            }
        });
        GridRecyclerViewAdapter gridRecyclerViewAdapter2 = this.recyclerViewAdapter;
        TextInputLayout textInputLayout = null;
        if (gridRecyclerViewAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerViewAdapter");
            gridRecyclerViewAdapter2 = null;
        }
        gridRecyclerViewAdapter2.setOnItemLongClickListener(new Function4<View, Integer, Long, PlayableItemEntity, Boolean>() { // from class: com.magneticchen.daijishou.ui.fragments.abstract.PlayableItemCollectionDialogFragment.onCreateView.2
            

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Boolean invoke(View view, Integer num, Long l, PlayableItemEntity playableItemEntity) {
                return invoke(view, num.intValue(), l.longValue(), playableItemEntity);
            }

            public final Boolean invoke(View view, int i, long j, PlayableItemEntity playableItemEntity) {
                Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
                Intrinsics.checkNotNullParameter(playableItemEntity, "playableItemEntity");
                Function1 function1 = PlayableItemCollectionDialogFragment.this.onLongClickListener;
                if (function1 != null) {
                    function1.invoke(playableItemEntity);
                }
                return true;
            }
        });
        GridRecyclerViewAdapter gridRecyclerViewAdapter3 = this.recyclerViewAdapter;
        if (gridRecyclerViewAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerViewAdapter");
            gridRecyclerViewAdapter3 = null;
        }
        gridRecyclerViewAdapter3.setOnItemSelectListener(new Function4<View, Integer, Long, PlayableItemEntity, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.abstract.PlayableItemCollectionDialogFragment.onCreateView.3
            

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(View view, Integer num, Long l, PlayableItemEntity playableItemEntity) {
                invoke(view, num.intValue(), l.longValue(), playableItemEntity);
                return Unit.INSTANCE;
            }

            public final void invoke(View view, int i, long j, PlayableItemEntity playableItemEntity) {
                Intrinsics.checkNotNullParameter(playableItemEntity, "playableItemEntity");
                Function1 function1 = PlayableItemCollectionDialogFragment.this.onSelectListener;
                if (function1 != null) {
                    function1.invoke(playableItemEntity);
                }
            }
        });
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        GridRecyclerViewAdapter gridRecyclerViewAdapter4 = this.recyclerViewAdapter;
        if (gridRecyclerViewAdapter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerViewAdapter");
            gridRecyclerViewAdapter4 = null;
        }
        recyclerView.setAdapter(gridRecyclerViewAdapter4);
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        this.gridLayoutManager = new DaijishouGridLayoutManager(contextRequireContext, 108.0f, 8, 4.0f, false, 16, null);
        RecyclerView recyclerView2 = this.recyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView2 = null;
        }
        DaijishouGridLayoutManager daijishouGridLayoutManager = this.gridLayoutManager;
        if (daijishouGridLayoutManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("gridLayoutManager");
            daijishouGridLayoutManager = null;
        }
        recyclerView2.setLayoutManager((RecyclerView.LayoutManager) daijishouGridLayoutManager);
        RecyclerView recyclerView3 = this.recyclerView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView3 = null;
        }
        recyclerView3.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.magneticchen.daijishou.ui.fragments.abstract.PlayableItemCollectionDialogFragment.onCreateView.4
            public void onScrollStateChanged(RecyclerView recyclerView4, int i) {
                Intrinsics.checkNotNullParameter(recyclerView4, "recyclerView");
                if (i == 0) {
                    PlayableItemCollectionDialogFragment.this.scrollingOnBackPressed = false;
                }
                super.onScrollStateChanged(recyclerView4, i);
            }
        });
        ConstraintLayout constraintLayoutFindViewById = viewInflate.findViewById(R.id.fragment_playable_item_collection_dialog_back_button);
        Intrinsics.checkNotNullExpressionValue(constraintLayoutFindViewById, "findViewById(...)");
        ConstraintLayout constraintLayout = constraintLayoutFindViewById;
        this.backButton = constraintLayout;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("backButton");
            constraintLayout = null;
        }
        constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.abstract.PlayableItemCollectionDialogFragment$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PlayableItemCollectionDialogFragment.onCreateView$lambda$6(this.f$0, view);
            }
        });
        TextInputEditText textInputEditTextFindViewById = viewInflate.findViewById(R.id.fragment_playable_item_collection_dialog_edit_text);
        Intrinsics.checkNotNullExpressionValue(textInputEditTextFindViewById, "findViewById(...)");
        TextInputEditText textInputEditText = textInputEditTextFindViewById;
        this.textInputEditText = textInputEditText;
        if (textInputEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textInputEditText");
            textInputEditText = null;
        }
        textInputEditText.setText(string2);
        if (string2 != null) {
            refreshSearchItemsByKeyword(string2);
        }
        TextInputEditText textInputEditText2 = this.textInputEditText;
        if (textInputEditText2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textInputEditText");
            textInputEditText2 = null;
        }
        textInputEditText2.addTextChangedListener(new TextWatcher() { // from class: com.magneticchen.daijishou.ui.fragments.abstract.PlayableItemCollectionDialogFragment.onCreateView.7
            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (PlayableItemCollectionDialogFragment.this.onTextChangedListener != null) {
                    Function4 function4 = PlayableItemCollectionDialogFragment.this.onTextChangedListener;
                    Intrinsics.checkNotNull(function4);
                    if (!((Boolean) function4.invoke(charSequence, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3))).booleanValue()) {
                        return;
                    }
                }
                if (charSequence == null || Intrinsics.areEqual(charSequence, "")) {
                    PlayableItemCollectionDialogFragment.this.resetPlayableItemCollectionInRecyclerView();
                } else {
                    PlayableItemCollectionDialogFragment.this.refreshSearchItemsByKeyword(charSequence.toString());
                }
            }
        });
        TextInputLayout textInputLayoutFindViewById = viewInflate.findViewById(R.id.fragment_playable_item_collection_dialog_text_input_layout);
        Intrinsics.checkNotNullExpressionValue(textInputLayoutFindViewById, "findViewById(...)");
        TextInputLayout textInputLayout2 = textInputLayoutFindViewById;
        this.textInputLayout = textInputLayout2;
        if (textInputLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textInputLayout");
            textInputLayout2 = null;
        }
        textInputLayout2.setHint(string);
        TextInputLayout textInputLayout3 = this.textInputLayout;
        if (textInputLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textInputLayout");
        } else {
            textInputLayout = textInputLayout3;
        }
        textInputLayout.setEndIconOnClickListener(new View.OnClickListener() { // from class: com.magneticchen.daijishou.ui.fragments.abstract.PlayableItemCollectionDialogFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                PlayableItemCollectionDialogFragment.onCreateView$lambda$8(this.f$0, view);
            }
        });
        for (PlatformEntity platformEntity : getDaijishouLibrary().getAllPlatformsStatically()) {
            this.platformIdToShortnameHashMap.put(Long.valueOf(platformEntity.getId()), platformEntity.getShortname());
        }
        getDaijishouLibrary().getAllPlatforms().observe(getViewLifecycleOwner(), new PlayableItemCollectionDialogFragment$sam$androidx_lifecycle_Observer$0(new Function1<List<? extends PlatformEntity>, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.abstract.PlayableItemCollectionDialogFragment.onCreateView.10
            

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends PlatformEntity> list) {
                invoke2((List<PlatformEntity>) list);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<PlatformEntity> list) {
                Intrinsics.checkNotNull(list);
                PlayableItemCollectionDialogFragment playableItemCollectionDialogFragment = PlayableItemCollectionDialogFragment.this;
                for (PlatformEntity platformEntity2 : list) {
                    playableItemCollectionDialogFragment.platformIdToShortnameHashMap.put(Long.valueOf(platformEntity2.getId()), platformEntity2.getShortname());
                }
            }
        }));
        return viewInflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$6(PlayableItemCollectionDialogFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.requireDialog().onBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreateView$lambda$8(PlayableItemCollectionDialogFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TextInputEditText textInputEditText = this$0.textInputEditText;
        if (textInputEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("textInputEditText");
            textInputEditText = null;
        }
        Editable text = textInputEditText.getText();
        if (text != null) {
            text.clear();
        }
    }

    /* JADX INFO: compiled from: PlayableItemCollectionDialogFragment.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0010B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J \u0010\n\u001a\n0\u000bR\u00060\u0000R\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\tH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/magneticchen/daijishou/ui/fragments/abstract/PlayableItemCollectionDialogFragment$GridRecyclerViewAdapter;", "Lcom/magneticchen/daijishou/ui/daijishou_recycler_view/DaijishouRecyclerView$Adapter;", "Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;", "playableItemEntityList", "", "(Lcom/magneticchen/daijishou/ui/fragments/abstract/PlayableItemCollectionDialogFragment;Ljava/util/List;)V", "getItemId", "", "position", "", "onCreateViewHolder", "Lcom/magneticchen/daijishou/ui/fragments/abstract/PlayableItemCollectionDialogFragment$GridRecyclerViewAdapter$ViewHolder;", "Lcom/magneticchen/daijishou/ui/fragments/abstract/PlayableItemCollectionDialogFragment;", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class GridRecyclerViewAdapter extends DaijishouRecyclerView.Adapter<PlayableItemEntity> {
        private final List<PlayableItemEntity> playableItemEntityList;
        final /* synthetic */ PlayableItemCollectionDialogFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GridRecyclerViewAdapter(PlayableItemCollectionDialogFragment playableItemCollectionDialogFragment, List<PlayableItemEntity> playableItemEntityList) {
            super(playableItemEntityList, false, false, 6, null);
            Intrinsics.checkNotNullParameter(playableItemEntityList, "playableItemEntityList");
            this.this$0 = playableItemCollectionDialogFragment;
            this.playableItemEntityList = playableItemEntityList;
        }

        public long getItemId(int i) {
            return this.playableItemEntityList.get(i).getId();
        }

        /* JADX INFO: compiled from: PlayableItemCollectionDialogFragment.kt */
        @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\b\u0086\u0004\u0018\u00002\f0\u0001R\b\u0012\u0004\u0012\u00020\u00030\u0002B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0003H\u0016J\b\u0010\u0014\u001a\u00020\u0010H\u0016J\u0010\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u0017H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/magneticchen/daijishou/ui/fragments/abstract/PlayableItemCollectionDialogFragment$GridRecyclerViewAdapter$ViewHolder;", "Lcom/magneticchen/daijishou/ui/daijishou_recycler_view/DaijishouRecyclerView$Adapter$ViewHolder;", "Lcom/magneticchen/daijishou/ui/daijishou_recycler_view/DaijishouRecyclerView$Adapter;", "Lcom/magneticchen/daijishou/data/db/entity/PlayableItemEntity;", "itemView", "Landroid/view/View;", "(Lcom/magneticchen/daijishou/ui/fragments/abstract/PlayableItemCollectionDialogFragment$GridRecyclerViewAdapter;Landroid/view/View;)V", "backgroundSet", "Landroidx/constraintlayout/widget/ConstraintLayout;", "imageView", "Landroid/widget/ImageView;", "placeholder", "platformTextView", "Landroid/widget/TextView;", "textView", "onBind", "", "position", "", "item", "onFocus", "onFocusClear", "isAbsoluteAdapterPositionValid", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
        public final class ViewHolder extends DaijishouRecyclerView.Adapter<PlayableItemEntity>.ViewHolder {
            private ConstraintLayout backgroundSet;
            private ImageView imageView;
            private ImageView placeholder;
            private TextView platformTextView;
            private TextView textView;
            final /* synthetic */ GridRecyclerViewAdapter this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ViewHolder(GridRecyclerViewAdapter gridRecyclerViewAdapter, View itemView) {
                super(gridRecyclerViewAdapter, itemView);
                Intrinsics.checkNotNullParameter(itemView, "itemView");
                this.this$0 = gridRecyclerViewAdapter;
                View viewFindViewById = itemView.findViewById(R.id.playable_item_thumbnail_text_view);
                Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
                this.textView = (TextView) viewFindViewById;
                View viewFindViewById2 = itemView.findViewById(R.id.playable_item_platform_text_view);
                Intrinsics.checkNotNullExpressionValue(viewFindViewById2, "findViewById(...)");
                this.platformTextView = (TextView) viewFindViewById2;
                View viewFindViewById3 = itemView.findViewById(R.id.playable_item_thumbnail_wallpaper);
                Intrinsics.checkNotNullExpressionValue(viewFindViewById3, "findViewById(...)");
                this.imageView = (ImageView) viewFindViewById3;
                View viewFindViewById4 = itemView.findViewById(R.id.playable_item_thumbnail_placeholder);
                Intrinsics.checkNotNullExpressionValue(viewFindViewById4, "findViewById(...)");
                this.placeholder = (ImageView) viewFindViewById4;
                ConstraintLayout constraintLayoutFindViewById = itemView.findViewById(R.id.playable_item_thumbnail_background_set);
                Intrinsics.checkNotNullExpressionValue(constraintLayoutFindViewById, "findViewById(...)");
                this.backgroundSet = constraintLayoutFindViewById;
            }

            @Override // com.magneticchen.daijishou.ui.daijishou_recycler_view.DaijishouRecyclerView.Adapter.ViewHolder
            public void onFocus() {
                super.onFocus();
                Utils utils = Utils.INSTANCE;
                View itemView = this.itemView;
                Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
                Utils.scaleView$default(utils, itemView, 1.0f, 1.03f, 0L, false, 24, null);
                this.itemView.requestFocus();
            }

            @Override // com.magneticchen.daijishou.ui.daijishou_recycler_view.DaijishouRecyclerView.Adapter.ViewHolder
            public void onFocusClear(boolean z) {
                super.onFocusClear(z);
                if (z) {
                    Utils utils = Utils.INSTANCE;
                    View itemView = this.itemView;
                    Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
                    Utils.scaleView$default(utils, itemView, 1.03f, 1.0f, 0L, false, 24, null);
                }
            }

            @Override // com.magneticchen.daijishou.ui.daijishou_recycler_view.DaijishouRecyclerView.Adapter.ViewHolder
            public void onBind(int i, PlayableItemEntity item) {
                Intrinsics.checkNotNullParameter(item, "item");
                this.imageView.setImageBitmap(null);
                if (this.placeholder.getVisibility() != 0) {
                    this.placeholder.setVisibility(0);
                }
                if (this.platformTextView.getVisibility() != 0) {
                    this.platformTextView.setVisibility(0);
                }
                this.textView.setText(this.this$0.this$0.getDaijishouLibrary().prettifyTitleWithPreferences(item.getName()));
                this.platformTextView.setText((CharSequence) this.this$0.this$0.platformIdToShortnameHashMap.get(item.getAttachedPlatformId()));
                ConstraintLayout.LayoutParams layoutParams = this.backgroundSet.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
                ConstraintLayout.LayoutParams layoutParams2 = layoutParams;
                if (!Intrinsics.areEqual(layoutParams2.dimensionRatio, this.this$0.this$0.currentPlatformEntityDimensionRatio)) {
                    layoutParams2.dimensionRatio = this.this$0.this$0.currentPlatformEntityDimensionRatio;
                    this.backgroundSet.requestLayout();
                }
                String boxArtPath = Utils.INSTANCE.getBoxArtPath(item);
                if (boxArtPath != null) {
                    CachedBitmapLoader.CachedBitmapLoaderTask.load$default(this.this$0.this$0.getDaijishouLibrary().getCachedBoxArtBitmapLoader().with((Fragment) this.this$0.this$0), boxArtPath, false, 2, null).setOnFailedListener(new Function1<Exception, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.abstract.PlayableItemCollectionDialogFragment$GridRecyclerViewAdapter$ViewHolder$onBind$1
                        

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Exception exc) {
                            invoke2(exc);
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(Exception it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            this.this$0.placeholder.setVisibility(0);
                            this.this$0.platformTextView.setVisibility(0);
                        }
                    }).setOnSucceedListener(new Function2<Bitmap, Boolean, Unit>() { // from class: com.magneticchen.daijishou.ui.fragments.abstract.PlayableItemCollectionDialogFragment$GridRecyclerViewAdapter$ViewHolder$onBind$2
                        

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Bitmap bitmap, Boolean bool) {
                            invoke(bitmap, bool.booleanValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Bitmap bitmap, boolean z) {
                            Intrinsics.checkNotNullParameter(bitmap, "bitmap");
                            this.this$0.placeholder.setVisibility(8);
                            this.this$0.platformTextView.setVisibility(8);
                            this.this$0.imageView.setImageBitmap(bitmap);
                        }
                    }).into(this.imageView);
                }
            }
        }

        public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
            Intrinsics.checkNotNullParameter(parent, "parent");
            View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_item_playable_item_thumbnail, parent, false);
            Intrinsics.checkNotNull(viewInflate);
            return new ViewHolder(this, viewInflate);
        }
    }
}
