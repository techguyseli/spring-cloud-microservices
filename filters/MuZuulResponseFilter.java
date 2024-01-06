package com.mcommerce.zuulserver.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletResponse;

@Component
public class MuZuulResponseFilter extends ZuulFilter{

    Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public String filterType() {
        //post : contiendra les filtres exécutés après le routage d’une requête (règles de post-routage).
        return "post";
    }

    @Override
    public int filterOrder() { return 1; }

    @Override
    public boolean shouldFilter() { return true; }

    @Override
    public Object run() throws ZuulException {
        HttpServletResponse response = RequestContext.getCurrentContext().getResponse();
        response.setStatus(400);
        log.info(
            " *** MyZuulReponseFilter : response.getStatus()); CODE HTTP {} **** ",
            response.getStatus()
        );
        return null;
    }
}
