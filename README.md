# receipt-processor
Simple sample application to receive and process receipts and evaluate points against those receipts.

## Development process
I will be committing code often with detailed messages in such a way to illustrate the complete development
process, start to finish, so that the progress can be fully tracked.

## Development Choices and Reasoning
SpringBoot (Java) will be used to quickly provide HTTP API scaffolding and payload (de)serialization.
In addition, Lombok is used to to reduce code around Java object definition.

### Code Organization/Package structure
While this initial application is quite simple, we will be organizing the code in such a way that 
we can readily replace adapter layers (API and data stores). The package structure will be as follows:

- `com.pthongsavanh.api` - API adapter layer code
- `com.pthongsavanh.service` - business logic layer
- `com.pthongsavanh.data` - Data formats, access, and persistence layer

## Running the application
The application will be runnable in a Docker container (Dockerfile).

How to run:
1. TODO

## Running unit tests
Unit tests will be runnable via docker as well (output will be the Maven build).

How to run:
1. TODO

## MAJOR TODOS
1. add validation for receipt data
1. Rules to implement
  - 5 points for every two items on the receipt.
  - If the trimmed length of the item description is a multiple of 3, multiply the price by 0.2 and round up to the nearest integer. The result is the number of points earned.
  - 6 points if the day in the purchase date is odd.
  - 10 points if the time of purchase is after 2:00pm and before 4:00pm.
