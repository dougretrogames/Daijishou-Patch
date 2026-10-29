package com.magneticchen.daijishou.arcade;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
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
import androidx.recyclerview.widget.GridLayoutManager;
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
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ArcadeSelectSystemFragment extends Fragment implements ArcadeSystemAdapter.OnSystemActionListener, ArcadeAppAdapter.OnAppActionListener {

    private View rootView;
    private ImageView wallpaperView1;
    private ImageView wallpaperView2;
    private View scrimView;
    private View headerLayout;
    private TextView headerTitle;
    private TextView headerSubtitle;
    private RecyclerView systemsRecyclerView;
    private View legendBar;
    private TextView legendMenuText;
    private TextView legendSelectText;
    private TextView legendBackText;

    // Embedded Apps UI
    private View appsContainer;
    private RecyclerView appsRecyclerView;
    private ProgressBar appsLoading;
    private TextView appsCountText;
    private ArcadeAppAdapter appAdapter;
    private boolean isAppsGridOpen = false;
    private List<ArcadeAppItem> cachedAppList = null;

    private ArcadeSystemAdapter adapter;
    private LinearSnapHelper snapHelper;

    private int activeWallpaperIndex = 0;
    private ArcadeItem currentlyFocusedItem = null;
    private boolean isVerticalOrientation = true;
    private final Handler wallpaperDebounceHandler = new Handler(Looper.getMainLooper());

    private final Runnable wallpaperDebounceRunnable = new Runnable() {
        @Override
        public void run() {
            if (currentlyFocusedItem != null) {
                displayWallpaper(resolveWallpaperPath(currentlyFocusedItem));
            }
        }
    };

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requireActivity().getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                if (isAppsGridOpen) {
                    closeAppsGrid();
                    return;
                }
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
        headerLayout = rootView.findViewById(ArcadeRes.getId(context, "arcade_header_layout"));
        headerTitle = rootView.findViewById(ArcadeRes.getId(context, "arcade_system_header_title"));
        headerSubtitle = rootView.findViewById(ArcadeRes.getId(context, "arcade_system_header_subtitle"));
        systemsRecyclerView = rootView.findViewById(ArcadeRes.getId(context, "arcade_systems_list"));
        legendBar = rootView.findViewById(ArcadeRes.getId(context, "arcade_legend_bar"));

        legendMenuText = rootView.findViewById(ArcadeRes.getId(context, "arcade_legend_menu_text"));
        legendSelectText = rootView.findViewById(ArcadeRes.getId(context, "arcade_legend_select_text"));
        legendBackText = rootView.findViewById(ArcadeRes.getId(context, "arcade_legend_back_text"));

        // Setup embedded Apps UI
        appsContainer = rootView.findViewById(ArcadeRes.getId(context, "arcade_apps_container"));
        appsRecyclerView = rootView.findViewById(ArcadeRes.getId(context, "arcade_apps_list"));
        appsLoading = rootView.findViewById(ArcadeRes.getId(context, "arcade_apps_loading"));
        appsCountText = rootView.findViewById(ArcadeRes.getId(context, "arcade_apps_count"));

        setupAppsRecyclerView();

        // Setup controller legend bar click actions
        View btnX = rootView.findViewById(ArcadeRes.getId(context, "arcade_btn_action_x"));
        View btnA = rootView.findViewById(ArcadeRes.getId(context, "arcade_btn_action_a"));
        View btnB = rootView.findViewById(ArcadeRes.getId(context, "arcade_btn_action_b"));

        if (btnX != null) {
            btnX.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openArcadeMenu();
                }
            });
        }
        if (btnA != null) {
            btnA.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isAppsGridOpen) {
                        // Launch app from click handled by item listener
                    } else {
                        launchSelectedSystem();
                    }
                }
            });
        }
        if (btnB != null) {
            btnB.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isAppsGridOpen) {
                        closeAppsGrid();
                    } else if (getActivity() != null) {
                        getActivity().onBackPressed();
                    }
                }
            });
        }

        // Determine orientation from preferences
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        String scrollDir = prefs.getString("arcade_scroll_direction", "1"); // Default to 1 (Vertical) matching reference
        isVerticalOrientation = "1".equals(scrollDir);

        setupRecyclerView(isVerticalOrientation);

        // Hardware controller / D-Pad key listener on root view
        rootView.setFocusableInTouchMode(true);
        rootView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN) {
                    if (keyCode == KeyEvent.KEYCODE_BUTTON_B || keyCode == KeyEvent.KEYCODE_BACK) {
                        if (isAppsGridOpen) {
                            closeAppsGrid();
                            return true;
                        }
                    }
                    if (keyCode == KeyEvent.KEYCODE_BUTTON_A || keyCode == KeyEvent.KEYCODE_DPAD_CENTER || keyCode == KeyEvent.KEYCODE_ENTER) {
                        if (!isAppsGridOpen) {
                            launchSelectedSystem();
                            return true;
                        }
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
        Activity act = getActivity();
        if (act != null) {
            ArcadeUIController.applyUIMode(act);
        }
        loadAndPopulatePlatforms();
    }

    private void setupAppsRecyclerView() {
        Context context = requireContext();
        int spanCount = getResources().getConfiguration().orientation == android.content.res.Configuration.ORIENTATION_LANDSCAPE ? 6 : 4;
        GridLayoutManager glm = new GridLayoutManager(context, spanCount);
        appsRecyclerView.setLayoutManager(glm);

        appAdapter = new ArcadeAppAdapter(context, this);
        appsRecyclerView.setAdapter(appAdapter);
    }

    private void setupRecyclerView(final boolean vertical) {
        Context context = requireContext();
        int orientation = vertical ? LinearLayoutManager.VERTICAL : LinearLayoutManager.HORIZONTAL;
        final LinearLayoutManager layoutManager = new LinearLayoutManager(context, orientation, false);
        systemsRecyclerView.setLayoutManager(layoutManager);

        adapter = new ArcadeSystemAdapter(context, vertical, this);
        systemsRecyclerView.setAdapter(adapter);

        final float density = getResources().getDisplayMetrics().density;
        final int screenWidth = getResources().getDisplayMetrics().widthPixels;

        // In vertical mode, hide the top center header to keep clean artwork
        if (headerLayout != null) {
            headerLayout.setVisibility(vertical ? View.GONE : View.VISIBLE);
        }

        // Adjust RecyclerView constraints for vertical wheel vs horizontal carousel
        ViewGroup.LayoutParams lp = systemsRecyclerView.getLayoutParams();
        if (lp instanceof ConstraintLayout.LayoutParams) {
            ConstraintLayout.LayoutParams clp = (ConstraintLayout.LayoutParams) lp;
            if (vertical) {
                // Align right ~35% screen width, matching user reference image
                clp.width = (int) (310 * density);
                clp.height = 0;
                clp.topToTop = ConstraintLayout.LayoutParams.PARENT_ID;
                if (legendBar != null) {
                    clp.bottomToTop = legendBar.getId();
                } else {
                    clp.bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID;
                }
                clp.endToEnd = ConstraintLayout.LayoutParams.PARENT_ID;
                clp.startToStart = ConstraintLayout.LayoutParams.UNSET;
                clp.rightMargin = (int) (36 * density);
                clp.leftMargin = 0;
            } else {
                clp.width = 0;
                clp.height = (int) (160 * density);
                clp.topToTop = ConstraintLayout.LayoutParams.UNSET;
                clp.bottomToBottom = ConstraintLayout.LayoutParams.UNSET;
                if (headerLayout != null) {
                    clp.topToBottom = headerLayout.getId();
                }
                if (legendBar != null) {
                    clp.bottomToTop = legendBar.getId();
                }
                clp.startToStart = ConstraintLayout.LayoutParams.PARENT_ID;
                clp.endToEnd = ConstraintLayout.LayoutParams.PARENT_ID;
                clp.rightMargin = 0;
                clp.leftMargin = 0;
            }
            systemsRecyclerView.setLayoutParams(clp);
        }

        systemsRecyclerView.post(new Runnable() {
            @Override
            public void run() {
                if (!isAdded()) return;
                if (!vertical) {
                    int cardWidth = (int) (260 * density);
                    int horizontalPadding = Math.max(0, (screenWidth - cardWidth) / 2);
                    systemsRecyclerView.setPadding(horizontalPadding, 0, horizontalPadding, 0);
                } else {
                    int rvHeight = systemsRecyclerView.getHeight();
                    int cardHeight = (int) (110 * density);
                    int verticalPadding = Math.max(0, (rvHeight - cardHeight) / 2);
                    systemsRecyclerView.setPadding(0, verticalPadding, 0, verticalPadding);
                }
                systemsRecyclerView.setClipToPadding(false);
            }
        });

        if (snapHelper == null) {
            snapHelper = new LinearSnapHelper();
            snapHelper.attachToRecyclerView(systemsRecyclerView);
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
                            adapter.setSelectedPosition(pos);
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

        // Virtual "Coleções" (matching user's reference image!)
        items.add(new ArcadeItem(-997L, "Coleções", "collections", null, null, false));

        // Virtual "TODOS OS JOGOS" system item (matching user's reference image!)
        items.add(new ArcadeItem(-998L, "Todos os Jogos", "all_games", null, null, false));

        File dbFile = context.getDatabasePath("Daijishou.db");
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

        // Virtual "Android Apps" System (alongside retro systems as requested by user)
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        String appsFilter = prefs.getString("arcade_android_apps_filter", "0");
        if (!"2".equals(appsFilter)) { // 2 = disabled
            int titleRes = ArcadeRes.getString(context, "arcade_android_apps_title");
            String appsTitle = (titleRes != 0) ? getString(titleRes) : "Apps";
            items.add(new ArcadeItem(-999L, appsTitle, "android", null, null, true));
        }

        // Virtual "Configurações" System (matching user's request for Tools / clearlogo_tools.png)
        items.add(new ArcadeItem(-996L, "Configurações", "tools", null, null, false));

        adapter.setItems(items);

        if (!items.isEmpty()) {
            long prevId = getSelectedPlatformIdFromVm();
            int targetPos = adapter.getPositionOfPlatform(prevId);
            if (targetPos < 0) {
                targetPos = (items.size() > 1) ? 1 : 0; // Default to "Todos os Jogos"
            }

            final int initialPos = targetPos;
            systemsRecyclerView.post(new Runnable() {
                @Override
                public void run() {
                    systemsRecyclerView.scrollToPosition(initialPos);
                    adapter.setSelectedPosition(initialPos);
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
            } else if (item.getId() == -998L) {
                headerSubtitle.setText("Biblioteca Completa");
            } else if (item.getId() == -997L) {
                headerSubtitle.setText("Coleções Especiais");
            } else if (item.getId() == -996L) {
                headerSubtitle.setText("Configurações do Sistema");
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

        // When "Configurações" / Tools is selected, immediately open Settings!
        if (currentlyFocusedItem.getId() == -996L || "tools".equalsIgnoreCase(currentlyFocusedItem.getShortname())) {
            Activity act = getActivity();
            if (act != null) {
                try {
                    Method navMethod = act.getClass().getMethod("navigatePage", String.class, Object.class);
                    navMethod.invoke(act, "settings", null);
                } catch (Throwable t) {
                    t.printStackTrace();
                }
            }
            return;
        }

        // When "Coleções" is selected, open collections dialog
        if (currentlyFocusedItem.getId() == -997L || "collections".equalsIgnoreCase(currentlyFocusedItem.getShortname())) {
            openCollectionsDialog();
            return;
        }

        // When "Apps" system is selected, open embedded Apps Grid right inside Arcade!
        if (currentlyFocusedItem.isAndroidApps()) {
            openAppsGrid();
            return;
        }

        // Console platform or All Games
        long platformId = currentlyFocusedItem.getId();
        if (platformId == -998L) {
            // First console if available
            if (adapter.getItemCount() > 2) {
                ArcadeItem firstConsole = adapter.getItem(1);
                if (firstConsole != null && !firstConsole.isAndroidApps()) {
                    platformId = firstConsole.getId();
                }
            }
        }

        setSelectedPlatformIdInVm(platformId);

        Context context = requireContext();
        SharedPreferences platformPrefs = context.getSharedPreferences(String.valueOf(platformId), Context.MODE_PRIVATE);
        int viewMode = platformPrefs.getInt("view_mode", 1); // default to grid

        NavController navController = Navigation.findNavController(rootView);
        int actionGrid = ArcadeRes.getId(context, "arcadeToPlatformLibraryGridViewAction");
        int actionList = ArcadeRes.getId(context, "arcadeToPlatformLibraryListViewAction");

        if (viewMode == 0 && actionList != 0) {
            navController.navigate(actionList);
        } else if (actionGrid != 0) {
            navController.navigate(actionGrid);
        }
    }

    private void openCollectionsDialog() {
        Context context = getContext();
        if (context == null) return;
        final String[] collections = new String[] {
            "Alex Kidd", "Art of Fighting", "Batman", "Bomberman",
            "Castlevania", "Crash Bandicoot", "Dragon Ball Z", "Donkey Kong",
            "Double Dragon", "Fatal Fury", "Final Fight", "Kirby",
            "The King of Fighters", "Mario", "Marvel", "Mega Man",
            "Metal Slug", "Mortal Kombat", "Pac-Man", "Pokémon",
            "Resident Evil", "Samurai Shodown", "Sonic", "Spider-Man",
            "Street Fighter", "Streets of Rage", "TMNT", "The Legend of Zelda"
        };
        new AlertDialog.Builder(context)
            .setTitle("Coleções")
            .setItems(collections, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    try {
                        Class<?> searchClass = Class.forName("com.magneticchen.daijishou.ui.fragments.dialog.SearchPlayableItemDialogFragment");
                        Class<?> companionClass = Class.forName("com.magneticchen.daijishou.ui.fragments.dialog.SearchPlayableItemDialogFragment$Companion");
                        java.lang.reflect.Field compField = searchClass.getField("Companion");
                        Object companion = compField.get(null);
                        Method newInst = companionClass.getMethod("newInstance");
                        androidx.fragment.app.DialogFragment dFrag = (androidx.fragment.app.DialogFragment) newInst.invoke(companion);
                        dFrag.show(getParentFragmentManager(), "SearchPlayableItemDialogFragment");
                    } catch (Throwable t) {
                        t.printStackTrace();
                    }
                }
            })
            .setNegativeButton("Fechar", null)
            .show();
    }

    // --- Embedded Android Apps Grid ---
    private void openAppsGrid() {
        isAppsGridOpen = true;

        if (headerLayout != null) headerLayout.setVisibility(View.GONE);
        if (systemsRecyclerView != null) systemsRecyclerView.setVisibility(View.GONE);

        if (appsContainer != null) {
            appsContainer.setAlpha(0f);
            appsContainer.setVisibility(View.VISIBLE);
            appsContainer.animate().alpha(1f).setDuration(220).start();
        }

        if (legendSelectText != null) legendSelectText.setText("INICIAR");
        if (legendBackText != null) legendBackText.setText("VOLTAR");
        if (legendMenuText != null) legendMenuText.setText("OPÇÕES");

        loadInstalledApps();
    }

    private void closeAppsGrid() {
        isAppsGridOpen = false;

        if (appsContainer != null) {
            appsContainer.animate().alpha(0f).setDuration(180).withEndAction(new Runnable() {
                @Override
                public void run() {
                    appsContainer.setVisibility(View.GONE);
                }
            }).start();
        }

        if (headerLayout != null) {
            headerLayout.setVisibility(isVerticalOrientation ? View.GONE : View.VISIBLE);
        }
        if (systemsRecyclerView != null) {
            systemsRecyclerView.setVisibility(View.VISIBLE);
            systemsRecyclerView.requestFocus();
        }

        if (legendSelectText != null) legendSelectText.setText(getString(ArcadeRes.getString(requireContext(), "arcade_legend_select")));
        if (legendBackText != null) legendBackText.setText(getString(ArcadeRes.getString(requireContext(), "arcade_legend_back")));
        if (legendMenuText != null) legendMenuText.setText(getString(ArcadeRes.getString(requireContext(), "arcade_legend_menu")));
    }

    private void loadInstalledApps() {
        if (cachedAppList != null && !cachedAppList.isEmpty()) {
            appAdapter.setItems(cachedAppList);
            if (appsCountText != null) {
                appsCountText.setText(cachedAppList.size() + " aplicativos");
            }
            appsRecyclerView.post(new Runnable() {
                @Override
                public void run() {
                    appsRecyclerView.requestFocus();
                }
            });
            return;
        }

        if (appsLoading != null) appsLoading.setVisibility(View.VISIBLE);

        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                Context ctx = getContext();
                if (ctx == null) return;

                PackageManager pm = ctx.getPackageManager();
                Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
                mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);

                List<ResolveInfo> resolved = pm.queryIntentActivities(mainIntent, 0);
                final List<ArcadeAppItem> list = new ArrayList<>();

                String myPackage = ctx.getPackageName();
                for (ResolveInfo ri : resolved) {
                    if (ri.activityInfo != null && !myPackage.equals(ri.activityInfo.packageName)) {
                        String pkg = ri.activityInfo.packageName;
                        String act = ri.activityInfo.name;
                        CharSequence labelSeq = ri.loadLabel(pm);
                        String label = (labelSeq != null) ? labelSeq.toString() : pkg;
                        Drawable icon = ri.loadIcon(pm);
                        list.add(new ArcadeAppItem(pkg, act, label, icon));
                    }
                }

                Collections.sort(list, new Comparator<ArcadeAppItem>() {
                    @Override
                    public int compare(ArcadeAppItem o1, ArcadeAppItem o2) {
                        return o1.getLabel().compareToIgnoreCase(o2.getLabel());
                    }
                });

                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        if (!isAdded()) return;
                        cachedAppList = list;
                        if (appsLoading != null) appsLoading.setVisibility(View.GONE);
                        appAdapter.setItems(list);
                        if (appsCountText != null) {
                            appsCountText.setText(list.size() + " aplicativos");
                        }
                        appsRecyclerView.post(new Runnable() {
                            @Override
                            public void run() {
                                appsRecyclerView.requestFocus();
                            }
                        });
                    }
                });
            }
        });
    }

    @Override
    public void onAppClick(ArcadeAppItem item, int position) {
        Context context = getContext();
        if (context == null || item == null) return;
        try {
            Intent launchIntent = new Intent(Intent.ACTION_MAIN);
            launchIntent.addCategory(Intent.CATEGORY_LAUNCHER);
            launchIntent.setComponent(new ComponentName(item.getPackageName(), item.getActivityName()));
            launchIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
            context.startActivity(launchIntent);
        } catch (Exception e) {
            e.printStackTrace();
            try {
                Intent fallback = context.getPackageManager().getLaunchIntentForPackage(item.getPackageName());
                if (fallback != null) {
                    fallback.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(fallback);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void onAppFocused(ArcadeAppItem item, int position) {
        // App focus changed in grid
    }

    private String resolveWallpaperPath(ArcadeItem item) {
        if (item == null) return null;
        Context context = getContext();
        if (context == null) return item.getWallpaperPath();

        File storage = android.os.Environment.getExternalStorageDirectory();

        // 1. Special collections / virtual items from 2-Jogos
        if (item.getId() == -998L || "all_games".equalsIgnoreCase(item.getShortname())) {
            File f = new File(storage, "2-Jogos/background_allsystems.png");
            if (f.exists()) return f.getAbsolutePath();
            File fJpg = new File(storage, "2-Jogos/background_allsystems.jpg");
            if (fJpg.exists()) return fJpg.getAbsolutePath();
        }

        if (item.isAndroidApps() || item.getId() == -999L || "android".equalsIgnoreCase(item.getShortname()) || "apps".equalsIgnoreCase(item.getShortname())) {
            File f1 = new File(storage, "2-Jogos/apps/media/background.png");
            if (f1.exists()) return f1.getAbsolutePath();
            File f1Jpg = new File(storage, "2-Jogos/apps/media/background.jpg");
            if (f1Jpg.exists()) return f1Jpg.getAbsolutePath();
            File f2 = new File(storage, "2-Jogos/background_apps.png");
            if (f2.exists()) return f2.getAbsolutePath();
        }

        if (item.getId() == -996L || "tools".equalsIgnoreCase(item.getShortname()) || "settings".equalsIgnoreCase(item.getShortname())) {
            File f = new File(storage, "2-Jogos/background_tools.png");
            if (f.exists()) return f.getAbsolutePath();
            File fJpg = new File(storage, "2-Jogos/background_tools.jpg");
            if (fJpg.exists()) return fJpg.getAbsolutePath();
        }

        if (item.getId() == -997L || "collections".equalsIgnoreCase(item.getShortname()) || "colecoes".equalsIgnoreCase(item.getShortname())) {
            File f = new File(storage, "2-Jogos/background_collections.png");
            if (f.exists()) return f.getAbsolutePath();
            File fJpg = new File(storage, "2-Jogos/background_collections.jpg");
            if (fJpg.exists()) return fJpg.getAbsolutePath();
        }

        // 2. 2-Jogos system backgrounds: 2-Jogos/{shortname}/media/background.png
        if (item.getShortname() != null) {
            String[] aliases = getShortnameAliases(item.getShortname());
            for (String alias : aliases) {
                File f = new File(storage, "2-Jogos" + File.separator + alias + File.separator + "media" + File.separator + "background.png");
                if (f.exists()) return f.getAbsolutePath();
                File fJpg = new File(storage, "2-Jogos" + File.separator + alias + File.separator + "media" + File.separator + "background.jpg");
                if (fJpg.exists()) return fJpg.getAbsolutePath();
                File fBg = new File(storage, "2-Jogos" + File.separator + "background_" + alias + ".png");
                if (fBg.exists()) return fBg.getAbsolutePath();
                File fColBg = new File(storage, "2-Jogos" + File.separator + "collection_" + alias + "_background.png");
                if (fColBg.exists()) return fColBg.getAbsolutePath();
            }
        }

        // 3. Explicit path assigned to the item
        String path = item.getWallpaperPath();
        if (path != null && !path.trim().isEmpty()) {
            try {
                if (path.startsWith("file://")) {
                    File f = new File(java.net.URI.create(path).getPath());
                    if (f.exists()) return f.getAbsolutePath();
                } else if (path.startsWith("/")) {
                    File f = new File(path);
                    if (f.exists()) return f.getAbsolutePath();
                } else {
                    return path;
                }
            } catch (Exception ignored) {
                return path;
            }
        }

        // 4. Check platform_wallpapers in app internal storage (by id or shortname)
        try {
            File internalDir = new File(context.getFilesDir(), "platform_wallpapers");
            if (internalDir.exists() && internalDir.isDirectory()) {
                if (item.getId() > 0) {
                    File byIdPng = new File(internalDir, item.getId() + ".png");
                    if (byIdPng.exists()) return byIdPng.getAbsolutePath();
                    File byIdJpg = new File(internalDir, item.getId() + ".jpg");
                    if (byIdJpg.exists()) return byIdJpg.getAbsolutePath();
                }
                if (item.getShortname() != null) {
                    File bySnPng = new File(internalDir, item.getShortname() + ".png");
                    if (bySnPng.exists()) return bySnPng.getAbsolutePath();
                    File bySnJpg = new File(internalDir, item.getShortname() + ".jpg");
                    if (bySnJpg.exists()) return bySnJpg.getAbsolutePath();
                }
            }
        } catch (Exception ignored) {}

        // 5. Check external storage /sdcard/Daijishou/wallpapers/
        try {
            File extDir = new File(storage, "Daijishou/wallpapers");
            if (extDir.exists() && item.getShortname() != null) {
                File extPng = new File(extDir, item.getShortname() + ".png");
                if (extPng.exists()) return extPng.getAbsolutePath();
                File extJpg = new File(extDir, item.getShortname() + ".jpg");
                if (extJpg.exists()) return extJpg.getAbsolutePath();
            }
        } catch (Exception ignored) {}

        // 6. Default background from 2-Jogos
        File default2Jogos = new File(storage, "2-Jogos/default_background.png");
        if (default2Jogos.exists()) {
            return default2Jogos.getAbsolutePath();
        }

        // 7. Global Daijishou wallpaper fallback
        try {
            File globalWp = new File(context.getFilesDir(), "wallpaper");
            if (globalWp.exists()) {
                return globalWp.getAbsolutePath();
            }
        } catch (Exception ignored) {}

        return null;
    }

    private String[] getShortnameAliases(String shortname) {
        String sn = shortname.toLowerCase();
        if ("genesis".equals(sn) || "megadrive".equals(sn)) {
            return new String[]{sn, "genesis", "megadrive"};
        }
        if ("gc".equals(sn) || "gamecube".equals(sn)) {
            return new String[]{sn, "gc", "gamecube"};
        }
        if ("master".equals(sn) || "mastersystem".equals(sn)) {
            return new String[]{sn, "master", "mastersystem"};
        }
        if ("tg16".equals(sn) || "pce".equals(sn) || "pcengine".equals(sn)) {
            return new String[]{sn, "pcengine", "tg16", "pce"};
        }
        if ("tgcd".equals(sn) || "pcecd".equals(sn) || "pcenginecd".equals(sn)) {
            return new String[]{sn, "pcenginecd", "tgcd", "pcecd"};
        }
        if ("coleco".equals(sn) || "colecovision".equals(sn)) {
            return new String[]{sn, "colecovision", "coleco"};
        }
        if ("wsc".equals(sn) || "ws".equals(sn) || "wswanc".equals(sn)) {
            return new String[]{sn, "wswanc", "wsc", "ws"};
        }
        if ("arcade".equals(sn) || "mame".equals(sn) || "fbneo".equals(sn)) {
            return new String[]{sn, "arcade", "mame", "fbneo"};
        }
        if ("android".equals(sn) || "apps".equals(sn)) {
            return new String[]{sn, "apps", "android"};
        }
        return new String[]{sn};
    }

    private void displayWallpaper(String wallpaperPath) {
        if (!isAdded() || getContext() == null) return;

        final ImageView incomingView = (activeWallpaperIndex == 0) ? wallpaperView2 : wallpaperView1;
        final ImageView outgoingView = (activeWallpaperIndex == 0) ? wallpaperView1 : wallpaperView2;

        incomingView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        outgoingView.setScaleType(ImageView.ScaleType.CENTER_CROP);

        if (wallpaperPath == null || wallpaperPath.isEmpty()) {
            outgoingView.animate().alpha(0.0f).setDuration(250).start();
            return;
        }

        Glide.with(this)
            .load(wallpaperPath)
            .centerCrop()
            .dontAnimate()
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
                    if (appsContainer != null) appsContainer.bringToFront();
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

        int strSwitch = ArcadeRes.getString(context, "arcade_menu_switch_to_mobile");
        int strAppearance = ArcadeRes.getString(context, "arcade_menu_appearance");
        int strSettings = ArcadeRes.getString(context, "arcade_menu_settings");
        int strOrientation = ArcadeRes.getString(context, "arcade_menu_toggle_orientation");
        int strReload = ArcadeRes.getString(context, "arcade_menu_reload_systems");
        int strMenuTitle = ArcadeRes.getString(context, "arcade_menu_title");
        int strClose = ArcadeRes.getString(context, "arcade_menu_close");

        CharSequence[] options = new CharSequence[] {
            (strSwitch != 0) ? getString(strSwitch) : "Alternar para Interface Mobile (Original)",
            "Baixar Pacote de Clearlogos (GitHub)",
            "Baixar Temas e Papéis de Parede (GitHub)",
            "Baixar Pacotes de Miniaturas (GitHub)",
            (strAppearance != 0) ? getString(strAppearance) : "Configurações de Aparência",
            (strSettings != 0) ? getString(strSettings) : "Configurações Gerais",
            (strOrientation != 0) ? getString(strOrientation) : "Alternar Orientação (Horizontal / Vertical)",
            (strReload != 0) ? getString(strReload) : "Recarregar Sistemas"
        };

        new AlertDialog.Builder(context)
            .setTitle((strMenuTitle != 0) ? getString(strMenuTitle) : "Menu Arcade")
            .setItems(options, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    if (which == 0) {
                        // Switch to Mobile Interface (Original)
                        ArcadeUIController.setInterfaceMode(context, "original");
                        Activity act = getActivity();
                        if (act != null) {
                            ArcadeUIController.applyUIMode(act);
                            act.recreate();
                        }
                    } else if (which == 1) {
                        // Directly download Clearlogos pack from GitHub
                        try {
                            Class<?> dfClass = Class.forName("com.magneticchen.daijishou.ui.fragments.dialog.DownloadPlatformThumbnailsPackDialogFragment");
                            Class<?> companionClass = Class.forName("com.magneticchen.daijishou.ui.fragments.dialog.DownloadPlatformThumbnailsPackDialogFragment$Companion");
                            java.lang.reflect.Field compField = dfClass.getField("Companion");
                            Object companion = compField.get(null);
                            Method newInst = companionClass.getMethod("newInstance", String.class);
                            String clearlogosUrl = "https://raw.githubusercontent.com/dougretrogames/Daijishou-Patch/main/themes/platform_thumbnails_packs/clearlogos/";
                            androidx.fragment.app.DialogFragment dFrag = (androidx.fragment.app.DialogFragment) newInst.invoke(companion, clearlogosUrl);
                            dFrag.show(getParentFragmentManager(), "DownloadPlatformThumbnailsPackDialogFragment");
                        } catch (Throwable t) {
                            t.printStackTrace();
                        }
                    } else if (which == 2) {
                        // Download Wallpapers / Themes
                        try {
                            Class<?> dfClass = Class.forName("com.magneticchen.daijishou.ui.fragments.dialog.DownloadPlatformWallpapersPackListDialogFragment");
                            androidx.fragment.app.DialogFragment dFrag = (androidx.fragment.app.DialogFragment) dfClass.newInstance();
                            dFrag.show(getParentFragmentManager(), "DownloadPlatformWallpapersPackListDialogFragment");
                        } catch (Throwable t) {
                            t.printStackTrace();
                        }
                    } else if (which == 3) {
                        // Download Thumbnails list
                        try {
                            Class<?> dfClass = Class.forName("com.magneticchen.daijishou.ui.fragments.dialog.DownloadPlatformThumbnailsPackListDialogFragment");
                            androidx.fragment.app.DialogFragment dFrag = (androidx.fragment.app.DialogFragment) dfClass.newInstance();
                            dFrag.show(getParentFragmentManager(), "DownloadPlatformThumbnailsPackListDialogFragment");
                        } catch (Throwable t) {
                            t.printStackTrace();
                        }
                    } else if (which == 4 || which == 5) {
                        Activity act = getActivity();
                        if (act != null) {
                            try {
                                Method navMethod = act.getClass().getMethod("navigatePage", String.class, Object.class);
                                navMethod.invoke(act, "settings", null);
                            } catch (Throwable t) {
                                t.printStackTrace();
                            }
                        }
                    } else if (which == 6) {
                        toggleOrientation();
                    } else if (which == 7) {
                        loadAndPopulatePlatforms();
                    }
                }
            })
            .setNegativeButton((strClose != 0) ? getString(strClose) : "Fechar", null)
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
