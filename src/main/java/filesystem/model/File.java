package filesystem.model;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "filesystemobject")
@TypeAlias("file")
public class File extends FileSystemObject {

    public File() {
    }

    public File(Integer id, String name, String author, Integer parent) {
        super(id, name, author, parent);
    }


}
