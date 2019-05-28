package org.czy.example.keyworld.calendars_rule;

import org.czy.example.util.KieSessionUtil;
import org.junit.Test;
import org.kie.api.runtime.KieSession;
import org.kie.api.time.Calendar;
import org.quartz.impl.calendar.WeeklyCalendar;

/**
 * @author chenzhiyuan
 * @date 2019/5/28
 * @Description
 */
public class CalendarsExample {

    /**
     * 日历可以单独应用于规则中，也可以和timer结合使用在规则中使用。通过属性calendars来定义日历。如果是多个日历，则不同日历之间用逗号进行分割。
     * 在Drools中，日历的概念只是将日历属性所选择的时间映射成布尔值，设置为规则的属性，控制规则的触发。
     * Drools可以通过计算当期日期和时间来决定是否允许规则的触发。此示例首先需要引入quarts框架
     *
     */
    @Test
    public void calendars(){
        KieSession kieSession = KieSessionUtil.getSession("CalendarsRuleKS");

        WeeklyCalendar weekDayCal = new WeeklyCalendar();
        // 默认包含所有的日期都生效
        weekDayCal.setDaysExcluded(new boolean[]{false, false, false, false, false, false, false,false,false});
        //weekDayCal.setDayExcluded(java.util.Calendar.THURSDAY, true); // 设置为true则不包含此天，周四
        Calendar calendar = new CalendarWrapper(weekDayCal);

        kieSession.getCalendars().set("weekday", calendar);

        kieSession.insert(new String("Hello"));
        kieSession.fireAllRules();

        kieSession.dispose();

    }
}
