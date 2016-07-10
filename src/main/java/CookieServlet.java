import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Gvozd on 10.07.2016.
 */
public class CookieServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();
        Cookie oreo = new Cookie("TIJava", "Fu");
        resp.addCookie(oreo);
        String result="";

        Cookie[] cooks = req.getCookies();
        for (Cookie obj: cooks){
            if (obj.getName().equals("TIJava")){
                result = obj.getValue();
            }
        }

        result = result + "u";
        pw.print("Cookie is "+ result);
        pw.close();
    }
}
