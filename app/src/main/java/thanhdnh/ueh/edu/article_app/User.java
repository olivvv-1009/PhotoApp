package thanhdnh.ueh.edu.article_app;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {

  @SerializedName("id")
  @Expose
  private int id;

  @SerializedName("uname")
  @Expose
  private String uname;

  @SerializedName("password")
  @Expose
  private String password;

  @SerializedName("me-profile")
  @Expose
  private String meProfile;

  @SerializedName("short-bio")
  @Expose
  private String shortBio;

  @SerializedName("image")
  @Expose
  private String image;

  public User(int id,
              String uname,
              String password,
              String meProfile,
              String shortBio,
              String image) {

    this.id = id;
    this.uname = uname;
    this.password = password;
    this.meProfile = meProfile;
    this.shortBio = shortBio;
    this.image = image;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getUname() {
    return uname;
  }

  public void setUname(String uname) {
    this.uname = uname;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getMeProfile() {
    return meProfile;
  }

  public void setMeProfile(String meProfile) {
    this.meProfile = meProfile;
  }

  public String getShortBio() {
    return shortBio;
  }

  public void setShortBio(String shortBio) {
    this.shortBio = shortBio;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }
}