package test.spring;

/**
 * Created by trympyrym on 04.01.17.
 */
public class DatabaseRecord {

    private static int currentMaxIndex;
    static
    {
        currentMaxIndex = 0;
    }
    private String name;
    private boolean done;

    public int getIndex() {
        return index;
    }

    public void changeDoneMark()
    {
        this.done = !this.done;
    }

    private int index;

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
        DatabaseRecord.currentMaxIndex++;
        initialize(name, false);
    }

    private void initialize(String name, boolean done)
    {
        this.name = name;
        this.done = done;
        this.index = DatabaseRecord.currentMaxIndex;
    }
}
