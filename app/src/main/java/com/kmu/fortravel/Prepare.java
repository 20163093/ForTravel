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
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

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
        }
    }
}
