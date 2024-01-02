package filesystem.view;


import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.spring.annotation.SpringComponent;
import filesystem.model.FileSystemObject;
import filesystem.repository.FileRepository;
import filesystem.repository.FolderRepository;
import org.springframework.context.annotation.Scope;
import org.vaadin.tatu.Tree;

@SpringComponent
@Scope("prototype")
public class TreeView extends VerticalLayout {

    FileRepository fileRepository;

    FolderRepository folderRepository;


    Tree<? extends FileSystemObject> tree = new Tree<>(this::createFileSystemObjectLabel);

    public TreeView(FileRepository fileRepository, FolderRepository folderRepository) {

        this.fileRepository = fileRepository;
        this.folderRepository = folderRepository;

        configureTree();

        add(tree);

    }

    private void configureTree() {

    }

    private String createFileSystemObjectLabel(FileSystemObject item) {

        return item.getName();
    }


}
