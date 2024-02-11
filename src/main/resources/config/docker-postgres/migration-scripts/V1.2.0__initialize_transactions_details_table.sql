CREATE TABLE IF NOT EXISTS public.transactions_details
(
       transaction_id character varying(255) COLLATE pg_catalog."default" NOT NULL,
       amount numeric(38,2),
       from_account_id integer,
       time_of_transaction timestamp without time zone,
       to_account_id integer,
       CONSTRAINT transactions_details_pkey PRIMARY KEY (transaction_id)
       )

       TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.transactions_details
       OWNER to postgres;


INSERT INTO transactions_details(transaction_id, amount, from_account_id, time_of_transaction, to_account_id)
VALUES ('0579c141-39be-45b8-b031-fccc6859a9e3', 60.00, 2, '2023-12-29 10:53:31.30457', 1),
       ('eede6919-26a1-4a75-ba50-a259939261c8', 600.00, 3, '2023-12-29 10:53:52.354367', 2),
       ('0579c141-26a1-45b8-ba50-fccc6859a9e3', 200.00, 1, '2023-12-29 10:54:04.723826', 3);