package test.spring;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by trympyrym on 11.01.17.
 */
public class Database {
    private static Integer nextKey = 0;
    private Map<String, DatabaseRecord> data = Collections.synchronizedMap(new HashMap<String, DatabaseRecord>());
    public synchronized void add(DatabaseRecord record)
    {
        data.put(Database.nextKey.toString(), record);
        Database.nextKey++;
    }

    public void remove(String index)
    {
        data.remove(index);
    }

    public void changeDoneMark(String index)
    {
        data.get(index).changeDoneMark();
    }

    public String getName(String index)
    {
        return data.get(index).getName();
    }

    public void setName(String index, String newName)
    {
        data.get(index).setName(newName);
    }

    public Map<String, DatabaseRecord> getAll()
    {
        return data;
    }
}
