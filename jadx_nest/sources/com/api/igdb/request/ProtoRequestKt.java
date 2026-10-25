package com.api.igdb.request;

import com.api.igdb.apicalypse.APICalypse;
import com.api.igdb.exceptions.RequestException;
import com.api.igdb.utils.Endpoints;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import proto.AgeRating;
import proto.AgeRatingContentDescription;
import proto.AgeRatingContentDescriptionResult;
import proto.AgeRatingResult;
import proto.AlternativeName;
import proto.AlternativeNameResult;
import proto.Artwork;
import proto.ArtworkResult;
import proto.Character;
import proto.CharacterMugShot;
import proto.CharacterMugShotResult;
import proto.CharacterResult;
import proto.Collection;
import proto.CollectionMembership;
import proto.CollectionMembershipResult;
import proto.CollectionMembershipType;
import proto.CollectionMembershipTypeResult;
import proto.CollectionRelation;
import proto.CollectionRelationResult;
import proto.CollectionRelationType;
import proto.CollectionRelationTypeResult;
import proto.CollectionResult;
import proto.CollectionType;
import proto.CollectionTypeResult;
import proto.Company;
import proto.CompanyLogo;
import proto.CompanyLogoResult;
import proto.CompanyResult;
import proto.CompanyWebsite;
import proto.CompanyWebsiteResult;
import proto.Cover;
import proto.CoverResult;
import proto.Event;
import proto.EventLogo;
import proto.EventLogoResult;
import proto.EventNetwork;
import proto.EventNetworkResult;
import proto.EventResult;
import proto.ExternalGame;
import proto.ExternalGameResult;
import proto.Franchise;
import proto.FranchiseResult;
import proto.Game;
import proto.GameEngine;
import proto.GameEngineLogo;
import proto.GameEngineLogoResult;
import proto.GameEngineResult;
import proto.GameLocalization;
import proto.GameLocalizationResult;
import proto.GameMode;
import proto.GameModeResult;
import proto.GameResult;
import proto.GameVersion;
import proto.GameVersionFeature;
import proto.GameVersionFeatureResult;
import proto.GameVersionFeatureValue;
import proto.GameVersionFeatureValueResult;
import proto.GameVersionResult;
import proto.GameVideo;
import proto.GameVideoResult;
import proto.Genre;
import proto.GenreResult;
import proto.InvolvedCompany;
import proto.InvolvedCompanyResult;
import proto.Keyword;
import proto.KeywordResult;
import proto.Language;
import proto.LanguageResult;
import proto.LanguageSupport;
import proto.LanguageSupportResult;
import proto.LanguageSupportType;
import proto.LanguageSupportTypeResult;
import proto.MultiplayerMode;
import proto.MultiplayerModeResult;
import proto.NetworkType;
import proto.NetworkTypeResult;
import proto.Platform;
import proto.PlatformFamily;
import proto.PlatformFamilyResult;
import proto.PlatformLogo;
import proto.PlatformLogoResult;
import proto.PlatformResult;
import proto.PlatformVersion;
import proto.PlatformVersionCompany;
import proto.PlatformVersionCompanyResult;
import proto.PlatformVersionReleaseDate;
import proto.PlatformVersionReleaseDateResult;
import proto.PlatformVersionResult;
import proto.PlatformWebsite;
import proto.PlatformWebsiteResult;
import proto.PlayerPerspective;
import proto.PlayerPerspectiveResult;
import proto.PopularityPrimitive;
import proto.PopularityPrimitiveResult;
import proto.PopularityType;
import proto.PopularityTypeResult;
import proto.Region;
import proto.RegionResult;
import proto.ReleaseDate;
import proto.ReleaseDateResult;
import proto.Screenshot;
import proto.ScreenshotResult;
import proto.Search;
import proto.SearchResult;
import proto.Theme;
import proto.ThemeResult;
import proto.Website;
import proto.WebsiteResult;

/* JADX INFO: compiled from: ProtoRequest.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000Ô\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0018\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0018\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0018\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0018\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0018\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0018\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0018\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0018\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0018\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0018\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0018\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0018\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0018\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0018\u0010 \u001a\b\u0012\u0004\u0012\u00020!0\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0018\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0018\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0018\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0018\u0010(\u001a\b\u0012\u0004\u0012\u00020)0\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0018\u0010*\u001a\b\u0012\u0004\u0012\u00020+0\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0018\u0010,\u001a\b\u0012\u0004\u0012\u00020-0\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0018\u0010.\u001a\b\u0012\u0004\u0012\u00020/0\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0018\u00100\u001a\b\u0012\u0004\u0012\u0002010\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0018\u00102\u001a\b\u0012\u0004\u0012\u0002030\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0018\u00104\u001a\b\u0012\u0004\u0012\u0002050\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0018\u00106\u001a\b\u0012\u0004\u0012\u0002070\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0018\u00108\u001a\b\u0012\u0004\u0012\u0002090\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0018\u0010:\u001a\b\u0012\u0004\u0012\u00020;0\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0018\u0010<\u001a\b\u0012\u0004\u0012\u00020=0\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0018\u0010>\u001a\b\u0012\u0004\u0012\u00020?0\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0018\u0010@\u001a\b\u0012\u0004\u0012\u00020A0\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0018\u0010B\u001a\b\u0012\u0004\u0012\u00020C0\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0018\u0010D\u001a\b\u0012\u0004\u0012\u00020E0\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0018\u0010F\u001a\b\u0012\u0004\u0012\u00020G0\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0018\u0010H\u001a\b\u0012\u0004\u0012\u00020I0\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0018\u0010J\u001a\b\u0012\u0004\u0012\u00020K0\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0018\u0010L\u001a\b\u0012\u0004\u0012\u00020M0\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0018\u0010N\u001a\b\u0012\u0004\u0012\u00020O0\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0018\u0010P\u001a\b\u0012\u0004\u0012\u00020Q0\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0018\u0010R\u001a\b\u0012\u0004\u0012\u00020S0\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0018\u0010T\u001a\b\u0012\u0004\u0012\u00020U0\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0018\u0010V\u001a\b\u0012\u0004\u0012\u00020W0\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0018\u0010X\u001a\b\u0012\u0004\u0012\u00020Y0\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0018\u0010Z\u001a\b\u0012\u0004\u0012\u00020[0\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0018\u0010\\\u001a\b\u0012\u0004\u0012\u00020]0\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0018\u0010^\u001a\b\u0012\u0004\u0012\u00020_0\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0018\u0010`\u001a\b\u0012\u0004\u0012\u00020a0\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0018\u0010b\u001a\b\u0012\u0004\u0012\u00020c0\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0018\u0010d\u001a\b\u0012\u0004\u0012\u00020e0\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0018\u0010f\u001a\b\u0012\u0004\u0012\u00020g0\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0018\u0010h\u001a\b\u0012\u0004\u0012\u00020i0\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0018\u0010j\u001a\b\u0012\u0004\u0012\u00020k0\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0018\u0010l\u001a\b\u0012\u0004\u0012\u00020m0\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0018\u0010n\u001a\b\u0012\u0004\u0012\u00020o0\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006p"}, d2 = {"ageRatingContentDescriptions", "", "Lproto/AgeRatingContentDescription;", "Lcom/api/igdb/request/IGDBWrapper;", "APICalypse", "Lcom/api/igdb/apicalypse/APICalypse;", "ageRatings", "Lproto/AgeRating;", "alternativeNames", "Lproto/AlternativeName;", "artworks", "Lproto/Artwork;", "characterMugShots", "Lproto/CharacterMugShot;", "characters", "Lproto/Character;", "collectionMembershipTypes", "Lproto/CollectionMembershipType;", "collectionMemberships", "Lproto/CollectionMembership;", "collectionRelationTypes", "Lproto/CollectionRelationType;", "collectionRelations", "Lproto/CollectionRelation;", "collectionTypes", "Lproto/CollectionType;", "collections", "Lproto/Collection;", "companies", "Lproto/Company;", "companyLogos", "Lproto/CompanyLogo;", "companyWebsites", "Lproto/CompanyWebsite;", "covers", "Lproto/Cover;", "eventLogos", "Lproto/EventLogo;", "eventNetworks", "Lproto/EventNetwork;", "events", "Lproto/Event;", "externalGames", "Lproto/ExternalGame;", "franchises", "Lproto/Franchise;", "gameEngineLogos", "Lproto/GameEngineLogo;", "gameEngines", "Lproto/GameEngine;", "gameLocalizations", "Lproto/GameLocalization;", "gameModes", "Lproto/GameMode;", "gameVersion", "Lproto/GameVersion;", "gameVersionFeatureValues", "Lproto/GameVersionFeatureValue;", "gameVersionFeatures", "Lproto/GameVersionFeature;", "gameVideos", "Lproto/GameVideo;", "games", "Lproto/Game;", "genres", "Lproto/Genre;", "involvedCompanies", "Lproto/InvolvedCompany;", "keywords", "Lproto/Keyword;", "languageSupportTypes", "Lproto/LanguageSupportType;", "languageSupports", "Lproto/LanguageSupport;", "languages", "Lproto/Language;", "multiplayerModes", "Lproto/MultiplayerMode;", "networkTypes", "Lproto/NetworkType;", "platformFamilies", "Lproto/PlatformFamily;", "platformLogos", "Lproto/PlatformLogo;", "platformVersionCompanies", "Lproto/PlatformVersionCompany;", "platformVersionReleaseDates", "Lproto/PlatformVersionReleaseDate;", "platformVersions", "Lproto/PlatformVersion;", "platformWebsites", "Lproto/PlatformWebsite;", "platforms", "Lproto/Platform;", "playerPerspectives", "Lproto/PlayerPerspective;", "popularityPrimitives", "Lproto/PopularityPrimitive;", "popularityTypes", "Lproto/PopularityType;", "regions", "Lproto/Region;", "releaseDates", "Lproto/ReleaseDate;", "screenshots", "Lproto/Screenshot;", "search", "Lproto/Search;", "themes", "Lproto/Theme;", "websites", "Lproto/Website;", "igdb-api-jvm"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class ProtoRequestKt {
    public static final List<AgeRating> ageRatings(IGDBWrapper iGDBWrapper, APICalypse APICalypse) throws RequestException {
        Intrinsics.checkNotNullParameter(iGDBWrapper, "<this>");
        Intrinsics.checkNotNullParameter(APICalypse, "APICalypse");
        List<AgeRating> ageratingsList = AgeRatingResult.parseFrom(iGDBWrapper.apiProtoRequest(Endpoints.AGE_RATINGS, APICalypse.buildQuery())).getAgeratingsList();
        Intrinsics.checkNotNullExpressionValue(ageratingsList, "getAgeratingsList(...)");
        return ageratingsList;
    }

    public static final List<AgeRatingContentDescription> ageRatingContentDescriptions(IGDBWrapper iGDBWrapper, APICalypse APICalypse) throws RequestException {
        Intrinsics.checkNotNullParameter(iGDBWrapper, "<this>");
        Intrinsics.checkNotNullParameter(APICalypse, "APICalypse");
        List<AgeRatingContentDescription> ageratingcontentdescriptionsList = AgeRatingContentDescriptionResult.parseFrom(iGDBWrapper.apiProtoRequest(Endpoints.AGE_RATING_CONTENT_DESCRIPTIONS, APICalypse.buildQuery())).getAgeratingcontentdescriptionsList();
        Intrinsics.checkNotNullExpressionValue(ageratingcontentdescriptionsList, "getAgeratingcontentdescriptionsList(...)");
        return ageratingcontentdescriptionsList;
    }

    public static final List<AlternativeName> alternativeNames(IGDBWrapper iGDBWrapper, APICalypse APICalypse) throws RequestException {
        Intrinsics.checkNotNullParameter(iGDBWrapper, "<this>");
        Intrinsics.checkNotNullParameter(APICalypse, "APICalypse");
        List<AlternativeName> alternativenamesList = AlternativeNameResult.parseFrom(iGDBWrapper.apiProtoRequest(Endpoints.ALTERNATIVE_NAMES, APICalypse.buildQuery())).getAlternativenamesList();
        Intrinsics.checkNotNullExpressionValue(alternativenamesList, "getAlternativenamesList(...)");
        return alternativenamesList;
    }

    public static final List<Artwork> artworks(IGDBWrapper iGDBWrapper, APICalypse APICalypse) throws RequestException {
        Intrinsics.checkNotNullParameter(iGDBWrapper, "<this>");
        Intrinsics.checkNotNullParameter(APICalypse, "APICalypse");
        List<Artwork> artworksList = ArtworkResult.parseFrom(iGDBWrapper.apiProtoRequest(Endpoints.ARTWORKS, APICalypse.buildQuery())).getArtworksList();
        Intrinsics.checkNotNullExpressionValue(artworksList, "getArtworksList(...)");
        return artworksList;
    }

    public static final List<Character> characters(IGDBWrapper iGDBWrapper, APICalypse APICalypse) throws RequestException {
        Intrinsics.checkNotNullParameter(iGDBWrapper, "<this>");
        Intrinsics.checkNotNullParameter(APICalypse, "APICalypse");
        List<Character> charactersList = CharacterResult.parseFrom(iGDBWrapper.apiProtoRequest(Endpoints.CHARACTERS, APICalypse.buildQuery())).getCharactersList();
        Intrinsics.checkNotNullExpressionValue(charactersList, "getCharactersList(...)");
        return charactersList;
    }

    public static final List<Collection> collections(IGDBWrapper iGDBWrapper, APICalypse APICalypse) throws RequestException {
        Intrinsics.checkNotNullParameter(iGDBWrapper, "<this>");
        Intrinsics.checkNotNullParameter(APICalypse, "APICalypse");
        List<Collection> collectionsList = CollectionResult.parseFrom(iGDBWrapper.apiProtoRequest(Endpoints.COLLECTIONS, APICalypse.buildQuery())).getCollectionsList();
        Intrinsics.checkNotNullExpressionValue(collectionsList, "getCollectionsList(...)");
        return collectionsList;
    }

    public static final List<CharacterMugShot> characterMugShots(IGDBWrapper iGDBWrapper, APICalypse APICalypse) throws RequestException {
        Intrinsics.checkNotNullParameter(iGDBWrapper, "<this>");
        Intrinsics.checkNotNullParameter(APICalypse, "APICalypse");
        List<CharacterMugShot> charactermugshotsList = CharacterMugShotResult.parseFrom(iGDBWrapper.apiProtoRequest(Endpoints.CHARACTER_MUG_SHOTS, APICalypse.buildQuery())).getCharactermugshotsList();
        Intrinsics.checkNotNullExpressionValue(charactermugshotsList, "getCharactermugshotsList(...)");
        return charactermugshotsList;
    }

    public static final List<Company> companies(IGDBWrapper iGDBWrapper, APICalypse APICalypse) throws RequestException {
        Intrinsics.checkNotNullParameter(iGDBWrapper, "<this>");
        Intrinsics.checkNotNullParameter(APICalypse, "APICalypse");
        List<Company> companiesList = CompanyResult.parseFrom(iGDBWrapper.apiProtoRequest(Endpoints.COMPANIES, APICalypse.buildQuery())).getCompaniesList();
        Intrinsics.checkNotNullExpressionValue(companiesList, "getCompaniesList(...)");
        return companiesList;
    }

    public static final List<CompanyWebsite> companyWebsites(IGDBWrapper iGDBWrapper, APICalypse APICalypse) throws RequestException {
        Intrinsics.checkNotNullParameter(iGDBWrapper, "<this>");
        Intrinsics.checkNotNullParameter(APICalypse, "APICalypse");
        List<CompanyWebsite> companywebsitesList = CompanyWebsiteResult.parseFrom(iGDBWrapper.apiProtoRequest(Endpoints.COMPANY_WEBSITES, APICalypse.buildQuery())).getCompanywebsitesList();
        Intrinsics.checkNotNullExpressionValue(companywebsitesList, "getCompanywebsitesList(...)");
        return companywebsitesList;
    }

    public static final List<CompanyLogo> companyLogos(IGDBWrapper iGDBWrapper, APICalypse APICalypse) throws RequestException {
        Intrinsics.checkNotNullParameter(iGDBWrapper, "<this>");
        Intrinsics.checkNotNullParameter(APICalypse, "APICalypse");
        List<CompanyLogo> companylogosList = CompanyLogoResult.parseFrom(iGDBWrapper.apiProtoRequest(Endpoints.COMPANY_LOGOS, APICalypse.buildQuery())).getCompanylogosList();
        Intrinsics.checkNotNullExpressionValue(companylogosList, "getCompanylogosList(...)");
        return companylogosList;
    }

    public static final List<Cover> covers(IGDBWrapper iGDBWrapper, APICalypse APICalypse) throws RequestException {
        Intrinsics.checkNotNullParameter(iGDBWrapper, "<this>");
        Intrinsics.checkNotNullParameter(APICalypse, "APICalypse");
        List<Cover> coversList = CoverResult.parseFrom(iGDBWrapper.apiProtoRequest(Endpoints.COVERS, APICalypse.buildQuery())).getCoversList();
        Intrinsics.checkNotNullExpressionValue(coversList, "getCoversList(...)");
        return coversList;
    }

    public static final List<ExternalGame> externalGames(IGDBWrapper iGDBWrapper, APICalypse APICalypse) throws RequestException {
        Intrinsics.checkNotNullParameter(iGDBWrapper, "<this>");
        Intrinsics.checkNotNullParameter(APICalypse, "APICalypse");
        List<ExternalGame> externalgamesList = ExternalGameResult.parseFrom(iGDBWrapper.apiProtoRequest(Endpoints.EXTERNAL_GAMES, APICalypse.buildQuery())).getExternalgamesList();
        Intrinsics.checkNotNullExpressionValue(externalgamesList, "getExternalgamesList(...)");
        return externalgamesList;
    }

    public static final List<Franchise> franchises(IGDBWrapper iGDBWrapper, APICalypse APICalypse) throws RequestException {
        Intrinsics.checkNotNullParameter(iGDBWrapper, "<this>");
        Intrinsics.checkNotNullParameter(APICalypse, "APICalypse");
        List<Franchise> franchisesList = FranchiseResult.parseFrom(iGDBWrapper.apiProtoRequest(Endpoints.FRANCHISES, APICalypse.buildQuery())).getFranchisesList();
        Intrinsics.checkNotNullExpressionValue(franchisesList, "getFranchisesList(...)");
        return franchisesList;
    }

    public static final List<Game> games(IGDBWrapper iGDBWrapper, APICalypse APICalypse) throws RequestException {
        Intrinsics.checkNotNullParameter(iGDBWrapper, "<this>");
        Intrinsics.checkNotNullParameter(APICalypse, "APICalypse");
        List<Game> gamesList = GameResult.parseFrom(iGDBWrapper.apiProtoRequest(Endpoints.GAMES, APICalypse.buildQuery())).getGamesList();
        Intrinsics.checkNotNullExpressionValue(gamesList, "getGamesList(...)");
        return gamesList;
    }

    public static final List<GameEngine> gameEngines(IGDBWrapper iGDBWrapper, APICalypse APICalypse) throws RequestException {
        Intrinsics.checkNotNullParameter(iGDBWrapper, "<this>");
        Intrinsics.checkNotNullParameter(APICalypse, "APICalypse");
        List<GameEngine> gameenginesList = GameEngineResult.parseFrom(iGDBWrapper.apiProtoRequest(Endpoints.GAME_ENGINES, APICalypse.buildQuery())).getGameenginesList();
        Intrinsics.checkNotNullExpressionValue(gameenginesList, "getGameenginesList(...)");
        return gameenginesList;
    }

    public static final List<GameEngineLogo> gameEngineLogos(IGDBWrapper iGDBWrapper, APICalypse APICalypse) throws RequestException {
        Intrinsics.checkNotNullParameter(iGDBWrapper, "<this>");
        Intrinsics.checkNotNullParameter(APICalypse, "APICalypse");
        List<GameEngineLogo> gameenginelogosList = GameEngineLogoResult.parseFrom(iGDBWrapper.apiProtoRequest(Endpoints.GAME_ENGINE_LOGOS, APICalypse.buildQuery())).getGameenginelogosList();
        Intrinsics.checkNotNullExpressionValue(gameenginelogosList, "getGameenginelogosList(...)");
        return gameenginelogosList;
    }

    public static final List<GameLocalization> gameLocalizations(IGDBWrapper iGDBWrapper, APICalypse APICalypse) throws RequestException {
        Intrinsics.checkNotNullParameter(iGDBWrapper, "<this>");
        Intrinsics.checkNotNullParameter(APICalypse, "APICalypse");
        List<GameLocalization> gamelocalizationsList = GameLocalizationResult.parseFrom(iGDBWrapper.apiProtoRequest(Endpoints.GAME_LOCALIZATIONS, APICalypse.buildQuery())).getGamelocalizationsList();
        Intrinsics.checkNotNullExpressionValue(gamelocalizationsList, "getGamelocalizationsList(...)");
        return gamelocalizationsList;
    }

    public static final List<GameMode> gameModes(IGDBWrapper iGDBWrapper, APICalypse APICalypse) throws RequestException {
        Intrinsics.checkNotNullParameter(iGDBWrapper, "<this>");
        Intrinsics.checkNotNullParameter(APICalypse, "APICalypse");
        List<GameMode> gamemodesList = GameModeResult.parseFrom(iGDBWrapper.apiProtoRequest(Endpoints.GAME_MODES, APICalypse.buildQuery())).getGamemodesList();
        Intrinsics.checkNotNullExpressionValue(gamemodesList, "getGamemodesList(...)");
        return gamemodesList;
    }

    public static final List<GameVersion> gameVersion(IGDBWrapper iGDBWrapper, APICalypse APICalypse) throws RequestException {
        Intrinsics.checkNotNullParameter(iGDBWrapper, "<this>");
        Intrinsics.checkNotNullParameter(APICalypse, "APICalypse");
        List<GameVersion> gameversionsList = GameVersionResult.parseFrom(iGDBWrapper.apiProtoRequest(Endpoints.GAME_VERSIONS, APICalypse.buildQuery())).getGameversionsList();
        Intrinsics.checkNotNullExpressionValue(gameversionsList, "getGameversionsList(...)");
        return gameversionsList;
    }

    public static final List<GameVersionFeature> gameVersionFeatures(IGDBWrapper iGDBWrapper, APICalypse APICalypse) throws RequestException {
        Intrinsics.checkNotNullParameter(iGDBWrapper, "<this>");
        Intrinsics.checkNotNullParameter(APICalypse, "APICalypse");
        List<GameVersionFeature> gameversionfeaturesList = GameVersionFeatureResult.parseFrom(iGDBWrapper.apiProtoRequest(Endpoints.GAME_VERSION_FEATURES, APICalypse.buildQuery())).getGameversionfeaturesList();
        Intrinsics.checkNotNullExpressionValue(gameversionfeaturesList, "getGameversionfeaturesList(...)");
        return gameversionfeaturesList;
    }

    public static final List<GameVersionFeatureValue> gameVersionFeatureValues(IGDBWrapper iGDBWrapper, APICalypse APICalypse) throws RequestException {
        Intrinsics.checkNotNullParameter(iGDBWrapper, "<this>");
        Intrinsics.checkNotNullParameter(APICalypse, "APICalypse");
        List<GameVersionFeatureValue> gameversionfeaturevaluesList = GameVersionFeatureValueResult.parseFrom(iGDBWrapper.apiProtoRequest(Endpoints.GAME_VERSION_FEATURE_VALUES, APICalypse.buildQuery())).getGameversionfeaturevaluesList();
        Intrinsics.checkNotNullExpressionValue(gameversionfeaturevaluesList, "getGameversionfeaturevaluesList(...)");
        return gameversionfeaturevaluesList;
    }

    public static final List<GameVideo> gameVideos(IGDBWrapper iGDBWrapper, APICalypse APICalypse) throws RequestException {
        Intrinsics.checkNotNullParameter(iGDBWrapper, "<this>");
        Intrinsics.checkNotNullParameter(APICalypse, "APICalypse");
        List<GameVideo> gamevideosList = GameVideoResult.parseFrom(iGDBWrapper.apiProtoRequest(Endpoints.GAME_VIDEOS, APICalypse.buildQuery())).getGamevideosList();
        Intrinsics.checkNotNullExpressionValue(gamevideosList, "getGamevideosList(...)");
        return gamevideosList;
    }

    public static final List<Genre> genres(IGDBWrapper iGDBWrapper, APICalypse APICalypse) throws RequestException {
        Intrinsics.checkNotNullParameter(iGDBWrapper, "<this>");
        Intrinsics.checkNotNullParameter(APICalypse, "APICalypse");
        List<Genre> genresList = GenreResult.parseFrom(iGDBWrapper.apiProtoRequest(Endpoints.GENRES, APICalypse.buildQuery())).getGenresList();
        Intrinsics.checkNotNullExpressionValue(genresList, "getGenresList(...)");
        return genresList;
    }

    public static final List<InvolvedCompany> involvedCompanies(IGDBWrapper iGDBWrapper, APICalypse APICalypse) throws RequestException {
        Intrinsics.checkNotNullParameter(iGDBWrapper, "<this>");
        Intrinsics.checkNotNullParameter(APICalypse, "APICalypse");
        List<InvolvedCompany> involvedcompaniesList = InvolvedCompanyResult.parseFrom(iGDBWrapper.apiProtoRequest(Endpoints.INVOLVED_COMPANIES, APICalypse.buildQuery())).getInvolvedcompaniesList();
        Intrinsics.checkNotNullExpressionValue(involvedcompaniesList, "getInvolvedcompaniesList(...)");
        return involvedcompaniesList;
    }

    public static final List<Keyword> keywords(IGDBWrapper iGDBWrapper, APICalypse APICalypse) throws RequestException {
        Intrinsics.checkNotNullParameter(iGDBWrapper, "<this>");
        Intrinsics.checkNotNullParameter(APICalypse, "APICalypse");
        List<Keyword> keywordsList = KeywordResult.parseFrom(iGDBWrapper.apiProtoRequest(Endpoints.KEYWORDS, APICalypse.buildQuery())).getKeywordsList();
        Intrinsics.checkNotNullExpressionValue(keywordsList, "getKeywordsList(...)");
        return keywordsList;
    }

    public static final List<Language> languages(IGDBWrapper iGDBWrapper, APICalypse APICalypse) throws RequestException {
        Intrinsics.checkNotNullParameter(iGDBWrapper, "<this>");
        Intrinsics.checkNotNullParameter(APICalypse, "APICalypse");
        List<Language> languagesList = LanguageResult.parseFrom(iGDBWrapper.apiProtoRequest(Endpoints.LANGUAGES, APICalypse.buildQuery())).getLanguagesList();
        Intrinsics.checkNotNullExpressionValue(languagesList, "getLanguagesList(...)");
        return languagesList;
    }

    public static final List<LanguageSupport> languageSupports(IGDBWrapper iGDBWrapper, APICalypse APICalypse) throws RequestException {
        Intrinsics.checkNotNullParameter(iGDBWrapper, "<this>");
        Intrinsics.checkNotNullParameter(APICalypse, "APICalypse");
        List<LanguageSupport> languagesupportsList = LanguageSupportResult.parseFrom(iGDBWrapper.apiProtoRequest(Endpoints.LANGUAGE_SUPPORTS, APICalypse.buildQuery())).getLanguagesupportsList();
        Intrinsics.checkNotNullExpressionValue(languagesupportsList, "getLanguagesupportsList(...)");
        return languagesupportsList;
    }

    public static final List<LanguageSupportType> languageSupportTypes(IGDBWrapper iGDBWrapper, APICalypse APICalypse) throws RequestException {
        Intrinsics.checkNotNullParameter(iGDBWrapper, "<this>");
        Intrinsics.checkNotNullParameter(APICalypse, "APICalypse");
        List<LanguageSupportType> languagesupporttypesList = LanguageSupportTypeResult.parseFrom(iGDBWrapper.apiProtoRequest(Endpoints.LANGUAGE_SUPPORT_TYPES, APICalypse.buildQuery())).getLanguagesupporttypesList();
        Intrinsics.checkNotNullExpressionValue(languagesupporttypesList, "getLanguagesupporttypesList(...)");
        return languagesupporttypesList;
    }

    public static final List<MultiplayerMode> multiplayerModes(IGDBWrapper iGDBWrapper, APICalypse APICalypse) throws RequestException {
        Intrinsics.checkNotNullParameter(iGDBWrapper, "<this>");
        Intrinsics.checkNotNullParameter(APICalypse, "APICalypse");
        List<MultiplayerMode> multiplayermodesList = MultiplayerModeResult.parseFrom(iGDBWrapper.apiProtoRequest(Endpoints.MULTIPLAYER_MODES, APICalypse.buildQuery())).getMultiplayermodesList();
        Intrinsics.checkNotNullExpressionValue(multiplayermodesList, "getMultiplayermodesList(...)");
        return multiplayermodesList;
    }

    public static final List<Platform> platforms(IGDBWrapper iGDBWrapper, APICalypse APICalypse) throws RequestException {
        Intrinsics.checkNotNullParameter(iGDBWrapper, "<this>");
        Intrinsics.checkNotNullParameter(APICalypse, "APICalypse");
        List<Platform> platformsList = PlatformResult.parseFrom(iGDBWrapper.apiProtoRequest(Endpoints.PLATFORMS, APICalypse.buildQuery())).getPlatformsList();
        Intrinsics.checkNotNullExpressionValue(platformsList, "getPlatformsList(...)");
        return platformsList;
    }

    public static final List<PlatformLogo> platformLogos(IGDBWrapper iGDBWrapper, APICalypse APICalypse) throws RequestException {
        Intrinsics.checkNotNullParameter(iGDBWrapper, "<this>");
        Intrinsics.checkNotNullParameter(APICalypse, "APICalypse");
        List<PlatformLogo> platformlogosList = PlatformLogoResult.parseFrom(iGDBWrapper.apiProtoRequest(Endpoints.PLATFORM_LOGOS, APICalypse.buildQuery())).getPlatformlogosList();
        Intrinsics.checkNotNullExpressionValue(platformlogosList, "getPlatformlogosList(...)");
        return platformlogosList;
    }

    public static final List<PlatformVersion> platformVersions(IGDBWrapper iGDBWrapper, APICalypse APICalypse) throws RequestException {
        Intrinsics.checkNotNullParameter(iGDBWrapper, "<this>");
        Intrinsics.checkNotNullParameter(APICalypse, "APICalypse");
        List<PlatformVersion> platformversionsList = PlatformVersionResult.parseFrom(iGDBWrapper.apiProtoRequest(Endpoints.PLATFORM_VERSIONS, APICalypse.buildQuery())).getPlatformversionsList();
        Intrinsics.checkNotNullExpressionValue(platformversionsList, "getPlatformversionsList(...)");
        return platformversionsList;
    }

    public static final List<PlatformVersionCompany> platformVersionCompanies(IGDBWrapper iGDBWrapper, APICalypse APICalypse) throws RequestException {
        Intrinsics.checkNotNullParameter(iGDBWrapper, "<this>");
        Intrinsics.checkNotNullParameter(APICalypse, "APICalypse");
        List<PlatformVersionCompany> platformversioncompaniesList = PlatformVersionCompanyResult.parseFrom(iGDBWrapper.apiProtoRequest(Endpoints.PLATFORM_VERSION_COMPANIES, APICalypse.buildQuery())).getPlatformversioncompaniesList();
        Intrinsics.checkNotNullExpressionValue(platformversioncompaniesList, "getPlatformversioncompaniesList(...)");
        return platformversioncompaniesList;
    }

    public static final List<PlatformVersionReleaseDate> platformVersionReleaseDates(IGDBWrapper iGDBWrapper, APICalypse APICalypse) throws RequestException {
        Intrinsics.checkNotNullParameter(iGDBWrapper, "<this>");
        Intrinsics.checkNotNullParameter(APICalypse, "APICalypse");
        List<PlatformVersionReleaseDate> platformversionreleasedatesList = PlatformVersionReleaseDateResult.parseFrom(iGDBWrapper.apiProtoRequest(Endpoints.PLATFORM_VERSION_RELEASE_DATES, APICalypse.buildQuery())).getPlatformversionreleasedatesList();
        Intrinsics.checkNotNullExpressionValue(platformversionreleasedatesList, "getPlatformversionreleasedatesList(...)");
        return platformversionreleasedatesList;
    }

    public static final List<PlatformWebsite> platformWebsites(IGDBWrapper iGDBWrapper, APICalypse APICalypse) throws RequestException {
        Intrinsics.checkNotNullParameter(iGDBWrapper, "<this>");
        Intrinsics.checkNotNullParameter(APICalypse, "APICalypse");
        List<PlatformWebsite> platformwebsitesList = PlatformWebsiteResult.parseFrom(iGDBWrapper.apiProtoRequest(Endpoints.PLATFORM_WEBSITES, APICalypse.buildQuery())).getPlatformwebsitesList();
        Intrinsics.checkNotNullExpressionValue(platformwebsitesList, "getPlatformwebsitesList(...)");
        return platformwebsitesList;
    }

    public static final List<PlayerPerspective> playerPerspectives(IGDBWrapper iGDBWrapper, APICalypse APICalypse) throws RequestException {
        Intrinsics.checkNotNullParameter(iGDBWrapper, "<this>");
        Intrinsics.checkNotNullParameter(APICalypse, "APICalypse");
        List<PlayerPerspective> playerperspectivesList = PlayerPerspectiveResult.parseFrom(iGDBWrapper.apiProtoRequest(Endpoints.PLAYER_PERSPECTIVES, APICalypse.buildQuery())).getPlayerperspectivesList();
        Intrinsics.checkNotNullExpressionValue(playerperspectivesList, "getPlayerperspectivesList(...)");
        return playerperspectivesList;
    }

    public static final List<PlatformFamily> platformFamilies(IGDBWrapper iGDBWrapper, APICalypse APICalypse) throws RequestException {
        Intrinsics.checkNotNullParameter(iGDBWrapper, "<this>");
        Intrinsics.checkNotNullParameter(APICalypse, "APICalypse");
        List<PlatformFamily> platformfamiliesList = PlatformFamilyResult.parseFrom(iGDBWrapper.apiProtoRequest(Endpoints.PLATFORM_FAMILIES, APICalypse.buildQuery())).getPlatformfamiliesList();
        Intrinsics.checkNotNullExpressionValue(platformfamiliesList, "getPlatformfamiliesList(...)");
        return platformfamiliesList;
    }

    public static final List<Region> regions(IGDBWrapper iGDBWrapper, APICalypse APICalypse) throws RequestException {
        Intrinsics.checkNotNullParameter(iGDBWrapper, "<this>");
        Intrinsics.checkNotNullParameter(APICalypse, "APICalypse");
        List<Region> regionsList = RegionResult.parseFrom(iGDBWrapper.apiProtoRequest(Endpoints.REGIONS, APICalypse.buildQuery())).getRegionsList();
        Intrinsics.checkNotNullExpressionValue(regionsList, "getRegionsList(...)");
        return regionsList;
    }

    public static final List<ReleaseDate> releaseDates(IGDBWrapper iGDBWrapper, APICalypse APICalypse) throws RequestException {
        Intrinsics.checkNotNullParameter(iGDBWrapper, "<this>");
        Intrinsics.checkNotNullParameter(APICalypse, "APICalypse");
        List<ReleaseDate> releasedatesList = ReleaseDateResult.parseFrom(iGDBWrapper.apiProtoRequest(Endpoints.RELEASE_DATES, APICalypse.buildQuery())).getReleasedatesList();
        Intrinsics.checkNotNullExpressionValue(releasedatesList, "getReleasedatesList(...)");
        return releasedatesList;
    }

    public static final List<Screenshot> screenshots(IGDBWrapper iGDBWrapper, APICalypse APICalypse) throws RequestException {
        Intrinsics.checkNotNullParameter(iGDBWrapper, "<this>");
        Intrinsics.checkNotNullParameter(APICalypse, "APICalypse");
        List<Screenshot> screenshotsList = ScreenshotResult.parseFrom(iGDBWrapper.apiProtoRequest(Endpoints.SCREENSHOTS, APICalypse.buildQuery())).getScreenshotsList();
        Intrinsics.checkNotNullExpressionValue(screenshotsList, "getScreenshotsList(...)");
        return screenshotsList;
    }

    public static final List<Search> search(IGDBWrapper iGDBWrapper, APICalypse APICalypse) throws RequestException {
        Intrinsics.checkNotNullParameter(iGDBWrapper, "<this>");
        Intrinsics.checkNotNullParameter(APICalypse, "APICalypse");
        List<Search> searchesList = SearchResult.parseFrom(iGDBWrapper.apiProtoRequest(Endpoints.SEARCH, APICalypse.buildQuery())).getSearchesList();
        Intrinsics.checkNotNullExpressionValue(searchesList, "getSearchesList(...)");
        return searchesList;
    }

    public static final List<Theme> themes(IGDBWrapper iGDBWrapper, APICalypse APICalypse) throws RequestException {
        Intrinsics.checkNotNullParameter(iGDBWrapper, "<this>");
        Intrinsics.checkNotNullParameter(APICalypse, "APICalypse");
        List<Theme> themesList = ThemeResult.parseFrom(iGDBWrapper.apiProtoRequest(Endpoints.THEMES, APICalypse.buildQuery())).getThemesList();
        Intrinsics.checkNotNullExpressionValue(themesList, "getThemesList(...)");
        return themesList;
    }

    public static final List<Website> websites(IGDBWrapper iGDBWrapper, APICalypse APICalypse) throws RequestException {
        Intrinsics.checkNotNullParameter(iGDBWrapper, "<this>");
        Intrinsics.checkNotNullParameter(APICalypse, "APICalypse");
        List<Website> websitesList = WebsiteResult.parseFrom(iGDBWrapper.apiProtoRequest(Endpoints.WEBSITES, APICalypse.buildQuery())).getWebsitesList();
        Intrinsics.checkNotNullExpressionValue(websitesList, "getWebsitesList(...)");
        return websitesList;
    }

    public static final List<Event> events(IGDBWrapper iGDBWrapper, APICalypse APICalypse) throws RequestException {
        Intrinsics.checkNotNullParameter(iGDBWrapper, "<this>");
        Intrinsics.checkNotNullParameter(APICalypse, "APICalypse");
        List<Event> eventsList = EventResult.parseFrom(iGDBWrapper.apiProtoRequest(Endpoints.EVENTS, APICalypse.buildQuery())).getEventsList();
        Intrinsics.checkNotNullExpressionValue(eventsList, "getEventsList(...)");
        return eventsList;
    }

    public static final List<EventLogo> eventLogos(IGDBWrapper iGDBWrapper, APICalypse APICalypse) throws RequestException {
        Intrinsics.checkNotNullParameter(iGDBWrapper, "<this>");
        Intrinsics.checkNotNullParameter(APICalypse, "APICalypse");
        List<EventLogo> eventlogosList = EventLogoResult.parseFrom(iGDBWrapper.apiProtoRequest(Endpoints.EVENT_LOGOS, APICalypse.buildQuery())).getEventlogosList();
        Intrinsics.checkNotNullExpressionValue(eventlogosList, "getEventlogosList(...)");
        return eventlogosList;
    }

    public static final List<EventNetwork> eventNetworks(IGDBWrapper iGDBWrapper, APICalypse APICalypse) throws RequestException {
        Intrinsics.checkNotNullParameter(iGDBWrapper, "<this>");
        Intrinsics.checkNotNullParameter(APICalypse, "APICalypse");
        List<EventNetwork> eventnetworksList = EventNetworkResult.parseFrom(iGDBWrapper.apiProtoRequest(Endpoints.EVENT_NETWORKS, APICalypse.buildQuery())).getEventnetworksList();
        Intrinsics.checkNotNullExpressionValue(eventnetworksList, "getEventnetworksList(...)");
        return eventnetworksList;
    }

    public static final List<NetworkType> networkTypes(IGDBWrapper iGDBWrapper, APICalypse APICalypse) throws RequestException {
        Intrinsics.checkNotNullParameter(iGDBWrapper, "<this>");
        Intrinsics.checkNotNullParameter(APICalypse, "APICalypse");
        List<NetworkType> networktypesList = NetworkTypeResult.parseFrom(iGDBWrapper.apiProtoRequest(Endpoints.NETWORK_TYPES, APICalypse.buildQuery())).getNetworktypesList();
        Intrinsics.checkNotNullExpressionValue(networktypesList, "getNetworktypesList(...)");
        return networktypesList;
    }

    public static final List<CollectionRelation> collectionRelations(IGDBWrapper iGDBWrapper, APICalypse APICalypse) throws RequestException {
        Intrinsics.checkNotNullParameter(iGDBWrapper, "<this>");
        Intrinsics.checkNotNullParameter(APICalypse, "APICalypse");
        List<CollectionRelation> collectionrelationsList = CollectionRelationResult.parseFrom(iGDBWrapper.apiProtoRequest(Endpoints.COLLECTION_RELATIONS, APICalypse.buildQuery())).getCollectionrelationsList();
        Intrinsics.checkNotNullExpressionValue(collectionrelationsList, "getCollectionrelationsList(...)");
        return collectionrelationsList;
    }

    public static final List<CollectionRelationType> collectionRelationTypes(IGDBWrapper iGDBWrapper, APICalypse APICalypse) throws RequestException {
        Intrinsics.checkNotNullParameter(iGDBWrapper, "<this>");
        Intrinsics.checkNotNullParameter(APICalypse, "APICalypse");
        List<CollectionRelationType> collectionrelationtypesList = CollectionRelationTypeResult.parseFrom(iGDBWrapper.apiProtoRequest(Endpoints.COLLECTION_RELATION_TYPES, APICalypse.buildQuery())).getCollectionrelationtypesList();
        Intrinsics.checkNotNullExpressionValue(collectionrelationtypesList, "getCollectionrelationtypesList(...)");
        return collectionrelationtypesList;
    }

    public static final List<CollectionType> collectionTypes(IGDBWrapper iGDBWrapper, APICalypse APICalypse) throws RequestException {
        Intrinsics.checkNotNullParameter(iGDBWrapper, "<this>");
        Intrinsics.checkNotNullParameter(APICalypse, "APICalypse");
        List<CollectionType> collectiontypesList = CollectionTypeResult.parseFrom(iGDBWrapper.apiProtoRequest(Endpoints.COLLECTION_TYPES, APICalypse.buildQuery())).getCollectiontypesList();
        Intrinsics.checkNotNullExpressionValue(collectiontypesList, "getCollectiontypesList(...)");
        return collectiontypesList;
    }

    public static final List<CollectionMembership> collectionMemberships(IGDBWrapper iGDBWrapper, APICalypse APICalypse) throws RequestException {
        Intrinsics.checkNotNullParameter(iGDBWrapper, "<this>");
        Intrinsics.checkNotNullParameter(APICalypse, "APICalypse");
        List<CollectionMembership> collectionmembershipsList = CollectionMembershipResult.parseFrom(iGDBWrapper.apiProtoRequest(Endpoints.COLLECTION_MEMBERSHIPS, APICalypse.buildQuery())).getCollectionmembershipsList();
        Intrinsics.checkNotNullExpressionValue(collectionmembershipsList, "getCollectionmembershipsList(...)");
        return collectionmembershipsList;
    }

    public static final List<CollectionMembershipType> collectionMembershipTypes(IGDBWrapper iGDBWrapper, APICalypse APICalypse) throws RequestException {
        Intrinsics.checkNotNullParameter(iGDBWrapper, "<this>");
        Intrinsics.checkNotNullParameter(APICalypse, "APICalypse");
        List<CollectionMembershipType> collectionmembershiptypesList = CollectionMembershipTypeResult.parseFrom(iGDBWrapper.apiProtoRequest(Endpoints.COLLECTION_MEMBERSHIP_TYPES, APICalypse.buildQuery())).getCollectionmembershiptypesList();
        Intrinsics.checkNotNullExpressionValue(collectionmembershiptypesList, "getCollectionmembershiptypesList(...)");
        return collectionmembershiptypesList;
    }

    public static final List<PopularityType> popularityTypes(IGDBWrapper iGDBWrapper, APICalypse APICalypse) throws RequestException {
        Intrinsics.checkNotNullParameter(iGDBWrapper, "<this>");
        Intrinsics.checkNotNullParameter(APICalypse, "APICalypse");
        List<PopularityType> popularitytypesList = PopularityTypeResult.parseFrom(iGDBWrapper.apiProtoRequest(Endpoints.POPULARITY_TYPES, APICalypse.buildQuery())).getPopularitytypesList();
        Intrinsics.checkNotNullExpressionValue(popularitytypesList, "getPopularitytypesList(...)");
        return popularitytypesList;
    }

    public static final List<PopularityPrimitive> popularityPrimitives(IGDBWrapper iGDBWrapper, APICalypse APICalypse) throws RequestException {
        Intrinsics.checkNotNullParameter(iGDBWrapper, "<this>");
        Intrinsics.checkNotNullParameter(APICalypse, "APICalypse");
        List<PopularityPrimitive> popularityprimitivesList = PopularityPrimitiveResult.parseFrom(iGDBWrapper.apiProtoRequest(Endpoints.COLLECTION_MEMBERSHIP_TYPES, APICalypse.buildQuery())).getPopularityprimitivesList();
        Intrinsics.checkNotNullExpressionValue(popularityprimitivesList, "getPopularityprimitivesList(...)");
        return popularityprimitivesList;
    }
}
