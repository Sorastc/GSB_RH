package Interface;

import java.util.ArrayList;

public class StatNombreFicheFraisHorsForfaitRegionsMoisVisiteurs extends StatBaseRegionMois {

    public StatNombreFicheFraisHorsForfaitRegionsMoisVisiteurs() {
        super(
            "Nb fiches hors forfait par visiteur",
            new String[]{"Nom", "Prénom", "Nb lignes HF"}
        );
    }

    @Override
    protected ArrayList<String[]> getResultats(int idRegion, int mois, int annee) {
        return statDAO.getNbFichesHFParVisiteur(idRegion, mois, annee);
    }
}
