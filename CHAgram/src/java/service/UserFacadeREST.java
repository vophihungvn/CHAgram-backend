/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import models.User;

/**
 *
 * @author Hung-PC
 */

public class UserFacadeREST extends AbstractFacade<User> {

    private EntityManager em;

    public UserFacadeREST() {
        super(User.class);
        em = Persistence.createEntityManagerFactory("CHAgramPU").createEntityManager();
    }

    public void create(User entity) {
        super.create(entity);
    }

    public void edit(Integer id, User entity) {
        super.edit(entity);
    }

    public void remove(Integer id) {
        super.remove(super.find(id));
    }

    public User find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @Override
    public List<User> findAll() {
        return super.findAll();
    }

    public List<User> findRange(Integer from, Integer to) {
        return super.findRange(new int[]{from, to});
    }

    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }    
}
