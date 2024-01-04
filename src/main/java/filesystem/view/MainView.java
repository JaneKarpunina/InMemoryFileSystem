package filesystem.view;


import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;
import filesystem.model.FileSystemObject;
import filesystem.model.Folder;
import jakarta.annotation.security.PermitAll;
import org.springframework.context.annotation.Scope;

@SpringComponent
@Scope("prototype")
@PermitAll
@Route(value = "", layout = MainLayout.class)
@PageTitle("Files | File system")
public class MainView extends HorizontalLayout {


    TreeForm treeForm;

    DocumentForm documentForm;

    public MainView(TreeForm treeForm, DocumentForm documentForm) {

        this.treeForm = treeForm;
        this.documentForm = documentForm;
        configureTreeForm();
        configureDocumentForm();
        add(treeForm, documentForm);

    }

    void configureTreeForm() {

        treeForm.setWidth("25em");

        treeForm.addOpenListener(this::openSystemObject);

    }

    private void openSystemObject(TreeForm.OpenEvent openEvent) {

        FileSystemObject fileSystemObject = openEvent.getFileSystemObject();
        documentForm.setName(fileSystemObject.getName());
        documentForm.setParent(String.valueOf(fileSystemObject.getParent()));
        documentForm.setAuthor(fileSystemObject.getAuthor());

        if (fileSystemObject instanceof Folder)
            documentForm.setIsFolder(true);
        else documentForm.setIsFolder(false);


    }


    void configureDocumentForm() {

    }



}
