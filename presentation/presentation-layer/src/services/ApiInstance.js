import DefaultApi from '../api/src/api/DefaultApi';
import ApiClient from '../api/src/ApiClient';

// Create and configure the API client
const apiClient = new ApiClient();

// Set backend URL
apiClient.basePath = 'http://localhost:8080';

// Create the API instance with configured client
export const Api = new DefaultApi(apiClient);