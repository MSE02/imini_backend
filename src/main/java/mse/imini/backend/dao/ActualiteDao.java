package mse.imini.backend.dao;

import mse.imini.backend.bean.Actualite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ActualiteDao extends JpaRepository<Actualite,Long> {
    Actualite findActualiteById(Long id);

}

