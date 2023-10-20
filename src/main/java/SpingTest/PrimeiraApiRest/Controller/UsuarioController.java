package SpingTest.PrimeiraApiRest.Controller;

import SpingTest.PrimeiraApiRest.Objetos.Usuario;
import SpingTest.PrimeiraApiRest.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioController {
    @Autowired
    private UsuarioRepository repository;
    @GetMapping("/usuarios")
    public List<Usuario> getUsuarios(){
       return repository.findAll();
    }
    @GetMapping("/{nome}")
    public Usuario getOne(@PathVariable("nome") String nome){
        return repository.findByUsername(nome);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id){
        repository.deleteById(id);
    }
    @PostMapping()
    public void postUser(@RequestBody Usuario user){
        repository.save(user);
    }
    @PutMapping()
    public void putUser(@RequestBody Usuario user){
        repository.save(user);
    }
}
