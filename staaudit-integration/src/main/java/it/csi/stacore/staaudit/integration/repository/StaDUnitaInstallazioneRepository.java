package it.csi.stacore.staaudit.integration.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.csi.stacore.staaudit.integration.entity.StaDUnitaInstallazione;

@Repository
public interface StaDUnitaInstallazioneRepository extends CrudRepository<StaDUnitaInstallazione, Integer> {
	

	@Query("select u from StaDUnitaInstallazione u where u.codiceUnitaInstallazione=?1")
	public StaDUnitaInstallazione findByCodiceUnitaInstallazione(String codiceUnitaInstallazione);

}
