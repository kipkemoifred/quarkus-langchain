package ke.co.tracom;

import io.smallrye.common.annotation.Blocking;
import io.smallrye.graphql.client.GraphQLClient;
import io.smallrye.graphql.client.Response;
import io.smallrye.graphql.client.core.Document;
import io.smallrye.graphql.client.dynamic.api.DynamicGraphQLClient;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import ke.co.tracom.model.Film;
import ke.co.tracom.model.FilmConnection;

import java.util.List;

import static io.smallrye.graphql.client.core.Document.document;
import static io.smallrye.graphql.client.core.Field.field;
import static io.smallrye.graphql.client.core.Operation.operation;

@Path("/")
public class StarWarsResource {
    @Inject
    StarWarsClientApi typesafeClient;

    @GET
    @Path("/typesafe")
    @Produces(MediaType.APPLICATION_JSON)
    @Blocking
    public List<Film> getAllFilmsUsingTypesafeClient() {
        return typesafeClient.allFilms().getFilms();
    }

    @Inject
    @GraphQLClient("star-wars-dynamic")
    DynamicGraphQLClient dynamicClient;

    @GET
    @Path("/dynamic")
    @Produces(MediaType.APPLICATION_JSON)
    @Blocking
    public List<Film> getAllFilmsUsingDynamicClient() throws Exception {
        Document query = document(
                operation(
                        field("allFilms",
                                field("films",
                                        field("title"),
                                        field("planetConnection",
                                                field("planets",
                                                        field("name")
                                                )
                                        )
                                )
                        )
                )
        );
        Response response = dynamicClient.executeSync(query);
        return response.getObject(FilmConnection.class, "allFilms").getFilms();
    }
}