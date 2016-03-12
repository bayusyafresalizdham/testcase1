package com.namagz.testcase1;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.namagz.testcase1.Model.Models;
import com.namagz.testcase1.rest.RestApi;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by user on 2/29/16.
 */
public class CetakRestActivity extends AppCompatActivity {
    public static final String ROOT_URL = "https://api.github.com/";
    private ListView listview;
    private List<Models> commit;

    String arr[] = new String[9000];
    private List<Models.File> commit1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rest);
        listview = (ListView) findViewById(R.id.listViewBuku);
        getData();
    }

    private void getData(){
        final ProgressDialog loading = ProgressDialog.show(this,"Loading....","Loading...",false,false);
        Retrofit retrofit = new Retrofit.Builder().baseUrl(ROOT_URL).addConverterFactory(GsonConverterFactory.create()).build();
        RestApi service = retrofit.create(RestApi.class);
        Call<List<Models>> call = service.getData();
        call.enqueue(new Callback<List<Models>>() {
            @Override
            public void onResponse(Call<List<Models>> call, Response<List<Models>> response) {
                try {
                    loading.dismiss();
                    List<Models> commitall = response.body();

                    //memasukkan data dari varibel buku ke books
                    commit = commitall;

                    int counter=0;
                    for (Models models : response.body()) {
                        for (Map.Entry<String, Models.File> file : models.files.entrySet()) {
                            Log.e("File", file.getKey());
                            Log.e("File", file.getValue().type);
                            arr[counter]=file.getValue().type;

                        } counter++;
                    }
                    for(int a = 0;a<counter;a++){
                        Log.e("asc","as"+arr[a]);
                    }
                    showList();
                } catch (Exception e) {

                }
            }

            @Override
            public void onFailure(Call<List<Models>> call, Throwable t) {

            }
        });
    }
    private void showList() {
        //String array untuk menyimpan nama semua nama buku
        String[] items = new String[commit.size()];

        for (int i = 0; i < commit.size(); i++) {

            items[i] = commit.get(i).getId() +"\n"+ arr[i];
        }
        //Membuat Array Adapter for listview
        ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.activity_listview, items);

        //setting adapter untuk listview
        listview.setAdapter(adapter);

    }
}
