package net.prosetyle.telephonnayakniga.controller.dao;

import net.prosetyle.telephonnayakniga.controller.entity.Telephonnaya_Kniga;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class TelephonnayaKnigaDaoImpl implements TelephonnayaKnigaDao {

    private static final Logger logger = LoggerFactory.getLogger(TelephonnayaKnigaDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory){this.sessionFactory = sessionFactory;}

    @Override
    public void addTelephonnayaKniga(Telephonnaya_Kniga telephonnaya_kniga) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(telephonnaya_kniga);
        logger.info("Telephonnaya_kniga succesfully saved. Telephonnaya_Kniga details: " +telephonnaya_kniga);

    }

    @Override
    public void updateTelephonnayaKniga(Telephonnaya_Kniga telephonnaya_kniga) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(telephonnaya_kniga);
        logger.info("Telephonnaya_kniga succesfully update. Telephonnaya kniga details: "+telephonnaya_kniga);
    }

    @Override
    public void removeTelephonnayaKniga(Integer id) {
        Session session = this.sessionFactory.getCurrentSession();
        Telephonnaya_Kniga telephonnaya_kniga = (Telephonnaya_Kniga) session.load(Telephonnaya_Kniga.class, new Integer(id));
        if(telephonnaya_kniga != null){
            session.delete(telephonnaya_kniga);
        }
        logger.info("Telephonnaya_kniga succesfully removed. Telephonnaya_kniga details: " +telephonnaya_kniga);

    }

    @Override
    public Telephonnaya_Kniga getTelephonnayaKnigaById(Integer id) {
        Session session = this.sessionFactory.getCurrentSession();
        Telephonnaya_Kniga telephonnaya_kniga = (Telephonnaya_Kniga) session.load(Telephonnaya_Kniga.class, new Integer(id));
        logger.info("Telephonnaya kniga succesfully loaded. Telephonnaya kniga details: " +telephonnaya_kniga);

        return telephonnaya_kniga;
    }





    @Override
    @SuppressWarnings("unchecked")
    public List<Telephonnaya_Kniga> listTelephonnayaKniga() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Telephonnaya_Kniga> telephonnaya_knigaList = session.createQuery("from telephonnaya_kniga").list();

        for(Telephonnaya_Kniga telephonnaya_kniga: telephonnaya_knigaList){
            logger.info("telephonnaya_Kniga list: " +telephonnaya_kniga);
        }
        return telephonnaya_knigaList;
    }

}
