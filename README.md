# How to run our project !

## Database Credentials

Within the main code base directory, you will find a file called DatabaseCredentials.java.
Simply fill in the required fields, and the database aspect of our application will run.

If the setup above is not performed, all tests cases that involve database querying will be skipped and the app will not run at all if you attempt to change the source of data to Oracle 
within the Admin/Employee apps. 

An error message will be displayed if credentials are not provided, and you will be 
provided instructions to further continue.

## Testing

Since we are testing reading/writing/deleting from sources, it is imperative that tests should be run before the app is run, in order to ensure that the tests cases are working with the same data. 

Have fun with our project !