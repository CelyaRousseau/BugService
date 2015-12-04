package com.bugtracker.bug.impl;

import com.bugtracker.bug.database.dao.BugDao;
import com.bugtracker.bug.database.dao.CommentDao;
import com.bugtracker.bug.database.dao.ProjectDao;
import com.bugtracker.bug.database.entity.Bug;
import com.bugtracker.bug.database.entity.Comment;
import com.bugtracker.bug.database.entity.Project;
import com.bugtracker.bug.itf.BugService;
import org.codehaus.jackson.map.ObjectMapper;
import org.jboss.resteasy.logging.Logger;

import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.List;

public class BugServiceImpl implements BugService {

    private Logger logger = Logger.getLogger(BugServiceImpl.class);

    @Override
    public Response getProjects() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ProjectDao projectDao = new ProjectDao();
        List<Project> projects = projectDao.getAll();
        return Response.status(200).entity(mapper.writeValueAsString(projects)).build();
    }

    @Override
    public Project getProjectById(@PathParam ("id") int id) throws IOException {
        ProjectDao projectDao = new ProjectDao();
        return projectDao.getProjectById(id);
    }

    @Override
    public Response getBugs() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        BugDao bugDao = new BugDao();
        List<Bug> bugs = bugDao.getAll();
        return Response.status(200).entity(mapper.writeValueAsString(bugs)).build();
    }

    @Override
    public Bug getBugsById(@PathParam ("id") int id) throws IOException {
        BugDao bugDao = new BugDao();
        return bugDao.getBugById(id);
    }

    @Override
    public Response getComments() throws IOException {
        CommentDao commentDao = new CommentDao();
        ObjectMapper mapper = new ObjectMapper();
        List<Comment> comments = commentDao.getAll();
        return Response.status(200).entity(mapper.writeValueAsString(comments)).build();
    }

    @Override
    public Comment getCommentsById(@PathParam ("id") int id) throws IOException {
        CommentDao commentDao = new CommentDao();
        return commentDao.getCommentById(id);
    }

}
