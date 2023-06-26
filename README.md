# appium-tests
Android App Automation Tests using Appium and Cucumber UI in Java

## Application Specs

* Android application used for this project is taken from https://github.com/haroldadmin/MovieDB 

  * Client application allows you to view list of movies
  * Search for a movie
  * View details of a movie
  * View cast biography
  * Add a movie to watchlist
 
## Setup 

* Download latest version Appium Server GUI from https://github.com/appium/appium-desktop  
  * Start server with Host: 0.0.0.0 and Port: 4723
    
* Download Appium Inspector from https://github.com/appium/appium-inspector

* Download latest version of Android Studio from https://developer.android.com/studio

* Download proxy tool, e.g. https://mitmproxy.org


## Appium Automation Tests

* Scenario: Go to movie details

* Scenario: Search for a movie

## Cucumber UI Features 

* Go to Movie Detail Screen

  Scenario: The user can move to movie detail screen
    * Click on first movie from the list. Verify that correct movie name is appering on details screen

* Search for a Movie

  Scenario: The user can search for a movie
    * Click on search bar and write a name of movie. Verify that search results only contain the list of movies with samilar name

* View Movie Cast Details

  Scenario: The user can view movie cast biography
    * Click on first movie from the list. Click on the second cast member from detail screen. Verify that correct cast member name is appearing on cast biography screen

* Change Country From App Settings

  Scenario: The user can change country from app settings
    * Click on application settings and select second country from the list. Verify that second country from the list is showing in Theatres Screen

## Network Tests

set this capability to simulate Slow Internet Connection
```
caps.setCapability("networkSpeed", "lte");
```
