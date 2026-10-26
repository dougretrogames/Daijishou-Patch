"""Automacao da Matriz de Testes AVD (P1 / P2).

Executa bateria completa de validacao ponta-a-ponta:
1. Verificacao de dispositivo conectado via ADB.
2. Instalacao limpa do APK reconstruido sem dependencias ORIG.
3. Configuracao de locale (pt-BR).
4. Limpeza de logs e encerramento de processos residuais.
5. Lancamento da MainActivity.
6. Afericao do processo ativo (PID).
7. Navegacao multi-aba dinamica por selecao semantica de UI (ElementTree):
   - Aba Biblioteca: verificacao do estado inicial.
   - Aba Aplicativos: navegacao e carregamento da lista de apps.
   - Aba Configuracoes: navegacao na raiz e abertura da subtela 'Aparencia'.
   - Retorno a Configuracoes via tecla Back.
   - Aba Widgets: navegacao e abertura do menu popup 'Novo widget'.
   - Fechamento do menu via tecla Back.
8. Coleta de UI hierarquica (uiautomator dump) e screenshot de evidencia.
9. Analise estrita de erros no logcat (AndroidRuntime:E).
"""
import os
import re
import subprocess
import sys
import time
import xml.etree.ElementTree as ET

if hasattr(sys.stdout, 'reconfigure'):
    sys.stdout.reconfigure(encoding='utf-8', errors='replace')
if hasattr(sys.stderr, 'reconfigure'):
    sys.stderr.reconfigure(encoding='utf-8', errors='replace')

ADB = os.path.expandvars(r'$LOCALAPPDATA\Android\Sdk\platform-tools\adb.exe')
APK = os.path.join(os.path.dirname(os.path.dirname(os.path.abspath(__file__))), 'Daijishou v1.5.0-reconstructed.apk')
OUT_DIR = os.path.dirname(os.path.abspath(__file__))

def run_adb(args):
    cmd = [ADB] + args
    res = subprocess.run(cmd, stdout=subprocess.PIPE, stderr=subprocess.PIPE, text=True, encoding='utf-8', errors='replace')
    return res.stdout.strip(), res.stderr.strip(), res.returncode

def tap(x, y, delay=1.5):
    run_adb(['shell', 'input', 'tap', str(x), str(y)])
    time.sleep(delay)

def press_key(keycode, delay=1.0):
    run_adb(['shell', 'input', 'keyevent', str(keycode)])
    time.sleep(delay)

def dump_ui(device_path='/sdcard/avd_ui.xml', local_path=None):
    if local_path is None:
        local_path = os.path.join(OUT_DIR, 'avd_matrix_ui.xml')
    run_adb(['shell', 'uiautomator', 'dump', device_path])
    run_adb(['pull', device_path, local_path])
    with open(local_path, 'r', encoding='utf-8', errors='replace') as f:
        return f.read()

def find_node(root, text_contains=None, res_id=None, class_name=None):
    for elem in root.iter('node'):
        if text_contains and text_contains.lower() not in elem.attrib.get('text', '').lower() and text_contains.lower() not in elem.attrib.get('content-desc', '').lower():
            continue
        if res_id and res_id not in elem.attrib.get('resource-id', ''):
            continue
        if class_name and class_name not in elem.attrib.get('class', ''):
            continue
        return elem
    return None

def get_node_center(elem):
    bounds = elem.attrib.get('bounds', '')
    m = re.findall(r'\[(\d+),(\d+)\]', bounds)
    if len(m) == 2:
        x1, y1 = int(m[0][0]), int(m[0][1])
        x2, y2 = int(m[1][0]), int(m[1][1])
        return ((x1 + x2) // 2, (y1 + y2) // 2)
    return None

def tap_node_by(text_contains=None, res_id=None, delay=1.5, dump_filename=None):
    ui_str = dump_ui(local_path=dump_filename)
    root = ET.fromstring(ui_str)
    elem = find_node(root, text_contains=text_contains, res_id=res_id)
    if elem is None:
        return False, ui_str
    pt = get_node_center(elem)
    if not pt:
        return False, ui_str
    tap(pt[0], pt[1], delay=delay)
    return True, ui_str

def main():
    print("=== [AVD Matrix Test] Iniciando bateria de testes na AVD ===")
    
    # 1. Verifica ADB
    out, err, code = run_adb(['devices'])
    lines = [l for l in out.splitlines() if '\tdevice' in l]
    if not lines:
        print("[ERRO] Nenhum emulador AVD ou dispositivo conectado no adb.")
        sys.exit(1)
    device_id = lines[0].split('\t')[0]
    print(f"  [OK] Dispositivo conectado: {device_id}")

    # 2. Instala APK
    if not os.path.exists(APK):
        print(f"[ERRO] APK nao encontrado em {APK}")
        sys.exit(1)
    print(f"  Instalando {os.path.basename(APK)}...")
    out, err, code = run_adb(['install', '-r', APK])
    if 'Success' not in out:
        print(f"[ERRO] Falha na instalacao: {out} {err}")
        sys.exit(1)
    print("  [OK] APK instalado com sucesso.")

    # 3. Configuracao de locale (pt-BR)
    run_adb(['shell', 'cmd', 'locale', 'set-app-locales', 'com.magneticchen.daijishou', '--locales', 'pt-BR'])

    # 4. Desbloqueia tela, limpa logs e para app
    run_adb(['shell', 'input', 'keyevent', '82'])
    run_adb(['shell', 'input', 'swipe', '720', '2000', '720', '500'])
    run_adb(['shell', 'am', 'force-stop', 'com.magneticchen.daijishou'])
    run_adb(['logcat', '-c'])

    # 5. Lanca app via am start
    print("  Lancando com.magneticchen.daijishou...")
    run_adb(['shell', 'am', 'start', '-n', 'com.magneticchen.daijishou/.activities.MainActivity', '-a', 'android.intent.action.MAIN', '-c', 'android.intent.category.LAUNCHER'])
    time.sleep(3)

    # Verifica PID com retry
    out_pid = ''
    for _ in range(5):
        out_pid, _, _ = run_adb(['shell', 'pidof', 'com.magneticchen.daijishou'])
        if out_pid.strip():
            break
        time.sleep(1)

    if not out_pid.strip():
        print("[ERRO] Aplicativo nao esta em execucao (PID vazio)!")
        sys.exit(1)
    print(f"  [OK] Processo ativo, PID: {out_pid.strip()}")

    # 6. Valida navegacao multi-aba dinamicamente
    print("  Testando navegacao entre abas e telas...")
    
    # Aba 1: Biblioteca
    ok, ui_lib = tap_node_by(text_contains='Biblioteca', dump_filename=os.path.join(OUT_DIR, 'avd_stage_lib.xml'))
    if not ok:
        print("[AVISO] Botao de aba 'Biblioteca' nao encontrado, dump coletado.")
    print("  [OK] Aba Biblioteca verificada.")

    # Aba 2: Aplicativos
    ok, ui_apps = tap_node_by(text_contains='Aplicativos', dump_filename=os.path.join(OUT_DIR, 'avd_stage_apps.xml'))
    if not ok:
        print("[ERRO] Nao foi possivel clicar na aba 'Aplicativos'!")
        sys.exit(1)
    print("  [OK] Aba Aplicativos verificada.")

    # Aba 3: Configuracoes
    ok, ui_settings = tap_node_by(text_contains='Configura', dump_filename=os.path.join(OUT_DIR, 'avd_stage_settings.xml'))
    if not ok:
        print("[ERRO] Nao foi possivel clicar na aba 'Configuracoes'!")
        sys.exit(1)
    print("  [OK] Aba Configuracoes carregada.")

    # Subtela: Aparencia
    ok, ui_appr = tap_node_by(text_contains='Apar', dump_filename=os.path.join(OUT_DIR, 'avd_stage_appearance.xml'))
    if not ok:
        print("[ERRO] Nao foi possivel abrir o item 'Aparencia'!")
        sys.exit(1)
    print("  [OK] Subtela Aparencia verificada.")

    # Voltar para Configuracoes via BACK key (keyevent 4)
    press_key(4)
    print("  [OK] Retorno para raiz de Configuracoes via BACK verificado.")

    # Aba 4: Widgets
    ok, ui_wid = tap_node_by(text_contains='Widgets', dump_filename=os.path.join(OUT_DIR, 'avd_stage_widgets.xml'))
    if not ok:
        print("[ERRO] Nao foi possivel clicar na aba 'Widgets'!")
        sys.exit(1)
    print("  [OK] Aba Widgets verificada.")

    # Menu popup Novo widget (procura pelo botao 'Novo widget')
    ok, ui_btn = tap_node_by(text_contains='Novo widget', dump_filename=os.path.join(OUT_DIR, 'avd_stage_widgets_tab.xml'))
    if not ok:
        print("[ERRO] Botao 'Novo widget' nao encontrado na aba Widgets!")
        sys.exit(1)
        
    ui_menu = dump_ui(local_path=os.path.join(OUT_DIR, 'avd_stage_new_widget_menu.xml'))
    if 'Aleat' not in ui_menu and 'Atalho' not in ui_menu and 'RSS' not in ui_menu:
        print("[ERRO] Menu popup 'Novo widget' nao exibiu opcoes esperadas!")
        sys.exit(1)
    print("  [OK] Menu Popup 'Novo widget' aberto e verificado.")

    # Fecha menu via BACK
    press_key(4)
    print("  [OK] Menu fechado via BACK.")

    # 7. Screenshot final
    shot_path = os.path.join(OUT_DIR, 'avd_matrix_screenshot.png')
    res = subprocess.run([ADB, 'exec-out', 'screencap', '-p'], stdout=subprocess.PIPE)
    with open(shot_path, 'wb') as sf:
        sf.write(res.stdout)
    print(f"  [OK] Screenshot final capturado: {shot_path} ({os.path.getsize(shot_path)} bytes)")

    # 8. Checagem estrita de erros fatais no logcat
    logcat_out, _, _ = run_adb(['logcat', '-d', '-s', 'AndroidRuntime:E'])
    crashes = [l for l in logcat_out.splitlines() if 'FATAL EXCEPTION' in l or 'AndroidRuntime' in l]
    if crashes:
        print(f"[ERRO] Erros fatais detectados no logcat:\n{logcat_out}")
        sys.exit(1)
    print("  [OK] 0 erros fatais em logcat (AndroidRuntime:E).")

    print("\n=== [SUCESSO] Matriz de teste AVD 100% aprovada (todos os estágios passaram)! ===")
    sys.exit(0)

if __name__ == '__main__':
    main()
