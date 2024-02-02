-- stat inscription user dans une anne
CREATE OR REPLACE FUNCTION stat_user_anne_beta(_anne int)
RETURNS TABLE (
    nb_users bigint,
    mois int,
    anne int
)
AS $$
DECLARE 
    i int;
    _mois int;
BEGIN
    FOR i in 1..12
    LOOP
    _mois := i;
        RETURN QUERY
            select 
            (
                select 
                v_users.nb_users
                from
                    v_users
                    where v_users.mois = _mois and v_users.anne = _anne
            ) as nb_users,
            _mois, _anne;
            
    END LOOP;
END;
$$ LANGUAGE plpgsql;


CREATE OR REPLACE FUNCTION stat_user_anne(_anne int)
RETURNS TABLE (
    nb_users bigint,
    mois int,
    anne int
)
AS $$
BEGIN
    RETURN QUERY 
        select 
        case when v.nb_users is null then 0 else v.nb_users end,
        v.mois, v.anne
        from
        stat_user_anne_beta(_anne) as v;
END;
$$ LANGUAGE plpgsql;

-- select * from stat_user_anne(2024);

-- annonce / mois
CREATE OR REPLACE FUNCTION stat_annonce_anne_beta(_anne int)
RETURNS TABLE (
    nb_annonce bigint,
    mois int,
    anne int
)
AS $$
DECLARE 
    i int;
    _mois int;
BEGIN
    FOR i in 1..12
    LOOP
    _mois := i;
        RETURN QUERY
            select 
            (
                select 
                v_annonce_mois.nb_annonce
                from
                    v_annonce_mois
                    where v_annonce_mois.mois = _mois and v_annonce_mois.anne = _anne
            ) as nb_annonce,
            _mois, _anne;
            
    END LOOP;
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION stat_annonce_anne(_anne int)
RETURNS TABLE (
    nb_annonce bigint,
    mois int,
    anne int
)
AS $$
BEGIN
    RETURN QUERY 
        select 
        case when v.nb_annonce is null then 0 else v.nb_annonce end,
        v.mois, v.anne
        from
        stat_annonce_anne_beta(_anne) as v;
END;
$$ LANGUAGE plpgsql;

-- select * from stat_annonce_anne(2024);

CREATE OR REPLACE FUNCTION stat_revenu_anne_beta(_anne int)
RETURNS TABLE (
    nb_commission bigint,
    total_commission double precision,
    mois int,
    anne int
)
AS $$
DECLARE 
    i int;
    _mois int;
BEGIN
    FOR i in 1..12
    LOOP
    _mois := i;
        RETURN QUERY
            select 
            (
                select 
                v_revenu_mensuel.nb_commission
                from
                    v_revenu_mensuel
                    where v_revenu_mensuel.mois = _mois and v_revenu_mensuel.anne = _anne
            ) as nb_commission,
            (
                select 
                v_revenu_mensuel.total_commission
                from
                    v_revenu_mensuel
                    where v_revenu_mensuel.mois = _mois and v_revenu_mensuel.anne = _anne
            ) as total_commission,
            _mois, _anne;
            
    END LOOP;
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION stat_revenu_anne(_anne int)
RETURNS TABLE (
    nb_commission bigint,
    total_commission double precision,
    mois int,
    anne int
)
AS $$
BEGIN
    RETURN QUERY 
        select 
        case when v.nb_commission is null then 0 else v.nb_commission end,
        case when v.total_commission is null then 0 else v.total_commission end,
        v.mois, v.anne
        from
        stat_revenu_anne_beta(_anne) as v;
END;
$$ LANGUAGE plpgsql;

-- select * from stat_revenu_anne(2024);

CREATE OR REPLACE FUNCTION get_total_reaction(id_an varchar)
RETURNS INTEGER AS $$
DECLARE
    total_count INTEGER;
BEGIN
    SELECT COALESCE(COUNT(*), 0) INTO total_count
    FROM favoris_user_annonce
    WHERE id_annonce = id_an;

    RETURN total_count;
END;
$$ LANGUAGE plpgsql;

--select * from get_total_reaction('AN1');
