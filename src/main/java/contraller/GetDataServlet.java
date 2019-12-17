package contraller;
import service.DataSource;
import travel.TravelTree;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
@WebServlet("/show")
public class GetDataServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws IOException {
        req.setCharacterEncoding("UTF-8");
        StringBuilder sb = new StringBuilder();
        List<Object[]> list = null;
        List<Object[]> getdata = null;
        try {
            //查询数据库所有数据
            getdata = DataSource.getData();
            System.out.println("查询数据库所有节点成功-->>>>>");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //递归得到树结构
        TravelTree travelTree = new TravelTree(getdata);
        list = travelTree.getShowTree();
        //读取list集合中数据
        for(Object b[] :list){
            System.out.println("当前节点："+b[0].toString()+"--"+"父节点："+b[1].toString()+"--"+"层级："+b[2]);
            sb.append(b[0].toString()+"|"+b[2].toString()).append("#");
        }

        /**
         * 2.使用PrintWriter流向客户端浏览器输出中文数据
         * PS:当需要向浏览器输出字符数据时，使用PrintWriter比较方便，省去了将字符转换成字节数组那一步。
         */
        response.setCharacterEncoding("UTF-8");//设置将字符以"UTF-8"编码输出到客户端浏览器
        PrintWriter out = response.getWriter();//获取PrintWriter输出流(PS：这句代码必须放在response.setCharacterEncoding("UTF-8");之后，否则response.setCharacterEncoding("UTF-8")这行代码的设置将无效，浏览器显示的时候还是乱码)
        response.setHeader("content-type", "text/html;charset=UTF-8");//设置响应头，控制浏览器以指定的字符编码编码进行显示
        out.append(new StringBuilder(sb.toString()).append("#"));//使用PrintWriter流向客户端输出字符

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        doGet(req, resp);
    }
}
