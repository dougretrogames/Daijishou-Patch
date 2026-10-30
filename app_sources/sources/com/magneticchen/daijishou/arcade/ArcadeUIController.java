package com.magneticchen.daijishou.arcade;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.view.View;
import android.view.KeyEvent;
import android.view.Window;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.preference.PreferenceManager;
import java.lang.reflect.Method;

public class ArcadeUIController {

    public static final String PREF_UI_MODE = "ui_interface_mode";
    public static final String MODE_ARCADE = "arcade";
    public static final String MODE_ORIGINAL = "original";

    private static SharedPreferences.OnSharedPreferenceChangeListener prefListener = null;

    public static boolean isArcadeMode(Context context) {
        if (context == null) return true;
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        String mode = prefs.getString(PREF_UI_MODE, MODE_ARCADE);
        if (mode != null) {
            return MODE_ARCADE.equalsIgnoreCase(mode);
        }
        // Fallback to library_collection_view_mode
        String collMode = prefs.getString("library_collection_view_mode", "3");
        return "3".equals(collMode);
    }

    public static void setInterfaceMode(Context context, String mode) {
        if (context == null) return;
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(PREF_UI_MODE, mode);
        if (MODE_ARCADE.equalsIgnoreCase(mode)) {
            editor.putString("library_collection_view_mode", "3");
        } else {
            editor.putString("library_collection_view_mode", "0");
        }
        editor.apply();
    }

    public static void applyUIMode(final Activity activity) {
        if (activity == null) return;

        registerPreferenceListener(activity);

        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                try {
                    boolean arcade = isArcadeMode(activity);
                    int visibility = arcade ? View.GONE : View.VISIBLE;

                    int tabId = ArcadeRes.getId(activity, "tab_layout");
                    int statusId = ArcadeRes.getId(activity, "system_status_layout");
                    int searchId = ArcadeRes.getId(activity, "search_button_layout");
                    int syncId = ArcadeRes.getId(activity, "sync_and_backup_button_layout");
                    int loggerId = ArcadeRes.getId(activity, "logger_button_layout");
                    int dividerId = ArcadeRes.getId(activity, "view");
                    int coordinatorId = ArcadeRes.getId(activity, "coordinatorLayout");

                    View tab = activity.findViewById(tabId);
                    View status = activity.findViewById(statusId);
                    View search = activity.findViewById(searchId);
                    View sync = activity.findViewById(syncId);
                    View logger = activity.findViewById(loggerId);
                    View divider = activity.findViewById(dividerId);
                    View coordinator = activity.findViewById(coordinatorId);

                    if (tab != null) tab.setVisibility(visibility);
                    if (status != null) status.setVisibility(visibility);
                    if (search != null) search.setVisibility(visibility);
                    if (sync != null) sync.setVisibility(visibility);
                    if (divider != null) divider.setVisibility(visibility);
                    if (coordinator != null) {
                        coordinator.setVisibility(visibility);
                        if (!arcade) {
                            // Make mobile mode coordinatorLayout buttons clickable too
                            int selectId = ArcadeRes.getId(activity, "constraintLayout2");
                            View selectLayout = activity.findViewById(selectId);
                            if (selectLayout != null) {
                                selectLayout.setClickable(true);
                                selectLayout.setFocusable(true);
                                selectLayout.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        int playId = ArcadeRes.getId(activity, "platform_library_play_button");
                                        View playBtn = activity.findViewById(playId);
                                        if (playBtn != null && playBtn.getVisibility() == View.VISIBLE) {
                                            playBtn.performClick();
                                        } else {
                                            View focused = activity.getCurrentFocus();
                                            if (focused != null) focused.performClick();
                                        }
                                    }
                                });
                            }
                            int backId = ArcadeRes.getId(activity, "constraintLayout3");
                            View backLayout = activity.findViewById(backId);
                            if (backLayout != null) {
                                backLayout.setClickable(true);
                                backLayout.setFocusable(true);
                                backLayout.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        activity.onBackPressed();
                                    }
                                });
                            }
                        }
                    }
                    if (logger != null) {
                        logger.setVisibility(View.GONE);
                    }

                    try {
                        int pagerId = ArcadeRes.getId(activity, "main_view_pager");
                        View pager = activity.findViewById(pagerId);
                        if (pager != null && pager.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                            ViewGroup.MarginLayoutParams mlp = (ViewGroup.MarginLayoutParams) pager.getLayoutParams();
                            int dp1 = (int) (1 * activity.getResources().getDisplayMetrics().density);
                            mlp.topMargin = arcade ? 0 : dp1;
                            mlp.bottomMargin = arcade ? 0 : dp1;
                            pager.setLayoutParams(mlp);
                        }
                    } catch (Throwable ignored) {}

                    if (arcade) {
                        try {
                            Method navMethod = activity.getClass().getMethod("navigatePage", String.class, Object.class);
                            navMethod.invoke(activity, "library", null);
                        } catch (Throwable ignored) {}
                    }
                } catch (Throwable t) {
                    t.printStackTrace();
                }
            }
        });
    }

    public static void registerPreferenceListener(final Activity activity) {
        if (activity == null) return;
        final SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(activity);
        if (prefListener == null) {
            prefListener = new SharedPreferences.OnSharedPreferenceChangeListener() {
                @Override
                public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
                    if (PREF_UI_MODE.equals(key)) {
                        String newMode = sharedPreferences.getString(PREF_UI_MODE, MODE_ARCADE);
                        // Also sync library_collection_view_mode
                        sharedPreferences.edit()
                            .putString("library_collection_view_mode", MODE_ARCADE.equalsIgnoreCase(newMode) ? "3" : "0")
                            .apply();
                        activity.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                activity.recreate();
                            }
                        });
                    }
                }
            };
            prefs.registerOnSharedPreferenceChangeListener(prefListener);
        }
    }

    public static void setupLibraryLegendBar(final androidx.fragment.app.Fragment fragment, final View rootView) {
        if (fragment == null || rootView == null) return;
        try {
            final Context context = rootView.getContext();
            boolean arcade = isArcadeMode(context);

            int footerId = ArcadeRes.getId(context, "arcade_game_footer_bar");
            View footer = (footerId != 0) ? rootView.findViewById(footerId) : null;
            if (footer != null) {
                footer.setVisibility(arcade ? View.VISIBLE : View.GONE);
            }

            if (!arcade) return;

            int editBtnId = ArcadeRes.getId(context, "arcade_btn_action_edit");
            View btnEdit = (editBtnId != 0) ? rootView.findViewById(editBtnId) : null;
            if (btnEdit != null) {
                btnEdit.setClickable(true);
                btnEdit.setFocusable(true);
                btnEdit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int chipEditId = ArcadeRes.getId(context, "platform_library_edit_button");
                        View chipEdit = rootView.findViewById(chipEditId);
                        if (chipEdit != null) {
                            chipEdit.performClick();
                        }
                    }
                });
            }

            int playBtnId = ArcadeRes.getId(context, "arcade_btn_action_play");
            View btnPlay = (playBtnId != 0) ? rootView.findViewById(playBtnId) : null;
            if (btnPlay != null) {
                btnPlay.setClickable(true);
                btnPlay.setFocusable(true);
                btnPlay.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int playChipId = ArcadeRes.getId(context, "platform_library_play_button");
                        View chipPlay = rootView.findViewById(playChipId);
                        if (chipPlay != null) {
                            chipPlay.performClick();
                        }
                    }
                });
            }

            int backBtnId = ArcadeRes.getId(context, "arcade_btn_action_back");
            View btnBack = (backBtnId != 0) ? rootView.findViewById(backBtnId) : null;
            if (btnBack != null) {
                btnBack.setClickable(true);
                btnBack.setFocusable(true);
                btnBack.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (fragment.getActivity() != null) {
                            fragment.getActivity().onBackPressed();
                        }
                    }
                });
            }

            try {
                android.content.SharedPreferences prefsLocal = androidx.preference.PreferenceManager.getDefaultSharedPreferences(context);
                boolean swapAB = prefsLocal.getBoolean("swap_a_b_buttons", false);
                int aBadgeId = ArcadeRes.getId(context, "arcade_footer_btn_a_badge");
                android.widget.TextView aBadge = (aBadgeId != 0) ? (android.widget.TextView) rootView.findViewById(aBadgeId) : null;
                if (aBadge != null) {
                    aBadge.setText(swapAB ? "B" : "A");
                    aBadge.setBackgroundTintList(android.content.res.ColorStateList.valueOf(swapAB ? 0xFFD50000 : 0xFF00C853));
                }
                int bBadgeId = ArcadeRes.getId(context, "arcade_footer_btn_b_badge");
                android.widget.TextView bBadge = (bBadgeId != 0) ? (android.widget.TextView) rootView.findViewById(bBadgeId) : null;
                if (bBadge != null) {
                    bBadge.setText(swapAB ? "A" : "B");
                    bBadge.setBackgroundTintList(android.content.res.ColorStateList.valueOf(swapAB ? 0xFF00C853 : 0xFFD50000));
                }
            } catch (Throwable tSwap) {
                tSwap.printStackTrace();
            }
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    public static boolean handleActivityKeyDown(Activity activity, int keyCode, KeyEvent event) {
        if (activity == null || !isArcadeMode(activity)) return false;
        if (event != null && event.getAction() != KeyEvent.ACTION_DOWN) return false;

        // X Button on Gamepad (KEYCODE_BUTTON_X = 99) or Keyboard X (KEYCODE_X = 52)
        if (keyCode == KeyEvent.KEYCODE_BUTTON_X || keyCode == KeyEvent.KEYCODE_X) {
            // First check if game library screen edit button is present & shown
            int chipEditId = ArcadeRes.getId(activity, "platform_library_edit_button");
            View chipEdit = (chipEditId != 0) ? activity.findViewById(chipEditId) : null;
            if (chipEdit != null && chipEdit.isShown()) {
                chipEdit.performClick();
                return true;
            }
            int footerEditId = ArcadeRes.getId(activity, "arcade_btn_action_edit");
            View footerEdit = (footerEditId != 0) ? activity.findViewById(footerEditId) : null;
            if (footerEdit != null && footerEdit.isShown()) {
                footerEdit.performClick();
                return true;
            }

            // Next check if arcade main screen menu button is present & shown
            int optBtnId = ArcadeRes.getId(activity, "arcade_btn_action_x");
            View optBtn = (optBtnId != 0) ? activity.findViewById(optBtnId) : null;
            if (optBtn != null && optBtn.isShown()) {
                optBtn.performClick();
                return true;
            }
        }

        return false;
    }

    public static void styleArcadeDialog(final AlertDialog dialog) {
        if (dialog == null) return;
        try {
            final Context context = dialog.getContext();
            Window window = dialog.getWindow();
            if (window != null) {
                window.setBackgroundDrawable(new ColorDrawable(0));
                View decor = window.getDecorView();
                if (decor != null) {
                    View targetPanel = null;
                    int ppId = context.getResources().getIdentifier("parentPanel", "id", "android");
                    if (ppId != 0) targetPanel = decor.findViewById(ppId);
                    if (targetPanel == null) {
                        int appPpId = context.getResources().getIdentifier("parentPanel", "id", context.getPackageName());
                        if (appPpId != 0) targetPanel = decor.findViewById(appPpId);
                    }
                    if (targetPanel == null) {
                        View content = decor.findViewById(android.R.id.content);
                        if (content instanceof ViewGroup && ((ViewGroup) content).getChildCount() > 0) {
                            targetPanel = ((ViewGroup) content).getChildAt(0);
                        } else {
                            targetPanel = (content != null) ? content : decor;
                        }
                    }

                    int bgId = ArcadeRes.getDrawable(context, "arcade_dialog_bg");
                    if (bgId != 0 && targetPanel != null) {
                        targetPanel.setBackgroundResource(bgId);
                        clearInnerBackgrounds(targetPanel, targetPanel);
                    }
                }
            }
            ListView listView = dialog.getListView();
            if (listView != null) {
                int selId = ArcadeRes.getDrawable(context, "arcade_dialog_item_selector");
                if (selId != 0) {
                    listView.setSelector(selId);
                }
                listView.setDivider(new ColorDrawable(0x338A2BE2));
                listView.setDividerHeight(1);
                listView.setOnHierarchyChangeListener(new ViewGroup.OnHierarchyChangeListener() {
                    @Override
                    public void onChildViewAdded(View parent, View child) {
                        if (child instanceof TextView) {
                            ((TextView) child).setTextColor(0xFFFFFFFF);
                            ((TextView) child).setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);
                        }
                    }
                    @Override
                    public void onChildViewRemoved(View parent, View child) {}
                });
            }
            int titleId = context.getResources().getIdentifier("alertTitle", "id", "android");
            if (titleId == 0) {
                titleId = context.getResources().getIdentifier("alertTitle", "id", context.getPackageName());
            }
            if (titleId != 0) {
                TextView tv = dialog.findViewById(titleId);
                if (tv != null) {
                    tv.setTextColor(0xFFFFFFFF);
                    tv.setTypeface(Typeface.DEFAULT_BOLD);
                }
            }
            int msgId = context.getResources().getIdentifier("message", "id", "android");
            if (msgId == 0) {
                msgId = context.getResources().getIdentifier("message", "id", context.getPackageName());
            }
            if (msgId != 0) {
                TextView tv = dialog.findViewById(msgId);
                if (tv != null) tv.setTextColor(0xFFEEEEEE);
            }
            Button btnPos = dialog.getButton(DialogInterface.BUTTON_POSITIVE);
            if (btnPos != null) {
                btnPos.setTextColor(0xFF8A2BE2);
                btnPos.setTypeface(Typeface.DEFAULT_BOLD);
            }
            Button btnNeg = dialog.getButton(DialogInterface.BUTTON_NEGATIVE);
            if (btnNeg != null) {
                btnNeg.setTextColor(0xFF8A2BE2);
                btnNeg.setTypeface(Typeface.DEFAULT_BOLD);
            }
            Button btnNeu = dialog.getButton(DialogInterface.BUTTON_NEUTRAL);
            if (btnNeu != null) {
                btnNeu.setTextColor(0xFF8A2BE2);
                btnNeu.setTypeface(Typeface.DEFAULT_BOLD);
            }
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    private static void clearInnerBackgrounds(View v, View root) {
        if (v == null) return;
        if (v != root) {
            if (!(v instanceof ListView) && !(v instanceof Button)) {
                v.setBackground(null);
            }
        }
        if (v instanceof ViewGroup) {
            ViewGroup vg = (ViewGroup) v;
            for (int i = 0; i < vg.getChildCount(); i++) {
                clearInnerBackgrounds(vg.getChildAt(i), root);
            }
        }
    }

    public static void safeEditPlayableItem(final androidx.fragment.app.Fragment fragment, final Object itemObj) {
        if (fragment == null || itemObj == null) return;
        final Activity activity = fragment.getActivity();
        if (activity == null || activity.isFinishing()) return;

        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                try {
                    if (activity.isFinishing()) return;
                    if (!(activity instanceof androidx.fragment.app.FragmentActivity)) return;

                    androidx.fragment.app.FragmentActivity fa = (androidx.fragment.app.FragmentActivity) activity;
                    androidx.fragment.app.FragmentManager fm = fa.getSupportFragmentManager();

                    try {
                        Method getLibMethod = fragment.getClass().getMethod("getDaijishouLibrary");
                        Object libModel = getLibMethod.invoke(fragment);
                        if (libModel != null) {
                            Method editMethod = libModel.getClass().getMethod("editPlayableItem", Activity.class, itemObj.getClass());
                            editMethod.invoke(libModel, activity, itemObj);
                            return;
                        }
                    } catch (Throwable t) {
                        t.printStackTrace();
                    }

                    Class<?> dialogClass = Class.forName("com.magneticchen.daijishou.ui.fragments.dialog.EditPlayableItemDialogFragment");
                    Class<?> compClass = Class.forName("com.magneticchen.daijishou.ui.fragments.dialog.EditPlayableItemDialogFragment$Companion");
                    java.lang.reflect.Field compField = dialogClass.getField("Companion");
                    Object companion = compField.get(null);
                    Method newInstance = compClass.getMethod("newInstance", itemObj.getClass());
                    androidx.fragment.app.DialogFragment dialog = (androidx.fragment.app.DialogFragment) newInstance.invoke(companion, itemObj);
                    if (dialog != null) {
                        dialog.show(fm, dialogClass.getName());
                    }
                } catch (Throwable t2) {
                    t2.printStackTrace();
                    try {
                        Toast.makeText(activity, "Não foi possível abrir o editor para este item", Toast.LENGTH_SHORT).show();
                    } catch (Throwable ignored) {}
                }
            }
        });
    }
    public static boolean handleRootBackPressed(Activity activity) {
        if (activity == null || !isArcadeMode(activity)) {
            return false;
        }
        try {
            ArcadeSelectSystemFragment activeArcade = ArcadeSelectSystemFragment.getActiveInstance();
            if (activeArcade != null && activeArcade.isAppsGridOpen()) {
                activeArcade.closeAppsGrid();
                return true;
            }

            // On the root screen of Arcade mode, minimize app to Android Home, avoiding getting stuck in other tabs
            activity.moveTaskToBack(true);
            return true;
        } catch (Throwable t) {
            t.printStackTrace();
        }
        return false;
    }

    public static boolean handleBackPressed(Activity activity) {
        return handleRootBackPressed(activity);
    }

}
