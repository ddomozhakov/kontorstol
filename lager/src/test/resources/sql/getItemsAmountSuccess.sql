CREATE TABLE lager_main (
                            id SERIAL PRIMARY KEY,
                            Type VARCHAR NOT NULL,
                            Amount INTEGER
);

insert into lager_main (Type, Amount)
values
    ('table', 15),
    ('chair', 11);
