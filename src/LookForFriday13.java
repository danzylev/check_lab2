import java.time.*;

public class LookForFriday13 {
    public static void main(String[] args) throws InterruptedException {

        LocalDate ny = LocalDate.of(2017, Month.DECEMBER, 31);
        LocalTime now = LocalTime.now();
        LocalDate date;
        int i = 0;

        // в цикле можно указать либо while(true), либо любое другое условие. Можно в обоих заданиях проработать склонения
        while (i < 5){
            i++;
            date = LocalDate.now();
            int expMonths = ny.getMonthValue() - date.getMonthValue();
            int expDays = date.getMonth().maxLength() - date.getDayOfMonth();

            now = LocalTime.now();
            System.out.println("До Нового года осталось " + expDays + " дней " + expMonths + " месяцев " +
                    (23 - now.getHour()) + " часов " + (60 - now.getMinute() + " минут и " + (60 - now.getSecond()) + " секунд"));
            Thread.sleep(1000);
        }
        LocalDate today = LocalDate.now();
//        LocalDate firstDay = LocalDate.of(today.getYear(), Month.JANUARY, 01);
        int n = 0;
        for (i = 1; i <= 12; i++){
            if (LocalDate.of(today.getYear(), i, 13).getDayOfWeek() == DayOfWeek.FRIDAY)
                n++;
        }
        System.out.println("В " + today.getYear() + " году пятницу 13е мы встретим " + n + " раз!");
    }
}
