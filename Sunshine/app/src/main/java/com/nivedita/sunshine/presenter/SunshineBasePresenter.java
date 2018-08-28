package com.nivedita.sunshine.presenter;

import com.nivedita.sunshine.di.scope.PerActivity;
import com.nivedita.sunshine.view.MVPView;
import com.nivedita.sunshine.view.SunshineView;

/**
 * Interface to be implemented by sunshine presenter.
 */

@PerActivity
public interface SunshineBasePresenter<T extends SunshineView> extends Presenter<T> {

    void onViewInitialized();
}
