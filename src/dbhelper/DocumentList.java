//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package dbhelper;

public class DocumentList {
    private String documentName;
    private String issuedBy;
    private String issuedByCaption;
    private String date;
    private String issuedTo;
    private String issuedToCaption;
    private String documentNumber;
    private String samwat;
    private String required;
    private String registeredDate;
    private int id;
    private int sno;

    public DocumentList() {
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

    public String getDocumentName() {
        return this.documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public String getIssuedBy() {
        return this.issuedBy;
    }

    public void setIssuedBy(String issuedBy) {
        this.issuedBy = issuedBy;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getIssuedTo() {
        return this.issuedTo;
    }

    public void setIssuedTo(String issuedTo) {
        this.issuedTo = issuedTo;
    }

    public String getDocumentNumber() {
        return this.documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getSamwat() {
        return this.samwat;
    }

    public void setSamwat(String samwat) {
        this.samwat = samwat;
    }

    public String getRequired() {
        return this.required;
    }

    public void setRequired(String required) {
        this.required = required;
    }

    public String getIssuedByCaption() {
        return this.issuedByCaption;
    }

    public void setIssuedByCaption(String issuedByCaption) {
        this.issuedByCaption = issuedByCaption;
    }

    public String getIssuedToCaption() {
        return this.issuedToCaption;
    }

    public void setIssuedToCaption(String issuedToCaption) {
        this.issuedToCaption = issuedToCaption;
    }

    public String getRegisteredDate() {
        return this.registeredDate;
    }

    public void setRegisteredDate(String registeredDate) {
        this.registeredDate = registeredDate;
    }

    public String toString() {
        String chain = "";
        chain = ". then after " + this.issuedBy + " issued " + this.documentName + " in favour of " + this.issuedTo + " dated on " + this.date + " which was registered dated on " + this.registeredDate;
        return chain;
    }
}
