package guest;
 
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
 
@Controller
public class GuestController {
 
    @Autowired
    private GuestDao guestDao;
 
    @Autowired
    private EnvironmentDao environmentDao;
    
     @RequestMapping(value="/guest")
    public ModelAndView guestbook(HttpServletRequest request) {
        // Handle a new guest (if any):
        String name = request.getParameter("name");
        if (name != null)
            guestDao.persist(new Guest(name));
 
        // Prepare the result view (guest.jsp):
        return new ModelAndView("guest.jsp", "guestDao", guestDao); 
     }
     
     @RequestMapping(value="/environments")
    public ModelAndView findEnvironment(HttpServletRequest request) {
        // Handle a new guest (if any):
        String envName = request.getParameter("envName");
        String isActive = request.getParameter("isActive");
        String envDesc = request.getParameter("envDesc");
        if(envName!=null && isActive!=null && envDesc != null){
            for(int i=1;i<10;i++){
            Environment env = new Environment();
                env.setEnvDesc(envDesc);
                env.setEnvName(envName);
                env.setIsActive(Boolean.valueOf(isActive));
                environmentDao.persist(env);
            }
        }
 
        // Prepare the result view (guest.jsp):
        return new ModelAndView("environments.jsp", "environmentDao", environmentDao);
    }
}