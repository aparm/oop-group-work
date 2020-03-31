//Позже станет суперклассом для классов разных должностей

import java.util.ArrayList;
import java.util.Date;

public class Worker {
    private String name;
    private String password;
    //private String hierarchy;

    private ArrayList<Date> workingTime; //для учета времени работы, опозданий и тд
    // 0, 2, 4... - начало работы
    // 1, 3, 5... - конец работы


    public Worker(String name, String password) { //String hierarchy
        this.name = name;
        this.password = password;
        //this.hierarchy = hierarchy;
    }

    public String getName() {
        return name;
    }

    /*
    public String getHierarchy() {
        return hierarchy;
    }

    public void setHierarchy(String hierarchy) {
        this.hierarchy = hierarchy;
    }

     */

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Date> getWorkingTime() {
        return workingTime;
    }


    public void startWork() {
        if (workingTime.size() % 2 == 0) {
            workingTime.add(new Date());
        }
        else {
            workingTime.add(workingTime.get(workingTime.size()-1)); //добавляем такой же элемент
            workingTime.add(new Date());
            System.out.println("Ошибка со временем работы - начало");
        }
    }

    public void endWork() {
        if (workingTime.size() % 2 == 1) {
            workingTime.add(new Date());
        }
        else {
            workingTime.add(new Date());
            workingTime.add(new Date());
            System.out.println("Ошибка со временем работы - конец");
        }
    }
    @Override
    public String toString() {
        return "Worker{" +
                "name='" + name + '\'' +
                ", workingTime=" + workingTime +
                '}';
    }
}
