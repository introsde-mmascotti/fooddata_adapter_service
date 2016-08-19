#Fooddata adapter service
This webservice adapts the data retrieved from the [Nutritionix REST api](https://www.nutritionix.com/business/api) 
for the [Recipe service](https://github.com/introsde-mmascotti/recipe_service) and the 
[Recipe storage service](https://github.com/introsde-mmascotti/recipe_storage_service).  
The Nutritionix api is accessed via [Mashape](https://market.mashape.com/msilverman/nutritionix-nutrition-database), so the webservice 
requires a system environment variable named *mashape_key* which contains the key for accessing the Nutritionix webservice.
