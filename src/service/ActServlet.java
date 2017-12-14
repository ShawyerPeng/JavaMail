package service;

import dao.UserDao;
import domain.User;
import javafx.application.Application;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "ActServlet")
public class ActServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String randomcode = request.getParameter("randomcode");
        System.out.println(username);
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        System.out.println(user);
        UserDao userDao = new UserDao();
        Date date = new Date();
        Date date1 = userDao.select(username);
        long nowtime = date.getTime() / 1000;
        long addtime = date1.getTime() / 1000;
        System.out.println(nowtime);
        System.out.println(addtime);
        System.out.println(nowtime-addtime);
        if ((nowtime - addtime) > 108000) {
            userDao.delete(username);
            response.sendRedirect("/lost.jsp");
        }else{
            if (user.getName().equals(username) && user.getRandomcode().equals(randomcode)) {
                userDao.update(username);
                response.sendRedirect("/login.jsp");
            } else {
                response.sendRedirect("/login.jsp");
            }
        }
    }

}
