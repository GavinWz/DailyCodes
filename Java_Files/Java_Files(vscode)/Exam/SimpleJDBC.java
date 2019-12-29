import java.sql.*;
public class SimpleJDBC{
    public static void main(String[] args)
        throws SQLException, ClassNotFoundException{
        Class.forName("oracle.jdbc.driver.OracleDriver");
        
        Connection connection = DriverManager.getConnection
            ("jdbc:oracle:thin:@localhost:8000:oracleDBSID","Gavin", "1234");
          //("jdbc:oracle:thin:@主机名:端口号:数据库名","用户名", "密码");
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery
            ("select firstNam, mi, lastName from Student where lastname = 'Smith'");
        while(result.next()){
            System.out.println(result.getString(1) + result.getString(2) + result.getString(3));
        }
        connection.close();
    }
}