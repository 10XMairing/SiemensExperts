package com.github.tenx.xservices.ui.business.main;

import com.github.tenx.xservices.base.BaseViewModel;
import com.github.tenx.xservices.data.AppDataManager;

public class BusinessMainViewModel extends BaseViewModel implements BusinessMainViewModelHelper {


    private AppDataManager appDataManager;

    public BusinessMainViewModel(AppDataManager appDataManager) {
        super(appDataManager);
        this.appDataManager = appDataManager;
    }

    public String getString(){
        return "i am a manuh . Do you understand me??";
    }


}
