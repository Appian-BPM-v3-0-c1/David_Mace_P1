package daos;

import models.Comment;

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
    public boolean removeById(String id) {
        return false;
    }
}

