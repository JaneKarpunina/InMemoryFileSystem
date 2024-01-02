package filesystem.repository;

import filesystem.model.FileSystemObject;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileSystemObjectRepository extends MongoRepository<FileSystemObject, Integer> {
}
