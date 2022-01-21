package it.csi.stacore.staaudit.integration.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import it.csi.stacore.staaudit.integration.entity.StaDProdotto;

@Repository
public interface StaDProdottoRepository extends CrudRepository<StaDProdotto, Long> {
	


}
