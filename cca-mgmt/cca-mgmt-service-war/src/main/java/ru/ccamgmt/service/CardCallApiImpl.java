package ru.ccamgmt.service;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import ru.ccamgmt.contracts.FormSectionsResponse;
import ru.ccamgmt.service.handler.CardCallHandler;
import ru.ccamgmt.service.handler.UserHandler;
import ru.ccamgmt.stubs.CardCallApi;
import ru.ccamgmt.stubs.NotFoundException;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by Yuriy Stolyarenko on 01.11.2015.
 */
@Path("/cardCall")
@Api(value = "/cardCall", description = "the cardCall API")
@Stateless
public class CardCallApiImpl implements CardCallApi {

    @EJB
    CardCallHandler cardCallHandler;

    @GET
    @Path("/formSections")
    @ApiOperation(value = "Get sections and questions", notes = "This method returns a list of questions and answers", response = FormSectionsResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Response with actual data"),

            @ApiResponse(code = 400, message = "Bad request"),

            @ApiResponse(code = 404, message = "Not Found") })
    @Override
    @Produces(MediaType.APPLICATION_JSON)
    public Response cardCallFormSectionsGet() throws NotFoundException {
        return cardCallHandler.sectionListHandler();
    }
}
