/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appclientes.dao;


import com.appclientes.model.Proveedor;
import com.appclientes.model.Sucursal;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * 
 * @author Sammy
 */
public class ProveedorDAO {

    private SqlSessionFactory sqlSessionFactory;

    public ProveedorDAO() {
        sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
    }

    /**
     * Returns the list of all Contact instances from the database.
     * @return the list of all Contact instances from the database.
     */
    @SuppressWarnings("unchecked")
    public List<Proveedor> selectAll() {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            List<Proveedor> list = session.selectList("TbProveedor.getAll");
            return list;
        } finally {
            session.close();
        }
    }

    /**
     * Returns a Contact instance from the database.
     * @param nit primary key value used for lookup.
     * @return A Contact instance with a primary key value equals to pk. null if there is no matching row.
     */
    public Proveedor selectById(String nit) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            Proveedor proveedor = (Proveedor) session.selectOne("TbProveedor.getById", nit);
            return proveedor;
        } finally {
            session.close();
        }
    }

    /**
     * Updates an instance of Contact in the database.
     * @param proveedor the instance to be updated.
     * @return 
     */
    public boolean update(Proveedor proveedor) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            session.update("TbProveedor.update", proveedor);
            session.commit();
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
	} finally {
            session.close();
        }
    }

    /**
     * Insert an instance of Contact into the database.
     * @param proveedor the instance to be persisted.
     * @return 
     */
    public boolean insert(Proveedor proveedor) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            session.insert("TbProveedor.insert", proveedor);
            session.commit();
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
	} finally {
            session.close();
        }
    }

    /**
     * Delete an instance of Contact from the database.
     * @param nit primary key value of the instance to be deleted.
     * @return 
     */
    public boolean delete(String nit) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            session.delete("TbProveedor.deleteById", nit);
            session.commit();
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
	} finally {
            session.close();
        }
    }
    
    /**
     * Returns the list of all Contact instances from the database.
     * @return the list of all Contact instances from the database.
     */
    @SuppressWarnings("unchecked")
    public List<Sucursal> selectAllSucursales() {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            List<Sucursal> list = session.selectList("TbSucursal.getAll");
            return list;
        } finally {
            session.close();
        }
    }

    


    /**
     * Insert an instance of Contact into the database.
     * @param sucursal the instance to be persisted.
     * @return 
     */
    public boolean insertSucursal(Sucursal sucursal) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            session.insert("TbSucursal.insert", sucursal);
            session.commit();
            return true;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
	} finally {
            session.close();
        }
    }    
    
}
