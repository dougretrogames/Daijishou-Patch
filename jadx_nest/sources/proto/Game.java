package proto;

import androidx.core.view.accessibility.AccessibilityEventCompat;
import com.google.api.client.googleapis.media.MediaHttpDownloader;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.Descriptors;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessage;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.Parser;
import com.google.protobuf.RepeatedFieldBuilder;
import com.google.protobuf.RuntimeVersion;
import com.google.protobuf.SingleFieldBuilder;
import com.google.protobuf.Timestamp;
import com.google.protobuf.TimestampOrBuilder;
import com.google.protobuf.UninitializedMessageException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* INFO: loaded from: classes6.dex */
public final class Game extends GeneratedMessage implements GameOrBuilder {
    public static final int AGE_RATINGS_FIELD_NUMBER = 2;
    public static final int AGGREGATED_RATING_COUNT_FIELD_NUMBER = 4;
    public static final int AGGREGATED_RATING_FIELD_NUMBER = 3;
    public static final int ALTERNATIVE_NAMES_FIELD_NUMBER = 5;
    public static final int ARTWORKS_FIELD_NUMBER = 6;
    public static final int BUNDLES_FIELD_NUMBER = 7;
    public static final int CATEGORY_FIELD_NUMBER = 8;
    public static final int CHECKSUM_FIELD_NUMBER = 50;
    public static final int COLLECTIONS_FIELD_NUMBER = 58;
    public static final int COLLECTION_FIELD_NUMBER = 9;
    public static final int COVER_FIELD_NUMBER = 10;
    public static final int CREATED_AT_FIELD_NUMBER = 11;
    private static final Game DEFAULT_INSTANCE;
    public static final int DLCS_FIELD_NUMBER = 12;
    public static final int EXPANDED_GAMES_FIELD_NUMBER = 53;
    public static final int EXPANSIONS_FIELD_NUMBER = 13;
    public static final int EXTERNAL_GAMES_FIELD_NUMBER = 14;
    public static final int FIRST_RELEASE_DATE_FIELD_NUMBER = 15;
    public static final int FOLLOWS_FIELD_NUMBER = 16;
    public static final int FORKS_FIELD_NUMBER = 55;
    public static final int FRANCHISES_FIELD_NUMBER = 18;
    public static final int FRANCHISE_FIELD_NUMBER = 17;
    public static final int GAME_ENGINES_FIELD_NUMBER = 19;
    public static final int GAME_LOCALIZATIONS_FIELD_NUMBER = 57;
    public static final int GAME_MODES_FIELD_NUMBER = 20;
    public static final int GENRES_FIELD_NUMBER = 21;
    public static final int HYPES_FIELD_NUMBER = 22;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int INVOLVED_COMPANIES_FIELD_NUMBER = 23;
    public static final int KEYWORDS_FIELD_NUMBER = 24;
    public static final int LANGUAGE_SUPPORTS_FIELD_NUMBER = 56;
    public static final int MULTIPLAYER_MODES_FIELD_NUMBER = 25;
    public static final int NAME_FIELD_NUMBER = 26;
    public static final int PARENT_GAME_FIELD_NUMBER = 27;
    private static final Parser<Game> PARSER;
    public static final int PLATFORMS_FIELD_NUMBER = 28;
    public static final int PLAYER_PERSPECTIVES_FIELD_NUMBER = 29;
    public static final int PORTS_FIELD_NUMBER = 54;
    public static final int RATING_COUNT_FIELD_NUMBER = 31;
    public static final int RATING_FIELD_NUMBER = 30;
    public static final int RELEASE_DATES_FIELD_NUMBER = 32;
    public static final int REMAKES_FIELD_NUMBER = 51;
    public static final int REMASTERS_FIELD_NUMBER = 52;
    public static final int SCREENSHOTS_FIELD_NUMBER = 33;
    public static final int SIMILAR_GAMES_FIELD_NUMBER = 34;
    public static final int SLUG_FIELD_NUMBER = 35;
    public static final int STANDALONE_EXPANSIONS_FIELD_NUMBER = 36;
    public static final int STATUS_FIELD_NUMBER = 37;
    public static final int STORYLINE_FIELD_NUMBER = 38;
    public static final int SUMMARY_FIELD_NUMBER = 39;
    public static final int TAGS_FIELD_NUMBER = 40;
    public static final int THEMES_FIELD_NUMBER = 41;
    public static final int TOTAL_RATING_COUNT_FIELD_NUMBER = 43;
    public static final int TOTAL_RATING_FIELD_NUMBER = 42;
    public static final int UPDATED_AT_FIELD_NUMBER = 44;
    public static final int URL_FIELD_NUMBER = 45;
    public static final int VERSION_PARENT_FIELD_NUMBER = 46;
    public static final int VERSION_TITLE_FIELD_NUMBER = 47;
    public static final int VIDEOS_FIELD_NUMBER = 48;
    public static final int WEBSITES_FIELD_NUMBER = 49;
    private static final long serialVersionUID = 0;
    private List<AgeRating> ageRatings_;
    private int aggregatedRatingCount_;
    private double aggregatedRating_;
    private List<AlternativeName> alternativeNames_;
    private List<Artwork> artworks_;
    private int bitField0_;
    private List<Game> bundles_;
    private int category_;
    private volatile Object checksum_;
    private Collection collection_;
    private List<Collection> collections_;
    private Cover cover_;
    private Timestamp createdAt_;
    private List<Game> dlcs_;
    private List<Game> expandedGames_;
    private List<Game> expansions_;
    private List<ExternalGame> externalGames_;
    private Timestamp firstReleaseDate_;
    private int follows_;
    private List<Game> forks_;
    private Franchise franchise_;
    private List<Franchise> franchises_;
    private List<GameEngine> gameEngines_;
    private List<GameLocalization> gameLocalizations_;
    private List<GameMode> gameModes_;
    private List<Genre> genres_;
    private int hypes_;
    private long id_;
    private List<InvolvedCompany> involvedCompanies_;
    private List<Keyword> keywords_;
    private List<LanguageSupport> languageSupports_;
    private List<MultiplayerMode> multiplayerModes_;
    private volatile Object name_;
    private Game parentGame_;
    private List<Platform> platforms_;
    private List<PlayerPerspective> playerPerspectives_;
    private List<Game> ports_;
    private int ratingCount_;
    private double rating_;
    private List<ReleaseDate> releaseDates_;
    private List<Game> remakes_;
    private List<Game> remasters_;
    private List<Screenshot> screenshots_;
    private List<Game> similarGames_;
    private volatile Object slug_;
    private List<Game> standaloneExpansions_;
    private int status_;
    private volatile Object storyline_;
    private volatile Object summary_;
    private int tagsMemoizedSerializedSize;
    private Internal.IntList tags_;
    private List<Theme> themes_;
    private int totalRatingCount_;
    private double totalRating_;
    private Timestamp updatedAt_;
    private volatile Object url_;
    private Game versionParent_;
    private volatile Object versionTitle_;
    private List<GameVideo> videos_;
    private List<Website> websites_;

    /* synthetic */ Game(GeneratedMessage.Builder builder, GameIA gameIA) {
        this(builder);
    }

    static {
        RuntimeVersion.validateProtobufGencodeVersion(RuntimeVersion.RuntimeDomain.PUBLIC, 4, 27, 2, "", Game.class.getName());
        DEFAULT_INSTANCE = new Game();
        PARSER = new AnonymousClass1();
    }

    private Game(GeneratedMessage.Builder<?> builder) {
        super(builder);
        this.id_ = 0L;
        this.aggregatedRating_ = 0.0d;
        this.aggregatedRatingCount_ = 0;
        this.category_ = 0;
        this.follows_ = 0;
        this.hypes_ = 0;
        this.name_ = "";
        this.rating_ = 0.0d;
        this.ratingCount_ = 0;
        this.slug_ = "";
        this.status_ = 0;
        this.storyline_ = "";
        this.summary_ = "";
        this.tags_ = emptyIntList();
        this.tagsMemoizedSerializedSize = -1;
        this.totalRating_ = 0.0d;
        this.totalRatingCount_ = 0;
        this.url_ = "";
        this.versionTitle_ = "";
        this.checksum_ = "";
    }

    private Game() {
        this.id_ = 0L;
        this.aggregatedRating_ = 0.0d;
        this.aggregatedRatingCount_ = 0;
        this.category_ = 0;
        this.follows_ = 0;
        this.hypes_ = 0;
        this.name_ = "";
        this.rating_ = 0.0d;
        this.ratingCount_ = 0;
        this.slug_ = "";
        this.status_ = 0;
        this.storyline_ = "";
        this.summary_ = "";
        this.tags_ = emptyIntList();
        this.tagsMemoizedSerializedSize = -1;
        this.totalRating_ = 0.0d;
        this.totalRatingCount_ = 0;
        this.url_ = "";
        this.versionTitle_ = "";
        this.checksum_ = "";
        this.ageRatings_ = Collections.emptyList();
        this.alternativeNames_ = Collections.emptyList();
        this.artworks_ = Collections.emptyList();
        this.bundles_ = Collections.emptyList();
        this.category_ = 0;
        this.dlcs_ = Collections.emptyList();
        this.expansions_ = Collections.emptyList();
        this.externalGames_ = Collections.emptyList();
        this.franchises_ = Collections.emptyList();
        this.gameEngines_ = Collections.emptyList();
        this.gameModes_ = Collections.emptyList();
        this.genres_ = Collections.emptyList();
        this.involvedCompanies_ = Collections.emptyList();
        this.keywords_ = Collections.emptyList();
        this.multiplayerModes_ = Collections.emptyList();
        this.name_ = "";
        this.platforms_ = Collections.emptyList();
        this.playerPerspectives_ = Collections.emptyList();
        this.releaseDates_ = Collections.emptyList();
        this.screenshots_ = Collections.emptyList();
        this.similarGames_ = Collections.emptyList();
        this.slug_ = "";
        this.standaloneExpansions_ = Collections.emptyList();
        this.status_ = 0;
        this.storyline_ = "";
        this.summary_ = "";
        this.tags_ = emptyIntList();
        this.themes_ = Collections.emptyList();
        this.url_ = "";
        this.versionTitle_ = "";
        this.videos_ = Collections.emptyList();
        this.websites_ = Collections.emptyList();
        this.checksum_ = "";
        this.remakes_ = Collections.emptyList();
        this.remasters_ = Collections.emptyList();
        this.expandedGames_ = Collections.emptyList();
        this.ports_ = Collections.emptyList();
        this.forks_ = Collections.emptyList();
        this.languageSupports_ = Collections.emptyList();
        this.gameLocalizations_ = Collections.emptyList();
        this.collections_ = Collections.emptyList();
    }

    public static final Descriptors.Descriptor getDescriptor() {
        return Igdbproto.internal_static_proto_Game_descriptor;
    }

    @Override // com.google.protobuf.GeneratedMessage
    protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
        return Igdbproto.internal_static_proto_Game_fieldAccessorTable.ensureFieldAccessorsInitialized(Game.class, Builder.class);
    }

    @Override // proto.GameOrBuilder
    public long getId() {
        return this.id_;
    }

    @Override // proto.GameOrBuilder
    public List<AgeRating> getAgeRatingsList() {
        return this.ageRatings_;
    }

    @Override // proto.GameOrBuilder
    public List<? extends AgeRatingOrBuilder> getAgeRatingsOrBuilderList() {
        return this.ageRatings_;
    }

    @Override // proto.GameOrBuilder
    public int getAgeRatingsCount() {
        return this.ageRatings_.size();
    }

    @Override // proto.GameOrBuilder
    public AgeRating getAgeRatings(int i) {
        return this.ageRatings_.get(i);
    }

    @Override // proto.GameOrBuilder
    public AgeRatingOrBuilder getAgeRatingsOrBuilder(int i) {
        return this.ageRatings_.get(i);
    }

    @Override // proto.GameOrBuilder
    public double getAggregatedRating() {
        return this.aggregatedRating_;
    }

    @Override // proto.GameOrBuilder
    public int getAggregatedRatingCount() {
        return this.aggregatedRatingCount_;
    }

    @Override // proto.GameOrBuilder
    public List<AlternativeName> getAlternativeNamesList() {
        return this.alternativeNames_;
    }

    @Override // proto.GameOrBuilder
    public List<? extends AlternativeNameOrBuilder> getAlternativeNamesOrBuilderList() {
        return this.alternativeNames_;
    }

    @Override // proto.GameOrBuilder
    public int getAlternativeNamesCount() {
        return this.alternativeNames_.size();
    }

    @Override // proto.GameOrBuilder
    public AlternativeName getAlternativeNames(int i) {
        return this.alternativeNames_.get(i);
    }

    @Override // proto.GameOrBuilder
    public AlternativeNameOrBuilder getAlternativeNamesOrBuilder(int i) {
        return this.alternativeNames_.get(i);
    }

    @Override // proto.GameOrBuilder
    public List<Artwork> getArtworksList() {
        return this.artworks_;
    }

    @Override // proto.GameOrBuilder
    public List<? extends ArtworkOrBuilder> getArtworksOrBuilderList() {
        return this.artworks_;
    }

    @Override // proto.GameOrBuilder
    public int getArtworksCount() {
        return this.artworks_.size();
    }

    @Override // proto.GameOrBuilder
    public Artwork getArtworks(int i) {
        return this.artworks_.get(i);
    }

    @Override // proto.GameOrBuilder
    public ArtworkOrBuilder getArtworksOrBuilder(int i) {
        return this.artworks_.get(i);
    }

    @Override // proto.GameOrBuilder
    public List<Game> getBundlesList() {
        return this.bundles_;
    }

    @Override // proto.GameOrBuilder
    public List<? extends GameOrBuilder> getBundlesOrBuilderList() {
        return this.bundles_;
    }

    @Override // proto.GameOrBuilder
    public int getBundlesCount() {
        return this.bundles_.size();
    }

    @Override // proto.GameOrBuilder
    public Game getBundles(int i) {
        return this.bundles_.get(i);
    }

    @Override // proto.GameOrBuilder
    public GameOrBuilder getBundlesOrBuilder(int i) {
        return this.bundles_.get(i);
    }

    @Override // proto.GameOrBuilder
    public int getCategoryValue() {
        return this.category_;
    }

    @Override // proto.GameOrBuilder
    public GameCategoryEnum getCategory() {
        GameCategoryEnum gameCategoryEnumForNumber = GameCategoryEnum.forNumber(this.category_);
        return gameCategoryEnumForNumber == null ? GameCategoryEnum.UNRECOGNIZED : gameCategoryEnumForNumber;
    }

    @Override // proto.GameOrBuilder
    public boolean hasCollection() {
        return (this.bitField0_ & 1) != 0;
    }

    @Override // proto.GameOrBuilder
    public Collection getCollection() {
        Collection collection = this.collection_;
        return collection == null ? Collection.getDefaultInstance() : collection;
    }

    @Override // proto.GameOrBuilder
    public CollectionOrBuilder getCollectionOrBuilder() {
        Collection collection = this.collection_;
        return collection == null ? Collection.getDefaultInstance() : collection;
    }

    @Override // proto.GameOrBuilder
    public boolean hasCover() {
        return (this.bitField0_ & 2) != 0;
    }

    @Override // proto.GameOrBuilder
    public Cover getCover() {
        Cover cover = this.cover_;
        return cover == null ? Cover.getDefaultInstance() : cover;
    }

    @Override // proto.GameOrBuilder
    public CoverOrBuilder getCoverOrBuilder() {
        Cover cover = this.cover_;
        return cover == null ? Cover.getDefaultInstance() : cover;
    }

    @Override // proto.GameOrBuilder
    public boolean hasCreatedAt() {
        return (this.bitField0_ & 4) != 0;
    }

    @Override // proto.GameOrBuilder
    public Timestamp getCreatedAt() {
        Timestamp timestamp = this.createdAt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // proto.GameOrBuilder
    public TimestampOrBuilder getCreatedAtOrBuilder() {
        Timestamp timestamp = this.createdAt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // proto.GameOrBuilder
    public List<Game> getDlcsList() {
        return this.dlcs_;
    }

    @Override // proto.GameOrBuilder
    public List<? extends GameOrBuilder> getDlcsOrBuilderList() {
        return this.dlcs_;
    }

    @Override // proto.GameOrBuilder
    public int getDlcsCount() {
        return this.dlcs_.size();
    }

    @Override // proto.GameOrBuilder
    public Game getDlcs(int i) {
        return this.dlcs_.get(i);
    }

    @Override // proto.GameOrBuilder
    public GameOrBuilder getDlcsOrBuilder(int i) {
        return this.dlcs_.get(i);
    }

    @Override // proto.GameOrBuilder
    public List<Game> getExpansionsList() {
        return this.expansions_;
    }

    @Override // proto.GameOrBuilder
    public List<? extends GameOrBuilder> getExpansionsOrBuilderList() {
        return this.expansions_;
    }

    @Override // proto.GameOrBuilder
    public int getExpansionsCount() {
        return this.expansions_.size();
    }

    @Override // proto.GameOrBuilder
    public Game getExpansions(int i) {
        return this.expansions_.get(i);
    }

    @Override // proto.GameOrBuilder
    public GameOrBuilder getExpansionsOrBuilder(int i) {
        return this.expansions_.get(i);
    }

    @Override // proto.GameOrBuilder
    public List<ExternalGame> getExternalGamesList() {
        return this.externalGames_;
    }

    @Override // proto.GameOrBuilder
    public List<? extends ExternalGameOrBuilder> getExternalGamesOrBuilderList() {
        return this.externalGames_;
    }

    @Override // proto.GameOrBuilder
    public int getExternalGamesCount() {
        return this.externalGames_.size();
    }

    @Override // proto.GameOrBuilder
    public ExternalGame getExternalGames(int i) {
        return this.externalGames_.get(i);
    }

    @Override // proto.GameOrBuilder
    public ExternalGameOrBuilder getExternalGamesOrBuilder(int i) {
        return this.externalGames_.get(i);
    }

    @Override // proto.GameOrBuilder
    public boolean hasFirstReleaseDate() {
        return (this.bitField0_ & 8) != 0;
    }

    @Override // proto.GameOrBuilder
    public Timestamp getFirstReleaseDate() {
        Timestamp timestamp = this.firstReleaseDate_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // proto.GameOrBuilder
    public TimestampOrBuilder getFirstReleaseDateOrBuilder() {
        Timestamp timestamp = this.firstReleaseDate_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // proto.GameOrBuilder
    @Deprecated
    public int getFollows() {
        return this.follows_;
    }

    @Override // proto.GameOrBuilder
    public boolean hasFranchise() {
        return (this.bitField0_ & 16) != 0;
    }

    @Override // proto.GameOrBuilder
    public Franchise getFranchise() {
        Franchise franchise = this.franchise_;
        return franchise == null ? Franchise.getDefaultInstance() : franchise;
    }

    @Override // proto.GameOrBuilder
    public FranchiseOrBuilder getFranchiseOrBuilder() {
        Franchise franchise = this.franchise_;
        return franchise == null ? Franchise.getDefaultInstance() : franchise;
    }

    @Override // proto.GameOrBuilder
    public List<Franchise> getFranchisesList() {
        return this.franchises_;
    }

    @Override // proto.GameOrBuilder
    public List<? extends FranchiseOrBuilder> getFranchisesOrBuilderList() {
        return this.franchises_;
    }

    @Override // proto.GameOrBuilder
    public int getFranchisesCount() {
        return this.franchises_.size();
    }

    @Override // proto.GameOrBuilder
    public Franchise getFranchises(int i) {
        return this.franchises_.get(i);
    }

    @Override // proto.GameOrBuilder
    public FranchiseOrBuilder getFranchisesOrBuilder(int i) {
        return this.franchises_.get(i);
    }

    @Override // proto.GameOrBuilder
    public List<GameEngine> getGameEnginesList() {
        return this.gameEngines_;
    }

    @Override // proto.GameOrBuilder
    public List<? extends GameEngineOrBuilder> getGameEnginesOrBuilderList() {
        return this.gameEngines_;
    }

    @Override // proto.GameOrBuilder
    public int getGameEnginesCount() {
        return this.gameEngines_.size();
    }

    @Override // proto.GameOrBuilder
    public GameEngine getGameEngines(int i) {
        return this.gameEngines_.get(i);
    }

    @Override // proto.GameOrBuilder
    public GameEngineOrBuilder getGameEnginesOrBuilder(int i) {
        return this.gameEngines_.get(i);
    }

    @Override // proto.GameOrBuilder
    public List<GameMode> getGameModesList() {
        return this.gameModes_;
    }

    @Override // proto.GameOrBuilder
    public List<? extends GameModeOrBuilder> getGameModesOrBuilderList() {
        return this.gameModes_;
    }

    @Override // proto.GameOrBuilder
    public int getGameModesCount() {
        return this.gameModes_.size();
    }

    @Override // proto.GameOrBuilder
    public GameMode getGameModes(int i) {
        return this.gameModes_.get(i);
    }

    @Override // proto.GameOrBuilder
    public GameModeOrBuilder getGameModesOrBuilder(int i) {
        return this.gameModes_.get(i);
    }

    @Override // proto.GameOrBuilder
    public List<Genre> getGenresList() {
        return this.genres_;
    }

    @Override // proto.GameOrBuilder
    public List<? extends GenreOrBuilder> getGenresOrBuilderList() {
        return this.genres_;
    }

    @Override // proto.GameOrBuilder
    public int getGenresCount() {
        return this.genres_.size();
    }

    @Override // proto.GameOrBuilder
    public Genre getGenres(int i) {
        return this.genres_.get(i);
    }

    @Override // proto.GameOrBuilder
    public GenreOrBuilder getGenresOrBuilder(int i) {
        return this.genres_.get(i);
    }

    @Override // proto.GameOrBuilder
    public int getHypes() {
        return this.hypes_;
    }

    @Override // proto.GameOrBuilder
    public List<InvolvedCompany> getInvolvedCompaniesList() {
        return this.involvedCompanies_;
    }

    @Override // proto.GameOrBuilder
    public List<? extends InvolvedCompanyOrBuilder> getInvolvedCompaniesOrBuilderList() {
        return this.involvedCompanies_;
    }

    @Override // proto.GameOrBuilder
    public int getInvolvedCompaniesCount() {
        return this.involvedCompanies_.size();
    }

    @Override // proto.GameOrBuilder
    public InvolvedCompany getInvolvedCompanies(int i) {
        return this.involvedCompanies_.get(i);
    }

    @Override // proto.GameOrBuilder
    public InvolvedCompanyOrBuilder getInvolvedCompaniesOrBuilder(int i) {
        return this.involvedCompanies_.get(i);
    }

    @Override // proto.GameOrBuilder
    public List<Keyword> getKeywordsList() {
        return this.keywords_;
    }

    @Override // proto.GameOrBuilder
    public List<? extends KeywordOrBuilder> getKeywordsOrBuilderList() {
        return this.keywords_;
    }

    @Override // proto.GameOrBuilder
    public int getKeywordsCount() {
        return this.keywords_.size();
    }

    @Override // proto.GameOrBuilder
    public Keyword getKeywords(int i) {
        return this.keywords_.get(i);
    }

    @Override // proto.GameOrBuilder
    public KeywordOrBuilder getKeywordsOrBuilder(int i) {
        return this.keywords_.get(i);
    }

    @Override // proto.GameOrBuilder
    public List<MultiplayerMode> getMultiplayerModesList() {
        return this.multiplayerModes_;
    }

    @Override // proto.GameOrBuilder
    public List<? extends MultiplayerModeOrBuilder> getMultiplayerModesOrBuilderList() {
        return this.multiplayerModes_;
    }

    @Override // proto.GameOrBuilder
    public int getMultiplayerModesCount() {
        return this.multiplayerModes_.size();
    }

    @Override // proto.GameOrBuilder
    public MultiplayerMode getMultiplayerModes(int i) {
        return this.multiplayerModes_.get(i);
    }

    @Override // proto.GameOrBuilder
    public MultiplayerModeOrBuilder getMultiplayerModesOrBuilder(int i) {
        return this.multiplayerModes_.get(i);
    }

    @Override // proto.GameOrBuilder
    public String getName() {
        Object obj = this.name_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.name_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.GameOrBuilder
    public ByteString getNameBytes() {
        Object obj = this.name_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.name_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // proto.GameOrBuilder
    public boolean hasParentGame() {
        return (this.bitField0_ & 32) != 0;
    }

    @Override // proto.GameOrBuilder
    public Game getParentGame() {
        Game game = this.parentGame_;
        return game == null ? getDefaultInstance() : game;
    }

    @Override // proto.GameOrBuilder
    public GameOrBuilder getParentGameOrBuilder() {
        Game game = this.parentGame_;
        return game == null ? getDefaultInstance() : game;
    }

    @Override // proto.GameOrBuilder
    public List<Platform> getPlatformsList() {
        return this.platforms_;
    }

    @Override // proto.GameOrBuilder
    public List<? extends PlatformOrBuilder> getPlatformsOrBuilderList() {
        return this.platforms_;
    }

    @Override // proto.GameOrBuilder
    public int getPlatformsCount() {
        return this.platforms_.size();
    }

    @Override // proto.GameOrBuilder
    public Platform getPlatforms(int i) {
        return this.platforms_.get(i);
    }

    @Override // proto.GameOrBuilder
    public PlatformOrBuilder getPlatformsOrBuilder(int i) {
        return this.platforms_.get(i);
    }

    @Override // proto.GameOrBuilder
    public List<PlayerPerspective> getPlayerPerspectivesList() {
        return this.playerPerspectives_;
    }

    @Override // proto.GameOrBuilder
    public List<? extends PlayerPerspectiveOrBuilder> getPlayerPerspectivesOrBuilderList() {
        return this.playerPerspectives_;
    }

    @Override // proto.GameOrBuilder
    public int getPlayerPerspectivesCount() {
        return this.playerPerspectives_.size();
    }

    @Override // proto.GameOrBuilder
    public PlayerPerspective getPlayerPerspectives(int i) {
        return this.playerPerspectives_.get(i);
    }

    @Override // proto.GameOrBuilder
    public PlayerPerspectiveOrBuilder getPlayerPerspectivesOrBuilder(int i) {
        return this.playerPerspectives_.get(i);
    }

    @Override // proto.GameOrBuilder
    public double getRating() {
        return this.rating_;
    }

    @Override // proto.GameOrBuilder
    public int getRatingCount() {
        return this.ratingCount_;
    }

    @Override // proto.GameOrBuilder
    public List<ReleaseDate> getReleaseDatesList() {
        return this.releaseDates_;
    }

    @Override // proto.GameOrBuilder
    public List<? extends ReleaseDateOrBuilder> getReleaseDatesOrBuilderList() {
        return this.releaseDates_;
    }

    @Override // proto.GameOrBuilder
    public int getReleaseDatesCount() {
        return this.releaseDates_.size();
    }

    @Override // proto.GameOrBuilder
    public ReleaseDate getReleaseDates(int i) {
        return this.releaseDates_.get(i);
    }

    @Override // proto.GameOrBuilder
    public ReleaseDateOrBuilder getReleaseDatesOrBuilder(int i) {
        return this.releaseDates_.get(i);
    }

    @Override // proto.GameOrBuilder
    public List<Screenshot> getScreenshotsList() {
        return this.screenshots_;
    }

    @Override // proto.GameOrBuilder
    public List<? extends ScreenshotOrBuilder> getScreenshotsOrBuilderList() {
        return this.screenshots_;
    }

    @Override // proto.GameOrBuilder
    public int getScreenshotsCount() {
        return this.screenshots_.size();
    }

    @Override // proto.GameOrBuilder
    public Screenshot getScreenshots(int i) {
        return this.screenshots_.get(i);
    }

    @Override // proto.GameOrBuilder
    public ScreenshotOrBuilder getScreenshotsOrBuilder(int i) {
        return this.screenshots_.get(i);
    }

    @Override // proto.GameOrBuilder
    public List<Game> getSimilarGamesList() {
        return this.similarGames_;
    }

    @Override // proto.GameOrBuilder
    public List<? extends GameOrBuilder> getSimilarGamesOrBuilderList() {
        return this.similarGames_;
    }

    @Override // proto.GameOrBuilder
    public int getSimilarGamesCount() {
        return this.similarGames_.size();
    }

    @Override // proto.GameOrBuilder
    public Game getSimilarGames(int i) {
        return this.similarGames_.get(i);
    }

    @Override // proto.GameOrBuilder
    public GameOrBuilder getSimilarGamesOrBuilder(int i) {
        return this.similarGames_.get(i);
    }

    @Override // proto.GameOrBuilder
    public String getSlug() {
        Object obj = this.slug_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.slug_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.GameOrBuilder
    public ByteString getSlugBytes() {
        Object obj = this.slug_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.slug_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // proto.GameOrBuilder
    public List<Game> getStandaloneExpansionsList() {
        return this.standaloneExpansions_;
    }

    @Override // proto.GameOrBuilder
    public List<? extends GameOrBuilder> getStandaloneExpansionsOrBuilderList() {
        return this.standaloneExpansions_;
    }

    @Override // proto.GameOrBuilder
    public int getStandaloneExpansionsCount() {
        return this.standaloneExpansions_.size();
    }

    @Override // proto.GameOrBuilder
    public Game getStandaloneExpansions(int i) {
        return this.standaloneExpansions_.get(i);
    }

    @Override // proto.GameOrBuilder
    public GameOrBuilder getStandaloneExpansionsOrBuilder(int i) {
        return this.standaloneExpansions_.get(i);
    }

    @Override // proto.GameOrBuilder
    public int getStatusValue() {
        return this.status_;
    }

    @Override // proto.GameOrBuilder
    public GameStatusEnum getStatus() {
        GameStatusEnum gameStatusEnumForNumber = GameStatusEnum.forNumber(this.status_);
        return gameStatusEnumForNumber == null ? GameStatusEnum.UNRECOGNIZED : gameStatusEnumForNumber;
    }

    @Override // proto.GameOrBuilder
    public String getStoryline() {
        Object obj = this.storyline_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.storyline_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.GameOrBuilder
    public ByteString getStorylineBytes() {
        Object obj = this.storyline_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.storyline_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // proto.GameOrBuilder
    public String getSummary() {
        Object obj = this.summary_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.summary_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.GameOrBuilder
    public ByteString getSummaryBytes() {
        Object obj = this.summary_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.summary_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // proto.GameOrBuilder
    public List<Integer> getTagsList() {
        return this.tags_;
    }

    @Override // proto.GameOrBuilder
    public int getTagsCount() {
        return this.tags_.size();
    }

    @Override // proto.GameOrBuilder
    public int getTags(int i) {
        return this.tags_.getInt(i);
    }

    @Override // proto.GameOrBuilder
    public List<Theme> getThemesList() {
        return this.themes_;
    }

    @Override // proto.GameOrBuilder
    public List<? extends ThemeOrBuilder> getThemesOrBuilderList() {
        return this.themes_;
    }

    @Override // proto.GameOrBuilder
    public int getThemesCount() {
        return this.themes_.size();
    }

    @Override // proto.GameOrBuilder
    public Theme getThemes(int i) {
        return this.themes_.get(i);
    }

    @Override // proto.GameOrBuilder
    public ThemeOrBuilder getThemesOrBuilder(int i) {
        return this.themes_.get(i);
    }

    @Override // proto.GameOrBuilder
    public double getTotalRating() {
        return this.totalRating_;
    }

    @Override // proto.GameOrBuilder
    public int getTotalRatingCount() {
        return this.totalRatingCount_;
    }

    @Override // proto.GameOrBuilder
    public boolean hasUpdatedAt() {
        return (this.bitField0_ & 64) != 0;
    }

    @Override // proto.GameOrBuilder
    public Timestamp getUpdatedAt() {
        Timestamp timestamp = this.updatedAt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // proto.GameOrBuilder
    public TimestampOrBuilder getUpdatedAtOrBuilder() {
        Timestamp timestamp = this.updatedAt_;
        return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
    }

    @Override // proto.GameOrBuilder
    public String getUrl() {
        Object obj = this.url_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.url_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.GameOrBuilder
    public ByteString getUrlBytes() {
        Object obj = this.url_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.url_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // proto.GameOrBuilder
    public boolean hasVersionParent() {
        return (this.bitField0_ & 128) != 0;
    }

    @Override // proto.GameOrBuilder
    public Game getVersionParent() {
        Game game = this.versionParent_;
        return game == null ? getDefaultInstance() : game;
    }

    @Override // proto.GameOrBuilder
    public GameOrBuilder getVersionParentOrBuilder() {
        Game game = this.versionParent_;
        return game == null ? getDefaultInstance() : game;
    }

    @Override // proto.GameOrBuilder
    public String getVersionTitle() {
        Object obj = this.versionTitle_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.versionTitle_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.GameOrBuilder
    public ByteString getVersionTitleBytes() {
        Object obj = this.versionTitle_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.versionTitle_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // proto.GameOrBuilder
    public List<GameVideo> getVideosList() {
        return this.videos_;
    }

    @Override // proto.GameOrBuilder
    public List<? extends GameVideoOrBuilder> getVideosOrBuilderList() {
        return this.videos_;
    }

    @Override // proto.GameOrBuilder
    public int getVideosCount() {
        return this.videos_.size();
    }

    @Override // proto.GameOrBuilder
    public GameVideo getVideos(int i) {
        return this.videos_.get(i);
    }

    @Override // proto.GameOrBuilder
    public GameVideoOrBuilder getVideosOrBuilder(int i) {
        return this.videos_.get(i);
    }

    @Override // proto.GameOrBuilder
    public List<Website> getWebsitesList() {
        return this.websites_;
    }

    @Override // proto.GameOrBuilder
    public List<? extends WebsiteOrBuilder> getWebsitesOrBuilderList() {
        return this.websites_;
    }

    @Override // proto.GameOrBuilder
    public int getWebsitesCount() {
        return this.websites_.size();
    }

    @Override // proto.GameOrBuilder
    public Website getWebsites(int i) {
        return this.websites_.get(i);
    }

    @Override // proto.GameOrBuilder
    public WebsiteOrBuilder getWebsitesOrBuilder(int i) {
        return this.websites_.get(i);
    }

    @Override // proto.GameOrBuilder
    public String getChecksum() {
        Object obj = this.checksum_;
        if (obj instanceof String) {
            return (String) obj;
        }
        String stringUtf8 = ((ByteString) obj).toStringUtf8();
        this.checksum_ = stringUtf8;
        return stringUtf8;
    }

    @Override // proto.GameOrBuilder
    public ByteString getChecksumBytes() {
        Object obj = this.checksum_;
        if (obj instanceof String) {
            ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.checksum_ = byteStringCopyFromUtf8;
            return byteStringCopyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // proto.GameOrBuilder
    public List<Game> getRemakesList() {
        return this.remakes_;
    }

    @Override // proto.GameOrBuilder
    public List<? extends GameOrBuilder> getRemakesOrBuilderList() {
        return this.remakes_;
    }

    @Override // proto.GameOrBuilder
    public int getRemakesCount() {
        return this.remakes_.size();
    }

    @Override // proto.GameOrBuilder
    public Game getRemakes(int i) {
        return this.remakes_.get(i);
    }

    @Override // proto.GameOrBuilder
    public GameOrBuilder getRemakesOrBuilder(int i) {
        return this.remakes_.get(i);
    }

    @Override // proto.GameOrBuilder
    public List<Game> getRemastersList() {
        return this.remasters_;
    }

    @Override // proto.GameOrBuilder
    public List<? extends GameOrBuilder> getRemastersOrBuilderList() {
        return this.remasters_;
    }

    @Override // proto.GameOrBuilder
    public int getRemastersCount() {
        return this.remasters_.size();
    }

    @Override // proto.GameOrBuilder
    public Game getRemasters(int i) {
        return this.remasters_.get(i);
    }

    @Override // proto.GameOrBuilder
    public GameOrBuilder getRemastersOrBuilder(int i) {
        return this.remasters_.get(i);
    }

    @Override // proto.GameOrBuilder
    public List<Game> getExpandedGamesList() {
        return this.expandedGames_;
    }

    @Override // proto.GameOrBuilder
    public List<? extends GameOrBuilder> getExpandedGamesOrBuilderList() {
        return this.expandedGames_;
    }

    @Override // proto.GameOrBuilder
    public int getExpandedGamesCount() {
        return this.expandedGames_.size();
    }

    @Override // proto.GameOrBuilder
    public Game getExpandedGames(int i) {
        return this.expandedGames_.get(i);
    }

    @Override // proto.GameOrBuilder
    public GameOrBuilder getExpandedGamesOrBuilder(int i) {
        return this.expandedGames_.get(i);
    }

    @Override // proto.GameOrBuilder
    public List<Game> getPortsList() {
        return this.ports_;
    }

    @Override // proto.GameOrBuilder
    public List<? extends GameOrBuilder> getPortsOrBuilderList() {
        return this.ports_;
    }

    @Override // proto.GameOrBuilder
    public int getPortsCount() {
        return this.ports_.size();
    }

    @Override // proto.GameOrBuilder
    public Game getPorts(int i) {
        return this.ports_.get(i);
    }

    @Override // proto.GameOrBuilder
    public GameOrBuilder getPortsOrBuilder(int i) {
        return this.ports_.get(i);
    }

    @Override // proto.GameOrBuilder
    public List<Game> getForksList() {
        return this.forks_;
    }

    @Override // proto.GameOrBuilder
    public List<? extends GameOrBuilder> getForksOrBuilderList() {
        return this.forks_;
    }

    @Override // proto.GameOrBuilder
    public int getForksCount() {
        return this.forks_.size();
    }

    @Override // proto.GameOrBuilder
    public Game getForks(int i) {
        return this.forks_.get(i);
    }

    @Override // proto.GameOrBuilder
    public GameOrBuilder getForksOrBuilder(int i) {
        return this.forks_.get(i);
    }

    @Override // proto.GameOrBuilder
    public List<LanguageSupport> getLanguageSupportsList() {
        return this.languageSupports_;
    }

    @Override // proto.GameOrBuilder
    public List<? extends LanguageSupportOrBuilder> getLanguageSupportsOrBuilderList() {
        return this.languageSupports_;
    }

    @Override // proto.GameOrBuilder
    public int getLanguageSupportsCount() {
        return this.languageSupports_.size();
    }

    @Override // proto.GameOrBuilder
    public LanguageSupport getLanguageSupports(int i) {
        return this.languageSupports_.get(i);
    }

    @Override // proto.GameOrBuilder
    public LanguageSupportOrBuilder getLanguageSupportsOrBuilder(int i) {
        return this.languageSupports_.get(i);
    }

    @Override // proto.GameOrBuilder
    public List<GameLocalization> getGameLocalizationsList() {
        return this.gameLocalizations_;
    }

    @Override // proto.GameOrBuilder
    public List<? extends GameLocalizationOrBuilder> getGameLocalizationsOrBuilderList() {
        return this.gameLocalizations_;
    }

    @Override // proto.GameOrBuilder
    public int getGameLocalizationsCount() {
        return this.gameLocalizations_.size();
    }

    @Override // proto.GameOrBuilder
    public GameLocalization getGameLocalizations(int i) {
        return this.gameLocalizations_.get(i);
    }

    @Override // proto.GameOrBuilder
    public GameLocalizationOrBuilder getGameLocalizationsOrBuilder(int i) {
        return this.gameLocalizations_.get(i);
    }

    @Override // proto.GameOrBuilder
    public List<Collection> getCollectionsList() {
        return this.collections_;
    }

    @Override // proto.GameOrBuilder
    public List<? extends CollectionOrBuilder> getCollectionsOrBuilderList() {
        return this.collections_;
    }

    @Override // proto.GameOrBuilder
    public int getCollectionsCount() {
        return this.collections_.size();
    }

    @Override // proto.GameOrBuilder
    public Collection getCollections(int i) {
        return this.collections_.get(i);
    }

    @Override // proto.GameOrBuilder
    public CollectionOrBuilder getCollectionsOrBuilder(int i) {
        return this.collections_.get(i);
    }

    public static Game parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer);
    }

    public static Game parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteBuffer, extensionRegistryLite);
    }

    public static Game parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public static Game parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    public static Game parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static Game parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static Game parseFrom(InputStream inputStream) throws IOException {
        return (Game) GeneratedMessage.parseWithIOException(PARSER, inputStream);
    }

    public static Game parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Game) GeneratedMessage.parseWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Game parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Game) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream);
    }

    public static Game parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Game) GeneratedMessage.parseDelimitedWithIOException(PARSER, inputStream, extensionRegistryLite);
    }

    public static Game parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Game) GeneratedMessage.parseWithIOException(PARSER, codedInputStream);
    }

    public static Game parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Game) GeneratedMessage.parseWithIOException(PARSER, codedInputStream, extensionRegistryLite);
    }

    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder newBuilderForType() {
        return newBuilder();
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.toBuilder();
    }

    /* WARN: Multi-variable type inference failed */
    public static Builder newBuilder(Game game) {
        return (Builder) DEFAULT_INSTANCE.toBuilder().mergeFrom((Message) game);
    }

    /* WARN: Multi-variable type inference failed */
    @Override // com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Builder toBuilder() {
        return this == DEFAULT_INSTANCE ? new Builder((GameIA) null) : (Builder) new Builder((GameIA) null).mergeFrom((Message) this);
    }

    /* INFO: Access modifiers changed from: protected */
    @Override // com.google.protobuf.AbstractMessage
    public Builder newBuilderForType(AbstractMessage.BuilderParent builderParent) {
        return new Builder(builderParent, null);
    }

    public static final class Builder extends GeneratedMessage.Builder<Builder> implements GameOrBuilder {
        private RepeatedFieldBuilder<AgeRating, AgeRating.Builder, AgeRatingOrBuilder> ageRatingsBuilder_;
        private List<AgeRating> ageRatings_;
        private int aggregatedRatingCount_;
        private double aggregatedRating_;
        private RepeatedFieldBuilder<AlternativeName, AlternativeName.Builder, AlternativeNameOrBuilder> alternativeNamesBuilder_;
        private List<AlternativeName> alternativeNames_;
        private RepeatedFieldBuilder<Artwork, Artwork.Builder, ArtworkOrBuilder> artworksBuilder_;
        private List<Artwork> artworks_;
        private int bitField0_;
        private int bitField1_;
        private RepeatedFieldBuilder<Game, Builder, GameOrBuilder> bundlesBuilder_;
        private List<Game> bundles_;
        private int category_;
        private Object checksum_;
        private SingleFieldBuilder<Collection, Collection.Builder, CollectionOrBuilder> collectionBuilder_;
        private Collection collection_;
        private RepeatedFieldBuilder<Collection, Collection.Builder, CollectionOrBuilder> collectionsBuilder_;
        private List<Collection> collections_;
        private SingleFieldBuilder<Cover, Cover.Builder, CoverOrBuilder> coverBuilder_;
        private Cover cover_;
        private SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> createdAtBuilder_;
        private Timestamp createdAt_;
        private RepeatedFieldBuilder<Game, Builder, GameOrBuilder> dlcsBuilder_;
        private List<Game> dlcs_;
        private RepeatedFieldBuilder<Game, Builder, GameOrBuilder> expandedGamesBuilder_;
        private List<Game> expandedGames_;
        private RepeatedFieldBuilder<Game, Builder, GameOrBuilder> expansionsBuilder_;
        private List<Game> expansions_;
        private RepeatedFieldBuilder<ExternalGame, ExternalGame.Builder, ExternalGameOrBuilder> externalGamesBuilder_;
        private List<ExternalGame> externalGames_;
        private SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> firstReleaseDateBuilder_;
        private Timestamp firstReleaseDate_;
        private int follows_;
        private RepeatedFieldBuilder<Game, Builder, GameOrBuilder> forksBuilder_;
        private List<Game> forks_;
        private SingleFieldBuilder<Franchise, Franchise.Builder, FranchiseOrBuilder> franchiseBuilder_;
        private Franchise franchise_;
        private RepeatedFieldBuilder<Franchise, Franchise.Builder, FranchiseOrBuilder> franchisesBuilder_;
        private List<Franchise> franchises_;
        private RepeatedFieldBuilder<GameEngine, GameEngine.Builder, GameEngineOrBuilder> gameEnginesBuilder_;
        private List<GameEngine> gameEngines_;
        private RepeatedFieldBuilder<GameLocalization, GameLocalization.Builder, GameLocalizationOrBuilder> gameLocalizationsBuilder_;
        private List<GameLocalization> gameLocalizations_;
        private RepeatedFieldBuilder<GameMode, GameMode.Builder, GameModeOrBuilder> gameModesBuilder_;
        private List<GameMode> gameModes_;
        private RepeatedFieldBuilder<Genre, Genre.Builder, GenreOrBuilder> genresBuilder_;
        private List<Genre> genres_;
        private int hypes_;
        private long id_;
        private RepeatedFieldBuilder<InvolvedCompany, InvolvedCompany.Builder, InvolvedCompanyOrBuilder> involvedCompaniesBuilder_;
        private List<InvolvedCompany> involvedCompanies_;
        private RepeatedFieldBuilder<Keyword, Keyword.Builder, KeywordOrBuilder> keywordsBuilder_;
        private List<Keyword> keywords_;
        private RepeatedFieldBuilder<LanguageSupport, LanguageSupport.Builder, LanguageSupportOrBuilder> languageSupportsBuilder_;
        private List<LanguageSupport> languageSupports_;
        private RepeatedFieldBuilder<MultiplayerMode, MultiplayerMode.Builder, MultiplayerModeOrBuilder> multiplayerModesBuilder_;
        private List<MultiplayerMode> multiplayerModes_;
        private Object name_;
        private SingleFieldBuilder<Game, Builder, GameOrBuilder> parentGameBuilder_;
        private Game parentGame_;
        private RepeatedFieldBuilder<Platform, Platform.Builder, PlatformOrBuilder> platformsBuilder_;
        private List<Platform> platforms_;
        private RepeatedFieldBuilder<PlayerPerspective, PlayerPerspective.Builder, PlayerPerspectiveOrBuilder> playerPerspectivesBuilder_;
        private List<PlayerPerspective> playerPerspectives_;
        private RepeatedFieldBuilder<Game, Builder, GameOrBuilder> portsBuilder_;
        private List<Game> ports_;
        private int ratingCount_;
        private double rating_;
        private RepeatedFieldBuilder<ReleaseDate, ReleaseDate.Builder, ReleaseDateOrBuilder> releaseDatesBuilder_;
        private List<ReleaseDate> releaseDates_;
        private RepeatedFieldBuilder<Game, Builder, GameOrBuilder> remakesBuilder_;
        private List<Game> remakes_;
        private RepeatedFieldBuilder<Game, Builder, GameOrBuilder> remastersBuilder_;
        private List<Game> remasters_;
        private RepeatedFieldBuilder<Screenshot, Screenshot.Builder, ScreenshotOrBuilder> screenshotsBuilder_;
        private List<Screenshot> screenshots_;
        private RepeatedFieldBuilder<Game, Builder, GameOrBuilder> similarGamesBuilder_;
        private List<Game> similarGames_;
        private Object slug_;
        private RepeatedFieldBuilder<Game, Builder, GameOrBuilder> standaloneExpansionsBuilder_;
        private List<Game> standaloneExpansions_;
        private int status_;
        private Object storyline_;
        private Object summary_;
        private Internal.IntList tags_;
        private RepeatedFieldBuilder<Theme, Theme.Builder, ThemeOrBuilder> themesBuilder_;
        private List<Theme> themes_;
        private int totalRatingCount_;
        private double totalRating_;
        private SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> updatedAtBuilder_;
        private Timestamp updatedAt_;
        private Object url_;
        private SingleFieldBuilder<Game, Builder, GameOrBuilder> versionParentBuilder_;
        private Game versionParent_;
        private Object versionTitle_;
        private RepeatedFieldBuilder<GameVideo, GameVideo.Builder, GameVideoOrBuilder> videosBuilder_;
        private List<GameVideo> videos_;
        private RepeatedFieldBuilder<Website, Website.Builder, WebsiteOrBuilder> websitesBuilder_;
        private List<Website> websites_;

        /* synthetic */ Builder(AbstractMessage.BuilderParent builderParent, GameIA gameIA) {
            this(builderParent);
        }

        /* synthetic */ Builder(GameIA gameIA) {
            this();
        }

        public static final Descriptors.Descriptor getDescriptor() {
            return Igdbproto.internal_static_proto_Game_descriptor;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder
        protected GeneratedMessage.FieldAccessorTable internalGetFieldAccessorTable() {
            return Igdbproto.internal_static_proto_Game_fieldAccessorTable.ensureFieldAccessorsInitialized(Game.class, Builder.class);
        }

        private Builder() {
            this.ageRatings_ = Collections.emptyList();
            this.alternativeNames_ = Collections.emptyList();
            this.artworks_ = Collections.emptyList();
            this.bundles_ = Collections.emptyList();
            this.category_ = 0;
            this.dlcs_ = Collections.emptyList();
            this.expansions_ = Collections.emptyList();
            this.externalGames_ = Collections.emptyList();
            this.franchises_ = Collections.emptyList();
            this.gameEngines_ = Collections.emptyList();
            this.gameModes_ = Collections.emptyList();
            this.genres_ = Collections.emptyList();
            this.involvedCompanies_ = Collections.emptyList();
            this.keywords_ = Collections.emptyList();
            this.multiplayerModes_ = Collections.emptyList();
            this.name_ = "";
            this.platforms_ = Collections.emptyList();
            this.playerPerspectives_ = Collections.emptyList();
            this.releaseDates_ = Collections.emptyList();
            this.screenshots_ = Collections.emptyList();
            this.similarGames_ = Collections.emptyList();
            this.slug_ = "";
            this.standaloneExpansions_ = Collections.emptyList();
            this.status_ = 0;
            this.storyline_ = "";
            this.summary_ = "";
            this.tags_ = Game.emptyIntList();
            this.themes_ = Collections.emptyList();
            this.url_ = "";
            this.versionTitle_ = "";
            this.videos_ = Collections.emptyList();
            this.websites_ = Collections.emptyList();
            this.checksum_ = "";
            this.remakes_ = Collections.emptyList();
            this.remasters_ = Collections.emptyList();
            this.expandedGames_ = Collections.emptyList();
            this.ports_ = Collections.emptyList();
            this.forks_ = Collections.emptyList();
            this.languageSupports_ = Collections.emptyList();
            this.gameLocalizations_ = Collections.emptyList();
            this.collections_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        private Builder(AbstractMessage.BuilderParent builderParent) {
            super(builderParent);
            this.ageRatings_ = Collections.emptyList();
            this.alternativeNames_ = Collections.emptyList();
            this.artworks_ = Collections.emptyList();
            this.bundles_ = Collections.emptyList();
            this.category_ = 0;
            this.dlcs_ = Collections.emptyList();
            this.expansions_ = Collections.emptyList();
            this.externalGames_ = Collections.emptyList();
            this.franchises_ = Collections.emptyList();
            this.gameEngines_ = Collections.emptyList();
            this.gameModes_ = Collections.emptyList();
            this.genres_ = Collections.emptyList();
            this.involvedCompanies_ = Collections.emptyList();
            this.keywords_ = Collections.emptyList();
            this.multiplayerModes_ = Collections.emptyList();
            this.name_ = "";
            this.platforms_ = Collections.emptyList();
            this.playerPerspectives_ = Collections.emptyList();
            this.releaseDates_ = Collections.emptyList();
            this.screenshots_ = Collections.emptyList();
            this.similarGames_ = Collections.emptyList();
            this.slug_ = "";
            this.standaloneExpansions_ = Collections.emptyList();
            this.status_ = 0;
            this.storyline_ = "";
            this.summary_ = "";
            this.tags_ = Game.emptyIntList();
            this.themes_ = Collections.emptyList();
            this.url_ = "";
            this.versionTitle_ = "";
            this.videos_ = Collections.emptyList();
            this.websites_ = Collections.emptyList();
            this.checksum_ = "";
            this.remakes_ = Collections.emptyList();
            this.remasters_ = Collections.emptyList();
            this.expandedGames_ = Collections.emptyList();
            this.ports_ = Collections.emptyList();
            this.forks_ = Collections.emptyList();
            this.languageSupports_ = Collections.emptyList();
            this.gameLocalizations_ = Collections.emptyList();
            this.collections_ = Collections.emptyList();
            maybeForceBuilderInitialization();
        }

        private void maybeForceBuilderInitialization() {
            if (Game.alwaysUseFieldBuilders) {
                getAgeRatingsFieldBuilder();
                getAlternativeNamesFieldBuilder();
                getArtworksFieldBuilder();
                getBundlesFieldBuilder();
                getCollectionFieldBuilder();
                getCoverFieldBuilder();
                getCreatedAtFieldBuilder();
                getDlcsFieldBuilder();
                getExpansionsFieldBuilder();
                getExternalGamesFieldBuilder();
                getFirstReleaseDateFieldBuilder();
                getFranchiseFieldBuilder();
                getFranchisesFieldBuilder();
                getGameEnginesFieldBuilder();
                getGameModesFieldBuilder();
                getGenresFieldBuilder();
                getInvolvedCompaniesFieldBuilder();
                getKeywordsFieldBuilder();
                getMultiplayerModesFieldBuilder();
                getParentGameFieldBuilder();
                getPlatformsFieldBuilder();
                getPlayerPerspectivesFieldBuilder();
                getReleaseDatesFieldBuilder();
                getScreenshotsFieldBuilder();
                getSimilarGamesFieldBuilder();
                getStandaloneExpansionsFieldBuilder();
                getThemesFieldBuilder();
                getUpdatedAtFieldBuilder();
                getVersionParentFieldBuilder();
                getVideosFieldBuilder();
                getWebsitesFieldBuilder();
                getRemakesFieldBuilder();
                getRemastersFieldBuilder();
                getExpandedGamesFieldBuilder();
                getPortsFieldBuilder();
                getForksFieldBuilder();
                getLanguageSupportsFieldBuilder();
                getGameLocalizationsFieldBuilder();
                getCollectionsFieldBuilder();
            }
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.AbstractMessage.Builder, com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Builder clear() {
            super.clear();
            this.bitField0_ = 0;
            this.bitField1_ = 0;
            this.id_ = 0L;
            RepeatedFieldBuilder<AgeRating, AgeRating.Builder, AgeRatingOrBuilder> repeatedFieldBuilder = this.ageRatingsBuilder_;
            if (repeatedFieldBuilder == null) {
                this.ageRatings_ = Collections.emptyList();
            } else {
                this.ageRatings_ = null;
                repeatedFieldBuilder.clear();
            }
            this.bitField0_ &= -3;
            this.aggregatedRating_ = 0.0d;
            this.aggregatedRatingCount_ = 0;
            RepeatedFieldBuilder<AlternativeName, AlternativeName.Builder, AlternativeNameOrBuilder> repeatedFieldBuilder2 = this.alternativeNamesBuilder_;
            if (repeatedFieldBuilder2 == null) {
                this.alternativeNames_ = Collections.emptyList();
            } else {
                this.alternativeNames_ = null;
                repeatedFieldBuilder2.clear();
            }
            this.bitField0_ &= -17;
            RepeatedFieldBuilder<Artwork, Artwork.Builder, ArtworkOrBuilder> repeatedFieldBuilder3 = this.artworksBuilder_;
            if (repeatedFieldBuilder3 == null) {
                this.artworks_ = Collections.emptyList();
            } else {
                this.artworks_ = null;
                repeatedFieldBuilder3.clear();
            }
            this.bitField0_ &= -33;
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder4 = this.bundlesBuilder_;
            if (repeatedFieldBuilder4 == null) {
                this.bundles_ = Collections.emptyList();
            } else {
                this.bundles_ = null;
                repeatedFieldBuilder4.clear();
            }
            this.bitField0_ &= -65;
            this.category_ = 0;
            this.collection_ = null;
            SingleFieldBuilder<Collection, Collection.Builder, CollectionOrBuilder> singleFieldBuilder = this.collectionBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.collectionBuilder_ = null;
            }
            this.cover_ = null;
            SingleFieldBuilder<Cover, Cover.Builder, CoverOrBuilder> singleFieldBuilder2 = this.coverBuilder_;
            if (singleFieldBuilder2 != null) {
                singleFieldBuilder2.dispose();
                this.coverBuilder_ = null;
            }
            this.createdAt_ = null;
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder3 = this.createdAtBuilder_;
            if (singleFieldBuilder3 != null) {
                singleFieldBuilder3.dispose();
                this.createdAtBuilder_ = null;
            }
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder5 = this.dlcsBuilder_;
            if (repeatedFieldBuilder5 == null) {
                this.dlcs_ = Collections.emptyList();
            } else {
                this.dlcs_ = null;
                repeatedFieldBuilder5.clear();
            }
            this.bitField0_ &= -2049;
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder6 = this.expansionsBuilder_;
            if (repeatedFieldBuilder6 == null) {
                this.expansions_ = Collections.emptyList();
            } else {
                this.expansions_ = null;
                repeatedFieldBuilder6.clear();
            }
            this.bitField0_ &= -4097;
            RepeatedFieldBuilder<ExternalGame, ExternalGame.Builder, ExternalGameOrBuilder> repeatedFieldBuilder7 = this.externalGamesBuilder_;
            if (repeatedFieldBuilder7 == null) {
                this.externalGames_ = Collections.emptyList();
            } else {
                this.externalGames_ = null;
                repeatedFieldBuilder7.clear();
            }
            this.bitField0_ &= -8193;
            this.firstReleaseDate_ = null;
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder4 = this.firstReleaseDateBuilder_;
            if (singleFieldBuilder4 != null) {
                singleFieldBuilder4.dispose();
                this.firstReleaseDateBuilder_ = null;
            }
            this.follows_ = 0;
            this.franchise_ = null;
            SingleFieldBuilder<Franchise, Franchise.Builder, FranchiseOrBuilder> singleFieldBuilder5 = this.franchiseBuilder_;
            if (singleFieldBuilder5 != null) {
                singleFieldBuilder5.dispose();
                this.franchiseBuilder_ = null;
            }
            RepeatedFieldBuilder<Franchise, Franchise.Builder, FranchiseOrBuilder> repeatedFieldBuilder8 = this.franchisesBuilder_;
            if (repeatedFieldBuilder8 == null) {
                this.franchises_ = Collections.emptyList();
            } else {
                this.franchises_ = null;
                repeatedFieldBuilder8.clear();
            }
            this.bitField0_ &= -131073;
            RepeatedFieldBuilder<GameEngine, GameEngine.Builder, GameEngineOrBuilder> repeatedFieldBuilder9 = this.gameEnginesBuilder_;
            if (repeatedFieldBuilder9 == null) {
                this.gameEngines_ = Collections.emptyList();
            } else {
                this.gameEngines_ = null;
                repeatedFieldBuilder9.clear();
            }
            this.bitField0_ &= -262145;
            RepeatedFieldBuilder<GameMode, GameMode.Builder, GameModeOrBuilder> repeatedFieldBuilder10 = this.gameModesBuilder_;
            if (repeatedFieldBuilder10 == null) {
                this.gameModes_ = Collections.emptyList();
            } else {
                this.gameModes_ = null;
                repeatedFieldBuilder10.clear();
            }
            this.bitField0_ &= -524289;
            RepeatedFieldBuilder<Genre, Genre.Builder, GenreOrBuilder> repeatedFieldBuilder11 = this.genresBuilder_;
            if (repeatedFieldBuilder11 == null) {
                this.genres_ = Collections.emptyList();
            } else {
                this.genres_ = null;
                repeatedFieldBuilder11.clear();
            }
            this.bitField0_ &= -1048577;
            this.hypes_ = 0;
            RepeatedFieldBuilder<InvolvedCompany, InvolvedCompany.Builder, InvolvedCompanyOrBuilder> repeatedFieldBuilder12 = this.involvedCompaniesBuilder_;
            if (repeatedFieldBuilder12 == null) {
                this.involvedCompanies_ = Collections.emptyList();
            } else {
                this.involvedCompanies_ = null;
                repeatedFieldBuilder12.clear();
            }
            this.bitField0_ &= -4194305;
            RepeatedFieldBuilder<Keyword, Keyword.Builder, KeywordOrBuilder> repeatedFieldBuilder13 = this.keywordsBuilder_;
            if (repeatedFieldBuilder13 == null) {
                this.keywords_ = Collections.emptyList();
            } else {
                this.keywords_ = null;
                repeatedFieldBuilder13.clear();
            }
            this.bitField0_ &= -8388609;
            RepeatedFieldBuilder<MultiplayerMode, MultiplayerMode.Builder, MultiplayerModeOrBuilder> repeatedFieldBuilder14 = this.multiplayerModesBuilder_;
            if (repeatedFieldBuilder14 == null) {
                this.multiplayerModes_ = Collections.emptyList();
            } else {
                this.multiplayerModes_ = null;
                repeatedFieldBuilder14.clear();
            }
            this.bitField0_ &= -16777217;
            this.name_ = "";
            this.parentGame_ = null;
            SingleFieldBuilder<Game, Builder, GameOrBuilder> singleFieldBuilder6 = this.parentGameBuilder_;
            if (singleFieldBuilder6 != null) {
                singleFieldBuilder6.dispose();
                this.parentGameBuilder_ = null;
            }
            RepeatedFieldBuilder<Platform, Platform.Builder, PlatformOrBuilder> repeatedFieldBuilder15 = this.platformsBuilder_;
            if (repeatedFieldBuilder15 == null) {
                this.platforms_ = Collections.emptyList();
            } else {
                this.platforms_ = null;
                repeatedFieldBuilder15.clear();
            }
            this.bitField0_ &= -134217729;
            RepeatedFieldBuilder<PlayerPerspective, PlayerPerspective.Builder, PlayerPerspectiveOrBuilder> repeatedFieldBuilder16 = this.playerPerspectivesBuilder_;
            if (repeatedFieldBuilder16 == null) {
                this.playerPerspectives_ = Collections.emptyList();
            } else {
                this.playerPerspectives_ = null;
                repeatedFieldBuilder16.clear();
            }
            this.bitField0_ &= -268435457;
            this.rating_ = 0.0d;
            this.ratingCount_ = 0;
            RepeatedFieldBuilder<ReleaseDate, ReleaseDate.Builder, ReleaseDateOrBuilder> repeatedFieldBuilder17 = this.releaseDatesBuilder_;
            if (repeatedFieldBuilder17 == null) {
                this.releaseDates_ = Collections.emptyList();
            } else {
                this.releaseDates_ = null;
                repeatedFieldBuilder17.clear();
            }
            this.bitField0_ &= Integer.MAX_VALUE;
            RepeatedFieldBuilder<Screenshot, Screenshot.Builder, ScreenshotOrBuilder> repeatedFieldBuilder18 = this.screenshotsBuilder_;
            if (repeatedFieldBuilder18 == null) {
                this.screenshots_ = Collections.emptyList();
            } else {
                this.screenshots_ = null;
                repeatedFieldBuilder18.clear();
            }
            this.bitField1_ &= -2;
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder19 = this.similarGamesBuilder_;
            if (repeatedFieldBuilder19 == null) {
                this.similarGames_ = Collections.emptyList();
            } else {
                this.similarGames_ = null;
                repeatedFieldBuilder19.clear();
            }
            this.bitField1_ &= -3;
            this.slug_ = "";
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder20 = this.standaloneExpansionsBuilder_;
            if (repeatedFieldBuilder20 == null) {
                this.standaloneExpansions_ = Collections.emptyList();
            } else {
                this.standaloneExpansions_ = null;
                repeatedFieldBuilder20.clear();
            }
            this.bitField1_ &= -9;
            this.status_ = 0;
            this.storyline_ = "";
            this.summary_ = "";
            this.tags_ = Game.emptyIntList();
            RepeatedFieldBuilder<Theme, Theme.Builder, ThemeOrBuilder> repeatedFieldBuilder21 = this.themesBuilder_;
            if (repeatedFieldBuilder21 == null) {
                this.themes_ = Collections.emptyList();
            } else {
                this.themes_ = null;
                repeatedFieldBuilder21.clear();
            }
            this.bitField1_ &= -257;
            this.totalRating_ = 0.0d;
            this.totalRatingCount_ = 0;
            this.updatedAt_ = null;
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder7 = this.updatedAtBuilder_;
            if (singleFieldBuilder7 != null) {
                singleFieldBuilder7.dispose();
                this.updatedAtBuilder_ = null;
            }
            this.url_ = "";
            this.versionParent_ = null;
            SingleFieldBuilder<Game, Builder, GameOrBuilder> singleFieldBuilder8 = this.versionParentBuilder_;
            if (singleFieldBuilder8 != null) {
                singleFieldBuilder8.dispose();
                this.versionParentBuilder_ = null;
            }
            this.versionTitle_ = "";
            RepeatedFieldBuilder<GameVideo, GameVideo.Builder, GameVideoOrBuilder> repeatedFieldBuilder22 = this.videosBuilder_;
            if (repeatedFieldBuilder22 == null) {
                this.videos_ = Collections.emptyList();
            } else {
                this.videos_ = null;
                repeatedFieldBuilder22.clear();
            }
            this.bitField1_ &= -32769;
            RepeatedFieldBuilder<Website, Website.Builder, WebsiteOrBuilder> repeatedFieldBuilder23 = this.websitesBuilder_;
            if (repeatedFieldBuilder23 == null) {
                this.websites_ = Collections.emptyList();
            } else {
                this.websites_ = null;
                repeatedFieldBuilder23.clear();
            }
            this.bitField1_ &= -65537;
            this.checksum_ = "";
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder24 = this.remakesBuilder_;
            if (repeatedFieldBuilder24 == null) {
                this.remakes_ = Collections.emptyList();
            } else {
                this.remakes_ = null;
                repeatedFieldBuilder24.clear();
            }
            this.bitField1_ &= -262145;
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder25 = this.remastersBuilder_;
            if (repeatedFieldBuilder25 == null) {
                this.remasters_ = Collections.emptyList();
            } else {
                this.remasters_ = null;
                repeatedFieldBuilder25.clear();
            }
            this.bitField1_ &= -524289;
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder26 = this.expandedGamesBuilder_;
            if (repeatedFieldBuilder26 == null) {
                this.expandedGames_ = Collections.emptyList();
            } else {
                this.expandedGames_ = null;
                repeatedFieldBuilder26.clear();
            }
            this.bitField1_ &= -1048577;
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder27 = this.portsBuilder_;
            if (repeatedFieldBuilder27 == null) {
                this.ports_ = Collections.emptyList();
            } else {
                this.ports_ = null;
                repeatedFieldBuilder27.clear();
            }
            this.bitField1_ &= -2097153;
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder28 = this.forksBuilder_;
            if (repeatedFieldBuilder28 == null) {
                this.forks_ = Collections.emptyList();
            } else {
                this.forks_ = null;
                repeatedFieldBuilder28.clear();
            }
            this.bitField1_ &= -4194305;
            RepeatedFieldBuilder<LanguageSupport, LanguageSupport.Builder, LanguageSupportOrBuilder> repeatedFieldBuilder29 = this.languageSupportsBuilder_;
            if (repeatedFieldBuilder29 == null) {
                this.languageSupports_ = Collections.emptyList();
            } else {
                this.languageSupports_ = null;
                repeatedFieldBuilder29.clear();
            }
            this.bitField1_ &= -8388609;
            RepeatedFieldBuilder<GameLocalization, GameLocalization.Builder, GameLocalizationOrBuilder> repeatedFieldBuilder30 = this.gameLocalizationsBuilder_;
            if (repeatedFieldBuilder30 == null) {
                this.gameLocalizations_ = Collections.emptyList();
            } else {
                this.gameLocalizations_ = null;
                repeatedFieldBuilder30.clear();
            }
            this.bitField1_ &= -16777217;
            RepeatedFieldBuilder<Collection, Collection.Builder, CollectionOrBuilder> repeatedFieldBuilder31 = this.collectionsBuilder_;
            if (repeatedFieldBuilder31 == null) {
                this.collections_ = Collections.emptyList();
            } else {
                this.collections_ = null;
                repeatedFieldBuilder31.clear();
            }
            this.bitField1_ &= -33554433;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessage.Builder, com.google.protobuf.Message.Builder, com.google.protobuf.MessageOrBuilder
        public Descriptors.Descriptor getDescriptorForType() {
            return Igdbproto.internal_static_proto_Game_descriptor;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
        public Game getDefaultInstanceForType() {
            return Game.getDefaultInstance();
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Game build() {
            Game gameBuildPartial = buildPartial();
            if (gameBuildPartial.isInitialized()) {
                return gameBuildPartial;
            }
            throw newUninitializedMessageException((Message) gameBuildPartial);
        }

        @Override // com.google.protobuf.MessageLite.Builder, com.google.protobuf.Message.Builder
        public Game buildPartial() {
            Game game = new Game(this, null);
            buildPartialRepeatedFields(game);
            if (this.bitField0_ != 0) {
                buildPartial0(game);
            }
            if (this.bitField1_ != 0) {
                buildPartial1(game);
            }
            onBuilt();
            return game;
        }

        private void buildPartialRepeatedFields(Game game) {
            RepeatedFieldBuilder<AgeRating, AgeRating.Builder, AgeRatingOrBuilder> repeatedFieldBuilder = this.ageRatingsBuilder_;
            if (repeatedFieldBuilder == null) {
                if ((this.bitField0_ & 2) != 0) {
                    this.ageRatings_ = Collections.unmodifiableList(this.ageRatings_);
                    this.bitField0_ &= -3;
                }
                game.ageRatings_ = this.ageRatings_;
            } else {
                game.ageRatings_ = repeatedFieldBuilder.build();
            }
            RepeatedFieldBuilder<AlternativeName, AlternativeName.Builder, AlternativeNameOrBuilder> repeatedFieldBuilder2 = this.alternativeNamesBuilder_;
            if (repeatedFieldBuilder2 == null) {
                if ((this.bitField0_ & 16) != 0) {
                    this.alternativeNames_ = Collections.unmodifiableList(this.alternativeNames_);
                    this.bitField0_ &= -17;
                }
                game.alternativeNames_ = this.alternativeNames_;
            } else {
                game.alternativeNames_ = repeatedFieldBuilder2.build();
            }
            RepeatedFieldBuilder<Artwork, Artwork.Builder, ArtworkOrBuilder> repeatedFieldBuilder3 = this.artworksBuilder_;
            if (repeatedFieldBuilder3 == null) {
                if ((this.bitField0_ & 32) != 0) {
                    this.artworks_ = Collections.unmodifiableList(this.artworks_);
                    this.bitField0_ &= -33;
                }
                game.artworks_ = this.artworks_;
            } else {
                game.artworks_ = repeatedFieldBuilder3.build();
            }
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder4 = this.bundlesBuilder_;
            if (repeatedFieldBuilder4 == null) {
                if ((this.bitField0_ & 64) != 0) {
                    this.bundles_ = Collections.unmodifiableList(this.bundles_);
                    this.bitField0_ &= -65;
                }
                game.bundles_ = this.bundles_;
            } else {
                game.bundles_ = repeatedFieldBuilder4.build();
            }
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder5 = this.dlcsBuilder_;
            if (repeatedFieldBuilder5 == null) {
                if ((this.bitField0_ & 2048) != 0) {
                    this.dlcs_ = Collections.unmodifiableList(this.dlcs_);
                    this.bitField0_ &= -2049;
                }
                game.dlcs_ = this.dlcs_;
            } else {
                game.dlcs_ = repeatedFieldBuilder5.build();
            }
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder6 = this.expansionsBuilder_;
            if (repeatedFieldBuilder6 == null) {
                if ((this.bitField0_ & 4096) != 0) {
                    this.expansions_ = Collections.unmodifiableList(this.expansions_);
                    this.bitField0_ &= -4097;
                }
                game.expansions_ = this.expansions_;
            } else {
                game.expansions_ = repeatedFieldBuilder6.build();
            }
            RepeatedFieldBuilder<ExternalGame, ExternalGame.Builder, ExternalGameOrBuilder> repeatedFieldBuilder7 = this.externalGamesBuilder_;
            if (repeatedFieldBuilder7 == null) {
                if ((this.bitField0_ & 8192) != 0) {
                    this.externalGames_ = Collections.unmodifiableList(this.externalGames_);
                    this.bitField0_ &= -8193;
                }
                game.externalGames_ = this.externalGames_;
            } else {
                game.externalGames_ = repeatedFieldBuilder7.build();
            }
            RepeatedFieldBuilder<Franchise, Franchise.Builder, FranchiseOrBuilder> repeatedFieldBuilder8 = this.franchisesBuilder_;
            if (repeatedFieldBuilder8 == null) {
                if ((this.bitField0_ & 131072) != 0) {
                    this.franchises_ = Collections.unmodifiableList(this.franchises_);
                    this.bitField0_ &= -131073;
                }
                game.franchises_ = this.franchises_;
            } else {
                game.franchises_ = repeatedFieldBuilder8.build();
            }
            RepeatedFieldBuilder<GameEngine, GameEngine.Builder, GameEngineOrBuilder> repeatedFieldBuilder9 = this.gameEnginesBuilder_;
            if (repeatedFieldBuilder9 == null) {
                if ((this.bitField0_ & 262144) != 0) {
                    this.gameEngines_ = Collections.unmodifiableList(this.gameEngines_);
                    this.bitField0_ &= -262145;
                }
                game.gameEngines_ = this.gameEngines_;
            } else {
                game.gameEngines_ = repeatedFieldBuilder9.build();
            }
            RepeatedFieldBuilder<GameMode, GameMode.Builder, GameModeOrBuilder> repeatedFieldBuilder10 = this.gameModesBuilder_;
            if (repeatedFieldBuilder10 == null) {
                if ((this.bitField0_ & 524288) != 0) {
                    this.gameModes_ = Collections.unmodifiableList(this.gameModes_);
                    this.bitField0_ &= -524289;
                }
                game.gameModes_ = this.gameModes_;
            } else {
                game.gameModes_ = repeatedFieldBuilder10.build();
            }
            RepeatedFieldBuilder<Genre, Genre.Builder, GenreOrBuilder> repeatedFieldBuilder11 = this.genresBuilder_;
            if (repeatedFieldBuilder11 == null) {
                if ((this.bitField0_ & 1048576) != 0) {
                    this.genres_ = Collections.unmodifiableList(this.genres_);
                    this.bitField0_ &= -1048577;
                }
                game.genres_ = this.genres_;
            } else {
                game.genres_ = repeatedFieldBuilder11.build();
            }
            RepeatedFieldBuilder<InvolvedCompany, InvolvedCompany.Builder, InvolvedCompanyOrBuilder> repeatedFieldBuilder12 = this.involvedCompaniesBuilder_;
            if (repeatedFieldBuilder12 == null) {
                if ((this.bitField0_ & 4194304) != 0) {
                    this.involvedCompanies_ = Collections.unmodifiableList(this.involvedCompanies_);
                    this.bitField0_ &= -4194305;
                }
                game.involvedCompanies_ = this.involvedCompanies_;
            } else {
                game.involvedCompanies_ = repeatedFieldBuilder12.build();
            }
            RepeatedFieldBuilder<Keyword, Keyword.Builder, KeywordOrBuilder> repeatedFieldBuilder13 = this.keywordsBuilder_;
            if (repeatedFieldBuilder13 == null) {
                if ((this.bitField0_ & 8388608) != 0) {
                    this.keywords_ = Collections.unmodifiableList(this.keywords_);
                    this.bitField0_ &= -8388609;
                }
                game.keywords_ = this.keywords_;
            } else {
                game.keywords_ = repeatedFieldBuilder13.build();
            }
            RepeatedFieldBuilder<MultiplayerMode, MultiplayerMode.Builder, MultiplayerModeOrBuilder> repeatedFieldBuilder14 = this.multiplayerModesBuilder_;
            if (repeatedFieldBuilder14 == null) {
                if ((this.bitField0_ & 16777216) != 0) {
                    this.multiplayerModes_ = Collections.unmodifiableList(this.multiplayerModes_);
                    this.bitField0_ &= -16777217;
                }
                game.multiplayerModes_ = this.multiplayerModes_;
            } else {
                game.multiplayerModes_ = repeatedFieldBuilder14.build();
            }
            RepeatedFieldBuilder<Platform, Platform.Builder, PlatformOrBuilder> repeatedFieldBuilder15 = this.platformsBuilder_;
            if (repeatedFieldBuilder15 == null) {
                if ((this.bitField0_ & 134217728) != 0) {
                    this.platforms_ = Collections.unmodifiableList(this.platforms_);
                    this.bitField0_ &= -134217729;
                }
                game.platforms_ = this.platforms_;
            } else {
                game.platforms_ = repeatedFieldBuilder15.build();
            }
            RepeatedFieldBuilder<PlayerPerspective, PlayerPerspective.Builder, PlayerPerspectiveOrBuilder> repeatedFieldBuilder16 = this.playerPerspectivesBuilder_;
            if (repeatedFieldBuilder16 == null) {
                if ((this.bitField0_ & 268435456) != 0) {
                    this.playerPerspectives_ = Collections.unmodifiableList(this.playerPerspectives_);
                    this.bitField0_ &= -268435457;
                }
                game.playerPerspectives_ = this.playerPerspectives_;
            } else {
                game.playerPerspectives_ = repeatedFieldBuilder16.build();
            }
            RepeatedFieldBuilder<ReleaseDate, ReleaseDate.Builder, ReleaseDateOrBuilder> repeatedFieldBuilder17 = this.releaseDatesBuilder_;
            if (repeatedFieldBuilder17 == null) {
                if ((this.bitField0_ & Integer.MIN_VALUE) != 0) {
                    this.releaseDates_ = Collections.unmodifiableList(this.releaseDates_);
                    this.bitField0_ &= Integer.MAX_VALUE;
                }
                game.releaseDates_ = this.releaseDates_;
            } else {
                game.releaseDates_ = repeatedFieldBuilder17.build();
            }
            RepeatedFieldBuilder<Screenshot, Screenshot.Builder, ScreenshotOrBuilder> repeatedFieldBuilder18 = this.screenshotsBuilder_;
            if (repeatedFieldBuilder18 == null) {
                if ((this.bitField1_ & 1) != 0) {
                    this.screenshots_ = Collections.unmodifiableList(this.screenshots_);
                    this.bitField1_ &= -2;
                }
                game.screenshots_ = this.screenshots_;
            } else {
                game.screenshots_ = repeatedFieldBuilder18.build();
            }
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder19 = this.similarGamesBuilder_;
            if (repeatedFieldBuilder19 == null) {
                if ((this.bitField1_ & 2) != 0) {
                    this.similarGames_ = Collections.unmodifiableList(this.similarGames_);
                    this.bitField1_ &= -3;
                }
                game.similarGames_ = this.similarGames_;
            } else {
                game.similarGames_ = repeatedFieldBuilder19.build();
            }
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder20 = this.standaloneExpansionsBuilder_;
            if (repeatedFieldBuilder20 == null) {
                if ((this.bitField1_ & 8) != 0) {
                    this.standaloneExpansions_ = Collections.unmodifiableList(this.standaloneExpansions_);
                    this.bitField1_ &= -9;
                }
                game.standaloneExpansions_ = this.standaloneExpansions_;
            } else {
                game.standaloneExpansions_ = repeatedFieldBuilder20.build();
            }
            RepeatedFieldBuilder<Theme, Theme.Builder, ThemeOrBuilder> repeatedFieldBuilder21 = this.themesBuilder_;
            if (repeatedFieldBuilder21 == null) {
                if ((this.bitField1_ & 256) != 0) {
                    this.themes_ = Collections.unmodifiableList(this.themes_);
                    this.bitField1_ &= -257;
                }
                game.themes_ = this.themes_;
            } else {
                game.themes_ = repeatedFieldBuilder21.build();
            }
            RepeatedFieldBuilder<GameVideo, GameVideo.Builder, GameVideoOrBuilder> repeatedFieldBuilder22 = this.videosBuilder_;
            if (repeatedFieldBuilder22 == null) {
                if ((this.bitField1_ & 32768) != 0) {
                    this.videos_ = Collections.unmodifiableList(this.videos_);
                    this.bitField1_ &= -32769;
                }
                game.videos_ = this.videos_;
            } else {
                game.videos_ = repeatedFieldBuilder22.build();
            }
            RepeatedFieldBuilder<Website, Website.Builder, WebsiteOrBuilder> repeatedFieldBuilder23 = this.websitesBuilder_;
            if (repeatedFieldBuilder23 == null) {
                if ((this.bitField1_ & 65536) != 0) {
                    this.websites_ = Collections.unmodifiableList(this.websites_);
                    this.bitField1_ &= -65537;
                }
                game.websites_ = this.websites_;
            } else {
                game.websites_ = repeatedFieldBuilder23.build();
            }
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder24 = this.remakesBuilder_;
            if (repeatedFieldBuilder24 == null) {
                if ((this.bitField1_ & 262144) != 0) {
                    this.remakes_ = Collections.unmodifiableList(this.remakes_);
                    this.bitField1_ &= -262145;
                }
                game.remakes_ = this.remakes_;
            } else {
                game.remakes_ = repeatedFieldBuilder24.build();
            }
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder25 = this.remastersBuilder_;
            if (repeatedFieldBuilder25 == null) {
                if ((this.bitField1_ & 524288) != 0) {
                    this.remasters_ = Collections.unmodifiableList(this.remasters_);
                    this.bitField1_ &= -524289;
                }
                game.remasters_ = this.remasters_;
            } else {
                game.remasters_ = repeatedFieldBuilder25.build();
            }
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder26 = this.expandedGamesBuilder_;
            if (repeatedFieldBuilder26 == null) {
                if ((this.bitField1_ & 1048576) != 0) {
                    this.expandedGames_ = Collections.unmodifiableList(this.expandedGames_);
                    this.bitField1_ &= -1048577;
                }
                game.expandedGames_ = this.expandedGames_;
            } else {
                game.expandedGames_ = repeatedFieldBuilder26.build();
            }
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder27 = this.portsBuilder_;
            if (repeatedFieldBuilder27 == null) {
                if ((this.bitField1_ & 2097152) != 0) {
                    this.ports_ = Collections.unmodifiableList(this.ports_);
                    this.bitField1_ &= -2097153;
                }
                game.ports_ = this.ports_;
            } else {
                game.ports_ = repeatedFieldBuilder27.build();
            }
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder28 = this.forksBuilder_;
            if (repeatedFieldBuilder28 == null) {
                if ((this.bitField1_ & 4194304) != 0) {
                    this.forks_ = Collections.unmodifiableList(this.forks_);
                    this.bitField1_ &= -4194305;
                }
                game.forks_ = this.forks_;
            } else {
                game.forks_ = repeatedFieldBuilder28.build();
            }
            RepeatedFieldBuilder<LanguageSupport, LanguageSupport.Builder, LanguageSupportOrBuilder> repeatedFieldBuilder29 = this.languageSupportsBuilder_;
            if (repeatedFieldBuilder29 == null) {
                if ((this.bitField1_ & 8388608) != 0) {
                    this.languageSupports_ = Collections.unmodifiableList(this.languageSupports_);
                    this.bitField1_ &= -8388609;
                }
                game.languageSupports_ = this.languageSupports_;
            } else {
                game.languageSupports_ = repeatedFieldBuilder29.build();
            }
            RepeatedFieldBuilder<GameLocalization, GameLocalization.Builder, GameLocalizationOrBuilder> repeatedFieldBuilder30 = this.gameLocalizationsBuilder_;
            if (repeatedFieldBuilder30 == null) {
                if ((this.bitField1_ & 16777216) != 0) {
                    this.gameLocalizations_ = Collections.unmodifiableList(this.gameLocalizations_);
                    this.bitField1_ &= -16777217;
                }
                game.gameLocalizations_ = this.gameLocalizations_;
            } else {
                game.gameLocalizations_ = repeatedFieldBuilder30.build();
            }
            RepeatedFieldBuilder<Collection, Collection.Builder, CollectionOrBuilder> repeatedFieldBuilder31 = this.collectionsBuilder_;
            if (repeatedFieldBuilder31 == null) {
                if ((this.bitField1_ & MediaHttpDownloader.MAXIMUM_CHUNK_SIZE) != 0) {
                    this.collections_ = Collections.unmodifiableList(this.collections_);
                    this.bitField1_ &= -33554433;
                }
                game.collections_ = this.collections_;
                return;
            }
            game.collections_ = repeatedFieldBuilder31.build();
        }

        private void buildPartial0(Game game) {
            int i;
            Game game2;
            Franchise franchise;
            Timestamp timestamp;
            Timestamp timestamp2;
            Cover cover;
            Collection collection;
            int i2 = this.bitField0_;
            if ((i2 & 1) != 0) {
                game.id_ = this.id_;
            }
            if ((i2 & 4) != 0) {
                game.aggregatedRating_ = this.aggregatedRating_;
            }
            if ((i2 & 8) != 0) {
                game.aggregatedRatingCount_ = this.aggregatedRatingCount_;
            }
            if ((i2 & 128) != 0) {
                game.category_ = this.category_;
            }
            if ((i2 & 256) != 0) {
                SingleFieldBuilder<Collection, Collection.Builder, CollectionOrBuilder> singleFieldBuilder = this.collectionBuilder_;
                if (singleFieldBuilder == null) {
                    collection = this.collection_;
                } else {
                    collection = (Collection) singleFieldBuilder.build();
                }
                game.collection_ = collection;
                i = 1;
            } else {
                i = 0;
            }
            if ((i2 & 512) != 0) {
                SingleFieldBuilder<Cover, Cover.Builder, CoverOrBuilder> singleFieldBuilder2 = this.coverBuilder_;
                if (singleFieldBuilder2 == null) {
                    cover = this.cover_;
                } else {
                    cover = (Cover) singleFieldBuilder2.build();
                }
                game.cover_ = cover;
                i |= 2;
            }
            if ((i2 & 1024) != 0) {
                SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder3 = this.createdAtBuilder_;
                if (singleFieldBuilder3 == null) {
                    timestamp2 = this.createdAt_;
                } else {
                    timestamp2 = (Timestamp) singleFieldBuilder3.build();
                }
                game.createdAt_ = timestamp2;
                i |= 4;
            }
            if ((i2 & 16384) != 0) {
                SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder4 = this.firstReleaseDateBuilder_;
                if (singleFieldBuilder4 == null) {
                    timestamp = this.firstReleaseDate_;
                } else {
                    timestamp = (Timestamp) singleFieldBuilder4.build();
                }
                game.firstReleaseDate_ = timestamp;
                i |= 8;
            }
            if ((32768 & i2) != 0) {
                game.follows_ = this.follows_;
            }
            if ((65536 & i2) != 0) {
                SingleFieldBuilder<Franchise, Franchise.Builder, FranchiseOrBuilder> singleFieldBuilder5 = this.franchiseBuilder_;
                if (singleFieldBuilder5 == null) {
                    franchise = this.franchise_;
                } else {
                    franchise = (Franchise) singleFieldBuilder5.build();
                }
                game.franchise_ = franchise;
                i |= 16;
            }
            if ((2097152 & i2) != 0) {
                game.hypes_ = this.hypes_;
            }
            if ((33554432 & i2) != 0) {
                game.name_ = this.name_;
            }
            if ((67108864 & i2) != 0) {
                SingleFieldBuilder<Game, Builder, GameOrBuilder> singleFieldBuilder6 = this.parentGameBuilder_;
                if (singleFieldBuilder6 == null) {
                    game2 = this.parentGame_;
                } else {
                    game2 = (Game) singleFieldBuilder6.build();
                }
                game.parentGame_ = game2;
                i |= 32;
            }
            if ((536870912 & i2) != 0) {
                game.rating_ = this.rating_;
            }
            if ((i2 & 1073741824) != 0) {
                game.ratingCount_ = this.ratingCount_;
            }
            game.bitField0_ |= i;
        }

        private void buildPartial1(Game game) {
            int i;
            Game game2;
            Timestamp timestamp;
            int i2 = this.bitField1_;
            if ((i2 & 4) != 0) {
                game.slug_ = this.slug_;
            }
            if ((i2 & 16) != 0) {
                game.status_ = this.status_;
            }
            if ((i2 & 32) != 0) {
                game.storyline_ = this.storyline_;
            }
            if ((i2 & 64) != 0) {
                game.summary_ = this.summary_;
            }
            if ((i2 & 128) != 0) {
                this.tags_.makeImmutable();
                game.tags_ = this.tags_;
            }
            if ((i2 & 512) != 0) {
                game.totalRating_ = this.totalRating_;
            }
            if ((i2 & 1024) != 0) {
                game.totalRatingCount_ = this.totalRatingCount_;
            }
            if ((i2 & 2048) != 0) {
                SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.updatedAtBuilder_;
                if (singleFieldBuilder == null) {
                    timestamp = this.updatedAt_;
                } else {
                    timestamp = (Timestamp) singleFieldBuilder.build();
                }
                game.updatedAt_ = timestamp;
                i = 64;
            } else {
                i = 0;
            }
            if ((i2 & 4096) != 0) {
                game.url_ = this.url_;
            }
            if ((i2 & 8192) != 0) {
                SingleFieldBuilder<Game, Builder, GameOrBuilder> singleFieldBuilder2 = this.versionParentBuilder_;
                if (singleFieldBuilder2 == null) {
                    game2 = this.versionParent_;
                } else {
                    game2 = (Game) singleFieldBuilder2.build();
                }
                game.versionParent_ = game2;
                i |= 128;
            }
            if ((i2 & 16384) != 0) {
                game.versionTitle_ = this.versionTitle_;
            }
            if ((i2 & 131072) != 0) {
                game.checksum_ = this.checksum_;
            }
            game.bitField0_ |= i;
        }

        @Override // proto.GameOrBuilder
        public long getId() {
            return this.id_;
        }

        public Builder setId(long j) {
            this.id_ = j;
            this.bitField0_ |= 1;
            onChanged();
            return this;
        }

        public Builder clearId() {
            this.bitField0_ &= -2;
            this.id_ = 0L;
            onChanged();
            return this;
        }

        private void ensureAgeRatingsIsMutable() {
            if ((this.bitField0_ & 2) == 0) {
                this.ageRatings_ = new ArrayList(this.ageRatings_);
                this.bitField0_ |= 2;
            }
        }

        @Override // proto.GameOrBuilder
        public List<AgeRating> getAgeRatingsList() {
            RepeatedFieldBuilder<AgeRating, AgeRating.Builder, AgeRatingOrBuilder> repeatedFieldBuilder = this.ageRatingsBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.ageRatings_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // proto.GameOrBuilder
        public int getAgeRatingsCount() {
            RepeatedFieldBuilder<AgeRating, AgeRating.Builder, AgeRatingOrBuilder> repeatedFieldBuilder = this.ageRatingsBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.ageRatings_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // proto.GameOrBuilder
        public AgeRating getAgeRatings(int i) {
            RepeatedFieldBuilder<AgeRating, AgeRating.Builder, AgeRatingOrBuilder> repeatedFieldBuilder = this.ageRatingsBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.ageRatings_.get(i);
            }
            return (AgeRating) repeatedFieldBuilder.getMessage(i);
        }

        public Builder setAgeRatings(int i, AgeRating ageRating) {
            RepeatedFieldBuilder<AgeRating, AgeRating.Builder, AgeRatingOrBuilder> repeatedFieldBuilder = this.ageRatingsBuilder_;
            if (repeatedFieldBuilder == null) {
                ageRating.getClass();
                ensureAgeRatingsIsMutable();
                this.ageRatings_.set(i, ageRating);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, ageRating);
            return this;
        }

        public Builder setAgeRatings(int i, AgeRating.Builder builder) {
            RepeatedFieldBuilder<AgeRating, AgeRating.Builder, AgeRatingOrBuilder> repeatedFieldBuilder = this.ageRatingsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureAgeRatingsIsMutable();
                this.ageRatings_.set(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, builder.build());
            return this;
        }

        public Builder addAgeRatings(AgeRating ageRating) {
            RepeatedFieldBuilder<AgeRating, AgeRating.Builder, AgeRatingOrBuilder> repeatedFieldBuilder = this.ageRatingsBuilder_;
            if (repeatedFieldBuilder == null) {
                ageRating.getClass();
                ensureAgeRatingsIsMutable();
                this.ageRatings_.add(ageRating);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(ageRating);
            return this;
        }

        public Builder addAgeRatings(int i, AgeRating ageRating) {
            RepeatedFieldBuilder<AgeRating, AgeRating.Builder, AgeRatingOrBuilder> repeatedFieldBuilder = this.ageRatingsBuilder_;
            if (repeatedFieldBuilder == null) {
                ageRating.getClass();
                ensureAgeRatingsIsMutable();
                this.ageRatings_.add(i, ageRating);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, ageRating);
            return this;
        }

        public Builder addAgeRatings(AgeRating.Builder builder) {
            RepeatedFieldBuilder<AgeRating, AgeRating.Builder, AgeRatingOrBuilder> repeatedFieldBuilder = this.ageRatingsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureAgeRatingsIsMutable();
                this.ageRatings_.add(builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(builder.build());
            return this;
        }

        public Builder addAgeRatings(int i, AgeRating.Builder builder) {
            RepeatedFieldBuilder<AgeRating, AgeRating.Builder, AgeRatingOrBuilder> repeatedFieldBuilder = this.ageRatingsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureAgeRatingsIsMutable();
                this.ageRatings_.add(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, builder.build());
            return this;
        }

        public Builder addAllAgeRatings(Iterable<? extends AgeRating> iterable) {
            RepeatedFieldBuilder<AgeRating, AgeRating.Builder, AgeRatingOrBuilder> repeatedFieldBuilder = this.ageRatingsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureAgeRatingsIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.ageRatings_);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addAllMessages(iterable);
            return this;
        }

        public Builder clearAgeRatings() {
            RepeatedFieldBuilder<AgeRating, AgeRating.Builder, AgeRatingOrBuilder> repeatedFieldBuilder = this.ageRatingsBuilder_;
            if (repeatedFieldBuilder == null) {
                this.ageRatings_ = Collections.emptyList();
                this.bitField0_ &= -3;
                onChanged();
                return this;
            }
            repeatedFieldBuilder.clear();
            return this;
        }

        public Builder removeAgeRatings(int i) {
            RepeatedFieldBuilder<AgeRating, AgeRating.Builder, AgeRatingOrBuilder> repeatedFieldBuilder = this.ageRatingsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureAgeRatingsIsMutable();
                this.ageRatings_.remove(i);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.remove(i);
            return this;
        }

        public AgeRating.Builder getAgeRatingsBuilder(int i) {
            return (AgeRating.Builder) getAgeRatingsFieldBuilder().getBuilder(i);
        }

        @Override // proto.GameOrBuilder
        public AgeRatingOrBuilder getAgeRatingsOrBuilder(int i) {
            RepeatedFieldBuilder<AgeRating, AgeRating.Builder, AgeRatingOrBuilder> repeatedFieldBuilder = this.ageRatingsBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.ageRatings_.get(i);
            }
            return (AgeRatingOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(i);
        }

        @Override // proto.GameOrBuilder
        public List<? extends AgeRatingOrBuilder> getAgeRatingsOrBuilderList() {
            RepeatedFieldBuilder<AgeRating, AgeRating.Builder, AgeRatingOrBuilder> repeatedFieldBuilder = this.ageRatingsBuilder_;
            if (repeatedFieldBuilder != null) {
                return repeatedFieldBuilder.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.ageRatings_);
        }

        public AgeRating.Builder addAgeRatingsBuilder() {
            return (AgeRating.Builder) getAgeRatingsFieldBuilder().addBuilder(AgeRating.getDefaultInstance());
        }

        public AgeRating.Builder addAgeRatingsBuilder(int i) {
            return (AgeRating.Builder) getAgeRatingsFieldBuilder().addBuilder(i, AgeRating.getDefaultInstance());
        }

        public List<AgeRating.Builder> getAgeRatingsBuilderList() {
            return getAgeRatingsFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilder<AgeRating, AgeRating.Builder, AgeRatingOrBuilder> getAgeRatingsFieldBuilder() {
            if (this.ageRatingsBuilder_ == null) {
                this.ageRatingsBuilder_ = new RepeatedFieldBuilder<>(this.ageRatings_, (this.bitField0_ & 2) != 0, getParentForChildren(), isClean());
                this.ageRatings_ = null;
            }
            return this.ageRatingsBuilder_;
        }

        @Override // proto.GameOrBuilder
        public double getAggregatedRating() {
            return this.aggregatedRating_;
        }

        public Builder setAggregatedRating(double d) {
            this.aggregatedRating_ = d;
            this.bitField0_ |= 4;
            onChanged();
            return this;
        }

        public Builder clearAggregatedRating() {
            this.bitField0_ &= -5;
            this.aggregatedRating_ = 0.0d;
            onChanged();
            return this;
        }

        @Override // proto.GameOrBuilder
        public int getAggregatedRatingCount() {
            return this.aggregatedRatingCount_;
        }

        public Builder setAggregatedRatingCount(int i) {
            this.aggregatedRatingCount_ = i;
            this.bitField0_ |= 8;
            onChanged();
            return this;
        }

        public Builder clearAggregatedRatingCount() {
            this.bitField0_ &= -9;
            this.aggregatedRatingCount_ = 0;
            onChanged();
            return this;
        }

        private void ensureAlternativeNamesIsMutable() {
            if ((this.bitField0_ & 16) == 0) {
                this.alternativeNames_ = new ArrayList(this.alternativeNames_);
                this.bitField0_ |= 16;
            }
        }

        @Override // proto.GameOrBuilder
        public List<AlternativeName> getAlternativeNamesList() {
            RepeatedFieldBuilder<AlternativeName, AlternativeName.Builder, AlternativeNameOrBuilder> repeatedFieldBuilder = this.alternativeNamesBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.alternativeNames_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // proto.GameOrBuilder
        public int getAlternativeNamesCount() {
            RepeatedFieldBuilder<AlternativeName, AlternativeName.Builder, AlternativeNameOrBuilder> repeatedFieldBuilder = this.alternativeNamesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.alternativeNames_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // proto.GameOrBuilder
        public AlternativeName getAlternativeNames(int i) {
            RepeatedFieldBuilder<AlternativeName, AlternativeName.Builder, AlternativeNameOrBuilder> repeatedFieldBuilder = this.alternativeNamesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.alternativeNames_.get(i);
            }
            return (AlternativeName) repeatedFieldBuilder.getMessage(i);
        }

        public Builder setAlternativeNames(int i, AlternativeName alternativeName) {
            RepeatedFieldBuilder<AlternativeName, AlternativeName.Builder, AlternativeNameOrBuilder> repeatedFieldBuilder = this.alternativeNamesBuilder_;
            if (repeatedFieldBuilder == null) {
                alternativeName.getClass();
                ensureAlternativeNamesIsMutable();
                this.alternativeNames_.set(i, alternativeName);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, alternativeName);
            return this;
        }

        public Builder setAlternativeNames(int i, AlternativeName.Builder builder) {
            RepeatedFieldBuilder<AlternativeName, AlternativeName.Builder, AlternativeNameOrBuilder> repeatedFieldBuilder = this.alternativeNamesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureAlternativeNamesIsMutable();
                this.alternativeNames_.set(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, builder.build());
            return this;
        }

        public Builder addAlternativeNames(AlternativeName alternativeName) {
            RepeatedFieldBuilder<AlternativeName, AlternativeName.Builder, AlternativeNameOrBuilder> repeatedFieldBuilder = this.alternativeNamesBuilder_;
            if (repeatedFieldBuilder == null) {
                alternativeName.getClass();
                ensureAlternativeNamesIsMutable();
                this.alternativeNames_.add(alternativeName);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(alternativeName);
            return this;
        }

        public Builder addAlternativeNames(int i, AlternativeName alternativeName) {
            RepeatedFieldBuilder<AlternativeName, AlternativeName.Builder, AlternativeNameOrBuilder> repeatedFieldBuilder = this.alternativeNamesBuilder_;
            if (repeatedFieldBuilder == null) {
                alternativeName.getClass();
                ensureAlternativeNamesIsMutable();
                this.alternativeNames_.add(i, alternativeName);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, alternativeName);
            return this;
        }

        public Builder addAlternativeNames(AlternativeName.Builder builder) {
            RepeatedFieldBuilder<AlternativeName, AlternativeName.Builder, AlternativeNameOrBuilder> repeatedFieldBuilder = this.alternativeNamesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureAlternativeNamesIsMutable();
                this.alternativeNames_.add(builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(builder.build());
            return this;
        }

        public Builder addAlternativeNames(int i, AlternativeName.Builder builder) {
            RepeatedFieldBuilder<AlternativeName, AlternativeName.Builder, AlternativeNameOrBuilder> repeatedFieldBuilder = this.alternativeNamesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureAlternativeNamesIsMutable();
                this.alternativeNames_.add(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, builder.build());
            return this;
        }

        public Builder addAllAlternativeNames(Iterable<? extends AlternativeName> iterable) {
            RepeatedFieldBuilder<AlternativeName, AlternativeName.Builder, AlternativeNameOrBuilder> repeatedFieldBuilder = this.alternativeNamesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureAlternativeNamesIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.alternativeNames_);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addAllMessages(iterable);
            return this;
        }

        public Builder clearAlternativeNames() {
            RepeatedFieldBuilder<AlternativeName, AlternativeName.Builder, AlternativeNameOrBuilder> repeatedFieldBuilder = this.alternativeNamesBuilder_;
            if (repeatedFieldBuilder == null) {
                this.alternativeNames_ = Collections.emptyList();
                this.bitField0_ &= -17;
                onChanged();
                return this;
            }
            repeatedFieldBuilder.clear();
            return this;
        }

        public Builder removeAlternativeNames(int i) {
            RepeatedFieldBuilder<AlternativeName, AlternativeName.Builder, AlternativeNameOrBuilder> repeatedFieldBuilder = this.alternativeNamesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureAlternativeNamesIsMutable();
                this.alternativeNames_.remove(i);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.remove(i);
            return this;
        }

        public AlternativeName.Builder getAlternativeNamesBuilder(int i) {
            return (AlternativeName.Builder) getAlternativeNamesFieldBuilder().getBuilder(i);
        }

        @Override // proto.GameOrBuilder
        public AlternativeNameOrBuilder getAlternativeNamesOrBuilder(int i) {
            RepeatedFieldBuilder<AlternativeName, AlternativeName.Builder, AlternativeNameOrBuilder> repeatedFieldBuilder = this.alternativeNamesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.alternativeNames_.get(i);
            }
            return (AlternativeNameOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(i);
        }

        @Override // proto.GameOrBuilder
        public List<? extends AlternativeNameOrBuilder> getAlternativeNamesOrBuilderList() {
            RepeatedFieldBuilder<AlternativeName, AlternativeName.Builder, AlternativeNameOrBuilder> repeatedFieldBuilder = this.alternativeNamesBuilder_;
            if (repeatedFieldBuilder != null) {
                return repeatedFieldBuilder.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.alternativeNames_);
        }

        public AlternativeName.Builder addAlternativeNamesBuilder() {
            return (AlternativeName.Builder) getAlternativeNamesFieldBuilder().addBuilder(AlternativeName.getDefaultInstance());
        }

        public AlternativeName.Builder addAlternativeNamesBuilder(int i) {
            return (AlternativeName.Builder) getAlternativeNamesFieldBuilder().addBuilder(i, AlternativeName.getDefaultInstance());
        }

        public List<AlternativeName.Builder> getAlternativeNamesBuilderList() {
            return getAlternativeNamesFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilder<AlternativeName, AlternativeName.Builder, AlternativeNameOrBuilder> getAlternativeNamesFieldBuilder() {
            if (this.alternativeNamesBuilder_ == null) {
                this.alternativeNamesBuilder_ = new RepeatedFieldBuilder<>(this.alternativeNames_, (this.bitField0_ & 16) != 0, getParentForChildren(), isClean());
                this.alternativeNames_ = null;
            }
            return this.alternativeNamesBuilder_;
        }

        private void ensureArtworksIsMutable() {
            if ((this.bitField0_ & 32) == 0) {
                this.artworks_ = new ArrayList(this.artworks_);
                this.bitField0_ |= 32;
            }
        }

        @Override // proto.GameOrBuilder
        public List<Artwork> getArtworksList() {
            RepeatedFieldBuilder<Artwork, Artwork.Builder, ArtworkOrBuilder> repeatedFieldBuilder = this.artworksBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.artworks_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // proto.GameOrBuilder
        public int getArtworksCount() {
            RepeatedFieldBuilder<Artwork, Artwork.Builder, ArtworkOrBuilder> repeatedFieldBuilder = this.artworksBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.artworks_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // proto.GameOrBuilder
        public Artwork getArtworks(int i) {
            RepeatedFieldBuilder<Artwork, Artwork.Builder, ArtworkOrBuilder> repeatedFieldBuilder = this.artworksBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.artworks_.get(i);
            }
            return (Artwork) repeatedFieldBuilder.getMessage(i);
        }

        public Builder setArtworks(int i, Artwork artwork) {
            RepeatedFieldBuilder<Artwork, Artwork.Builder, ArtworkOrBuilder> repeatedFieldBuilder = this.artworksBuilder_;
            if (repeatedFieldBuilder == null) {
                artwork.getClass();
                ensureArtworksIsMutable();
                this.artworks_.set(i, artwork);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, artwork);
            return this;
        }

        public Builder setArtworks(int i, Artwork.Builder builder) {
            RepeatedFieldBuilder<Artwork, Artwork.Builder, ArtworkOrBuilder> repeatedFieldBuilder = this.artworksBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureArtworksIsMutable();
                this.artworks_.set(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, builder.build());
            return this;
        }

        public Builder addArtworks(Artwork artwork) {
            RepeatedFieldBuilder<Artwork, Artwork.Builder, ArtworkOrBuilder> repeatedFieldBuilder = this.artworksBuilder_;
            if (repeatedFieldBuilder == null) {
                artwork.getClass();
                ensureArtworksIsMutable();
                this.artworks_.add(artwork);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(artwork);
            return this;
        }

        public Builder addArtworks(int i, Artwork artwork) {
            RepeatedFieldBuilder<Artwork, Artwork.Builder, ArtworkOrBuilder> repeatedFieldBuilder = this.artworksBuilder_;
            if (repeatedFieldBuilder == null) {
                artwork.getClass();
                ensureArtworksIsMutable();
                this.artworks_.add(i, artwork);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, artwork);
            return this;
        }

        public Builder addArtworks(Artwork.Builder builder) {
            RepeatedFieldBuilder<Artwork, Artwork.Builder, ArtworkOrBuilder> repeatedFieldBuilder = this.artworksBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureArtworksIsMutable();
                this.artworks_.add(builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(builder.build());
            return this;
        }

        public Builder addArtworks(int i, Artwork.Builder builder) {
            RepeatedFieldBuilder<Artwork, Artwork.Builder, ArtworkOrBuilder> repeatedFieldBuilder = this.artworksBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureArtworksIsMutable();
                this.artworks_.add(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, builder.build());
            return this;
        }

        public Builder addAllArtworks(Iterable<? extends Artwork> iterable) {
            RepeatedFieldBuilder<Artwork, Artwork.Builder, ArtworkOrBuilder> repeatedFieldBuilder = this.artworksBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureArtworksIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.artworks_);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addAllMessages(iterable);
            return this;
        }

        public Builder clearArtworks() {
            RepeatedFieldBuilder<Artwork, Artwork.Builder, ArtworkOrBuilder> repeatedFieldBuilder = this.artworksBuilder_;
            if (repeatedFieldBuilder == null) {
                this.artworks_ = Collections.emptyList();
                this.bitField0_ &= -33;
                onChanged();
                return this;
            }
            repeatedFieldBuilder.clear();
            return this;
        }

        public Builder removeArtworks(int i) {
            RepeatedFieldBuilder<Artwork, Artwork.Builder, ArtworkOrBuilder> repeatedFieldBuilder = this.artworksBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureArtworksIsMutable();
                this.artworks_.remove(i);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.remove(i);
            return this;
        }

        public Artwork.Builder getArtworksBuilder(int i) {
            return (Artwork.Builder) getArtworksFieldBuilder().getBuilder(i);
        }

        @Override // proto.GameOrBuilder
        public ArtworkOrBuilder getArtworksOrBuilder(int i) {
            RepeatedFieldBuilder<Artwork, Artwork.Builder, ArtworkOrBuilder> repeatedFieldBuilder = this.artworksBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.artworks_.get(i);
            }
            return (ArtworkOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(i);
        }

        @Override // proto.GameOrBuilder
        public List<? extends ArtworkOrBuilder> getArtworksOrBuilderList() {
            RepeatedFieldBuilder<Artwork, Artwork.Builder, ArtworkOrBuilder> repeatedFieldBuilder = this.artworksBuilder_;
            if (repeatedFieldBuilder != null) {
                return repeatedFieldBuilder.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.artworks_);
        }

        public Artwork.Builder addArtworksBuilder() {
            return (Artwork.Builder) getArtworksFieldBuilder().addBuilder(Artwork.getDefaultInstance());
        }

        public Artwork.Builder addArtworksBuilder(int i) {
            return (Artwork.Builder) getArtworksFieldBuilder().addBuilder(i, Artwork.getDefaultInstance());
        }

        public List<Artwork.Builder> getArtworksBuilderList() {
            return getArtworksFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilder<Artwork, Artwork.Builder, ArtworkOrBuilder> getArtworksFieldBuilder() {
            if (this.artworksBuilder_ == null) {
                this.artworksBuilder_ = new RepeatedFieldBuilder<>(this.artworks_, (this.bitField0_ & 32) != 0, getParentForChildren(), isClean());
                this.artworks_ = null;
            }
            return this.artworksBuilder_;
        }

        private void ensureBundlesIsMutable() {
            if ((this.bitField0_ & 64) == 0) {
                this.bundles_ = new ArrayList(this.bundles_);
                this.bitField0_ |= 64;
            }
        }

        @Override // proto.GameOrBuilder
        public List<Game> getBundlesList() {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.bundlesBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.bundles_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // proto.GameOrBuilder
        public int getBundlesCount() {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.bundlesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.bundles_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // proto.GameOrBuilder
        public Game getBundles(int i) {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.bundlesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.bundles_.get(i);
            }
            return (Game) repeatedFieldBuilder.getMessage(i);
        }

        public Builder setBundles(int i, Game game) {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.bundlesBuilder_;
            if (repeatedFieldBuilder == null) {
                game.getClass();
                ensureBundlesIsMutable();
                this.bundles_.set(i, game);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, game);
            return this;
        }

        public Builder setBundles(int i, Builder builder) {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.bundlesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureBundlesIsMutable();
                this.bundles_.set(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, builder.build());
            return this;
        }

        public Builder addBundles(Game game) {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.bundlesBuilder_;
            if (repeatedFieldBuilder == null) {
                game.getClass();
                ensureBundlesIsMutable();
                this.bundles_.add(game);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(game);
            return this;
        }

        public Builder addBundles(int i, Game game) {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.bundlesBuilder_;
            if (repeatedFieldBuilder == null) {
                game.getClass();
                ensureBundlesIsMutable();
                this.bundles_.add(i, game);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, game);
            return this;
        }

        public Builder addBundles(Builder builder) {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.bundlesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureBundlesIsMutable();
                this.bundles_.add(builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(builder.build());
            return this;
        }

        public Builder addBundles(int i, Builder builder) {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.bundlesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureBundlesIsMutable();
                this.bundles_.add(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, builder.build());
            return this;
        }

        public Builder addAllBundles(Iterable<? extends Game> iterable) {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.bundlesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureBundlesIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.bundles_);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addAllMessages(iterable);
            return this;
        }

        public Builder clearBundles() {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.bundlesBuilder_;
            if (repeatedFieldBuilder == null) {
                this.bundles_ = Collections.emptyList();
                this.bitField0_ &= -65;
                onChanged();
                return this;
            }
            repeatedFieldBuilder.clear();
            return this;
        }

        public Builder removeBundles(int i) {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.bundlesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureBundlesIsMutable();
                this.bundles_.remove(i);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.remove(i);
            return this;
        }

        public Builder getBundlesBuilder(int i) {
            return (Builder) getBundlesFieldBuilder().getBuilder(i);
        }

        @Override // proto.GameOrBuilder
        public GameOrBuilder getBundlesOrBuilder(int i) {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.bundlesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.bundles_.get(i);
            }
            return (GameOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(i);
        }

        @Override // proto.GameOrBuilder
        public List<? extends GameOrBuilder> getBundlesOrBuilderList() {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.bundlesBuilder_;
            if (repeatedFieldBuilder != null) {
                return repeatedFieldBuilder.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.bundles_);
        }

        public Builder addBundlesBuilder() {
            return (Builder) getBundlesFieldBuilder().addBuilder(Game.getDefaultInstance());
        }

        public Builder addBundlesBuilder(int i) {
            return (Builder) getBundlesFieldBuilder().addBuilder(i, Game.getDefaultInstance());
        }

        public List<Builder> getBundlesBuilderList() {
            return getBundlesFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilder<Game, Builder, GameOrBuilder> getBundlesFieldBuilder() {
            if (this.bundlesBuilder_ == null) {
                this.bundlesBuilder_ = new RepeatedFieldBuilder<>(this.bundles_, (this.bitField0_ & 64) != 0, getParentForChildren(), isClean());
                this.bundles_ = null;
            }
            return this.bundlesBuilder_;
        }

        @Override // proto.GameOrBuilder
        public int getCategoryValue() {
            return this.category_;
        }

        public Builder setCategoryValue(int i) {
            this.category_ = i;
            this.bitField0_ |= 128;
            onChanged();
            return this;
        }

        @Override // proto.GameOrBuilder
        public GameCategoryEnum getCategory() {
            GameCategoryEnum gameCategoryEnumForNumber = GameCategoryEnum.forNumber(this.category_);
            return gameCategoryEnumForNumber == null ? GameCategoryEnum.UNRECOGNIZED : gameCategoryEnumForNumber;
        }

        public Builder setCategory(GameCategoryEnum gameCategoryEnum) {
            gameCategoryEnum.getClass();
            this.bitField0_ |= 128;
            this.category_ = gameCategoryEnum.getNumber();
            onChanged();
            return this;
        }

        public Builder clearCategory() {
            this.bitField0_ &= -129;
            this.category_ = 0;
            onChanged();
            return this;
        }

        @Override // proto.GameOrBuilder
        public boolean hasCollection() {
            return (this.bitField0_ & 256) != 0;
        }

        @Override // proto.GameOrBuilder
        public Collection getCollection() {
            SingleFieldBuilder<Collection, Collection.Builder, CollectionOrBuilder> singleFieldBuilder = this.collectionBuilder_;
            if (singleFieldBuilder == null) {
                Collection collection = this.collection_;
                return collection == null ? Collection.getDefaultInstance() : collection;
            }
            return (Collection) singleFieldBuilder.getMessage();
        }

        public Builder setCollection(Collection collection) {
            SingleFieldBuilder<Collection, Collection.Builder, CollectionOrBuilder> singleFieldBuilder = this.collectionBuilder_;
            if (singleFieldBuilder == null) {
                collection.getClass();
                this.collection_ = collection;
            } else {
                singleFieldBuilder.setMessage(collection);
            }
            this.bitField0_ |= 256;
            onChanged();
            return this;
        }

        public Builder setCollection(Collection.Builder builder) {
            SingleFieldBuilder<Collection, Collection.Builder, CollectionOrBuilder> singleFieldBuilder = this.collectionBuilder_;
            if (singleFieldBuilder == null) {
                this.collection_ = builder.build();
            } else {
                singleFieldBuilder.setMessage(builder.build());
            }
            this.bitField0_ |= 256;
            onChanged();
            return this;
        }

        public Builder mergeCollection(Collection collection) {
            Collection collection2;
            SingleFieldBuilder<Collection, Collection.Builder, CollectionOrBuilder> singleFieldBuilder = this.collectionBuilder_;
            if (singleFieldBuilder == null) {
                if ((this.bitField0_ & 256) != 0 && (collection2 = this.collection_) != null && collection2 != Collection.getDefaultInstance()) {
                    getCollectionBuilder().mergeFrom((Message) collection);
                } else {
                    this.collection_ = collection;
                }
            } else {
                singleFieldBuilder.mergeFrom(collection);
            }
            if (this.collection_ != null) {
                this.bitField0_ |= 256;
                onChanged();
            }
            return this;
        }

        public Builder clearCollection() {
            this.bitField0_ &= -257;
            this.collection_ = null;
            SingleFieldBuilder<Collection, Collection.Builder, CollectionOrBuilder> singleFieldBuilder = this.collectionBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.collectionBuilder_ = null;
            }
            onChanged();
            return this;
        }

        public Collection.Builder getCollectionBuilder() {
            this.bitField0_ |= 256;
            onChanged();
            return (Collection.Builder) getCollectionFieldBuilder().getBuilder();
        }

        @Override // proto.GameOrBuilder
        public CollectionOrBuilder getCollectionOrBuilder() {
            SingleFieldBuilder<Collection, Collection.Builder, CollectionOrBuilder> singleFieldBuilder = this.collectionBuilder_;
            if (singleFieldBuilder != null) {
                return (CollectionOrBuilder) singleFieldBuilder.getMessageOrBuilder();
            }
            Collection collection = this.collection_;
            return collection == null ? Collection.getDefaultInstance() : collection;
        }

        private SingleFieldBuilder<Collection, Collection.Builder, CollectionOrBuilder> getCollectionFieldBuilder() {
            if (this.collectionBuilder_ == null) {
                this.collectionBuilder_ = new SingleFieldBuilder<>(getCollection(), getParentForChildren(), isClean());
                this.collection_ = null;
            }
            return this.collectionBuilder_;
        }

        @Override // proto.GameOrBuilder
        public boolean hasCover() {
            return (this.bitField0_ & 512) != 0;
        }

        @Override // proto.GameOrBuilder
        public Cover getCover() {
            SingleFieldBuilder<Cover, Cover.Builder, CoverOrBuilder> singleFieldBuilder = this.coverBuilder_;
            if (singleFieldBuilder == null) {
                Cover cover = this.cover_;
                return cover == null ? Cover.getDefaultInstance() : cover;
            }
            return (Cover) singleFieldBuilder.getMessage();
        }

        public Builder setCover(Cover cover) {
            SingleFieldBuilder<Cover, Cover.Builder, CoverOrBuilder> singleFieldBuilder = this.coverBuilder_;
            if (singleFieldBuilder == null) {
                cover.getClass();
                this.cover_ = cover;
            } else {
                singleFieldBuilder.setMessage(cover);
            }
            this.bitField0_ |= 512;
            onChanged();
            return this;
        }

        public Builder setCover(Cover.Builder builder) {
            SingleFieldBuilder<Cover, Cover.Builder, CoverOrBuilder> singleFieldBuilder = this.coverBuilder_;
            if (singleFieldBuilder == null) {
                this.cover_ = builder.build();
            } else {
                singleFieldBuilder.setMessage(builder.build());
            }
            this.bitField0_ |= 512;
            onChanged();
            return this;
        }

        public Builder mergeCover(Cover cover) {
            Cover cover2;
            SingleFieldBuilder<Cover, Cover.Builder, CoverOrBuilder> singleFieldBuilder = this.coverBuilder_;
            if (singleFieldBuilder == null) {
                if ((this.bitField0_ & 512) != 0 && (cover2 = this.cover_) != null && cover2 != Cover.getDefaultInstance()) {
                    getCoverBuilder().mergeFrom((Message) cover);
                } else {
                    this.cover_ = cover;
                }
            } else {
                singleFieldBuilder.mergeFrom(cover);
            }
            if (this.cover_ != null) {
                this.bitField0_ |= 512;
                onChanged();
            }
            return this;
        }

        public Builder clearCover() {
            this.bitField0_ &= -513;
            this.cover_ = null;
            SingleFieldBuilder<Cover, Cover.Builder, CoverOrBuilder> singleFieldBuilder = this.coverBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.coverBuilder_ = null;
            }
            onChanged();
            return this;
        }

        public Cover.Builder getCoverBuilder() {
            this.bitField0_ |= 512;
            onChanged();
            return (Cover.Builder) getCoverFieldBuilder().getBuilder();
        }

        @Override // proto.GameOrBuilder
        public CoverOrBuilder getCoverOrBuilder() {
            SingleFieldBuilder<Cover, Cover.Builder, CoverOrBuilder> singleFieldBuilder = this.coverBuilder_;
            if (singleFieldBuilder != null) {
                return (CoverOrBuilder) singleFieldBuilder.getMessageOrBuilder();
            }
            Cover cover = this.cover_;
            return cover == null ? Cover.getDefaultInstance() : cover;
        }

        private SingleFieldBuilder<Cover, Cover.Builder, CoverOrBuilder> getCoverFieldBuilder() {
            if (this.coverBuilder_ == null) {
                this.coverBuilder_ = new SingleFieldBuilder<>(getCover(), getParentForChildren(), isClean());
                this.cover_ = null;
            }
            return this.coverBuilder_;
        }

        @Override // proto.GameOrBuilder
        public boolean hasCreatedAt() {
            return (this.bitField0_ & 1024) != 0;
        }

        @Override // proto.GameOrBuilder
        public Timestamp getCreatedAt() {
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.createdAtBuilder_;
            if (singleFieldBuilder == null) {
                Timestamp timestamp = this.createdAt_;
                return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
            }
            return (Timestamp) singleFieldBuilder.getMessage();
        }

        public Builder setCreatedAt(Timestamp timestamp) {
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.createdAtBuilder_;
            if (singleFieldBuilder == null) {
                timestamp.getClass();
                this.createdAt_ = timestamp;
            } else {
                singleFieldBuilder.setMessage(timestamp);
            }
            this.bitField0_ |= 1024;
            onChanged();
            return this;
        }

        public Builder setCreatedAt(Timestamp.Builder builder) {
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.createdAtBuilder_;
            if (singleFieldBuilder == null) {
                this.createdAt_ = builder.build();
            } else {
                singleFieldBuilder.setMessage(builder.build());
            }
            this.bitField0_ |= 1024;
            onChanged();
            return this;
        }

        public Builder mergeCreatedAt(Timestamp timestamp) {
            Timestamp timestamp2;
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.createdAtBuilder_;
            if (singleFieldBuilder == null) {
                if ((this.bitField0_ & 1024) != 0 && (timestamp2 = this.createdAt_) != null && timestamp2 != Timestamp.getDefaultInstance()) {
                    getCreatedAtBuilder().mergeFrom(timestamp);
                } else {
                    this.createdAt_ = timestamp;
                }
            } else {
                singleFieldBuilder.mergeFrom(timestamp);
            }
            if (this.createdAt_ != null) {
                this.bitField0_ |= 1024;
                onChanged();
            }
            return this;
        }

        public Builder clearCreatedAt() {
            this.bitField0_ &= -1025;
            this.createdAt_ = null;
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.createdAtBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.createdAtBuilder_ = null;
            }
            onChanged();
            return this;
        }

        public Timestamp.Builder getCreatedAtBuilder() {
            this.bitField0_ |= 1024;
            onChanged();
            return (Timestamp.Builder) getCreatedAtFieldBuilder().getBuilder();
        }

        @Override // proto.GameOrBuilder
        public TimestampOrBuilder getCreatedAtOrBuilder() {
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.createdAtBuilder_;
            if (singleFieldBuilder != null) {
                return (TimestampOrBuilder) singleFieldBuilder.getMessageOrBuilder();
            }
            Timestamp timestamp = this.createdAt_;
            return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
        }

        private SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> getCreatedAtFieldBuilder() {
            if (this.createdAtBuilder_ == null) {
                this.createdAtBuilder_ = new SingleFieldBuilder<>(getCreatedAt(), getParentForChildren(), isClean());
                this.createdAt_ = null;
            }
            return this.createdAtBuilder_;
        }

        private void ensureDlcsIsMutable() {
            if ((this.bitField0_ & 2048) == 0) {
                this.dlcs_ = new ArrayList(this.dlcs_);
                this.bitField0_ |= 2048;
            }
        }

        @Override // proto.GameOrBuilder
        public List<Game> getDlcsList() {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.dlcsBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.dlcs_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // proto.GameOrBuilder
        public int getDlcsCount() {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.dlcsBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.dlcs_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // proto.GameOrBuilder
        public Game getDlcs(int i) {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.dlcsBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.dlcs_.get(i);
            }
            return (Game) repeatedFieldBuilder.getMessage(i);
        }

        public Builder setDlcs(int i, Game game) {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.dlcsBuilder_;
            if (repeatedFieldBuilder == null) {
                game.getClass();
                ensureDlcsIsMutable();
                this.dlcs_.set(i, game);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, game);
            return this;
        }

        public Builder setDlcs(int i, Builder builder) {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.dlcsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureDlcsIsMutable();
                this.dlcs_.set(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, builder.build());
            return this;
        }

        public Builder addDlcs(Game game) {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.dlcsBuilder_;
            if (repeatedFieldBuilder == null) {
                game.getClass();
                ensureDlcsIsMutable();
                this.dlcs_.add(game);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(game);
            return this;
        }

        public Builder addDlcs(int i, Game game) {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.dlcsBuilder_;
            if (repeatedFieldBuilder == null) {
                game.getClass();
                ensureDlcsIsMutable();
                this.dlcs_.add(i, game);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, game);
            return this;
        }

        public Builder addDlcs(Builder builder) {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.dlcsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureDlcsIsMutable();
                this.dlcs_.add(builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(builder.build());
            return this;
        }

        public Builder addDlcs(int i, Builder builder) {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.dlcsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureDlcsIsMutable();
                this.dlcs_.add(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, builder.build());
            return this;
        }

        public Builder addAllDlcs(Iterable<? extends Game> iterable) {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.dlcsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureDlcsIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.dlcs_);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addAllMessages(iterable);
            return this;
        }

        public Builder clearDlcs() {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.dlcsBuilder_;
            if (repeatedFieldBuilder == null) {
                this.dlcs_ = Collections.emptyList();
                this.bitField0_ &= -2049;
                onChanged();
                return this;
            }
            repeatedFieldBuilder.clear();
            return this;
        }

        public Builder removeDlcs(int i) {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.dlcsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureDlcsIsMutable();
                this.dlcs_.remove(i);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.remove(i);
            return this;
        }

        public Builder getDlcsBuilder(int i) {
            return (Builder) getDlcsFieldBuilder().getBuilder(i);
        }

        @Override // proto.GameOrBuilder
        public GameOrBuilder getDlcsOrBuilder(int i) {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.dlcsBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.dlcs_.get(i);
            }
            return (GameOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(i);
        }

        @Override // proto.GameOrBuilder
        public List<? extends GameOrBuilder> getDlcsOrBuilderList() {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.dlcsBuilder_;
            if (repeatedFieldBuilder != null) {
                return repeatedFieldBuilder.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.dlcs_);
        }

        public Builder addDlcsBuilder() {
            return (Builder) getDlcsFieldBuilder().addBuilder(Game.getDefaultInstance());
        }

        public Builder addDlcsBuilder(int i) {
            return (Builder) getDlcsFieldBuilder().addBuilder(i, Game.getDefaultInstance());
        }

        public List<Builder> getDlcsBuilderList() {
            return getDlcsFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilder<Game, Builder, GameOrBuilder> getDlcsFieldBuilder() {
            if (this.dlcsBuilder_ == null) {
                this.dlcsBuilder_ = new RepeatedFieldBuilder<>(this.dlcs_, (this.bitField0_ & 2048) != 0, getParentForChildren(), isClean());
                this.dlcs_ = null;
            }
            return this.dlcsBuilder_;
        }

        private void ensureExpansionsIsMutable() {
            if ((this.bitField0_ & 4096) == 0) {
                this.expansions_ = new ArrayList(this.expansions_);
                this.bitField0_ |= 4096;
            }
        }

        @Override // proto.GameOrBuilder
        public List<Game> getExpansionsList() {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.expansionsBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.expansions_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // proto.GameOrBuilder
        public int getExpansionsCount() {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.expansionsBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.expansions_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // proto.GameOrBuilder
        public Game getExpansions(int i) {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.expansionsBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.expansions_.get(i);
            }
            return (Game) repeatedFieldBuilder.getMessage(i);
        }

        public Builder setExpansions(int i, Game game) {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.expansionsBuilder_;
            if (repeatedFieldBuilder == null) {
                game.getClass();
                ensureExpansionsIsMutable();
                this.expansions_.set(i, game);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, game);
            return this;
        }

        public Builder setExpansions(int i, Builder builder) {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.expansionsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureExpansionsIsMutable();
                this.expansions_.set(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, builder.build());
            return this;
        }

        public Builder addExpansions(Game game) {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.expansionsBuilder_;
            if (repeatedFieldBuilder == null) {
                game.getClass();
                ensureExpansionsIsMutable();
                this.expansions_.add(game);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(game);
            return this;
        }

        public Builder addExpansions(int i, Game game) {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.expansionsBuilder_;
            if (repeatedFieldBuilder == null) {
                game.getClass();
                ensureExpansionsIsMutable();
                this.expansions_.add(i, game);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, game);
            return this;
        }

        public Builder addExpansions(Builder builder) {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.expansionsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureExpansionsIsMutable();
                this.expansions_.add(builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(builder.build());
            return this;
        }

        public Builder addExpansions(int i, Builder builder) {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.expansionsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureExpansionsIsMutable();
                this.expansions_.add(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, builder.build());
            return this;
        }

        public Builder addAllExpansions(Iterable<? extends Game> iterable) {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.expansionsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureExpansionsIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.expansions_);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addAllMessages(iterable);
            return this;
        }

        public Builder clearExpansions() {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.expansionsBuilder_;
            if (repeatedFieldBuilder == null) {
                this.expansions_ = Collections.emptyList();
                this.bitField0_ &= -4097;
                onChanged();
                return this;
            }
            repeatedFieldBuilder.clear();
            return this;
        }

        public Builder removeExpansions(int i) {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.expansionsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureExpansionsIsMutable();
                this.expansions_.remove(i);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.remove(i);
            return this;
        }

        public Builder getExpansionsBuilder(int i) {
            return (Builder) getExpansionsFieldBuilder().getBuilder(i);
        }

        @Override // proto.GameOrBuilder
        public GameOrBuilder getExpansionsOrBuilder(int i) {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.expansionsBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.expansions_.get(i);
            }
            return (GameOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(i);
        }

        @Override // proto.GameOrBuilder
        public List<? extends GameOrBuilder> getExpansionsOrBuilderList() {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.expansionsBuilder_;
            if (repeatedFieldBuilder != null) {
                return repeatedFieldBuilder.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.expansions_);
        }

        public Builder addExpansionsBuilder() {
            return (Builder) getExpansionsFieldBuilder().addBuilder(Game.getDefaultInstance());
        }

        public Builder addExpansionsBuilder(int i) {
            return (Builder) getExpansionsFieldBuilder().addBuilder(i, Game.getDefaultInstance());
        }

        public List<Builder> getExpansionsBuilderList() {
            return getExpansionsFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilder<Game, Builder, GameOrBuilder> getExpansionsFieldBuilder() {
            if (this.expansionsBuilder_ == null) {
                this.expansionsBuilder_ = new RepeatedFieldBuilder<>(this.expansions_, (this.bitField0_ & 4096) != 0, getParentForChildren(), isClean());
                this.expansions_ = null;
            }
            return this.expansionsBuilder_;
        }

        private void ensureExternalGamesIsMutable() {
            if ((this.bitField0_ & 8192) == 0) {
                this.externalGames_ = new ArrayList(this.externalGames_);
                this.bitField0_ |= 8192;
            }
        }

        @Override // proto.GameOrBuilder
        public List<ExternalGame> getExternalGamesList() {
            RepeatedFieldBuilder<ExternalGame, ExternalGame.Builder, ExternalGameOrBuilder> repeatedFieldBuilder = this.externalGamesBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.externalGames_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // proto.GameOrBuilder
        public int getExternalGamesCount() {
            RepeatedFieldBuilder<ExternalGame, ExternalGame.Builder, ExternalGameOrBuilder> repeatedFieldBuilder = this.externalGamesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.externalGames_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // proto.GameOrBuilder
        public ExternalGame getExternalGames(int i) {
            RepeatedFieldBuilder<ExternalGame, ExternalGame.Builder, ExternalGameOrBuilder> repeatedFieldBuilder = this.externalGamesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.externalGames_.get(i);
            }
            return (ExternalGame) repeatedFieldBuilder.getMessage(i);
        }

        public Builder setExternalGames(int i, ExternalGame externalGame) {
            RepeatedFieldBuilder<ExternalGame, ExternalGame.Builder, ExternalGameOrBuilder> repeatedFieldBuilder = this.externalGamesBuilder_;
            if (repeatedFieldBuilder == null) {
                externalGame.getClass();
                ensureExternalGamesIsMutable();
                this.externalGames_.set(i, externalGame);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, externalGame);
            return this;
        }

        public Builder setExternalGames(int i, ExternalGame.Builder builder) {
            RepeatedFieldBuilder<ExternalGame, ExternalGame.Builder, ExternalGameOrBuilder> repeatedFieldBuilder = this.externalGamesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureExternalGamesIsMutable();
                this.externalGames_.set(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, builder.build());
            return this;
        }

        public Builder addExternalGames(ExternalGame externalGame) {
            RepeatedFieldBuilder<ExternalGame, ExternalGame.Builder, ExternalGameOrBuilder> repeatedFieldBuilder = this.externalGamesBuilder_;
            if (repeatedFieldBuilder == null) {
                externalGame.getClass();
                ensureExternalGamesIsMutable();
                this.externalGames_.add(externalGame);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(externalGame);
            return this;
        }

        public Builder addExternalGames(int i, ExternalGame externalGame) {
            RepeatedFieldBuilder<ExternalGame, ExternalGame.Builder, ExternalGameOrBuilder> repeatedFieldBuilder = this.externalGamesBuilder_;
            if (repeatedFieldBuilder == null) {
                externalGame.getClass();
                ensureExternalGamesIsMutable();
                this.externalGames_.add(i, externalGame);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, externalGame);
            return this;
        }

        public Builder addExternalGames(ExternalGame.Builder builder) {
            RepeatedFieldBuilder<ExternalGame, ExternalGame.Builder, ExternalGameOrBuilder> repeatedFieldBuilder = this.externalGamesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureExternalGamesIsMutable();
                this.externalGames_.add(builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(builder.build());
            return this;
        }

        public Builder addExternalGames(int i, ExternalGame.Builder builder) {
            RepeatedFieldBuilder<ExternalGame, ExternalGame.Builder, ExternalGameOrBuilder> repeatedFieldBuilder = this.externalGamesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureExternalGamesIsMutable();
                this.externalGames_.add(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, builder.build());
            return this;
        }

        public Builder addAllExternalGames(Iterable<? extends ExternalGame> iterable) {
            RepeatedFieldBuilder<ExternalGame, ExternalGame.Builder, ExternalGameOrBuilder> repeatedFieldBuilder = this.externalGamesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureExternalGamesIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.externalGames_);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addAllMessages(iterable);
            return this;
        }

        public Builder clearExternalGames() {
            RepeatedFieldBuilder<ExternalGame, ExternalGame.Builder, ExternalGameOrBuilder> repeatedFieldBuilder = this.externalGamesBuilder_;
            if (repeatedFieldBuilder == null) {
                this.externalGames_ = Collections.emptyList();
                this.bitField0_ &= -8193;
                onChanged();
                return this;
            }
            repeatedFieldBuilder.clear();
            return this;
        }

        public Builder removeExternalGames(int i) {
            RepeatedFieldBuilder<ExternalGame, ExternalGame.Builder, ExternalGameOrBuilder> repeatedFieldBuilder = this.externalGamesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureExternalGamesIsMutable();
                this.externalGames_.remove(i);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.remove(i);
            return this;
        }

        public ExternalGame.Builder getExternalGamesBuilder(int i) {
            return (ExternalGame.Builder) getExternalGamesFieldBuilder().getBuilder(i);
        }

        @Override // proto.GameOrBuilder
        public ExternalGameOrBuilder getExternalGamesOrBuilder(int i) {
            RepeatedFieldBuilder<ExternalGame, ExternalGame.Builder, ExternalGameOrBuilder> repeatedFieldBuilder = this.externalGamesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.externalGames_.get(i);
            }
            return (ExternalGameOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(i);
        }

        @Override // proto.GameOrBuilder
        public List<? extends ExternalGameOrBuilder> getExternalGamesOrBuilderList() {
            RepeatedFieldBuilder<ExternalGame, ExternalGame.Builder, ExternalGameOrBuilder> repeatedFieldBuilder = this.externalGamesBuilder_;
            if (repeatedFieldBuilder != null) {
                return repeatedFieldBuilder.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.externalGames_);
        }

        public ExternalGame.Builder addExternalGamesBuilder() {
            return (ExternalGame.Builder) getExternalGamesFieldBuilder().addBuilder(ExternalGame.getDefaultInstance());
        }

        public ExternalGame.Builder addExternalGamesBuilder(int i) {
            return (ExternalGame.Builder) getExternalGamesFieldBuilder().addBuilder(i, ExternalGame.getDefaultInstance());
        }

        public List<ExternalGame.Builder> getExternalGamesBuilderList() {
            return getExternalGamesFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilder<ExternalGame, ExternalGame.Builder, ExternalGameOrBuilder> getExternalGamesFieldBuilder() {
            if (this.externalGamesBuilder_ == null) {
                this.externalGamesBuilder_ = new RepeatedFieldBuilder<>(this.externalGames_, (this.bitField0_ & 8192) != 0, getParentForChildren(), isClean());
                this.externalGames_ = null;
            }
            return this.externalGamesBuilder_;
        }

        @Override // proto.GameOrBuilder
        public boolean hasFirstReleaseDate() {
            return (this.bitField0_ & 16384) != 0;
        }

        @Override // proto.GameOrBuilder
        public Timestamp getFirstReleaseDate() {
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.firstReleaseDateBuilder_;
            if (singleFieldBuilder == null) {
                Timestamp timestamp = this.firstReleaseDate_;
                return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
            }
            return (Timestamp) singleFieldBuilder.getMessage();
        }

        public Builder setFirstReleaseDate(Timestamp timestamp) {
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.firstReleaseDateBuilder_;
            if (singleFieldBuilder == null) {
                timestamp.getClass();
                this.firstReleaseDate_ = timestamp;
            } else {
                singleFieldBuilder.setMessage(timestamp);
            }
            this.bitField0_ |= 16384;
            onChanged();
            return this;
        }

        public Builder setFirstReleaseDate(Timestamp.Builder builder) {
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.firstReleaseDateBuilder_;
            if (singleFieldBuilder == null) {
                this.firstReleaseDate_ = builder.build();
            } else {
                singleFieldBuilder.setMessage(builder.build());
            }
            this.bitField0_ |= 16384;
            onChanged();
            return this;
        }

        public Builder mergeFirstReleaseDate(Timestamp timestamp) {
            Timestamp timestamp2;
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.firstReleaseDateBuilder_;
            if (singleFieldBuilder == null) {
                if ((this.bitField0_ & 16384) != 0 && (timestamp2 = this.firstReleaseDate_) != null && timestamp2 != Timestamp.getDefaultInstance()) {
                    getFirstReleaseDateBuilder().mergeFrom(timestamp);
                } else {
                    this.firstReleaseDate_ = timestamp;
                }
            } else {
                singleFieldBuilder.mergeFrom(timestamp);
            }
            if (this.firstReleaseDate_ != null) {
                this.bitField0_ |= 16384;
                onChanged();
            }
            return this;
        }

        public Builder clearFirstReleaseDate() {
            this.bitField0_ &= -16385;
            this.firstReleaseDate_ = null;
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.firstReleaseDateBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.firstReleaseDateBuilder_ = null;
            }
            onChanged();
            return this;
        }

        public Timestamp.Builder getFirstReleaseDateBuilder() {
            this.bitField0_ |= 16384;
            onChanged();
            return (Timestamp.Builder) getFirstReleaseDateFieldBuilder().getBuilder();
        }

        @Override // proto.GameOrBuilder
        public TimestampOrBuilder getFirstReleaseDateOrBuilder() {
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.firstReleaseDateBuilder_;
            if (singleFieldBuilder != null) {
                return (TimestampOrBuilder) singleFieldBuilder.getMessageOrBuilder();
            }
            Timestamp timestamp = this.firstReleaseDate_;
            return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
        }

        private SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> getFirstReleaseDateFieldBuilder() {
            if (this.firstReleaseDateBuilder_ == null) {
                this.firstReleaseDateBuilder_ = new SingleFieldBuilder<>(getFirstReleaseDate(), getParentForChildren(), isClean());
                this.firstReleaseDate_ = null;
            }
            return this.firstReleaseDateBuilder_;
        }

        @Override // proto.GameOrBuilder
        @Deprecated
        public int getFollows() {
            return this.follows_;
        }

        @Deprecated
        public Builder setFollows(int i) {
            this.follows_ = i;
            this.bitField0_ |= 32768;
            onChanged();
            return this;
        }

        @Deprecated
        public Builder clearFollows() {
            this.bitField0_ &= -32769;
            this.follows_ = 0;
            onChanged();
            return this;
        }

        @Override // proto.GameOrBuilder
        public boolean hasFranchise() {
            return (this.bitField0_ & 65536) != 0;
        }

        @Override // proto.GameOrBuilder
        public Franchise getFranchise() {
            SingleFieldBuilder<Franchise, Franchise.Builder, FranchiseOrBuilder> singleFieldBuilder = this.franchiseBuilder_;
            if (singleFieldBuilder == null) {
                Franchise franchise = this.franchise_;
                return franchise == null ? Franchise.getDefaultInstance() : franchise;
            }
            return (Franchise) singleFieldBuilder.getMessage();
        }

        public Builder setFranchise(Franchise franchise) {
            SingleFieldBuilder<Franchise, Franchise.Builder, FranchiseOrBuilder> singleFieldBuilder = this.franchiseBuilder_;
            if (singleFieldBuilder == null) {
                franchise.getClass();
                this.franchise_ = franchise;
            } else {
                singleFieldBuilder.setMessage(franchise);
            }
            this.bitField0_ |= 65536;
            onChanged();
            return this;
        }

        public Builder setFranchise(Franchise.Builder builder) {
            SingleFieldBuilder<Franchise, Franchise.Builder, FranchiseOrBuilder> singleFieldBuilder = this.franchiseBuilder_;
            if (singleFieldBuilder == null) {
                this.franchise_ = builder.build();
            } else {
                singleFieldBuilder.setMessage(builder.build());
            }
            this.bitField0_ |= 65536;
            onChanged();
            return this;
        }

        public Builder mergeFranchise(Franchise franchise) {
            Franchise franchise2;
            SingleFieldBuilder<Franchise, Franchise.Builder, FranchiseOrBuilder> singleFieldBuilder = this.franchiseBuilder_;
            if (singleFieldBuilder == null) {
                if ((this.bitField0_ & 65536) != 0 && (franchise2 = this.franchise_) != null && franchise2 != Franchise.getDefaultInstance()) {
                    getFranchiseBuilder().mergeFrom((Message) franchise);
                } else {
                    this.franchise_ = franchise;
                }
            } else {
                singleFieldBuilder.mergeFrom(franchise);
            }
            if (this.franchise_ != null) {
                this.bitField0_ |= 65536;
                onChanged();
            }
            return this;
        }

        public Builder clearFranchise() {
            this.bitField0_ &= -65537;
            this.franchise_ = null;
            SingleFieldBuilder<Franchise, Franchise.Builder, FranchiseOrBuilder> singleFieldBuilder = this.franchiseBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.franchiseBuilder_ = null;
            }
            onChanged();
            return this;
        }

        public Franchise.Builder getFranchiseBuilder() {
            this.bitField0_ |= 65536;
            onChanged();
            return (Franchise.Builder) getFranchiseFieldBuilder().getBuilder();
        }

        @Override // proto.GameOrBuilder
        public FranchiseOrBuilder getFranchiseOrBuilder() {
            SingleFieldBuilder<Franchise, Franchise.Builder, FranchiseOrBuilder> singleFieldBuilder = this.franchiseBuilder_;
            if (singleFieldBuilder != null) {
                return (FranchiseOrBuilder) singleFieldBuilder.getMessageOrBuilder();
            }
            Franchise franchise = this.franchise_;
            return franchise == null ? Franchise.getDefaultInstance() : franchise;
        }

        private SingleFieldBuilder<Franchise, Franchise.Builder, FranchiseOrBuilder> getFranchiseFieldBuilder() {
            if (this.franchiseBuilder_ == null) {
                this.franchiseBuilder_ = new SingleFieldBuilder<>(getFranchise(), getParentForChildren(), isClean());
                this.franchise_ = null;
            }
            return this.franchiseBuilder_;
        }

        private void ensureFranchisesIsMutable() {
            if ((this.bitField0_ & 131072) == 0) {
                this.franchises_ = new ArrayList(this.franchises_);
                this.bitField0_ |= 131072;
            }
        }

        @Override // proto.GameOrBuilder
        public List<Franchise> getFranchisesList() {
            RepeatedFieldBuilder<Franchise, Franchise.Builder, FranchiseOrBuilder> repeatedFieldBuilder = this.franchisesBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.franchises_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // proto.GameOrBuilder
        public int getFranchisesCount() {
            RepeatedFieldBuilder<Franchise, Franchise.Builder, FranchiseOrBuilder> repeatedFieldBuilder = this.franchisesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.franchises_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // proto.GameOrBuilder
        public Franchise getFranchises(int i) {
            RepeatedFieldBuilder<Franchise, Franchise.Builder, FranchiseOrBuilder> repeatedFieldBuilder = this.franchisesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.franchises_.get(i);
            }
            return (Franchise) repeatedFieldBuilder.getMessage(i);
        }

        public Builder setFranchises(int i, Franchise franchise) {
            RepeatedFieldBuilder<Franchise, Franchise.Builder, FranchiseOrBuilder> repeatedFieldBuilder = this.franchisesBuilder_;
            if (repeatedFieldBuilder == null) {
                franchise.getClass();
                ensureFranchisesIsMutable();
                this.franchises_.set(i, franchise);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, franchise);
            return this;
        }

        public Builder setFranchises(int i, Franchise.Builder builder) {
            RepeatedFieldBuilder<Franchise, Franchise.Builder, FranchiseOrBuilder> repeatedFieldBuilder = this.franchisesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureFranchisesIsMutable();
                this.franchises_.set(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, builder.build());
            return this;
        }

        public Builder addFranchises(Franchise franchise) {
            RepeatedFieldBuilder<Franchise, Franchise.Builder, FranchiseOrBuilder> repeatedFieldBuilder = this.franchisesBuilder_;
            if (repeatedFieldBuilder == null) {
                franchise.getClass();
                ensureFranchisesIsMutable();
                this.franchises_.add(franchise);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(franchise);
            return this;
        }

        public Builder addFranchises(int i, Franchise franchise) {
            RepeatedFieldBuilder<Franchise, Franchise.Builder, FranchiseOrBuilder> repeatedFieldBuilder = this.franchisesBuilder_;
            if (repeatedFieldBuilder == null) {
                franchise.getClass();
                ensureFranchisesIsMutable();
                this.franchises_.add(i, franchise);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, franchise);
            return this;
        }

        public Builder addFranchises(Franchise.Builder builder) {
            RepeatedFieldBuilder<Franchise, Franchise.Builder, FranchiseOrBuilder> repeatedFieldBuilder = this.franchisesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureFranchisesIsMutable();
                this.franchises_.add(builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(builder.build());
            return this;
        }

        public Builder addFranchises(int i, Franchise.Builder builder) {
            RepeatedFieldBuilder<Franchise, Franchise.Builder, FranchiseOrBuilder> repeatedFieldBuilder = this.franchisesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureFranchisesIsMutable();
                this.franchises_.add(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, builder.build());
            return this;
        }

        public Builder addAllFranchises(Iterable<? extends Franchise> iterable) {
            RepeatedFieldBuilder<Franchise, Franchise.Builder, FranchiseOrBuilder> repeatedFieldBuilder = this.franchisesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureFranchisesIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.franchises_);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addAllMessages(iterable);
            return this;
        }

        public Builder clearFranchises() {
            RepeatedFieldBuilder<Franchise, Franchise.Builder, FranchiseOrBuilder> repeatedFieldBuilder = this.franchisesBuilder_;
            if (repeatedFieldBuilder == null) {
                this.franchises_ = Collections.emptyList();
                this.bitField0_ &= -131073;
                onChanged();
                return this;
            }
            repeatedFieldBuilder.clear();
            return this;
        }

        public Builder removeFranchises(int i) {
            RepeatedFieldBuilder<Franchise, Franchise.Builder, FranchiseOrBuilder> repeatedFieldBuilder = this.franchisesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureFranchisesIsMutable();
                this.franchises_.remove(i);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.remove(i);
            return this;
        }

        public Franchise.Builder getFranchisesBuilder(int i) {
            return (Franchise.Builder) getFranchisesFieldBuilder().getBuilder(i);
        }

        @Override // proto.GameOrBuilder
        public FranchiseOrBuilder getFranchisesOrBuilder(int i) {
            RepeatedFieldBuilder<Franchise, Franchise.Builder, FranchiseOrBuilder> repeatedFieldBuilder = this.franchisesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.franchises_.get(i);
            }
            return (FranchiseOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(i);
        }

        @Override // proto.GameOrBuilder
        public List<? extends FranchiseOrBuilder> getFranchisesOrBuilderList() {
            RepeatedFieldBuilder<Franchise, Franchise.Builder, FranchiseOrBuilder> repeatedFieldBuilder = this.franchisesBuilder_;
            if (repeatedFieldBuilder != null) {
                return repeatedFieldBuilder.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.franchises_);
        }

        public Franchise.Builder addFranchisesBuilder() {
            return (Franchise.Builder) getFranchisesFieldBuilder().addBuilder(Franchise.getDefaultInstance());
        }

        public Franchise.Builder addFranchisesBuilder(int i) {
            return (Franchise.Builder) getFranchisesFieldBuilder().addBuilder(i, Franchise.getDefaultInstance());
        }

        public List<Franchise.Builder> getFranchisesBuilderList() {
            return getFranchisesFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilder<Franchise, Franchise.Builder, FranchiseOrBuilder> getFranchisesFieldBuilder() {
            if (this.franchisesBuilder_ == null) {
                this.franchisesBuilder_ = new RepeatedFieldBuilder<>(this.franchises_, (this.bitField0_ & 131072) != 0, getParentForChildren(), isClean());
                this.franchises_ = null;
            }
            return this.franchisesBuilder_;
        }

        private void ensureGameEnginesIsMutable() {
            if ((this.bitField0_ & 262144) == 0) {
                this.gameEngines_ = new ArrayList(this.gameEngines_);
                this.bitField0_ |= 262144;
            }
        }

        @Override // proto.GameOrBuilder
        public List<GameEngine> getGameEnginesList() {
            RepeatedFieldBuilder<GameEngine, GameEngine.Builder, GameEngineOrBuilder> repeatedFieldBuilder = this.gameEnginesBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.gameEngines_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // proto.GameOrBuilder
        public int getGameEnginesCount() {
            RepeatedFieldBuilder<GameEngine, GameEngine.Builder, GameEngineOrBuilder> repeatedFieldBuilder = this.gameEnginesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.gameEngines_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // proto.GameOrBuilder
        public GameEngine getGameEngines(int i) {
            RepeatedFieldBuilder<GameEngine, GameEngine.Builder, GameEngineOrBuilder> repeatedFieldBuilder = this.gameEnginesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.gameEngines_.get(i);
            }
            return (GameEngine) repeatedFieldBuilder.getMessage(i);
        }

        public Builder setGameEngines(int i, GameEngine gameEngine) {
            RepeatedFieldBuilder<GameEngine, GameEngine.Builder, GameEngineOrBuilder> repeatedFieldBuilder = this.gameEnginesBuilder_;
            if (repeatedFieldBuilder == null) {
                gameEngine.getClass();
                ensureGameEnginesIsMutable();
                this.gameEngines_.set(i, gameEngine);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, gameEngine);
            return this;
        }

        public Builder setGameEngines(int i, GameEngine.Builder builder) {
            RepeatedFieldBuilder<GameEngine, GameEngine.Builder, GameEngineOrBuilder> repeatedFieldBuilder = this.gameEnginesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureGameEnginesIsMutable();
                this.gameEngines_.set(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, builder.build());
            return this;
        }

        public Builder addGameEngines(GameEngine gameEngine) {
            RepeatedFieldBuilder<GameEngine, GameEngine.Builder, GameEngineOrBuilder> repeatedFieldBuilder = this.gameEnginesBuilder_;
            if (repeatedFieldBuilder == null) {
                gameEngine.getClass();
                ensureGameEnginesIsMutable();
                this.gameEngines_.add(gameEngine);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(gameEngine);
            return this;
        }

        public Builder addGameEngines(int i, GameEngine gameEngine) {
            RepeatedFieldBuilder<GameEngine, GameEngine.Builder, GameEngineOrBuilder> repeatedFieldBuilder = this.gameEnginesBuilder_;
            if (repeatedFieldBuilder == null) {
                gameEngine.getClass();
                ensureGameEnginesIsMutable();
                this.gameEngines_.add(i, gameEngine);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, gameEngine);
            return this;
        }

        public Builder addGameEngines(GameEngine.Builder builder) {
            RepeatedFieldBuilder<GameEngine, GameEngine.Builder, GameEngineOrBuilder> repeatedFieldBuilder = this.gameEnginesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureGameEnginesIsMutable();
                this.gameEngines_.add(builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(builder.build());
            return this;
        }

        public Builder addGameEngines(int i, GameEngine.Builder builder) {
            RepeatedFieldBuilder<GameEngine, GameEngine.Builder, GameEngineOrBuilder> repeatedFieldBuilder = this.gameEnginesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureGameEnginesIsMutable();
                this.gameEngines_.add(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, builder.build());
            return this;
        }

        public Builder addAllGameEngines(Iterable<? extends GameEngine> iterable) {
            RepeatedFieldBuilder<GameEngine, GameEngine.Builder, GameEngineOrBuilder> repeatedFieldBuilder = this.gameEnginesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureGameEnginesIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.gameEngines_);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addAllMessages(iterable);
            return this;
        }

        public Builder clearGameEngines() {
            RepeatedFieldBuilder<GameEngine, GameEngine.Builder, GameEngineOrBuilder> repeatedFieldBuilder = this.gameEnginesBuilder_;
            if (repeatedFieldBuilder == null) {
                this.gameEngines_ = Collections.emptyList();
                this.bitField0_ &= -262145;
                onChanged();
                return this;
            }
            repeatedFieldBuilder.clear();
            return this;
        }

        public Builder removeGameEngines(int i) {
            RepeatedFieldBuilder<GameEngine, GameEngine.Builder, GameEngineOrBuilder> repeatedFieldBuilder = this.gameEnginesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureGameEnginesIsMutable();
                this.gameEngines_.remove(i);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.remove(i);
            return this;
        }

        public GameEngine.Builder getGameEnginesBuilder(int i) {
            return (GameEngine.Builder) getGameEnginesFieldBuilder().getBuilder(i);
        }

        @Override // proto.GameOrBuilder
        public GameEngineOrBuilder getGameEnginesOrBuilder(int i) {
            RepeatedFieldBuilder<GameEngine, GameEngine.Builder, GameEngineOrBuilder> repeatedFieldBuilder = this.gameEnginesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.gameEngines_.get(i);
            }
            return (GameEngineOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(i);
        }

        @Override // proto.GameOrBuilder
        public List<? extends GameEngineOrBuilder> getGameEnginesOrBuilderList() {
            RepeatedFieldBuilder<GameEngine, GameEngine.Builder, GameEngineOrBuilder> repeatedFieldBuilder = this.gameEnginesBuilder_;
            if (repeatedFieldBuilder != null) {
                return repeatedFieldBuilder.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.gameEngines_);
        }

        public GameEngine.Builder addGameEnginesBuilder() {
            return (GameEngine.Builder) getGameEnginesFieldBuilder().addBuilder(GameEngine.getDefaultInstance());
        }

        public GameEngine.Builder addGameEnginesBuilder(int i) {
            return (GameEngine.Builder) getGameEnginesFieldBuilder().addBuilder(i, GameEngine.getDefaultInstance());
        }

        public List<GameEngine.Builder> getGameEnginesBuilderList() {
            return getGameEnginesFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilder<GameEngine, GameEngine.Builder, GameEngineOrBuilder> getGameEnginesFieldBuilder() {
            if (this.gameEnginesBuilder_ == null) {
                this.gameEnginesBuilder_ = new RepeatedFieldBuilder<>(this.gameEngines_, (this.bitField0_ & 262144) != 0, getParentForChildren(), isClean());
                this.gameEngines_ = null;
            }
            return this.gameEnginesBuilder_;
        }

        private void ensureGameModesIsMutable() {
            if ((this.bitField0_ & 524288) == 0) {
                this.gameModes_ = new ArrayList(this.gameModes_);
                this.bitField0_ |= 524288;
            }
        }

        @Override // proto.GameOrBuilder
        public List<GameMode> getGameModesList() {
            RepeatedFieldBuilder<GameMode, GameMode.Builder, GameModeOrBuilder> repeatedFieldBuilder = this.gameModesBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.gameModes_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // proto.GameOrBuilder
        public int getGameModesCount() {
            RepeatedFieldBuilder<GameMode, GameMode.Builder, GameModeOrBuilder> repeatedFieldBuilder = this.gameModesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.gameModes_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // proto.GameOrBuilder
        public GameMode getGameModes(int i) {
            RepeatedFieldBuilder<GameMode, GameMode.Builder, GameModeOrBuilder> repeatedFieldBuilder = this.gameModesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.gameModes_.get(i);
            }
            return (GameMode) repeatedFieldBuilder.getMessage(i);
        }

        public Builder setGameModes(int i, GameMode gameMode) {
            RepeatedFieldBuilder<GameMode, GameMode.Builder, GameModeOrBuilder> repeatedFieldBuilder = this.gameModesBuilder_;
            if (repeatedFieldBuilder == null) {
                gameMode.getClass();
                ensureGameModesIsMutable();
                this.gameModes_.set(i, gameMode);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, gameMode);
            return this;
        }

        public Builder setGameModes(int i, GameMode.Builder builder) {
            RepeatedFieldBuilder<GameMode, GameMode.Builder, GameModeOrBuilder> repeatedFieldBuilder = this.gameModesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureGameModesIsMutable();
                this.gameModes_.set(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, builder.build());
            return this;
        }

        public Builder addGameModes(GameMode gameMode) {
            RepeatedFieldBuilder<GameMode, GameMode.Builder, GameModeOrBuilder> repeatedFieldBuilder = this.gameModesBuilder_;
            if (repeatedFieldBuilder == null) {
                gameMode.getClass();
                ensureGameModesIsMutable();
                this.gameModes_.add(gameMode);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(gameMode);
            return this;
        }

        public Builder addGameModes(int i, GameMode gameMode) {
            RepeatedFieldBuilder<GameMode, GameMode.Builder, GameModeOrBuilder> repeatedFieldBuilder = this.gameModesBuilder_;
            if (repeatedFieldBuilder == null) {
                gameMode.getClass();
                ensureGameModesIsMutable();
                this.gameModes_.add(i, gameMode);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, gameMode);
            return this;
        }

        public Builder addGameModes(GameMode.Builder builder) {
            RepeatedFieldBuilder<GameMode, GameMode.Builder, GameModeOrBuilder> repeatedFieldBuilder = this.gameModesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureGameModesIsMutable();
                this.gameModes_.add(builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(builder.build());
            return this;
        }

        public Builder addGameModes(int i, GameMode.Builder builder) {
            RepeatedFieldBuilder<GameMode, GameMode.Builder, GameModeOrBuilder> repeatedFieldBuilder = this.gameModesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureGameModesIsMutable();
                this.gameModes_.add(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, builder.build());
            return this;
        }

        public Builder addAllGameModes(Iterable<? extends GameMode> iterable) {
            RepeatedFieldBuilder<GameMode, GameMode.Builder, GameModeOrBuilder> repeatedFieldBuilder = this.gameModesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureGameModesIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.gameModes_);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addAllMessages(iterable);
            return this;
        }

        public Builder clearGameModes() {
            RepeatedFieldBuilder<GameMode, GameMode.Builder, GameModeOrBuilder> repeatedFieldBuilder = this.gameModesBuilder_;
            if (repeatedFieldBuilder == null) {
                this.gameModes_ = Collections.emptyList();
                this.bitField0_ &= -524289;
                onChanged();
                return this;
            }
            repeatedFieldBuilder.clear();
            return this;
        }

        public Builder removeGameModes(int i) {
            RepeatedFieldBuilder<GameMode, GameMode.Builder, GameModeOrBuilder> repeatedFieldBuilder = this.gameModesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureGameModesIsMutable();
                this.gameModes_.remove(i);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.remove(i);
            return this;
        }

        public GameMode.Builder getGameModesBuilder(int i) {
            return (GameMode.Builder) getGameModesFieldBuilder().getBuilder(i);
        }

        @Override // proto.GameOrBuilder
        public GameModeOrBuilder getGameModesOrBuilder(int i) {
            RepeatedFieldBuilder<GameMode, GameMode.Builder, GameModeOrBuilder> repeatedFieldBuilder = this.gameModesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.gameModes_.get(i);
            }
            return (GameModeOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(i);
        }

        @Override // proto.GameOrBuilder
        public List<? extends GameModeOrBuilder> getGameModesOrBuilderList() {
            RepeatedFieldBuilder<GameMode, GameMode.Builder, GameModeOrBuilder> repeatedFieldBuilder = this.gameModesBuilder_;
            if (repeatedFieldBuilder != null) {
                return repeatedFieldBuilder.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.gameModes_);
        }

        public GameMode.Builder addGameModesBuilder() {
            return (GameMode.Builder) getGameModesFieldBuilder().addBuilder(GameMode.getDefaultInstance());
        }

        public GameMode.Builder addGameModesBuilder(int i) {
            return (GameMode.Builder) getGameModesFieldBuilder().addBuilder(i, GameMode.getDefaultInstance());
        }

        public List<GameMode.Builder> getGameModesBuilderList() {
            return getGameModesFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilder<GameMode, GameMode.Builder, GameModeOrBuilder> getGameModesFieldBuilder() {
            if (this.gameModesBuilder_ == null) {
                this.gameModesBuilder_ = new RepeatedFieldBuilder<>(this.gameModes_, (this.bitField0_ & 524288) != 0, getParentForChildren(), isClean());
                this.gameModes_ = null;
            }
            return this.gameModesBuilder_;
        }

        private void ensureGenresIsMutable() {
            if ((this.bitField0_ & 1048576) == 0) {
                this.genres_ = new ArrayList(this.genres_);
                this.bitField0_ |= 1048576;
            }
        }

        @Override // proto.GameOrBuilder
        public List<Genre> getGenresList() {
            RepeatedFieldBuilder<Genre, Genre.Builder, GenreOrBuilder> repeatedFieldBuilder = this.genresBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.genres_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // proto.GameOrBuilder
        public int getGenresCount() {
            RepeatedFieldBuilder<Genre, Genre.Builder, GenreOrBuilder> repeatedFieldBuilder = this.genresBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.genres_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // proto.GameOrBuilder
        public Genre getGenres(int i) {
            RepeatedFieldBuilder<Genre, Genre.Builder, GenreOrBuilder> repeatedFieldBuilder = this.genresBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.genres_.get(i);
            }
            return (Genre) repeatedFieldBuilder.getMessage(i);
        }

        public Builder setGenres(int i, Genre genre) {
            RepeatedFieldBuilder<Genre, Genre.Builder, GenreOrBuilder> repeatedFieldBuilder = this.genresBuilder_;
            if (repeatedFieldBuilder == null) {
                genre.getClass();
                ensureGenresIsMutable();
                this.genres_.set(i, genre);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, genre);
            return this;
        }

        public Builder setGenres(int i, Genre.Builder builder) {
            RepeatedFieldBuilder<Genre, Genre.Builder, GenreOrBuilder> repeatedFieldBuilder = this.genresBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureGenresIsMutable();
                this.genres_.set(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, builder.build());
            return this;
        }

        public Builder addGenres(Genre genre) {
            RepeatedFieldBuilder<Genre, Genre.Builder, GenreOrBuilder> repeatedFieldBuilder = this.genresBuilder_;
            if (repeatedFieldBuilder == null) {
                genre.getClass();
                ensureGenresIsMutable();
                this.genres_.add(genre);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(genre);
            return this;
        }

        public Builder addGenres(int i, Genre genre) {
            RepeatedFieldBuilder<Genre, Genre.Builder, GenreOrBuilder> repeatedFieldBuilder = this.genresBuilder_;
            if (repeatedFieldBuilder == null) {
                genre.getClass();
                ensureGenresIsMutable();
                this.genres_.add(i, genre);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, genre);
            return this;
        }

        public Builder addGenres(Genre.Builder builder) {
            RepeatedFieldBuilder<Genre, Genre.Builder, GenreOrBuilder> repeatedFieldBuilder = this.genresBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureGenresIsMutable();
                this.genres_.add(builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(builder.build());
            return this;
        }

        public Builder addGenres(int i, Genre.Builder builder) {
            RepeatedFieldBuilder<Genre, Genre.Builder, GenreOrBuilder> repeatedFieldBuilder = this.genresBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureGenresIsMutable();
                this.genres_.add(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, builder.build());
            return this;
        }

        public Builder addAllGenres(Iterable<? extends Genre> iterable) {
            RepeatedFieldBuilder<Genre, Genre.Builder, GenreOrBuilder> repeatedFieldBuilder = this.genresBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureGenresIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.genres_);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addAllMessages(iterable);
            return this;
        }

        public Builder clearGenres() {
            RepeatedFieldBuilder<Genre, Genre.Builder, GenreOrBuilder> repeatedFieldBuilder = this.genresBuilder_;
            if (repeatedFieldBuilder == null) {
                this.genres_ = Collections.emptyList();
                this.bitField0_ &= -1048577;
                onChanged();
                return this;
            }
            repeatedFieldBuilder.clear();
            return this;
        }

        public Builder removeGenres(int i) {
            RepeatedFieldBuilder<Genre, Genre.Builder, GenreOrBuilder> repeatedFieldBuilder = this.genresBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureGenresIsMutable();
                this.genres_.remove(i);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.remove(i);
            return this;
        }

        public Genre.Builder getGenresBuilder(int i) {
            return (Genre.Builder) getGenresFieldBuilder().getBuilder(i);
        }

        @Override // proto.GameOrBuilder
        public GenreOrBuilder getGenresOrBuilder(int i) {
            RepeatedFieldBuilder<Genre, Genre.Builder, GenreOrBuilder> repeatedFieldBuilder = this.genresBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.genres_.get(i);
            }
            return (GenreOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(i);
        }

        @Override // proto.GameOrBuilder
        public List<? extends GenreOrBuilder> getGenresOrBuilderList() {
            RepeatedFieldBuilder<Genre, Genre.Builder, GenreOrBuilder> repeatedFieldBuilder = this.genresBuilder_;
            if (repeatedFieldBuilder != null) {
                return repeatedFieldBuilder.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.genres_);
        }

        public Genre.Builder addGenresBuilder() {
            return (Genre.Builder) getGenresFieldBuilder().addBuilder(Genre.getDefaultInstance());
        }

        public Genre.Builder addGenresBuilder(int i) {
            return (Genre.Builder) getGenresFieldBuilder().addBuilder(i, Genre.getDefaultInstance());
        }

        public List<Genre.Builder> getGenresBuilderList() {
            return getGenresFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilder<Genre, Genre.Builder, GenreOrBuilder> getGenresFieldBuilder() {
            if (this.genresBuilder_ == null) {
                this.genresBuilder_ = new RepeatedFieldBuilder<>(this.genres_, (this.bitField0_ & 1048576) != 0, getParentForChildren(), isClean());
                this.genres_ = null;
            }
            return this.genresBuilder_;
        }

        @Override // proto.GameOrBuilder
        public int getHypes() {
            return this.hypes_;
        }

        public Builder setHypes(int i) {
            this.hypes_ = i;
            this.bitField0_ |= 2097152;
            onChanged();
            return this;
        }

        public Builder clearHypes() {
            this.bitField0_ &= -2097153;
            this.hypes_ = 0;
            onChanged();
            return this;
        }

        private void ensureInvolvedCompaniesIsMutable() {
            if ((this.bitField0_ & 4194304) == 0) {
                this.involvedCompanies_ = new ArrayList(this.involvedCompanies_);
                this.bitField0_ |= 4194304;
            }
        }

        @Override // proto.GameOrBuilder
        public List<InvolvedCompany> getInvolvedCompaniesList() {
            RepeatedFieldBuilder<InvolvedCompany, InvolvedCompany.Builder, InvolvedCompanyOrBuilder> repeatedFieldBuilder = this.involvedCompaniesBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.involvedCompanies_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // proto.GameOrBuilder
        public int getInvolvedCompaniesCount() {
            RepeatedFieldBuilder<InvolvedCompany, InvolvedCompany.Builder, InvolvedCompanyOrBuilder> repeatedFieldBuilder = this.involvedCompaniesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.involvedCompanies_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // proto.GameOrBuilder
        public InvolvedCompany getInvolvedCompanies(int i) {
            RepeatedFieldBuilder<InvolvedCompany, InvolvedCompany.Builder, InvolvedCompanyOrBuilder> repeatedFieldBuilder = this.involvedCompaniesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.involvedCompanies_.get(i);
            }
            return (InvolvedCompany) repeatedFieldBuilder.getMessage(i);
        }

        public Builder setInvolvedCompanies(int i, InvolvedCompany involvedCompany) {
            RepeatedFieldBuilder<InvolvedCompany, InvolvedCompany.Builder, InvolvedCompanyOrBuilder> repeatedFieldBuilder = this.involvedCompaniesBuilder_;
            if (repeatedFieldBuilder == null) {
                involvedCompany.getClass();
                ensureInvolvedCompaniesIsMutable();
                this.involvedCompanies_.set(i, involvedCompany);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, involvedCompany);
            return this;
        }

        public Builder setInvolvedCompanies(int i, InvolvedCompany.Builder builder) {
            RepeatedFieldBuilder<InvolvedCompany, InvolvedCompany.Builder, InvolvedCompanyOrBuilder> repeatedFieldBuilder = this.involvedCompaniesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureInvolvedCompaniesIsMutable();
                this.involvedCompanies_.set(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, builder.build());
            return this;
        }

        public Builder addInvolvedCompanies(InvolvedCompany involvedCompany) {
            RepeatedFieldBuilder<InvolvedCompany, InvolvedCompany.Builder, InvolvedCompanyOrBuilder> repeatedFieldBuilder = this.involvedCompaniesBuilder_;
            if (repeatedFieldBuilder == null) {
                involvedCompany.getClass();
                ensureInvolvedCompaniesIsMutable();
                this.involvedCompanies_.add(involvedCompany);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(involvedCompany);
            return this;
        }

        public Builder addInvolvedCompanies(int i, InvolvedCompany involvedCompany) {
            RepeatedFieldBuilder<InvolvedCompany, InvolvedCompany.Builder, InvolvedCompanyOrBuilder> repeatedFieldBuilder = this.involvedCompaniesBuilder_;
            if (repeatedFieldBuilder == null) {
                involvedCompany.getClass();
                ensureInvolvedCompaniesIsMutable();
                this.involvedCompanies_.add(i, involvedCompany);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, involvedCompany);
            return this;
        }

        public Builder addInvolvedCompanies(InvolvedCompany.Builder builder) {
            RepeatedFieldBuilder<InvolvedCompany, InvolvedCompany.Builder, InvolvedCompanyOrBuilder> repeatedFieldBuilder = this.involvedCompaniesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureInvolvedCompaniesIsMutable();
                this.involvedCompanies_.add(builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(builder.build());
            return this;
        }

        public Builder addInvolvedCompanies(int i, InvolvedCompany.Builder builder) {
            RepeatedFieldBuilder<InvolvedCompany, InvolvedCompany.Builder, InvolvedCompanyOrBuilder> repeatedFieldBuilder = this.involvedCompaniesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureInvolvedCompaniesIsMutable();
                this.involvedCompanies_.add(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, builder.build());
            return this;
        }

        public Builder addAllInvolvedCompanies(Iterable<? extends InvolvedCompany> iterable) {
            RepeatedFieldBuilder<InvolvedCompany, InvolvedCompany.Builder, InvolvedCompanyOrBuilder> repeatedFieldBuilder = this.involvedCompaniesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureInvolvedCompaniesIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.involvedCompanies_);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addAllMessages(iterable);
            return this;
        }

        public Builder clearInvolvedCompanies() {
            RepeatedFieldBuilder<InvolvedCompany, InvolvedCompany.Builder, InvolvedCompanyOrBuilder> repeatedFieldBuilder = this.involvedCompaniesBuilder_;
            if (repeatedFieldBuilder == null) {
                this.involvedCompanies_ = Collections.emptyList();
                this.bitField0_ &= -4194305;
                onChanged();
                return this;
            }
            repeatedFieldBuilder.clear();
            return this;
        }

        public Builder removeInvolvedCompanies(int i) {
            RepeatedFieldBuilder<InvolvedCompany, InvolvedCompany.Builder, InvolvedCompanyOrBuilder> repeatedFieldBuilder = this.involvedCompaniesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureInvolvedCompaniesIsMutable();
                this.involvedCompanies_.remove(i);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.remove(i);
            return this;
        }

        public InvolvedCompany.Builder getInvolvedCompaniesBuilder(int i) {
            return (InvolvedCompany.Builder) getInvolvedCompaniesFieldBuilder().getBuilder(i);
        }

        @Override // proto.GameOrBuilder
        public InvolvedCompanyOrBuilder getInvolvedCompaniesOrBuilder(int i) {
            RepeatedFieldBuilder<InvolvedCompany, InvolvedCompany.Builder, InvolvedCompanyOrBuilder> repeatedFieldBuilder = this.involvedCompaniesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.involvedCompanies_.get(i);
            }
            return (InvolvedCompanyOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(i);
        }

        @Override // proto.GameOrBuilder
        public List<? extends InvolvedCompanyOrBuilder> getInvolvedCompaniesOrBuilderList() {
            RepeatedFieldBuilder<InvolvedCompany, InvolvedCompany.Builder, InvolvedCompanyOrBuilder> repeatedFieldBuilder = this.involvedCompaniesBuilder_;
            if (repeatedFieldBuilder != null) {
                return repeatedFieldBuilder.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.involvedCompanies_);
        }

        public InvolvedCompany.Builder addInvolvedCompaniesBuilder() {
            return (InvolvedCompany.Builder) getInvolvedCompaniesFieldBuilder().addBuilder(InvolvedCompany.getDefaultInstance());
        }

        public InvolvedCompany.Builder addInvolvedCompaniesBuilder(int i) {
            return (InvolvedCompany.Builder) getInvolvedCompaniesFieldBuilder().addBuilder(i, InvolvedCompany.getDefaultInstance());
        }

        public List<InvolvedCompany.Builder> getInvolvedCompaniesBuilderList() {
            return getInvolvedCompaniesFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilder<InvolvedCompany, InvolvedCompany.Builder, InvolvedCompanyOrBuilder> getInvolvedCompaniesFieldBuilder() {
            if (this.involvedCompaniesBuilder_ == null) {
                this.involvedCompaniesBuilder_ = new RepeatedFieldBuilder<>(this.involvedCompanies_, (this.bitField0_ & 4194304) != 0, getParentForChildren(), isClean());
                this.involvedCompanies_ = null;
            }
            return this.involvedCompaniesBuilder_;
        }

        private void ensureKeywordsIsMutable() {
            if ((this.bitField0_ & 8388608) == 0) {
                this.keywords_ = new ArrayList(this.keywords_);
                this.bitField0_ |= 8388608;
            }
        }

        @Override // proto.GameOrBuilder
        public List<Keyword> getKeywordsList() {
            RepeatedFieldBuilder<Keyword, Keyword.Builder, KeywordOrBuilder> repeatedFieldBuilder = this.keywordsBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.keywords_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // proto.GameOrBuilder
        public int getKeywordsCount() {
            RepeatedFieldBuilder<Keyword, Keyword.Builder, KeywordOrBuilder> repeatedFieldBuilder = this.keywordsBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.keywords_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // proto.GameOrBuilder
        public Keyword getKeywords(int i) {
            RepeatedFieldBuilder<Keyword, Keyword.Builder, KeywordOrBuilder> repeatedFieldBuilder = this.keywordsBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.keywords_.get(i);
            }
            return (Keyword) repeatedFieldBuilder.getMessage(i);
        }

        public Builder setKeywords(int i, Keyword keyword) {
            RepeatedFieldBuilder<Keyword, Keyword.Builder, KeywordOrBuilder> repeatedFieldBuilder = this.keywordsBuilder_;
            if (repeatedFieldBuilder == null) {
                keyword.getClass();
                ensureKeywordsIsMutable();
                this.keywords_.set(i, keyword);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, keyword);
            return this;
        }

        public Builder setKeywords(int i, Keyword.Builder builder) {
            RepeatedFieldBuilder<Keyword, Keyword.Builder, KeywordOrBuilder> repeatedFieldBuilder = this.keywordsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureKeywordsIsMutable();
                this.keywords_.set(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, builder.build());
            return this;
        }

        public Builder addKeywords(Keyword keyword) {
            RepeatedFieldBuilder<Keyword, Keyword.Builder, KeywordOrBuilder> repeatedFieldBuilder = this.keywordsBuilder_;
            if (repeatedFieldBuilder == null) {
                keyword.getClass();
                ensureKeywordsIsMutable();
                this.keywords_.add(keyword);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(keyword);
            return this;
        }

        public Builder addKeywords(int i, Keyword keyword) {
            RepeatedFieldBuilder<Keyword, Keyword.Builder, KeywordOrBuilder> repeatedFieldBuilder = this.keywordsBuilder_;
            if (repeatedFieldBuilder == null) {
                keyword.getClass();
                ensureKeywordsIsMutable();
                this.keywords_.add(i, keyword);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, keyword);
            return this;
        }

        public Builder addKeywords(Keyword.Builder builder) {
            RepeatedFieldBuilder<Keyword, Keyword.Builder, KeywordOrBuilder> repeatedFieldBuilder = this.keywordsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureKeywordsIsMutable();
                this.keywords_.add(builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(builder.build());
            return this;
        }

        public Builder addKeywords(int i, Keyword.Builder builder) {
            RepeatedFieldBuilder<Keyword, Keyword.Builder, KeywordOrBuilder> repeatedFieldBuilder = this.keywordsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureKeywordsIsMutable();
                this.keywords_.add(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, builder.build());
            return this;
        }

        public Builder addAllKeywords(Iterable<? extends Keyword> iterable) {
            RepeatedFieldBuilder<Keyword, Keyword.Builder, KeywordOrBuilder> repeatedFieldBuilder = this.keywordsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureKeywordsIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.keywords_);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addAllMessages(iterable);
            return this;
        }

        public Builder clearKeywords() {
            RepeatedFieldBuilder<Keyword, Keyword.Builder, KeywordOrBuilder> repeatedFieldBuilder = this.keywordsBuilder_;
            if (repeatedFieldBuilder == null) {
                this.keywords_ = Collections.emptyList();
                this.bitField0_ &= -8388609;
                onChanged();
                return this;
            }
            repeatedFieldBuilder.clear();
            return this;
        }

        public Builder removeKeywords(int i) {
            RepeatedFieldBuilder<Keyword, Keyword.Builder, KeywordOrBuilder> repeatedFieldBuilder = this.keywordsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureKeywordsIsMutable();
                this.keywords_.remove(i);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.remove(i);
            return this;
        }

        public Keyword.Builder getKeywordsBuilder(int i) {
            return (Keyword.Builder) getKeywordsFieldBuilder().getBuilder(i);
        }

        @Override // proto.GameOrBuilder
        public KeywordOrBuilder getKeywordsOrBuilder(int i) {
            RepeatedFieldBuilder<Keyword, Keyword.Builder, KeywordOrBuilder> repeatedFieldBuilder = this.keywordsBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.keywords_.get(i);
            }
            return (KeywordOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(i);
        }

        @Override // proto.GameOrBuilder
        public List<? extends KeywordOrBuilder> getKeywordsOrBuilderList() {
            RepeatedFieldBuilder<Keyword, Keyword.Builder, KeywordOrBuilder> repeatedFieldBuilder = this.keywordsBuilder_;
            if (repeatedFieldBuilder != null) {
                return repeatedFieldBuilder.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.keywords_);
        }

        public Keyword.Builder addKeywordsBuilder() {
            return (Keyword.Builder) getKeywordsFieldBuilder().addBuilder(Keyword.getDefaultInstance());
        }

        public Keyword.Builder addKeywordsBuilder(int i) {
            return (Keyword.Builder) getKeywordsFieldBuilder().addBuilder(i, Keyword.getDefaultInstance());
        }

        public List<Keyword.Builder> getKeywordsBuilderList() {
            return getKeywordsFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilder<Keyword, Keyword.Builder, KeywordOrBuilder> getKeywordsFieldBuilder() {
            if (this.keywordsBuilder_ == null) {
                this.keywordsBuilder_ = new RepeatedFieldBuilder<>(this.keywords_, (this.bitField0_ & 8388608) != 0, getParentForChildren(), isClean());
                this.keywords_ = null;
            }
            return this.keywordsBuilder_;
        }

        private void ensureMultiplayerModesIsMutable() {
            if ((this.bitField0_ & 16777216) == 0) {
                this.multiplayerModes_ = new ArrayList(this.multiplayerModes_);
                this.bitField0_ |= 16777216;
            }
        }

        @Override // proto.GameOrBuilder
        public List<MultiplayerMode> getMultiplayerModesList() {
            RepeatedFieldBuilder<MultiplayerMode, MultiplayerMode.Builder, MultiplayerModeOrBuilder> repeatedFieldBuilder = this.multiplayerModesBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.multiplayerModes_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // proto.GameOrBuilder
        public int getMultiplayerModesCount() {
            RepeatedFieldBuilder<MultiplayerMode, MultiplayerMode.Builder, MultiplayerModeOrBuilder> repeatedFieldBuilder = this.multiplayerModesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.multiplayerModes_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // proto.GameOrBuilder
        public MultiplayerMode getMultiplayerModes(int i) {
            RepeatedFieldBuilder<MultiplayerMode, MultiplayerMode.Builder, MultiplayerModeOrBuilder> repeatedFieldBuilder = this.multiplayerModesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.multiplayerModes_.get(i);
            }
            return (MultiplayerMode) repeatedFieldBuilder.getMessage(i);
        }

        public Builder setMultiplayerModes(int i, MultiplayerMode multiplayerMode) {
            RepeatedFieldBuilder<MultiplayerMode, MultiplayerMode.Builder, MultiplayerModeOrBuilder> repeatedFieldBuilder = this.multiplayerModesBuilder_;
            if (repeatedFieldBuilder == null) {
                multiplayerMode.getClass();
                ensureMultiplayerModesIsMutable();
                this.multiplayerModes_.set(i, multiplayerMode);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, multiplayerMode);
            return this;
        }

        public Builder setMultiplayerModes(int i, MultiplayerMode.Builder builder) {
            RepeatedFieldBuilder<MultiplayerMode, MultiplayerMode.Builder, MultiplayerModeOrBuilder> repeatedFieldBuilder = this.multiplayerModesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureMultiplayerModesIsMutable();
                this.multiplayerModes_.set(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, builder.build());
            return this;
        }

        public Builder addMultiplayerModes(MultiplayerMode multiplayerMode) {
            RepeatedFieldBuilder<MultiplayerMode, MultiplayerMode.Builder, MultiplayerModeOrBuilder> repeatedFieldBuilder = this.multiplayerModesBuilder_;
            if (repeatedFieldBuilder == null) {
                multiplayerMode.getClass();
                ensureMultiplayerModesIsMutable();
                this.multiplayerModes_.add(multiplayerMode);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(multiplayerMode);
            return this;
        }

        public Builder addMultiplayerModes(int i, MultiplayerMode multiplayerMode) {
            RepeatedFieldBuilder<MultiplayerMode, MultiplayerMode.Builder, MultiplayerModeOrBuilder> repeatedFieldBuilder = this.multiplayerModesBuilder_;
            if (repeatedFieldBuilder == null) {
                multiplayerMode.getClass();
                ensureMultiplayerModesIsMutable();
                this.multiplayerModes_.add(i, multiplayerMode);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, multiplayerMode);
            return this;
        }

        public Builder addMultiplayerModes(MultiplayerMode.Builder builder) {
            RepeatedFieldBuilder<MultiplayerMode, MultiplayerMode.Builder, MultiplayerModeOrBuilder> repeatedFieldBuilder = this.multiplayerModesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureMultiplayerModesIsMutable();
                this.multiplayerModes_.add(builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(builder.build());
            return this;
        }

        public Builder addMultiplayerModes(int i, MultiplayerMode.Builder builder) {
            RepeatedFieldBuilder<MultiplayerMode, MultiplayerMode.Builder, MultiplayerModeOrBuilder> repeatedFieldBuilder = this.multiplayerModesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureMultiplayerModesIsMutable();
                this.multiplayerModes_.add(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, builder.build());
            return this;
        }

        public Builder addAllMultiplayerModes(Iterable<? extends MultiplayerMode> iterable) {
            RepeatedFieldBuilder<MultiplayerMode, MultiplayerMode.Builder, MultiplayerModeOrBuilder> repeatedFieldBuilder = this.multiplayerModesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureMultiplayerModesIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.multiplayerModes_);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addAllMessages(iterable);
            return this;
        }

        public Builder clearMultiplayerModes() {
            RepeatedFieldBuilder<MultiplayerMode, MultiplayerMode.Builder, MultiplayerModeOrBuilder> repeatedFieldBuilder = this.multiplayerModesBuilder_;
            if (repeatedFieldBuilder == null) {
                this.multiplayerModes_ = Collections.emptyList();
                this.bitField0_ &= -16777217;
                onChanged();
                return this;
            }
            repeatedFieldBuilder.clear();
            return this;
        }

        public Builder removeMultiplayerModes(int i) {
            RepeatedFieldBuilder<MultiplayerMode, MultiplayerMode.Builder, MultiplayerModeOrBuilder> repeatedFieldBuilder = this.multiplayerModesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureMultiplayerModesIsMutable();
                this.multiplayerModes_.remove(i);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.remove(i);
            return this;
        }

        public MultiplayerMode.Builder getMultiplayerModesBuilder(int i) {
            return (MultiplayerMode.Builder) getMultiplayerModesFieldBuilder().getBuilder(i);
        }

        @Override // proto.GameOrBuilder
        public MultiplayerModeOrBuilder getMultiplayerModesOrBuilder(int i) {
            RepeatedFieldBuilder<MultiplayerMode, MultiplayerMode.Builder, MultiplayerModeOrBuilder> repeatedFieldBuilder = this.multiplayerModesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.multiplayerModes_.get(i);
            }
            return (MultiplayerModeOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(i);
        }

        @Override // proto.GameOrBuilder
        public List<? extends MultiplayerModeOrBuilder> getMultiplayerModesOrBuilderList() {
            RepeatedFieldBuilder<MultiplayerMode, MultiplayerMode.Builder, MultiplayerModeOrBuilder> repeatedFieldBuilder = this.multiplayerModesBuilder_;
            if (repeatedFieldBuilder != null) {
                return repeatedFieldBuilder.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.multiplayerModes_);
        }

        public MultiplayerMode.Builder addMultiplayerModesBuilder() {
            return (MultiplayerMode.Builder) getMultiplayerModesFieldBuilder().addBuilder(MultiplayerMode.getDefaultInstance());
        }

        public MultiplayerMode.Builder addMultiplayerModesBuilder(int i) {
            return (MultiplayerMode.Builder) getMultiplayerModesFieldBuilder().addBuilder(i, MultiplayerMode.getDefaultInstance());
        }

        public List<MultiplayerMode.Builder> getMultiplayerModesBuilderList() {
            return getMultiplayerModesFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilder<MultiplayerMode, MultiplayerMode.Builder, MultiplayerModeOrBuilder> getMultiplayerModesFieldBuilder() {
            if (this.multiplayerModesBuilder_ == null) {
                this.multiplayerModesBuilder_ = new RepeatedFieldBuilder<>(this.multiplayerModes_, (this.bitField0_ & 16777216) != 0, getParentForChildren(), isClean());
                this.multiplayerModes_ = null;
            }
            return this.multiplayerModesBuilder_;
        }

        @Override // proto.GameOrBuilder
        public String getName() {
            Object obj = this.name_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.name_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.GameOrBuilder
        public ByteString getNameBytes() {
            Object obj = this.name_;
            if (obj instanceof String) {
                ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.name_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (ByteString) obj;
        }

        public Builder setName(String str) {
            str.getClass();
            this.name_ = str;
            this.bitField0_ |= MediaHttpDownloader.MAXIMUM_CHUNK_SIZE;
            onChanged();
            return this;
        }

        public Builder clearName() {
            this.name_ = Game.getDefaultInstance().getName();
            this.bitField0_ &= -33554433;
            onChanged();
            return this;
        }

        public Builder setNameBytes(ByteString byteString) {
            byteString.getClass();
            Game.checkByteStringIsUtf8(byteString);
            this.name_ = byteString;
            this.bitField0_ |= MediaHttpDownloader.MAXIMUM_CHUNK_SIZE;
            onChanged();
            return this;
        }

        @Override // proto.GameOrBuilder
        public boolean hasParentGame() {
            return (this.bitField0_ & AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL) != 0;
        }

        @Override // proto.GameOrBuilder
        public Game getParentGame() {
            SingleFieldBuilder<Game, Builder, GameOrBuilder> singleFieldBuilder = this.parentGameBuilder_;
            if (singleFieldBuilder == null) {
                Game game = this.parentGame_;
                return game == null ? Game.getDefaultInstance() : game;
            }
            return (Game) singleFieldBuilder.getMessage();
        }

        public Builder setParentGame(Game game) {
            SingleFieldBuilder<Game, Builder, GameOrBuilder> singleFieldBuilder = this.parentGameBuilder_;
            if (singleFieldBuilder == null) {
                game.getClass();
                this.parentGame_ = game;
            } else {
                singleFieldBuilder.setMessage(game);
            }
            this.bitField0_ |= AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
            onChanged();
            return this;
        }

        public Builder setParentGame(Builder builder) {
            SingleFieldBuilder<Game, Builder, GameOrBuilder> singleFieldBuilder = this.parentGameBuilder_;
            if (singleFieldBuilder == null) {
                this.parentGame_ = builder.build();
            } else {
                singleFieldBuilder.setMessage(builder.build());
            }
            this.bitField0_ |= AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
            onChanged();
            return this;
        }

        public Builder mergeParentGame(Game game) {
            Game game2;
            SingleFieldBuilder<Game, Builder, GameOrBuilder> singleFieldBuilder = this.parentGameBuilder_;
            if (singleFieldBuilder == null) {
                if ((this.bitField0_ & AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL) != 0 && (game2 = this.parentGame_) != null && game2 != Game.getDefaultInstance()) {
                    getParentGameBuilder().mergeFrom((Message) game);
                } else {
                    this.parentGame_ = game;
                }
            } else {
                singleFieldBuilder.mergeFrom(game);
            }
            if (this.parentGame_ != null) {
                this.bitField0_ |= AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
                onChanged();
            }
            return this;
        }

        public Builder clearParentGame() {
            this.bitField0_ &= -67108865;
            this.parentGame_ = null;
            SingleFieldBuilder<Game, Builder, GameOrBuilder> singleFieldBuilder = this.parentGameBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.parentGameBuilder_ = null;
            }
            onChanged();
            return this;
        }

        public Builder getParentGameBuilder() {
            this.bitField0_ |= AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
            onChanged();
            return (Builder) getParentGameFieldBuilder().getBuilder();
        }

        @Override // proto.GameOrBuilder
        public GameOrBuilder getParentGameOrBuilder() {
            SingleFieldBuilder<Game, Builder, GameOrBuilder> singleFieldBuilder = this.parentGameBuilder_;
            if (singleFieldBuilder != null) {
                return (GameOrBuilder) singleFieldBuilder.getMessageOrBuilder();
            }
            Game game = this.parentGame_;
            return game == null ? Game.getDefaultInstance() : game;
        }

        private SingleFieldBuilder<Game, Builder, GameOrBuilder> getParentGameFieldBuilder() {
            if (this.parentGameBuilder_ == null) {
                this.parentGameBuilder_ = new SingleFieldBuilder<>(getParentGame(), getParentForChildren(), isClean());
                this.parentGame_ = null;
            }
            return this.parentGameBuilder_;
        }

        private void ensurePlatformsIsMutable() {
            if ((this.bitField0_ & 134217728) == 0) {
                this.platforms_ = new ArrayList(this.platforms_);
                this.bitField0_ |= 134217728;
            }
        }

        @Override // proto.GameOrBuilder
        public List<Platform> getPlatformsList() {
            RepeatedFieldBuilder<Platform, Platform.Builder, PlatformOrBuilder> repeatedFieldBuilder = this.platformsBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.platforms_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // proto.GameOrBuilder
        public int getPlatformsCount() {
            RepeatedFieldBuilder<Platform, Platform.Builder, PlatformOrBuilder> repeatedFieldBuilder = this.platformsBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.platforms_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // proto.GameOrBuilder
        public Platform getPlatforms(int i) {
            RepeatedFieldBuilder<Platform, Platform.Builder, PlatformOrBuilder> repeatedFieldBuilder = this.platformsBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.platforms_.get(i);
            }
            return (Platform) repeatedFieldBuilder.getMessage(i);
        }

        public Builder setPlatforms(int i, Platform platform) {
            RepeatedFieldBuilder<Platform, Platform.Builder, PlatformOrBuilder> repeatedFieldBuilder = this.platformsBuilder_;
            if (repeatedFieldBuilder == null) {
                platform.getClass();
                ensurePlatformsIsMutable();
                this.platforms_.set(i, platform);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, platform);
            return this;
        }

        public Builder setPlatforms(int i, Platform.Builder builder) {
            RepeatedFieldBuilder<Platform, Platform.Builder, PlatformOrBuilder> repeatedFieldBuilder = this.platformsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensurePlatformsIsMutable();
                this.platforms_.set(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, builder.build());
            return this;
        }

        public Builder addPlatforms(Platform platform) {
            RepeatedFieldBuilder<Platform, Platform.Builder, PlatformOrBuilder> repeatedFieldBuilder = this.platformsBuilder_;
            if (repeatedFieldBuilder == null) {
                platform.getClass();
                ensurePlatformsIsMutable();
                this.platforms_.add(platform);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(platform);
            return this;
        }

        public Builder addPlatforms(int i, Platform platform) {
            RepeatedFieldBuilder<Platform, Platform.Builder, PlatformOrBuilder> repeatedFieldBuilder = this.platformsBuilder_;
            if (repeatedFieldBuilder == null) {
                platform.getClass();
                ensurePlatformsIsMutable();
                this.platforms_.add(i, platform);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, platform);
            return this;
        }

        public Builder addPlatforms(Platform.Builder builder) {
            RepeatedFieldBuilder<Platform, Platform.Builder, PlatformOrBuilder> repeatedFieldBuilder = this.platformsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensurePlatformsIsMutable();
                this.platforms_.add(builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(builder.build());
            return this;
        }

        public Builder addPlatforms(int i, Platform.Builder builder) {
            RepeatedFieldBuilder<Platform, Platform.Builder, PlatformOrBuilder> repeatedFieldBuilder = this.platformsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensurePlatformsIsMutable();
                this.platforms_.add(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, builder.build());
            return this;
        }

        public Builder addAllPlatforms(Iterable<? extends Platform> iterable) {
            RepeatedFieldBuilder<Platform, Platform.Builder, PlatformOrBuilder> repeatedFieldBuilder = this.platformsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensurePlatformsIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.platforms_);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addAllMessages(iterable);
            return this;
        }

        public Builder clearPlatforms() {
            RepeatedFieldBuilder<Platform, Platform.Builder, PlatformOrBuilder> repeatedFieldBuilder = this.platformsBuilder_;
            if (repeatedFieldBuilder == null) {
                this.platforms_ = Collections.emptyList();
                this.bitField0_ &= -134217729;
                onChanged();
                return this;
            }
            repeatedFieldBuilder.clear();
            return this;
        }

        public Builder removePlatforms(int i) {
            RepeatedFieldBuilder<Platform, Platform.Builder, PlatformOrBuilder> repeatedFieldBuilder = this.platformsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensurePlatformsIsMutable();
                this.platforms_.remove(i);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.remove(i);
            return this;
        }

        public Platform.Builder getPlatformsBuilder(int i) {
            return (Platform.Builder) getPlatformsFieldBuilder().getBuilder(i);
        }

        @Override // proto.GameOrBuilder
        public PlatformOrBuilder getPlatformsOrBuilder(int i) {
            RepeatedFieldBuilder<Platform, Platform.Builder, PlatformOrBuilder> repeatedFieldBuilder = this.platformsBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.platforms_.get(i);
            }
            return (PlatformOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(i);
        }

        @Override // proto.GameOrBuilder
        public List<? extends PlatformOrBuilder> getPlatformsOrBuilderList() {
            RepeatedFieldBuilder<Platform, Platform.Builder, PlatformOrBuilder> repeatedFieldBuilder = this.platformsBuilder_;
            if (repeatedFieldBuilder != null) {
                return repeatedFieldBuilder.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.platforms_);
        }

        public Platform.Builder addPlatformsBuilder() {
            return (Platform.Builder) getPlatformsFieldBuilder().addBuilder(Platform.getDefaultInstance());
        }

        public Platform.Builder addPlatformsBuilder(int i) {
            return (Platform.Builder) getPlatformsFieldBuilder().addBuilder(i, Platform.getDefaultInstance());
        }

        public List<Platform.Builder> getPlatformsBuilderList() {
            return getPlatformsFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilder<Platform, Platform.Builder, PlatformOrBuilder> getPlatformsFieldBuilder() {
            if (this.platformsBuilder_ == null) {
                this.platformsBuilder_ = new RepeatedFieldBuilder<>(this.platforms_, (this.bitField0_ & 134217728) != 0, getParentForChildren(), isClean());
                this.platforms_ = null;
            }
            return this.platformsBuilder_;
        }

        private void ensurePlayerPerspectivesIsMutable() {
            if ((this.bitField0_ & 268435456) == 0) {
                this.playerPerspectives_ = new ArrayList(this.playerPerspectives_);
                this.bitField0_ |= 268435456;
            }
        }

        @Override // proto.GameOrBuilder
        public List<PlayerPerspective> getPlayerPerspectivesList() {
            RepeatedFieldBuilder<PlayerPerspective, PlayerPerspective.Builder, PlayerPerspectiveOrBuilder> repeatedFieldBuilder = this.playerPerspectivesBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.playerPerspectives_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // proto.GameOrBuilder
        public int getPlayerPerspectivesCount() {
            RepeatedFieldBuilder<PlayerPerspective, PlayerPerspective.Builder, PlayerPerspectiveOrBuilder> repeatedFieldBuilder = this.playerPerspectivesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.playerPerspectives_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // proto.GameOrBuilder
        public PlayerPerspective getPlayerPerspectives(int i) {
            RepeatedFieldBuilder<PlayerPerspective, PlayerPerspective.Builder, PlayerPerspectiveOrBuilder> repeatedFieldBuilder = this.playerPerspectivesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.playerPerspectives_.get(i);
            }
            return (PlayerPerspective) repeatedFieldBuilder.getMessage(i);
        }

        public Builder setPlayerPerspectives(int i, PlayerPerspective playerPerspective) {
            RepeatedFieldBuilder<PlayerPerspective, PlayerPerspective.Builder, PlayerPerspectiveOrBuilder> repeatedFieldBuilder = this.playerPerspectivesBuilder_;
            if (repeatedFieldBuilder == null) {
                playerPerspective.getClass();
                ensurePlayerPerspectivesIsMutable();
                this.playerPerspectives_.set(i, playerPerspective);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, playerPerspective);
            return this;
        }

        public Builder setPlayerPerspectives(int i, PlayerPerspective.Builder builder) {
            RepeatedFieldBuilder<PlayerPerspective, PlayerPerspective.Builder, PlayerPerspectiveOrBuilder> repeatedFieldBuilder = this.playerPerspectivesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensurePlayerPerspectivesIsMutable();
                this.playerPerspectives_.set(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, builder.build());
            return this;
        }

        public Builder addPlayerPerspectives(PlayerPerspective playerPerspective) {
            RepeatedFieldBuilder<PlayerPerspective, PlayerPerspective.Builder, PlayerPerspectiveOrBuilder> repeatedFieldBuilder = this.playerPerspectivesBuilder_;
            if (repeatedFieldBuilder == null) {
                playerPerspective.getClass();
                ensurePlayerPerspectivesIsMutable();
                this.playerPerspectives_.add(playerPerspective);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(playerPerspective);
            return this;
        }

        public Builder addPlayerPerspectives(int i, PlayerPerspective playerPerspective) {
            RepeatedFieldBuilder<PlayerPerspective, PlayerPerspective.Builder, PlayerPerspectiveOrBuilder> repeatedFieldBuilder = this.playerPerspectivesBuilder_;
            if (repeatedFieldBuilder == null) {
                playerPerspective.getClass();
                ensurePlayerPerspectivesIsMutable();
                this.playerPerspectives_.add(i, playerPerspective);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, playerPerspective);
            return this;
        }

        public Builder addPlayerPerspectives(PlayerPerspective.Builder builder) {
            RepeatedFieldBuilder<PlayerPerspective, PlayerPerspective.Builder, PlayerPerspectiveOrBuilder> repeatedFieldBuilder = this.playerPerspectivesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensurePlayerPerspectivesIsMutable();
                this.playerPerspectives_.add(builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(builder.build());
            return this;
        }

        public Builder addPlayerPerspectives(int i, PlayerPerspective.Builder builder) {
            RepeatedFieldBuilder<PlayerPerspective, PlayerPerspective.Builder, PlayerPerspectiveOrBuilder> repeatedFieldBuilder = this.playerPerspectivesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensurePlayerPerspectivesIsMutable();
                this.playerPerspectives_.add(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, builder.build());
            return this;
        }

        public Builder addAllPlayerPerspectives(Iterable<? extends PlayerPerspective> iterable) {
            RepeatedFieldBuilder<PlayerPerspective, PlayerPerspective.Builder, PlayerPerspectiveOrBuilder> repeatedFieldBuilder = this.playerPerspectivesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensurePlayerPerspectivesIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.playerPerspectives_);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addAllMessages(iterable);
            return this;
        }

        public Builder clearPlayerPerspectives() {
            RepeatedFieldBuilder<PlayerPerspective, PlayerPerspective.Builder, PlayerPerspectiveOrBuilder> repeatedFieldBuilder = this.playerPerspectivesBuilder_;
            if (repeatedFieldBuilder == null) {
                this.playerPerspectives_ = Collections.emptyList();
                this.bitField0_ &= -268435457;
                onChanged();
                return this;
            }
            repeatedFieldBuilder.clear();
            return this;
        }

        public Builder removePlayerPerspectives(int i) {
            RepeatedFieldBuilder<PlayerPerspective, PlayerPerspective.Builder, PlayerPerspectiveOrBuilder> repeatedFieldBuilder = this.playerPerspectivesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensurePlayerPerspectivesIsMutable();
                this.playerPerspectives_.remove(i);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.remove(i);
            return this;
        }

        public PlayerPerspective.Builder getPlayerPerspectivesBuilder(int i) {
            return (PlayerPerspective.Builder) getPlayerPerspectivesFieldBuilder().getBuilder(i);
        }

        @Override // proto.GameOrBuilder
        public PlayerPerspectiveOrBuilder getPlayerPerspectivesOrBuilder(int i) {
            RepeatedFieldBuilder<PlayerPerspective, PlayerPerspective.Builder, PlayerPerspectiveOrBuilder> repeatedFieldBuilder = this.playerPerspectivesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.playerPerspectives_.get(i);
            }
            return (PlayerPerspectiveOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(i);
        }

        @Override // proto.GameOrBuilder
        public List<? extends PlayerPerspectiveOrBuilder> getPlayerPerspectivesOrBuilderList() {
            RepeatedFieldBuilder<PlayerPerspective, PlayerPerspective.Builder, PlayerPerspectiveOrBuilder> repeatedFieldBuilder = this.playerPerspectivesBuilder_;
            if (repeatedFieldBuilder != null) {
                return repeatedFieldBuilder.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.playerPerspectives_);
        }

        public PlayerPerspective.Builder addPlayerPerspectivesBuilder() {
            return (PlayerPerspective.Builder) getPlayerPerspectivesFieldBuilder().addBuilder(PlayerPerspective.getDefaultInstance());
        }

        public PlayerPerspective.Builder addPlayerPerspectivesBuilder(int i) {
            return (PlayerPerspective.Builder) getPlayerPerspectivesFieldBuilder().addBuilder(i, PlayerPerspective.getDefaultInstance());
        }

        public List<PlayerPerspective.Builder> getPlayerPerspectivesBuilderList() {
            return getPlayerPerspectivesFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilder<PlayerPerspective, PlayerPerspective.Builder, PlayerPerspectiveOrBuilder> getPlayerPerspectivesFieldBuilder() {
            if (this.playerPerspectivesBuilder_ == null) {
                this.playerPerspectivesBuilder_ = new RepeatedFieldBuilder<>(this.playerPerspectives_, (this.bitField0_ & 268435456) != 0, getParentForChildren(), isClean());
                this.playerPerspectives_ = null;
            }
            return this.playerPerspectivesBuilder_;
        }

        @Override // proto.GameOrBuilder
        public double getRating() {
            return this.rating_;
        }

        public Builder setRating(double d) {
            this.rating_ = d;
            this.bitField0_ |= 536870912;
            onChanged();
            return this;
        }

        public Builder clearRating() {
            this.bitField0_ &= -536870913;
            this.rating_ = 0.0d;
            onChanged();
            return this;
        }

        @Override // proto.GameOrBuilder
        public int getRatingCount() {
            return this.ratingCount_;
        }

        public Builder setRatingCount(int i) {
            this.ratingCount_ = i;
            this.bitField0_ |= 1073741824;
            onChanged();
            return this;
        }

        public Builder clearRatingCount() {
            this.bitField0_ &= -1073741825;
            this.ratingCount_ = 0;
            onChanged();
            return this;
        }

        private void ensureReleaseDatesIsMutable() {
            if ((this.bitField0_ & Integer.MIN_VALUE) == 0) {
                this.releaseDates_ = new ArrayList(this.releaseDates_);
                this.bitField0_ |= Integer.MIN_VALUE;
            }
        }

        @Override // proto.GameOrBuilder
        public List<ReleaseDate> getReleaseDatesList() {
            RepeatedFieldBuilder<ReleaseDate, ReleaseDate.Builder, ReleaseDateOrBuilder> repeatedFieldBuilder = this.releaseDatesBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.releaseDates_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // proto.GameOrBuilder
        public int getReleaseDatesCount() {
            RepeatedFieldBuilder<ReleaseDate, ReleaseDate.Builder, ReleaseDateOrBuilder> repeatedFieldBuilder = this.releaseDatesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.releaseDates_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // proto.GameOrBuilder
        public ReleaseDate getReleaseDates(int i) {
            RepeatedFieldBuilder<ReleaseDate, ReleaseDate.Builder, ReleaseDateOrBuilder> repeatedFieldBuilder = this.releaseDatesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.releaseDates_.get(i);
            }
            return (ReleaseDate) repeatedFieldBuilder.getMessage(i);
        }

        public Builder setReleaseDates(int i, ReleaseDate releaseDate) {
            RepeatedFieldBuilder<ReleaseDate, ReleaseDate.Builder, ReleaseDateOrBuilder> repeatedFieldBuilder = this.releaseDatesBuilder_;
            if (repeatedFieldBuilder == null) {
                releaseDate.getClass();
                ensureReleaseDatesIsMutable();
                this.releaseDates_.set(i, releaseDate);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, releaseDate);
            return this;
        }

        public Builder setReleaseDates(int i, ReleaseDate.Builder builder) {
            RepeatedFieldBuilder<ReleaseDate, ReleaseDate.Builder, ReleaseDateOrBuilder> repeatedFieldBuilder = this.releaseDatesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureReleaseDatesIsMutable();
                this.releaseDates_.set(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, builder.build());
            return this;
        }

        public Builder addReleaseDates(ReleaseDate releaseDate) {
            RepeatedFieldBuilder<ReleaseDate, ReleaseDate.Builder, ReleaseDateOrBuilder> repeatedFieldBuilder = this.releaseDatesBuilder_;
            if (repeatedFieldBuilder == null) {
                releaseDate.getClass();
                ensureReleaseDatesIsMutable();
                this.releaseDates_.add(releaseDate);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(releaseDate);
            return this;
        }

        public Builder addReleaseDates(int i, ReleaseDate releaseDate) {
            RepeatedFieldBuilder<ReleaseDate, ReleaseDate.Builder, ReleaseDateOrBuilder> repeatedFieldBuilder = this.releaseDatesBuilder_;
            if (repeatedFieldBuilder == null) {
                releaseDate.getClass();
                ensureReleaseDatesIsMutable();
                this.releaseDates_.add(i, releaseDate);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, releaseDate);
            return this;
        }

        public Builder addReleaseDates(ReleaseDate.Builder builder) {
            RepeatedFieldBuilder<ReleaseDate, ReleaseDate.Builder, ReleaseDateOrBuilder> repeatedFieldBuilder = this.releaseDatesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureReleaseDatesIsMutable();
                this.releaseDates_.add(builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(builder.build());
            return this;
        }

        public Builder addReleaseDates(int i, ReleaseDate.Builder builder) {
            RepeatedFieldBuilder<ReleaseDate, ReleaseDate.Builder, ReleaseDateOrBuilder> repeatedFieldBuilder = this.releaseDatesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureReleaseDatesIsMutable();
                this.releaseDates_.add(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, builder.build());
            return this;
        }

        public Builder addAllReleaseDates(Iterable<? extends ReleaseDate> iterable) {
            RepeatedFieldBuilder<ReleaseDate, ReleaseDate.Builder, ReleaseDateOrBuilder> repeatedFieldBuilder = this.releaseDatesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureReleaseDatesIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.releaseDates_);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addAllMessages(iterable);
            return this;
        }

        public Builder clearReleaseDates() {
            RepeatedFieldBuilder<ReleaseDate, ReleaseDate.Builder, ReleaseDateOrBuilder> repeatedFieldBuilder = this.releaseDatesBuilder_;
            if (repeatedFieldBuilder == null) {
                this.releaseDates_ = Collections.emptyList();
                this.bitField0_ &= Integer.MAX_VALUE;
                onChanged();
                return this;
            }
            repeatedFieldBuilder.clear();
            return this;
        }

        public Builder removeReleaseDates(int i) {
            RepeatedFieldBuilder<ReleaseDate, ReleaseDate.Builder, ReleaseDateOrBuilder> repeatedFieldBuilder = this.releaseDatesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureReleaseDatesIsMutable();
                this.releaseDates_.remove(i);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.remove(i);
            return this;
        }

        public ReleaseDate.Builder getReleaseDatesBuilder(int i) {
            return (ReleaseDate.Builder) getReleaseDatesFieldBuilder().getBuilder(i);
        }

        @Override // proto.GameOrBuilder
        public ReleaseDateOrBuilder getReleaseDatesOrBuilder(int i) {
            RepeatedFieldBuilder<ReleaseDate, ReleaseDate.Builder, ReleaseDateOrBuilder> repeatedFieldBuilder = this.releaseDatesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.releaseDates_.get(i);
            }
            return (ReleaseDateOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(i);
        }

        @Override // proto.GameOrBuilder
        public List<? extends ReleaseDateOrBuilder> getReleaseDatesOrBuilderList() {
            RepeatedFieldBuilder<ReleaseDate, ReleaseDate.Builder, ReleaseDateOrBuilder> repeatedFieldBuilder = this.releaseDatesBuilder_;
            if (repeatedFieldBuilder != null) {
                return repeatedFieldBuilder.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.releaseDates_);
        }

        public ReleaseDate.Builder addReleaseDatesBuilder() {
            return (ReleaseDate.Builder) getReleaseDatesFieldBuilder().addBuilder(ReleaseDate.getDefaultInstance());
        }

        public ReleaseDate.Builder addReleaseDatesBuilder(int i) {
            return (ReleaseDate.Builder) getReleaseDatesFieldBuilder().addBuilder(i, ReleaseDate.getDefaultInstance());
        }

        public List<ReleaseDate.Builder> getReleaseDatesBuilderList() {
            return getReleaseDatesFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilder<ReleaseDate, ReleaseDate.Builder, ReleaseDateOrBuilder> getReleaseDatesFieldBuilder() {
            if (this.releaseDatesBuilder_ == null) {
                this.releaseDatesBuilder_ = new RepeatedFieldBuilder<>(this.releaseDates_, (this.bitField0_ & Integer.MIN_VALUE) != 0, getParentForChildren(), isClean());
                this.releaseDates_ = null;
            }
            return this.releaseDatesBuilder_;
        }

        private void ensureScreenshotsIsMutable() {
            if ((this.bitField1_ & 1) == 0) {
                this.screenshots_ = new ArrayList(this.screenshots_);
                this.bitField1_ |= 1;
            }
        }

        @Override // proto.GameOrBuilder
        public List<Screenshot> getScreenshotsList() {
            RepeatedFieldBuilder<Screenshot, Screenshot.Builder, ScreenshotOrBuilder> repeatedFieldBuilder = this.screenshotsBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.screenshots_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // proto.GameOrBuilder
        public int getScreenshotsCount() {
            RepeatedFieldBuilder<Screenshot, Screenshot.Builder, ScreenshotOrBuilder> repeatedFieldBuilder = this.screenshotsBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.screenshots_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // proto.GameOrBuilder
        public Screenshot getScreenshots(int i) {
            RepeatedFieldBuilder<Screenshot, Screenshot.Builder, ScreenshotOrBuilder> repeatedFieldBuilder = this.screenshotsBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.screenshots_.get(i);
            }
            return (Screenshot) repeatedFieldBuilder.getMessage(i);
        }

        public Builder setScreenshots(int i, Screenshot screenshot) {
            RepeatedFieldBuilder<Screenshot, Screenshot.Builder, ScreenshotOrBuilder> repeatedFieldBuilder = this.screenshotsBuilder_;
            if (repeatedFieldBuilder == null) {
                screenshot.getClass();
                ensureScreenshotsIsMutable();
                this.screenshots_.set(i, screenshot);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, screenshot);
            return this;
        }

        public Builder setScreenshots(int i, Screenshot.Builder builder) {
            RepeatedFieldBuilder<Screenshot, Screenshot.Builder, ScreenshotOrBuilder> repeatedFieldBuilder = this.screenshotsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureScreenshotsIsMutable();
                this.screenshots_.set(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, builder.build());
            return this;
        }

        public Builder addScreenshots(Screenshot screenshot) {
            RepeatedFieldBuilder<Screenshot, Screenshot.Builder, ScreenshotOrBuilder> repeatedFieldBuilder = this.screenshotsBuilder_;
            if (repeatedFieldBuilder == null) {
                screenshot.getClass();
                ensureScreenshotsIsMutable();
                this.screenshots_.add(screenshot);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(screenshot);
            return this;
        }

        public Builder addScreenshots(int i, Screenshot screenshot) {
            RepeatedFieldBuilder<Screenshot, Screenshot.Builder, ScreenshotOrBuilder> repeatedFieldBuilder = this.screenshotsBuilder_;
            if (repeatedFieldBuilder == null) {
                screenshot.getClass();
                ensureScreenshotsIsMutable();
                this.screenshots_.add(i, screenshot);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, screenshot);
            return this;
        }

        public Builder addScreenshots(Screenshot.Builder builder) {
            RepeatedFieldBuilder<Screenshot, Screenshot.Builder, ScreenshotOrBuilder> repeatedFieldBuilder = this.screenshotsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureScreenshotsIsMutable();
                this.screenshots_.add(builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(builder.build());
            return this;
        }

        public Builder addScreenshots(int i, Screenshot.Builder builder) {
            RepeatedFieldBuilder<Screenshot, Screenshot.Builder, ScreenshotOrBuilder> repeatedFieldBuilder = this.screenshotsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureScreenshotsIsMutable();
                this.screenshots_.add(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, builder.build());
            return this;
        }

        public Builder addAllScreenshots(Iterable<? extends Screenshot> iterable) {
            RepeatedFieldBuilder<Screenshot, Screenshot.Builder, ScreenshotOrBuilder> repeatedFieldBuilder = this.screenshotsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureScreenshotsIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.screenshots_);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addAllMessages(iterable);
            return this;
        }

        public Builder clearScreenshots() {
            RepeatedFieldBuilder<Screenshot, Screenshot.Builder, ScreenshotOrBuilder> repeatedFieldBuilder = this.screenshotsBuilder_;
            if (repeatedFieldBuilder == null) {
                this.screenshots_ = Collections.emptyList();
                this.bitField1_ &= -2;
                onChanged();
                return this;
            }
            repeatedFieldBuilder.clear();
            return this;
        }

        public Builder removeScreenshots(int i) {
            RepeatedFieldBuilder<Screenshot, Screenshot.Builder, ScreenshotOrBuilder> repeatedFieldBuilder = this.screenshotsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureScreenshotsIsMutable();
                this.screenshots_.remove(i);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.remove(i);
            return this;
        }

        public Screenshot.Builder getScreenshotsBuilder(int i) {
            return (Screenshot.Builder) getScreenshotsFieldBuilder().getBuilder(i);
        }

        @Override // proto.GameOrBuilder
        public ScreenshotOrBuilder getScreenshotsOrBuilder(int i) {
            RepeatedFieldBuilder<Screenshot, Screenshot.Builder, ScreenshotOrBuilder> repeatedFieldBuilder = this.screenshotsBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.screenshots_.get(i);
            }
            return (ScreenshotOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(i);
        }

        @Override // proto.GameOrBuilder
        public List<? extends ScreenshotOrBuilder> getScreenshotsOrBuilderList() {
            RepeatedFieldBuilder<Screenshot, Screenshot.Builder, ScreenshotOrBuilder> repeatedFieldBuilder = this.screenshotsBuilder_;
            if (repeatedFieldBuilder != null) {
                return repeatedFieldBuilder.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.screenshots_);
        }

        public Screenshot.Builder addScreenshotsBuilder() {
            return (Screenshot.Builder) getScreenshotsFieldBuilder().addBuilder(Screenshot.getDefaultInstance());
        }

        public Screenshot.Builder addScreenshotsBuilder(int i) {
            return (Screenshot.Builder) getScreenshotsFieldBuilder().addBuilder(i, Screenshot.getDefaultInstance());
        }

        public List<Screenshot.Builder> getScreenshotsBuilderList() {
            return getScreenshotsFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilder<Screenshot, Screenshot.Builder, ScreenshotOrBuilder> getScreenshotsFieldBuilder() {
            if (this.screenshotsBuilder_ == null) {
                this.screenshotsBuilder_ = new RepeatedFieldBuilder<>(this.screenshots_, (this.bitField1_ & 1) != 0, getParentForChildren(), isClean());
                this.screenshots_ = null;
            }
            return this.screenshotsBuilder_;
        }

        private void ensureSimilarGamesIsMutable() {
            if ((this.bitField1_ & 2) == 0) {
                this.similarGames_ = new ArrayList(this.similarGames_);
                this.bitField1_ |= 2;
            }
        }

        @Override // proto.GameOrBuilder
        public List<Game> getSimilarGamesList() {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.similarGamesBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.similarGames_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // proto.GameOrBuilder
        public int getSimilarGamesCount() {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.similarGamesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.similarGames_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // proto.GameOrBuilder
        public Game getSimilarGames(int i) {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.similarGamesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.similarGames_.get(i);
            }
            return (Game) repeatedFieldBuilder.getMessage(i);
        }

        public Builder setSimilarGames(int i, Game game) {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.similarGamesBuilder_;
            if (repeatedFieldBuilder == null) {
                game.getClass();
                ensureSimilarGamesIsMutable();
                this.similarGames_.set(i, game);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, game);
            return this;
        }

        public Builder setSimilarGames(int i, Builder builder) {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.similarGamesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureSimilarGamesIsMutable();
                this.similarGames_.set(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, builder.build());
            return this;
        }

        public Builder addSimilarGames(Game game) {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.similarGamesBuilder_;
            if (repeatedFieldBuilder == null) {
                game.getClass();
                ensureSimilarGamesIsMutable();
                this.similarGames_.add(game);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(game);
            return this;
        }

        public Builder addSimilarGames(int i, Game game) {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.similarGamesBuilder_;
            if (repeatedFieldBuilder == null) {
                game.getClass();
                ensureSimilarGamesIsMutable();
                this.similarGames_.add(i, game);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, game);
            return this;
        }

        public Builder addSimilarGames(Builder builder) {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.similarGamesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureSimilarGamesIsMutable();
                this.similarGames_.add(builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(builder.build());
            return this;
        }

        public Builder addSimilarGames(int i, Builder builder) {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.similarGamesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureSimilarGamesIsMutable();
                this.similarGames_.add(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, builder.build());
            return this;
        }

        public Builder addAllSimilarGames(Iterable<? extends Game> iterable) {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.similarGamesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureSimilarGamesIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.similarGames_);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addAllMessages(iterable);
            return this;
        }

        public Builder clearSimilarGames() {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.similarGamesBuilder_;
            if (repeatedFieldBuilder == null) {
                this.similarGames_ = Collections.emptyList();
                this.bitField1_ &= -3;
                onChanged();
                return this;
            }
            repeatedFieldBuilder.clear();
            return this;
        }

        public Builder removeSimilarGames(int i) {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.similarGamesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureSimilarGamesIsMutable();
                this.similarGames_.remove(i);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.remove(i);
            return this;
        }

        public Builder getSimilarGamesBuilder(int i) {
            return (Builder) getSimilarGamesFieldBuilder().getBuilder(i);
        }

        @Override // proto.GameOrBuilder
        public GameOrBuilder getSimilarGamesOrBuilder(int i) {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.similarGamesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.similarGames_.get(i);
            }
            return (GameOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(i);
        }

        @Override // proto.GameOrBuilder
        public List<? extends GameOrBuilder> getSimilarGamesOrBuilderList() {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.similarGamesBuilder_;
            if (repeatedFieldBuilder != null) {
                return repeatedFieldBuilder.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.similarGames_);
        }

        public Builder addSimilarGamesBuilder() {
            return (Builder) getSimilarGamesFieldBuilder().addBuilder(Game.getDefaultInstance());
        }

        public Builder addSimilarGamesBuilder(int i) {
            return (Builder) getSimilarGamesFieldBuilder().addBuilder(i, Game.getDefaultInstance());
        }

        public List<Builder> getSimilarGamesBuilderList() {
            return getSimilarGamesFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilder<Game, Builder, GameOrBuilder> getSimilarGamesFieldBuilder() {
            if (this.similarGamesBuilder_ == null) {
                this.similarGamesBuilder_ = new RepeatedFieldBuilder<>(this.similarGames_, (this.bitField1_ & 2) != 0, getParentForChildren(), isClean());
                this.similarGames_ = null;
            }
            return this.similarGamesBuilder_;
        }

        @Override // proto.GameOrBuilder
        public String getSlug() {
            Object obj = this.slug_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.slug_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.GameOrBuilder
        public ByteString getSlugBytes() {
            Object obj = this.slug_;
            if (obj instanceof String) {
                ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.slug_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (ByteString) obj;
        }

        public Builder setSlug(String str) {
            str.getClass();
            this.slug_ = str;
            this.bitField1_ |= 4;
            onChanged();
            return this;
        }

        public Builder clearSlug() {
            this.slug_ = Game.getDefaultInstance().getSlug();
            this.bitField1_ &= -5;
            onChanged();
            return this;
        }

        public Builder setSlugBytes(ByteString byteString) {
            byteString.getClass();
            Game.checkByteStringIsUtf8(byteString);
            this.slug_ = byteString;
            this.bitField1_ |= 4;
            onChanged();
            return this;
        }

        private void ensureStandaloneExpansionsIsMutable() {
            if ((this.bitField1_ & 8) == 0) {
                this.standaloneExpansions_ = new ArrayList(this.standaloneExpansions_);
                this.bitField1_ |= 8;
            }
        }

        @Override // proto.GameOrBuilder
        public List<Game> getStandaloneExpansionsList() {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.standaloneExpansionsBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.standaloneExpansions_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // proto.GameOrBuilder
        public int getStandaloneExpansionsCount() {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.standaloneExpansionsBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.standaloneExpansions_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // proto.GameOrBuilder
        public Game getStandaloneExpansions(int i) {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.standaloneExpansionsBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.standaloneExpansions_.get(i);
            }
            return (Game) repeatedFieldBuilder.getMessage(i);
        }

        public Builder setStandaloneExpansions(int i, Game game) {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.standaloneExpansionsBuilder_;
            if (repeatedFieldBuilder == null) {
                game.getClass();
                ensureStandaloneExpansionsIsMutable();
                this.standaloneExpansions_.set(i, game);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, game);
            return this;
        }

        public Builder setStandaloneExpansions(int i, Builder builder) {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.standaloneExpansionsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureStandaloneExpansionsIsMutable();
                this.standaloneExpansions_.set(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, builder.build());
            return this;
        }

        public Builder addStandaloneExpansions(Game game) {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.standaloneExpansionsBuilder_;
            if (repeatedFieldBuilder == null) {
                game.getClass();
                ensureStandaloneExpansionsIsMutable();
                this.standaloneExpansions_.add(game);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(game);
            return this;
        }

        public Builder addStandaloneExpansions(int i, Game game) {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.standaloneExpansionsBuilder_;
            if (repeatedFieldBuilder == null) {
                game.getClass();
                ensureStandaloneExpansionsIsMutable();
                this.standaloneExpansions_.add(i, game);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, game);
            return this;
        }

        public Builder addStandaloneExpansions(Builder builder) {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.standaloneExpansionsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureStandaloneExpansionsIsMutable();
                this.standaloneExpansions_.add(builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(builder.build());
            return this;
        }

        public Builder addStandaloneExpansions(int i, Builder builder) {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.standaloneExpansionsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureStandaloneExpansionsIsMutable();
                this.standaloneExpansions_.add(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, builder.build());
            return this;
        }

        public Builder addAllStandaloneExpansions(Iterable<? extends Game> iterable) {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.standaloneExpansionsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureStandaloneExpansionsIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.standaloneExpansions_);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addAllMessages(iterable);
            return this;
        }

        public Builder clearStandaloneExpansions() {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.standaloneExpansionsBuilder_;
            if (repeatedFieldBuilder == null) {
                this.standaloneExpansions_ = Collections.emptyList();
                this.bitField1_ &= -9;
                onChanged();
                return this;
            }
            repeatedFieldBuilder.clear();
            return this;
        }

        public Builder removeStandaloneExpansions(int i) {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.standaloneExpansionsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureStandaloneExpansionsIsMutable();
                this.standaloneExpansions_.remove(i);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.remove(i);
            return this;
        }

        public Builder getStandaloneExpansionsBuilder(int i) {
            return (Builder) getStandaloneExpansionsFieldBuilder().getBuilder(i);
        }

        @Override // proto.GameOrBuilder
        public GameOrBuilder getStandaloneExpansionsOrBuilder(int i) {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.standaloneExpansionsBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.standaloneExpansions_.get(i);
            }
            return (GameOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(i);
        }

        @Override // proto.GameOrBuilder
        public List<? extends GameOrBuilder> getStandaloneExpansionsOrBuilderList() {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.standaloneExpansionsBuilder_;
            if (repeatedFieldBuilder != null) {
                return repeatedFieldBuilder.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.standaloneExpansions_);
        }

        public Builder addStandaloneExpansionsBuilder() {
            return (Builder) getStandaloneExpansionsFieldBuilder().addBuilder(Game.getDefaultInstance());
        }

        public Builder addStandaloneExpansionsBuilder(int i) {
            return (Builder) getStandaloneExpansionsFieldBuilder().addBuilder(i, Game.getDefaultInstance());
        }

        public List<Builder> getStandaloneExpansionsBuilderList() {
            return getStandaloneExpansionsFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilder<Game, Builder, GameOrBuilder> getStandaloneExpansionsFieldBuilder() {
            if (this.standaloneExpansionsBuilder_ == null) {
                this.standaloneExpansionsBuilder_ = new RepeatedFieldBuilder<>(this.standaloneExpansions_, (this.bitField1_ & 8) != 0, getParentForChildren(), isClean());
                this.standaloneExpansions_ = null;
            }
            return this.standaloneExpansionsBuilder_;
        }

        @Override // proto.GameOrBuilder
        public int getStatusValue() {
            return this.status_;
        }

        public Builder setStatusValue(int i) {
            this.status_ = i;
            this.bitField1_ |= 16;
            onChanged();
            return this;
        }

        @Override // proto.GameOrBuilder
        public GameStatusEnum getStatus() {
            GameStatusEnum gameStatusEnumForNumber = GameStatusEnum.forNumber(this.status_);
            return gameStatusEnumForNumber == null ? GameStatusEnum.UNRECOGNIZED : gameStatusEnumForNumber;
        }

        public Builder setStatus(GameStatusEnum gameStatusEnum) {
            gameStatusEnum.getClass();
            this.bitField1_ |= 16;
            this.status_ = gameStatusEnum.getNumber();
            onChanged();
            return this;
        }

        public Builder clearStatus() {
            this.bitField1_ &= -17;
            this.status_ = 0;
            onChanged();
            return this;
        }

        @Override // proto.GameOrBuilder
        public String getStoryline() {
            Object obj = this.storyline_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.storyline_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.GameOrBuilder
        public ByteString getStorylineBytes() {
            Object obj = this.storyline_;
            if (obj instanceof String) {
                ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.storyline_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (ByteString) obj;
        }

        public Builder setStoryline(String str) {
            str.getClass();
            this.storyline_ = str;
            this.bitField1_ |= 32;
            onChanged();
            return this;
        }

        public Builder clearStoryline() {
            this.storyline_ = Game.getDefaultInstance().getStoryline();
            this.bitField1_ &= -33;
            onChanged();
            return this;
        }

        public Builder setStorylineBytes(ByteString byteString) {
            byteString.getClass();
            Game.checkByteStringIsUtf8(byteString);
            this.storyline_ = byteString;
            this.bitField1_ |= 32;
            onChanged();
            return this;
        }

        @Override // proto.GameOrBuilder
        public String getSummary() {
            Object obj = this.summary_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.summary_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.GameOrBuilder
        public ByteString getSummaryBytes() {
            Object obj = this.summary_;
            if (obj instanceof String) {
                ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.summary_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (ByteString) obj;
        }

        public Builder setSummary(String str) {
            str.getClass();
            this.summary_ = str;
            this.bitField1_ |= 64;
            onChanged();
            return this;
        }

        public Builder clearSummary() {
            this.summary_ = Game.getDefaultInstance().getSummary();
            this.bitField1_ &= -65;
            onChanged();
            return this;
        }

        public Builder setSummaryBytes(ByteString byteString) {
            byteString.getClass();
            Game.checkByteStringIsUtf8(byteString);
            this.summary_ = byteString;
            this.bitField1_ |= 64;
            onChanged();
            return this;
        }

        private void ensureTagsIsMutable() {
            if (!this.tags_.isModifiable()) {
                this.tags_ = (Internal.IntList) Game.makeMutableCopy(this.tags_);
            }
            this.bitField1_ |= 128;
        }

        @Override // proto.GameOrBuilder
        public List<Integer> getTagsList() {
            this.tags_.makeImmutable();
            return this.tags_;
        }

        @Override // proto.GameOrBuilder
        public int getTagsCount() {
            return this.tags_.size();
        }

        @Override // proto.GameOrBuilder
        public int getTags(int i) {
            return this.tags_.getInt(i);
        }

        public Builder setTags(int i, int i2) {
            ensureTagsIsMutable();
            this.tags_.setInt(i, i2);
            this.bitField1_ |= 128;
            onChanged();
            return this;
        }

        public Builder addTags(int i) {
            ensureTagsIsMutable();
            this.tags_.addInt(i);
            this.bitField1_ |= 128;
            onChanged();
            return this;
        }

        public Builder addAllTags(Iterable<? extends Integer> iterable) {
            ensureTagsIsMutable();
            AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.tags_);
            this.bitField1_ |= 128;
            onChanged();
            return this;
        }

        public Builder clearTags() {
            this.tags_ = Game.emptyIntList();
            this.bitField1_ &= -129;
            onChanged();
            return this;
        }

        private void ensureThemesIsMutable() {
            if ((this.bitField1_ & 256) == 0) {
                this.themes_ = new ArrayList(this.themes_);
                this.bitField1_ |= 256;
            }
        }

        @Override // proto.GameOrBuilder
        public List<Theme> getThemesList() {
            RepeatedFieldBuilder<Theme, Theme.Builder, ThemeOrBuilder> repeatedFieldBuilder = this.themesBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.themes_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // proto.GameOrBuilder
        public int getThemesCount() {
            RepeatedFieldBuilder<Theme, Theme.Builder, ThemeOrBuilder> repeatedFieldBuilder = this.themesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.themes_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // proto.GameOrBuilder
        public Theme getThemes(int i) {
            RepeatedFieldBuilder<Theme, Theme.Builder, ThemeOrBuilder> repeatedFieldBuilder = this.themesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.themes_.get(i);
            }
            return (Theme) repeatedFieldBuilder.getMessage(i);
        }

        public Builder setThemes(int i, Theme theme) {
            RepeatedFieldBuilder<Theme, Theme.Builder, ThemeOrBuilder> repeatedFieldBuilder = this.themesBuilder_;
            if (repeatedFieldBuilder == null) {
                theme.getClass();
                ensureThemesIsMutable();
                this.themes_.set(i, theme);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, theme);
            return this;
        }

        public Builder setThemes(int i, Theme.Builder builder) {
            RepeatedFieldBuilder<Theme, Theme.Builder, ThemeOrBuilder> repeatedFieldBuilder = this.themesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureThemesIsMutable();
                this.themes_.set(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, builder.build());
            return this;
        }

        public Builder addThemes(Theme theme) {
            RepeatedFieldBuilder<Theme, Theme.Builder, ThemeOrBuilder> repeatedFieldBuilder = this.themesBuilder_;
            if (repeatedFieldBuilder == null) {
                theme.getClass();
                ensureThemesIsMutable();
                this.themes_.add(theme);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(theme);
            return this;
        }

        public Builder addThemes(int i, Theme theme) {
            RepeatedFieldBuilder<Theme, Theme.Builder, ThemeOrBuilder> repeatedFieldBuilder = this.themesBuilder_;
            if (repeatedFieldBuilder == null) {
                theme.getClass();
                ensureThemesIsMutable();
                this.themes_.add(i, theme);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, theme);
            return this;
        }

        public Builder addThemes(Theme.Builder builder) {
            RepeatedFieldBuilder<Theme, Theme.Builder, ThemeOrBuilder> repeatedFieldBuilder = this.themesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureThemesIsMutable();
                this.themes_.add(builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(builder.build());
            return this;
        }

        public Builder addThemes(int i, Theme.Builder builder) {
            RepeatedFieldBuilder<Theme, Theme.Builder, ThemeOrBuilder> repeatedFieldBuilder = this.themesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureThemesIsMutable();
                this.themes_.add(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, builder.build());
            return this;
        }

        public Builder addAllThemes(Iterable<? extends Theme> iterable) {
            RepeatedFieldBuilder<Theme, Theme.Builder, ThemeOrBuilder> repeatedFieldBuilder = this.themesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureThemesIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.themes_);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addAllMessages(iterable);
            return this;
        }

        public Builder clearThemes() {
            RepeatedFieldBuilder<Theme, Theme.Builder, ThemeOrBuilder> repeatedFieldBuilder = this.themesBuilder_;
            if (repeatedFieldBuilder == null) {
                this.themes_ = Collections.emptyList();
                this.bitField1_ &= -257;
                onChanged();
                return this;
            }
            repeatedFieldBuilder.clear();
            return this;
        }

        public Builder removeThemes(int i) {
            RepeatedFieldBuilder<Theme, Theme.Builder, ThemeOrBuilder> repeatedFieldBuilder = this.themesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureThemesIsMutable();
                this.themes_.remove(i);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.remove(i);
            return this;
        }

        public Theme.Builder getThemesBuilder(int i) {
            return (Theme.Builder) getThemesFieldBuilder().getBuilder(i);
        }

        @Override // proto.GameOrBuilder
        public ThemeOrBuilder getThemesOrBuilder(int i) {
            RepeatedFieldBuilder<Theme, Theme.Builder, ThemeOrBuilder> repeatedFieldBuilder = this.themesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.themes_.get(i);
            }
            return (ThemeOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(i);
        }

        @Override // proto.GameOrBuilder
        public List<? extends ThemeOrBuilder> getThemesOrBuilderList() {
            RepeatedFieldBuilder<Theme, Theme.Builder, ThemeOrBuilder> repeatedFieldBuilder = this.themesBuilder_;
            if (repeatedFieldBuilder != null) {
                return repeatedFieldBuilder.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.themes_);
        }

        public Theme.Builder addThemesBuilder() {
            return (Theme.Builder) getThemesFieldBuilder().addBuilder(Theme.getDefaultInstance());
        }

        public Theme.Builder addThemesBuilder(int i) {
            return (Theme.Builder) getThemesFieldBuilder().addBuilder(i, Theme.getDefaultInstance());
        }

        public List<Theme.Builder> getThemesBuilderList() {
            return getThemesFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilder<Theme, Theme.Builder, ThemeOrBuilder> getThemesFieldBuilder() {
            if (this.themesBuilder_ == null) {
                this.themesBuilder_ = new RepeatedFieldBuilder<>(this.themes_, (this.bitField1_ & 256) != 0, getParentForChildren(), isClean());
                this.themes_ = null;
            }
            return this.themesBuilder_;
        }

        @Override // proto.GameOrBuilder
        public double getTotalRating() {
            return this.totalRating_;
        }

        public Builder setTotalRating(double d) {
            this.totalRating_ = d;
            this.bitField1_ |= 512;
            onChanged();
            return this;
        }

        public Builder clearTotalRating() {
            this.bitField1_ &= -513;
            this.totalRating_ = 0.0d;
            onChanged();
            return this;
        }

        @Override // proto.GameOrBuilder
        public int getTotalRatingCount() {
            return this.totalRatingCount_;
        }

        public Builder setTotalRatingCount(int i) {
            this.totalRatingCount_ = i;
            this.bitField1_ |= 1024;
            onChanged();
            return this;
        }

        public Builder clearTotalRatingCount() {
            this.bitField1_ &= -1025;
            this.totalRatingCount_ = 0;
            onChanged();
            return this;
        }

        @Override // proto.GameOrBuilder
        public boolean hasUpdatedAt() {
            return (this.bitField1_ & 2048) != 0;
        }

        @Override // proto.GameOrBuilder
        public Timestamp getUpdatedAt() {
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.updatedAtBuilder_;
            if (singleFieldBuilder == null) {
                Timestamp timestamp = this.updatedAt_;
                return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
            }
            return (Timestamp) singleFieldBuilder.getMessage();
        }

        public Builder setUpdatedAt(Timestamp timestamp) {
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.updatedAtBuilder_;
            if (singleFieldBuilder == null) {
                timestamp.getClass();
                this.updatedAt_ = timestamp;
            } else {
                singleFieldBuilder.setMessage(timestamp);
            }
            this.bitField1_ |= 2048;
            onChanged();
            return this;
        }

        public Builder setUpdatedAt(Timestamp.Builder builder) {
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.updatedAtBuilder_;
            if (singleFieldBuilder == null) {
                this.updatedAt_ = builder.build();
            } else {
                singleFieldBuilder.setMessage(builder.build());
            }
            this.bitField1_ |= 2048;
            onChanged();
            return this;
        }

        public Builder mergeUpdatedAt(Timestamp timestamp) {
            Timestamp timestamp2;
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.updatedAtBuilder_;
            if (singleFieldBuilder == null) {
                if ((this.bitField1_ & 2048) != 0 && (timestamp2 = this.updatedAt_) != null && timestamp2 != Timestamp.getDefaultInstance()) {
                    getUpdatedAtBuilder().mergeFrom(timestamp);
                } else {
                    this.updatedAt_ = timestamp;
                }
            } else {
                singleFieldBuilder.mergeFrom(timestamp);
            }
            if (this.updatedAt_ != null) {
                this.bitField1_ |= 2048;
                onChanged();
            }
            return this;
        }

        public Builder clearUpdatedAt() {
            this.bitField1_ &= -2049;
            this.updatedAt_ = null;
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.updatedAtBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.updatedAtBuilder_ = null;
            }
            onChanged();
            return this;
        }

        public Timestamp.Builder getUpdatedAtBuilder() {
            this.bitField1_ |= 2048;
            onChanged();
            return (Timestamp.Builder) getUpdatedAtFieldBuilder().getBuilder();
        }

        @Override // proto.GameOrBuilder
        public TimestampOrBuilder getUpdatedAtOrBuilder() {
            SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> singleFieldBuilder = this.updatedAtBuilder_;
            if (singleFieldBuilder != null) {
                return (TimestampOrBuilder) singleFieldBuilder.getMessageOrBuilder();
            }
            Timestamp timestamp = this.updatedAt_;
            return timestamp == null ? Timestamp.getDefaultInstance() : timestamp;
        }

        private SingleFieldBuilder<Timestamp, Timestamp.Builder, TimestampOrBuilder> getUpdatedAtFieldBuilder() {
            if (this.updatedAtBuilder_ == null) {
                this.updatedAtBuilder_ = new SingleFieldBuilder<>(getUpdatedAt(), getParentForChildren(), isClean());
                this.updatedAt_ = null;
            }
            return this.updatedAtBuilder_;
        }

        @Override // proto.GameOrBuilder
        public String getUrl() {
            Object obj = this.url_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.url_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.GameOrBuilder
        public ByteString getUrlBytes() {
            Object obj = this.url_;
            if (obj instanceof String) {
                ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.url_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (ByteString) obj;
        }

        public Builder setUrl(String str) {
            str.getClass();
            this.url_ = str;
            this.bitField1_ |= 4096;
            onChanged();
            return this;
        }

        public Builder clearUrl() {
            this.url_ = Game.getDefaultInstance().getUrl();
            this.bitField1_ &= -4097;
            onChanged();
            return this;
        }

        public Builder setUrlBytes(ByteString byteString) {
            byteString.getClass();
            Game.checkByteStringIsUtf8(byteString);
            this.url_ = byteString;
            this.bitField1_ |= 4096;
            onChanged();
            return this;
        }

        @Override // proto.GameOrBuilder
        public boolean hasVersionParent() {
            return (this.bitField1_ & 8192) != 0;
        }

        @Override // proto.GameOrBuilder
        public Game getVersionParent() {
            SingleFieldBuilder<Game, Builder, GameOrBuilder> singleFieldBuilder = this.versionParentBuilder_;
            if (singleFieldBuilder == null) {
                Game game = this.versionParent_;
                return game == null ? Game.getDefaultInstance() : game;
            }
            return (Game) singleFieldBuilder.getMessage();
        }

        public Builder setVersionParent(Game game) {
            SingleFieldBuilder<Game, Builder, GameOrBuilder> singleFieldBuilder = this.versionParentBuilder_;
            if (singleFieldBuilder == null) {
                game.getClass();
                this.versionParent_ = game;
            } else {
                singleFieldBuilder.setMessage(game);
            }
            this.bitField1_ |= 8192;
            onChanged();
            return this;
        }

        public Builder setVersionParent(Builder builder) {
            SingleFieldBuilder<Game, Builder, GameOrBuilder> singleFieldBuilder = this.versionParentBuilder_;
            if (singleFieldBuilder == null) {
                this.versionParent_ = builder.build();
            } else {
                singleFieldBuilder.setMessage(builder.build());
            }
            this.bitField1_ |= 8192;
            onChanged();
            return this;
        }

        public Builder mergeVersionParent(Game game) {
            Game game2;
            SingleFieldBuilder<Game, Builder, GameOrBuilder> singleFieldBuilder = this.versionParentBuilder_;
            if (singleFieldBuilder == null) {
                if ((this.bitField1_ & 8192) != 0 && (game2 = this.versionParent_) != null && game2 != Game.getDefaultInstance()) {
                    getVersionParentBuilder().mergeFrom((Message) game);
                } else {
                    this.versionParent_ = game;
                }
            } else {
                singleFieldBuilder.mergeFrom(game);
            }
            if (this.versionParent_ != null) {
                this.bitField1_ |= 8192;
                onChanged();
            }
            return this;
        }

        public Builder clearVersionParent() {
            this.bitField1_ &= -8193;
            this.versionParent_ = null;
            SingleFieldBuilder<Game, Builder, GameOrBuilder> singleFieldBuilder = this.versionParentBuilder_;
            if (singleFieldBuilder != null) {
                singleFieldBuilder.dispose();
                this.versionParentBuilder_ = null;
            }
            onChanged();
            return this;
        }

        public Builder getVersionParentBuilder() {
            this.bitField1_ |= 8192;
            onChanged();
            return (Builder) getVersionParentFieldBuilder().getBuilder();
        }

        @Override // proto.GameOrBuilder
        public GameOrBuilder getVersionParentOrBuilder() {
            SingleFieldBuilder<Game, Builder, GameOrBuilder> singleFieldBuilder = this.versionParentBuilder_;
            if (singleFieldBuilder != null) {
                return (GameOrBuilder) singleFieldBuilder.getMessageOrBuilder();
            }
            Game game = this.versionParent_;
            return game == null ? Game.getDefaultInstance() : game;
        }

        private SingleFieldBuilder<Game, Builder, GameOrBuilder> getVersionParentFieldBuilder() {
            if (this.versionParentBuilder_ == null) {
                this.versionParentBuilder_ = new SingleFieldBuilder<>(getVersionParent(), getParentForChildren(), isClean());
                this.versionParent_ = null;
            }
            return this.versionParentBuilder_;
        }

        @Override // proto.GameOrBuilder
        public String getVersionTitle() {
            Object obj = this.versionTitle_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.versionTitle_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.GameOrBuilder
        public ByteString getVersionTitleBytes() {
            Object obj = this.versionTitle_;
            if (obj instanceof String) {
                ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.versionTitle_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (ByteString) obj;
        }

        public Builder setVersionTitle(String str) {
            str.getClass();
            this.versionTitle_ = str;
            this.bitField1_ |= 16384;
            onChanged();
            return this;
        }

        public Builder clearVersionTitle() {
            this.versionTitle_ = Game.getDefaultInstance().getVersionTitle();
            this.bitField1_ &= -16385;
            onChanged();
            return this;
        }

        public Builder setVersionTitleBytes(ByteString byteString) {
            byteString.getClass();
            Game.checkByteStringIsUtf8(byteString);
            this.versionTitle_ = byteString;
            this.bitField1_ |= 16384;
            onChanged();
            return this;
        }

        private void ensureVideosIsMutable() {
            if ((this.bitField1_ & 32768) == 0) {
                this.videos_ = new ArrayList(this.videos_);
                this.bitField1_ |= 32768;
            }
        }

        @Override // proto.GameOrBuilder
        public List<GameVideo> getVideosList() {
            RepeatedFieldBuilder<GameVideo, GameVideo.Builder, GameVideoOrBuilder> repeatedFieldBuilder = this.videosBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.videos_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // proto.GameOrBuilder
        public int getVideosCount() {
            RepeatedFieldBuilder<GameVideo, GameVideo.Builder, GameVideoOrBuilder> repeatedFieldBuilder = this.videosBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.videos_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // proto.GameOrBuilder
        public GameVideo getVideos(int i) {
            RepeatedFieldBuilder<GameVideo, GameVideo.Builder, GameVideoOrBuilder> repeatedFieldBuilder = this.videosBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.videos_.get(i);
            }
            return (GameVideo) repeatedFieldBuilder.getMessage(i);
        }

        public Builder setVideos(int i, GameVideo gameVideo) {
            RepeatedFieldBuilder<GameVideo, GameVideo.Builder, GameVideoOrBuilder> repeatedFieldBuilder = this.videosBuilder_;
            if (repeatedFieldBuilder == null) {
                gameVideo.getClass();
                ensureVideosIsMutable();
                this.videos_.set(i, gameVideo);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, gameVideo);
            return this;
        }

        public Builder setVideos(int i, GameVideo.Builder builder) {
            RepeatedFieldBuilder<GameVideo, GameVideo.Builder, GameVideoOrBuilder> repeatedFieldBuilder = this.videosBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureVideosIsMutable();
                this.videos_.set(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, builder.build());
            return this;
        }

        public Builder addVideos(GameVideo gameVideo) {
            RepeatedFieldBuilder<GameVideo, GameVideo.Builder, GameVideoOrBuilder> repeatedFieldBuilder = this.videosBuilder_;
            if (repeatedFieldBuilder == null) {
                gameVideo.getClass();
                ensureVideosIsMutable();
                this.videos_.add(gameVideo);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(gameVideo);
            return this;
        }

        public Builder addVideos(int i, GameVideo gameVideo) {
            RepeatedFieldBuilder<GameVideo, GameVideo.Builder, GameVideoOrBuilder> repeatedFieldBuilder = this.videosBuilder_;
            if (repeatedFieldBuilder == null) {
                gameVideo.getClass();
                ensureVideosIsMutable();
                this.videos_.add(i, gameVideo);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, gameVideo);
            return this;
        }

        public Builder addVideos(GameVideo.Builder builder) {
            RepeatedFieldBuilder<GameVideo, GameVideo.Builder, GameVideoOrBuilder> repeatedFieldBuilder = this.videosBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureVideosIsMutable();
                this.videos_.add(builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(builder.build());
            return this;
        }

        public Builder addVideos(int i, GameVideo.Builder builder) {
            RepeatedFieldBuilder<GameVideo, GameVideo.Builder, GameVideoOrBuilder> repeatedFieldBuilder = this.videosBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureVideosIsMutable();
                this.videos_.add(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, builder.build());
            return this;
        }

        public Builder addAllVideos(Iterable<? extends GameVideo> iterable) {
            RepeatedFieldBuilder<GameVideo, GameVideo.Builder, GameVideoOrBuilder> repeatedFieldBuilder = this.videosBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureVideosIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.videos_);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addAllMessages(iterable);
            return this;
        }

        public Builder clearVideos() {
            RepeatedFieldBuilder<GameVideo, GameVideo.Builder, GameVideoOrBuilder> repeatedFieldBuilder = this.videosBuilder_;
            if (repeatedFieldBuilder == null) {
                this.videos_ = Collections.emptyList();
                this.bitField1_ &= -32769;
                onChanged();
                return this;
            }
            repeatedFieldBuilder.clear();
            return this;
        }

        public Builder removeVideos(int i) {
            RepeatedFieldBuilder<GameVideo, GameVideo.Builder, GameVideoOrBuilder> repeatedFieldBuilder = this.videosBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureVideosIsMutable();
                this.videos_.remove(i);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.remove(i);
            return this;
        }

        public GameVideo.Builder getVideosBuilder(int i) {
            return (GameVideo.Builder) getVideosFieldBuilder().getBuilder(i);
        }

        @Override // proto.GameOrBuilder
        public GameVideoOrBuilder getVideosOrBuilder(int i) {
            RepeatedFieldBuilder<GameVideo, GameVideo.Builder, GameVideoOrBuilder> repeatedFieldBuilder = this.videosBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.videos_.get(i);
            }
            return (GameVideoOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(i);
        }

        @Override // proto.GameOrBuilder
        public List<? extends GameVideoOrBuilder> getVideosOrBuilderList() {
            RepeatedFieldBuilder<GameVideo, GameVideo.Builder, GameVideoOrBuilder> repeatedFieldBuilder = this.videosBuilder_;
            if (repeatedFieldBuilder != null) {
                return repeatedFieldBuilder.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.videos_);
        }

        public GameVideo.Builder addVideosBuilder() {
            return (GameVideo.Builder) getVideosFieldBuilder().addBuilder(GameVideo.getDefaultInstance());
        }

        public GameVideo.Builder addVideosBuilder(int i) {
            return (GameVideo.Builder) getVideosFieldBuilder().addBuilder(i, GameVideo.getDefaultInstance());
        }

        public List<GameVideo.Builder> getVideosBuilderList() {
            return getVideosFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilder<GameVideo, GameVideo.Builder, GameVideoOrBuilder> getVideosFieldBuilder() {
            if (this.videosBuilder_ == null) {
                this.videosBuilder_ = new RepeatedFieldBuilder<>(this.videos_, (this.bitField1_ & 32768) != 0, getParentForChildren(), isClean());
                this.videos_ = null;
            }
            return this.videosBuilder_;
        }

        private void ensureWebsitesIsMutable() {
            if ((this.bitField1_ & 65536) == 0) {
                this.websites_ = new ArrayList(this.websites_);
                this.bitField1_ |= 65536;
            }
        }

        @Override // proto.GameOrBuilder
        public List<Website> getWebsitesList() {
            RepeatedFieldBuilder<Website, Website.Builder, WebsiteOrBuilder> repeatedFieldBuilder = this.websitesBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.websites_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // proto.GameOrBuilder
        public int getWebsitesCount() {
            RepeatedFieldBuilder<Website, Website.Builder, WebsiteOrBuilder> repeatedFieldBuilder = this.websitesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.websites_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // proto.GameOrBuilder
        public Website getWebsites(int i) {
            RepeatedFieldBuilder<Website, Website.Builder, WebsiteOrBuilder> repeatedFieldBuilder = this.websitesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.websites_.get(i);
            }
            return (Website) repeatedFieldBuilder.getMessage(i);
        }

        public Builder setWebsites(int i, Website website) {
            RepeatedFieldBuilder<Website, Website.Builder, WebsiteOrBuilder> repeatedFieldBuilder = this.websitesBuilder_;
            if (repeatedFieldBuilder == null) {
                website.getClass();
                ensureWebsitesIsMutable();
                this.websites_.set(i, website);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, website);
            return this;
        }

        public Builder setWebsites(int i, Website.Builder builder) {
            RepeatedFieldBuilder<Website, Website.Builder, WebsiteOrBuilder> repeatedFieldBuilder = this.websitesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureWebsitesIsMutable();
                this.websites_.set(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, builder.build());
            return this;
        }

        public Builder addWebsites(Website website) {
            RepeatedFieldBuilder<Website, Website.Builder, WebsiteOrBuilder> repeatedFieldBuilder = this.websitesBuilder_;
            if (repeatedFieldBuilder == null) {
                website.getClass();
                ensureWebsitesIsMutable();
                this.websites_.add(website);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(website);
            return this;
        }

        public Builder addWebsites(int i, Website website) {
            RepeatedFieldBuilder<Website, Website.Builder, WebsiteOrBuilder> repeatedFieldBuilder = this.websitesBuilder_;
            if (repeatedFieldBuilder == null) {
                website.getClass();
                ensureWebsitesIsMutable();
                this.websites_.add(i, website);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, website);
            return this;
        }

        public Builder addWebsites(Website.Builder builder) {
            RepeatedFieldBuilder<Website, Website.Builder, WebsiteOrBuilder> repeatedFieldBuilder = this.websitesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureWebsitesIsMutable();
                this.websites_.add(builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(builder.build());
            return this;
        }

        public Builder addWebsites(int i, Website.Builder builder) {
            RepeatedFieldBuilder<Website, Website.Builder, WebsiteOrBuilder> repeatedFieldBuilder = this.websitesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureWebsitesIsMutable();
                this.websites_.add(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, builder.build());
            return this;
        }

        public Builder addAllWebsites(Iterable<? extends Website> iterable) {
            RepeatedFieldBuilder<Website, Website.Builder, WebsiteOrBuilder> repeatedFieldBuilder = this.websitesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureWebsitesIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.websites_);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addAllMessages(iterable);
            return this;
        }

        public Builder clearWebsites() {
            RepeatedFieldBuilder<Website, Website.Builder, WebsiteOrBuilder> repeatedFieldBuilder = this.websitesBuilder_;
            if (repeatedFieldBuilder == null) {
                this.websites_ = Collections.emptyList();
                this.bitField1_ &= -65537;
                onChanged();
                return this;
            }
            repeatedFieldBuilder.clear();
            return this;
        }

        public Builder removeWebsites(int i) {
            RepeatedFieldBuilder<Website, Website.Builder, WebsiteOrBuilder> repeatedFieldBuilder = this.websitesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureWebsitesIsMutable();
                this.websites_.remove(i);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.remove(i);
            return this;
        }

        public Website.Builder getWebsitesBuilder(int i) {
            return (Website.Builder) getWebsitesFieldBuilder().getBuilder(i);
        }

        @Override // proto.GameOrBuilder
        public WebsiteOrBuilder getWebsitesOrBuilder(int i) {
            RepeatedFieldBuilder<Website, Website.Builder, WebsiteOrBuilder> repeatedFieldBuilder = this.websitesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.websites_.get(i);
            }
            return (WebsiteOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(i);
        }

        @Override // proto.GameOrBuilder
        public List<? extends WebsiteOrBuilder> getWebsitesOrBuilderList() {
            RepeatedFieldBuilder<Website, Website.Builder, WebsiteOrBuilder> repeatedFieldBuilder = this.websitesBuilder_;
            if (repeatedFieldBuilder != null) {
                return repeatedFieldBuilder.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.websites_);
        }

        public Website.Builder addWebsitesBuilder() {
            return (Website.Builder) getWebsitesFieldBuilder().addBuilder(Website.getDefaultInstance());
        }

        public Website.Builder addWebsitesBuilder(int i) {
            return (Website.Builder) getWebsitesFieldBuilder().addBuilder(i, Website.getDefaultInstance());
        }

        public List<Website.Builder> getWebsitesBuilderList() {
            return getWebsitesFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilder<Website, Website.Builder, WebsiteOrBuilder> getWebsitesFieldBuilder() {
            if (this.websitesBuilder_ == null) {
                this.websitesBuilder_ = new RepeatedFieldBuilder<>(this.websites_, (this.bitField1_ & 65536) != 0, getParentForChildren(), isClean());
                this.websites_ = null;
            }
            return this.websitesBuilder_;
        }

        @Override // proto.GameOrBuilder
        public String getChecksum() {
            Object obj = this.checksum_;
            if (!(obj instanceof String)) {
                String stringUtf8 = ((ByteString) obj).toStringUtf8();
                this.checksum_ = stringUtf8;
                return stringUtf8;
            }
            return (String) obj;
        }

        @Override // proto.GameOrBuilder
        public ByteString getChecksumBytes() {
            Object obj = this.checksum_;
            if (obj instanceof String) {
                ByteString byteStringCopyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.checksum_ = byteStringCopyFromUtf8;
                return byteStringCopyFromUtf8;
            }
            return (ByteString) obj;
        }

        public Builder setChecksum(String str) {
            str.getClass();
            this.checksum_ = str;
            this.bitField1_ |= 131072;
            onChanged();
            return this;
        }

        public Builder clearChecksum() {
            this.checksum_ = Game.getDefaultInstance().getChecksum();
            this.bitField1_ &= -131073;
            onChanged();
            return this;
        }

        public Builder setChecksumBytes(ByteString byteString) {
            byteString.getClass();
            Game.checkByteStringIsUtf8(byteString);
            this.checksum_ = byteString;
            this.bitField1_ |= 131072;
            onChanged();
            return this;
        }

        private void ensureRemakesIsMutable() {
            if ((this.bitField1_ & 262144) == 0) {
                this.remakes_ = new ArrayList(this.remakes_);
                this.bitField1_ |= 262144;
            }
        }

        @Override // proto.GameOrBuilder
        public List<Game> getRemakesList() {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.remakesBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.remakes_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // proto.GameOrBuilder
        public int getRemakesCount() {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.remakesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.remakes_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // proto.GameOrBuilder
        public Game getRemakes(int i) {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.remakesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.remakes_.get(i);
            }
            return (Game) repeatedFieldBuilder.getMessage(i);
        }

        public Builder setRemakes(int i, Game game) {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.remakesBuilder_;
            if (repeatedFieldBuilder == null) {
                game.getClass();
                ensureRemakesIsMutable();
                this.remakes_.set(i, game);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, game);
            return this;
        }

        public Builder setRemakes(int i, Builder builder) {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.remakesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureRemakesIsMutable();
                this.remakes_.set(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, builder.build());
            return this;
        }

        public Builder addRemakes(Game game) {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.remakesBuilder_;
            if (repeatedFieldBuilder == null) {
                game.getClass();
                ensureRemakesIsMutable();
                this.remakes_.add(game);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(game);
            return this;
        }

        public Builder addRemakes(int i, Game game) {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.remakesBuilder_;
            if (repeatedFieldBuilder == null) {
                game.getClass();
                ensureRemakesIsMutable();
                this.remakes_.add(i, game);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, game);
            return this;
        }

        public Builder addRemakes(Builder builder) {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.remakesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureRemakesIsMutable();
                this.remakes_.add(builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(builder.build());
            return this;
        }

        public Builder addRemakes(int i, Builder builder) {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.remakesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureRemakesIsMutable();
                this.remakes_.add(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, builder.build());
            return this;
        }

        public Builder addAllRemakes(Iterable<? extends Game> iterable) {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.remakesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureRemakesIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.remakes_);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addAllMessages(iterable);
            return this;
        }

        public Builder clearRemakes() {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.remakesBuilder_;
            if (repeatedFieldBuilder == null) {
                this.remakes_ = Collections.emptyList();
                this.bitField1_ &= -262145;
                onChanged();
                return this;
            }
            repeatedFieldBuilder.clear();
            return this;
        }

        public Builder removeRemakes(int i) {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.remakesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureRemakesIsMutable();
                this.remakes_.remove(i);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.remove(i);
            return this;
        }

        public Builder getRemakesBuilder(int i) {
            return (Builder) getRemakesFieldBuilder().getBuilder(i);
        }

        @Override // proto.GameOrBuilder
        public GameOrBuilder getRemakesOrBuilder(int i) {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.remakesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.remakes_.get(i);
            }
            return (GameOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(i);
        }

        @Override // proto.GameOrBuilder
        public List<? extends GameOrBuilder> getRemakesOrBuilderList() {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.remakesBuilder_;
            if (repeatedFieldBuilder != null) {
                return repeatedFieldBuilder.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.remakes_);
        }

        public Builder addRemakesBuilder() {
            return (Builder) getRemakesFieldBuilder().addBuilder(Game.getDefaultInstance());
        }

        public Builder addRemakesBuilder(int i) {
            return (Builder) getRemakesFieldBuilder().addBuilder(i, Game.getDefaultInstance());
        }

        public List<Builder> getRemakesBuilderList() {
            return getRemakesFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilder<Game, Builder, GameOrBuilder> getRemakesFieldBuilder() {
            if (this.remakesBuilder_ == null) {
                this.remakesBuilder_ = new RepeatedFieldBuilder<>(this.remakes_, (this.bitField1_ & 262144) != 0, getParentForChildren(), isClean());
                this.remakes_ = null;
            }
            return this.remakesBuilder_;
        }

        private void ensureRemastersIsMutable() {
            if ((this.bitField1_ & 524288) == 0) {
                this.remasters_ = new ArrayList(this.remasters_);
                this.bitField1_ |= 524288;
            }
        }

        @Override // proto.GameOrBuilder
        public List<Game> getRemastersList() {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.remastersBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.remasters_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // proto.GameOrBuilder
        public int getRemastersCount() {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.remastersBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.remasters_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // proto.GameOrBuilder
        public Game getRemasters(int i) {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.remastersBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.remasters_.get(i);
            }
            return (Game) repeatedFieldBuilder.getMessage(i);
        }

        public Builder setRemasters(int i, Game game) {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.remastersBuilder_;
            if (repeatedFieldBuilder == null) {
                game.getClass();
                ensureRemastersIsMutable();
                this.remasters_.set(i, game);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, game);
            return this;
        }

        public Builder setRemasters(int i, Builder builder) {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.remastersBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureRemastersIsMutable();
                this.remasters_.set(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, builder.build());
            return this;
        }

        public Builder addRemasters(Game game) {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.remastersBuilder_;
            if (repeatedFieldBuilder == null) {
                game.getClass();
                ensureRemastersIsMutable();
                this.remasters_.add(game);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(game);
            return this;
        }

        public Builder addRemasters(int i, Game game) {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.remastersBuilder_;
            if (repeatedFieldBuilder == null) {
                game.getClass();
                ensureRemastersIsMutable();
                this.remasters_.add(i, game);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, game);
            return this;
        }

        public Builder addRemasters(Builder builder) {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.remastersBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureRemastersIsMutable();
                this.remasters_.add(builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(builder.build());
            return this;
        }

        public Builder addRemasters(int i, Builder builder) {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.remastersBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureRemastersIsMutable();
                this.remasters_.add(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, builder.build());
            return this;
        }

        public Builder addAllRemasters(Iterable<? extends Game> iterable) {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.remastersBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureRemastersIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.remasters_);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addAllMessages(iterable);
            return this;
        }

        public Builder clearRemasters() {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.remastersBuilder_;
            if (repeatedFieldBuilder == null) {
                this.remasters_ = Collections.emptyList();
                this.bitField1_ &= -524289;
                onChanged();
                return this;
            }
            repeatedFieldBuilder.clear();
            return this;
        }

        public Builder removeRemasters(int i) {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.remastersBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureRemastersIsMutable();
                this.remasters_.remove(i);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.remove(i);
            return this;
        }

        public Builder getRemastersBuilder(int i) {
            return (Builder) getRemastersFieldBuilder().getBuilder(i);
        }

        @Override // proto.GameOrBuilder
        public GameOrBuilder getRemastersOrBuilder(int i) {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.remastersBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.remasters_.get(i);
            }
            return (GameOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(i);
        }

        @Override // proto.GameOrBuilder
        public List<? extends GameOrBuilder> getRemastersOrBuilderList() {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.remastersBuilder_;
            if (repeatedFieldBuilder != null) {
                return repeatedFieldBuilder.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.remasters_);
        }

        public Builder addRemastersBuilder() {
            return (Builder) getRemastersFieldBuilder().addBuilder(Game.getDefaultInstance());
        }

        public Builder addRemastersBuilder(int i) {
            return (Builder) getRemastersFieldBuilder().addBuilder(i, Game.getDefaultInstance());
        }

        public List<Builder> getRemastersBuilderList() {
            return getRemastersFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilder<Game, Builder, GameOrBuilder> getRemastersFieldBuilder() {
            if (this.remastersBuilder_ == null) {
                this.remastersBuilder_ = new RepeatedFieldBuilder<>(this.remasters_, (this.bitField1_ & 524288) != 0, getParentForChildren(), isClean());
                this.remasters_ = null;
            }
            return this.remastersBuilder_;
        }

        private void ensureExpandedGamesIsMutable() {
            if ((this.bitField1_ & 1048576) == 0) {
                this.expandedGames_ = new ArrayList(this.expandedGames_);
                this.bitField1_ |= 1048576;
            }
        }

        @Override // proto.GameOrBuilder
        public List<Game> getExpandedGamesList() {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.expandedGamesBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.expandedGames_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // proto.GameOrBuilder
        public int getExpandedGamesCount() {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.expandedGamesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.expandedGames_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // proto.GameOrBuilder
        public Game getExpandedGames(int i) {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.expandedGamesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.expandedGames_.get(i);
            }
            return (Game) repeatedFieldBuilder.getMessage(i);
        }

        public Builder setExpandedGames(int i, Game game) {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.expandedGamesBuilder_;
            if (repeatedFieldBuilder == null) {
                game.getClass();
                ensureExpandedGamesIsMutable();
                this.expandedGames_.set(i, game);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, game);
            return this;
        }

        public Builder setExpandedGames(int i, Builder builder) {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.expandedGamesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureExpandedGamesIsMutable();
                this.expandedGames_.set(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, builder.build());
            return this;
        }

        public Builder addExpandedGames(Game game) {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.expandedGamesBuilder_;
            if (repeatedFieldBuilder == null) {
                game.getClass();
                ensureExpandedGamesIsMutable();
                this.expandedGames_.add(game);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(game);
            return this;
        }

        public Builder addExpandedGames(int i, Game game) {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.expandedGamesBuilder_;
            if (repeatedFieldBuilder == null) {
                game.getClass();
                ensureExpandedGamesIsMutable();
                this.expandedGames_.add(i, game);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, game);
            return this;
        }

        public Builder addExpandedGames(Builder builder) {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.expandedGamesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureExpandedGamesIsMutable();
                this.expandedGames_.add(builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(builder.build());
            return this;
        }

        public Builder addExpandedGames(int i, Builder builder) {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.expandedGamesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureExpandedGamesIsMutable();
                this.expandedGames_.add(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, builder.build());
            return this;
        }

        public Builder addAllExpandedGames(Iterable<? extends Game> iterable) {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.expandedGamesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureExpandedGamesIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.expandedGames_);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addAllMessages(iterable);
            return this;
        }

        public Builder clearExpandedGames() {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.expandedGamesBuilder_;
            if (repeatedFieldBuilder == null) {
                this.expandedGames_ = Collections.emptyList();
                this.bitField1_ &= -1048577;
                onChanged();
                return this;
            }
            repeatedFieldBuilder.clear();
            return this;
        }

        public Builder removeExpandedGames(int i) {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.expandedGamesBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureExpandedGamesIsMutable();
                this.expandedGames_.remove(i);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.remove(i);
            return this;
        }

        public Builder getExpandedGamesBuilder(int i) {
            return (Builder) getExpandedGamesFieldBuilder().getBuilder(i);
        }

        @Override // proto.GameOrBuilder
        public GameOrBuilder getExpandedGamesOrBuilder(int i) {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.expandedGamesBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.expandedGames_.get(i);
            }
            return (GameOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(i);
        }

        @Override // proto.GameOrBuilder
        public List<? extends GameOrBuilder> getExpandedGamesOrBuilderList() {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.expandedGamesBuilder_;
            if (repeatedFieldBuilder != null) {
                return repeatedFieldBuilder.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.expandedGames_);
        }

        public Builder addExpandedGamesBuilder() {
            return (Builder) getExpandedGamesFieldBuilder().addBuilder(Game.getDefaultInstance());
        }

        public Builder addExpandedGamesBuilder(int i) {
            return (Builder) getExpandedGamesFieldBuilder().addBuilder(i, Game.getDefaultInstance());
        }

        public List<Builder> getExpandedGamesBuilderList() {
            return getExpandedGamesFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilder<Game, Builder, GameOrBuilder> getExpandedGamesFieldBuilder() {
            if (this.expandedGamesBuilder_ == null) {
                this.expandedGamesBuilder_ = new RepeatedFieldBuilder<>(this.expandedGames_, (this.bitField1_ & 1048576) != 0, getParentForChildren(), isClean());
                this.expandedGames_ = null;
            }
            return this.expandedGamesBuilder_;
        }

        private void ensurePortsIsMutable() {
            if ((this.bitField1_ & 2097152) == 0) {
                this.ports_ = new ArrayList(this.ports_);
                this.bitField1_ |= 2097152;
            }
        }

        @Override // proto.GameOrBuilder
        public List<Game> getPortsList() {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.portsBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.ports_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // proto.GameOrBuilder
        public int getPortsCount() {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.portsBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.ports_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // proto.GameOrBuilder
        public Game getPorts(int i) {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.portsBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.ports_.get(i);
            }
            return (Game) repeatedFieldBuilder.getMessage(i);
        }

        public Builder setPorts(int i, Game game) {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.portsBuilder_;
            if (repeatedFieldBuilder == null) {
                game.getClass();
                ensurePortsIsMutable();
                this.ports_.set(i, game);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, game);
            return this;
        }

        public Builder setPorts(int i, Builder builder) {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.portsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensurePortsIsMutable();
                this.ports_.set(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, builder.build());
            return this;
        }

        public Builder addPorts(Game game) {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.portsBuilder_;
            if (repeatedFieldBuilder == null) {
                game.getClass();
                ensurePortsIsMutable();
                this.ports_.add(game);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(game);
            return this;
        }

        public Builder addPorts(int i, Game game) {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.portsBuilder_;
            if (repeatedFieldBuilder == null) {
                game.getClass();
                ensurePortsIsMutable();
                this.ports_.add(i, game);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, game);
            return this;
        }

        public Builder addPorts(Builder builder) {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.portsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensurePortsIsMutable();
                this.ports_.add(builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(builder.build());
            return this;
        }

        public Builder addPorts(int i, Builder builder) {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.portsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensurePortsIsMutable();
                this.ports_.add(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, builder.build());
            return this;
        }

        public Builder addAllPorts(Iterable<? extends Game> iterable) {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.portsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensurePortsIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.ports_);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addAllMessages(iterable);
            return this;
        }

        public Builder clearPorts() {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.portsBuilder_;
            if (repeatedFieldBuilder == null) {
                this.ports_ = Collections.emptyList();
                this.bitField1_ &= -2097153;
                onChanged();
                return this;
            }
            repeatedFieldBuilder.clear();
            return this;
        }

        public Builder removePorts(int i) {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.portsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensurePortsIsMutable();
                this.ports_.remove(i);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.remove(i);
            return this;
        }

        public Builder getPortsBuilder(int i) {
            return (Builder) getPortsFieldBuilder().getBuilder(i);
        }

        @Override // proto.GameOrBuilder
        public GameOrBuilder getPortsOrBuilder(int i) {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.portsBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.ports_.get(i);
            }
            return (GameOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(i);
        }

        @Override // proto.GameOrBuilder
        public List<? extends GameOrBuilder> getPortsOrBuilderList() {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.portsBuilder_;
            if (repeatedFieldBuilder != null) {
                return repeatedFieldBuilder.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.ports_);
        }

        public Builder addPortsBuilder() {
            return (Builder) getPortsFieldBuilder().addBuilder(Game.getDefaultInstance());
        }

        public Builder addPortsBuilder(int i) {
            return (Builder) getPortsFieldBuilder().addBuilder(i, Game.getDefaultInstance());
        }

        public List<Builder> getPortsBuilderList() {
            return getPortsFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilder<Game, Builder, GameOrBuilder> getPortsFieldBuilder() {
            if (this.portsBuilder_ == null) {
                this.portsBuilder_ = new RepeatedFieldBuilder<>(this.ports_, (this.bitField1_ & 2097152) != 0, getParentForChildren(), isClean());
                this.ports_ = null;
            }
            return this.portsBuilder_;
        }

        private void ensureForksIsMutable() {
            if ((this.bitField1_ & 4194304) == 0) {
                this.forks_ = new ArrayList(this.forks_);
                this.bitField1_ |= 4194304;
            }
        }

        @Override // proto.GameOrBuilder
        public List<Game> getForksList() {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.forksBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.forks_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // proto.GameOrBuilder
        public int getForksCount() {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.forksBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.forks_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // proto.GameOrBuilder
        public Game getForks(int i) {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.forksBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.forks_.get(i);
            }
            return (Game) repeatedFieldBuilder.getMessage(i);
        }

        public Builder setForks(int i, Game game) {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.forksBuilder_;
            if (repeatedFieldBuilder == null) {
                game.getClass();
                ensureForksIsMutable();
                this.forks_.set(i, game);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, game);
            return this;
        }

        public Builder setForks(int i, Builder builder) {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.forksBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureForksIsMutable();
                this.forks_.set(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, builder.build());
            return this;
        }

        public Builder addForks(Game game) {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.forksBuilder_;
            if (repeatedFieldBuilder == null) {
                game.getClass();
                ensureForksIsMutable();
                this.forks_.add(game);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(game);
            return this;
        }

        public Builder addForks(int i, Game game) {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.forksBuilder_;
            if (repeatedFieldBuilder == null) {
                game.getClass();
                ensureForksIsMutable();
                this.forks_.add(i, game);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, game);
            return this;
        }

        public Builder addForks(Builder builder) {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.forksBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureForksIsMutable();
                this.forks_.add(builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(builder.build());
            return this;
        }

        public Builder addForks(int i, Builder builder) {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.forksBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureForksIsMutable();
                this.forks_.add(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, builder.build());
            return this;
        }

        public Builder addAllForks(Iterable<? extends Game> iterable) {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.forksBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureForksIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.forks_);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addAllMessages(iterable);
            return this;
        }

        public Builder clearForks() {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.forksBuilder_;
            if (repeatedFieldBuilder == null) {
                this.forks_ = Collections.emptyList();
                this.bitField1_ &= -4194305;
                onChanged();
                return this;
            }
            repeatedFieldBuilder.clear();
            return this;
        }

        public Builder removeForks(int i) {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.forksBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureForksIsMutable();
                this.forks_.remove(i);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.remove(i);
            return this;
        }

        public Builder getForksBuilder(int i) {
            return (Builder) getForksFieldBuilder().getBuilder(i);
        }

        @Override // proto.GameOrBuilder
        public GameOrBuilder getForksOrBuilder(int i) {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.forksBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.forks_.get(i);
            }
            return (GameOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(i);
        }

        @Override // proto.GameOrBuilder
        public List<? extends GameOrBuilder> getForksOrBuilderList() {
            RepeatedFieldBuilder<Game, Builder, GameOrBuilder> repeatedFieldBuilder = this.forksBuilder_;
            if (repeatedFieldBuilder != null) {
                return repeatedFieldBuilder.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.forks_);
        }

        public Builder addForksBuilder() {
            return (Builder) getForksFieldBuilder().addBuilder(Game.getDefaultInstance());
        }

        public Builder addForksBuilder(int i) {
            return (Builder) getForksFieldBuilder().addBuilder(i, Game.getDefaultInstance());
        }

        public List<Builder> getForksBuilderList() {
            return getForksFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilder<Game, Builder, GameOrBuilder> getForksFieldBuilder() {
            if (this.forksBuilder_ == null) {
                this.forksBuilder_ = new RepeatedFieldBuilder<>(this.forks_, (this.bitField1_ & 4194304) != 0, getParentForChildren(), isClean());
                this.forks_ = null;
            }
            return this.forksBuilder_;
        }

        private void ensureLanguageSupportsIsMutable() {
            if ((this.bitField1_ & 8388608) == 0) {
                this.languageSupports_ = new ArrayList(this.languageSupports_);
                this.bitField1_ |= 8388608;
            }
        }

        @Override // proto.GameOrBuilder
        public List<LanguageSupport> getLanguageSupportsList() {
            RepeatedFieldBuilder<LanguageSupport, LanguageSupport.Builder, LanguageSupportOrBuilder> repeatedFieldBuilder = this.languageSupportsBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.languageSupports_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // proto.GameOrBuilder
        public int getLanguageSupportsCount() {
            RepeatedFieldBuilder<LanguageSupport, LanguageSupport.Builder, LanguageSupportOrBuilder> repeatedFieldBuilder = this.languageSupportsBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.languageSupports_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // proto.GameOrBuilder
        public LanguageSupport getLanguageSupports(int i) {
            RepeatedFieldBuilder<LanguageSupport, LanguageSupport.Builder, LanguageSupportOrBuilder> repeatedFieldBuilder = this.languageSupportsBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.languageSupports_.get(i);
            }
            return (LanguageSupport) repeatedFieldBuilder.getMessage(i);
        }

        public Builder setLanguageSupports(int i, LanguageSupport languageSupport) {
            RepeatedFieldBuilder<LanguageSupport, LanguageSupport.Builder, LanguageSupportOrBuilder> repeatedFieldBuilder = this.languageSupportsBuilder_;
            if (repeatedFieldBuilder == null) {
                languageSupport.getClass();
                ensureLanguageSupportsIsMutable();
                this.languageSupports_.set(i, languageSupport);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, languageSupport);
            return this;
        }

        public Builder setLanguageSupports(int i, LanguageSupport.Builder builder) {
            RepeatedFieldBuilder<LanguageSupport, LanguageSupport.Builder, LanguageSupportOrBuilder> repeatedFieldBuilder = this.languageSupportsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureLanguageSupportsIsMutable();
                this.languageSupports_.set(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, builder.build());
            return this;
        }

        public Builder addLanguageSupports(LanguageSupport languageSupport) {
            RepeatedFieldBuilder<LanguageSupport, LanguageSupport.Builder, LanguageSupportOrBuilder> repeatedFieldBuilder = this.languageSupportsBuilder_;
            if (repeatedFieldBuilder == null) {
                languageSupport.getClass();
                ensureLanguageSupportsIsMutable();
                this.languageSupports_.add(languageSupport);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(languageSupport);
            return this;
        }

        public Builder addLanguageSupports(int i, LanguageSupport languageSupport) {
            RepeatedFieldBuilder<LanguageSupport, LanguageSupport.Builder, LanguageSupportOrBuilder> repeatedFieldBuilder = this.languageSupportsBuilder_;
            if (repeatedFieldBuilder == null) {
                languageSupport.getClass();
                ensureLanguageSupportsIsMutable();
                this.languageSupports_.add(i, languageSupport);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, languageSupport);
            return this;
        }

        public Builder addLanguageSupports(LanguageSupport.Builder builder) {
            RepeatedFieldBuilder<LanguageSupport, LanguageSupport.Builder, LanguageSupportOrBuilder> repeatedFieldBuilder = this.languageSupportsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureLanguageSupportsIsMutable();
                this.languageSupports_.add(builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(builder.build());
            return this;
        }

        public Builder addLanguageSupports(int i, LanguageSupport.Builder builder) {
            RepeatedFieldBuilder<LanguageSupport, LanguageSupport.Builder, LanguageSupportOrBuilder> repeatedFieldBuilder = this.languageSupportsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureLanguageSupportsIsMutable();
                this.languageSupports_.add(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, builder.build());
            return this;
        }

        public Builder addAllLanguageSupports(Iterable<? extends LanguageSupport> iterable) {
            RepeatedFieldBuilder<LanguageSupport, LanguageSupport.Builder, LanguageSupportOrBuilder> repeatedFieldBuilder = this.languageSupportsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureLanguageSupportsIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.languageSupports_);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addAllMessages(iterable);
            return this;
        }

        public Builder clearLanguageSupports() {
            RepeatedFieldBuilder<LanguageSupport, LanguageSupport.Builder, LanguageSupportOrBuilder> repeatedFieldBuilder = this.languageSupportsBuilder_;
            if (repeatedFieldBuilder == null) {
                this.languageSupports_ = Collections.emptyList();
                this.bitField1_ &= -8388609;
                onChanged();
                return this;
            }
            repeatedFieldBuilder.clear();
            return this;
        }

        public Builder removeLanguageSupports(int i) {
            RepeatedFieldBuilder<LanguageSupport, LanguageSupport.Builder, LanguageSupportOrBuilder> repeatedFieldBuilder = this.languageSupportsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureLanguageSupportsIsMutable();
                this.languageSupports_.remove(i);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.remove(i);
            return this;
        }

        public LanguageSupport.Builder getLanguageSupportsBuilder(int i) {
            return (LanguageSupport.Builder) getLanguageSupportsFieldBuilder().getBuilder(i);
        }

        @Override // proto.GameOrBuilder
        public LanguageSupportOrBuilder getLanguageSupportsOrBuilder(int i) {
            RepeatedFieldBuilder<LanguageSupport, LanguageSupport.Builder, LanguageSupportOrBuilder> repeatedFieldBuilder = this.languageSupportsBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.languageSupports_.get(i);
            }
            return (LanguageSupportOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(i);
        }

        @Override // proto.GameOrBuilder
        public List<? extends LanguageSupportOrBuilder> getLanguageSupportsOrBuilderList() {
            RepeatedFieldBuilder<LanguageSupport, LanguageSupport.Builder, LanguageSupportOrBuilder> repeatedFieldBuilder = this.languageSupportsBuilder_;
            if (repeatedFieldBuilder != null) {
                return repeatedFieldBuilder.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.languageSupports_);
        }

        public LanguageSupport.Builder addLanguageSupportsBuilder() {
            return (LanguageSupport.Builder) getLanguageSupportsFieldBuilder().addBuilder(LanguageSupport.getDefaultInstance());
        }

        public LanguageSupport.Builder addLanguageSupportsBuilder(int i) {
            return (LanguageSupport.Builder) getLanguageSupportsFieldBuilder().addBuilder(i, LanguageSupport.getDefaultInstance());
        }

        public List<LanguageSupport.Builder> getLanguageSupportsBuilderList() {
            return getLanguageSupportsFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilder<LanguageSupport, LanguageSupport.Builder, LanguageSupportOrBuilder> getLanguageSupportsFieldBuilder() {
            if (this.languageSupportsBuilder_ == null) {
                this.languageSupportsBuilder_ = new RepeatedFieldBuilder<>(this.languageSupports_, (this.bitField1_ & 8388608) != 0, getParentForChildren(), isClean());
                this.languageSupports_ = null;
            }
            return this.languageSupportsBuilder_;
        }

        private void ensureGameLocalizationsIsMutable() {
            if ((this.bitField1_ & 16777216) == 0) {
                this.gameLocalizations_ = new ArrayList(this.gameLocalizations_);
                this.bitField1_ |= 16777216;
            }
        }

        @Override // proto.GameOrBuilder
        public List<GameLocalization> getGameLocalizationsList() {
            RepeatedFieldBuilder<GameLocalization, GameLocalization.Builder, GameLocalizationOrBuilder> repeatedFieldBuilder = this.gameLocalizationsBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.gameLocalizations_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // proto.GameOrBuilder
        public int getGameLocalizationsCount() {
            RepeatedFieldBuilder<GameLocalization, GameLocalization.Builder, GameLocalizationOrBuilder> repeatedFieldBuilder = this.gameLocalizationsBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.gameLocalizations_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // proto.GameOrBuilder
        public GameLocalization getGameLocalizations(int i) {
            RepeatedFieldBuilder<GameLocalization, GameLocalization.Builder, GameLocalizationOrBuilder> repeatedFieldBuilder = this.gameLocalizationsBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.gameLocalizations_.get(i);
            }
            return (GameLocalization) repeatedFieldBuilder.getMessage(i);
        }

        public Builder setGameLocalizations(int i, GameLocalization gameLocalization) {
            RepeatedFieldBuilder<GameLocalization, GameLocalization.Builder, GameLocalizationOrBuilder> repeatedFieldBuilder = this.gameLocalizationsBuilder_;
            if (repeatedFieldBuilder == null) {
                gameLocalization.getClass();
                ensureGameLocalizationsIsMutable();
                this.gameLocalizations_.set(i, gameLocalization);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, gameLocalization);
            return this;
        }

        public Builder setGameLocalizations(int i, GameLocalization.Builder builder) {
            RepeatedFieldBuilder<GameLocalization, GameLocalization.Builder, GameLocalizationOrBuilder> repeatedFieldBuilder = this.gameLocalizationsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureGameLocalizationsIsMutable();
                this.gameLocalizations_.set(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, builder.build());
            return this;
        }

        public Builder addGameLocalizations(GameLocalization gameLocalization) {
            RepeatedFieldBuilder<GameLocalization, GameLocalization.Builder, GameLocalizationOrBuilder> repeatedFieldBuilder = this.gameLocalizationsBuilder_;
            if (repeatedFieldBuilder == null) {
                gameLocalization.getClass();
                ensureGameLocalizationsIsMutable();
                this.gameLocalizations_.add(gameLocalization);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(gameLocalization);
            return this;
        }

        public Builder addGameLocalizations(int i, GameLocalization gameLocalization) {
            RepeatedFieldBuilder<GameLocalization, GameLocalization.Builder, GameLocalizationOrBuilder> repeatedFieldBuilder = this.gameLocalizationsBuilder_;
            if (repeatedFieldBuilder == null) {
                gameLocalization.getClass();
                ensureGameLocalizationsIsMutable();
                this.gameLocalizations_.add(i, gameLocalization);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, gameLocalization);
            return this;
        }

        public Builder addGameLocalizations(GameLocalization.Builder builder) {
            RepeatedFieldBuilder<GameLocalization, GameLocalization.Builder, GameLocalizationOrBuilder> repeatedFieldBuilder = this.gameLocalizationsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureGameLocalizationsIsMutable();
                this.gameLocalizations_.add(builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(builder.build());
            return this;
        }

        public Builder addGameLocalizations(int i, GameLocalization.Builder builder) {
            RepeatedFieldBuilder<GameLocalization, GameLocalization.Builder, GameLocalizationOrBuilder> repeatedFieldBuilder = this.gameLocalizationsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureGameLocalizationsIsMutable();
                this.gameLocalizations_.add(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, builder.build());
            return this;
        }

        public Builder addAllGameLocalizations(Iterable<? extends GameLocalization> iterable) {
            RepeatedFieldBuilder<GameLocalization, GameLocalization.Builder, GameLocalizationOrBuilder> repeatedFieldBuilder = this.gameLocalizationsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureGameLocalizationsIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.gameLocalizations_);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addAllMessages(iterable);
            return this;
        }

        public Builder clearGameLocalizations() {
            RepeatedFieldBuilder<GameLocalization, GameLocalization.Builder, GameLocalizationOrBuilder> repeatedFieldBuilder = this.gameLocalizationsBuilder_;
            if (repeatedFieldBuilder == null) {
                this.gameLocalizations_ = Collections.emptyList();
                this.bitField1_ &= -16777217;
                onChanged();
                return this;
            }
            repeatedFieldBuilder.clear();
            return this;
        }

        public Builder removeGameLocalizations(int i) {
            RepeatedFieldBuilder<GameLocalization, GameLocalization.Builder, GameLocalizationOrBuilder> repeatedFieldBuilder = this.gameLocalizationsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureGameLocalizationsIsMutable();
                this.gameLocalizations_.remove(i);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.remove(i);
            return this;
        }

        public GameLocalization.Builder getGameLocalizationsBuilder(int i) {
            return (GameLocalization.Builder) getGameLocalizationsFieldBuilder().getBuilder(i);
        }

        @Override // proto.GameOrBuilder
        public GameLocalizationOrBuilder getGameLocalizationsOrBuilder(int i) {
            RepeatedFieldBuilder<GameLocalization, GameLocalization.Builder, GameLocalizationOrBuilder> repeatedFieldBuilder = this.gameLocalizationsBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.gameLocalizations_.get(i);
            }
            return (GameLocalizationOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(i);
        }

        @Override // proto.GameOrBuilder
        public List<? extends GameLocalizationOrBuilder> getGameLocalizationsOrBuilderList() {
            RepeatedFieldBuilder<GameLocalization, GameLocalization.Builder, GameLocalizationOrBuilder> repeatedFieldBuilder = this.gameLocalizationsBuilder_;
            if (repeatedFieldBuilder != null) {
                return repeatedFieldBuilder.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.gameLocalizations_);
        }

        public GameLocalization.Builder addGameLocalizationsBuilder() {
            return (GameLocalization.Builder) getGameLocalizationsFieldBuilder().addBuilder(GameLocalization.getDefaultInstance());
        }

        public GameLocalization.Builder addGameLocalizationsBuilder(int i) {
            return (GameLocalization.Builder) getGameLocalizationsFieldBuilder().addBuilder(i, GameLocalization.getDefaultInstance());
        }

        public List<GameLocalization.Builder> getGameLocalizationsBuilderList() {
            return getGameLocalizationsFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilder<GameLocalization, GameLocalization.Builder, GameLocalizationOrBuilder> getGameLocalizationsFieldBuilder() {
            if (this.gameLocalizationsBuilder_ == null) {
                this.gameLocalizationsBuilder_ = new RepeatedFieldBuilder<>(this.gameLocalizations_, (this.bitField1_ & 16777216) != 0, getParentForChildren(), isClean());
                this.gameLocalizations_ = null;
            }
            return this.gameLocalizationsBuilder_;
        }

        private void ensureCollectionsIsMutable() {
            if ((this.bitField1_ & MediaHttpDownloader.MAXIMUM_CHUNK_SIZE) == 0) {
                this.collections_ = new ArrayList(this.collections_);
                this.bitField1_ |= MediaHttpDownloader.MAXIMUM_CHUNK_SIZE;
            }
        }

        @Override // proto.GameOrBuilder
        public List<Collection> getCollectionsList() {
            RepeatedFieldBuilder<Collection, Collection.Builder, CollectionOrBuilder> repeatedFieldBuilder = this.collectionsBuilder_;
            if (repeatedFieldBuilder == null) {
                return Collections.unmodifiableList(this.collections_);
            }
            return repeatedFieldBuilder.getMessageList();
        }

        @Override // proto.GameOrBuilder
        public int getCollectionsCount() {
            RepeatedFieldBuilder<Collection, Collection.Builder, CollectionOrBuilder> repeatedFieldBuilder = this.collectionsBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.collections_.size();
            }
            return repeatedFieldBuilder.getCount();
        }

        @Override // proto.GameOrBuilder
        public Collection getCollections(int i) {
            RepeatedFieldBuilder<Collection, Collection.Builder, CollectionOrBuilder> repeatedFieldBuilder = this.collectionsBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.collections_.get(i);
            }
            return (Collection) repeatedFieldBuilder.getMessage(i);
        }

        public Builder setCollections(int i, Collection collection) {
            RepeatedFieldBuilder<Collection, Collection.Builder, CollectionOrBuilder> repeatedFieldBuilder = this.collectionsBuilder_;
            if (repeatedFieldBuilder == null) {
                collection.getClass();
                ensureCollectionsIsMutable();
                this.collections_.set(i, collection);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, collection);
            return this;
        }

        public Builder setCollections(int i, Collection.Builder builder) {
            RepeatedFieldBuilder<Collection, Collection.Builder, CollectionOrBuilder> repeatedFieldBuilder = this.collectionsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureCollectionsIsMutable();
                this.collections_.set(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.setMessage(i, builder.build());
            return this;
        }

        public Builder addCollections(Collection collection) {
            RepeatedFieldBuilder<Collection, Collection.Builder, CollectionOrBuilder> repeatedFieldBuilder = this.collectionsBuilder_;
            if (repeatedFieldBuilder == null) {
                collection.getClass();
                ensureCollectionsIsMutable();
                this.collections_.add(collection);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(collection);
            return this;
        }

        public Builder addCollections(int i, Collection collection) {
            RepeatedFieldBuilder<Collection, Collection.Builder, CollectionOrBuilder> repeatedFieldBuilder = this.collectionsBuilder_;
            if (repeatedFieldBuilder == null) {
                collection.getClass();
                ensureCollectionsIsMutable();
                this.collections_.add(i, collection);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, collection);
            return this;
        }

        public Builder addCollections(Collection.Builder builder) {
            RepeatedFieldBuilder<Collection, Collection.Builder, CollectionOrBuilder> repeatedFieldBuilder = this.collectionsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureCollectionsIsMutable();
                this.collections_.add(builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(builder.build());
            return this;
        }

        public Builder addCollections(int i, Collection.Builder builder) {
            RepeatedFieldBuilder<Collection, Collection.Builder, CollectionOrBuilder> repeatedFieldBuilder = this.collectionsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureCollectionsIsMutable();
                this.collections_.add(i, builder.build());
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addMessage(i, builder.build());
            return this;
        }

        public Builder addAllCollections(Iterable<? extends Collection> iterable) {
            RepeatedFieldBuilder<Collection, Collection.Builder, CollectionOrBuilder> repeatedFieldBuilder = this.collectionsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureCollectionsIsMutable();
                AbstractMessageLite.Builder.addAll((Iterable) iterable, (List) this.collections_);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.addAllMessages(iterable);
            return this;
        }

        public Builder clearCollections() {
            RepeatedFieldBuilder<Collection, Collection.Builder, CollectionOrBuilder> repeatedFieldBuilder = this.collectionsBuilder_;
            if (repeatedFieldBuilder == null) {
                this.collections_ = Collections.emptyList();
                this.bitField1_ &= -33554433;
                onChanged();
                return this;
            }
            repeatedFieldBuilder.clear();
            return this;
        }

        public Builder removeCollections(int i) {
            RepeatedFieldBuilder<Collection, Collection.Builder, CollectionOrBuilder> repeatedFieldBuilder = this.collectionsBuilder_;
            if (repeatedFieldBuilder == null) {
                ensureCollectionsIsMutable();
                this.collections_.remove(i);
                onChanged();
                return this;
            }
            repeatedFieldBuilder.remove(i);
            return this;
        }

        public Collection.Builder getCollectionsBuilder(int i) {
            return (Collection.Builder) getCollectionsFieldBuilder().getBuilder(i);
        }

        @Override // proto.GameOrBuilder
        public CollectionOrBuilder getCollectionsOrBuilder(int i) {
            RepeatedFieldBuilder<Collection, Collection.Builder, CollectionOrBuilder> repeatedFieldBuilder = this.collectionsBuilder_;
            if (repeatedFieldBuilder == null) {
                return this.collections_.get(i);
            }
            return (CollectionOrBuilder) repeatedFieldBuilder.getMessageOrBuilder(i);
        }

        @Override // proto.GameOrBuilder
        public List<? extends CollectionOrBuilder> getCollectionsOrBuilderList() {
            RepeatedFieldBuilder<Collection, Collection.Builder, CollectionOrBuilder> repeatedFieldBuilder = this.collectionsBuilder_;
            if (repeatedFieldBuilder != null) {
                return repeatedFieldBuilder.getMessageOrBuilderList();
            }
            return Collections.unmodifiableList(this.collections_);
        }

        public Collection.Builder addCollectionsBuilder() {
            return (Collection.Builder) getCollectionsFieldBuilder().addBuilder(Collection.getDefaultInstance());
        }

        public Collection.Builder addCollectionsBuilder(int i) {
            return (Collection.Builder) getCollectionsFieldBuilder().addBuilder(i, Collection.getDefaultInstance());
        }

        public List<Collection.Builder> getCollectionsBuilderList() {
            return getCollectionsFieldBuilder().getBuilderList();
        }

        private RepeatedFieldBuilder<Collection, Collection.Builder, CollectionOrBuilder> getCollectionsFieldBuilder() {
            if (this.collectionsBuilder_ == null) {
                this.collectionsBuilder_ = new RepeatedFieldBuilder<>(this.collections_, (this.bitField1_ & MediaHttpDownloader.MAXIMUM_CHUNK_SIZE) != 0, getParentForChildren(), isClean());
                this.collections_ = null;
            }
            return this.collectionsBuilder_;
        }
    }

    public static Game getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* INFO: renamed from: proto.Game$1, reason: invalid class name */
    class AnonymousClass1 extends AbstractParser<Game> {
        AnonymousClass1() {
        }

        @Override // com.google.protobuf.Parser
        public Game parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            Builder builderNewBuilder = Game.newBuilder();
            try {
                builderNewBuilder.mergeFrom(codedInputStream, extensionRegistryLite);
                return builderNewBuilder.buildPartial();
            } catch (InvalidProtocolBufferException e) {
                throw e.setUnfinishedMessage(builderNewBuilder.buildPartial());
            } catch (UninitializedMessageException e2) {
                throw e2.asInvalidProtocolBufferException().setUnfinishedMessage(builderNewBuilder.buildPartial());
            } catch (IOException e3) {
                throw new InvalidProtocolBufferException(e3).setUnfinishedMessage(builderNewBuilder.buildPartial());
            }
        }
    }

    public static Parser<Game> parser() {
        return PARSER;
    }

    @Override // com.google.protobuf.GeneratedMessage, com.google.protobuf.MessageLite, com.google.protobuf.Message
    public Parser<Game> getParserForType() {
        return PARSER;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder, com.google.protobuf.MessageOrBuilder
    public Game getDefaultInstanceForType() {
        return DEFAULT_INSTANCE;
    }
}
