//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package dbhelper;

public class ChannelHistory {
    private int id;
    private int sno;
    private String name;
    private String deedDate;
    private String nature;
    private String khasra;
    private String size;

    public ChannelHistory() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSno() {
        return this.sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeedDate() {
        return this.deedDate;
    }

    public void setDeedDate(String deedDate) {
        this.deedDate = deedDate;
    }

    public String getNature() {
        return this.nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public String getKhasra() {
        return this.khasra;
    }

    public void setKhasra(String khasra) {
        this.khasra = khasra;
    }

    public String getSize() {
        return this.size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String toString() {
        String chain = "";
        chain = this.name + " they have executed " + this.nature + " of khasra number " + this.khasra + " registered on date " + this.deedDate + " size " + this.size;
        return chain;
    }
}
