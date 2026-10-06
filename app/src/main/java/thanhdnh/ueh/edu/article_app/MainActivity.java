package thanhdnh.ueh.edu.article_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private GridView gridview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        gridview =
                findViewById(R.id.gridview);

        UserData userData =
                new UserData(
                        getBaseContext(),
                        gridview
                );

        userData.loadData(
                "https://raw.githubusercontent.com/olivvv-1009/PhotoApp/refs/heads/master/users.json",
                this
        );

        gridview.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {

                    @Override
                    public void onItemClick(
                            AdapterView<?> parent,
                            View view,
                            int position,
                            long id) {

                        Intent intent =
                                new Intent(
                                        MainActivity.this,
                                        ViewUserActivity.class
                                );

                        intent.putExtra(
                                "id",
                                (int) id
                        );

                        startActivity(intent);
                    }
                }
        );
    }
}