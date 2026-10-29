package luchaLibre.dataBase;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseConnection {

    public static Connection getConnetionDb(){
        String url = "jdbc:mysql://localhost:3306/lucha_libre";
        String password = "DB_PASSWORD";
        String user = "DB_USER";

      try{
          Connection connectionDb = DriverManager.getConnection(url,user, password);
          System.out.println("Conexión exitosa");
          return connectionDb;
      }catch (Exception e){
          System.out.println("Error de conexión..." + e);
          return null;
      }

    }

}
