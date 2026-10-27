import os, shutil

src_default = r"build_tmp/jadx_1.8.1_default/sources/com/magneticchen/daijishou"
merged_dir = r"build_tmp/sources_181_merged/com/magneticchen/daijishou"

if os.path.exists(r"build_tmp/sources_181_merged"):
    shutil.rmtree(r"build_tmp/sources_181_merged")

shutil.copytree(src_default, merged_dir)
print(f"Copied {len(os.listdir(merged_dir))} items to merged_dir")
