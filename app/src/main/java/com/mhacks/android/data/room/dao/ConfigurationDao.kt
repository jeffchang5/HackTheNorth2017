package com.mhacks.android.data.room.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.mhacks.android.data.kotlin.Configuration
import io.reactivex.Single

/**
 * Created by jeffreychang on 9/7/17.
 */

@Dao
interface ConfigurationDao {
    @Query("SELECT * FROM config")
    fun getConfig(): Single<Configuration>

    @Insert
    fun insertConfig(config: Configuration)
}