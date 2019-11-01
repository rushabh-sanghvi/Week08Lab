/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

/**
 *
 * @author 794466
 */
public class NotesDBException extends Exception{
    
     /**
     * Creates a new instance of <code>NotesBDException</code> without detail
     * message.
     */
    public NotesDBException() 
    {
        
    }

    /**
     * Constructs an instance of <code>NotesBDException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public NotesDBException(String msg) 
    {
        super(msg);
    }
}
