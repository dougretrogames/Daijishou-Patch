# HANDOFF — Daijishō 1.5.0: reconstrução de código

Documento de continuidade. Leia também **`AGENTS.md`** (regras duras) e
**`RECONSTRUCTION_REPORT.md`** (relatório técnico completo, 594 linhas).
Lista de trabalho do próximo passo: **`build_tmp/PORT_PLAN.md`**.

---

## 0. TL;DR

- O build atual **funciona** e foi comparado tela a tela com o build de referência em dois AVDs
  (mesmos bounds de UI, mesmos textos, mesmos logs nos caminhos de erro).
- O que falta **não é comportamento**: é **autossuficiência da árvore**. 16 classes em 2
  arquivos Java ainda são substituídas pelo código de referência dentro do pipeline
  (**27.280 linhas de smali** a portar). Todo o resto do app (1.437 arquivos) já é Java real.
- Objetivo: **P0** eliminar essa dependência → **P1** gates de fidelidade → **P2** cobertura de
  testes. **Sem conversão para Kotlin** (decisão de escopo): a réplica é funcional, em Java.
- Recursos Android (`res/`, `assets/`, `AndroidManifest.xml`, `resources.arsc`) já são
  **byte a byte** os do build de referência; não há nada a reconstruir neles.

Critério de sucesso: **APK gerado sem nenhum reaproveitamento do código de referência**, com o
mesmo comportamento observável na matriz de testes. Não exige bytes nem nomes idênticos.

---

## 1. O que é o projeto

Daijishō é um launcher/front-end Android para emulação retrô: biblioteca de plataformas e jogos,
scraping de metadados, templates de intent para emuladores, widgets, RetroAchievements, backup
local e Google Drive.

Este repositório mantém a **árvore de código Java** dessa versão (1.5.0 / 416) de forma
reprodutível: ela compila, gera um APK instalável e é validada contra o **build de referência**
(o artefato 1.5.0 / 416, usado como oráculo de comportamento). O objetivo é manter e auditar o app
sem depender de uma árvore de código publicada.

Ferramentas e método:

1. **JADX 1.5.6** (`--no-inline-anonymous --no-inline-kotlin-lambda`) → `jadx_nest/sources`
   (1.439 arquivos do pacote do app; a árvore com as 13,7 mil classes de biblioteca foi descartada).
2. **javac 21** mirando bytecode 8, contra os jars das dependências → 2.404 classes, 0 erros.
3. **D8 `--release`** → `classes7.dex` (app).
4. **baksmali 2.5.2** → smali compilado → **pipeline de reconciliação** (9 scripts, 10 etapas) que
   alinha nomes e membros ao smali de referência.
5. **apktool 2.11.1 + assemble3.py** monta o APK: dex de referência 1/2/3/5/6 preservados, `classes4`
   reconstruído só com bibliotecas, `classes7` com o app.
6. **AVD** (Android 17 / API 37) para validar e comparar com o build de referência.

---

## 2. Estado atual medido (25/10/2026)

`ORIG` = **build de referência** 1.5.0 (416), usado como oráculo de comportamento.

| Métrica | Valor |
|---|---|
| Fonte Java | 1.439 arquivos → 2.404 classes, **0 erros** de compilação |
| Classes no APK (app) | 2.411 (inclui 5 shims de suporte) |
| Classes no ORIG (app) | 2.429 |
| Smali textualmente igual ao ORIG | 9 classes |
| Classes com nome JADX (`$AnonymousClassN` ou `$Cn`) | **722** |
| Lambdas sintéticas geradas (`$$ExternalSyntheticLambda`) | 347 |
| Classes substituídas inteiras pelo pipeline | **9** (em 1 arquivo Java) |
| Smali ORIG a portar | **16.669 linhas** |
| Ocorrências de stub no Java | 145 (116 são guardas do compilador Kotlin; **29 corpos reais**, sendo 7 em P0) |
| Stubs no dex final | 116 métodos / 9 classes |
| Stubs no dex de referência | 116 métodos / 9 classes — **conjunto idêntico (0 diferença)** |
| Referências ausentes (`check_refs.py`) | **0 métodos, 0 campos** (113 herdados benignos) |
| APK gerado | 21.267.302 bytes, `apksigner` v2+v3 OK, `zipalign -c -p 4` OK |
| Dex do app | 3.615.796 bytes (`classes7.dex`, armazenado sem compressão) |
| Testes | 71 PNG + 119 XML (build atual); 18 PNG + 24 XML (build de referência) |

Conclusão importante: **não há regressão de stub** — os 116 métodos que lançam
`UnsupportedOperationException` existem iguais no build de referência (guardas do compilador
Kotlin para `super.foo$default` em interfaces e métodos que o app nunca chama).
`build_tmp/stub_compare.py` prova isso e deve continuar imprimindo `0/0`.

---

## 3. Layout do repositório

| Caminho | Conteúdo |
|---|---|
| `jadx_nest/sources/` | **árvore de código Java** — é aqui que se trabalha |
| `jadx_nest/resources/` | vazio (o JADX não exportou recursos; ver §6) |
| `smali_orig_app/` | smali do `classes4.dex` do build de referência = **especificação** (não editar) |
| `smali/`, `smali_classes3..6/` | smali dos 6 dex do build de referência |
| `dex/` | os 6 dex do build de referência |
| `reconstructed/jars_compile/` | jars de compilação (classes publicizadas/deduplicadas) |
| `build_tmp/` | pipeline, scripts, smali intermediário, APKs intermediários, keystore |
| `build_tmp/smali_recon/` | smali final que entra no APK (gerado) |
| `build_tmp/PORT_PLAN.md` | **lista P0** com arquivo, classes, linhas de smali e stubs |
| `build_tmp/*.py` | pipeline + gates (somente stdlib) |
| `tools/` | `jadx-1.5.6-all.jar`, `baksmali-2.5.2.jar`, `apktool_2.11.1.jar` (copiados para não depender de `%TEMP%`) |
| `avd_tests/reconstructed/`, `avd_tests/original/` | capturas, dumps e logcat dos dois builds |
| `Daijishou v1.5.0.apk` | build de referência 1.5.0 / 416 (17.912.484 bytes) |
| `Daijishou v1.5.0-reconstructed.apk` | build atual, assinado (21.291.878 bytes) |

---

## 4. Ambiente (Windows, esta máquina)

| Item | Caminho / versão |
|---|---|
| JDK de build | `C:\Users\Douglas\.jdks\jdk-21.0.12.1+1` (o `java` do PATH é 11 — **não use**) |
| Android SDK | `C:\Users\Douglas\AppData\Local\Android\Sdk` |
| android.jar | `...\platforms\android-35\android.jar` |
| build-tools | `...\build-tools\35.0.0` (d8, apksigner, zipalign) |
| adb / emulator | `...\platform-tools\adb.exe`, `...\emulator\emulator.exe` |
| Python | 3.14 (`python -I` nos scripts) |
| AVDs | `Pixel_10_Pro` (build atual) e `Daijishou_Orig` (build de referência) — imagem `android-37.2 google_apis_playstore_ps16k x86_64` |
| RAM livre | ~2 GB → **um emulador por vez** |

---

## 5. Build — comandos exatos

### 5.1 Ciclo completo (depois de qualquer edição de fonte)

```powershell
cd C:\Users\Douglas\Documents\Daijishou
$jd21   = 'C:\Users\Douglas\.jdks\jdk-21.0.12.1+1\bin'
$android= "$env:LOCALAPPDATA\Android\Sdk\platforms\android-35\android.jar"
$bt     = "$env:LOCALAPPDATA\Android\Sdk\build-tools\35.0.0"
$env:JAVA_HOME = 'C:\Users\Douglas\.jdks\jdk-21.0.12.1+1'   # o d8.bat usa JAVA_HOME

# 1) compilar os 1.439 arquivos do app (o argfile já está pronto; NÃO regenere apontando para jadx_nest/sources)
& "$jd21\javac.exe" -J-Xmx6g -nowarn -proc:none -encoding UTF-8 -source 8 -target 8 `
  -bootclasspath $android -classpath "reconstructed\jars_compile\*;$android" `
  -Xmaxerrs 40000 -d nest_classes_compile "@nest_sources_compile.txt"

# 2) dex do app
& "$jd21\jar.exe" cf build_tmp\app_classes_compile.jar -C nest_classes_compile .
& "$bt\d8.bat" --release --min-api 26 --lib $android --output build_tmp\app_dex_rel build_tmp\app_classes_compile.jar
Copy-Item build_tmp\app_dex_rel\classes.dex build_tmp\app_dex\classes.dex -Force

# 3) baksmali + reconciliação
& "$jd21\java.exe" -jar tools\baksmali-2.5.2.jar d -f build_tmp\app_dex\classes.dex -o build_tmp\smali_compiled
powershell -ExecutionPolicy Bypass -File build_tmp\run_pipeline.ps1

# 4) montar, alinhar, assinar
powershell -ExecutionPolicy Bypass -File build_tmp\rebuild_app.ps1
```

`rebuild_app.ps1` recria `build_tmp/smali_build7`, chama o apktool, roda `assemble3.py`
(que **exige `build_tmp/lib4.apk`** — não apague), alinha e assina. Saída:
`Daijishou v1.5.0-reconstructed.apk`.

### 5.2 Regerar a árvore de código (só se precisar)

```powershell
# regerar a árvore Java (sempre headless; nunca java -jar, que abre a GUI)
& "$jd21\java.exe" -cp tools\jadx-1.5.6-all.jar jadx.cli.JadxCLI `
  --no-inline-anonymous --no-inline-kotlin-lambda -d jadx_nest "Daijishou v1.5.0.apk"

# especificação do app (classes4 contém o app + bibliotecas)
& "$jd21\java.exe" -jar tools\baksmali-2.5.2.jar d -f dex\classes4.dex -o smali_classes4
Copy-Item smali_classes4 smali_orig_app -Recurse -Force
```

### 5.3 Pipeline (ordem fixa)

`build_tmp/run_pipeline.ps1` executa:
`build_member_map` → `patch_stubs` → `patch_closure` → `patch_members` → `patch_align` →
`patch_stub_bodies` → `patch_align` → `patch_visibility` → `patch_inject_members` → `patch_invokes`.

Números atuais: 718 renomeações, 57 classes-stub, 7 closures, 49+101+9 injeções de membros,
5 corpos, 9 classes/83 membros publicizados, 59 invokes normalizados.

---

## 6. Recursos Android

Não há nada a reconstruir: `assemble3.py` copia do build de referência todas as entradas exceto os
dex e a assinatura — ou seja, `res/`, `assets/`, `AndroidManifest.xml`, `resources.arsc` e ícones são
byte a byte os de referência. Se em algum momento for preciso **editar** recursos, decodifique:

```powershell
& "$jd21\java.exe" -jar tools\apktool_2.11.1.jar d -s -f "Daijishou v1.5.0.apk" -o original_decoded
```

(`-s` = só recursos.) Aí a montagem tem de mudar: hoje o APK é composto a partir do build de
referência, e não do `res/` decodificado. Decodificação do apktool não é compatível com AGP/Gradle —
não tente "converter para projeto Android Studio".

---

## 7. Gates e testes

### 7.1 Gates estáticos

```powershell
python -I build_tmp/gap_inventory.py    # stub sets, nomes, classes divergentes
python -I build_tmp/stub_compare.py     # tem de dar 0/0
python -I build_tmp/stub_reach.py       # stubs com chamada (hoje: 4, iguais à referência)
python -I build_tmp/check_refs.py       # 0 métodos / 0 campos ausentes (~minutos)
python -I build_tmp/scan_catch_cast.py  # 0 casts pós-catch
```

### 7.2 AVD — instalar e exercitar

```powershell
$adb = "$env:LOCALAPPDATA\Android\Sdk\platform-tools\adb.exe"
$emu = "$env:LOCALAPPDATA\Android\Sdk\emulator\emulator.exe"

Start-Process $emu -ArgumentList '-avd','Pixel_10_Pro','-no-snapshot','-no-boot-anim','-no-audio','-no-window','-gpu','swiftshader_indirect'
# aguardar: (& $adb shell getprop sys.boot_completed) == 1  (~50 s)

& $adb install -r "Daijishou v1.5.0-reconstructed.apk"
& $adb shell cmd locale set-app-locales com.magneticchen.daijishou --locales pt-BR
& $adb shell monkey -p com.magneticchen.daijishou -c android.intent.category.LAUNCHER 1

# evidência
& $adb shell screencap -p /sdcard/shot.png ; & $adb pull /sdcard/shot.png avd_tests\reconstructed\NN_nome.png
& $adb shell uiautomator dump /sdcard/ui.xml ; & $adb pull /sdcard/ui.xml avd_tests\reconstructed\NN_nome.xml
python -I build_tmp/dump_ui.py avd_tests\reconstructed\NN_nome.xml
```

Comparação com o build de referência: segundo AVD `Daijishou_Orig`, instalar
`Daijishou v1.5.0.apk`, repetir o mesmo roteiro e comparar `dump_ui.py` (bounds e textos) e logcat.

Regras de interação aprendidas:

- App em landscape: coordenadas de `input tap` e dos dumps estão no espaço **2856×1280**.
- Diálogos: navegue por teclado (TAB até o botão + `keyevent 23`); toque direto cai sob o IME.
- `PopupMenu`: `keyevent 20` (DPAD_DOWN) + `keyevent 23`; o 8º item exige rolar.
- `uiautomator dump` falha durante animação ("could not get idle state") — repetir.
- `screencap`/`pull`; nunca redirecionar PNG no PowerShell (corrompe).
- Ruído benigno: `uwb-service` SIGABRT, `libnfc_nci`, `MalformedURLException: no protocol: index.json`,
  `Unauthenticated.` do RA.

---

## 8. O que falta

### P0 — Eliminar o reaproveitamento do código de referência (**prioridade máxima**)

9 classes em 1 arquivo Java (`build_tmp/PORT_PLAN.md`). Total: **16.669 linhas** de smali restante.
(Lote de calibração: `MD5.java`, `ForeverUpgradeScript.java` e `DownloadPlatformThumbnailsPackDialogFragment.java`; Lote 2: `SplashScreenActivity.java`, `BackupAndRestore.java`, `DownloadPlatformWallpapersPackDialogFragment.java`, `DownloadPlatformThumbnailsPackListDialogFragment.java`; Lote 3: `RetroAchievementsFaceFragment.java`, `PinAndPlayWidgetFaceFragment.java`; Lotes 4-11: `RetroAchievementsGameRecordDialogFragment`, `PlayableItemDetailDialogFragment`, `CachedBitmapLoader`, `DownloadPlatformsDialogFragment`, `BackupAndRestoreSettingsNavFragment`; Lote 12: `DaijishouConsoleViewModel.java`; Lote 13: `RetroAchievementsNavFragment.java`; Lote 14: `RetroAchievementsGameDialogFragment.java`; Lote 15: `GoogleDrive.java`; Lote 16: `DaijishouSynchronizationModel.java`).

| Ordem sugerida | Arquivo Java | Classes | Linhas de smali |
|---|---|---|---|
| 1 (calibração) | `utils/MD5.java` | 1 | 365 |
| 1 | `dialog_fragments/DownloadPlatformThumbnailsPackDialogFragment.java` | 1 | 359 |
| 1 | `upgrade_scripts/ForeverUpgradeScript.java` | 1 | 630 |
| 2 | `activities/SplashScreenActivity.java` | 2 | 1.306 |
| 2 | `backup_and_restore/BackupAndRestore.java` | 1 | 1.689 |
| 2 | `dialog_fragments/DownloadPlatformWallpapersPackDialogFragment.java` | 1 | 359 |
| 2 | `dialog_fragments/DownloadPlatformThumbnailsPackListDialogFragment.java` | 1 | 334 |
| 3 | `daijishou_widget/widgets/retro_achievements/RetroAchievementsFaceFragment.java` | 2 | 597 |
| 3 | `daijishou_widget/widgets/pin_and_play/PinAndPlayWidgetFaceFragment.java` | 1 | 1.631 |
| 4 | `google_drive/GoogleDrive.java` | 2 | 7.780 |
| 5 | `view_models/DaijishouSynchronizationModel.java` | 7 | 10.611 |
| 6 | `retro_achievements/RetroAchievementsManager.java` | 9 | 16.669 |

**Aceite:** `build_member_map.py` reporta `stub classes: 0`; `class_map.json["stubs"]` vazio;
`stub_compare.py` 0/0; `check_refs.py` 0; APK montado **sem** substituição passa a matriz de AVD.
**Estimativa:** 3–6 semanas em regime de lotes (o RA Manager sozinho é 1/4 do total).

### P1 — Gates de fidelidade

- Modo de build `-NoOrig` (falha se ainda houver reaproveitamento do build de referência) e flag
  equivalente no pipeline.
- Diff por método com normalização de registradores **nas classes que já são Java**, para achar
  outras falhas de conversão como a do RSS (encontrada por acidente; ver §10).
- Automatizar a matriz de AVD (roteiro atual é manual).

### P2 — Cobertura de testes e robustez

Biblioteca real + execução de emulador externo, scraping real, RA autenticado, Drive autenticado,
backup→restore round-trip, API 26 (minSdk), outras densidades/idiomas, serviço de acessibilidade,
protocolo TCP de debug (`daijishou_debug_service`). Cada fluxo testado vira linha da matriz de AVD
(build atual × build de referência).

### Opcional — nomes binários (722 classes)

Nomes com `$` são legais em Java (`Foo$onCreate$1`), então dá para reproduzir os nomes do build de
referência e dispensar `patch_members`/`patch_align`/`patch_invokes` em boa parte. Ganho: stack
traces e logs alinhados, comparação binária viável. Custo: 2–5 dias, risco médio.
**Não é requisito de replicação** — o dex atual é auto-consistente e o comportamento já bate.

### Fora de escopo (decidido)

- **Kotlin**: não haverá conversão J2K. O alvo é replicação funcional em Java. `@Metadata`,
  `DefaultImpls` e a forma dos state machines Kotlin não são reproduzidos — e não precisam ser.
- **Bytes idênticos**: impossível sem a mesma chave de assinatura e o mesmo toolchain; não é critério.
- **Árvore de código publicada**: não existe para esta versão; a especificação é o artefato de
  referência 1.5.0 / 416.

---

## 9. Receita para portar uma classe (P0)

1. Localize a entrada em `build_tmp/PORT_PLAN.md` e o smali em `smali_orig_app/...`.
2. No Java, substitua a classe-stub pela implementação real, guiado pelo smali:
   - preserve as mensagens de exceção e as chamadas `Intrinsics.checkNotNullParameter`;
   - preserve a ordem de efeitos colaterais e o tratamento de erro (`try/catch` **dentro** do
     escopo correto — ver o bug do RSS em §10);
   - máquinas de estado de `suspend` viram código sequencial normal (o shim cuida do resto).
3. Compile; rode `build_member_map.py` e confirme que a contagem de stubs **caiu em 1**.
4. Rode o pipeline + `rebuild_app.ps1` + os gates.
5. Teste na AVD o fluxo afetado (ex.: Google Drive → login/toast; RA → refresh; backup → zip).
6. Commit com a evidência.

Regra de ouro: se o método de referência **também** lança `UnsupportedOperationException`, ele é
guarda do compilador — **não** implemente; apenas mantenha a assinatura.

---

## 10. Armadilhas conhecidas

1. **Falha de conversão do JADX (já corrigida, serve de padrão):** no widget RSS, o JADX pôs o
   `check-cast`/atribuição **fora** do `try`, transformando um erro de rede em `ClassCastException`
   fatal. O smali de referência tem o cast dentro de `:try_start_49 .. :try_end_4e`. Corrigido em
   `RSSWidgetFaceFragment`; `scan_catch_cast.py` varre o padrão.
2. `java -jar jadx-*.jar` abre a GUI → sempre `-cp ... jadx.cli.JadxCLI`.
3. `d8` sem `--release` muda o dex (não reproduz 3.615.796 bytes).
4. `check_refs.py` compara o app contra as bibliotecas; 113 "unknown" são herdados benignos.
5. `patch_stubs` só substitui o que `build_member_map` detectar como stub — por isso o aceite do P0
   é a contagem no `build_member_map`, não uma lista manual.
6. Assinatura debug ⇒ **não** instala por cima do build de referência; e **quebra OAuth do Google**
   (client restrito por SHA-1) — Drive/Play Integrity nunca funcionarão ponta a ponta neste build.
7. `classes7.dex` é armazenado sem compressão (por isso o APK tem 21,3 MB).
8. O app não tem bibliotecas nativas (`lib/` ausente) e o runtime de extensões não existe no dex
   (só assets JS + manifesto) — **não implemente**.
9. `tools/` foi copiado de `%TEMP%`/AppData nesta sessão: sem ele o pipeline não reproduz.
10. Console do PowerShell mostra acentos corrompidos; os arquivos são UTF-8 válidos.

---

## 11. Protocolo de trabalho

1. `git init` + `.gitignore` (já existe) + commit inicial **antes** de qualquer edição em massa.
2. Uma branch por lote (`p0/md5`, `p0/google-drive`, ...), um commit por arquivo/classe.
3. Atualizar os contadores deste documento e do `RECONSTRUCTION_REPORT.md` no fim do lote.
4. Nunca commitar `build_tmp/smali_recon`, `nest_classes*`, APKs intermediários ou `tools/`.
5. Se um gate falhar, **parar** e investigar; não seguir para o próximo arquivo.

---

## 12. Definição de pronto (fim do projeto)

- [ ] 0 classes substituídas pelo pipeline (árvore Java autossuficiente).
- [ ] Build `-NoOrig` reproduz o APK sem nenhum reaproveitamento do código de referência.
- [ ] `check_refs` 0/0, `stub_compare` 0/0, `scan_catch_cast` 0.
- [ ] Matriz de AVD verde (build atual × referência) nos fluxos de §8/P2.
- [ ] `RECONSTRUCTION_REPORT.md` atualizado com os números finais.
