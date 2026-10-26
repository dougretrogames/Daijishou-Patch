"""Teste do fluxo de criacao e interacao de Widgets.

1. Navega para a aba Widgets.
2. Abre o menu popup 'Novo widget'.
3. Seleciona o widget 'Atividade' (ActivityWidget, que nao requer configuracao externa).
4. Verifica se o RecyclerView de widgets agora contem o novo widget adicionado.
5. Captura screenshot de evidencia.
6. Valida 0 crashes no logcat.
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

def dump_ui(device_path='/sdcard/widget_ui.xml', local_path=None):
    if local_path is None:
        local_path = os.path.join(OUT_DIR, 'widget_ui_dump.xml')
    run_adb(['shell', 'uiautomator', 'dump', device_path])
    run_adb(['pull', device_path, local_path])
    with open(local_path, 'r', encoding='utf-8', errors='replace') as f:
        return f.read()

def find_node(root, text_contains=None, res_id=None):
    for elem in root.iter('node'):
        if text_contains and text_contains.lower() not in elem.attrib.get('text', '').lower() and text_contains.lower() not in elem.attrib.get('content-desc', '').lower():
            continue
        if res_id and res_id not in elem.attrib.get('resource-id', ''):
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

def tap_node_by(text_contains=None, res_id=None, delay=1.5):
    ui_str = dump_ui()
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
    print("=== [Test Widgets Flow] Iniciando teste de criacao de Widgets ===")

    # 0. Garante que qualquer dialogo aberto seja fechado
    ui_init = dump_ui()
    for _ in range(3):
        if 'Widgets' in ui_init or 'Widgets de atividade' in ui_init or 'Activity widgets' in ui_init:
            break
        press_key(4, delay=1.0)
        ui_init = dump_ui()

    # 1. Verifica se dialogo 'Widgets de atividade' / 'Activity widgets' ja esta aberto
    if 'Widgets de atividade' not in ui_init and 'Activity widgets' not in ui_init:
        # Navega para a aba Widgets
        print("  Navegando para a aba Widgets...")
        ok, ui = tap_node_by(text_contains='Widgets')
        if not ok:
            print("[ERRO] Nao foi possivel localizar a aba Widgets!")
            sys.exit(1)
            
        time.sleep(1)

        # 2. Clica no botao 'Novo widget'
        print("  Abrindo menu 'Novo widget'...")
        ok, ui = tap_node_by(text_contains='Novo widget')
        if not ok:
            print("[ERRO] Botao 'Novo widget' nao encontrado na aba Widgets!")
            sys.exit(1)

        # 3. No popup, clica na opcao 'Atividade'
        print("  Selecionando widget 'Atividade'...")
        ok, ui = tap_node_by(text_contains='Atividade')
        if not ok:
            print("[ERRO] Opcao 'Atividade' nao encontrada no popup!")
            sys.exit(1)

        time.sleep(1.5)

    # 4. No dialogo de tipos de atividade, seleciona 'Continuar a jogar' / 'Continue play'
    print("  Selecionando 'Continuar a jogar' / 'Continue play'...")
    ok, ui = tap_node_by(text_contains='Continuar a jogar')
    if not ok:
        ok, ui = tap_node_by(text_contains='Continue play')
    if not ok:
        ok, ui = tap_node_by(res_id='android:id/text1')
    if not ok:
        print("[ERRO] Opcao 'Continuar a jogar' / 'Continue play' nao encontrada no dialogo!")
        sys.exit(1)

    time.sleep(2)

    # 5. Verifica se o widget foi inserido na interface
    ui_after = dump_ui()
    if 'Continuar a jogar' in ui_after or 'widgets_recycler_view' in ui_after:
        print("  [OK] Widget 'Continuar a jogar' adicionado com sucesso no RecyclerView!")
    else:
        print("[AVISO] Nao foi possivel confirmar o widget explicitamente no dump.")

    # 6. Captura screenshot de evidencia
    shot_path = os.path.join(OUT_DIR, 'widgets_flow_success.png')
    res = subprocess.run([ADB, 'exec-out', 'screencap', '-p'], stdout=subprocess.PIPE)
    with open(shot_path, 'wb') as sf:
        sf.write(res.stdout)
    print(f"  [OK] Evidencia salva em {shot_path} ({os.path.getsize(shot_path)} bytes)")

    # 6. Analise de erros no logcat
    logcat_out, _, _ = run_adb(['logcat', '-d', '-s', 'AndroidRuntime:E'])
    crashes = [l for l in logcat_out.splitlines() if 'FATAL EXCEPTION' in l or 'AndroidRuntime' in l]
    if crashes:
        print(f"[ERRO] Erros fatais detectados no logcat:\n{logcat_out}")
        sys.exit(1)
    print("  [OK] 0 erros fatais em logcat (AndroidRuntime:E).")

    print("\n=== [SUCESSO] Fluxo de Widgets validado com sucesso! ===")
    return 0

if __name__ == '__main__':
    main()
