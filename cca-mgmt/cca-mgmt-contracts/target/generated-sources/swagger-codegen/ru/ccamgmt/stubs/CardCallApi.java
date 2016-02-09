package ru.ccamgmt.stubs;

import ru.ccamgmt.contracts.*;

import io.swagger.annotations.*;

import ru.ccamgmt.contracts.CardCallListResponse;
import ru.ccamgmt.contracts.ErrorResponse;
import ru.ccamgmt.contracts.AddCardCallRequest;
import ru.ccamgmt.contracts.MedicsResponse;
import ru.ccamgmt.contracts.DepartmentsResponse;
import ru.ccamgmt.contracts.FormSectionsResponse;
import ru.ccamgmt.contracts.ProfileResponse;

import java.util.List;
import ru.ccamgmt.stubs.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.ws.rs.core.Response;
import javax.ws.rs.*;

@Path("/cardCall")
@Api(value = "/cardCall", description = "the cardCall API")
public interface CardCallApi {
  
  @GET
  @Path("/List")
  
  
  // CardCallListResponse
  @ApiOperation(value = "Get all the Card Call", notes = "This method returns list of Card Call List", response = CardCallListResponse.class)
  @ApiResponses(value = { 
    @ApiResponse(code = 200, message = "Response with actual data"),
    
    @ApiResponse(code = 400, message = "Bad request"),
    
    @ApiResponse(code = 404, message = "Not Found") })

  public Response cardCallListGet()
      throws NotFoundException;

  
  @POST
  @Path("/addOrEdit")
  
  
  // MedicsResponse
  @ApiOperation(value = "add or update card call", notes = "", response = MedicsResponse.class)
  @ApiResponses(value = { 
    @ApiResponse(code = 200, message = "Response with actual data"),
    
    @ApiResponse(code = 400, message = "Bad request"),
    
    @ApiResponse(code = 404, message = "Not Found") })

  public Response cardCallAddOrEditPost(@ApiParam(value = "" ,required=true ) AddCardCallRequest body)
      throws NotFoundException;

  
  @GET
  @Path("/departmentList")
  
  
  // DepartmentsResponse
  @ApiOperation(value = "Get all the departments at the substation", notes = "This method returns list of Departments", response = DepartmentsResponse.class)
  @ApiResponses(value = { 
    @ApiResponse(code = 200, message = "Response with actual data"),
    
    @ApiResponse(code = 400, message = "Bad request"),
    
    @ApiResponse(code = 404, message = "Not Found") })

  public Response cardCallDepartmentListGet()
      throws NotFoundException;

  
  @GET
  @Path("/formSections")
  
  
  // FormSectionsResponse
  @ApiOperation(value = "Get sections and questions", notes = "This method returns a list of questions and answers", response = FormSectionsResponse.class)
  @ApiResponses(value = { 
    @ApiResponse(code = 200, message = "Response with actual data"),
    
    @ApiResponse(code = 400, message = "Bad request"),
    
    @ApiResponse(code = 404, message = "Not Found") })

  public Response cardCallFormSectionsGet()
      throws NotFoundException;

  
  @GET
  @Path("/profileList")
  
  
  // ProfileResponse
  @ApiOperation(value = "Get all the Profiles at the substation", notes = "This method returns list of Profiles", response = ProfileResponse.class)
  @ApiResponses(value = { 
    @ApiResponse(code = 200, message = "Response with actual data"),
    
    @ApiResponse(code = 400, message = "Bad request"),
    
    @ApiResponse(code = 404, message = "Not Found") })

  public Response cardCallProfileListGet()
      throws NotFoundException;

  
}
