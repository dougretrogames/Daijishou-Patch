import os, glob, sys
import xml.etree.ElementTree as ET

# Ensure stdout is utf-8
sys.stdout.reconfigure(encoding='utf-8')

tree = ET.parse('jadx-1.5.6/resources/res/values/strings.xml')
all_items = {e.get('name'): (e.text or '') for e in tree.getroot().findall('string') if e.get('name')}

lib_prefixes = (
    'abc_', 'androidx_', 'common_', 'status_bar_', 'search_menu_',
    'mtrl_', 'material_', 'm3_', 'fab_', 'side_sheet_', 'bottom_sheet_',
    'chip_', 'character_counter_', 'password_toggle_', 'item_view_role_',
    'clear_text_end_icon_', 'error_icon_', 'exposed_dropdown_menu_',
    'not_set', 'preference_', 'v7_', 'exo_', 'navigation_bar_'
)

lib_keys = set(k for k in all_items if any(k.startswith(p) for p in lib_prefixes))
app_keys = set(k for k in all_items if k not in lib_keys)

print(f"Total strings in base (English): {len(all_items)}")
print(f"Library strings: {len(lib_keys)}")
print(f"App-specific strings: {len(app_keys)}")

locales = []
for p in sorted(glob.glob('jadx-1.5.6/resources/res/values-*/strings.xml')):
    dirname = os.path.basename(os.path.dirname(p))
    t = ET.parse(p)
    loc_keys = set(e.get('name') for e in t.getroot().findall('string') if e.get('name'))
    
    app_translated = loc_keys.intersection(app_keys)
    lib_translated = loc_keys.intersection(lib_keys)
    total_translated = loc_keys.intersection(all_items.keys())
    
    pct_app = (len(app_translated) / len(app_keys)) * 100
    pct_total = (len(total_translated) / len(all_items)) * 100
    
    locales.append({
        'dir': dirname,
        'app_count': len(app_translated),
        'app_pct': pct_app,
        'total_count': len(total_translated),
        'total_pct': pct_total,
        'missing_app': len(app_keys) - len(app_translated)
    })

locales.sort(key=lambda x: x['app_count'], reverse=True)

print("\n--- LOCAIS COM TRADUÇÃO DO APP SIGNIFICATIVA (>50%) ---")
for loc in locales:
    if loc['app_pct'] > 50:
        print(f"{loc['dir']:<18} App: {loc['app_count']}/{len(app_keys)} ({loc['app_pct']:.1f}%) | Faltam no app: {loc['missing_app']} | Total: {loc['total_count']}/{len(all_items)} ({loc['total_pct']:.1f}%)")

print("\n--- LOCAIS COM TRADUÇÃO PARCIAL (10% a 50%) ---")
partial = [loc for loc in locales if 10 <= loc['app_pct'] <= 50]
if not partial:
    print("Nenhum local nessa faixa.")
else:
    for loc in partial:
        print(f"{loc['dir']:<18} App: {loc['app_count']}/{len(app_keys)} ({loc['app_pct']:.1f}%)")

print("\n--- LOCAIS COM APENAS STRINGS DE BIBLIOTECA / MÍNIMAS (<10%) ---")
low = [loc for loc in locales if loc['app_pct'] < 10]
print(f"Total de locais com tradução quase nula/apenas libs: {len(low)}")
for loc in low[:15]:
    print(f"  {loc['dir']}: {loc['app_count']} app strings ({loc['app_pct']:.1f}%)")
if len(low) > 15:
    print(f"  ... e mais {len(low)-15} idiomas")
