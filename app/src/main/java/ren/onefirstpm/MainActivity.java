package ren.onefirstpm;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.BindColor;
import butterknife.BindDimen;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.lv_list)
    ListView mLvList;
    private Unbinder mBind;

    @BindView(R.id.tv_hw)
    TextView tv_hw;
    @BindString(R.string.app_name)
    String name;
    @BindColor(R.color.colorAccent)
    int mColor;
    @BindDimen(R.dimen.activity_horizontal_margin)
    float magin;
    private ArrayList<String> mList;
    private ArrayAdapter<String> mAdapter;

    //    @BindDrawable(R.drawable.ic_launcher)
//    ImageView iv;
    @OnClick({R.id.tv_hw, R.id.bt_one})
    public void click(View view) {
        switch (view.getId()) {
            case R.id.tv_hw:
                Toast.makeText(this, "8888888888888", Toast.LENGTH_SHORT).show();
                break;
            case R.id.bt_one:
                Toast.makeText(this, "99999999999999999", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBind = ButterKnife.bind(this);
        mLvList = (ListView) findViewById(R.id.lv_list);
        mList = new ArrayList<String>();
        for (int i = 0; i < 20; i++) {
            mList.add("今日砍柴" + i);
        }
        mAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, mList);
        mLvList.setAdapter(mAdapter);
    }

//    public @interface OnItemClick


    @OnItemClick(R.id.lv_list)
    void onItemClick(int position) {
        Toast.makeText(this, "今天放羊" + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mBind.unbind();
    }
}
