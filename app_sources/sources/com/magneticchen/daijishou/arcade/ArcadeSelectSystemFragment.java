package com.magneticchen.daijishou.arcade;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.preference.PreferenceManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ArcadeSelectSystemFragment extends Fragment implements ArcadeSystemAdapter.OnSystemActionListener {

    private View rootView;
    private ImageView wallpaperView1;
    private ImageView wallpaperView2;
    private View scrimView;
    private TextView headerTitle;
    private TextView headerSubtitle;
    private RecyclerView systemsRecyclerView;
    private View legendBar;
    private ArcadeSystemAdapter adapter;
    private LinearSnapHelper snapHelper;

    private int activeWallpaperIndex = 0;
    private ArcadeItem currentlyFocusedItem = null;
    private boolean isVerticalOrientation = false;
    private final Handler wallpaperDebounceHandler = new Handler(Looper.getMainLooper());

    private final Runnable wallpaperDebounceRunnable = new Runnable() {
        @Override
        public void run() {
            if (currentlyFocusedItem != null) {
                displayWallpaper(currentlyFocusedItem.getWallpaperPath());
            }
        }
    };

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requireActivity().getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                setEnabled(false);
                if (getActivity() != null) {
                    getActivity().onBackPressed();
                }
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Context context = requireContext();
        int layoutId = ArcadeRes.getLayout(context, "fragment_arcade_system_select");
        rootView = inflater.inflate(layoutId, container, false);

        wallpaperView1 = rootView.findViewById(ArcadeRes.getId(context, "arcade_wallpaper_1"));
        wallpaperView2 = rootView.findViewById(ArcadeRes.getId(context, "arcade_wallpaper_2"));
        scrimView = rootView.findViewById(ArcadeRes.getId(context, "arcade_scrim"));
        headerTitle = rootView.findViewById(ArcadeRes.getId(context, "arcade_system_header_title"));
        headerSubtitle = rootView.findViewById(ArcadeRes.getId(context, "arcade_system_header_subtitle"));
        systemsRecyclerView = rootView.findViewById(ArcadeRes.getId(context, "arcade_systems_list"));
        legendBar = rootView.findViewById(ArcadeRes.getId(context, "arcade_legend_bar"));

        // Setup controller legend bar click actions
        View btnA = rootView.findViewById(ArcadeRes.getId(context, "arcade_btn_action_a"));
        View btnB = rootView.findViewById(ArcadeRes.getId(context, "arcade_btn_action_b"));
        View btnX = rootView.findViewById(ArcadeRes.getId(context, "arcade_btn_action_x"));

        if (btnA != null) {
            btnA.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    launchSelectedSystem();
                }
            });
        }
        if (btnB != null) {
            btnB.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (getActivity() != null) {
                        getActivity().onBackPressed();
                    }
                }
            });
        }
        if (btnX != null) {
            btnX.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openArcadeMenu();
                }
            });
        }

        // Determine orientation from preferences
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        String scrollDir = prefs.getString("arcade_scroll_direction", "0");
        isVerticalOrientation = "1".equals(scrollDir);

        setupRecyclerView(isVerticalOrientation);

        // Hardware controller / D-Pad key listener on root view
        rootView.setFocusableInTouchMode(true);
        rootView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN) {
                    if (keyCode == KeyEvent.KEYCODE_BUTTON_A || keyCode == KeyEvent.KEYCODE_DPAD_CENTER || keyCode == KeyEvent.KEYCODE_ENTER) {
                        launchSelectedSystem();
                        return true;
                    }
                    if (keyCode == KeyEvent.KEYCODE_BUTTON_X || keyCode == KeyEvent.KEYCODE_MENU) {
                        openArcadeMenu();
                        return true;
                    }
                }
                return false;
            }
        });

        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loadAndPopulatePlatforms();
    }

    @Override
    public void onResume() {
        super.onResume();
        loadAndPopulatePlatforms();
    }

    private void setupRecyclerView(boolean vertical) {
        Context context = requireContext();
        int orientation = vertical ? LinearLayoutManager.VERTICAL : LinearLayoutManager.HORIZONTAL;
        final LinearLayoutManager layoutManager = new LinearLayoutManager(context, orientation, false);
        systemsRecyclerView.setLayoutManager(layoutManager);

        adapter = new ArcadeSystemAdapter(context, vertical, this);
        systemsRecyclerView.setAdapter(adapter);

        // Center carousel items so the active card snaps to the exact center
        int cardWidth = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 280, getResources().getDisplayMetrics());
        int screenWidth = getResources().getDisplayMetrics().widthPixels;
        int horizontalPadding = Math.max(0, (screenWidth - cardWidth) / 2);
        if (!vertical) {
            systemsRecyclerView.setPadding(horizontalPadding, 0, horizontalPadding, 0);
            systemsRecyclerView.setClipToPadding(false);
        } else {
            int cardHeight = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 120, getResources().getDisplayMetrics());
            int screenHeight = getResources().getDisplayMetrics().heightPixels;
            int verticalPadding = Math.max(0, (screenHeight - cardHeight) / 2);
            systemsRecyclerView.setPadding(0, verticalPadding, 0, verticalPadding);
            systemsRecyclerView.setClipToPadding(false);
        }

        if (snapHelper == null) {
            snapHelper = new LinearSnapHelper();
            snapHelper.attachToRecyclerView(systemsRecyclerView);
        }

        // Adjust RecyclerView constraints for vertical wheel if needed
        ViewGroup.LayoutParams lp = systemsRecyclerView.getLayoutParams();
        if (lp instanceof ConstraintLayout.LayoutParams) {
            ConstraintLayout.LayoutParams clp = (ConstraintLayout.LayoutParams) lp;
            if (vertical) {
                clp.width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 320, getResources().getDisplayMetrics());
                clp.height = 0;
            } else {
                clp.width = 0;
                clp.height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 160, getResources().getDisplayMetrics());
            }
            systemsRecyclerView.setLayoutParams(clp);
        }

        systemsRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView rv, int newState) {
                super.onScrollStateChanged(rv, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    View centerView = snapHelper.findSnapView(layoutManager);
                    if (centerView != null) {
                        int pos = layoutManager.getPosition(centerView);
                        if (pos != RecyclerView.NO_POSITION) {
                            ArcadeItem item = adapter.getItem(pos);
                            if (item != null && item != currentlyFocusedItem) {
                                onSystemFocused(item, pos);
                            }
                        }
                    }
                }
            }
        });
    }

    private void loadAndPopulatePlatforms() {
        Context context = getContext();
        if (context == null) return;

        List<ArcadeItem> items = new ArrayList<>();
        File dbFile = context.getDatabasePath("Daijishou.db");
        android.util.Log.d("ArcadeSelect", "dbFile path: " + dbFile.getAbsolutePath() + ", exists=" + dbFile.exists());
        if (dbFile.exists()) {
            SQLiteDatabase db = null;
            Cursor cursor = null;
            try {
                db = SQLiteDatabase.openDatabase(dbFile.getAbsolutePath(), null, SQLiteDatabase.OPEN_READWRITE);
                Cursor countCursor = db.rawQuery("SELECT count(*) FROM PlatformEntity", null);
                int count = 0;
                if (countCursor != null && countCursor.moveToFirst()) {
                    count = countCursor.getInt(0);
                    countCursor.close();
                }
                android.util.Log.d("ArcadeSelect", "Total rows in PlatformEntity: " + count);

                if (count == 0) {
                    try {
                        db.execSQL("INSERT INTO PlatformEntity (name, shortname, is_visible, scrape_preview_media, accept_filename_regex, default_player_id, player_id_list, scraper_source_list, box_art_aspect_ratio_id, use_custom_box_art_aspect_ratio, screen_aspect_ratio_id, use_custom_screen_aspect_ratio, items_sync_tree_uri_list, retro_achievements_console_id_list, position, extra) VALUES ('Super Nintendo Entertainment System', 'snes', 1, 0, '.*', 0, '[]', '[]', 0, 0, 0, 0, '[]', '[]', 0, '{}')");
                        db.execSQL("INSERT INTO PlatformEntity (name, shortname, is_visible, scrape_preview_media, accept_filename_regex, default_player_id, player_id_list, scraper_source_list, box_art_aspect_ratio_id, use_custom_box_art_aspect_ratio, screen_aspect_ratio_id, use_custom_screen_aspect_ratio, items_sync_tree_uri_list, retro_achievements_console_id_list, position, extra) VALUES ('Game Boy Advance', 'gba', 1, 0, '.*', 0, '[]', '[]', 0, 0, 0, 0, '[]', '[]', 1, '{}')");
                        db.execSQL("INSERT INTO PlatformEntity (name, shortname, is_visible, scrape_preview_media, accept_filename_regex, default_player_id, player_id_list, scraper_source_list, box_art_aspect_ratio_id, use_custom_box_art_aspect_ratio, screen_aspect_ratio_id, use_custom_screen_aspect_ratio, items_sync_tree_uri_list, retro_achievements_console_id_list, position, extra) VALUES ('Sony PlayStation', 'psx', 1, 0, '.*', 0, '[]', '[]', 0, 0, 0, 0, '[]', '[]', 2, '{}')");
                        db.execSQL("INSERT INTO PlatformEntity (name, shortname, is_visible, scrape_preview_media, accept_filename_regex, default_player_id, player_id_list, scraper_source_list, box_art_aspect_ratio_id, use_custom_box_art_aspect_ratio, screen_aspect_ratio_id, use_custom_screen_aspect_ratio, items_sync_tree_uri_list, retro_achievements_console_id_list, position, extra) VALUES ('Sega Genesis', 'genesis', 1, 0, '.*', 0, '[]', '[]', 0, 0, 0, 0, '[]', '[]', 3, '{}')");
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }

                cursor = db.rawQuery(
                    "SELECT id, name, shortname, wallpaper_path, thumbnail_path FROM PlatformEntity WHERE is_visible = 1 ORDER BY shortname COLLATE NOCASE ASC",
                    null
                );
                android.util.Log.d("ArcadeSelect", "Cursor: " + (cursor != null ? cursor.getCount() : "null"));
                if (cursor != null && cursor.moveToFirst()) {
                    do {
                        long id = cursor.getLong(0);
                        String name = cursor.getString(1);
                        String shortname = cursor.getString(2);
                        String wallpaper = cursor.getString(3);
                        String thumbnail = cursor.getString(4);
                        items.add(new ArcadeItem(id, name, shortname, wallpaper, thumbnail, false));
                    } while (cursor.moveToNext());
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (cursor != null) cursor.close();
                if (db != null) db.close();
            }
        }

        // Virtual "Android Apps" System
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        String appsFilter = prefs.getString("arcade_android_apps_filter", "0");
        if (!"2".equals(appsFilter)) { // 2 = disabled
            int titleRes = ArcadeRes.getString(context, "arcade_android_apps_title");
            String appsTitle = (titleRes != 0) ? getString(titleRes) : "Android Apps";
            items.add(new ArcadeItem(-999L, appsTitle, "android", null, null, true));
        }

        adapter.setItems(items);

        if (!items.isEmpty()) {
            long prevId = getSelectedPlatformIdFromVm();
            int targetPos = adapter.getPositionOfPlatform(prevId);
            if (targetPos < 0) targetPos = 0;

            final int initialPos = targetPos;
            systemsRecyclerView.post(new Runnable() {
                @Override
                public void run() {
                    systemsRecyclerView.scrollToPosition(initialPos);
                    ArcadeItem initialItem = adapter.getItem(initialPos);
                    if (initialItem != null) {
                        onSystemFocused(initialItem, initialPos);
                    }
                }
            });
        }
    }

    private long getSelectedPlatformIdFromVm() {
        try {
            Class<? extends androidx.lifecycle.ViewModel> vmClass = Class.forName("com.magneticchen.daijishou.ui.model.LibraryViewModel").asSubclass(androidx.lifecycle.ViewModel.class);
            Object vm = new ViewModelProvider(requireActivity()).get(vmClass);
            Method m = vmClass.getMethod("getSelectedPlatformId");
            Object res = m.invoke(vm);
            if (res instanceof Long) {
                return (Long) res;
            }
        } catch (Throwable ignored) {}
        return -1L;
    }

    private void setSelectedPlatformIdInVm(long id) {
        try {
            Class<? extends androidx.lifecycle.ViewModel> vmClass = Class.forName("com.magneticchen.daijishou.ui.model.LibraryViewModel").asSubclass(androidx.lifecycle.ViewModel.class);
            Object vm = new ViewModelProvider(requireActivity()).get(vmClass);
            Method m = vmClass.getMethod("setSelectedPlatformId", long.class);
            m.invoke(vm, id);
        } catch (Throwable ignored) {}
    }

    @Override
    public void onSystemFocused(ArcadeItem item, int position) {
        this.currentlyFocusedItem = item;

        if (headerTitle != null) {
            headerTitle.setText(item.getName());
        }
        if (headerSubtitle != null) {
            if (item.isAndroidApps()) {
                headerSubtitle.setText("Android Launcher");
            } else {
                headerSubtitle.setText(item.getShortname().toUpperCase());
            }
        }

        wallpaperDebounceHandler.removeCallbacks(wallpaperDebounceRunnable);
        wallpaperDebounceHandler.postDelayed(wallpaperDebounceRunnable, 250);
    }

    @Override
    public void onSystemSelected(ArcadeItem item, int position) {
        this.currentlyFocusedItem = item;
        launchSelectedSystem();
    }

    private void launchSelectedSystem() {
        if (currentlyFocusedItem == null) return;

        if (currentlyFocusedItem.isAndroidApps()) {
            // Switch to Apps tab in MainActivity via navigatePage("apps", null)
            Activity act = getActivity();
            if (act != null) {
                try {
                    Method navMethod = act.getClass().getMethod("navigatePage", String.class, Object.class);
                    navMethod.invoke(act, "apps", null);
                } catch (Throwable t) {
                    t.printStackTrace();
                }
            }
            return;
        }

        // Console platform
        long platformId = currentlyFocusedItem.getId();
        setSelectedPlatformIdInVm(platformId);

        Context context = requireContext();
        SharedPreferences platformPrefs = context.getSharedPreferences(String.valueOf(platformId), Context.MODE_PRIVATE);
        int viewMode = platformPrefs.getInt("view_mode", 1); // 0 = list, 1 = grid (default to grid)

        NavController navController = Navigation.findNavController(rootView);
        int actionGrid = ArcadeRes.getId(context, "arcadeToPlatformLibraryGridViewAction");
        int actionList = ArcadeRes.getId(context, "arcadeToPlatformLibraryListViewAction");

        if (viewMode == 0 && actionList != 0) {
            navController.navigate(actionList);
        } else if (actionGrid != 0) {
            navController.navigate(actionGrid);
        }
    }

    private void displayWallpaper(String wallpaperPath) {
        if (!isAdded() || getContext() == null) return;

        final ImageView incomingView = (activeWallpaperIndex == 0) ? wallpaperView2 : wallpaperView1;
        final ImageView outgoingView = (activeWallpaperIndex == 0) ? wallpaperView1 : wallpaperView2;

        if (wallpaperPath == null || wallpaperPath.isEmpty()) {
            outgoingView.animate().alpha(0.0f).setDuration(250).start();
            return;
        }

        Glide.with(this)
            .load(wallpaperPath)
            .centerCrop()
            .listener(new RequestListener<Drawable>() {
                @Override
                public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                    return false;
                }

                @Override
                public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                    incomingView.setAlpha(0.0f);
                    incomingView.setVisibility(View.VISIBLE);
                    incomingView.bringToFront();
                    scrimView.bringToFront();
                    systemsRecyclerView.bringToFront();
                    legendBar.bringToFront();

                    incomingView.animate()
                        .alpha(1.0f)
                        .setDuration(300)
                        .withEndAction(new Runnable() {
                            @Override
                            public void run() {
                                outgoingView.setVisibility(View.INVISIBLE);
                                outgoingView.setAlpha(0.0f);
                                activeWallpaperIndex = (activeWallpaperIndex == 0) ? 1 : 0;
                            }
                        })
                        .start();
                    return false;
                }
            })
            .into(incomingView);
    }

    private void openArcadeMenu() {
        Context context = getContext();
        if (context == null) return;

        CharSequence[] options = new CharSequence[] {
            "Configurações de Aparência",
            "Configurações Gerais",
            "Alternar Orientação (Horizontal / Vertical)",
            "Recarregar Sistemas"
        };

        new AlertDialog.Builder(context)
            .setTitle("Menu Arcade")
            .setItems(options, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    if (which == 0 || which == 1) {
                        Activity act = getActivity();
                        if (act != null) {
                            try {
                                Method navMethod = act.getClass().getMethod("navigatePage", String.class, Object.class);
                                navMethod.invoke(act, "settings", null);
                            } catch (Throwable t) {
                                t.printStackTrace();
                            }
                        }
                    } else if (which == 2) {
                        toggleOrientation();
                    } else if (which == 3) {
                        loadAndPopulatePlatforms();
                    }
                }
            })
            .setNegativeButton("Fechar", null)
            .show();
    }

    private void toggleOrientation() {
        Context context = getContext();
        if (context == null) return;
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        isVerticalOrientation = !isVerticalOrientation;
        prefs.edit().putString("arcade_scroll_direction", isVerticalOrientation ? "1" : "0").apply();
        setupRecyclerView(isVerticalOrientation);
        loadAndPopulatePlatforms();
    }
}
