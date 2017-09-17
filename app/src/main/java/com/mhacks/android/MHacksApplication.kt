/**
 * Created by jeffreychang on 9/2/17.
 */

package com.mhacks.android

import android.app.Application
import com.mhacks.android.dagger.component.*
import com.mhacks.android.dagger.module.AppModule
import com.mhacks.android.dagger.module.AuthModule
import com.mhacks.android.dagger.module.RetrofitModule
import timber.log.Timber
import com.uber.sdk.android.core.UberSdk
import com.uber.sdk.core.auth.Scope
import com.uber.sdk.rides.client.SessionConfiguration
import java.util.*


class MHacksApplication : Application(){

    private lateinit var netComponent: NetComponent
    lateinit var hackathonComponent: HackathonComponent

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())

        val appModule = AppModule(this)

        netComponent = DaggerNetComponent.builder()
                .appModule(appModule)
                .authModule(AuthModule(null))
                .retrofitModule(RetrofitModule("https://staging.mhacks.org/v1/"))
                .build()
        hackathonComponent = DaggerHackathonComponent
                .builder()
                .netComponent(netComponent)
                .build()

        setUberSDKConfig()

    }

    fun setUberSDKConfig() {
        val config = SessionConfiguration.Builder()
                .setClientId("x811lv0W3F2Yl-zZMX5fqt6Rmy02Oek3") //This is necessary
                .setRedirectUri("YOUR_REDIRECT_URI") //This is necessary if you'll be using implicit grant
                .setEnvironment(SessionConfiguration.Environment.SANDBOX) //Useful for testing your app in the sandbox environment
                .setScopes(Arrays.asList(Scope.PROFILE, Scope.RIDE_WIDGETS)) //Your scopes for authentication here
                .build()
//Secret Key
//        OZ0CRQcTH-u6mXIBfYfHgJim0IKBRriC0eL5PhpD
//This is a convenience method and will set the default config to be used in other components without passing it directly.
        UberSdk.initialize(config)
    }
}