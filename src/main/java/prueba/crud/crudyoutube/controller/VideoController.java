package prueba.crud.crudyoutube.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import prueba.crud.crudyoutube.entity.Video;
import prueba.crud.crudyoutube.service.VideoService;

@RestController
@RequestMapping("/videos")
@CrossOrigin( origins = "http://localhost:4200/" )
public class VideoController {
    @Autowired
    private VideoService videoService;

    @PostMapping("/agregar")
    public Video agregarvide(@RequestBody Video video){
        return videoService.agregarvideo(video);
    }

    @DeleteMapping("/borrar/{id}")
    public void borrarvideo(@PathVariable Long id){
        videoService.borrarvideo(id);
    }

    @GetMapping("/obtener")
    @ResponseBody
    public List<Video> obtenervideos(){
        return videoService.obtenervideos();
    }

    @GetMapping("/obtener/{id}")
    @ResponseBody
    public Video buscarVideoporId(@PathVariable Long id){
        return videoService.buscarVideoporId(id);
    }

    @GetMapping("/filtrar")
    @ResponseBody
    public ResponseEntity<Video> filtrarVideosPortitulo(@RequestParam String title){
        Video video = videoService.filtrarVideosPortitulo(title);
        if(video != null){
            return ResponseEntity.ok(video);
        } else{
            return ResponseEntity.notFound().build();
        }
    }
   

    @PutMapping("/modificar/{id}")
    public Video actualizardeVideo(@PathVariable Long id, @RequestBody Video videoactualizar){
        return videoService.actualizardeVideo(id, videoactualizar);
    }
    
}
