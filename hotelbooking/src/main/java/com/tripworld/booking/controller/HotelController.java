package com.tripworld.booking.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tripworld.booking.model.Hotel;
import com.tripworld.booking.model.Message;
import com.tripworld.booking.model.Room;
import com.tripworld.booking.service.HotelService;
import com.tripworld.booking.service.RoomService;

@Controller
@RequestMapping("/")
public class HotelController {
	private final org.slf4j.Logger logger = LoggerFactory.getLogger(HotelController.class);


	@Autowired
	private HotelService hotelService;
	
	private Hotel hotel;
	private final String HOTEL_NAME = "RAVIZ";
	List<Hotel> hotels = new ArrayList<Hotel>();
	private MessageSource messageSource;
	private RoomService roomService;
   

    /* Search Hotel list */
    @RequestMapping(method = RequestMethod.GET)
    public String hotelList(Model model) {
       // logger.info("Listing hotels");
        if (hotel == null) {
        	/* Here add new hotel */
        	hotel = new Hotel();
        }
        hotel = hotelService.searchByName(HOTEL_NAME);
        setHotelAttributes(model);
        return "list";
    }
    
    
    
    /* Create new Hotel */
    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String createHotel(@Valid Hotel hotel, BindingResult bindingResult, Model model,
            HttpServletRequest httpServletRequest, RedirectAttributes redirectAttributes,
            Locale locale) {
    	//logger.info("Creating room");
        hotel.setHotelName(HOTEL_NAME);
        if (bindingResult.hasErrors()) {
            model.addAttribute("message", new Message("error",
                    messageSource.getMessage("hotel_save_error", new Object[]{}, locale)));
            setHotelAttributes(model);
            return "new";
        }
        model.asMap().clear();
        redirectAttributes.addFlashAttribute("message", new Message("success",
                messageSource.getMessage("room_save_success_text", new Object[]{}, locale)));
        hotelService.save(hotel);
        logger.info("Room id: " + hotel.getId());
        return "redirect:/";
    }
        //Hotel hotel = new Hotel();
        //setHotelAttributes(model);
        //return "new";
    

    /* Set hotel attributes */
    private void setHotelAttributes(Model model) {
        model.addAttribute("hotel", hotel);
        
    }
    
    /* Delete Hotel from list */
    @RequestMapping(value = "/{hotelId}", params = "delete", method = RequestMethod.GET)
    public String deleteRoom(@PathVariable("hotel_id") int hotel_id, Model model) {
    	hotelService.delete(hotel_id);
        return "";
    }

    
    /* Add new room to hotel */
    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String createRoom(@Valid Room room, BindingResult bindingResult, Model model,
                             HttpServletRequest httpServletRequest, RedirectAttributes redirectAttributes,
                             Locale locale) {
        logger.info("Creating room");
        if (bindingResult.hasErrors()) {
            model.addAttribute("message", new Message("error",
                    messageSource.getMessage("room_save_error_text", new Object[]{}, locale)));
            setHotelAttributes(model);
            setRoomAttributes(model, room);
            return "new";
        }
        redirectAttributes.addFlashAttribute("message", new Message("success",
                messageSource.getMessage("room_save_success_text", new Object[]{}, locale)));
        roomService.save(room);
        logger.info("Room id: " + room.getRoomId());
        return "redirect:/";
    }
    
    /* Set room attributes */
    private void setRoomAttributes(Model model, Room room) {
        
        model.addAttribute("roomId");
        model.addAttribute("description");
        model.addAttribute("hotelID");
    }


}