package helper;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DataHelper {
    private static final Faker faker = new Faker();

    public static String getRandomEmail() {
        return faker.letterify("??????????@gmail.com");
    }

    public static String getRandomAlphanumeric(int min, int max) {
        return faker.internet().password(min, max);
    }

    public static String getRandomNumberic(int number) {
        return faker.number().digits(number);
    }

    public static String getDateFromToday(int numberOfDays, String dateFormat) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, numberOfDays);
        Date resultDate = calendar.getTime();
        return simpleDateFormat.format(resultDate);
    }
}