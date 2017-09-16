package com.mhacks.android.dagger.module

import android.app.Application
import android.arch.persistence.room.Room
import com.mhacks.android.dagger.scope.UserScope
import com.mhacks.android.data.room.MHacksDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by jeffreychang on 9/6/17.
 */

@Module
class RoomModule {

    @UserScope
    @Provides
    fun provideMHacksDatabase(application: Application): MHacksDatabase {
        return Room.databaseBuilder(application, MHacksDatabase::class.java, "mhacks-db").build()
    }

}