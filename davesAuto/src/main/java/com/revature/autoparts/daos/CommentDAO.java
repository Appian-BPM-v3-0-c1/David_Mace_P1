package com.revature.autoparts.daos;

import com.revature.autoparts.connection.DatabaseConnection;
import com.revature.autoparts.models.Comment;
import com.revature.autoparts.models.Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommentDAO implements CrudDAO<Comment> {
    @Override
    public int save(Comment obj) {
        return 0;
    }

    @Override
    public List<Comment> findAll() {
        return null;
    }

    @Override
    public Comment findById(int id) {
        return null;
    }

    @Override
    public List<Comment> findAllById() {
        return null;
    }

    @Override
    public boolean update(Comment updatedObj) {
        return false;
    }

    @Override
    public boolean removeById(int id) {
        return false;
    }
}

