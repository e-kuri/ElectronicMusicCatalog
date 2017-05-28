package com.example.admin.emc.presentation.presenter.IPresenter;

import com.example.admin.emc.data.model.DJ;
import com.example.admin.emc.domain.callback.IDJListCallback;

/**
 * Created by admin on 8/12/2016.
 */
public interface DetailContract{

    interface View {
        void setData(DJ dj);
    }

    interface UserActionListener{
        void getDjByUsername(String key);
    }

}
