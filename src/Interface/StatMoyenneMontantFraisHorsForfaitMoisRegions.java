package Interface;

import java.util.ArrayList;

public class StatMoyenneMontantFraisHorsForfaitMoisRegions extends StatBaseMois {

    public StatMoyenneMontantFraisHorsForfaitMoisRegions() {
        super(
            "Moyenne hors forfait par région",
            new String[]{"Région", "Nb visiteurs", "Moyenne HF"}
        );
    }

    @Override
    protected ArrayList<String[]> getResultats(int mois, int annee) {
        return statDAO.getMoyenneHFParRegion(mois, annee);
    }
}
