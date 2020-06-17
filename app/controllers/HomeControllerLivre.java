package controllers;

import models.Livre;
import views.html.*;
import play.mvc.*;
import java.util.List ; 
import play.data.* ;
import javax.inject.Inject; 
import play.i18n.MessagesApi;


/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeControllerLivre extends Controller {

    @Inject
    FormFactory formFactory; 
    Form <Livre > livreForm ;
    MessagesApi messagesApi;
    
    @Inject
    public HomeControllerLivre(FormFactory formFactory, MessagesApi messagesApi) {
     this.livreForm = formFactory.form(Livre.class);
     this.messagesApi = messagesApi;
    }
    
    /*
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    
    public Result allLivre(){
        List<Livre> liste = Livre.find.all();
        return ok(alllivre.render(liste));
    }
    
    public Result showLivre (Long id) {
        Livre p = Livre.find.byId(id) ;
        return ok(showLivre.render(p)) ;
    }
    
    public Result deleteLivre ( Long id) {
        Livre p = Livre.find.byId(id) ;
        p.delete() ;
        return ok(deleteLivre.render()) ;
    }
     public Result newlivre (Http.Request request) {
        livreForm = formFactory.form(Livre.class) ;
        return ok(newlivre.render(livreForm, request, messagesApi.preferred(request))) ; 
    }
    public Result okNewLivre(Http.Request request) {
       final Form<Livre> pForm = livreForm.bindFromRequest(request) ; 
    //    if (pForm.hasErrors()){
      //      return badRequest(sayhelloform.render(pForm,request, messagesApi.preferred(request)));
    //    }
    //    else{
            Livre a = pForm.get();
            a.save();
        return ok(okNewLivre.render(a)) ;
    //    }
    }

}


