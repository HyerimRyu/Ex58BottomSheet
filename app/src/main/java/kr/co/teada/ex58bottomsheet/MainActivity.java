package kr.co.teada.ex58bottomsheet;

import android.support.design.widget.BottomSheetDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickBtn(View view) {

        //1. 버튼다이얼로그 객체생성
        final BottomSheetDialog bottomSheetDialog=new BottomSheetDialog(this);

        //3. 보여질 뷰 설정_xml : bottom_dialog, arrays.xml
        View v=getLayoutInflater().inflate(R.layout.bottom_dialog,null);
        bottomSheetDialog.setContentView(v);

        bottomSheetDialog.setCanceledOnTouchOutside(true);

        //2. 다이얼로그 보이기
        bottomSheetDialog.show();

        //4. 다이얼로그 안에 있는 ListView 의 아이템 클릭 반응하기
        ListView listView= v.findViewById(R.id.listview);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String[] datas= getResources().getStringArray(R.array.datas); ///xml에 있는 String 배열을 불러오는 기법
                Toast.makeText(MainActivity.this, datas[position], Toast.LENGTH_SHORT).show();

                bottomSheetDialog.dismiss();
                
            }
        });
        
//        listView.addHeaderView();
//        listView.addFooterView();
    }
}
