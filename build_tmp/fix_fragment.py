p = 'build_tmp/sources_181_merged/com/magneticchen/daijishou/ui/fragments/p000abstract/DaijishouFragment.java'
with open(p, 'r', encoding='utf-8') as f:
    c = f.read()

target = 'MainActivity mainActivityRequireActivity = this.this$0.requireActivity();'
replacement = 'MainActivity mainActivityRequireActivity = (MainActivity) DaijishouFragment.this.requireActivity();'

assert target in c, 'target not found'
c = c.replace(target, replacement)

with open(p, 'w', encoding='utf-8') as f:
    f.write(c)

print('Fixed DaijishouFragment.java successfully')
