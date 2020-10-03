package th.ac.su.cp.bnk48;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import th.ac.su.cp.bnk48.model.BNK48Member;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // สร้าง Layout Manager Object
        LinearLayoutManager lm = new LinearLayoutManager(MainActivity.this);
        // สร้าง Adapter Object
        MyAdapter adapter = new MyAdapter();
        //เจ้าถึง RecyclerView  กับ Layout
        RecyclerView rv = findViewById(R.id.word_list_recycle_view);
        rv.setLayoutManager(lm);//กำหนด layout manager ให้กับ RecyclerView
        rv.setAdapter(adapter);//กำหนด  Adapter ให้กับRecyclerView
    }
}

class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    BNK48Member[] items = {
            new BNK48Member(R.drawable.pun, "PUN", "PUNSIKORN TIYAKORN"),
            new BNK48Member(R.drawable.jennis, "JENNIS", "JENNIS OPRASERT"),
            new BNK48Member(R.drawable.cherprang, "CHERPRANG", "CHERPRANG AREEKUL"),
            new BNK48Member(R.drawable.music, "MUSIC", "PRAEWA SUTHAMPHONG"),
            new BNK48Member(R.drawable.mobile, "MOBILE", "PIMRAPAT PHADUNGWATANACHOK"),
            new BNK48Member(R.drawable.kaew, "KAEW", "NATRUJA CHUTIWANSOPON"),
            new BNK48Member(R.drawable.namsai, "NAMSAI", "PICHAYAPA NATHA"),
            new BNK48Member(R.drawable.pupe, "PUPE", "JIRADAPA INTAJAK"),
            new BNK48Member(R.drawable.namneung, "NAMNEUNG", "MILIN DOKTHIAN"),
            new BNK48Member(R.drawable.noey, "NOEY", "KANTEERA WADCHARATHADSANAKUL"),
    };

    public MyAdapter() {


    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.member_bnk48, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.imageView.setImageResource(items[position].imageResId);
        holder.wordTextView.setText(items[position].word);
        holder.nameTextView.setText(items[position].name);

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView wordTextView;
        TextView nameTextView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_view);
            wordTextView = itemView.findViewById(R.id.word_text_view);
            nameTextView = itemView.findViewById(R.id.name_text_view);
        }
    }
}
