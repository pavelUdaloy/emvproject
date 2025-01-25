package elizaveta.management.viden.project.facade;

import elizaveta.management.viden.project.entity.Project;
import elizaveta.management.viden.project.http.dto.CreateProjectRequest;
import elizaveta.management.viden.project.http.dto.CreateProjectResponse;
import elizaveta.management.viden.project.http.dto.EditProjectRequest;
import elizaveta.management.viden.project.http.dto.EditProjectResponse;
import elizaveta.management.viden.project.http.dto.GetProjectResponse;
import elizaveta.management.viden.project.http.dto.GetProjectShortedResponse;
import elizaveta.management.viden.project.service.ProjectService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
@RequiredArgsConstructor
public class ProjectFacade {

    private final ProjectService projectService;

    public CreateProjectResponse create(CreateProjectRequest createProjectRequest) {
        Project project = projectService.checkAndCreate(createProjectRequest.getName());

        return CreateProjectResponse.builder()
                .id(project.getId())
                .name(project.getName())
                .build();
    }

    public List<GetProjectShortedResponse> getAll() {
        return projectService.findAll().stream()
                .map(project -> GetProjectShortedResponse.builder()
                        .id(project.getId())
                        .name(project.getName())
                        .build())
                .collect(Collectors.toList());
    }

    public void delete(int id) {
        projectService.delete(id);
    }

    public EditProjectResponse edit(int id, EditProjectRequest editProjectRequest) {
        Project project = projectService.edit(id, editProjectRequest);
        return mapToEditProjectResponse(project);
    }

    public GetProjectResponse getById(int id) {
        Project project = projectService.findById(id);
        return mapToGetProjectResponse(project);
    }

    private static EditProjectResponse mapToEditProjectResponse(Project project) {
        return EditProjectResponse.builder()
                .id(project.getId())
                .name(project.getName())
                .usersCount(project.getUsers().size())
                .correctCodeImplementationStatus(project.getCorrectCodeImplementationStatus())
                .correctCodeImplementationDescription(project.getCorrectCodeImplementationDescription())
                .correctMobileSiteTrackingStatus(project.getCorrectMobileSiteTrackingStatus())
                .correctMobileSiteTrackingDescription(project.getCorrectMobileSiteTrackingDescription())
                .codeSingularityStatus(project.getCodeSingularityStatus())
                .codeSingularityDescription(project.getCodeSingularityDescription())
                .correctSinglePageApplicationTrackingStatus(project.getCorrectSinglePageApplicationTrackingStatus())
                .correctSinglePageApplicationTrackingDescription(project.getCorrectSinglePageApplicationTrackingDescription())
                .crossDomainTrackingConfigurationStatus(project.getCrossDomainTrackingConfigurationStatus())
                .crossDomainTrackingConfigurationDescription(project.getCrossDomainTrackingConfigurationDescription())
                .selfReferralsStatus(project.getSelfReferralsStatus())
                .selfReferralsDescription(project.getSelfReferralsDescription())
                .paymentProcessReferralsStatus(project.getPaymentProcessReferralsStatus())
                .paymentProcessReferralsDescription(project.getPaymentProcessReferralsDescription())
                .utmTaggingStatus(project.getUtmTaggingStatus())
                .utmTaggingDescription(project.getUtmTaggingDescription())
                .pages404ErrorTrackingStatus(project.getPages404ErrorTrackingStatus())
                .pages404ErrorTrackingDescription(project.getPages404ErrorTrackingDescription())
                .mainDomainInListUnwantedReferralsStatus(project.getMainDomainInListUnwantedReferralsStatus())
                .mainDomainInListUnwantedReferralsDescription(project.getMainDomainInListUnwantedReferralsDescription())
                .sessionTimeoutStatus(project.getSessionTimeoutStatus())
                .sessionTimeoutDescription(project.getSessionTimeoutDescription())
                .lookbackWindowStatus(project.getLookbackWindowStatus())
                .lookbackWindowDescription(project.getLookbackWindowDescription())
                .userAndEventDataRetentionStatus(project.getUserAndEventDataRetentionStatus())
                .userAndEventDataRetentionDescription(project.getUserAndEventDataRetentionDescription())
                .ecommerceDataAccuracyStatus(project.getEcommerceDataAccuracyStatus())
                .ecommerceDataAccuracyDescription(project.getEcommerceDataAccuracyDescription())
                .trafficToNotSetLandingPageStatus(project.getTrafficToNotSetLandingPageStatus())
                .trafficToNotSetLandingPageDescription(project.getTrafficToNotSetLandingPageDescription())
                .currencyStatus(project.getCurrencyStatus())
                .currencyDescription(project.getCurrencyDescription())
                .defineInternalTrafficStatus(project.getDefineInternalTrafficStatus())
                .defineInternalTrafficDescription(project.getDefineInternalTrafficDescription())
                .industryCategoryStatus(project.getIndustryCategoryStatus())
                .industryCategoryDescription(project.getIndustryCategoryDescription())
                .reportingTimeZoneStatus(project.getReportingTimeZoneStatus())
                .reportingTimeZoneDescription(project.getReportingTimeZoneDescription())
                .eventTrackingStatus(project.getEventTrackingStatus())
                .eventTrackingDescription(project.getEventTrackingDescription())
                .conversionTrackingStatus(project.getConversionTrackingStatus())
                .conversionTrackingDescription(project.getConversionTrackingDescription())
                .standardPurchaseEcommerceTrackingImplementationStatus(project.getStandardPurchaseEcommerceTrackingImplementationStatus())
                .standardPurchaseEcommerceTrackingImplementationDescription(project.getStandardPurchaseEcommerceTrackingImplementationDescription())
                .enhancedMeasurementStatus(project.getEnhancedMeasurementStatus())
                .enhancedMeasurementDescription(project.getEnhancedMeasurementDescription())
                .userIdTrackingImplementationStatus(project.getUserIdTrackingImplementationStatus())
                .userIdTrackingImplementationDescription(project.getUserIdTrackingImplementationDescription())
                .enhnancedEcommerceTrackingStatus(project.getEnhnancedEcommerceTrackingStatus())
                .enhnancedEcommerceTrackingDescription(project.getEnhnancedEcommerceTrackingDescription())
                .customDimensionsAndMetricsTrackingStatus(project.getCustomDimensionsAndMetricsTrackingStatus())
                .customDimensionsAndMetricsTrackingDescription(project.getCustomDimensionsAndMetricsTrackingDescription())
                .granularLocationAndDeviceDataCollectionStatus(project.getGranularLocationAndDeviceDataCollectionStatus())
                .granularLocationAndDeviceDataCollectionDescription(project.getGranularLocationAndDeviceDataCollectionDescription())
                .advancedSettingsToAllowForAdsPersonalizationStatus(project.getAdvancedSettingsToAllowForAdsPersonalizationStatus())
                .advancedSettingsToAllowForAdsPersonalizationDescription(project.getAdvancedSettingsToAllowForAdsPersonalizationDescription())
                .propertyNameStatus(project.getPropertyNameStatus())
                .propertyNameDescription(project.getPropertyNameDescription())
                .streamNameStatus(project.getStreamNameStatus())
                .streamNameDescription(project.getStreamNameDescription())
                .eventTrackingTaxonomyStatus(project.getEventTrackingTaxonomyStatus())
                .eventTrackingTaxonomyDescription(project.getEventTrackingTaxonomyDescription())
                .googleBigqueryLinkingStatus(project.getGoogleBigqueryLinkingStatus())
                .googleBigqueryLinkingDescription(project.getGoogleBigqueryLinkingDescription())
                .libraryStatus(project.getLibraryStatus())
                .libraryDescription(project.getLibraryDescription())
                .googleAdsLinkingStatus(project.getGoogleAdsLinkingStatus())
                .googleAdsLinkingDescription(project.getGoogleAdsLinkingDescription())
                .googleSearchConsoleLinkingStatus(project.getGoogleSearchConsoleLinkingStatus())
                .googleSearchConsoleLinkingDescription(project.getGoogleSearchConsoleLinkingDescription())
                .googleMerchantCenterLinkingStatus(project.getGoogleMerchantCenterLinkingStatus())
                .googleMerchantCenterLinkingDescription(project.getGoogleMerchantCenterLinkingDescription())
                .displayAndVideo360LinkingStatus(project.getDisplayAndVideo360LinkingStatus())
                .displayAndVideo360LinkingDescription(project.getDisplayAndVideo360LinkingDescription())
                .dataImportStatus(project.getDataImportStatus())
                .dataImportDescription(project.getDataImportDescription())
                .adManagerLinkingStatus(project.getAdManagerLinkingStatus())
                .adManagerLinkingDescription(project.getAdManagerLinkingDescription())
                .searchAds360LinkingStatus(project.getSearchAds360LinkingStatus())
                .searchAds360LinkingDescription(project.getSearchAds360LinkingDescription())
                .googleSignalsDataCollectionStatus(project.getGoogleSignalsDataCollectionStatus())
                .googleSignalsDataCollectionDescription(project.getGoogleSignalsDataCollectionDescription())
                .reportingAttributionModelStatus(project.getReportingAttributionModelStatus())
                .reportingAttributionModelDescription(project.getReportingAttributionModelDescription())
                .reportingAttributionIdentityStatus(project.getReportingAttributionIdentityStatus())
                .reportingAttributionIdentityDescription(project.getReportingAttributionIdentityDescription())
                .serverSideTrackingImplementationStatus(project.getServerSideTrackingImplementationStatus())
                .serverSideTrackingImplementationDescription(project.getServerSideTrackingImplementationDescription())
                .consentModeStatus(project.getConsentModeStatus())
                .consentModeDescription(project.getConsentModeDescription())
                .piiDataNotCollectionStatus(project.getPiiDataNotCollectionStatus())
                .piiDataNotCollectionDescription(project.getPiiDataNotCollectionDescription())
                .build();
    }

    private static GetProjectResponse mapToGetProjectResponse(Project project) {
        return GetProjectResponse.builder()
                .id(project.getId())
                .name(project.getName())
                .usersCount(project.getUsers().size())
                .correctCodeImplementationStatus(project.getCorrectCodeImplementationStatus())
                .correctCodeImplementationDescription(project.getCorrectCodeImplementationDescription())
                .correctMobileSiteTrackingStatus(project.getCorrectMobileSiteTrackingStatus())
                .correctMobileSiteTrackingDescription(project.getCorrectMobileSiteTrackingDescription())
                .codeSingularityStatus(project.getCodeSingularityStatus())
                .codeSingularityDescription(project.getCodeSingularityDescription())
                .correctSinglePageApplicationTrackingStatus(project.getCorrectSinglePageApplicationTrackingStatus())
                .correctSinglePageApplicationTrackingDescription(project.getCorrectSinglePageApplicationTrackingDescription())
                .crossDomainTrackingConfigurationStatus(project.getCrossDomainTrackingConfigurationStatus())
                .crossDomainTrackingConfigurationDescription(project.getCrossDomainTrackingConfigurationDescription())
                .selfReferralsStatus(project.getSelfReferralsStatus())
                .selfReferralsDescription(project.getSelfReferralsDescription())
                .paymentProcessReferralsStatus(project.getPaymentProcessReferralsStatus())
                .paymentProcessReferralsDescription(project.getPaymentProcessReferralsDescription())
                .utmTaggingStatus(project.getUtmTaggingStatus())
                .utmTaggingDescription(project.getUtmTaggingDescription())
                .pages404ErrorTrackingStatus(project.getPages404ErrorTrackingStatus())
                .pages404ErrorTrackingDescription(project.getPages404ErrorTrackingDescription())
                .mainDomainInListUnwantedReferralsStatus(project.getMainDomainInListUnwantedReferralsStatus())
                .mainDomainInListUnwantedReferralsDescription(project.getMainDomainInListUnwantedReferralsDescription())
                .sessionTimeoutStatus(project.getSessionTimeoutStatus())
                .sessionTimeoutDescription(project.getSessionTimeoutDescription())
                .lookbackWindowStatus(project.getLookbackWindowStatus())
                .lookbackWindowDescription(project.getLookbackWindowDescription())
                .userAndEventDataRetentionStatus(project.getUserAndEventDataRetentionStatus())
                .userAndEventDataRetentionDescription(project.getUserAndEventDataRetentionDescription())
                .ecommerceDataAccuracyStatus(project.getEcommerceDataAccuracyStatus())
                .ecommerceDataAccuracyDescription(project.getEcommerceDataAccuracyDescription())
                .trafficToNotSetLandingPageStatus(project.getTrafficToNotSetLandingPageStatus())
                .trafficToNotSetLandingPageDescription(project.getTrafficToNotSetLandingPageDescription())
                .currencyStatus(project.getCurrencyStatus())
                .currencyDescription(project.getCurrencyDescription())
                .defineInternalTrafficStatus(project.getDefineInternalTrafficStatus())
                .defineInternalTrafficDescription(project.getDefineInternalTrafficDescription())
                .industryCategoryStatus(project.getIndustryCategoryStatus())
                .industryCategoryDescription(project.getIndustryCategoryDescription())
                .reportingTimeZoneStatus(project.getReportingTimeZoneStatus())
                .reportingTimeZoneDescription(project.getReportingTimeZoneDescription())
                .eventTrackingStatus(project.getEventTrackingStatus())
                .eventTrackingDescription(project.getEventTrackingDescription())
                .conversionTrackingStatus(project.getConversionTrackingStatus())
                .conversionTrackingDescription(project.getConversionTrackingDescription())
                .standardPurchaseEcommerceTrackingImplementationStatus(project.getStandardPurchaseEcommerceTrackingImplementationStatus())
                .standardPurchaseEcommerceTrackingImplementationDescription(project.getStandardPurchaseEcommerceTrackingImplementationDescription())
                .enhancedMeasurementStatus(project.getEnhancedMeasurementStatus())
                .enhancedMeasurementDescription(project.getEnhancedMeasurementDescription())
                .userIdTrackingImplementationStatus(project.getUserIdTrackingImplementationStatus())
                .userIdTrackingImplementationDescription(project.getUserIdTrackingImplementationDescription())
                .enhnancedEcommerceTrackingStatus(project.getEnhnancedEcommerceTrackingStatus())
                .enhnancedEcommerceTrackingDescription(project.getEnhnancedEcommerceTrackingDescription())
                .customDimensionsAndMetricsTrackingStatus(project.getCustomDimensionsAndMetricsTrackingStatus())
                .customDimensionsAndMetricsTrackingDescription(project.getCustomDimensionsAndMetricsTrackingDescription())
                .granularLocationAndDeviceDataCollectionStatus(project.getGranularLocationAndDeviceDataCollectionStatus())
                .granularLocationAndDeviceDataCollectionDescription(project.getGranularLocationAndDeviceDataCollectionDescription())
                .advancedSettingsToAllowForAdsPersonalizationStatus(project.getAdvancedSettingsToAllowForAdsPersonalizationStatus())
                .advancedSettingsToAllowForAdsPersonalizationDescription(project.getAdvancedSettingsToAllowForAdsPersonalizationDescription())
                .propertyNameStatus(project.getPropertyNameStatus())
                .propertyNameDescription(project.getPropertyNameDescription())
                .streamNameStatus(project.getStreamNameStatus())
                .streamNameDescription(project.getStreamNameDescription())
                .eventTrackingTaxonomyStatus(project.getEventTrackingTaxonomyStatus())
                .eventTrackingTaxonomyDescription(project.getEventTrackingTaxonomyDescription())
                .googleBigqueryLinkingStatus(project.getGoogleBigqueryLinkingStatus())
                .googleBigqueryLinkingDescription(project.getGoogleBigqueryLinkingDescription())
                .libraryStatus(project.getLibraryStatus())
                .libraryDescription(project.getLibraryDescription())
                .googleAdsLinkingStatus(project.getGoogleAdsLinkingStatus())
                .googleAdsLinkingDescription(project.getGoogleAdsLinkingDescription())
                .googleSearchConsoleLinkingStatus(project.getGoogleSearchConsoleLinkingStatus())
                .googleSearchConsoleLinkingDescription(project.getGoogleSearchConsoleLinkingDescription())
                .googleMerchantCenterLinkingStatus(project.getGoogleMerchantCenterLinkingStatus())
                .googleMerchantCenterLinkingDescription(project.getGoogleMerchantCenterLinkingDescription())
                .displayAndVideo360LinkingStatus(project.getDisplayAndVideo360LinkingStatus())
                .displayAndVideo360LinkingDescription(project.getDisplayAndVideo360LinkingDescription())
                .dataImportStatus(project.getDataImportStatus())
                .dataImportDescription(project.getDataImportDescription())
                .adManagerLinkingStatus(project.getAdManagerLinkingStatus())
                .adManagerLinkingDescription(project.getAdManagerLinkingDescription())
                .searchAds360LinkingStatus(project.getSearchAds360LinkingStatus())
                .searchAds360LinkingDescription(project.getSearchAds360LinkingDescription())
                .googleSignalsDataCollectionStatus(project.getGoogleSignalsDataCollectionStatus())
                .googleSignalsDataCollectionDescription(project.getGoogleSignalsDataCollectionDescription())
                .reportingAttributionModelStatus(project.getReportingAttributionModelStatus())
                .reportingAttributionModelDescription(project.getReportingAttributionModelDescription())
                .reportingAttributionIdentityStatus(project.getReportingAttributionIdentityStatus())
                .reportingAttributionIdentityDescription(project.getReportingAttributionIdentityDescription())
                .serverSideTrackingImplementationStatus(project.getServerSideTrackingImplementationStatus())
                .serverSideTrackingImplementationDescription(project.getServerSideTrackingImplementationDescription())
                .consentModeStatus(project.getConsentModeStatus())
                .consentModeDescription(project.getConsentModeDescription())
                .piiDataNotCollectionStatus(project.getPiiDataNotCollectionStatus())
                .piiDataNotCollectionDescription(project.getPiiDataNotCollectionDescription())
                .build();
    }
}
