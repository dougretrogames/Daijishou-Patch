package com.magneticchen.daijishou.arcade;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.NavOptions;
import androidx.preference.PreferenceManager;

import java.util.List;

public class ArcadeNavHelper {

    public static boolean handleEmptyNav(Fragment fragment, NavController navController, List<?> platforms) {
        if (fragment == null || navController == null) {
            return false;
        }
        Context context = fragment.getContext();
        if (context == null) return false;

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        String mode = prefs.getString("library_collection_view_mode", "0");
        android.util.Log.d("ArcadeNavHelper", "handleEmptyNav called: mode=" + mode + ", platforms=" + platforms);
        if (!"3".equals(mode)) {
            return false;
        }

        String appsFilter = prefs.getString("arcade_android_apps_filter", "0");
        boolean appsEnabled = !"2".equals(appsFilter);
        boolean hasPlatforms = (platforms != null && !platforms.isEmpty());

        if (!hasPlatforms && !appsEnabled) {
            return false;
        }

        int arcadeDestId = context.getResources().getIdentifier("arcadeSelectSystemFragment", "id", context.getPackageName());
        if (arcadeDestId == 0) return false;

        int emptyId = context.getResources().getIdentifier("platformEmptyNavFragment", "id", context.getPackageName());
        
        NavOptions.Builder builder = new NavOptions.Builder();
        if (emptyId != 0) {
            builder.setPopUpTo(emptyId, true);
        }
        NavOptions navOptions = builder.build();

        navController.getGraph().setStartDestination(arcadeDestId);
        NavDestination current = navController.getCurrentDestination();
        if (current != null && current.getId() == emptyId) {
            int actionId = context.getResources().getIdentifier("platformEmptyToArcadeAction", "id", context.getPackageName());
            if (actionId != 0) {
                navController.navigate(actionId, null, navOptions);
            } else {
                navController.navigate(arcadeDestId, null, navOptions);
            }
        }
        return true;
    }
}
