package com.magneticchen.daijishou.daijishou_library_db;

import android.content.Context;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.magneticchen.daijishou.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: Genres.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b2\u0006\u0010\f\u001a\u00020\u0005J&\u0010\r\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000b0\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\u0005R-\u0010\u0003\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/magneticchen/daijishou/daijishou_library_db/Genres;", "", "()V", "genres", "Ljava/util/HashMap;", "", "Lcom/magneticchen/daijishou/daijishou_library_db/Genre;", "Lkotlin/collections/HashMap;", "getGenres", "()Ljava/util/HashMap;", "extractGenresFromString", "", TypedValues.Custom.S_STRING, "generateGenreIdsAndNames", "Lkotlin/Pair;", "context", "Landroid/content/Context;", "makeStringTight", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final class Genres {
    public static final Genres INSTANCE = new Genres();
    private static final HashMap<String, Genre> genres = MapsKt.hashMapOf(TuplesKt.to("action", new Genre("action", CollectionsKt.listOf("action"), R.string.action_genre_name)), TuplesKt.to("adventure", new Genre("adventure", CollectionsKt.listOf("adventure"), R.string.adventure_genre_name)), TuplesKt.to("puzzle", new Genre("puzzle", CollectionsKt.listOf(new String[]{"puzzle", "puzzle video game"}), R.string.puzzle_genre_name)), TuplesKt.to("role_playing", new Genre("role_playing", CollectionsKt.listOf(new String[]{"role playing", "rpg"}), R.string.role_playing_genre_name)), TuplesKt.to("simulation", new Genre("simulation", CollectionsKt.listOf("simulation"), R.string.simulation_genre_name)), TuplesKt.to("strategy", new Genre("strategy", CollectionsKt.listOf("strategy"), R.string.strategy_genre_name)), TuplesKt.to("racing", new Genre("racing", CollectionsKt.listOf(new String[]{"racing", "driving"}), R.string.racing_genre_name)), TuplesKt.to("sports", new Genre("sports", CollectionsKt.listOf("sports"), R.string.sports_genre_name)), TuplesKt.to("shooter", new Genre("shooter", CollectionsKt.listOf("shooter"), R.string.shooter_genre_name)), TuplesKt.to("platform", new Genre("platform", CollectionsKt.listOf(new String[]{"platform", "platformer"}), R.string.platform_genre_name)), TuplesKt.to("management", new Genre("management", CollectionsKt.listOf("management"), R.string.management_genre_name)), TuplesKt.to("party", new Genre("party", CollectionsKt.listOf("party"), R.string.party_genre_name)), TuplesKt.to("fighting", new Genre("fighting", CollectionsKt.listOf(new String[]{"fighting", "fighter"}), R.string.fighting_genre_name)), TuplesKt.to("rhythm", new Genre("rhythm", CollectionsKt.listOf(new String[]{"rhythm", "music"}), R.string.rhythm_genre_name)), TuplesKt.to("horror", new Genre("horror", CollectionsKt.listOf("horror"), R.string.horror_genre_name)), TuplesKt.to("maze", new Genre("maze", CollectionsKt.listOf("maze"), R.string.maze_genre_name)), TuplesKt.to("casino", new Genre("casino", CollectionsKt.listOf("casino"), R.string.casino_genre_name)), TuplesKt.to("beat_em_up", new Genre("beat_em_up", CollectionsKt.listOf(new String[]{"beat'em up", "beat 'em up", "beat em up"}), R.string.beat_em_up_genre_name)), TuplesKt.to("visual_novel", new Genre("visual_novel", CollectionsKt.listOf("visual novel"), R.string.visual_novels_genre_name)), TuplesKt.to("shoot_em_up", new Genre("shoot_em_up", CollectionsKt.listOf(new String[]{"shoot'em up", "shoot 'em up", "shoot em up"}), R.string.shoot_em_up_genre_name)), TuplesKt.to("scrolling", new Genre("scrolling", CollectionsKt.listOf(new String[]{"scrolling", "scroll"}), R.string.scrolling_genre_name)), TuplesKt.to("metroidvania", new Genre("metroidvania", CollectionsKt.listOf(new String[]{"metroidvania", "metroid vania", "castle vania", "castlevania"}), R.string.metroidvania_genre_name)), TuplesKt.to("hack_and_slash", new Genre("hack_and_slash", CollectionsKt.listOf(new String[]{"Hack and slash", "Hack n slash"}), R.string.hack_and_slash_genre_name)), TuplesKt.to("fishing", new Genre("fishing", CollectionsKt.listOf("Fishing"), R.string.fishing_genre_name)), TuplesKt.to("survival", new Genre("survival", CollectionsKt.listOf("Survival"), R.string.survival_genre_name)), TuplesKt.to("golf", new Genre("golf", CollectionsKt.listOf("Golf"), R.string.golf_genre_name)), TuplesKt.to("baseball", new Genre("baseball", CollectionsKt.listOf("Baseball"), R.string.baseball_genre_name)), TuplesKt.to("basketball", new Genre("basketball", CollectionsKt.listOf("Basketball"), R.string.basketball_genre_name)), TuplesKt.to("erotic", new Genre("erotic", CollectionsKt.listOf(new String[]{"Erotic", "Hentai"}), R.string.erotic_genre_name)));

    private Genres() {
    }

    public final HashMap<String, Genre> getGenres() {
        return genres;
    }

    public final Pair<List<String>, List<String>> generateGenreIdsAndNames(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Map.Entry<String, Genre> entry : genres.entrySet()) {
            arrayList.add(entry.getValue().getId());
            String string = context.getString(entry.getValue().getNameStringId());
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            arrayList2.add(string);
        }
        return new Pair<>(arrayList, arrayList2);
    }

    public final String makeStringTight(String string) {
        Intrinsics.checkNotNullParameter(string, "string");
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
        String lowerCase = string.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return new Regex("[^0-9a-zA-Z]+").replace(new Regex("(\\s+|_+)").replace(lowerCase, " "), "");
    }

    public final List<Genre> extractGenresFromString(String string) {
        Intrinsics.checkNotNullParameter(string, "string");
        ArrayList arrayList = new ArrayList();
        String strMakeStringTight = makeStringTight(string);
        if (strMakeStringTight == null) {
            return arrayList;
        }
        for (Map.Entry<String, Genre> entry : genres.entrySet()) {
            entry.getKey();
            Genre value = entry.getValue();
            Genres genres2 = INSTANCE;
            Iterator it = value.getAlias().iterator();
            while (it.hasNext()) {
                String strMakeStringTight2 = genres2.makeStringTight((String) it.next());
                if (strMakeStringTight2 != null && StringsKt.contains$default((CharSequence) strMakeStringTight, (CharSequence) strMakeStringTight2, false, 2, (Object) null)) {
                    arrayList.add(value);
                    break;
                }
            }
        }
        return CollectionsKt.distinct(arrayList);
    }
}
