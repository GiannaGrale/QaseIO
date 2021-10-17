package endpoints;

public interface CasesEndpoints {
    String GET_ALL_CASES = "https://api.qase.io/v1/case/%s";
    String GET_SPECIFIC_CASE = "https://api.qase.io/v1/case/%s/%d";
    String DELETE_CASE = "https://api.qase.io/v1/case/%s/%d";

}
