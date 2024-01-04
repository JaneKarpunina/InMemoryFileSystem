package filesystem.view;


import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.spring.annotation.SpringComponent;
import filesystem.repository.FileRepository;
import filesystem.repository.FileSystemObjectRepository;
import filesystem.repository.FolderRepository;
import filesystem.service.FileSystemObjectService;
import org.springframework.context.annotation.Scope;


@SpringComponent
@Scope("prototype")
public class DocumentForm extends VerticalLayout {

    FileSystemObjectService fileSystemObjectService;
   TextField name = new TextField();

   TextField author = new TextField();

   TextField parent = new TextField();

   Checkbox isFolder = new Checkbox();

   public DocumentForm(FileSystemObjectService fileSystemObjectService) {

       this.fileSystemObjectService = fileSystemObjectService;

       HorizontalLayout docParams = new HorizontalLayout();

       name.setLabel("Name: ");
       author.setLabel("Author: ");
       docParams.add(name, author);

       HorizontalLayout docParams2 = new HorizontalLayout();

       parent.setLabel("Parent: ");
       isFolder.setLabel("Folder: ");
       docParams2.add(parent, isFolder);

       add(docParams, docParams2);
   }

    public void setName(String name) {
        this.name.setValue(name);
    }

    public void setAuthor(String author) {
        this.author.setValue(author);
    }

    public void setParent(String parent) {
        this.parent.setValue(parent);
    }

    public void setIsFolder(boolean isFolder) {
        this.isFolder.setValue(isFolder);
    }
}
