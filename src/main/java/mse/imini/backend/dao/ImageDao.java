package mse.imini.backend.dao;

import mse.imini.backend.bean.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ImageDao extends JpaRepository<Image, Long> {
    Image findImageById(Long id);

    List<Image> findImageByActualite_Id(Long id);

    List<Image> findByName(String fileName);

}
