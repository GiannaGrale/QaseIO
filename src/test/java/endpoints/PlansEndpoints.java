package endpoints;

public interface PlansEndpoints {
   String GET_PLANS = "https://api.qase.io/v1/plan/%s";
   String GET_SPECIFIC_PLAN = "https://api.qase.io/v1/plan/%s/%d";
   String CREATE_PLAN ="https://api.qase.io/v1/plan/%s";
   String UPDATE_PLAN = "https://api.qase.io/v1/plan/%s/%d";
   String DELETE_PLAN = "https://api.qase.io/v1/plan/%s/%d";
}
