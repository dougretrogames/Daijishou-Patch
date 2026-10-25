"""Inventario do gap de fidelidade: quanto o fonte reconstruido ainda depende do ORIG.

- compara build_tmp/smali_recon com smali_orig_app (texto normalizado, sem CRLF)
- classifica as classes do ORIG que nao existem no reconstruido (sinteticas do Kotlin)
- lista stubs restantes no fonte Java
Gera build_tmp/gap_diff.txt e build_tmp/gap_stubs.txt.
"""
import json
import os
import re

BASE = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))
RECON = os.path.join(BASE, 'build_tmp', 'smali_recon')
ORIG = os.path.join(BASE, 'smali_orig_app')
SCOPE = 'com/magneticchen/daijishou'
SRC = os.path.join(BASE, 'jadx_nest', 'sources', 'com', 'magneticchen', 'daijishou')
OUT = os.path.join(BASE, 'build_tmp')


def walk(root):
    out = {}
    for dp, _, fs in os.walk(root):
        for f in fs:
            if f.endswith('.smali'):
                p = os.path.join(dp, f)
                out[os.path.relpath(p, root).replace('\\', '/')] = p
    return out


def norm(p):
    with open(p, 'rb') as fh:
        t = fh.read().decode('utf-8', 'replace')
    t = t.replace('\r\n', '\n').replace('\r', '\n')
    return '\n'.join(line.rstrip() for line in t.split('\n')).strip()


def classify(name):
    base = name.rsplit('/', 1)[-1]
    if '$$ExternalSyntheticLambda' in base or '-$$Lambda$' in base or '$lambda' in base:
        return 'lambda sintetica'
    if '$WhenMappings' in base:
        return 'when-mappings'
    if '$Companion' in base:
        return 'Companion'
    if re.search(r'\$C\d+', base) or re.search(r'\$\d+$', base) or '$AnonymousClass' in base:
        return 'classe anonima/lambda'
    if base.startswith('Companion') or '$DefaultImpls' in base:
        return 'Kotlin default impl'
    if '$' in base:
        return 'outra interna $'
    return 'classe normal'


def main():
    R, O = walk(RECON), walk(ORIG)
    R = {k: v for k, v in R.items() if k.startswith(SCOPE)}
    O = {k: v for k, v in O.items() if k.startswith(SCOPE)}
    same, diff, only_recon = [], [], []
    for k, p in R.items():
        q = O.get(k)
        if q is None:
            only_recon.append(k)
            continue
        (same if norm(p) == norm(q) else diff).append(k)
    only_orig = sorted(set(O) - set(R))

    print('classes no APK reconstruido : %d' % len(R))
    print('classes no ORIG (com/...)   : %d' % len(O))
    print('iguais ao ORIG (normalizado): %d' % len(same))
    print('divergentes do ORIG         : %d' % len(diff))
    print('so no reconstruido          : %d' % len(only_recon))
    print('so no ORIG                  : %d' % len(only_orig))

    buckets = {}
    for k in only_orig:
        buckets.setdefault(classify(k), []).append(k)
    print('\nclasses do ORIG ausentes no reconstruido, por tipo:')
    for k in sorted(buckets, key=lambda x: -len(buckets[x])):
        print('  %5d  %s' % (len(buckets[k]), k))

    stubs = {}
    for dp, _, fs in os.walk(SRC):
        for f in fs:
            if not f.endswith('.java'):
                continue
            p = os.path.join(dp, f)
            t = open(p, encoding='utf-8', errors='replace').read()
            n = t.count('UnsupportedOperationException')
            if n:
                stubs[os.path.relpath(p, SRC).replace('\\', '/')] = n
    total = sum(stubs.values())
    print('\nstubs no fonte Java         : %d ocorrencias em %d arquivos' % (total, len(stubs)))
    cm = json.load(open(os.path.join(OUT, 'class_map.json')))
    print('classes substituidas inteiras pelo pipeline: %d' % len(cm['stubs']))

    # quantos stubs estao em classes que o pipeline NAO substitui inteiras
    stub_cls = set(cm['stubs'])
    rest = [k for k in stubs if k[:-5].replace('/', '.') not in
            {s.replace('/', '.') for s in stub_cls}]
    print('arquivos com stub fora das 57 classes substituidas: %d' % len(rest))

    with open(os.path.join(OUT, 'gap_diff.txt'), 'w', encoding='utf-8') as fh:
        fh.write('# divergentes do ORIG\n')
        for k in sorted(diff):
            fh.write(k + '\n')
        fh.write('\n# so no reconstruido\n')
        for k in sorted(only_recon):
            fh.write(k + '\n')
        fh.write('\n# so no ORIG\n')
        for k in only_orig:
            fh.write(k + '\n')
    with open(os.path.join(OUT, 'gap_stubs.txt'), 'w', encoding='utf-8') as fh:
        for k in sorted(stubs, key=lambda x: -stubs[x]):
            fh.write('%d\t%s\n' % (stubs[k], k))

    print('\nlistas: build_tmp/gap_diff.txt, build_tmp/gap_stubs.txt')


if __name__ == '__main__':
    main()
