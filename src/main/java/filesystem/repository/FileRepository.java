package filesystem.repository;

import filesystem.model.File;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface FileRepository extends MongoRepository<File, Integer>{
}
