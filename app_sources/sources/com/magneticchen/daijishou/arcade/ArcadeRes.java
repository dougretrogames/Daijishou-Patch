package com.magneticchen.daijishou.arcade;

import android.content.Context;

public class ArcadeRes {
    public static int getId(Context ctx, String name) {
        if (ctx == null) return 0;
        return ctx.getResources().getIdentifier(name, "id", ctx.getPackageName());
    }

    public static int getLayout(Context ctx, String name) {
        if (ctx == null) return 0;
        return ctx.getResources().getIdentifier(name, "layout", ctx.getPackageName());
    }

    public static int getString(Context ctx, String name) {
        if (ctx == null) return 0;
        return ctx.getResources().getIdentifier(name, "string", ctx.getPackageName());
    }

    public static int getDrawable(Context ctx, String name) {
        if (ctx == null) return 0;
        return ctx.getResources().getIdentifier(name, "drawable", ctx.getPackageName());
    }
}
