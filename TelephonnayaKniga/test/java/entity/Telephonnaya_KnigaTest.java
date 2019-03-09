package entity;

import config.DBUnitConfig;
import net.prosetyle.telephonnayakniga.controller.entity.Telephonnaya_Kniga;
import net.prosetyle.telephonnayakniga.controller.service.TelephonnayaKnigaServiceImpl;
import org.dbunit.Assertion;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

public class Telephonnaya_KnigaTest extends DBUnitConfig {
private TelephonnayaKnigaServiceImpl service = new TelephonnayaKnigaServiceImpl();
private EntityManager em = Persistence.createEntityManagerFactory("DBUnitEx").createEntityManager();

@Before
    public void setUp() throws Exception{
    super.setUp();
    beforeData = new FlatXmlDataSetBuilder().build(Thread.currentThread().getContextClassLoader().getResourceAsStream("net/prosetyle/telephonnayakniga/controller/entity/telephonnaya_kniga-data.xml"));

    tester.setDataSet(beforeData);
    tester.onSetup();


}
public Telephonnaya_KnigaTest(String name){
    super(name);
}
@Test
    public void testGetAll() throws Exception{
    List<Telephonnaya_Kniga> knigaList = service.getAll();

    IDataSet expectedData = new FlatXmlDataSetBuilder().build(Thread.currentThread().getContextClassLoader().getResourceAsStream("net/prosetyle/telephonnayakniga/controller/entity/telephonnaya_kniga-data.xml"));
    IDataSet actualData = tester.getConnection().createDataSet();
    Assertion.assertEquals(expectedData,actualData);
    Assert.assertEquals(expectedData.getTable("telephonnaya_kniga").getRowCount(), knigaList.size());

}
@Test

public void testSave() throws Exception{
    Telephonnaya_Kniga telephonnaya_kniga = new Telephonnaya_Kniga();
    telephonnaya_kniga.setNamee("Oleksandr");
    telephonnaya_kniga.setSurname("Kukhar");

    service.save(telephonnaya_kniga);

    IDataSet expectedData = new FlatXmlDataSetBuilder().build(Thread.currentThread().getContextClassLoader().getResourceAsStream("net/prosetyle/telephonnayakniga/controller/entity/telephonnaya_kniga-data.xml"));
    DatabaseOperation.CLEAN_INSERT.execute(getConnection(),expectedData);

    String[] ignore = {"id"};
    Assertion.assertEqualsIgnoreCols(expectedData, actualData, "person", ignore);





}
@Test
public void testDelete() throws Exception{
    Telephonnaya_Kniga telephonnaya_kniga = new Telephonnaya_Kniga();
    telephonnaya_kniga.setNamee("Vera");
    telephonnaya_kniga.setNamee("Chakra");

    telephonnaya_kniga = em.merge(telephonnaya_kniga);

    Integer id = telephonnaya_kniga.getId();

    service.delete(telephonnaya_kniga);
    Telephonnaya_Kniga telephonnayaKnigaFromDb = em.find(Telephonnaya_Kniga.class, id);
    Assert.assertNull(telephonnayaKnigaFromDb);

    }

    @Test
    public void testUpdate() throws Exception{
    Telephonnaya_Kniga telephonnaya_kniga = em.find(Telephonnaya_Kniga.class, 1);
    telephonnaya_kniga.setNamee("Berdychev");
    service.update(telephonnaya_kniga);
    Telephonnaya_Kniga telephonnayaKnigaFromDb = em.find(Telephonnaya_Kniga.class, 1);

    Assert.assertEquals(telephonnaya_kniga.getNamee(), telephonnayaKnigaFromDb.getNamee());
    }
@Test
    public void testGetById() throws  Exception{
    Telephonnaya_Kniga telephonnaya_kniga = service.get(1);
    Telephonnaya_Kniga telephonnaya_kniga1 = em.find(Telephonnaya_Kniga.class, 1);

    Assert.assertEquals(telephonnaya_kniga.getId(), telephonnaya_kniga1.getId());
    Assert.assertEquals(telephonnaya_kniga.getNamee(), telephonnaya_kniga1.getNamee());
    Assert.assertEquals(telephonnaya_kniga.getSurname(), telephonnaya_kniga1.getSurname());


}
}
