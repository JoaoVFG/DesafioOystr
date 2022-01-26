package JoaoVFG.com.github.DesafioOystr.Repository;

import JoaoVFG.com.github.DesafioOystr.Entity.Publicacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface PublicacaoRepository extends JpaRepository<Publicacao, Integer> {

    @Transactional(readOnly = true)
    Publicacao findBychaveUnica(String chaveUnica);

}
