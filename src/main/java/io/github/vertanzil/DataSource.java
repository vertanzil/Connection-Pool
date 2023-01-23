package io.github.vertanzil;


import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mysql.jdbc.Connection;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.SQLException;

public class DataSource {
    private DataSource datasource;
    private ComboPooledDataSource cpds;

    public DataSource() throws IOException, SQLException, PropertyVetoException {
        cpds = new ComboPooledDataSource();
        cpds.setDriverClass("com.mysql.jdbc.Driver"); //loads the jdbc driver
        cpds.setJdbcUrl("jdbc:mysql://localhost/blocklog");
        cpds.setUser("woot");
        cpds.setPassword("woot");


        cpds.setMaxPoolSize(1000);

        cpds.setMinPoolSize(2);
        cpds.setMaxIdleTime(300);
        cpds.setIdleConnectionTestPeriod(3000);
        cpds.setNumHelperThreads(2);

        cpds.setTestConnectionOnCheckin(true);
        cpds.setMaxStatements(20000);
        cpds.setMaxStatementsPerConnection(250);
        cpds.setDebugUnreturnedConnectionStackTraces(true);
    }

    public  DataSource getInstance() throws IOException, SQLException, PropertyVetoException {
        if (datasource == null) {
            datasource = new DataSource();
            return datasource;
        } else {
            return datasource;
        }
    }



    public java.sql.Connection getConnection() throws SQLException {
        return this.cpds.getConnection();
    }

}