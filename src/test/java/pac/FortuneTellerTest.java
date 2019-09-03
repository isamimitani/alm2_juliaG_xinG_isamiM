/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pac;

import java.util.Random;
import java.util.logging.Logger;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Julia
 */
public class FortuneTellerTest {
    private static final Logger LOG = Logger.getLogger(FortuneTeller.class.getName());

    FortuneTeller fortuneTeller = FortuneTeller.getInstance();

    private final String[] CHARACTER = {"you are very paitent, ", "you are so unique, ", "you are quite romantic, ",
        "you are brave, ", "you are an honest person, ", "you are a little sensitive, ",
        "you are very responsible, ", "you have leadership, ", "you are so careful, ",
        "you are attractive, ", "you are quite mystery, ", "you like freedom, "};

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testShowCharacter() {
        for(int i = 0; i < 10; i++){
            Random ran = new Random();
            int index = ran.nextInt(12);
            String character = fortuneTeller.showCharacter(index+1);
            String expect = CHARACTER[index];
            LOG.info("Testing the method showCharacter with: " + character + " and " + expect);
            assertEquals(character, expect);            
        }
    }
}
