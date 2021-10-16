package adapters;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class BaseAdapter {
        Gson gson;

        public BaseAdapter() {
            this.gson = new GsonBuilder()
                    .excludeFieldsWithoutExposeAnnotation()
                    .create();
    }
}
