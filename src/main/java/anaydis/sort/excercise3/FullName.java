package anaydis.sort.excercise3;

/**
 * User: nschejtman
 * Date: 27/08/13
 * Time: 16:39
 */
public class FullName {
    private String firstName;
    private String lastName;

    public FullName(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void print(){
        System.out.println(firstName + " " + lastName);
    }
}
