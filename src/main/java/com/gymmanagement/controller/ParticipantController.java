package com.gymmanagement.controller;

import com.gymmanagement.dao.ParticipantDAO;
import com.gymmanagement.bean.Participant;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/participant")
public class ParticipantController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ParticipantDAO participantDAO;

    public void init() {
        participantDAO = new ParticipantDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        try {
            switch (action) {
                case "new":
                    showNewForm(request, response);
                    break;
                case "insert":
                    insertParticipant(request, response);
                    break;
                case "delete":
                    deleteParticipant(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "update":
                    updateParticipant(request, response);
                    break;
                case "list":
                    listParticipants(request, response);
                    break;
                default:
                    showHomePage(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void showHomePage(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }

    private void listParticipants(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Participant> listParticipants = participantDAO.selectAllParticipants();
        request.setAttribute("participants", listParticipants);
        RequestDispatcher dispatcher = request.getRequestDispatcher("participant-list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("add-participant.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Participant existingParticipant = participantDAO.selectParticipant(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("update-participant.jsp");
        request.setAttribute("participant", existingParticipant);
        dispatcher.forward(request, response);
    }

    private void insertParticipant(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String email = request.getParameter("email");
        int batchId = Integer.parseInt(request.getParameter("batchId"));
        Participant newParticipant = new Participant(name, age, email, batchId);
        participantDAO.insertParticipant(newParticipant);
        response.sendRedirect("participant?action=list");
    }

    private void updateParticipant(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String email = request.getParameter("email");
        int batchId = Integer.parseInt(request.getParameter("batchId"));

        Participant participant = new Participant(id, name, age, email, batchId);
        participantDAO.updateParticipant(participant);
        response.sendRedirect("participant?action=list");
    }

    private void deleteParticipant(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        participantDAO.deleteParticipant(id);
        response.sendRedirect("participant?action=list");
    }
}
