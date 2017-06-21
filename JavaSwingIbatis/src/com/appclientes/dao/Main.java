/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appclientes.dao;


import com.appclientes.model.Usuario;
import java.util.List;

/**
 * 
 * @author Sammy
 */
public class Main {

    
    public static void main(String[] args) {
        ProveedorDAO dao = new ProveedorDAO();
        //List<Asset> lstassets = dao.selectAll();
        //for (Asset asset : lstassets) {
        //    System.out.println(asset.getAssetid() + "\t" + asset.getAssetnum() + "\t" + asset.getDescription()+ "\t" + asset.getAssettype()+ "\t" + asset.getStatus());
        //}
        
        
        System.out.println(dao.selectAllSucursales());
        //dao.insert(nuevoVehiculo);

    }
}
