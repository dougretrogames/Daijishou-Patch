import os, re

base_dir = r"build_tmp/sources_181_merged/com/magneticchen/daijishou"

# 1. DaijishouLibraryRepository.java
fpath = os.path.join(base_dir, "data/db/repositories/DaijishouLibraryRepository.java")
with open(fpath, "r", encoding="utf-8") as f:
    c = f.read()
c = c.replace('?? r12 = "";', 'String r12 = "";')
c = c.replace('?? r16 = "";', 'String r16 = "";')
c = c.replace('?? r3 = groupValues3.get(2);', 'String r3 = groupValues3.get(2);')
c = c.replace('?? r11 = r16;', 'String r11 = r16;')
with open(fpath, "w", encoding="utf-8") as f:
    f.write(c)

# 2. ui/widget/widgets/category/CategoryWidgetNavFragment$onCreateView$refreshPlayableItems$1.java
fpath = os.path.join(base_dir, "ui/widget/widgets/category/CategoryWidgetNavFragment$onCreateView$refreshPlayableItems$1.java")
with open(fpath, "r", encoding="utf-8") as f:
    c = f.read()
c = c.replace('?? r15 = (PlayableItemEntity) obj3;', 'PlayableItemEntity r15 = (PlayableItemEntity) obj3;')
with open(fpath, "w", encoding="utf-8") as f:
    f.write(c)

# 3. ui/model/DaijishouLibraryModel.java
fpath = os.path.join(base_dir, "ui/model/DaijishouLibraryModel.java")
with open(fpath, "r", encoding="utf-8") as f:
    c = f.read()
c = c.replace('?? r18;', 'int r18 = 1;')
c = c.replace('r18 = true;', 'r18 = 1;')
c = c.replace('r18 = z3;', 'r18 = z3 ? 1 : 0;')
with open(fpath, "w", encoding="utf-8") as f:
    f.write(c)

# 4. features/retroachievements/RetroAchievementsManager.java
fpath = os.path.join(base_dir, "features/retroachievements/RetroAchievementsManager.java")
with open(fpath, "r", encoding="utf-8") as f:
    c = f.read()
c = c.replace('?? r6;', 'long r6 = 0L;')
c = c.replace('?? r7;', 'long r7 = 0L;')
c = c.replace('?? r20;', 'long r20 = 0L;')
c = c.replace('?? r21;', 'long r21 = 0L;')
c = c.replace('?? r22;', 'long r22 = 0L;')
c = c.replace('?? retroAchievementsRepository = retroAchievementsManager.getRetroAchievementsRepository();',
              'com.magneticchen.daijishou.data.db.repositories.RetroAchievementsRepository retroAchievementsRepository = retroAchievementsManager.getRetroAchievementsRepository();')
c = c.replace('?? r23 = r6;', 'long r23 = r6;')
c = c.replace('?? retroAchievementsRepository3 = retroAchievementsManager.getRetroAchievementsRepository();',
              'com.magneticchen.daijishou.data.db.repositories.RetroAchievementsRepository retroAchievementsRepository3 = retroAchievementsManager.getRetroAchievementsRepository();')
c = c.replace('?? r24 = r6;', 'long r24 = r6;')
c = c.replace('?? retroAchievementsRepository5 = retroAchievementsManager.getRetroAchievementsRepository();',
              'com.magneticchen.daijishou.data.db.repositories.RetroAchievementsRepository retroAchievementsRepository5 = retroAchievementsManager.getRetroAchievementsRepository();')
c = c.replace('?? r25 = r6;', 'long r25 = r6;')
c = c.replace('?? retroAchievementsRepository7 = retroAchievementsManager.getRetroAchievementsRepository();',
              'com.magneticchen.daijishou.data.db.repositories.RetroAchievementsRepository retroAchievementsRepository7 = retroAchievementsManager.getRetroAchievementsRepository();')
c = c.replace('?? r26 = r6;', 'long r26 = r6;')
with open(fpath, "w", encoding="utf-8") as f:
    f.write(c)

# 5. ui/model/SynchronizationOfPlatform.java
fpath = os.path.join(base_dir, "ui/model/SynchronizationOfPlatform.java")
with open(fpath, "r", encoding="utf-8") as f:
    c = f.read()
c = c.replace('final ?? regex;', 'final kotlin.text.Regex regex;')
with open(fpath, "w", encoding="utf-8") as f:
    f.write(c)

# 6. ui/fragments/nav/WidgetGridNavFragment.java
fpath = os.path.join(base_dir, "ui/fragments/nav/WidgetGridNavFragment.java")
with open(fpath, "r", encoding="utf-8") as f:
    c = f.read()
c = re.sub(r'private final WidgetGridNavFragment\$timeTickBroadcastReceiver\$1\s+timeTickBroadcastReceiver\s*=',
           'private final android.content.BroadcastReceiver timeTickBroadcastReceiver =', c)
with open(fpath, "w", encoding="utf-8") as f:
    f.write(c)

# 7. data/live/SharedPreferenceLiveData.java
fpath = os.path.join(base_dir, "data/live/SharedPreferenceLiveData.java")
with open(fpath, "r", encoding="utf-8") as f:
    c = f.read()
c = c.replace('SharedPreferenceLiveData.preferenceChangeListener$lambda$0(this.f$0, sharedPreferences, str);',
              'SharedPreferenceLiveData.preferenceChangeListener$lambda$0(SharedPreferenceLiveData.this, sharedPreferences, str);')
with open(fpath, "w", encoding="utf-8") as f:
    f.write(c)

# 8. cache/CachedBitmapLoader.java
fpath = os.path.join(base_dir, "cache/CachedBitmapLoader.java")
with open(fpath, "r", encoding="utf-8") as f:
    c = f.read()
c = c.replace('public final class CachedBitmapLoaderTask', 'public static final class CachedBitmapLoaderTask')
with open(fpath, "w", encoding="utf-8") as f:
    f.write(c)

# 9. features/AudioManager.java
fpath = os.path.join(base_dir, "features/AudioManager.java")
with open(fpath, "r", encoding="utf-8") as f:
    c = f.read()
c = c.replace('public /* synthetic */ class WhenMappings', 'public static /* synthetic */ class WhenMappings')
with open(fpath, "w", encoding="utf-8") as f:
    f.write(c)

# 10. ui/daijishou_recycler_view/DaijishouRecyclerView.java
fpath = os.path.join(base_dir, "ui/daijishou_recycler_view/DaijishouRecyclerView.java")
with open(fpath, "r", encoding="utf-8") as f:
    c = f.read()
c = c.replace('Adapter.ViewHolder', 'ViewHolder')
with open(fpath, "w", encoding="utf-8") as f:
    f.write(c)

# 11. ui/widget/widgets/rss/RSSWidgetNavFragment.java
fpath = os.path.join(base_dir, "ui/widget/widgets/rss/RSSWidgetNavFragment.java")
with open(fpath, "r", encoding="utf-8") as f:
    c = f.read()
c = c.replace("public final class RSSArticleListAdapter extends RecyclerView.Adapter<ViewHolder>",
              "public final class RSSArticleListAdapter extends RecyclerView.Adapter<RSSArticleListAdapter.ViewHolder>")
with open(fpath, "w", encoding="utf-8") as f:
    f.write(c)

# 12. data/db/repositories/DaijishouExtensionRepository.java
fpath = os.path.join(base_dir, "data/db/repositories/DaijishouExtensionRepository.java")
with open(fpath, "r", encoding="utf-8") as f:
    c = f.read()
c = c.replace("for (Map.Entry entry : (Set) ((Map) this.cachedExtensionPreferenceItemHolders).entrySet())",
              "for (Map.Entry entry : ((Map<?, ?>) this.cachedExtensionPreferenceItemHolders).entrySet())")
c = c.replace("Entry entry = (Entry) obj;", "Map.Entry entry = (Map.Entry) obj;")
with open(fpath, "w", encoding="utf-8") as f:
    f.write(c)

# 13. features/retroachievements/v2/RetroAchievementsManager$refreshUserProfile$3$emit$1.java
fpath = os.path.join(base_dir, "features/retroachievements/v2/RetroAchievementsManager$refreshUserProfile$3$emit$1.java")
if os.path.exists(fpath):
    with open(fpath, "r", encoding="utf-8") as f:
        c = f.read()
    c = c.replace("final class RetroAchievementsManager$refreshUserProfile$3$emit$1 extends ContinuationImpl",
                  "final class RetroAchievementsManager$refreshUserProfile$3$emit$1<T> extends ContinuationImpl")
    c = c.replace("RetroAchievementsManager.AnonymousClass3<T> this$0;", "RetroAchievementsManager.AnonymousClass3 this$0;")
    c = c.replace("RetroAchievementsManager$refreshUserProfile$3$emit$1(RetroAchievementsManager.AnonymousClass3<? super T> anonymousClass3, Continuation<? super RetroAchievementsManager$refreshUserProfile$3$emit$1> continuation)",
                  "RetroAchievementsManager$refreshUserProfile$3$emit$1(RetroAchievementsManager.AnonymousClass3 anonymousClass3, Continuation continuation)")
    with open(fpath, "w", encoding="utf-8") as f:
        f.write(c)

print("Applied 13 target fixes!")
