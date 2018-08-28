package com.nivedita.sunshine.view;

import com.nivedita.sunshine.model.network.LogNetworkError;
import com.nivedita.sunshine.model.pojo.WeatherList;

import java.util.List;

/**
 * Basic MVPView to be extended by any activity or Fragment.
 */

public interface MVPView {
    void showError(LogNetworkError logNetworkError);

    void showWait();

    void removeWait();
}
