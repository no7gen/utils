import java.sql.SQLException;

public class main {
    public static void main(String[] args) {
        try {
            System.out.println(new dbRows().getRowsCount());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}