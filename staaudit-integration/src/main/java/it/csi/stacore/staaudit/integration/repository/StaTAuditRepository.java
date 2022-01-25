package it.csi.stacore.staaudit.integration.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.csi.stacore.staaudit.integration.entity.StaTAudit;

@Repository
public interface StaTAuditRepository extends CrudRepository<StaTAudit, Long> {
	


}
