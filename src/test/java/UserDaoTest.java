//
// import org.junit.After;
// import org.junit.Assert;
// import org.junit.Before;
// import org.junit.Test;
// import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
// import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
// import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
// import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
//
// import com.curveDental.dao.PersonDAO;
//
// public class CarTypeTest {
//
// private EmbeddedDatabase db;
//
// PersonDAO userDao;
//
// @Before
// public void setUp() {
// //db = new EmbeddedDatabaseBuilder().addDefaultScripts().build();
// db = new EmbeddedDatabaseBuilder()
// .setType(EmbeddedDatabaseType.H2)
// .addScript("sql/schema.sql").addScript("sql/data.sql")
// .build();
// }
//
// @Test
// public void testFindByname() {
// NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(db);
// PersonDAO userDao = new PersonDAO();
// userDao.setNamedParameterJdbcTemplate(template);
//
// PersonDAO user = userDao.findByName("mkyong");
//
// Assert.assertNotNull(user);
// Assert.assertEquals(1, user.getId().intValue());
// Assert.assertEquals("mkyong", user.getName());
// Assert.assertEquals("mkyong@gmail.com", user.getEmail());
//
// }
//
// @After
// public void tearDown() {
// db.shutdown();
// }
//
// }