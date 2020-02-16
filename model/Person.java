import java.util.ArrayList;

public class Person {

	private String name, hetu;
    private int sex, age;
    private ArrayList<Object> personalItems;

	
	public Person(String name, int sex, String hetu){
        this.name = name;
        this.sex = sex;
        this.hetu = hetu;
	}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getHetu() {
        return hetu;
    }

    public void setHetu(String hetu) {
        this.hetu = hetu;
    }
}