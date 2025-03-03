CREATE TABLE projects
(
    id                                                              INT          NOT NULL IDENTITY (1,1) UNIQUE,
    name                                                            VARCHAR(100) NOT NULL UNIQUE,
    correct_code_implementation_status                              VARCHAR(100),
    correct_code_implementation_description                         TEXT,
    correct_mobile_site_tracking_status                             VARCHAR(100),
    correct_mobile_site_tracking_description                        TEXT,
    code_singularity_status                                         VARCHAR(100),
    code_singularity_description                                    TEXT,
    correct_single_page_application_tracking_status                 VARCHAR(100),
    correct_single_page_application_tracking_description            TEXT,
    cross_domain_tracking_configuration_status                      VARCHAR(100),
    cross_domain_tracking_configuration_description                 TEXT,
    self_referrals_status                                           VARCHAR(100),
    self_referrals_description                                      TEXT,
    payment_process_referrals_status                                VARCHAR(100),
    payment_process_referrals_description                           TEXT,
    utm_tagging_status                                              VARCHAR(100),
    utm_tagging_description                                         TEXT,
    pages_404_error_tracking_status                                 VARCHAR(100),
    pages_404_error_tracking_description                            TEXT,
    main_domain_in_list_unwanted_referrals_status                   VARCHAR(100),
    main_domain_in_list_unwanted_referrals_description              TEXT,
    session_timeout_status                                          VARCHAR(100),
    session_timeout_description                                     TEXT,
    lookback_window_status                                          VARCHAR(100),
    lookback_window_description                                     TEXT,
    user_and_event_data_retention_status                            VARCHAR(100),
    user_and_event_data_retention_description                       TEXT,
    ecommerce_data_accuracy_status                                  VARCHAR(100),
    ecommerce_data_accuracy_description                             TEXT,
    traffic_to_not_set_landing_page_status                          VARCHAR(100),
    traffic_to_not_set_landing_page_description                     TEXT,
    currency_status                                                 VARCHAR(100),
    currency_description                                            TEXT,
    define_internal_traffic_status                                  VARCHAR(100),
    define_internal_traffic_description                             TEXT,
    industry_category_status                                        VARCHAR(100),
    industry_category_description                                   TEXT,
    reporting_time_zone_status                                      VARCHAR(100),
    reporting_time_zone_description                                 TEXT,
    event_tracking_status                                           VARCHAR(100),
    event_tracking_description                                      TEXT,
    conversion_tracking_status                                      VARCHAR(100),
    conversion_tracking_description                                 TEXT,
    standard_purchase_ecommerce_tracking_implementation_status      VARCHAR(100),
    standard_purchase_ecommerce_tracking_implementation_description TEXT,
    enhanced_measurement_status                                     VARCHAR(100),
    enhanced_measurement_description                                TEXT,
    user_id_tracking_implementation_status                          VARCHAR(100),
    user_id_tracking_implementation_description                     TEXT,
    enhnanced_ecommerce_tracking_status                             VARCHAR(100),
    enhnanced_ecommerce_tracking_description                        TEXT,
    custom_dimensions_and_metrics_tracking_status                   VARCHAR(100),
    custom_dimensions_and_metrics_tracking_description              TEXT,
    granular_location_and_device_data_collection_status             VARCHAR(100),
    granular_location_and_device_data_collection_description        TEXT,
    advanced_settings_to_allow_for_ads_personalization_status       VARCHAR(100),
    advanced_settings_to_allow_for_ads_personalization_description  TEXT,
    property_name_status                                            VARCHAR(100),
    property_name_description                                       TEXT,
    stream_name_status                                              VARCHAR(100),
    stream_name_description                                         TEXT,
    event_tracking_taxonomy_status                                  VARCHAR(100),
    event_tracking_taxonomy_description                             TEXT,
    google_bigquery_linking_status                                  VARCHAR(100),
    google_bigquery_linking_description                             TEXT,
    library_status                                                  VARCHAR(100),
    library_description                                             TEXT,
    google_ads_linking_status                                       VARCHAR(100),
    google_ads_linking_description                                  TEXT,
    google_search_console_linking_status                            VARCHAR(100),
    google_search_console_linking_description                       TEXT,
    google_merchant_center_linking_status                           VARCHAR(100),
    google_merchant_center_linking_description                      TEXT,
    display_and_video_360_linking_status                            VARCHAR(100),
    display_and_video_360_linking_description                       TEXT,
    data_import_status                                              VARCHAR(100),
    data_import_description                                         TEXT,
    ad_manager_linking_status                                       VARCHAR(100),
    ad_manager_linking_description                                  TEXT,
    search_ads_360_linking_status                                   VARCHAR(100),
    search_ads_360_linking_description                              TEXT,
    google_signals_data_collection_status                           VARCHAR(100),
    google_signals_data_collection_description                      TEXT,
    reporting_attribution_model_status                              VARCHAR(100),
    reporting_attribution_model_description                         TEXT,
    reporting_attribution_identity_status                           VARCHAR(100),
    reporting_attribution_identity_description                      TEXT,
    server_side_tracking_implementation_status                      VARCHAR(100),
    server_side_tracking_implementation_description                 TEXT,
    consent_mode_status                                             VARCHAR(100),
    consent_mode_description                                        TEXT,
    pii_data_not_collection_status                                  VARCHAR(100),
    pii_data_not_collection_description                             TEXT,
    PRIMARY KEY (id)
);

INSERT INTO projects (name)
VALUES ('VIDEN'),
       ('GOOGLE');

CREATE TABLE users
(
    id         INT          NOT NULL IDENTITY (1,1) UNIQUE,
    email      VARCHAR(100) NOT NULL UNIQUE,
    password   VARCHAR(100) NOT NULL,
    title      VARCHAR(100) NOT NULL,
    first_name VARCHAR(100) NOT NULL,
    last_name  VARCHAR(100) NOT NULL,
    project_id INT          NOT NULL,
    PRIMARY KEY (id)
);

ALTER TABLE users
    ADD CONSTRAINT fk_users_projects
        FOREIGN KEY (project_id)
            REFERENCES projects (id)
            ON DELETE CASCADE;

INSERT INTO users (email, password, title, first_name, last_name, project_id)
VALUES ('dzianis.zakharych@viden.com', '1234', 'FOUNDER', 'Dzianis', 'Zakharych',
        (SELECT id FROM projects WHERE name = 'VIDEN')),
       ('elizaveta.tsypenkova@viden.com', '1234', 'ANALYST', 'Elizaveta', 'Tsypenkova',
        (SELECT id FROM projects WHERE name = 'VIDEN')),
       ('jack.jackson@google.com', '1234', 'ANALYST', 'Jack', 'Jackson',
        (SELECT id FROM projects WHERE name = 'GOOGLE'));

CREATE SEQUENCE users_SEQ START WITH 1 INCREMENT BY 1;
CREATE SEQUENCE notes_SEQ START WITH 1 INCREMENT BY 1;

CREATE TABLE notes
(
    id           INT  NOT NULL IDENTITY (1,1) UNIQUE,
    message      TEXT NOT NULL,
    project_id   INT  NOT NULL,
    root_note_id INT,
    user_id      INT  NOT NULL,
    sended_at    DATETIME2 NOT NULL,
    PRIMARY KEY (id)
);

ALTER TABLE notes
    ADD CONSTRAINT fk_notes_projects
        FOREIGN KEY (project_id)
            REFERENCES projects (id)
            ON DELETE NO ACTION;
ALTER TABLE notes
    ADD CONSTRAINT fk_notes_notes
        FOREIGN KEY (root_note_id)
            REFERENCES notes (id)
            ON DELETE NO ACTION;
ALTER TABLE notes
    ADD CONSTRAINT fk_notes_users
        FOREIGN KEY (user_id)
            REFERENCES users (id)
            ON DELETE NO ACTION;