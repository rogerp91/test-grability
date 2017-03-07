package com.grability.ui.adapte;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.grability.R;
import com.grability.TestGrability;
import com.grability.domain.entity.Child;
import com.grability.domain.entity.Data_;
import com.grability.ui.activity.theme.ThemeFragment;
import com.grability.util.Functions;
import com.grability.util.SelectsImage;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by rogerp91 on 03/03/17.
 */

public class ThemeAdapte extends RecyclerView.Adapter<ThemeAdapte.ViewHolder> {

    private static String TAG = ThemeAdapte.class.getSimpleName();

    private List<Child> children;
    private ThemeFragment.ThemeItemListener clickListener;
    private String url;

    public ThemeAdapte(List<Child> children, ThemeFragment.ThemeItemListener listener) {
        this.children = children;
        this.clickListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_theme, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Data_ data_ = children.get(position).getData();
        holder.name.setText(data_.getTitle());
        holder.subscribers.setText(String.format("Suscriptores: %s", Integer.toString(data_.getSubscribers())));
        holder.date.setText(Functions.getDate(data_.getCreatedUtc()));

        holder.descripcion.setText(data_.getDescription());
        if (data_.getDescription().isEmpty()) {
            holder.descripcion.setText("Información no disponible");
        } else {
            holder.descripcion.setText(data_.getDescription());
        }

        try {
            url = data_.getBannerImg();
            if (url.isEmpty()) {
                url = SelectsImage.selectImg();
            }
        } catch (NullPointerException e) {
            Log.d(TAG, "onBindViewHolder: " + e.getMessage());
        }

        // IMG
        Glide.with(TestGrability.getContext()).load(url).diskCacheStrategy(DiskCacheStrategy.ALL).into(holder.img_banner);

        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onDetailTheme(data_);
            }
        });
    }

    @Override
    public int getItemCount() {
        return children.size();
    }

    @Override
    public long getItemId(int position) {
        return children.get(position).getData().getId_aux();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.img_banner)
        ImageView img_banner;

        @BindView(R.id.name)
        TextView name;

        @BindView(R.id.subscribers)
        TextView subscribers;

        @BindView(R.id.description)
        TextView descripcion;

        @BindView(R.id.detail)
        Button button;

        @BindView(R.id.date)
        TextView date;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

}