public class Couple {
    Person p1;
    Person p2;
    public Couple(Person bride, Person groom){
        p1 = bride;
        p2 = groom;
    }
    public Person getp1() {return p1;}
    public Person getp2() {return p2;}
}