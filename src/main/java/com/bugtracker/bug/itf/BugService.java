package com.bugtracker.bug.itf;

import com.bugtracker.bug.database.entity.Bug;
import com.bugtracker.bug.database.entity.Comment;
import com.bugtracker.bug.database.entity.Project;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.io.IOException;

@Path("/")
public interface BugService {

    @GET
    @Path("/projects")
    @Produces({"application/json", "application/xml"})
    Response getProjects() throws IOException;

    @GET
    @Path("/projects/{id}")
    @Produces({"application/json", "application/xml"})
    Project getProjectById(@PathParam ("id") int id) throws IOException;

    @GET
    @Path("/bugs")
    @Produces({"application/json", "application/xml"})
    Response getBugs() throws IOException;

    @GET
    @Path("/bugs/{id}")
    @Produces({"application/json", "application/xml"})
    Bug getBugsById(@PathParam ("id") int id) throws IOException;

    @GET
    @Path("/comments")
    @Produces({"application/json", "application/xml"})
    Response getComments() throws IOException;

    @GET
    @Path("/comments/{id}")
    @Produces({"application/json", "application/xml"})
    Comment getCommentsById(@PathParam ("id") int id) throws IOException;



}
