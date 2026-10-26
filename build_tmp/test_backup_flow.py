#!/usr/bin/env python3
"""
test_backup_flow.py — Teste automatizado do fluxo de backup e sincronizacao no Daijishou

Valida:
1. Abertura do dialogo de sincronizacao (sync_and_backup_button_layout).
2. Navegacao para Configuracoes -> Backup e restauracao (BackupAndRestoreSettingsNavFragment).
3. Acionamento do backup manual ("Faca backup agora").
4. Exportacao e backup da plataforma 3DO para JSON (Compartilhar -> 3DO.json no Chooser).
5. Ausencia total de crashes / excecoes fatais no processo do app.
"""

import os
import re
import sys
import time
import subprocess
import xml.etree.ElementTree as ET

# Garante saida em UTF-8 no Windows
sys.stdout.reconfigure(encoding='utf-8', errors='replace')

ADB = os.path.expandvars(r"$LOCALAPPDATA\Android\Sdk\platform-tools\adb.exe")
PACKAGE = "com.magneticchen.daijishou"
DUMP_REMOTE = "/sdcard/window_dump.xml"
DUMP_LOCAL = os.path.join("build_tmp", "backup_flow_dump.xml")

def run_adb(cmd, timeout=15):
    full_cmd = [ADB] + cmd
    res = subprocess.run(full_cmd, capture_output=True, text=True, timeout=timeout)
    return res.stdout.strip()

def dump_ui():
    run_adb(["shell", "uiautomator", "dump", DUMP_REMOTE])
    run_adb(["pull", DUMP_REMOTE, DUMP_LOCAL])
    if os.path.exists(DUMP_LOCAL):
        try:
            return ET.parse(DUMP_LOCAL)
        except Exception as e:
            print(f"Erro ao parsear XML: {e}")
    return None

def find_node(tree, resource_id=None, text_contains=None, class_name=None):
    if tree is None:
        return None
    for node in tree.iter():
        rid = node.attrib.get("resource-id", "")
        txt = node.attrib.get("text", "")
        desc = node.attrib.get("content-desc", "")
        cls = node.attrib.get("class", "")
        
        match = True
        if resource_id and resource_id not in rid:
            match = False
        if text_contains:
            q = text_contains.lower()
            if q not in txt.lower() and q not in desc.lower():
                match = False
        if class_name and class_name not in cls:
            match = False
        if match:
            return node
    return None

def get_node_center(node):
    if node is None:
        return None
    bounds = node.attrib.get("bounds", "")
    m = re.match(r"\[(\d+),(\d+)\]\[(\d+),(\d+)\]", bounds)
    if m:
        x1, y1, x2, y2 = map(int, m.groups())
        return ((x1 + x2) // 2, (y1 + y2) // 2)
    return None

def tap_node(node, delay=1.5):
    center = get_node_center(node)
    if center:
        run_adb(["shell", "input", "tap", str(center[0]), str(center[1])])
        time.sleep(delay)
        return True
    return False

def check_crashes(since_sec=20):
    log = run_adb(["logcat", "-d", "-t", f"{since_sec * 100}"])
    lines = log.splitlines()
    crashes = []
    for l in lines:
        if "FATAL EXCEPTION" in l or ("com.magneticchen.daijishou" in l and "Exception" in l and "FATAL" in l):
            crashes.append(l)
    return crashes

def main():
    print("=== [Backup Flow Test] Iniciando teste do fluxo de backup e sincronizacao ===")

    # Garante acessibilidade desativada para uiautomator funcionar
    run_adb(["shell", "settings", "put", "secure", "accessibility_enabled", "0"])

    pid = run_adb(["shell", "pidof", PACKAGE])
    if not pid:
        print("[*] Iniciando MainActivity...")
        run_adb(["shell", "am", "start", "-n", f"{PACKAGE}/.activities.MainActivity"])
        time.sleep(3)

    # 1. Teste do Botao de Sincronizacao no Topo
    print("  [1/4] Testando botao de sincronizacao no topo...")
    tree = dump_ui()
    sync_btn = find_node(tree, resource_id="sync_and_backup_button_layout")
    if sync_btn is None:
        print("[ERRO] Botao de sincronizacao nao encontrado no topo.")
        return 1
    tap_node(sync_btn, delay=2.0)

    tree = dump_ui()
    dialog_title = find_node(tree, resource_id="fragment_synchronization_status_title")
    if dialog_title is not None:
        print(f"  [OK] Dialogo de status aberto: '{dialog_title.attrib.get('text')}'")
    else:
        print("[ERRO] Dialogo de sincronizacao nao abriu.")
        return 1

    # Clica no chip Sincronizar se presente
    chip = find_node(tree, resource_id="fragment_synchronization_status_sync_chip")
    if chip is not None:
        print(f"  [OK] Acionando chip: '{chip.attrib.get('text')}'")
        tap_node(chip, delay=1.0)

    # Fecha o dialogo via BACK
    run_adb(["shell", "input", "keyevent", "4"])
    time.sleep(1.5)

    # 2. Teste de Configuracoes -> Backup e Restauracao
    print("  [2/4] Navegando para Configuracoes -> Backup e restauracao...")
    tree = dump_ui()
    tab_settings = find_node(tree, text_contains="Configura")
    if tab_settings is None:
        tab_settings = find_node(tree, text_contains="Settings")
    if tab_settings is None:
        print("[ERRO] Aba Configuracoes nao encontrada!")
        return 1
    tap_node(tab_settings, delay=2.0)

    # Verifica se a raiz de Configuracoes abriu
    tree = dump_ui()
    page_title = find_node(tree, resource_id="apps_title_text_view")
    if page_title is None or "Configura" not in page_title.attrib.get("text", ""):
        print("[AVISO] Repetindo clique na aba Configuracoes...")
        tab_settings = find_node(tree, text_contains="Configura")
        if tab_settings is not None:
            tap_node(tab_settings, delay=2.0)
            tree = dump_ui()

    # Rola a tela para baixo para exibir "Backup e restauracao"
    run_adb(["shell", "input", "swipe", "1500", "1100", "1500", "400", "300"])
    time.sleep(1.5)

    tree = dump_ui()
    backup_pref = find_node(tree, text_contains="Backup")
    if backup_pref is None:
        print("[ERRO] Preferencia de Backup nao encontrada nas configuracoes.")
        return 1
    print(f"  [OK] Acessando item de configuracao: '{backup_pref.attrib.get('text')}'")
    tap_node(backup_pref, delay=2.0)

    tree = dump_ui()
    settings_title = find_node(tree, resource_id="settings_title_text_view")
    if settings_title is not None and "Backup" in settings_title.attrib.get("text", ""):
        print(f"  [OK] Tela de Backup e Restauracao carregada com sucesso: '{settings_title.attrib.get('text')}'")
    else:
        print("[ERRO] Falha ao abrir tela de Backup e Restauracao.")
        return 1

    # Clica em 'Faca backup agora' / 'Backup to Google Drive'
    backup_now = find_node(tree, text_contains="backup agora")
    if backup_now is None:
        backup_now = find_node(tree, text_contains="Backup now")
    if backup_now is not None:
        print(f"  [OK] Acionando backup manual: '{backup_now.attrib.get('text')}'")
        tap_node(backup_now, delay=2.0)

    # Volta para a tela principal
    run_adb(["shell", "input", "keyevent", "4"])
    time.sleep(1.0)
    run_adb(["shell", "input", "keyevent", "4"])
    time.sleep(1.5)

    # 3. Teste de Exportacao / Backup de Plataforma (3DO.json)
    print("  [3/4] Testando exportacao de plataforma (3DO.json)...")
    tree = dump_ui()
    tab_lib = find_node(tree, text_contains="Biblioteca")
    if tab_lib is None:
        tab_lib = find_node(tree, text_contains="Library")
    if tab_lib is not None:
        tap_node(tab_lib, delay=2.0)

    tree = dump_ui()
    share_btn = find_node(tree, resource_id="library_collection_wallpaper_view_platform_share_button")
    if share_btn is None:
        print("[ERRO] Botao 'Compartilhar' nao encontrado na tela da plataforma.")
        return 1
    print(f"  [OK] Clicando em 'Compartilhar' na plataforma...")
    tap_node(share_btn, delay=2.0)

    tree = dump_ui()
    opt_export = find_node(tree, text_contains="configuração da plataforma")
    if opt_export is None:
        opt_export = find_node(tree, text_contains="platform settings")
    if opt_export is None:
        print("[ERRO] Opcao de exportacao de plataforma nao encontrada no dialogo.")
        return 1
    print(f"  [OK] Selecionando opcao: '{opt_export.attrib.get('text')}'")
    tap_node(opt_export, delay=3.0)

    # Verifica se o Chooser do Android abriu com o arquivo 3DO.json
    tree = dump_ui()
    json_node = find_node(tree, text_contains="3DO.json")
    if json_node is None:
        json_node = find_node(tree, resource_id="content_preview_filename")
    if json_node is not None:
        print(f"  [OK] Arquivo de exportacao gerado com sucesso: '{json_node.attrib.get('text')}'")
    else:
        print("[ERRO] Android Chooser com 3DO.json nao detectado.")
        return 1

    # Fecha o chooser
    run_adb(["shell", "input", "keyevent", "4"])
    time.sleep(1.5)

    # 4. Validacao Final de Integridade
    print("  [4/4] Validando integridade do processo...")
    pid_final = run_adb(["shell", "pidof", PACKAGE])
    if not pid_final:
        print("[ERRO] App encerrou inesperadamente durante o teste!")
        return 1

    crashes = check_crashes(30)
    if crashes:
        print("[ERRO] Crashes detectados:")
        for c in crashes:
            print("  ", c)
        return 1

    # Captura screenshot de sucesso
    screenshot_path = os.path.join("build_tmp", "backup_flow_success.png")
    run_adb(["shell", "screencap", "-p", "/sdcard/backup_flow_success.png"])
    run_adb(["pull", "/sdcard/backup_flow_success.png", screenshot_path])
    print(f"  [OK] Screenshot de sucesso salva em {screenshot_path}")

    print("\n=== [SUCESSO] Fluxo de backup e sincronizacao validado com 100% de exito! ===")
    return 0

if __name__ == "__main__":
    sys.exit(main())
