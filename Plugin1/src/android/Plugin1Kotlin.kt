package com.outsystems.experts.plugin1

import android.widget.Toast
import org.apache.cordova.CordovaPlugin
import org.apache.cordova.CallbackContext
import org.json.JSONArray
import org.json.JSONException

/**
 * This class echoes a string called from JavaScript.
 */
public open class Plugin1Kotlin : CordovaPlugin() {

    @Throws(JSONException::class)
    override fun execute(action: String, args: JSONArray, callbackContext: CallbackContext): Boolean {
        return when {
            action == "coolMethodKotlin" -> {
                val message = args.getString(0)
                coolMethod(message, callbackContext)
                true
            }
            action == "coolMethod2Kotlin" -> {
                val message = args.getString(0)
                coolMethod2(message, callbackContext)
                true
            }
            else -> false
        }
    }

    override fun onResume(multitasking: Boolean) {
        super.onResume(multitasking)
    }

    override fun onPause(multitasking: Boolean) {
        super.onPause(multitasking)
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    private fun coolMethod(message: String?, callbackContext: CallbackContext) {
        if (message != null && message.isNotEmpty()) {
            Toast.makeText(cordova.context, "coolMethodKotlin", Toast.LENGTH_SHORT).show()
            callbackContext.success(message)
        } else {
            callbackContext.error("Expected one non-empty string argument.")
        }
    }

    private fun coolMethod2(message: String?, callbackContext: CallbackContext) {
        if (message != null && message.isNotEmpty()) {
            Toast.makeText(cordova.context, "coolMethod2Kotlin", Toast.LENGTH_SHORT).show()
            callbackContext.success(message)
        } else {
            callbackContext.error("Expected one non-empty string argument.")
        }
    }
}