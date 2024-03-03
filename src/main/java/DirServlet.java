import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;

@WebServlet("/files")
public class DirServlet extends HttpServlet{

    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException {
        String path = req.getParameter("path");
        File file = new File(path);
        File[] files;
        File[] directories;
        if(file.isDirectory()) {
            files = file.listFiles(File :: isFile);
            directories = file.listFiles(File :: isDirectory);
        }
        else {
            files = new File[0];
            directories = new File[0];
        }


        req.setAttribute("files", files);
        req.setAttribute("dires", directories);
        req.getRequestDispatcher("mypage.jsp").forward(req, res);
    }

}
