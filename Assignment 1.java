\\Task no 1:-
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class DateDifferenceCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the first date (yyyy-MM-dd):");
        String firstDateString = scanner.nextLine();

        System.out.println("Enter the second date (yyyy-MM-dd):");
        String secondDateString = scanner.nextLine();

        LocalDate firstDate = LocalDate.parse(firstDateString, DateTimeFormatter.ISO_DATE);
        LocalDate secondDate = LocalDate.parse(secondDateString, DateTimeFormatter.ISO_DATE);

        long differenceInDays = ChronoUnit.DAYS.between(firstDate, secondDate);

        System.out.println("Difference in days: " + Math.abs(differenceInDays));
    }
}
\\Task no 2:-
import java.util.Scanner;
import java.time.LocalDate;
import java.time.Period;

public class AgeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your birth date (YYYY-MM-DD):");
        String birthDateString = scanner.nextLine();

        LocalDate birthDate = LocalDate.parse(birthDateString);
        LocalDate currentDate = LocalDate.now();

        Period period = Period.between(birthDate, currentDate);

        int age = period.getYears();

        System.out.println("You are " + age + " years old.");
        
        scanner.close();
    }
}
\\Task no 3:-
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.time.format.DateTimeParseException;

public class DateParsing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a date string in the format yyyy-MM-dd:");
        String dateString = scanner.nextLine();

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        try {
            LocalDate date = LocalDate.parse(dateString, dateFormatter);

            System.out.println("Parsed date: " + date);
        } catch (DateTimeParseException e) {
            System.out.println("Error: Invalid date format. Please enter a date in the format yyyy-MM-dd.");
        } finally {
            scanner.close();
        }
    }
}
Task no 4:-
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class EventDurationCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        System.out.println("Enter the start time of the event (yyyy-MM-dd HH:mm):");
        String startDateTimeString = scanner.nextLine();

        System.out.println("Enter the end time of the event (yyyy-MM-dd HH:mm):");
        String endDateTimeString = scanner.nextLine();

        try {
            LocalDateTime startDateTime = LocalDateTime.parse(startDateTimeString, dateTimeFormatter);
            LocalDateTime endDateTime = LocalDateTime.parse(endDateTimeString, dateTimeFormatter);

            Duration duration = Duration.between(startDateTime, endDateTime);

            long hours = duration.toHours();
            long minutes = duration.toMinutes() % 60;

            System.out.println("Duration of the event: " + hours + " hours and " + minutes + " minutes.");
        } catch (Exception e) {
            System.out.println("Error: Invalid date-time format. Please enter date-time in the format yyyy-MM-dd HH:mm.");
        } finally {
            scanner.close();
        }
    }
}
\\Task no 5:-
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TimeZoneConversion {
    public static void main(String[] args) 
        Scanner scanner = new Scanner(System.in);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        try {
            System.out.println("Enter the date and time (yyyy-MM-dd HH:mm):");
            String dateTimeString = scanner.nextLine();

            System.out.println("Enter the source time zone (e.g., UTC):");
            String sourceTimeZoneString = scanner.nextLine();

            System.out.println("Enter the target time zone (e.g., America/Los_Angeles):");
            String targetTimeZoneString = scanner.nextLine();

            LocalDateTime localDateTime = LocalDateTime.parse(dateTimeString, dateTimeFormatter);

            ZoneId sourceTimeZone = ZoneId.of(sourceTimeZoneString);
            ZonedDateTime sourceZonedDateTime = ZonedDateTime.of(localDateTime, sourceTimeZone);

            ZoneId targetTimeZone = ZoneId.of(targetTimeZoneString);
            ZonedDateTime targetZonedDateTime = sourceZonedDateTime.withZoneSameInstant(targetTimeZone);

            System.out.println("Converted date and time: " + targetZonedDateTime.format(dateTimeFormatter));
        } catch (Exception e) {
            System.out.println("Error: Invalid input or time zone.");
        } finally {
            scanner.close();
        }
    }
}
\\Task no 6:-
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class ReminderSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter the date and time for the reminder (yyyy-MM-dd HH:mm):");
            String dateTimeString = scanner.nextLine();

            System.out.println("Enter the reminder message:");
            String reminderMessage = scanner.nextLine();

            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

            LocalDateTime reminderDateTime = LocalDateTime.parse(dateTimeString, dateTimeFormatter);

            Timer timer = new Timer();

            timer.schedule(new ReminderTask(reminderMessage), java.sql.Timestamp.valueOf(reminderDateTime));

            System.out.println("Reminder scheduled successfully!");
        } catch (Exception e)
            System.out.println("Error: Invalid input.");
        } finally {
            scanner.close();
        }
    }

    static class ReminderTask extends TimerTask {
        private String message;

        public ReminderTask(String message) {
            this.message = message;
        }

        @Override
        public void run() {
            System.out.println("Reminder: " + message);
        }
    }
}
\\Task no 7:-
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DateTimeValidation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter the date and time (yyyy-MM-dd HH:mm):");
            String dateTimeString = scanner.nextLine();

            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

            LocalDateTime dateTime = LocalDateTime.parse(dateTimeString, dateTimeFormatter);

            if (isValidDateTime(dateTime)) {
                System.out.println("Valid date and time.");
            } else {
                System.out.println("Invalid date and time.");
            }
        } catch (Exception e) {
            System.out.println("Error: Invalid input or date-time format.");
        } finally {
            scanner.close();
        }
    }

    public static boolean isValidDateTime(LocalDateTime dateTime) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        if (dateTime.isBefore(currentDateTime)) {
            return false;
       }
        return true;
    }
}
\\Task no 8:-
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HolidayCalendar {
    public static void main(String[] args) {
        Map<String, String> holidays = new HashMap<>();
        holidays.put("New Year's Day", "01-01");
        holidays.put("Valentine's Day", "02-14");
        holidays.put("Independence Day", "07-04");
        holidays.put("Christmas", "12-25");

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Enter the year:");
            int year = scanner.nextInt();

            System.out.println("Holidays in " + year + ":");

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd");

            for (Map.Entry<String, String> entry : holidays.entrySet()) {
                String holidayName = entry.getKey();
                String holidayDate = entry.getValue();
                LocalDate holiday = LocalDate.parse(year + "-" + holidayDate, formatter);

                if (holiday.getYear() == year) {
                    System.out.println(holidayName + ": " + holiday.format(DateTimeFormatter.ofPattern("MMMM d")));
                }
            }
        } catch (Exception e) {
            System.out.println("Error: Invalid input.");
        } finally {
            scanner.close();
        }
    }
}
