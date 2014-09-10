package com.realdolmen.ticket;

import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.ext.mysql.MySqlDataTypeFactory;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;


public class DatasetPersistenceTest extends PersistenceTest {
    protected final Logger logger = LoggerFactory.getLogger(getClass());

    @Before
    public void setUp() throws Exception {
        logger.info("Loading dataset");
        Connection connection1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "admin");
        IDatabaseConnection connection = new DatabaseConnection(connection1);

        IDataSet dataset=new FlatXmlDataSetBuilder().build(getClass().getResource("/data.xml"));

        //set factorytype in dbconfig to remove warning
        DatabaseConfig dbConfig = connection.getConfig();
        dbConfig.setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new MySqlDataTypeFactory());

        DatabaseOperation.CLEAN_INSERT.execute(connection,dataset);

    }
}
