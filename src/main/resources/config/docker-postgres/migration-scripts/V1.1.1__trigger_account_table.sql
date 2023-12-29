-- FUNCTION: public.account_created_at()

-- DROP FUNCTION IF EXISTS public.account_created_at();

CREATE OR REPLACE FUNCTION public.account_created_at()
    RETURNS trigger
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE NOT LEAKPROOF
AS $BODY$
BEGIN
    NEW.created_at = NOW();
RETURN NEW;
END;
$BODY$;

ALTER FUNCTION public.account_created_at()
    OWNER TO postgres;


-- Trigger: trigger_account_created_at

-- DROP TRIGGER IF EXISTS trigger_account_created_at ON public.accounts;

CREATE OR REPLACE TRIGGER trigger_account_created_at
    BEFORE INSERT
    ON public.accounts
    FOR EACH ROW
    EXECUTE FUNCTION public.account_created_at();