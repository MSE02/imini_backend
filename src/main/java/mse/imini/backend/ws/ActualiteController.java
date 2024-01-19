package mse.imini.backend.ws;

import mse.imini.backend.bean.Actualite;
import mse.imini.backend.service.facade.ActualiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/actualites")
public class ActualiteController {
    @Autowired
    private ActualiteService actualiteService;


    @GetMapping("/")
    public List<Actualite> getAllActualites() {
        return actualiteService.getAllActualites();
    }

    @GetMapping("/{id}")
    public Actualite getActualiteById(@PathVariable Long id) {
        return actualiteService.getActualiteById(id);
    }

    @PostMapping("/")
    public void saveActualite(@RequestBody Actualite actualite) {
        actualiteService.saveActualite(actualite);
    }

    @DeleteMapping("/{id}")
    public void deleteActualite(@PathVariable Long id) {
        actualiteService.deleteActualite(id);
    }

    @PutMapping("/{id}")
    public void updateActualite(@PathVariable Long id, @RequestBody Actualite actualite) {
        actualiteService.updateActualite(id, actualite);
    }
}
