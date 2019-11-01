/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import models.Note;

/**
 *
 * @author 794466
 */
public class NoteDB {

       /**
     * 
     * @param note
     * @return 0 if not successful, 1 if successful 
     */
    public int insert(Note note)
    {
        int r = 0;              
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try 
        {
            trans.begin();
            em.persist(note);
            trans.commit();
            
            r = 1;                   
            return r;
        } 
        catch (Exception e) 
        {
            trans.rollback();
            return r;
        } 
        finally 
        {
            em.close();
        }
    }
    
    public int update(Note note)
    {
        int r = 0;       
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try 
        {
            trans.begin();
            em.merge(note);
            trans.commit();
            
            r = 1;                   
            return r;
        } 
        catch (Exception e) 
        {
            trans.rollback();
            return r;
        } 
        finally 
        {
            em.close();
        }
    }
    
    public List<Note> getAll()
    {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try
        {
            List<Note> tempList = em.createNamedQuery("Note.findAll", Note.class).getResultList();
            return tempList;
        }
        finally
        {
            em.close();
        }
    }
    
    public Note get(int noteID)
    {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        try
        {
            Note n = em.find(Note.class, noteID);
            return n;
        }
        finally
        {
            em.close();
        }
    }
    
    public int delete(Note note)
    {
        int r = 0;              
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        
        try 
        {
            trans.begin();
            em.remove(em.merge(note));
            trans.commit();
            
            r = 1;        
            return r;
        } 
        catch (Exception e) 
        {
            trans.rollback();
            return r;
        } 
        finally 
        {
            em.close();
        }
    }
}
