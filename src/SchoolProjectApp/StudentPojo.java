package SchoolProjectApp;

public class StudentPojo {

    private String idNo;
    private String nameSurname;
    private int old;
    private int classCategory;
    private int schoolNumber;

    public StudentPojo() {
    }

    public StudentPojo(String idNo, String nameSurname, int old, int classCategory, int schoolNumber) {
        this.idNo = idNo;
        this.nameSurname = nameSurname;
        this.old = old;
        this.classCategory = classCategory;
        this.schoolNumber = schoolNumber;
    }

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    public String getNameSurname() {
        return nameSurname;
    }

    public void setNameSurname(String nameSurname) {
        this.nameSurname = nameSurname;
    }

    public int getOld() {
        return old;
    }

    public void setOld(int old) {
        this.old = old;
    }

    public int getClassCategory() {
        return classCategory;
    }

    public void setClassCategory(int classCategory) {
        this.classCategory = classCategory;
    }

    public int getSchoolNumber() {
        return schoolNumber;
    }

    public void setSchoolNumber(int schoolNumber) {
        this.schoolNumber = schoolNumber;
    }

    @Override
    public String toString() {
        return  "\nIdentification number --> "+idNo+
                "\nName Surname          --> "+ nameSurname+
                "\nOld                   --> "+old+
                "\nClass Category        --> "+classCategory+
                "\nSchool Number         --> "+schoolNumber;

    }
}
