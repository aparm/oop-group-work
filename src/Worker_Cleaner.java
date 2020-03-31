import java.util.ArrayList;
import java.util.Date;

public class Worker_Cleaner extends  Worker{
    public Worker_Cleaner(String name, String password, String type) {
        super(name, password, type);
    }

    @Override
    public String toString() {
        return "Cleaner{" + getName() + "; " + getType() + "; " + getWorkingTime() + "}";
    }

    @Override
    public ArrayList<Date> getWorkingTime() {
        return super.getWorkingTime();
    }

}
