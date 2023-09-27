package com.example.service;

import com.example.domain.entity.Actor;
import com.example.domain.entity.Director;
import com.example.domain.entity.Movie;
import com.example.domain.response.MovieResponse;
import com.example.repository.MovieRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MovieServiceMockTest {
    @Mock
    private MovieRepository movieRepository;

    @Mock
    private LogService logService;

    @InjectMocks
    private MovieService movieService;

    @Test
    public void 영화단건_조회_테스트(){
        int movieId = 1;
        Movie movie = new Movie();
        movie.setName("하이");
        movie.setDirector(new Director());
        movie.setActors(List.of(new Actor()));


        when(movieRepository.findById(anyLong())).thenReturn(Optional.of(movie));
        //when(movieRepository.findById(anyLong())).thenReturn(null);

        MovieResponse result = movieService.getMovie(movieId);
        assertNotNull(result);
        //assertThrows(NullPointerException.class, () -> movieService.getMovie(movieId));
    }
    @Test
    public void 영화불량조회_테스트(){
        int movieId = 1;
        Movie movie = new Movie();
        movie.setName("하이");
        movie.setDirector(new Director());
        movie.setActors(List.of(new Actor()));


        //when(movieRepository.findById(anyLong())).thenReturn(Optional.of(movie));
        when(movieRepository.findById(anyLong())).thenReturn(null);

        //MovieResponse result = movieService.getMovie(movieId);
        //assertNotNull(result);
        assertThrows(NullPointerException.class, () -> movieService.getMovie(movieId));
    }
}
