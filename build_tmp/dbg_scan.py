import re

src = open(r'C:\Users\Douglas\Documents\Daijishou\jadx_nest\sources\com\magneticchen\daijishou\activities\SplashScreenActivity.java', encoding='utf-8', errors='replace').read()
i = 0; n = len(src); depth = 0; stack = []; classes = []; pending = []
class_re = re.compile(r'\b(?:class|interface|enum)\s+([A-Za-z_$][\w$]*)')
ren = re.compile(r'/\* JADX INFO: renamed from: ([^,\s]+), reason:')
while i < n:
    if src.startswith('/*', i):
        end = src.find('*/', i + 2)
        seg = src[i:end + 2]
        mm = ren.search(seg)
        if mm: pending.append(mm.group(1))
        i = end + 2; continue
    if src.startswith('//', i):
        end = src.find('\n', i); i = n if end < 0 else end + 1; continue
    ch = src[i]
    if ch in '"\'':
        q = ch; j = i + 1
        while j < n:
            if src[j] == '\\': j += 2; continue
            if src[j] == q: j += 1; break
            j += 1
        i = j; continue
    if ch == '{': depth += 1; i += 1; continue
    if ch == '}':
        depth -= 1
        if stack and stack[-1][2] == depth:
            _, nm, _, st = stack.pop(); classes.append((nm, st, i))
        i += 1; continue
    mm = class_re.match(src, i)
    if mm and (i == 0 or not (src[i-1].isalnum() or src[i-1] in '_$.')):
        simple = mm.group(1)
        jadx = 'com.magneticchen.daijishou.activities.' + '$'.join([s[1] for s in stack] + [simple])
        stack.append((jadx, simple, depth + 1, i)); i = mm.end(); continue
    i += 1
print('classes', len(classes), 'stack left', len(stack), 'depth', depth)
for c in classes[:8]:
    print(c[0])
