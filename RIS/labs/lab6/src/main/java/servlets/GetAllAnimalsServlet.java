package servlets;


import by.bsuir.Animal;
import by.bsuir.AnimalService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.xml.ws.WebServiceRef;


import java.io.IOException;
import java.util.List;


@WebServlet(urlPatterns = "/getAllAnimals")
public class GetAllAnimalsServlet extends HttpServlet {

    @WebServiceRef
    AnimalService animalService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Animal> list = animalService.getAll();
        req.setAttribute("accounts", list);
        req.setAttribute("message", "All animals");
        req.setAttribute("badMessage", "There are no animals!");
        RequestDispatcher dispatcher = req.getRequestDispatcher("/answer.jsp");
        dispatcher.forward(req, resp);
    }
}
