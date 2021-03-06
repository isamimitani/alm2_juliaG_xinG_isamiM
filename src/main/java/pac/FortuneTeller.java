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
    private final String[] HEALTHO = 
    {"keep on a diet", "ensure protein intake", "develop a good sleep routine", "practice swimming", "enjoy the sunshine"};
    private final String[] HEALTHA = 
    {"eat less meat", "eat more vegetables", "prevent catch cold", "drink some fruit tea", "practice yoga"};
    private final String[] HEALTHB = 
    {"practice tai chi", "eat a little mutton", "eat a little hazel and pine nut", "drink some licorice tea", "eat less chicken"};
    private final String[] HEALTHC = 
    {"give up smoking", "stop drinking", "prevent the intake of allergenic foods", "take some vitamin C", "have some outdoor activites"};
    

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
        String job = showJob(name, birthMonth, gender);
        String health = showHealth(name, birthMonth, bloodtype);

        String result = "Hi " + name.trim() + ", " + character + "and you will be successful in the job about " + job
                + ". Recently, you need to " + health + ". Good luck!";

        return result;
    }

    public String showCharacter(int birthMonth) {
        return CHARACTER[birthMonth - 1];
    }

    public String showJob(String name, int birthMonth, char gender) {
        int jobindex = name.length();
        int index1 = (birthMonth - 1) % 4;
        String job = "";
        int index2 = jobindex % 3;
        if (gender == 'M') {
            job = JOBM[index1][index2];
        } else {
            job = JOBF[index1][index2];
        }
        return job;
    }

    public String showHealth(String name, int birthMonth, char bloodtype) {
        int healthindex = name.length() + birthMonth;
        int index2 = healthindex % 5;
        String health = "";
        switch (bloodtype) {
            case 'A':
                health = HEALTHA[index2];
                break;
            case 'B':
                health = HEALTHB[index2];
                break;
            case 'O':
                health = HEALTHO[index2];
                break;
            default:
                health = HEALTHC[index2];
                break;
        }
        return health;
    }


}
