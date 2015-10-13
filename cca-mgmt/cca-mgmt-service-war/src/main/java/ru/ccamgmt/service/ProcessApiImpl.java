package ru.ccamgmt.service;

import io.swagger.annotations.Api;

import javax.ejb.Stateless;
import javax.ws.rs.Path;

/**
 * Created by Владимир on 13.10.2015.
 */
@Api(value = "/ccamgmt", description = "the ccamgmt API")
@Path("/ccamgmt")
@Stateless
public class ProcessApiImpl {

}
