package models;

import com.google.gson.annotations.Expose;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    @Expose
    String status;
    @Expose
    User result;
    @Expose
    int total;
    @Expose
    int filtered;
    @Expose
    User[] entities;
    @Expose
    int id;
    @Expose
    String name;
    @Expose
    String email;
    @Expose
    String title;
    @Expose
    int statusNum;

}
