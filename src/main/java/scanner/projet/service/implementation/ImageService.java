package scanner.projet.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import scanner.projet.model.bo.Image;
import scanner.projet.model.dao.ImageRepository;
import scanner.projet.service.IImageService;

import javax.transaction.Transactional;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

@Service
@Transactional
public class ImageService implements IImageService {
    @Autowired
    private ImageRepository imageRepository;

    @Override
    public Image saveImage(Image a) {
        System.out.println("*** save image .......");
        a=imageRepository.save(a);
        a.setUrl("http://localhost:8080/images/get/"+a.getId());
        return imageRepository.save(a);
    }

    @Override
    public Image findImage(Long id) {
        return imageRepository.findImageById(id);
    }

    public Image uplaodImage(MultipartFile file) throws IOException {
        System.out.println("Original Image Byte Size - " + file.getBytes().length);
        System.out.println(file.getContentType());
        System.out.println(file.getOriginalFilename());
        Image img = new Image(file.getOriginalFilename(), file.getContentType(),
                compressBytes(file.getBytes()));
        return saveImage(img);
    }

    public Image UpdateUplaodImage(MultipartFile file,Image image) throws IOException {
        System.out.println("Original Image Byte Size - " + file.getBytes().length);
        image.setName(file.getOriginalFilename());
        image.setType(file.getContentType());
        image.setPicByte(compressBytes(file.getBytes()));
        return imageRepository.save(image);
    }


    public byte[] getImage(Long  id)
            throws IOException {
        Image retrievedImage = findImage(id);
        Image img = new Image(retrievedImage.getName(), retrievedImage.getType(),
                decompressBytes(retrievedImage.getPicByte()));
        return img.getPicByte();
    }

    // compress the image bytes before storing it in the database
    public static byte[] compressBytes(byte[] data) {
        Deflater deflater = new Deflater();
        deflater.setInput(data);
        deflater.finish();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        while (!deflater.finished()) {
            int count = deflater.deflate(buffer);
            outputStream.write(buffer, 0, count);
        }
        try {
            outputStream.close();
        } catch (IOException e) {
        }
        System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);
        return outputStream.toByteArray();
    }

    // uncompress the image bytes before returning it to the angular application
    public static byte[] decompressBytes(byte[] data) {
        Inflater inflater = new Inflater();
        inflater.setInput(data);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
        byte[] buffer = new byte[1024];
        try {
            while (!inflater.finished()) {
                int count = inflater.inflate(buffer);
                outputStream.write(buffer, 0, count);
            }
            outputStream.close();
        } catch (IOException ioe) {
        } catch (DataFormatException e) {
        }
        return outputStream.toByteArray();
    }

}
