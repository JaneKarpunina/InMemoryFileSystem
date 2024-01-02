package filesystem.view;


import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;
import jakarta.annotation.security.PermitAll;
import org.springframework.context.annotation.Scope;

@SpringComponent
@Scope("prototype")
@PermitAll
@Route(value = "", layout = MainLayout.class)
@PageTitle("Files | File system")
public class MainView extends HorizontalLayout {


    TreeView treeView;

    DocumentView documentView;

    public MainView(TreeView treeView, DocumentView documentView) {
        
    }




}
