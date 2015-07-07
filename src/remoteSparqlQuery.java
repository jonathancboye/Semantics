import com.hp.hpl.jena.sparql.engine.http.*;
import com.hp.hpl.jena.query.*;
import com.hp.hpl.jena.rdf.model.*;

public class remoteSparqlQuery {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String sparqlService = "http://semantic.ckan.net/sparql";
		Query query = QueryFactory.create(
				  "PREFIX rdf:<http://www.w3.org/1999/02/22-rdf-syntax-ns#> " 
				 +"PREFIX xsd:<http://www.w3.org/2001/XMLSchema#> " 
				 +"PREFIX dcterms:<http://purl.org/dc/terms/> " 
				 +"PREFIX rdfs:<http://www.w3.org/2000/01/rdf-schema#> " 
				 +"PREFIX owl:<http://www.w3.org/2002/07/owl#> " 
				 +"PREFIX ends:<http://labs.mondeca.com/vocab/endpointStatus#> " 
				 +"PREFIX void:<http://rdfs.org/ns/void#> " 
				 
				 +"SELECT DISTINCT ?dataset ?endpoint ?name " 
				 +"WHERE { " 
				 +"?dataset void:sparqlEndpoint ?endpoint. " 
				 +"?dataset dcterms:title ?name }"
				);
		QueryEngineHTTP queryEngine = new QueryEngineHTTP(sparqlService, query);
		ResultSet results = queryEngine.execSelect();
		while(results.hasNext()) {
			QuerySolution soln = results.next();
			RDFNode s = soln.get("dataset");
			RDFNode p = soln.get("endpoint");
			RDFNode o = soln.get("name");
			System.out.println(s.toString() + " " +p.toString() + " " + o.toString());
		}
		queryEngine.close();
	}
}


