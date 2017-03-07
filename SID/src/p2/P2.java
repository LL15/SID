package p2;

import java.util.ArrayList;

import org.apache.jena.query.*;
import org.apache.jena.query.Query;

import twitter4j.*;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;
import twitter4j.conf.ConfigurationBuilder;

public class P2 {

	public static void main(String[] args){
		ArrayList<String> tendenciasTwitter = new ArrayList<String>();
		try{
			/*ConfigurationBuilder cb = new ConfigurationBuilder();
			cb.setDebugEnabled(true)
			  .setOAuthConsumerKey("w7T5rLBuhMmLYX3GqqrbLakdM")
			  .setOAuthConsumerSecret("1KEwkRaKClE93oAI1V9V4wbEjK66bzz00IE3a3TJWXRiXeHlpT")
			  .setOAuthAccessToken("3003195647-KrGj5kH9CIcxelynPGruJpGExLIcNjJ5EHUH5de")
			  .setOAuthAccessTokenSecret("m3RFQbJ2Va4cp4uENK9uLYwIYVv7fxYtYAhLrTcu4ZmRI");*/
			//TwitterFactory tf = new TwitterFactory(cb.build());
			TwitterFactory tf = new TwitterFactory();
			Twitter twitter = tf.getInstance();
			
			//23424950 es el codigo de españa
			Trends trends = twitter.getPlaceTrends(23424950);
			//for (int i = 0; i < trends.getTrends().length; i++) {
			for (int i = 0; i <= 10; i++) {
				tendenciasTwitter.add(trends.getTrends()[i].getName());
			    //System.out.println(trends.getTrends()[i].getName());
			}
			System.out.println(tendenciasTwitter);
			System.out.println("---------------------HECHO!---------------------");
			
//			ResponseList<Location> locations;
//			locations = twitter.getAvailableTrends();
//			System.out.println("Showing available trends");
//            for (Location location : locations) {
//                System.out.println(location.getName() + " (woeid:" + location.getWoeid() + ")");
//            }
//			System.out.println("done.");
		} catch(TwitterException te){
			te.printStackTrace();
            System.out.println("Failed to get trends: " + te.getMessage());
            System.exit(-1);
		}
		
		//String tendencias[] = {"Neymar", "Lionel", "Michel"};
		for (String tendencia : tendenciasTwitter){
			System.out.println(tendencia);
			String sparqlEndpoint = "http://dbpedia.org/sparql";

			String sparqlQuery = "PREFIX dbp: <http://dbpedia.org/property/> PREFIX dbo: <http://dbpedia.org/ontology/> "
					+ "PREFIX dbr: <http://dbpedia.org/resource/>"
					+ "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"
					+ "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>"
					+ "SELECT DISTINCT ?uri ?club WHERE {"
					+ "   ?uri rdf:type dbo:SoccerPlayer ."
					+ "   ?uri dbp:name '"+tendencia+"'@en ."
					+ "   ?uri dbp:currentclub ?club .}";
			Query query = QueryFactory.create(sparqlQuery);
			QueryExecution exec = QueryExecutionFactory.sparqlService(
				sparqlEndpoint, query );
			try {
				ResultSet results = exec.execSelect();
				while ( results.hasNext() )
					System.out.println(results.nextSolution());
			} finally {
				exec.close();
			}
		}
	 }
}
