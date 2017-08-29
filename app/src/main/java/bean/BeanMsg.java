package bean;

/**
 * Created by 蒋順聪 on 2017/8/29.
 */

public class BeanMsg {
    private String title;
    private String thumbnail_pic_s;

    @Override
    public String toString() {
        return "BeanMsg{" +
                "title='" + title + '\'' +
                ", thumbnail_pic_s='" + thumbnail_pic_s + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getThumbnail_pic_s() {
        return thumbnail_pic_s;
    }

    public void setThumbnail_pic_s(String thumbnail_pic_s) {
        this.thumbnail_pic_s = thumbnail_pic_s;
    }

    public BeanMsg() {

    }

    public BeanMsg(String title, String thumbnail_pic_s) {

        this.title = title;
        this.thumbnail_pic_s = thumbnail_pic_s;
    }
}
