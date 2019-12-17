package travel;
import java.util.ArrayList;
import java.util.List;

public class TravelTree {

    public List<Object[]> show = new ArrayList<Object[]>();
    //声明要返回的树结构集合
    public List<Object[]> getShow = new ArrayList<Object[]>();

    public TravelTree(List<Object[]> show){
        this.show = show;
    }

    private void fun(List<Object[]> list, String s, int k){
        //一个简单的递归，fun参数为
        // list：从数据库中查到的所有数据，
        // s：父节点，当父节点==此条数据中的父节点是存入getshow集合
        // k：递归得出的当前节点的层级数
        for(Object b[] :list){
            if (b[2].toString().equals(s)){//当前节点等于父节点是，讲节点存入集合
                Object []objects = new Object[3];
                //System.out.println(b[1]);
                objects[0]=b[1].toString();
                objects[1]=b[2].toString();
                objects[2]=k;
                getShow.add(objects);
                fun(list,b[1].toString(),k+1);
            }
        }
    }

    public List<Object[]> getShowTree(){
        fun(show,"0",0);
        return getShow;
    }

}
