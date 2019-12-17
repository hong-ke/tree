package until;

import service.DataSource;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class test {
    static List<Object[]> show = new ArrayList<Object[]>();
    private static String root = "0";
    private static int flog = 0;
    public static void main(String[] args) throws SQLException {
//        List<Object[]> a =  service.DataSource.getData();
//        travel.TravelTree travelTree = new travel.TravelTree(a);
//        show = travelTree.getShowTree();
//        for(Object b[] :show){
//            System.out.println(b[0].toString()+"--------"+b[1].toString()+"------"+b[2]);
//        }
        DataSource.delete();
        //System.out.println(a.get(0).getId());

    }

    private static void fun(List<Object[]> list ,String s,int k){

//        for(Object b[] :list){
//
//            if (b[2].toString().equals(s)){
//                Object []objects = new Object[3];
//                //System.out.println(b[1]);
//                objects[0]=b[1].toString();
//                objects[1]=b[2].toString();
//                objects[2]=k;
//                show.add(objects);
//                root = b[1].toString();
//                fun(list,b[1].toString(),k+1);
//
//            }
//        }
    }
}
