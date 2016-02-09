package ru.ccamgmt.stubs;

import ru.ccamgmt.contracts.*;

import io.swagger.annotations.*;

import ru.ccamgmt.contracts.MedicsResponse;
import ru.ccamgmt.contracts.AddMedicUserRequest;
import ru.ccamgmt.contracts.ErrorResponse;

import java.util.List;
import ru.ccamgmt.stubs.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.ws.rs.core.Response;
import javax.ws.rs.*;

@Path("/user")
@Api(value = "/user", description = "the user API")
public interface UserApi {
  
  @POST
  @Path("/addMedicUser")
  
  
  // MedicsResponse
  @ApiOperation(value = "add or update MedicUser", notes = "", response = MedicsResponse.class)
  @ApiResponses(value = { 
    @ApiResponse(code = 200, message = "Response with actual data"),
    
    @ApiResponse(code = 400, message = "Bad request"),
    
    @ApiResponse(code = 404, message = "Not Found") })

  public Response userAddMedicUserPost(@ApiParam(value = "" ,required=true ) AddMedicUserRequest body)
      throws NotFoundException;

  
  @GET
  @Path("/medicList")
  
  
  // MedicsResponse
  @ApiOperation(value = "Get all the medics at the substation", notes = "This method returns list of Medics", response = MedicsResponse.class)
  @ApiResponses(value = { 
    @ApiResponse(code = 200, message = "Response with actual data"),
    
    @ApiResponse(code = 400, message = "Bad request"),
    
    @ApiResponse(code = 404, message = "Not Found") })

  public Response userMedicListGet()
      throws NotFoundException;

  
}
