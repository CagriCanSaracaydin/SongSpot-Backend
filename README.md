# SongSpot Backend API Documentation

## Project Overview
**SongSpot** is a revolutionary mobile application designed to become the "IMDB for music." It serves as a comprehensive music discovery and rating platform. The backend API supports a robust music database and facilitates user interactions, enabling features such as song exploration, commenting, and rating.

## API Endpoints

### GET `/api/v1/songs`
- **Description:** Retrieves a list of all songs in the database.
- **Returns:** JSON array of song details.

### GET `/api/v1/songs/{id}`
- **Description:** Fetches details of a song identified by its unique ID.
- **Returns:** JSON object of song details.

### GET `/api/v1/songs/genre/{genre}`
- **Description:** Retrieves songs filtered by genre.
- **Returns:** JSON array of song details.

### GET `/api/v1/comments/song/{songId}`
- **Description:** Retrieves all comments for a specific song.
- **Returns:** JSON array of comments.

### POST `/api/v1/comments`
- **Description:** Posts a new comment on a song.
- **Body:** 
  ```json
  {
    "songId": 1,
    "username": "user123",
    "comment": "Great song!"
  }
  ```
- **Returns:** 
  ```json
  {
    "result": "success"
  }
  ```

### POST `/api/v1/ratings`
- **Description:** Allows users to rate a song.
- **Body:** 
  ```json
  {
    "songId": 1,
    "username": "user456",
    "rating": 5
  }
  ```
- **Returns:** 
  ```json
  {
    "result": "success"
  }
  ```

## Purpose and Impact
The **SongSpot API** handles essential data management tasks, maintaining song properties like artist and genre. It also supports user interactions such as commenting and rating. This API is integral to the application’s goal of amplifying visibility for new artists and providing a dynamic platform for music lovers to explore and engage with music. By leveraging this backend, SongSpot aims to enhance user experience and foster a vibrant community of music enthusiasts.
