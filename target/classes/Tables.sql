CREATE TABLE benefits
(
    id           BIGINT   NOT NULL,
    job_benefits LONGTEXT NULL,
    CONSTRAINT pk_benefits PRIMARY KEY (id)
);

CREATE TABLE highlights
(
    id                  BIGINT NOT NULL,
    qualifications_id   BIGINT NULL,
    responsibilities_id BIGINT NULL,
    benefits_id         BIGINT NULL,
    CONSTRAINT pk_highlights PRIMARY KEY (id)
);

CREATE TABLE job_data
(
    id                             INT          NOT NULL,
    employer_name                  VARCHAR(255) NULL,
    employer_website               VARCHAR(255) NULL,
    employer_company_type          VARCHAR(255) NULL,
    job_publisher                  VARCHAR(255) NULL,
    job_employment_type            VARCHAR(255) NULL,
    job_title                      VARCHAR(255) NULL,
    job_apply_link                 VARCHAR(255) NULL,
    job_apply_is_direct            VARCHAR(255) NULL,
    job_description                MEDIUMTEXT   NULL,
    job_is_remote                  VARCHAR(255) NULL,
    job_posted_at_timestamp        VARCHAR(255) NULL,
    job_city                       VARCHAR(255) NULL,
    job_state                      VARCHAR(255) NULL,
    job_country                    VARCHAR(255) NULL,
    job_offer_expiration_timestamp VARCHAR(255) NULL,
    job_min_salary                 VARCHAR(255) NULL,
    job_max_salary                 VARCHAR(255) NULL,
    job_salary_currency            VARCHAR(255) NULL,
    job_salary_period              VARCHAR(255) NULL,
    previous_experience_id  BIGINT       NULL,
    highlights_id                  BIGINT       NULL,
    prev_education_id              BIGINT       NULL,
    CONSTRAINT pk_job_data PRIMARY KEY (id)
);

CREATE TABLE prev_education
(
    id                         BIGINT       NOT NULL,
    postgraduate_degree        VARCHAR(255) NULL,
    professional_certification VARCHAR(255) NULL,
    high_school                VARCHAR(255) NULL,
    associates_degree          VARCHAR(255) NULL,
    bachelors_degree           VARCHAR(255) NULL,
    CONSTRAINT pk_prev_education PRIMARY KEY (id)
);

CREATE TABLE previous_experience
(
    id                            BIGINT       NOT NULL,
    no_experience_required        VARCHAR(255) NULL,
    required_experience_in_months VARCHAR(255) NULL,
    experience_preferred          VARCHAR(255) NULL,
    CONSTRAINT pk_previous_experience PRIMARY KEY (id)
);

CREATE TABLE qualifications
(
    id             BIGINT   NOT NULL,
    qualifications LONGTEXT NULL,
    CONSTRAINT pk_qualifications PRIMARY KEY (id)
);

CREATE TABLE responsibilities
(
    id               BIGINT   NOT NULL,
    responsibilities LONGTEXT NULL,
    CONSTRAINT pk_responsibilities PRIMARY KEY (id)
);

ALTER TABLE highlights
    ADD CONSTRAINT uc_highlights_benefits UNIQUE (benefits_id);

ALTER TABLE highlights
    ADD CONSTRAINT uc_highlights_qualifications UNIQUE (qualifications_id);

ALTER TABLE highlights
    ADD CONSTRAINT uc_highlights_responsibilities UNIQUE (responsibilities_id);

ALTER TABLE job_data
    ADD CONSTRAINT uc_job_data_highlights UNIQUE (highlights_id);

ALTER TABLE job_data
    ADD CONSTRAINT uc_job_data_prev_education UNIQUE (prev_education_id);

ALTER TABLE job_data
    ADD CONSTRAINT uc_job_data_previous_experience_entity UNIQUE (previous_experience_id);

ALTER TABLE highlights
    ADD CONSTRAINT FK_HIGHLIGHTS_ON_BENEFITS FOREIGN KEY (benefits_id) REFERENCES benefits (id);

ALTER TABLE highlights
    ADD CONSTRAINT FK_HIGHLIGHTS_ON_QUALIFICATIONS FOREIGN KEY (qualifications_id) REFERENCES qualifications (id);

ALTER TABLE highlights
    ADD CONSTRAINT FK_HIGHLIGHTS_ON_RESPONSIBILITIES FOREIGN KEY (responsibilities_id) REFERENCES responsibilities (id);

ALTER TABLE job_data
    ADD CONSTRAINT FK_JOB_DATA_ON_HIGHLIGHTS FOREIGN KEY (highlights_id) REFERENCES highlights (id);

ALTER TABLE job_data
    ADD CONSTRAINT FK_JOB_DATA_ON_PREVIOUS_EXPERIENCE_ENTITY FOREIGN KEY (previous_experience_id) REFERENCES previous_experience (id);

ALTER TABLE job_data
    ADD CONSTRAINT FK_JOB_DATA_ON_PREV_EDUCATION FOREIGN KEY (prev_education_id) REFERENCES prev_education (id);