import java.util.Calendar;

public class todayDate {

    int tyear;
    int tmonth;
    int tday;

    public todayDate (Calendar c){
        tyear = c.get(Calendar.YEAR);
        tmonth = c.get(Calendar.MONTH)+1;
        tday = c.get(Calendar.DAY_OF_MONTH);
    }
}
