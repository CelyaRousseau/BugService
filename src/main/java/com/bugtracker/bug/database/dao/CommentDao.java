package com.bugtracker.bug.database.dao;

import com.bugtracker.bug.database.entity.Comment;
import com.bugtracker.bug.util.Template;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class CommentDao extends Template {

    public Comment getCommentById(int project_id) {

        Session session = getSessionFactory().openSession();
        session.beginTransaction();

        Criteria criteria = session.createCriteria(Comment.class)
                .add(Restrictions.eq("idProject", project_id));

        criteria.setMaxResults(1);

        Comment comment = (Comment)criteria.uniqueResult();

        session.close();

        return comment;
    }

    public List<Comment> getAll() {

        Session session = getSessionFactory().openSession();
        session.beginTransaction();

        Criteria criteria = session.createCriteria(Comment.class);

        List<Comment> comments = (List<Comment>)criteria.list();

        session.close();

        return comments;
    }
}
