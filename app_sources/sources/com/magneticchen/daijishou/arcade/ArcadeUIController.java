package com.magneticchen.daijishou.arcade;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
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
                    if (coordinator != null) coordinator.setVisibility(visibility);
                    if (logger != null) {
                        logger.setVisibility(View.GONE);
                    }

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
        Context context = rootView.getContext();
        boolean arcade = isArcadeMode(context);

        int barId = ArcadeRes.getId(context, "arcade_legend_bar");
        final View legendBar = (barId != 0) ? rootView.findViewById(barId) : null;
        if (legendBar != null) {
            legendBar.setVisibility(arcade ? View.VISIBLE : View.GONE);
        }

        if (!arcade) return;

        // Button A: Play game
        int btnAId = ArcadeRes.getId(context, "arcade_btn_action_a");
        View btnA = (btnAId != 0) ? rootView.findViewById(btnAId) : null;
        if (btnA != null) {
            btnA.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int playId = ArcadeRes.getId(rootView.getContext(), "platform_library_play_button");
                    View playBtn = (playId != 0) ? rootView.findViewById(playId) : null;
                    if (playBtn != null && playBtn.getVisibility() == View.VISIBLE) {
                        playBtn.performClick();
                    }
                }
            });
        }

        // Button B: Back to Arcade system select
        int btnBId = ArcadeRes.getId(context, "arcade_btn_action_b");
        View btnB = (btnBId != 0) ? rootView.findViewById(btnBId) : null;
        if (btnB != null) {
            btnB.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (fragment.getActivity() != null) {
                        fragment.getActivity().onBackPressed();
                    }
                }
            });
        }

        // Button X: Game Options / Details
        int btnXId = ArcadeRes.getId(context, "arcade_btn_action_x");
        View btnX = (btnXId != 0) ? rootView.findViewById(btnXId) : null;
        if (btnX != null) {
            btnX.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int detailId = ArcadeRes.getId(rootView.getContext(), "platform_library_detail_button");
                    View detailBtn = (detailId != 0) ? rootView.findViewById(detailId) : null;
                    if (detailBtn != null && detailBtn.getVisibility() == View.VISIBLE) {
                        detailBtn.performClick();
                        return;
                    }
                    int editId = ArcadeRes.getId(rootView.getContext(), "platform_library_edit_button");
                    View editBtn = (editId != 0) ? rootView.findViewById(editId) : null;
                    if (editBtn != null) {
                        editBtn.performClick();
                    }
                }
            });
        }
    }

    public static void styleArcadeDialog(final AlertDialog dialog) {
        if (dialog == null) return;
        try {
            Context context = dialog.getContext();
            Window window = dialog.getWindow();
            if (window != null) {
                int bgId = ArcadeRes.getDrawable(context, "arcade_dialog_bg");
                if (bgId != 0) {
                    window.setBackgroundDrawableResource(bgId);
                }
            }
            ListView listView = dialog.getListView();
            if (listView != null) {
                int selId = ArcadeRes.getDrawable(context, "arcade_dialog_item_selector");
                if (selId != 0) {
                    listView.setSelector(selId);
                }
            }
            int titleId = context.getResources().getIdentifier("alertTitle", "id", "android");
            if (titleId != 0) {
                TextView tv = dialog.findViewById(titleId);
                if (tv != null) tv.setTextColor(0xFFFFFFFF);
            }
            int msgId = context.getResources().getIdentifier("message", "id", "android");
            if (msgId != 0) {
                TextView tv = dialog.findViewById(msgId);
                if (tv != null) tv.setTextColor(0xFFEEEEEE);
            }
            Button btnPos = dialog.getButton(DialogInterface.BUTTON_POSITIVE);
            if (btnPos != null) btnPos.setTextColor(0xFF9C27B0);
            Button btnNeg = dialog.getButton(DialogInterface.BUTTON_NEGATIVE);
            if (btnNeg != null) btnNeg.setTextColor(0xFF9C27B0);
            Button btnNeu = dialog.getButton(DialogInterface.BUTTON_NEUTRAL);
            if (btnNeu != null) btnNeu.setTextColor(0xFF9C27B0);
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
}
