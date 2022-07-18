package builder;

import bo.Pays;
import dal.PaysDAO;

import java.util.Map;

public class PaysBuilder {
    PaysDAO paysDAO = new PaysDAO();
    public Pays createOBJPays(Object pays) {
        Pays paysToCreate = new Pays();
        Map<String, Object> mapPays = (Map) pays;

        paysToCreate.setNom((String) mapPays.get("nom"));
        paysToCreate.setUrl((String) mapPays.get("url"));
        return checkDuplicatePays(paysToCreate);
    }

    public Pays checkDuplicatePays(Pays pays) {
        if(paysDAO.get(pays) == null) {
            paysDAO.create(pays);
            return pays;
        } else {
            return paysDAO.get(pays);
        }
    }
}
