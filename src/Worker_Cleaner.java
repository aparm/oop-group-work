//import java.util.ArrayList;
//import java.util.Date;

public class Worker_Cleaner extends  Worker{
    public Worker_Cleaner(String name, String password) {
        super(name, password);
    }

    @Override
    public String toString() {
        return "Koristaja{" + getName() + "}";
    }

    /*
    @Override
    public ArrayList<Date> getWorkingTime() {
        return super.getWorkingTime();
    }

     */

}
