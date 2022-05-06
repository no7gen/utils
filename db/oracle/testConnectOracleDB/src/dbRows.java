import java.sql.*;

public class dbRows{

    String url = "jdbc:oracle:thin:@localhost:1521/XE";
    String user = "test";
    String pass = "test";
    Connection connection = null;
    Statement statement = null;
    ResultSet resultSet = null;
    int result=0;

    public int getRowsCount() throws SQLException {
        try {
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        } catch (SQLException e) {
            System.out.println("-- Не получилось зарегистрировать драйвер");
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(url,user,pass);
            statement = connection.createStatement();
            resultSet = statement.executeQuery ("SELECT * FROM testtable");

            while (resultSet.next()) {
                result = resultSet.getInt(1);
            }
        } catch (Exception e) {
            System.out.println("Блок catch");
            e.printStackTrace();
        }
        finally {
            System.out.println("Блок finally");
            try {
                resultSet.close();
                System.out.println("Resultset closed");
            } catch (Exception e) {
                System.out.println("-- Не получилось закрыть resultSet");
                e.printStackTrace();
            }

            try {
                statement.close();
                System.out.println("statement closed");
            } catch (Exception e) {
                System.out.println("-- Не получилось закрыть statement");
                e.printStackTrace();
            }

            try {
                connection.close();
                System.out.println("connection closed");
            } catch (Exception e) {
                System.out.println("-- Не получилось закрыть connection");
                e.printStackTrace();
            }

        }

        return result;
    }
}
