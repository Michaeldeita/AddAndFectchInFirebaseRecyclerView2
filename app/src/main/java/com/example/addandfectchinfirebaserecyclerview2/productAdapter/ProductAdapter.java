package com.example.addandfectchinfirebaserecyclerview2.productAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.addandfectchinfirebaserecyclerview2.R;
import com.example.addandfectchinfirebaserecyclerview2.productModel.ProductModel;

import java.util.List;
import java.util.zip.Inflater;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    List<ProductModel> productModelList;

    public ProductAdapter(List<ProductModel> productModelList) {
        this.productModelList = productModelList;
    }

    @NonNull
    @Override
    public ProductAdapter.ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.product_card, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.ProductViewHolder holder, int position) {
        ProductModel productModel = productModelList.get(position);
        holder.name.setText(productModel.getName());
        holder.category.setText(productModel.getCategory());
        holder.price.setText(String.valueOf(productModel.getPrice()));
    }

    @Override
    public int getItemCount() {
        return productModelList.size();
    }

    public static class ProductViewHolder extends RecyclerView.ViewHolder {

        TextView name, category, price;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.tv_product_name);
            category = itemView.findViewById(R.id.tv_product_category);
            price = itemView.findViewById(R.id.tv_product_price);

            }
        }
    }
