package com.example.modernandroid200608;

import android.app.Application;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.room.Room;

import java.util.List;


//뷰모델
public class MainViewModel extends AndroidViewModel {

    private AppDatabase db;
    public LiveData<List<Todo>> todos;
    public String newTodo;

    public MainViewModel(@NonNull Application application) {
        super(application);

        db = Room.databaseBuilder(application, AppDatabase.class, "todo-db").build();

        todos = getAll();
    }

    public LiveData<List<Todo>> getAll(){
        return db.todoDao().getAll();
    }

    public void insert(String todo){
        new InsertAsyncTask(db.todoDao()).execute(new Todo(todo));
    }


    //데이터 바인딩때문에 수정
//    public void insert(Todo todo){
//        new InsertAsyncTask(db.todoDao()).execute(todo);
//    }

    //백스레드는 스레드를 만드는방법, 에이싱크 테스크 만드는 방법
    //우리는 에이싱크를 쓴다
    private static class InsertAsyncTask extends AsyncTask<Todo, Void, Void> {

        private TodoDao mTodoDao;

        public InsertAsyncTask(TodoDao mTodoDao) {
            this.mTodoDao = mTodoDao;
        }

        @Override
        protected Void doInBackground(Todo... todos) {
            mTodoDao.insert(todos[0]);
            return null;
        }
    }
}
