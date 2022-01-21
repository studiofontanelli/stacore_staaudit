# TestApi

All URIs are relative to *https://127.0.0.1:8080/staaudit/*

Method | HTTP request | Description
------------- | ------------- | -------------
[**testResources**](TestApi.md#testResources) | **GET** /test/resources | Test resources


<a name="testResources"></a>
# **testResources**
> GenericResponse testResources()

Test resources

Effettua il test dei servizi richiamati

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.TestApi;


TestApi apiInstance = new TestApi();
try {
    GenericResponse result = apiInstance.testResources();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling TestApi#testResources");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**GenericResponse**](GenericResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

