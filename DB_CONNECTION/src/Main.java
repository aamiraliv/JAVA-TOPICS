import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String url = "jdbc:mysql://127.0.0.1:3306/login_schema";
        String username = "root";
        String password = "*********";

        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("connected to the db successfully!!");

            String sql = "INSERT INTO users (USERNAME,PASSWORD) VALUES (?,?)";
            PreparedStatement prep = conn.prepareStatement(sql);

            System.out.println("enter the user name: ");
            String name = s.nextLine();
            System.out.println("enter the password : ");
            String pass = s.nextLine();

            prep.setString(1, name);
            prep.setString(2, pass);


            int rowwxecute = prep.executeUpdate();
            if (rowwxecute > 0) {
                System.out.println("user added successfully");
            }

            String upadate = "UPDATE users SET USERNAME = ? WHERE idUSERS = ?";
            PreparedStatement updateStm = conn.prepareStatement(upadate);
            System.out.println("enter the id of the user to update :");
            int uid = s.nextInt();
            s.nextLine();
            System.out.println("enter the new user name : ");
            String uuser = s.nextLine();

            updateStm.setString(1, uuser);
            updateStm.setInt(2, uid);

            int updaterow = updateStm.executeUpdate();
            if (updaterow > 0) {
                System.out.println("user name is updated!!");
            }

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM users");
            while (rs.next()) {
                System.out.println(rs.getString("USERNAME"));
            }



            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
