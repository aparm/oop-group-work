package Worker;

import java.util.ArrayList;

public class WorkersList {

    public static ArrayList<Worker> workers = new ArrayList<>();

    public static void addWorker(){
        workers.add(new Worker_Manager("Volodja", "123"));
        workers.add(new Worker("Afanasij", "1234"));
        workers.add(new Worker_Security("Dmitri", "1234"));
        workers.add(new Worker_Coffeeman("Anatolij", "1234"));
        workers.add(new Worker_Cleaner("Roman", "1234"));
    }

    public static void addWorker(Worker worker){
        workers.add(worker);
    }

    //сохраняет лист в файл
    public static void saveToFile() {

    }

    //загружает лист из файла
    public static void loadFromFile() {

    }
}
