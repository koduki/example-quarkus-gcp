/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dev.nklab.examples.gcp_graal;

import com.google.cloud.Service;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.storage.StorageOptions;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Sample Quarkus Application demonstrating Cloud Pub/Sub operations.
 */
@Path("/hello")
public class TestService {

    /**
     * Creates a Pub/Sub subscription.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        var datastore = DatastoreOptions.getDefaultInstance().getService();
        var storage = StorageOptions.newBuilder()
                .build()
                .getService();
        return "Hello RESTEasy: " + datastore.getOptions().getProjectId();
    }
}
