package ru.netcracker.tasks.DataWorker;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


public class IDataWorkerImpl implements IDataWorker {
    @Override
    public boolean isLeapYear(int year) {
        if(year % 400 == 0 || year % 100 == 0 || year % 4 == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isValidDate(int year, int month, int day) {
        boolean valid = true;
        if(day <= 31 && month <=12 && month > 0 && year >=0){
            if((month == 4 || month == 6 || month == 9 || month == 11) && day > 30){
                valid = false;
            }
            if (month == 2){
                if ((year % 400 == 0 || year % 100 == 0 || year % 4 == 0) && day > 28){
                    valid = false;
                } else if(day > 29){
                    valid = false;
                }
            }
        }
        return valid;
    }

    @Override
    public int getDayOfWeek(int year, int month, int day) {
        int day_of_week =0;
        int temp = (((day + (((month + 1) * 26) / 10) + year + (year / 4) + (6 * (year / 100)) + (year / 400)) - 1) % 7);
        switch (temp){
            case 0 : day_of_week = 6;break;

            case 1 : day_of_week = 0;  break;
            case 2 : day_of_week = 1;  break;
            case 3 : day_of_week = 2;  break;
            case 4 : day_of_week = 3;  break;
            case 5 : day_of_week = 4;  break;
            case 6 : day_of_week = 5;  break;
        }
        return day_of_week;
    }

    @Override
    public String toString(int year, int month, int day) {
        String[] days = { "Monday", "Tuesday", "Wednesday", "Thursday", "Friday","Saturday", "Sunday"};
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        return days[getDayOfWeek(year,month,day)] +" "+ day+ " " + months[month-1]+" "+year ;
    }

    @Override
    public int countDays(int year, int month, int day) {
        Date a  = new Date(year,month,day);
        String date = a.toString();
        LocalDate startDate = LocalDate.parse(date);
        LocalDate endDate = LocalDate.now();
        Long count = ChronoUnit.DAYS.between(startDate, endDate);
        return Math.toIntExact(count);

    }
}
