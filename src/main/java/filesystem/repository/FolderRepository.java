package filesystem.repository;

import filesystem.model.Folder;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FolderRepository extends MongoRepository<Folder, Integer> {
}
