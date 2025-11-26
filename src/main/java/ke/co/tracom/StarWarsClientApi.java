package ke.co.tracom;

import io.smallrye.graphql.client.typesafe.api.GraphQLClientApi;
import ke.co.tracom.model.FilmConnection;

@GraphQLClientApi(configKey = "star-wars-typesafe")
public interface StarWarsClientApi {

    FilmConnection allFilms();

}
