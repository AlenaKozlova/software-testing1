import org.junit.Test;

public class MainClassTest extends MainClass {

    @Test
            public void testGetLocalNumber(){
            int b = 0;

            b = this.getLocalNumber();

            if (b == 14)
            {
                System.out.println("True");
            }
            else
            {
                System.out.println("False");
            }
        }
    @Test
    public void testGetClassNumber(){
        int c = 0;
        c = this.getClassNumber();

        if (c > 45)
        {
            System.out.println("True, c > 45");
        }
        else
        {
            System.out.println("False, c < 45");
        }
    }

    @Test
    public void testGetClassString(){
       String class_string = this.getClassString();
        {
           boolean got = class_string.contains("hello");
           System.out.println("true hello");
                   }

    }

}

