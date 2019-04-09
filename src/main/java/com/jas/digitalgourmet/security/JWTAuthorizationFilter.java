package com.jas.digitalgourmet.security;

import static  com.jas.digitalgourmet.util.Constant.HEADER_AUTHORIZACION_KEY;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingResponseWrapper;

import com.jas.digitalgourmet.controller.dto.JwtCredentials;
import com.jas.digitalgourmet.util.CustomHttpServletRequestWrapper;


public class JWTAuthorizationFilter extends OncePerRequestFilter {

    private JwtTokenUtil jwtTokenUtil;

    JWTAuthorizationFilter(JwtTokenUtil jwtTokenUtil) {
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        String header = request.getHeader(HEADER_AUTHORIZACION_KEY);
        JwtCredentials jwtCredentials = null;
        /*Si viene vacio, aplica los filtros y se va */
        if (header == null) {
            chain.doFilter(request, response);
        }

        /* Si el header no viene vacio, intento decodearlo */
        if (header != null) {
            jwtCredentials = jwtTokenUtil.getDatosToken(header);
        }

        /* Si vienen llenos los datos de usuario y el contexto de spring no tiene autenticacion seteada */
        if (jwtCredentials != null && SecurityContextHolder.getContext().getAuthentication() == null) {

            DigitalGourmetAuthenticationToken authenticationToken = new DigitalGourmetAuthenticationToken(jwtCredentials);

            String newToken = jwtTokenUtil.generateJWT(jwtCredentials);
            response.setHeader("Token", newToken);

            authenticationToken.setToken(newToken);

            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }

        ContentCachingResponseWrapper contentCachingResponseWrapper = new ContentCachingResponseWrapper(response);
        chain.doFilter(new CustomHttpServletRequestWrapper(request), contentCachingResponseWrapper);

        contentCachingResponseWrapper.copyBodyToResponse();
    }

}
