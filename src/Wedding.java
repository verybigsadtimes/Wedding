import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class Wedding{
    private LocalDate LocalDate;
    private String Location;
    private int Cake;
    Couple c1;
    public Wedding(Couple c, LocalDate d, String loc, int ca) {
        c1 = c;
        LocalDate = d;
        Location = loc;
        Cake = ca;
    }
    DateTimeFormatter dateformatter = DateTimeFormatter.ofPattern("MM dd, YYYY");
    public Couple getc1() {return c1;}
    public String getLocalDate() {return dateformatter.format(LocalDate);}
    public String getLocation() {return Location;}
    public int getCake() {return Cake;}
    public void setLocalDate(LocalDate LocalDate){this.LocalDate = LocalDate;}
    public void setLocation(String Location){this.Location = Location;}
    public void setCake(int Cake){this.Cake = Cake;}
}