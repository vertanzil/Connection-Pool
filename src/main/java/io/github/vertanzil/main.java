package io.github.vertanzil;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class main {
    public static void main(String[] args) throws SQLException, IOException, PropertyVetoException {

        DataSource ds = new DataSource();
        Plugin plugin = null;
        Random rand = new Random();

        int n = rand.nextInt(200) + 1;


        //Connection connection = DataSource.getInstance().getConnection();


        final String query = ("");
        PreparedStatement statement = ds.getConnection().prepareStatement(query);
        final PreparedStatement Statement = statement;




        Runnable r = new Runnable() {
            public void run() {
                try {

                    for(int i=1; i<600; i++){
                        Statement.execute(query);
                    }

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        };

        new Thread(r).start();

    }
}
