package com.AccioIntern.BookMyShow.Services;

import com.AccioIntern.BookMyShow.Convertors.TheatreConvertors;
import com.AccioIntern.BookMyShow.DTOs.RequestDTOs.TheatreDTOs.TheatreCreationDTO;
import com.AccioIntern.BookMyShow.DTOs.ResponseDTOs.TheatreDTOs.TheatreResponseDTO;
import com.AccioIntern.BookMyShow.Enums.SeatType;
import com.AccioIntern.BookMyShow.Models.*;
import com.AccioIntern.BookMyShow.Repositories.MovieRepository;
import com.AccioIntern.BookMyShow.Repositories.ShowSeatRepository;
import com.AccioIntern.BookMyShow.Repositories.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class TheatreService {
    @Autowired
    TheatreRepository theatreRepository;
    @Autowired
    ShowSeatRepository showSeatRepository;
    @Autowired
    MovieRepository movieRepository;
    public String createTheatre(TheatreCreationDTO theatreCreationDTO) throws Exception{
        Theatre theatre = TheatreConvertors.theatreCreationDtotoTheatre(theatreCreationDTO);

        theatre.setTheatreSeats(makeTheatreSeats(theatreCreationDTO, theatre));

        theatreRepository.save(theatre);

        return "Theatre added successfully";
    }

    private List<TheatreSeat> makeTheatreSeats(TheatreCreationDTO theatreCreationDTO, Theatre theatre){
        int noOfBalcony = theatreCreationDTO.getNoOfBalconySeats();
        int noOfLower = theatreCreationDTO.getNoOfLowerSeats();
        int noOfMiddle = theatreCreationDTO.getNoOfMiddleSeats();

        List<TheatreSeat> seats = new ArrayList<>();

        for(int i = 1;i <= noOfLower;i++){
            TheatreSeat theatreSeat = TheatreSeat.builder()
                    .seatNo("L" + i)
                    .seatType(SeatType.LOWER)
                    .theatre(theatre)
                    .build();
            seats.add(theatreSeat);
        }
        for(int i = 1;i <= noOfMiddle;i++){
            TheatreSeat theatreSeat = TheatreSeat.builder()
                    .seatNo("M" + i)
                    .seatType(SeatType.MIDDLE)
                    .theatre(theatre)
                    .build();
            seats.add(theatreSeat);
        }
        for(int i = 1;i <= noOfBalcony;i++){
            TheatreSeat theatreSeat = TheatreSeat.builder()
                    .seatNo("B" + i)
                    .seatType(SeatType.BALCONY)
                    .theatre(theatre)
                    .build();
            seats.add(theatreSeat);
        }

        return seats;
    }

    public String theatresShowingParticularMovie(int movieId) throws Exception{
        Movie movie = movieRepository.findById(movieId).get();
        List<Show> showList = movie.getShows();
        if(showList.size() == 0){
            throw new Exception("No show is available");
        }
        List<TheatreResponseDTO> listOfTheatresShowingTheMovie = new ArrayList<>();
        for(Show show : showList){
            Theatre theatre = show.getTheatre();
            TheatreResponseDTO theatreResponseDTO = TheatreConvertors.theatreToTheatreResponseDTO(theatre);
            listOfTheatresShowingTheMovie.add(theatreResponseDTO);
        }
        return listOfTheatresShowingTheMovie.toString();
    }

    public String uniqueLocations() throws Exception{
        Set<String> setOfLocation = new HashSet<>();
        List<Theatre> theatres = theatreRepository.findAll();
        if(theatres.size() == 0){
            throw new Exception("No theatres are available");
        }
        for(Theatre theatre : theatres){
            setOfLocation.add(theatre.getLocation());
        }
        return new ArrayList<>(setOfLocation).toString();
    }
}
