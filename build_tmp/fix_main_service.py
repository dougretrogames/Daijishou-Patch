p = 'build_tmp/sources_181_merged/com/magneticchen/daijishou/ui/activities/DaijishouMainService.java'
with open(p, 'r', encoding='utf-8') as f:
    c = f.read()

c = c.replace('this.this$0', 'DaijishouMainService.this')

with open(p, 'w', encoding='utf-8') as f:
    f.write(c)

print('Fixed DaijishouMainService.java successfully')
