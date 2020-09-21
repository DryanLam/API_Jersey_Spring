package com.sample.dl.filter;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
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

