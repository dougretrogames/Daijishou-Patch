import os, re, io, sys

sys.stdout.reconfigure(errors='replace')
BASE_REPO = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))
BASE = os.path.join(BASE_REPO, 'app_sources', 'sources', 'com', 'magneticchen', 'daijishou')

bad = []
for dirpath, _, files in os.walk(BASE):
    for fn in files:
        if not fn.endswith('.java'):
            continue
        full = os.path.join(dirpath, fn)
        lines = open(full, encoding='utf-8', errors='replace').read().split('\n')
        for i, line in enumerate(lines):
            if re.search(r'\)\s*obj;', line) and re.search(r'=\s*\(', line):
                # look back up to 12 lines for the end of a catch block
                lo = max(0, i - 12)
                window = lines[lo:i]
                for j, w in enumerate(window):
                    if re.match(r'\s*\}\s*catch\s*\(', w) or re.match(r'\s*catch\s*\(', w):
                        bad.append((full, i + 1, '\n'.join(window[j:]) + '\n' + line))
                        break
print('suspicious casts after catch:', len(bad))
for full, ln, snippet in bad:
    print('---', full.replace(BASE, ''), ln)
    for s in snippet.split('\n'):
        print('   ', s.strip()[:150])
