package JsonObjects;

public class User {
    public User(String name, String job){
        this.name = name;
        this.job = job;
    }

    private String name;
    private String job;


    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }
}
