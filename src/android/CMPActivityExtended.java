package com.outsystems.experts.OutsystemsPluginOneTrust;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Window;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import com.onetrust.otpublishers.headless.Public.DataModel.OTConfiguration;
import com.onetrust.otpublishers.headless.Public.OTEventListener;
import com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK;
import com.onetrust.otpublishers.headless.Public.OTUIDisplayReason.OTUIDisplayReason;

/**
 * This class echoes a string called from JavaScript.
 */
public class CMPActivityExtended extends AppCompatActivity  {
    OTPublishersHeadlessSDK ot;
    Integer layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        layout = this.getResources().getIdentifier("activity_c_m_p","layout", getPackageName());
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(layout);

        try {
            this.getWindow().getDecorView().setBackgroundColor(Color.TRANSPARENT);
        } catch (Exception e) {
            e.printStackTrace();
        }

        ot = new OTPublishersHeadlessSDK(this);
        OTConfiguration config = getOTConfiguration(this);
        addEventListeners();

        switch (this.getIntent().getIntExtra("UIType",-1)){
            case 0:
                ot.showBannerUI(this,config);
                break;
            case 1:
                ot.showPreferenceCenterUI(this,config);
                break;
            default:
                endActivity();
        }
    }

    private void endActivity(){
        setResult(RESULT_OK, this.getIntent());
        CMPActivityExtended.super.finish();
    }

    private void addEventListeners(){
        String emptyPayload = "{}";
        ot.addEventListener(new OTEventListener() {
            @Override
            public void onShowBanner(OTUIDisplayReason otuiDisplayReason) {

            }

            @Override
            public void onHideBanner() {

            }

            @Override
            public void onBannerClickedAcceptAll() {

            }

            @Override
            public void onBannerClickedRejectAll() {

            }

            @Override
            public void onShowPreferenceCenter(OTUIDisplayReason otuiDisplayReason) {

            }

            @Override
            public void onHidePreferenceCenter() {

            }

            @Override
            public void onPreferenceCenterAcceptAll() {

            }

            @Override
            public void onPreferenceCenterRejectAll() {

            }

            @Override
            public void onPreferenceCenterConfirmChoices() {

            }

            @Override
            public void onShowVendorList() {

            }

            @Override
            public void onHideVendorList() {

            }

            @Override
            public void onVendorConfirmChoices() {

            }

            @Override
            public void onVendorListVendorConsentChanged(String s, int i) {

            }

            @Override
            public void onVendorListVendorLegitimateInterestChanged(String s, int i) {

            }

            @Override
            public void onPreferenceCenterPurposeConsentChanged(String s, int i) {

            }

            @Override
            public void onPreferenceCenterPurposeLegitimateInterestChanged(String s, int i) {

            }

            @Override
            public void allSDKViewsDismissed(String interactionType){
                endActivity();
            }
        });
    }
    public OTConfiguration getOTConfiguration(@NonNull Context context) {
        int resourceID=context.getResources().getIdentifier("comic_neue_regular","font",getPackageName());
        Typeface otGenericTypeFace = null;
        if(resourceID!=0) {
            otGenericTypeFace = ResourcesCompat.getFont(context, resourceID);
        }
        OTConfiguration.OTConfigurationBuilder otConfigurationBuilder = OTConfiguration.OTConfigurationBuilder.newInstance();

        if (otGenericTypeFace != null) {
            otConfigurationBuilder = otConfigurationBuilder.addOTTypeFace("ot-font", otGenericTypeFace);
        } //in this case ot-font is our typeFaceKey that will be included in the JSON
        return otConfigurationBuilder.build();
    }




}

