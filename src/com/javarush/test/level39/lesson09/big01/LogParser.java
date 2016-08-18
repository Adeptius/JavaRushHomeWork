package com.javarush.test.level39.lesson09.big01;

import com.javarush.test.level39.lesson09.big01.query.IPQuery;

import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.*;

public class LogParser implements IPQuery {

    private Path logDir;
    private SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.ENGLISH);
    private Map<Date, String> uniqueIPsMessage = new TreeMap<>();

    public LogParser(Path logDir) {
        this.logDir = logDir;
    }

    private String getIP(String s) {
        return s.split("\t")[0];
    }

    private String getName(String s) {
        return s.split("\t")[1];
    }

    private String getDate(String s) {
        return s.split("\t")[2];
    }

    private String getEvent(String s) {
        return s.split("\t")[3];
    }

    private String getStatus(String s) {
        return s.split("\t")[4];
    }

    @Override
    public int getNumberOfUniqueIPs(Date after, Date before) {
        return getUniqueIPs(after, before).size();
    }

    private Set<String> createSetMessageToCurrentDate(Date after, Date before) {
        Set<String> setMessageOfCurrentDate = new TreeSet<>();
        for (Map.Entry<Date, String> entry : uniqueIPsMessage.entrySet()) {
            long time = entry.getKey().getTime();
            if ((after == null || after.getTime() <= time) && (before == null || before.getTime() >= time))
                setMessageOfCurrentDate.add(entry.getValue());
        }
        return setMessageOfCurrentDate;
    }

    private Set<String> getStringParameters(Date after, Date before, String typeFilter, String value) {
        Set<String> set = new HashSet<>();
        for (String s : createSetMessageToCurrentDate(after, before)) {
            switch (value) {
                case ("ip"):
                    if (typeFilter == null || s.contains(typeFilter))
                        set.add(getIP(s));
                    break;
                case ("user"):
                    if (typeFilter == null || s.contains(typeFilter))
                        set.add(getName(s));
                    break;
                case ("event"):
                    if (typeFilter == null || s.contains(typeFilter))
                        set.add(getEvent(s).split(" ")[0]);
                    break;
            }
        }
        return set;
    }

    @Override
    public Set<String> getUniqueIPs(Date after, Date before) {
        return getStringParameters(after, before, null, "ip");
    }

    @Override
    public Set<String> getIPsForUser(String user, Date after, Date before) {
        return getStringParameters(after, before, user, "ip");
    }

    @Override
    public Set<String> getIPsForEvent(Event event, Date after, Date before) {
        return getStringParameters(after, before, event.name(), "ip");
    }

    @Override
    public Set<String> getIPsForStatus(Status status, Date after, Date before) {
        return getStringParameters(after, before, status.name(), "ip");
    }
}
