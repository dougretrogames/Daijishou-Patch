package proto;

import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public interface AgeRatingResultOrBuilder extends MessageOrBuilder {
    AgeRating getAgeratings(int i);

    int getAgeratingsCount();

    List<AgeRating> getAgeratingsList();

    AgeRatingOrBuilder getAgeratingsOrBuilder(int i);

    List<? extends AgeRatingOrBuilder> getAgeratingsOrBuilderList();
}
