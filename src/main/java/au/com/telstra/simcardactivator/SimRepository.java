package au.com.telstra.simcardactivator;

import org.springframework.data.repository.CrudRepository;

public interface SimRepository extends CrudRepository<SimDBRecord, Long> {
}
