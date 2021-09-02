package com.example.lesson4;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class StudentAdapter extends RecyclerView.Adapter {

    //Dữ liệu hiện thị là danh sách sinh viên
    private ArrayList<Student> mStutents;
    // Lưu Context để dễ dàng truy cập
    private Context mContext;

    public StudentAdapter(ArrayList<Student> _student, Context mContext) {
        this.mStutents = _student;
        this.mContext = mContext;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Nạp layout cho View biểu diễn phần tử sinh viên
        View studentView =
                inflater.inflate(R.layout.student_item, parent, false);

        MyViewHolder viewHolder = new MyViewHolder(studentView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Student student = mStutents.get(position);

        ((MyViewHolder) holder).studentname.setText(student.getmName());
        ((MyViewHolder) holder).birthyear.setText(student.getBirthYear() + "");
    }

    @Override
    public int getItemCount() {
        return mStutents.size();
    }


    /**
     * Lớp nắm giữ cấu trúc view
     */
    public class MyViewHolder extends RecyclerView.ViewHolder {
        private View itemview;
        public TextView studentname;
        public TextView birthyear;
        public Button detail_button;

        public MyViewHolder(View itemView) {
            super(itemView);
            itemview = itemView;
            studentname = itemView.findViewById(R.id.studentname);
            birthyear = itemView.findViewById(R.id.birthyear);
            detail_button = itemView.findViewById(R.id.detail_button);

            //Xử lý khi nút Chi tiết được bấm
            detail_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(view.getContext(),
                            studentname.getText() + " | "
                                    + " Demo function", Toast.LENGTH_SHORT)
                            .show();
                }
            });

            itemview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(),
                            studentname.getText() + " | "
                                    + " Demo function", Toast.LENGTH_SHORT)
                            .show();
                }
            });
        }
    }


}
