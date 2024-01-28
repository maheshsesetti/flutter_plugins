package com.example.example_plugin

import android.app.AlertDialog
import android.content.DialogInterface
import androidx.annotation.NonNull
import io.flutter.embedding.engine.FlutterEngine

import io.flutter.embedding.engine.plugins.FlutterPlugin
import io.flutter.embedding.engine.plugins.activity.ActivityAware
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler
import io.flutter.plugin.common.MethodChannel.Result

/** ExamplePlugin */
class ExamplePlugin: FlutterPlugin, MethodCallHandler, ActivityAware {
  /// The MethodChannel that will the communication between Flutter and native Android
  ///
  /// This local reference serves to register the plugin with the Flutter Engine and unregister it
  /// when the Flutter Engine is detached from the Activity
  private lateinit var channel : MethodChannel


  private var currentActivity : android.app.Activity? = null

  override fun onAttachedToEngine(flutterPluginBinding: FlutterPlugin.FlutterPluginBinding) {
    channel = MethodChannel(flutterPluginBinding.binaryMessenger, "example_plugin")
    channel.setMethodCallHandler(this)
  }

  override fun onMethodCall(call: MethodCall, result: Result) {

    when (call.method) {
      "getPlatformVersion" -> {
        result.success("Android ${ android.os.Build.VERSION.RELEASE}")
      }
      "showAlert" -> {
        return currentActivity?.let {
          val builder = AlertDialog.Builder(it)
          builder.setTitle("Hello")
          builder.setMessage("I am a native alert dialog.")
          .setPositiveButton(android.R.string.ok,
          DialogInterface.OnClickListener { _, _ ->
          })
          builder.create().show()
          result.success(true)
        } ?: result.error("0", "Current activity null", "Can not show dialog because current activity is null.")
      }
      "showMap" ->  {
        
      }
      else -> {
        result.notImplemented()
      }
    }
  }

  override fun onDetachedFromEngine(binding: FlutterPlugin.FlutterPluginBinding) {

    channel.setMethodCallHandler(null)
  }
  override fun onAttachedToActivity(binding: ActivityPluginBinding) {
    currentActivity = binding.activity
  }
  override fun onDetachedFromActivityForConfigChanges() {
    currentActivity = null
  }
  override fun onReattachedToActivityForConfigChanges(binding: ActivityPluginBinding) {
    currentActivity = binding.activity
  }
  override fun onDetachedFromActivity() {
    currentActivity = null
  }
}
