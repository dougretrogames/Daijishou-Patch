package com.magneticchen.daijishou.arcade;

public class ArcadeItem {
    private final long id;
    private final String name;
    private final String shortname;
    private final String wallpaperPath;
    private final String thumbnailPath;
    private final boolean isAndroidApps;
    private int gameCount;

    public ArcadeItem(long id, String name, String shortname, String wallpaperPath, String thumbnailPath, boolean isAndroidApps) {
        this.id = id;
        this.name = name;
        this.shortname = shortname;
        this.wallpaperPath = wallpaperPath;
        this.thumbnailPath = thumbnailPath;
        this.isAndroidApps = isAndroidApps;
        this.gameCount = 0;
    }

    public long getId() { return id; }
    public String getName() { return name; }
    public String getShortname() { return shortname; }
    public String getWallpaperPath() { return wallpaperPath; }
    public String getThumbnailPath() { return thumbnailPath; }
    public boolean isAndroidApps() { return isAndroidApps; }
    public int getGameCount() { return gameCount; }
    public void setGameCount(int count) { this.gameCount = count; }
}
