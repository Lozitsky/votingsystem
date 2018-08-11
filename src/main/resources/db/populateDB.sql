DELETE FROM citizens;
DELETE FROM candidates;

INSERT INTO citizens (id, citizen_name, has_voted)
VALUES (11000, 'Givi', TRUE ),
       (11001, 'Gogi', FALSE );

INSERT INTO candidates (id, candidate_name)
VALUES (12000, 'Vano');