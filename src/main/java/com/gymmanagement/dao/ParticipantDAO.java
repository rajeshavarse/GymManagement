package com.gymmanagement.dao;

import com.gymmanagement.bean.Participant;
import com.gymmanagement.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ParticipantDAO {
    private static final String INSERT_PARTICIPANT_SQL = "INSERT INTO participants (name, age, email, batchId) VALUES (?, ?, ?, ?)";
    private static final String SELECT_PARTICIPANT_BY_ID = "SELECT id, name, age, email, batchId FROM participants WHERE id = ?";
    private static final String SELECT_ALL_PARTICIPANTS = "SELECT * FROM participants";
    private static final String DELETE_PARTICIPANT_SQL = "DELETE FROM participants WHERE id = ?";
    private static final String UPDATE_PARTICIPANT_SQL = "UPDATE participants SET name = ?, age = ?, email = ?, batchId = ? WHERE id = ?";

    public void insertParticipant(Participant participant) throws SQLException {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PARTICIPANT_SQL)) {
            preparedStatement.setString(1, participant.getName());
            preparedStatement.setInt(2, participant.getAge());
            preparedStatement.setString(3, participant.getEmail());
            preparedStatement.setInt(4, participant.getBatchId());
            preparedStatement.executeUpdate();
        }
    }

    public Participant selectParticipant(int id) {
        Participant participant = null;
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PARTICIPANT_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String email = rs.getString("email");
                int batchId = rs.getInt("batchId");
                participant = new Participant(id, name, age, email, batchId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return participant;
    }

    public List<Participant> selectAllParticipants() {
        List<Participant> participants = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PARTICIPANTS)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String email = rs.getString("email");
                int batchId = rs.getInt("batchId");
                participants.add(new Participant(id, name, age, email, batchId));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(participants);
        return participants;
    }

    public boolean deleteParticipant(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_PARTICIPANT_SQL)) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean updateParticipant(Participant participant) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_PARTICIPANT_SQL)) {
            statement.setString(1, participant.getName());
            statement.setInt(2, participant.getAge());
            statement.setString(3, participant.getEmail());
            statement.setInt(4, participant.getBatchId());
            statement.setInt(5, participant.getId());
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }
}
