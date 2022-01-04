package helpers;

import java.sql.Connection;
import java.sql.DriverManager;


public class DatabaseConnection {
    public Connection databaseLink;

    public Connection getConnection(){
        String databaseName = "loanapp";
        String databaseUser = "root";
        String databasePassword = "Pauloo@1155";
        String timeZone = "useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String url = "jdbc:mysql://localhost:3306/" + databaseName + "?" + timeZone;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);

        }catch (Exception ex){
            ex.printStackTrace();
            ex.getCause();
        }
        return databaseLink;
    }
}
