"""Verifica se os stubs que sobraram no dex final sao alcancaveis.

Para cada metodo cujo corpo e `new UnsupportedOperationException`, procura
chamadas (`invoke-*`) para a mesma assinatura em todo o smali do APK.
Stub sem chamada = codigo morto (nao pode derrubar o app em runtime).
"""
import os
import re

BASE = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))
ROOT = os.path.join(BASE, 'build_tmp', 'smali_recon')
SCOPE = os.path.join(ROOT, 'com', 'magneticchen', 'daijishou')

METHOD_RE = re.compile(r'^\.method\s+(?:[\w\- ]+\s+)*([\w$<>]+)(\(.*)$')
INVOKE_RE = re.compile(r'^\s+invoke-(?:virtual|static|direct|interface|super)\s+.*->([\w$<>]+)(\(.*)')


def main():
    files = []
    for dp, _, fs in os.walk(SCOPE):
        for f in fs:
            if f.endswith('.smali'):
                files.append(os.path.join(dp, f))

    stubs = []          # (class_rel, name, desc, file)
    for p in files:
        rel = os.path.relpath(p, ROOT).replace('\\', '/')
        cls = rel[:-6]
        with open(p, encoding='utf-8', errors='replace') as fh:
            lines = fh.read().split('\n')
        cur = None
        for line in lines:
            m = METHOD_RE.match(line)
            if m:
                cur = (m.group(1), m.group(2).strip())
                continue
            if line.startswith('.end method'):
                cur = None
                continue
            if cur and 'UnsupportedOperationException' in line:
                stubs.append((cls, cur[0], cur[1], rel))
                cur = None

    refs = {}
    for p in files:
        with open(p, encoding='utf-8', errors='replace') as fh:
            for line in fh:
                m = INVOKE_RE.match(line)
                if m:
                    key = (m.group(1), m.group(2).strip())
                    refs[key] = refs.get(key, 0) + 1

    print('metodos stub no dex final : %d' % len(stubs))
    alive = [s for s in stubs if refs.get((s[1], s[2]), 0) > 0]
    print('com chamada (risco real)  : %d' % len(alive))
    for cls, name, desc, rel in alive:
        print('  %s->%s%s  (%d chamadas)' % (cls, name, desc, refs[(name, desc)]))
    print('sem chamada (codigo morto): %d' % (len(stubs) - len(alive)))

    by_cls = {}
    for cls, name, desc, rel in stubs:
        by_cls.setdefault(cls, 0)
        by_cls[cls] += 1
    print('\nclasses com stub:')
    for k in sorted(by_cls, key=lambda x: -by_cls[x]):
        print('  %4d  %s' % (by_cls[k], k.replace('com/magneticchen/daijishou/', '')))


if __name__ == '__main__':
    main()
