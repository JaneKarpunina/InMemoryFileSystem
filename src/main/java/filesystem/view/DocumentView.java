package filesystem.view;


import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;
import jakarta.annotation.security.PermitAll;
import org.springframework.context.annotation.Scope;

@SpringComponent
@Scope("prototype")
public class DocumentView extends VerticalLayout {


   TextField name = new TextField();

   TextField author = new TextField();

   public DocumentView() {

       HorizontalLayout docParams = new HorizontalLayout();

       docParams.add(name, author);
       add(docParams);
   }




}
