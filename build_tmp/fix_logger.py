p = 'build_tmp/sources_181_merged/com/magneticchen/daijishou/logger/Logger.java'
with open(p, 'r', encoding='utf-8') as f:
    c = f.read()

c = c.replace('this._latestLogRecordLiveData = new MutableLiveData<>((Object) null);', 'this._latestLogRecordLiveData = new MutableLiveData<LogRecord>((LogRecord) null);')
c = c.replace('public final int compare(T t, T t2) {', 'public final int compare(Object t, Object t2) {')
c = c.replace('this._latestLogRecordLiveData.postValue((Object) null);', 'this._latestLogRecordLiveData.postValue((LogRecord) null);')

with open(p, 'w', encoding='utf-8') as f:
    f.write(c)

print('Fixed Logger.java successfully')
