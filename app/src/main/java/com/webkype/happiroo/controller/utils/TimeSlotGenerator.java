package com.webkype.happiroo.controller.utils;

import com.webkype.happiroo.model.SelectModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class TimeSlotGenerator {
    private boolean currentDay = true;
    private int bufferMinutes = 15;
    private List<SelectModel> mDateList = new ArrayList<>();
    private List<SelectModel> mTimeSlotList = new ArrayList<>();

    public TimeSlotGenerator() {
    }

    TimeSlotGenerator(int bufferMinutes) {
    }

    public List<SelectModel> getTimeSlot(boolean currentDay) {
        this.currentDay = currentDay;
        setTimeListData();
        return mTimeSlotList;
    }

    public List<SelectModel> getNextSixDays() {
        generateNextSixDays();
        return mDateList;
    }

    private void generateNextSixDays() {
        Calendar start = Calendar.getInstance();
        Calendar end = Calendar.getInstance();
        end.setTime(start.getTime());
        end.set(Calendar.DAY_OF_MONTH,
                Calendar.getInstance().getActualMaximum(Calendar.DAY_OF_MONTH));
        end.add(Calendar.DATE, 7);
        SimpleDateFormat sdf = new SimpleDateFormat("EEE d MMM");

        int i = 0;
        for (Date dt = start.getTime(); !start.after(end); start.add(
                Calendar.DATE, 1), dt = start.getTime()) {
            if (i == 5)
                break;
            mDateList.add(new SelectModel(sdf.format(dt), ""));
            i++;
        }
    }

    private void setTimeListData() {
        Calendar calender = Calendar.getInstance();
        int currentHours = calender.get(Calendar.HOUR_OF_DAY);
        int currentMins = calender.get(Calendar.MINUTE);
        mTimeSlotList.clear();
        if (currentDay == false) {
            mTimeSlotList.add(new SelectModel("7:00 AM - 8:00 AM", ""));
            mTimeSlotList.add(new SelectModel("8:00 AM - 9:00 AM", ""));
            mTimeSlotList.add(new SelectModel("09:00 AM - 10:00 AM", ""));
            mTimeSlotList.add(new SelectModel("10:00 AM - 11:00 AM", ""));
            mTimeSlotList.add(new SelectModel("11:00 AM - 12:00 PM", ""));
            mTimeSlotList.add(new SelectModel("12:00 PM - 01:00 PM", ""));
            mTimeSlotList.add(new SelectModel("01:00 PM - 02:00 PM", ""));
            mTimeSlotList.add(new SelectModel("02:00 PM - 03:00 PM", ""));
            mTimeSlotList.add(new SelectModel("03:00 PM - 04:00 PM", ""));
            mTimeSlotList.add(new SelectModel("04:00 PM - 05:00 PM", ""));
            mTimeSlotList.add(new SelectModel("05:00 PM - 06:00 PM", ""));
            mTimeSlotList.add(new SelectModel("06:00 PM - 07:00 PM", ""));
            mTimeSlotList.add(new SelectModel("07:00 PM - 08:00 PM", ""));
        } else {
            if (currentHours <= 6) {
                if (currentMins < bufferMinutes)
                    mTimeSlotList.add(new SelectModel("7:00 AM - 8:00 AM", ""));
                mTimeSlotList.add(new SelectModel("8:00 AM - 9:00 AM", ""));
                mTimeSlotList.add(new SelectModel("09:00 AM - 10:00 AM", ""));
                mTimeSlotList.add(new SelectModel("10:00 AM - 11:00 AM", ""));
                mTimeSlotList.add(new SelectModel("11:00 AM - 12:00 PM", ""));
                mTimeSlotList.add(new SelectModel("12:00 PM - 01:00 PM", ""));
                mTimeSlotList.add(new SelectModel("01:00 PM - 02:00 PM", ""));
                mTimeSlotList.add(new SelectModel("02:00 PM - 03:00 PM", ""));
                mTimeSlotList.add(new SelectModel("03:00 PM - 04:00 PM", ""));
                mTimeSlotList.add(new SelectModel("04:00 PM - 05:00 PM", ""));
                mTimeSlotList.add(new SelectModel("05:00 PM - 06:00 PM", ""));
                mTimeSlotList.add(new SelectModel("06:00 PM - 07:00 PM", ""));
                mTimeSlotList.add(new SelectModel("07:00 PM - 08:00 PM", ""));

            } else if (currentHours <= 7) {
                if (currentMins < bufferMinutes)
                    mTimeSlotList.add(new SelectModel("8:00 AM - 9:00 AM", ""));
                mTimeSlotList.add(new SelectModel("09:00 AM - 10:00 AM", ""));
                mTimeSlotList.add(new SelectModel("10:00 AM - 11:00 AM", ""));
                mTimeSlotList.add(new SelectModel("11:00 AM - 12:00 PM", ""));
                mTimeSlotList.add(new SelectModel("12:00 PM - 01:00 PM", ""));
                mTimeSlotList.add(new SelectModel("01:00 PM - 02:00 PM", ""));
                mTimeSlotList.add(new SelectModel("02:00 PM - 03:00 PM", ""));
                mTimeSlotList.add(new SelectModel("03:00 PM - 04:00 PM", ""));
                mTimeSlotList.add(new SelectModel("04:00 PM - 05:00 PM", ""));
                mTimeSlotList.add(new SelectModel("05:00 PM - 06:00 PM", ""));
                mTimeSlotList.add(new SelectModel("06:00 PM - 07:00 PM", ""));
                mTimeSlotList.add(new SelectModel("07:00 PM - 08:00 PM", ""));
            } else if (currentHours <= 8) {
                if (currentMins < bufferMinutes)
                    mTimeSlotList.add(new SelectModel("09:00 AM - 10:00 AM", ""));
                mTimeSlotList.add(new SelectModel("10:00 AM - 11:00 AM", ""));
                mTimeSlotList.add(new SelectModel("11:00 AM - 12:00 PM", ""));
                mTimeSlotList.add(new SelectModel("12:00 PM - 01:00 PM", ""));
                mTimeSlotList.add(new SelectModel("01:00 PM - 02:00 PM", ""));
                mTimeSlotList.add(new SelectModel("02:00 PM - 03:00 PM", ""));
                mTimeSlotList.add(new SelectModel("03:00 PM - 04:00 PM", ""));
                mTimeSlotList.add(new SelectModel("04:00 PM - 05:00 PM", ""));
                mTimeSlotList.add(new SelectModel("05:00 PM - 06:00 PM", ""));
                mTimeSlotList.add(new SelectModel("06:00 PM - 07:00 PM", ""));
                mTimeSlotList.add(new SelectModel("07:00 PM - 08:00 PM", ""));
            } else if (currentHours <= 9) {
                if (currentMins < bufferMinutes)
                    mTimeSlotList.add(new SelectModel("10:00 AM - 11:00 AM", ""));
                mTimeSlotList.add(new SelectModel("11:00 AM - 12:00 PM", ""));
                mTimeSlotList.add(new SelectModel("12:00 PM - 01:00 PM", ""));
                mTimeSlotList.add(new SelectModel("01:00 PM - 02:00 PM", ""));
                mTimeSlotList.add(new SelectModel("02:00 PM - 03:00 PM", ""));
                mTimeSlotList.add(new SelectModel("03:00 PM - 04:00 PM", ""));
                mTimeSlotList.add(new SelectModel("04:00 PM - 05:00 PM", ""));
                mTimeSlotList.add(new SelectModel("05:00 PM - 06:00 PM", ""));
                mTimeSlotList.add(new SelectModel("06:00 PM - 07:00 PM", ""));
                mTimeSlotList.add(new SelectModel("07:00 PM - 08:00 PM", ""));
            } else if (currentHours <= 10) {
                if (currentMins < bufferMinutes)
                    mTimeSlotList.add(new SelectModel("11:00 AM - 12:00 PM", ""));
                mTimeSlotList.add(new SelectModel("12:00 PM - 01:00 PM", ""));
                mTimeSlotList.add(new SelectModel("01:00 PM - 02:00 PM", ""));
                mTimeSlotList.add(new SelectModel("02:00 PM - 03:00 PM", ""));
                mTimeSlotList.add(new SelectModel("03:00 PM - 04:00 PM", ""));
                mTimeSlotList.add(new SelectModel("04:00 PM - 05:00 PM", ""));
                mTimeSlotList.add(new SelectModel("05:00 PM - 06:00 PM", ""));
                mTimeSlotList.add(new SelectModel("06:00 PM - 07:00 PM", ""));
                mTimeSlotList.add(new SelectModel("07:00 PM - 08:00 PM", ""));
            } else if (currentHours <= 11) {
                if (currentMins < bufferMinutes)
                    mTimeSlotList.add(new SelectModel("12:00 PM - 01:00 PM", ""));
                mTimeSlotList.add(new SelectModel("01:00 PM - 02:00 PM", ""));
                mTimeSlotList.add(new SelectModel("02:00 PM - 03:00 PM", ""));
                mTimeSlotList.add(new SelectModel("03:00 PM - 04:00 PM", ""));
                mTimeSlotList.add(new SelectModel("04:00 PM - 05:00 PM", ""));
                mTimeSlotList.add(new SelectModel("05:00 PM - 06:00 PM", ""));
                mTimeSlotList.add(new SelectModel("06:00 PM - 07:00 PM", ""));
                mTimeSlotList.add(new SelectModel("07:00 PM - 08:00 PM", ""));
            } else if (currentHours <= 12) {
                if (currentMins < bufferMinutes)
                    mTimeSlotList.add(new SelectModel("01:00 PM - 02:00 PM", ""));
                mTimeSlotList.add(new SelectModel("02:00 PM - 03:00 PM", ""));
                mTimeSlotList.add(new SelectModel("03:00 PM - 04:00 PM", ""));
                mTimeSlotList.add(new SelectModel("04:00 PM - 05:00 PM", ""));
                mTimeSlotList.add(new SelectModel("05:00 PM - 06:00 PM", ""));
                mTimeSlotList.add(new SelectModel("06:00 PM - 07:00 PM", ""));
                mTimeSlotList.add(new SelectModel("07:00 PM - 08:00 PM", ""));
            } else if (currentHours <= 13) {
                if (currentMins < bufferMinutes)
                    mTimeSlotList.add(new SelectModel("02:00 PM - 03:00 PM", ""));
                mTimeSlotList.add(new SelectModel("03:00 PM - 04:00 PM", ""));
                mTimeSlotList.add(new SelectModel("04:00 PM - 05:00 PM", ""));
                mTimeSlotList.add(new SelectModel("05:00 PM - 06:00 PM", ""));
                mTimeSlotList.add(new SelectModel("06:00 PM - 07:00 PM", ""));
                mTimeSlotList.add(new SelectModel("07:00 PM - 08:00 PM", ""));
            } else if (currentHours <= 14) {
                if (currentMins < bufferMinutes)
                    mTimeSlotList.add(new SelectModel("03:00 PM - 04:00 PM", ""));
                mTimeSlotList.add(new SelectModel("04:00 PM - 05:00 PM", ""));
                mTimeSlotList.add(new SelectModel("05:00 PM - 06:00 PM", ""));
                mTimeSlotList.add(new SelectModel("06:00 PM - 07:00 PM", ""));
                mTimeSlotList.add(new SelectModel("07:00 PM - 08:00 PM", ""));
            } else if (currentHours <= 15) {
                if (currentMins < bufferMinutes)
                    mTimeSlotList.add(new SelectModel("04:00 PM - 05:00 PM", ""));
                mTimeSlotList.add(new SelectModel("05:00 PM - 06:00 PM", ""));
                mTimeSlotList.add(new SelectModel("06:00 PM - 07:00 PM", ""));
                mTimeSlotList.add(new SelectModel("07:00 PM - 08:00 PM", ""));
            } else if (currentHours <= 16) {
                if (currentMins < bufferMinutes)
                    mTimeSlotList.add(new SelectModel("05:00 PM - 06:00 PM", ""));
                mTimeSlotList.add(new SelectModel("06:00 PM - 07:00 PM", ""));
                mTimeSlotList.add(new SelectModel("07:00 PM - 08:00 PM", ""));
            } else if (currentHours <= 17) {
                if (currentMins < bufferMinutes)
                    mTimeSlotList.add(new SelectModel("06:00 PM - 07:00 PM", ""));
                mTimeSlotList.add(new SelectModel("07:00 PM - 08:00 PM", ""));
            } else if (currentHours <= 18) {
                if (currentMins < bufferMinutes)
                    mTimeSlotList.add(new SelectModel("07:00 PM - 08:00 PM", ""));
            } else if (currentHours <= 19) {
                if (currentMins < bufferMinutes)
                    mTimeSlotList.add(new SelectModel("08:00 PM - 09:00 PM", ""));
            }
        }
    }


}
