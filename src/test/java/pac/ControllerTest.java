package pac;

import org.junit.Test;
import static org.junit.Assert.*;


public class ControllerTest {
    
    private Controller controller;
    private FortuneTeller teller;

    public ControllerTest() {
        controller = new Controller();
        teller = FortuneTeller.getInstance();
        controller.init();
        controller.setName("testname");
        controller.setBloodtype('A');
        controller.setGender('M');
        controller.setBirthMonth(1);
        controller.setResult("");
        controller.showFortune();
    }
    
    

     @Test
     public void hello() {
         assertEquals("testname", controller.getName());
         assertEquals('A', controller.getBloodtype());
         assertEquals('M', controller.getGender());
         assertEquals(1, controller.getBirthMonth());
         assertEquals(teller.tellFortune(controller.getName(), controller.getGender(), controller.getBloodtype(), controller.getBirthMonth()), controller.getResult());
                 
             
     }
}
