package bean;

import java.util.List;

/**
 * Created by 蒋順聪 on 2017/8/29.
 */

public class BeanJson {

    public Result result;
    public class Result{
        public List<Data> data;
        public class Data{
            public String title;
            public String thumbnail_pic_s;
        }
    }

}
