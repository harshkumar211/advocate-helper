//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package dbhelper;

import java.util.ArrayList;

public class ApplicantInfo {
    private int id;
    private int sno;
    private String name;
    private String fh;
    private String fhName;
    private String sirName;
    private String address;
    private String age;
    private ArrayList<Property> properties;
    private ArrayList<ChannelHistory> channelHistories;
    private ArrayList<DocumentList> documentLists;
    private AabadiProperty aabadiProperty;

    public ApplicantInfo() {
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

    public String getFh() {
        return this.fh;
    }

    public void setFh(String fh) {
        this.fh = fh;
    }

    public String getFhName() {
        return this.fhName;
    }

    public void setFhName(String fhName) {
        this.fhName = fhName;
    }

    public String getSirName() {
        return this.sirName;
    }

    public void setSirName(String sirName) {
        this.sirName = sirName;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAge() {
        return this.age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public ArrayList<Property> getProperties() {
        return this.properties;
    }

    public void setProperties(ArrayList<Property> properties) {
        this.properties = properties;
    }

    public ArrayList<ChannelHistory> getChannelHistories() {
        return this.channelHistories;
    }

    public void setChannelHistories(ArrayList<ChannelHistory> channelHistories) {
        this.channelHistories = channelHistories;
    }

    public ArrayList<DocumentList> getDocumentLists() {
        return this.documentLists;
    }

    public void setDocumentLists(ArrayList<DocumentList> documentLists) {
        this.documentLists = documentLists;
    }

    public AabadiProperty getAabadiProperty() {
        return this.aabadiProperty;
    }

    public void setAabadiProperty(AabadiProperty aabadiProperty) {
        this.aabadiProperty = aabadiProperty;
    }
}
