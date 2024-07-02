package com.app.smartcalculator.app

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.app.smartcalculator.R
import com.app.smartcalculator.app.AppConstants.Companion.OTHER


open class BaseActivity : AppCompatActivity() {


    var isStatusDone = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


//    fun checkNotificationPermission() {
//        if (ContextCompat.checkSelfPermission(this, Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
//            requestPermissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
//        }
//    }
//
//    private val requestPermissionLauncher = registerForActivityResult(
//        ActivityResultContracts.RequestPermission()
//    ) { isGranted: Boolean ->
//
//        if (!isGranted) {
//            Toast.makeText(this, "${getString(R.string.grant_permission_noti)}", Toast.LENGTH_SHORT).show()
//        }
//    }

//    fun firebaseNotificationTopicSubscribe() {
//        firebaseSubscribe(
//            applicationContext.getString(R.string.app_name) + OTHER, applicationContext.getString(R.string.app_name) + GENERAL
//        )
//    }
//
//    fun firebaseNotificationTopicUnSubscribe() {
//        firebaseUnSubscribe(
//            applicationContext.getString(R.string.app_name) + OTHER, applicationContext.getString(R.string.app_name) + GENERAL
//        )
//    }

//    private fun firebaseSubscribe(vararg topicArgs: String) {
//        topicArgs.forEach { topic ->
//            val newTopic = topic.replace(" ", "_")
//            Firebase.messaging.subscribeToTopic(newTopic).addOnCompleteListener {
//                if (it.isSuccessful) {
//                    Log.e("firebase_topic", "subscribed to notification topic: $newTopic")
//                } else {
//                    Log.e("firebase_topic", "subscription to notification failed: $newTopic with ${it.exception}")
//                }
//            }
//        }
//    }


//    private fun firebaseUnSubscribe(vararg topicArgs: String) {
//        topicArgs.forEach { topic ->
//            val newTopic = topic.replace(" ", "_")
//            Firebase.messaging.unsubscribeFromTopic(newTopic).addOnCompleteListener {
//                if (it.isSuccessful) {
//                    Log.e("firebase_topic", "unsubscribed to notification topic: $newTopic")
//                } else {
//                    Log.e("firebase_topic", "unsubscribed to notification failed: $newTopic with ${it.exception}")
//                }
//            }
//        }
//    }


}