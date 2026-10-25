package proto;

import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public interface PlatformLogoResultOrBuilder extends MessageOrBuilder {
    PlatformLogo getPlatformlogos(int i);

    int getPlatformlogosCount();

    List<PlatformLogo> getPlatformlogosList();

    PlatformLogoOrBuilder getPlatformlogosOrBuilder(int i);

    List<? extends PlatformLogoOrBuilder> getPlatformlogosOrBuilderList();
}
