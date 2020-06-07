package com.example.modernandroid200608;

import androidx.room.Database;
import androidx.room.RoomDatabase;

//엡데이터 베이스에 해당
//만약 데이터베이스 엔티티를 늘리고 싶다면 아래의 데이터베이스에 추가하면됨

@Database(entities =  {Todo.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract TodoDao todoDao();
}
