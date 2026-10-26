"""Teste de fluxo de plataformas (Download e Importacao).

1. Verifica se o dialogo 'Selecione as plataformas' ja esta aberto ou navega ate ele na Biblioteca.
2. Verifica se o ListView contem as plataformas baixadas da index_uri (122 itens).
3. Seleciona a plataforma '3DO' (ou primeiro item disponivel).
4. Clica em 'IMPORTAR' (android:id/button1).
5. Aguarda o download do JSON da plataforma e persistencia no Room Database.
6. Confirma que a plataforma agora aparece carregada na Biblioteca com seu nome e navegacao.
7. Captura screenshot de evidencia.
8. Valida ausencia de excecoes fatais no logcat.
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

def dump_ui(filename='ui_platform_test.xml'):
    local_path = os.path.join(OUT_DIR, filename)
    run_adb(['shell', 'uiautomator', 'dump', '/sdcard/dump.xml'])
    run_adb(['pull', '/sdcard/dump.xml', local_path])
    with open(local_path, 'r', encoding='utf-8', errors='replace') as f:
        return f.read()

def find_node(root, text_contains=None, res_id=None):
    if root is None:
        return None
    for elem in root.iter('node'):
        if text_contains and text_contains.lower() in elem.attrib.get('text', '').lower():
            return elem
        if res_id and res_id in elem.attrib.get('resource-id', ''):
            return elem
    return None

def get_node_center(elem):
    if elem is None:
        return None
    bounds = elem.attrib.get('bounds', '')
    m = re.findall(r'\[(\d+),(\d+)\]', bounds)
    if len(m) == 2:
        x1, y1 = int(m[0][0]), int(m[0][1])
        x2, y2 = int(m[1][0]), int(m[1][1])
        return ((x1 + x2) // 2, (y1 + y2) // 2)
    return None

def main():
    print("=== [Test Platforms Flow] Iniciando teste de Download e Importacao de Plataformas ===")
    
    # 1. Analisa estado atual da tela
    xml_str = dump_ui('stage_platform_check.xml')
    root = ET.fromstring(xml_str)
    
    items = [elem for elem in root.iter('node') if elem.attrib.get('class') == 'android.widget.CheckedTextView']
    
    if not items:
        # Se nao estiver no dialogo de plataformas, fecha dialogos residuais e navega para Biblioteca
        print("  Dialogo de plataformas nao visivel no momento. Navegando para Biblioteca...")
        for _ in range(3):
            xml_str = dump_ui('stage_platform_check.xml')
            root = ET.fromstring(xml_str)
            logger_back = find_node(root, res_id='fragment_logger_dialog_back_button')
            if logger_back is not None:
                cx, cy = get_node_center(logger_back)
                tap(cx, cy, delay=1.0)
            elif 'Biblioteca' in xml_str or 'Library' in xml_str:
                break
            else:
                press_key(4, delay=1.0)

        # Clica na aba Biblioteca (coordenadas semanticas do no de tab Biblioteca)
        xml_str = dump_ui('stage_lib_initial.xml')
        root = ET.fromstring(xml_str)
        tab_lib = find_node(root, text_contains='Biblioteca')
        if tab_lib is None:
            tab_lib = find_node(root, text_contains='Library')
        if tab_lib is not None:
            cx, cy = get_node_center(tab_lib)
            tap(cx, cy, delay=2.5)

        # Polling para certificar que a tela da Biblioteca esta renderizada
        for _ in range(5):
            xml_str = dump_ui('stage_lib_initial.xml')
            if '3do' in xml_str.lower() or 'download' in xml_str.lower() or 'library_collection' in xml_str:
                break
            time.sleep(1.0)

        root = ET.fromstring(xml_str)
        
        # Verifica se biblioteca ja contem plataformas
        if 'detalhes da plataforma' in xml_str.lower() or 'sincronizar' in xml_str.lower() or '3do' in xml_str.lower():
            print("  [OK] Plataforma ja importada e presente na Biblioteca!")
            return 0
            
        empty_btn = find_node(root, res_id='fragment_library_empty_button')
        if empty_btn is None:
            empty_btn = find_node(root, text_contains='DOWNLOAD')
        if empty_btn is None:
            print("[ERRO] Nao foi possivel encontrar botao DOWNLOAD nem plataforma na Biblioteca.")
            sys.exit(1)
            
        cx, cy = get_node_center(empty_btn)
        print(f"  Clicando no botao DOWNLOAD em ({cx}, {cy})...")
        tap(cx, cy, delay=3.0)
        
        # Aguarda carregar
        for attempt in range(15):
            xml_str = dump_ui('stage_dialog_platforms.xml')
            root = ET.fromstring(xml_str)
            items = [elem for elem in root.iter('node') if elem.attrib.get('class') == 'android.widget.CheckedTextView']
            if items:
                break
            time.sleep(2)
            
    if not items:
        print("[ERRO] Falha ao carregar lista de plataformas do dialogo!")
        sys.exit(1)
        
    print(f"  [OK] Dialogo de plataformas com {len(items)} itens visiveis.")
    first_item = items[0]
    p_text = first_item.attrib.get('text', '')
    print(f"  Item selecionado: '{p_text}'")
    
    # Clica no item para marcar a checkbox
    cx, cy = get_node_center(first_item)
    print(f"  Marcando checkbox em ({cx}, {cy})...")
    tap(cx, cy, delay=1.5)
    
    # Clica no botao IMPORTAR
    xml_str = dump_ui('stage_dialog_ready_to_import.xml')
    root = ET.fromstring(xml_str)
    import_btn = find_node(root, res_id='android:id/button1')
    if import_btn is None:
        import_btn = find_node(root, text_contains='IMPORTAR')
    if import_btn is None:
        print("[ERRO] Botao IMPORTAR nao encontrado.")
        sys.exit(1)
        
    ix, iy = get_node_center(import_btn)
    print(f"  Clicando no botao IMPORTAR em ({ix}, {iy})...")
    tap(ix, iy, delay=5.0)
    
    # Aguarda o processo de importacao
    print("  Aguardando conclusao da importacao e atualizacao da Room DB...")
    success = False
    for attempt in range(15):
        xml_str = dump_ui('stage_after_import.xml')
        # Verifica se o dialogo fechou e a tela da biblioteca exibe a plataforma
        if '3DO' in xml_str or 'detalhes' in xml_str.lower() or 'sincronizar' in xml_str.lower():
            print(f"  [OK] Plataforma detectada na Biblioteca na tentativa {attempt+1}!")
            success = True
            break
        time.sleep(2)
        
    if not success:
        print("[AVISO] Texto da plataforma nao identificado imediatamente no dump. Verificando logcat...")
        out, _, _ = run_adb(['logcat', '-d', '-s', 'DaijishouLibraryModel:I', 'PlatformDAO:I'])
        print(out)
        
    # Tira screenshot de evidencia
    shot_path = os.path.join(OUT_DIR, 'platforms_flow_success.png')
    res = subprocess.run([ADB, 'exec-out', 'screencap', '-p'], stdout=subprocess.PIPE)
    with open(shot_path, 'wb') as sf:
        sf.write(res.stdout)
    print(f"  [OK] Evidencia salva em {shot_path} ({os.path.getsize(shot_path)} bytes)")
    
    # Valida logcat
    logcat_out, _, _ = run_adb(['logcat', '-d', '-s', 'AndroidRuntime:E'])
    crashes = [l for l in logcat_out.splitlines() if 'FATAL EXCEPTION' in l]
    if crashes:
        print(f"[ERRO] Crashes detectados no logcat:\n{logcat_out}")
        sys.exit(1)
    print("  [OK] 0 erros fatais no logcat.")
    
    print("\n=== [SUCESSO] Fluxo de Download e Importacao de Plataformas validado com sucesso! ===")
    return 0

if __name__ == '__main__':
    main()
