package model;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;

public class Player implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String name;
    private char[] password;
    private final ArrayList<String> arrayHistory = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char[] getPassword() {
        return password;
    }

    public void setPassword(char[] password) {
        this.password = password;
    }

    public void setHistory(String history) {
        arrayHistory.add(history);
    }

    public String getHistory() {
        return arrayHistory.get(0);
    }

    public ArrayList<String> getAllHistory() {
        return arrayHistory;
    }
}