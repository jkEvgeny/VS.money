DROP TABLE IF EXISTS policyholder;

CREATE SEQUENCE global_seq START WITH 100000;

CREATE TABLE policyholder
(
    id              INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    name            VARCHAR                           NOT NULL,
    surname         VARCHAR                           NOT NULL,
    patronymic      VARCHAR,
    birth_date      DATE                              NOT NULL,
    passport_series INTEGER                           NOT NULL,
    passport_number INTEGER                           NOT NULL
);
INSERT INTO policyholder(id, name, surname, patronymic, birth_date, passport_series, passport_number, change)
values (100000, 'John', 'Smith', 'Paul', '10.01.1970', 1234, 123456, true);

INSERT INTO policyholder(id, name, surname, patronymic, birth_date, passport_series, passport_number, change)
values (100001, 'Sarah', 'Dillan', '', '30.12.1990', 4321, 654321, true);

CREATE TABLE calculation
(
    id                   INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    insurance_amount     INTEGER                           NOT NULL,
    validity_period_from DATE                DEFAULT now() NOT NULL,
    validity_period_to   DATE                              NOT NULL,
    property_type        VARCHAR                           NOT NULL,
    year_of_construction VARCHAR                           NOT NULL,
    area                 VARCHAR                           NOT NULL,
    settlement_date      TIMESTAMP           DEFAULT now() NOT NULL,
    prize                VARCHAR                           NOT NULL
);

CREATE TABLE execution
(
    id                 INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    contract_number    INTEGER                           NOT NULL,
    date_of_conclusion TIMESTAMP           DEFAULT now() NOT NULL
);

CREATE TABLE address
(
    id                   INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    state                VARCHAR NOT NULL,
    index                VARCHAR,
    region               VARCHAR NOT NULL,
    district             VARCHAR,
    locality             VARCHAR NOT NULL,
    street               VARCHAR NOT NULL,
    house                INTEGER,
    housing              VARCHAR,
    structure            VARCHAR,
    flat                 VARCHAR NOT NULL,
    comment              VARCHAR
);
