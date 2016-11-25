package data;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Thomas Hartmann - tha@cphbusiness.dk created on Nov 10, 2016 
 */
public class UserMapper {
//    public User getUser(int id){
//        User user = null;
//        try {
//            String sql = "SELECT id, name, password FROM user WHERE id = ?";
//            PreparedStatement pstmt = DB.getConnection().prepareStatement(sql);
//            pstmt.setInt(1, id);
//            ResultSet rs = pstmt.executeQuery();
//            if(rs.next()){
//                String username = rs.getString("name");
//                String password = rs.getString("password");
//                user = new User(id, username, password);
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        return user;
//    }
//    public List<User> getAllUsers(){
//        List<User> users = new ArrayList();
//        try {
//            String sql = "SELECT id, name, password FROM user";
//            PreparedStatement pstmt = DB.getConnection().prepareStatement(sql);
//            ResultSet rs = pstmt.executeQuery();
//            while(rs.next()){
//                String username = rs.getString("name");
//                String password = rs.getString("password");
//                User user = new User(username, password);
//                users.add(user);
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        return users;
//    }
//    public User getUserByName(String name){}
    public void registerUser(String username, String password, String email) throws PasswordStorage.CannotPerformOperationException{
        try {
            String hashed = PasswordStorage.createHash(password);
            String sql = "INSERT INTO logintable (username, password, email) VALUES (?,?,?)";
            PreparedStatement pstmt = DB.getConnection().prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, hashed);
            pstmt.setString(3, email);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
    }
    
    public boolean authenticate(String username, String password) throws PasswordStorage.CannotPerformOperationException, PasswordStorage.InvalidHashException{
        try {
            String sql = "SELECT username, password FROM logintable WHERE username = ?";
            PreparedStatement pstmt = DB.getConnection().prepareStatement(sql);
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                String hash = rs.getString("password");
                if(PasswordStorage.verifyPassword(password, hash)){
                    return true;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return false;
    }
//    public User getUserByName(String username){
//        User user = null;
//        try {
//            String sql = "SELECT id, name FROM user WHERE name = ?";
//            PreparedStatement pstmt = DB.getConnection().prepareStatement(sql);
//            pstmt.setString(1, username);
//            ResultSet rs = pstmt.executeQuery();
//            if(rs.next()){
//                int id = rs.getInt("id");
//                user = new User(id, username);
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        return user;
//    }
    public static void main(String[] args) throws PasswordStorage.CannotPerformOperationException, PasswordStorage.InvalidHashException {
        new UserMapper().registerUser("thomas", "Thomas1234", "tha@cphbusiness.dk");
        boolean auth = new UserMapper().authenticate("thomas", "Thomas1234");
        System.out.println("AUTH: "+auth);
    }
}
