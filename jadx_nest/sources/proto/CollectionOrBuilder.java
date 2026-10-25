package proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Timestamp;
import com.google.protobuf.TimestampOrBuilder;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public interface CollectionOrBuilder extends MessageOrBuilder {
    CollectionRelation getAsChildRelations(int i);

    int getAsChildRelationsCount();

    List<CollectionRelation> getAsChildRelationsList();

    CollectionRelationOrBuilder getAsChildRelationsOrBuilder(int i);

    List<? extends CollectionRelationOrBuilder> getAsChildRelationsOrBuilderList();

    CollectionRelation getAsParentRelations(int i);

    int getAsParentRelationsCount();

    List<CollectionRelation> getAsParentRelationsList();

    CollectionRelationOrBuilder getAsParentRelationsOrBuilder(int i);

    List<? extends CollectionRelationOrBuilder> getAsParentRelationsOrBuilderList();

    String getChecksum();

    ByteString getChecksumBytes();

    Timestamp getCreatedAt();

    TimestampOrBuilder getCreatedAtOrBuilder();

    Game getGames(int i);

    int getGamesCount();

    List<Game> getGamesList();

    GameOrBuilder getGamesOrBuilder(int i);

    List<? extends GameOrBuilder> getGamesOrBuilderList();

    long getId();

    String getName();

    ByteString getNameBytes();

    String getSlug();

    ByteString getSlugBytes();

    CollectionType getType();

    CollectionTypeOrBuilder getTypeOrBuilder();

    Timestamp getUpdatedAt();

    TimestampOrBuilder getUpdatedAtOrBuilder();

    String getUrl();

    ByteString getUrlBytes();

    boolean hasCreatedAt();

    boolean hasType();

    boolean hasUpdatedAt();
}
