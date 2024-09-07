package com.gymmanagement.controller;

import com.gymmanagement.dao.BatchDAO;
import com.gymmanagement.bean.Batch;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/batch")
public class BatchController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private BatchDAO batchDAO;

    public void init() {
        batchDAO = new BatchDAO();
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
                    insertBatch(request, response);
                    break;
                case "delete":
                    deleteBatch(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "update":
                    updateBatch(request, response);
                    break;
                case "list":
                    listBatches(request, response);
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

    private void listBatches(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Batch> listBatches = batchDAO.selectAllBatches();
        request.setAttribute("batches", listBatches);
        RequestDispatcher dispatcher = request.getRequestDispatcher("batch-list.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("add-batch.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Batch existingBatch = batchDAO.selectBatch(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("update-batch.jsp");
        request.setAttribute("batch", existingBatch);
        dispatcher.forward(request, response);
    }

    private void insertBatch(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String batchName = request.getParameter("batchName");
        String batchTime = request.getParameter("batchTime");
        int maxParticipants = Integer.parseInt(request.getParameter("maxParticipants"));
        Batch newBatch = new Batch(batchName, batchTime, maxParticipants);
        batchDAO.insertBatch(newBatch);
        response.sendRedirect("batch?action=list");
    }

    private void updateBatch(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String batchName = request.getParameter("batchName");
        String batchTime = request.getParameter("batchTime");
        int maxParticipants = Integer.parseInt(request.getParameter("maxParticipants"));

        Batch batch = new Batch(id, batchName, batchTime, maxParticipants);
        batchDAO.updateBatch(batch);
        response.sendRedirect("batch?action=list");
    }

    private void deleteBatch(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        batchDAO.deleteBatch(id);
        response.sendRedirect("batch?action=list");
    }
}
