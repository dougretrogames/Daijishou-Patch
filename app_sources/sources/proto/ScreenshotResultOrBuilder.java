package proto;

import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* INFO: loaded from: classes6.dex */
public interface ScreenshotResultOrBuilder extends MessageOrBuilder {
    Screenshot getScreenshots(int i);

    int getScreenshotsCount();

    List<Screenshot> getScreenshotsList();

    ScreenshotOrBuilder getScreenshotsOrBuilder(int i);

    List<? extends ScreenshotOrBuilder> getScreenshotsOrBuilderList();
}
