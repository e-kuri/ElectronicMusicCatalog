package com.example.admin.emc.domain.service.IService;

import com.example.admin.emc.data.model.DJ;
import com.example.admin.emc.domain.adapter.builder.AdapterListener;
import com.example.admin.emc.domain.callback.IDJDetailCallback;
import com.example.admin.emc.domain.callback.IDJListCallback;

/**
 * Created by admin on 8/17/2016.
 */
public interface IDJService {

    void getDJListAdapter(String genre, final int layout, final AdapterListener listener, final IDJListCallback.DJListCallback callback);
    void getDJByUsername(String username, IDJDetailCallback.DJByUsernamePresenterCallback callback);
}


