package pl.sapiens.javarestsoap.controller;

import lombok.extern.slf4j.Slf4j;
import pl.sapiens.javarestsoap.entity.Reservation;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.List;

import static javax.ws.rs.core.Response.Status.NOT_FOUND;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Slf4j
@Path("/reservations")
public class RestReservationController {

    private static final Reservation theOnlyOne = new Reservation(1L,
            "Nowak",
            13,
            LocalDateTime.now(),
            LocalDateTime.now().plusHours(2),
            "Main center",
            "Near window!!!");

    @GET
    public Response getReservation() {
        var dummyReservations = List.of(theOnlyOne);
        log.info("Getting all reservations");
        log.info("Number of found reservations: [{}]", dummyReservations.size());
        return Response.ok(dummyReservations).build();
    }

    @GET
    @Path("/{id}")
    public Response findReservationById(@PathParam("id") Long reservationId) {
        log.info("Trying to find reservation by id: [{}]", reservationId);
        //TODO: replace with itegration with service
        Response result;
        if (reservationId == 1L) {
            result = Response.ok(theOnlyOne).build();
        } else {
            result = Response.status(NOT_FOUND).build();
        }
        return result;
    }

    @POST
    public Response createReservation( Reservation toCreate) throws URISyntaxException {
        log.info("Trying to create reservation: [{}]:", toCreate);
        //TODO: use service, add validation
        URI location = new URI("/reservatons/2");
        return  Response.created(location).build();

    }
}


