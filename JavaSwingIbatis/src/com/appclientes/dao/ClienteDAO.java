/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appclientes.dao;


import com.appclientes.model.Cliente;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * 
 * @author Sammy
 */
public class ClienteDAO {

    private SqlSessionFactory sqlSessionFactory;

    public ClienteDAO() {
        sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
    }

    /**
     * Returns the list of all Contact instances from the database.
     * @return the list of all Contact instances from the database.
     */
    @SuppressWarnings("unchecked")
    public List<Cliente> selectAll() {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            List<Cliente> list = session.selectList("TbCliente.getAll");
            return list;
        } finally {
            session.close();
        }
    }

    /**
     * Returns a Contact instance from the database.
     * @param codigo primary key value used for lookup.
     * @return A Contact instance with a primary key value equals to pk. null if there is no matching row.
     */
    public Cliente selectById(int codigo) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            Cliente user = (Cliente) session.selectOne("TbCliente.getById", codigo);
            return user;
        } finally {
            session.close();
        }
    }

    /**
     * Updates an instance of Contact in the database.
     * @param cliente the instance to be updated.
     * @return 
     */
    public boolean update(Cliente cliente) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            session.update("TbCliente.update", cliente);
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
     * @param cliente the instance to be persisted.
     * @return 
     */
    public boolean insert(Cliente cliente) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            session.insert("TbCliente.insert", cliente);
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
     * @param codigo primary key value of the instance to be deleted.
     * @return 
     */
    public boolean delete(int codigo) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            session.delete("TbCliente.deleteById", codigo);
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
