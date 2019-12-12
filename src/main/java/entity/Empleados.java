/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author allex
 */
public class Empleados {
    private int id;
    private String name;

    public Empleados(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Empleados() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if(id>0){
        this.id = id;
        }else{
            this.id=1;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    
}
