package p2;

import java.util.*;
import org.apache.jena.*;
import org.apache.jena.query.Query;
import org.apache.jena.query.QueryExecution;
import org.apache.jena.query.QueryExecutionFactory;
import org.apache.jena.query.QueryFactory;
import org.apache.jena.query.ResultSet;

public class P2 {

	public static void main(String[] args){
		String tendencias[] = {"Neymar", "Lionel Messi", "Ilegales"};
		for (String tendencia : tendencias){
			String sparqlEndpoint = "http://dbpedia.org/sparql";

			String sparqlQuery = "PREFIX dbp: <http://dbpedia.org/property/> PREFIX dbo: <http://dbpedia.org/ontology/> "
					+ "PREFIX dbr: <http://dbpedia.org/resource/>"
					+ "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"
					+ "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>"
					+ "SELECT DISTINCT ?uri WHERE {"
					+ "   ?uri rdf:type dbo:Person ."
					+ "   ?uri dbp:name '"+tendencia+"'@en .}";
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
