package pac;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.annotation.PostConstruct;

@Named(value = "controller")
@SessionScoped
public class Controller implements Serializable {

    private String name;
    private char gender;
    private char bloodtype;
    private int birthMonth;

    private String result;
    private FortuneTeller fortuneTeller;

    /**
     * Creates a new instance of Controller
     */
    public Controller() {
    }

    @PostConstruct
    public void init() {
        fortuneTeller = FortuneTeller.getInstance();
    }

    public void showFortune() {
        result = fortuneTeller.tellFortune(name, gender, bloodtype, birthMonth);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public char getBloodtype() {
        return bloodtype;
    }

    public void setBloodtype(char bloodtype) {
        this.bloodtype = bloodtype;
    }

    public int getBirthMonth() {
        return birthMonth;
    }

    public void setBirthMonth(int birthMonth) {
        this.birthMonth = birthMonth;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

}
