import java.sql.*;

public class SimpleJDBC{
    public static void main(String[] args) throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Driver loaded");
        Connection connection = DriverManager.getConnection
        ("jdbc:mysql://localhost/javabook", "scott", "tiger");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery
        ("sellect first name, mi, lastName from Student where last Name" + "= 'Smith'");
        while(resultSet.next())
            System.out.println(resultSet.getString(1) + "\t" + resultSet.getString(2) + "\t" + resultSet.getString(3));
        connection.close();
    }
}