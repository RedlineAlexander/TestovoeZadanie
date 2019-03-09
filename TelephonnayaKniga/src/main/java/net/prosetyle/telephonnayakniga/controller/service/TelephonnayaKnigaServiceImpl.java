package net.prosetyle.telephonnayakniga.controller.service;

import net.prosetyle.telephonnayakniga.controller.dao.TelephonnayaKnigaDao;
import net.prosetyle.telephonnayakniga.controller.entity.Telephonnaya_Kniga;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;
@Service
public class TelephonnayaKnigaServiceImpl implements TelephonnayaKnigaService{

    private TelephonnayaKnigaDao telephonnaya_knigaDao;

    public void setTelephonnaya_knigaDao(TelephonnayaKnigaDao telephonnaya_knigaDao) {
        this.telephonnaya_knigaDao = telephonnaya_knigaDao;
    }

    @Override
    @Transactional
    public void addTelephonnayaKniga(Telephonnaya_Kniga telephonnaya_kniga) {
    this.telephonnaya_knigaDao.addTelephonnayaKniga(telephonnaya_kniga);
    }

    @Override
    @Transactional
    public void updateTelephonnayaKniga(Telephonnaya_Kniga telephonnaya_kniga) {
     this.telephonnaya_knigaDao.updateTelephonnayaKniga(telephonnaya_kniga);
    }

    @Override
    @Transactional
    public void removeTelephonnayaKniga(Integer id) {
        this.telephonnaya_knigaDao.removeTelephonnayaKniga(id);
    }

    @Override
    @Transactional
    public Telephonnaya_Kniga getTelephonnayaKnigaById(Integer id) {
        return this.telephonnaya_knigaDao.getTelephonnayaKnigaById(id);
    }




    @Override
    @Transactional
    public List<Telephonnaya_Kniga> listTelephonnayaKniga() {
        return this.telephonnaya_knigaDao.listTelephonnayaKniga();
    }

private EntityManager em = Persistence.createEntityManagerFactory("DBUnitEx").createEntityManager();

    public void save(Telephonnaya_Kniga telephonnaya_kniga){
        em.getTransaction().begin();
        em.persist(telephonnaya_kniga);
        em.getTransaction().commit();
    }
    public void delete(Telephonnaya_Kniga telephonnaya_kniga){
        em.getTransaction().begin();
        em.remove(telephonnaya_kniga);
        em.getTransaction().commit();
    }
    public Telephonnaya_Kniga get(Integer id){return em.find(Telephonnaya_Kniga.class, id);}

    public void update(Telephonnaya_Kniga telephonnaya_kniga){
        em.getTransaction().begin();
        em.merge(telephonnaya_kniga);
        em.getTransaction().commit();
    }

    public List<Telephonnaya_Kniga> getAll(){
        TypedQuery<Telephonnaya_Kniga> telephonnaya_knigaTypedQuery = em.createNamedQuery("Telephonnaya_Kniga.getAll", Telephonnaya_Kniga.class);
        return telephonnaya_knigaTypedQuery.getResultList();
    }

}
