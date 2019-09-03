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

    private final String[][] JOBM = {{"librarian", "archeitect", "accounting"}, {"astronomer", "sales", "diplomatist"},
    {"teacher", "cook", "doctor"}, {"explorer", "judge", "researcher"}};
    private final String[][] JOBF = {{"civil servant", "designer", "analyst"}, {"psychologists", "writer", "actor"},
    {"secretary", "nurse", "freelancer"}, {"entrepreneur", "programmer", "journalist"}};

    private final String[] HEALTHO = {"keep on a diet", "ensure protein intake", "develop a good sleep routine"};
    private final String[] HEALTHA = {"eat less meat", "eat more vegetables", "prevent catch cold"};
    private final String[] HEALTHB = {"practice tai chi", "eat a little mutton", "eat a little hazel and pine nut"};
    private final String[] HEALTHC = {"give up smoking", "stop drinking", "prevent the intake of allergenic foods"};

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testShowCharacter() {
        for (int i = 0; i < 10; i++) {
            Random ran = new Random();
            int index = ran.nextInt(12);
            int birthMonth = index + 1;
            String character = fortuneTeller.showCharacter(birthMonth);
            String expect = CHARACTER[index];
            LOG.info("Testing the method showCharacter with: " + character + " and " + expect);
            assertEquals(character, expect);
        }
    }

    @Test
    public void testShowJob() {
        for (int i = 0; i < 10; i++) {
            Random ran = new Random();
            int indexM = ran.nextInt(12);
            int birthMonth = indexM + 1;
            int index1 = (birthMonth - 1) % 4;
            int index = 0;
            int index2 = index % 2;

            String jobM = fortuneTeller.showJob(birthMonth, 'M');
            String expectM = JOBM[index1][index2];
            LOG.info("Testing the method showJob with: " + jobM + " and " + expectM);
            assertEquals(jobM, expectM);
            index++;

            String jobF = fortuneTeller.showJob(birthMonth, 'F');
            String expectF = JOBF[index1][index2];
            LOG.info("Testing the method showJob with: " + jobF + " and " + expectF);
            assertEquals(jobF, expectF);
            index++;
        }
    }

    @Test
    public void testShowHealth() {
        for (int i = 0; i < 10; i++) {
            int index = 0;
            int index2 = index % 2;

            String healthA = fortuneTeller.showHealth('A');
            String expectA = HEALTHA[index2];
            LOG.info("Testing the method health with: " + healthA + " and " + expectA);
            assertEquals(healthA, expectA);
            index++;

            String healthB = fortuneTeller.showHealth('B');
            String expectB = HEALTHB[index2];
            LOG.info("Testing the method health with: " + healthB + " and " + expectB);
            assertEquals(healthB, expectB);
            index++;

            String healthAB = fortuneTeller.showHealth('C');
            String expectAB = HEALTHC[index2];
            LOG.info("Testing the method health with: " + healthAB + " and " + expectAB);
            assertEquals(healthAB, expectAB);
            index++;

            String healthO = fortuneTeller.showHealth('O');
            String expectO = HEALTHO[index2];
            LOG.info("Testing the method health with: " + healthO + " and " + expectO);
            assertEquals(healthO, expectO);
            index++;

        }
    }

    @Test
    public void testTellFortune() {
        
    }
}
