package proto;

import com.google.protobuf.MessageOrBuilder;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public interface GenreResultOrBuilder extends MessageOrBuilder {
    Genre getGenres(int i);

    int getGenresCount();

    List<Genre> getGenresList();

    GenreOrBuilder getGenresOrBuilder(int i);

    List<? extends GenreOrBuilder> getGenresOrBuilderList();
}
