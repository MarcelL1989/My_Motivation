package com.example.my_motivation.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.my_motivation.data.model.Detailcard

@Dao
interface DatabaseDAO {

    @Query("SELECT * FROM Detailcard")
    fun getAll(): LiveData<List<Detailcard>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(detailcard: Detailcard)

    @Delete
    suspend fun delete(detailcard: Detailcard)
}