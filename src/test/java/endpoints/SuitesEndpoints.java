package endpoints;

public interface SuitesEndpoints {
    String ALL_SUITES = "https://api.qase.io/v1/suite/%s";
    String GET_SPECIFIC_SUITE = "https://api.qase.io/v1/suite/%s/%d";
    String POST_SUITE = "https://api.qase.io/v1/suite/%s";
    String UPDATE_SUITE = "https://api.qase.io/v1/suite/%s/%d";
    String DELETE_SUITE = "https://api.qase.io/v1/suite/%s/%d";

}
