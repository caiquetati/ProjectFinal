package TokioFinal.ProjectWork.Controller;

import TokioFinal.ProjectWork.Service.Perfil_Service;
import TokioFinal.ProjectWork.entity.Perfil_Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servico")
@CrossOrigin(origins = "http://localhost:3000")
public class Perfil_Controller {

    private final Perfil_Service perfilService;

    @Autowired
    public Perfil_Controller(Perfil_Service perfilService) {
        this.perfilService = perfilService;
    }

    @GetMapping("/buscar")
    public List<Perfil_Entity> buscarPerfis(
            @RequestParam(required = false) String id,
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) String centrocusto,
            @RequestParam(required = false) String ativo) {
        return perfilService.buscarPerfis(id, nome, centrocusto, ativo);
    }

    @PutMapping("/alterar")
    public Perfil_Entity alterar(@RequestBody Perfil_Entity servico) {
        return perfilService.alterar(servico);
    }

    @PostMapping("/inserir")
    public Perfil_Entity inserir(@RequestBody Perfil_Entity servico) {
        return perfilService.inserir(servico);
    }
    @PostMapping("/inserir-multiplos")
    public ResponseEntity<List<Perfil_Entity>> inserirMultiplos(@RequestBody List<Perfil_Entity> servicos) {
        List<Perfil_Entity> resultado = perfilService.inserirMultiplos(servicos);
        return ResponseEntity.ok(resultado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
        perfilService.excluir(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/deletar")
    public ResponseEntity<String> deletar() {
        perfilService.deletar();
        return ResponseEntity.ok("Todos os perfis foram deletados com sucesso.");
    }
}
