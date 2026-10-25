# Plano de porte P0 — classes ainda substituídas pelo bytecode ORIG

8 classes em 1 arquivo Java (`com/magneticchen/daijishou/retro_achievements/v2/RetroAchievementsManager.java`); 0 classes ORIG sem smali localizado; 0 sem arquivo Java.

`java_real_stubs` = corpos que hoje são stub no Java (sem contar as guardas do
compilador Kotlin "Super calls with default arguments", que existem também no ORIG).

| # | arquivo Java | classes | smali ORIG (linhas) | stubs no Java |
|---|---|---|---|---|
| 18 | `com/magneticchen/daijishou/retro_achievements/v2/RetroAchievementsManager.java` | 8 | 6438 | 8 |

## Classes por arquivo (nomes ORIG)

- `com/magneticchen/daijishou/retro_achievements/v2/RetroAchievementsManager.java`:
  - `retro_achievements/v2/RetroAchievementsManager$refreshUserProfile$3`
  - `retro_achievements/v2/RetroAchievementsManager$getPlayableItemIdToRetroAchievementsGameIdSurjectionByPlayableItemEntity$1`
  - `retro_achievements/v2/RetroAchievementsManager$getRetroAchievementsGameListByConsoleId$1`
  - `retro_achievements/v2/RetroAchievementsManager$getRetroAchievementsGameRecordByGameId$1`
  - `retro_achievements/v2/RetroAchievementsManager$getRetroAchievementsUserRecentGames$1`
  - `retro_achievements/v2/RetroAchievementsManager$getRetroAchievementsUserProfile$1`
  - `retro_achievements/v2/RetroAchievementsManager$getRetroAchievementsAwardsByUserId$1`
  - `retro_achievements/v2/RetroAchievementsManager$getRetroAchievementsConsoleIds$1`
