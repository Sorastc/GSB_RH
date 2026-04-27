package Interface;

import java.util.ArrayList;

public class StatMontantFraisForfaitRegionsMoisVisiteurs extends StatBaseRegionMois {

    public StatMontantFraisForfaitRegionsMoisVisiteurs() {
        super(
            "Montant forfait par visiteur",
            new String[]{"Nom", "Prénom", "Montant forfait"}
        );
    }

    @Override
    protected ArrayList<String[]> getResultats(int idRegion, int mois, int annee) {
        return statDAO.getMontantForfaitParVisiteur(idRegion, mois, annee);
    }
}
