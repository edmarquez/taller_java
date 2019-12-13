/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import entity.Empleados;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author allex
 */
public class EmpleadosModel {
    private Connection con;
    
    public EmpleadosModel(Connection _con){
        this.con=_con;
    }
    
    public boolean agregar(Empleados e){
        PreparedStatement ps;
        try{
            ps = this.con.prepareStatement("INSERT INTO Empleados(id,name) VALUES(?,?)");
            ps.setInt(1, e.getId());
            ps.setString(2, e.getName());
            int res = ps.executeUpdate();
            if(res==0){
                return false;
            }else{
                return true;
            }
        }catch(SQLException ex){
            //test
        }
        return false;
    }
    
    public ArrayList<Empleados> obtenerTodos(){
        ArrayList registros = new ArrayList<>();
        PreparedStatement ps;
        try{
            ps=this.con.prepareStatement("SELECT * FROM Empleados");
            ResultSet filas = ps.executeQuery();
            if(filas!=null){
                try{
                    while(filas.next()){
                        Empleados em = 
                            new Empleados(filas.getInt("id"), filas.getString("name"));
                        registros.add(em);
                    }
                }catch(SQLException ex){
                    //test error
                }
            }
        }catch(SQLException ex){
            //exception
        }
        return registros;
    }
}
