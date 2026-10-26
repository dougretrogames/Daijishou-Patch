package proto;

import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* INFO: loaded from: classes6.dex */
public interface ArtworkResultOrBuilder extends MessageOrBuilder {
    Artwork getArtworks(int i);

    int getArtworksCount();

    List<Artwork> getArtworksList();

    ArtworkOrBuilder getArtworksOrBuilder(int i);

    List<? extends ArtworkOrBuilder> getArtworksOrBuilderList();
}
