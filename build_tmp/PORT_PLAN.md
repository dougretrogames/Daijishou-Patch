# Plano de porte P0 — classes ainda substituídas pelo bytecode ORIG

16 classes em 2 arquivos Java; 0 classes ORIG sem smali localizado; 0 sem arquivo Java.

`java_real_stubs` = corpos que hoje são stub no Java (sem contar as guardas do
compilador Kotlin "Super calls with default arguments", que existem também no ORIG).

| # | arquivo Java | classes | smali ORIG (linhas) | stubs no Java |
|---|---|---|---|---|
| 1 | `com/magneticchen/daijishou/view_models/DaijishouSynchronizationModel.java` | 7 | 10611 | 10 |
| 2 | `com/magneticchen/daijishou/retro_achievements/RetroAchievementsManager.java` | 9 | 16669 | 7 |

## Classes por arquivo (nomes ORIG)

- `com/magneticchen/daijishou/view_models/DaijishouSynchronizationModel.java`: `view_models/DaijishouSynchronizationModel$updatePlatformsFromGitHub$1`, `view_models/DaijishouSynchronizationModel`, `view_models/DaijishouSynchronizationModel$restoreFromIndexOfListOfBackupDataFromGoogleDrive$1`, `view_models/DaijishouSynchronizationModel$startBackingUp$1`, `view_models/DaijishouSynchronizationModel$importDatFilesFromUriForPlatformId$1`, `view_models/DaijishouSynchronizationModel$importXMLFilesFromUriForPlatformId$1`, `view_models/DaijishouSynchronizationModel$importPreviewMediaFromUriForPlatformId$1`
- `com/magneticchen/daijishou/retro_achievements/RetroAchievementsManager.java`: `retro_achievements/RetroAchievementsManager`, `retro_achievements/v2/RetroAchievementsManager$refreshUserProfile$3`, `retro_achievements/v2/RetroAchievementsManager$getPlayableItemIdToRetroAchievementsGameIdSurjectionByPlayableItemEntity$1`, `retro_achievements/v2/RetroAchievementsManager$getRetroAchievementsGameListByConsoleId$1`, `retro_achievements/v2/RetroAchievementsManager$getRetroAchievementsGameRecordByGameId$1`, `retro_achievements/v2/RetroAchievementsManager$getRetroAchievementsUserRecentGames$1`, `retro_achievements/v2/RetroAchievementsManager$getRetroAchievementsUserProfile$1`, `retro_achievements/v2/RetroAchievementsManager$getRetroAchievementsAwardsByUserId$1`, `retro_achievements/v2/RetroAchievementsManager$getRetroAchievementsConsoleIds$1`
