package com.sample.dl.filter;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import java.io.IOException;


@PreMatching
public class AppFilter implements ContainerRequestFilter  {

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        String tc = requestContext.getHeaderString("testcase");
        if(tc != null){
            System.out.println(tc);
        }
    }

}

