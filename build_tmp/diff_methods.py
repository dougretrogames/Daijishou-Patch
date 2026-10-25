"""
diff_methods.py - Normalizes registers, labels, and class names to compare
methods between reconstructed smali (build_tmp/smali_recon) and reference smali (smali_orig_app).

Identifies methods with structural divergence, try/catch mismatches, and reports statistics.
"""

import os
import sys
import re
import json
import argparse
import difflib

BASE = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))
ORIG_BASE = os.path.join(BASE, 'smali_orig_app')
RECON_BASE = os.path.join(BASE, 'build_tmp', 'smali_recon')
CLASS_MAP_PATH = os.path.join(BASE, 'build_tmp', 'class_map.json')

def load_class_map():
    if not os.path.exists(CLASS_MAP_PATH):
        return {}, {}
    with open(CLASS_MAP_PATH, 'r', encoding='utf-8') as f:
        data = json.load(f)
    return data.get('map', {}), data.get('inv', {})

def extract_methods(filepath):
    methods = {}
    if not os.path.exists(filepath):
        return methods
    with open(filepath, 'r', encoding='utf-8', errors='replace') as f:
        content = f.read()
    for m in re.finditer(r'\.method\s+(.*?)\n(.*?)\.end method', content, re.DOTALL):
        header = m.group(1).strip()
        body = m.group(2)
        sig_m = re.search(r'([A-Za-z0-9_$<>-]+)\s*\((.*?)\)(\S+)', header)
        if sig_m:
            name = sig_m.group(1)
            desc = '(' + sig_m.group(2) + ')' + sig_m.group(3)
            key = name + desc
            methods[key] = (header, body)
    return methods

def normalize_method(body, class_map_inv):
    lines = []
    reg_map = {}
    label_map = {}
    reg_counter = 0
    label_counter = 0

    for raw in body.split('\n'):
        line = raw.strip()
        if not line or line.startswith('#'):
            continue
        if line.startswith(('.line', '.local', '.prologue', '.parameter', '.registers', '.locals')):
            continue

        # normalize class references in line if present in class_map_inv
        for jadx_cls, orig_cls in class_map_inv.items():
            if jadx_cls in line:
                line = line.replace('L' + jadx_cls + ';', 'L' + orig_cls + ';')

        # normalize label declarations (:goto_0, :cond_1, etc.)
        if line.startswith(':'):
            lbl = line.split()[0]
            if lbl not in label_map:
                label_map[lbl] = f':L{label_counter}'
                label_counter += 1
            lines.append(label_map[lbl])
            continue

        # normalize label usages in instructions
        for lbl in re.findall(r':[A-Za-z0-9_]+', line):
            if lbl not in label_map:
                label_map[lbl] = f':L{label_counter}'
                label_counter += 1
            line = line.replace(lbl, label_map[lbl])

        # normalize registers (v0, v1, p0, p1 -> r0, r1...)
        for reg in re.findall(r'\b[vp]\d+\b', line):
            if reg not in reg_map:
                reg_map[reg] = f'r{reg_counter}'
                reg_counter += 1
            line = re.sub(r'\b' + reg + r'\b', reg_map[reg], line)

        lines.append(line)
    return lines

def count_try_catches(body):
    return [l.strip() for l in body.split('\n') if l.strip().startswith('.catch')]

def main():
    parser = argparse.ArgumentParser(description="Diff smali methods with register and label normalization.")
    parser.add_argument('--class-name', '-c', help="Specific class to diff (e.g. utils/MD5 or full path)")
    parser.add_argument('--method', '-m', help="Specific method name or substring to diff")
    parser.add_argument('--check-catches', action='store_true', help="Check for try/catch mismatches across all methods")
    parser.add_argument('--max-diffs', type=int, default=5, help="Max diff details to display")
    args = parser.parse_args()

    cmap_orig_to_jadx, cmap_jadx_to_orig = load_class_map()

    if args.class_name:
        target = args.class_name.replace('.', '/').replace('\\', '/')
        if target.endswith('.smali'):
            target = target[:-6]
        if target.startswith('com/magneticchen/daijishou/'):
            pass
        else:
            target = 'com/magneticchen/daijishou/' + target.lstrip('/')

        recon_path = os.path.join(RECON_BASE, target + '.smali')
        orig_target = cmap_jadx_to_orig.get(target, target)
        orig_path = os.path.join(ORIG_BASE, orig_target + '.smali')

        if not os.path.exists(recon_path):
            print(f"Error: Reconstructed class not found: {recon_path}")
            return 1
        if not os.path.exists(orig_path):
            print(f"Error: Original class not found: {orig_path}")
            return 1

        m_recon = extract_methods(recon_path)
        m_orig = extract_methods(orig_path)
        print(f"Comparing Class: {target}")
        print(f"Recon methods: {len(m_recon)}, Orig methods: {len(m_orig)}")

        for k in sorted(m_recon.keys()):
            if args.method and args.method not in k:
                continue
            if k not in m_orig:
                print(f"\n[+ RECON ONLY] {k}")
                continue
            b_recon = normalize_method(m_recon[k][1], cmap_jadx_to_orig)
            b_orig = normalize_method(m_orig[k][1], {})
            if b_recon == b_orig:
                print(f"[MATCH] {k}")
            else:
                print(f"\n[DIFF] {k}")
                diff = difflib.unified_diff(b_orig, b_recon, fromfile='ORIG', tofile='RECON', lineterm='')
                for d in diff:
                    print(d)
        return 0

    # Whole codebase scan
    total_methods = 0
    identical_methods = 0
    differing_methods = 0
    catch_mismatches = []

    for root, _, files in os.walk(RECON_BASE):
        for f in files:
            if not f.endswith('.smali'):
                continue
            recon_path = os.path.join(root, f)
            rel = os.path.relpath(recon_path, RECON_BASE).replace('\\', '/')[:-6]
            orig_rel = cmap_jadx_to_orig.get(rel, rel)
            orig_path = os.path.join(ORIG_BASE, orig_rel + '.smali')
            if not os.path.exists(orig_path):
                continue

            m_recon = extract_methods(recon_path)
            m_orig = extract_methods(orig_path)

            for sig, (header_recon, body_recon) in m_recon.items():
                if sig in m_orig:
                    total_methods += 1
                    header_orig, body_orig = m_orig[sig]
                    
                    catches_recon = count_try_catches(body_recon)
                    catches_orig = count_try_catches(body_orig)
                    if len(catches_recon) != len(catches_orig):
                        catch_mismatches.append((rel, sig, len(catches_orig), len(catches_recon)))

                    b_recon = normalize_method(body_recon, cmap_jadx_to_orig)
                    b_orig = normalize_method(body_orig, {})
                    if b_recon == b_orig:
                        identical_methods += 1
                    else:
                        differing_methods += 1

    print(f"=== Normalized Method Diff Summary ===")
    print(f"Total matched methods: {total_methods}")
    print(f"Normalized identical: {identical_methods} ({identical_methods*100.0/total_methods:.1f}%)")
    print(f"Normalized differing: {differing_methods} ({differing_methods*100.0/total_methods:.1f}%)")
    print(f"Try/Catch block count mismatches: {len(catch_mismatches)}")

    if catch_mismatches:
        print("\n--- Try/Catch Count Mismatches ---")
        for cls_name, sig, orig_c, recon_c in catch_mismatches[:args.max_diffs]:
            print(f"  {cls_name}::{sig} -> Orig: {orig_c}, Recon: {recon_c}")
        if len(catch_mismatches) > args.max_diffs:
            print(f"  ... and {len(catch_mismatches) - args.max_diffs} more.")

    return 0

if __name__ == '__main__':
    sys.exit(main())
