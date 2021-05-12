import org.junit.jupiter.api.Test;

public class MyFirstTest {
    @Test
    public void firstTest() {
        System.out.println("Hello world!");

        String firstName = "Renars";
        String lastName = "Kravcovs";
        String email = "renars.k@gmail.com";
        int age = 41;
        System.out.println("First name: " + firstName + "\nLast Name: " + lastName + "\nE-mail: " + email + "\nAge: " + age);

        int commentCount = 36;
        int newComments = 22;

        String stringcommentCount = "36";
        String stringnewComments = "22";


        System.out.println(commentCount + newComments);
        System.out.println(stringcommentCount + " " + stringnewComments);

        printSum("15", "3");

    }

    private void printSum(String a, String b) {
        int first = Integer.parseInt(a);
        int second = Integer.parseInt(b);
        System.out.println("Text is: " + (first + second));
    }

}
