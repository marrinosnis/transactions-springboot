CREATE TABLE IF NOT EXISTS public.accounts
(
      id integer NOT NULL,
      currency varchar NOT NULL,
      balance double precision NOT NULL,
      created_at timestamp with time zone NOT NULL,
      PRIMARY KEY (id)
      );

ALTER TABLE IF EXISTS public.accounts
      OWNER to postgres;

INSERT INTO public.accounts(id, balance, created_at, currency)
VALUES(1, 2000, '2023-12-11 22:00:49.362307', 'euros'),
      (2, 1000, '2022-10-1 19:00:49.362307', 'dollars'),
      (3, 3000, '2020-5-29 20:53:46.361458', 'pesos');
