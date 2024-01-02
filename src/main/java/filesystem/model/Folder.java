package filesystem.model;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "filesystemobject")
@TypeAlias("folder")
public class Folder extends FileSystemObject {
}
