package contraller;
import entiy.treeNode;
import service.DataSource;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

//插入一条数据
@WebServlet("/insert")
public class InserOneDataServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取数据
        request.setCharacterEncoding("UTF-8");
        String data = request.getParameter("data");
        String father = request.getParameter("father");
//        String clientStr=request.getQueryString();
        StringBuilder sb = new StringBuilder();
//        String[] data = null;
//        if (clientStr.indexOf("#")>0){
//            data=clientStr.split("#");
//        }
        System.out.println("要插入的节点是-->>>>>"+data);

        treeNode treeNode = new treeNode(data,father);
        try {
            int flog = DataSource.insertOneData(treeNode);
            if(flog==1){
                sb.append(flog);
                response.setCharacterEncoding("UTF-8");//设置将字符以"UTF-8"编码输出到客户端浏览器
                PrintWriter out = response.getWriter();//获取PrintWriter输出流(PS：这句代码必须放在response.setCharacterEncoding("UTF-8");之后，否则response.setCharacterEncoding("UTF-8")这行代码的设置将无效，浏览器显示的时候还是乱码)
                response.setHeader("content-type", "text/html;charset=UTF-8");//设置响应头，控制浏览器以指定的字符编码编码进行显示
                out.append(new StringBuilder(sb.toString()).append("#"));//使用PrintWriter流向客户端输出字符
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
