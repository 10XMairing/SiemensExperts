package com.github.tenx.xservices.ui.Function;

import com.github.tenx.xservices.base.BaseViewModel;
import com.github.tenx.xservices.data.AppDataManager;

public class FunctionViewModel extends BaseViewModel implements FunctionViewModelHelper {
    
    private AppDataManager appDataManager;

    private static final String TAG = "FunctionViewModel";
    
    public FunctionViewModel(AppDataManager dataManager) {
        super(dataManager);
        this.appDataManager = dataManager;
    }


    public String getString(){
        return "i am a manuh . Do you understand me??";
    }
    
    
}
