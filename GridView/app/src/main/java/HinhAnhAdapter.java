import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.gridview.R;

import java.util.List;

public class HinhAnhAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<HinhAnh> hinhanhList;

    public HinhAnhAdapter(Context context, int layout, List<HinhAnh> hinhanhList) {
        this.context = context;
        this.layout = layout;
        this.hinhanhList = hinhanhList;
    }

    @Override
    public int getCount() {
        return hinhanhList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    class ViewHolder{
        ImageView imgHinh;
    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder viewHolder;
        if(view==null){
            viewHolder=new ViewHolder();
            LayoutInflater inflater =(LayoutInflater)
                    context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            // gắn layout:
            view =inflater.inflate(layout,null);
            viewHolder.imgHinh=(ImageView) view.findViewById(R.id.imageView);
            view.setTag(viewHolder);
        }
        else{
            viewHolder =(ViewHolder) view.getTag();
        }
        HinhAnh hinhAnh=hinhanhList.get(position);
        viewHolder.imgHinh.setImageResource(hinhAnh.getHinh());
        return view;
    }
}
