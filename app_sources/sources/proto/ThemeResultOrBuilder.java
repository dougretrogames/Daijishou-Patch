package proto;

import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* INFO: loaded from: classes6.dex */
public interface ThemeResultOrBuilder extends MessageOrBuilder {
    Theme getThemes(int i);

    int getThemesCount();

    List<Theme> getThemesList();

    ThemeOrBuilder getThemesOrBuilder(int i);

    List<? extends ThemeOrBuilder> getThemesOrBuilderList();
}
