package com.example.myappmarvel.database

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.myappmarvel.MainActivity
import com.example.myappmarvel.models.Hero
import java.util.concurrent.Executors

@Database(entities = [
    Hero::class
    ],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun listHeroDAO() : ListHeroDAO

    companion object {

        @Volatile
        private var instance: AppDatabase? = null

        operator fun invoke() = instance ?: synchronized(this) {
            instance ?: buildDatabase().also { instance = it }
        }

        private fun buildDatabase() = Room.databaseBuilder(
            MainActivity.applicationContext(),
            AppDatabase::class.java,
            "encrypted_db"
        )
        .fallbackToDestructiveMigration()
        .allowMainThreadQueries()
        //.openHelperFactory(SupportFactory(SQLiteDatabase.getBytes("MasterKey".toCharArray())))
        .build()
    }

}