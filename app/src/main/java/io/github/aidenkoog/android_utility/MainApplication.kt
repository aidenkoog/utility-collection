package io.github.aidenkoog.android_utility

import android.app.Activity
import android.app.Application
import android.content.Context
import android.os.Bundle
import androidx.multidex.MultiDex
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.FormatStrategy
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy
import io.github.aidenkoog.android_utility.util.Constants.LOGGER_TAG

class MainApplication : Application(), Application.ActivityLifecycleCallbacks {

    companion object {
        private const val TAG: String = LOGGER_TAG
        private var isBackground = false
    }

    override fun onCreate() {
        super.onCreate()

        /**
         * Android runs on top of JVM-based ART.
         * To run on top of ART, Android code is compiled into dex files.
         * The number of methods cannot exceed 64k (65536).
         * Multidex splits a dex file into several pieces
         * so that the number of methods does not exceed 64k (65536),
         * and allows the split dex to be read.
         */
        MultiDex.install(this)
        loadLoggerFeature()
        registerActivityLifecycleCallbacks(this)
    }

    private fun loadLoggerFeature() {
        val formatStrategy: FormatStrategy = PrettyFormatStrategy.newBuilder().tag(TAG).build()
        Logger.addLogAdapter(object : AndroidLogAdapter(formatStrategy) {
            override fun isLoggable(priority: Int, tag: String?): Boolean {
                return BuildConfig.DEBUG
            }
        })
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    /**
     * Called when the Activity calls [super.onCreate()][Activity.onCreate].
     */
    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
        Logger.d("onActivityCreated:")
    }

    /**
     * Called when the Activity calls [super.onStart()][Activity.onStart].
     */
    override fun onActivityStarted(activity: Activity) {
        Logger.d("onActivityStarted:")
    }

    /**
     * Called when the Activity calls [super.onResume()][Activity.onResume].
     */
    override fun onActivityResumed(activity: Activity) {
        Logger.d("foreground")
        isBackground = false
    }

    /**
     * Called when the Activity calls [super.onPause()][Activity.onPause].
     */
    override fun onActivityPaused(activity: Activity) {
        Logger.d("background")
        isBackground = true
    }

    /**
     * Called when the Activity calls [super.onStop()][Activity.onStop].
     */
    override fun onActivityStopped(activity: Activity) {
        Logger.d("onActivityStopped:")
    }

    /**
     * Called when the Activity calls
     * [super.onSaveInstanceState()][Activity.onSaveInstanceState].
     */
    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
        Logger.d("onActivitySaveInstanceState:")
    }

    /**
     * Called when the Activity calls [super.onDestroy()][Activity.onDestroy].
     */
    override fun onActivityDestroyed(activity: Activity) {
        Logger.d("onActivityDestroyed:")
    }
}