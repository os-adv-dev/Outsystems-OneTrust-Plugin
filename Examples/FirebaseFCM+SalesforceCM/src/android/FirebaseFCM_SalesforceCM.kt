package com.outsystems.experts.plugin1_extended

import com.outsystems.firebase.cloudmessaging.OSFirebaseCloudMessaging
import com.outsystems.plugins.firebasemessaging.controller.FirebaseMessagingController
import kotlinx.coroutines.runBlocking
import org.apache.cordova.CallbackContext
import org.json.JSONArray

/**
 * This class echoes a string called from JavaScript.
 */
class FirebaseFCM_SalesforceCM : OSFirebaseCloudMessaging() {

    private lateinit var controller : FirebaseMessagingController

    override fun execute(action: String, args: JSONArray, callbackContext: CallbackContext): Boolean {
        this.callbackContext = callbackContext
        val result = runBlocking {
            when (action) {
                "getToken" -> {
                    controller.getToken()
                }
                else -> false
            }
            true
        }
        return result
    }

}