package test.spring;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by trympyrym on 11.01.17.
 */
public class Database {
    private static Integer nextKey = 0;
    private Map<String, DatabaseRecord> data = new HashMap<>();
    public synchronized void add(DatabaseRecord record)
    {
        data.put(Database.nextKey.toString(), record);
        Database.nextKey++;
    }

    public void remove(String index)
    {
        synchronized (data)
        {
            data.remove(index);
        }
    }

    public void changeDoneMark(String index)
    {
        synchronized (data)
        {
            data.get(index).changeDoneMark();
        }
    }

    public String getName(String index)
    {
        synchronized (data)
        {
            return data.get(index).getName();
        }
    }

    public void setName(String index, String newName)
    {
        synchronized (data)
        {
            data.get(index).setName(newName);
        }
    }

    public Map<String, DatabaseRecord> getAll()
    {

        synchronized (data)
        {
            return data;
        }
    }
}
