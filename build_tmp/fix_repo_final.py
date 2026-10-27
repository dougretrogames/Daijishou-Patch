p = 'build_tmp/sources_181_merged/com/magneticchen/daijishou/data/db/repositories/DaijishouLibraryRepository.java'
with open(p, 'r', encoding='utf-8') as f:
    c = f.read()

c = c.replace('for (Map.Entry entry : map.entrySet()) {', 'for (Object obj_entry : map.entrySet()) {\n            Map.Entry entry = (Map.Entry) obj_entry;')

with open(p, 'w', encoding='utf-8') as f:
    f.write(c)

print('Fixed map.entrySet in DaijishouLibraryRepository.java')
