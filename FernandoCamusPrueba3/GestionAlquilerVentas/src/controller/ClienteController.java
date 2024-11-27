/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Bd.Conexion;
import Controller.HelperController;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.Cliente;
import java.sql.PreparedStatement;
import java.util.HashSet;


/**
 *
 * @author Cetecom
 */
public class ClienteController {
    HelperController helper = new HelperController();
    Conexion cx;

    public ClienteController() {
    cx = new Conexion();
    cx.conectar();
    }
    
    
    public List<Cliente> obtenerClientes (String filtro) {
        List<Cliente> clientes = new ArrayList<>();
        String query;
        if(filtro == null || filtro.isEmpty()){
            query = "SELECT * FROM CLIENTE";
        } else {
            query = "SELECT * FROM CLIENTE WHERE nombre = '" + filtro + "';";
        }
        try {
            ResultSet rs = cx.EjecutarQuery(query);
            while(rs.next()){
                clientes.add(new Cliente(
                        rs.getInt("rut"),
                        rs.getString("nombre"),
                        rs.getString("numero_de_contacto"),
                        rs.getString("direccion"),
                        rs.getString("tipo_de_cliente")
                ));
            }
            
        } catch (Exception e) {
            helper.showError("No se encuentran clientes");
        }
        return  clientes;
    }
    
    public void agregarCliente(String nombre, String numero_de_contacto, String direccion, String tipo_de_cliente){
        String query = "INSERT INTO `cliente` (nombre,numero_de_contacto,direccion,tipo_de_cliente) VALUES (?,?,?,?)";
        try {
            PreparedStatement st = cx.getConnection().prepareStatement(query);
            st.setString(1,nombre);
            st.setString(2,numero_de_contacto);
            st.setString(3,direccion);
            st.setString(4,tipo_de_cliente);
            st.executeUpdate();
            helper.showInformation("CLIENTE AGREGADO");
        } catch (Exception e) {
            helper.showError(e.getMessage());

        }
    }
    
   
    public Cliente buscarClientePorRut(int rut){
        Cliente clienteEncontrado = null;
        String query = "SELECT * FROM CLIENTE WHERE RUT = " + rut + ";";
        
        try {
            ResultSet rs = cx.EjecutarQuery(query);
            if(rs.next()){
                clienteEncontrado = new Cliente();
                clienteEncontrado.setRut(rs.getInt("rut"));
                clienteEncontrado.setNombre(rs.getString("nombre"));
                clienteEncontrado.setNumero_de_contacto(rs.getString("numero_de_contacto"));
                clienteEncontrado.setDireccion(rs.getString("direccion"));
                clienteEncontrado.setTipo_de_cliente(rs.getString("tipo_de_cliente"));
            }
        } catch (Exception e) {
            helper.showError(e.getMessage());
        }
        return clienteEncontrado;
    }
    
    /**
    public void editarCliente(int Rut,String Nombre, String Numero_de_contacto, String Direccion, String Tipo_de_cliente){
            String query = "UPDATE Cliente SET nombre = '" + Nombre + "' , numero_de_contacto = '" + Numero_de_contacto + "' , direccion = '" + Direccion + "' , Tipo_de_cliente = '" + Tipo_de_cliente + "' WHERE rut = " + Rut + ";";
            System.out.println(query);

            try {
                Cliente clienteEncontrado = buscarClientePorRut(Rut);
                if(clienteEncontrado != null){
                    Statement st = cx.getConnection().createStatement();
                    st.executeUpdate(query);
                    System.out.println("HELPER");

                } else {
                    System.out.println("Error");
                }
            } catch (Exception e) {
                helper.showError(e.getMessage());
            }
    }
    **/
    /**
    public void eliminarCliente(int rut){
        String query = "DELETE FROM CLASS WHERE rut = " + rut + ";";
        
        try {
            Cliente clienteEncontrado = buscarClientePorRut(rut);
            if(clienteEncontrado != null){
                Statement st = cx.getConnection().createStatement();
                st.executeUpdate(query);
                helper.showInformation("CLIENTE ELIMINADO");
            } else {
                helper.showInformation("CLIENTE NO ENCONTRADO");
            }
        } catch (Exception e) {
            helper.showError("ERROR AL ELIMINAR" + e.getMessage());
        }
    }
    **/
}
