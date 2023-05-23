# receipt-processor
Simple sample application to receive and process receipts and evaluate points against those receipts.

## Development process
I will be committing code often with detailed messages in such a way to illustrate the complete development
process, start to finish, so that the progress can be fully tracked.

## Development Choices and Reasoning
SpringBoot (Java) will be used to quickly provide HTTP API scaffolding and payload (de)serialization. 

### Code Organization/Package structure
While this initial application is quite simple, we will be organizing the code in such a way that 
we can readily replace adapter layers (API and data stores). The package structure will be as follows:

- `com.pthongsavanh.api` - API adapter layer code
- `com.pthongsavanh.service` - business logic layer
- `com.pthongsavanh.data` - Data formats, access, and persistence layer

## Running the application
The application will be runnable in a Docker container (Dockerfile). How to run:
1. TBD
