## Find Best Plan v1.0

## Author
Li Tianhui

## Assumptions
- prices can be represented as integers

## Build
This project can be built by running following command which outputs executable jar file in target folder

```shell
mvn clean install
```

## Run
Extract jar file from target folder and execute following command where filename is local file (including full file path) with information on plans and features are features needed (separated by commas)

```shell
java -jar find-best-plan.jar $filename $features
```

## Improvement
Implement recursive function to find combination of plans with lowest cost by recursively reducing features required
