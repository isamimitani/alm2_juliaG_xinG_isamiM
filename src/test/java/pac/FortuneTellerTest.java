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

    private final String[] HEALTHO = 
    {"keep on a diet", "ensure protein intake", "develop a good sleep routine", "practice swimming", "enjoy the sunshine"};
    private final String[] HEALTHA = 
    {"eat less meat", "eat more vegetables", "prevent catch cold", "drink some fruit tea", "practice yoga"};
    private final String[] HEALTHB = 
    {"practice tai chi", "eat a little mutton", "eat a little hazel and pine nut", "drink some licorice tea", "eat less chicken"};
    private final String[] HEALTHC = 
    {"give up smoking", "stop drinking", "prevent the intake of allergenic foods", "take some vitamin C", "have some outdoor activites"};
    
    private int jobindex = 0;
    private int healthindex = 0;

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
            int index2 = jobindex % 3;
            String jobM = fortuneTeller.showJob(birthMonth, 'M');
            String expectM = JOBM[index1][index2];
            LOG.info("Testing the method showJob with: " + jobM + " and " + expectM);
            assertEquals(jobM, expectM);
            jobindex++;
        }
        for (int i = 0; i < 10; i++) {
            Random ran = new Random();
            int indexM = ran.nextInt(12);
            int birthMonth = indexM + 1;
            int index1 = (birthMonth - 1) % 4;
            int index = 0;
            int index2 = jobindex % 3;
            String jobF = fortuneTeller.showJob(birthMonth, 'F');
            String expectF = JOBF[index1][index2];
            LOG.info("Testing the method showJob with: " + jobF + " and " + expectF);
            assertEquals(jobF, expectF);
            jobindex++;
        }
    }

    @Test
    public void testShowHealth() {
        for (int i = 0; i < 10; i++) {
            int index2 = healthindex % 5;
            String healthA = fortuneTeller.showHealth('A');
            String expectA = HEALTHA[index2];
            LOG.info("Testing the method health with: " + healthA + " and " + expectA);
            assertEquals(healthA, expectA);
            healthindex++;
        }
        for (int i = 0; i < 10; i++) {
            int index2 = healthindex % 5;
            String healthB = fortuneTeller.showHealth('B');
            String expectB = HEALTHB[index2];
            LOG.info("Testing the method health with: " + healthB + " and " + expectB);
            assertEquals(healthB, expectB);
            healthindex++;
        }
        for (int i = 0; i < 10; i++) {
            int index2 = healthindex % 5;
            String healthAB = fortuneTeller.showHealth('C');
            String expectAB = HEALTHC[index2];
            LOG.info("Testing the method health with: " + healthAB + " and " + expectAB);
            assertEquals(healthAB, expectAB);
            healthindex++;
        }
        for (int i = 0; i < 10; i++) {
            int index2 = healthindex % 5;
            String healthO = fortuneTeller.showHealth('O');
            String expectO = HEALTHO[index2];
            LOG.info("Testing the method health with: " + healthO + " and " + expectO);
            assertEquals(healthO, expectO);
            healthindex++;
        }
    }

    @Test
    public void testTellFortune() {
        Random ran = new Random();
        char[] gender = {'F', 'M'};
        char[] blood = {'A', 'B', 'C', 'O'};
        int[] month = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        for (int i = 10; i < 10; i++) {
            int genderindex = ran.nextInt(2);
            int bloodindex = ran.nextInt(4);
            int monthindex = ran.nextInt(12);
            int ranName = ran.nextInt();
            String name = "Test-" + ranName;
            String result = fortuneTeller.tellFortune(name, gender[genderindex], blood[bloodindex], month[monthindex]);
            int index = result.indexOf(",");
            String expect = "Hi " + name + result.substring(index);
            LOG.info("Testing the method tell fortune with: " + result + " and " + expect);
            assertEquals(result, expect);

        }
    }
}
