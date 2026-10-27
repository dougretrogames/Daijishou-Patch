p = 'build_tmp/sources_181_merged/com/magneticchen/daijishou/ui/activities/abstract_classes/DaijishouServiceLauncher.java'
with open(p, 'r', encoding='utf-8') as f:
    c = f.read()

target = '''        this.serviceConnection = new ServiceConnection(this) { // from class: com.magneticchen.daijishou.ui.activities.abstract_classes.DaijishouServiceLauncher$serviceConnection$1
            final /* synthetic */ DaijishouServiceLauncher<T> this$0;

            {
                this.this$0 = this;
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName className, IBinder iBinder) {
                Intrinsics.checkNotNullParameter(className, "className");
                Intrinsics.checkNotNullParameter(iBinder, "iBinder");
                DaijishouServiceLauncher<T> daijishouServiceLauncher = this.this$0;
                DaijishouService service = ((DaijishouService.LocalBinder) iBinder).getService();
                Intrinsics.checkNotNull(service, "null cannot be cast to non-null type T of com.magneticchen.daijishou.ui.activities.abstract_classes.DaijishouServiceLauncher");
                daijishouServiceLauncher.setService(service);
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName arg0) {
                Intrinsics.checkNotNullParameter(arg0, "arg0");
                this.this$0.setService(null);
            }
        };'''

replacement = '''        this.serviceConnection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName className, IBinder iBinder) {
                Intrinsics.checkNotNullParameter(className, "className");
                Intrinsics.checkNotNullParameter(iBinder, "iBinder");
                DaijishouService service = ((DaijishouService.LocalBinder) iBinder).getService();
                Intrinsics.checkNotNull(service, "null cannot be cast to non-null type T of com.magneticchen.daijishou.ui.activities.abstract_classes.DaijishouServiceLauncher");
                DaijishouServiceLauncher.this.setService((T) service);
            }

            @Override
            public void onServiceDisconnected(ComponentName arg0) {
                Intrinsics.checkNotNullParameter(arg0, "arg0");
                DaijishouServiceLauncher.this.setService(null);
            }
        };'''

assert target in c, 'target not found'
c = c.replace(target, replacement)
with open(p, 'w', encoding='utf-8') as f:
    f.write(c)
print('Fixed DaijishouServiceLauncher.java successfully')
