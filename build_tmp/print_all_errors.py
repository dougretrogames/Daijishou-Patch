with open("build_tmp/test_181_javac_err.log", encoding="utf-8") as f:
    for line in f:
        if "error:" in line:
            print(line.strip())
