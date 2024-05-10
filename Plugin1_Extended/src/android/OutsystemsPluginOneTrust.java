package com.outsystems.experts.plugin1_extended;

import android.util.Log;
import android.widget.Toast;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import com.outsystems.experts.plugin1.Plugin1; /* DO I NEED THIS */

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.onetrust.otpublishers.headless.Public.DataModel.OTConfiguration;
import com.onetrust.otpublishers.headless.Public.OTEventListener;
import com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK;
import com.onetrust.otpublishers.headless.Public.OTUIDisplayReason.OTUIDisplayReason;

/**
 * This class echoes a string called from JavaScript.
 */
public class OutsystemsPluginOneTrust extends CMPActivity {

    static final String TAG =  "Plugin1Extended_TAG";
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
