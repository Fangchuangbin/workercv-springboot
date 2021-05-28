package com.workercv.springboot.interceptor;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.workercv.springboot.util.JWTUtil;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

public class JWTInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = new String(Base64.decodeBase64(request.getHeader("token")), StandardCharsets.UTF_8);
        HashMap<String, Object> map = new HashMap<>();
        map.put("code", 1);
        try{
            JWTUtil.verify(token);
            map.put("code", 0);
            map.put("msg","令牌有效");
        }catch (SignatureVerificationException e){
            e.printStackTrace();
            map.put("msg","无效令牌");
        }catch (TokenExpiredException e){
            e.printStackTrace();
            map.put("msg","令牌过期");
        }catch (AlgorithmMismatchException e){
            e.printStackTrace();
            map.put("msg","无效令牌");
        }catch (Exception e){
            e.printStackTrace();
            map.put("msg","无效令牌");
        }
        String result = new ObjectMapper().writeValueAsString(map);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().println(result);
        return false;
    }

}
