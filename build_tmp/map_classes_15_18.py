import os

old_dir = r"app_sources\sources\com\magneticchen\daijishou"
new_dir = r"build_tmp\jadx_1.8.1_no_inline\sources\com\magneticchen\daijishou"

def get_class_names(d):
    res = {}
    for root, dirs, files in os.walk(d):
        for f in files:
            if f.endswith('.java') and '$' not in f:
                rel = os.path.relpath(os.path.join(root, f), d)
                res[f] = rel
    return res

old_classes = get_class_names(old_dir)
new_classes = get_class_names(new_dir)

print(f"Old base classes (no $): {len(old_classes)}")
print(f"New base classes (no $): {len(new_classes)}")

matched = []
unmatched_old = []
unmatched_new = list(new_classes.keys())

for f, old_rel in old_classes.items():
    if f in new_classes:
        matched.append((f, old_rel, new_classes[f]))
        unmatched_new.remove(f)
    else:
        unmatched_old.append((f, old_rel))

print(f"\nMatched classes by name: {len(matched)}")
print(f"Unmatched old: {len(unmatched_old)}")
print(f"Unmatched new: {len(unmatched_new)}")

print("\nSample matched classes:")
for f, old_rel, new_rel in matched[:10]:
    print(f"  {f}: {old_rel} -> {new_rel}")

print("\nUnmatched old classes (deleted or renamed):")
for f, old_rel in unmatched_old[:15]:
    print(f"  {f} ({old_rel})")

print("\nUnmatched new classes (added in 1.8.1):")
for f in unmatched_new[:15]:
    print(f"  {f} ({new_classes[f]})")
