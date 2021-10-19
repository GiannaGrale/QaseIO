package models;

import com.google.gson.annotations.Expose;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Attachment {
    @Expose
    boolean status;
    @Expose
    Attachment result;
    @Expose
    int total;
    @Expose
    int filtered;
    @Expose
    Attachment[] entities;
    @Expose
    String hash;
    @Expose
    String file;
    @Expose
    String mime;
    @Expose
    int size;
    @Expose
    String full_path;
}

