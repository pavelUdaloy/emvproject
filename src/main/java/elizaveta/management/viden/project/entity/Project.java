package elizaveta.management.viden.project.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@SuppressWarnings("JpaDataSourceORMInspection")
@Entity
@Table(name = "projects")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "project")
    private List<User> users;

    @Column(name = "correct_code_implementation_status")
    private String correctCodeImplementationStatus = "N/A";
    @Column(name = "correct_code_implementation_description")
    private String correctCodeImplementationDescription;
    @Column(name = "correct_mobile_site_tracking_status")
    private String correctMobileSiteTrackingStatus = "N/A";
    @Column(name = "correct_mobile_site_tracking_description")
    private String correctMobileSiteTrackingDescription;
    @Column(name = "code_singularity_status")
    private String codeSingularityStatus = "N/A";
    @Column(name = "code_singularity_description")
    private String codeSingularityDescription;
    @Column(name = "correct_single_page_application_tracking_status")
    private String correctSinglePageApplicationTrackingStatus = "N/A";
    @Column(name = "correct_single_page_application_tracking_description")
    private String correctSinglePageApplicationTrackingDescription;
    @Column(name = "cross_domain_tracking_configuration_status")
    private String crossDomainTrackingConfigurationStatus = "N/A";
    @Column(name = "cross_domain_tracking_configuration_description")
    private String crossDomainTrackingConfigurationDescription;
    @Column(name = "self_referrals_status")
    private String selfReferralsStatus = "N/A";
    @Column(name = "self_referrals_description")
    private String selfReferralsDescription;
    @Column(name = "payment_process_referrals_status")
    private String paymentProcessReferralsStatus = "N/A";
    @Column(name = "payment_process_referrals_description")
    private String paymentProcessReferralsDescription;
    @Column(name = "utm_tagging_status")
    private String utmTaggingStatus = "N/A";
    @Column(name = "utm_tagging_description")
    private String utmTaggingDescription;
    @Column(name = "pages_404_error_tracking_status")
    private String pages404ErrorTrackingStatus = "N/A";
    @Column(name = "pages_404_error_tracking_description")
    private String pages404ErrorTrackingDescription;
    @Column(name = "main_domain_in_list_unwanted_referrals_status")
    private String mainDomainInListUnwantedReferralsStatus = "N/A";
    @Column(name = "main_domain_in_list_unwanted_referrals_description")
    private String mainDomainInListUnwantedReferralsDescription;
    @Column(name = "session_timeout_status")
    private String sessionTimeoutStatus = "N/A";
    @Column(name = "session_timeout_description")
    private String sessionTimeoutDescription;
    @Column(name = "lookback_window_status")
    private String lookbackWindowStatus = "N/A";
    @Column(name = "lookback_window_description")
    private String lookbackWindowDescription;
    @Column(name = "user_and_event_data_retention_status")
    private String userAndEventDataRetentionStatus = "N/A";
    @Column(name = "user_and_event_data_retention_description")
    private String userAndEventDataRetentionDescription;
    @Column(name = "ecommerce_data_accuracy_status")
    private String ecommerceDataAccuracyStatus = "N/A";
    @Column(name = "ecommerce_data_accuracy_description")
    private String ecommerceDataAccuracyDescription;
    @Column(name = "traffic_to_not_set_landing_page_status")
    private String trafficToNotSetLandingPageStatus = "N/A";
    @Column(name = "traffic_to_not_set_landing_page_description")
    private String trafficToNotSetLandingPageDescription;
    @Column(name = "currency_status")
    private String currencyStatus = "N/A";
    @Column(name = "currency_description")
    private String currencyDescription;
    @Column(name = "define_internal_traffic_status")
    private String defineInternalTrafficStatus = "N/A";
    @Column(name = "define_internal_traffic_description")
    private String defineInternalTrafficDescription;
    @Column(name = "industry_category_status")
    private String industryCategoryStatus = "N/A";
    @Column(name = "industry_category_description")
    private String industryCategoryDescription;
    @Column(name = "reporting_time_zone_status")
    private String reportingTimeZoneStatus = "N/A";
    @Column(name = "reporting_time_zone_description")
    private String reportingTimeZoneDescription;
    @Column(name = "event_tracking_status")
    private String eventTrackingStatus = "N/A";
    @Column(name = "event_tracking_description")
    private String eventTrackingDescription;
    @Column(name = "conversion_tracking_status")
    private String conversionTrackingStatus = "N/A";
    @Column(name = "conversion_tracking_description")
    private String conversionTrackingDescription;
    @Column(name = "standard_purchase_ecommerce_tracking_implementation_status")
    private String standardPurchaseEcommerceTrackingImplementationStatus = "N/A";
    @Column(name = "standard_purchase_ecommerce_tracking_implementation_description")
    private String standardPurchaseEcommerceTrackingImplementationDescription;
    @Column(name = "enhanced_measurement_status")
    private String enhancedMeasurementStatus = "N/A";
    @Column(name = "enhanced_measurement_description")
    private String enhancedMeasurementDescription;
    @Column(name = "user_id_tracking_implementation_status")
    private String userIdTrackingImplementationStatus = "N/A";
    @Column(name = "user_id_tracking_implementation_description")
    private String userIdTrackingImplementationDescription;
    @Column(name = "enhnanced_ecommerce_tracking_status")
    private String enhnancedEcommerceTrackingStatus = "N/A";
    @Column(name = "enhnanced_ecommerce_tracking_description")
    private String enhnancedEcommerceTrackingDescription;
    @Column(name = "custom_dimensions_and_metrics_tracking_status")
    private String customDimensionsAndMetricsTrackingStatus = "N/A";
    @Column(name = "custom_dimensions_and_metrics_tracking_description")
    private String customDimensionsAndMetricsTrackingDescription;
    @Column(name = "granular_location_and_device_data_collection_status")
    private String granularLocationAndDeviceDataCollectionStatus = "N/A";
    @Column(name = "granular_location_and_device_data_collection_description")
    private String granularLocationAndDeviceDataCollectionDescription;
    @Column(name = "advanced_settings_to_allow_for_ads_personalization_status")
    private String advancedSettingsToAllowForAdsPersonalizationStatus = "N/A";
    @Column(name = "advanced_settings_to_allow_for_ads_personalization_description")
    private String advancedSettingsToAllowForAdsPersonalizationDescription;
    @Column(name = "property_name_status")
    private String propertyNameStatus = "N/A";
    @Column(name = "property_name_description")
    private String propertyNameDescription;
    @Column(name = "stream_name_status")
    private String streamNameStatus = "N/A";
    @Column(name = "stream_name_description")
    private String streamNameDescription;
    @Column(name = "event_tracking_taxonomy_status")
    private String eventTrackingTaxonomyStatus = "N/A";
    @Column(name = "event_tracking_taxonomy_description")
    private String eventTrackingTaxonomyDescription;
    @Column(name = "google_bigquery_linking_status")
    private String googleBigqueryLinkingStatus = "N/A";
    @Column(name = "google_bigquery_linking_description")
    private String googleBigqueryLinkingDescription;
    @Column(name = "library_status")
    private String libraryStatus = "N/A";
    @Column(name = "library_description")
    private String libraryDescription;
    @Column(name = "google_ads_linking_status")
    private String googleAdsLinkingStatus = "N/A";
    @Column(name = "google_ads_linking_description")
    private String googleAdsLinkingDescription;
    @Column(name = "google_search_console_linking_status")
    private String googleSearchConsoleLinkingStatus = "N/A";
    @Column(name = "google_search_console_linking_description")
    private String googleSearchConsoleLinkingDescription;
    @Column(name = "google_merchant_center_linking_status")
    private String googleMerchantCenterLinkingStatus = "N/A";
    @Column(name = "google_merchant_center_linking_description")
    private String googleMerchantCenterLinkingDescription;
    @Column(name = "display_and_video_360_linking_status")
    private String displayAndVideo360LinkingStatus = "N/A";
    @Column(name = "display_and_video_360_linking_description")
    private String displayAndVideo360LinkingDescription;
    @Column(name = "data_import_status")
    private String dataImportStatus = "N/A";
    @Column(name = "data_import_description")
    private String dataImportDescription;
    @Column(name = "ad_manager_linking_status")
    private String adManagerLinkingStatus = "N/A";
    @Column(name = "ad_manager_linking_description")
    private String adManagerLinkingDescription;
    @Column(name = "search_ads_360_linking_status")
    private String searchAds360LinkingStatus = "N/A";
    @Column(name = "search_ads_360_linking_description")
    private String searchAds360LinkingDescription;
    @Column(name = "google_signals_data_collection_status")
    private String googleSignalsDataCollectionStatus = "N/A";
    @Column(name = "google_signals_data_collection_description")
    private String googleSignalsDataCollectionDescription;
    @Column(name = "reporting_attribution_model_status")
    private String reportingAttributionModelStatus = "N/A";
    @Column(name = "reporting_attribution_model_description")
    private String reportingAttributionModelDescription;
    @Column(name = "reporting_attribution_identity_status")
    private String reportingAttributionIdentityStatus = "N/A";
    @Column(name = "reporting_attribution_identity_description")
    private String reportingAttributionIdentityDescription;
    @Column(name = "server_side_tracking_implementation_status")
    private String serverSideTrackingImplementationStatus = "N/A";
    @Column(name = "server_side_tracking_implementation_description")
    private String serverSideTrackingImplementationDescription;
    @Column(name = "consent_mode_status")
    private String consentModeStatus = "N/A";
    @Column(name = "consent_mode_description")
    private String consentModeDescription;
    @Column(name = "pii_data_not_collection_status")
    private String piiDataNotCollectionStatus = "N/A";
    @Column(name = "pii_data_not_collection_description")
    private String piiDataNotCollectionDescription;
}
