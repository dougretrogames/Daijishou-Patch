package proto;

import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public interface GameVersionFeatureResultOrBuilder extends MessageOrBuilder {
    GameVersionFeature getGameversionfeatures(int i);

    int getGameversionfeaturesCount();

    List<GameVersionFeature> getGameversionfeaturesList();

    GameVersionFeatureOrBuilder getGameversionfeaturesOrBuilder(int i);

    List<? extends GameVersionFeatureOrBuilder> getGameversionfeaturesOrBuilderList();
}
