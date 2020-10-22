package ru.netcracker.tasks.DataWorker;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Необходимо реализовать класс для работы с датами и следующим функционалом
 */
public interface IDataWorker {

    /**
     * Определяет високосный год или нет
     * @param year
     * @return если год високосный возвращает true
     */
    public boolean isLeapYear(int year);

    /**
     * Осуществаляет проверку даты на корректность
     * @param year,month,day
     * @return если дата корректна true
     */
    public boolean isValidDate(int year, int month, int day);

    /**
     * Номер дня недели где 0-MON 6-SUN
     * @param year,month,day
     * @return номер
     */
    public int getDayOfWeek(int year, int month, int day);

    /**
     * Приводит дату к красивому виду : Tuesday 14 Feb 2012
     * @param year,month,day
     * @return дату в виде строки
     */
    public String toString(int year, int month, int day);

    /**
     * Вычисляет сколько дней прошло с введенной даты по сегодняшнюю
     * @param year,month,day
     * @return количество дней
     */
    public int countDays(int year, int month, int day);


    public class Date{
        private int day;
        private int month;
        private int year;

        public Date(){
            year = 1;
            month = 1;
            day = 1970;

        }
        public Date(int year, int month, int day){
            this.year = year;
            this.month = month;
            this.day = day;
        }

        public int getYear() {
            return year;
        }
        public int getMonth() {
            return month;
        }
        public int getDay() {
            return day;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public void setMonth(int month) {
            this.month = month;
        }

        public void setDay(int day) {
            this.day = day;
        }

        @Override
        public String toString() {
            String date = year + "-" + month + "-" +day;
           if (day < 10 || month < 10) {
               if (day < 10) {
                   date = year + "-" + month + "-" + "0" + day;
               }
               if (month < 10){
                  date = year + "-" + "0"+month + "-" +day;
               }
               if (day < 10 && month < 10){
                   date = year +"-"+"0"+month+"-"+"0" + day;
               }

           }
               return date;

        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Date date = (Date) o;

            if (date.day == day && date.month == month && date.year == year) {
                return true;
            }
            return false;

        }

        @Override
        public int hashCode() {
            int result = day;
            result = 31 * result + month;
            result = 31 * result + year;
            return result;
        }
    }
}
