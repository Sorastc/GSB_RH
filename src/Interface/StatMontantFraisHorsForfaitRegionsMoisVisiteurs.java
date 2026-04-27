package Interface;

import java.util.ArrayList;

public class StatMontantFraisHorsForfaitRegionsMoisVisiteurs extends StatBaseRegionMois {

    public StatMontantFraisHorsForfaitRegionsMoisVisiteurs() {
        super(
            "Montant hors forfait par visiteur",
            new String[]{"Nom", "Prénom", "Montant HF"}
        );
    }

    @Override
    protected ArrayList<String[]> getResultats(int idRegion, int mois, int annee) {
        return statDAO.getMontantHFParVisiteur(idRegion, mois, annee);
    }
}
