package com.bugtracker.bug.database.dao;

import com.bugtracker.bug.database.entity.Project;
import com.bugtracker.bug.util.Template;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class ProjectDao extends Template {

    public Project getProjectById(int project_id) {

        Session session = getSessionFactory().openSession();
        session.beginTransaction();

        Criteria criteria = session.createCriteria(Project.class)
                .add(Restrictions.eq("idProject", project_id));

        criteria.setMaxResults(1);

        Project project = (Project)criteria.uniqueResult();

        session.close();

        return project;
    }

    public List<Project> getAll() {

        Session session = getSessionFactory().openSession();
        session.beginTransaction();

        Criteria criteria = session.createCriteria(Project.class);

        List<Project> projects = (List<Project>)criteria.list();

        session.close();

        return projects;
    }
}
