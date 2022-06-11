package scanner.projet.service;

import scanner.projet.model.bo.Image;

public interface IImageService {
    Image saveImage(Image a);

    Image findImage(Long id);
}
