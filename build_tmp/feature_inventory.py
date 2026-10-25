import os, re

root = r'C:\Users\Douglas\Documents\Daijishou\jadx_nest\sources\com\magneticchen\daijishou'

def top(rel):
    d = os.path.join(root, rel)
    return sorted(f[:-5] for f in os.listdir(d) if f.endswith('.java')) if os.path.isdir(d) else []

for rel in ['activities', 'daijishou_player', 'daijishou_uri', 'service', 'google_drive',
            'backup_and_restore', 'daijishou_recycler_view', 'repositories', 'cache', 'application_data']:
    print('==', rel)
    print('  ' + ', '.join(top(rel)))

print('== scraper tree')
for dp, _, fns in os.walk(os.path.join(root, 'scraper')):
    for fn in fns:
        if fn.endswith('.java') and '$$' not in fn and '$' not in fn:
            print('  ', os.path.relpath(os.path.join(dp, fn), root))

print('== widget dirs')
w = os.path.join(root, 'daijishou_widget', 'widgets')
if os.path.isdir(w):
    print('  ' + ', '.join(sorted(os.listdir(w))))

print('== db entities')
d = os.path.join(root, 'daijishou_library_db')
print('  ' + ', '.join(sorted(f for f in os.listdir(d) if f.endswith('Entity.java'))))
print('== db daos')
print('  ' + ', '.join(sorted(f for f in os.listdir(d) if f.endswith('DAO.java'))))
print('== db others')
print('  ' + ', '.join(sorted(f for f in os.listdir(d) if not f.endswith(('Entity.java', 'DAO.java')))))
