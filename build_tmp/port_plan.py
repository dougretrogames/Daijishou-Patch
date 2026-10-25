"""Gera a lista de trabalho P0: classes que o fonte Java ainda nao reconstroi.

`class_map.json["stubs"]` guarda nomes JADX (compilados); `inv` mapeia JADX -> ORIG.
Para cada classe substituida pelo pipeline, agrupa por arquivo Java e mede:
- smali ORIG (fonte da verdade) e tamanho
- quantos corpos reais estao como stub no Java

Saida: build_tmp/PORT_PLAN.md e build_tmp/port_plan.tsv
"""
import json
import os

BASE = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))
SRC = os.path.join(BASE, 'jadx_nest', 'sources')
ORIG = os.path.join(BASE, 'smali_orig_app')
BUILD = os.path.join(BASE, 'build_tmp')
APP_SRC = os.path.join(SRC, 'com', 'magneticchen', 'daijishou')
PREFIX = 'com/magneticchen/daijishou/'


def find_java(jadx_name):
    rel = jadx_name[len(PREFIX):] if jadx_name.startswith(PREFIX) else jadx_name
    for c in (rel + '.java', rel.split('$')[0] + '.java'):
        p = os.path.join(SRC, *c.split('/'))
        if os.path.exists(p):
            return os.path.relpath(p, SRC).replace('\\', '/')
    base = rel.split('$')[0].split('/')[-1] + '.java'
    for dp, _, fs in os.walk(APP_SRC):
        if base in fs:
            return os.path.relpath(os.path.join(dp, base), SRC).replace('\\', '/')
    return None


def main():
    cm = json.load(open(os.path.join(BUILD, 'class_map.json')))
    inv = cm['inv']
    groups = {}
    no_java = []
    no_orig = []
    for jadx_cls in cm['stubs']:
        orig_cls = inv.get(jadx_cls, jadx_cls)
        java_rel = find_java(jadx_cls)
        smali = os.path.join(ORIG, *orig_cls.split('/')) + '.smali'
        exists = os.path.exists(smali)
        if not exists:
            no_orig.append((jadx_cls, orig_cls))
        lines = 0
        if exists:
            with open(smali, encoding='utf-8', errors='replace') as fh:
                lines = fh.read().count('\n')
        if not java_rel:
            no_java.append((jadx_cls, orig_cls, lines))
            continue
        g = groups.setdefault(java_rel, {'classes': [], 'orig': [], 'lines': 0})
        g['classes'].append(jadx_cls[len(PREFIX):] if jadx_cls.startswith(PREFIX) else jadx_cls)
        g['orig'].append(orig_cls[len(PREFIX):] if orig_cls.startswith(PREFIX) else orig_cls)
        g['lines'] += lines

    for java_rel, g in groups.items():
        real = 0
        with open(os.path.join(SRC, java_rel), encoding='utf-8', errors='replace') as fh:
            for line in fh:
                if 'UnsupportedOperationException' in line and \
                   'Super calls with default arguments' not in line:
                    real += 1
        g['real'] = real

    rows = sorted(groups.items(), key=lambda kv: (-kv[1]['real'], -kv[1]['lines']))

    with open(os.path.join(BUILD, 'port_plan.tsv'), 'w', encoding='utf-8') as fh:
        fh.write('java_file\tclasses_orig\tsmali_lines\tjava_real_stubs\n')
        for java_rel, g in rows:
            fh.write('%s\t%s\t%d\t%d\n' % (java_rel, ' '.join(g['orig']), g['lines'], g['real']))

    with open(os.path.join(BUILD, 'PORT_PLAN.md'), 'w', encoding='utf-8') as fh:
        fh.write('# Plano de porte P0 — classes ainda substituídas pelo bytecode ORIG\n\n')
        fh.write('%d classes em %d arquivos Java; %d classes ORIG sem smali localizado; '
                 '%d sem arquivo Java.\n\n'
                 % (len(cm['stubs']), len(rows), len(no_orig), len(no_java)))
        fh.write('`java_real_stubs` = corpos que hoje são stub no Java (sem contar as guardas do\n')
        fh.write('compilador Kotlin "Super calls with default arguments", que existem também no ORIG).\n\n')
        fh.write('| # | arquivo Java | classes | smali ORIG (linhas) | stubs no Java |\n')
        fh.write('|---|---|---|---|---|\n')
        for i, (java_rel, g) in enumerate(rows, 1):
            fh.write('| %d | `%s` | %d | %d | %d |\n'
                     % (i, java_rel, len(g['classes']), g['lines'], g['real']))
        fh.write('\n## Classes por arquivo (nomes ORIG)\n\n')
        for java_rel, g in rows:
            fh.write('- `%s`: %s\n' % (java_rel, ', '.join('`%s`' % c for c in g['orig'])))
        if no_orig:
            fh.write('\n## Classes sem smali ORIG localizado\n\n')
            for j, o in no_orig:
                fh.write('- JADX `%s` → ORIG `%s`\n' % (j, o))
        if no_java:
            fh.write('\n## Classes sem arquivo Java\n\n')
            for j, o, lines in no_java:
                fh.write('- JADX `%s` → ORIG `%s` (%d linhas)\n' % (j, o, lines))

    print('classes:', len(cm['stubs']), 'arquivos Java:', len(rows),
          'sem smali ORIG:', len(no_orig), 'sem Java:', len(no_java))
    print('linhas de smali ORIG a portar:', sum(g['lines'] for _, g in rows))
    print('\ntop 12 por stubs reais:')
    for java_rel, g in rows[:12]:
        print('  %2d stubs  %5d linhas  %d classes  %s'
              % (g['real'], g['lines'], len(g['classes']), java_rel))
    print('\nPORT_PLAN.md e port_plan.tsv gerados.')


if __name__ == '__main__':
    main()
