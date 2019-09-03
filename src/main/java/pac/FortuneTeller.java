package pac;

import java.util.Random;


public class FortuneTeller {

    private static FortuneTeller fortuneTeller;
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

    private FortuneTeller() {
    }

    public static FortuneTeller getInstance() {
        if (fortuneTeller == null) {
            fortuneTeller = new FortuneTeller();
        }
        return fortuneTeller;
    }

    //1 5 9 , 2 6 10, 3 7 11, 4 8 12
    //0      1       2      3
    public String tellFortune(String name, char gender, char bloodtype, int birthMonth) {
        String character = showCharacter(birthMonth);
        String job = showJob(birthMonth, gender);
        String health = showHealth(bloodtype);

        String result = "Hi " + name + ", " + character + "and you will be successful in the job about " + job
                + ". Recently, you need to " + health + ". Good luck!";

        return result;
    }

    public String showCharacter(int birthMonth) {
        return CHARACTER[birthMonth - 1];
    }

    public String showJob(int birthMonth, char gender) {
        int index1 = (birthMonth - 1) % 4;
        String job = "";
//        Random ran = new Random();
        int index = 0;
        int index2 = index % 2;
        if (gender == 'M') {
//            index++;
            job = JOBM[index1][index2];
        } else {
//            index++;
            job = JOBF[index1][index2];
        }
        index++;
        return job;
    }

    public String showHealth(char bloodtype) {
        Random ran = new Random();
        String health = "";
        int index = ran.nextInt(3);
        switch (bloodtype) {
            case 'A':
                health = HEALTHA[index];
                break;
            case 'B':
                health = HEALTHB[index];
                break;
            case 'O':
                health = HEALTHO[index];
                break;
            default:
                health = HEALTHC[index];
                break;
        }
        return health;
    }


}
