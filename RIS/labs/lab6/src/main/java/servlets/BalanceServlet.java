//package servlets;
//
//
//import jakarta.servlet.RequestDispatcher;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.xml.ws.WebServiceRef;
//
//
//import java.io.IOException;
//import java.util.List;
//
//@WebServlet(urlPatterns = "/getBankAccountsByBalance")
//public class BalanceServlet extends HttpServlet {
//
//    @WebServiceRef
//    BankService bankService;
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        Integer balance = Integer.valueOf(req.getParameter("balance"));
//        List<BankAccount> list = bankService.getByBalance(balance);
//        req.setAttribute("accounts", list);
//        req.setAttribute("message", "Bank account with balance " + balance);
//        req.setAttribute("badMessage", "There are no accounts with this balance!");
//        RequestDispatcher dispatcher = req.getRequestDispatcher("/answer.jsp");
//        dispatcher.forward(req, resp);
//    }
//}
