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
INSERT INTO policyholder(id, name, surname, patronymic, birth_date, passport_series, passport_number)
values (100000, 'John', 'Smith', 'Paul', '10.01.1970', 1234, 123456);

INSERT INTO policyholder(id, name, surname, patronymic, birth_date, passport_series, passport_number)
values (100001, 'Sarah', 'Dillan', '', '30.12.1990', 4321, 654321);

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
INSERT INTO calculation (id, insurance_amount, validity_period_from, validity_period_to, property_type, year_of_construction, area,settlement_date,prize)
values (100001, 431, '24.05.2021', '24.05.2022','Квартира', '2019', '75', '24.05.2021', 32000);

CREATE TABLE execution
(
    id                 INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    contract_number    INTEGER                           NOT NULL,
    date_of_conclusion TIMESTAMP           DEFAULT now() NOT NULL
);
INSERT INTO execution (id, contract_number, date_of_conclusion)
values (100000, 000001, '24.05.2021');

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
