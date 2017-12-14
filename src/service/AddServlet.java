package service;

import dao.UserDao;
import domain.User;
import util.EncodeMD5;
import util.SendMail;
import util.Time;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Random;

public class AddServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        System.out.println(username);
        System.out.println(password);
        System.out.println(email);
        StringBuffer random = new StringBuffer();
        Random r = new Random();
        for (int i = 0; i < 4; i++) {
            random.append(r.nextInt(10));
        }
        System.out.println(random.toString());
        String randomcode = EncodeMD5.getMd5(random.toString());
        String time = Time.getDate();
        System.out.println(time);
        User user = new User();
        user.setName(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setRandomcode(randomcode);
        UserDao userdao = new UserDao();
        userdao.add(user);
        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        SendMail.sendMail(user.getName(),randomcode,email);
//        user.setUser(user);
//        System.out.println(user.getUser());
//        System.out.println(username);
//        System.out.println(password);
//        System.out.println(email);
        request.getRequestDispatcher("/login.jsp").forward(request, response);

    }
}
