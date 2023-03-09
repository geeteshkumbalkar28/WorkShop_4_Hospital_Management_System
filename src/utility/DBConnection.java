package utility;

import java.sql.*;

public class DBConnection {
    public static final DBConnection dbconnection = new DBConnection();
    private static final String user = "root";
    private static final String password = "Geetesh@2000";
    private static final String dbName = "Hospital_Manegement_System";
    private static final String hostName = "localhost";

    private DBConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loaded .....");

        } catch (ClassNotFoundException e) {
            System.err.println("Driver is missing");
            e.printStackTrace();
        }
    }
    public  static DBConnection getDbConnection()
    {
        return dbconnection;
    }


    public Connection getConnection() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("jdbc:mysql://");
        stringBuilder.append(hostName).append("/").append(dbName);
        String url = stringBuilder.toString();
        System.out.println(url);
        Connection connection = null;
        try {

            connection = DriverManager.getConnection(url, user, password);
            System.out.println(connection);
            System.out.println("connection is successfull..");

        } catch (SQLException e) {
            System.err.println(e.getLocalizedMessage());

        }
        return connection;

    }

    public static void main(String[] args) throws SQLException {
        Connection connection = DBConnection.dbconnection.getConnection();


//    dbconnection.deposite(11111,2000,1);
//        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++");
//        dbconnection.withdraw(11111,20000,1);
//            Statement statement = connection.createStatement();
//           ResultSet rs = statement.executeQuery("select * from customerDetails");
//        while (rs.next())
//        {
//            System.out.println("address id "+rs.getString("firstname"));
//        }



    }

}
