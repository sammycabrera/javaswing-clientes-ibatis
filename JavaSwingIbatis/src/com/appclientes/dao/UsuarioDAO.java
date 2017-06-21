/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.appclientes.dao;


import com.appclientes.model.Usuario;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

/**
 * 
 * @author Sammy
 */
public class UsuarioDAO {

    private SqlSessionFactory sqlSessionFactory;

    public UsuarioDAO() {
        sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
    }

    /**
     * Returns the list of all Contact instances from the database.
     * @return the list of all Contact instances from the database.
     */
    @SuppressWarnings("unchecked")
    public List<Usuario> selectAll() {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            List<Usuario> list = session.selectList("TbUsuario.getAll");
            return list;
        } finally {
            session.close();
        }
    }

    /**
     * Returns a Contact instance from the database.
     * @param userId primary key value used for lookup.
     * @return A Contact instance with a primary key value equals to pk. null if there is no matching row.
     */
    public Usuario selectById(String userId) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            Usuario user = (Usuario) session.selectOne("TbUsuario.getById", userId);
            return user;
        } finally {
            session.close();
        }
    }

    /**
     * Updates an instance of Contact in the database.
     * @param user the instance to be updated.
     * @return 
     */
    public boolean update(Usuario user) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            session.update("TbUsuario.update", user);
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
     * @param user the instance to be persisted.
     * @return 
     */
    public boolean insert(Usuario user) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            session.insert("TbUsuario.insert", user);
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
     * @param userId primary key value of the instance to be deleted.
     * @return 
     */
    public boolean delete(String userId) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            session.delete("TbUsuario.deleteById", userId);
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
