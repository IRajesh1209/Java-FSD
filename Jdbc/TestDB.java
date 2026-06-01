import java.sql.*;
import java.util.Scanner;

public class TestDB {

    static final String url = "jdbc:mysql://localhost:3306/testdb";
    static final String user = "root";
    static final String password = "";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);

            System.out.println("Connected to MySQL!");

            while (true) {
                System.out.println("\n===== MENU =====");
                System.out.println("1. Insert");
                System.out.println("2. View");
                System.out.println("3. Update");
                System.out.println("4. Delete");
                System.out.println("5. Exit");
                System.out.print("Enter choice: ");

                int choice = sc.nextInt();

                switch (choice) {

                    case 1:
                        // INSERT
                        System.out.print("Enter ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();

                        String insertSQL = "INSERT INTO student VALUES (?, ?)";
                        PreparedStatement ps1 = con.prepareStatement(insertSQL);
                        ps1.setInt(1, id);
                        ps1.setString(2, name);

                        ps1.executeUpdate();
                        System.out.println("Data Inserted!");
                        break;

                    case 2:
                        // VIEW
                        String selectSQL = "SELECT * FROM student";
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery(selectSQL);

                        System.out.println("\nID\tName");
                        while (rs.next()) {
                            System.out.println(rs.getInt("id") + "\t" + rs.getString("name"));
                        }
                        break;

                    case 3:
                        // UPDATE
                        System.out.print("Enter ID to update: ");
                        int uid = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter new Name: ");
                        String newName = sc.nextLine();

                        String updateSQL = "UPDATE student SET name=? WHERE id=?";
                        PreparedStatement ps2 = con.prepareStatement(updateSQL);
                        ps2.setString(1, newName);
                        ps2.setInt(2, uid);

                        int rows = ps2.executeUpdate();
                        if (rows > 0)
                            System.out.println("Updated successfully!");
                        else
                            System.out.println("ID not found!");
                        break;

                    case 4:
                        // DELETE
                        System.out.print("Enter ID to delete: ");
                        int did = sc.nextInt();

                        String deleteSQL = "DELETE FROM student WHERE id=?";
                        PreparedStatement ps3 = con.prepareStatement(deleteSQL);
                        ps3.setInt(1, did);

                        int delRows = ps3.executeUpdate();
                        if (delRows > 0)
                            System.out.println("Deleted successfully!");
                        else
                            System.out.println("ID not found!");
                        break;

                    case 5:
                        // EXIT
                        System.out.println("Exiting...");
                        con.close();
                        System.exit(0);

                    default:
                        System.out.println("Invalid choice!");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}