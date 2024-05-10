package com.outsystems.experts.plugin1_extended

import android.util.Log
import android.widget.Toast
import com.outsystems.experts.plugin1.Plugin1Kotlin
import org.apache.cordova.CallbackContext
import org.json.JSONArray
import org.json.JSONException

/**
 * This class echoes a string called from JavaScript.
 */
class Plugin1Kotlin_Extended : Plugin1Kotlin() {

    companion object {
        const val TAG = "Plugin1KotlinExtended_TAG"
    }

    @Throws(JSONException::class)
    override fun execute(action: String, args: JSONArray, callbackContext: CallbackContext): Boolean {
        return when {
            action == "coolMethodKotlin" -> {
                val message = args.getString(0)
                coolMethod(message, callbackContext)
                true
            }
            action == "coolMethodKotlin2" -> {
                val message = args.getString(0)
                coolMethod2(message, callbackContext)
                true
            }
            else -> false
        }
    }

    override fun onPause(multitasking: Boolean) {
        //super.onPause(multitasking)
        Log.d(TAG, "123")
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    private fun coolMethod(message: String?, callbackContext: CallbackContext) {
        if (message != null && message.isNotEmpty()) {
            Log.e(TAG, "reaching Plugin1_Extended")
            Toast.makeText(cordova.context, "coolMethodKotlin extended", Toast.LENGTH_SHORT).show()
            callbackContext.success(message)
        } else {
            callbackContext.error("Expected one non-empty string argument.")
        }
    }

    private fun coolMethod2(message: String?, callbackContext: CallbackContext) {
        if (message != null && message.isNotEmpty()) {
            Toast.makeText(cordova.context, "coolMethodKotlin2 extended", Toast.LENGTH_SHORT).show()
            callbackContext.success(message)
        } else {
            callbackContext.error("Expected one non-empty string argument.")
        }
    }
}