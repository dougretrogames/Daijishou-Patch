#!/usr/bin/env python3
"""
test_p2_suite.py — Suite Master Integrada de Validacao P2 do Daijishou 1.5.0

Executa a bateria completa de testes de ponta a ponta:
1. Gate No-Orig: verify_no_orig.py
2. Matriz de abas AVD: test_avd_matrix.py
3. Servico TCP DaijishouDebugService (porta 19487): test_debug_service.py
4. Servico de Acessibilidade (LauncherAccessibilityService) via dumpsys
5. Fluxo de Download e Importacao de Plataformas: test_platforms_flow.py
6. Fluxo de Criacao de Widgets no Grid: test_widgets_flow.py
7. Fluxo de Backup e Sincronizacao: test_backup_flow.py
8. Bateria de Gates Estaticos Obrigatorios (gap_inventory, stub_compare, scan_catch_cast, check_refs)
"""

import os
import sys
import time
import subprocess

# Garante suporte a UTF-8 no Windows
sys.stdout.reconfigure(encoding='utf-8', errors='replace')

ADB = os.path.expandvars(r"$LOCALAPPDATA\Android\Sdk\platform-tools\adb.exe")
WORKSPACE = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))
BUILD_TMP = os.path.join(WORKSPACE, "build_tmp")

def run_cmd(cmd_list, timeout=120, cwd=WORKSPACE):
    start = time.time()
    try:
        res = subprocess.run(cmd_list, capture_output=True, text=True, timeout=timeout, cwd=cwd, encoding='utf-8', errors='replace')
        elapsed = time.time() - start
        return res.returncode, res.stdout.strip(), res.stderr.strip(), elapsed
    except subprocess.TimeoutExpired:
        elapsed = time.time() - start
        return -1, "", f"Timeout ({timeout}s) expirado", elapsed

def run_adb(args, timeout=15):
    cmd = [ADB] + args
    res = subprocess.run(cmd, capture_output=True, text=True, timeout=timeout, encoding='utf-8', errors='replace')
    return res.stdout.strip(), res.stderr.strip(), res.returncode

def test_accessibility_service():
    print("  [4.1] Habilitando LauncherAccessibilityService via secure settings...")
    run_adb(["shell", "settings", "put", "secure", "enabled_accessibility_services", "com.magneticchen.daijishou/com.magneticchen.daijishou.service.LauncherAccessibilityService"])
    run_adb(["shell", "settings", "put", "secure", "accessibility_enabled", "1"])
    time.sleep(2)

    print("  [4.2] Verificando status no dumpsys accessibility...")
    dump, _, code = run_adb(["shell", "dumpsys", "accessibility"])
    if code != 0:
        return 1, "Falha ao executar dumpsys accessibility"

    if "com.magneticchen.daijishou.service.LauncherAccessibilityService" not in dump:
        return 1, "LauncherAccessibilityService nao encontrado nos servicos habilitados do dumpsys"

    if "Bound services:" not in dump or "Daijishō" not in dump:
        return 1, "LauncherAccessibilityService nao esta vinculado (Bound) pelo sistema"

    if "Crashed services:{com.magneticchen.daijishou" in dump:
        return 1, "LauncherAccessibilityService crashou no sistema"

    print("  [4.3] Desabilitando LauncherAccessibilityService para liberar bridge...")
    run_adb(["shell", "settings", "put", "secure", "accessibility_enabled", "0"])
    run_adb(["shell", "settings", "delete", "secure", "enabled_accessibility_services"])
    time.sleep(1)

    return 0, "LauncherAccessibilityService ativado, vinculado e liberado com sucesso"

def main():
    print("=" * 80)
    print("   SUITE MASTER DE TESTES P2 — DAIJISHOU 1.5.0 (RECONSTRUCAO JAVA)")
    print("=" * 80)

    stages = [
        ("Gate de Compilacao No-Orig", ["python", "-I", os.path.join(BUILD_TMP, "verify_no_orig.py")]),
        ("Matriz de Abas e Telas AVD", ["python", "-I", os.path.join(BUILD_TMP, "test_avd_matrix.py")]),
        ("Servico TCP DaijishouDebugService (Porta 19487)", ["python", "-I", os.path.join(BUILD_TMP, "test_debug_service.py")]),
        ("Servico de Acessibilidade (LauncherAccessibilityService)", "ACCESSIBILITY_SPECIAL"),
        ("Download e Importacao de Plataformas (3DO)", ["python", "-I", os.path.join(BUILD_TMP, "test_platforms_flow.py")]),
        ("Criacao de Widgets Dinamicos no Grid", ["python", "-I", os.path.join(BUILD_TMP, "test_widgets_flow.py")]),
        ("Fluxo de Backup e Sincronizacao", ["python", "-I", os.path.join(BUILD_TMP, "test_backup_flow.py")]),
        ("Gate Estatico: Gap Inventory", ["python", "-I", os.path.join(BUILD_TMP, "gap_inventory.py")]),
        ("Gate Estatico: Stub Compare (0/0)", ["python", "-I", os.path.join(BUILD_TMP, "stub_compare.py")]),
        ("Gate Estatico: Scan Catch Cast (0)", ["python", "-I", os.path.join(BUILD_TMP, "scan_catch_cast.py")]),
        ("Gate Estatico: Check References (0/0)", ["python", "-I", os.path.join(BUILD_TMP, "check_refs.py")]),
    ]

    results = []
    overall_start = time.time()

    for idx, (name, cmd) in enumerate(stages, 1):
        print(f"\n[{idx}/{len(stages)}] >>> EXECUTANDO: {name}...")
        stage_start = time.time()
        
        if cmd == "ACCESSIBILITY_SPECIAL":
            code, msg = test_accessibility_service()
            elapsed = time.time() - stage_start
            stdout = msg
            stderr = ""
        else:
            # Garante que acessibilidade esteja desabilitada para scripts baseados em uiautomator
            run_adb(["shell", "settings", "put", "secure", "accessibility_enabled", "0"])
            code, stdout, stderr, elapsed = run_cmd(cmd, timeout=300)

        if code == 0:
            status = "PASS"
            print(f"  [OK] Concluido em {elapsed:.2f}s — STATUS: PASS")
            if stdout:
                lines = stdout.splitlines()
                summary_lines = lines[-3:] if len(lines) > 3 else lines
                for l in summary_lines:
                    print(f"      {l}")
        else:
            status = "FAIL"
            print(f"  [FAIL] Falhou com codigo {code} apos {elapsed:.2f}s!")
            if stdout:
                print("  --- STDOUT ---")
                for l in stdout.splitlines()[-10:]:
                    print(f"    {l}")
            if stderr:
                print("  --- STDERR ---")
                for l in stderr.splitlines()[-10:]:
                    print(f"    {l}")
            results.append((name, status, elapsed))
            break

        results.append((name, status, elapsed))

    overall_elapsed = time.time() - overall_start

    print("\n" + "=" * 80)
    print("   RELATORIO CONSOLIDADO DA SUITE MASTER P2")
    print("=" * 80)
    print(f"{'Estágio / Teste':<55} | {'Tempo':<8} | {'Status':<6}")
    print("-" * 80)

    all_passed = True
    for name, status, elapsed in results:
        if status != "PASS":
            all_passed = False
        print(f"{name:<55} | {elapsed:>6.2f}s | [{status}]")

    print("-" * 80)
    print(f"Tempo total de execucao: {overall_elapsed:.2f}s")

    if all_passed and len(results) == len(stages):
        print("\n>>> RESULTADO FINAL: TODOS OS TESTES P2 APROVADOS COM SUCESSO (100% GREEN) <<<")
        return 0
    else:
        print("\n>>> RESULTADO FINAL: FALHA EM UMA OU MAIS ETAPAS <<<")
        return 1

if __name__ == "__main__":
    sys.exit(main())
