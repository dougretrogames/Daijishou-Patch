# AGENTS.md — regras para agentes de IA neste repositório

Manutenção da árvore de código Java do **Daijishō 1.5.0** (`com.magneticchen.daijishou`,
versionCode 416): ela compila, gera um APK instalável e é validada em AVD contra o build de
referência 1.5.0 (416).
**Leia `HANDOFF.md` antes de qualquer alteração.** Histórico técnico completo em
`RECONSTRUCTION_REPORT.md`.

## Escopo

Réplica **funcional, em Java**. Não há conversão para Kotlin; não se exige bytes nem nomes de classe
idênticos ao original — exige-se o mesmo comportamento observável na matriz de testes.

## Fontes da verdade (não negociável)

| Caminho | Papel | Pode editar? |
|---|---|---|
| `jadx_nest/sources/` | árvore de código Java (1.439 arquivos) | **sim, é aqui que se trabalha** |
| `smali_orig_app/` | código de referência do app (cópia de `smali_classes4`) | **nunca** |
| `build_tmp/smali_compiled/` | baksmali do dex compilado | nunca (gerado) |
| `build_tmp/smali_recon/` | smali após o pipeline, entra no APK | nunca (gerado) |
| `build_tmp/class_map.json` | mapa JADX→ORIG, stubs, renomeações | nunca (gerado) |

Se o Java e o smali divergirem, **o smali de referência manda**. Toda correção de semântica é feita
no Java e validada contra o smali.

## Ciclo obrigatório

```
editar jadx_nest/sources  →  javac  →  jar  →  d8 --release  →  baksmali
→  run_pipeline.ps1  →  rebuild_app.ps1  →  gates  →  teste na AVD  →  commit
```

Comandos exatos: `HANDOFF.md` §5. Nunca pule etapas: o APK só é válido se sair do pipeline.

## Proibido

- `java -jar jadx-*.jar` (abre a GUI). Use `java -cp tools/jadx-1.5.6-all.jar jadx.cli.JadxCLI`.
- Rodar `d8` sem `--release` (muda o dex e quebra a reprodução).
- Editar `smali_recon`, `smali_compiled`, `smali_orig_app` ou `class_map.json` à mão.
- "Consertar" os 116 métodos `UnsupportedOperationException` que existem **também no build de
  referência** (são guardas do compilador Kotlin). `stub_compare.py` deve continuar 0/0.
- Apontar `compile_app.ps1` para `jadx_nest/sources` (inclui as 13,7 mil classes de biblioteca
  e gera ~1.679 erros). Use `nest_sources_compile.txt` (1.439 arquivos).
- Instalar o build atual por cima do build de referência (assinaturas diferentes: debug × release).
- Converter o projeto para Kotlin (fora de escopo: a réplica é em Java).
- Reescrever o pipeline em outra linguagem/ferramenta sem necessidade.

## Gates (todos verdes antes de commitar)

```powershell
python -I build_tmp/gap_inventory.py   # stub sets, nomes divergentes
python -I build_tmp/stub_compare.py    # deve imprimir 0/0 (stubs == referência)
python -I build_tmp/check_refs.py      # 0 métodos / 0 campos ausentes
python -I build_tmp/scan_catch_cast.py # 0 casts pós-catch (bug do RSS)
```

## Estilo de trabalho

- Lotes pequenos: **1 arquivo Java ou ~2.000 linhas de smali por iteração**.
- Um commit por lote, com a evidência (saída dos gates + print/dump da AVD).
- Antes de portar um método, leia o `.line` do smali para saber a linha Kotlin original.
- Se algo não estiver claro, **meça** (scripts em `build_tmp/`), não estime.
- Atualize `HANDOFF.md` (contadores) e `RECONSTRUCTION_REPORT.md` ao fechar um lote.
- Responda em português; código e nomes de API em inglês.
