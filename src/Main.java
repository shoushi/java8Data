import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;

public class Main {

    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        System.out.println("Today`s Local date : " + today);
        System.out.println("当前年：" + today.getYear());
        System.out.println("当前月：" + today.getMonth());

        LocalDate myBrithday = LocalDate.of(1996, 2, 5);
        System.out.println("myBrithday :" + myBrithday);

        //检查时间是否相等
        LocalDate date1 = LocalDate.of(2018, 7, 3);
        if (today.equals(date1)) {
            System.out.printf("Today %s and date1 %s is the same date \n", today, myBrithday);
        }



        //判断今天是否是生日
        MonthDay brithDay = MonthDay.of(myBrithday.getMonth(), myBrithday.getDayOfMonth());
        MonthDay currentMonthDay = MonthDay.from(today);
        if (brithDay.equals(currentMonthDay)) {
            System.out.println("Happy Birthday!");
        } else {
            System.out.println("Also Happy Day for you!");
        }

        //获取当前时间time
        LocalTime localTime = LocalTime.now();
        System.out.println("当前时间：" + localTime);
        System.out.println("当前日期时间：" + LocalDateTime.now());

        //增加时间
        System.out.println("当前时间：" + localTime);
        System.out.println("增加2小时后：" + localTime.plusHours(2));
        //error，由于localTime精确到hh：mm：ss,增加的ChronoUnit.WEEKS只精确到day，所以会报错。
        //System.out.println("增加1周后："+localTime.plus(1, ChronoUnit.WEEKS));
        //success
        System.out.println("增加1周后：" + today.plus(1, ChronoUnit.WEEKS));
        //success
        System.out.println("减少1周后：" + today.minus(1, ChronoUnit.WEEKS));

        //判断某个日期在另一日期前或者后
        LocalDate tomorrow = LocalDate.of(2024, 1, 15);
        if(tomorrow.isAfter(today)){
            System.out.println("Tomorrow comes after today");
        }
        LocalDate yesterday = today.minus(1, ChronoUnit.DAYS);
        if(yesterday.isBefore(today)){
            System.out.println("Yesterday is day before today");
        }

        //返回月天数
        YearMonth yearMonth=YearMonth.of(2018,Month.FEBRUARY);
        System.out.println(yearMonth.lengthOfMonth());

        //判断是否为闰年
        System.out.println(Year.of(4028).isLeap());
        if(today.isLeapYear()){
            System.out.println("This year is Leap year");
        }else {
            System.out.println(today.getYear()+" is not a Leap year");
        }

        //两个日期之间包含多少天，多少个月
        Period period=Period.between(myBrithday,today);
        System.out.printf("你已经走过了%d年\n",period.getYears());

        //带时区偏移量的日期与时间
        ZoneOffset zoneOffset=ZoneOffset.of("+05:30");
        OffsetDateTime date = OffsetDateTime.of(LocalDateTime.now(), zoneOffset);
        System.out.println("Date and Time with timezone offset in Java : " + date);

        //当前时间戳
        System.out.println(Instant.now());

        //使用预定义的格式器来对日期进行解析/格式化
        LocalDate localDate= LocalDate.parse("20180506",DateTimeFormatter.BASIC_ISO_DATE);
        System.out.printf("Date generated from String %s is %s %n", "20180506", localDate);

        //自定格式
        String goodFriday = "2014年05月16日 12:15:16";
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日 hh:mm:ss");
            LocalDate holiday = LocalDate.parse(goodFriday, formatter);
            System.out.printf("Successfully parsed String %s, date is %s%n", goodFriday, holiday);
        } catch (DateTimeParseException ex) {
            System.out.printf("%s is not parsable!%n", goodFriday);
            ex.printStackTrace();
        }

        //时间格式转化为string
        //testgit
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");
        String dataTime=LocalDateTime.now().format(formatter);
        System.out.println(dataTime);
    }
}
