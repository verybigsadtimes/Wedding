public class Person {
    private String FName;
    private String LName;
    public Person(String fn, String ln){
        FName = fn;
        LName = ln;
    }
    public String getFName() {return FName;}
    public String getLName() {return LName;}
    public void setFName(String Fname){this.FName = FName;}
    public void setLName(String LName){this.FName = LName;}
}