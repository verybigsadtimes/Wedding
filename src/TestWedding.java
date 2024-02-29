import java.util.Scanner;
import java.time.LocalDate;
public class TestWedding{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first name of bride >> "); //bride creation
        String bfna = sc.nextLine();
        System.out.println("Enter last name of bride >> ");
        String blna = sc.nextLine();
        Person bride = new Person(bfna, blna);
        System.out.println("Enter first name of groom >> "); //groom creation
        String gfna = sc.nextLine();
        System.out.println("Enter last name of groom >> ");
        String glna = sc.nextLine();
        Person groom = new Person(gfna, glna);
        Couple c1 = new Couple(bride, groom);
        System.out.println("Enter location of wedding >> "); //location
        String locate = sc.nextLine();
        System.out.println("Enter date of wedding >> "); //date
        LocalDate time = LocalDate.parse(sc.nextLine());
        System.out.println("Enter number of tiers on wedding cake >> "); //cake
        int layers = sc.nextInt();
        Wedding w1 = new Wedding(c1, time, locate, layers);
        System.out.println("Please join us for the wedding of " + w1.getc1().getp1().getFName() + " " + w1.getc1().getp1().getLName() + " and " + w1.getc1().getp2().getFName() + " " + w1.getc1().getp2().getLName() + " at " + w1.getLocation() + " on " + w1.getLocalDate() + "! There will be a " + w1.getCake() + "-tier cake!");
    }
}