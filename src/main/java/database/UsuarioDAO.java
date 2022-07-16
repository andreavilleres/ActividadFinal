/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Usuario;


public class UsuarioDAO {
    
    private Connection connection;
    
    public UsuarioDAO(){
        DBConn conn = new DBConn();
        connection = conn.getConnection("homebanking", "root", "");
    }
    
    public Usuario buscar(String userName, String password) throws SQLException {
        PreparedStatement ps;
        ResultSet rs;
        ps = connection.prepareStatement("SELECT * FROM users WHERE username = ? AND password = ?");
        
        ps.setString(1, userName);
        ps.setString(2, password);
        
        rs = ps.executeQuery();
        
        Usuario usuarioRetorno = null;
        if(rs.next()){  
             usuarioRetorno = new Usuario();
             usuarioRetorno.setId(rs.getString("id"));
            usuarioRetorno.setUsername(rs.getString("username"));
             usuarioRetorno.setPassword(rs.getString("password"));
              usuarioRetorno.setNombre(rs.getString("nombre"));
            usuarioRetorno.setApellido(rs.getString("apellido"));
            usuarioRetorno.setMail(rs.getString("mail"));
            
        }

        
        return usuarioRetorno;
    }
    public boolean actualizar(Integer id, String userName, String password, String nombre, String apellido, String mail) throws SQLException {
        PreparedStatement ps;
 
        ps = connection.prepareStatement(" UPDATE users SET  username = ?, password = ?, nombre = ?, apellido = ?, mail = ? WHERE id = ?;");
        
      
        ps.setString(1, userName);
        ps.setString(2, password);
        ps.setString(3, nombre);
        ps.setString(4, apellido);
        ps.setString(5, mail);
        ps.setInt(6, id.intValue());
        
        ps.executeUpdate();
       
        
        return true;
    }
}
 
