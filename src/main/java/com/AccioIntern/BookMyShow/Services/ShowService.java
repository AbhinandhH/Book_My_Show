package com.AccioIntern.BookMyShow.Services;

import com.AccioIntern.BookMyShow.Convertors.SeatConvertors;
import com.AccioIntern.BookMyShow.Convertors.ShowConvertors;
import com.AccioIntern.BookMyShow.DTOs.RequestDTOs.ShowDTOs.ShowCreationDTO;
import com.AccioIntern.BookMyShow.Enums.ShowTypes;
import com.AccioIntern.BookMyShow.Models.*;
import com.AccioIntern.BookMyShow.Repositories.MovieRepository;
import com.AccioIntern.BookMyShow.Repositories.ShowRepository;
import com.AccioIntern.BookMyShow.Repositories.ShowSeatRepository;
import com.AccioIntern.BookMyShow.Repositories.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ShowService {
    @Autowired
    ShowRepository showRepository;
    @Autowired
    MovieRepository movieRepository;
    @Autowired
    TheatreRepository theatreRepository;
    @Autowired
    ShowSeatRepository showSeatRepository;

    public String createShow(ShowCreationDTO showCreationDTO) throws Exception{
        Movie movie;
        try{
            movie  = movieRepository.findById(showCreationDTO.getMovieId()).get();
        }catch(Exception e){
            throw new Exception("Movie is not found");
        }

        Theatre theatre;
        try{
            theatre  = theatreRepository.findById(showCreationDTO.getTheatreId()).get();
        }catch (Exception e){
            throw new Exception("theatre is not found");
        }
        Show show = ShowConvertors.showCreationDtoToShow(showCreationDTO);

        List<TheatreSeat> theatreSeats = theatre.getTheatreSeats();

        List<ShowSeat> showSeats = makeShowSeatList(showCreationDTO, theatreSeats, show);

        show.setMovie(movie);
        show.setTheatre(theatre);
        show.setSeats(showSeats);
        show.setCreatedOn(LocalDate.now());
        if(showCreationDTO.getShowType().equals(ShowTypes.TWO_D)){
            show.setShowPrice(showCreationDTO.getTwoDShowPrice());
        }else if(showCreationDTO.getShowType().equals(ShowTypes.THREE_D)){
            show.setShowPrice(showCreationDTO.getThreeDShowPrice());
        }

        showRepository.save(show);

        movie.getShows().add(show);
        movieRepository.save(movie);

        theatre.getShows().add(show);
        theatreRepository.save(theatre);

        return "Show added successfully";
    }

    private List<ShowSeat> makeShowSeatList(ShowCreationDTO showCreationDTO, List<TheatreSeat> theatreSeats, Show show){
        List<ShowSeat> showSeats = new ArrayList<>();
        for(TheatreSeat theatreSeat : theatreSeats){
            ShowSeat showSeat = SeatConvertors.theatreSeatToShowSeat(theatreSeat,show,showCreationDTO);
            showSeats.add(showSeat);
        }
        return showSeats;
    }




}
