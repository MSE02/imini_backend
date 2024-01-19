package mse.imini.backend.ws;

import mse.imini.backend.bean.Image;
import mse.imini.backend.dao.ImageDao;
import mse.imini.backend.service.impl.ImageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/image")
public class ImageController {
    @Autowired
    private ImageServiceImpl imageServiceImpl;
    @Autowired
    private ImageDao imageDao;

    @PostMapping("/upload")
    public ResponseEntity<?> uploadImage(@RequestParam("image") MultipartFile file) throws IOException {
        String uploadImage = imageServiceImpl.saveImage(file);
        return ResponseEntity.status(HttpStatus.OK)
                .body(uploadImage);
    }

    @GetMapping("/download/{name}")
    public ResponseEntity<?> uploadImage(@PathVariable String name) {
        byte[] imageData = imageServiceImpl.downloadImage(name);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .body(imageData);
    }

    @GetMapping("/")
    public List<Image> getAllImages() {
        return imageDao.findAll();
    }

    @GetMapping("/{id}")
    public Image getImageById(@PathVariable Long id) {
        return imageDao.findImageById(id);
    }

    @GetMapping("/actualiteId/{id}")
    public List<Image> getImagesByActualiteId(@PathVariable Long id) {
        return imageDao.findImageByActualite_Id(id);
    }
}
