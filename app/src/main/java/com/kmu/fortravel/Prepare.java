package com.kmu.fortravel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class Prepare extends AppCompatActivity {


    ArrayList<String> items;
    ArrayAdapter<String> adapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prepare);

        //데이터 준비
        items = new ArrayList<String>();

        // 어댑터 생성
        adapter = new ArrayAdapter<String>(Prepare.this,
                android.R.layout.simple_list_item_multiple_choice, items);

        // 어댑터 설정
        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE); // 하나의 항목만 선택할 수 있도록 설정

        // selectAll button에 대한 이벤트 처리.
        Button selectAllButton = (Button)findViewById(R.id.selectAll) ;
        selectAllButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                int count = 0 ;
                count = adapter.getCount() ;

                for (int i=0; i<count; i++) {
                    listView.setItemChecked(i, true) ;
                }
            }
        }) ;

    }

    /**
     * ADD, DELETE 버튼 클릭 시 실행되는 메소드
     */
    public void OnClick(View v) {
        EditText editText = (EditText) findViewById(R.id.newItem);
        switch (v.getId()) {
            case R.id.Add:                                 // ADD 버튼 클릭시
                String text = editText.getText().toString();        // EditText에 입력된 문자열값을 얻기
                if (!text.isEmpty()) {                        // 입력된 text 문자열이 비어있지 않으면
                    items.add(text);                          // items 리스트에 입력된 문자열 추가
                    editText.setText("");                           // EditText 입력란 초기화
                    adapter.notifyDataSetChanged();           // 리스트 목록 갱신
                }
                break;
            case R.id.Delete:                             // DELETE 버튼 클릭시
                SparseBooleanArray checkedItems = listView.getCheckedItemPositions();
                int count_del = adapter.getCount() ;

                for (int i = count_del-1; i >= 0; i--) {
                    if (checkedItems.get(i)) {
                        items.remove(i) ;
                    }
                }
                listView.clearChoices() ;
                adapter.notifyDataSetChanged();
                break;
//            case R.id.selectAll:
//                int count_sA = 0 ;
//                count_sA = adapter.getCount() ;
//
//                for (int i = 0; i < count_sA; i++) {
//                    listView.setItemChecked(i, true) ;
//                }
//                break;
        }
    }



//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_prepare);
//
//        // 빈 데이터 리스트 생성.
//        final ArrayList<String> items = new ArrayList<String>() ;
//        // ArrayAdapter 생성. 아이템 View를 선택(multiple choice)가능하도록 만듦.
//        final ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_multiple_choice, items) ;
//
//        // listview 생성 및 adapter 지정.
//        final ListView listview = (ListView) findViewById(R.id.listview1) ;
//        listview.setAdapter(adapter) ;
//
//        // add button에 대한 이벤트 처리.
//        Button addButton = (Button)findViewById(R.id.add) ;
//        addButton.setOnClickListener(new Button.OnClickListener() {
//            public void onClick(View v) {
//                int count;
//                count = adapter.getCount();
//
//                // 아이템 추가.
//                items.add("LIST" + Integer.toString(count + 1));
//
//                // listview 갱신
//                adapter.notifyDataSetChanged();
//            }
//        }) ;
//
//        // delete button에 대한 이벤트 처리.
//        Button deleteButton = (Button)findViewById(R.id.delete) ;
//        deleteButton.setOnClickListener(new Button.OnClickListener() {
//            public void onClick(View v) {
//                SparseBooleanArray checkedItems = listview.getCheckedItemPositions();
//                int count = adapter.getCount() ;
//
//                for (int i = count-1; i >= 0; i--) {
//                    if (checkedItems.get(i)) {
//                        items.remove(i) ;
//                    }
//                }
//
//                // 모든 선택 상태 초기화.
//                listview.clearChoices() ;
//
//                adapter.notifyDataSetChanged();
//            }
//        }) ;
//
//        // selectAll button에 대한 이벤트 처리.
//        Button selectAllButton = (Button)findViewById(R.id.selectAll) ;
//        selectAllButton.setOnClickListener(new Button.OnClickListener() {
//            public void onClick(View v) {
//                int count = 0 ;
//                count = adapter.getCount() ;
//
//                for (int i=0; i<count; i++) {
//                    listview.setItemChecked(i, true) ;
//                }
//            }
//        }) ;
//
//    }
}
