//package servlets;
//
//import entities.BankAccount;
//import jakarta.servlet.RequestDispatcher;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.xml.ws.WebServiceRef;
//import services.BankService;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//@WebServlet(urlPatterns = "/getBankAccountByNumber")
//public class NumberServlet extends HttpServlet {
//
//    @WebServiceRef
//    BankService bankService;
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String number = req.getParameter("number");
//        BankAccount bankAccount = bankService.getByNumber(number);
//        List<BankAccount> list = new ArrayList<>();
//        if (bankAccount != null) {
//            list.add(bankAccount);
//        }
//        req.setAttribute("accounts", list);
//        req.setAttribute("message", "Bank account with number " + number);
//        req.setAttribute("badMessage", "There is no account with this number!");
//        RequestDispatcher dispatcher = req.getRequestDispatcher("/answer.jsp");
//        dispatcher.forward(req, resp);
//    }
//}
