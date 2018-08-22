package com.nivedita.sunshine.presenter;

import com.nivedita.sunshine.view.MVPView;

/**
 * The main presenter to be extended by other presenters
 */

public interface Presenter<V extends MVPView> {

    void attachView(V mvpView);

    void detachView();

}
