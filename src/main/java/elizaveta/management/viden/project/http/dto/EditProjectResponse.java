package elizaveta.management.viden.project.http.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class EditProjectResponse {

    private Integer id;
    private String name;

    private int usersCount;

    private String correctCodeImplementationStatus;
    private String correctCodeImplementationDescription;
    private String correctMobileSiteTrackingStatus;
    private String correctMobileSiteTrackingDescription;
    private String codeSingularityStatus;
    private String codeSingularityDescription;
    private String correctSinglePageApplicationTrackingStatus;
    private String correctSinglePageApplicationTrackingDescription;
    private String crossDomainTrackingConfigurationStatus;
    private String crossDomainTrackingConfigurationDescription;
    private String selfReferralsStatus;
    private String selfReferralsDescription;
    private String paymentProcessReferralsStatus;
    private String paymentProcessReferralsDescription;
    private String utmTaggingStatus;
    private String utmTaggingDescription;
    private String pages404ErrorTrackingStatus;
    private String pages404ErrorTrackingDescription;
    private String mainDomainInListUnwantedReferralsStatus;
    private String mainDomainInListUnwantedReferralsDescription;
    private String sessionTimeoutStatus;
    private String sessionTimeoutDescription;
    private String lookbackWindowStatus;
    private String lookbackWindowDescription;
    private String userAndEventDataRetentionStatus;
    private String userAndEventDataRetentionDescription;
    private String ecommerceDataAccuracyStatus;
    private String ecommerceDataAccuracyDescription;
    private String trafficToNotSetLandingPageStatus;
    private String trafficToNotSetLandingPageDescription;
    private String currencyStatus;
    private String currencyDescription;
    private String defineInternalTrafficStatus;
    private String defineInternalTrafficDescription;
    private String industryCategoryStatus;
    private String industryCategoryDescription;
    private String reportingTimeZoneStatus;
    private String reportingTimeZoneDescription;
    private String eventTrackingStatus;
    private String eventTrackingDescription;
    private String conversionTrackingStatus;
    private String conversionTrackingDescription;
    private String standardPurchaseEcommerceTrackingImplementationStatus;
    private String standardPurchaseEcommerceTrackingImplementationDescription;
    private String enhancedMeasurementStatus;
    private String enhancedMeasurementDescription;
    private String userIdTrackingImplementationStatus;
    private String userIdTrackingImplementationDescription;
    private String enhnancedEcommerceTrackingStatus;
    private String enhnancedEcommerceTrackingDescription;
    private String customDimensionsAndMetricsTrackingStatus;
    private String customDimensionsAndMetricsTrackingDescription;
    private String granularLocationAndDeviceDataCollectionStatus;
    private String granularLocationAndDeviceDataCollectionDescription;
    private String advancedSettingsToAllowForAdsPersonalizationStatus;
    private String advancedSettingsToAllowForAdsPersonalizationDescription;
    private String propertyNameStatus;
    private String propertyNameDescription;
    private String streamNameStatus;
    private String streamNameDescription;
    private String eventTrackingTaxonomyStatus;
    private String eventTrackingTaxonomyDescription;
    private String googleBigqueryLinkingStatus;
    private String googleBigqueryLinkingDescription;
    private String libraryStatus;
    private String libraryDescription;
    private String googleAdsLinkingStatus;
    private String googleAdsLinkingDescription;
    private String googleSearchConsoleLinkingStatus;
    private String googleSearchConsoleLinkingDescription;
    private String googleMerchantCenterLinkingStatus;
    private String googleMerchantCenterLinkingDescription;
    private String displayAndVideo360LinkingStatus;
    private String displayAndVideo360LinkingDescription;
    private String dataImportStatus;
    private String dataImportDescription;
    private String adManagerLinkingStatus;
    private String adManagerLinkingDescription;
    private String searchAds360LinkingStatus;
    private String searchAds360LinkingDescription;
    private String googleSignalsDataCollectionStatus;
    private String googleSignalsDataCollectionDescription;
    private String reportingAttributionModelStatus;
    private String reportingAttributionModelDescription;
    private String reportingAttributionIdentityStatus;
    private String reportingAttributionIdentityDescription;
    private String serverSideTrackingImplementationStatus;
    private String serverSideTrackingImplementationDescription;
    private String consentModeStatus;
    private String consentModeDescription;
    private String piiDataNotCollectionStatus;
    private String piiDataNotCollectionDescription;
}
