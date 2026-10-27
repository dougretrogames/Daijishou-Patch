import os, re

base_dir = r"build_tmp/jadx_1.8.1_clean/sources/com/magneticchen/daijishou"

# 1. RSSWidgetNavFragment.java
p = os.path.join(base_dir, "ui/widget/widgets/rss/RSSWidgetNavFragment.java")
with open(p, "r", encoding="utf-8") as f:
    c = f.read()
c = c.replace("public final class RSSArticleListAdapter extends RecyclerView.Adapter<ViewHolder>",
              "public final class RSSArticleListAdapter extends RecyclerView.Adapter<RSSArticleListAdapter.ViewHolder>")
with open(p, "w", encoding="utf-8") as f:
    f.write(c)

# 2. ConnectionLiveData.java
p = os.path.join(base_dir, "data/live/ConnectionLiveData.java")
with open(p, "r", encoding="utf-8") as f:
    c = f.read()
c = c.replace("public static final class AnonymousClass1 extends ConnectivityManager.NetworkCallback",
              "public final class AnonymousClass1 extends ConnectivityManager.NetworkCallback")
with open(p, "w", encoding="utf-8") as f:
    f.write(c)

# 3. DaijishouExtensionRepository.java
p = os.path.join(base_dir, "data/db/repositories/DaijishouExtensionRepository.java")
with open(p, "r", encoding="utf-8") as f:
    c = f.read()
c = c.replace("for (Map.Entry entry : (Set) ((Map) this.cachedExtensionPreferenceItemHolders).entrySet())",
              "for (Map.Entry entry : ((Map<?, ?>) this.cachedExtensionPreferenceItemHolders).entrySet())")
c = c.replace("Entry entry = (Entry) obj;", "Map.Entry entry = (Map.Entry) obj;")
with open(p, "w", encoding="utf-8") as f:
    f.write(c)

# 4. DaijishouServiceLauncher$serviceConnection$1.java
p = os.path.join(base_dir, "ui/activities/abstract_classes/DaijishouServiceLauncher$serviceConnection$1.java")
with open(p, "r", encoding="utf-8") as f:
    c = f.read()
c = c.replace("public final class DaijishouServiceLauncher$serviceConnection$1 implements ServiceConnection",
              "public final class DaijishouServiceLauncher$serviceConnection$1<T extends DaijishouMainService> implements ServiceConnection")
c = c.replace("DaijishouServiceLauncher$serviceConnection$1(DaijishouServiceLauncher<T> daijishouServiceLauncher)",
              "DaijishouServiceLauncher$serviceConnection$1(DaijishouServiceLauncher daijishouServiceLauncher)")
with open(p, "w", encoding="utf-8") as f:
    f.write(c)

# 5. RetroAchievementsManager$refreshUserProfile$3$emit$1.java
p = os.path.join(base_dir, "features/retroachievements/v2/RetroAchievementsManager$refreshUserProfile$3$emit$1.java")
with open(p, "r", encoding="utf-8") as f:
    c = f.read()
c = c.replace("final class RetroAchievementsManager$refreshUserProfile$3$emit$1 extends ContinuationImpl",
              "final class RetroAchievementsManager$refreshUserProfile$3$emit$1<T> extends ContinuationImpl")
c = c.replace("RetroAchievementsManager.AnonymousClass3<T> this$0;", "RetroAchievementsManager.AnonymousClass3 this$0;")
c = c.replace("RetroAchievementsManager$refreshUserProfile$3$emit$1(RetroAchievementsManager.AnonymousClass3<? super T> anonymousClass3, Continuation<? super RetroAchievementsManager$refreshUserProfile$3$emit$1> continuation)",
              "RetroAchievementsManager$refreshUserProfile$3$emit$1(RetroAchievementsManager.AnonymousClass3 anonymousClass3, Continuation continuation)")
with open(p, "w", encoding="utf-8") as f:
    f.write(c)

# 6. features/retroachievements/v2/RetroAchievementsManager.java
p = os.path.join(base_dir, "features/retroachievements/v2/RetroAchievementsManager.java")
with open(p, "r", encoding="utf-8") as f:
    c = f.read()
c = c.replace("public static final AnonymousClass6<T> INSTANCE = new AnonymousClass6<>();",
              "public static final AnonymousClass6 INSTANCE = new AnonymousClass6();")
with open(p, "w", encoding="utf-8") as f:
    f.write(c)

# 7. CachedBitmapLoader.java
p = os.path.join(base_dir, "cache/CachedBitmapLoader.java")
with open(p, "r", encoding="utf-8") as f:
    c = f.read()
c = c.replace("public final class CachedBitmapLoaderTask", "public static final class CachedBitmapLoaderTask")
with open(p, "w", encoding="utf-8") as f:
    f.write(c)

# 8. AudioManager.java
p = os.path.join(base_dir, "features/AudioManager.java")
with open(p, "r", encoding="utf-8") as f:
    c = f.read()
c = c.replace("public /* synthetic */ class WhenMappings", "public static /* synthetic */ class WhenMappings")
with open(p, "w", encoding="utf-8") as f:
    f.write(c)

# 9. DaijishouRecyclerView.java
p = os.path.join(base_dir, "ui/daijishou_recycler_view/DaijishouRecyclerView.java")
with open(p, "r", encoding="utf-8") as f:
    c = f.read()
c = c.replace("Adapter.ViewHolder", "ViewHolder")
with open(p, "w", encoding="utf-8") as f:
    f.write(c)

# 10. Global batch fixes for:
# static final class AnonymousClassN extends Lambda -> final class AnonymousClassN extends Lambda<Unit>
# extends Lambda implements FunctionN<...> -> extends Lambda<Unit> implements FunctionN<...>
count = 0
for root, dirs, files in os.walk(base_dir):
    for f in files:
        if f.endswith('.java'):
            filepath = os.path.join(root, f)
            with open(filepath, "r", encoding="utf-8") as fp:
                content = fp.read()
            new_content = content
            # fix Lambda inheritance
            new_content = re.sub(r'static final class (AnonymousClass\d+) extends Lambda', r'final class \1 extends Lambda<Unit>', new_content)
            new_content = re.sub(r'extends Lambda implements Function(\d+)<', r'extends Lambda<Unit> implements Function\1<', new_content)
            new_content = re.sub(r'extends Lambda implements Function0<', r'extends Lambda<Unit> implements Function0<', new_content)
            new_content = re.sub(r'extends Lambda implements Function0\s*\{', r'extends Lambda<Unit> implements Function0<Unit> {', new_content)
            if new_content != content:
                with open(filepath, "w", encoding="utf-8") as fp:
                    fp.write(new_content)
                count += 1

print(f"Applied fixes across {count} files!")
