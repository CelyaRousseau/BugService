package com.bugtracker.bug.database.dao;

import com.bugtracker.bug.database.entity.Bug;
import com.bugtracker.bug.util.Template;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class BugDao extends Template {

    public Bug getBugById(int project_id) {

        Session session = getSessionFactory().openSession();
        session.beginTransaction();

        Criteria criteria = session.createCriteria(Bug.class)
                .add(Restrictions.eq("idBug", project_id));

        criteria.setMaxResults(1);

        Bug bug = (Bug)criteria.uniqueResult();

        session.close();

        return bug;
    }

    public List<Bug> getAll() {

        Session session = getSessionFactory().openSession();
        session.beginTransaction();

        Criteria criteria = session.createCriteria(Bug.class);

        List<Bug> bugs = (List<Bug>)criteria.list();

        session.close();

        return bugs;
    }
}
