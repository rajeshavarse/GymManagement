package com.gymmanagement.dao;

import com.gymmanagement.bean.Batch;
import com.gymmanagement.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BatchDAO {
    private static final String INSERT_BATCH_SQL = "INSERT INTO batches (batchName, batchTime, maxParticipants) VALUES (?, ?, ?)";
    private static final String SELECT_BATCH_BY_ID = "SELECT id, batchName, batchTime, maxParticipants FROM batches WHERE id = ?";
    private static final String SELECT_ALL_BATCHES = "SELECT * FROM batches";
    private static final String DELETE_BATCH_SQL = "DELETE FROM batches WHERE id = ?";
    private static final String UPDATE_BATCH_SQL = "UPDATE batches SET batchName = ?, batchTime = ?, maxParticipants = ? WHERE id = ?";

    public void insertBatch(Batch batch) throws SQLException {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BATCH_SQL)) {
            preparedStatement.setString(1, batch.getBatchName());
            preparedStatement.setString(2, batch.getBatchTime());
            preparedStatement.setInt(3, batch.getMaxParticipants());
            preparedStatement.executeUpdate();
        }
    }

    public Batch selectBatch(int id) {
        Batch batch = null;
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BATCH_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                String batchName = rs.getString("batchName");
                String batchTime = rs.getString("batchTime");
                int maxParticipants = rs.getInt("maxParticipants");
                batch = new Batch(id, batchName, batchTime, maxParticipants);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return batch;
    }

    public List<Batch> selectAllBatches() {
        List<Batch> batches = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BATCHES)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String batchName = rs.getString("batchName");
                String batchTime = rs.getString("batchTime");
                int maxParticipants = rs.getInt("maxParticipants");
                batches.add(new Batch(id, batchName, batchTime, maxParticipants));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return batches;
    }

    public boolean deleteBatch(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_BATCH_SQL)) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean updateBatch(Batch batch) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_BATCH_SQL)) {
            statement.setString(1, batch.getBatchName());
            statement.setString(2, batch.getBatchTime());
            statement.setInt(3, batch.getMaxParticipants());
            statement.setInt(4, batch.getId());
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }
}
