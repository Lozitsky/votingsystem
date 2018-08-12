
DROP TABLE IF EXISTS citizens;
DROP TABLE IF EXISTS candidates;
-- DROP SEQUENCE IF EXISTS global_seq;
-- CREATE SEQUENCE global_seq START 100000;

CREATE TABLE citizens
(
  id INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  citizen_name VARCHAR NOT NULL,
  has_voted BOOLEAN
);

CREATE TABLE candidates
(
  id INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  candidate_name VARCHAR NOT NULL,
  votes INTEGER
)