# Plano de porte P0 — classes ainda substituídas pelo bytecode ORIG

## STATUS: P0 100% CONCLUÍDO! (0 classes restantes)

0 classes em 0 arquivos Java. Todas as 57 classes-stub do APK de referência foram totalmente portadas para Java na árvore `jadx_nest/sources/`.

| # | arquivo Java | classes | smali ORIG (linhas) | stubs no Java | status |
|---|---|---|---|---|---|
| 18 | `com/magneticchen/daijishou/retro_achievements/v2/RetroAchievementsManager.java` | 8 | 6438 | 0 | Concluído (100%) |

## Classes portadas no Lote 18 (final de P0):
- `retro_achievements/v2/RetroAchievementsManager$refreshUserProfile$3` (FlowCollector com coroutine state machine)
- `retro_achievements/v2/RetroAchievementsManager$getPlayableItemIdToRetroAchievementsGameIdSurjectionByPlayableItemEntity$1` (algoritmo completo de surjeção com ranking, cache e scraping)
- `retro_achievements/v2/RetroAchievementsManager$getRetroAchievementsGameListByConsoleId$1` (game list por consoleId)
- `retro_achievements/v2/RetroAchievementsManager$getRetroAchievementsGameRecordByGameId$1` (game record com lista e entidades de achievement)
- `retro_achievements/v2/RetroAchievementsManager$getRetroAchievementsUserRecentGames$1` (recent games do usuário)
- `retro_achievements/v2/RetroAchievementsManager$getRetroAchievementsUserProfile$1` (user profile)
- `retro_achievements/v2/RetroAchievementsManager$getRetroAchievementsAwardsByUserId$1` (user awards)
- `retro_achievements/v2/RetroAchievementsManager$getRetroAchievementsConsoleIds$1` (console ids)

## Validação Final de P0:
- `build_class_map.py`: `stub classes: 0 methods: 0`
- `class_map.json["stubs"]`: 0
- `gap_inventory.py`: `classes substituidas inteiras pelo pipeline: 0`
- `stub_compare.py`: `0/0` (116 métodos UOE Kotlin preservados)
- `check_refs.py`: `missing method refs: 0, missing field refs: 0`
- `scan_catch_cast.py`: `0`
- AVD `emulator-5554`: PID ativo, 0 erros fatais em logcat, screenshot `build_tmp/avd_batch18.png`.
