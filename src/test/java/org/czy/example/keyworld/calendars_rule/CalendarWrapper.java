package org.czy.example.keyworld.calendars_rule;

import org.kie.api.time.Calendar;
import org.quartz.impl.calendar.WeeklyCalendar;

/**
 * @author chenzhiyuan
 * @date 2019/5/28
 * @Description
 */
public class CalendarWrapper implements Calendar {

    private WeeklyCalendar cal;

    public CalendarWrapper(WeeklyCalendar cal) {
        this.cal = cal;
    }
    @Override
    public boolean isTimeIncluded(long l) {
        return cal.isTimeIncluded(l);
    }

    public WeeklyCalendar getCal() {
        return cal;
    }

    public void setCal(WeeklyCalendar cal) {
        this.cal = cal;
    }

}
