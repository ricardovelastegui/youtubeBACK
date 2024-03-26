package prueba.crud.crudyoutube.repository;

import org.springframework.stereotype.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import prueba.crud.crudyoutube.entity.Video;

@Repository
public interface VideoRepository extends JpaRepository<Video, Long>{
    Video findByTitle(String title);

    Optional<Video> findById(Long id);
}
