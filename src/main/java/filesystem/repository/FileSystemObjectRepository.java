package filesystem.repository;

import filesystem.model.FileSystemObject;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FileSystemObjectRepository extends MongoRepository<FileSystemObject, Integer> {

    List<FileSystemObject> findByParent(Integer parent);

    //List<FileSystemObject> find
}
