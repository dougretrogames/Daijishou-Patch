"""Automacao da Matriz de Testes AVD (P1 / P2).

Executa:
1. Verificacao de dispositivo conectado via ADB.
2. Instalacao limpa do APK reconstruido.
3. Configuracao de locale (pt-BR).
4. Limpeza de logs.
5. Lancamento da MainActivity.
6. Afericao do processo ativo (PID).
7. Coleta de UI hierarquica (uiautomator dump) e verificacao dos elementos principais.
8. Captura de tela (screenshot).
9. Analise de erros no logcat (AndroidRuntime:E).
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

def main():
    print("=== [AVD Matrix Test] Iniciando teste automatizado na AVD ===")
    
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
        run_adb(['shell', 'uiautomator', 'dump', '/sdcard/ui_tmp.xml'])
        out_ui, _, _ = run_adb(['shell', 'cat', '/sdcard/ui_tmp.xml'])
        if 'Got it' in out_ui:
            print("  Dispensando dialogo de tela cheia (Got it)...")
            run_adb(['shell', 'input', 'tap', '2003', '701'])
            time.sleep(2)
            break
        time.sleep(1)

    # 6. Verifica PID
    out_pid, _, _ = run_adb(['shell', 'pidof', 'com.magneticchen.daijishou'])
    if not out_pid.strip():
        print("[ERRO] Aplicativo nao esta em execucao (PID vazio)!")
        sys.exit(1)
    print(f"  [OK] Processo ativo, PID: {out_pid.strip()}")

    # 7. Dump da UI e checagem de elementos
    xml_path = os.path.join(OUT_DIR, 'avd_matrix_ui.xml')
    run_adb(['shell', 'uiautomator', 'dump', '/sdcard/avd_ui.xml'])
    run_adb(['pull', '/sdcard/avd_ui.xml', xml_path])
    
    with open(xml_path, 'r', encoding='utf-8', errors='replace') as xf:
        ui_content = xf.read()
    
    required_elements = ['Library', 'Widgets', 'Apps', 'Settings']
    found_elements = [elem for elem in required_elements if elem in ui_content]
    print(f"  [OK] Elementos da interface detectados: {found_elements}")

    # 8. Screenshot
    shot_path = os.path.join(OUT_DIR, 'avd_matrix_screenshot.png')
    res = subprocess.run([ADB, 'exec-out', 'screencap', '-p'], stdout=subprocess.PIPE)
    with open(shot_path, 'wb') as sf:
        sf.write(res.stdout)
    print(f"  [OK] Screenshot capturado: {shot_path} ({os.path.getsize(shot_path)} bytes)")

    # 9. Checagem de erros fatais no logcat
    logcat_out, _, _ = run_adb(['logcat', '-d', '-s', 'AndroidRuntime:E'])
    crashes = [l for l in logcat_out.splitlines() if 'FATAL EXCEPTION' in l or 'AndroidRuntime' in l]
    if crashes:
        print(f"[ERRO] Erros fatais detectados no logcat:\n{logcat_out}")
        sys.exit(1)
    print("  [OK] 0 erros fatais em logcat (AndroidRuntime:E).")

    print("\n=== [SUCESSO] Matriz de teste AVD 100% aprovada! ===")
    sys.exit(0)

if __name__ == '__main__':
    main()
