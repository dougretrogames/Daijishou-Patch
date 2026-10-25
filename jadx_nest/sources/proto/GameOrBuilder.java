package proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.Timestamp;
import com.google.protobuf.TimestampOrBuilder;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public interface GameOrBuilder extends MessageOrBuilder {
    AgeRating getAgeRatings(int i);

    int getAgeRatingsCount();

    List<AgeRating> getAgeRatingsList();

    AgeRatingOrBuilder getAgeRatingsOrBuilder(int i);

    List<? extends AgeRatingOrBuilder> getAgeRatingsOrBuilderList();

    double getAggregatedRating();

    int getAggregatedRatingCount();

    AlternativeName getAlternativeNames(int i);

    int getAlternativeNamesCount();

    List<AlternativeName> getAlternativeNamesList();

    AlternativeNameOrBuilder getAlternativeNamesOrBuilder(int i);

    List<? extends AlternativeNameOrBuilder> getAlternativeNamesOrBuilderList();

    Artwork getArtworks(int i);

    int getArtworksCount();

    List<Artwork> getArtworksList();

    ArtworkOrBuilder getArtworksOrBuilder(int i);

    List<? extends ArtworkOrBuilder> getArtworksOrBuilderList();

    Game getBundles(int i);

    int getBundlesCount();

    List<Game> getBundlesList();

    GameOrBuilder getBundlesOrBuilder(int i);

    List<? extends GameOrBuilder> getBundlesOrBuilderList();

    GameCategoryEnum getCategory();

    int getCategoryValue();

    String getChecksum();

    ByteString getChecksumBytes();

    Collection getCollection();

    CollectionOrBuilder getCollectionOrBuilder();

    Collection getCollections(int i);

    int getCollectionsCount();

    List<Collection> getCollectionsList();

    CollectionOrBuilder getCollectionsOrBuilder(int i);

    List<? extends CollectionOrBuilder> getCollectionsOrBuilderList();

    Cover getCover();

    CoverOrBuilder getCoverOrBuilder();

    Timestamp getCreatedAt();

    TimestampOrBuilder getCreatedAtOrBuilder();

    Game getDlcs(int i);

    int getDlcsCount();

    List<Game> getDlcsList();

    GameOrBuilder getDlcsOrBuilder(int i);

    List<? extends GameOrBuilder> getDlcsOrBuilderList();

    Game getExpandedGames(int i);

    int getExpandedGamesCount();

    List<Game> getExpandedGamesList();

    GameOrBuilder getExpandedGamesOrBuilder(int i);

    List<? extends GameOrBuilder> getExpandedGamesOrBuilderList();

    Game getExpansions(int i);

    int getExpansionsCount();

    List<Game> getExpansionsList();

    GameOrBuilder getExpansionsOrBuilder(int i);

    List<? extends GameOrBuilder> getExpansionsOrBuilderList();

    ExternalGame getExternalGames(int i);

    int getExternalGamesCount();

    List<ExternalGame> getExternalGamesList();

    ExternalGameOrBuilder getExternalGamesOrBuilder(int i);

    List<? extends ExternalGameOrBuilder> getExternalGamesOrBuilderList();

    Timestamp getFirstReleaseDate();

    TimestampOrBuilder getFirstReleaseDateOrBuilder();

    @Deprecated
    int getFollows();

    Game getForks(int i);

    int getForksCount();

    List<Game> getForksList();

    GameOrBuilder getForksOrBuilder(int i);

    List<? extends GameOrBuilder> getForksOrBuilderList();

    Franchise getFranchise();

    FranchiseOrBuilder getFranchiseOrBuilder();

    Franchise getFranchises(int i);

    int getFranchisesCount();

    List<Franchise> getFranchisesList();

    FranchiseOrBuilder getFranchisesOrBuilder(int i);

    List<? extends FranchiseOrBuilder> getFranchisesOrBuilderList();

    GameEngine getGameEngines(int i);

    int getGameEnginesCount();

    List<GameEngine> getGameEnginesList();

    GameEngineOrBuilder getGameEnginesOrBuilder(int i);

    List<? extends GameEngineOrBuilder> getGameEnginesOrBuilderList();

    GameLocalization getGameLocalizations(int i);

    int getGameLocalizationsCount();

    List<GameLocalization> getGameLocalizationsList();

    GameLocalizationOrBuilder getGameLocalizationsOrBuilder(int i);

    List<? extends GameLocalizationOrBuilder> getGameLocalizationsOrBuilderList();

    GameMode getGameModes(int i);

    int getGameModesCount();

    List<GameMode> getGameModesList();

    GameModeOrBuilder getGameModesOrBuilder(int i);

    List<? extends GameModeOrBuilder> getGameModesOrBuilderList();

    Genre getGenres(int i);

    int getGenresCount();

    List<Genre> getGenresList();

    GenreOrBuilder getGenresOrBuilder(int i);

    List<? extends GenreOrBuilder> getGenresOrBuilderList();

    int getHypes();

    long getId();

    InvolvedCompany getInvolvedCompanies(int i);

    int getInvolvedCompaniesCount();

    List<InvolvedCompany> getInvolvedCompaniesList();

    InvolvedCompanyOrBuilder getInvolvedCompaniesOrBuilder(int i);

    List<? extends InvolvedCompanyOrBuilder> getInvolvedCompaniesOrBuilderList();

    Keyword getKeywords(int i);

    int getKeywordsCount();

    List<Keyword> getKeywordsList();

    KeywordOrBuilder getKeywordsOrBuilder(int i);

    List<? extends KeywordOrBuilder> getKeywordsOrBuilderList();

    LanguageSupport getLanguageSupports(int i);

    int getLanguageSupportsCount();

    List<LanguageSupport> getLanguageSupportsList();

    LanguageSupportOrBuilder getLanguageSupportsOrBuilder(int i);

    List<? extends LanguageSupportOrBuilder> getLanguageSupportsOrBuilderList();

    MultiplayerMode getMultiplayerModes(int i);

    int getMultiplayerModesCount();

    List<MultiplayerMode> getMultiplayerModesList();

    MultiplayerModeOrBuilder getMultiplayerModesOrBuilder(int i);

    List<? extends MultiplayerModeOrBuilder> getMultiplayerModesOrBuilderList();

    String getName();

    ByteString getNameBytes();

    Game getParentGame();

    GameOrBuilder getParentGameOrBuilder();

    Platform getPlatforms(int i);

    int getPlatformsCount();

    List<Platform> getPlatformsList();

    PlatformOrBuilder getPlatformsOrBuilder(int i);

    List<? extends PlatformOrBuilder> getPlatformsOrBuilderList();

    PlayerPerspective getPlayerPerspectives(int i);

    int getPlayerPerspectivesCount();

    List<PlayerPerspective> getPlayerPerspectivesList();

    PlayerPerspectiveOrBuilder getPlayerPerspectivesOrBuilder(int i);

    List<? extends PlayerPerspectiveOrBuilder> getPlayerPerspectivesOrBuilderList();

    Game getPorts(int i);

    int getPortsCount();

    List<Game> getPortsList();

    GameOrBuilder getPortsOrBuilder(int i);

    List<? extends GameOrBuilder> getPortsOrBuilderList();

    double getRating();

    int getRatingCount();

    ReleaseDate getReleaseDates(int i);

    int getReleaseDatesCount();

    List<ReleaseDate> getReleaseDatesList();

    ReleaseDateOrBuilder getReleaseDatesOrBuilder(int i);

    List<? extends ReleaseDateOrBuilder> getReleaseDatesOrBuilderList();

    Game getRemakes(int i);

    int getRemakesCount();

    List<Game> getRemakesList();

    GameOrBuilder getRemakesOrBuilder(int i);

    List<? extends GameOrBuilder> getRemakesOrBuilderList();

    Game getRemasters(int i);

    int getRemastersCount();

    List<Game> getRemastersList();

    GameOrBuilder getRemastersOrBuilder(int i);

    List<? extends GameOrBuilder> getRemastersOrBuilderList();

    Screenshot getScreenshots(int i);

    int getScreenshotsCount();

    List<Screenshot> getScreenshotsList();

    ScreenshotOrBuilder getScreenshotsOrBuilder(int i);

    List<? extends ScreenshotOrBuilder> getScreenshotsOrBuilderList();

    Game getSimilarGames(int i);

    int getSimilarGamesCount();

    List<Game> getSimilarGamesList();

    GameOrBuilder getSimilarGamesOrBuilder(int i);

    List<? extends GameOrBuilder> getSimilarGamesOrBuilderList();

    String getSlug();

    ByteString getSlugBytes();

    Game getStandaloneExpansions(int i);

    int getStandaloneExpansionsCount();

    List<Game> getStandaloneExpansionsList();

    GameOrBuilder getStandaloneExpansionsOrBuilder(int i);

    List<? extends GameOrBuilder> getStandaloneExpansionsOrBuilderList();

    GameStatusEnum getStatus();

    int getStatusValue();

    String getStoryline();

    ByteString getStorylineBytes();

    String getSummary();

    ByteString getSummaryBytes();

    int getTags(int i);

    int getTagsCount();

    List<Integer> getTagsList();

    Theme getThemes(int i);

    int getThemesCount();

    List<Theme> getThemesList();

    ThemeOrBuilder getThemesOrBuilder(int i);

    List<? extends ThemeOrBuilder> getThemesOrBuilderList();

    double getTotalRating();

    int getTotalRatingCount();

    Timestamp getUpdatedAt();

    TimestampOrBuilder getUpdatedAtOrBuilder();

    String getUrl();

    ByteString getUrlBytes();

    Game getVersionParent();

    GameOrBuilder getVersionParentOrBuilder();

    String getVersionTitle();

    ByteString getVersionTitleBytes();

    GameVideo getVideos(int i);

    int getVideosCount();

    List<GameVideo> getVideosList();

    GameVideoOrBuilder getVideosOrBuilder(int i);

    List<? extends GameVideoOrBuilder> getVideosOrBuilderList();

    Website getWebsites(int i);

    int getWebsitesCount();

    List<Website> getWebsitesList();

    WebsiteOrBuilder getWebsitesOrBuilder(int i);

    List<? extends WebsiteOrBuilder> getWebsitesOrBuilderList();

    boolean hasCollection();

    boolean hasCover();

    boolean hasCreatedAt();

    boolean hasFirstReleaseDate();

    boolean hasFranchise();

    boolean hasParentGame();

    boolean hasUpdatedAt();

    boolean hasVersionParent();
}
