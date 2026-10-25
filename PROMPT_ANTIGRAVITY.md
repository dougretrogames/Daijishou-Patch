# Prompt para o Antigravity

Copie o bloco abaixo como primeira mensagem no Antigravity, com a pasta
`C:\Users\Douglas\Documents\Daijishou` aberta.

---

Você vai continuar a manutenção da árvore de código Java de um app Android que já está em
andamento nesta máquina. Raiz do projeto: `C:\Users\Douglas\Documents\Daijishou` (Windows,
PowerShell). Antes de qualquer coisa, leia nesta ordem: `AGENTS.md`, `HANDOFF.md`,
`build_tmp/PORT_PLAN.md` e, se precisar de histórico técnico, `RECONSTRUCTION_REPORT.md`.

## Contexto

O repositório mantém a árvore Java do **Daijishō 1.5.0** (`com.magneticchen.daijishou`, versão
416) de forma reprodutível, para estudo de comportamento e manutenção. Estado atual:

- `jadx_nest/sources`: 1.439 arquivos, 2.404 classes, **compila com 0 erros**.
- `build_tmp/` tem o pipeline completo de build (compilação, dex, empacotamento) e a etapa de
  reconciliação, que usa o smali de referência (`smali_orig_app`) para alinhar nomes e membros.
- O build atual é instalável e foi validado em AVD contra o build de referência 1.5.0 (416):
  mesmos textos, mesmos limites de UI, mesmos logs nos caminhos de erro.
- **O que falta**: 57 classes em 27 arquivos Java (63.198 linhas de smali) ainda são reaproveitadas
  do build de referência dentro do pipeline, porque ainda não foram convertidas para Java.
  Todo o resto (1.412 arquivos) já é Java.
- **Escopo**: manter o mesmo comportamento observável, em Java. Sem conversão para Kotlin e sem
  exigir bytes ou nomes de classe idênticos.

## Objetivo

1. Tornar a árvore **autossuficiente**: converter essas 57 classes para Java, de modo que o build
   seja gerado **sem reaproveitar código do build de referência** e mantenha o comportamento.
2. Manter a capacidade de **instalar e testar os builds na VM** (AVD) — roteiro em `HANDOFF.md` §7.2.
3. Ampliar a **cobertura de testes** (biblioteca real, scraping, RA, backup/restore, API 26 e
   outros idiomas/densidades) para validar cada fluxo.

## Regras (valem sempre)

- O smali de referência (`smali_orig_app`) é a especificação. **Nunca** edite `smali_orig_app`,
  `build_tmp/smali_recon`, `build_tmp/smali_compiled` ou `build_tmp/class_map.json`.
- Trabalhe **apenas** em `jadx_nest/sources`. Depois de editar, siga o ciclo do `HANDOFF.md` §5
  (javac → jar → d8 --release → baksmali → pipeline → rebuild → gates → AVD).
- Use o JADX sempre em modo CLI: `java -cp tools/jadx-1.5.6-all.jar jadx.cli.JadxCLI ...`.
  `java -jar` abre a GUI e trava o processo.
- `d8` sempre com `--release`; use o JDK 21 em `C:\Users\Douglas\.jdks\jdk-21.0.12.1+1`
  (o `java` do PATH é 11 e não serve).
- Não altere os 116 métodos que lançam `UnsupportedOperationException`: eles existem **iguais no
  build de referência** (guardas do compilador Kotlin). `stub_compare.py` deve continuar 0/0.
- Lotes pequenos: **1 arquivo Java ou ~2.000 linhas de smali por iteração**, com um commit por lote.
- Se faltar informação, **meça** com os scripts de `build_tmp/`; não estime.
- Não converta o projeto para Kotlin nem faça renomeações em massa sem eu pedir.
- Use apenas os arquivos e artefatos locais; não baixe código de terceiros para substituir o que já
  existe no repositório.

## Primeira tarefa (faça agora)

1. `git init` + commit inicial respeitando o `.gitignore`; confirme que ficaram de fora APKs, dex,
   `.class`, smali, `tools/` e `build_tmp` (exceto scripts).
2. Rode e cole a saída dos gates: `gap_inventory.py`, `stub_compare.py`, `check_refs.py`.
   Esperado: `stub_compare` 0/0; `check_refs` 0 métodos / 0 campos ausentes.
3. Confirme que o build atual reproduz o APK (javac 0 erros, `apksigner verify` = Verifies).
4. Converta o **lote de calibração** do P0, nesta ordem:
   - `utils/MD5.java` (365 linhas de smali)
   - `upgrade_scripts/ForeverUpgradeScript.java` (630)
   - `dialog_fragments/DownloadPlatformThumbnailsPackDialogFragment.java` (359)
   Para cada um: leia o smali em `smali_orig_app`, reescreva a classe em Java, compile, rode o
   pipeline, rode os gates e confirme que a contagem de stubs do `build_member_map.py` caiu em 1.
5. Me mostre: diff resumido, saída dos gates e o contador de stubs antes/depois.

## Como quero as respostas

- Em português, direto, com os comandos executados e **evidência numérica** (nada de "funcionou").
- Sempre termine com: o que foi feito, o que está bloqueado e o próximo passo.
- Se um gate falhar, **pare** e investigue; não avance para o próximo arquivo.

## Critério de aceite do projeto

0 classes reaproveitadas do build de referência; build gerado só a partir do código Java; gates
verdes; matriz AVD (build atual × referência) verde; `HANDOFF.md` e `RECONSTRUCTION_REPORT.md`
atualizados.
