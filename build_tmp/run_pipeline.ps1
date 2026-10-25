$ErrorActionPreference = 'Stop'
$bt = 'C:\Users\Douglas\Documents\Daijishou\build_tmp'
Set-Location $bt
Remove-Item -Recurse -Force smali_recon
Copy-Item smali_compiled smali_recon -Recurse
python -I build_member_map.py | Select-Object -First 4
python -I patch_stubs.py | Select-Object -First 4
python -I patch_closure.py | Select-Object -First 3
python -I patch_members.py | Select-Object -First 3
python -I patch_align.py | Select-Object -First 20
python -I patch_stub_bodies.py
python -I patch_align.py | Select-Object -First 20
python -I patch_visibility.py
python -I patch_inject_members.py | Select-Object -First 4
python -I patch_invokes.py
