/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import dataaccess.NoteDB;
import dataaccess.NotesDBException;
import java.util.Date;
import java.util.List;
import models.Note;

/**
 *
 * @author 794466
 */
public class NoteService {

 public Note get(int noteid)
    {
        NoteDB ndb = new NoteDB();
        Note n = ndb.get(noteid);
        return n;
    }
    
    public List<Note> getAll()
    {
        NoteDB ndb = new NoteDB();
        List<Note> noteList = ndb.getAll();
        return noteList;
    }
    
    public int update(int noteid, String title, String contents) throws Exception
    {
        NoteDB ndb = new NoteDB();
        Note temp = ndb.get(noteid);
        Date d = temp.getDatecreated();
        Note n = new Note(noteid, d, title, contents);
        int r = ndb.update(n);
        
        if(r == 0)
        {
            throw new NotesDBException("Error - Update operation unsuccessful.");
        }
        
        return r;
    }
    
    public int delete(int noteid) throws Exception
    {
        NoteDB ndb = new NoteDB();
        Note n = ndb.get(noteid);
        int r = ndb.delete(n);
        
        if(r == 0)
        {
            throw new NotesDBException("Error - Delete operation unsuccessful.");
        }
        
        return r;
    }
    
    public int insert(String title, String contents) throws Exception
    {
        NoteDB ndb = new NoteDB();
        Date d = new Date();
        Note n = new Note(0, d, title, contents);
        int r = ndb.insert(n);
        
        if(r == 0)
        {
            throw new NotesDBException("Error - Insert operation unsuccessful.");
        }
        
        return r;
    }
}
