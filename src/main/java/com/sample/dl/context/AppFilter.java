package com.sample.dl.context;


import org.springframework.stereotype.Service;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.ext.Provider;
import java.io.IOException;


//@Provider
//@Service
@PreMatching
public class AppFilter implements ContainerRequestFilter  {

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        System.out.println("PreMatching filtering ... ");
        String tc = requestContext.getHeaderString("testcase");
        System.out.println(tc);
    }
}

