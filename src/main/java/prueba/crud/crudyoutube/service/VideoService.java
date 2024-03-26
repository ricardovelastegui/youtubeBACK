package prueba.crud.crudyoutube.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import prueba.crud.crudyoutube.entity.Video;
import prueba.crud.crudyoutube.repository.VideoRepository;

@Service
public class VideoService {

    @Autowired
    VideoRepository videoRepository;

    //ya está
    public Video agregarvideo(Video video){
        return videoRepository.save(video);
    }

    //ya está
    public void borrarvideo(Long id){
        videoRepository.deleteById(id);
    }

    //ya está
    public List<Video> obtenervideos(){
        return videoRepository.findAll();
    }

    public Video buscarVideoporId(Long id){

        return videoRepository.findById(id).orElse(null);
    }

    public Video filtrarVideosPortitulo(String title){
        return videoRepository.findByTitle(title);
    }


    //ya está
    public Video actualizardeVideo(Long id, Video videoactualizar){
        Optional<Video> optionalVideo = videoRepository.findById(id);
        if (optionalVideo.isPresent()){
            Video video = optionalVideo.get();
            video.setTitle(videoactualizar.getTitle());
            video.setDescription(videoactualizar.getDescription());
            return videoRepository.save(video);
        } else{
            throw new RuntimeException("Video no encontrado con ID: "+ id);
        }
       
    }


}
