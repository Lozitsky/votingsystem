DELETE FROM citizens;
DELETE FROM candidates;

INSERT INTO citizens (id, citizen_name, has_voted)
VALUES (11000, 'Givi', FALSE ),
       (11001, 'Gogi', FALSE );

INSERT INTO candidates (id, candidate_name, votes)
VALUES (12000, 'Vano', 0),
       (12001, 'Alik', 0);