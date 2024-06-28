package TokioFinal.ProjectWork.Repository;

import TokioFinal.ProjectWork.entity.Perfil_Entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicoRepository extends JpaRepository<Perfil_Entity, Long> {
}
