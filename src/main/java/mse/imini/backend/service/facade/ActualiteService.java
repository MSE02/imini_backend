package mse.imini.backend.service.facade;

import mse.imini.backend.bean.Actualite;

import java.util.Date;
import java.util.List;

public interface ActualiteService {
    List<Actualite> getAllActualites();

    Actualite getActualiteById(Long id);

    Actualite saveActualite(Actualite actualite);

    void deleteActualite(Long id);

    Actualite updateActualite(Long id, Actualite updatedActualite);
}
