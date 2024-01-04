package filesystem.model;

import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "filesystemobject")
@TypeAlias("folder")
public class Folder extends FileSystemObject {

    public Folder() {
    }

    public Folder(Integer id, String name, String author, Integer parent) {
        super(id, name, author, parent);
    }

    private List<Integer> children = new ArrayList<>();

    void addChild(Integer objId) {
        children.add(objId);
    }

    public List<Integer> getChildren() {
        return children;
    }
}
