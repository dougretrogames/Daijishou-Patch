for fname in [
    "build_tmp/jadx_1.8.1_clean/sources/com/magneticchen/daijishou/data/live/TripleLiveData.java",
    "build_tmp/jadx_1.8.1_clean/sources/com/magneticchen/daijishou/data/live/PairLiveData.java"
]:
    with open(fname, "r", encoding="utf-8") as f:
        c = f.read()
    # Replace static final class AnonymousClass with final class AnonymousClass
    c = c.replace("static final class AnonymousClass", "final class AnonymousClass")
    c = c.replace("extends Lambda implements Function", "extends Lambda<Unit> implements Function")
    with open(fname, "w", encoding="utf-8") as f:
        f.write(c)

print("Updated TripleLiveData and PairLiveData")
