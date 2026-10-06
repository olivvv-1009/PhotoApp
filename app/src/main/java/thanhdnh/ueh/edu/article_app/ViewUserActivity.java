package thanhdnh.ueh.edu.article_app;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class ViewUserActivity
        extends AppCompatActivity {

  private ImageView ivUserDetail;

  private TextView tvDetailUsername;
  private TextView tvDetailProfile;
  private TextView tvDetailBio;

  @Override
  protected void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);

    setContentView(
            R.layout.activity_view_user
    );

    if (getSupportActionBar() != null) {
      getSupportActionBar().hide();
    }

    ivUserDetail =
            findViewById(
                    R.id.iv_user_detail
            );

    tvDetailUsername =
            findViewById(
                    R.id.tv_detail_username
            );

    tvDetailProfile =
            findViewById(
                    R.id.tv_detail_profile
            );

    tvDetailBio =
            findViewById(
                    R.id.tv_detail_bio
            );

    int id =
            getIntent().getIntExtra(
                    "id",
                    -1
            );

    User user =
            UserData.getUserFromId(id);

    if (user != null) {

      tvDetailUsername.setText(
              user.getUname()
      );

      tvDetailProfile.setText(
              user.getMeProfile()
      );

      tvDetailBio.setText(
              user.getShortBio()
      );

      Picasso.get()
              .load(user.getImage())
              .fit()
              .centerCrop()
              .placeholder(
                      android.R.drawable.ic_menu_gallery
              )
              .error(
                      android.R.drawable.ic_menu_report_image
              )
              .into(ivUserDetail);
    }
  }
}