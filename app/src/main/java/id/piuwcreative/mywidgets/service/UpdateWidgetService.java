package id.piuwcreative.mywidgets.service;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.widget.RemoteViews;

import id.piuwcreative.mywidgets.NumberGenerator;
import id.piuwcreative.mywidgets.R;
import id.piuwcreative.mywidgets.widget.RandomNumbersWidget;

public class UpdateWidgetService extends JobService {
    @Override
    public boolean onStartJob(JobParameters jobParameters) {
        AppWidgetManager manager = AppWidgetManager.getInstance(this);
        RemoteViews views = new RemoteViews(getPackageName(), R.layout.random_numbers_widget);
        ComponentName theWidget = new ComponentName(this, RandomNumbersWidget.class);

        String lastUpdate = "Random: " + NumberGenerator.generate(100);
        views.setTextViewText(R.id.appwidget_text, lastUpdate);
        manager.updateAppWidget(theWidget, views);
        jobFinished(jobParameters, false);
        return true;
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }
}
