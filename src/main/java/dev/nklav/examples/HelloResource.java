/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.nklav.examples;

import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.Query;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author koduki
 */
@Path("/hello")
public class HelloResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("say")
    public String say() {
        var datastore = DatastoreOptions.getDefaultInstance().getService();
        var key = datastore.newKeyFactory().setKind("Sandbox").newKey();
        var task = Entity.newBuilder(key).set("title", "test - " + new Date()).build();
        var entity = datastore.put(task);

        return String.format("Project: %s, key: %d", datastore.getOptions().getProjectId(), entity.getKey().getId());
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("listen")
    public String listen() {
        var datastore = DatastoreOptions.getDefaultInstance().getService();
        var gql = "SELECT * FROM Sandbox";
        var query = Query.newGqlQueryBuilder(Query.ResultType.ENTITY, gql).setAllowLiteral(true)
                .build();

        var result = new ArrayList<Map<String, Object>>();
        var rs = datastore.run(query);
        var title = "";
        var cnt = 0;
        while (rs.hasNext()) {
            var record = rs.next();
            cnt += 1;
            title = record.getString("title");
        }

        return String.format("title: %s, count: %d", title, cnt);
    }
}
