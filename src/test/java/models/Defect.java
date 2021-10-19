package models;

import com.google.gson.annotations.Expose;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Defect {
    @Expose
    boolean status;
    @Expose
    Defect result;
    @Expose
    Defect [] entities;
    @Expose
    int id;
    @Expose
    String actual_result;
    @Expose
    String open;
    @Expose
    int user_id;
    @Expose
    String created;
    @Expose
    String updated;

}
