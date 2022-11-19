package au.com.telstra.simcardactivator;

import au.com.telstra.simcardactivator.SimDBRecord;
import org.springframework.data.repository.CrudRepository;

public interface SimRepository extends CrudRepository<SimDBRecord, Long> {
}
