package scanner.projet.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import scanner.projet.model.bo.Image;

public interface ImageRepository   extends JpaRepository<Image,Long> {
        Image findByName(String name);
        Image findImageById(Long id);


        }