"""Compara o conjunto de metodos-stub do APK final com o do ORIG.

Se forem iguais, os stubs que sobraram nao sao regressao da reconstrucao:
o APK original tambem os tem (sao guardas do compilador Kotlin para
`super.foo$default` em interfaces, ou metodos que o app nunca chama).
"""
import os
import re

BASE = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))
SCOPE = 'com/magneticchen/daijishou'
METHOD_RE = re.compile(r'^\.method\s+(?:[\w\- ]+\s+)*([\w$<>]+)(\(.*)$')


def collect(root):
    out = {}
    base = os.path.join(root, *SCOPE.split('/'))
    for dp, _, fs in os.walk(base):
        for f in fs:
            if not f.endswith('.smali'):
                continue
            p = os.path.join(dp, f)
            rel = os.path.relpath(p, root).replace('\\', '/')[:-6]
            cur = None
            with open(p, encoding='utf-8', errors='replace') as fh:
                for line in fh:
                    m = METHOD_RE.match(line)
                    if m:
                        cur = (m.group(1), m.group(2).strip())
                        continue
                    if line.startswith('.end method'):
                        cur = None
                        continue
                    if cur and 'UnsupportedOperationException' in line:
                        out.setdefault(rel, set()).add(cur)
                        cur = None
    return out


def main():
    a = collect(os.path.join(BASE, 'build_tmp', 'smali_recon'))
    b = collect(os.path.join(BASE, 'smali_orig_app'))
    na = sum(len(v) for v in a.values())
    nb = sum(len(v) for v in b.values())
    print('stub methods no APK reconstruido : %d em %d classes' % (na, len(a)))
    print('stub methods no APK ORIG         : %d em %d classes' % (nb, len(b)))

    only_a = {c: v - b.get(c, set()) for c, v in a.items() if v - b.get(c, set())}
    only_b = {c: v - a.get(c, set()) for c, v in b.items() if v - a.get(c, set())}
    print('\nsó no reconstruido: %d metodos em %d classes' % (sum(len(v) for v in only_a.values()), len(only_a)))
    for c, v in sorted(only_a.items()):
        for name, desc in sorted(v):
            print('  %s->%s%s' % (c.replace(SCOPE + '/', ''), name, desc[:70]))
    print('\nsó no ORIG: %d metodos em %d classes' % (sum(len(v) for v in only_b.values()), len(only_b)))
    for c, v in sorted(only_b.items()):
        for name, desc in sorted(v):
            print('  %s->%s%s' % (c.replace(SCOPE + '/', ''), name, desc[:70]))


if __name__ == '__main__':
    main()
