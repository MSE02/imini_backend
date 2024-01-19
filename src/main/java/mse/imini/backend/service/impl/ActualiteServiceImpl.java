package mse.imini.backend.service.impl;

import mse.imini.backend.bean.Actualite;
import mse.imini.backend.dao.ActualiteDao;
import mse.imini.backend.service.facade.ActualiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class ActualiteServiceImpl implements ActualiteService {
    @Autowired
    private ActualiteDao actualiteDao;

    @Override
    public List<Actualite> getAllActualites() {
        return actualiteDao.findAll();
    }

    @Override
    public Actualite getActualiteById(Long id) {
        return actualiteDao.findActualiteById(id);
    }

    @Override
    @Transactional
    public Actualite saveActualite(Actualite actualite) {
        return actualiteDao.save(actualite);
    }

    @Override
    @Transactional
    public void deleteActualite(Long id) {
        actualiteDao.deleteById(id);
    }

    @Override
    @Transactional
    public Actualite updateActualite(Long id, Actualite updatedActualite) {
        if (updatedActualite.getTitre() != null) {
            actualiteDao.findActualiteById(id).setTitre(updatedActualite.getTitre());
        }
        if (updatedActualite.getContenu() != null) {
            actualiteDao.findActualiteById(id).setContenu(updatedActualite.getContenu());
        }
        if (updatedActualite.getDatePublication() != null) {
            actualiteDao.findActualiteById(id).setDatePublication(updatedActualite.getDatePublication());
        }
        // Perform the update in the database
        return actualiteDao.save(actualiteDao.findActualiteById(id));
    }
}



