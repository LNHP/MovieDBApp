# MovieApp_LongDo
Overview

You are about to implement an app that helps user view movies information. User can keep their favourite movies in offline mode to view even when there is no internet available.
This assignment requires you to use the API from TheMovieDB website for obtain necessary information.

Functionalities

You application should have following functionalities:

1. On launching the app, home screen should show a grid of movie poster. Within home screen: 
- Allow user to choose different settings to display like: most popular movies, most rated movies, favourite movies.
- On tapping on poster, user will be redirected to movie detail screen.

2. Movie detail screen contains the information:
- original title
- movie poster image thumbnail
- A plot synopsis (called overview in the api)
- user rating (called vote_average in the api)
- release date

3. Movie detail screen must display a list of available trailers for that movie. On tapping on trailer item, user can play the trailer in youtube app or a web-browser.

4. User can read the reviews of a selected movie.

5. You’ll help user to mark a movie as a favourite in the details view by tapping a button (star button). This action will add the movie to local movies collection and do not need to make any API request.

6. Your app must work well on both phone and tablet, with optimized experience for tablet.

7. Your local movies collection will be synced with cloud services (Parse is highly recommended, or Firebase is another option here) with user’s account. User must be able to create their account and keep their data private. 

8. You app should be able to run on device with Android 4.2 or later with consistent User Experience.
