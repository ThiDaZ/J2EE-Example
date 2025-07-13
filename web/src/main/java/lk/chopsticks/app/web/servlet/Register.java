package lk.chopsticks.app.web.servlet;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.chopsticks.app.core.model.User;
import lk.chopsticks.app.core.service.UserService;

import java.io.IOException;

@WebServlet("/register")
public class Register extends HttpServlet {


    @EJB
    private UserService userService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String contact = req.getParameter("contact");

        User user = new User(name, email, password, contact);

        userService.addUser(user);

    }
}
