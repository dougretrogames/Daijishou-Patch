package androidx.appcompat.widget;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.appcompat.R;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPopupHelper;
import androidx.appcompat.view.menu.ShowableListMenu;

/* INFO: loaded from: classes.dex */
public class PopupMenu {
    private final View mAnchor;
    private final Context mContext;
    private View.OnTouchListener mDragListener;
    private final MenuBuilder mMenu;
    OnMenuItemClickListener mMenuItemClickListener;
    OnDismissListener mOnDismissListener;
    final MenuPopupHelper mPopup;

    public interface OnDismissListener {
        void onDismiss(PopupMenu popupMenu);
    }

    public interface OnMenuItemClickListener {
        boolean onMenuItemClick(MenuItem menuItem);
    }

    public PopupMenu(Context context, View view) {
        this(context, view, 0);
    }

    public PopupMenu(Context context, View view, int i) {
        this(context, view, i, R.attr.popupMenuStyle, 0);
    }

    public PopupMenu(Context context, View view, int i, int i2, int i3) {
        this.mContext = context;
        this.mAnchor = view;
        MenuBuilder menuBuilder = new MenuBuilder(context);
        this.mMenu = menuBuilder;
        menuBuilder.setCallback(new AnonymousClass1());
        MenuPopupHelper menuPopupHelper = new MenuPopupHelper(context, menuBuilder, view, false, i2, i3);
        this.mPopup = menuPopupHelper;
        menuPopupHelper.setGravity(i);
        menuPopupHelper.setOnDismissListener(new AnonymousClass2());
    }

    /* INFO: renamed from: androidx.appcompat.widget.PopupMenu$1, reason: invalid class name */
    class AnonymousClass1 implements MenuBuilder.Callback {
        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public void onMenuModeChange(MenuBuilder menuBuilder) {
        }

        AnonymousClass1() {
        }

        @Override // androidx.appcompat.view.menu.MenuBuilder.Callback
        public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
            if (PopupMenu.this.mMenuItemClickListener != null) {
                return PopupMenu.this.mMenuItemClickListener.onMenuItemClick(menuItem);
            }
            return false;
        }
    }

    /* INFO: renamed from: androidx.appcompat.widget.PopupMenu$2, reason: invalid class name */
    class AnonymousClass2 implements PopupWindow.OnDismissListener {
        AnonymousClass2() {
        }

        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (PopupMenu.this.mOnDismissListener != null) {
                PopupMenu.this.mOnDismissListener.onDismiss(PopupMenu.this);
            }
        }
    }

    public void setGravity(int i) {
        this.mPopup.setGravity(i);
    }

    public int getGravity() {
        return this.mPopup.getGravity();
    }

    /* INFO: renamed from: androidx.appcompat.widget.PopupMenu$3, reason: invalid class name */
    class AnonymousClass3 extends ForwardingListener {
        AnonymousClass3(View view) {
            super(view);
        }

        @Override // androidx.appcompat.widget.ForwardingListener
        protected boolean onForwardingStarted() {
            PopupMenu.this.show();
            return true;
        }

        @Override // androidx.appcompat.widget.ForwardingListener
        protected boolean onForwardingStopped() {
            PopupMenu.this.dismiss();
            return true;
        }

        @Override // androidx.appcompat.widget.ForwardingListener
        public ShowableListMenu getPopup() {
            return PopupMenu.this.mPopup.getPopup();
        }
    }

    public View.OnTouchListener getDragToOpenListener() {
        if (this.mDragListener == null) {
            this.mDragListener = new AnonymousClass3(this.mAnchor);
        }
        return this.mDragListener;
    }

    public Menu getMenu() {
        return this.mMenu;
    }

    public MenuInflater getMenuInflater() {
        return new SupportMenuInflater(this.mContext);
    }

    public void inflate(int i) {
        getMenuInflater().inflate(i, this.mMenu);
    }

    public void show() {
        this.mPopup.show();
    }

    public void dismiss() {
        this.mPopup.dismiss();
    }

    public void setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.mMenuItemClickListener = onMenuItemClickListener;
    }

    public void setOnDismissListener(OnDismissListener onDismissListener) {
        this.mOnDismissListener = onDismissListener;
    }

    public void setForceShowIcon(boolean z) {
        this.mPopup.setForceShowIcon(z);
    }

    ListView getMenuListView() {
        if (this.mPopup.isShowing()) {
            return this.mPopup.getListView();
        }
        return null;
    }
}
