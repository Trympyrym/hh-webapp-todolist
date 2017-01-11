package test.spring;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by trympyrym on 11.01.17.
 */
public class Database {
    private List<DatabaseRecord> data = Collections.synchronizedList(new ArrayList<>());
    public void add(DatabaseRecord record)
    {
        data.add(record);
    }

    public void remove(Integer index)
    {

        for (DatabaseRecord task: data)
        {
            if (task.getIndex() == index)
            {
                data.remove(task);
                break;
            }
        }
    }

    public void changeDoneMark(Integer index)
    {

        for (DatabaseRecord task: data)
        {
            if (task.getIndex() == index)
            {
                task.changeDoneMark();
                break;
            }
        }
    }


    public List<DatabaseRecord> getAll()
    {
        return data;
    }
}
