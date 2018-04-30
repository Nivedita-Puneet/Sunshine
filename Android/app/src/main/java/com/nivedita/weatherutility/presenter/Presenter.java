package com.nivedita.weatherutility.presenter;

import com.nivedita.weatherutility.view.MVPView;

public interface Presenter<V extends MVPView> {

    void attachView(V mvpView);

    void detachView();

}
