"""
test_debug_service.py - Automacao de teste do servico TCP DaijishouDebugService (P2).

Roteiro:
1. Navega ate Configuracoes e rola ate encontrar 'Registrador'.
2. Abre LoggerDialogFragment.
3. Injeta o codigo secreto 'nooxyhowdoyouturnthison?'.
4. Trata e interage com DebugAndExperimentalDialogFragment para iniciar o servico de debug.
5. Concede permissao de notificacao (POST_NOTIFICATIONS) se solicitado.
6. Fecha dialogos e retorna para a MainActivity.
7. Configura adb forward para a porta 19487.
8. Conecta via socket TCP ao DaijishouDebugService e envia opcode Heartbeat (0x00).
9. Valida a resposta do protocolo passivo do servico.
10. Valida ausencia de erros no logcat.
"""
import os
import sys
import time
import socket
import struct
import subprocess

ADB = os.path.expandvars(r'$LOCALAPPDATA\Android\Sdk\platform-tools\adb.exe')

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

def get_ui():
    run_adb(['shell', 'uiautomator', 'dump', '/sdcard/tmp_ui.xml'])
    out, _, _ = run_adb(['shell', 'cat', '/sdcard/tmp_ui.xml'])
    return out

def main():
    print("=== [P2 Test] Testando DaijishouDebugService via TCP ===")

    # 1. Navega para Configuracoes
    print("  Navegando para Configuracoes...")
    tap(1267, 56)
    time.sleep(1)

    # Rola ate o fim para alcancar Registrador
    print("  Rolando tela de configuracoes...")
    run_adb(['shell', 'input', 'swipe', '1000', '1100', '1000', '300', '300'])
    time.sleep(1.5)

    ui = get_ui()
    if 'Registrador' not in ui:
        print("[AVISO] 'Registrador' nao encontrado apos swipe, tentando mais uma rolagem...")
        run_adb(['shell', 'input', 'swipe', '1000', '1100', '1000', '300', '300'])
        time.sleep(1.5)

    # 2. Abre Registrador
    print("  Abrindo Registrador (LoggerDialogFragment)...")
    tap(568, 1192)
    time.sleep(2)

    # 3. Digita codigo secreto
    print("  Digitando codigo secreto...")
    tap(1639, 192) # foca no campo de busca
    time.sleep(1)
    run_adb(['shell', 'input', 'text', 'nooxyhowdoyouturnthison\\?'])
    
    # Aguarda dialogo 'Debug and experimental' com polling
    dialog_opened = False
    for _ in range(6):
        time.sleep(1)
        ui = get_ui()
        if 'Debug and experimental' in ui:
            dialog_opened = True
            break
            
    if not dialog_opened:
        print("[ERRO] Dialogo 'Debug and experimental' nao abriu!")
        sys.exit(1)
    print("  [OK] Dialogo 'Debug and experimental' aberto com sucesso.")

    # 4. Inicia Servico de Debug
    print("  Clicando em 'START DEBUG SERVICE'...")
    tap(920, 726)
    time.sleep(2)

    # 5. Concede permissao se houver popup
    ui_perm = get_ui()
    if 'Allow' in ui_perm or 'Permitir' in ui_perm:
        print("  Concedendo permissao POST_NOTIFICATIONS...")
        tap(1631, 731)
        time.sleep(2)

    # 6. Fecha dialogos
    print("  Fechando dialogos...")
    tap(2300, 1258) # DONE no debug dialog
    time.sleep(1.5)
    tap(168, 192)   # Clica explicitamente no fragment_logger_dialog_back_button
    time.sleep(1.0)
    press_key(4)    # Garante fechamento
    time.sleep(1.5)

    # 7. Configura adb forward
    print("  Configurando adb forward para porta 19487...")
    run_adb(['forward', 'tcp:19487', 'tcp:19487'])
    time.sleep(1)

    # 8. Testa conexao TCP e Heartbeat
    print("  Conectando ao DaijishouDebugService via socket TCP (127.0.0.1:19487)...")
    try:
        s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
        s.settimeout(5.0)
        s.connect(('127.0.0.1', 19487))
        print("  [OK] Conexao TCP estabelecida com sucesso.")

        # Envia opcode Heartbeat (0x00)
        print("  Enviando opcode Heartbeat (0x00)...")
        s.sendall(b'\x00')

        resp = s.recv(1)
        if resp != b'\x00':
            print(f"[ERRO] Resposta inesperada do Heartbeat: {resp}")
            s.close()
            sys.exit(1)
        print(f"  [OK] Heartbeat confirmado com sucesso (resposta: {resp})!")
        s.close()
    except Exception as e:
        print(f"[ERRO] Falha na comunicacao TCP: {e}")
        sys.exit(1)

    # 9. Checagem de erros fatais no logcat
    logcat_out, _, _ = run_adb(['logcat', '-d', '-s', 'AndroidRuntime:E'])
    crashes = [l for l in logcat_out.splitlines() if 'FATAL EXCEPTION' in l or 'AndroidRuntime' in l]
    if crashes:
        print(f"[ERRO] Erros fatais detectados no logcat:\n{logcat_out}")
        sys.exit(1)
    print("  [OK] 0 erros fatais em logcat (AndroidRuntime:E).")

    print("\n=== [SUCESSO] DaijishouDebugService TCP passive protocol testado e aprovado! ===")
    sys.exit(0)

if __name__ == '__main__':
    main()
