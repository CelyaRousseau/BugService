package com.bugtracker.bug.security;

import org.jboss.resteasy.core.Headers;
import org.jboss.resteasy.core.ServerResponse;
import sun.misc.BASE64Decoder;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;


@PermitAdmin
@Provider
public class WineInterceptor implements ContainerRequestFilter {

    private static final ServerResponse ACCESS_DENIED = new ServerResponse("Access denied for this resource", 401,
            new Headers<Object>());

    @Override
    public void filter(ContainerRequestContext containerRequestContext) throws IOException {
        String authorization = containerRequestContext.getHeaderString("Authorization");

        if (authorization != null && new String(new BASE64Decoder().decodeBuffer(authorization.split(" ")[1]))
                .split(":")[0].equals("admin")) {
            return;
        }
        containerRequestContext.abortWith(ACCESS_DENIED);
    }
}
