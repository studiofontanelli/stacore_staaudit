package it.csi.stacore.staaudit.integration.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.csi.stacore.staaudit.integration.entity.StaDOperazione;

@Repository
public interface StaDOperazioneRepository extends CrudRepository<StaDOperazione, Integer> {
	
	@Query("select u from StaDOperazione u where u.codiceOperazione=?1")
	public StaDOperazione findByCodiceOperazione(String codiceOperazione);

}
