package mse.imini.backend.service.impl;

import mse.imini.backend.bean.Image;
import mse.imini.backend.dao.ImageDao;
import mse.imini.backend.service.facade.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import mse.imini.backend.util.ImageUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;


@Service
public class ImageServiceImpl implements ImageService {
    @Autowired
    ImageDao imageDao;

    @Override
    @Transactional
    public String saveImage(MultipartFile file) throws IOException {
        Image imageData = imageDao.save(Image.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .imageData(ImageUtils.compressImage(file.getBytes())).build());
        if (imageData != null) {
            return "file uploaded successfully : " + file.getOriginalFilename();
        }
        return null;
    }

    public byte[] downloadImage(String fileName) {
        List<Image> dbImages = imageDao.findByName(fileName);
        Image dbImageData = dbImages.get(0);
        byte[] images = ImageUtils.decompressImage(dbImageData.getImageData());
        return images;
    }

}
