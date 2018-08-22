package com.nivedita.sunshine.view;

import com.nivedita.sunshine.model.network.LogNetworkError;
import com.nivedita.sunshine.model.pojo.Sunshine;

/**
 * The view which must be implemented by Main Activity.
 */

public interface SunshineView extends MVPView {

    void showDailyForecast(Sunshine sunshine);

    void noWeatherReports();

    void showError(LogNetworkError logNetworkError);

    void showWait();

    void removeWait();

}
