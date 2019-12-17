package entiy;


//定义树的结点
public class treeNode {
    public int id;
    public String da;
    public String fatherId;

    public treeNode(String da, String fatherId) {
        this.da = da;
        this.fatherId = fatherId;
    }
    public treeNode() { }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDa() {
        return da;
    }

    public void setDa(String da) {
        this.da = da;
    }

    public String getFatherId() {
        return fatherId;
    }

    public void setFatherId(String fatherId) {
        this.fatherId = fatherId;
    }
}