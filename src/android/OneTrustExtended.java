package com.outsystems.experts.OutsystemsPluginOneTrust;
import com.onetrust.cordova.OneTrust;
import com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK;

import android.content.Intent;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPreferences;
import org.apache.cordova.CordovaWebView;
import org.json.JSONArray;
import org.json.JSONException;


public class OneTrustExtended extends OneTrust {
    OTPublishersHeadlessSDK ot;



    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
        ot = new OTPublishersHeadlessSDK(cordova.getContext());
    }
    private void startCMPActivity(int uiType){
        Intent intent = new Intent(cordova.getContext(), CMPActivityExtended.class);
        intent.putExtra("UIType", uiType);
        CordovaPreferences prefs = webView.getPreferences();
        String fontFile=prefs.getString("customfontfile","");
        intent.putExtra("CustomFontFile",fontFile);
        this.cordova.startActivityForResult(this, intent, 1);
    }
    private void showBannerUI(){
        if(ot.getBannerData()!=null){ //null check prevents starting blank activity if no banner data present
            startCMPActivity(0);
        }
    }

    private void showPreferenceCenterUI(){
        if(ot.getPreferenceCenterData() != null){ ////null check prevents starting blank activity if no PC data present
            startCMPActivity(1);
        }
    }

    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        switch (action){

            case "showBannerUI":
                showBannerUI();
                return true;
            case "showPreferenceCenterUI":
                showPreferenceCenterUI();
                return true;
        }
        return false;
    }
}

