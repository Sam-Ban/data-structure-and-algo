package practice.designpattern.structural.adapter;

public class RawMaterial {
    private String rid;
    private String rdesc;

    public RawMaterial(String rid,String rdesc){
        this.rid = rid;
        this.rdesc = rdesc;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public String getRdesc() {
        return rdesc;
    }

    public void setRdesc(String rdesc) {
        this.rdesc = rdesc;
    }

    @Override
    public String toString() {
        return "RawMaterial{" +
                "rid='" + rid + '\'' +
                ", rdesc='" + rdesc + '\'' +
                '}';
    }
}
