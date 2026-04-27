package Interface;

import java.util.ArrayList;

public class StatMoyenneMontantFraisForfaitMoisRegions extends StatBaseMois {

    public StatMoyenneMontantFraisForfaitMoisRegions() {
        super(
            "Moyenne forfait par région",
            new String[]{"Région", "Nb visiteurs", "Moyenne forfait"}
        );
    }

    @Override
    protected ArrayList<String[]> getResultats(int mois, int annee) {
        return statDAO.getMoyenneForfaitParRegion(mois, annee);
    }
}
