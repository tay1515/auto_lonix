
##**README **

##**Run tests with gradle:**

```
./gradlew clean test
```

##**Run tests with gradle and specific tags:**

```
./gradlew clean test -DincludeTags='smoke'
```

To run tests in Firefox:

```
./gradlew clean test -Dwebdriver.driver=firefox
```

In windows:
```
gradlew clean test
```

##**Run tests with Maven:**

```
mvn clean verify -Ddriver=firefox
```
or try this:

```
mvn clean verify -Dwebdriver.driver=firefox
```

