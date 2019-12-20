### Android Application for Siemens MakeITReal 2019 Hackathon



**Required libraries :** 

0: **Dagger Android** : Dependency Injection Framework

1: Butterknife : Injecting views

2: Android Architecture Components -- ViewModel and LiveData

3: Retrofit and GSON : for Api Requests

4: Material Design Components MDC

5: RxJava 2

6: Firebase Cloud messaging : For sending real time notifications


## Naming Patterns

**layouts**
`type_name`




|||
|--|--|
|MainActivity|activity_main|
|HomeFragment|fragment_home|
|for listLayouts in recyclers etc|item_user|




## Project Structure

| directory/files |purpose  |
|--|--|
|  `data`| Contains Data Services , REST API calls , Firebase, Shared Prefs   |
|`AppDataManager`|Encapsulates all data sources into a single entity by combining the interfaces and implementing them|
|`base`|Contains Base classes|
|`di`|Contains di modules and components|
|`di->modules`|has modules for fragments and activities. They provide dependencies|
|`di->components`|has components for dagger|
|`ui`|contains the Activities and Fragments . The hierarchy is followed as Application ==> Activities ==> Fragments. An Application is a single entity of the application. But it can have multiple Activities. Each Activity also can have multiple fragments.|
|`ViewModels`|Each Activity has its own view model. View model connects data to view. An Activity can access its `own` view model and `appViewModel`. 
|`config`|contains configuration keys. The Base URL for the app.|


