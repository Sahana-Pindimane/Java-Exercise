package sd.db;

public class Student {

    String name;
    String address;
    String be_branch;

    public Student() {}

    public Student( String name, String address, String be_branch)
    {

        this.name = name;
        this.address = address;
        this.be_branch = be_branch;
    }

    

    public String getName()
    {
        return name;
    }

    public String getAddress()
    {
        return address;
    }

    public String getBEBranch()
    {
        return be_branch;
    }



    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setBEBranch(String be_branch) {
        this.be_branch = be_branch;
    }
}