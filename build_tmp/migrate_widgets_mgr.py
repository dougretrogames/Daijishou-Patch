import os

src_dir = 'app_sources/sources/com/magneticchen/daijishou/daijishou_widget'
dst_dir = 'build_tmp/sources_181_merged/com/magneticchen/daijishou/ui/widget'

files = [
    'WidgetsManager.java',
    'WidgetsManager$resetAndInitialize$2$1.java',
    'WidgetsManager$widgetInstancesLiveData$2.java',
    'WidgetsManager$$ExternalSyntheticLambda0.java',
    'WidgetsManager$$ExternalSyntheticLambda1.java'
]

for fname in files:
    src_p = os.path.join(src_dir, fname)
    if not os.path.exists(src_p):
        continue
    with open(src_p, 'r', encoding='utf-8') as f:
        c = f.read()
    
    c = c.replace('package com.magneticchen.daijishou.daijishou_widget;', 'package com.magneticchen.daijishou.ui.widget;')
    c = c.replace('package com.magneticchen.daijishou.daijishou_widget.', 'package com.magneticchen.daijishou.ui.widget.')
    c = c.replace('com.magneticchen.daijishou.daijishou_widget.abstract_widget_classes.', 'com.magneticchen.daijishou.ui.widget.abstract_widget_classes.')
    c = c.replace('com.magneticchen.daijishou.daijishou_widget.widgets.', 'com.magneticchen.daijishou.ui.widget.widgets.')
    c = c.replace('com.magneticchen.daijishou.daijishou_widget.widget_db.WidgetInstanceEntity', 'com.magneticchen.daijishou.data.db.entity.WidgetInstanceEntity')
    c = c.replace('com.magneticchen.daijishou.repositories.DaijishouWidgetRepository', 'com.magneticchen.daijishou.data.db.repositories.DaijishouWidgetRepository')
    c = c.replace('com.magneticchen.daijishou.daijishou_widget.', 'com.magneticchen.daijishou.ui.widget.')
    
    with open(os.path.join(dst_dir, fname), 'w', encoding='utf-8') as f:
        f.write(c)

print('WidgetsManager migrated successfully!')
