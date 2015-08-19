package com.lpsmuseum.webmuseum.controller;

import facebook4j.Facebook;
import facebook4j.FacebookFactory;
import facebook4j.FacebookException;
import facebook4j.Media;
import facebook4j.PhotoUpdate;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FacebookController {

    @RequestMapping("signin")
    public void signin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Facebook facebook = new FacebookFactory().getInstance();
        request.getSession().setAttribute("facebook", facebook);
        StringBuffer callbackURL = request.getRequestURL();
        int index = callbackURL.lastIndexOf("/");
        callbackURL.replace(index, callbackURL.length(), "").append("/callback");
        response.sendRedirect(facebook.getOAuthAuthorizationURL(callbackURL.toString()));
    }

    @RequestMapping("callback")
    public void callback(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Facebook facebook = (Facebook) request.getSession().getAttribute("facebook");
        String oauthCode = request.getParameter("code");
        try {
            facebook.getOAuthAccessToken(oauthCode);
        } catch (FacebookException e) {
            throw new ServletException(e);
        }
        response.sendRedirect(request.getContextPath() + "/");
    }

    @RequestMapping("post")
    public void post(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, FacebookException {
        request.setCharacterEncoding("UTF-8");
        String message = request.getParameter("message");
        Facebook facebook = (Facebook) request.getSession().getAttribute("facebook");

        File file = new File("c:\\temp\\imagem.png");
        FileInputStream fileInputStream = new FileInputStream(file);

        Media media = new Media("Imagem", fileInputStream);
        PhotoUpdate photoUpdate = new PhotoUpdate(media);
        photoUpdate.setMessage("Museu LPS");

        facebook.postPhoto(photoUpdate);

        response.sendRedirect(request.getContextPath() + "/");
    }

    @RequestMapping("logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Facebook facebook = (Facebook) request.getSession().getAttribute("facebook");
        String accessToken = facebook.getOAuthAccessToken().getToken();
        request.getSession().invalidate();

        // Log Out of the Facebook
        StringBuffer next = request.getRequestURL();
        int index = next.lastIndexOf("/");
        next.replace(index + 1, next.length(), "");
        response.sendRedirect("http://www.facebook.com/logout.php?next=" + next.toString() + "&access_token=" + accessToken);
    }

}
