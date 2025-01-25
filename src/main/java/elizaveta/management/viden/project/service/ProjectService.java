package elizaveta.management.viden.project.service;

import elizaveta.management.viden.project.entity.Project;
import elizaveta.management.viden.project.http.dto.EditProjectRequest;
import elizaveta.management.viden.project.rep.ProjectRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;

    @Transactional(readOnly = true)
    public Project findById(int id) {
        Optional<Project> project = projectRepository.findById(id);
        if (project.isEmpty()) {
            log.error("Cannot find project with id = {}", id);
            throw new UsernameNotFoundException("Cannot find project with id = " + id);
        }
        return project.get();
    }

    @Transactional(readOnly = true)
    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    @Transactional
    public void delete(int id) {
        Project project = findById(id);
        projectRepository.delete(project);
    }

    @Transactional
    public Project checkAndCreate(String name) {
        Optional<Project> optionalProject = projectRepository.findByName(name);
        if (optionalProject.isPresent()) {
            log.error("Project with name {} already exists", name);
            throw new RuntimeException("Project with name " + name + " already exists");
        }

        Project project = new Project();
        project.setName(name);

        return projectRepository.save(project);
    }

    @Transactional
    public Project edit(int id, EditProjectRequest editProjectRequest) {
        Project project = findById(id);

        if (editProjectRequest.getName() != null) {
            project.setName(editProjectRequest.getName());
        }
        if (editProjectRequest.getCorrectCodeImplementationStatus() != null) {
            project.setCorrectCodeImplementationStatus(editProjectRequest.getCorrectCodeImplementationStatus());
        }
        if (editProjectRequest.getCorrectCodeImplementationDescription() != null) {
            project.setCorrectCodeImplementationDescription(editProjectRequest.getCorrectCodeImplementationDescription());
        }
        if (editProjectRequest.getCorrectMobileSiteTrackingStatus() != null) {
            project.setCorrectMobileSiteTrackingStatus(editProjectRequest.getCorrectMobileSiteTrackingStatus());
        }
        if (editProjectRequest.getCorrectMobileSiteTrackingDescription() != null) {
            project.setCorrectMobileSiteTrackingDescription(editProjectRequest.getCorrectMobileSiteTrackingDescription());
        }
        if (editProjectRequest.getCodeSingularityStatus() != null) {
            project.setCodeSingularityStatus(editProjectRequest.getCodeSingularityStatus());
        }
        if (editProjectRequest.getCodeSingularityDescription() != null) {
            project.setCodeSingularityDescription(editProjectRequest.getCodeSingularityDescription());
        }
        if (editProjectRequest.getCorrectSinglePageApplicationTrackingStatus() != null) {
            project.setCorrectSinglePageApplicationTrackingStatus(editProjectRequest.getCorrectSinglePageApplicationTrackingStatus());
        }
        if (editProjectRequest.getCorrectSinglePageApplicationTrackingDescription() != null) {
            project.setCorrectSinglePageApplicationTrackingDescription(editProjectRequest.getCorrectSinglePageApplicationTrackingDescription());
        }
        if (editProjectRequest.getCrossDomainTrackingConfigurationStatus() != null) {
            project.setCrossDomainTrackingConfigurationStatus(editProjectRequest.getCrossDomainTrackingConfigurationStatus());
        }
        if (editProjectRequest.getCrossDomainTrackingConfigurationDescription() != null) {
            project.setCrossDomainTrackingConfigurationDescription(editProjectRequest.getCrossDomainTrackingConfigurationDescription());
        }
        if (editProjectRequest.getSelfReferralsStatus() != null) {
            project.setSelfReferralsStatus(editProjectRequest.getSelfReferralsStatus());
        }
        if (editProjectRequest.getSelfReferralsDescription() != null) {
            project.setSelfReferralsDescription(editProjectRequest.getSelfReferralsDescription());
        }
        if (editProjectRequest.getPaymentProcessReferralsStatus() != null) {
            project.setPaymentProcessReferralsStatus(editProjectRequest.getPaymentProcessReferralsStatus());
        }
        if (editProjectRequest.getPaymentProcessReferralsDescription() != null) {
            project.setPaymentProcessReferralsDescription(editProjectRequest.getPaymentProcessReferralsDescription());
        }
        if (editProjectRequest.getUtmTaggingStatus() != null) {
            project.setUtmTaggingStatus(editProjectRequest.getUtmTaggingStatus());
        }
        if (editProjectRequest.getUtmTaggingDescription() != null) {
            project.setUtmTaggingDescription(editProjectRequest.getUtmTaggingDescription());
        }
        if (editProjectRequest.getPages404ErrorTrackingStatus() != null) {
            project.setPages404ErrorTrackingStatus(editProjectRequest.getPages404ErrorTrackingStatus());
        }
        if (editProjectRequest.getPages404ErrorTrackingDescription() != null) {
            project.setPages404ErrorTrackingDescription(editProjectRequest.getPages404ErrorTrackingDescription());
        }
        if (editProjectRequest.getMainDomainInListUnwantedReferralsStatus() != null) {
            project.setMainDomainInListUnwantedReferralsStatus(editProjectRequest.getMainDomainInListUnwantedReferralsStatus());
        }
        if (editProjectRequest.getMainDomainInListUnwantedReferralsDescription() != null) {
            project.setMainDomainInListUnwantedReferralsDescription(editProjectRequest.getMainDomainInListUnwantedReferralsDescription());
        }
        if (editProjectRequest.getSessionTimeoutStatus() != null) {
            project.setSessionTimeoutStatus(editProjectRequest.getSessionTimeoutStatus());
        }
        if (editProjectRequest.getSessionTimeoutDescription() != null) {
            project.setSessionTimeoutDescription(editProjectRequest.getSessionTimeoutDescription());
        }
        if (editProjectRequest.getLookbackWindowStatus() != null) {
            project.setLookbackWindowStatus(editProjectRequest.getLookbackWindowStatus());
        }
        if (editProjectRequest.getLookbackWindowDescription() != null) {
            project.setLookbackWindowDescription(editProjectRequest.getLookbackWindowDescription());
        }
        if (editProjectRequest.getUserAndEventDataRetentionStatus() != null) {
            project.setUserAndEventDataRetentionStatus(editProjectRequest.getUserAndEventDataRetentionStatus());
        }
        if (editProjectRequest.getUserAndEventDataRetentionDescription() != null) {
            project.setUserAndEventDataRetentionDescription(editProjectRequest.getUserAndEventDataRetentionDescription());
        }
        if (editProjectRequest.getEcommerceDataAccuracyStatus() != null) {
            project.setEcommerceDataAccuracyStatus(editProjectRequest.getEcommerceDataAccuracyStatus());
        }
        if (editProjectRequest.getEcommerceDataAccuracyDescription() != null) {
            project.setEcommerceDataAccuracyDescription(editProjectRequest.getEcommerceDataAccuracyDescription());
        }
        if (editProjectRequest.getTrafficToNotSetLandingPageStatus() != null) {
            project.setTrafficToNotSetLandingPageStatus(editProjectRequest.getTrafficToNotSetLandingPageStatus());
        }
        if (editProjectRequest.getTrafficToNotSetLandingPageDescription() != null) {
            project.setTrafficToNotSetLandingPageDescription(editProjectRequest.getTrafficToNotSetLandingPageDescription());
        }
        if (editProjectRequest.getCurrencyStatus() != null) {
            project.setCurrencyStatus(editProjectRequest.getCurrencyStatus());
        }
        if (editProjectRequest.getCurrencyDescription() != null) {
            project.setCurrencyDescription(editProjectRequest.getCurrencyDescription());
        }
        if (editProjectRequest.getDefineInternalTrafficStatus() != null) {
            project.setDefineInternalTrafficStatus(editProjectRequest.getDefineInternalTrafficStatus());
        }
        if (editProjectRequest.getDefineInternalTrafficDescription() != null) {
            project.setDefineInternalTrafficDescription(editProjectRequest.getDefineInternalTrafficDescription());
        }
        if (editProjectRequest.getIndustryCategoryStatus() != null) {
            project.setIndustryCategoryStatus(editProjectRequest.getIndustryCategoryStatus());
        }
        if (editProjectRequest.getIndustryCategoryDescription() != null) {
            project.setIndustryCategoryDescription(editProjectRequest.getIndustryCategoryDescription());
        }
        if (editProjectRequest.getReportingTimeZoneStatus() != null) {
            project.setReportingTimeZoneStatus(editProjectRequest.getReportingTimeZoneStatus());
        }
        if (editProjectRequest.getReportingTimeZoneDescription() != null) {
            project.setReportingTimeZoneDescription(editProjectRequest.getReportingTimeZoneDescription());
        }
        if (editProjectRequest.getEventTrackingStatus() != null) {
            project.setEventTrackingStatus(editProjectRequest.getEventTrackingStatus());
        }
        if (editProjectRequest.getEventTrackingDescription() != null) {
            project.setEventTrackingDescription(editProjectRequest.getEventTrackingDescription());
        }
        if (editProjectRequest.getConversionTrackingStatus() != null) {
            project.setConversionTrackingStatus(editProjectRequest.getConversionTrackingStatus());
        }
        if (editProjectRequest.getConversionTrackingDescription() != null) {
            project.setConversionTrackingDescription(editProjectRequest.getConversionTrackingDescription());
        }
        if (editProjectRequest.getStandardPurchaseEcommerceTrackingImplementationStatus() != null) {
            project.setStandardPurchaseEcommerceTrackingImplementationStatus(editProjectRequest.getStandardPurchaseEcommerceTrackingImplementationStatus());
        }
        if (editProjectRequest.getStandardPurchaseEcommerceTrackingImplementationDescription() != null) {
            project.setStandardPurchaseEcommerceTrackingImplementationDescription(editProjectRequest.getStandardPurchaseEcommerceTrackingImplementationDescription());
        }
        if (editProjectRequest.getEnhancedMeasurementStatus() != null) {
            project.setEnhancedMeasurementStatus(editProjectRequest.getEnhancedMeasurementStatus());
        }
        if (editProjectRequest.getEnhancedMeasurementDescription() != null) {
            project.setEnhancedMeasurementDescription(editProjectRequest.getEnhancedMeasurementDescription());
        }
        if (editProjectRequest.getUserIdTrackingImplementationStatus() != null) {
            project.setUserIdTrackingImplementationStatus(editProjectRequest.getUserIdTrackingImplementationStatus());
        }
        if (editProjectRequest.getUserIdTrackingImplementationDescription() != null) {
            project.setUserIdTrackingImplementationDescription(editProjectRequest.getUserIdTrackingImplementationDescription());
        }
        if (editProjectRequest.getEnhnancedEcommerceTrackingStatus() != null) {
            project.setEnhnancedEcommerceTrackingStatus(editProjectRequest.getEnhnancedEcommerceTrackingStatus());
        }
        if (editProjectRequest.getEnhnancedEcommerceTrackingDescription() != null) {
            project.setEnhnancedEcommerceTrackingDescription(editProjectRequest.getEnhnancedEcommerceTrackingDescription());
        }
        if (editProjectRequest.getCustomDimensionsAndMetricsTrackingStatus() != null) {
            project.setCustomDimensionsAndMetricsTrackingStatus(editProjectRequest.getCustomDimensionsAndMetricsTrackingStatus());
        }
        if (editProjectRequest.getCustomDimensionsAndMetricsTrackingDescription() != null) {
            project.setCustomDimensionsAndMetricsTrackingDescription(editProjectRequest.getCustomDimensionsAndMetricsTrackingDescription());
        }
        if (editProjectRequest.getGranularLocationAndDeviceDataCollectionStatus() != null) {
            project.setGranularLocationAndDeviceDataCollectionStatus(editProjectRequest.getGranularLocationAndDeviceDataCollectionStatus());
        }
        if (editProjectRequest.getGranularLocationAndDeviceDataCollectionDescription() != null) {
            project.setGranularLocationAndDeviceDataCollectionDescription(editProjectRequest.getGranularLocationAndDeviceDataCollectionDescription());
        }
        if (editProjectRequest.getAdvancedSettingsToAllowForAdsPersonalizationStatus() != null) {
            project.setAdvancedSettingsToAllowForAdsPersonalizationStatus(editProjectRequest.getAdvancedSettingsToAllowForAdsPersonalizationStatus());
        }
        if (editProjectRequest.getAdvancedSettingsToAllowForAdsPersonalizationDescription() != null) {
            project.setAdvancedSettingsToAllowForAdsPersonalizationDescription(editProjectRequest.getAdvancedSettingsToAllowForAdsPersonalizationDescription());
        }
        if (editProjectRequest.getPropertyNameStatus() != null) {
            project.setPropertyNameStatus(editProjectRequest.getPropertyNameStatus());
        }
        if (editProjectRequest.getPropertyNameDescription() != null) {
            project.setPropertyNameDescription(editProjectRequest.getPropertyNameDescription());
        }
        if (editProjectRequest.getStreamNameStatus() != null) {
            project.setStreamNameStatus(editProjectRequest.getStreamNameStatus());
        }
        if (editProjectRequest.getStreamNameDescription() != null) {
            project.setStreamNameDescription(editProjectRequest.getStreamNameDescription());
        }
        if (editProjectRequest.getEventTrackingTaxonomyStatus() != null) {
            project.setEventTrackingTaxonomyStatus(editProjectRequest.getEventTrackingTaxonomyStatus());
        }
        if (editProjectRequest.getEventTrackingTaxonomyDescription() != null) {
            project.setEventTrackingTaxonomyDescription(editProjectRequest.getEventTrackingTaxonomyDescription());
        }
        if (editProjectRequest.getGoogleBigqueryLinkingStatus() != null) {
            project.setGoogleBigqueryLinkingStatus(editProjectRequest.getGoogleBigqueryLinkingStatus());
        }
        if (editProjectRequest.getGoogleBigqueryLinkingDescription() != null) {
            project.setGoogleBigqueryLinkingDescription(editProjectRequest.getGoogleBigqueryLinkingDescription());
        }
        if (editProjectRequest.getLibraryStatus() != null) {
            project.setLibraryStatus(editProjectRequest.getLibraryStatus());
        }
        if (editProjectRequest.getLibraryDescription() != null) {
            project.setLibraryDescription(editProjectRequest.getLibraryDescription());
        }
        if (editProjectRequest.getGoogleAdsLinkingStatus() != null) {
            project.setGoogleAdsLinkingStatus(editProjectRequest.getGoogleAdsLinkingStatus());
        }
        if (editProjectRequest.getGoogleAdsLinkingDescription() != null) {
            project.setGoogleAdsLinkingDescription(editProjectRequest.getGoogleAdsLinkingDescription());
        }
        if (editProjectRequest.getGoogleSearchConsoleLinkingStatus() != null) {
            project.setGoogleSearchConsoleLinkingStatus(editProjectRequest.getGoogleSearchConsoleLinkingStatus());
        }
        if (editProjectRequest.getGoogleSearchConsoleLinkingDescription() != null) {
            project.setGoogleSearchConsoleLinkingDescription(editProjectRequest.getGoogleSearchConsoleLinkingDescription());
        }
        if (editProjectRequest.getGoogleMerchantCenterLinkingStatus() != null) {
            project.setGoogleMerchantCenterLinkingStatus(editProjectRequest.getGoogleMerchantCenterLinkingStatus());
        }
        if (editProjectRequest.getGoogleMerchantCenterLinkingDescription() != null) {
            project.setGoogleMerchantCenterLinkingDescription(editProjectRequest.getGoogleMerchantCenterLinkingDescription());
        }
        if (editProjectRequest.getDisplayAndVideo360LinkingStatus() != null) {
            project.setDisplayAndVideo360LinkingStatus(editProjectRequest.getDisplayAndVideo360LinkingStatus());
        }
        if (editProjectRequest.getDisplayAndVideo360LinkingDescription() != null) {
            project.setDisplayAndVideo360LinkingDescription(editProjectRequest.getDisplayAndVideo360LinkingDescription());
        }
        if (editProjectRequest.getDataImportStatus() != null) {
            project.setDataImportStatus(editProjectRequest.getDataImportStatus());
        }
        if (editProjectRequest.getDataImportDescription() != null) {
            project.setDataImportDescription(editProjectRequest.getDataImportDescription());
        }
        if (editProjectRequest.getAdManagerLinkingStatus() != null) {
            project.setAdManagerLinkingStatus(editProjectRequest.getAdManagerLinkingStatus());
        }
        if (editProjectRequest.getAdManagerLinkingDescription() != null) {
            project.setAdManagerLinkingDescription(editProjectRequest.getAdManagerLinkingDescription());
        }
        if (editProjectRequest.getSearchAds360LinkingStatus() != null) {
            project.setSearchAds360LinkingStatus(editProjectRequest.getSearchAds360LinkingStatus());
        }
        if (editProjectRequest.getSearchAds360LinkingDescription() != null) {
            project.setSearchAds360LinkingDescription(editProjectRequest.getSearchAds360LinkingDescription());
        }
        if (editProjectRequest.getGoogleSignalsDataCollectionStatus() != null) {
            project.setGoogleSignalsDataCollectionStatus(editProjectRequest.getGoogleSignalsDataCollectionStatus());
        }
        if (editProjectRequest.getGoogleSignalsDataCollectionDescription() != null) {
            project.setGoogleSignalsDataCollectionDescription(editProjectRequest.getGoogleSignalsDataCollectionDescription());
        }
        if (editProjectRequest.getReportingAttributionModelStatus() != null) {
            project.setReportingAttributionModelStatus(editProjectRequest.getReportingAttributionModelStatus());
        }
        if (editProjectRequest.getReportingAttributionModelDescription() != null) {
            project.setReportingAttributionModelDescription(editProjectRequest.getReportingAttributionModelDescription());
        }
        if (editProjectRequest.getReportingAttributionIdentityStatus() != null) {
            project.setReportingAttributionIdentityStatus(editProjectRequest.getReportingAttributionIdentityStatus());
        }
        if (editProjectRequest.getReportingAttributionIdentityDescription() != null) {
            project.setReportingAttributionIdentityDescription(editProjectRequest.getReportingAttributionIdentityDescription());
        }
        if (editProjectRequest.getServerSideTrackingImplementationStatus() != null) {
            project.setServerSideTrackingImplementationStatus(editProjectRequest.getServerSideTrackingImplementationStatus());
        }
        if (editProjectRequest.getServerSideTrackingImplementationDescription() != null) {
            project.setServerSideTrackingImplementationDescription(editProjectRequest.getServerSideTrackingImplementationDescription());
        }
        if (editProjectRequest.getConsentModeStatus() != null) {
            project.setConsentModeStatus(editProjectRequest.getConsentModeStatus());
        }
        if (editProjectRequest.getConsentModeDescription() != null) {
            project.setConsentModeDescription(editProjectRequest.getConsentModeDescription());
        }
        if (editProjectRequest.getPiiDataNotCollectionStatus() != null) {
            project.setPiiDataNotCollectionStatus(editProjectRequest.getPiiDataNotCollectionStatus());
        }
        if (editProjectRequest.getPiiDataNotCollectionDescription() != null) {
            project.setPiiDataNotCollectionDescription(editProjectRequest.getPiiDataNotCollectionDescription());
        }
        return projectRepository.save(project);
    }
}
