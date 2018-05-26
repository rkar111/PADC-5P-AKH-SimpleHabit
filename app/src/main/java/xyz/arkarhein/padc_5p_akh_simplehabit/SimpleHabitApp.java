package xyz.arkarhein.padc_5p_akh_simplehabit;

import android.app.Application;

import xyz.arkarhein.padc_5p_akh_simplehabit.data.models.SimpleHabitsModel;

public class SimpleHabitApp extends Application {
    public static final String LOG_TAG = "SimpleHabit";

    @Override
    public void onCreate() {
        super.onCreate();
        SimpleHabitsModel.getsObjInstance().loadData();
    }
}
