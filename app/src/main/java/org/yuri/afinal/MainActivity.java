package org.yuri.afinal;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView noticeListView;
    private NoticeListAdapter adapter;
    private List<Notice> noticeList;

    //즉 프라이베이트로 해당 클래스의 멤버 변수를 만들어 준 것이다.
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        Button managementButton = (Button) findViewById(R.id.managementButton);

//        if(e1.equals("admin")){
//
//                        managementButton.setEnable(false);
//
//                    }
//
//        Intent intent = getIntent();
//        String id = intent.getStringExtra("id");
////        String password = intent.getStringExtra("password");
////        String message = "Welcome," + id;
//
//
//        if(id.equals("admin")){
//            managementButton.setVisibility(View.GONE);
//        }





        noticeListView = (ListView) findViewById(R.id.noticeListView);
        noticeList = new ArrayList<Notice>();
        noticeList.add(new Notice("About Final Project and Its Demonstration","yuri","01/05/2019"));
        noticeList.add(new Notice("About Final Quiz","yuri","02/05/2019"));
        noticeList.add(new Notice("May 1 class is cancelled due to workers day","yuri","03/05/2019"));
        noticeList.add(new Notice("About Midterm Project's ","yuri","11/05/2019"));
        noticeList.add(new Notice("ASSIGNMENT & CLASS NOTES & PRESENTATIONS","yuri","01/05/2019"));
        noticeList.add(new Notice("Midterm grades have been announced!","yuri","12/05/2019"));
        noticeList.add(new Notice("Quiz-04","yuri","12/05/2019"));

        adapter = new NoticeListAdapter(getApplicationContext(),noticeList);
        noticeListView.setAdapter(adapter);

        //해당어뎁터가 매칭됨으로써 어뎁터에 있는 내용이 view 형태로 진행이 되는 것이다.



//        final Button userButton = (Button) findViewById(R.id.userButton);
        final Button myInfoButton = (Button) findViewById(R.id.myInfoButton);
//        final Button newsButton = (Button) findViewById(R.id.newsButton);

        //화면이 바뀌는 레이아웃, //만들었던 notice 어뎁터를 추가해야 한다
        final LinearLayout notice = (LinearLayout) findViewById(R.id.notice);


//
//        userButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                notice.setVisibility(View.GONE);
//
//
//                //공지사항이라는 부분이 보이지 않도록, 해당 프레그 먼트로 바꿔주는 것이다
//
////                userButton.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
//                myInfoButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
////                newsButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
//
//                FragmentManager fragmentManager = getSupportFragmentManager();
//                //프래그 먼트의 트렌젝션을 만들어 준다
//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                fragmentTransaction.replace(R.id.fragment,new UserFragment());
//                fragmentTransaction.commit();
//
//            }
//        });

        //
        myInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notice.setVisibility(View.GONE);


                //공지사항이라는 부분이 보이지 않도록, 해당 프레그 먼트로 바꿔주는 것이다

//                userButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                myInfoButton.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
//                newsButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));

                FragmentManager fragmentManager = getSupportFragmentManager();
                //프래그 먼트의 트렌젝션을 만들어 준다
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment,new MyinfoFragment());
                fragmentTransaction.commit();

            }
        });

        //

//        newsButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                notice.setVisibility(View.GONE);
//
//
//                //공지사항이라는 부분이 보이지 않도록, 해당 프레그 먼트로 바꿔주는 것이다
//
//                userButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
//                myInfoButton.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
//                newsButton.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
//
//                FragmentManager fragmentManager = getSupportFragmentManager();
//                //프래그 먼트의 트렌젝션을 만들어 준다
//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//                fragmentTransaction.replace(R.id.fragment,new NewsFragment());
//                fragmentTransaction.commit();
//
//            }
//        });


    }

    //두번 뒤로가기 눌렀을 경우 종료 될 수 있도록

    private long lastTimeBackPressed;

    @Override
    public void onBackPressed(){
        if(System.currentTimeMillis() - lastTimeBackPressed <1500)
        {
            finish();
            return;

        }
        Toast.makeText(this,"Press the 'back' button once more to exit.",Toast.LENGTH_LONG);
        lastTimeBackPressed = System.currentTimeMillis();
    }

}
