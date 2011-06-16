/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package una.pa.util;

import java.sql.Date;
import java.text.ParseException;
import java.util.Calendar;
import java.sql.Timestamp;
import java.util.Locale;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


/**
 *
 * @author Dirceu
 * @ajuda Stefano
 */
public class DateTime implements Comparable{

    private long millis = 0;
    private Locale locale = new Locale("pt", "BR");

    public DateTime(String date, String format) throws ParseException{
        DateFormat fmt = new SimpleDateFormat(format);
        this.millis = fmt.parse(date).getTime();
    }

    public DateTime(int year, int month, int day) throws ParseException{
        String date = day + "/" + month + "/" + year;
        String format = "dd/MM/yyyy";
        DateFormat fmt = new SimpleDateFormat(format);
        this.millis = fmt.parse(date).getTime();
    }

    public DateTime(long millis){
        this.millis = millis;
    }

    public DateTime(Timestamp value){
        if(value != null){
            this.millis = value.getTime();
        }else{
            this.millis = 0;
        }
    }

    public DateTime(Date value){
        if(value != null){
            this.millis = value.getTime();
        }else{
            this.millis = 0;
        }
    }

    public static DateTime now(){
        Calendar c = Calendar.getInstance();
        return new DateTime(c.getTimeInMillis());
    }

    public Date getDate(){
        if(this.millis != 0){
            return new Date(this.millis);
        }else{
            return null;
        }
    }

    public void setMillis(long millis) {
        this.millis = millis;
    }

    public long getMillis(){
        return this.millis;
    }

    public Timestamp getTimestamp(){
        if(this.millis != 0){
            return new Timestamp(this.millis);
        }else{
            return null;
        }
    }

    public String toString(String format){
        if(this.millis != 0){
            DateFormat fmt = new SimpleDateFormat(format, locale);
            return fmt.format(getTimestamp());
        }else{
            return "";
        }
    }

    public String getWeekDay(){
        return this.toString("EEEE");
    }

    public int getDay(){
        return Integer.parseInt(this.toString("dd"));
    }

    public int getMonth(){
        return Integer.parseInt(this.toString("MM"));
    }

    public int getYear(){
        return Integer.parseInt(this.toString("yyyy"));
    }

    public int getHour(){
        return Integer.parseInt(this.toString("HH"));
    }

    public int getMinute(){
        return Integer.parseInt(this.toString("mm"));
    }

    public int getSecond(){
        return Integer.parseInt(this.toString("ss"));
    }

    public void addSecond(long v){
        this.millis += v * 1000;
    }

    public void addMinute(long v){
        addSecond(v * 60);
    }

    public void addHour(long v){
        addMinute(v * 60);
    }

    public void addDay(long v){
        addHour(v * 24);
    }

    public void addMonth(int v){
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(this.millis);
        c.add(Calendar.MONTH, v);
        this.millis = c.getTimeInMillis();
    }

    public void addYear(int v){
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(this.millis);
        c.add(Calendar.YEAR, v);
        this.millis = c.getTimeInMillis();
    }

    public void addDateTime(DateTime v){
        this.millis += v.getMillis();
    }

    public int compareTo(Object o) {
        DateTime d = (DateTime)o;
        if(this.millis == d.getMillis()){
            return 0;
        }else if(this.millis > d.getMillis()){
            return 1;
        }else{
            return -1;
        }
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

}
