--This is the repository for eSamudaay take home assessment--

Basic functionality -

1. Create an API to calculate the total order price depending upon various factor defined in te problem statement
2. Created entities for different components for easy understanding and object oriented implementation
3. Different Json outputs for different exceptions
	code -> 2000 - "item quantity/price is more than allowed limit"
	code ->	2001 - "delivery distance is more than allowed limit"
	code -> 3000 - "error occurred during order placement"
4. Used distancefee data structre for distance fees based on distance (implemented binary search for faster calculation of fees)
5. Validator service is defined which handles absurd inputs

Instructios to run - 

1. clone the repo in the local system.
2. open the project in IDE eg. Eclipse or IntelliJ
3. build the project(Maven file is already created which will automatically import all the dependencies)
4. run the Main application once successfully built

