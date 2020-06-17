package controllers;

import models.Person;
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
public class HomeController extends Controller {

    @Inject
    FormFactory formFactory; 
    Form <Person > personForm ;
    MessagesApi messagesApi;
    
    @Inject
    public HomeController(FormFactory formFactory, MessagesApi messagesApi) {
     this.personForm = formFactory.form(Person.class);
     this.messagesApi = messagesApi;
    }
    
    /*
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result index() {
        return ok(TP2.render());
    }
    
    public Result all(){
        List<Person> liste = Person.find.all();
        return ok(all.render(liste));
    }
    
    public Result show (Long id) {
        Person p = Person.find.byId(id) ;
        return ok(show.render(p)) ;
    }
    
    public Result delete ( Long id) {
        Person p = Person.find.byId(id) ;
        p.delete() ;
        return ok(delete.render()) ;
    }
    public Result TP21() {
        return ok(views.html.TP21.render());
    }
    public Result TP22() {
        return ok(views.html.TP22.render());
    }
    public Result TP23() {
        return ok(views.html.TP23.render());
    }
    public Result TP24() {
        return ok(views.html.TP24.render());
    }
    public Result TP2livre() {
        return ok(views.html.TP2livre.render());
    }
     public Result utili (Http.Request request) {
        personForm = formFactory.form(Person.class) ;
        return ok(utili.render(personForm, request, messagesApi.preferred(request))) ; 
    }
    public Result welcome(Http.Request request) {
       final Form<Person> pForm = personForm.bindFromRequest(request) ; 
    //    if (pForm.hasErrors()){
      //      return badRequest(sayhelloform.render(pForm,request, messagesApi.preferred(request)));
    //    }
    //    else{
            Person a = pForm.get();
            a.save();
        return ok(welcome.render(a)) ;
    //    }
    }

}
