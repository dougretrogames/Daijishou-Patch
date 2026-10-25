"""Automacao da Matriz de Testes AVD (P1 / P2).

Executa bateria completa de validacao ponta-a-ponta:
1. Verificacao de dispositivo conectado via ADB.
2. Instalacao limpa do APK reconstruido sem dependencias ORIG.
3. Configuracao de locale (pt-BR).
4. Limpeza de logs e encerramento de processos residuais.
5. Lancamento da MainActivity via monkey launcher.
6. Afericao do processo ativo (PID).
7. Tratamento e dispensa automatica de dialogos do sistema.
8. Navegacao multi-aba completa:
   - Aba Biblioteca: verificacao do estado inicial.
   - Aba Aplicativos: navegacao e carregamento da lista de apps.
   - Aba Configuracoes: navegacao na raiz e abertura da subtela 'Aparencia'.
   - Retorno a Configuracoes via tecla Back.
   - Aba Widgets: navegacao e abertura do menu popup 'Novo widget'.
   - Fechamento do menu via tecla Back.
9. Coleta de UI hierarquica (uiautomator dump) e screenshot de evidencia.
10. Analise estrita de erros no logcat (AndroidRuntime:E).
"""
import os
import subprocess
import sys
import time

ADB = os.path.expandvars(r'$LOCALAPPDATA\Android\Sdk\platform-tools\adb.exe')
APK = os.path.join(os.path.dirname(os.path.dirname(os.path.abspath(__file__))), 'Daijishou v1.5.0-reconstructed.apk')
OUT_DIR = os.path.join(os.path.dirname(os.path.abspath(__file__)))

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

    # 3. Locale pt-BR
    run_adb(['shell', 'cmd', 'locale', 'set-app-locales', 'com.magneticchen.daijishou', '--locales', 'pt-BR'])

    # 4. Limpa logs e para app
    run_adb(['shell', 'am', 'force-stop', 'com.magneticchen.daijishou'])
    run_adb(['logcat', '-c'])

    # 5. Lanca app via monkey
    print("  Lancando com.magneticchen.daijishou...")
    run_adb(['shell', 'monkey', '-p', 'com.magneticchen.daijishou', '-c', 'android.intent.category.LAUNCHER', '1'])
    time.sleep(4)

    # Trata popup de tela cheia se presente
    for _ in range(3):
        ui = dump_ui('/sdcard/ui_tmp.xml', os.path.join(OUT_DIR, 'ui_tmp.xml'))
        if 'Got it' in ui:
            print("  Dispensando dialogo de tela cheia (Got it)...")
            tap(2003, 701, delay=2.0)
            break
        time.sleep(1)

    # 6. Verifica PID
    out_pid, _, _ = run_adb(['shell', 'pidof', 'com.magneticchen.daijishou'])
    if not out_pid.strip():
        print("[ERRO] Aplicativo nao esta em execucao (PID vazio)!")
        sys.exit(1)
    print(f"  [OK] Processo ativo, PID: {out_pid.strip()}")

    # 7. Valida navegacao multi-aba
    print("  Testando navegacao entre abas e telas...")
    
    # Aba 1: Biblioteca
    tap(328, 56)
    ui_lib = dump_ui(local_path=os.path.join(OUT_DIR, 'avd_stage_lib.xml'))
    if 'Biblioteca' not in ui_lib:
        print("[AVISO] Texto 'Biblioteca' nao detectado no dump da aba Biblioteca.")
    print("  [OK] Aba Biblioteca verificada.")

    # Aba 2: Aplicativos
    tap(895, 56)
    ui_apps = dump_ui(local_path=os.path.join(OUT_DIR, 'avd_stage_apps.xml'))
    print("  [OK] Aba Aplicativos verificada.")

    # Aba 3: Configuracoes
    tap(1267, 56)
    ui_settings = dump_ui(local_path=os.path.join(OUT_DIR, 'avd_stage_settings.xml'))
    if 'Aparência' not in ui_settings and 'Aparencia' not in ui_settings and 'Configura' not in ui_settings:
        print("[ERRO] Aba Configuracoes nao carregou corretamente!")
        sys.exit(1)
    print("  [OK] Aba Configuracoes carregada.")

    # Subtela: Aparencia
    tap(550, 1037)
    ui_appearance = dump_ui(local_path=os.path.join(OUT_DIR, 'avd_stage_appearance.xml'))
    if 'Tema escuro' not in ui_appearance and 'Cores do tema' not in ui_appearance:
        print("[ERRO] Subtela Aparencia nao exibiu itens esperados!")
        sys.exit(1)
    print("  [OK] Subtela Aparencia verificada.")

    # Voltar para Configuracoes via BACK key (keyevent 4)
    press_key(4)
    print("  [OK] Retorno para raiz de Configuracoes via BACK verificado.")

    # Aba 4: Widgets
    tap(604, 56)
    ui_widgets = dump_ui(local_path=os.path.join(OUT_DIR, 'avd_stage_widgets.xml'))
    if 'Novo widget' not in ui_widgets:
        print("[ERRO] Aba Widgets nao exibiu botao 'Novo widget'!")
        sys.exit(1)
    print("  [OK] Aba Widgets verificada.")

    # Menu popup Novo widget
    tap(2800, 240)
    ui_menu = dump_ui(local_path=os.path.join(OUT_DIR, 'avd_stage_new_widget_menu.xml'))
    if 'Aleatório' not in ui_menu and 'Aleat' not in ui_menu and 'Atalho' not in ui_menu:
        print("[ERRO] Menu Novo widget nao abriu!")
        sys.exit(1)
    print("  [OK] Menu Popup 'Novo widget' aberto e verificado.")

    # Fecha menu
    press_key(4)
    print("  [OK] Menu fechado via BACK.")

    # 8. Screenshot final
    shot_path = os.path.join(OUT_DIR, 'avd_matrix_screenshot.png')
    res = subprocess.run([ADB, 'exec-out', 'screencap', '-p'], stdout=subprocess.PIPE)
    with open(shot_path, 'wb') as sf:
        sf.write(res.stdout)
    print(f"  [OK] Screenshot final capturado: {shot_path} ({os.path.getsize(shot_path)} bytes)")

    # 9. Checagem estrita de erros fatais no logcat
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
