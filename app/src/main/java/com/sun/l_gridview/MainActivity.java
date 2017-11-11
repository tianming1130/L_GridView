package com.sun.l_gridview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private GridView gridView;
    private List<Map<String, Object>> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView = (GridView) findViewById(R.id.grid_view);

        initData();
        //使用数据适配器 SimpleAdapter
        //SimpleAdapter adapter=new SimpleAdapter(this,dataList,R.layout.grid_item,new String[]{"img","price","content"},new int[]{R.id.image,R.id.tv_price,R.id.tv_content});

        MyAdapter adapter=new MyAdapter(this,dataList);
        gridView.setAdapter(adapter);
    }

    private void initData() {
        int[] images = {R.drawable.a1, R.drawable.a2, R.drawable.a3, R.drawable.a4, R
                .drawable.a5, R.drawable.a6, R.drawable.a7, R.drawable.a8};
        String[] prices = {"￥159", "￥216", "￥169", "￥199", "￥215", "￥369", "￥309", "￥329"};
        String[] contents = {"裙子秋冬2017新款格子毛呢短裙A字裙格子裙打底裙半身裙女高腰潮",
                "2017秋装新款针织毛衣冬天裙子女韩版长袖套头打底冬季加厚连衣裙",
                "针织秋冬季连衣裙女长袖2017新款修身显瘦加厚圆领中长款裙子潮",
                "毛呢半身裙秋冬中长款裙子女士高腰包臀裙开叉包裙显瘦一步裙中裙",
                "装套装男士三件套商务职业正装西服韩版修身伴郎新郎结婚礼服秋",
                "西服套装男士三件套商务正装职业小西装修身韩版伴郎新郎结婚礼服",
                "花花公子西服套装男西装男士商务休闲职业装修身新郎伴郎结婚礼服",
                "西服套装男士春秋修身三件套新郎婚礼服结婚伴郎西装男职业装正装"};

        dataList=new ArrayList<>();
        for (int i=0;i<8;i++){
            Map<String,Object> map=new HashMap<>();
            map.put("img",images[i]);
            map.put("price",prices[i]);
            map.put("content",contents[i]);
            dataList.add(map);
        }
    }
}
