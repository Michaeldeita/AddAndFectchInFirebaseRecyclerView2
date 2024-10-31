package com.example.addandfectchinfirebaserecyclerview2;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.addandfectchinfirebaserecyclerview2.productModel.ProductModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText id, name, category, price;
    Button add, list;

    List<ProductModel> productList = new ArrayList<>();
    ProductModel productObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        productObject = new ProductModel();

        id = findViewById(R.id.et_product_id);
        name = findViewById(R.id.et_product_name);
        category = findViewById(R.id.et_product_category);
        price = findViewById(R.id.et_product_price);
        add = findViewById(R.id.btn_product_add);
        list = findViewById(R.id.btn_product_list);

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
    }

    //list function
    public void toList() {

    }

}