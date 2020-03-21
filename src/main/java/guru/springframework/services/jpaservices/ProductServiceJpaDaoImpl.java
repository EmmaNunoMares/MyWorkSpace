package guru.springframework.services.jpaservices;

import guru.springframework.domain.Product;
import guru.springframework.services.ProductService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by jt on 12/9/15.
 */
@Service
@Profile("jpadao")
public class ProductServiceJpaDaoImpl extends AbstractJpaDaoService implements ProductService {

    @Override
    public List<Product> listAll() {
        EntityManager em = emf.createEntityManager();
        List<Product> out = em.createQuery("from Product", Product.class).getResultList();
        em.close();
        return out;
    }

    @Override
    public Product getById(Integer id) {
        EntityManager em = emf.createEntityManager();
        Product out = em.find(Product.class, id);
        em.close();
        return out;
    }

    @Override
    public Product saveOrUpdate(Product domainObject) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        Product savedProduct = em.merge(domainObject);
        em.getTransaction().commit();
        em.close();
        return savedProduct;
    }

    @Override
    public void delete(Integer id) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.remove(em.find(Product.class, id));
        em.getTransaction().commit();
        em.close();
    }
}
