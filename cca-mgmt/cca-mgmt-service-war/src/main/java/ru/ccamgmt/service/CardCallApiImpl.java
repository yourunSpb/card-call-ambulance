package ru.ccamgmt.service;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import ru.ccamgmt.contracts.*;
import ru.ccamgmt.service.handler.CardCallHandler;
import ru.ccamgmt.stubs.CardCallApi;
import ru.ccamgmt.stubs.NotFoundException;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
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

    @POST
    @Path("/addOrEdit")
    @ApiOperation(value = "add or update card call", notes = "", response = MedicsResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Response with actual data"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 404, message = "Not Found")})
    @Override
    @Produces(MediaType.APPLICATION_JSON)
    public Response cardCallAddOrEditPost(@ApiParam(value = "", required = true) AddCardCallRequest body) throws NotFoundException {
        return cardCallHandler.addOrEditHandler(body);
    }

    @GET
    @Path("/cardCallById")
    // CardCallResponse
    @ApiOperation(value = "Get Card Call by Id", notes = "This method returns Card Call By Id", response = CardCallResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Response with actual data"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 404, message = "Not Found") })
    @Override
    @Produces(MediaType.APPLICATION_JSON)
    public Response cardCallCardCallByIdGet(@ApiParam(value = "card call id", required = true) @PathParam("cardCallId") Long cardCallId) throws NotFoundException {
        return cardCallHandler.getCardCallIdHandler(cardCallId);
    }


    @GET
    @Path("/departmentList")
    @ApiOperation(value = "Get all the departments at the substation", notes = "This method returns list of Departments", response = DepartmentsResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Response with actual data"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 404, message = "Not Found")})
    @Override
    @Produces(MediaType.APPLICATION_JSON)
    public Response cardCallDepartmentListGet() throws NotFoundException {
        return cardCallHandler.cardCallDepartmentListHandler();
    }

    @GET
    @Path("/formSections")
    @ApiOperation(value = "Get sections and questions", notes = "This method returns a list of questions and answers", response = FormSectionsResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Response with actual data"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 404, message = "Not Found")})
    @Override
    @Produces(MediaType.APPLICATION_JSON)
    public Response cardCallFormSectionsGet() throws NotFoundException {
        return cardCallHandler.sectionListHandler();
    }

    @GET
    @Path("/profileList")
    @ApiOperation(value = "Get all the Profiles at the substation", notes = "This method returns list of Profiles", response = ProfileResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Response with actual data"),

            @ApiResponse(code = 400, message = "Bad request"),

            @ApiResponse(code = 404, message = "Not Found") })
    @Override
    @Produces(MediaType.APPLICATION_JSON)
    public Response cardCallProfileListGet() throws NotFoundException {
        return cardCallHandler.cardCallProfileListHandler();
    }

    @GET
    @Path("/List")
    // CardCallListResponse
    @ApiOperation(value = "Get all the Card Call", notes = "This method returns list of Card Call List", response = CardCallListResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Response with actual data"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 404, message = "Not Found") })
    @Override
    @Produces(MediaType.APPLICATION_JSON)
    public Response cardCallListGet() throws NotFoundException {
        return cardCallHandler.cardCallListHandler();
    }
}




