# Deploy

1. Compile front end:

Run this from the Angular code (UI):
```
ng build --base-href=/MealAndGroceryBuilder_war/ --deploy-url=/MealAndGroceryBuilder_war/ --prod --output-path=../src/main/webapp/static
```

2. Build the WAR file
   
3. Copy th war file from target/MealAndGroceryBuilder.war and upload it to ec2