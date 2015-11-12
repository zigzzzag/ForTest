package com.mnikiforov.core.datetest.early_dates_test;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.apache.commons.lang.builder.StandardToStringStyle;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by SBT-Nikiforov-MO on 17.08.2015.
 */
public class DatesSerializable implements Serializable {

    private static final long serialVersionUID = -6251700725621457901L;

    private Date today;
    private Date before_26_10_2014;
    private Date now_26_10_2014;
    private Date after_26_10_2014;

    public DatesSerializable() {
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.reflectionToString(this, new StandardToStringStyle());
    }

    public Date getToday() {
        return today;
    }

    public void setToday(Date today) {
        this.today = today;
    }

    public Date getBefore_26_10_2014() {
        return before_26_10_2014;
    }

    public void setBefore_26_10_2014(Date before_26_10_2014) {
        this.before_26_10_2014 = before_26_10_2014;
    }

    public Date getNow_26_10_2014() {
        return now_26_10_2014;
    }

    public void setNow_26_10_2014(Date now_26_10_2014) {
        this.now_26_10_2014 = now_26_10_2014;
    }

    public Date getAfter_26_10_2014() {
        return after_26_10_2014;
    }

    public void setAfter_26_10_2014(Date after_26_10_2014) {
        this.after_26_10_2014 = after_26_10_2014;
    }
}
