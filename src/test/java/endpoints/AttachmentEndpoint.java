package endpoints;

public interface AttachmentEndpoint {

    String UPLOAD_ATTACHMENT = "https://api.qase.io/v1/attachment/%s";
    String GET_SPECIFIC_ATTACHMENT = "https://api.qase.io/v1/attachment/%s";
    String GET_ALL_ATTACHMENTS = "https://api.qase.io/v1/attachment";
    String DELETE_ATTACHMENT = "https://api.qase.io/v1/attachment/%s";
}
