package ikhyarpl1.smkcoding.com.roompersistance;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder>{

    public static String EXTRA_SISWA = "ESISWA";
    private List<SiswaModel> arrayList;

    public MainAdapter(List<SiswaModel> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.siswa_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        final SiswaModel siswa = arrayList.get(position);
        Glide.with(holder.itemView)
                .load(siswa.getPathFoto())
                .into(holder.imgProfile);

        holder.textName.setText(siswa.getNama());
        holder.textAddress.setText(siswa.getAlamat());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(holder.itemView.getContext(), ActionActivity.class);
                i.putExtra(EXTRA_SISWA, siswa);
                holder.itemView.getContext().startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.img_profile)
        ImageView imgProfile;

        @BindView(R.id.txt_name)
        TextView textName;

        @BindView(R.id.txt_address)
        TextView textAddress;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    
    }
}
