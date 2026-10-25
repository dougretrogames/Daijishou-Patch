# Plano de porte P0 — classes ainda substituídas pelo bytecode ORIG

49 classes em 20 arquivos Java; 0 classes ORIG sem smali localizado; 0 sem arquivo Java.

`java_real_stubs` = corpos que hoje são stub no Java (sem contar as guardas do
compilador Kotlin "Super calls with default arguments", que existem também no ORIG).

| # | arquivo Java | classes | smali ORIG (linhas) | stubs no Java |
|---|---|---|---|---|
| 1 | `com/magneticchen/daijishou/google_drive/GoogleDrive.java` | 2 | 7780 | 11 |
| 2 | `com/magneticchen/daijishou/view_models/DaijishouSynchronizationModel.java` | 7 | 10611 | 10 |
| 3 | `com/magneticchen/daijishou/retro_achievements/RetroAchievementsManager.java` | 9 | 16669 | 7 |
| 4 | `com/magneticchen/daijishou/daijishou_widget/widgets/retro_achievements/RetroAchievementsNavFragment.java` | 5 | 3767 | 3 |
| 5 | `com/magneticchen/daijishou/daijishou_widget/widgets/retro_achievements/RetroAchievementsFaceFragment.java` | 2 | 597 | 2 |
| 6 | `com/magneticchen/daijishou/dialog_fragments/RetroAchievementsGameDialogFragment.java` | 1 | 4710 | 1 |
| 7 | `com/magneticchen/daijishou/view_models/DaijishouConsoleViewModel.java` | 4 | 3782 | 1 |
| 8 | `com/magneticchen/daijishou/daijishou_widget/widgets/pin_and_play/PinAndPlayWidgetFaceFragment.java` | 1 | 1631 | 1 |
| 9 | `com/magneticchen/daijishou/settings_nav_fragments/BackupAndRestoreSettingsNavFragment.java` | 3 | 1249 | 0 |
| 10 | `com/magneticchen/daijishou/dialog_fragments/DownloadPlatformsDialogFragment.java` | 2 | 1099 | 0 |
| 11 | `com/magneticchen/daijishou/cache/CachedBitmapLoader.java` | 2 | 1088 | 0 |
| 12 | `com/magneticchen/daijishou/dialog_fragments/PlayableItemDetailDialogFragment.java` | 3 | 1023 | 0 |
| 13 | `com/magneticchen/daijishou/nav_fragments/PlatformLibraryGridViewNavFragment.java` | 1 | 949 | 0 |
| 14 | `com/magneticchen/daijishou/daijishou_widget/widgets/activity/ActivityWidgetTodayFaceFragment.java` | 1 | 675 | 0 |
| 15 | `com/magneticchen/daijishou/daijishou_widget/widgets/rss/RSSWidgetFaceFragment.java` | 1 | 507 | 0 |
| 16 | `com/magneticchen/daijishou/daijishou_widget/widgets/activity/ActivityWidgetContinueFaceFragment.java` | 1 | 471 | 0 |
| 17 | `com/magneticchen/daijishou/daijishou_widget/widgets/rss/RSSWidgetNavFragment.java` | 1 | 450 | 0 |
| 18 | `com/magneticchen/daijishou/nav_fragments/PlatformLibraryListViewNavFragment.java` | 1 | 444 | 0 |
| 19 | `com/magneticchen/daijishou/dialog_fragments/DebugAndExperimentalDialogFragment.java` | 1 | 341 | 0 |
| 20 | `com/magneticchen/daijishou/dialog_fragments/LoggerDialogFragment.java` | 1 | 313 | 0 |

## Classes por arquivo (nomes ORIG)

- `com/magneticchen/daijishou/google_drive/GoogleDrive.java`: `google_drive/GoogleDrive`, `google_drive/GoogleDrive$setupGoogleSignInAccount$1`
- `com/magneticchen/daijishou/view_models/DaijishouSynchronizationModel.java`: `view_models/DaijishouSynchronizationModel$updatePlatformsFromGitHub$1`, `view_models/DaijishouSynchronizationModel`, `view_models/DaijishouSynchronizationModel$restoreFromIndexOfListOfBackupDataFromGoogleDrive$1`, `view_models/DaijishouSynchronizationModel$startBackingUp$1`, `view_models/DaijishouSynchronizationModel$importDatFilesFromUriForPlatformId$1`, `view_models/DaijishouSynchronizationModel$importXMLFilesFromUriForPlatformId$1`, `view_models/DaijishouSynchronizationModel$importPreviewMediaFromUriForPlatformId$1`
- `com/magneticchen/daijishou/retro_achievements/RetroAchievementsManager.java`: `retro_achievements/RetroAchievementsManager`, `retro_achievements/v2/RetroAchievementsManager$refreshUserProfile$3`, `retro_achievements/v2/RetroAchievementsManager$getPlayableItemIdToRetroAchievementsGameIdSurjectionByPlayableItemEntity$1`, `retro_achievements/v2/RetroAchievementsManager$getRetroAchievementsGameListByConsoleId$1`, `retro_achievements/v2/RetroAchievementsManager$getRetroAchievementsGameRecordByGameId$1`, `retro_achievements/v2/RetroAchievementsManager$getRetroAchievementsUserRecentGames$1`, `retro_achievements/v2/RetroAchievementsManager$getRetroAchievementsUserProfile$1`, `retro_achievements/v2/RetroAchievementsManager$getRetroAchievementsAwardsByUserId$1`, `retro_achievements/v2/RetroAchievementsManager$getRetroAchievementsConsoleIds$1`
- `com/magneticchen/daijishou/daijishou_widget/widgets/retro_achievements/RetroAchievementsNavFragment.java`: `daijishou_widget/widgets/retro_achievements/RetroAchievementsNavFragment$GameListAdapter$ViewHolder$onBind$1`, `daijishou_widget/widgets/retro_achievements/RetroAchievementsNavFragment$onCreateView$3$1`, `daijishou_widget/widgets/retro_achievements/RetroAchievementsNavFragment`, `daijishou_widget/widgets/retro_achievements/RetroAchievementsNavFragment$onCreateView$10$1`, `daijishou_widget/widgets/retro_achievements/RetroAchievementsNavFragment$onCreateView$12`
- `com/magneticchen/daijishou/daijishou_widget/widgets/retro_achievements/RetroAchievementsFaceFragment.java`: `daijishou_widget/widgets/retro_achievements/RetroAchievementsFaceFragment$onCreateView$3$1`, `daijishou_widget/widgets/retro_achievements/RetroAchievementsFaceFragment$onCreateView$4`
- `com/magneticchen/daijishou/dialog_fragments/RetroAchievementsGameDialogFragment.java`: `dialog_fragments/RetroAchievementsGameDialogFragment`
- `com/magneticchen/daijishou/view_models/DaijishouConsoleViewModel.java`: `view_models/DaijishouConsoleViewModel$commands$2`, `view_models/DaijishouConsoleViewModel$commands$6`, `view_models/DaijishouConsoleViewModel$commands$7`, `view_models/DaijishouConsoleViewModel`
- `com/magneticchen/daijishou/daijishou_widget/widgets/pin_and_play/PinAndPlayWidgetFaceFragment.java`: `daijishou_widget/widgets/pin_and_play/PinAndPlayWidgetFaceFragment`
- `com/magneticchen/daijishou/settings_nav_fragments/BackupAndRestoreSettingsNavFragment.java`: `settings_nav_fragments/BackupAndRestoreSettingsNavFragment$onCreateView$2$1`, `settings_nav_fragments/BackupAndRestoreSettingsNavFragment$onCreateView$2$1$2$2$1$1`, `settings_nav_fragments/BackupAndRestoreSettingsNavFragment$onCreateView$4$1$1`
- `com/magneticchen/daijishou/dialog_fragments/DownloadPlatformsDialogFragment.java`: `dialog_fragments/DownloadPlatformsDialogFragment$onCreateDialog$1$2$1$1$1$2`, `dialog_fragments/DownloadPlatformsDialogFragment$onStart$1$1`
- `com/magneticchen/daijishou/cache/CachedBitmapLoader.java`: `cache/CachedBitmapLoader$CachedBitmapLoaderTask$into$1`, `cache/CachedBitmapLoader$CachedBitmapLoaderTask$intoNothing$1`
- `com/magneticchen/daijishou/dialog_fragments/PlayableItemDetailDialogFragment.java`: `dialog_fragments/PlayableItemDetailDialogFragment$onCreateView$retroAchievementsGameRecordLiveData$1$1$1`, `dialog_fragments/PlayableItemDetailDialogFragment$onCreateView$retroAchievementsGameRecordLiveData$1$1$1$1`, `dialog_fragments/PlayableItemDetailDialogFragment$onCreateView$retroAchievementsGameRecordLiveData$1$2$1$1`
- `com/magneticchen/daijishou/nav_fragments/PlatformLibraryGridViewNavFragment.java`: `nav_fragments/PlatformLibraryGridViewNavFragment$onCreateView$refreshPlayableItems$1`
- `com/magneticchen/daijishou/daijishou_widget/widgets/activity/ActivityWidgetTodayFaceFragment.java`: `daijishou_widget/widgets/activity/ActivityWidgetTodayFaceFragment$renewAndUpdateFace$1$1`
- `com/magneticchen/daijishou/daijishou_widget/widgets/rss/RSSWidgetFaceFragment.java`: `daijishou_widget/widgets/rss/RSSWidgetFaceFragment$onCreateView$1$1$2`
- `com/magneticchen/daijishou/daijishou_widget/widgets/activity/ActivityWidgetContinueFaceFragment.java`: `daijishou_widget/widgets/activity/ActivityWidgetContinueFaceFragment$onCreateView$2$1$1`
- `com/magneticchen/daijishou/daijishou_widget/widgets/rss/RSSWidgetNavFragment.java`: `daijishou_widget/widgets/rss/RSSWidgetNavFragment$onCreateView$4$1$2`
- `com/magneticchen/daijishou/nav_fragments/PlatformLibraryListViewNavFragment.java`: `nav_fragments/PlatformLibraryListViewNavFragment$refreshPreview$1$1`
- `com/magneticchen/daijishou/dialog_fragments/DebugAndExperimentalDialogFragment.java`: `dialog_fragments/DebugAndExperimentalDialogFragment$onCreateDialog$7$1`
- `com/magneticchen/daijishou/dialog_fragments/LoggerDialogFragment.java`: `dialog_fragments/LoggerDialogFragment$onCreateView$8$1`
