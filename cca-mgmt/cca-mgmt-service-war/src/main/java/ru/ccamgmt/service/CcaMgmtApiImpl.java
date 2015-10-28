package ru.ccamgmt.service;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import ru.ccamgmt.contracts.MedicsResponse;
import ru.ccamgmt.service.handler.CcaMgmtHandler;
import ru.ccamgmt.stubs.MedicListApi;
import ru.ccamgmt.stubs.NotFoundException;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by Yuriy Stolyarenko on 28.10.2015.
 */
@Path("/medicList")
@Api(value = "/medicList", description = "the medicList API")
@Stateless
public class CcaMgmtApiImpl implements MedicListApi {

    @EJB
    CcaMgmtHandler ccaMgmtHandler;

    @GET
    @ApiOperation(value = "Get all the medics at the substation", notes = "This method returns list of Medics", response = MedicsResponse.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Response with actual data"),

            @ApiResponse(code = 400, message = "Bad request"),

            @ApiResponse(code = 404, message = "Not Found") })
    @Override
    @Produces(MediaType.APPLICATION_JSON)
    public Response medicListGet() throws NotFoundException {
        return ccaMgmtHandler.medicHandle();
    }
}
