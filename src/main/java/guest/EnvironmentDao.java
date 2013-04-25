package guest;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
@Component
public class EnvironmentDao {
    @PersistenceContext private EntityManager em;
    
    @Transactional
    public void persist(Environment env){
    em.persist(env);
    }

    public List<Environment> getAllEnvironments(){
    TypedQuery<Environment> query = em.createQuery(
        "SELECT env FROM Environment env ORDER BY env.envId",Environment.class);
    return query.getResultList();
    }
}
