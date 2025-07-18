import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.TextStyle;
import java.util.Locale;

public class CalendarApp {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        int year = today.getYear();
        int month = today.getMonthValue();

        String monthName = today.getMonth().getDisplayName(TextStyle.FULL, Locale.getDefault());
        System.out.println("📅 " + monthName + " " + year);
        System.out.println("-----------------------------");

        String[] days = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        for (String day : days) {
            System.out.printf("%4s", day);
        }
        System.out.println();

        YearMonth yearMonth = YearMonth.of(year, month);
        int daysInMonth = yearMonth.lengthOfMonth();
        LocalDate firstDay = yearMonth.atDay(1);
        int startDayOfWeek = firstDay.getDayOfWeek().getValue(); // 1 (Mon) to 7 (Sun)
        int offset = startDayOfWeek % 7;

        for (int i = 0; i < offset; i++) {
            System.out.printf("%4s", "");
        }

        for (int day = 1; day <= daysInMonth; day++) {
            if (day == today.getDayOfMonth()) {
                System.out.printf("%3s*", day);
            } else {
                System.out.printf("%4d", day);
            }

            if ((day + offset) % 7 == 0) {
                System.out.println();
            }
        }

        System.out.println("\n\n[*] = Today");
    }
}
