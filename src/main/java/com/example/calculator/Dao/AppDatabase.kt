package com.example.calculator.Dao
import androidx.room.*
import com.example.calculator.model.History

@Database(entities = [History::class],version =1)
abstract class AppDatabase : RoomDatabase(){
    abstract fun historyDao(): HistoryDao

}