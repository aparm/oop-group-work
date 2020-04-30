package Worker;

import java.io.*;
import java.util.ArrayList;

public class WorkersList {

    public static ArrayList<Worker> workers = new ArrayList<>();

    public static void addWorker(Worker worker){
        workers.add(worker);
    }

    public static Worker findWorker(String name) {
        for (Worker worker : workers) {
            if (worker.getName().equals(name)) return worker;
        }
        return null;
    }

    //TODO: сохранение и загрузка работников из других классов (записывать и считывать еще одну String и обработать как нужно)

    //сохраняет лист в файл
    public static void saveToFile() {
        try {
            DataOutputStream dos = new DataOutputStream(new FileOutputStream("workers.dat"));

            dos.writeInt(workers.size());

            for (Worker worker : workers) {
                dos.writeUTF(worker.getName());
                dos.writeUTF(worker.getPassword());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //загружает лист из файла
    public static void loadFromFile() {
        try {
            DataInputStream dos = new DataInputStream(new FileInputStream("workers.dat"));

            int n = dos.readInt();

            for (int i = 0; i < n; i++) {
                String name = dos.readUTF();
                String pass = dos.readUTF();
                workers.add(new Worker(name,pass));
            }

        } catch (FileNotFoundException e) {
            System.out.println("Ei ole seda faili");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
