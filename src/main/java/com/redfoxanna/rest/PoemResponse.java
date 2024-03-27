package com.redfoxanna.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.redfoxanna.entity.Poem;
import com.redfoxanna.entity.User;
import com.redfoxanna.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/poems")
public class PoemResponse {
    private final Logger logger = LogManager.getLogger(this.getClass());

    // The Java method will process HTTP GET requests
    @GET
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces("text/json")
    public Response getMessage() {
        ObjectMapper objectMapper = new ObjectMapper();
        GenericDao<Poem> poemDao = new GenericDao<>(Poem.class);
        List<Poem> poems = poemDao.getAll();
        String output = "There was an error";

        try {
            output = objectMapper.writeValueAsString(poems);
            return Response.status(200).entity(output).build();
        } catch (JsonProcessingException jsonProcessingException) {
            logger.error("Error creating the file", jsonProcessingException);
        }

        return Response.status(500).entity(output).build();
    }
}