package com.github.tenx.xservices.ui.Services;

import com.github.tenx.xservices.base.BaseViewModel;
import com.github.tenx.xservices.data.AppDataManager;

public class ServicesViewModel extends BaseViewModel implements ServicesViewModelHelper {


    private AppDataManager appDataManager;

    private static final String TAG = "ServicesViewModel";


    public ServicesViewModel(AppDataManager dataManager) {

        super(dataManager);
        this.appDataManager = dataManager;
    }


    public String getString(){
        return "i am a manuh . Do you understand Goru??";
    }

}
