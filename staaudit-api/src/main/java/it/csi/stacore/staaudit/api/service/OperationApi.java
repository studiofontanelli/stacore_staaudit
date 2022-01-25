/**********************************************
 * CSI PIEMONTE 
 **********************************************/
package it.csi.stacore.staaudit.api.service;

import it.csi.stacore.staaudit.api.dto.*;

import io.swagger.annotations.ApiParam;
import io.swagger.jaxrs.*;

import it.csi.stacore.staaudit.api.dto.ErrorDto;
import it.csi.stacore.staaudit.api.dto.Operazione;

import java.util.List;
import java.util.Map;

import java.io.InputStream;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.HttpHeaders;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;
import javax.validation.constraints.*;

@Path("/operation")


@io.swagger.annotations.Api(description = "the operation API")

public interface OperationApi  {
   
    @POST
    @Path("/save")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @io.swagger.annotations.ApiOperation(value = "Save operation", notes = "Effettua il tracciamento dell'operazione effettuata", response = Void.class, tags={ "operation", })
    @io.swagger.annotations.ApiResponses(value = { 
        @io.swagger.annotations.ApiResponse(code = 201, message = "OK", response = Void.class),
        
        @io.swagger.annotations.ApiResponse(code = 422, message = "Errori di validazione", response = ErrorDto.class),
        
        @io.swagger.annotations.ApiResponse(code = 500, message = "Internal server error", response = ErrorDto.class) })
    public Response saveOperation(@ApiParam(value = "" ,required=true) Operazione request,@Context SecurityContext securityContext, @Context HttpHeaders httpHeaders );
}
