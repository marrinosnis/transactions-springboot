-- FUNCTION: public.transactions_details_time_of_transaction()

-- DROP FUNCTION IF EXISTS public.transactions_details_time_of_transaction();

CREATE OR REPLACE FUNCTION public.transactions_details_time_of_transaction()
    RETURNS trigger
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE NOT LEAKPROOF
AS $BODY$
BEGIN
	NEW.time_of_transaction= NOW();
RETURN NEW;
END;
$BODY$;

ALTER FUNCTION public.transactions_details_time_of_transaction()
    OWNER TO postgres;



-- Trigger: trigger_update_time_of_transaction

-- DROP TRIGGER IF EXISTS trigger_update_time_of_transaction ON public.transactions_details;

CREATE OR REPLACE TRIGGER trigger_update_time_of_transaction
    BEFORE INSERT
    ON public.transactions_details
    FOR EACH ROW
    EXECUTE FUNCTION public.transactions_details_time_of_transaction();
