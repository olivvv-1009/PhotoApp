package thanhdnh.ueh.edu.article_app;

import android.app.Activity;
import android.content.Context;
import android.widget.GridView;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UserData {

  public static UserList data;

  private final Context context;
  private final GridView gridview;

  private final ExecutorService executor =
          Executors.newSingleThreadExecutor();

  public UserData(Context context, GridView gridview) {
    this.context = context;
    this.gridview = gridview;
  }

  public static User getUserFromId(int id) {

    if (data == null || data.getUsers() == null) {
      return null;
    }

    for (User user : data.getUsers()) {

      if (user.getId() == id) {
        return user;
      }
    }

    return null;
  }

  public void loadData(String url, Activity activity) {

    executor.execute(() -> {

      File file = Downloader.downloadFile(
              url,
              context.getCacheDir()
      );

      if (file == null) {
        return;
      }

      String json = readText(file);

      activity.runOnUiThread(() -> {

        Gson gson = new Gson();

        data = gson.fromJson(
                json,
                UserList.class
        );

        if (data != null && data.getUsers() != null) {

          UserAdapter adapter =
                  new UserAdapter(
                          data.getUsers(),
                          context
                  );

          gridview.setAdapter(adapter);
        }
      });
    });
  }

  private String readText(File file) {

    StringBuilder result =
            new StringBuilder();

    try {

      InputStream inputStream =
              new FileInputStream(file);

      BufferedReader reader =
              new BufferedReader(
                      new InputStreamReader(inputStream)
              );

      String line;

      while ((line = reader.readLine()) != null) {
        result.append(line);
      }

      reader.close();

    } catch (Exception e) {

      e.printStackTrace();
    }

    return result.toString();
  }
}