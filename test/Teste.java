
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import static java.time.temporal.TemporalAdjusters.previousOrSame;
import static java.time.temporal.TemporalAdjusters.nextOrSame;

/**
 * @author jonascosta
 * @date 30/10/2017
 *
 */
public class Teste {

    public static void main(String[] args) {

        LocalDate now = LocalDate.now();
        LocalDate first = now.with(previousOrSame(DayOfWeek.MONDAY));
        LocalDate last = now.with(nextOrSame(DayOfWeek.SUNDAY));

        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        

        System.out.println("P: " + first.format(formatters));
        System.out.println("P: " + last.format(formatters));

    }

}
