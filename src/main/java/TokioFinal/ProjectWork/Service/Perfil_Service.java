package TokioFinal.ProjectWork.Service;

import TokioFinal.ProjectWork.Repository.ServicoRepository;
import TokioFinal.ProjectWork.entity.Perfil_Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class Perfil_Service {

    private final ServicoRepository servicoRepository;

    @Autowired
    public Perfil_Service(ServicoRepository servicoRepository) {
        this.servicoRepository = servicoRepository;
    }

    public List<Perfil_Entity> buscarPerfis(String id, String nome, String centrocusto, String ativo) {
        List<Perfil_Entity> perfis = servicoRepository.findAll();

        if (id != null && !id.isEmpty()) {
            try {
                long idLong = Long.parseLong(id);
                perfis = perfis.stream()
                        .filter(perfil -> perfil.getId() == idLong)
                        .collect(Collectors.toList());
            } catch (NumberFormatException e) {
                return List.of();
            }
        }

        if (nome != null && !nome.isEmpty()) {
            perfis = perfis.stream()
                    .filter(perfil -> perfil.getNome().equalsIgnoreCase(nome))
                    .collect(Collectors.toList());
        }

        if (centrocusto != null && !centrocusto.isEmpty()) {
            try {
                Double centrocustoDouble = Double.parseDouble(centrocusto);
                perfis = perfis.stream()
                        .filter(perfil -> perfil.getCentroCusto() != null && perfil.getCentroCusto().equals(centrocustoDouble))
                        .collect(Collectors.toList());
            } catch (NumberFormatException e) {
                return List.of();
            }
        }

        if (ativo != null && !ativo.isEmpty()) {
            perfis = perfis.stream()
                    .filter(perfil -> perfil.getAtivo() != null && perfil.getAtivo().equalsIgnoreCase(ativo))
                    .collect(Collectors.toList());
        }

        return perfis;
    }

    public List<Perfil_Entity> buscarTodos() {
        return servicoRepository.findAll();
    }
    public List<Perfil_Entity> inserirMultiplos(List<Perfil_Entity> servicos) {
        return servicoRepository.saveAll(servicos);
    }
    public Perfil_Entity inserir(Perfil_Entity servico) {
        // Garante que o ID seja nulo para evitar problemas de atualização acidental
        if (servico.getId() != 0) {
            throw new IllegalArgumentException("O objeto a ser inserido não pode ter ID preenchido.");
        }
        return servicoRepository.save(servico);
    }

    public Perfil_Entity alterar(Perfil_Entity servico) {
        // Garante que o ID seja fornecido para garantir que o objeto exista antes de atualizar
        if (servico.getId() == 0) {
            throw new IllegalArgumentException("O objeto a ser alterado deve ter ID preenchido.");
        }
        return servicoRepository.save(servico);
    }

    public void excluir(Long id) {
        servicoRepository.deleteById(id);
    }

    public void deletar() {
        servicoRepository.deleteAll();
    }
    public Optional<Perfil_Entity> buscarPorId(Long id) {
        return servicoRepository.findById(id);
    }
}
