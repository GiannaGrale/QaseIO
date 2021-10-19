package models;

import com.google.gson.annotations.Expose;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomField {
    @Expose
    CustomField result;
    @Expose
    int total;
    @Expose
    int filtered;
    @Expose
    int count;
    @Expose
    CustomField [] entities;
    @Expose
    int id;
    @Expose
    String title;
    @Expose
    String type;
    @Expose
    String placeholder;
    @Expose
    String default_value;
    @Expose
    String value;
    @Expose
    boolean is_required;
    @Expose
    boolean is_visible;
    @Expose
    boolean is_filterable;
}
