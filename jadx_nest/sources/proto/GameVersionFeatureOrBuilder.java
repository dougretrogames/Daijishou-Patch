package proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public interface GameVersionFeatureOrBuilder extends MessageOrBuilder {
    GameVersionFeatureCategoryEnum getCategory();

    int getCategoryValue();

    String getChecksum();

    ByteString getChecksumBytes();

    String getDescription();

    ByteString getDescriptionBytes();

    long getId();

    int getPosition();

    String getTitle();

    ByteString getTitleBytes();

    GameVersionFeatureValue getValues(int i);

    int getValuesCount();

    List<GameVersionFeatureValue> getValuesList();

    GameVersionFeatureValueOrBuilder getValuesOrBuilder(int i);

    List<? extends GameVersionFeatureValueOrBuilder> getValuesOrBuilderList();
}
