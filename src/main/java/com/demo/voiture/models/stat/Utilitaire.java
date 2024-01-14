package com.demo.voiture.models.stat;

public class Utilitaire {

    public static String getMois(int mois) throws  Exception {
        try {
            String[] all_mois = {"Janvier", "Fevrier", "Mars",
            "Avril", "Mai", "Juin", "Juillet", "Aout", "Septembre",
            "Octobre", "Decembre"
            };
            return all_mois[mois - 1];
        }
        catch (Exception e) {
            throw  new Exception("Mois entre 1 a 12");
        }
    }

    public static void verifyAnne(int anne) throws Exception {
        if(anne < 0) {
            throw new Exception("Invalide anne");
        }
    }


    public static void  verifyMoisAnne(int mois, int anne) throws Exception {
        try {
            String mois_str = getMois(mois);
            if(anne < 0) {
                throw new Exception("Invalide anne");
            }
        }catch (Exception e) {
            throw e;
        }
    }

}
