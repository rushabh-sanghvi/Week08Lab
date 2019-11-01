/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Note;
import Services.NoteService;

/**
 *
 * @author 794466
 */
public class NotesServlet extends HttpServlet {

      @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        NoteService ns = new NoteService();
        List<Note> noteList = ns.getAll();
        
        request.setAttribute("displayNotes", noteList);
        
        String edit = request.getParameter("edit");
        
        if(edit != null)
        {
            Note n = ns.get(Integer.valueOf(edit));
            request.setAttribute("note", n);
            
            request.setAttribute("control", "Edit");
            
            request.setAttribute("test", edit);
        }
        else
        {
            request.setAttribute("control", "Add");
        }

        getServletContext().getRequestDispatcher("/WEB-INF/notes.jsp")
            .forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        NoteService ns = new NoteService();
        
        String action = request.getParameter("option");

        String title = request.getParameter("titleBox");
        String contents = request.getParameter("contentBox");
        
        try
        {
            if(action.equals("Save"))
            {
                String edit = request.getParameter("edit");
                ns.update(Integer.valueOf(edit), title, contents);
            }
            else if(action.equals("Add"))
            {
                ns.insert(title, contents);
            }
            else if(action.equals("Delete"))
            {
                String edit = request.getParameter("edit");
                ns.delete(Integer.valueOf(edit));
            }
        }
        catch(Exception e)
        {
            
        }

        response.sendRedirect("notes");
    }


    @Override
    public String getServletInfo() 
    {
        return "Short description";
    }
}
