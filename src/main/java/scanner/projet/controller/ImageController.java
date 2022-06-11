package scanner.projet.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import scanner.projet.model.bo.Image;
import scanner.projet.service.implementation.ImageService;

import java.io.IOException;

@RestController
@RequestMapping("/images")
@CrossOrigin(origins = "http://localhost:4200",
        allowCredentials = "true")
public class ImageController {
    @Autowired
    public ImageService imageService;

    @PostMapping("/upload")
    public ResponseEntity<Image> uplaod(@RequestParam("imageFile") MultipartFile file) throws IOException {
        Image img = imageService.uplaodImage(file);
        return new ResponseEntity<>(img,HttpStatus.OK);
    }

    @GetMapping(path = { "/get/{id}" },
            produces = {MediaType.IMAGE_PNG_VALUE,MediaType.IMAGE_JPEG_VALUE})
    public byte[] get(@PathVariable("id") Long  id)
            throws IOException {
        return imageService.getImage(id);
    }

}