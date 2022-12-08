package SchoolProjectApp;

public class InstructorPojo {

    private String idNo;
    private String nameSurname;
    private int old;
    private int registrationNumber;
    private String department;

    public InstructorPojo() {
    }

    public InstructorPojo(String idNo, String nameSurname, int old, int registrationNumber, String department) {
        this.idNo = idNo;
        this.nameSurname = nameSurname;
        this.old = old;
        this.registrationNumber = registrationNumber;
        this.department = department;
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

    public int getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(int registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return  "\nIdentification number  --> "+idNo+
                "\nName Surname           --> "+nameSurname+
                "\nOld                    --> "+old+
                "\nRegistration Number    --> "+registrationNumber+
                "\nDepartment             --> "+department;
    }
}
