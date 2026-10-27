import os

src_dir = 'app_sources/sources/com/magneticchen/daijishou/daijishou_debug_service'
dst_dir = 'build_tmp/sources_181_merged/com/magneticchen/daijishou/service/debug'

# 1. Adapt and copy DaijishouDebugService$DaijishouDebugServiceTcpClient$start$1.java
f_aux = 'DaijishouDebugService$DaijishouDebugServiceTcpClient$start$1.java'
with open(os.path.join(src_dir, f_aux), 'r', encoding='utf-8') as f:
    c = f.read()

c = c.replace('package com.magneticchen.daijishou.daijishou_debug_service;', 'package com.magneticchen.daijishou.service.debug;')
c = c.replace('com.magneticchen.daijishou.daijishou_debug_service.passive_protocol.', 'com.magneticchen.daijishou.service.debug.passive_protocol.')
c = c.replace('com.magneticchen.daijishou.daijishou_debug_service.', 'com.magneticchen.daijishou.service.debug.')

with open(os.path.join(dst_dir, f_aux), 'w', encoding='utf-8') as f:
    f.write(c)

# 2. Adapt DaijishouDebugService.java
with open(os.path.join(src_dir, 'DaijishouDebugService.java'), 'r', encoding='utf-8') as f:
    c = f.read()

c = c.replace('package com.magneticchen.daijishou.daijishou_debug_service;', 'package com.magneticchen.daijishou.service.debug;')
c = c.replace('com.magneticchen.daijishou.activities.BootstrapActivity;', 'com.magneticchen.daijishou.ui.activities.BootstrapActivity;')
c = c.replace('com.magneticchen.daijishou.activities.abstract_classes.DaijishouService;', 'com.magneticchen.daijishou.ui.activities.abstract_classes.DaijishouService;')
c = c.replace('com.magneticchen.daijishou.daijishou_debug_service.passive_protocol.', 'com.magneticchen.daijishou.service.debug.passive_protocol.')
c = c.replace('com.magneticchen.daijishou.daijishou_debug_service.', 'com.magneticchen.daijishou.service.debug.')

with open(os.path.join(dst_dir, 'DaijishouDebugService.java'), 'w', encoding='utf-8') as f:
    f.write(c)

print('DaijishouDebugService adapted successfully!')
