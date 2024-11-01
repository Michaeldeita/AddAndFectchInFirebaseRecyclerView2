package com.example.addandfectchinfirebaserecyclerview2;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.addandfectchinfirebaserecyclerview2.productAdapter.ProductAdapter;
import com.example.addandfectchinfirebaserecyclerview2.productModel.ProductModel;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText id, name, category, price;
    Button add, list;
    RecyclerView rvMain;

    List<ProductModel> productList = new ArrayList<>();
    ProductModel productObject;
    ProductAdapter productAdapter;

    FirebaseFirestore firestore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        productObject = new ProductModel();
        firestore = FirebaseFirestore.getInstance();

        id = findViewById(R.id.et_product_id);
        name = findViewById(R.id.et_product_name);
        category = findViewById(R.id.et_product_category);
        price = findViewById(R.id.et_product_price);
        add = findViewById(R.id.btn_product_add);
        list = findViewById(R.id.btn_product_list);

        rvMain = findViewById(R.id.rv_main);
        productAdapter = new ProductAdapter(productList);
        rvMain.setAdapter(productAdapter);
        rvMain.setLayoutManager(new LinearLayoutManager(this));

        //btn add functionality
        add.setOnClickListener(view -> toAdd());

        //btn list functionality
        list.setOnClickListener(view -> toList());




    }

    //add function
    public void toAdd() {
        productObject.setId(Integer.parseInt(id.getText().toString()));
        productObject.setName(name.getText().toString());
        productObject.setCategory(category.getText().toString());
        productObject.setPrice(Integer.parseInt(price.getText().toString()));

        Log.d("MAIN", "sandro");
        firestore.collection("products").add(productObject).addOnSuccessListener(document -> {
            productList.add(productObject);

        }).addOnFailureListener(e -> {
            Log.d("MAIN", e.getMessage());
        });
    }

    //list function
    public void toList() {
        firestore.collection("products").get().addOnCompleteListener(v->{
            if(v.isSuccessful()) {
                for (QueryDocumentSnapshot document : v.getResult()) {
                    ProductModel product = document.toObject(ProductModel.class);
                    productList.add(product);
                }productAdapter.notifyDataSetChanged();
            }else{
                Log.e("MAIN",v.getException().getMessage());
            }
        });
    }

}