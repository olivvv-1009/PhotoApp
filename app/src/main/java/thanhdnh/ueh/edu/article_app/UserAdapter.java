package thanhdnh.ueh.edu.article_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class UserAdapter extends BaseAdapter {

  private final ArrayList<User> userList;
  private final Context context;

  public UserAdapter(
          ArrayList<User> userList,
          Context context) {

    this.userList = userList;
    this.context = context;
  }

  @Override
  public int getCount() {
    return userList.size();
  }

  @Override
  public Object getItem(int position) {
    return userList.get(position);
  }

  @Override
  public long getItemId(int position) {
    return userList.get(position).getId();
  }

  @Override
  public View getView(
          int position,
          View convertView,
          ViewGroup parent) {

    MyView dataItem;

    LayoutInflater inflater =
            (LayoutInflater)
                    context.getSystemService(
                            Context.LAYOUT_INFLATER_SERVICE
                    );

    if (convertView == null) {

      dataItem = new MyView();

      convertView = inflater.inflate(
              R.layout.user_disp_tpl,
              parent,
              false
      );

      dataItem.ivUser =
              convertView.findViewById(
                      R.id.iv_user
              );

      dataItem.tvUsername =
              convertView.findViewById(
                      R.id.tv_username
              );

      dataItem.tvProfile =
              convertView.findViewById(
                      R.id.tv_profile
              );

      convertView.setTag(dataItem);

    } else {

      dataItem =
              (MyView) convertView.getTag();
    }

    User user =
            userList.get(position);

    dataItem.tvUsername.setText(
            user.getUname()
    );

    dataItem.tvProfile.setText(
            user.getMeProfile()
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
            .into(dataItem.ivUser);

    return convertView;
  }

  private static class MyView {

    ImageView ivUser;
    TextView tvUsername;
    TextView tvProfile;
  }
}