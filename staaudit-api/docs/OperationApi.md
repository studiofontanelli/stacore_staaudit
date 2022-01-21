# OperationApi

All URIs are relative to *https://127.0.0.1:8080/staaudit/*

Method | HTTP request | Description
------------- | ------------- | -------------
[**saveOperation**](OperationApi.md#saveOperation) | **POST** /operation/save | Save operation


<a name="saveOperation"></a>
# **saveOperation**
> saveOperation(request)

Save operation

Effettua il tracciamento dell&#39;operazione effettuata

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.OperationApi;


OperationApi apiInstance = new OperationApi();
RequestSalvaOperazione request = new RequestSalvaOperazione(); // RequestSalvaOperazione | 
try {
    apiInstance.saveOperation(request);
} catch (ApiException e) {
    System.err.println("Exception when calling OperationApi#saveOperation");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **request** | [**RequestSalvaOperazione**](RequestSalvaOperazione.md)|  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

