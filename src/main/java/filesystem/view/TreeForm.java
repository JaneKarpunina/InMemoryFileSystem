package filesystem.view;


import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.server.StreamResource;
import com.vaadin.flow.shared.Registration;
import com.vaadin.flow.spring.annotation.SpringComponent;
import filesystem.model.FileSystemObject;
import filesystem.model.Folder;
import filesystem.repository.FileRepository;
import filesystem.repository.FileSystemObjectRepository;
import filesystem.repository.FolderRepository;
import filesystem.service.FileSystemObjectService;
import org.springframework.context.annotation.Scope;
import org.vaadin.tatu.Tree;

import java.util.List;


@SpringComponent
@Scope("prototype")
public class TreeForm extends VerticalLayout {


    FileSystemObjectService fileSystemObjectService;

    Tree<FileSystemObject> tree = new Tree<>(this::createFileSystemObjectLabel);

    TextArea message = new TextArea("");


    public TreeForm(FileSystemObjectService fileSystemObjectService) {

        this.fileSystemObjectService = fileSystemObjectService;

//        folderRepository.save(new Folder(1, "root folder 1",
//                "author1", 0));
//        folderRepository.save(new Folder(2, "root folder 2",
//                "author2", 0));
//        folderRepository.save(new Folder(3, "child folder 1",
//                "author1", 1));
//        fileRepository.save(new File(4, "file 1",
//                "author1", 3));
//        fileRepository.save(new File(5, "file 2",
//                "author1", 2));
//        fileRepository.save(new File(6, "file 3",
//                "author2", 1));
//        fileRepository.save(new File(7, "file 4",
//                "author2", 2));

        message.setHeight("100px");
        message.setReadOnly(true);

        configureTree();
        add(tree, message);

    }

    private void configureTree() {

        tree.setItems(getRootSystemObjects(),
                this::getChildSystemObjects);

        tree.setItemIconProvider(this::getIcon);
        tree.setItemIconSrcProvider(this::getImageIconSrc);
        tree.setItemTooltipProvider(this::createFileSystemObjectLabel);

        tree.addExpandListener(event -> message.setValue(
                String.format("Expanded %s item(s)", event.getItems().size())
                        + "\n" + message.getValue()));
        tree.addCollapseListener(event -> message.setValue(
                String.format("Collapsed %s item(s)", event.getItems().size())
                        + "\n" + message.getValue()));

        tree.asSingleSelect().addValueChangeListener(event -> {
            if (event.getValue() != null) {
                System.out.println(event.getValue().getName() + " selected");

                fireEvent(new OpenEvent(this, event.getValue()));
            }
        });
        tree.setAllRowsVisible(true);
        tree.setWidth("200px");
        tree.setHeight("300px");

        //fileSystemObjectRepository.findByParent(0);


    }

    private StreamResource getImageIconSrc(FileSystemObject item) {
        if (item.getName().equalsIgnoreCase("vaadin")) {
            return new StreamResource("vaadin.svg", () -> getClass()
                    .getClassLoader().getResourceAsStream("images/vaadin.svg"));
        } else {
            return null;
        }
    }

    private VaadinIcon getIcon(FileSystemObject item) {
        if (item instanceof Folder)
            return VaadinIcon.BUILDING;
        else if (item.getName().equalsIgnoreCase("vaadin")) {
            return null;
        } else
            return VaadinIcon.USER;
    }

    public List<FileSystemObject> getRootSystemObjects() {

        return fileSystemObjectService.findFileSystemObjectsByParent(0);
    }

    public List<FileSystemObject> getChildSystemObjects(FileSystemObject parent) {

        return fileSystemObjectService.findFileSystemObjectsByParent(parent.getId());
    }

    private String createFileSystemObjectLabel(FileSystemObject item) {
        return item.getName();
    }

    public static abstract class TreeFormEvent extends ComponentEvent<TreeForm> {
        private FileSystemObject fileSystemObject;

        protected TreeFormEvent(TreeForm source, FileSystemObject fileSystemObject) {
            super(source, false);
            this.fileSystemObject = fileSystemObject;
        }

        public FileSystemObject getFileSystemObject() {
            return fileSystemObject;
        }
    }

    public static class OpenEvent extends TreeFormEvent  {
        OpenEvent(TreeForm source, FileSystemObject fileSystemObject) {
            super(source, fileSystemObject);
        }
    }


    public Registration addOpenListener(ComponentEventListener<OpenEvent> listener) {
        return addListener(OpenEvent.class, listener);
    }


}
