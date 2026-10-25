package com.api.igdb.request;

import com.api.igdb.apicalypse.APICalypse;
import com.api.igdb.exceptions.RequestException;
import com.api.igdb.utils.Endpoints;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: JsonRequest.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b6\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010\u0006\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010\u0007\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010\b\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010\t\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010\n\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010\u000b\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010\f\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010\r\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010\u000e\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010\u000f\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010\u0010\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010\u0011\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010\u0012\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010\u0013\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010\u0014\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010\u0015\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010\u0016\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010\u0017\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010\u0018\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010\u0019\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010\u001a\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010\u001b\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010\u001c\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010\u001d\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010\u001e\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010\u001f\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010 \u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010!\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010\"\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010#\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010$\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010%\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010&\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010'\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010(\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010)\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010*\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010+\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010,\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010-\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010.\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u0010/\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u00100\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u00101\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u00102\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u00103\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u00104\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u00105\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u00106\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u00107\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u00108\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0012\u00109\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006:"}, d2 = {"jsonAgeRatingContentDescriptions", "", "Lcom/api/igdb/request/IGDBWrapper;", "APICalypse", "Lcom/api/igdb/apicalypse/APICalypse;", "jsonAgeRatings", "jsonAlternativeNames", "jsonArtworks", "jsonCharacterMugShots", "jsonCharacters", "jsonCollectionMembershipTypes", "jsonCollectionMemberships", "jsonCollectionRelationTypes", "jsonCollectionRelations", "jsonCollectionTypes", "jsonCollections", "jsonCompanies", "jsonCompanyLogos", "jsonCompanyWebsites", "jsonCovers", "jsonEventLogos", "jsonEventNetworks", "jsonEvents", "jsonExternalGames", "jsonFranchises", "jsonGameEngineLogos", "jsonGameEngines", "jsonGameLocalizations", "jsonGameModes", "jsonGameVersion", "jsonGameVersionFeatureValues", "jsonGameVersionFeatures", "jsonGameVideos", "jsonGames", "jsonGenres", "jsonInvolvedCompanies", "jsonKeywords", "jsonLanguageSupportTypes", "jsonLanguageSupports", "jsonLanguages", "jsonMultiplayerModes", "jsonNetworkTypes", "jsonPlatformFamilies", "jsonPlatformLogos", "jsonPlatformVersionCompanies", "jsonPlatformVersionReleaseDates", "jsonPlatformVersions", "jsonPlatformWebsites", "jsonPlatforms", "jsonPlayerPerspectives", "jsonPopularityPrimitives", "jsonPopularityTypes", "jsonRegions", "jsonReleaseDates", "jsonScreenshots", "jsonSearch", "jsonThemes", "jsonWebsites", "igdb-api-jvm"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class JsonRequestKt {
    public static final String jsonAgeRatings(IGDBWrapper iGDBWrapper, APICalypse APICalypse) throws RequestException {
        Intrinsics.checkNotNullParameter(iGDBWrapper, "<this>");
        Intrinsics.checkNotNullParameter(APICalypse, "APICalypse");
        return iGDBWrapper.apiJsonRequest(Endpoints.AGE_RATINGS, APICalypse.buildQuery());
    }

    public static final String jsonAgeRatingContentDescriptions(IGDBWrapper iGDBWrapper, APICalypse APICalypse) throws RequestException {
        Intrinsics.checkNotNullParameter(iGDBWrapper, "<this>");
        Intrinsics.checkNotNullParameter(APICalypse, "APICalypse");
        return iGDBWrapper.apiJsonRequest(Endpoints.AGE_RATING_CONTENT_DESCRIPTIONS, APICalypse.buildQuery());
    }

    public static final String jsonAlternativeNames(IGDBWrapper iGDBWrapper, APICalypse APICalypse) throws RequestException {
        Intrinsics.checkNotNullParameter(iGDBWrapper, "<this>");
        Intrinsics.checkNotNullParameter(APICalypse, "APICalypse");
        return iGDBWrapper.apiJsonRequest(Endpoints.ALTERNATIVE_NAMES, APICalypse.buildQuery());
    }

    public static final String jsonArtworks(IGDBWrapper iGDBWrapper, APICalypse APICalypse) throws RequestException {
        Intrinsics.checkNotNullParameter(iGDBWrapper, "<this>");
        Intrinsics.checkNotNullParameter(APICalypse, "APICalypse");
        return iGDBWrapper.apiJsonRequest(Endpoints.ARTWORKS, APICalypse.buildQuery());
    }

    public static final String jsonCharacters(IGDBWrapper iGDBWrapper, APICalypse APICalypse) throws RequestException {
        Intrinsics.checkNotNullParameter(iGDBWrapper, "<this>");
        Intrinsics.checkNotNullParameter(APICalypse, "APICalypse");
        return iGDBWrapper.apiJsonRequest(Endpoints.CHARACTERS, APICalypse.buildQuery());
    }

    public static final String jsonCollections(IGDBWrapper iGDBWrapper, APICalypse APICalypse) throws RequestException {
        Intrinsics.checkNotNullParameter(iGDBWrapper, "<this>");
        Intrinsics.checkNotNullParameter(APICalypse, "APICalypse");
        return iGDBWrapper.apiJsonRequest(Endpoints.COLLECTIONS, APICalypse.buildQuery());
    }

    public static final String jsonCharacterMugShots(IGDBWrapper iGDBWrapper, APICalypse APICalypse) throws RequestException {
        Intrinsics.checkNotNullParameter(iGDBWrapper, "<this>");
        Intrinsics.checkNotNullParameter(APICalypse, "APICalypse");
        return iGDBWrapper.apiJsonRequest(Endpoints.CHARACTER_MUG_SHOTS, APICalypse.buildQuery());
    }

    public static final String jsonCompanies(IGDBWrapper iGDBWrapper, APICalypse APICalypse) throws RequestException {
        Intrinsics.checkNotNullParameter(iGDBWrapper, "<this>");
        Intrinsics.checkNotNullParameter(APICalypse, "APICalypse");
        return iGDBWrapper.apiJsonRequest(Endpoints.COMPANIES, APICalypse.buildQuery());
    }

    public static final String jsonCompanyWebsites(IGDBWrapper iGDBWrapper, APICalypse APICalypse) throws RequestException {
        Intrinsics.checkNotNullParameter(iGDBWrapper, "<this>");
        Intrinsics.checkNotNullParameter(APICalypse, "APICalypse");
        return iGDBWrapper.apiJsonRequest(Endpoints.COMPANY_WEBSITES, APICalypse.buildQuery());
    }

    public static final String jsonCompanyLogos(IGDBWrapper iGDBWrapper, APICalypse APICalypse) throws RequestException {
        Intrinsics.checkNotNullParameter(iGDBWrapper, "<this>");
        Intrinsics.checkNotNullParameter(APICalypse, "APICalypse");
        return iGDBWrapper.apiJsonRequest(Endpoints.COMPANY_LOGOS, APICalypse.buildQuery());
    }

    public static final String jsonCovers(IGDBWrapper iGDBWrapper, APICalypse APICalypse) throws RequestException {
        Intrinsics.checkNotNullParameter(iGDBWrapper, "<this>");
        Intrinsics.checkNotNullParameter(APICalypse, "APICalypse");
        return iGDBWrapper.apiJsonRequest(Endpoints.COVERS, APICalypse.buildQuery());
    }

    public static final String jsonExternalGames(IGDBWrapper iGDBWrapper, APICalypse APICalypse) throws RequestException {
        Intrinsics.checkNotNullParameter(iGDBWrapper, "<this>");
        Intrinsics.checkNotNullParameter(APICalypse, "APICalypse");
        return iGDBWrapper.apiJsonRequest(Endpoints.EXTERNAL_GAMES, APICalypse.buildQuery());
    }

    public static final String jsonFranchises(IGDBWrapper iGDBWrapper, APICalypse APICalypse) throws RequestException {
        Intrinsics.checkNotNullParameter(iGDBWrapper, "<this>");
        Intrinsics.checkNotNullParameter(APICalypse, "APICalypse");
        return iGDBWrapper.apiJsonRequest(Endpoints.FRANCHISES, APICalypse.buildQuery());
    }

    public static final String jsonGames(IGDBWrapper iGDBWrapper, APICalypse APICalypse) throws RequestException {
        Intrinsics.checkNotNullParameter(iGDBWrapper, "<this>");
        Intrinsics.checkNotNullParameter(APICalypse, "APICalypse");
        return iGDBWrapper.apiJsonRequest(Endpoints.GAMES, APICalypse.buildQuery());
    }

    public static final String jsonGameEngines(IGDBWrapper iGDBWrapper, APICalypse APICalypse) throws RequestException {
        Intrinsics.checkNotNullParameter(iGDBWrapper, "<this>");
        Intrinsics.checkNotNullParameter(APICalypse, "APICalypse");
        return iGDBWrapper.apiJsonRequest(Endpoints.GAME_ENGINES, APICalypse.buildQuery());
    }

    public static final String jsonGameEngineLogos(IGDBWrapper iGDBWrapper, APICalypse APICalypse) throws RequestException {
        Intrinsics.checkNotNullParameter(iGDBWrapper, "<this>");
        Intrinsics.checkNotNullParameter(APICalypse, "APICalypse");
        return iGDBWrapper.apiJsonRequest(Endpoints.GAME_ENGINE_LOGOS, APICalypse.buildQuery());
    }

    public static final String jsonGameLocalizations(IGDBWrapper iGDBWrapper, APICalypse APICalypse) throws RequestException {
        Intrinsics.checkNotNullParameter(iGDBWrapper, "<this>");
        Intrinsics.checkNotNullParameter(APICalypse, "APICalypse");
        return iGDBWrapper.apiJsonRequest(Endpoints.GAME_LOCALIZATIONS, APICalypse.buildQuery());
    }

    public static final String jsonGameModes(IGDBWrapper iGDBWrapper, APICalypse APICalypse) throws RequestException {
        Intrinsics.checkNotNullParameter(iGDBWrapper, "<this>");
        Intrinsics.checkNotNullParameter(APICalypse, "APICalypse");
        return iGDBWrapper.apiJsonRequest(Endpoints.GAME_MODES, APICalypse.buildQuery());
    }

    public static final String jsonGameVersion(IGDBWrapper iGDBWrapper, APICalypse APICalypse) throws RequestException {
        Intrinsics.checkNotNullParameter(iGDBWrapper, "<this>");
        Intrinsics.checkNotNullParameter(APICalypse, "APICalypse");
        return iGDBWrapper.apiJsonRequest(Endpoints.GAME_VERSIONS, APICalypse.buildQuery());
    }

    public static final String jsonGameVersionFeatures(IGDBWrapper iGDBWrapper, APICalypse APICalypse) throws RequestException {
        Intrinsics.checkNotNullParameter(iGDBWrapper, "<this>");
        Intrinsics.checkNotNullParameter(APICalypse, "APICalypse");
        return iGDBWrapper.apiJsonRequest(Endpoints.GAME_VERSION_FEATURES, APICalypse.buildQuery());
    }

    public static final String jsonGameVersionFeatureValues(IGDBWrapper iGDBWrapper, APICalypse APICalypse) throws RequestException {
        Intrinsics.checkNotNullParameter(iGDBWrapper, "<this>");
        Intrinsics.checkNotNullParameter(APICalypse, "APICalypse");
        return iGDBWrapper.apiJsonRequest(Endpoints.GAME_VERSION_FEATURE_VALUES, APICalypse.buildQuery());
    }

    public static final String jsonGameVideos(IGDBWrapper iGDBWrapper, APICalypse APICalypse) throws RequestException {
        Intrinsics.checkNotNullParameter(iGDBWrapper, "<this>");
        Intrinsics.checkNotNullParameter(APICalypse, "APICalypse");
        return iGDBWrapper.apiJsonRequest(Endpoints.GAME_VIDEOS, APICalypse.buildQuery());
    }

    public static final String jsonGenres(IGDBWrapper iGDBWrapper, APICalypse APICalypse) throws RequestException {
        Intrinsics.checkNotNullParameter(iGDBWrapper, "<this>");
        Intrinsics.checkNotNullParameter(APICalypse, "APICalypse");
        return iGDBWrapper.apiJsonRequest(Endpoints.GENRES, APICalypse.buildQuery());
    }

    public static final String jsonInvolvedCompanies(IGDBWrapper iGDBWrapper, APICalypse APICalypse) throws RequestException {
        Intrinsics.checkNotNullParameter(iGDBWrapper, "<this>");
        Intrinsics.checkNotNullParameter(APICalypse, "APICalypse");
        return iGDBWrapper.apiJsonRequest(Endpoints.INVOLVED_COMPANIES, APICalypse.buildQuery());
    }

    public static final String jsonKeywords(IGDBWrapper iGDBWrapper, APICalypse APICalypse) throws RequestException {
        Intrinsics.checkNotNullParameter(iGDBWrapper, "<this>");
        Intrinsics.checkNotNullParameter(APICalypse, "APICalypse");
        return iGDBWrapper.apiJsonRequest(Endpoints.KEYWORDS, APICalypse.buildQuery());
    }

    public static final String jsonLanguages(IGDBWrapper iGDBWrapper, APICalypse APICalypse) throws RequestException {
        Intrinsics.checkNotNullParameter(iGDBWrapper, "<this>");
        Intrinsics.checkNotNullParameter(APICalypse, "APICalypse");
        return iGDBWrapper.apiJsonRequest(Endpoints.LANGUAGES, APICalypse.buildQuery());
    }

    public static final String jsonLanguageSupports(IGDBWrapper iGDBWrapper, APICalypse APICalypse) throws RequestException {
        Intrinsics.checkNotNullParameter(iGDBWrapper, "<this>");
        Intrinsics.checkNotNullParameter(APICalypse, "APICalypse");
        return iGDBWrapper.apiJsonRequest(Endpoints.LANGUAGE_SUPPORTS, APICalypse.buildQuery());
    }

    public static final String jsonLanguageSupportTypes(IGDBWrapper iGDBWrapper, APICalypse APICalypse) throws RequestException {
        Intrinsics.checkNotNullParameter(iGDBWrapper, "<this>");
        Intrinsics.checkNotNullParameter(APICalypse, "APICalypse");
        return iGDBWrapper.apiJsonRequest(Endpoints.LANGUAGE_SUPPORT_TYPES, APICalypse.buildQuery());
    }

    public static final String jsonMultiplayerModes(IGDBWrapper iGDBWrapper, APICalypse APICalypse) throws RequestException {
        Intrinsics.checkNotNullParameter(iGDBWrapper, "<this>");
        Intrinsics.checkNotNullParameter(APICalypse, "APICalypse");
        return iGDBWrapper.apiJsonRequest(Endpoints.MULTIPLAYER_MODES, APICalypse.buildQuery());
    }

    public static final String jsonPlatforms(IGDBWrapper iGDBWrapper, APICalypse APICalypse) throws RequestException {
        Intrinsics.checkNotNullParameter(iGDBWrapper, "<this>");
        Intrinsics.checkNotNullParameter(APICalypse, "APICalypse");
        return iGDBWrapper.apiJsonRequest(Endpoints.PLATFORMS, APICalypse.buildQuery());
    }

    public static final String jsonPlatformLogos(IGDBWrapper iGDBWrapper, APICalypse APICalypse) throws RequestException {
        Intrinsics.checkNotNullParameter(iGDBWrapper, "<this>");
        Intrinsics.checkNotNullParameter(APICalypse, "APICalypse");
        return iGDBWrapper.apiJsonRequest(Endpoints.PLATFORM_LOGOS, APICalypse.buildQuery());
    }

    public static final String jsonPlatformVersions(IGDBWrapper iGDBWrapper, APICalypse APICalypse) throws RequestException {
        Intrinsics.checkNotNullParameter(iGDBWrapper, "<this>");
        Intrinsics.checkNotNullParameter(APICalypse, "APICalypse");
        return iGDBWrapper.apiJsonRequest(Endpoints.PLATFORM_VERSIONS, APICalypse.buildQuery());
    }

    public static final String jsonPlatformVersionCompanies(IGDBWrapper iGDBWrapper, APICalypse APICalypse) throws RequestException {
        Intrinsics.checkNotNullParameter(iGDBWrapper, "<this>");
        Intrinsics.checkNotNullParameter(APICalypse, "APICalypse");
        return iGDBWrapper.apiJsonRequest(Endpoints.PLATFORM_VERSION_COMPANIES, APICalypse.buildQuery());
    }

    public static final String jsonRegions(IGDBWrapper iGDBWrapper, APICalypse APICalypse) throws RequestException {
        Intrinsics.checkNotNullParameter(iGDBWrapper, "<this>");
        Intrinsics.checkNotNullParameter(APICalypse, "APICalypse");
        return iGDBWrapper.apiJsonRequest(Endpoints.REGIONS, APICalypse.buildQuery());
    }

    public static final String jsonPlatformVersionReleaseDates(IGDBWrapper iGDBWrapper, APICalypse APICalypse) throws RequestException {
        Intrinsics.checkNotNullParameter(iGDBWrapper, "<this>");
        Intrinsics.checkNotNullParameter(APICalypse, "APICalypse");
        return iGDBWrapper.apiJsonRequest(Endpoints.PLATFORM_VERSION_RELEASE_DATES, APICalypse.buildQuery());
    }

    public static final String jsonPlatformWebsites(IGDBWrapper iGDBWrapper, APICalypse APICalypse) throws RequestException {
        Intrinsics.checkNotNullParameter(iGDBWrapper, "<this>");
        Intrinsics.checkNotNullParameter(APICalypse, "APICalypse");
        return iGDBWrapper.apiJsonRequest(Endpoints.PLATFORM_WEBSITES, APICalypse.buildQuery());
    }

    public static final String jsonPlayerPerspectives(IGDBWrapper iGDBWrapper, APICalypse APICalypse) throws RequestException {
        Intrinsics.checkNotNullParameter(iGDBWrapper, "<this>");
        Intrinsics.checkNotNullParameter(APICalypse, "APICalypse");
        return iGDBWrapper.apiJsonRequest(Endpoints.PLAYER_PERSPECTIVES, APICalypse.buildQuery());
    }

    public static final String jsonPlatformFamilies(IGDBWrapper iGDBWrapper, APICalypse APICalypse) throws RequestException {
        Intrinsics.checkNotNullParameter(iGDBWrapper, "<this>");
        Intrinsics.checkNotNullParameter(APICalypse, "APICalypse");
        return iGDBWrapper.apiJsonRequest(Endpoints.PLATFORM_FAMILIES, APICalypse.buildQuery());
    }

    public static final String jsonReleaseDates(IGDBWrapper iGDBWrapper, APICalypse APICalypse) throws RequestException {
        Intrinsics.checkNotNullParameter(iGDBWrapper, "<this>");
        Intrinsics.checkNotNullParameter(APICalypse, "APICalypse");
        return iGDBWrapper.apiJsonRequest(Endpoints.RELEASE_DATES, APICalypse.buildQuery());
    }

    public static final String jsonScreenshots(IGDBWrapper iGDBWrapper, APICalypse APICalypse) throws RequestException {
        Intrinsics.checkNotNullParameter(iGDBWrapper, "<this>");
        Intrinsics.checkNotNullParameter(APICalypse, "APICalypse");
        return iGDBWrapper.apiJsonRequest(Endpoints.SCREENSHOTS, APICalypse.buildQuery());
    }

    public static final String jsonSearch(IGDBWrapper iGDBWrapper, APICalypse APICalypse) throws RequestException {
        Intrinsics.checkNotNullParameter(iGDBWrapper, "<this>");
        Intrinsics.checkNotNullParameter(APICalypse, "APICalypse");
        return iGDBWrapper.apiJsonRequest(Endpoints.SEARCH, APICalypse.buildQuery());
    }

    public static final String jsonThemes(IGDBWrapper iGDBWrapper, APICalypse APICalypse) throws RequestException {
        Intrinsics.checkNotNullParameter(iGDBWrapper, "<this>");
        Intrinsics.checkNotNullParameter(APICalypse, "APICalypse");
        return iGDBWrapper.apiJsonRequest(Endpoints.THEMES, APICalypse.buildQuery());
    }

    public static final String jsonWebsites(IGDBWrapper iGDBWrapper, APICalypse APICalypse) throws RequestException {
        Intrinsics.checkNotNullParameter(iGDBWrapper, "<this>");
        Intrinsics.checkNotNullParameter(APICalypse, "APICalypse");
        return iGDBWrapper.apiJsonRequest(Endpoints.WEBSITES, APICalypse.buildQuery());
    }

    public static final String jsonEvents(IGDBWrapper iGDBWrapper, APICalypse APICalypse) throws RequestException {
        Intrinsics.checkNotNullParameter(iGDBWrapper, "<this>");
        Intrinsics.checkNotNullParameter(APICalypse, "APICalypse");
        return iGDBWrapper.apiJsonRequest(Endpoints.EVENTS, APICalypse.buildQuery());
    }

    public static final String jsonEventLogos(IGDBWrapper iGDBWrapper, APICalypse APICalypse) throws RequestException {
        Intrinsics.checkNotNullParameter(iGDBWrapper, "<this>");
        Intrinsics.checkNotNullParameter(APICalypse, "APICalypse");
        return iGDBWrapper.apiJsonRequest(Endpoints.EVENT_LOGOS, APICalypse.buildQuery());
    }

    public static final String jsonEventNetworks(IGDBWrapper iGDBWrapper, APICalypse APICalypse) throws RequestException {
        Intrinsics.checkNotNullParameter(iGDBWrapper, "<this>");
        Intrinsics.checkNotNullParameter(APICalypse, "APICalypse");
        return iGDBWrapper.apiJsonRequest(Endpoints.EVENT_NETWORKS, APICalypse.buildQuery());
    }

    public static final String jsonNetworkTypes(IGDBWrapper iGDBWrapper, APICalypse APICalypse) throws RequestException {
        Intrinsics.checkNotNullParameter(iGDBWrapper, "<this>");
        Intrinsics.checkNotNullParameter(APICalypse, "APICalypse");
        return iGDBWrapper.apiJsonRequest(Endpoints.NETWORK_TYPES, APICalypse.buildQuery());
    }

    public static final String jsonCollectionRelations(IGDBWrapper iGDBWrapper, APICalypse APICalypse) throws RequestException {
        Intrinsics.checkNotNullParameter(iGDBWrapper, "<this>");
        Intrinsics.checkNotNullParameter(APICalypse, "APICalypse");
        return iGDBWrapper.apiJsonRequest(Endpoints.COLLECTION_RELATIONS, APICalypse.buildQuery());
    }

    public static final String jsonCollectionRelationTypes(IGDBWrapper iGDBWrapper, APICalypse APICalypse) throws RequestException {
        Intrinsics.checkNotNullParameter(iGDBWrapper, "<this>");
        Intrinsics.checkNotNullParameter(APICalypse, "APICalypse");
        return iGDBWrapper.apiJsonRequest(Endpoints.COLLECTION_RELATION_TYPES, APICalypse.buildQuery());
    }

    public static final String jsonCollectionTypes(IGDBWrapper iGDBWrapper, APICalypse APICalypse) throws RequestException {
        Intrinsics.checkNotNullParameter(iGDBWrapper, "<this>");
        Intrinsics.checkNotNullParameter(APICalypse, "APICalypse");
        return iGDBWrapper.apiJsonRequest(Endpoints.COLLECTION_TYPES, APICalypse.buildQuery());
    }

    public static final String jsonCollectionMemberships(IGDBWrapper iGDBWrapper, APICalypse APICalypse) throws RequestException {
        Intrinsics.checkNotNullParameter(iGDBWrapper, "<this>");
        Intrinsics.checkNotNullParameter(APICalypse, "APICalypse");
        return iGDBWrapper.apiJsonRequest(Endpoints.COLLECTION_MEMBERSHIPS, APICalypse.buildQuery());
    }

    public static final String jsonCollectionMembershipTypes(IGDBWrapper iGDBWrapper, APICalypse APICalypse) throws RequestException {
        Intrinsics.checkNotNullParameter(iGDBWrapper, "<this>");
        Intrinsics.checkNotNullParameter(APICalypse, "APICalypse");
        return iGDBWrapper.apiJsonRequest(Endpoints.COLLECTION_MEMBERSHIP_TYPES, APICalypse.buildQuery());
    }

    public static final String jsonPopularityTypes(IGDBWrapper iGDBWrapper, APICalypse APICalypse) throws RequestException {
        Intrinsics.checkNotNullParameter(iGDBWrapper, "<this>");
        Intrinsics.checkNotNullParameter(APICalypse, "APICalypse");
        return iGDBWrapper.apiJsonRequest(Endpoints.POPULARITY_TYPES, APICalypse.buildQuery());
    }

    public static final String jsonPopularityPrimitives(IGDBWrapper iGDBWrapper, APICalypse APICalypse) throws RequestException {
        Intrinsics.checkNotNullParameter(iGDBWrapper, "<this>");
        Intrinsics.checkNotNullParameter(APICalypse, "APICalypse");
        return iGDBWrapper.apiJsonRequest(Endpoints.POPULARITY_PRIMITIVES, APICalypse.buildQuery());
    }
}
