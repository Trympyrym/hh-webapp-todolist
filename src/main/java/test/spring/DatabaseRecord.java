package test.spring;

/**
 * Created by trympyrym on 04.01.17.
 */
public class DatabaseRecord {

    private String name;
    private boolean done;


    public void changeDoneMark()
    {
        this.done = !this.done;
    }



    public String getName() {
        return this.name;
    }

    public void setName(String newName)
    {
        this.name = newName;
    }

    public boolean isDone() {
        return this.done;
    }

    public DatabaseRecord(String name) {
        initialize(name, false);
    }

    private void initialize(String name, boolean done)
    {
        this.name = name;
        this.done = done;
    }
}
