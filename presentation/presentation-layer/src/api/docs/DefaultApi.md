# RJTourismAPI.DefaultApi

All URIs are relative to *http://localhost*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addLike**](DefaultApi.md#addLike) | **POST** /v1/content/add-like | Add a like to a post with a given user ID and post ID.
[**authenticateUser**](DefaultApi.md#authenticateUser) | **POST** /v1/authentication/authenticate-user | For a given username and password, authenticate them.
[**calculateAchievement**](DefaultApi.md#calculateAchievement) | **GET** /v1/account/calculate-achievement/{userId} | Calculate the achievements for a given user ID.
[**createPost**](DefaultApi.md#createPost) | **POST** /v1/content/create-post | Create a post with a given title and content.
[**createUser**](DefaultApi.md#createUser) | **POST** /v1/account/create-user | Create a user account with a given username and password.
[**deleteComment**](DefaultApi.md#deleteComment) | **DELETE** /v1/content/delete-comment/{commentId} | Delete a comment with a given comment ID.
[**deletePost**](DefaultApi.md#deletePost) | **DELETE** /v1/content/delete-post/{postId} | Delete a post with a given post ID.
[**fetchLikes**](DefaultApi.md#fetchLikes) | **GET** /v1/content/fetch-likes/{postId} | Fetch the number of likes for a given post ID.
[**fetchPosts**](DefaultApi.md#fetchPosts) | **GET** /v1/content/fetch-posts | Fetch all posts.
[**getLike**](DefaultApi.md#getLike) | **GET** /v1/content/get-like | Get the like status for a given user ID and post ID.
[**pingAuth**](DefaultApi.md#pingAuth) | **GET** /v1/authentication | Ping authentication controller to see if it is reachable



## addLike

> addLike(opts)

Add a like to a post with a given user ID and post ID.

### Example

```javascript
import RJTourismAPI from 'rjtoursim-api-client';

let apiInstance = new RJTourismAPI.DefaultApi();
let opts = {
  'likeRequest': new RJTourismAPI.LikeRequest() // LikeRequest | 
};
apiInstance.addLike(opts).then(() => {
  console.log('API called successfully.');
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **likeRequest** | [**LikeRequest**](LikeRequest.md)|  | [optional] 

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: Not defined


## authenticateUser

> authenticateUser(opts)

For a given username and password, authenticate them.

### Example

```javascript
import RJTourismAPI from 'rjtoursim-api-client';

let apiInstance = new RJTourismAPI.DefaultApi();
let opts = {
  'userCredentials': new RJTourismAPI.UserCredentials() // UserCredentials | 
};
apiInstance.authenticateUser(opts).then(() => {
  console.log('API called successfully.');
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userCredentials** | [**UserCredentials**](UserCredentials.md)|  | [optional] 

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: Not defined


## calculateAchievement

> CalculateAchievementResponse calculateAchievement(userId)

Calculate the achievements for a given user ID.

### Example

```javascript
import RJTourismAPI from 'rjtoursim-api-client';

let apiInstance = new RJTourismAPI.DefaultApi();
let userId = 56; // Number | 
apiInstance.calculateAchievement(userId).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userId** | **Number**|  | 

### Return type

[**CalculateAchievementResponse**](CalculateAchievementResponse.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## createPost

> createPost(opts)

Create a post with a given title and content.

### Example

```javascript
import RJTourismAPI from 'rjtoursim-api-client';

let apiInstance = new RJTourismAPI.DefaultApi();
let opts = {
  'createPostRequest': new RJTourismAPI.CreatePostRequest() // CreatePostRequest | 
};
apiInstance.createPost(opts).then(() => {
  console.log('API called successfully.');
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **createPostRequest** | [**CreatePostRequest**](CreatePostRequest.md)|  | [optional] 

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: Not defined


## createUser

> createUser(opts)

Create a user account with a given username and password.

### Example

```javascript
import RJTourismAPI from 'rjtoursim-api-client';

let apiInstance = new RJTourismAPI.DefaultApi();
let opts = {
  'userCredentials': new RJTourismAPI.UserCredentials() // UserCredentials | 
};
apiInstance.createUser(opts).then(() => {
  console.log('API called successfully.');
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **userCredentials** | [**UserCredentials**](UserCredentials.md)|  | [optional] 

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: Not defined


## deleteComment

> deleteComment(commentId)

Delete a comment with a given comment ID.

### Example

```javascript
import RJTourismAPI from 'rjtoursim-api-client';

let apiInstance = new RJTourismAPI.DefaultApi();
let commentId = 56; // Number | 
apiInstance.deleteComment(commentId).then(() => {
  console.log('API called successfully.');
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **commentId** | **Number**|  | 

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined


## deletePost

> deletePost(postId)

Delete a post with a given post ID.

### Example

```javascript
import RJTourismAPI from 'rjtoursim-api-client';

let apiInstance = new RJTourismAPI.DefaultApi();
let postId = 56; // Number | 
apiInstance.deletePost(postId).then(() => {
  console.log('API called successfully.');
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **postId** | **Number**|  | 

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined


## fetchLikes

> FetchLikesResponse fetchLikes(postId)

Fetch the number of likes for a given post ID.

### Example

```javascript
import RJTourismAPI from 'rjtoursim-api-client';

let apiInstance = new RJTourismAPI.DefaultApi();
let postId = 56; // Number | 
apiInstance.fetchLikes(postId).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **postId** | **Number**|  | 

### Return type

[**FetchLikesResponse**](FetchLikesResponse.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## fetchPosts

> FetchPostsResponse fetchPosts()

Fetch all posts.

### Example

```javascript
import RJTourismAPI from 'rjtoursim-api-client';

let apiInstance = new RJTourismAPI.DefaultApi();
apiInstance.fetchPosts().then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters

This endpoint does not need any parameter.

### Return type

[**FetchPostsResponse**](FetchPostsResponse.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json


## getLike

> GetLikeResponse getLike(opts)

Get the like status for a given user ID and post ID.

### Example

```javascript
import RJTourismAPI from 'rjtoursim-api-client';

let apiInstance = new RJTourismAPI.DefaultApi();
let opts = {
  'likeRequest': new RJTourismAPI.LikeRequest() // LikeRequest | 
};
apiInstance.getLike(opts).then((data) => {
  console.log('API called successfully. Returned data: ' + data);
}, (error) => {
  console.error(error);
});

```

### Parameters


Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **likeRequest** | [**LikeRequest**](LikeRequest.md)|  | [optional] 

### Return type

[**GetLikeResponse**](GetLikeResponse.md)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json


## pingAuth

> pingAuth()

Ping authentication controller to see if it is reachable

### Example

```javascript
import RJTourismAPI from 'rjtoursim-api-client';

let apiInstance = new RJTourismAPI.DefaultApi();
apiInstance.pingAuth().then(() => {
  console.log('API called successfully.');
}, (error) => {
  console.error(error);
});

```

### Parameters

This endpoint does not need any parameter.

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: Not defined

