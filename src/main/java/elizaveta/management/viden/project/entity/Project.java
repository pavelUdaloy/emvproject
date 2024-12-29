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

    @Column(nullable = false, name = "correct_code_implementation_status", columnDefinition = "VARCHAR(100) DEFAULT 'N/A'")
    private String correctCodeImplementationStatus;
    @Column(name = "correct_code_implementation_description", columnDefinition = "TEXT")
    private String correctCodeImplementationDescription;
    @Column(nullable = false, name = "correct_mobile_site_tracking_status", columnDefinition = "VARCHAR(100) DEFAULT 'N/A'")
    private String correctMobileSiteTrackingStatus;
    @Column(name = "correct_mobile_site_tracking_description", columnDefinition = "TEXT")
    private String correctMobileSiteTrackingDescription;
    @Column(nullable = false, name = "code_singularity_status", columnDefinition = "VARCHAR(100) DEFAULT 'N/A'")
    private String codeSingularityStatus;
    @Column(name = "code_singularity_description", columnDefinition = "TEXT")
    private String codeSingularityDescription;
    @Column(nullable = false, name = "correct_single_page_application_tracking_status", columnDefinition = "VARCHAR(100) DEFAULT 'N/A'")
    private String correctSinglePageApplicationTrackingStatus;
    @Column(name = "correct_single_page_application_tracking_description", columnDefinition = "TEXT")
    private String correctSinglePageApplicationTrackingDescription;
    @Column(nullable = false, name = "cross_domain_tracking_configuration_status", columnDefinition = "VARCHAR(100) DEFAULT 'N/A'")
    private String crossDomainTrackingConfigurationStatus;
    @Column(name = "cross_domain_tracking_configuration_description", columnDefinition = "TEXT")
    private String crossDomainTrackingConfigurationDescription;
    @Column(nullable = false, name = "self_referrals_status", columnDefinition = "VARCHAR(100) DEFAULT 'N/A'")
    private String selfReferralsStatus;
    @Column(name = "self_referrals_description", columnDefinition = "TEXT")
    private String selfReferralsDescription;
    @Column(nullable = false, name = "payment_process_referrals_status", columnDefinition = "VARCHAR(100) DEFAULT 'N/A'")
    private String paymentProcessReferralsStatus;
    @Column(name = "payment_process_referrals_description", columnDefinition = "TEXT")
    private String paymentProcessReferralsDescription;
    @Column(nullable = false, name = "utm_tagging_status", columnDefinition = "VARCHAR(100) DEFAULT 'N/A'")
    private String utmTaggingStatus;
    @Column(name = "utm_tagging_description", columnDefinition = "TEXT")
    private String utmTaggingDescription;
    @Column(nullable = false, name = "pages_404_error_tracking_status", columnDefinition = "VARCHAR(100) DEFAULT 'N/A'")
    private String pages404ErrorTrackingStatus;
    @Column(name = "pages_404_error_tracking_description", columnDefinition = "TEXT")
    private String pages404ErrorTrackingDescription;
    @Column(nullable = false, name = "main_domain_in_list_unwanted_referrals_status", columnDefinition = "VARCHAR(100) DEFAULT 'N/A'")
    private String mainDomainInListUnwantedReferralsStatus;
    @Column(name = "main_domain_in_list_unwanted_referrals_description", columnDefinition = "TEXT")
    private String mainDomainInListUnwantedReferralsDescription;
    @Column(nullable = false, name = "session_timeout_status", columnDefinition = "VARCHAR(100) DEFAULT 'N/A'")
    private String sessionTimeoutStatus;
    @Column(name = "session_timeout_description", columnDefinition = "TEXT")
    private String sessionTimeoutDescription;
    @Column(nullable = false, name = "lookback_window_status", columnDefinition = "VARCHAR(100) DEFAULT 'N/A'")
    private String lookbackWindowStatus;
    @Column(name = "lookback_window_description", columnDefinition = "TEXT")
    private String lookbackWindowDescription;
    @Column(nullable = false, name = "user_and_event_data_retention_status", columnDefinition = "VARCHAR(100) DEFAULT 'N/A'")
    private String userAndEventDataRetentionStatus;
    @Column(name = "user_and_event_data_retention_description", columnDefinition = "TEXT")
    private String userAndEventDataRetentionDescription;
    @Column(nullable = false, name = "ecommerce_data_accuracy_status", columnDefinition = "VARCHAR(100) DEFAULT 'N/A'")
    private String ecommerceDataAccuracyStatus;
    @Column(name = "ecommerce_data_accuracy_description", columnDefinition = "TEXT")
    private String ecommerceDataAccuracyDescription;
    @Column(nullable = false, name = "traffic_to_not_set_landing_page_status", columnDefinition = "VARCHAR(100) DEFAULT 'N/A'")
    private String trafficToNotSetLandingPageStatus;
    @Column(name = "traffic_to_not_set_landing_page_description", columnDefinition = "TEXT")
    private String trafficToNotSetLandingPageDescription;
    @Column(nullable = false, name = "currency_status", columnDefinition = "VARCHAR(100) DEFAULT 'N/A'")
    private String currencyStatus;
    @Column(name = "currency_description", columnDefinition = "TEXT")
    private String currencyDescription;
    @Column(nullable = false, name = "define_internal_traffic_status", columnDefinition = "VARCHAR(100) DEFAULT 'N/A'")
    private String defineInternalTrafficStatus;
    @Column(name = "define_internal_traffic_description", columnDefinition = "TEXT")
    private String defineInternalTrafficDescription;
    @Column(nullable = false, name = "industry_category_status", columnDefinition = "VARCHAR(100) DEFAULT 'N/A'")
    private String industryCategoryStatus;
    @Column(name = "industry_category_description", columnDefinition = "TEXT")
    private String industryCategoryDescription;
    @Column(nullable = false, name = "reporting_time_zone_status", columnDefinition = "VARCHAR(100) DEFAULT 'N/A'")
    private String reportingTimeZoneStatus;
    @Column(name = "reporting_time_zone_description", columnDefinition = "TEXT")
    private String reportingTimeZoneDescription;
    @Column(nullable = false, name = "event_tracking_status", columnDefinition = "VARCHAR(100) DEFAULT 'N/A'")
    private String eventTrackingStatus;
    @Column(name = "event_tracking_description", columnDefinition = "TEXT")
    private String eventTrackingDescription;
    @Column(nullable = false, name = "conversion_tracking_status", columnDefinition = "VARCHAR(100) DEFAULT 'N/A'")
    private String conversionTrackingStatus;
    @Column(name = "conversion_tracking_description", columnDefinition = "TEXT")
    private String conversionTrackingDescription;
    @Column(nullable = false, name = "standard_purchase_ecommerce_tracking_implementation_status", columnDefinition = "VARCHAR(100) DEFAULT 'N/A'")
    private String standardPurchaseEcommerceTrackingImplementationStatus;
    @Column(name = "standard_purchase_ecommerce_tracking_implementation_description", columnDefinition = "TEXT")
    private String standardPurchaseEcommerceTrackingImplementationDescription;
    @Column(nullable = false, name = "enhanced_measurement_status", columnDefinition = "VARCHAR(100) DEFAULT 'N/A'")
    private String enhancedMeasurementStatus;
    @Column(name = "enhanced_measurement_description", columnDefinition = "TEXT")
    private String enhancedMeasurementDescription;
    @Column(nullable = false, name = "user_id_tracking_implementation_status", columnDefinition = "VARCHAR(100) DEFAULT 'N/A'")
    private String userIdTrackingImplementationStatus;
    @Column(name = "user_id_tracking_implementation_description", columnDefinition = "TEXT")
    private String userIdTrackingImplementationDescription;
    @Column(nullable = false, name = "enhnanced_ecommerce_tracking_status", columnDefinition = "VARCHAR(100) DEFAULT 'N/A'")
    private String enhnancedEcommerceTrackingStatus;
    @Column(name = "enhnanced_ecommerce_tracking_description", columnDefinition = "TEXT")
    private String enhnancedEcommerceTrackingDescription;
    @Column(nullable = false, name = "custom_dimensions_and_metrics_tracking_status", columnDefinition = "VARCHAR(100) DEFAULT 'N/A'")
    private String customDimensionsAndMetricsTrackingStatus;
    @Column(name = "custom_dimensions_and_metrics_tracking_description", columnDefinition = "TEXT")
    private String customDimensionsAndMetricsTrackingDescription;
    @Column(nullable = false, name = "granular_location_and_device_data_collection_status", columnDefinition = "VARCHAR(100) DEFAULT 'N/A'")
    private String granularLocationAndDeviceDataCollectionStatus;
    @Column(name = "granular_location_and_device_data_collection_description", columnDefinition = "TEXT")
    private String granularLocationAndDeviceDataCollectionDescription;
    @Column(nullable = false, name = "advanced_settings_to_allow_for_ads_personalization_status", columnDefinition = "VARCHAR(100) DEFAULT 'N/A'")
    private String advancedSettingsToAllowForAdsPersonalizationStatus;
    @Column(name = "advanced_settings_to_allow_for_ads_personalization_description", columnDefinition = "TEXT")
    private String advancedSettingsToAllowForAdsPersonalizationDescription;
    @Column(nullable = false, name = "property_name_status", columnDefinition = "VARCHAR(100) DEFAULT 'N/A'")
    private String propertyNameStatus;
    @Column(name = "property_name_description", columnDefinition = "TEXT")
    private String propertyNameDescription;
    @Column(nullable = false, name = "stream_name_status", columnDefinition = "VARCHAR(100) DEFAULT 'N/A'")
    private String streamNameStatus;
    @Column(name = "stream_name_description", columnDefinition = "TEXT")
    private String streamNameDescription;
    @Column(nullable = false, name = "event_tracking_taxonomy_status", columnDefinition = "VARCHAR(100) DEFAULT 'N/A'")
    private String eventTrackingTaxonomyStatus;
    @Column(name = "event_tracking_taxonomy_description", columnDefinition = "TEXT")
    private String eventTrackingTaxonomyDescription;
    @Column(nullable = false, name = "google_bigquery_linking_status", columnDefinition = "VARCHAR(100) DEFAULT 'N/A'")
    private String googleBigqueryLinkingStatus;
    @Column(name = "google_bigquery_linking_description", columnDefinition = "TEXT")
    private String googleBigqueryLinkingDescription;
    @Column(nullable = false, name = "library_status", columnDefinition = "VARCHAR(100) DEFAULT 'N/A'")
    private String libraryStatus;
    @Column(name = "library_description", columnDefinition = "TEXT")
    private String libraryDescription;
    @Column(nullable = false, name = "google_ads_linking_status", columnDefinition = "VARCHAR(100) DEFAULT 'N/A'")
    private String googleAdsLinkingStatus;
    @Column(name = "google_ads_linking_description", columnDefinition = "TEXT")
    private String googleAdsLinkingDescription;
    @Column(nullable = false, name = "google_search_console_linking_status", columnDefinition = "VARCHAR(100) DEFAULT 'N/A'")
    private String googleSearchConsoleLinkingStatus;
    @Column(name = "google_search_console_linking_description", columnDefinition = "TEXT")
    private String googleSearchConsoleLinkingDescription;
    @Column(nullable = false, name = "google_merchant_center_linking_status", columnDefinition = "VARCHAR(100) DEFAULT 'N/A'")
    private String googleMerchantCenterLinkingStatus;
    @Column(name = "google_merchant_center_linking_description", columnDefinition = "TEXT")
    private String googleMerchantCenterLinkingDescription;
    @Column(nullable = false, name = "display_and_video_360_linking_status", columnDefinition = "VARCHAR(100) DEFAULT 'N/A'")
    private String displayAndVideo360LinkingStatus;
    @Column(name = "display_and_video_360_linking_description", columnDefinition = "TEXT")
    private String displayAndVideo360LinkingDescription;
    @Column(nullable = false, name = "data_import_status", columnDefinition = "VARCHAR(100) DEFAULT 'N/A'")
    private String dataImportStatus;
    @Column(name = "data_import_description", columnDefinition = "TEXT")
    private String dataImportDescription;
    @Column(nullable = false, name = "ad_manager_linking_status", columnDefinition = "VARCHAR(100) DEFAULT 'N/A'")
    private String adManagerLinkingStatus;
    @Column(name = "ad_manager_linking_description", columnDefinition = "TEXT")
    private String adManagerLinkingDescription;
    @Column(nullable = false, name = "search_ads_360_linking_status", columnDefinition = "VARCHAR(100) DEFAULT 'N/A'")
    private String searchAds360LinkingStatus;
    @Column(name = "search_ads_360_linking_description", columnDefinition = "TEXT")
    private String searchAds360LinkingDescription;
    @Column(nullable = false, name = "google_signals_data_collection_status", columnDefinition = "VARCHAR(100) DEFAULT 'N/A'")
    private String googleSignalsDataCollectionStatus;
    @Column(name = "google_signals_data_collection_description", columnDefinition = "TEXT")
    private String googleSignalsDataCollectionDescription;
    @Column(nullable = false, name = "reporting_attribution_model_status", columnDefinition = "VARCHAR(100) DEFAULT 'N/A'")
    private String reportingAttributionModelStatus;
    @Column(name = "reporting_attribution_model_description", columnDefinition = "TEXT")
    private String reportingAttributionModelDescription;
    @Column(nullable = false, name = "reporting_attribution_identity_status", columnDefinition = "VARCHAR(100) DEFAULT 'N/A'")
    private String reportingAttributionIdentityStatus;
    @Column(name = "reporting_attribution_identity_description", columnDefinition = "TEXT")
    private String reportingAttributionIdentityDescription;
    @Column(nullable = false, name = "server_side_tracking_implementation_status", columnDefinition = "VARCHAR(100) DEFAULT 'N/A'")
    private String serverSideTrackingImplementationStatus;
    @Column(name = "server_side_tracking_implementation_description", columnDefinition = "TEXT")
    private String serverSideTrackingImplementationDescription;
    @Column(nullable = false, name = "consent_mode_status", columnDefinition = "VARCHAR(100) DEFAULT 'N/A'")
    private String consentModeStatus;
    @Column(name = "consent_mode_description", columnDefinition = "TEXT")
    private String consentModeDescription;
    @Column(nullable = false, name = "pii_data_not_collection_status", columnDefinition = "VARCHAR(100) DEFAULT 'N/A'")
    private String piiDataNotCollectionStatus;
    @Column(name = "pii_data_not_collection_description", columnDefinition = "TEXT")
    private String piiDataNotCollectionDescription;
}
