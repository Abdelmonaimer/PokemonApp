# PokemonApp

This is a mobile application built using Android Studio and Java that retrieves data from the Pokemon API and displays it in a user interface.

![PokemonApp (1)](https://user-images.githubusercontent.com/121363683/231857636-e4dd1aa7-fac4-4fbc-8314-8f6c065331f8.gif)



## Features
View a list of all Pokemon
View details about each Pokemon, including type, height, weight, and abilities

## Installation
To use this app, you will need to have Android Studio installed on your computer. Once you have cloned or downloaded the repository, open the project in Android Studio and run it on an emulator or a physical device.

## Usage
Upon launching the app, you will be presented with a list of all Pokemon. You can tap on any Pokemon to view its details.

## API
This app uses the Pokemon API to retrieve data about Pokemon. The API is open source and free to use.

## Credits
This app was created by ERRAJI Abdelmonaim for a school project. It is not affiliated with the Pokemon Company.


# Code Explanation
This will help you understand more the code used in this project,

## MainActivity 1 :

The first activity contains a button that guides you directly to another Activity (named MainActivity 2 in my case) that shows all the pokemons.
![image](https://user-images.githubusercontent.com/121363683/231844963-ed7aa941-e08d-4ebf-bc4b-b7ef6d72c8c0.png)

## MainActivity 2 :
![image](https://user-images.githubusercontent.com/121363683/231849751-d3b12a44-b1ee-4d8e-9dc7-1cf4a23f716c.png)

This code sets up a RecyclerView with a custom adapter and a fixed grid layout. It also adds an OnScrollListener to the RecyclerView to load more data when the user scrolls to the end of the list.

First, it creates a new instance of the custom adapter for the RecyclerView and sets it to the RecyclerView. Then it sets the RecyclerView's layout manager to a new instance of GridLayoutManager with a span count of 2. The RecyclerView is also set to have a fixed size.

Finally, an OnScrollListener is added to the RecyclerView, which listens for scrolling events. When the user scrolls, it checks if the scroll is in the positive Y direction (scrolling down). If it is, it checks if the last item in the list is visible by comparing the number of visible items to the total number of items in the list. If the last item is visible, it increments an offset variable and calls the takeData method to load more data into the RecyclerView. The toChange variable is used to ensure that the takeData method is called only once per scroll event.


### recyclerView.addOnItemTouchListener(new RecyclerClickListener(MainActivity2.this, recyclerView, new RecyclerClickListener.OnItemClickListener()..
This code adds a touch listener to the RecyclerView, which listens for clicks on the items in the list. It uses a custom implementation of the RecyclerView.OnItemTouchListener interface called RecyclerClickListener. This implementation takes an OnItemClickListener interface as a parameter, which defines two methods: onItemClick() and onItemLongClick().


## PikachuActivity :

Retrofit : Retrofit client that is configured to make requests to the PokeAPI's base URL and convert the responses to JSON format using the Gson library. This client can then be used to make HTTP requests and receive responses from the PokeAPI.

Now the methodes used in my code :
### getdonnee() :
This method uses Retrofit to retrieve data from the PokeAPI and updates the UI with the retrieved data.

![image](https://user-images.githubusercontent.com/121363683/231846770-5ae4ed09-ce8c-4584-af13-94b37af54393.png)
Creation of an instance of the PokeapiService interface using the Retrofit client. The PokeapiService interface is used to define the API endpoints that the client will be communicating with.

![image](https://user-images.githubusercontent.com/121363683/231846923-05122149-2299-4d2a-a20b-3d7251b1f5b2.png)
Call object that will be used to make a request to the API using the getPokemon method defined in the PokeapiService interface. The index variable is passed as a parameter to the getPokemon method, which specifies which Pokemon to retrieve.

![image](https://user-images.githubusercontent.com/121363683/231847139-8b35b6a9-9f3e-4554-90f5-ebdb7bc861ca.png)
enqueues the Call object to be executed asynchronously in the background. The Callback object that is passed in will be used to handle the response when it is received from the API.

![image](https://user-images.githubusercontent.com/121363683/231847890-b418fcc3-78f3-4a88-ab90-1e97ec9d9f1c.png)
This line uses the Glide library to load the official artwork image of the Pokemon from the PokeAPI and set it as the image for the imageView object.

The rest of the code updates the UI with additional data from the API response, such as the weight and height of the Pokemon, as well as its stats.

### takeData() :

This method is used to retrieve data about a Pokémon's types from the Pokeapi API and display it on the screen. It uses the Retrofit library to make an HTTP request to the API and parse the response into a Java object.

First, it creates a new instance of the PokeapiService interface using the retrofit object that was created earlier. Then, it calls the getPokemon() method on the PokeapiService object, passing in the index variable as a parameter. This retrieves information about a specific Pokémon based on its index number.

The enqueue() method is then called on the pokemonRequestCall object, which sends the request asynchronously and executes the callbacks on a background thread.

When the response is received, the onResponse() method of the Callback interface is called, which retrieves the Pokemon object from the response body.

Next, it creates a LinearLayout to hold the type information, and retrieves a list of Type objects from the Pokemon object. It then loops through each Type object, creates a new TextView to display the type name, sets its properties such as width, height, and margin, and adds it to the layout.

For each type, it also sets the background color of the TextView to a specific color based on the type using the TypesColors.getColorByType() method, which maps the type name to a color value.

Finally, if the API request fails, the onFailure() method of the Callback interface is called, which does not display any data.

### createLoadingAnimation() :

This method creates a loading animation for a given progress bar and text view based on a base stat and effort values.

First, the method calculates the maximum progress value based on the base stat and the width of the progress bar. Then, it sets the progress of the progress bar to zero and starts an ObjectAnimator to animate the progress from zero to the calculated maximum progress value. The duration of the animation is set to 1500 milliseconds.

The method also adds an update listener to the animator to update the progress text view during the animation. The text view displays the base stat value and is updated as the progress value changes.


