package com.example.modernandroid200608;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.room.Room;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.example.modernandroid200608.databinding.ActivityMainBinding;

import java.util.List;

public class MainActivity extends AppCompatActivity {

// 데이버바인딩에선 이거 안씀
//    private EditText mTodoEditText;
//    private TextView mResultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        //데이터바인딩, 기존의 셋컨텐츠뷰가 아닌 아래 클래스 함수 사용
        //데이터바인딩된 레이아웃의 객체 생성
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        //라이브데이터도 관찰가능하게 바인딩에 설정
        binding.setLifecycleOwner(this);

//        mTodoEditText = findViewById(R.id.todo_edit);
//        mResultTextView = findViewById(R.id.content_text);

        MainViewModel viewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        //뷰모델을 섹해주면, 앞서 바인딩해줬던 액티비티의 레이아웃으로 연결됨
        binding.setViewModel(viewModel);

        //메인쓰레드에서 돌아가게 해줬는데, 이는 연습시에 쓸만하지 실무에서는 백쓰레드로 돌림
        //        final AppDatabase db = Room.databaseBuilder(
        //                this, AppDatabase.class, "todo-db").allowMainThreadQueries().build();

        //라이브데이터 적용
        //UI 갱신
//        db.todoDao().getAll().observe(this, todos -> {
//            //mResultTextView.setText(db.todoDao().getAll().toString());
//            mResultTextView.setText(todos.toString());
//        });

        //UI갱신
        //데이터바인딩을 했으므로 있을필요없음
//        viewModel.getAll().observe(this, todos -> {
//            //mResultTextView.setText(db.todoDao().getAll().toString());
//            binding.contentText.setText(todos.toString());
//        });

//        //버튼 클릭시 DB에 insert
//        findViewById(R.id.add_button).setOnClickListener(v -> {
//            viewModel.insert(new Todo(binding.todoEdit.getText().toString()));
//            //디비에서 가져와서 바로 사용하기
//            //db.todoDao().insert(new Todo(mTodoEditText.getText().toString()));
////            new InsertAsyncTask(db.todoDao())
////                    .execute(new Todo(mTodoEditText.getText().toString()));
//        });
    }



}